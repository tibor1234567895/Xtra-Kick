package xa;

import android.support.v4.media.h;
import db.a;
import db.c;

public class i extends b implements h, c {

    /* renamed from: o  reason: collision with root package name */
    public final int f16810o;

    /* renamed from: p  reason: collision with root package name */
    public final int f16811p;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i(int i10, Class cls, String str, String str2, int i11) {
        super(b.f16799n, cls, str, str2, (i11 & 1) == 1);
        this.f16810o = i10;
        this.f16811p = i11 >> 1;
    }

    public final a a() {
        v.f16819a.getClass();
        return this;
    }

    /* renamed from: d */
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof i) {
            i iVar = (i) obj;
            if (!this.f16803k.equals(iVar.f16803k) || !this.f16804l.equals(iVar.f16804l) || this.f16811p != iVar.f16811p || this.f16810o != iVar.f16810o || !j.a(this.f16801i, iVar.f16801i) || !j.a(c(), iVar.c())) {
                return false;
            }
            return true;
        } else if (!(obj instanceof c)) {
            return false;
        } else {
            a aVar = this.f16800h;
            if (aVar == null) {
                a();
                this.f16800h = this;
                aVar = this;
            }
            return obj.equals(aVar);
        }
    }

    /* renamed from: f */
    public final int hashCode() {
        int i10;
        if (c() == null) {
            i10 = 0;
        } else {
            i10 = c().hashCode() * 31;
        }
        return this.f16804l.hashCode() + h.e(this.f16803k, i10, 31);
    }

    public final int getArity() {
        return this.f16810o;
    }

    /* renamed from: h */
    public final String toString() {
        a aVar = this.f16800h;
        if (aVar == null) {
            a();
            this.f16800h = this;
            aVar = this;
        }
        if (aVar != this) {
            return aVar.toString();
        }
        String str = this.f16803k;
        if ("<init>".equals(str)) {
            return "constructor (Kotlin reflection is not available)";
        }
        return h.n("function ", str, " (Kotlin reflection is not available)");
    }

    public i(int i10, Object obj, Class cls, String str, String str2) {
        super(obj, cls, str, str2, false);
        this.f16810o = i10;
        this.f16811p = 0;
    }
}
