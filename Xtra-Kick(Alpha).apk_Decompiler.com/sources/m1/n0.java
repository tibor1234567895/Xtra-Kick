package m1;

import a2.b;
import a2.c;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import b2.l;
import c2.m;
import com.bumptech.glide.manager.b0;
import d9.p0;
import d9.r0;
import g.g0;
import g1.a2;
import g1.b2;
import g1.d1;
import g1.f1;
import g1.g1;
import g1.h;
import g1.i1;
import g1.j;
import g1.k1;
import g1.l1;
import g1.q;
import g1.r1;
import g1.s0;
import g1.t0;
import g1.t1;
import g1.u0;
import g1.u1;
import g1.v0;
import g1.y1;
import i1.d;
import j1.c0;
import j1.d0;
import j1.e0;
import j1.f0;
import j1.g;
import j1.l0;
import j1.v;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeoutException;
import n1.a;
import n1.w;
import v.e;
import v1.a0;
import v1.e1;
import v1.z;
import z1.s;
import z1.u;
import z1.x;
import z1.y;

public final class n0 extends j implements u {

    /* renamed from: l0  reason: collision with root package name */
    public static final /* synthetic */ int f10366l0 = 0;
    public final e A;
    public final s1 B;
    public final t1 C;
    public final t1 D;
    public final long E;
    public int F;
    public boolean G;
    public int H;
    public int I;
    public boolean J;
    public int K;
    public e1 L;
    public g1 M;
    public v0 N;
    public v0 O;
    public AudioTrack P;
    public Object Q;
    public Surface R;
    public SurfaceHolder S;
    public m T;
    public boolean U;
    public TextureView V;
    public final int W;
    public c0 X;
    public final int Y;
    public final h Z;

    /* renamed from: a0  reason: collision with root package name */
    public float f10367a0;

    /* renamed from: b  reason: collision with root package name */
    public final y f10368b;

    /* renamed from: b0  reason: collision with root package name */
    public boolean f10369b0;

    /* renamed from: c  reason: collision with root package name */
    public final g1 f10370c;

    /* renamed from: c0  reason: collision with root package name */
    public d f10371c0;

    /* renamed from: d  reason: collision with root package name */
    public final g f10372d;

    /* renamed from: d0  reason: collision with root package name */
    public final boolean f10373d0;

    /* renamed from: e  reason: collision with root package name */
    public final Context f10374e;

    /* renamed from: e0  reason: collision with root package name */
    public boolean f10375e0;

    /* renamed from: f  reason: collision with root package name */
    public final k1 f10376f;

    /* renamed from: f0  reason: collision with root package name */
    public q f10377f0;

    /* renamed from: g  reason: collision with root package name */
    public final f[] f10378g;

    /* renamed from: g0  reason: collision with root package name */
    public b2 f10379g0;

    /* renamed from: h  reason: collision with root package name */
    public final x f10380h;

    /* renamed from: h0  reason: collision with root package name */
    public v0 f10381h0;

    /* renamed from: i  reason: collision with root package name */
    public final f0 f10382i;

    /* renamed from: i0  reason: collision with root package name */
    public k1 f10383i0;

    /* renamed from: j  reason: collision with root package name */
    public final x f10384j;

    /* renamed from: j0  reason: collision with root package name */
    public int f10385j0;

    /* renamed from: k  reason: collision with root package name */
    public final u0 f10386k;

    /* renamed from: k0  reason: collision with root package name */
    public long f10387k0;

    /* renamed from: l  reason: collision with root package name */
    public final e f10388l;

    /* renamed from: m  reason: collision with root package name */
    public final CopyOnWriteArraySet f10389m;

    /* renamed from: n  reason: collision with root package name */
    public final r1 f10390n;

    /* renamed from: o  reason: collision with root package name */
    public final ArrayList f10391o;

    /* renamed from: p  reason: collision with root package name */
    public final boolean f10392p;

    /* renamed from: q  reason: collision with root package name */
    public final z f10393q;

    /* renamed from: r  reason: collision with root package name */
    public final a f10394r;

    /* renamed from: s  reason: collision with root package name */
    public final Looper f10395s;

    /* renamed from: t  reason: collision with root package name */
    public final a2.d f10396t;

    /* renamed from: u  reason: collision with root package name */
    public final long f10397u;

    /* renamed from: v  reason: collision with root package name */
    public final long f10398v;

    /* renamed from: w  reason: collision with root package name */
    public final d0 f10399w;

    /* renamed from: x  reason: collision with root package name */
    public final k0 f10400x;

    /* renamed from: y  reason: collision with root package name */
    public final l0 f10401y;

    /* renamed from: z  reason: collision with root package name */
    public final b0 f10402z;

    static {
        t0.a("media3.exoplayer");
    }

