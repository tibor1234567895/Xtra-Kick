package h3;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.Surface;
import d9.i0;
import d9.i2;
import d9.o0;
import d9.q1;
import d9.r0;
import e1.d0;
import g1.a2;
import g1.e1;
import g1.s0;
import g1.v0;
import g1.v1;
import g1.w1;
import g1.x1;
import g1.y1;
import g1.z1;
import h9.a0;
import h9.e0;
import h9.k0;
import h9.q;
import j1.a;
import j1.h;
import j1.l0;
import j1.v;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import m1.g0;
import m1.w;
import m1.y;
import n1.k;
import p0.c;
import v1.c0;

public final class s3 extends q {

    /* renamed from: j  reason: collision with root package name */
    public static final /* synthetic */ int f7316j = 0;

    /* renamed from: d  reason: collision with root package name */
    public final WeakReference f7317d;

    /* renamed from: e  reason: collision with root package name */
    public final d0 f7318e;

    /* renamed from: f  reason: collision with root package name */
    public final g f7319f;

    /* renamed from: g  reason: collision with root package name */
    public final Set f7320g = Collections.synchronizedSet(new HashSet());

    /* renamed from: h  reason: collision with root package name */
    public q1 f7321h = q1.f4650p;

    /* renamed from: i  reason: collision with root package name */
    public int f7322i;

    public s3(n2 n2Var) {
        this.f7317d = new WeakReference(n2Var);
        this.f7318e = d0.a(n2Var.f7232e);
        this.f7319f = new g(n2Var);
    }

    public static e0 E0(n2 n2Var, e2 e2Var, int i10, r3 r3Var, f3 f3Var) {
        if (n2Var.f()) {
            return a0.f7718i;
        }
        e0 e0Var = (e0) r3Var.h(n2Var, e2Var, i10);
        k0 n10 = k0.n();
        e0Var.a(new c0(n2Var, n10, f3Var, e0Var, 5), q.f7765h);
        return n10;
    }

    public static l3 H0(r3 r3Var) {
        return new l3(r3Var, 1);
    }

    public static void I0(e2 e2Var, int i10, j4 j4Var) {
        try {
            d2 d2Var = e2Var.f6998c;
            a.f(d2Var);
            d2Var.t(i10, j4Var);
        } catch (RemoteException e10) {
            v.h("MediaSessionStub", "Failed to send result to controller " + e2Var, e10);
        }
    }

    public static c J0(h hVar) {
        return new c(21, new c(22, hVar));
    }

    public static l3 K0(r3 r3Var) {
        return new l3(r3Var, 0);
    }

    public final void A0(o oVar, int i10, int i11, String str, int i12, int i13) {
        e1.c0 c0Var = new e1.c0(str, i12, i13);
        e2 e2Var = new e2(c0Var, i11, this.f7318e.b(c0Var), new n3(oVar));
        n2 n2Var = (n2) this.f7317d.get();
        if (n2Var == null || n2Var.f()) {
            try {
                oVar.g(0);
            } catch (RemoteException unused) {
            }
        } else {
            this.f7320g.add(e2Var);
            l0.L(n2Var.f7239l, new c0(this, e2Var, n2Var, oVar, 4));
        }
    }

    public final void B(o oVar, int i10) {
        if (oVar != null) {
            G0(oVar, i10, 6, J0(new f3.a(28)));
        }
    }

    public final void B0(o oVar, int i10, int i11, l3 l3Var) {
        C0(oVar, i10, (f4) null, i11, l3Var);
    }

    public final void C(o oVar, int i10) {
        if (oVar != null) {
            G0(oVar, i10, 1, J0(new c(19, this)));
        }
    }

