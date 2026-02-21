package h3;

import android.os.Binder;
import android.os.Bundle;
import androidx.fragment.app.g;
import d0.o;
import f3.a;
import g.r0;
import g1.g1;
import g1.m;
import j1.l0;
import j1.v;
import java.lang.ref.WeakReference;
import p0.c;

public final class o1 extends n {

    /* renamed from: e  reason: collision with root package name */
    public static final /* synthetic */ int f7265e = 0;

    /* renamed from: d  reason: collision with root package name */
    public final WeakReference f7266d;

    public o1(y0 y0Var) {
        this.f7266d = new WeakReference(y0Var);
    }

    public final void B0(n1 n1Var) {
        long clearCallingIdentity = Binder.clearCallingIdentity();
        try {
            y0 y0Var = (y0) this.f7266d.get();
            if (y0Var != null) {
                l0.L(y0Var.f7453a.f6926e, new r0(y0Var, 22, n1Var));
                Binder.restoreCallingIdentity(clearCallingIdentity);
            }
        } finally {
            Binder.restoreCallingIdentity(clearCallingIdentity);
        }
    }

    public final void C0(int i10, m mVar) {
        long clearCallingIdentity = Binder.clearCallingIdentity();
        try {
            y0 y0Var = (y0) this.f7266d.get();
            if (y0Var != null) {
                y0Var.f7454b.c(i10, mVar);
                y0Var.f7453a.S0(new o(y0Var, i10, 2));
                Binder.restoreCallingIdentity(clearCallingIdentity);
            }
        } finally {
            Binder.restoreCallingIdentity(clearCallingIdentity);
        }
    }

    public final void Q(int i10, Bundle bundle) {
        try {
            B0(new c(11, (i) i.f7088z.e(bundle)));
        } catch (RuntimeException e10) {
            v.h("MediaControllerStub", "Malformed Bundle for ConnectionResult. Disconnected from the session.", e10);
            g(i10);
        }
    }

    public final void a0(int i10, Bundle bundle) {
        try {
            B0(new m1((g1) g1.f6384k.e(bundle)));
        } catch (RuntimeException e10) {
            v.h("MediaControllerStub", "Ignoring malformed Bundle for Commands", e10);
        }
    }

    public final void d(int i10) {
        B0(new a(16));
    }

    public final void d0(int i10, Bundle bundle) {
        try {
            B0(new c(13, (i4) i4.D.e(bundle)));
        } catch (RuntimeException e10) {
            v.h("MediaControllerStub", "Ignoring malformed Bundle for SessionPositionInfo", e10);
        }
    }

    public final void e0(int i10, Bundle bundle, boolean z10) {
        n0(i10, bundle, new v3(z10, true).h());
    }

    public final void g(int i10) {
        B0(new a(17));
    }

    public final void k(int i10, Bundle bundle) {
        try {
            C0(i10, (v) v.f7371r.e(bundle));
        } catch (RuntimeException e10) {
            v.h("MediaControllerStub", "Ignoring malformed Bundle for LibraryResult", e10);
        }
    }

    public final void n0(int i10, Bundle bundle, Bundle bundle2) {
        try {
            try {
                B0(new g((w3) w3.f7411q0.e(bundle), 24, (v3) v3.f7387m.e(bundle2)));
            } catch (RuntimeException e10) {
                v.h("MediaControllerStub", "Ignoring malformed Bundle for BundlingExclusions", e10);
            }
        } catch (RuntimeException e11) {
            v.h("MediaControllerStub", "Ignoring malformed Bundle for PlayerInfo", e11);
        }
    }

    public final void v0(int i10, Bundle bundle) {
        try {
            C0(i10, (j4) j4.f7142n.e(bundle));
        } catch (RuntimeException e10) {
            v.h("MediaControllerStub", "Ignoring malformed Bundle for SessionResult", e10);
        }
    }
}
