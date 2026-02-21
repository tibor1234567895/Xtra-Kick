package h3;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceView;
import android.view.TextureView;
import d9.r0;
import g1.a2;
import g1.b2;
import g1.d1;
import g1.e1;
import g1.g1;
import g1.i1;
import g1.k1;
import g1.q;
import g1.s0;
import g1.t1;
import g1.u1;
import g1.v0;
import g1.y1;
import h9.a0;
import h9.e0;
import i1.d;
import j1.a;
import j1.h;
import j1.l0;
import j1.v;
import java.util.List;
import p0.c;

public final class b0 implements k1 {

    /* renamed from: a  reason: collision with root package name */
    public final t1 f6922a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f6923b;

    /* renamed from: c  reason: collision with root package name */
    public final a0 f6924c;

    /* renamed from: d  reason: collision with root package name */
    public final z f6925d;

    /* renamed from: e  reason: collision with root package name */
    public final Handler f6926e;

    /* renamed from: f  reason: collision with root package name */
    public final long f6927f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f6928g;

    /* renamed from: h  reason: collision with root package name */
    public final y f6929h;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v1, resolved type: h3.l1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: h3.y0} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: h3.l1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: h3.l1} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public b0(android.content.Context r7, h3.l4 r8, android.os.Bundle r9, h3.z r10, android.os.Looper r11, h3.c0 r12, h3.a r13) {
        /*
            r6 = this;
            r6.<init>()
            if (r7 == 0) goto L_0x0051
            if (r8 == 0) goto L_0x0049
            g1.t1 r0 = new g1.t1
            r0.<init>()
            r6.f6922a = r0
            r0 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r6.f6927f = r0
            r6.f6925d = r10
            android.os.Handler r10 = new android.os.Handler
            r10.<init>(r11)
            r6.f6926e = r10
            r6.f6929h = r12
            h3.k4 r10 = r8.f7191h
            boolean r10 = r10.b()
            if (r10 == 0) goto L_0x0037
            h3.l1 r9 = new h3.l1
            r13.getClass()
            r0 = r9
            r1 = r7
            r2 = r6
            r3 = r8
            r4 = r11
            r5 = r13
            r0.<init>(r1, r2, r3, r4, r5)
            goto L_0x0043
        L_0x0037:
            h3.y0 r10 = new h3.y0
            r0 = r10
            r1 = r7
            r2 = r6
            r3 = r8
            r4 = r9
            r5 = r11
            r0.<init>(r1, r2, r3, r4, r5)
            r9 = r10
        L_0x0043:
            r6.f6924c = r9
            r9.K0()
            return
        L_0x0049:
            java.lang.NullPointerException r7 = new java.lang.NullPointerException
            java.lang.String r8 = "token must not be null"
            r7.<init>(r8)
            throw r7
        L_0x0051:
            java.lang.NullPointerException r7 = new java.lang.NullPointerException
            java.lang.String r8 = "context must not be null"
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: h3.b0.<init>(android.content.Context, h3.l4, android.os.Bundle, h3.z, android.os.Looper, h3.c0, h3.a):void");
    }

    public final void A(boolean z10) {
        U0();
        if (!P0()) {
            v.g("MediaController", "The controller is not connected. Ignoring setShuffleMode().");
        } else {
            this.f6924c.A(z10);
        }
    }

    public final void A0() {
        U0();
        if (!P0()) {
            v.g("MediaController", "The controller is not connected. Ignoring seekBack().");
        } else {
            this.f6924c.A0();
        }
    }

    public final void B() {
        U0();
        if (!P0()) {
            v.g("MediaController", "The controller is not connected. Ignoring seekToNextMediaItem().");
        } else {
            this.f6924c.B();
        }
    }

    public final void B0(float f10) {
        U0();
        a.a("volume must be between 0 and 1", f10 >= 0.0f && f10 <= 1.0f);
        if (!P0()) {
            v.g("MediaController", "The controller is not connected. Ignoring setVolume().");
        } else {
            this.f6924c.B0(f10);
        }
    }

    public final void C(r0 r0Var) {
        boolean z10;
        U0();
        if (r0Var != null) {
            for (int i10 = 0; i10 < r0Var.size(); i10++) {
                if (r0Var.get(i10) != null) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                a.a("items must not contain null, index=" + i10, z10);
            }
            if (!P0()) {
                v.g("MediaController", "The controller is not connected. Ignoring setMediaItems().");
            } else {
                this.f6924c.C(r0Var);
            }
        } else {
            throw new NullPointerException("mediaItems must not be null");
        }
    }

    public final v0 C0() {
        U0();
        return P0() ? this.f6924c.C0() : v0.P;
    }

    public final a2 D() {
        U0();
        return P0() ? this.f6924c.D() : a2.f6286i;
    }

    public final void D0() {
        U0();
        if (!P0()) {
            v.g("MediaController", "The controller is not connected. Ignoring seekToPrevious().");
        } else {
            this.f6924c.D0();
        }
    }

    public final int E() {
        U0();
        if (P0()) {
            return this.f6924c.E();
        }
        return 0;
    }

    public final void E0(float f10) {
        U0();
        if (!P0()) {
            v.g("MediaController", "The controller is not connected. Ignoring setPlaybackSpeed().");
        } else {
            this.f6924c.E0(f10);
        }
    }

    public final long F() {
        U0();
        if (P0()) {
            return this.f6924c.F();
        }
        return 0;
    }

    public final void F0(List list, int i10) {
        U0();
        if (!P0()) {
            v.g("MediaController", "The controller is not connected. Ignoring addMediaItems().");
        } else {
            this.f6924c.F0(list, i10);
        }
    }

    public final boolean G() {
        U0();
        return P0() && this.f6924c.G();
    }

    public final long G0() {
        U0();
        if (P0()) {
            return this.f6924c.G0();
        }
        return 0;
    }

    public final v0 H() {
        U0();
        return P0() ? this.f6924c.H() : v0.P;
    }

    public final Object H0() {
        return null;
    }

    public final boolean I() {
        U0();
        return P0() && this.f6924c.I();
    }

    public final boolean I0() {
        U0();
        u1 j02 = j0();
        return !j02.y() && j02.v(U(), this.f6922a).f6582o;
    }

    public final long J() {
        U0();
        if (P0()) {
            return this.f6924c.J();
        }
        return -9223372036854775807L;
    }

    public final s0 J0() {
        u1 j02 = j0();
        if (j02.y()) {
            return null;
        }
        return j02.v(U(), this.f6922a).f6577j;
    }

    public final int K() {
        U0();
        if (P0()) {
            return this.f6924c.K();
        }
        return -1;
    }

    public final void K0(int i10, long j10, r0 r0Var) {
        boolean z10;
        U0();
        if (r0Var != null) {
            for (int i11 = 0; i11 < r0Var.size(); i11++) {
                if (r0Var.get(i11) != null) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                a.a("items must not contain null, index=" + i11, z10);
            }
            if (!P0()) {
                v.g("MediaController", "The controller is not connected. Ignoring setMediaItems().");
            } else {
                this.f6924c.L0(i10, j10, r0Var);
            }
        } else {
            throw new NullPointerException("mediaItems must not be null");
        }
    }

    public final d L() {
        U0();
        return P0() ? this.f6924c.L() : d.f7990j;
    }

    public final boolean L0(int i10) {
        return w().i(i10);
    }

    public final void M(TextureView textureView) {
        U0();
        if (!P0()) {
            v.g("MediaController", "The controller is not connected. Ignoring clearVideoTextureView().");
        } else {
            this.f6924c.M(textureView);
        }
    }

    public final boolean M0() {
        U0();
        u1 j02 = j0();
        return !j02.y() && j02.v(U(), this.f6922a).f6583p;
    }

    public final b2 N() {
        U0();
        return P0() ? this.f6924c.N() : b2.f6311l;
    }

    public final Looper N0() {
        return this.f6926e.getLooper();
    }

    public final void O() {
        U0();
        if (!P0()) {
            v.g("MediaController", "The controller is not connected. Ignoring seekToPreviousMediaItem().");
        } else {
            this.f6924c.O();
        }
    }

    public final boolean O0() {
        U0();
        u1 j02 = j0();
        return !j02.y() && j02.v(U(), this.f6922a).k();
    }

    public final void P() {
        U0();
        if (!P0()) {
            v.g("MediaController", "The controller is not connected. Ignoring play().");
        } else {
            this.f6924c.P();
        }
    }

    public final boolean P0() {
        return this.f6924c.H0();
    }

    public final float Q() {
        U0();
        if (P0()) {
            return this.f6924c.Q();
        }
        return 1.0f;
    }

    public final void Q0() {
        boolean z10;
        if (Looper.myLooper() == N0()) {
            z10 = true;
        } else {
            z10 = false;
        }
        a.e(z10);
        a.e(!this.f6928g);
        this.f6928g = true;
        c0 c0Var = (c0) this.f6929h;
        c0Var.f6952q = true;
        b0 b0Var = c0Var.f6951p;
        if (b0Var != null) {
            c0Var.l(b0Var);
        }
    }

    public final void R() {
        U0();
        if (!P0()) {
            v.g("MediaController", "The controller is not connected. Ignoring seekTo().");
        } else {
            this.f6924c.R();
        }
    }

    public final void R0(h hVar) {
        a.e(Looper.myLooper() == N0());
        hVar.b(this.f6925d);
    }

    public final g1.h S() {
        U0();
        return !P0() ? g1.h.f6386n : this.f6924c.S();
    }

    public final void S0(Runnable runnable) {
        l0.L(this.f6926e, runnable);
    }

    public final int T() {
        U0();
        if (P0()) {
            return this.f6924c.T();
        }
        return -1;
    }

    public final e0 T0(f4 f4Var, Bundle bundle) {
        boolean z10;
        U0();
        if (f4Var.f7034h == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        a.a("command must be a custom command", z10);
        if (P0()) {
            return this.f6924c.J0(f4Var, bundle);
        }
        return new a0(new j4(-100));
    }

    public final int U() {
        U0();
        if (P0()) {
            return this.f6924c.U();
        }
        return -1;
    }

    public final void U0() {
        boolean z10;
        if (Looper.myLooper() == N0()) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            throw new IllegalStateException("MediaController method is called from a wrong thread. See javadoc of MediaController for details.");
        }
    }

    public final q V() {
        U0();
        return !P0() ? q.f6514k : this.f6924c.V();
    }

    public final void W() {
        U0();
        if (!P0()) {
            v.g("MediaController", "The controller is not connected. Ignoring decreaseDeviceVolume().");
        } else {
            this.f6924c.W();
        }
    }

    public final void X(boolean z10) {
        U0();
        if (!P0()) {
            v.g("MediaController", "The controller is not connected. Ignoring setDeviceMuted().");
        } else {
            this.f6924c.X(z10);
        }
    }

    public final boolean Y() {
        U0();
        return P0() && this.f6924c.Y();
    }

    public final int Z() {
        U0();
        if (P0()) {
            return this.f6924c.Z();
        }
        return -1;
    }

    public final void a() {
        U0();
        if (!this.f6923b) {
            this.f6923b = true;
            this.f6926e.removeCallbacksAndMessages((Object) null);
            try {
                this.f6924c.a();
            } catch (Exception e10) {
                v.a("Exception while releasing impl", e10);
                v.b();
            }
            if (this.f6928g) {
                R0(new c(10, this));
                return;
            }
            this.f6928g = true;
            c0 c0Var = (c0) this.f6929h;
            c0Var.getClass();
            c0Var.m(new SecurityException("Session rejected the connection request."));
        }
    }

    public final void a0(SurfaceView surfaceView) {
        U0();
        if (!P0()) {
            v.g("MediaController", "The controller is not connected. Ignoring setVideoSurfaceView().");
        } else {
            this.f6924c.a0(surfaceView);
        }
    }

    public final int b() {
        U0();
        if (P0()) {
            return this.f6924c.b();
        }
        return 1;
    }

    public final void b0(s0 s0Var) {
        U0();
        if (s0Var == null) {
            throw new NullPointerException("mediaItems must not be null");
        } else if (!P0()) {
            v.g("MediaController", "The controller is not connected. Ignoring setMediaItems().");
        } else {
            this.f6924c.b0(s0Var);
        }
    }

    public final boolean c() {
        U0();
        return P0() && this.f6924c.c();
    }

    public final void c0(SurfaceView surfaceView) {
        U0();
        if (!P0()) {
            v.g("MediaController", "The controller is not connected. Ignoring clearVideoSurfaceView().");
        } else {
            this.f6924c.c0(surfaceView);
        }
    }

    public final void d(e1 e1Var) {
        U0();
        if (e1Var == null) {
            throw new NullPointerException("playbackParameters must not be null");
        } else if (!P0()) {
            v.g("MediaController", "The controller is not connected. Ignoring setPlaybackParameters().");
        } else {
            this.f6924c.d(e1Var);
        }
    }

    public final void d0(int i10, int i11) {
        U0();
        if (!P0()) {
            v.g("MediaController", "The controller is not connected. Ignoring moveMediaItem().");
        } else {
            this.f6924c.d0(i10, i11);
        }
    }

    public final void e() {
        U0();
        if (!P0()) {
            v.g("MediaController", "The controller is not connected. Ignoring prepare().");
        } else {
            this.f6924c.e();
        }
    }

    public final void e0(int i10, int i11, int i12) {
        U0();
        if (!P0()) {
            v.g("MediaController", "The controller is not connected. Ignoring moveMediaItems().");
        } else {
            this.f6924c.e0(i10, i11, i12);
        }
    }

    public final void f(int i10) {
        U0();
        if (!P0()) {
            v.g("MediaController", "The controller is not connected. Ignoring setRepeatMode().");
        } else {
            this.f6924c.f(i10);
        }
    }

    public final int f0() {
        U0();
        if (P0()) {
            return this.f6924c.f0();
        }
        return 0;
    }

    public final void g() {
        U0();
        if (!P0()) {
            v.g("MediaController", "The controller is not connected. Ignoring pause().");
        } else {
            this.f6924c.g();
        }
    }

    public final void g0(List list) {
        U0();
        if (!P0()) {
            v.g("MediaController", "The controller is not connected. Ignoring addMediaItems().");
        } else {
            this.f6924c.g0(list);
        }
    }

    public final int h() {
        U0();
        if (P0()) {
            return this.f6924c.h();
        }
        return 0;
    }

    public final void h0(s0 s0Var) {
        U0();
        if (!P0()) {
            v.g("MediaController", "The controller is not connected. Ignoring setMediaItem().");
        } else {
            this.f6924c.h0(s0Var);
        }
    }

    public final e1 i() {
        U0();
        return P0() ? this.f6924c.i() : e1.f6351k;
    }

    public final long i0() {
        U0();
        if (P0()) {
            return this.f6924c.i0();
        }
        return -9223372036854775807L;
    }

    public final long j() {
        U0();
        if (P0()) {
            return this.f6924c.j();
        }
        return 0;
    }

    public final u1 j0() {
        U0();
        return P0() ? this.f6924c.j0() : u1.f6622h;
    }

    public final d1 k() {
        U0();
        if (P0()) {
            return this.f6924c.k();
        }
        return null;
    }

    public final boolean k0() {
        U0();
        if (!P0()) {
            return false;
        }
        return this.f6924c.k0();
    }

    public final int l() {
        U0();
        if (!P0()) {
            return 0;
        }
        return this.f6924c.l();
    }

    public final void l0(v0 v0Var) {
        U0();
        if (v0Var == null) {
            throw new NullPointerException("playlistMetadata must not be null");
        } else if (!P0()) {
            v.g("MediaController", "The controller is not connected. Ignoring setPlaylistMetadata().");
        } else {
            this.f6924c.l0(v0Var);
        }
    }

    public final void m(boolean z10) {
        U0();
        if (P0()) {
            this.f6924c.m(z10);
        }
    }

    public final void m0(int i10) {
        U0();
        if (!P0()) {
            v.g("MediaController", "The controller is not connected. Ignoring removeMediaItem().");
        } else {
            this.f6924c.m0(i10);
        }
    }

    public final void n(Surface surface) {
        U0();
        if (!P0()) {
            v.g("MediaController", "The controller is not connected. Ignoring setVideoSurface().");
        } else {
            this.f6924c.n(surface);
        }
    }

    public final void n0() {
        U0();
        if (!P0()) {
            v.g("MediaController", "The controller is not connected. Ignoring increaseDeviceVolume().");
        } else {
            this.f6924c.n0();
        }
    }

    public final boolean o() {
        U0();
        return P0() && this.f6924c.o();
    }

    public final boolean o0() {
        U0();
        return P0() && this.f6924c.o0();
    }

    public final void p(int i10) {
        U0();
        if (!P0()) {
            v.g("MediaController", "The controller is not connected. Ignoring seekTo().");
        } else {
            this.f6924c.p(i10);
        }
    }

    public final y1 p0() {
        U0();
        return !P0() ? y1.H : this.f6924c.p0();
    }

    public final long q() {
        U0();
        if (P0()) {
            return this.f6924c.q();
        }
        return 0;
    }

    public final void q0(long j10) {
        U0();
        if (!P0()) {
            v.g("MediaController", "The controller is not connected. Ignoring seekTo().");
        } else {
            this.f6924c.q0(j10);
        }
    }

    public final void r(y1 y1Var) {
        U0();
        if (!P0()) {
            v.g("MediaController", "The controller is not connected. Ignoring setTrackSelectionParameters().");
        }
        this.f6924c.r(y1Var);
    }

    public final long r0() {
        U0();
        if (P0()) {
            return this.f6924c.r0();
        }
        return 0;
    }

    public final long s() {
        U0();
        if (P0()) {
            return this.f6924c.s();
        }
        return -9223372036854775807L;
    }

    public final void s0(int i10, int i11) {
        U0();
        if (!P0()) {
            v.g("MediaController", "The controller is not connected. Ignoring removeMediaItems().");
        } else {
            this.f6924c.s0(i10, i11);
        }
    }

    public final void stop() {
        U0();
        if (!P0()) {
            v.g("MediaController", "The controller is not connected. Ignoring stop().");
        } else {
            this.f6924c.stop();
        }
    }

    public final long t() {
        U0();
        if (P0()) {
            return this.f6924c.t();
        }
        return 0;
    }

    public final void t0(int i10) {
        U0();
        if (!P0()) {
            v.g("MediaController", "The controller is not connected. Ignoring setDeviceVolume().");
        } else {
            this.f6924c.t0(i10);
        }
    }

    public final long u() {
        U0();
        if (P0()) {
            return this.f6924c.u();
        }
        return 0;
    }

    public final void u0() {
        U0();
        if (!P0()) {
            v.g("MediaController", "The controller is not connected. Ignoring seekToNext().");
        } else {
            this.f6924c.u0();
        }
    }

    public final void v(int i10, long j10) {
        U0();
        if (!P0()) {
            v.g("MediaController", "The controller is not connected. Ignoring seekTo().");
        } else {
            this.f6924c.v(i10, j10);
        }
    }

    public final void v0() {
        U0();
        if (!P0()) {
            v.g("MediaController", "The controller is not connected. Ignoring seekForward().");
        } else {
            this.f6924c.v0();
        }
    }

    public final g1 w() {
        U0();
        return !P0() ? g1.f6382i : this.f6924c.w();
    }

    public final void w0(TextureView textureView) {
        U0();
        if (!P0()) {
            v.g("MediaController", "The controller is not connected. Ignoring setVideoTextureView().");
        } else {
            this.f6924c.w0(textureView);
        }
    }

    public final long x() {
        U0();
        if (P0()) {
            return this.f6924c.x();
        }
        return 0;
    }

    public final void x0(i1 i1Var) {
        if (i1Var != null) {
            this.f6924c.x0(i1Var);
            return;
        }
        throw new NullPointerException("listener must not be null");
    }

    public final boolean y() {
        U0();
        return P0() && this.f6924c.y();
    }

    public final void y0(s0 s0Var, long j10) {
        U0();
        if (s0Var == null) {
            throw new NullPointerException("mediaItems must not be null");
        } else if (!P0()) {
            v.g("MediaController", "The controller is not connected. Ignoring setMediaItem().");
        } else {
            this.f6924c.y0(s0Var, j10);
        }
    }

    public final void z() {
        U0();
        if (!P0()) {
            v.g("MediaController", "The controller is not connected. Ignoring clearMediaItems().");
        } else {
            this.f6924c.z();
        }
    }

    public final void z0(i1 i1Var) {
        U0();
        if (i1Var != null) {
            this.f6924c.z0(i1Var);
            return;
        }
        throw new NullPointerException("listener must not be null");
    }
}
