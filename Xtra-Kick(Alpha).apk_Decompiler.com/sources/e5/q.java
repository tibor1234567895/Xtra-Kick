package e5;

import android.graphics.Bitmap;
import w5.p;

public final class q implements o {

    /* renamed from: a  reason: collision with root package name */
    public final r f5064a;

    /* renamed from: b  reason: collision with root package name */
    public int f5065b;

    /* renamed from: c  reason: collision with root package name */
    public Bitmap.Config f5066c;

    public q(r rVar) {
        this.f5064a = rVar;
    }

    public final void a() {
        this.f5064a.c(this);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        return this.f5065b == qVar.f5065b && p.b(this.f5066c, qVar.f5066c);
    }

    public final int hashCode() {
        int i10 = this.f5065b * 31;
        Bitmap.Config config = this.f5066c;
        return i10 + (config != null ? config.hashCode() : 0);
    }

    public final String toString() {
        return s.h(this.f5065b, this.f5066c);
    }
}
