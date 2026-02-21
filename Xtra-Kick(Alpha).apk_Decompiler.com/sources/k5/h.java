package k5;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Paint;
import b5.j;
import e5.c;
import java.security.MessageDigest;

public final class h extends e {

    /* renamed from: b  reason: collision with root package name */
    public static final byte[] f9159b = "com.bumptech.glide.load.resource.bitmap.CenterCrop".getBytes(j.f2629a);

    public final void b(MessageDigest messageDigest) {
        messageDigest.update(f9159b);
    }

    public final Bitmap c(c cVar, Bitmap bitmap, int i10, int i11) {
        float f10;
        float f11;
        Bitmap.Config config;
        Paint paint = g0.f9155a;
        if (bitmap.getWidth() == i10 && bitmap.getHeight() == i11) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        float f12 = 0.0f;
        if (bitmap.getWidth() * i11 > bitmap.getHeight() * i10) {
            f11 = ((float) i11) / ((float) bitmap.getHeight());
            f12 = (((float) i10) - (((float) bitmap.getWidth()) * f11)) * 0.5f;
            f10 = 0.0f;
        } else {
            f11 = ((float) i10) / ((float) bitmap.getWidth());
            f10 = (((float) i11) - (((float) bitmap.getHeight()) * f11)) * 0.5f;
        }
        matrix.setScale(f11, f11);
        matrix.postTranslate((float) ((int) (f12 + 0.5f)), (float) ((int) (f10 + 0.5f)));
        if (bitmap.getConfig() != null) {
            config = bitmap.getConfig();
        } else {
            config = Bitmap.Config.ARGB_8888;
        }
        Bitmap b10 = cVar.b(i10, i11, config);
        b10.setHasAlpha(bitmap.hasAlpha());
        g0.a(bitmap, b10, matrix);
        return b10;
    }

    public final boolean equals(Object obj) {
        return obj instanceof h;
    }

    public final int hashCode() {
        return -599754482;
    }
}
