package k5;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import e5.c;
import java.security.MessageDigest;
import java.util.concurrent.locks.Lock;

public final class j extends e {

    /* renamed from: b  reason: collision with root package name */
    public static final byte[] f9163b = "com.bumptech.glide.load.resource.bitmap.CircleCrop.1".getBytes(b5.j.f2629a);

    public final void b(MessageDigest messageDigest) {
        messageDigest.update(f9163b);
    }

    /* JADX INFO: finally extract failed */
    public final Bitmap c(c cVar, Bitmap bitmap, int i10, int i11) {
        Bitmap.Config config;
        Bitmap bitmap2;
        Bitmap.Config config2;
        Paint paint = g0.f9155a;
        int min = Math.min(i10, i11);
        float f10 = (float) min;
        float f11 = f10 / 2.0f;
        float width = (float) bitmap.getWidth();
        float height = (float) bitmap.getHeight();
        float max = Math.max(f10 / width, f10 / height);
        float f12 = width * max;
        float f13 = max * height;
        float f14 = (f10 - f12) / 2.0f;
        float f15 = (f10 - f13) / 2.0f;
        RectF rectF = new RectF(f14, f15, f12 + f14, f13 + f15);
        int i12 = Build.VERSION.SDK_INT;
        if (i12 < 26 || !Bitmap.Config.RGBA_F16.equals(bitmap.getConfig())) {
            config = Bitmap.Config.ARGB_8888;
        } else {
            config = Bitmap.Config.RGBA_F16;
        }
        if (config.equals(bitmap.getConfig())) {
            bitmap2 = bitmap;
        } else {
            bitmap2 = cVar.b(bitmap.getWidth(), bitmap.getHeight(), config);
            new Canvas(bitmap2).drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        }
        if (i12 < 26 || !Bitmap.Config.RGBA_F16.equals(bitmap.getConfig())) {
            config2 = Bitmap.Config.ARGB_8888;
        } else {
            config2 = Bitmap.Config.RGBA_F16;
        }
        Bitmap b10 = cVar.b(min, min, config2);
        b10.setHasAlpha(true);
        Lock lock = g0.f9158d;
        lock.lock();
        try {
            Canvas canvas = new Canvas(b10);
            canvas.drawCircle(f11, f11, f11, g0.f9156b);
            canvas.drawBitmap(bitmap2, (Rect) null, rectF, g0.f9157c);
            canvas.setBitmap((Bitmap) null);
            lock.unlock();
            if (!bitmap2.equals(bitmap)) {
                cVar.c(bitmap2);
            }
            return b10;
        } catch (Throwable th) {
            lock.unlock();
            throw th;
        }
    }

    public final boolean equals(Object obj) {
        return obj instanceof j;
    }

    public final int hashCode() {
        return 1101716364;
    }
}
