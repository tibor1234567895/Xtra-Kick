package v1;

import a2.e;
import a2.i;
import android.net.Uri;
import android.os.Looper;
import d2.a0;
import g1.n0;
import g1.s0;
import j1.a;
import k1.f0;
import k1.g;
import k1.h;
import p0.c;
import p1.n;
import p1.q;
import p1.u;

public final class u0 extends a {

    /* renamed from: h  reason: collision with root package name */
    public final s0 f15794h;

    /* renamed from: i  reason: collision with root package name */
    public final n0 f15795i;

    /* renamed from: j  reason: collision with root package name */
    public final g f15796j;

    /* renamed from: k  reason: collision with root package name */
    public final c f15797k;

    /* renamed from: l  reason: collision with root package name */
    public final u f15798l;

    /* renamed from: m  reason: collision with root package name */
    public final i f15799m;

    /* renamed from: n  reason: collision with root package name */
    public final int f15800n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f15801o = true;

    /* renamed from: p  reason: collision with root package name */
    public long f15802p = -9223372036854775807L;

    /* renamed from: q  reason: collision with root package name */
    public boolean f15803q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f15804r;

    /* renamed from: s  reason: collision with root package name */
    public f0 f15805s;

    public u0(s0 s0Var, g gVar, c cVar, u uVar, i iVar, int i10) {
        n0 n0Var = s0Var.f6557i;
        n0Var.getClass();
        this.f15795i = n0Var;
        this.f15794h = s0Var;
        this.f15796j = gVar;
        this.f15797k = cVar;
        this.f15798l = uVar;
        this.f15799m = iVar;
        this.f15800n = i10;
    }

    public final y b(a0 a0Var, e eVar, long j10) {
        h a10 = this.f15796j.a();
        f0 f0Var = this.f15805s;
        if (f0Var != null) {
            a10.i(f0Var);
        }
        n0 n0Var = this.f15795i;
        Uri uri = n0Var.f6478a;
        a.f(this.f15562g);
        android.support.v4.media.session.u uVar = new android.support.v4.media.session.u((a0) this.f15797k.f12404i);
        u uVar2 = this.f15798l;
        a0 a0Var2 = a0Var;
        q qVar = new q(this.f15559d.f12507c, 0, a0Var);
        i iVar = this.f15799m;
        return new r0(uri, a10, uVar, uVar2, qVar, iVar, a(a0Var), this, eVar, n0Var.f6482e, this.f15800n);
    }

    public final s0 h() {
        return this.f15794h;
    }

    public final void j() {
    }

    public final void l(f0 f0Var) {
        this.f15805s = f0Var;
        Looper myLooper = Looper.myLooper();
        myLooper.getClass();
        n1.f0 f0Var2 = this.f15562g;
        a.f(f0Var2);
        u uVar = this.f15798l;
        uVar.f(myLooper, f0Var2);
        uVar.e();
        s();
    }

    public final void n(y yVar) {
        r0 r0Var = (r0) yVar;
        if (r0Var.C) {
            for (a1 a1Var : r0Var.f15777z) {
                a1Var.i();
                n nVar = a1Var.f15570h;
                if (nVar != null) {
                    nVar.d(a1Var.f15567e);
                    a1Var.f15570h = null;
                    a1Var.f15569g = null;
                }
            }
        }
        r0Var.f15769r.f(r0Var);
        r0Var.f15774w.removeCallbacksAndMessages((Object) null);
        r0Var.f15775x = null;
        r0Var.S = true;
    }

    public final void p() {
        this.f15798l.a();
    }

    /* JADX WARNING: type inference failed for: r0v2, types: [v1.s0] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void s() {
        /*
            r7 = this;
            v1.f1 r6 = new v1.f1
            long r1 = r7.f15802p
            boolean r3 = r7.f15803q
            boolean r4 = r7.f15804r
            g1.s0 r5 = r7.f15794h
            r0 = r6
            r0.<init>(r1, r3, r4, r5)
            boolean r0 = r7.f15801o
            if (r0 == 0) goto L_0x0018
            v1.s0 r0 = new v1.s0
            r0.<init>(r6)
            r6 = r0
        L_0x0018:
            r7.m(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: v1.u0.s():void");
    }

    public final void t(long j10, boolean z10, boolean z11) {
        if (j10 == -9223372036854775807L) {
            j10 = this.f15802p;
        }
        if (this.f15801o || this.f15802p != j10 || this.f15803q != z10 || this.f15804r != z11) {
            this.f15802p = j10;
            this.f15803q = z10;
            this.f15804r = z11;
            this.f15801o = false;
            s();
        }
    }
}