    public final void C0(o oVar, int i10, f4 f4Var, int i11, l3 l3Var) {
        long clearCallingIdentity = Binder.clearCallingIdentity();
        try {
            n2 n2Var = (n2) this.f7317d.get();
            if (n2Var != null) {
                if (!n2Var.f()) {
                    e2 e10 = this.f7319f.e(oVar.asBinder());
                    if (e10 == null) {
                        Binder.restoreCallingIdentity(clearCallingIdentity);
                        return;
                    }
                    l0.L(n2Var.f7239l, new e3(this, e10, f4Var, i10, i11, l3Var, n2Var));
                    Binder.restoreCallingIdentity(clearCallingIdentity);
                }
            }
        } finally {
            Binder.restoreCallingIdentity(clearCallingIdentity);
        }
    }

    public final void D(o oVar, int i10) {
        if (oVar != null) {
            G0(oVar, i10, 4, J0(new f3.a(29)));
        }
    }

    public final w3 D0(w3 w3Var) {
        r0 r0Var = w3Var.J.f6289h;
        o0 o0Var = new o0();
        i0 i0Var = new i0();
        for (int i10 = 0; i10 < r0Var.size(); i10++) {
            z1 z1Var = (z1) r0Var.get(i10);
            v1 v1Var = z1Var.f6778i;
            String str = (String) this.f7321h.get(v1Var);
            if (str == null) {
                StringBuilder sb2 = new StringBuilder();
                int i11 = this.f7322i;
                this.f7322i = i11 + 1;
                sb2.append(l0.C(i11));
                sb2.append("-");
                sb2.append(v1Var.f6674i);
                str = sb2.toString();
            }
            i0Var.f(v1Var, str);
            o0Var.c(new z1(new v1(str, z1Var.f6778i.f6676k), z1Var.f6779j, z1Var.f6780k, z1Var.f6781l));
        }
        this.f7321h = i0Var.a();
        a2 a2Var = new a2(o0Var.e());
        u3 u3Var = new u3(w3Var);
        u3Var.C = a2Var;
        w3 a10 = u3Var.a();
        y1 y1Var = a10.K;
        if (y1Var.F.isEmpty()) {
            return a10;
        }
        x1 c10 = y1Var.i().c();
        i2 g10 = y1Var.F.values().iterator();
        while (g10.hasNext()) {
            w1 w1Var = (w1) g10.next();
            v1 v1Var2 = w1Var.f6686h;
            String str2 = (String) this.f7321h.get(v1Var2);
            if (str2 != null) {
                c10.a(new w1(new v1(str2, v1Var2.f6676k), (List) w1Var.f6687i));
            } else {
                c10.a(w1Var);
            }
        }
        y1 b10 = c10.b();
        u3 u3Var2 = new u3(a10);
        u3Var2.D = b10;
        return u3Var2.a();
    }

    public final int F0(int i10, e2 e2Var, a4 a4Var) {
        if (a4Var.L0(17)) {
            g gVar = this.f7319f;
            if (!gVar.h(17, e2Var) && gVar.h(16, e2Var)) {
                return a4Var.U() + i10;
            }
        }
        return i10;
    }

    public final void G0(o oVar, int i10, int i11, r3 r3Var) {
        long clearCallingIdentity = Binder.clearCallingIdentity();
        try {
            n2 n2Var = (n2) this.f7317d.get();
            if (n2Var != null) {
                if (!n2Var.f()) {
                    e2 e10 = this.f7319f.e(oVar.asBinder());
                    if (e10 == null) {
                        Binder.restoreCallingIdentity(clearCallingIdentity);
                        return;
                    }
                    l0.L(n2Var.f7239l, new m3(this, e10, i11, i10, n2Var, r3Var));
                    Binder.restoreCallingIdentity(clearCallingIdentity);
                }
            }
        } finally {
            Binder.restoreCallingIdentity(clearCallingIdentity);
        }
    }

    public final void H(o oVar, int i10, Bundle bundle, long j10) {
        if (oVar != null && bundle != null) {
            try {
                G0(oVar, i10, 31, K0(new d3(new t0(j10, (s0) s0.f6555t.e(bundle)), 3, new j3(5))));
            } catch (RuntimeException e10) {
                v.h("MediaSessionStub", "Ignoring malformed Bundle for MediaItem", e10);
            }
        }
    }

