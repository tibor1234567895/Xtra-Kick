package android.support.v4.media.session;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import e1.c0;
import java.util.List;

public final class h0 extends e {

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f397d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ z f398e;

    public /* synthetic */ h0(z zVar, int i10) {
        this.f397d = i10;
        this.f398e = zVar;
    }

    private void U0(c cVar) {
        if (!((a0) this.f398e).f381e) {
            ((a0) this.f398e).f382f.register(cVar, new c0("android.media.session.MediaController", Binder.getCallingPid(), Binder.getCallingUid()));
            synchronized (((a0) this.f398e).f379c) {
                ((a0) this.f398e).getClass();
            }
        }
    }

    private void d1(c cVar) {
        ((a0) this.f398e).f382f.unregister(cVar);
        Binder.getCallingPid();
        Binder.getCallingUid();
        synchronized (((a0) this.f398e).f379c) {
            ((a0) this.f398e).getClass();
        }
    }

    public final int A() {
        int i10 = this.f397d;
        z zVar = this.f398e;
        switch (i10) {
            case 0:
                ((i0) zVar).getClass();
                return 0;
            default:
                return ((a0) zVar).f388l;
        }
    }

    public final void B0() {
        switch (this.f397d) {
            case 0:
                M0(16);
                return;
            default:
                throw new AssertionError();
        }
    }

    public final void C0() {
        switch (this.f397d) {
            case 0:
                ((i0) this.f398e).getClass();
                throw null;
            default:
                throw new AssertionError();
        }
    }

    public final long D0() {
        switch (this.f397d) {
            case 0:
                ((i0) this.f398e).getClass();
                throw null;
            default:
                throw new AssertionError();
        }
    }

    public final int E() {
        int i10 = this.f397d;
        z zVar = this.f398e;
        switch (i10) {
            case 0:
                ((i0) zVar).getClass();
                return 0;
            default:
                return ((a0) zVar).f386j;
        }
    }

    public final List E0() {
        switch (this.f397d) {
            case 0:
                ((i0) this.f398e).getClass();
                throw null;
            default:
                return null;
        }
    }

    public final ParcelableVolumeInfo F0() {
        switch (this.f397d) {
            case 0:
                ((i0) this.f398e).getClass();
                throw null;
            default:
                throw new AssertionError();
        }
    }

    public final boolean G() {
        int i10 = this.f397d;
        z zVar = this.f398e;
        switch (i10) {
            case 0:
                ((i0) zVar).getClass();
                return false;
            default:
                ((a0) zVar).getClass();
                return false;
        }
    }

    public final void G0() {
        switch (this.f397d) {
            case 0:
                M0(14);
                return;
            default:
                throw new AssertionError();
        }
    }

    public final void H0() {
        switch (this.f397d) {
            case 0:
                M0(12);
                return;
            default:
                throw new AssertionError();
        }
    }

    public final void I0() {
        switch (this.f397d) {
            case 0:
                M0(7);
                return;
            default:
                throw new AssertionError();
        }
    }

    public final void J0(Bundle bundle, String str) {
        switch (this.f397d) {
            case 0:
                O0(8, str, bundle);
                return;
            default:
                throw new AssertionError();
        }
    }

    public final void K0(Bundle bundle, String str) {
        switch (this.f397d) {
            case 0:
                O0(9, str, bundle);
                return;
            default:
                throw new AssertionError();
        }
    }

    public final void L0(Uri uri, Bundle bundle) {
        switch (this.f397d) {
            case 0:
                O0(10, uri, bundle);
                return;
            default:
                throw new AssertionError();
        }
    }

    public final void M0(int i10) {
        ((i0) this.f398e).d(i10, 0, 0, (Object) null, (Bundle) null);
    }

    public final void N0(int i10, Object obj) {
        ((i0) this.f398e).d(i10, 0, 0, obj, (Bundle) null);
    }

    public final void O0(int i10, Object obj, Bundle bundle) {
        ((i0) this.f398e).d(i10, 0, 0, obj, bundle);
    }

    public final void P0() {
        switch (this.f397d) {
            case 0:
                M0(3);
                return;
            default:
                throw new AssertionError();
        }
    }

    public final void Q0(Bundle bundle, String str) {
        switch (this.f397d) {
            case 0:
                O0(4, str, bundle);
                return;
            default:
                throw new AssertionError();
        }
    }

    public final void R0(Bundle bundle, String str) {
        switch (this.f397d) {
            case 0:
                O0(5, str, bundle);
                return;
            default:
                throw new AssertionError();
        }
    }

    public final void S0(Uri uri, Bundle bundle) {
        switch (this.f397d) {
            case 0:
                O0(6, uri, bundle);
                return;
            default:
                throw new AssertionError();
        }
    }

    public final void T(c cVar) {
        switch (this.f397d) {
            case 0:
                ((i0) this.f398e).getClass();
                throw null;
            default:
                d1(cVar);
                return;
        }
    }

    public final void T0() {
        switch (this.f397d) {
            case 0:
                M0(15);
                return;
            default:
                throw new AssertionError();
        }
    }

    public final void V0() {
        switch (this.f397d) {
            case 0:
                M0(17);
                return;
            default:
                throw new AssertionError();
        }
    }

    public final void W0(long j10) {
        switch (this.f397d) {
            case 0:
                N0(18, Long.valueOf(j10));
                return;
            default:
                throw new AssertionError();
        }
    }

    public final void X0(Bundle bundle, String str) {
        switch (this.f397d) {
            case 0:
                O0(20, str, bundle);
                return;
            default:
                throw new AssertionError();
        }
    }

    public final void Y0(float f10) {
        switch (this.f397d) {
            case 0:
                N0(32, Float.valueOf(f10));
                return;
            default:
                throw new AssertionError();
        }
    }

    public final void Z0(int i10) {
        switch (this.f397d) {
            case 0:
                ((i0) this.f398e).d(23, i10, 0, (Object) null, (Bundle) null);
                return;
            default:
                throw new AssertionError();
        }
    }

    public final void a1(int i10) {
        switch (this.f397d) {
            case 0:
                ((i0) this.f398e).d(30, i10, 0, (Object) null, (Bundle) null);
                return;
            default:
                throw new AssertionError();
        }
    }

    public final PlaybackStateCompat b() {
        switch (this.f397d) {
            case 0:
                ((i0) this.f398e).getClass();
                throw null;
            default:
                a0 a0Var = (a0) this.f398e;
                return u.A(a0Var.f383g, a0Var.f385i);
        }
    }

    public final void b1(long j10) {
        switch (this.f397d) {
            case 0:
                N0(11, Long.valueOf(j10));
                return;
            default:
                throw new AssertionError();
        }
    }

    public final void c1() {
        switch (this.f397d) {
            case 0:
                M0(13);
                return;
            default:
                throw new AssertionError();
        }
    }

    public final int h() {
        int i10 = this.f397d;
        z zVar = this.f398e;
        switch (i10) {
            case 0:
                ((i0) zVar).getClass();
                return 0;
            default:
                return ((a0) zVar).f387k;
        }
    }

    public final void m(c cVar) {
        switch (this.f397d) {
            case 0:
                ((i0) this.f398e).getClass();
                Binder.getCallingPid();
                Binder.getCallingUid();
                ((i0) this.f398e).getClass();
                throw null;
            default:
                U0(cVar);
                return;
        }
    }
}
