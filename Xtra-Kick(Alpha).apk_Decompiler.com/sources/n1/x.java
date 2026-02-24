package n1;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.SparseArray;
import androidx.appcompat.widget.j3;
import androidx.fragment.app.g;
import d9.r0;
import d9.t0;
import g1.a2;
import g1.b2;
import g1.d1;
import g1.e1;
import g1.g1;
import g1.h;
import g1.h1;
import g1.j1;
import g1.k1;
import g1.q;
import g1.r1;
import g1.s0;
import g1.t1;
import g1.u1;
import g1.v0;
import g1.w0;
import g1.y1;
import g1.z0;
import i1.c;
import j1.a;
import j1.d;
import j1.d0;
import j1.f0;
import j1.l0;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import m1.p;
import v.e;
import v1.a0;
import v1.r;
import v1.w;

public final class x implements a {

    /* renamed from: h  reason: collision with root package name */
    public final d f10997h;

    /* renamed from: i  reason: collision with root package name */
    public final r1 f10998i;

    /* renamed from: j  reason: collision with root package name */
    public final t1 f10999j;

    /* renamed from: k  reason: collision with root package name */
    public final j3 f11000k;

    /* renamed from: l  reason: collision with root package name */
    public final SparseArray f11001l;

    /* renamed from: m  reason: collision with root package name */
    public e f11002m;

    /* renamed from: n  reason: collision with root package name */
    public k1 f11003n;

    /* renamed from: o  reason: collision with root package name */
    public f0 f11004o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f11005p;

    public x(d dVar) {
        dVar.getClass();
        this.f10997h = dVar;
        int i10 = l0.f8453a;
        Looper myLooper = Looper.myLooper();
        this.f11002m = new e(myLooper == null ? Looper.getMainLooper() : myLooper, dVar, new c(5));
        r1 r1Var = new r1();
        this.f10998i = r1Var;
        this.f10999j = new t1();
        this.f11000k = new j3(r1Var);
        this.f11001l = new SparseArray();
    }

    public final void A(float f10) {
        b c02 = c0();
        d0(c02, 22, new v(c02, f10));
    }

    public final void B(d1 d1Var) {
        b bVar;
        w0 w0Var;
        if (!(d1Var instanceof p) || (w0Var = ((p) d1Var).f10429u) == null) {
            bVar = b();
        } else {
            bVar = a0(new a0(w0Var));
        }
        d0(bVar, 10, new g(bVar, d1Var, 0));
    }

    public final void C(int i10, a0 a0Var) {
        b b02 = b0(i10, a0Var);
        d0(b02, 1025, new w(b02, 4));
    }

    public final void D(y1 y1Var) {
        b b10 = b();
        d0(b10, 19, new g(b10, 2, y1Var));
    }

    public final void E(int i10, a0 a0Var, int i11) {
        b b02 = b0(i10, a0Var);
        d0(b02, 1022, new p(b02, i11, 4));
    }

    public final void F(int i10) {
        b b10 = b();
        d0(b10, 4, new p(b10, i10, 3));
    }

    public final void G(long j10) {
        b b10 = b();
        d0(b10, 18, new j(b10, j10, 1));
    }

    public final void H(int i10, a0 a0Var, Exception exc) {
        b b02 = b0(i10, a0Var);
        d0(b02, 1024, new h3.j3(b02, exc, 3));
    }

    public final void I(int i10, a0 a0Var, r rVar, w wVar) {
        b b02 = b0(i10, a0Var);
        d0(b02, 1000, new m(b02, rVar, wVar, 0));
    }

    public final void J(int i10, a0 a0Var, r rVar, w wVar, IOException iOException, boolean z10) {
        b b02 = b0(i10, a0Var);
        d0(b02, 1003, new l(b02, rVar, wVar, iOException, z10));
    }

    public final void K(int i10, int i11) {
        b c02 = c0();
        d0(c02, 24, new k(c02, i10, i11));
    }

    public final void L(int i10, s0 s0Var) {
        b b10 = b();
        d0(b10, 1, new h((Object) b10, i10, (Object) s0Var));
    }

    public final void M(int i10, a0 a0Var, r rVar, w wVar) {
        b b02 = b0(i10, a0Var);
        d0(b02, 1001, new m(b02, rVar, wVar, 2));
    }

    public final void N(e1 e1Var) {
        b b10 = b();
        d0(b10, 12, new g(b10, 1, e1Var));
    }

    public final void O(g1 g1Var) {
        b b10 = b();
        d0(b10, 13, new g(b10, 3, g1Var));
    }

