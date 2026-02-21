package k5;

import android.graphics.Bitmap;
import android.graphics.Paint;
import android.util.Log;
import b5.j;
import e5.c;
import java.security.MessageDigest;

public final class i extends e {

    /* renamed from: b  reason: collision with root package name */
    public static final byte[] f9162b = "com.bumptech.glide.load.resource.bitmap.CenterInside".getBytes(j.f2629a);

    public final void b(MessageDigest messageDigest) {
        messageDigest.update(f9162b);
    }

    public final Bitmap c(c cVar, Bitmap bitmap, int i10, int i11) {
        Paint paint = g0.f9155a;
        if (bitmap.getWidth() > i10 || bitmap.getHeight() > i11) {
            Log.isLoggable("TransformationUtils", 2);
            return g0.b(cVar, bitmap, i10, i11);
        }
        Log.isLoggable("TransformationUtils", 2);
        return bitmap;
    }

    public final boolean equals(Object obj) {
        return obj instanceof i;
    }

    public final int hashCode() {
        return -670243078;
    }
}
