package s4;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.ColorSpace;
import android.graphics.drawable.Drawable;
import android.os.Build;
import androidx.lifecycle.t;
import hb.d0;
import j4.j;
import java.util.List;
import pb.p0;
import q4.d;
import t4.h;
import u4.a;
import v4.c;

public final class i {
    public final Integer A;
    public final Drawable B;
    public final Integer C;
    public final Drawable D;
    public final Integer E;
    public final Drawable F;
    public final b G;
    public final a H;
    public final int I;
    public final int J;
    public final int K;
    public final int L;
    public final int M;

    /* renamed from: a  reason: collision with root package name */
    public final Context f14249a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f14250b;

    /* renamed from: c  reason: collision with root package name */
    public final a f14251c;

    /* renamed from: d  reason: collision with root package name */
    public final h f14252d;

    /* renamed from: e  reason: collision with root package name */
    public final d f14253e;

    /* renamed from: f  reason: collision with root package name */
    public final String f14254f;

    /* renamed from: g  reason: collision with root package name */
    public final Bitmap.Config f14255g;

    /* renamed from: h  reason: collision with root package name */
    public final ColorSpace f14256h;

    /* renamed from: i  reason: collision with root package name */
    public final la.i f14257i;

    /* renamed from: j  reason: collision with root package name */
    public final j f14258j;

    /* renamed from: k  reason: collision with root package name */
    public final List f14259k;

    /* renamed from: l  reason: collision with root package name */
    public final c f14260l;

    /* renamed from: m  reason: collision with root package name */
    public final p0 f14261m;

    /* renamed from: n  reason: collision with root package name */
    public final t f14262n;

    /* renamed from: o  reason: collision with root package name */
    public final boolean f14263o;

    /* renamed from: p  reason: collision with root package name */
    public final boolean f14264p;

    /* renamed from: q  reason: collision with root package name */
    public final boolean f14265q;

    /* renamed from: r  reason: collision with root package name */
    public final boolean f14266r;

    /* renamed from: s  reason: collision with root package name */
    public final d0 f14267s;

    /* renamed from: t  reason: collision with root package name */
    public final d0 f14268t;

    /* renamed from: u  reason: collision with root package name */
    public final d0 f14269u;

    /* renamed from: v  reason: collision with root package name */
    public final d0 f14270v;

    /* renamed from: w  reason: collision with root package name */
    public final t f14271w;

    /* renamed from: x  reason: collision with root package name */
    public final h f14272x;

    /* renamed from: y  reason: collision with root package name */
    public final p f14273y;

    /* renamed from: z  reason: collision with root package name */
    public final d f14274z;

    public i(Context context, Object obj, a aVar, h hVar, d dVar, String str, Bitmap.Config config, ColorSpace colorSpace, int i10, la.i iVar, j jVar, List list, c cVar, p0 p0Var, t tVar, boolean z10, boolean z11, boolean z12, boolean z13, int i11, int i12, int i13, d0 d0Var, d0 d0Var2, d0 d0Var3, d0 d0Var4, t tVar2, h hVar2, int i14, p pVar, d dVar2, Integer num, Drawable drawable, Integer num2, Drawable drawable2, Integer num3, Drawable drawable3, b bVar, a aVar2) {
        this.f14249a = context;
        this.f14250b = obj;
        this.f14251c = aVar;
        this.f14252d = hVar;
        this.f14253e = dVar;
        this.f14254f = str;
        this.f14255g = config;
        this.f14256h = colorSpace;
        this.I = i10;
        this.f14257i = iVar;
        this.f14258j = jVar;
        this.f14259k = list;
        this.f14260l = cVar;
        this.f14261m = p0Var;
        this.f14262n = tVar;
        this.f14263o = z10;
        this.f14264p = z11;
        this.f14265q = z12;
        this.f14266r = z13;
        this.J = i11;
        this.K = i12;
        this.L = i13;
        this.f14267s = d0Var;
        this.f14268t = d0Var2;
        this.f14269u = d0Var3;
        this.f14270v = d0Var4;
        this.f14271w = tVar2;
        this.f14272x = hVar2;
        this.M = i14;
        this.f14273y = pVar;
        this.f14274z = dVar2;
        this.A = num;
        this.B = drawable;
        this.C = num2;
        this.D = drawable2;
        this.E = num3;
        this.F = drawable3;
        this.G = bVar;
        this.H = aVar2;
    }