    public final void K(o oVar, int i10, Bundle bundle) {
        if (oVar != null && bundle != null) {
            G0(oVar, i10, 13, J0(new o0(3, (e1) e1.f6354n.e(bundle))));
        }
    }

    public final void L(o oVar, int i10) {
        if (oVar != null) {
            G0(oVar, i10, 1, J0(new j3(1)));
        }
    }

    public final void O(o oVar, int i10, Bundle bundle, boolean z10) {
        if (oVar != null && bundle != null) {
            try {
                G0(oVar, i10, 31, K0(new d3(new h1(1, (s0) s0.f6555t.e(bundle), z10), 3, new f3.a(22))));
            } catch (RuntimeException e10) {
                v.h("MediaSessionStub", "Ignoring malformed Bundle for MediaItem", e10);
            }
        }
    }

    public final void P(o oVar, int i10, long j10) {
        if (oVar != null) {
            G0(oVar, i10, 5, J0(new k2(j10)));
        }
    }

    public final void R(o oVar, int i10, int i11) {
        if (oVar != null) {
            G0(oVar, i10, 10, new c(21, new h3(this, i11, 0)));
        }
    }

    public final void S(o oVar, int i10) {
        if (oVar != null) {
            G0(oVar, i10, 26, J0(new f3.a(26)));
        }
    }

    public final void V(o oVar, int i10, Bundle bundle) {
        e4 e4Var;
        f fVar;
        if (oVar != null && bundle != null) {
            try {
                j4 j4Var = (j4) j4.f7142n.e(bundle);
                long clearCallingIdentity = Binder.clearCallingIdentity();
                try {
                    g gVar = this.f7319f;
                    IBinder asBinder = oVar.asBinder();
                    synchronized (gVar.f7037a) {
                        e2 e10 = gVar.e(asBinder);
                        e4Var = null;
                        if (e10 != null) {
                            fVar = (f) gVar.f7039c.getOrDefault(e10, (Object) null);
                        } else {
                            fVar = null;
                        }
                    }
                    if (fVar != null) {
                        e4Var = fVar.f7013b;
                    }
                    if (e4Var == null) {
                        Binder.restoreCallingIdentity(clearCallingIdentity);
                        return;
                    }
                    e4Var.c(i10, j4Var);
                    Binder.restoreCallingIdentity(clearCallingIdentity);
                } catch (Throwable th) {
                    Binder.restoreCallingIdentity(clearCallingIdentity);
                    throw th;
                }
            } catch (RuntimeException e11) {
                v.h("MediaSessionStub", "Ignoring malformed Bundle for SessionResult", e11);
            }
        }
    }

    public final void W(o oVar) {
        if (oVar != null) {
            long clearCallingIdentity = Binder.clearCallingIdentity();
            try {
                n2 n2Var = (n2) this.f7317d.get();
                if (n2Var != null) {
                    if (!n2Var.f()) {
                        e2 e10 = this.f7319f.e(oVar.asBinder());
                        if (e10 != null) {
                            l0.L(n2Var.f7239l, new g.r0(this, 28, e10));
                        }
                        Binder.restoreCallingIdentity(clearCallingIdentity);
                    }
                }
            } finally {
                Binder.restoreCallingIdentity(clearCallingIdentity);
            }
        }
    }

    public final void X(o oVar, int i10) {
        if (oVar != null) {
            G0(oVar, i10, 2, J0(new j3(6)));
        }
    }

    public final void Y(o oVar, int i10) {
        if (oVar != null) {
            G0(oVar, i10, 12, J0(new j3(0)));
        }
    }

    public final void Z(o oVar, int i10, int i11) {
        if (oVar != null) {
            G0(oVar, i10, 15, J0(new m1.e0(i11, 6)));
        }
    }

