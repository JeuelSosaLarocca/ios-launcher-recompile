"""Build the light (drawable/) and dark (drawable-night/) versions of the launcher's per-app icons.

  * Apple apps: both versions come from Apple's iOS 27 UI kit (Figma, component "_System Icons",
    exported at 8x as "Icon=<App>, Mode=<Default|Dark>.png").
  * third-party apps installed on the phone: tools/icondump output (<pkg>.png and the adaptive
    foreground <pkg>.fg.png); the dark version is the foreground on a dark background, as iOS does
    for apps without a dark icon.
  * every other icon: the dark version is derived from the existing image (background estimated
    from the border, glyph kept).

Every replaced file is moved to the backup folder first. Output icons are opaque 256x256 squares
(the launcher applies its own rounded mask).

Usage: python -I build_theme_icons.py <figma_dir> <phone_dir> <res_dir> <backup_dir>
"""
import shutil
import sys
from pathlib import Path

from PIL import Image, ImageFilter

SIZE = 256

APPLE = {  # Figma kit name -> drawable
    "Phone": "new_call_icon", "Messages": "new_message_icon", "Camera": "new_camera_icon",
    "Photos": "new_photos_icon", "Safari": "new_safari_icon", "Contacts": "new_contact_icon",
    "Mail": "new_email_icon", "FaceTime": "new_face_time_icon", "Files": "new_file_icon",
    "Calculator": "new_calculator_icon", "Music": "new_music_icon", "News": "new_news_icon",
    "Notes": "new_notes_icon", "Voice Memos": "new_voice_memos_icon", "Settings": "new_settings_icon",
    "App Store": "new_store_icon", "Health": "health_icon", "Books": "ic_book", "Home": "ic_home",
    "Podcasts": "ic_podcasts", "Stocks": "ic_stocks", "TV": "ic_videos", "Games": "game_icon",
    "Calendar": "calendar_icon", "Clock": "clock_icon",
}
PHONE = {  # package -> drawable
    "com.android.chrome": "chrome_icon", "com.discord": "ic_discord", "com.facebook.katana": "facebook_icon",
    "com.google.android.apps.docs": "drive_icon", "com.google.android.apps.maps": "google_maps_icon",
    "com.google.android.apps.photos": "google_photos_icon", "com.google.android.gm": "gmail_icon",
    "com.google.android.googlequicksearchbox": "google_icon", "com.google.android.youtube": "youtube_icon",
    "com.instagram.android": "instagram_icon", "com.spotify.music": "spotify_icon",
    "com.twitter.android": "twitter_icon", "com.ubercab": "uber_icon", "com.whatsapp": "whatsapp_icon",
    "com.zhiliaoapp.musically": "ic_tik_tok", "org.telegram.messenger": "ic_telegram",
}
FLAT_ONLY = {"com.google.android.apps.maps"}
OTHER = ["compass_icon", "dropbox_icon", "flipboard_icon", "line_icon", "snapchat_icon", "viber_icon",
         "ic_deezer", "ic_messenger", "ic_mifit", "ic_netflix", "ic_pinterest", "ic_shazam", "ic_radio",
         "keep_icon", "translate_icon"]


def lum(c):
    return (0.299 * c[0] + 0.587 * c[1] + 0.114 * c[2]) / 255


def sat(c):
    return (max(c[:3]) - min(c[:3])) / 255


