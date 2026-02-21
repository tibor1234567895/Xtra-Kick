package h3;

import android.os.Bundle;
import android.os.Looper;
import android.os.SystemClock;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceView;
import android.view.TextureView;
import d9.p0;
import d9.r0;
import d9.r1;
import e1.h;
import g1.a2;
import g1.b0;
import g1.b2;
import g1.c0;
import g1.d1;
import g1.e1;
import g1.g1;
import g1.i1;
import g1.j1;
import g1.k1;
import g1.q;
import g1.s0;
import g1.u1;
import g1.v0;
import g1.y1;
import i1.d;
import j1.a;
import java.util.ArrayList;
import java.util.List;

public final class a4 extends c0 {

    /* renamed from: b  reason: collision with root package name */
    public final r1 f6919b = r1.f4658l;

    public a4(k1 k1Var) {
        super(k1Var);
        p0 p0Var = r0.f4657i;
    }

    public final void A(boolean z10) {
        W0();
        this.f6334a.A(z10);
    }

    public final void A0() {
        W0();
        this.f6334a.A0();
    }

    public final void B() {
        W0();
        this.f6334a.B();
    }

    public final void B0(float f10) {
        W0();
        this.f6334a.B0(f10);
    }

    public final void C(r0 r0Var) {
        W0();
        this.f6334a.C(r0Var);
    }

    public final v0 C0() {
        W0();
        return this.f6334a.C0();
    }

    public final a2 D() {
        W0();
        return this.f6334a.D();
    }

    public final void D0() {
        W0();
        this.f6334a.D0();
    }

    public final int E() {
        W0();
        return this.f6334a.E();
    }

    public final void E0(float f10) {
        W0();
        this.f6334a.E0(f10);
    }

    public final long F() {
        W0();
        return this.f6334a.F();
    }

    public final void F0(List list, int i10) {
        W0();
        this.f6334a.F0(list, i10);
    }

    public final boolean G() {
        W0();
        return this.f6334a.G();
    }

    public final long G0() {
        W0();
        return this.f6334a.G0();
    }

    public final v0 H() {
        W0();
        return this.f6334a.H();
    }

    public final Object H0() {
        W0();
        return this.f6334a.H0();
    }

    public final boolean I() {
        W0();
        return this.f6334a.I();
    }

    public final boolean I0() {
        W0();
        return this.f6334a.I0();
    }

    public final long J() {
        W0();
        return this.f6334a.J();
    }

    public final s0 J0() {
        W0();
        return this.f6334a.J0();
    }

    public final int K() {
        W0();
        return this.f6334a.K();
    }

    public final void K0(int i10, long j10, r0 r0Var) {
        W0();
        this.f6334a.K0(i10, j10, r0Var);
    }

    public final d L() {
        W0();
        return this.f6334a.L();
    }

    public final boolean L0(int i10) {
        W0();
        return this.f6334a.L0(i10);
    }

    public final void M(TextureView textureView) {
        W0();
        this.f6334a.M(textureView);
    }

    public final boolean M0() {
        W0();
        return this.f6334a.M0();
    }

    public final b2 N() {
        W0();
        return this.f6334a.N();
    }

    public final void O() {
        W0();
        this.f6334a.O();
    }

    public final boolean O0() {
        W0();
        return this.f6334a.O0();
    }

    public final void P() {
        W0();
        this.f6334a.P();
    }