    public final void c(o oVar, int i10, int i11) {
        if (oVar != null) {
            G0(oVar, i10, 20, new c(21, new h3(this, i11, 2)));
        }
    }

    public final void c0(o oVar, int i10, boolean z10) {
        if (oVar != null) {
            G0(oVar, i10, 26, J0(new w(8, z10)));
        }
    }

    public final void f(o oVar, int i10) {
        if (oVar != null) {
            G0(oVar, i10, 20, J0(new f3.a(23)));
        }
    }

    public final void h0(o oVar, int i10, int i11, int i12) {
        if (oVar != null) {
            G0(oVar, i10, 20, new c(21, new k(this, i11, i12)));
        }
    }

    public final void i(o oVar, int i10) {
        if (oVar != null) {
            G0(oVar, i10, 7, J0(new j3(3)));
        }
    }

    public final void i0(o oVar, int i10, IBinder iBinder) {
        if (oVar != null && iBinder != null) {
            try {
                G0(oVar, i10, 20, K0(new d3(new g0(j1.c.a(s0.f6555t, g1.k.a(iBinder)), 1), 2, new f3.a(21))));
            } catch (RuntimeException e10) {
                v.h("MediaSessionStub", "Ignoring malformed Bundle for MediaItem", e10);
            }
        }
    }

    public final void j(o oVar, int i10) {
        if (oVar != null) {
            G0(oVar, i10, 8, J0(new f3.a(20)));
        }
    }

    public final void j0(o oVar, int i10) {
        if (oVar != null) {
            G0(oVar, i10, 11, J0(new j3(4)));
        }
    }

    public final void k0(o oVar, int i10, int i11, int i12) {
        if (oVar != null) {
            G0(oVar, i10, 20, J0(new y(i11, i12, 2)));
        }
    }

    public final void l(o oVar, int i10, int i11, int i12, int i13) {
        if (oVar != null) {
            G0(oVar, i10, 20, J0(new i3(i11, i12, i13)));
        }
    }

    public final void l0(o oVar, int i10) {
        if (oVar != null) {
            G0(oVar, i10, 26, J0(new f3.a(27)));
        }
    }

    public final void o(o oVar, int i10, IBinder iBinder, boolean z10) {
        if (oVar != null && iBinder != null) {
            try {
                G0(oVar, i10, 20, K0(new d3(new h1(2, j1.c.a(s0.f6555t, g1.k.a(iBinder)), z10), 3, new f3.a(24))));
            } catch (RuntimeException e10) {
                v.h("MediaSessionStub", "Ignoring malformed Bundle for MediaItem", e10);
            }
        }
    }

    public final void p(o oVar, int i10, float f10) {
        if (oVar != null) {
            G0(oVar, i10, 13, J0(new m1.d0(4, f10)));
        }
    }

    public final void p0(o oVar, int i10, float f10) {
        if (oVar != null) {
            G0(oVar, i10, 24, J0(new m1.d0(3, f10)));
        }
    }

    public final void q0(o oVar, int i10) {
        if (oVar != null) {
            long clearCallingIdentity = Binder.clearCallingIdentity();
            try {
                n2 n2Var = (n2) this.f7317d.get();
                if (n2Var != null) {
                    if (!n2Var.f()) {
                        l0.L(n2Var.f7239l, new g.r0(this, 27, oVar));
                        Binder.restoreCallingIdentity(clearCallingIdentity);
                    }
                }
            } finally {
                Binder.restoreCallingIdentity(clearCallingIdentity);
            }
        }
    }

    public final void r0(o oVar, int i10, IBinder iBinder, int i11, long j10) {
        if (oVar != null && iBinder != null) {
            try {
                G0(oVar, i10, 20, K0(new d3(new g0(i11, j10, j1.c.a(s0.f6555t, g1.k.a(iBinder))), 3, new j3(8))));
            } catch (RuntimeException e10) {
                v.h("MediaSessionStub", "Ignoring malformed Bundle for MediaItem", e10);
            }
        }
    }