    public final void P(a2 a2Var) {
        b b10 = b();
        d0(b10, 2, new g(b10, 5, a2Var));
    }

    public final void Q(u1 u1Var, int i10) {
        k1 k1Var = this.f11003n;
        k1Var.getClass();
        j3 j3Var = this.f11000k;
        j3Var.f897d = j3.d(k1Var, (r0) j3Var.f895b, (a0) j3Var.f898e, (r1) j3Var.f894a);
        j3Var.i(k1Var.j0());
        b b10 = b();
        d0(b10, 0, new p(b10, i10, 2));
    }

    public final void R(i1.d dVar) {
        b b10 = b();
        d0(b10, 27, new g(b10, 9, dVar));
    }

    public final void S(z0 z0Var) {
        b b10 = b();
        d0(b10, 28, new g(b10, 8, z0Var));
    }

    public final void T(int i10, a0 a0Var) {
        b b02 = b0(i10, a0Var);
        d0(b02, 1026, new w(b02, 6));
    }

    public final void U(int i10, a0 a0Var) {
        b b02 = b0(i10, a0Var);
        d0(b02, 1023, new w(b02, 5));
    }

    public final void V(b2 b2Var) {
        b c02 = c0();
        d0(c02, 25, new g(c02, 11, b2Var));
    }

    public final /* synthetic */ void W() {
    }

    public final void X(q qVar) {
        b b10 = b();
        d0(b10, 29, new g(b10, 4, qVar));
    }

    public final void Y(boolean z10) {
        b b10 = b();
        d0(b10, 7, new q(1, b10, z10));
    }

    public final b Z(u1 u1Var, int i10, a0 a0Var) {
        a0 a0Var2;
        boolean z10;
        long j10;
        u1 u1Var2 = u1Var;
        int i11 = i10;
        if (u1Var.y()) {
            a0Var2 = null;
        } else {
            a0Var2 = a0Var;
        }
        ((d0) this.f10997h).getClass();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        boolean z11 = true;
        if (!u1Var2.equals(this.f11003n.j0()) || i11 != this.f11003n.U()) {
            z10 = false;
        } else {
            z10 = true;
        }
        long j11 = 0;
        if (a0Var2 != null && a0Var2.a()) {
            if (!(z10 && this.f11003n.T() == a0Var2.f6679b && this.f11003n.Z() == a0Var2.f6680c)) {
                z11 = false;
            }
            if (z11) {
                j11 = this.f11003n.j();
            }
        } else if (z10) {
            j10 = this.f11003n.t();
            return new b(elapsedRealtime, u1Var, i10, a0Var2, j10, this.f11003n.j0(), this.f11003n.U(), (a0) this.f11000k.f897d, this.f11003n.j(), this.f11003n.u());
        } else if (!u1Var.y()) {
            j11 = u1Var2.v(i11, this.f10999j).i();
        }
        j10 = j11;
        return new b(elapsedRealtime, u1Var, i10, a0Var2, j10, this.f11003n.j0(), this.f11003n.U(), (a0) this.f11000k.f897d, this.f11003n.j(), this.f11003n.u());
    }

    public final void a(int i10) {
        b b10 = b();
        d0(b10, 8, new p(b10, i10, 1));
    }

