package s4;

import android.graphics.Bitmap;
import androidx.lifecycle.t;
import hb.d0;
import s.i;
import t4.h;
import v4.c;
import xa.j;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final t f14203a;

    /* renamed from: b  reason: collision with root package name */
    public final h f14204b;

    /* renamed from: c  reason: collision with root package name */
    public final int f14205c;

    /* renamed from: d  reason: collision with root package name */
    public final d0 f14206d;

    /* renamed from: e  reason: collision with root package name */
    public final d0 f14207e;

    /* renamed from: f  reason: collision with root package name */
    public final d0 f14208f;

    /* renamed from: g  reason: collision with root package name */
    public final d0 f14209g;

    /* renamed from: h  reason: collision with root package name */
    public final c f14210h;

    /* renamed from: i  reason: collision with root package name */
    public final int f14211i;

    /* renamed from: j  reason: collision with root package name */
    public final Bitmap.Config f14212j;

    /* renamed from: k  reason: collision with root package name */
    public final Boolean f14213k;

    /* renamed from: l  reason: collision with root package name */
    public final Boolean f14214l;

    /* renamed from: m  reason: collision with root package name */
    public final int f14215m;

    /* renamed from: n  reason: collision with root package name */
    public final int f14216n;

    /* renamed from: o  reason: collision with root package name */
    public final int f14217o;

    public b(t tVar, h hVar, int i10, d0 d0Var, d0 d0Var2, d0 d0Var3, d0 d0Var4, c cVar, int i11, Bitmap.Config config, Boolean bool, Boolean bool2, int i12, int i13, int i14) {
        this.f14203a = tVar;
        this.f14204b = hVar;
        this.f14205c = i10;
        this.f14206d = d0Var;
        this.f14207e = d0Var2;
        this.f14208f = d0Var3;
        this.f14209g = d0Var4;
        this.f14210h = cVar;
        this.f14211i = i11;
        this.f14212j = config;
        this.f14213k = bool;
        this.f14214l = bool2;
        this.f14215m = i12;
        this.f14216n = i13;
        this.f14217o = i14;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            return j.a(this.f14203a, bVar.f14203a) && j.a(this.f14204b, bVar.f14204b) && this.f14205c == bVar.f14205c && j.a(this.f14206d, bVar.f14206d) && j.a(this.f14207e, bVar.f14207e) && j.a(this.f14208f, bVar.f14208f) && j.a(this.f14209g, bVar.f14209g) && j.a(this.f14210h, bVar.f14210h) && this.f14211i == bVar.f14211i && this.f14212j == bVar.f14212j && j.a(this.f14213k, bVar.f14213k) && j.a(this.f14214l, bVar.f14214l) && this.f14215m == bVar.f14215m && this.f14216n == bVar.f14216n && this.f14217o == bVar.f14217o;
        }
    }

    public final int hashCode() {
        int i10 = 0;
        t tVar = this.f14203a;
        int hashCode = (tVar != null ? tVar.hashCode() : 0) * 31;
        h hVar = this.f14204b;
        int hashCode2 = (hashCode + (hVar != null ? hVar.hashCode() : 0)) * 31;
        int i11 = this.f14205c;
        int a10 = (hashCode2 + (i11 != 0 ? i.a(i11) : 0)) * 31;
        d0 d0Var = this.f14206d;
        int hashCode3 = (a10 + (d0Var != null ? d0Var.hashCode() : 0)) * 31;
        d0 d0Var2 = this.f14207e;
        int hashCode4 = (hashCode3 + (d0Var2 != null ? d0Var2.hashCode() : 0)) * 31;
        d0 d0Var3 = this.f14208f;
        int hashCode5 = (hashCode4 + (d0Var3 != null ? d0Var3.hashCode() : 0)) * 31;
        d0 d0Var4 = this.f14209g;
        int hashCode6 = (hashCode5 + (d0Var4 != null ? d0Var4.hashCode() : 0)) * 31;
        c cVar = this.f14210h;
        int hashCode7 = (hashCode6 + (cVar != null ? cVar.hashCode() : 0)) * 31;
        int i12 = this.f14211i;
        int a11 = (hashCode7 + (i12 != 0 ? i.a(i12) : 0)) * 31;
        Bitmap.Config config = this.f14212j;
        int hashCode8 = (a11 + (config != null ? config.hashCode() : 0)) * 31;
        Boolean bool = this.f14213k;
        int hashCode9 = (hashCode8 + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.f14214l;
        int hashCode10 = (hashCode9 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        int i13 = this.f14215m;
        int a12 = (hashCode10 + (i13 != 0 ? i.a(i13) : 0)) * 31;
        int i14 = this.f14216n;
        int a13 = (a12 + (i14 != 0 ? i.a(i14) : 0)) * 31;
        int i15 = this.f14217o;
        if (i15 != 0) {
            i10 = i.a(i15);
        }
        return a13 + i10;
    }
}
