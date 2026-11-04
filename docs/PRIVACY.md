# Privacy policy

Last reviewed: November 4, 2026 (ads removed).

> This text describes what **this recompiled copy** of the launcher does with your data, based on the code it contains.
> It is not legal advice. If it is ever distributed to third parties, have it reviewed by a professional and adapted to the
> rules that apply (for example GDPR, CCPA, or the policies of the store where it is published).

## 1. What this is and who is responsible for the data

This is a personal copy of an iOS-style Android launcher (the original is called *iOS Launcher* and is by LuuTinh
Developer). I recompiled it from its decompiled code. **This project has no servers of its own**: there is no account, no user
registry and no dashboard where your data could end up. Whoever installs and uses the app is responsible for what happens on
their own phone.

## 2. What data the app uses and why

Everything below is processed **on your phone**. The uses are inferred from the code and the declared permissions.

| Android permission | What it is used for | Leaves the phone |
|---|---|---|
| Contacts (`READ_CONTACTS`) | Show your favorite contacts in widgets | No |
| Calls (`CALL_PHONE`) | Call a favorite contact from a widget | No (done by the phone app) |
| Calendar (`READ_CALENDAR`) | Show events in the calendar widget | No |
| Location (`ACCESS_FINE_LOCATION`, `ACCESS_COARSE_LOCATION`) | Know where you are for the weather | **Yes**, to the weather API (see 3) |
| Storage and wallpaper (`READ_EXTERNAL_STORAGE`, `WRITE_EXTERNAL_STORAGE`, `SET_WALLPAPER`, `SET_WALLPAPER_HINTS`, `READ_WALLPAPER_INTERNAL`) | Pick a photo and set it as wallpaper, and read the current wallpaper | No |
| App list (`QUERY_ALL_PACKAGES`) | Show your apps on the home screen, the library and in search | No |
| Uninstall (`REQUEST_DELETE_PACKAGES`) | Ask the system to uninstall an app you choose | No |
| Bluetooth (`BLUETOOTH`) | Show the battery of connected devices in the battery widget | No |
| Network (`INTERNET`, `ACCESS_NETWORK_STATE`) | Fetch the weather | See 3 |
| Background services (`FOREGROUND_SERVICE`, `RECEIVE_BOOT_COMPLETED`, `WAKE_LOCK`, `BROADCAST_STICKY`) | Update the weather and restore state after a reboot | No |
| Widgets (`BIND_APPWIDGET`) | Host widgets on the home screen | No |
| Vibration (`VIBRATE`) | Haptic feedback | No |

What the app stores on the phone: the layout of your home screen, an icon cache, your settings and the latest weather data. It
is deleted when you uninstall the app or clear its data from Android settings.

## 3. What leaves the phone

1. **Weather.** When the weather updates, the app queries *Visual Crossing* (`weather.visualcrossing.com`) with the location
   or city you chose. That company receives the query and your IP address, and is governed by its own policy.
2. **Ads.** This copy no longer shows or requests ads: the calls from the settings screen and the weather screen, the
   advertising permissions (`AD_ID`, `ACCESS_ADSERVICES_*`) and the AdMob identifiers were removed. The files of the Google
   Mobile Ads SDK are still inside the original library package, but the code neither uses nor initializes them.
3. **Nothing else on purpose.** I found no accounts, no analytics of its own and no statistics services such as Firebase in the
   app. But the app includes third-party libraries that I did not review line by line, so I cannot guarantee there are no
   other connections.

The project does not sell data, does not build profiles and does not share anything with anyone else.

## 4. What you can control

- **Permissions:** grant or revoke them in *Android Settings → Apps → iOS Launcher → Permissions*. The app keeps working
  without them, but the widgets that depend on each permission stop working.
- **Local data:** *Android Settings → Apps → iOS Launcher → Storage → Clear data*, or uninstall the app.
- **Weather:** do not enable location for the weather, or pick a city by hand if the app allows it.

## 5. Minors

The app is not aimed at minors and does not ask them for data.

## 6. Changes

If what the app does with your data changes, this document and its review date are updated. The history stays in the
repository.

## 7. Contact

For questions about this document or this copy, open an *issue* in the project repository.
For the original launcher, the contact is its developer, LuuTinh Developer.
