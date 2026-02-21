package y1;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import d9.r0;
import d9.r1;
import g1.a0;
import g1.a1;
import i1.d;
import j1.a;
import j1.l0;
import j1.v;
import m1.f;
import m1.g0;
import m1.k0;
import m1.n0;
import m1.w0;
import p0.c;
import w2.e;
import w2.h;
import w2.i;

public final class g extends f implements Handler.Callback {
    public int A;
    public a0 B;
    public e C;
    public h D;
    public i E;
    public i F;
    public int G;
    public long H;
    public long I;
    public long J;

    /* renamed from: t  reason: collision with root package name */
    public final Handler f16868t;

    /* renamed from: u  reason: collision with root package name */
    public final f f16869u;

    /* renamed from: v  reason: collision with root package name */
    public final e f16870v;

    /* renamed from: w  reason: collision with root package name */
    public final w0 f16871w;

    /* renamed from: x  reason: collision with root package name */
    public boolean f16872x;

    /* renamed from: y  reason: collision with root package name */
    public boolean f16873y;

    /* renamed from: z  reason: collision with root package name */
    public boolean f16874z;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g(k0 k0Var, Looper looper) {
        super(3);
        Handler handler;
        d dVar = e.f16867a;
        this.f16869u = k0Var;
        if (looper == null) {
            handler = null;
        } else {
            int i10 = l0.f8453a;
            handler = new Handler(looper, this);
        }
        this.f16868t = handler;
        this.f16870v = dVar;
        this.f16871w = new w0();
        this.H = -9223372036854775807L;
        this.I = -9223372036854775807L;
        this.J = -9223372036854775807L;
    }

    public final long A() {
        if (this.G == -1) {
            return Long.MAX_VALUE;
        }
        this.E.getClass();
        if (this.G >= this.E.d()) {
            return Long.MAX_VALUE;
        }
        return this.E.b(this.G);
    }

    public final long B(long j10) {
        boolean z10 = true;
        a.e(j10 != -9223372036854775807L);
        if (this.I == -9223372036854775807L) {
            z10 = false;
        }
        a.e(z10);
        return j10 - this.I;
    }

    public final void C(d dVar) {
        r0 r0Var = dVar.f7994h;
        k0 k0Var = (k0) this.f16869u;
        k0Var.f10314h.f10388l.m(27, new g0(r0Var, 0));
        n0 n0Var = k0Var.f10314h;
        n0Var.f10371c0 = dVar;
        n0Var.f10388l.m(27, new c(4, dVar));
    }

    public final void D() {
        this.D = null;
        this.G = -1;
        i iVar = this.E;
        if (iVar != null) {
            iVar.h();
            this.E = null;
        }
        i iVar2 = this.F;
        if (iVar2 != null) {
            iVar2.h();
            this.F = null;
        }
    }

    public final String g() {
        return "TextRenderer";
    }

    public final boolean handleMessage(Message message) {
        if (message.what == 0) {
            C((d) message.obj);
            return true;
        }
        throw new IllegalStateException();
    }

    public final boolean j() {
        return this.f16873y;
    }

    public final boolean k() {
        return true;
    }

    public final void l() {
        this.B = null;
        this.H = -9223372036854775807L;
        z();
        this.I = -9223372036854775807L;
        this.J = -9223372036854775807L;
        D();
        e eVar = this.C;
        eVar.getClass();
        eVar.a();
        this.C = null;
        this.A = 0;
    }

    public final void n(long j10, boolean z10) {
        this.J = j10;
        z();
        this.f16872x = false;
        this.f16873y = false;
        this.H = -9223372036854775807L;
        if (this.A != 0) {
            D();
            e eVar = this.C;
            eVar.getClass();
            eVar.a();
            this.C = null;
            this.A = 0;
            this.f16874z = true;
            a0 a0Var = this.B;
            a0Var.getClass();
            this.C = ((d) this.f16870v).a(a0Var);
            return;
        }
        D();
        e eVar2 = this.C;
        eVar2.getClass();
        eVar2.flush();
    }

    public final void r(a0[] a0VarArr, long j10, long j11) {
        this.I = j11;
        a0 a0Var = a0VarArr[0];
        this.B = a0Var;
        if (this.C != null) {
            this.A = 1;
            return;
        }
        this.f16874z = true;
        a0Var.getClass();
        this.C = ((d) this.f16870v).a(a0Var);
    }