    public n0(t tVar) {
        boolean z10;
        n1.f0 f0Var;
        n0 n0Var = this;
        t tVar2 = tVar;
        n0Var.f10372d = new g();
        try {
            v.f("ExoPlayerImpl", "Init " + Integer.toHexString(System.identityHashCode(this)) + " [AndroidXMedia3/1.0.2] [" + l0.f8457e + "]");
            Context context = tVar2.f10473a;
            Context applicationContext = context.getApplicationContext();
            n0Var.f10374e = applicationContext;
            c9.j jVar = tVar2.f10480h;
            d0 d0Var = tVar2.f10474b;
            a aVar = (a) jVar.apply(d0Var);
            n0Var.f10394r = aVar;
            n0Var.Z = tVar2.f10482j;
            n0Var.W = tVar2.f10483k;
            n0Var.f10369b0 = false;
            n0Var.E = tVar2.f10490r;
            k0 k0Var = new k0(n0Var);
            n0Var.f10400x = k0Var;
            n0Var.f10401y = new l0(0);
            Handler handler = new Handler(tVar2.f10481i);
            f[] a10 = ((o) tVar2.f10475c.get()).a(handler, k0Var, k0Var, k0Var, k0Var);
            n0Var.f10378g = a10;
            if (a10.length > 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            j1.a.e(z10);
            x xVar = (x) tVar2.f10477e.get();
            n0Var.f10380h = xVar;
            n0Var.f10393q = (z) tVar2.f10476d.get();
            a2.d dVar = (a2.d) tVar2.f10479g.get();
            n0Var.f10396t = dVar;
            n0Var.f10392p = tVar2.f10484l;
            p1 p1Var = tVar2.f10485m;
            a aVar2 = aVar;
            n0Var.f10397u = tVar2.f10486n;
            n0Var.f10398v = tVar2.f10487o;
            Looper looper = tVar2.f10481i;
            n0Var.f10395s = looper;
            n0Var.f10399w = d0Var;
            n0Var.f10376f = n0Var;
            n0Var.f10388l = new e(looper, d0Var, new x(n0Var, 0));
            CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
            n0Var.f10389m = copyOnWriteArraySet;
            n0Var.f10391o = new ArrayList();
            n0Var.L = new e1();
            Handler handler2 = handler;
            Context context2 = context;
            y yVar = new y(new o1[a10.length], new s[a10.length], a2.f6286i, (u) null);
            n0Var.f10368b = yVar;
            n0Var.f10390n = new r1();
            f1 f1Var = new f1();
            f1Var.f6371a.b(1, 2, 3, 13, 14, 15, 16, 17, 18, 19, 31, 20, 30, 21, 22, 23, 24, 25, 26, 27, 28);
            xVar.getClass();
            f1Var.b(29, xVar instanceof z1.q);
            g1 c10 = f1Var.c();
            n0Var.f10370c = c10;
            f1 f1Var2 = new f1();
            g1.x xVar2 = f1Var2.f6371a;
            g1.y yVar2 = c10.f6385h;
            xVar2.getClass();
            p1 p1Var2 = p1Var;
            for (int i10 = 0; i10 < yVar2.c(); i10++) {
                xVar2.a(yVar2.b(i10));
            }
            xVar2.a(4);
            xVar2.a(10);
            n0Var.M = f1Var2.c();
            n0Var.f10382i = d0Var.a(looper, (Handler.Callback) null);
            x xVar3 = new x(n0Var, 1);
            n0Var.f10384j = xVar3;
            n0Var.f10383i0 = k1.h(yVar);
            ((n1.x) aVar2).e0(n0Var, looper);
            int i11 = l0.f8453a;
            if (i11 < 31) {
                f0Var = new n1.f0();
            } else {
                f0Var = f0.a(applicationContext, n0Var, tVar2.f10491s);
            }
            l lVar = (l) tVar2.f10478f.get();
            int i12 = n0Var.F;
            boolean z11 = n0Var.G;
            d0 d0Var2 = d0Var;
            j jVar2 = tVar2.f10488p;
            try {
                u0 u0Var = r5;
                Handler handler3 = handler2;
                int i13 = i11;
                a2.d dVar2 = dVar;
                CopyOnWriteArraySet copyOnWriteArraySet2 = copyOnWriteArraySet;
                boolean z12 = z11;
                Looper looper2 = looper;
                k0 k0Var2 = k0Var;
                u0 u0Var2 = new u0(a10, xVar, yVar, lVar, dVar, i12, z12, aVar2, p1Var2, jVar2, tVar2.f10489q, looper2, d0Var2, xVar3, f0Var);
                n0Var = this;
                n0Var.f10386k = u0Var;
                n0Var.f10367a0 = 1.0f;
                n0Var.F = 0;
                v0 v0Var = v0.P;
                n0Var.N = v0Var;
                n0Var.O = v0Var;
                n0Var.f10381h0 = v0Var;
                int i14 = -1;
                n0Var.f10385j0 = -1;
                if (i13 < 21) {
                    AudioTrack audioTrack = n0Var.P;
                    if (!(audioTrack == null || audioTrack.getAudioSessionId() == 0)) {
                        n0Var.P.release();
                        n0Var.P = null;
                    }
                    if (n0Var.P == null) {
                        n0Var.P = new AudioTrack(3, 4000, 4, 2, 2, 0, 0);
                    }
                    i14 = n0Var.P.getAudioSessionId();
                } else {
                    AudioManager audioManager = (AudioManager) n0Var.f10374e.getSystemService("audio");
                    if (audioManager != null) {
                        i14 = audioManager.generateAudioSessionId();
                    }
                }
                n0Var.Y = i14;
                n0Var.f10371c0 = d.f7990j;
                n0Var.f10373d0 = true;
                n0Var.x0(n0Var.f10394r);
                Handler handler4 = new Handler(looper2);
                a aVar3 = n0Var.f10394r;
                a2.h hVar = (a2.h) dVar2;
                hVar.getClass();
                aVar3.getClass();
                c cVar = hVar.f42b;
                cVar.getClass();
                cVar.a(aVar3);
                cVar.f21a.add(new b(handler4, aVar3));
                k0 k0Var3 = k0Var2;
                copyOnWriteArraySet2.add(k0Var3);
                Context context3 = context2;
                Handler handler5 = handler3;
                b0 b0Var = new b0(context3, handler5, k0Var3);
                n0Var.f10402z = b0Var;
                b0Var.d();
                e eVar = new e(context3, handler5, k0Var3);
                n0Var.A = eVar;
                eVar.c();
                s1 s1Var = new s1(context3, handler5, k0Var3);
                n0Var.B = s1Var;
                s1Var.c(l0.w(n0Var.Z.f6395j));
                t1 t1Var = new t1(context3, 0);
                n0Var.C = t1Var;
                t1Var.a();
                t1 t1Var2 = new t1(context3, 1);
                n0Var.D = t1Var2;
                t1Var2.a();
                n0Var.f10377f0 = new q(0, s1Var.a(), s1Var.f10468d.getStreamMaxVolume(s1Var.f10470f));
                n0Var.f10379g0 = b2.f6311l;
                n0Var.X = c0.f8417c;
                n0Var.f10380h.e(n0Var.Z);
                n0Var.m1(1, 10, Integer.valueOf(i14));
                n0Var.m1(2, 10, Integer.valueOf(i14));
                n0Var.m1(1, 3, n0Var.Z);
                n0Var.m1(2, 4, Integer.valueOf(n0Var.W));
                n0Var.m1(2, 5, 0);
                n0Var.m1(1, 9, Boolean.valueOf(n0Var.f10369b0));
                n0Var.m1(2, 7, n0Var.f10401y);
                n0Var.m1(6, 8, n0Var.f10401y);
                n0Var.f10372d.b();
            } catch (Throwable th) {
                th = th;
                n0Var = this;
                n0Var.f10372d.b();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            n0Var.f10372d.b();
            throw th;
        }
    }

    public static long e1(k1 k1Var) {
        t1 t1Var = new t1();
        r1 r1Var = new r1();
        k1Var.f10316a.p(k1Var.f10317b.f6678a, r1Var);
        long j10 = k1Var.f10318c;
        if (j10 == -9223372036854775807L) {
            return k1Var.f10316a.v(r1Var.f6544j, t1Var).f6587t;
        }
        return r1Var.f6546l + j10;
    }

    public static boolean f1(k1 k1Var) {
        return k1Var.f10320e == 3 && k1Var.f10327l && k1Var.f10328m == 0;
    }

    public final void A(boolean z10) {
        w1();
        if (this.G != z10) {
            this.G = z10;
            f0 f0Var = this.f10386k.f10506o;
            f0Var.getClass();
            e0 b10 = f0.b();
            b10.f8423a = f0Var.f8429a.obtainMessage(12, z10 ? 1 : 0, 0);
            b10.a();
            w wVar = new w(0, z10);
            e eVar = this.f10388l;
            eVar.j(9, wVar);
            s1();
            eVar.g();
        }
    }

    public final void B0(float f10) {
        w1();
        float g10 = l0.g(f10, 0.0f, 1.0f);
        if (this.f10367a0 != g10) {
            this.f10367a0 = g10;
            m1(1, 2, Float.valueOf(this.A.f10207g * g10));
            this.f10388l.m(22, new d0(0, g10));
        }
    }

    public final void C(r0 r0Var) {
        w1();
        ArrayList Z0 = Z0(r0Var);
        w1();
        o1(Z0, -1, -9223372036854775807L, true);
    }

    public final v0 C0() {
        w1();
        return this.N;
    }

    public final a2 D() {
        w1();
        return this.f10383i0.f10324i.f17490d;
    }

    public final long F() {
        w1();
        return 3000;
    }

    public final void F0(List list, int i10) {
        boolean z10;
        int i11 = i10;
        w1();
        ArrayList Z0 = Z0(list);
        w1();
        if (i11 >= 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        j1.a.b(z10);
        ArrayList arrayList = this.f10391o;
        int min = Math.min(i11, arrayList.size());
        u1 j02 = j0();
        this.H++;
        ArrayList W0 = W0(Z0, min);
        n1 n1Var = new n1(arrayList, this.L);
        k1 g12 = g1(this.f10383i0, n1Var, d1(j02, n1Var));
        e1 e1Var = this.L;
        f0 f0Var = this.f10386k.f10506o;
        p0 p0Var = new p0(W0, e1Var, -1, -9223372036854775807L);
        f0Var.getClass();
        e0 b10 = f0.b();
        b10.f8423a = f0Var.f8429a.obtainMessage(18, min, 0, p0Var);
        b10.a();
        u1(g12, 0, 1, false, false, 5, -9223372036854775807L, -1, false);
    }

    public final long G0() {
        w1();
        return this.f10397u;
    }

    public final v0 H() {
        w1();
        return this.O;
    }

    public final int K() {
        w1();
        if (this.f10383i0.f10316a.y()) {
            return 0;
        }
        k1 k1Var = this.f10383i0;
        return k1Var.f10316a.k(k1Var.f10317b.f6678a);
    }

    public final void K0(int i10, long j10, r0 r0Var) {
        w1();
        ArrayList Z0 = Z0(r0Var);
        w1();
        o1(Z0, i10, j10, false);
    }

    public final d L() {
        w1();
        return this.f10371c0;
    }

    public final void M(TextureView textureView) {
        w1();
        if (textureView != null && textureView == this.V) {
            Y0();
        }
    }

    public final b2 N() {
        w1();
        return this.f10379g0;
    }

    public final Looper N0() {
        return this.f10395s;
    }

    public final float Q() {
        w1();
        return this.f10367a0;
    }

    public final void R0(long j10, int i10, boolean z10) {
        boolean z11;
        int i11 = i10;
        w1();
        int i12 = 1;
        if (i11 >= 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        j1.a.b(z11);
        n1.x xVar = (n1.x) this.f10394r;
        if (!xVar.f11005p) {
            n1.b b10 = xVar.b();
            xVar.f11005p = true;
            xVar.d0(b10, -1, new w(b10, 1));
        }
        u1 u1Var = this.f10383i0.f10316a;
        if (u1Var.y() || i11 < u1Var.x()) {
            this.H++;
            if (o()) {
                v.g("ExoPlayerImpl", "seekTo ignored because an ad is playing");
                r0 r0Var = new r0(this.f10383i0);
                r0Var.a(1);
                n0 n0Var = this.f10384j.f10525i;
                n0Var.getClass();
                n0Var.f10382i.c(new g.r0(n0Var, 8, r0Var));
                return;
            }
            if (b() != 1) {
                i12 = 2;
            }
            int U2 = U();
            long j11 = j10;
            k1 g12 = g1(this.f10383i0.f(i12), u1Var, h1(u1Var, i10, j10));
            this.f10386k.f10506o.a(3, new t0(u1Var, i10, l0.H(j10))).a();
            u1(g12, 0, 1, true, true, 1, b1(g12), U2, z10);
        }
    }

    public final h S() {
        w1();
        return this.Z;
    }

    public final int T() {
        w1();
        if (o()) {
            return this.f10383i0.f10317b.f6679b;
        }
        return -1;
    }

    public final int U() {
        w1();
        int c12 = c1();
        if (c12 == -1) {
            return 0;
        }
        return c12;
    }

    public final q V() {
        w1();
        return this.f10377f0;
    }

    public final void W() {
        w1();
        s1 s1Var = this.B;
        if (s1Var.f10471g > s1Var.a()) {
            s1Var.f10468d.adjustStreamVolume(s1Var.f10470f, -1, 1);
            s1Var.d();
        }
    }

    public final ArrayList W0(List list, int i10) {
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < list.size(); i11++) {
            i1 i1Var = new i1((v1.a) list.get(i11), this.f10392p);
            arrayList.add(i1Var);
            this.f10391o.add(i11 + i10, new m0(i1Var.f10270a.f15809o, i1Var.f10271b));
        }
        this.L = this.L.a(i10, arrayList.size());
        return arrayList;
    }

    public final void X(boolean z10) {
        int i10;
        w1();
        s1 s1Var = this.B;
        s1Var.getClass();
        int i11 = l0.f8453a;
        AudioManager audioManager = s1Var.f10468d;
        if (i11 >= 23) {
            int i12 = s1Var.f10470f;
            if (z10) {
                i10 = -100;
            } else {
                i10 = 100;
            }
            audioManager.adjustStreamVolume(i12, i10, 1);
        } else {
            audioManager.setStreamMute(s1Var.f10470f, z10);
        }
        s1Var.d();
    }

    public final v0 X0() {
        u1 j02 = j0();
        if (j02.y()) {
            return this.f10381h0;
        }
        s0 s0Var = j02.v(U(), this.f6413a).f6577j;
        v0 v0Var = this.f10381h0;
        v0Var.getClass();
        u0 u0Var = new u0(v0Var);
        v0 v0Var2 = s0Var.f6559k;
        if (v0Var2 != null) {
            CharSequence charSequence = v0Var2.f6651h;
            if (charSequence != null) {
                u0Var.f6596a = charSequence;
            }
            CharSequence charSequence2 = v0Var2.f6652i;
            if (charSequence2 != null) {
                u0Var.f6597b = charSequence2;
            }
            CharSequence charSequence3 = v0Var2.f6653j;
            if (charSequence3 != null) {
                u0Var.f6598c = charSequence3;
            }
            CharSequence charSequence4 = v0Var2.f6654k;
            if (charSequence4 != null) {
                u0Var.f6599d = charSequence4;
            }
            CharSequence charSequence5 = v0Var2.f6655l;
            if (charSequence5 != null) {
                u0Var.f6600e = charSequence5;
            }
            CharSequence charSequence6 = v0Var2.f6656m;
            if (charSequence6 != null) {
                u0Var.f6601f = charSequence6;
            }
            CharSequence charSequence7 = v0Var2.f6657n;
            if (charSequence7 != null) {
                u0Var.f6602g = charSequence7;
            }
            l1 l1Var = v0Var2.f6658o;
            if (l1Var != null) {
                u0Var.f6603h = l1Var;
            }
            l1 l1Var2 = v0Var2.f6659p;
            if (l1Var2 != null) {
                u0Var.f6604i = l1Var2;
            }
            byte[] bArr = v0Var2.f6660q;
            if (bArr != null) {
                u0Var.b(bArr, v0Var2.f6661r);
            }
            Uri uri = v0Var2.f6662s;
            if (uri != null) {
                u0Var.f6607l = uri;
            }
            Integer num = v0Var2.f6663t;
            if (num != null) {
                u0Var.f6608m = num;
            }
            Integer num2 = v0Var2.f6664u;
            if (num2 != null) {
                u0Var.f6609n = num2;
            }
            Integer num3 = v0Var2.f6665v;
            if (num3 != null) {
                u0Var.f6610o = num3;
            }
            Boolean bool = v0Var2.f6666w;
            if (bool != null) {
                u0Var.f6611p = bool;
            }
            Boolean bool2 = v0Var2.f6667x;
            if (bool2 != null) {
                u0Var.f6612q = bool2;
            }
            Integer num4 = v0Var2.f6668y;
            if (num4 != null) {
                u0Var.f6613r = num4;
            }
            Integer num5 = v0Var2.f6669z;
            if (num5 != null) {
                u0Var.f6613r = num5;
            }
            Integer num6 = v0Var2.A;
            if (num6 != null) {
                u0Var.f6614s = num6;
            }
            Integer num7 = v0Var2.B;
            if (num7 != null) {
                u0Var.f6615t = num7;
            }
            Integer num8 = v0Var2.C;
            if (num8 != null) {
                u0Var.f6616u = num8;
            }
            Integer num9 = v0Var2.D;
            if (num9 != null) {
                u0Var.f6617v = num9;
            }
            Integer num10 = v0Var2.E;
            if (num10 != null) {
                u0Var.f6618w = num10;
            }
            CharSequence charSequence8 = v0Var2.F;
            if (charSequence8 != null) {
                u0Var.f6619x = charSequence8;
            }
            CharSequence charSequence9 = v0Var2.G;
            if (charSequence9 != null) {
                u0Var.f6620y = charSequence9;
            }
            CharSequence charSequence10 = v0Var2.H;
            if (charSequence10 != null) {
                u0Var.f6621z = charSequence10;
            }
            Integer num11 = v0Var2.I;
            if (num11 != null) {
                u0Var.A = num11;
            }
            Integer num12 = v0Var2.J;
            if (num12 != null) {
                u0Var.B = num12;
            }
            CharSequence charSequence11 = v0Var2.K;
            if (charSequence11 != null) {
                u0Var.C = charSequence11;
            }
            CharSequence charSequence12 = v0Var2.L;
            if (charSequence12 != null) {
                u0Var.D = charSequence12;
            }
            CharSequence charSequence13 = v0Var2.M;
            if (charSequence13 != null) {
                u0Var.E = charSequence13;
            }
            Integer num13 = v0Var2.N;
            if (num13 != null) {
                u0Var.F = num13;
            }
            Bundle bundle = v0Var2.O;
            if (bundle != null) {
                u0Var.G = bundle;
            }
        }
        return new v0(u0Var);
    }

    public final void Y0() {
        w1();
        l1();
        q1((Object) null);
        i1(0, 0);
    }

    public final int Z() {
        w1();
        if (o()) {
            return this.f10383i0.f10317b.f6680c;
        }
        return -1;
    }

    public final ArrayList Z0(List list) {
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < list.size(); i10++) {
            arrayList.add(this.f10393q.a((s0) list.get(i10)));
        }
        return arrayList;
    }

    public final void a() {
        String str;
        AudioTrack audioTrack;
        StringBuilder sb2 = new StringBuilder("Release ");
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        sb2.append(" [AndroidXMedia3/1.0.2] [");
        sb2.append(l0.f8457e);
        sb2.append("] [");
        HashSet hashSet = t0.f6571a;
        synchronized (t0.class) {
            str = t0.f6572b;
        }
        sb2.append(str);
        sb2.append("]");
        v.f("ExoPlayerImpl", sb2.toString());
        w1();
        if (l0.f8453a < 21 && (audioTrack = this.P) != null) {
            audioTrack.release();
            this.P = null;
        }
        this.f10402z.d();
        s1 s1Var = this.B;
        g0 g0Var = s1Var.f10469e;
        if (g0Var != null) {
            try {
                s1Var.f10465a.unregisterReceiver(g0Var);
            } catch (RuntimeException e10) {
                v.h("StreamVolumeManager", "Error unregistering stream volume receiver", e10);
            }
            s1Var.f10469e = null;
        }
        this.C.b(false);
        this.D.b(false);
        e eVar = this.A;
        eVar.f10203c = null;
        eVar.a();
        if (!this.f10386k.y()) {
            this.f10388l.m(10, new i1.c(2));
        }
        this.f10388l.k();
        this.f10382i.f8429a.removeCallbacksAndMessages((Object) null);
        a2.d dVar = this.f10396t;
        ((a2.h) dVar).f42b.a(this.f10394r);
        k1 f10 = this.f10383i0.f(1);
        this.f10383i0 = f10;
        k1 a10 = f10.a(f10.f10317b);
        this.f10383i0 = a10;
        a10.f10331p = a10.f10333r;
        this.f10383i0.f10332q = 0;
        n1.x xVar = (n1.x) this.f10394r;
        f0 f0Var = xVar.f11004o;
        j1.a.f(f0Var);
        f0Var.c(new androidx.activity.e(9, xVar));
        this.f10380h.c();
        l1();
        Surface surface = this.R;
        if (surface != null) {
            surface.release();
            this.R = null;
        }
        this.f10371c0 = d.f7990j;
    }

    public final void a0(SurfaceView surfaceView) {
        SurfaceHolder surfaceHolder;
        w1();
        if (surfaceView instanceof l) {
            l1();
            q1(surfaceView);
        } else {
            boolean z10 = surfaceView instanceof m;
            k0 k0Var = this.f10400x;
            if (z10) {
                l1();
                this.T = (m) surfaceView;
                m1 a12 = a1(this.f10401y);
                j1.a.e(!a12.f10357g);
                a12.f10354d = 10000;
                m mVar = this.T;
                j1.a.e(true ^ a12.f10357g);
                a12.f10355e = mVar;
                a12.c();
                this.T.f2780h.add(k0Var);
                q1(this.T.getVideoSurface());
            } else {
                if (surfaceView == null) {
                    surfaceHolder = null;
                } else {
                    surfaceHolder = surfaceView.getHolder();
                }
                w1();
                if (surfaceHolder == null) {
                    Y0();
                    return;
                }
                l1();
                this.U = true;
                this.S = surfaceHolder;
                surfaceHolder.addCallback(k0Var);
                Surface surface = surfaceHolder.getSurface();
                if (surface == null || !surface.isValid()) {
                    q1((Object) null);
                    i1(0, 0);
                    return;
                }
                q1(surface);
                Rect surfaceFrame = surfaceHolder.getSurfaceFrame();
                i1(surfaceFrame.width(), surfaceFrame.height());
                return;
            }
        }
        p1(surfaceView.getHolder());
    }

    public final m1 a1(l1 l1Var) {
        int i10;
        int c12 = c1();
        u1 u1Var = this.f10383i0.f10316a;
        if (c12 == -1) {
            i10 = 0;
        } else {
            i10 = c12;
        }
        d0 d0Var = this.f10399w;
        u0 u0Var = this.f10386k;
        return new m1(u0Var, l1Var, u1Var, i10, d0Var, u0Var.f10508q);
    }

    public final int b() {
        w1();
        return this.f10383i0.f10320e;
    }

    public final long b1(k1 k1Var) {
        if (k1Var.f10316a.y()) {
            return l0.H(this.f10387k0);
        }
        if (k1Var.f10317b.a()) {
            return k1Var.f10333r;
        }
        u1 u1Var = k1Var.f10316a;
        a0 a0Var = k1Var.f10317b;
        long j10 = k1Var.f10333r;
        Object obj = a0Var.f6678a;
        r1 r1Var = this.f10390n;
        u1Var.p(obj, r1Var);
        return j10 + r1Var.f6546l;
    }

    public final boolean c() {
        w1();
        return this.f10383i0.f10322g;
    }

    public final void c0(SurfaceView surfaceView) {
        SurfaceHolder surfaceHolder;
        w1();
        if (surfaceView == null) {
            surfaceHolder = null;
        } else {
            surfaceHolder = surfaceView.getHolder();
        }
        w1();
        if (surfaceHolder != null && surfaceHolder == this.S) {
            Y0();
        }
    }

    public final int c1() {
        if (this.f10383i0.f10316a.y()) {
            return this.f10385j0;
        }
        k1 k1Var = this.f10383i0;
        return k1Var.f10316a.p(k1Var.f10317b.f6678a, this.f10390n).f6544j;
    }

    public final void d(g1.e1 e1Var) {
        w1();
        if (e1Var == null) {
            e1Var = g1.e1.f6351k;
        }
        if (!this.f10383i0.f10329n.equals(e1Var)) {
            k1 e10 = this.f10383i0.e(e1Var);
            this.H++;
            this.f10386k.f10506o.a(4, e1Var).a();
            u1(e10, 0, 1, false, false, 5, -9223372036854775807L, -1, false);
        }
    }

    public final Pair d1(u1 u1Var, n1 n1Var) {
        long t10 = t();
        int i10 = -1;
        if (u1Var.y() || n1Var.y()) {
            boolean z10 = !u1Var.y() && n1Var.y();
            if (!z10) {
                i10 = c1();
            }
            if (z10) {
                t10 = -9223372036854775807L;
            }
            return h1(n1Var, i10, t10);
        }
        Pair r10 = u1Var.r(this.f6413a, this.f10390n, U(), l0.H(t10));
        Object obj = r10.first;
        if (n1Var.k(obj) != -1) {
            return r10;
        }
        Object H2 = u0.H(this.f6413a, this.f10390n, this.F, this.G, obj, u1Var, n1Var);
        if (H2 == null) {
            return h1(n1Var, -1, -9223372036854775807L);
        }
        r1 r1Var = this.f10390n;
        n1Var.p(H2, r1Var);
        int i11 = r1Var.f6544j;
        return h1(n1Var, i11, n1Var.v(i11, this.f6413a).i());
    }

    public final void e() {
        int i10;
        w1();
        boolean y10 = y();
        int i11 = 2;
        int e10 = this.A.e(2, y10);
        if (!y10 || e10 == 1) {
            i10 = 1;
        } else {
            i10 = 2;
        }
        t1(e10, i10, y10);
        k1 k1Var = this.f10383i0;
        if (k1Var.f10320e == 1) {
            k1 d10 = k1Var.d((p) null);
            if (d10.f10316a.y()) {
                i11 = 4;
            }
            k1 f10 = d10.f(i11);
            this.H++;
            f0 f0Var = this.f10386k.f10506o;
            f0Var.getClass();
            e0 b10 = f0.b();
            b10.f8423a = f0Var.f8429a.obtainMessage(0);
            b10.a();
            u1(f10, 1, 1, false, false, 5, -9223372036854775807L, -1, false);
        }
    }

    public final void e0(int i10, int i11, int i12) {
        boolean z10;
        int i13 = i10;
        int i14 = i11;
        int i15 = i12;
        w1();
        if (i13 < 0 || i13 > i14 || i15 < 0) {
            z10 = false;
        } else {
            z10 = true;
        }
        j1.a.b(z10);
        ArrayList arrayList = this.f10391o;
        int size = arrayList.size();
        int min = Math.min(i11, size);
        int min2 = Math.min(i15, size - (min - i13));
        if (i13 < size && i13 != min && i13 != min2) {
            u1 j02 = j0();
            this.H++;
            l0.G(arrayList, i10, min, min2);
            n1 n1Var = new n1(arrayList, this.L);
            k1 g12 = g1(this.f10383i0, n1Var, d1(j02, n1Var));
            e1 e1Var = this.L;
            u0 u0Var = this.f10386k;
            u0Var.getClass();
            u0Var.f10506o.a(19, new q0(i10, min, min2, e1Var)).a();
            u1(g12, 0, 1, false, false, 5, -9223372036854775807L, -1, false);
        }
    }

    public final void f(int i10) {
        w1();
        if (this.F != i10) {
            this.F = i10;
            f0 f0Var = this.f10386k.f10506o;
            f0Var.getClass();
            e0 b10 = f0.b();
            b10.f8423a = f0Var.f8429a.obtainMessage(11, i10, 0);
            b10.a();
            e0 e0Var = new e0(i10, 0);
            e eVar = this.f10388l;
            eVar.j(8, e0Var);
            s1();
            eVar.g();
        }
    }

    public final int f0() {
        w1();
        return this.f10383i0.f10328m;
    }

    public final k1 g1(k1 k1Var, u1 u1Var, Pair pair) {
        boolean z10;
        a0 a0Var;
        v1.l1 l1Var;
        y yVar;
        List list;
        int i10;
        k1 k1Var2;
        long j10;
        long j11;
        u1 u1Var2 = u1Var;
        Pair pair2 = pair;
        if (u1Var.y() || pair2 != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        j1.a.b(z10);
        u1 u1Var3 = k1Var.f10316a;
        k1 g10 = k1Var.g(u1Var);
        if (u1Var.y()) {
            a0 a0Var2 = k1.f10315s;
            long H2 = l0.H(this.f10387k0);
            k1 a10 = g10.b(a0Var2, H2, H2, H2, 0, v1.l1.f15714k, this.f10368b, d9.r1.f4658l).a(a0Var2);
            a10.f10331p = a10.f10333r;
            return a10;
        }
        Object obj = g10.f10317b.f6678a;
        boolean z11 = !obj.equals(pair2.first);
        if (z11) {
            a0Var = new a0(pair2.first);
        } else {
            a0Var = g10.f10317b;
        }
        a0 a0Var3 = a0Var;
        long longValue = ((Long) pair2.second).longValue();
        long H3 = l0.H(t());
        if (!u1Var3.y()) {
            H3 -= u1Var3.p(obj, this.f10390n).f6546l;
        }
        if (z11 || longValue < H3) {
            a0 a0Var4 = a0Var3;
            j1.a.e(!a0Var4.a());
            if (z11) {
                l1Var = v1.l1.f15714k;
            } else {
                l1Var = g10.f10323h;
            }
            v1.l1 l1Var2 = l1Var;
            if (z11) {
                yVar = this.f10368b;
            } else {
                yVar = g10.f10324i;
            }
            y yVar2 = yVar;
            if (z11) {
                p0 p0Var = r0.f4657i;
                list = d9.r1.f4658l;
            } else {
                list = g10.f10325j;
            }
            k1 a11 = g10.b(a0Var4, longValue, longValue, longValue, 0, l1Var2, yVar2, list).a(a0Var4);
            a11.f10331p = longValue;
            return a11;
        }
        if (i10 == 0) {
            int k10 = u1Var2.k(g10.f10326k.f6678a);
            if (k10 != -1 && u1Var2.o(k10, this.f10390n, false).f6544j == u1Var2.p(a0Var3.f6678a, this.f10390n).f6544j) {
                return g10;
            }
            u1Var2.p(a0Var3.f6678a, this.f10390n);
            if (a0Var3.a()) {
                j11 = this.f10390n.i(a0Var3.f6679b, a0Var3.f6680c);
            } else {
                j11 = this.f10390n.f6545k;
            }
            long j12 = j11;
            k1Var2 = g10.b(a0Var3, g10.f10333r, g10.f10333r, g10.f10319d, j11 - g10.f10333r, g10.f10323h, g10.f10324i, g10.f10325j).a(a0Var3);
            j10 = j12;
        } else {
            a0 a0Var5 = a0Var3;
            j1.a.e(!a0Var5.a());
            long max = Math.max(0, g10.f10332q - (longValue - H3));
            long j13 = g10.f10331p;
            if (g10.f10326k.equals(g10.f10317b)) {
                j13 = longValue + max;
            }
            k1Var2 = g10.b(a0Var5, longValue, longValue, longValue, max, g10.f10323h, g10.f10324i, g10.f10325j);
            j10 = j13;
        }
        k1Var2.f10331p = j10;
        return k1Var2;
    }

    public final int h() {
        w1();
        return this.F;
    }

    public final Pair h1(u1 u1Var, int i10, long j10) {
        if (u1Var.y()) {
            this.f10385j0 = i10;
            if (j10 == -9223372036854775807L) {
                j10 = 0;
            }
            this.f10387k0 = j10;
            return null;
        }
        if (i10 == -1 || i10 >= u1Var.x()) {
            i10 = u1Var.j(this.G);
            j10 = u1Var.v(i10, this.f6413a).i();
        }
        return u1Var.r(this.f6413a, this.f10390n, i10, l0.H(j10));
    }

    public final g1.e1 i() {
        w1();
        return this.f10383i0.f10329n;
    }

    public final long i0() {
        w1();
        if (!o()) {
            return J();
        }
        k1 k1Var = this.f10383i0;
        a0 a0Var = k1Var.f10317b;
        u1 u1Var = k1Var.f10316a;
        Object obj = a0Var.f6678a;
        r1 r1Var = this.f10390n;
        u1Var.p(obj, r1Var);
        return l0.Q(r1Var.i(a0Var.f6679b, a0Var.f6680c));
    }

    public final void i1(int i10, int i11) {
        c0 c0Var = this.X;
        if (i10 != c0Var.f8418a || i11 != c0Var.f8419b) {
            this.X = new c0(i10, i11);
            this.f10388l.m(24, new y(i10, i11, 0));
        }
    }

    public final long j() {
        w1();
        return l0.Q(b1(this.f10383i0));
    }

    public final u1 j0() {
        w1();
        return this.f10383i0.f10316a;
    }

    public final k1 j1(int i10, int i11) {
        int U2 = U();
        u1 j02 = j0();
        ArrayList arrayList = this.f10391o;
        int size = arrayList.size();
        boolean z10 = true;
        this.H++;
        k1(i10, i11);
        n1 n1Var = new n1(arrayList, this.L);
        k1 g12 = g1(this.f10383i0, n1Var, d1(j02, n1Var));
        int i12 = g12.f10320e;
        if (i12 == 1 || i12 == 4 || i10 >= i11 || i11 != size || U2 < g12.f10316a.x()) {
            z10 = false;
        }
        if (z10) {
            g12 = g12.f(4);
        }
        e1 e1Var = this.L;
        f0 f0Var = this.f10386k.f10506o;
        f0Var.getClass();
        e0 b10 = f0.b();
        b10.f8423a = f0Var.f8429a.obtainMessage(20, i10, i11, e1Var);
        b10.a();
        return g12;
    }

    public final d1 k() {
        w1();
        return this.f10383i0.f10321f;
    }

    public final boolean k0() {
        w1();
        return this.B.f10472h;
    }

    public final void k1(int i10, int i11) {
        for (int i12 = i11 - 1; i12 >= i10; i12--) {
            this.f10391o.remove(i12);
        }
        e1 e1Var = this.L;
        int i13 = i11 - i10;
        int[] iArr = e1Var.f15616b;
        int[] iArr2 = new int[(iArr.length - i13)];
        int i14 = 0;
        for (int i15 = 0; i15 < iArr.length; i15++) {
            int i16 = iArr[i15];
            if (i16 < i10 || i16 >= i11) {
                int i17 = i15 - i14;
                if (i16 >= i10) {
                    i16 -= i13;
                }
                iArr2[i17] = i16;
            } else {
                i14++;
            }
        }
        this.L = new e1(iArr2, new Random(e1Var.f15615a.nextLong()));
    }

    public final int l() {
        w1();
        return this.B.f10471g;
    }

    public final void l0(v0 v0Var) {
        w1();
        v0Var.getClass();
        if (!v0Var.equals(this.O)) {
            this.O = v0Var;
            this.f10388l.m(15, new x(this, 3));
        }
    }

    public final void l1() {
        m mVar = this.T;
        k0 k0Var = this.f10400x;
        if (mVar != null) {
            m1 a12 = a1(this.f10401y);
            j1.a.e(!a12.f10357g);
            a12.f10354d = 10000;
            j1.a.e(!a12.f10357g);
            a12.f10355e = null;
            a12.c();
            this.T.f2780h.remove(k0Var);
            this.T = null;
        }
        TextureView textureView = this.V;
        if (textureView != null) {
            if (textureView.getSurfaceTextureListener() != k0Var) {
                v.g("ExoPlayerImpl", "SurfaceTextureListener already unset or replaced.");
            } else {
                this.V.setSurfaceTextureListener((TextureView.SurfaceTextureListener) null);
            }
            this.V = null;
        }
        SurfaceHolder surfaceHolder = this.S;
        if (surfaceHolder != null) {
            surfaceHolder.removeCallback(k0Var);
            this.S = null;
        }
    }

    public final void m(boolean z10) {
        w1();
        int e10 = this.A.e(b(), z10);
        int i10 = 1;
        if (z10 && e10 != 1) {
            i10 = 2;
        }
        t1(e10, i10, z10);
    }

    public final void m1(int i10, int i11, Object obj) {
        for (f fVar : this.f10378g) {
            if (fVar.f10216h == i10) {
                m1 a12 = a1(fVar);
                j1.a.e(!a12.f10357g);
                a12.f10354d = i11;
                j1.a.e(!a12.f10357g);
                a12.f10355e = obj;
                a12.c();
            }
        }
    }

    public final void n(Surface surface) {
        w1();
        l1();
        q1(surface);
        int i10 = surface == null ? 0 : -1;
        i1(i10, i10);
    }

    public final void n0() {
        w1();
        s1 s1Var = this.B;
        int i10 = s1Var.f10471g;
        int i11 = s1Var.f10470f;
        AudioManager audioManager = s1Var.f10468d;
        if (i10 < audioManager.getStreamMaxVolume(i11)) {
            audioManager.adjustStreamVolume(s1Var.f10470f, 1, 1);
            s1Var.d();
        }
    }

    public final void n1(q1.q qVar) {
        w1();
        List singletonList = Collections.singletonList(qVar);
        w1();
        w1();
        o1(singletonList, -1, -9223372036854775807L, true);
    }

    public final boolean o() {
        w1();
        return this.f10383i0.f10317b.a();
    }

    public final boolean o0() {
        w1();
        return this.G;
    }

    public final void o1(List list, int i10, long j10, boolean z10) {
        int i11;
        long j11;
        int i12;
        int i13 = i10;
        int c12 = c1();
        long j12 = j();
        boolean z11 = true;
        this.H++;
        ArrayList arrayList = this.f10391o;
        if (!arrayList.isEmpty()) {
            k1(0, arrayList.size());
        }
        ArrayList W0 = W0(list, 0);
        n1 n1Var = new n1(arrayList, this.L);
        boolean y10 = n1Var.y();
        int i14 = n1Var.f10406o;
        if (y10 || i13 < i14) {
            if (z10) {
                i13 = n1Var.j(this.G);
                j11 = -9223372036854775807L;
            } else if (i13 == -1) {
                i11 = c12;
                j11 = j12;
                k1 g12 = g1(this.f10383i0, n1Var, h1(n1Var, i11, j11));
                i12 = g12.f10320e;
                if (!(i11 == -1 || i12 == 1)) {
                    i12 = (!n1Var.y() || i11 >= i14) ? 4 : 2;
                }
                k1 f10 = g12.f(i12);
                this.f10386k.f10506o.a(17, new p0(W0, this.L, i11, l0.H(j11))).a();
                if (this.f10383i0.f10317b.f6678a.equals(f10.f10317b.f6678a) || this.f10383i0.f10316a.y()) {
                    z11 = false;
                }
                u1(f10, 0, 1, false, z11, 4, b1(f10), -1, false);
                return;
            } else {
                j11 = j10;
            }
            i11 = i13;
            k1 g122 = g1(this.f10383i0, n1Var, h1(n1Var, i11, j11));
            i12 = g122.f10320e;
            if (!n1Var.y()) {
            }
            k1 f102 = g122.f(i12);
            this.f10386k.f10506o.a(17, new p0(W0, this.L, i11, l0.H(j11))).a();
            z11 = false;
            u1(f102, 0, 1, false, z11, 4, b1(f102), -1, false);
            return;
        }
        throw new g1.e0();
    }

    public final y1 p0() {
        w1();
        return this.f10380h.a();
    }

    public final void p1(SurfaceHolder surfaceHolder) {
        this.U = false;
        this.S = surfaceHolder;
        surfaceHolder.addCallback(this.f10400x);
        Surface surface = this.S.getSurface();
        if (surface == null || !surface.isValid()) {
            i1(0, 0);
            return;
        }
        Rect surfaceFrame = this.S.getSurfaceFrame();
        i1(surfaceFrame.width(), surfaceFrame.height());
    }

    public final long q() {
        w1();
        return this.f10398v;
    }

    public final void q1(Object obj) {
        ArrayList arrayList = new ArrayList();
        boolean z10 = false;
        for (f fVar : this.f10378g) {
            if (fVar.f10216h == 2) {
                m1 a12 = a1(fVar);
                j1.a.e(!a12.f10357g);
                a12.f10354d = 1;
                j1.a.e(true ^ a12.f10357g);
                a12.f10355e = obj;
                a12.c();
                arrayList.add(a12);
            }
        }
        Object obj2 = this.Q;
        if (!(obj2 == null || obj2 == obj)) {
            try {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((m1) it.next()).a(this.E);
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            } catch (TimeoutException unused2) {
                z10 = true;
            }
            Object obj3 = this.Q;
            Surface surface = this.R;
            if (obj3 == surface) {
                surface.release();
                this.R = null;
            }
        }
        this.Q = obj;
        if (z10) {
            r1(new p(2, new v0(3), 1003));
        }
    }

    public final void r(y1 y1Var) {
        w1();
        x xVar = this.f10380h;
        xVar.getClass();
        if ((xVar instanceof z1.q) && !y1Var.equals(xVar.a())) {
            xVar.f(y1Var);
            this.f10388l.m(19, new v(0, y1Var));
        }
    }

    public final long r0() {
        w1();
        if (this.f10383i0.f10316a.y()) {
            return this.f10387k0;
        }
        k1 k1Var = this.f10383i0;
        if (k1Var.f10326k.f6681d != k1Var.f10317b.f6681d) {
            return k1Var.f10316a.v(U(), this.f6413a).j();
        }
        long j10 = k1Var.f10331p;
        if (this.f10383i0.f10326k.a()) {
            k1 k1Var2 = this.f10383i0;
            r1 p10 = k1Var2.f10316a.p(k1Var2.f10326k.f6678a, this.f10390n);
            long l10 = p10.l(this.f10383i0.f10326k.f6679b);
            if (l10 == Long.MIN_VALUE) {
                j10 = p10.f6545k;
            } else {
                j10 = l10;
            }
        }
        k1 k1Var3 = this.f10383i0;
        u1 u1Var = k1Var3.f10316a;
        Object obj = k1Var3.f10326k.f6678a;
        r1 r1Var = this.f10390n;
        u1Var.p(obj, r1Var);
        return l0.Q(j10 + r1Var.f6546l);
    }

    public final void r1(p pVar) {
        boolean z10;
        k1 k1Var = this.f10383i0;
        k1 a10 = k1Var.a(k1Var.f10317b);
        a10.f10331p = a10.f10333r;
        a10.f10332q = 0;
        k1 f10 = a10.f(1);
        if (pVar != null) {
            f10 = f10.d(pVar);
        }
        k1 k1Var2 = f10;
        this.H++;
        f0 f0Var = this.f10386k.f10506o;
        f0Var.getClass();
        e0 b10 = f0.b();
        b10.f8423a = f0Var.f8429a.obtainMessage(6);
        b10.a();
        if (!k1Var2.f10316a.y() || this.f10383i0.f10316a.y()) {
            z10 = false;
        } else {
            z10 = true;
        }
        u1(k1Var2, 0, 1, false, z10, 4, b1(k1Var2), -1, false);
    }

    public final void s0(int i10, int i11) {
        w1();
        j1.a.b(i10 >= 0 && i11 >= i10);
        int size = this.f10391o.size();
        int min = Math.min(i11, size);
        if (i10 < size && i10 != min) {
            k1 j12 = j1(i10, min);
            u1(j12, 0, 1, false, !j12.f10317b.f6678a.equals(this.f10383i0.f10317b.f6678a), 4, b1(j12), -1, false);
        }
    }

    public final void s1() {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        g1 g1Var = this.M;
        int i10 = l0.f8453a;
        k1 k1Var = this.f10376f;
        boolean o10 = k1Var.o();
        boolean I0 = k1Var.I0();
        boolean Y2 = k1Var.Y();
        boolean G2 = k1Var.G();
        boolean O0 = k1Var.O0();
        boolean M0 = k1Var.M0();
        boolean y10 = k1Var.j0().y();
        f1 f1Var = new f1();
        g1.y yVar = this.f10370c.f6385h;
        g1.x xVar = f1Var.f6371a;
        xVar.getClass();
        boolean z16 = false;
        for (int i11 = 0; i11 < yVar.c(); i11++) {
            xVar.a(yVar.b(i11));
        }
        boolean z17 = !o10;
        f1Var.b(4, z17);
        if (!I0 || o10) {
            z10 = false;
        } else {
            z10 = true;
        }
        f1Var.b(5, z10);
        if (!Y2 || o10) {
            z11 = false;
        } else {
            z11 = true;
        }
        f1Var.b(6, z11);
        if (y10 || ((!Y2 && O0 && !I0) || o10)) {
            z12 = false;
        } else {
            z12 = true;
        }
        f1Var.b(7, z12);
        if (!G2 || o10) {
            z13 = false;
        } else {
            z13 = true;
        }
        f1Var.b(8, z13);
        if (y10 || ((!G2 && (!O0 || !M0)) || o10)) {
            z14 = false;
        } else {
            z14 = true;
        }
        f1Var.b(9, z14);
        f1Var.b(10, z17);
        if (!I0 || o10) {
            z15 = false;
        } else {
            z15 = true;
        }
        f1Var.b(11, z15);
        if (I0 && !o10) {
            z16 = true;
        }
        f1Var.b(12, z16);
        g1 c10 = f1Var.c();
        this.M = c10;
        if (!c10.equals(g1Var)) {
            this.f10388l.j(13, new x(this, 2));
        }
    }

    public final void stop() {
        w1();
        w1();
        this.A.e(1, y());
        r1((p) null);
        this.f10371c0 = new d(this.f10383i0.f10333r, d9.r1.f4658l);
    }

    public final long t() {
        w1();
        if (!o()) {
            return j();
        }
        k1 k1Var = this.f10383i0;
        u1 u1Var = k1Var.f10316a;
        Object obj = k1Var.f10317b.f6678a;
        r1 r1Var = this.f10390n;
        u1Var.p(obj, r1Var);
        k1 k1Var2 = this.f10383i0;
        if (k1Var2.f10318c != -9223372036854775807L) {
            return l0.Q(r1Var.f6546l) + l0.Q(this.f10383i0.f10318c);
        }
        return k1Var2.f10316a.v(U(), this.f6413a).i();
    }

    public final void t0(int i10) {
        w1();
        s1 s1Var = this.B;
        if (i10 >= s1Var.a()) {
            int i11 = s1Var.f10470f;
            AudioManager audioManager = s1Var.f10468d;
            if (i10 <= audioManager.getStreamMaxVolume(i11)) {
                audioManager.setStreamVolume(s1Var.f10470f, i10, 1);
                s1Var.d();
            }
        }
    }

    public final void t1(int i10, int i11, boolean z10) {
        boolean z11;
        int i12 = i10;
        int i13 = 0;
        if (!z10 || i12 == -1) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (z11 && i12 != 1) {
            i13 = 1;
        }
        k1 k1Var = this.f10383i0;
        if (k1Var.f10327l != z11 || k1Var.f10328m != i13) {
            this.H++;
            k1 c10 = k1Var.c(i13, z11);
            f0 f0Var = this.f10386k.f10506o;
            f0Var.getClass();
            e0 b10 = f0.b();
            b10.f8423a = f0Var.f8429a.obtainMessage(1, z11 ? 1 : 0, i13);
            b10.a();
            u1(c10, 0, i11, false, false, 5, -9223372036854775807L, -1, false);
        }
    }

    public final long u() {
        w1();
        return l0.Q(this.f10383i0.f10332q);
    }

    /* JADX WARNING: Removed duplicated region for block: B:89:0x0226  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0254  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x026c  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0279  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void u1(m1.k1 r39, int r40, int r41, boolean r42, boolean r43, int r44, long r45, int r47, boolean r48) {
        /*
            r38 = this;
            r0 = r38
            r1 = r39
            r2 = r44
            m1.k1 r3 = r0.f10383i0
            r0.f10383i0 = r1
            g1.u1 r4 = r3.f10316a
            g1.u1 r5 = r1.f10316a
            boolean r4 = r4.equals(r5)
            r5 = 1
            r4 = r4 ^ r5
            g1.u1 r6 = r3.f10316a
            g1.u1 r7 = r1.f10316a
            boolean r8 = r7.y()
            r9 = -1
            java.lang.Integer r10 = java.lang.Integer.valueOf(r9)
            r11 = 2
            r12 = 3
            r13 = 0
            if (r8 == 0) goto L_0x0035
            boolean r8 = r6.y()
            if (r8 == 0) goto L_0x0035
            android.util.Pair r6 = new android.util.Pair
            java.lang.Boolean r7 = java.lang.Boolean.FALSE
            r6.<init>(r7, r10)
            goto L_0x00c9
        L_0x0035:
            boolean r8 = r7.y()
            boolean r14 = r6.y()
            if (r8 == r14) goto L_0x004c
            android.util.Pair r6 = new android.util.Pair
            java.lang.Boolean r7 = java.lang.Boolean.TRUE
            java.lang.Integer r8 = java.lang.Integer.valueOf(r12)
            r6.<init>(r7, r8)
            goto L_0x00c9
        L_0x004c:
            v1.a0 r8 = r3.f10317b
            java.lang.Object r14 = r8.f6678a
            g1.r1 r15 = r0.f10390n
            g1.r1 r14 = r6.p(r14, r15)
            int r14 = r14.f6544j
            g1.t1 r12 = r0.f6413a
            g1.t1 r6 = r6.v(r14, r12)
            java.lang.Object r6 = r6.f6575h
            v1.a0 r14 = r1.f10317b
            java.lang.Object r9 = r14.f6678a
            g1.r1 r9 = r7.p(r9, r15)
            int r9 = r9.f6544j
            g1.t1 r7 = r7.v(r9, r12)
            java.lang.Object r7 = r7.f6575h
            boolean r6 = r6.equals(r7)
            if (r6 != 0) goto L_0x0098
            if (r43 == 0) goto L_0x007c
            if (r2 != 0) goto L_0x007c
            r6 = 1
            goto L_0x0085
        L_0x007c:
            if (r43 == 0) goto L_0x0082
            if (r2 != r5) goto L_0x0082
            r6 = 2
            goto L_0x0085
        L_0x0082:
            if (r4 == 0) goto L_0x0092
            r6 = 3
        L_0x0085:
            android.util.Pair r7 = new android.util.Pair
            java.lang.Boolean r8 = java.lang.Boolean.TRUE
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r7.<init>(r8, r6)
            r6 = r7
            goto L_0x00c9
        L_0x0092:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            r1.<init>()
            throw r1
        L_0x0098:
            if (r43 == 0) goto L_0x00b0
            if (r2 != 0) goto L_0x00b0
            long r6 = r8.f6681d
            long r8 = r14.f6681d
            int r12 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r12 >= 0) goto L_0x00b0
            android.util.Pair r6 = new android.util.Pair
            java.lang.Boolean r7 = java.lang.Boolean.TRUE
            java.lang.Integer r8 = java.lang.Integer.valueOf(r13)
            r6.<init>(r7, r8)
            goto L_0x00c9
        L_0x00b0:
            if (r43 == 0) goto L_0x00c2
            if (r2 != r5) goto L_0x00c2
            if (r48 == 0) goto L_0x00c2
            android.util.Pair r6 = new android.util.Pair
            java.lang.Boolean r7 = java.lang.Boolean.TRUE
            java.lang.Integer r8 = java.lang.Integer.valueOf(r11)
            r6.<init>(r7, r8)
            goto L_0x00c9
        L_0x00c2:
            android.util.Pair r6 = new android.util.Pair
            java.lang.Boolean r7 = java.lang.Boolean.FALSE
            r6.<init>(r7, r10)
        L_0x00c9:
            java.lang.Object r7 = r6.first
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            java.lang.Object r6 = r6.second
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r6 = r6.intValue()
            g1.v0 r8 = r0.N
            if (r7 == 0) goto L_0x0104
            g1.u1 r10 = r1.f10316a
            boolean r10 = r10.y()
            if (r10 != 0) goto L_0x00fe
            g1.u1 r10 = r1.f10316a
            v1.a0 r12 = r1.f10317b
            java.lang.Object r12 = r12.f6678a
            g1.r1 r14 = r0.f10390n
            g1.r1 r10 = r10.p(r12, r14)
            int r10 = r10.f6544j
            g1.u1 r12 = r1.f10316a
            g1.t1 r14 = r0.f6413a
            g1.t1 r10 = r12.v(r10, r14)
            g1.s0 r10 = r10.f6577j
            goto L_0x00ff
        L_0x00fe:
            r10 = 0
        L_0x00ff:
            g1.v0 r12 = g1.v0.P
            r0.f10381h0 = r12
            goto L_0x0105
        L_0x0104:
            r10 = 0
        L_0x0105:
            if (r7 != 0) goto L_0x0111
            java.util.List r12 = r3.f10325j
            java.util.List r14 = r1.f10325j
            boolean r12 = r12.equals(r14)
            if (r12 != 0) goto L_0x0149
        L_0x0111:
            g1.v0 r8 = r0.f10381h0
            r8.getClass()
            g1.u0 r12 = new g1.u0
            r12.<init>(r8)
            java.util.List r8 = r1.f10325j
            r14 = 0
        L_0x011e:
            int r15 = r8.size()
            if (r14 >= r15) goto L_0x013e
            java.lang.Object r15 = r8.get(r14)
            g1.z0 r15 = (g1.z0) r15
            r9 = 0
        L_0x012b:
            g1.y0[] r11 = r15.f6770h
            int r13 = r11.length
            if (r9 >= r13) goto L_0x0139
            r11 = r11[r9]
            r11.h(r12)
            int r9 = r9 + 1
            r13 = 0
            goto L_0x012b
        L_0x0139:
            int r14 = r14 + 1
            r11 = 2
            r13 = 0
            goto L_0x011e
        L_0x013e:
            g1.v0 r8 = new g1.v0
            r8.<init>(r12)
            r0.f10381h0 = r8
            g1.v0 r8 = r38.X0()
        L_0x0149:
            g1.v0 r9 = r0.N
            boolean r9 = r8.equals(r9)
            r9 = r9 ^ r5
            r0.N = r8
            boolean r8 = r3.f10327l
            boolean r11 = r1.f10327l
            if (r8 == r11) goto L_0x015a
            r8 = 1
            goto L_0x015b
        L_0x015a:
            r8 = 0
        L_0x015b:
            int r11 = r3.f10320e
            int r12 = r1.f10320e
            if (r11 == r12) goto L_0x0163
            r11 = 1
            goto L_0x0164
        L_0x0163:
            r11 = 0
        L_0x0164:
            if (r11 != 0) goto L_0x0168
            if (r8 == 0) goto L_0x016b
        L_0x0168:
            r38.v1()
        L_0x016b:
            boolean r12 = r3.f10322g
            boolean r13 = r1.f10322g
            if (r12 == r13) goto L_0x0173
            r12 = 1
            goto L_0x0174
        L_0x0173:
            r12 = 0
        L_0x0174:
            if (r4 == 0) goto L_0x0183
            v.e r4 = r0.f10388l
            m1.z r13 = new m1.z
            r14 = r40
            r15 = 0
            r13.<init>(r14, r15, r1)
            r4.j(r15, r13)
        L_0x0183:
            if (r43 == 0) goto L_0x029a
            g1.r1 r4 = new g1.r1
            r4.<init>()
            g1.u1 r13 = r3.f10316a
            boolean r13 = r13.y()
            if (r13 != 0) goto L_0x01be
            v1.a0 r13 = r3.f10317b
            java.lang.Object r13 = r13.f6678a
            g1.u1 r14 = r3.f10316a
            r14.p(r13, r4)
            int r14 = r4.f6544j
            g1.u1 r15 = r3.f10316a
            int r15 = r15.k(r13)
            g1.u1 r5 = r3.f10316a
            r40 = r13
            g1.t1 r13 = r0.f6413a
            g1.t1 r5 = r5.v(r14, r13)
            java.lang.Object r5 = r5.f6575h
            g1.t1 r13 = r0.f6413a
            g1.s0 r13 = r13.f6577j
            r20 = r40
            r17 = r5
            r19 = r13
            r18 = r14
            r21 = r15
            goto L_0x01c8
        L_0x01be:
            r18 = r47
            r17 = 0
            r19 = 0
            r20 = 0
            r21 = -1
        L_0x01c8:
            v1.a0 r5 = r3.f10317b
            boolean r5 = r5.a()
            if (r2 != 0) goto L_0x01f0
            if (r5 == 0) goto L_0x01dd
            v1.a0 r5 = r3.f10317b
            int r13 = r5.f6679b
            int r5 = r5.f6680c
            long r4 = r4.i(r13, r5)
            goto L_0x01f4
        L_0x01dd:
            v1.a0 r5 = r3.f10317b
            int r5 = r5.f6682e
            r13 = -1
            if (r5 == r13) goto L_0x01eb
            m1.k1 r4 = r0.f10383i0
            long r4 = e1(r4)
            goto L_0x01fe
        L_0x01eb:
            long r13 = r4.f6546l
            long r4 = r4.f6545k
            goto L_0x01fd
        L_0x01f0:
            if (r5 == 0) goto L_0x01f9
            long r4 = r3.f10333r
        L_0x01f4:
            long r13 = e1(r3)
            goto L_0x01ff
        L_0x01f9:
            long r4 = r4.f6546l
            long r13 = r3.f10333r
        L_0x01fd:
            long r4 = r4 + r13
        L_0x01fe:
            r13 = r4
        L_0x01ff:
            g1.j1 r15 = new g1.j1
            long r22 = j1.l0.Q(r4)
            long r24 = j1.l0.Q(r13)
            v1.a0 r4 = r3.f10317b
            int r5 = r4.f6679b
            int r4 = r4.f6680c
            r16 = r15
            r26 = r5
            r27 = r4
            r16.<init>(r17, r18, r19, r20, r21, r22, r24, r26, r27)
            int r4 = r38.U()
            m1.k1 r5 = r0.f10383i0
            g1.u1 r5 = r5.f10316a
            boolean r5 = r5.y()
            if (r5 != 0) goto L_0x0254
            m1.k1 r5 = r0.f10383i0
            v1.a0 r13 = r5.f10317b
            java.lang.Object r13 = r13.f6678a
            g1.u1 r5 = r5.f10316a
            g1.r1 r14 = r0.f10390n
            r5.p(r13, r14)
            m1.k1 r5 = r0.f10383i0
            g1.u1 r5 = r5.f10316a
            int r5 = r5.k(r13)
            m1.k1 r14 = r0.f10383i0
            g1.u1 r14 = r14.f10316a
            r40 = r5
            g1.t1 r5 = r0.f6413a
            g1.t1 r14 = r14.v(r4, r5)
            java.lang.Object r14 = r14.f6575h
            g1.s0 r5 = r5.f6577j
            r31 = r40
            r29 = r5
            r30 = r13
            r27 = r14
            goto L_0x025c
        L_0x0254:
            r27 = 0
            r29 = 0
            r30 = 0
            r31 = -1
        L_0x025c:
            long r32 = j1.l0.Q(r45)
            g1.j1 r5 = new g1.j1
            m1.k1 r13 = r0.f10383i0
            v1.a0 r13 = r13.f10317b
            boolean r13 = r13.a()
            if (r13 == 0) goto L_0x0279
            m1.k1 r13 = r0.f10383i0
            long r13 = e1(r13)
            long r13 = j1.l0.Q(r13)
            r34 = r13
            goto L_0x027b
        L_0x0279:
            r34 = r32
        L_0x027b:
            m1.k1 r13 = r0.f10383i0
            v1.a0 r13 = r13.f10317b
            int r14 = r13.f6679b
            int r13 = r13.f6680c
            r26 = r5
            r28 = r4
            r36 = r14
            r37 = r13
            r26.<init>(r27, r28, r29, r30, r31, r32, r34, r36, r37)
            v.e r4 = r0.f10388l
            m1.b0 r13 = new m1.b0
            r13.<init>(r2, r15, r5)
            r2 = 11
            r4.j(r2, r13)
        L_0x029a:
            if (r7 == 0) goto L_0x02a7
            v.e r2 = r0.f10388l
            h3.k3 r4 = new h3.k3
            r4.<init>(r6, r10)
            r5 = 1
            r2.j(r5, r4)
        L_0x02a7:
            m1.p r2 = r3.f10321f
            m1.p r4 = r1.f10321f
            r5 = 4
            if (r2 == r4) goto L_0x02c9
            v.e r2 = r0.f10388l
            m1.a0 r4 = new m1.a0
            r6 = 3
            r4.<init>(r1, r6)
            r6 = 10
            r2.j(r6, r4)
            m1.p r2 = r1.f10321f
            if (r2 == 0) goto L_0x02c9
            v.e r2 = r0.f10388l
            m1.a0 r4 = new m1.a0
            r4.<init>(r1, r5)
            r2.j(r6, r4)
        L_0x02c9:
            z1.y r2 = r3.f10324i
            z1.y r4 = r1.f10324i
            r6 = 5
            if (r2 == r4) goto L_0x02e2
            z1.x r2 = r0.f10380h
            java.lang.Object r4 = r4.f17491e
            r2.b(r4)
            v.e r2 = r0.f10388l
            m1.a0 r4 = new m1.a0
            r4.<init>(r1, r6)
            r7 = 2
            r2.j(r7, r4)
        L_0x02e2:
            if (r9 == 0) goto L_0x02f3
            g1.v0 r2 = r0.N
            v.e r4 = r0.f10388l
            m1.c0 r7 = new m1.c0
            r9 = 0
            r7.<init>(r9, r2)
            r2 = 14
            r4.j(r2, r7)
        L_0x02f3:
            r2 = 6
            if (r12 == 0) goto L_0x0301
            v.e r4 = r0.f10388l
            m1.a0 r7 = new m1.a0
            r7.<init>(r1, r2)
            r9 = 3
            r4.j(r9, r7)
        L_0x0301:
            r4 = 7
            if (r11 != 0) goto L_0x0306
            if (r8 == 0) goto L_0x0311
        L_0x0306:
            v.e r7 = r0.f10388l
            m1.a0 r9 = new m1.a0
            r9.<init>(r1, r4)
            r10 = -1
            r7.j(r10, r9)
        L_0x0311:
            if (r11 == 0) goto L_0x031f
            v.e r7 = r0.f10388l
            m1.a0 r9 = new m1.a0
            r10 = 8
            r9.<init>(r1, r10)
            r7.j(r5, r9)
        L_0x031f:
            if (r8 == 0) goto L_0x032e
            v.e r5 = r0.f10388l
            m1.z r7 = new m1.z
            r8 = r41
            r9 = 1
            r7.<init>(r8, r9, r1)
            r5.j(r6, r7)
        L_0x032e:
            int r5 = r3.f10328m
            int r6 = r1.f10328m
            if (r5 == r6) goto L_0x033f
            v.e r5 = r0.f10388l
            m1.a0 r6 = new m1.a0
            r7 = 0
            r6.<init>(r1, r7)
            r5.j(r2, r6)
        L_0x033f:
            boolean r2 = f1(r3)
            boolean r5 = f1(r39)
            if (r2 == r5) goto L_0x0354
            v.e r2 = r0.f10388l
            m1.a0 r5 = new m1.a0
            r6 = 1
            r5.<init>(r1, r6)
            r2.j(r4, r5)
        L_0x0354:
            g1.e1 r2 = r3.f10329n
            g1.e1 r4 = r1.f10329n
            boolean r2 = r2.equals(r4)
            if (r2 != 0) goto L_0x036b
            v.e r2 = r0.f10388l
            m1.a0 r4 = new m1.a0
            r5 = 2
            r4.<init>(r1, r5)
            r5 = 12
            r2.j(r5, r4)
        L_0x036b:
            if (r42 == 0) goto L_0x0379
            v.e r2 = r0.f10388l
            i1.c r4 = new i1.c
            r5 = 3
            r4.<init>(r5)
            r5 = -1
            r2.j(r5, r4)
        L_0x0379:
            r38.s1()
            v.e r2 = r0.f10388l
            r2.g()
            boolean r2 = r3.f10330o
            boolean r1 = r1.f10330o
            if (r2 == r1) goto L_0x039f
            java.util.concurrent.CopyOnWriteArraySet r1 = r0.f10389m
            java.util.Iterator r1 = r1.iterator()
        L_0x038d:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x039f
            java.lang.Object r2 = r1.next()
            m1.k0 r2 = (m1.k0) r2
            m1.n0 r2 = r2.f10314h
            r2.v1()
            goto L_0x038d
        L_0x039f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: m1.n0.u1(m1.k1, int, int, boolean, boolean, int, long, int, boolean):void");
    }

    public final void v1() {
        int b10 = b();
        t1 t1Var = this.D;
        t1 t1Var2 = this.C;
        boolean z10 = true;
        if (b10 != 1) {
            if (b10 == 2 || b10 == 3) {
                w1();
                boolean z11 = this.f10383i0.f10330o;
                if (!y() || z11) {
                    z10 = false;
                }
                t1Var2.b(z10);
                t1Var.b(y());
                return;
            } else if (b10 != 4) {
                throw new IllegalStateException();
            }
        }
        t1Var2.b(false);
        t1Var.b(false);
    }

    public final g1 w() {
        w1();
        return this.M;
    }

    public final void w0(TextureView textureView) {
        SurfaceTexture surfaceTexture;
        w1();
        if (textureView == null) {
            Y0();
            return;
        }
        l1();
        this.V = textureView;
        if (textureView.getSurfaceTextureListener() != null) {
            v.g("ExoPlayerImpl", "Replacing existing SurfaceTextureListener.");
        }
        textureView.setSurfaceTextureListener(this.f10400x);
        if (textureView.isAvailable()) {
            surfaceTexture = textureView.getSurfaceTexture();
        } else {
            surfaceTexture = null;
        }
        if (surfaceTexture == null) {
            q1((Object) null);
            i1(0, 0);
            return;
        }
        Surface surface = new Surface(surfaceTexture);
        q1(surface);
        this.R = surface;
        i1(textureView.getWidth(), textureView.getHeight());
    }

    public final void w1() {
        IllegalStateException illegalStateException;
        g gVar = this.f10372d;
        synchronized (gVar) {
            boolean z10 = false;
            while (!gVar.f8430a) {
                try {
                    gVar.wait();
                } catch (InterruptedException unused) {
                    z10 = true;
                }
            }
            if (z10) {
                Thread.currentThread().interrupt();
            }
        }
        if (Thread.currentThread() != this.f10395s.getThread()) {
            String l10 = l0.l("Player is accessed on the wrong thread.\nCurrent thread: '%s'\nExpected thread: '%s'\nSee https://developer.android.com/guide/topics/media/issues/player-accessed-on-wrong-thread", Thread.currentThread().getName(), this.f10395s.getThread().getName());
            if (!this.f10373d0) {
                if (this.f10375e0) {
                    illegalStateException = null;
                } else {
                    illegalStateException = new IllegalStateException();
                }
                v.h("ExoPlayerImpl", l10, illegalStateException);
                this.f10375e0 = true;
                return;
            }
            throw new IllegalStateException(l10);
        }
    }

    public final long x() {
        w1();
        if (!o()) {
            return r0();
        }
        k1 k1Var = this.f10383i0;
        return k1Var.f10326k.equals(k1Var.f10317b) ? l0.Q(this.f10383i0.f10331p) : i0();
    }

    public final void x0(i1 i1Var) {
        i1Var.getClass();
        this.f10388l.a(i1Var);
    }

    public final boolean y() {
        w1();
        return this.f10383i0.f10327l;
    }

    public final void z0(i1 i1Var) {
        w1();
        i1Var.getClass();
        this.f10388l.l(i1Var);
    }
}