    public final PlaybackStateCompat P0() {
        int i10;
        long j10;
        float f10;
        int U;
        d1 k10 = k();
        int b10 = b();
        boolean y10 = y();
        h hVar = t3.f7332a;
        if (k10 != null) {
            i10 = 7;
        } else if (b10 != 1) {
            if (b10 != 2) {
                if (b10 != 3) {
                    if (b10 == 4) {
                        i10 = 1;
                    } else {
                        throw new IllegalArgumentException(android.support.v4.media.h.i("Unrecognized State: ", b10));
                    }
                } else if (y10) {
                    i10 = 3;
                }
            } else if (y10) {
                i10 = 6;
            }
            i10 = 2;
        } else {
            i10 = 0;
        }
        g1 w10 = w();
        long j11 = 128;
        int i11 = 0;
        while (true) {
            long j12 = 0;
            if (i11 < w10.f6385h.c()) {
                int b11 = w10.f6385h.b(i11);
                if (b11 == 1) {
                    j12 = 518;
                } else if (b11 == 2) {
                    j12 = 16384;
                } else if (b11 == 3) {
                    j12 = 1;
                } else if (b11 != 31) {
                    switch (b11) {
                        case Constants.MAX_COMPATIBILITY_VERSION:
                            j12 = 256;
                            break;
                        case 6:
                        case 7:
                            j12 = 16;
                            break;
                        case 8:
                        case 9:
                            j12 = 32;
                            break;
                        case 10:
                            j12 = 4096;
                            break;
                        case 11:
                            j12 = 8;
                            break;
                        case 12:
                            j12 = 64;
                            break;
                        case 13:
                            j12 = 4194304;
                            break;
                        case 14:
                            j12 = 2621440;
                            break;
                        case 15:
                            j12 = 262144;
                            break;
                    }
                } else {
                    j12 = 240640;
                }
                j11 |= j12;
                i11++;
            } else {
                long j13 = -1;
                if (!L0(17) || (U = U()) == -1) {
                    j10 = -1;
                } else {
                    j10 = (long) U;
                }
                float f11 = i().f6355h;
                if (I()) {
                    f10 = f11;
                } else {
                    f10 = 0.0f;
                }
                Bundle bundle = new Bundle();
                bundle.putFloat("EXO_SPEED", f11);
                s0 T0 = T0();
                if (T0 != null) {
                    String str = T0.f6556h;
                    if (!"".equals(str)) {
                        bundle.putString("androidx.media.PlaybackStateCompat.Extras.KEY_MEDIA_ID", str);
                    }
                }
                boolean L0 = L0(16);
                if (L0) {
                    j13 = j();
                }
                if (L0) {
                    j12 = x();
                }
                android.support.v4.media.session.r0 r0Var = new android.support.v4.media.session.r0();
                long elapsedRealtime = SystemClock.elapsedRealtime();
                r0Var.f415b = i10;
                r0Var.f416c = j13;
                r0Var.f422i = elapsedRealtime;
                r0Var.f418e = f10;
                r0Var.f419f = j11;
                r0Var.f423j = j10;
                r0Var.f417d = j12;
                r0Var.f424k = bundle;
                int i12 = 0;
                while (true) {
                    r1 r1Var = this.f6919b;
                    int i13 = r1Var.f4660k;
                    ArrayList arrayList = r0Var.f414a;
                    if (i12 < i13) {
                        d dVar = (d) r1Var.get(i12);
                        f4 f4Var = dVar.f6971h;
                        if (f4Var != null && f4Var.f7034h == 0) {
                            String str2 = f4Var.f7035i;
                            if (!TextUtils.isEmpty(str2)) {
                                CharSequence charSequence = dVar.f6974k;
                                if (!TextUtils.isEmpty(charSequence)) {
                                    int i14 = dVar.f6973j;
                                    if (i14 != 0) {
                                        arrayList.add(new PlaybackStateCompat.CustomAction(str2, charSequence, i14, f4Var.f7036j));
                                    } else {
                                        throw new IllegalArgumentException("You must specify an icon resource id to build a CustomAction");
                                    }
                                } else {
                                    throw new IllegalArgumentException("You must specify a name to build a CustomAction");
                                }
                            } else {
                                throw new IllegalArgumentException("You must specify an action to build a CustomAction");
                            }
                        }
                        i12++;
                    } else {
                        if (k10 != null) {
                            String message = k10.getMessage();
                            r0Var.f420g = 0;
                            r0Var.f421h = message;
                        }
                        PlaybackStateCompat playbackStateCompat = r6;
                        PlaybackStateCompat playbackStateCompat2 = new PlaybackStateCompat(r0Var.f415b, r0Var.f416c, r0Var.f417d, r0Var.f418e, r0Var.f419f, r0Var.f420g, r0Var.f421h, r0Var.f422i, arrayList, r0Var.f423j, r0Var.f424k);
                        return playbackStateCompat;
                    }
                }
            }
        }
    }

    public final float Q() {
        W0();
        return this.f6334a.Q();
    }

