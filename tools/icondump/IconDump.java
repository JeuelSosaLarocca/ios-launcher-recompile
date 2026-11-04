import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.Drawable;
import android.os.Looper;

import java.io.FileOutputStream;

/**
 * Saves the current launcher icon of installed apps as full-bleed 256x256 PNGs (the format of the
 * iOS Launcher's drawable/*_icon.jpg files; the launcher applies its own rounded mask).
 * Adaptive icons: background + foreground, cropped to the visible 72dp of the 108dp layers.
 * Legacy icons: drawn on white. Adaptive icons also get &lt;package&gt;.fg.png, the foreground layer
 * alone, for building dark-mode variants.
 *
 * Run on the device: app_process -cp icondump.dex / IconDump <out_dir> <package>...
 */
public final class IconDump {
    public static void main(String[] args) throws Exception {
        Looper.prepareMainLooper();
        Class<?> at = Class.forName("android.app.ActivityThread");
        Object thread = at.getMethod("systemMain").invoke(null);
        Context ctx = (Context) at.getMethod("getSystemContext").invoke(thread);
        PackageManager pm = ctx.getPackageManager();
        int size = 256;
        for (int i = 1; i < args.length; i++) {
            String pkg = args[i];
            try {
                Drawable d = pm.getApplicationIcon(pkg);
                Bitmap b = Bitmap.createBitmap(size, size, Bitmap.Config.ARGB_8888);
                Canvas c = new Canvas(b);
                String kind;
                if (d instanceof AdaptiveIconDrawable a) {
                    int full = size * 108 / 72, off = (full - size) / 2;
                    if (a.getBackground() != null) {
                        a.getBackground().setBounds(-off, -off, size + off, size + off);
                        a.getBackground().draw(c);
                    }
                    if (a.getForeground() != null) {
                        a.getForeground().setBounds(-off, -off, size + off, size + off);
                        a.getForeground().draw(c);
                    }
                    kind = "adaptive";
                } else {
                    c.drawColor(Color.WHITE);
                    d.setBounds(0, 0, size, size);
                    d.draw(c);
                    kind = "legacy";
                }
                try (FileOutputStream os = new FileOutputStream(args[0] + "/" + pkg + ".png")) {
                    b.compress(Bitmap.CompressFormat.PNG, 100, os);
                }
                // the foreground alone (transparent elsewhere), used to build a dark-mode variant
                if (d instanceof AdaptiveIconDrawable a && a.getForeground() != null) {
                    int full = size * 108 / 72, off = (full - size) / 2;
                    Bitmap fg = Bitmap.createBitmap(size, size, Bitmap.Config.ARGB_8888);
                    a.getForeground().setBounds(-off, -off, size + off, size + off);
                    a.getForeground().draw(new Canvas(fg));
                    try (FileOutputStream os = new FileOutputStream(args[0] + "/" + pkg + ".fg.png")) {
                        fg.compress(Bitmap.CompressFormat.PNG, 100, os);
                    }
                }
                System.out.println(pkg + " " + kind);
            } catch (PackageManager.NameNotFoundException e) {
                System.out.println(pkg + " not installed");
            }
        }
        System.exit(0);
    }
}