    public final Drawable a() {
        return w4.c.b(this, this.D, this.C, this.H.f14198k);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof i) {
            i iVar = (i) obj;
            return xa.j.a(this.f14249a, iVar.f14249a) && xa.j.a(this.f14250b, iVar.f14250b) && xa.j.a(this.f14251c, iVar.f14251c) && xa.j.a(this.f14252d, iVar.f14252d) && xa.j.a(this.f14253e, iVar.f14253e) && xa.j.a(this.f14254f, iVar.f14254f) && this.f14255g == iVar.f14255g && (Build.VERSION.SDK_INT < 26 || xa.j.a(this.f14256h, iVar.f14256h)) && this.I == iVar.I && xa.j.a(this.f14257i, iVar.f14257i) && xa.j.a(this.f14258j, iVar.f14258j) && xa.j.a(this.f14259k, iVar.f14259k) && xa.j.a(this.f14260l, iVar.f14260l) && xa.j.a(this.f14261m, iVar.f14261m) && xa.j.a(this.f14262n, iVar.f14262n) && this.f14263o == iVar.f14263o && this.f14264p == iVar.f14264p && this.f14265q == iVar.f14265q && this.f14266r == iVar.f14266r && this.J == iVar.J && this.K == iVar.K && this.L == iVar.L && xa.j.a(this.f14267s, iVar.f14267s) && xa.j.a(this.f14268t, iVar.f14268t) && xa.j.a(this.f14269u, iVar.f14269u) && xa.j.a(this.f14270v, iVar.f14270v) && xa.j.a(this.f14274z, iVar.f14274z) && xa.j.a(this.A, iVar.A) && xa.j.a(this.B, iVar.B) && xa.j.a(this.C, iVar.C) && xa.j.a(this.D, iVar.D) && xa.j.a(this.E, iVar.E) && xa.j.a(this.F, iVar.F) && xa.j.a(this.f14271w, iVar.f14271w) && xa.j.a(this.f14272x, iVar.f14272x) && this.M == iVar.M && xa.j.a(this.f14273y, iVar.f14273y) && xa.j.a(this.G, iVar.G) && xa.j.a(this.H, iVar.H);
        }
    }

    public final int hashCode() {
        int hashCode = (this.f14250b.hashCode() + (this.f14249a.hashCode() * 31)) * 31;
        int i10 = 0;
        a aVar = this.f14251c;
        int hashCode2 = (hashCode + (aVar != null ? aVar.hashCode() : 0)) * 31;
        h hVar = this.f14252d;
        int hashCode3 = (hashCode2 + (hVar != null ? hVar.hashCode() : 0)) * 31;
        d dVar = this.f14253e;
        int hashCode4 = (hashCode3 + (dVar != null ? dVar.hashCode() : 0)) * 31;
        String str = this.f14254f;
        int hashCode5 = (this.f14255g.hashCode() + ((hashCode4 + (str != null ? str.hashCode() : 0)) * 31)) * 31;
        ColorSpace colorSpace = this.f14256h;
        int a10 = (s.i.a(this.I) + ((hashCode5 + (colorSpace != null ? colorSpace.hashCode() : 0)) * 31)) * 31;
        la.i iVar = this.f14257i;
        int hashCode6 = (a10 + (iVar != null ? iVar.hashCode() : 0)) * 31;
        j jVar = this.f14258j;
        int i11 = 1237;
        int hashCode7 = (((((((this.f14262n.hashCode() + ((this.f14261m.hashCode() + ((this.f14260l.hashCode() + ((this.f14259k.hashCode() + ((hashCode6 + (jVar != null ? jVar.hashCode() : 0)) * 31)) * 31)) * 31)) * 31)) * 31) + (this.f14263o ? 1231 : 1237)) * 31) + (this.f14264p ? 1231 : 1237)) * 31) + (this.f14265q ? 1231 : 1237)) * 31;
        if (this.f14266r) {
            i11 = 1231;
        }
        int hashCode8 = (this.f14273y.hashCode() + ((s.i.a(this.M) + ((this.f14272x.hashCode() + ((this.f14271w.hashCode() + ((this.f14270v.hashCode() + ((this.f14269u.hashCode() + ((this.f14268t.hashCode() + ((this.f14267s.hashCode() + ((s.i.a(this.L) + ((s.i.a(this.K) + ((s.i.a(this.J) + ((hashCode7 + i11) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        d dVar2 = this.f14274z;
        int hashCode9 = (hashCode8 + (dVar2 != null ? dVar2.hashCode() : 0)) * 31;
        Integer num = this.A;
        int hashCode10 = (hashCode9 + (num != null ? num.hashCode() : 0)) * 31;
        Drawable drawable = this.B;
        int hashCode11 = (hashCode10 + (drawable != null ? drawable.hashCode() : 0)) * 31;
        Integer num2 = this.C;
        int hashCode12 = (hashCode11 + (num2 != null ? num2.hashCode() : 0)) * 31;
        Drawable drawable2 = this.D;
        int hashCode13 = (hashCode12 + (drawable2 != null ? drawable2.hashCode() : 0)) * 31;
        Integer num3 = this.E;
        int hashCode14 = (hashCode13 + (num3 != null ? num3.hashCode() : 0)) * 31;
        Drawable drawable3 = this.F;
        if (drawable3 != null) {
            i10 = drawable3.hashCode();
        }
        return this.H.hashCode() + ((this.G.hashCode() + ((hashCode14 + i10) * 31)) * 31);
    }
}
