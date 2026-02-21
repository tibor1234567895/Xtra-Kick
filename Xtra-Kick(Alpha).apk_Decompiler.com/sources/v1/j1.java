package v1;

import a2.e;
import a2.i;
import a2.o;
import android.net.Uri;
import d9.r0;
import g1.a0;
import g1.q0;
import g1.s0;
import g1.z;
import k1.f0;
import k1.g;
import k1.l;
import k1.m;

public final class j1 extends a {

    /* renamed from: h  reason: collision with root package name */
    public final m f15682h;

    /* renamed from: i  reason: collision with root package name */
    public final g f15683i;

    /* renamed from: j  reason: collision with root package name */
    public final a0 f15684j;

    /* renamed from: k  reason: collision with root package name */
    public final long f15685k = -9223372036854775807L;

    /* renamed from: l  reason: collision with root package name */
    public final i f15686l;

    /* renamed from: m  reason: collision with root package name */
    public final boolean f15687m;

    /* renamed from: n  reason: collision with root package name */
    public final f1 f15688n;

    /* renamed from: o  reason: collision with root package name */
    public final s0 f15689o;

    /* renamed from: p  reason: collision with root package name */
    public f0 f15690p;

    public j1(String str, q0 q0Var, g gVar, i iVar, boolean z10, Object obj) {
        this.f15683i = gVar;
        this.f15686l = iVar;
        this.f15687m = z10;
        g1.f0 f0Var = new g1.f0();
        f0Var.f6359b = Uri.EMPTY;
        String uri = q0Var.f6522a.toString();
        uri.getClass();
        f0Var.f6358a = uri;
        f0Var.f6365h = r0.j(r0.n(q0Var));
        f0Var.f6366i = obj;
        s0 a10 = f0Var.a();
        this.f15689o = a10;
        z zVar = new z();
        String str2 = q0Var.f6523b;
        zVar.f6754k = str2 == null ? "text/x-unknown" : str2;
        zVar.f6746c = q0Var.f6524c;
        zVar.f6747d = q0Var.f6525d;
        zVar.f6748e = q0Var.f6526e;
        zVar.f6745b = q0Var.f6527f;
        String str3 = q0Var.f6528g;
        zVar.f6744a = str3 != null ? str3 : str;
        this.f15684j = new a0(zVar);
        l lVar = new l();
        lVar.f9013a = q0Var.f6522a;
        lVar.f9020h = 1;
        this.f15682h = lVar.a();
        this.f15688n = new f1(-9223372036854775807L, true, false, a10);
    }

    public final y b(a0 a0Var, e eVar, long j10) {
        return new i1(this.f15682h, this.f15683i, this.f15690p, this.f15684j, this.f15685k, this.f15686l, a(a0Var), this.f15687m);
    }

    public final s0 h() {
        return this.f15689o;
    }

    public final void j() {
    }

    public final void l(f0 f0Var) {
        this.f15690p = f0Var;
        m(this.f15688n);
    }

    public final void n(y yVar) {
        ((i1) yVar).f15671p.f((o) null);
    }

    public final void p() {
    }
}
