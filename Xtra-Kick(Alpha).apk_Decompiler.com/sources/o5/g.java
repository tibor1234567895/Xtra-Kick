package o5;

import android.graphics.Bitmap;
import b5.r;
import com.bumptech.glide.c;
import com.bumptech.glide.h;
import d5.o0;
import java.security.MessageDigest;
import k5.d;
import w5.n;

public final class g implements r {

    /* renamed from: b  reason: collision with root package name */
    public final r f12211b;

    public g(r rVar) {
        n.b(rVar);
        this.f12211b = rVar;
    }

    public final o0 a(h hVar, o0 o0Var, int i10, int i11) {
        e eVar = (e) o0Var.get();
        d dVar = new d(eVar.f12201h.f12200a.f12227l, c.a(hVar).f3164h);
        r rVar = this.f12211b;
        o0 a10 = rVar.a(hVar, dVar, i10, i11);
        if (!dVar.equals(a10)) {
            dVar.e();
        }
        eVar.f12201h.f12200a.c(rVar, (Bitmap) a10.get());
        return o0Var;
    }

    public final void b(MessageDigest messageDigest) {
        this.f12211b.b(messageDigest);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof g) {
            return this.f12211b.equals(((g) obj).f12211b);
        }
        return false;
    }

    public final int hashCode() {
        return this.f12211b.hashCode();
    }
}
