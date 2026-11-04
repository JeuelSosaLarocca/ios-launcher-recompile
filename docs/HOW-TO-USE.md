# How to use the launcher

Quick guide to this copy. Example screenshots are in the [README](../README.md). The original shipped a help video on YouTube;
this guide replaces it.

## 1. Getting started

1. Install the app (steps in the [README](../README.md#install-and-use)).
2. Open it once from the **iOS Launcher** icon. That is the launcher's settings screen.
3. Make it the default launcher: on that screen, the **Make Default Launcher** row, or in Android
   *Settings → Apps → Default apps → Home app*.
4. Press the home button: you now see the iOS-style home screen.

Permissions are requested when a feature needs them; you can deny them and keep using the rest (see [PRIVACY.md](PRIVACY.md)).

## 2. The home screen

- **Pages and icons:** swipe left and right to change page. Long-press an icon to move it, send it to another page or remove
  it from the home screen (the app stays installed and appears in the library).
- **Folders:** drag one icon onto another to create a folder; tap it to open it.
- **Dock:** the four icons at the bottom are visible on every page.
- **Search:** the *Search* button above the dock opens app search and web search.

## 3. Today view (widgets)

From the first page, swipe right. The widgets live there: weather, battery, calendar, photo, favorite contacts and others.
The **Edit** button at the end of the page lets you add or remove widgets.

## 4. App Library

From the last page, swipe left. Apps are grouped by category (recent, games, audio, video, images, social, etc.) and there is a
search box at the top. It is the place where **all** your apps are, even if they are not on any page.

## 5. The launcher settings

Open the **iOS Launcher** icon to see the list. Each row opens its own screen:

| Row | What it lets you do |
|---|---|
| Layout | How icons and pages are arranged |
| Weather | Configure the weather widget and screen |
| Liquid glass | The glass effect of translucent elements |
| Blur effect | The background blur |
| Animations | Animations when opening and closing |
| Wallpapers | Choose and change the wallpaper |
| Change icon | Replace an app's icon |
| Rename | Change the displayed name of an app |
| App Library | Library options |
| Hidden apps | Hide apps from the home screen |
| Make Default Launcher | Choose this launcher as the home app |
| Reload launcher | Asks for confirmation and reloads the home screen |

The description of each row comes from its name and from what the code does; if an option behaves differently, what you see on
screen takes priority. The app's own labels are in Spanish, so a row may appear under its Spanish name.

## 6. Light and dark theme

The icons have light and dark versions and change on their own when Android switches from one theme to the other. The Clock and
Calendar icons are drawn live (real time and date) and keep their white face in both themes.

## 7. If something doesn't work

- **An icon looks wrong or out of date:** open *Settings → Reload launcher* and accept.
- **The home screen doesn't load:** stop the app from Android settings and open it again.
- **The app closes:** note what you were doing, check `adb logcat` if you can, and open an *issue* in the repository.
- **Samsung's launcher (or another one) shows up instead of this one:** your phone stopped using this launcher as the home app;
  repeat step 3 of *Getting started*.
