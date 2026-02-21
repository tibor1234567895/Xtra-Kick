package f0;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;

public final class f {
    private f() {
    }

    public static Uri a(Object obj) {
        if (Build.VERSION.SDK_INT >= 28) {
            return i.d(obj);
        }
        try {
            return (Uri) obj.getClass().getMethod("getUri", new Class[0]).invoke(obj, new Object[0]);
        } catch (IllegalAccessException e10) {
            Log.e("IconCompat", "Unable to get icon uri", e10);
            return null;
        } catch (InvocationTargetException e11) {
            Log.e("IconCompat", "Unable to get icon uri", e11);
            return null;
        } catch (NoSuchMethodException e12) {
            Log.e("IconCompat", "Unable to get icon uri", e12);
            return null;
        }
    }

    public static Drawable b(Icon icon, Context context) {
        return icon.loadDrawable(context);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0070, code lost:
        r4 = f0.h.b(r4);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.drawable.Icon c(androidx.core.graphics.drawable.IconCompat r3, android.content.Context r4) {
        /*
            int r0 = r3.f1211a
            r1 = 26
            switch(r0) {
                case -1: goto L_0x00bc;
                case 0: goto L_0x0007;
                case 1: goto L_0x00a3;
                case 2: goto L_0x0098;
                case 3: goto L_0x008b;
                case 4: goto L_0x0082;
                case 5: goto L_0x0068;
                case 6: goto L_0x000f;
                default: goto L_0x0007;
            }
        L_0x0007:
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException
            java.lang.String r4 = "Unknown type"
            r3.<init>(r4)
            throw r3
        L_0x000f:
            int r0 = android.os.Build.VERSION.SDK_INT
            r2 = 30
            if (r0 < r2) goto L_0x001f
            android.net.Uri r4 = r3.i()
            android.graphics.drawable.Icon r4 = f0.j.a(r4)
            goto L_0x00ab
        L_0x001f:
            if (r4 == 0) goto L_0x0050
            java.io.InputStream r4 = r3.j(r4)
            if (r4 == 0) goto L_0x0038
            android.graphics.Bitmap r4 = android.graphics.BitmapFactory.decodeStream(r4)
            if (r0 < r1) goto L_0x002e
            goto L_0x0070
        L_0x002e:
            android.graphics.Bitmap r4 = androidx.core.graphics.drawable.IconCompat.a(r4)
            android.graphics.drawable.Icon r4 = android.graphics.drawable.Icon.createWithBitmap(r4)
            goto L_0x00ab
        L_0x0038:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Cannot load adaptive icon from uri: "
            r0.<init>(r1)
            android.net.Uri r3 = r3.i()
            r0.append(r3)
            java.lang.String r3 = r0.toString()
            r4.<init>(r3)
            throw r4
        L_0x0050:
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Context is required to resolve the file uri of the icon: "
            r0.<init>(r1)
            android.net.Uri r3 = r3.i()
            r0.append(r3)
            java.lang.String r3 = r0.toString()
            r4.<init>(r3)
            throw r4
        L_0x0068:
            int r4 = android.os.Build.VERSION.SDK_INT
            if (r4 < r1) goto L_0x0075
            java.lang.Object r4 = r3.f1212b
            android.graphics.Bitmap r4 = (android.graphics.Bitmap) r4
        L_0x0070:
            android.graphics.drawable.Icon r4 = f0.h.b(r4)
            goto L_0x00ab
        L_0x0075:
            java.lang.Object r4 = r3.f1212b
            android.graphics.Bitmap r4 = (android.graphics.Bitmap) r4
            android.graphics.Bitmap r4 = androidx.core.graphics.drawable.IconCompat.a(r4)
            android.graphics.drawable.Icon r4 = android.graphics.drawable.Icon.createWithBitmap(r4)
            goto L_0x00ab
        L_0x0082:
            java.lang.Object r4 = r3.f1212b
            java.lang.String r4 = (java.lang.String) r4
            android.graphics.drawable.Icon r4 = android.graphics.drawable.Icon.createWithContentUri(r4)
            goto L_0x00ab
        L_0x008b:
            java.lang.Object r4 = r3.f1212b
            byte[] r4 = (byte[]) r4
            int r0 = r3.f1215e
            int r1 = r3.f1216f
            android.graphics.drawable.Icon r4 = android.graphics.drawable.Icon.createWithData(r4, r0, r1)
            goto L_0x00ab
        L_0x0098:
            java.lang.String r4 = r3.h()
            int r0 = r3.f1215e
            android.graphics.drawable.Icon r4 = android.graphics.drawable.Icon.createWithResource(r4, r0)
            goto L_0x00ab
        L_0x00a3:
            java.lang.Object r4 = r3.f1212b
            android.graphics.Bitmap r4 = (android.graphics.Bitmap) r4
            android.graphics.drawable.Icon r4 = android.graphics.drawable.Icon.createWithBitmap(r4)
        L_0x00ab:
            android.content.res.ColorStateList r0 = r3.f1217g
            if (r0 == 0) goto L_0x00b2
            r4.setTintList(r0)
        L_0x00b2:
            android.graphics.PorterDuff$Mode r3 = r3.f1218h
            android.graphics.PorterDuff$Mode r0 = androidx.core.graphics.drawable.IconCompat.f1210k
            if (r3 == r0) goto L_0x00bb
            r4.setTintMode(r3)
        L_0x00bb:
            return r4
        L_0x00bc:
            java.lang.Object r3 = r3.f1212b
            android.graphics.drawable.Icon r3 = androidx.appcompat.widget.w1.j(r3)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: f0.f.c(androidx.core.graphics.drawable.IconCompat, android.content.Context):android.graphics.drawable.Icon");
    }
}
