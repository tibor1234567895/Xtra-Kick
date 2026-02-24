package g1;

import android.os.Bundle;
import e.a;
import j1.l0;

public final class h implements m {

    /* renamed from: n  reason: collision with root package name */
    public static final h f6386n = new g().a();

    /* renamed from: o  reason: collision with root package name */
    public static final String f6387o = l0.C(0);

    /* renamed from: p  reason: collision with root package name */
    public static final String f6388p = l0.C(1);

    /* renamed from: q  reason: collision with root package name */
    public static final String f6389q = l0.C(2);

    /* renamed from: r  reason: collision with root package name */
    public static final String f6390r = l0.C(3);

    /* renamed from: s  reason: collision with root package name */
    public static final String f6391s = l0.C(4);

    /* renamed from: t  reason: collision with root package name */
    public static final a f6392t = new a(2);

    /* renamed from: h  reason: collision with root package name */
    public final int f6393h;

    /* renamed from: i  reason: collision with root package name */
    public final int f6394i;

    /* renamed from: j  reason: collision with root package name */
    public final int f6395j;

    /* renamed from: k  reason: collision with root package name */
    public final int f6396k;

    /* renamed from: l  reason: collision with root package name */
    public final int f6397l;

    /* renamed from: m  reason: collision with root package name */
    public a f6398m;

    public h(int i10, int i11, int i12, int i13, int i14) {
        this.f6393h = i10;
        this.f6394i = i11;
        this.f6395j = i12;
        this.f6396k = i13;
        this.f6397l = i14;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || h.class != obj.getClass()) {
            return false;
        }
        h hVar = (h) obj;
        return this.f6393h == hVar.f6393h && this.f6394i == hVar.f6394i && this.f6395j == hVar.f6395j && this.f6396k == hVar.f6396k && this.f6397l == hVar.f6397l;
    }

    public final Bundle h() {
        Bundle bundle = new Bundle();
        bundle.putInt(f6387o, this.f6393h);
        bundle.putInt(f6388p, this.f6394i);
        bundle.putInt(f6389q, this.f6395j);
        bundle.putInt(f6390r, this.f6396k);
        bundle.putInt(f6391s, this.f6397l);
        return bundle;
    }

    public final int hashCode() {
        return ((((((((527 + this.f6393h) * 31) + this.f6394i) * 31) + this.f6395j) * 31) + this.f6396k) * 31) + this.f6397l;
    }

    public final a i() {
        if (this.f6398m == null) {
            this.f6398m = new a(this, 0);
        }
        return this.f6398m;
    }
}