    public final void s(o oVar, int i10, int i11, long j10) {
        if (oVar != null) {
            G0(oVar, i10, 10, new c(21, new g0(i11, j10, this)));
        }
    }

    public final void s0(o oVar, int i10, Bundle bundle) {
        if (oVar != null && bundle != null) {
            try {
                G0(oVar, i10, 19, J0(new m1.c0(4, (v0) v0.f6650x0.e(bundle))));
            } catch (RuntimeException e10) {
                v.h("MediaSessionStub", "Ignoring malformed Bundle for MediaMetadata", e10);
            }
        }
    }

    public final void t(o oVar, int i10, Bundle bundle, Bundle bundle2) {
        if (oVar != null && bundle != null && bundle2 != null) {
            try {
                f4 f4Var = (f4) f4.f7033o.e(bundle);
                C0(oVar, i10, f4Var, 0, K0(new d3(f4Var, 1, bundle2)));
            } catch (RuntimeException e10) {
                v.h("MediaSessionStub", "Ignoring malformed Bundle for SessionCommand", e10);
            }
        }
    }

    public final void t0(o oVar, int i10, Bundle bundle) {
        if (oVar != null) {
            try {
                y1 y1Var = y1.H;
                G0(oVar, i10, 29, J0(new d3(this, 0, new y1(new x1(bundle)))));
            } catch (RuntimeException e10) {
                v.h("MediaSessionStub", "Ignoring malformed Bundle for TrackSelectionParameters", e10);
            }
        }
    }

    public final void u(o oVar, int i10, int i11, IBinder iBinder) {
        if (oVar != null && iBinder != null) {
            try {
                G0(oVar, i10, 20, K0(new d3(new g0(j1.c.a(s0.f6555t, g1.k.a(iBinder)), 2), 2, new h3(this, i11, 1))));
            } catch (RuntimeException e10) {
                v.h("MediaSessionStub", "Ignoring malformed Bundle for MediaItem", e10);
            }
        }
    }

    public final void u0(o oVar, int i10, int i11) {
        if (oVar != null) {
            G0(oVar, i10, 25, J0(new m1.e0(i11, 5)));
        }
    }

    public final void v(o oVar, int i10, boolean z10) {
        if (oVar != null) {
            G0(oVar, i10, 14, J0(new w(6, z10)));
        }
    }

    public final void w(o1 o1Var, int i10, Bundle bundle) {
        O(o1Var, i10, bundle, true);
    }

    public final void w0(o oVar, int i10) {
        if (oVar != null) {
            G0(oVar, i10, 9, J0(new f3.a(25)));
        }
    }

    public final void x(o oVar, int i10, Bundle bundle) {
        if (oVar != null && bundle != null) {
            try {
                h hVar = (h) h.f7058r.e(bundle);
                int callingUid = Binder.getCallingUid();
                int callingPid = Binder.getCallingPid();
                long clearCallingIdentity = Binder.clearCallingIdentity();
                if (callingPid == 0) {
                    callingPid = hVar.f7062k;
                }
                try {
                    A0(oVar, hVar.f7059h, hVar.f7060i, hVar.f7061j, callingPid, callingUid);
                } finally {
                    Binder.restoreCallingIdentity(clearCallingIdentity);
                }
            } catch (RuntimeException e10) {
                v.h("MediaSessionStub", "Ignoring malformed Bundle for ConnectionRequest", e10);
            }
        }
    }

    public final void y(o oVar, int i10) {
        if (oVar != null) {
            G0(oVar, i10, 3, J0(new j3(2)));
        }
    }

    public final void y0(o oVar, int i10, Surface surface) {
        if (oVar != null) {
            G0(oVar, i10, 27, J0(new c(18, surface)));
        }
    }

    public final void z(o oVar, int i10, boolean z10) {
        if (oVar != null) {
            G0(oVar, i10, 1, J0(new w(7, z10)));
        }
    }
}
