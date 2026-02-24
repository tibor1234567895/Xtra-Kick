package z1;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.TextUtils;
import d9.e0;
import d9.o1;
import d9.p1;
import d9.r0;
import d9.y1;
import g1.a0;
import g1.v1;
import j1.l0;
import java.util.Locale;

public final class g extends o implements Comparable {
    public final int A;
    public final boolean B;
    public final boolean C;

    /* renamed from: l  reason: collision with root package name */
    public final int f17398l;

    /* renamed from: m  reason: collision with root package name */
    public final boolean f17399m;

    /* renamed from: n  reason: collision with root package name */
    public final String f17400n = q.l(this.f17452k.f6267j);

    /* renamed from: o  reason: collision with root package name */
    public final j f17401o;

    /* renamed from: p  reason: collision with root package name */
    public final boolean f17402p;

    /* renamed from: q  reason: collision with root package name */
    public final int f17403q;

    /* renamed from: r  reason: collision with root package name */
    public final int f17404r;

    /* renamed from: s  reason: collision with root package name */
    public final int f17405s;

    /* renamed from: t  reason: collision with root package name */
    public final boolean f17406t;

    /* renamed from: u  reason: collision with root package name */
    public final int f17407u;

    /* renamed from: v  reason: collision with root package name */
    public final int f17408v;

    /* renamed from: w  reason: collision with root package name */
    public final boolean f17409w;

    /* renamed from: x  reason: collision with root package name */
    public final int f17410x;

    /* renamed from: y  reason: collision with root package name */
    public final int f17411y;

    /* renamed from: z  reason: collision with root package name */
    public final int f17412z;

