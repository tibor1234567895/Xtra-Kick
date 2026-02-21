package t1;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.media.h;
import g1.a0;
import g1.u0;
import g1.v0;
import g1.y0;
import g1.z0;
import j1.l0;
import j2.a;
import j2.b;
import java.util.ArrayList;
import m1.f;
import m1.k0;
import m1.n0;
import m1.w0;
import v.e;

public final class c extends f implements Handler.Callback {
    public long A;
    public z0 B;
    public long C;

    /* renamed from: t  reason: collision with root package name */
    public final b f14486t;

    /* renamed from: u  reason: collision with root package name */
    public final k0 f14487u;

    /* renamed from: v  reason: collision with root package name */
    public final Handler f14488v;

    /* renamed from: w  reason: collision with root package name */
    public final a f14489w;

    /* renamed from: x  reason: collision with root package name */
    public b f14490x;

    /* renamed from: y  reason: collision with root package name */
    public boolean f14491y;

    /* renamed from: z  reason: collision with root package name */
    public boolean f14492z;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(k0 k0Var, Looper looper) {
        super(5);
        Handler handler;
        a aVar = b.f14485a;
        this.f14487u = k0Var;
        if (looper == null) {
            handler = null;
        } else {
            int i10 = l0.f8453a;
            handler = new Handler(looper, this);
        }
        this.f14488v = handler;
        aVar.getClass();
        this.f14486t = aVar;
        this.f14489w = new a();
        this.C = -9223372036854775807L;
    }

    public final long A(long j10) {
        boolean z10 = true;
        j1.a.e(j10 != -9223372036854775807L);
        if (this.C == -9223372036854775807L) {
            z10 = false;
        }
        j1.a.e(z10);
        return j10 - this.C;
    }

    public final void B(z0 z0Var) {
        k0 k0Var = this.f14487u;
        n0 n0Var = k0Var.f10314h;
        v0 v0Var = n0Var.f10381h0;
        v0Var.getClass();
        u0 u0Var = new u0(v0Var);
        int i10 = 0;
        while (true) {
            y0[] y0VarArr = z0Var.f6770h;
            if (i10 >= y0VarArr.length) {
                break;
            }
            y0VarArr[i10].h(u0Var);
            i10++;
        }
        n0Var.f10381h0 = new v0(u0Var);
        v0 X0 = n0Var.X0();
        boolean equals = X0.equals(n0Var.N);
        e eVar = n0Var.f10388l;
        if (!equals) {
            n0Var.N = X0;
            eVar.j(14, new p0.c(2, k0Var));
        }
        eVar.j(28, new p0.c(3, z0Var));
        eVar.g();
    }

    public final String g() {
        return "MetadataRenderer";
    }

    public final boolean handleMessage(Message message) {
        if (message.what == 0) {
            B((z0) message.obj);
            return true;
        }
        throw new IllegalStateException();
    }

    public final boolean j() {
        return this.f14492z;
    }

    public final boolean k() {
        return true;
    }

    public final void l() {
        this.B = null;
        this.f14490x = null;
        this.C = -9223372036854775807L;
    }

    public final void n(long j10, boolean z10) {
        this.B = null;
        this.f14491y = false;
        this.f14492z = false;
    }

    public final void r(a0[] a0VarArr, long j10, long j11) {
        this.f14490x = ((a) this.f14486t).a(a0VarArr[0]);
        z0 z0Var = this.B;
        if (z0Var != null) {
            long j12 = this.C;
            long j13 = z0Var.f6771i;
            long j14 = (j12 + j13) - j11;
            if (j13 != j14) {
                z0Var = new z0(j14, z0Var.f6770h);
            }
            this.B = z0Var;
        }
        this.C = j11;
    }

    public final void t(long j10, long j11) {
        boolean z10 = true;
        while (z10) {
            if (!this.f14491y && this.B == null) {
                a aVar = this.f14489w;
                aVar.h();
                w0 w0Var = this.f10217i;
                w0Var.a();
                int s10 = s(w0Var, aVar, 0);
                if (s10 == -4) {
                    if (aVar.f(4)) {
                        this.f14491y = true;
                    } else {
                        aVar.f8487p = this.A;
                        aVar.k();
                        b bVar = this.f14490x;
                        int i10 = l0.f8453a;
                        z0 a10 = bVar.a(aVar);
                        if (a10 != null) {
                            ArrayList arrayList = new ArrayList(a10.f6770h.length);
                            z(a10, arrayList);
                            if (!arrayList.isEmpty()) {
                                this.B = new z0(A(aVar.f9517l), (y0[]) arrayList.toArray(new y0[0]));
                            }
                        }
                    }
                } else if (s10 == -5) {
                    a0 a0Var = w0Var.f10523b;
                    a0Var.getClass();
                    this.A = a0Var.f6280w;
                }
            }
            z0 z0Var = this.B;
            if (z0Var == null || z0Var.f6771i > A(j10)) {
                z10 = false;
            } else {
                z0 z0Var2 = this.B;
                Handler handler = this.f14488v;
                if (handler != null) {
                    handler.obtainMessage(0, z0Var2).sendToTarget();
                } else {
                    B(z0Var2);
                }
                this.B = null;
                z10 = true;
            }
            if (this.f14491y && this.B == null) {
                this.f14492z = true;
            }
        }
    }

    public final int x(a0 a0Var) {
        if (!((a) this.f14486t).b(a0Var)) {
            return h.c(0, 0, 0);
        }
        return h.c(a0Var.N == 0 ? 4 : 2, 0, 0);
    }

    public final void z(z0 z0Var, ArrayList arrayList) {
        int i10 = 0;
        while (true) {
            y0[] y0VarArr = z0Var.f6770h;
            if (i10 < y0VarArr.length) {
                a0 g10 = y0VarArr[i10].g();
                if (g10 != null) {
                    a aVar = (a) this.f14486t;
                    if (aVar.b(g10)) {
                        b a10 = aVar.a(g10);
                        byte[] r10 = y0VarArr[i10].r();
                        r10.getClass();
                        a aVar2 = this.f14489w;
                        aVar2.h();
                        aVar2.j(r10.length);
                        aVar2.f9515j.put(r10);
                        aVar2.k();
                        z0 a11 = a10.a(aVar2);
                        if (a11 != null) {
                            z(a11, arrayList);
                        }
                        i10++;
                    }
                }
                arrayList.add(y0VarArr[i10]);
                i10++;
            } else {
                return;
            }
        }
    }
}