    public final b a0(a0 a0Var) {
        u1 u1Var;
        boolean z10;
        this.f11003n.getClass();
        if (a0Var == null) {
            u1Var = null;
        } else {
            u1Var = (u1) ((t0) this.f11000k.f896c).get(a0Var);
        }
        if (a0Var != null && u1Var != null) {
            return Z(u1Var, u1Var.p(a0Var.f6678a, this.f10998i).f6544j, a0Var);
        }
        int U = this.f11003n.U();
        u1 j02 = this.f11003n.j0();
        if (U < j02.x()) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            j02 = u1.f6622h;
        }
        return Z(j02, U, (a0) null);
    }

    public final b b() {
        return a0((a0) this.f11000k.f897d);
    }

    public final b b0(int i10, a0 a0Var) {
        this.f11003n.getClass();
        boolean z10 = false;
        if (a0Var != null) {
            if (((u1) ((t0) this.f11000k.f896c).get(a0Var)) != null) {
                z10 = true;
            }
            if (z10) {
                return a0(a0Var);
            }
            return Z(u1.f6622h, i10, a0Var);
        }
        u1 j02 = this.f11003n.j0();
        if (i10 < j02.x()) {
            z10 = true;
        }
        if (!z10) {
            j02 = u1.f6622h;
        }
        return Z(j02, i10, (a0) null);
    }

    public final void c(h hVar) {
        b c02 = c0();
        d0(c02, 20, new g(c02, 10, hVar));
    }

    public final b c0() {
        return a0((a0) this.f11000k.f899f);
    }

    public final void d(int i10, a0 a0Var, w wVar) {
        b b02 = b0(i10, a0Var);
        d0(b02, 1004, new s(b02, wVar, 1));
    }

    public final void d0(b bVar, int i10, j1.q qVar) {
        this.f11001l.put(i10, bVar);
        this.f11002m.m(i10, qVar);
    }

    public final void e(v0 v0Var) {
        b b10 = b();
        d0(b10, 15, new i(b10, v0Var, 1));
    }

    public final void e0(k1 k1Var, Looper looper) {
        boolean z10;
        if (this.f11003n == null || ((r0) this.f11000k.f895b).isEmpty()) {
            z10 = true;
        } else {
            z10 = false;
        }
        a.e(z10);
        this.f11003n = k1Var;
        this.f11004o = ((d0) this.f10997h).a(looper, (Handler.Callback) null);
        e eVar = this.f11002m;
        g gVar = new g(this, 6, k1Var);
        this.f11002m = new e((CopyOnWriteArraySet) eVar.f15504f, looper, (d) eVar.f15501c, gVar);
    }

    public final void f(boolean z10) {
        b b10 = b();
        d0(b10, 9, new q(2, b10, z10));
    }

    public final void g(int i10, boolean z10) {
        b b10 = b();
        d0(b10, 30, new t(i10, b10, z10));
    }

    public final void h(int i10) {
        b b10 = b();
        d0(b10, 6, new p(b10, i10, 0));
    }

    public final void i(long j10) {
        b b10 = b();
        d0(b10, 16, new j(b10, j10, 3));
    }

    public final void j(boolean z10) {
    }

    public final void k(int i10) {
    }

    public final void l(k1 k1Var, h1 h1Var) {
    }

    public final void m(long j10) {
        b b10 = b();
        d0(b10, 17, new j(b10, j10, 2));
    }

    public final void n(int i10, j1 j1Var, j1 j1Var2) {
        if (i10 == 1) {
            this.f11005p = false;
        }
        k1 k1Var = this.f11003n;
        k1Var.getClass();
        j3 j3Var = this.f11000k;
        j3Var.f897d = j3.d(k1Var, (r0) j3Var.f895b, (a0) j3Var.f898e, (r1) j3Var.f894a);
        b b10 = b();
        d0(b10, 11, new d(i10, j1Var, j1Var2, b10));
    }

    public final void o(int i10, a0 a0Var, w wVar) {
        b b02 = b0(i10, a0Var);
        d0(b02, 1005, new s(b02, wVar, 0));
    }

    public final void p(int i10, a0 a0Var) {
        b b02 = b0(i10, a0Var);
        d0(b02, 1027, new w(b02, 2));
    }

    public final void q(boolean z10) {
        b b10 = b();
        d0(b10, 3, new q(0, b10, z10));
    }

    public final void r() {
    }

    public final void s() {
        b b10 = b();
        d0(b10, -1, new w(b10, 0));
    }

    public final void t(v0 v0Var) {
        b b10 = b();
        d0(b10, 14, new i(b10, v0Var, 0));
    }

    public final void u(d1 d1Var) {
        b bVar;
        w0 w0Var;
        if (!(d1Var instanceof p) || (w0Var = ((p) d1Var).f10429u) == null) {
            bVar = b();
        } else {
            bVar = a0(new a0(w0Var));
        }
        d0(bVar, 10, new g(bVar, d1Var, 1));
    }

    public final void v(boolean z10) {
        b c02 = c0();
        d0(c02, 23, new q(3, c02, z10));
    }

    public final void w(int i10, a0 a0Var, r rVar, w wVar) {
        b b02 = b0(i10, a0Var);
        d0(b02, 1002, new m(b02, rVar, wVar, 1));
    }

    public final void x(List list) {
        b b10 = b();
        d0(b10, 27, new g(b10, 7, list));
    }

    public final void y(int i10, boolean z10) {
        b b10 = b();
        d0(b10, -1, new t(b10, z10, i10, 0));
    }

    public final void z(int i10, boolean z10) {
        b b10 = b();
        d0(b10, 5, new t(b10, z10, i10, 2));
    }
}