    public g(int i10, v1 v1Var, int i11, j jVar, int i12, boolean z10, f fVar) {
        super(i10, i11, v1Var);
        int i13;
        int i14;
        int i15;
        boolean z11;
        boolean z12;
        boolean z13;
        String[] strArr;
        int i16;
        boolean z14;
        boolean z15;
        boolean z16;
        String str;
        this.f17401o = jVar;
        int i17 = 0;
        this.f17402p = q.j(i12, false);
        int i18 = 0;
        while (true) {
            i13 = Integer.MAX_VALUE;
            if (i18 >= jVar.f6738u.size()) {
                i18 = Integer.MAX_VALUE;
                i14 = 0;
                break;
            }
            i14 = q.i(this.f17452k, (String) jVar.f6738u.get(i18), false);
            if (i14 > 0) {
                break;
            }
            i18++;
        }
        this.f17404r = i18;
        this.f17403q = i14;
        int i19 = this.f17452k.f6269l;
        int i20 = jVar.f6739v;
        if (i19 == 0 || i19 != i20) {
            i15 = Integer.bitCount(i19 & i20);
        } else {
            i15 = Integer.MAX_VALUE;
        }
        this.f17405s = i15;
        a0 a0Var = this.f17452k;
        int i21 = a0Var.f6269l;
        if (i21 == 0 || (i21 & 1) != 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        this.f17406t = z11;
        if ((a0Var.f6268k & 1) != 0) {
            z12 = true;
        } else {
            z12 = false;
        }
        this.f17409w = z12;
        int i22 = a0Var.F;
        this.f17410x = i22;
        this.f17411y = a0Var.G;
        int i23 = a0Var.f6272o;
        this.f17412z = i23;
        if ((i23 == -1 || i23 <= jVar.f6741x) && ((i22 == -1 || i22 <= jVar.f6740w) && fVar.apply(a0Var))) {
            z13 = true;
        } else {
            z13 = false;
        }
        this.f17399m = z13;
        Configuration configuration = Resources.getSystem().getConfiguration();
        int i24 = l0.f8453a;
        if (i24 >= 24) {
            strArr = configuration.getLocales().toLanguageTags().split(",", -1);
        } else {
            String[] strArr2 = new String[1];
            Locale locale = configuration.locale;
            if (i24 >= 21) {
                str = locale.toLanguageTag();
            } else {
                str = locale.toString();
            }
            strArr2[0] = str;
            strArr = strArr2;
        }
        for (int i25 = 0; i25 < strArr.length; i25++) {
            strArr[i25] = l0.I(strArr[i25]);
        }
        int i26 = 0;
        while (true) {
            if (i26 >= strArr.length) {
                i26 = Integer.MAX_VALUE;
                i16 = 0;
                break;
            }
            i16 = q.i(this.f17452k, strArr[i26], false);
            if (i16 > 0) {
                break;
            }
            i26++;
        }
        this.f17407u = i26;
        this.f17408v = i16;
        int i27 = 0;
        while (true) {
            r0 r0Var = jVar.f6742y;
            if (i27 < r0Var.size()) {
                String str2 = this.f17452k.f6276s;
                if (str2 != null && str2.equals(r0Var.get(i27))) {
                    i13 = i27;
                    break;
                }
                i27++;
            } else {
                break;
            }
        }
        this.A = i13;
        if ((i12 & 384) == 128) {
            z14 = true;
        } else {
            z14 = false;
        }
        this.B = z14;
        if ((i12 & 64) == 64) {
            z15 = true;
        } else {
            z15 = false;
        }
        this.C = z15;
        j jVar2 = this.f17401o;
        if (q.j(i12, jVar2.f17428s0) && ((z16 = this.f17399m) || jVar2.f17422m0)) {
            i17 = (!q.j(i12, false) || !z16 || this.f17452k.f6272o == -1 || jVar2.E || jVar2.D || (!jVar2.f17430u0 && z10)) ? 1 : 2;
        }
        this.f17398l = i17;
    }

    public final int a() {
        return this.f17398l;
    }

    public final boolean b(o oVar) {
        int i10;
        String str;
        int i11;
        g gVar = (g) oVar;
        j jVar = this.f17401o;
        boolean z10 = jVar.f17425p0;
        a0 a0Var = gVar.f17452k;
        a0 a0Var2 = this.f17452k;
        if ((z10 || ((i11 = a0Var2.F) != -1 && i11 == a0Var.F)) && ((jVar.f17423n0 || ((str = a0Var2.f6276s) != null && TextUtils.equals(str, a0Var.f6276s))) && ((jVar.f17424o0 || ((i10 = a0Var2.G) != -1 && i10 == a0Var.G)) && (jVar.f17426q0 || (this.B == gVar.B && this.C == gVar.C))))) {
            return true;
        }
        return false;
    }

    /* renamed from: c */
    public final int compareTo(g gVar) {
        p1 p1Var;
        p1 p1Var2;
        boolean z10 = this.f17402p;
        boolean z11 = this.f17399m;
        if (!z11 || !z10) {
            p1Var = q.f17467j.a();
        } else {
            p1Var = q.f17467j;
        }
        e0 c10 = e0.f4608a.c(z10, gVar.f17402p);
        Integer valueOf = Integer.valueOf(this.f17404r);
        Integer valueOf2 = Integer.valueOf(gVar.f17404r);
        o1.f4642h.getClass();
        y1 y1Var = y1.f4713h;
        e0 b10 = c10.b(valueOf, valueOf2, y1Var).a(this.f17403q, gVar.f17403q).a(this.f17405s, gVar.f17405s).c(this.f17409w, gVar.f17409w).c(this.f17406t, gVar.f17406t).b(Integer.valueOf(this.f17407u), Integer.valueOf(gVar.f17407u), y1Var).a(this.f17408v, gVar.f17408v).c(z11, gVar.f17399m).b(Integer.valueOf(this.A), Integer.valueOf(gVar.A), y1Var);
        int i10 = this.f17412z;
        Integer valueOf3 = Integer.valueOf(i10);
        int i11 = gVar.f17412z;
        Integer valueOf4 = Integer.valueOf(i11);
        if (this.f17401o.D) {
            p1Var2 = q.f17467j.a();
        } else {
            p1Var2 = q.f17468k;
        }
        e0 b11 = b10.b(valueOf3, valueOf4, p1Var2).c(this.B, gVar.B).c(this.C, gVar.C).b(Integer.valueOf(this.f17410x), Integer.valueOf(gVar.f17410x), p1Var).b(Integer.valueOf(this.f17411y), Integer.valueOf(gVar.f17411y), p1Var);
        Integer valueOf5 = Integer.valueOf(i10);
        Integer valueOf6 = Integer.valueOf(i11);
        if (!l0.a(this.f17400n, gVar.f17400n)) {
            p1Var = q.f17468k;
        }
        return b11.b(valueOf5, valueOf6, p1Var).e();
    }
}