def dark_background(figma):
    """Vertical gradient sampled from the kit's dark Settings icon, so generated icons match Apple's."""
    im = Image.open(figma / "Icon=Settings, Mode=Dark.png").convert("RGB")
    w, h = im.size
    top, bottom = im.getpixel((w // 2, int(h * 0.06))), im.getpixel((w // 2, int(h * 0.94)))
    g = Image.new("RGB", (1, SIZE))
    for y in range(SIZE):
        t = y / (SIZE - 1)
        g.putpixel((0, y), tuple(round(a + (b - a) * t) for a, b in zip(top, bottom)))
    return g.resize((SIZE, SIZE)).convert("RGBA")


def opaque_square(im):
    """Kit icons are rounded with transparent corners; fill the corners with the icon's own edge."""
    im = im.convert("RGBA").resize((SIZE, SIZE), Image.LANCZOS)
    big = im.resize((int(SIZE * 1.4),) * 2, Image.LANCZOS)
    o = (big.width - SIZE) // 2
    base = big.crop((o, o, o + SIZE, o + SIZE)).filter(ImageFilter.GaussianBlur(6))
    solid = Image.new("RGBA", (SIZE, SIZE), base.getpixel((SIZE // 2, SIZE // 2)))
    solid.alpha_composite(base)
    solid.alpha_composite(im)
    return solid.convert("RGB")


def median_color(pixels):
    pixels = sorted(pixels, key=lum)
    return pixels[len(pixels) // 2][:3]


def compose_dark(glyph_rgba, bg_color, darkbg):
    """glyph on the dark background; a white glyph on a colored icon takes the icon's color."""
    a = glyph_rgba.getchannel("A")
    opaque = [p for p, al in zip(glyph_rgba.getdata(), a.getdata()) if al > 200]
    glyph_lum = sum(lum(p) for p in opaque) / max(1, len(opaque))
    out = darkbg.copy()
    if lum(bg_color) < 0.92 and sat(bg_color) > 0.25 and glyph_lum > 0.8:
        tinted = Image.new("RGBA", glyph_rgba.size, bg_color + (255,))
        tinted.putalpha(a)
        out.alpha_composite(tinted)
    else:
        out.alpha_composite(glyph_rgba)
    return out.convert("RGB")


def dark_from_layers(full, fg, darkbg):
    full, fg = full.convert("RGB").resize((SIZE, SIZE)), fg.convert("RGBA").resize((SIZE, SIZE))
    a = fg.getchannel("A")
    bg_pixels = [p for p, al in zip(full.getdata(), a.getdata()) if al < 10]
    if len(bg_pixels) < SIZE * SIZE * 0.1:  # the foreground covers everything: no separate glyph
        return dark_from_flat(full, darkbg)
    bg = median_color(bg_pixels)
    if lum(bg) < 0.25:
        return full
    return compose_dark(fg, bg, darkbg)


def dark_from_flat(im, darkbg):
    im = im.convert("RGB").resize((SIZE, SIZE))
    w = SIZE
    px = im.load()
    # sampled a few pixels in: some of the old JPGs have a thin light margin
    i, j = 6, w - 7
    border = [px[x, y] for x in range(w) for y in (i, i + 1, j - 1, j)] + \
             [px[x, y] for y in range(w) for x in (i, i + 1, j - 1, j)]
    bg = median_color(border)
    if lum(bg) < 0.25:
        return im
    # background estimate per pixel (handles linear gradients): average of the row and column interpolations
    left, right = [px[i, y] for y in range(w)], [px[j, y] for y in range(w)]
    top, bottom = [px[x, i] for x in range(w)], [px[x, j] for x in range(w)]
    alpha = Image.new("L", (w, w))
    ap = alpha.load()
    for y in range(w):
        for x in range(w):
            tx, ty = x / (w - 1), y / (w - 1)
            est = [((l + (r - l) * tx) + (t + (b - t) * ty)) / 2
                   for l, r, t, b in zip(left[y], right[y], top[x], bottom[x])]
            d = sum((c - e) ** 2 for c, e in zip(px[x, y], est)) ** 0.5 / 441
            ap[x, y] = int(max(0.0, min(1.0, (d - 0.10) / 0.15)) * 255)
    glyph = im.convert("RGBA")
    glyph.putalpha(alpha.filter(ImageFilter.GaussianBlur(0.6)))
    return compose_dark(glyph, bg, darkbg)


def install(img, path, backup):
    for old in path.parent.glob(path.stem + ".*"):
        if not (backup / (path.parent.name + "__" + old.name)).exists():
            shutil.copy2(old, backup / (path.parent.name + "__" + old.name))
        old.unlink()
    img.save(path, optimize=True)


def main(figma, phone, res, backup):
    figma, phone, res, backup = map(Path, (figma, phone, res, backup))
    light_dir, dark_dir = res / "drawable", res / "drawable-night"
    dark_dir.mkdir(exist_ok=True)
    backup.mkdir(exist_ok=True)
    darkbg = dark_background(figma)
    for app, name in APPLE.items():
        install(opaque_square(Image.open(figma / f"Icon={app}, Mode=Default.png")), light_dir / f"{name}.png", backup)
        install(opaque_square(Image.open(figma / f"Icon={app}, Mode=Dark.png")), dark_dir / f"{name}.png", backup)
    for pkg, name in PHONE.items():
        full = Image.open(phone / f"{pkg}.png").convert("RGB")
        install(full, light_dir / f"{name}.png", backup)
        fg = phone / f"{pkg}.fg.png"
        # Maps draws a white plate in its foreground layer, so its layers do not separate the glyph
        use_layers = fg.exists() and pkg not in FLAT_ONLY
        dark = dark_from_layers(full, Image.open(fg), darkbg) if use_layers else dark_from_flat(full, darkbg)
        install(dark, dark_dir / f"{name}.png", backup)
    for name in OTHER:
        src = next(light_dir.glob(name + ".*"))
        install(dark_from_flat(Image.open(src), darkbg), dark_dir / f"{name}.png", backup)
    print(f"apple: {len(APPLE)}, phone: {len(PHONE)}, derived: {len(OTHER)} (light + dark)")


if __name__ == "__main__":
    main(*sys.argv[1:5])
