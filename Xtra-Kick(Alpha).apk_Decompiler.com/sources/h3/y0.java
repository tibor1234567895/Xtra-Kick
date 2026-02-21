package h3;

import a2.k;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Process;
import android.os.RemoteException;
import android.os.SystemClock;
import android.support.v4.media.n;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import androidx.fragment.app.g;
import d9.o0;
import d9.r0;
import d9.r1;
import e1.h;
import g1.a2;
import g1.b2;
import g1.c;
import g1.d1;
import g1.e1;
import g1.g1;
import g1.i1;
import g1.j1;
import g1.m0;
import g1.q;
import g1.s0;
import g1.s1;
import g1.t1;
import g1.u1;
import g1.v0;
import g1.y1;
import h9.a0;
import h9.e0;
import j1.a;
import j1.c0;
import j1.d;
import j1.l0;
import j1.v;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;
import m1.d0;
import m1.w;
import m1.y;
import n1.o;
import q.f;
import v.e;

public class y0 implements a0 {
    public v3 A;

    /* renamed from: a  reason: collision with root package name */
    public final b0 f7453a;

    /* renamed from: b  reason: collision with root package name */
    public final e4 f7454b;

    /* renamed from: c  reason: collision with root package name */
    public final o1 f7455c;

    /* renamed from: d  reason: collision with root package name */
    public final Context f7456d;

    /* renamed from: e  reason: collision with root package name */
    public final l4 f7457e;

    /* renamed from: f  reason: collision with root package name */
    public final Bundle f7458f;

    /* renamed from: g  reason: collision with root package name */
    public final e0 f7459g;

    /* renamed from: h  reason: collision with root package name */
    public final x0 f7460h;

    /* renamed from: i  reason: collision with root package name */
    public final e f7461i;

    /* renamed from: j  reason: collision with root package name */
    public final n f7462j;

    /* renamed from: k  reason: collision with root package name */
    public final f f7463k;

    /* renamed from: l  reason: collision with root package name */
    public v0 f7464l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f7465m;

    /* renamed from: n  reason: collision with root package name */
    public w3 f7466n = w3.L;

    /* renamed from: o  reason: collision with root package name */
    public h4 f7467o = h4.f7075i;

    /* renamed from: p  reason: collision with root package name */
    public g1 f7468p;

    /* renamed from: q  reason: collision with root package name */
    public g1 f7469q;

    /* renamed from: r  reason: collision with root package name */
    public g1 f7470r;

    /* renamed from: s  reason: collision with root package name */
    public Surface f7471s;

    /* renamed from: t  reason: collision with root package name */
    public SurfaceHolder f7472t;

    /* renamed from: u  reason: collision with root package name */
    public TextureView f7473u;

    /* renamed from: v  reason: collision with root package name */
    public c0 f7474v = c0.f8417c;

    /* renamed from: w  reason: collision with root package name */
    public r f7475w;

    /* renamed from: x  reason: collision with root package name */
    public long f7476x;

    /* renamed from: y  reason: collision with root package name */
    public long f7477y;

    /* renamed from: z  reason: collision with root package name */
    public w3 f7478z;

    public y0(Context context, b0 b0Var, l4 l4Var, Bundle bundle, Looper looper) {
        v0 v0Var;
        g1 g1Var = g1.f6382i;
        this.f7468p = g1Var;
        this.f7469q = g1Var;
        this.f7470r = g1Var;
        this.f7461i = new e(looper, d.f8420a, new l0(this, 10));
        this.f7453a = b0Var;
        if (context == null) {
            throw new NullPointerException("context must not be null");
        } else if (l4Var != null) {
            this.f7456d = context;
            this.f7454b = new e4();
            this.f7455c = new o1(this);
            this.f7463k = new f();
            this.f7457e = l4Var;
            this.f7458f = bundle;
            this.f7459g = new e0(this);
            this.f7460h = new x0(this);
            if (l4Var.f7191h.getType() == 0) {
                v0Var = null;
            } else {
                v0Var = new v0(bundle, this);
            }
            this.f7464l = v0Var;
            this.f7462j = new n(this, looper);
            this.f7476x = -9223372036854775807L;
            this.f7477y = -9223372036854775807L;
        } else {
            throw new NullPointerException("token must not be null");
        }
    }

    public static s1 P0(ArrayList arrayList, ArrayList arrayList2) {
        o0 o0Var = new o0();
        o0Var.d(arrayList);
        r1 e10 = o0Var.e();
        o0 o0Var2 = new o0();
        o0Var2.d(arrayList2);
        r1 e11 = o0Var2.e();
        int size = arrayList.size();
        h hVar = t3.f7332a;
        int[] iArr = new int[size];
        for (int i10 = 0; i10 < size; i10++) {
            iArr[i10] = i10;
        }
        return new s1(e10, e11, iArr);
    }

    public static w3 X0(w3 w3Var, s1 s1Var, int i10, int i11, int i12) {
        w3 w3Var2 = w3Var;
        s1 s1Var2 = s1Var;
        j1 j1Var = r2;
        int i13 = i10;
        s0 s0Var = s1Var2.v(i13, new t1()).f6577j;
        j1 j1Var2 = w3Var2.f7414j.f7117h;
        j1 j1Var3 = new j1((Object) null, i13, s0Var, (Object) null, i11, j1Var2.f6435m, j1Var2.f6436n, j1Var2.f6437o, j1Var2.f6438p);
        i4 i4Var = w3Var2.f7414j;
        return Y0(w3Var2, s1Var2, j1Var3, new i4(j1Var, i4Var.f7118i, SystemClock.elapsedRealtime(), i4Var.f7120k, i4Var.f7121l, i4Var.f7122m, i4Var.f7123n, i4Var.f7124o, i4Var.f7125p, i4Var.f7126q), i12);
    }

    public static w3 Y0(w3 w3Var, u1 u1Var, j1 j1Var, i4 i4Var, int i10) {
        u3 u3Var = new u3(w3Var);
        u3Var.f7349j = u1Var;
        u3Var.f7343d = w3Var.f7414j.f7117h;
        u3Var.f7344e = j1Var;
        u3Var.f7342c = i4Var;
        u3Var.f7345f = i10;
        return u3Var.a();
    }

