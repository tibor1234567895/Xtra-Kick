package wb;

import dc.m;
import dc.n;
import xa.j;

public final class e {

    /* renamed from: d  reason: collision with root package name */
    public static final n f16204d = m.b(Constants.EXT_TAG_END);

    /* renamed from: e  reason: collision with root package name */
    public static final n f16205e = m.b(":status");

    /* renamed from: f  reason: collision with root package name */
    public static final n f16206f = m.b(":method");

    /* renamed from: g  reason: collision with root package name */
    public static final n f16207g = m.b(":path");

    /* renamed from: h  reason: collision with root package name */
    public static final n f16208h = m.b(":scheme");

    /* renamed from: i  reason: collision with root package name */
    public static final n f16209i = m.b(":authority");

    /* renamed from: a  reason: collision with root package name */
    public final n f16210a;

    /* renamed from: b  reason: collision with root package name */
    public final n f16211b;

    /* renamed from: c  reason: collision with root package name */
    public final int f16212c;

    static {
        new d(0);
        n.f4802k.getClass();
    }

    public e(n nVar, n nVar2) {
        j.f("name", nVar);
        j.f("value", nVar2);
        this.f16210a = nVar;
        this.f16211b = nVar2;
        this.f16212c = nVar2.d() + nVar.d() + 32;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return j.a(this.f16210a, eVar.f16210a) && j.a(this.f16211b, eVar.f16211b);
    }

    public final int hashCode() {
        return this.f16211b.hashCode() + (this.f16210a.hashCode() * 31);
    }

    public final String toString() {
        return this.f16210a.q() + ": " + this.f16211b.q();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public e(n nVar, String str) {
        this(nVar, m.b(str));
        j.f("name", nVar);
        j.f("value", str);
        n.f4802k.getClass();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public e(String str, String str2) {
        this(m.b(str), m.b(str2));
        n.f4802k.getClass();
    }
}