    public final w3 Q0() {
        v0 v0Var;
        float f10;
        g1.h hVar;
        d dVar;
        int i10;
        a2 a2Var;
        d1 k10 = k();
        i4 S0 = S0();
        j1 R0 = R0();
        j1 R02 = R0();
        e1 i11 = i();
        int h10 = h();
        boolean o02 = o0();
        b2 N = N();
        u1 U0 = U0();
        if (L0(18)) {
            v0Var = H();
        } else {
            v0Var = v0.P;
        }
        v0 v0Var2 = v0Var;
        if (L0(22)) {
            f10 = Q();
        } else {
            f10 = 0.0f;
        }
        if (L0(21)) {
            hVar = S();
        } else {
            hVar = g1.h.f6386n;
        }
        g1.h hVar2 = hVar;
        if (L0(28)) {
            dVar = L();
        } else {
            dVar = d.f7990j;
        }
        d dVar2 = dVar;
        q V = V();
        boolean z10 = false;
        if (L0(23)) {
            i10 = l();
        } else {
            i10 = 0;
        }
        if (L0(23) && k0()) {
            z10 = true;
        }
        boolean y10 = y();
        int f02 = f0();
        int b10 = b();
        boolean I = I();
        boolean c10 = c();
        v0 V0 = V0();
        long G0 = G0();
        long q10 = q();
        long F = F();
        if (L0(30)) {
            a2Var = D();
        } else {
            a2Var = a2.f6286i;
        }
        return new w3(k10, 0, S0, R0, R02, 0, i11, h10, o02, N, U0, v0Var2, f10, hVar2, dVar2, V, i10, z10, y10, 1, f02, b10, I, c10, V0, G0, q10, F, a2Var, p0());
    }

    public final void R() {
        W0();
        this.f6334a.R();
    }

    public final j1 R0() {
        boolean L0 = L0(16);
        boolean L02 = L0(17);
        int U = L02 ? U() : 0;
        s0 J0 = L0 ? J0() : null;
        int K = L02 ? K() : 0;
        long j10 = 0;
        long j11 = L0 ? j() : 0;
        if (L0) {
            j10 = t();
        }
        return new j1((Object) null, U, J0, (Object) null, K, j11, j10, L0 ? T() : -1, L0 ? Z() : -1);
    }

    public final g1.h S() {
        W0();
        return this.f6334a.S();
    }

    public final i4 S0() {
        boolean L0 = L0(16);
        j1 R0 = R0();
        boolean z10 = L0 && o();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j10 = -9223372036854775807L;
        long i02 = L0 ? i0() : -9223372036854775807L;
        long x10 = L0 ? x() : 0;
        int E = L0 ? E() : 0;
        long u10 = L0 ? u() : 0;
        long s10 = L0 ? s() : -9223372036854775807L;
        if (L0) {
            j10 = J();
        }
        return new i4(R0, z10, elapsedRealtime, i02, x10, E, u10, s10, j10, L0 ? r0() : 0);
    }

    public final int T() {
        W0();
        return this.f6334a.T();
    }

    public final s0 T0() {
        if (L0(16)) {
            return J0();
        }
        return null;
    }

    public final int U() {
        W0();
        return this.f6334a.U();
    }

    public final u1 U0() {
        return L0(17) ? j0() : L0(16) ? new z3(this) : u1.f6622h;
    }

    public final q V() {
        W0();
        return this.f6334a.V();
    }

    public final v0 V0() {
        return L0(18) ? C0() : v0.P;
    }

    public final void W() {
        W0();
        this.f6334a.W();
    }

    public final void W0() {
        a.e(Looper.myLooper() == N0());
    }

    public final void X(boolean z10) {
        W0();
        this.f6334a.X(z10);
    }

    public final boolean Y() {
        W0();
        return this.f6334a.Y();
    }

    public final int Z() {
        W0();
        return this.f6334a.Z();
    }

    public final void a() {
        W0();
        super.a();
    }

    public final void a0(SurfaceView surfaceView) {
        W0();
        this.f6334a.a0(surfaceView);
    }

    public final int b() {
        W0();
        return this.f6334a.b();
    }

    public final void b0(s0 s0Var) {
        W0();
        this.f6334a.b0(s0Var);
    }

