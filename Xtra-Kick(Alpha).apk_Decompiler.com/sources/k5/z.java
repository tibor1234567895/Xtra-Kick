package k5;

import android.graphics.drawable.Drawable;
import b5.r;
import com.bumptech.glide.h;
import d5.o0;
import e5.c;
import java.security.MessageDigest;

public final class z implements r {

    /* renamed from: b  reason: collision with root package name */
    public final r f9197b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f9198c;

    public z(r rVar, boolean z10) {
        this.f9197b = rVar;
        this.f9198c = z10;
    }

    public final o0 a(h hVar, o0 o0Var, int i10, int i11) {
        c cVar = com.bumptech.glide.c.a(hVar).f3164h;
        Drawable drawable = (Drawable) o0Var.get();
        d a10 = y.a(cVar, drawable, i10, i11);
        if (a10 != null) {
            o0 a11 = this.f9197b.a(hVar, a10, i10, i11);
            if (!a11.equals(a10)) {
                return new d(hVar.getResources(), a11);
            }
            a11.e();
            return o0Var;
        } else if (!this.f9198c) {
            return o0Var;
        } else {
            throw new IllegalArgumentException("Unable to convert " + drawable + " to a Bitmap");
        }
    }

    public final void b(MessageDigest messageDigest) {
        this.f9197b.b(messageDigest);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof z) {
            return this.f9197b.equals(((z) obj).f9197b);
        }
        return false;
    }

    public final int hashCode() {
        return this.f9197b.hashCode();
    }
}
