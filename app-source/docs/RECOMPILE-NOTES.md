# Recompile notes

## What actually runs

The app dex in `app-debug-full.apk` is built by `DexMerge` (`tools/libjar`) from the **original**
app classes, read straight from the original `classes.dex`. Neither jadx nor dex2jar touches that
code, so the decompile bugs listed below no longer reach the device. The compiled sources contribute
only:

* methods that call `JadxSupport.useSource()`, which replace the original method with the same
  signature and keep its access flags;
* compiled code those methods reach that the original lacks (new classes, methods and fields).

**To change behavior:** edit the method in `app-source` and make
`com.luutinhit.launcher6.JadxSupport.useSource();` its first statement. Without the marker the edit
is compiled but never shipped. The build log of `assembleDebugFull` does not show DexMerge's output.
Run it by hand to see which compiled methods were taken and any warnings about private members:
`java -cp "app-source/tools-bin/*" DexMerge original-apk/base.apk app-source/app/libs/original-libs.dex app-source/app/build/outputs/apk/debug/app-debug.apk out.dex`

Methods marked `useSource` today:

* `LauncherProvider.loadDefaultFavoritesIfNecessary()`: skips the Play Auto Installs layout.
* `IOSLauncher.startRatingActivity()`: now empty, so the "rate 5 stars" dialog never opens by itself. The Rate buttons in the settings still open it.
* `LauncherAppState.getInstance()`: also registers `ThemeIconReloader`, which reloads the icons when the system theme changes (icons have light and dark versions). On a reload it empties both the icon cache and `IconCache.f16346e`: that map gives each iOS icon to **one** app only (`m8023y`), so if it is kept, apps that already own an icon (Messages, Camera, Settings) fall back to their own icon after the switch.

Play Store links removed (`tools/scripts/remove_play_store_links.py`, resources and manifest only, no code change). Views are
hidden with `visibility="gone"` rather than deleted, because the original bytecode calls `findViewById(...).setOnClickListener(...)` on them:

* Settings: the card "Rating 5 star / Download other apps" and the card with the developer's other apps (Lock Screen, Control Center,
  AssistiveTouch), which open Play Store pages when those apps are not installed.
* Main screen of the app: share (it shares a Play Store link), like, and the floating star button.
* Search: the "Search Store" row (opens a Play Store search) and the divider above it. Not tried on the phone.
* Manifest: `RatingActivity` disabled (`android:enabled="false"`); the `com.android.vending.*` and `com.android.stamp.*` meta-data are removed.

Settings screen header removed (`tools/scripts/hide_settings_header.py`, `activity_main.xml` only): the "LAUNCHER IOS" banner (`header_layout`) is
made **invisible, 1dp high and without its image**, the mail button (`action_email`) is gone; the menu button is tinted `colorAccent` so it shows on
the plain background, and the list gets `layout_marginTop="64dp"` so it starts below it. Checked on the phone (dark theme only).

The banner must not be `gone`: the list's overscroll bounce (`D/C0157a`, case 11) scales it with `overscroll / header.getMeasuredHeight() + 1`. With a
gone header that is a division by zero, `View.setScaleX(Infinity)` throws `IllegalArgumentException` and the launcher process crashed while
scrolling the settings list. After the fix, four rounds of swipes with overscroll at both ends gave no crash.

Sliding menu removed (`tools/scripts/remove_drawer_menu.py`, layouts + one new drawable + two additions in code). Its five entries went like this:
privacy policy, how to use and about were web pages / a YouTube video of the original developer; they are rewritten in `docs/` of the repository
and no longer open from the app; "Website" is dropped; "Reload launcher" is now the last row of the settings list.

* `LockedDrawerLayout` (new, `launcher6/`): the root of `activity_main.xml` is this subclass of `DrawerLayout`, locked closed in its constructor.
  `MainActivity` still does `(DrawerLayout) findViewById(R.id.drawer_layout)`, so the view has to stay; the hamburger button and the `NavigationView` are `gone`
  and the `NavigationView` has no header and no menu any more. Because only the layout names this class, it is listed in
  `app/compiled-extra-classes.txt`, a new optional argument of `DexMerge` (it ships a new class only when a marked method reaches it).
* `MainActivity.reloadLauncher(View)` (new method, `useSource`): the confirmation dialog and the same broadcast the old menu entry sent
  (`ACTION_FORCE_RELOAD_LAUNCHER`, then `finish()`); a row of `settings_view.xml` calls it with `android:onClick`. DexMerge adds it to the original class.
* Checked on the phone: the list starts near the top, the new row opens the dialog, CANCELAR goes back to the list and ACEPTAR closes the screen without a
  crash. Not checked: an edge swipe cannot be tested with `adb` (the left edge is the system back gesture); the lock rests on the constructor call.

