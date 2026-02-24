package s5;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import b5.m;
import b5.n;
import b5.r;
import com.bumptech.glide.j;
import d5.u;
import k5.b0;
import k5.e;
import k5.h;
import k5.i;
import k5.t;
import k5.z;
import o5.g;
import w5.b;
import w5.p;

public abstract class a implements Cloneable {
    public boolean A;
    public Resources.Theme B;
    public boolean C;
    public boolean D;
    public boolean E;
    public boolean F = true;
    public boolean G;

    /* renamed from: h  reason: collision with root package name */
    public int f14304h;

    /* renamed from: i  reason: collision with root package name */
    public float f14305i = 1.0f;

    /* renamed from: j  reason: collision with root package name */
    public u f14306j = u.f4494d;

    /* renamed from: k  reason: collision with root package name */
    public j f14307k = j.NORMAL;

    /* renamed from: l  reason: collision with root package name */
    public Drawable f14308l;

    /* renamed from: m  reason: collision with root package name */
    public int f14309m;

    /* renamed from: n  reason: collision with root package name */
    public Drawable f14310n;

    /* renamed from: o  reason: collision with root package name */
    public int f14311o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f14312p = true;

    /* renamed from: q  reason: collision with root package name */
    public int f14313q = -1;

    /* renamed from: r  reason: collision with root package name */
    public int f14314r = -1;

    /* renamed from: s  reason: collision with root package name */
    public b5.j f14315s = v5.a.f15927b;

    /* renamed from: t  reason: collision with root package name */
    public boolean f14316t;

    /* renamed from: u  reason: collision with root package name */
    public boolean f14317u = true;

    /* renamed from: v  reason: collision with root package name */
    public Drawable f14318v;

    /* renamed from: w  reason: collision with root package name */
    public int f14319w;

    /* renamed from: x  reason: collision with root package name */
    public n f14320x = new n();

    /* renamed from: y  reason: collision with root package name */
    public b f14321y = new b();

    /* renamed from: z  reason: collision with root package name */
    public Class f14322z = Object.class;

    public static boolean h(int i10, int i11) {
        return (i10 & i11) != 0;
    }

    public a a(a aVar) {
        if (this.C) {
            return clone().a(aVar);
        }
        if (h(aVar.f14304h, 2)) {
            this.f14305i = aVar.f14305i;
        }
        if (h(aVar.f14304h, 262144)) {
            this.D = aVar.D;
        }
        if (h(aVar.f14304h, 1048576)) {
            this.G = aVar.G;
        }
        if (h(aVar.f14304h, 4)) {
            this.f14306j = aVar.f14306j;
        }
        if (h(aVar.f14304h, 8)) {
            this.f14307k = aVar.f14307k;
        }
        if (h(aVar.f14304h, 16)) {
            this.f14308l = aVar.f14308l;
            this.f14309m = 0;
            this.f14304h &= -33;
        }
        if (h(aVar.f14304h, 32)) {
            this.f14309m = aVar.f14309m;
            this.f14308l = null;
            this.f14304h &= -17;
        }
        if (h(aVar.f14304h, 64)) {
            this.f14310n = aVar.f14310n;
            this.f14311o = 0;
            this.f14304h &= -129;
        }
        if (h(aVar.f14304h, 128)) {
            this.f14311o = aVar.f14311o;
            this.f14310n = null;
            this.f14304h &= -65;
        }
        if (h(aVar.f14304h, 256)) {
            this.f14312p = aVar.f14312p;
        }
        if (h(aVar.f14304h, 512)) {
            this.f14314r = aVar.f14314r;
            this.f14313q = aVar.f14313q;
        }
        if (h(aVar.f14304h, 1024)) {
            this.f14315s = aVar.f14315s;
        }
        if (h(aVar.f14304h, 4096)) {
            this.f14322z = aVar.f14322z;
        }
        if (h(aVar.f14304h, 8192)) {
            this.f14318v = aVar.f14318v;
            this.f14319w = 0;
            this.f14304h &= -16385;
        }
        if (h(aVar.f14304h, 16384)) {
            this.f14319w = aVar.f14319w;
            this.f14318v = null;
            this.f14304h &= -8193;
        }
        if (h(aVar.f14304h, 32768)) {
            this.B = aVar.B;
        }
        if (h(aVar.f14304h, 65536)) {
            this.f14317u = aVar.f14317u;
        }
        if (h(aVar.f14304h, 131072)) {
            this.f14316t = aVar.f14316t;
        }
        if (h(aVar.f14304h, 2048)) {
            this.f14321y.putAll(aVar.f14321y);
            this.F = aVar.F;
        }
        if (h(aVar.f14304h, 524288)) {
            this.E = aVar.E;
        }
        if (!this.f14317u) {
            this.f14321y.clear();
            this.f14316t = false;
            this.f14304h = this.f14304h & -2049 & -131073;
            this.F = true;
        }
        this.f14304h |= aVar.f14304h;
        this.f14320x.f2635b.i(aVar.f14320x.f2635b);
        p();
        return this;
    }

    public a b() {
        if (!this.A || this.C) {
            this.C = true;
            return i();
        }
        throw new IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
    }

    public a c() {
        return w(t.f9170b, new k5.j());
    }

