package k5;

import android.graphics.Bitmap;
import b5.j;
import e5.c;
import java.security.MessageDigest;

public final class b0 extends e {

    /* renamed from: b  reason: collision with root package name */
    public static final byte[] f9129b = "com.bumptech.glide.load.resource.bitmap.FitCenter".getBytes(j.f2629a);

    public final void b(MessageDigest messageDigest) {
        messageDigest.update(f9129b);
    }

    public final Bitmap c(c cVar, Bitmap bitmap, int i10, int i11) {
        return g0.b(cVar, bitmap, i10, i11);
    }

    public final boolean equals(Object obj) {
        return obj instanceof b0;
    }

    public final int hashCode() {
        return 1572326941;
    }
}