    public final void t(long j10, long j11) {
        boolean z10;
        boolean z11;
        long j12;
        long j13 = j10;
        w0 w0Var = this.f16871w;
        this.J = j13;
        if (this.f10226r) {
            long j14 = this.H;
            if (j14 != -9223372036854775807L && j13 >= j14) {
                D();
                this.f16873y = true;
            }
        }
        if (!this.f16873y) {
            i iVar = this.F;
            e eVar = this.f16870v;
            if (iVar == null) {
                e eVar2 = this.C;
                eVar2.getClass();
                eVar2.b(j13);
                try {
                    e eVar3 = this.C;
                    eVar3.getClass();
                    this.F = (i) eVar3.d();
                } catch (w2.f e10) {
                    v.d("TextRenderer", "Subtitle decoding failed. streamFormat=" + this.B, e10);
                    z();
                    D();
                    e eVar4 = this.C;
                    eVar4.getClass();
                    eVar4.a();
                    this.C = null;
                    this.A = 0;
                    this.f16874z = true;
                    a0 a0Var = this.B;
                    a0Var.getClass();
                    this.C = ((d) eVar).a(a0Var);
                    return;
                }
            }
            if (this.f10221m == 2) {
                if (this.E != null) {
                    long A2 = A();
                    z10 = false;
                    while (A2 <= j13) {
                        this.G++;
                        A2 = A();
                        z10 = true;
                    }
                } else {
                    z10 = false;
                }
                i iVar2 = this.F;
                if (iVar2 != null) {
                    if (iVar2.f(4)) {
                        if (!z10 && A() == Long.MAX_VALUE) {
                            if (this.A == 2) {
                                D();
                                e eVar5 = this.C;
                                eVar5.getClass();
                                eVar5.a();
                                this.C = null;
                                this.A = 0;
                                this.f16874z = true;
                                a0 a0Var2 = this.B;
                                a0Var2.getClass();
                                this.C = ((d) eVar).a(a0Var2);
                            } else {
                                D();
                                this.f16873y = true;
                            }
                        }
                    } else if (iVar2.f9521i <= j13) {
                        i iVar3 = this.E;
                        if (iVar3 != null) {
                            iVar3.h();
                        }
                        this.G = iVar2.a(j13);
                        this.E = iVar2;
                        this.F = null;
                        z10 = true;
                    }
                }
                if (z10) {
                    this.E.getClass();
                    int a10 = this.E.a(j13);
                    if (a10 == 0 || this.E.d() == 0) {
                        j12 = this.E.f9521i;
                    } else if (a10 == -1) {
                        i iVar4 = this.E;
                        j12 = iVar4.b(iVar4.d() - 1);
                    } else {
                        j12 = this.E.b(a10 - 1);
                    }
                    d dVar = new d(B(j12), this.E.c(j13));
                    Handler handler = this.f16868t;
                    if (handler != null) {
                        handler.obtainMessage(0, dVar).sendToTarget();
                    } else {
                        C(dVar);
                    }
                }
                if (this.A != 2) {
                    while (!this.f16872x) {
                        try {
                            h hVar = this.D;
                            if (hVar == null) {
                                e eVar6 = this.C;
                                eVar6.getClass();
                                hVar = (h) eVar6.e();
                                if (hVar != null) {
                                    this.D = hVar;
                                } else {
                                    return;
                                }
                            }
                            if (this.A == 1) {
                                hVar.f9501h = 4;
                                e eVar7 = this.C;
                                eVar7.getClass();
                                eVar7.c(hVar);
                                this.D = null;
                                this.A = 2;
                                return;
                            }
                            int s10 = s(w0Var, hVar, 0);
                            if (s10 == -4) {
                                if (hVar.f(4)) {
                                    this.f16872x = true;
                                    this.f16874z = false;
                                } else {
                                    a0 a0Var3 = w0Var.f10523b;
                                    if (a0Var3 != null) {
                                        hVar.f16064p = a0Var3.f6280w;
                                        hVar.k();
                                        boolean z12 = this.f16874z;
                                        if (!hVar.f(1)) {
                                            z11 = true;
                                        } else {
                                            z11 = false;
                                        }
                                        this.f16874z = z12 & z11;
                                    } else {
                                        return;
                                    }
                                }
                                if (!this.f16874z) {
                                    e eVar8 = this.C;
                                    eVar8.getClass();
                                    eVar8.c(hVar);
                                    this.D = null;
                                }
                            } else if (s10 == -3) {
                                return;
                            }
                        } catch (w2.f e11) {
                            v.d("TextRenderer", "Subtitle decoding failed. streamFormat=" + this.B, e11);
                            z();
                            D();
                            e eVar9 = this.C;
                            eVar9.getClass();
                            eVar9.a();
                            this.C = null;
                            this.A = 0;
                            this.f16874z = true;
                            a0 a0Var4 = this.B;
                            a0Var4.getClass();
                            this.C = ((d) eVar).a(a0Var4);
                            return;
                        }
                    }
                }
            }
        }
    }

    public final int x(a0 a0Var) {
        if (!((d) this.f16870v).b(a0Var)) {
            return a1.j(a0Var.f6276s) ? android.support.v4.media.h.c(1, 0, 0) : android.support.v4.media.h.c(0, 0, 0);
        }
        return android.support.v4.media.h.c(a0Var.N == 0 ? 4 : 2, 0, 0);
    }

    public final void z() {
        d dVar = new d(B(this.J), r1.f4658l);
        Handler handler = this.f16868t;
        if (handler != null) {
            handler.obtainMessage(0, dVar).sendToTarget();
        } else {
            C(dVar);
        }
    }
}
