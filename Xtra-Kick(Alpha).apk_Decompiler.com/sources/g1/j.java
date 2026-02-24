package g1;

import android.os.SystemClock;
import d9.r0;
import j1.l0;
import java.util.List;
import m1.n0;

public abstract class j implements k1 {

    /* renamed from: a  reason: collision with root package name */
    public final t1 f6413a = new t1();

    public final void A0() {
        n0 n0Var = (n0) this;
        n0Var.w1();
        U0(11, -n0Var.f10397u);
    }

    public final void B() {
        int P0 = P0();
        if (P0 != -1) {
            n0 n0Var = (n0) this;
            if (P0 == n0Var.U()) {
                R0(-9223372036854775807L, n0Var.U(), true);
            } else {
                T0(P0, 8);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0035, code lost:
        if (r1 <= 3000) goto L_0x0037;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void D0() {
        /*
            r6 = this;
            r0 = r6
            m1.n0 r0 = (m1.n0) r0
            g1.u1 r1 = r0.j0()
            boolean r1 = r1.y()
            if (r1 != 0) goto L_0x0040
            boolean r1 = r0.o()
            if (r1 == 0) goto L_0x0014
            goto L_0x0040
        L_0x0014:
            boolean r1 = r6.Y()
            boolean r2 = r6.O0()
            r3 = 7
            if (r2 == 0) goto L_0x0028
            boolean r2 = r6.I0()
            if (r2 != 0) goto L_0x0028
            if (r1 == 0) goto L_0x0040
            goto L_0x0037
        L_0x0028:
            if (r1 == 0) goto L_0x003b
            long r1 = r0.j()
            r0.F()
            r4 = 3000(0xbb8, double:1.482E-320)
            int r0 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r0 > 0) goto L_0x003b
        L_0x0037:
            r6.V0(r3)
            goto L_0x0040
        L_0x003b:
            r0 = 0
            r6.S0(r3, r0)
        L_0x0040:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: g1.j.D0():void");
    }

    public final int E() {
        n0 n0Var = (n0) this;
        long x10 = n0Var.x();
        long i02 = n0Var.i0();
        if (x10 == -9223372036854775807L || i02 == -9223372036854775807L) {
            return 0;
        }
        if (i02 == 0) {
            return 100;
        }
        return l0.h((int) ((x10 * 100) / i02), 0, 100);
    }

    public final void E0(float f10) {
        n0 n0Var = (n0) this;
        n0Var.d(new e1(f10, n0Var.i().f6356i));
    }

    public final boolean G() {
        return P0() != -1;
    }

    public final Object H0() {
        n0 n0Var = (n0) this;
        u1 j02 = n0Var.j0();
        if (j02.y()) {
            return null;
        }
        return j02.v(n0Var.U(), this.f6413a).f6578k;
    }

    public final boolean I() {
        n0 n0Var = (n0) this;
        return n0Var.b() == 3 && n0Var.y() && n0Var.f0() == 0;
    }

    public final boolean I0() {
        n0 n0Var = (n0) this;
        u1 j02 = n0Var.j0();
        return !j02.y() && j02.v(n0Var.U(), this.f6413a).f6582o;
    }

    public final long J() {
        n0 n0Var = (n0) this;
        u1 j02 = n0Var.j0();
        if (j02.y()) {
            return -9223372036854775807L;
        }
        return j02.v(n0Var.U(), this.f6413a).j();
    }

    public final s0 J0() {
        n0 n0Var = (n0) this;
        u1 j02 = n0Var.j0();
        if (j02.y()) {
            return null;
        }
        return j02.v(n0Var.U(), this.f6413a).f6577j;
    }

    public final boolean L0(int i10) {
        n0 n0Var = (n0) this;
        n0Var.w1();
        return n0Var.M.i(i10);
    }

    public final boolean M0() {
        n0 n0Var = (n0) this;
        u1 j02 = n0Var.j0();
        return !j02.y() && j02.v(n0Var.U(), this.f6413a).f6583p;
    }

    public final void O() {
        V0(6);
    }

    public final boolean O0() {
        n0 n0Var = (n0) this;
        u1 j02 = n0Var.j0();
        return !j02.y() && j02.v(n0Var.U(), this.f6413a).k();
    }

    public final void P() {
        ((n0) this).m(true);
    }

    public final int P0() {
        n0 n0Var = (n0) this;
        u1 j02 = n0Var.j0();
        if (j02.y()) {
            return -1;
        }
        int U = n0Var.U();
        n0Var.w1();
        int i10 = n0Var.F;
        if (i10 == 1) {
            i10 = 0;
        }
        n0Var.w1();
        return j02.n(U, i10, n0Var.G);
    }

    public final int Q0() {
        n0 n0Var = (n0) this;
        u1 j02 = n0Var.j0();
        if (j02.y()) {
            return -1;
        }
        int U = n0Var.U();
        n0Var.w1();
        int i10 = n0Var.F;
        if (i10 == 1) {
            i10 = 0;
        }
        n0Var.w1();
        return j02.t(U, i10, n0Var.G);
    }

    public final void R() {
        T0(((n0) this).U(), 4);
    }

    public abstract void R0(long j10, int i10, boolean z10);

    public final void S0(int i10, long j10) {
        R0(j10, ((n0) this).U(), false);
    }

    public final void T0(int i10, int i11) {
        R0(-9223372036854775807L, i10, false);
    }

    public final void U0(int i10, long j10) {
        n0 n0Var = (n0) this;
        long j11 = n0Var.j() + j10;
        long i02 = n0Var.i0();
        if (i02 != -9223372036854775807L) {
            j11 = Math.min(j11, i02);
        }
        S0(i10, Math.max(j11, 0));
    }

    public final void V0(int i10) {
        int Q0 = Q0();
        if (Q0 != -1) {
            n0 n0Var = (n0) this;
            if (Q0 == n0Var.U()) {
                R0(-9223372036854775807L, n0Var.U(), true);
            } else {
                T0(Q0, i10);
            }
        }
    }

    public final boolean Y() {
        return Q0() != -1;
    }

    public final void b0(s0 s0Var) {
        ((n0) this).C(r0.n(s0Var));
    }

    public final void d0(int i10, int i11) {
        if (i10 != i11) {
            ((n0) this).e0(i10, i10 + 1, i11);
        }
    }

    public final void g() {
        ((n0) this).m(false);
    }

    public final void g0(List list) {
        ((n0) this).F0(list, Integer.MAX_VALUE);
    }

    public final void h0(s0 s0Var) {
        ((n0) this).C(r0.n(s0Var));
    }

    public final void m0(int i10) {
        ((n0) this).s0(i10, i10 + 1);
    }

    public final void p(int i10) {
        T0(i10, 10);
    }

    public final void q0(long j10) {
        S0(5, j10);
    }

    public final long s() {
        long j10;
        n0 n0Var = (n0) this;
        u1 j02 = n0Var.j0();
        if (j02.y()) {
            return -9223372036854775807L;
        }
        int U = n0Var.U();
        t1 t1Var = this.f6413a;
        if (j02.v(U, t1Var).f6580m == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        long j11 = t1Var.f6581n;
        if (j11 == -9223372036854775807L) {
            j10 = System.currentTimeMillis();
        } else {
            j10 = j11 + SystemClock.elapsedRealtime();
        }
        return (j10 - t1Var.f6580m) - n0Var.t();
    }

    public final void u0() {
        n0 n0Var = (n0) this;
        if (!n0Var.j0().y() && !n0Var.o()) {
            if (G()) {
                int P0 = P0();
                if (P0 != -1) {
                    if (P0 == n0Var.U()) {
                        R0(-9223372036854775807L, n0Var.U(), true);
                    } else {
                        T0(P0, 9);
                    }
                }
            } else if (O0() && M0()) {
                T0(n0Var.U(), 9);
            }
        }
    }

    public final void v(int i10, long j10) {
        R0(j10, i10, false);
    }

    public final void v0() {
        n0 n0Var = (n0) this;
        n0Var.w1();
        U0(12, n0Var.f10398v);
    }

    public final void y0(s0 s0Var, long j10) {
        ((n0) this).K0(0, j10, r0.n(s0Var));
    }

    public final void z() {
        ((n0) this).s0(0, Integer.MAX_VALUE);
    }
}