    public final boolean c() {
        W0();
        return this.f6334a.c();
    }

    public final void c0(SurfaceView surfaceView) {
        W0();
        this.f6334a.c0(surfaceView);
    }

    public final void d(e1 e1Var) {
        W0();
        this.f6334a.d(e1Var);
    }

    public final void d0(int i10, int i11) {
        W0();
        this.f6334a.d0(i10, i11);
    }

    public final void e() {
        W0();
        this.f6334a.e();
    }

    public final void e0(int i10, int i11, int i12) {
        W0();
        this.f6334a.e0(i10, i11, i12);
    }

    public final void f(int i10) {
        W0();
        this.f6334a.f(i10);
    }

    public final int f0() {
        W0();
        return this.f6334a.f0();
    }

    public final void g() {
        W0();
        this.f6334a.g();
    }

    public final void g0(List list) {
        W0();
        this.f6334a.g0(list);
    }

    public final int h() {
        W0();
        return this.f6334a.h();
    }

    public final void h0(s0 s0Var) {
        W0();
        this.f6334a.h0(s0Var);
    }

    public final e1 i() {
        W0();
        return this.f6334a.i();
    }

    public final long i0() {
        W0();
        return this.f6334a.i0();
    }

    public final long j() {
        W0();
        return this.f6334a.j();
    }

    public final u1 j0() {
        W0();
        return this.f6334a.j0();
    }

    public final d1 k() {
        W0();
        return this.f6334a.k();
    }

    public final boolean k0() {
        W0();
        return this.f6334a.k0();
    }

    public final int l() {
        W0();
        return this.f6334a.l();
    }

    public final void l0(v0 v0Var) {
        W0();
        this.f6334a.l0(v0Var);
    }

    public final void m(boolean z10) {
        W0();
        this.f6334a.m(z10);
    }

    public final void m0(int i10) {
        W0();
        this.f6334a.m0(i10);
    }

    public final void n(Surface surface) {
        W0();
        this.f6334a.n(surface);
    }

    public final void n0() {
        W0();
        this.f6334a.n0();
    }

    public final boolean o() {
        W0();
        return this.f6334a.o();
    }

    public final boolean o0() {
        W0();
        return this.f6334a.o0();
    }

    public final void p(int i10) {
        W0();
        this.f6334a.p(i10);
    }

    public final y1 p0() {
        W0();
        return this.f6334a.p0();
    }

    public final long q() {
        W0();
        return this.f6334a.q();
    }

    public final void q0(long j10) {
        W0();
        this.f6334a.q0(j10);
    }

    public final void r(y1 y1Var) {
        W0();
        this.f6334a.r(y1Var);
    }

    public final long r0() {
        W0();
        return this.f6334a.r0();
    }

    public final long s() {
        W0();
        return this.f6334a.s();
    }

    public final void s0(int i10, int i11) {
        W0();
        this.f6334a.s0(i10, i11);
    }

    public final void stop() {
        W0();
        this.f6334a.stop();
    }

    public final long t() {
        W0();
        return this.f6334a.t();
    }

    public final void t0(int i10) {
        W0();
        this.f6334a.t0(i10);
    }

    public final long u() {
        W0();
        return this.f6334a.u();
    }

    public final void u0() {
        W0();
        this.f6334a.u0();
    }

    public final void v(int i10, long j10) {
        W0();
        this.f6334a.v(i10, j10);
    }

    public final void v0() {
        W0();
        this.f6334a.v0();
    }

    public final g1 w() {
        W0();
        return this.f6334a.w();
    }

    public final void w0(TextureView textureView) {
        W0();
        this.f6334a.w0(textureView);
    }

    public final long x() {
        W0();
        return this.f6334a.x();
    }

    public final void x0(i1 i1Var) {
        W0();
        this.f6334a.x0(new b0(this, i1Var));
    }

    public final boolean y() {
        W0();
        return this.f6334a.y();
    }

    public final void y0(s0 s0Var, long j10) {
        W0();
        this.f6334a.y0(s0Var, j10);
    }

    public final void z() {
        W0();
        this.f6334a.z();
    }

    public final void z0(i1 i1Var) {
        W0();
        this.f6334a.z0(new b0(this, i1Var));
    }
}
