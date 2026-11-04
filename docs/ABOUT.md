# About

## What this is

A **recompilable** copy of an iOS-style Android launcher, made for personal use. It starts from the APK of the
*iOS Launcher* app (`com.luutinhit.launcherios`, version 8.9.2, version code 892), decompiled and fixed until it compiles.
How it is put together and how it is built is explained in the [README](../README.md).

## What the launcher does

- Home screen with pages, a dock and folders.
- *Today* view with widgets (weather, battery, calendar, photos, favorite contacts).
- App Library with categories and a search box.
- App search and web search.
- Hidden apps, and per-app icon and name changes.
- Wallpapers, plus blur and liquid-glass effects.

The usage guide is in [HOW-TO-USE.md](HOW-TO-USE.md) and what it does with your data is in [PRIVACY.md](PRIVACY.md).

## What changes in this copy

Spanish language, iOS 27 icons in light and dark versions that follow the system theme, no rating prompt and no Play Store
links, no header image and no side menu in the settings, and no ads. The full list and the reasons are in
[`app-source/docs/RECOMPILE-NOTES.md`](../app-source/docs/RECOMPILE-NOTES.md).

## Technical details

- Android 5.0 (API 21) or higher; compiled for API 36.
- `arm64-v8a` architecture only.
- Debug signature: it cannot be used to publish to a store.

## Credits and limits

- The original launcher and its code belong to **LuuTinh Developer**. This copy has no relationship with its author.
- "iOS", "iPhone" and the names and designs of Apple's apps are trademarks of Apple Inc.; this project is not affiliated with Apple.
- Third-party app icons belong to their owners and are used only in this personal copy.
- The build tools (dex2jar, tiny-remapper, ASM, smali, jadx) are open-source projects with their own licenses.
- The repository is for personal use; before making it public, the rights to the decompiled code must be resolved.