Not touched: the Play Store app's own shortcut on the home screen (and its App Store icon), and the `market://` fallback in
`res/xml/default_workspace_*x4.xml`.

Known limit: the live Clock and Calendar icons are drawn in code (`B3/C0069l`, `B3/C0068k`, tinted by `CustomIconView.setTint`), not from `drawable/`, so they keep a white face in both themes.

D8 sometimes moves the body of a marked method into a synthetic `$invoke$special$<name>` and leaves
`<name>` as a forwarder. DexMerge detects this and replaces the original `<name>` with the forwarder
(a marked method whose edit seems to be ignored is the sign to look for). This is what made the
rating dialog come back after `startRatingActivity()` was emptied: the original body was kept.

Taking method bodies from the dex2jar output instead (the old `useOriginalBytecode` path in
PostCompile) does not work for everything. dex2jar turns `new X` into `new <ancestor>` whenever R8
removed X's pass-through constructor, so many constructors fail verification (for example `W1.<init>`).

## Source changes

Each fix to the decompiled source below matters only once its method is marked `useSource`.

Places where the decompiled source had to be changed in a way that may not match the original
behavior. Check these first if something misbehaves at runtime.

| File | What | Risk |
|---|---|---|
| `launcher6/LauncherProvider.java` `migrateLauncher2Shortcuts()` | jadx rethrew an exception (`th`) that is not in scope; replaced by a `RuntimeException`. | Only runs when migrating shortcuts from an old AOSP Launcher2 database. |
| `launcher6/LoaderTask.java` `loadWorkspace()` | jadx could not decompile it ("Method dump skipped"); the body is empty. | **High**: the home screen will not load items until this is rewritten (AOSP `LauncherModel.LoaderTask.loadWorkspace` is the reference). |
| `launcher6/appslibrary/AppsLibraryItemDecoration.java` | Sticky-header loops had lost their `break`s (infinite loops); restored, and `childAt == null && ...getChildAdapterPosition(childAt)` (always NPE) changed to `!= null`. | Header position in the Apps Library list. |
| `res/` (85 references) | jadx left raw IDs / `?unknown_ref` for drawables that only exist in `split_config.xxhdpi.apk`; the split's drawables were imported (`tools/scripts/import_density_split.py`, 43 compiled 9-patches rebuilt) and the references resolved. | 9-patch borders are rebuilt from the `npTc` chunk; check stretching of those backgrounds. |
| `res/drawable` icons (IconCache's per-app icons) | **Intentional change:** the icons were updated. Apple apps (22 icons) use the iOS 27 artwork from Apple's App Store listings (mzstatic CDN, 1024 px scaled to 256). Third-party apps (16 icons) use the current icons of the apps installed on the phone, dumped with `tools/icondump`. Not changed: Settings and App Store (not on the App Store), Calendar and Clock (drawn live), Radio, and third-party apps that are not installed. The originals are in `original-icons-backup/`. | The `new_*_icon` vectors are now PNGs with the same names. |
| strings | Base strings are decoded from base.apk. The Spanish ones (`values-es`, `values-es-rUS`, `values-b+es+419`) come from `split_config.es.apk`, decoded with `jadx --no-src`; all 482 names match the base IDs. Other languages were not in the downloaded splits. | Only English and Spanish are available. |
| `launcher6/MergedIdleRunnable.java` (wallpaper size) | Restored the early return of AOSP `WallpaperUtils.suggestWallpaperDimension`; without it `suggestDesiredDimensions(-1, -1)` crashed. | Wallpaper sizing. |
| `launcher6/BlurScreenLayout.java` constructor | Rewrote the find-the-Launcher loop: jadx duplicated code into it and dropped a `break`, which hung the UI thread at startup. | Blur layout init. |
| `launcher6/LauncherProvider.java` `loadDefaultFavoritesIfNecessary()` | **Intentional change**: the Play Auto Installs layout is skipped (`SKIP_PLAY_AUTO_INSTALL_LAYOUT`). Samsung's PAI layout has items without screen/x/y, so the original code produced an empty home screen. | First-run layout comes from the app's `default_workspace_*_samsung.xml`. |
| `launcher6/LoaderTask.java` `m8263c` (checkItemPlacement) | Restored the final `return true` jadx dropped; without it the loader spun forever holding the model lock (black screen). | Workspace loading. |
| `launcher6/LoaderTask.java` `run()` | jadx held `synchronized (mLock)` around the whole method (deadlock with the UI thread). The source is now a stub and PostCompile uses the original bytecode. | Same as original. |
| endless `while (true)` loops | `tools/scripts/find_infinite_loops.py` finds loops with no exit (jadx dropped an `else break`); their methods use the original bytecode, and the one in the `MergedItemCallbacks` constructor was fixed by hand. | Re-run the script after regenerating sources. |