    public static void c1(u1 u1Var, ArrayList arrayList, ArrayList arrayList2) {
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            t1 t1Var = (t1) arrayList.get(i10);
            int i11 = t1Var.f6589v;
            int i12 = t1Var.f6590w;
            if (i11 == -1 || i12 == -1) {
                t1Var.f6589v = arrayList2.size();
                t1Var.f6590w = arrayList2.size();
                g1.r1 r1Var = new g1.r1();
                r1Var.q((Object) null, (Object) null, i10, -9223372036854775807L, 0, c.f6321n, true);
                arrayList2.add(r1Var);
            } else {
                t1Var.f6589v = arrayList2.size();
                t1Var.f6590w = (i12 - i11) + arrayList2.size();
                while (i11 <= i12) {
                    g1.r1 r1Var2 = new g1.r1();
                    u1Var.o(i11, r1Var2, false);
                    r1Var2.f6544j = i10;
                    arrayList2.add(r1Var2);
                    i11++;
                }
            }
        }
    }

    public final void A(boolean z10) {
        if (W0(14)) {
            R0(new m0(this, z10, 3));
            w3 w3Var = this.f7466n;
            if (w3Var.f7420p != z10) {
                u3 u3Var = new u3(w3Var);
                u3Var.f7348i = z10;
                this.f7466n = u3Var.a();
                w wVar = new w(2, z10);
                e eVar = this.f7461i;
                eVar.j(9, wVar);
                eVar.g();
            }
        }
    }

    public final void A0() {
        if (W0(11)) {
            R0(new l0(this, 9));
            f1(-this.f7466n.G);
        }
    }

    public final void B() {
        if (W0(8)) {
            R0(new l0(this, 7));
            if (T0() != -1) {
                e1(T0(), -9223372036854775807L);
            }
        }
    }

    public final void B0(float f10) {
        if (W0(24)) {
            R0(new p0(this, f10, 0));
            w3 w3Var = this.f7466n;
            if (w3Var.f7424t != f10) {
                u3 u3Var = new u3(w3Var);
                u3Var.f7352m = f10;
                this.f7466n = u3Var.a();
                d0 d0Var = new d0(1, f10);
                e eVar = this.f7461i;
                eVar.j(22, d0Var);
                eVar.g();
            }
        }
    }

    public final void C(r0 r0Var) {
        if (W0(20)) {
            R0(new z1.e(this, r0Var, true, 1));
            g1(r0Var, -1, -9223372036854775807L, true);
        }
    }

    public final v0 C0() {
        return this.f7466n.F;
    }

    public final a2 D() {
        return this.f7466n.J;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x004e, code lost:
        if (r5.f7476x <= r5.f7466n.I) goto L_0x0050;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void D0() {
        /*
            r5 = this;
            r0 = 7
            boolean r0 = r5.W0(r0)
            if (r0 != 0) goto L_0x0008
            return
        L_0x0008:
            h3.l0 r0 = new h3.l0
            r1 = 13
            r0.<init>(r5, r1)
            r5.R0(r0)
            h3.w3 r0 = r5.f7466n
            g1.u1 r0 = r0.f7421q
            boolean r1 = r0.y()
            if (r1 != 0) goto L_0x0063
            boolean r1 = r5.o()
            if (r1 == 0) goto L_0x0023
            goto L_0x0063
        L_0x0023:
            boolean r1 = r5.Y()
            int r2 = r5.U()
            g1.t1 r3 = new g1.t1
            r3.<init>()
            g1.t1 r0 = r0.v(r2, r3)
            boolean r2 = r0.f6583p
            if (r2 == 0) goto L_0x0041
            boolean r0 = r0.k()
            if (r0 == 0) goto L_0x0041
            if (r1 == 0) goto L_0x0063
            goto L_0x0050
        L_0x0041:
            if (r1 == 0) goto L_0x005a
            r5.a1()
            long r0 = r5.f7476x
            h3.w3 r2 = r5.f7466n
            long r2 = r2.I
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 > 0) goto L_0x005a
        L_0x0050:
            int r0 = r5.V0()
            r1 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            goto L_0x0060
        L_0x005a:
            int r0 = r5.U()
            r1 = 0
        L_0x0060:
            r5.e1(r0, r1)
        L_0x0063:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: h3.y0.D0():void");
    }

    public final int E() {
        return this.f7466n.f7414j.f7122m;
    }

    public final void E0(float f10) {
        if (W0(13)) {
            R0(new p0(this, f10, 1));
            e1 e1Var = this.f7466n.f7418n;
            if (e1Var.f6355h != f10) {
                e1 e1Var2 = new e1(f10, e1Var.f6356i);
                this.f7466n = this.f7466n.k(e1Var2);
                o0 o0Var = new o0(1, e1Var2);
                e eVar = this.f7461i;
                eVar.j(12, o0Var);
                eVar.g();
            }
        }
    }

    public final long F() {
        return this.f7466n.I;
    }

    public final void F0(List list, int i10) {
        if (W0(20)) {
            a.b(i10 >= 0);
            R0(new k0(this, i10, list));
            M0(list, i10);
        }
    }

    public final boolean G() {
        return T0() != -1;
    }

    public final long G0() {
        return this.f7466n.G;
    }

    public final v0 H() {
        return this.f7466n.f7423s;
    }

    public final boolean H0() {
        return this.f7475w != null;
    }

    public final boolean I() {
        return this.f7466n.B;
    }

    public final h4 I0() {
        return this.f7467o;
    }

    public final long J() {
        return this.f7466n.f7414j.f7125p;
    }

    public final e0 J0(f4 f4Var, Bundle bundle) {
        boolean z10;
        r rVar;
        f0 f0Var = new f0(this, f4Var, bundle, 0);
        if (f4Var.f7034h == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        a.b(z10);
        h4 h4Var = this.f7467o;
        h4Var.getClass();
        if (!h4Var.f7078h.contains(f4Var)) {
            v.g("MCImplBase", "Controller isn't allowed to call custom session command:" + f4Var.f7035i);
            rVar = null;
        } else {
            rVar = this.f7475w;
        }
        return Q0(rVar, f0Var, false);
    }

    public final int K() {
        return this.f7466n.f7414j.f7117h.f6434l;
    }

    public final void K0() {
        int i10;
        r rVar;
        l4 l4Var = this.f7457e;
        int type = l4Var.f7191h.getType();
        boolean z10 = true;
        k4 k4Var = l4Var.f7191h;
        Context context = this.f7456d;
        Bundle bundle = this.f7458f;
        if (type == 0) {
            this.f7464l = null;
            Object d10 = k4Var.d();
            a.f(d10);
            IBinder iBinder = (IBinder) d10;
            int i11 = q.f7289c;
            IInterface queryLocalInterface = iBinder.queryLocalInterface("androidx.media3.session.IMediaSession");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof r)) {
                rVar = new p(iBinder);
            } else {
                rVar = (r) queryLocalInterface;
            }
            try {
                rVar.x(this.f7455c, this.f7454b.a(), new h(context.getPackageName(), Process.myPid(), bundle).h());
            } catch (RemoteException e10) {
                v.h("MCImplBase", "Failed to call connection request.", e10);
            }
        } else {
            this.f7464l = new v0(bundle, this);
            if (l0.f8453a >= 29) {
                i10 = 4097;
            } else {
                i10 = 1;
            }
            Intent intent = new Intent("androidx.media3.session.MediaSessionService");
            intent.setClassName(k4Var.g(), k4Var.e());
            if (!context.bindService(intent, this.f7464l, i10)) {
                v.g("MCImplBase", "bind to " + l4Var + " failed");
                z10 = false;
            }
        }
        if (!z10) {
            b0 b0Var = this.f7453a;
            Objects.requireNonNull(b0Var);
            b0Var.S0(new r0(b0Var, 0));
        }
    }

    public final i1.d L() {
        return this.f7466n.f7426v;
    }

    public final void L0(int i10, long j10, List list) {
        if (W0(20)) {
            R0(new j0(this, (r0) list, i10, j10));
            g1(list, i10, j10, false);
        }
    }

    public final void M(TextureView textureView) {
        if (W0(27) && textureView != null && this.f7473u == textureView) {
            O0();
        }
    }

    public final void M0(List list, int i10) {
        int i11;
        if (!list.isEmpty()) {
            int min = Math.min(i10, this.f7466n.f7421q.x());
            u1 u1Var = this.f7466n.f7421q;
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int i12 = 0;
            for (int i13 = 0; i13 < u1Var.x(); i13++) {
                arrayList.add(u1Var.v(i13, new t1()));
            }
            for (int i14 = 0; i14 < list.size(); i14++) {
                t1 t1Var = r9;
                t1 t1Var2 = new t1();
                t1Var.l(0, (s0) list.get(i14), (Object) null, 0, 0, 0, true, false, (m0) null, 0, -9223372036854775807L, -1, -1, 0);
                arrayList.add(i14 + min, t1Var2);
            }
            List list2 = list;
            c1(u1Var, arrayList, arrayList2);
            s1 P0 = P0(arrayList, arrayList2);
            if (this.f7466n.f7421q.y()) {
                i11 = 0;
            } else {
                int i15 = this.f7466n.f7414j.f7117h.f6431i;
                if (i15 >= min) {
                    i12 = list.size() + i15;
                } else {
                    i12 = i15;
                }
                int i16 = this.f7466n.f7414j.f7117h.f6434l;
                if (i16 >= min) {
                    i11 = list.size() + i16;
                } else {
                    i11 = i16;
                }
            }
            i1(X0(this.f7466n, P0, i12, i11, 5), false, 5, u1Var.y(), 3);
        }
    }

    public final b2 N() {
        return this.f7466n.f7422r;
    }

    public final void N0() {
        TextureView textureView = this.f7473u;
        if (textureView != null) {
            textureView.setSurfaceTextureListener((TextureView.SurfaceTextureListener) null);
            this.f7473u = null;
        }
        SurfaceHolder surfaceHolder = this.f7472t;
        if (surfaceHolder != null) {
            surfaceHolder.removeCallback(this.f7460h);
            this.f7472t = null;
        }
        if (this.f7471s != null) {
            this.f7471s = null;
        }
    }

    public final void O() {
        if (W0(6)) {
            R0(new l0(this, 0));
            if (V0() != -1) {
                e1(V0(), -9223372036854775807L);
            }
        }
    }

    public final void O0() {
        if (W0(27)) {
            N0();
            S0(new l0(this, 8));
            Z0(0, 0);
        }
    }

    public final void P() {
        if (W0(1)) {
            R0(new l0(this, 14));
            h1(true);
        }
    }

    public final float Q() {
        return this.f7466n.f7424t;
    }

    public final e0 Q0(r rVar, u0 u0Var, boolean z10) {
        d4 d4Var;
        if (rVar == null) {
            return new a0(new j4(-4));
        }
        e4 e4Var = this.f7454b;
        j4 j4Var = new j4(1);
        synchronized (e4Var.f7006a) {
            int a10 = e4Var.a();
            d4Var = new d4(a10, j4Var);
            if (e4Var.f7011f) {
                d4Var.n();
            } else {
                e4Var.f7008c.put(Integer.valueOf(a10), d4Var);
            }
        }
        int i10 = d4Var.f6985o;
        if (z10) {
            this.f7463k.add(Integer.valueOf(i10));
        }
        try {
            u0Var.d(rVar, i10);
        } catch (RemoteException e10) {
            v.h("MCImplBase", "Cannot connect to the service or the session is gone", e10);
            this.f7463k.remove(Integer.valueOf(i10));
            this.f7454b.c(i10, new j4(-100));
        }
        return d4Var;
    }

    public final void R() {
        if (W0(4)) {
            R0(new l0(this, 6));
            e1(U(), -9223372036854775807L);
        }
    }

    public final void R0(u0 u0Var) {
        n nVar = this.f7462j;
        if (((y0) nVar.f338j).f7475w != null && !((Handler) nVar.f337i).hasMessages(1)) {
            ((Handler) nVar.f337i).sendEmptyMessage(1);
        }
        Q0(this.f7475w, u0Var, true);
    }

    public final g1.h S() {
        return this.f7466n.f7425u;
    }

    public final void S0(u0 u0Var) {
        e0 Q0 = Q0(this.f7475w, u0Var, true);
        try {
            t3.u(Q0);
        } catch (ExecutionException e10) {
            throw new IllegalStateException(e10);
        } catch (TimeoutException e11) {
            if (Q0 instanceof d4) {
                int i10 = ((d4) Q0).f6985o;
                this.f7463k.remove(Integer.valueOf(i10));
                this.f7454b.c(i10, new j4(-1));
            }
            v.h("MCImplBase", "Synchronous command takes too long on the session side.", e11);
        }
    }

    public final int T() {
        return this.f7466n.f7414j.f7117h.f6437o;
    }

    public final int T0() {
        if (this.f7466n.f7421q.y()) {
            return -1;
        }
        u1 u1Var = this.f7466n.f7421q;
        int U = U();
        w3 w3Var = this.f7466n;
        int i10 = w3Var.f7419o;
        if (i10 == 1) {
            i10 = 0;
        }
        return u1Var.n(U, i10, w3Var.f7420p);
    }

    public final int U() {
        int i10 = this.f7466n.f7414j.f7117h.f6431i;
        if (i10 == -1) {
            return 0;
        }
        return i10;
    }

    public final k U0(u1 u1Var, int i10, long j10) {
        if (u1Var.y()) {
            return null;
        }
        t1 t1Var = new t1();
        g1.r1 r1Var = new g1.r1();
        if (i10 == -1 || i10 >= u1Var.x()) {
            i10 = u1Var.j(this.f7466n.f7420p);
            j10 = u1Var.v(i10, t1Var).i();
        }
        long H = l0.H(j10);
        a.c(i10, u1Var.x());
        u1Var.v(i10, t1Var);
        if (H == -9223372036854775807L) {
            H = t1Var.f6587t;
            if (H == -9223372036854775807L) {
                return null;
            }
        }
        int i11 = t1Var.f6589v;
        u1Var.o(i11, r1Var, false);
        while (i11 < t1Var.f6590w && r1Var.f6546l != H) {
            int i12 = i11 + 1;
            if (u1Var.o(i12, r1Var, false).f6546l > H) {
                break;
            }
            i11 = i12;
        }
        u1Var.o(i11, r1Var, false);
        return new k(i11, H - r1Var.f6546l, 0);
    }

    public final q V() {
        return this.f7466n.f7427w;
    }

    public final int V0() {
        if (this.f7466n.f7421q.y()) {
            return -1;
        }
        u1 u1Var = this.f7466n.f7421q;
        int U = U();
        w3 w3Var = this.f7466n;
        int i10 = w3Var.f7419o;
        if (i10 == 1) {
            i10 = 0;
        }
        return u1Var.t(U, i10, w3Var.f7420p);
    }

    public final void W() {
        if (W0(26)) {
            R0(new l0(this, 2));
            w3 w3Var = this.f7466n;
            int i10 = w3Var.f7428x - 1;
            if (i10 >= w3Var.f7427w.f6520i) {
                this.f7466n = w3Var.i(i10, w3Var.f7429y);
                n0 n0Var = new n0(this, i10, 0);
                e eVar = this.f7461i;
                eVar.j(30, n0Var);
                eVar.g();
            }
        }
    }

    public final boolean W0(int i10) {
        if (this.f7470r.i(i10)) {
            return true;
        }
        android.support.v4.media.h.z("Controller isn't allowed to call command= ", i10, "MCImplBase");
        return false;
    }

    public final void X(boolean z10) {
        if (W0(26)) {
            R0(new m0(this, z10, 1));
            w3 w3Var = this.f7466n;
            if (w3Var.f7429y != z10) {
                this.f7466n = w3Var.i(w3Var.f7428x, z10);
                m0 m0Var = new m0(this, z10, 2);
                e eVar = this.f7461i;
                eVar.j(30, m0Var);
                eVar.g();
            }
        }
    }

    public final boolean Y() {
        return V0() != -1;
    }

    public final int Z() {
        return this.f7466n.f7414j.f7117h.f6438p;
    }

    public final void Z0(int i10, int i11) {
        c0 c0Var = this.f7474v;
        if (c0Var.f8418a != i10 || c0Var.f8419b != i11) {
            this.f7474v = new c0(i10, i11);
            this.f7461i.m(24, new y(i10, i11, 1));
        }
    }

    public final void a() {
        r rVar = this.f7475w;
        if (!this.f7465m) {
            this.f7465m = true;
            n nVar = this.f7462j;
            if (((Handler) nVar.f337i).hasMessages(1)) {
                try {
                    Object obj = nVar.f338j;
                    ((y0) obj).f7475w.W(((y0) obj).f7455c);
                } catch (RemoteException unused) {
                    v.g("MCImplBase", "Error in sending flushCommandQueue");
                }
            }
            ((Handler) nVar.f337i).removeCallbacksAndMessages((Object) null);
            this.f7475w = null;
            if (rVar != null) {
                int a10 = this.f7454b.a();
                try {
                    rVar.asBinder().unlinkToDeath(this.f7459g, 0);
                    rVar.q0(this.f7455c, a10);
                } catch (RemoteException unused2) {
                }
            }
            this.f7461i.k();
            e4 e4Var = this.f7454b;
            androidx.activity.e eVar = new androidx.activity.e(14, this);
            synchronized (e4Var.f7006a) {
                Handler k10 = l0.k((Handler.Callback) null);
                e4Var.f7010e = k10;
                e4Var.f7009d = eVar;
                if (e4Var.f7008c.isEmpty()) {
                    e4Var.b();
                } else {
                    k10.postDelayed(new androidx.activity.e(16, e4Var), 30000);
                }
            }
        }
    }

    public final void a0(SurfaceView surfaceView) {
        SurfaceHolder surfaceHolder;
        if (W0(27)) {
            if (surfaceView == null) {
                surfaceHolder = null;
            } else {
                surfaceHolder = surfaceView.getHolder();
            }
            if (W0(27)) {
                if (surfaceHolder == null) {
                    O0();
                } else if (this.f7472t != surfaceHolder) {
                    N0();
                    this.f7472t = surfaceHolder;
                    surfaceHolder.addCallback(this.f7460h);
                    Surface surface = surfaceHolder.getSurface();
                    if (surface == null || !surface.isValid()) {
                        this.f7471s = null;
                        S0(new l0(this, 15));
                        Z0(0, 0);
                        return;
                    }
                    this.f7471s = surface;
                    S0(new d0(this, surface, 1));
                    Rect surfaceFrame = surfaceHolder.getSurfaceFrame();
                    Z0(surfaceFrame.width(), surfaceFrame.height());
                }
            }
        }
    }

    public final void a1() {
        boolean z10;
        long j10 = this.f7477y;
        w3 w3Var = this.f7466n;
        i4 i4Var = w3Var.f7414j;
        if (j10 < i4Var.f7119j) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!w3Var.B) {
            if (z10 || this.f7476x == -9223372036854775807L) {
                this.f7476x = i4Var.f7117h.f6435m;
            }
        } else if (z10 || this.f7476x == -9223372036854775807L) {
            long j11 = this.f7453a.f6927f;
            if (j11 == -9223372036854775807L) {
                j11 = SystemClock.elapsedRealtime() - this.f7466n.f7414j.f7119j;
            }
            w3 w3Var2 = this.f7466n;
            i4 i4Var2 = w3Var2.f7414j;
            long j12 = i4Var2.f7117h.f6435m + ((long) (((float) j11) * w3Var2.f7418n.f6355h));
            long j13 = i4Var2.f7120k;
            if (j13 != -9223372036854775807L) {
                j12 = Math.min(j12, j13);
            }
            this.f7476x = j12;
        }
    }

    public final int b() {
        return this.f7466n.E;
    }

    public final void b0(s0 s0Var) {
        if (W0(31)) {
            R0(new z1.e(this, s0Var, true, 2));
            g1(Collections.singletonList(s0Var), -1, -9223372036854775807L, true);
        }
    }

    public final void b1(int i10, int i11, int i12) {
        u1 u1Var = this.f7466n.f7421q;
        int x10 = u1Var.x();
        int min = Math.min(i11, x10);
        int i13 = min - i10;
        int min2 = Math.min(i12, x10 - i13);
        if (i10 < x10 && i10 != min && i10 != min2) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (int i14 = 0; i14 < x10; i14++) {
                arrayList.add(u1Var.v(i14, new t1()));
            }
            l0.G(arrayList, i10, min, min2);
            c1(u1Var, arrayList, arrayList2);
            s1 P0 = P0(arrayList, arrayList2);
            if (!P0.y()) {
                int U = U();
                int i15 = (U < i10 || U >= min) ? (min > U || min2 <= U) ? (min <= U || min2 > U) ? U : i13 + U : U - i13 : (U - i10) + min2;
                t1 t1Var = new t1();
                i1(X0(this.f7466n, P0, i15, (this.f7466n.f7414j.f7117h.f6434l - u1Var.v(U, t1Var).f6589v) + P0.v(i15, t1Var).f6589v, 5), false, 5, false, 0);
            }
        }
    }

    public final boolean c() {
        return this.f7466n.C;
    }

    public final void c0(SurfaceView surfaceView) {
        SurfaceHolder surfaceHolder;
        if (W0(27)) {
            if (surfaceView == null) {
                surfaceHolder = null;
            } else {
                surfaceHolder = surfaceView.getHolder();
            }
            if (W0(27) && surfaceHolder != null && this.f7472t == surfaceHolder) {
                O0();
            }
        }
    }

    public final void d(e1 e1Var) {
        if (W0(13)) {
            R0(new g(this, 15, e1Var));
            if (!this.f7466n.f7418n.equals(e1Var)) {
                this.f7466n = this.f7466n.k(e1Var);
                o0 o0Var = new o0(0, e1Var);
                e eVar = this.f7461i;
                eVar.j(12, o0Var);
                eVar.g();
            }
        }
    }

    public final void d0(int i10, int i11) {
        if (W0(20)) {
            a.b(i10 >= 0 && i11 >= 0);
            R0(new s0(this, i10, i11, 0));
            b1(i10, i10 + 1, i11);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0094, code lost:
        r4 = -1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void d1(int r45, int r46) {
        /*
            r44 = this;
            r6 = r44
            r0 = r45
            h3.w3 r1 = r6.f7466n
            g1.u1 r1 = r1.f7421q
            int r2 = r1.x()
            r3 = r46
            int r3 = java.lang.Math.min(r3, r2)
            if (r0 >= r2) goto L_0x016f
            if (r0 != r3) goto L_0x0018
            goto L_0x016f
        L_0x0018:
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            r7 = 0
        L_0x0023:
            int r8 = r1.x()
            if (r7 >= r8) goto L_0x003c
            if (r7 < r0) goto L_0x002d
            if (r7 < r3) goto L_0x0039
        L_0x002d:
            g1.t1 r8 = new g1.t1
            r8.<init>()
            g1.t1 r8 = r1.v(r7, r8)
            r2.add(r8)
        L_0x0039:
            int r7 = r7 + 1
            goto L_0x0023
        L_0x003c:
            c1(r1, r2, r4)
            g1.s1 r2 = P0(r2, r4)
            int r4 = r44.U()
            h3.w3 r7 = r6.f7466n
            h3.i4 r7 = r7.f7414j
            g1.j1 r7 = r7.f7117h
            int r7 = r7.f6434l
            int r8 = r44.U()
            r9 = 1
            if (r8 < r0) goto L_0x005e
            int r8 = r44.U()
            if (r8 >= r3) goto L_0x005e
            r8 = 1
            goto L_0x005f
        L_0x005e:
            r8 = 0
        L_0x005f:
            g1.t1 r10 = new g1.t1
            r10.<init>()
            boolean r11 = r1.y()
            if (r11 == 0) goto L_0x006c
            goto L_0x016f
        L_0x006c:
            boolean r11 = r2.y()
            r12 = -1
            if (r11 == 0) goto L_0x0076
            r7 = 0
            r15 = -1
            goto L_0x00ca
        L_0x0076:
            if (r8 == 0) goto L_0x00ac
            h3.w3 r7 = r6.f7466n
            int r11 = r7.f7419o
            int r13 = r1.x()
            r14 = 0
        L_0x0081:
            if (r14 >= r13) goto L_0x0094
            boolean r15 = r7.f7420p
            int r4 = r1.n(r4, r11, r15)
            if (r4 != r12) goto L_0x008c
            goto L_0x0094
        L_0x008c:
            if (r4 < r0) goto L_0x0095
            if (r4 < r3) goto L_0x0091
            goto L_0x0095
        L_0x0091:
            int r14 = r14 + 1
            goto L_0x0081
        L_0x0094:
            r4 = -1
        L_0x0095:
            if (r4 != r12) goto L_0x00a0
            h3.w3 r4 = r6.f7466n
            boolean r4 = r4.f7420p
            int r4 = r2.j(r4)
            goto L_0x00a5
        L_0x00a0:
            if (r4 < r3) goto L_0x00a5
            int r7 = r3 - r0
            int r4 = r4 - r7
        L_0x00a5:
            g1.t1 r7 = r2.v(r4, r10)
            int r7 = r7.f6589v
            goto L_0x00c9
        L_0x00ac:
            if (r4 < r3) goto L_0x00c9
            int r10 = r3 - r0
            int r4 = r4 - r10
            if (r7 != r12) goto L_0x00b4
            goto L_0x00c9
        L_0x00b4:
            r10 = r0
        L_0x00b5:
            if (r10 >= r3) goto L_0x00c9
            g1.t1 r11 = new g1.t1
            r11.<init>()
            r1.v(r10, r11)
            int r13 = r11.f6590w
            int r11 = r11.f6589v
            int r13 = r13 - r11
            int r13 = r13 + r9
            int r7 = r7 - r13
            int r10 = r10 + 1
            goto L_0x00b5
        L_0x00c9:
            r15 = r4
        L_0x00ca:
            if (r8 == 0) goto L_0x012f
            if (r15 != r12) goto L_0x00d5
            g1.j1 r7 = h3.i4.f7108r
            h3.w3 r10 = r6.f7466n
            h3.i4 r11 = h3.i4.f7109s
            goto L_0x0129
        L_0x00d5:
            g1.t1 r10 = new g1.t1
            r10.<init>()
            g1.t1 r10 = r2.v(r15, r10)
            long r11 = r10.i()
            r32 = r11
            r41 = r11
            long r13 = r10.j()
            r39 = r13
            r30 = r13
            g1.j1 r43 = new g1.j1
            r26 = r43
            r16 = 0
            g1.s0 r10 = r10.f6577j
            r17 = 0
            r23 = -1
            r24 = -1
            r4 = r13
            r13 = r43
            r14 = r16
            r16 = r10
            r18 = r7
            r19 = r11
            r21 = r11
            r13.<init>(r14, r15, r16, r17, r18, r19, r21, r23, r24)
            h3.w3 r10 = r6.f7466n
            h3.i4 r7 = new h3.i4
            r25 = r7
            r27 = 0
            long r28 = android.os.SystemClock.elapsedRealtime()
            int r34 = h3.t3.b(r11, r4)
            r35 = 0
            r37 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r25.<init>(r26, r27, r28, r30, r32, r34, r35, r37, r39, r41)
            r11 = r7
            r7 = r43
        L_0x0129:
            r4 = 4
            h3.w3 r2 = Y0(r10, r2, r7, r11, r4)
            goto L_0x0136
        L_0x012f:
            r4 = 4
            h3.w3 r5 = r6.f7466n
            h3.w3 r2 = X0(r5, r2, r15, r7, r4)
        L_0x0136:
            int r5 = r2.E
            if (r5 == r9) goto L_0x014c
            if (r5 == r4) goto L_0x014c
            if (r0 >= r3) goto L_0x014c
            int r1 = r1.x()
            if (r3 != r1) goto L_0x014c
            int r1 = r44.U()
            if (r1 < r0) goto L_0x014c
            r1 = 1
            goto L_0x014d
        L_0x014c:
            r1 = 0
        L_0x014d:
            if (r1 == 0) goto L_0x0156
            r1 = 0
            r4 = 4
            h3.w3 r1 = r2.l(r4, r1)
            goto L_0x0157
        L_0x0156:
            r1 = r2
        L_0x0157:
            r4 = 4
            h3.w3 r2 = r6.f7466n
            h3.i4 r2 = r2.f7414j
            g1.j1 r2 = r2.f7117h
            int r2 = r2.f6431i
            if (r2 < r0) goto L_0x0165
            if (r2 >= r3) goto L_0x0165
            goto L_0x0166
        L_0x0165:
            r9 = 0
        L_0x0166:
            r5 = 3
            r0 = r44
            r2 = r8
            r3 = r4
            r4 = r9
            r0.i1(r1, r2, r3, r4, r5)
        L_0x016f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: h3.y0.d1(int, int):void");
    }

    public final void e() {
        int i10 = 2;
        if (W0(2)) {
            R0(new l0(this, 5));
            w3 w3Var = this.f7466n;
            if (w3Var.E == 1) {
                if (w3Var.f7421q.y()) {
                    i10 = 4;
                }
                i1(w3Var.l(i10, (d1) null), false, 5, false, 0);
            }
        }
    }

    public final void e0(int i10, int i11, int i12) {
        if (W0(20)) {
            a.b(i10 >= 0 && i10 <= i11 && i12 >= 0);
            R0(new q0(this, i10, i11, i12));
            b1(i10, i11, i12);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:51:0x020e  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0210  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0224  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0226  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0229 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x022a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void e1(int r53, long r54) {
        /*
            r52 = this;
            r6 = r52
            r0 = r53
            r1 = r54
            h3.w3 r3 = r6.f7466n
            g1.u1 r3 = r3.f7421q
            boolean r4 = r3.y()
            if (r4 != 0) goto L_0x0016
            int r4 = r3.x()
            if (r0 >= r4) goto L_0x001c
        L_0x0016:
            boolean r4 = r52.o()
            if (r4 == 0) goto L_0x001d
        L_0x001c:
            return
        L_0x001d:
            h3.w3 r4 = r6.f7466n
            int r5 = r4.E
            r15 = 1
            if (r5 != r15) goto L_0x0026
            r5 = 1
            goto L_0x0027
        L_0x0026:
            r5 = 2
        L_0x0027:
            g1.d1 r7 = r4.f7412h
            h3.w3 r4 = r4.l(r5, r7)
            a2.k r5 = r6.U0(r3, r0, r1)
            r13 = 0
            r12 = 0
            if (r5 != 0) goto L_0x00a8
            g1.j1 r3 = new g1.j1
            r8 = 0
            r10 = 0
            r11 = 0
            r4 = 0
            r16 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r5 = (r1 > r16 ? 1 : (r1 == r16 ? 0 : -1))
            if (r5 != 0) goto L_0x0048
            r16 = r13
            goto L_0x004a
        L_0x0048:
            r16 = r1
        L_0x004a:
            if (r5 != 0) goto L_0x004f
            r18 = r13
            goto L_0x0051
        L_0x004f:
            r18 = r1
        L_0x0051:
            r20 = -1
            r21 = -1
            r7 = r3
            r9 = r53
            r0 = 0
            r12 = r4
            r13 = r16
            r4 = 1
            r15 = r18
            r17 = r20
            r18 = r21
            r7.<init>(r8, r9, r10, r11, r12, r13, r15, r17, r18)
            h3.w3 r7 = r6.f7466n
            g1.u1 r8 = r7.f7421q
            h3.i4 r9 = new h3.i4
            h3.w3 r10 = r6.f7466n
            h3.i4 r10 = r10.f7414j
            boolean r10 = r10.f7118i
            long r19 = android.os.SystemClock.elapsedRealtime()
            h3.w3 r11 = r6.f7466n
            h3.i4 r11 = r11.f7414j
            long r12 = r11.f7120k
            if (r5 != 0) goto L_0x0081
            r23 = 0
            goto L_0x0083
        L_0x0081:
            r23 = r1
        L_0x0083:
            r25 = 0
            r26 = 0
            long r14 = r11.f7124o
            long r0 = r11.f7125p
            if (r5 != 0) goto L_0x0090
            r32 = 0
            goto L_0x0092
        L_0x0090:
            r32 = r54
        L_0x0092:
            r16 = r9
            r17 = r3
            r18 = r10
            r21 = r12
            r28 = r14
            r30 = r0
            r16.<init>(r17, r18, r19, r21, r23, r25, r26, r28, r30, r32)
            h3.w3 r0 = Y0(r7, r8, r3, r9, r4)
            r4 = r0
            r0 = 1
            goto L_0x00de
        L_0x00a8:
            r0 = 1
            h3.i4 r1 = r4.f7414j
            g1.j1 r7 = r1.f7117h
            int r13 = r7.f6434l
            int r7 = r5.f59a
            g1.r1 r8 = new g1.r1
            r8.<init>()
            r2 = 0
            r3.o(r13, r8, r2)
            g1.r1 r14 = new g1.r1
            r14.<init>()
            r3.o(r7, r14, r2)
            if (r13 == r7) goto L_0x00c7
            r26 = 1
            goto L_0x00c9
        L_0x00c7:
            r26 = 0
        L_0x00c9:
            r52.a1()
            long r9 = r6.f7476x
            long r9 = j1.l0.H(r9)
            long r11 = r8.f6546l
            long r27 = r9 - r11
            long r11 = r5.f60b
            if (r26 != 0) goto L_0x00e2
            int r5 = (r11 > r27 ? 1 : (r11 == r27 ? 0 : -1))
            if (r5 != 0) goto L_0x00e2
        L_0x00de:
            r1 = r4
            r3 = 0
            goto L_0x01f4
        L_0x00e2:
            g1.j1 r1 = r1.f7117h
            int r5 = r1.f6437o
            r9 = -1
            if (r5 != r9) goto L_0x00eb
            r15 = 1
            goto L_0x00ec
        L_0x00eb:
            r15 = 0
        L_0x00ec:
            j1.a.e(r15)
            g1.j1 r5 = new g1.j1
            int r10 = r8.f6544j
            g1.s0 r1 = r1.f6432j
            r20 = r3
            long r2 = r8.f6546l
            long r2 = r2 + r27
            long r2 = j1.l0.Q(r2)
            long r8 = r8.f6546l
            long r8 = r8 + r27
            long r16 = j1.l0.Q(r8)
            r24 = -1
            r25 = -1
            r15 = 0
            r18 = -1
            r19 = -1
            r9 = 0
            r8 = r5
            r29 = r11
            r11 = r1
            r12 = r15
            r1 = r14
            r14 = r2
            r8.<init>(r9, r10, r11, r12, r13, r14, r16, r18, r19)
            r2 = r20
            r3 = 0
            r2.o(r7, r1, r3)
            g1.t1 r8 = new g1.t1
            r8.<init>()
            int r9 = r1.f6544j
            r2.v(r9, r8)
            g1.j1 r2 = new g1.j1
            r15 = 0
            int r9 = r1.f6544j
            g1.s0 r10 = r8.f6577j
            r18 = 0
            long r11 = r1.f6546l
            long r11 = r11 + r29
            long r20 = j1.l0.Q(r11)
            long r11 = r1.f6546l
            long r11 = r11 + r29
            long r22 = j1.l0.Q(r11)
            r14 = r2
            r16 = r9
            r17 = r10
            r19 = r7
            r14.<init>(r15, r16, r17, r18, r19, r20, r22, r24, r25)
            h3.u3 r7 = new h3.u3
            r7.<init>(r4)
            r7.f7343d = r5
            r7.f7344e = r2
            r7.f7345f = r0
            h3.w3 r4 = r7.a()
            if (r26 != 0) goto L_0x01b1
            int r5 = (r29 > r27 ? 1 : (r29 == r27 ? 0 : -1))
            if (r5 >= 0) goto L_0x0164
            goto L_0x01b1
        L_0x0164:
            h3.i4 r1 = r4.f7414j
            long r9 = r1.f7123n
            long r9 = j1.l0.H(r9)
            long r11 = r29 - r27
            long r9 = r9 - r11
            r11 = 0
            long r9 = java.lang.Math.max(r11, r9)
            long r11 = r29 + r9
            h3.i4 r1 = new h3.i4
            r34 = r1
            r36 = 0
            long r37 = android.os.SystemClock.elapsedRealtime()
            long r39 = r8.j()
            long r41 = j1.l0.Q(r11)
            long r13 = j1.l0.Q(r11)
            long r7 = r8.j()
            int r43 = h3.t3.b(r13, r7)
            long r44 = j1.l0.Q(r9)
            r46 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r48 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            long r50 = j1.l0.Q(r11)
            r35 = r2
            r34.<init>(r35, r36, r37, r39, r41, r43, r44, r46, r48, r50)
            h3.w3 r1 = r4.m(r1)
            goto L_0x01f4
        L_0x01b1:
            h3.i4 r5 = new h3.i4
            r34 = r5
            r36 = 0
            long r37 = android.os.SystemClock.elapsedRealtime()
            long r39 = r8.j()
            long r9 = r1.f6546l
            long r9 = r9 + r29
            long r41 = j1.l0.Q(r9)
            long r9 = r1.f6546l
            long r9 = r9 + r29
            long r9 = j1.l0.Q(r9)
            long r7 = r8.j()
            int r43 = h3.t3.b(r9, r7)
            r44 = 0
            r46 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r48 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            long r7 = r1.f6546l
            long r7 = r7 + r29
            long r50 = j1.l0.Q(r7)
            r35 = r2
            r34.<init>(r35, r36, r37, r39, r41, r43, r44, r46, r48, r50)
            h3.w3 r1 = r4.m(r5)
        L_0x01f4:
            h3.w3 r2 = r6.f7466n
            g1.u1 r2 = r2.f7421q
            boolean r2 = r2.y()
            h3.i4 r4 = r1.f7414j
            if (r2 != 0) goto L_0x0210
            g1.j1 r2 = r4.f7117h
            int r2 = r2.f6431i
            h3.w3 r5 = r6.f7466n
            h3.i4 r5 = r5.f7414j
            g1.j1 r5 = r5.f7117h
            int r5 = r5.f6431i
            if (r2 == r5) goto L_0x0210
            r5 = 1
            goto L_0x0211
        L_0x0210:
            r5 = 0
        L_0x0211:
            if (r5 != 0) goto L_0x0226
            g1.j1 r2 = r4.f7117h
            long r7 = r2.f6435m
            h3.w3 r2 = r6.f7466n
            h3.i4 r2 = r2.f7414j
            g1.j1 r2 = r2.f7117h
            long r9 = r2.f6435m
            int r2 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r2 == 0) goto L_0x0224
            goto L_0x0226
        L_0x0224:
            r2 = 0
            goto L_0x0227
        L_0x0226:
            r2 = 1
        L_0x0227:
            if (r2 != 0) goto L_0x022a
            return
        L_0x022a:
            r3 = 1
            r7 = 2
            r0 = r52
            r4 = r5
            r5 = r7
            r0.i1(r1, r2, r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: h3.y0.e1(int, long):void");
    }

    public final void f(int i10) {
        if (W0(15)) {
            R0(new n0(this, i10, 1));
            w3 w3Var = this.f7466n;
            if (w3Var.f7419o != i10) {
                u3 u3Var = new u3(w3Var);
                u3Var.f7347h = i10;
                this.f7466n = u3Var.a();
                m1.e0 e0Var = new m1.e0(i10, 2);
                e eVar = this.f7461i;
                eVar.j(8, e0Var);
                eVar.g();
            }
        }
    }

    public final int f0() {
        return this.f7466n.D;
    }

    public final void f1(long j10) {
        a1();
        long j11 = this.f7476x + j10;
        long i02 = i0();
        if (i02 != -9223372036854775807L) {
            j11 = Math.min(j11, i02);
        }
        e1(U(), Math.max(j11, 0));
    }

    public final void g() {
        if (W0(1)) {
            R0(new l0(this, 1));
            h1(false);
        }
    }

    public final void g0(List list) {
        if (W0(20)) {
            R0(new g(this, 18, list));
            M0(list, this.f7466n.f7421q.x());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x010f  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x019f  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x01a2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void g1(java.util.List r67, int r68, long r69, boolean r71) {
        /*
            r66 = this;
            r6 = r66
            r0 = r67
            r1 = r68
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            r4 = 0
            r5 = 0
        L_0x0012:
            int r7 = r67.size()
            if (r5 >= r7) goto L_0x006a
            java.lang.Object r7 = r0.get(r5)
            r9 = r7
            g1.s0 r9 = (g1.s0) r9
            e1.h r7 = h3.t3.f7332a
            g1.t1 r15 = new g1.t1
            r7 = r15
            r15.<init>()
            java.lang.Integer r8 = java.lang.Integer.valueOf(r4)
            r10 = 0
            r11 = 0
            r13 = 0
            r16 = 0
            r4 = r15
            r15 = r16
            r17 = 1
            r18 = 0
            r19 = 0
            r20 = 0
            r22 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r26 = 0
            r24 = r5
            r25 = r5
            r7.l(r8, r9, r10, r11, r13, r15, r17, r18, r19, r20, r22, r24, r25, r26)
            r2.add(r4)
            g1.r1 r4 = new g1.r1
            r4.<init>()
            r8 = 0
            r9 = 0
            r11 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            g1.c r15 = g1.c.f6321n
            r16 = 1
            r7 = r4
            r10 = r5
            r7.q(r8, r9, r10, r11, r13, r15, r16)
            r3.add(r4)
            int r5 = r5 + 1
            r4 = 0
            goto L_0x0012
        L_0x006a:
            g1.s1 r2 = P0(r2, r3)
            boolean r3 = r2.y()
            if (r3 != 0) goto L_0x0081
            int r3 = r2.x()
            if (r1 >= r3) goto L_0x007b
            goto L_0x0081
        L_0x007b:
            g1.e0 r0 = new g1.e0
            r0.<init>()
            throw r0
        L_0x0081:
            r3 = 1
            r4 = -1
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r71 == 0) goto L_0x0094
            h3.w3 r1 = r6.f7466n
            boolean r1 = r1.f7420p
            int r1 = r2.j(r1)
            r9 = r7
            goto L_0x00b5
        L_0x0094:
            if (r1 != r4) goto L_0x00b3
            h3.w3 r1 = r6.f7466n
            h3.i4 r1 = r1.f7414j
            g1.j1 r1 = r1.f7117h
            int r5 = r1.f6431i
            int r9 = r2.x()
            if (r5 < r9) goto L_0x00af
            h3.w3 r1 = r6.f7466n
            boolean r1 = r1.f7420p
            int r1 = r2.j(r1)
            r9 = r7
            r5 = 1
            goto L_0x00b6
        L_0x00af:
            long r9 = r1.f6435m
            r1 = r5
            goto L_0x00b5
        L_0x00b3:
            r9 = r69
        L_0x00b5:
            r5 = 0
        L_0x00b6:
            a2.k r11 = r6.U0(r2, r1, r9)
            if (r11 != 0) goto L_0x010f
            g1.j1 r0 = new g1.j1
            r12 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r23 = 0
            int r25 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r25 != 0) goto L_0x00cc
            r17 = r23
            goto L_0x00ce
        L_0x00cc:
            r17 = r9
        L_0x00ce:
            if (r25 != 0) goto L_0x00d3
            r19 = r23
            goto L_0x00d5
        L_0x00d3:
            r19 = r9
        L_0x00d5:
            r21 = -1
            r22 = -1
            r11 = r0
            r13 = r1
            r11.<init>(r12, r13, r14, r15, r16, r17, r19, r21, r22)
            h3.i4 r7 = new h3.i4
            r31 = 0
            long r32 = android.os.SystemClock.elapsedRealtime()
            r34 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r25 != 0) goto L_0x00f0
            r36 = r23
            goto L_0x00f2
        L_0x00f0:
            r36 = r9
        L_0x00f2:
            r38 = 0
            r39 = 0
            r41 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r43 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r25 != 0) goto L_0x0105
            r45 = r23
            goto L_0x0107
        L_0x0105:
            r45 = r9
        L_0x0107:
            r29 = r7
            r30 = r0
            r29.<init>(r30, r31, r32, r34, r36, r38, r39, r41, r43, r45)
            goto L_0x0160
        L_0x010f:
            g1.j1 r7 = new g1.j1
            r48 = r7
            r12 = 0
            java.lang.Object r0 = r0.get(r1)
            r14 = r0
            g1.s0 r14 = (g1.s0) r14
            r15 = 0
            int r0 = r11.f59a
            long r8 = r11.f60b
            long r17 = j1.l0.Q(r8)
            long r19 = j1.l0.Q(r8)
            r21 = -1
            r22 = -1
            r11 = r7
            r13 = r1
            r16 = r0
            r11.<init>(r12, r13, r14, r15, r16, r17, r19, r21, r22)
            h3.i4 r0 = new h3.i4
            r47 = r0
            r49 = 0
            long r50 = android.os.SystemClock.elapsedRealtime()
            r52 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            long r54 = j1.l0.Q(r8)
            r56 = 0
            r57 = 0
            r59 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r61 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            long r63 = j1.l0.Q(r8)
            r47.<init>(r48, r49, r50, r52, r54, r56, r57, r59, r61, r63)
            r65 = r7
            r7 = r0
            r0 = r65
        L_0x0160:
            h3.w3 r8 = r6.f7466n
            r9 = 4
            h3.w3 r0 = Y0(r8, r2, r0, r7, r9)
            int r7 = r0.E
            if (r1 == r4) goto L_0x0178
            if (r7 == r3) goto L_0x0178
            boolean r1 = r2.y()
            if (r1 != 0) goto L_0x0179
            if (r5 == 0) goto L_0x0176
            goto L_0x0179
        L_0x0176:
            r9 = 2
            goto L_0x0179
        L_0x0178:
            r9 = r7
        L_0x0179:
            h3.w3 r1 = r6.f7466n
            g1.d1 r1 = r1.f7412h
            h3.w3 r1 = r0.l(r9, r1)
            h3.w3 r0 = r6.f7466n
            g1.u1 r0 = r0.f7421q
            boolean r0 = r0.y()
            r2 = r0 ^ 1
            r4 = 4
            h3.w3 r0 = r6.f7466n
            g1.u1 r0 = r0.f7421q
            boolean r0 = r0.y()
            if (r0 == 0) goto L_0x01a2
            g1.u1 r0 = r1.f7421q
            boolean r0 = r0.y()
            if (r0 != 0) goto L_0x019f
            goto L_0x01a2
        L_0x019f:
            r28 = 0
            goto L_0x01a4
        L_0x01a2:
            r28 = 1
        L_0x01a4:
            r5 = 3
            r0 = r66
            r3 = r4
            r4 = r28
            r0.i1(r1, r2, r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: h3.y0.g1(java.util.List, int, long, boolean):void");
    }

    public final int h() {
        return this.f7466n.f7419o;
    }

    public final void h0(s0 s0Var) {
        if (W0(31)) {
            R0(new g(this, 16, s0Var));
            g1(Collections.singletonList(s0Var), -1, -9223372036854775807L, true);
        }
    }

    public final void h1(boolean z10) {
        w3 w3Var = this.f7466n;
        if (w3Var.f7430z != z10 || w3Var.D != 0) {
            a1();
            this.f7477y = SystemClock.elapsedRealtime();
            i1(this.f7466n.j(1, 0, z10), false, 5, false, 0);
        }
    }

    public final e1 i() {
        return this.f7466n.f7418n;
    }

    public final long i0() {
        return this.f7466n.f7414j.f7120k;
    }

    public final void i1(w3 w3Var, boolean z10, int i10, boolean z11, int i11) {
        w3 w3Var2 = this.f7466n;
        this.f7466n = w3Var;
        e eVar = this.f7461i;
        if (z11) {
            eVar.j(1, new h0(w3Var, i11, 0));
        }
        if (z10) {
            eVar.j(11, new h0(w3Var, i10, 1));
        }
        if (!w3Var2.f7421q.equals(w3Var.f7421q)) {
            eVar.j(0, new h0(w3Var, 0, 2));
        }
        if (w3Var2.E != w3Var.E) {
            android.support.v4.media.h.x(w3Var, 0, eVar, 4);
        }
        if (w3Var2.f7430z != w3Var.f7430z) {
            eVar.j(5, new h0(w3Var, 1, 3));
        }
        if (w3Var2.D != w3Var.D) {
            android.support.v4.media.h.x(w3Var, 1, eVar, 6);
        }
        if (w3Var2.B != w3Var.B) {
            android.support.v4.media.h.x(w3Var, 2, eVar, 7);
        }
        eVar.g();
    }

    public final long j() {
        a1();
        return this.f7476x;
    }

    public final u1 j0() {
        return this.f7466n.f7421q;
    }

    public final d1 k() {
        return this.f7466n.f7412h;
    }

    public final boolean k0() {
        return this.f7466n.f7429y;
    }

    public final int l() {
        return this.f7466n.f7428x;
    }

    public final void l0(v0 v0Var) {
        if (W0(19)) {
            R0(new g(this, 17, v0Var));
            if (!this.f7466n.f7423s.equals(v0Var)) {
                w3 w3Var = this.f7466n;
                u3 g10 = android.support.v4.media.h.g(w3Var, w3Var);
                g10.f7351l = v0Var;
                this.f7466n = g10.a();
                m1.c0 c0Var = new m1.c0(1, v0Var);
                e eVar = this.f7461i;
                eVar.j(15, c0Var);
                eVar.g();
            }
        }
    }

    public final void m(boolean z10) {
        if (W0(1)) {
            R0(new m0(this, z10, 0));
            h1(z10);
        }
    }

    public final void m0(int i10) {
        if (W0(20)) {
            a.b(i10 >= 0);
            R0(new n0(this, i10, 6));
            d1(i10, i10 + 1);
        }
    }

    public final void n(Surface surface) {
        if (W0(27)) {
            N0();
            this.f7471s = surface;
            int i10 = 0;
            S0(new d0(this, surface, 0));
            if (surface != null) {
                i10 = -1;
            }
            Z0(i10, i10);
        }
    }

    public final void n0() {
        if (W0(26)) {
            R0(new l0(this, 12));
            w3 w3Var = this.f7466n;
            int i10 = w3Var.f7428x + 1;
            if (i10 <= w3Var.f7427w.f6521j) {
                this.f7466n = w3Var.i(i10, w3Var.f7429y);
                n0 n0Var = new n0(this, i10, 2);
                e eVar = this.f7461i;
                eVar.j(30, n0Var);
                eVar.g();
            }
        }
    }

    public final boolean o() {
        return this.f7466n.f7414j.f7118i;
    }

    public final boolean o0() {
        return this.f7466n.f7420p;
    }

    public final void p(int i10) {
        if (W0(10)) {
            a.b(i10 >= 0);
            R0(new n0(this, i10, 5));
            e1(i10, -9223372036854775807L);
        }
    }

    public final y1 p0() {
        return this.f7466n.K;
    }

    public final long q() {
        return this.f7466n.H;
    }

    public final void q0(long j10) {
        if (W0(5)) {
            R0(new t0(j10, this));
            e1(U(), j10);
        }
    }

    public final void r(y1 y1Var) {
        if (W0(29)) {
            R0(new g(this, 14, y1Var));
            w3 w3Var = this.f7466n;
            if (y1Var != w3Var.K) {
                u3 u3Var = new u3(w3Var);
                u3Var.D = y1Var;
                this.f7466n = u3Var.a();
                m1.v vVar = new m1.v(1, y1Var);
                e eVar = this.f7461i;
                eVar.j(19, vVar);
                eVar.g();
            }
        }
    }

    public final long r0() {
        return this.f7466n.f7414j.f7126q;
    }

    public final long s() {
        return this.f7466n.f7414j.f7124o;
    }

    public final void s0(int i10, int i11) {
        if (W0(20)) {
            a.b(i10 >= 0 && i11 >= i10);
            R0(new s0(this, i10, i11, 1));
            d1(i10, i11);
        }
    }

    public final void stop() {
        if (W0(3)) {
            R0(new l0(this, 4));
            w3 w3Var = this.f7466n;
            i4 i4Var = this.f7466n.f7414j;
            j1 j1Var = i4Var.f7117h;
            boolean z10 = i4Var.f7118i;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            i4 i4Var2 = this.f7466n.f7414j;
            long j10 = i4Var2.f7120k;
            long j11 = i4Var2.f7117h.f6435m;
            int b10 = t3.b(j11, j10);
            i4 i4Var3 = this.f7466n.f7414j;
            i4 i4Var4 = r3;
            i4 i4Var5 = new i4(j1Var, z10, elapsedRealtime, j10, j11, b10, 0, i4Var3.f7124o, i4Var3.f7125p, i4Var3.f7117h.f6435m);
            w3 m10 = w3Var.m(i4Var4);
            this.f7466n = m10;
            if (m10.E != 1) {
                this.f7466n = m10.l(1, m10.f7412h);
                f3.a aVar = new f3.a(14);
                e eVar = this.f7461i;
                eVar.j(4, aVar);
                eVar.g();
            }
        }
    }

    public final long t() {
        i4 i4Var = this.f7466n.f7414j;
        if (i4Var.f7118i) {
            return i4Var.f7117h.f6436n;
        }
        a1();
        return this.f7476x;
    }

    public final void t0(int i10) {
        if (W0(25)) {
            R0(new n0(this, i10, 3));
            w3 w3Var = this.f7466n;
            if (w3Var.f7428x != i10) {
                this.f7466n = w3Var.i(i10, w3Var.f7429y);
                n0 n0Var = new n0(this, i10, 4);
                e eVar = this.f7461i;
                eVar.j(30, n0Var);
                eVar.g();
            }
        }
    }

    public final long u() {
        return this.f7466n.f7414j.f7123n;
    }

    public final void u0() {
        int i10;
        if (W0(9)) {
            R0(new l0(this, 18));
            u1 u1Var = this.f7466n.f7421q;
            if (!u1Var.y() && !o()) {
                if (G()) {
                    i10 = T0();
                } else {
                    t1 v10 = u1Var.v(U(), new t1());
                    if (v10.f6583p && v10.k()) {
                        i10 = U();
                    } else {
                        return;
                    }
                }
                e1(i10, -9223372036854775807L);
            }
        }
    }

    public final void v(int i10, long j10) {
        if (W0(10)) {
            a.b(i10 >= 0);
            R0(new g0(i10, j10, this));
            e1(i10, j10);
        }
    }

    public final void v0() {
        if (W0(12)) {
            R0(new l0(this, 11));
            f1(this.f7466n.H);
        }
    }

    public final g1 w() {
        return this.f7470r;
    }

    public final void w0(TextureView textureView) {
        if (W0(27)) {
            if (textureView == null) {
                O0();
            } else if (this.f7473u != textureView) {
                N0();
                this.f7473u = textureView;
                textureView.setSurfaceTextureListener(this.f7460h);
                SurfaceTexture surfaceTexture = textureView.getSurfaceTexture();
                if (surfaceTexture == null) {
                    S0(new l0(this, 16));
                    Z0(0, 0);
                    return;
                }
                this.f7471s = new Surface(surfaceTexture);
                S0(new l0(this, 17));
                Z0(textureView.getWidth(), textureView.getHeight());
            }
        }
    }

    public final long x() {
        return this.f7466n.f7414j.f7121l;
    }

    public final void x0(i1 i1Var) {
        this.f7461i.a(i1Var);
    }

    public final boolean y() {
        return this.f7466n.f7430z;
    }

    public final void y0(s0 s0Var, long j10) {
        if (W0(31)) {
            R0(new o(this, s0Var, j10));
            g1(Collections.singletonList(s0Var), -1, j10, false);
        }
    }

    public final void z() {
        if (W0(20)) {
            R0(new l0(this, 3));
            d1(0, Integer.MAX_VALUE);
        }
    }

    public final void z0(i1 i1Var) {
        this.f7461i.l(i1Var);
    }
}
