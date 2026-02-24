package s4;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import hb.d0;
import s.i;
import v4.c;
import xa.j;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final d0 f14188a;

    /* renamed from: b  reason: collision with root package name */
    public final d0 f14189b;

    /* renamed from: c  reason: collision with root package name */
    public final d0 f14190c;

    /* renamed from: d  reason: collision with root package name */
    public final d0 f14191d;

    /* renamed from: e  reason: collision with root package name */
    public final c f14192e;

    /* renamed from: f  reason: collision with root package name */
    public final int f14193f;

    /* renamed from: g  reason: collision with root package name */
    public final Bitmap.Config f14194g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f14195h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f14196i;

    /* renamed from: j  reason: collision with root package name */
    public final Drawable f14197j;

    /* renamed from: k  reason: collision with root package name */
    public final Drawable f14198k;

    /* renamed from: l  reason: collision with root package name */
    public final Drawable f14199l;

    /* renamed from: m  reason: collision with root package name */
    public final int f14200m;

    /* renamed from: n  reason: collision with root package name */
    public final int f14201n;

    /* renamed from: o  reason: collision with root package name */
    public final int f14202o;

    public a() {
        this(0);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            return j.a(this.f14188a, aVar.f14188a) && j.a(this.f14189b, aVar.f14189b) && j.a(this.f14190c, aVar.f14190c) && j.a(this.f14191d, aVar.f14191d) && j.a(this.f14192e, aVar.f14192e) && this.f14193f == aVar.f14193f && this.f14194g == aVar.f14194g && this.f14195h == aVar.f14195h && this.f14196i == aVar.f14196i && j.a(this.f14197j, aVar.f14197j) && j.a(this.f14198k, aVar.f14198k) && j.a(this.f14199l, aVar.f14199l) && this.f14200m == aVar.f14200m && this.f14201n == aVar.f14201n && this.f14202o == aVar.f14202o;
        }
    }

    public final int hashCode() {
        int hashCode = this.f14189b.hashCode();
        int hashCode2 = this.f14190c.hashCode();
        int i10 = 1237;
        int hashCode3 = (((this.f14194g.hashCode() + ((i.a(this.f14193f) + ((this.f14192e.hashCode() + ((this.f14191d.hashCode() + ((hashCode2 + ((hashCode + (this.f14188a.hashCode() * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31) + (this.f14195h ? 1231 : 1237)) * 31;
        if (this.f14196i) {
            i10 = 1231;
        }
        int i11 = (hashCode3 + i10) * 31;
        int i12 = 0;
        Drawable drawable = this.f14197j;
        int hashCode4 = (i11 + (drawable != null ? drawable.hashCode() : 0)) * 31;
        Drawable drawable2 = this.f14198k;
        int hashCode5 = (hashCode4 + (drawable2 != null ? drawable2.hashCode() : 0)) * 31;
        Drawable drawable3 = this.f14199l;
        if (drawable3 != null) {
            i12 = drawable3.hashCode();
        }
        return i.a(this.f14202o) + ((i.a(this.f14201n) + ((i.a(this.f14200m) + ((hashCode5 + i12) * 31)) * 31)) * 31);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public a(int r18) {
        /*
            r17 = this;
            nb.e r0 = hb.p0.f7833a
            hb.x1 r0 = mb.u.f10886a
            hb.x1 r2 = r0.Q0()
            nb.d r5 = hb.p0.f7834b
            v4.a r6 = v4.c.f15926a
            r7 = 3
            android.graphics.Bitmap$Config r8 = w4.e.f16081b
            r9 = 1
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 1
            r15 = 1
            r16 = 1
            r1 = r17
            r3 = r5
            r4 = r5
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: s4.a.<init>(int):void");
    }

    public a(d0 d0Var, d0 d0Var2, d0 d0Var3, d0 d0Var4, c cVar, int i10, Bitmap.Config config, boolean z10, boolean z11, Drawable drawable, Drawable drawable2, Drawable drawable3, int i11, int i12, int i13) {
        this.f14188a = d0Var;
        this.f14189b = d0Var2;
        this.f14190c = d0Var3;
        this.f14191d = d0Var4;
        this.f14192e = cVar;
        this.f14193f = i10;
        this.f14194g = config;
        this.f14195h = z10;
        this.f14196i = z11;
        this.f14197j = drawable;
        this.f14198k = drawable2;
        this.f14199l = drawable3;
        this.f14200m = i11;
        this.f14201n = i12;
        this.f14202o = i13;
    }
}