    /* renamed from: d */
    public a clone() {
        try {
            a aVar = (a) super.clone();
            n nVar = new n();
            aVar.f14320x = nVar;
            nVar.f2635b.i(this.f14320x.f2635b);
            b bVar = new b();
            aVar.f14321y = bVar;
            bVar.putAll(this.f14321y);
            aVar.A = false;
            aVar.C = false;
            return aVar;
        } catch (CloneNotSupportedException e10) {
            throw new RuntimeException(e10);
        }
    }

    public a e(Class cls) {
        if (this.C) {
            return clone().e(cls);
        }
        this.f14322z = cls;
        this.f14304h |= 4096;
        p();
        return this;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            return Float.compare(aVar.f14305i, this.f14305i) == 0 && this.f14309m == aVar.f14309m && p.b(this.f14308l, aVar.f14308l) && this.f14311o == aVar.f14311o && p.b(this.f14310n, aVar.f14310n) && this.f14319w == aVar.f14319w && p.b(this.f14318v, aVar.f14318v) && this.f14312p == aVar.f14312p && this.f14313q == aVar.f14313q && this.f14314r == aVar.f14314r && this.f14316t == aVar.f14316t && this.f14317u == aVar.f14317u && this.D == aVar.D && this.E == aVar.E && this.f14306j.equals(aVar.f14306j) && this.f14307k == aVar.f14307k && this.f14320x.equals(aVar.f14320x) && this.f14321y.equals(aVar.f14321y) && this.f14322z.equals(aVar.f14322z) && p.b(this.f14315s, aVar.f14315s) && p.b(this.B, aVar.B);
        }
    }

    public a f(u uVar) {
        if (this.C) {
            return clone().f(uVar);
        }
        w5.n.b(uVar);
        this.f14306j = uVar;
        this.f14304h |= 4;
        p();
        return this;
    }

    public a g(t tVar) {
        m mVar = t.f9174f;
        w5.n.b(tVar);
        return q(mVar, tVar);
    }

    public int hashCode() {
        float f10 = this.f14305i;
        char[] cArr = p.f16126a;
        return p.f(p.f(p.f(p.f(p.f(p.f(p.f(p.g(p.g(p.g(p.g((((p.g(p.f((p.f((p.f(((Float.floatToIntBits(f10) + 527) * 31) + this.f14309m, this.f14308l) * 31) + this.f14311o, this.f14310n) * 31) + this.f14319w, this.f14318v), this.f14312p) * 31) + this.f14313q) * 31) + this.f14314r, this.f14316t), this.f14317u), this.D), this.E), this.f14306j), this.f14307k), this.f14320x), this.f14321y), this.f14322z), this.f14315s), this.B);
    }

    public a i() {
        this.A = true;
        return this;
    }

    public a j() {
        return m(t.f9171c, new h());
    }

    public a k() {
        a m10 = m(t.f9170b, new i());
        m10.F = true;
        return m10;
    }

    public a l() {
        a m10 = m(t.f9169a, new b0());
        m10.F = true;
        return m10;
    }

    public final a m(t tVar, e eVar) {
        if (this.C) {
            return clone().m(tVar, eVar);
        }
        g(tVar);
        return t(eVar, false);
    }

    public a n(int i10, int i11) {
        if (this.C) {
            return clone().n(i10, i11);
        }
        this.f14314r = i10;
        this.f14313q = i11;
        this.f14304h |= 512;
        p();
        return this;
    }

    public a o() {
        j jVar = j.LOW;
        if (this.C) {
            return clone().o();
        }
        this.f14307k = jVar;
        this.f14304h |= 8;
        p();
        return this;
    }

    public final void p() {
        if (this.A) {
            throw new IllegalStateException("You cannot modify locked T, consider clone()");
        }
    }

    public a q(m mVar, Object obj) {
        if (this.C) {
            return clone().q(mVar, obj);
        }
        w5.n.b(mVar);
        w5.n.b(obj);
        this.f14320x.f2635b.put(mVar, obj);
        p();
        return this;
    }

    public a r(b5.j jVar) {
        if (this.C) {
            return clone().r(jVar);
        }
        this.f14315s = jVar;
        this.f14304h |= 1024;
        p();
        return this;
    }

    public a s(boolean z10) {
        if (this.C) {
            return clone().s(true);
        }
        this.f14312p = !z10;
        this.f14304h |= 256;
        p();
        return this;
    }

    public final a t(r rVar, boolean z10) {
        if (this.C) {
            return clone().t(rVar, z10);
        }
        z zVar = new z(rVar, z10);
        u(Bitmap.class, rVar, z10);
        u(Drawable.class, zVar, z10);
        u(BitmapDrawable.class, zVar, z10);
        u(o5.e.class, new g(rVar), z10);
        p();
        return this;
    }

    public final a u(Class cls, r rVar, boolean z10) {
        if (this.C) {
            return clone().u(cls, rVar, z10);
        }
        w5.n.b(rVar);
        this.f14321y.put(cls, rVar);
        this.f14317u = true;
        int i10 = this.f14304h | 2048 | 65536;
        this.f14304h = i10;
        this.F = false;
        if (z10) {
            this.f14304h = i10 | 131072;
            this.f14316t = true;
        }
        p();
        return this;
    }

    public a v(k5.j jVar) {
        return t(jVar, true);
    }

    public final a w(k5.p pVar, k5.j jVar) {
        if (this.C) {
            return clone().w(pVar, jVar);
        }
        g(pVar);
        return v(jVar);
    }

    public a x() {
        if (this.C) {
            return clone().x();
        }
        this.G = true;
        this.f14304h |= 1048576;
        p();
        return this;
    }
}
