package m1;

import a2.d;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import android.support.v4.media.h;
import android.util.Pair;
import d9.o0;
import d9.p0;
import g.r0;
import g1.m0;
import g1.r1;
import g1.t1;
import g1.u1;
import g1.y0;
import g1.z0;
import j1.d0;
import j1.f0;
import j1.l0;
import j1.v;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import n1.a;
import v1.a0;
import v1.b1;
import v1.d1;
import v1.e1;
import v1.l1;
import v1.x;
import y1.g;
import z1.s;
import z1.y;

public final class u0 implements Handler.Callback, x, m {
    public final j1 A;
    public final j B;
    public final long C;
    public p1 D;
    public k1 E;
    public r0 F;
    public boolean G;
    public boolean H = false;
    public boolean I;
    public boolean J;
    public boolean K;
    public int L;
    public boolean M;
    public boolean N;
    public boolean O;
    public boolean P;
    public int Q;
    public t0 R;
    public long S;
    public int T;
    public boolean U;
    public p V;
    public long W;

    /* renamed from: h  reason: collision with root package name */
    public final f[] f10499h;

    /* renamed from: i  reason: collision with root package name */
    public final Set f10500i;

    /* renamed from: j  reason: collision with root package name */
    public final f[] f10501j;

    /* renamed from: k  reason: collision with root package name */
    public final z1.x f10502k;

    /* renamed from: l  reason: collision with root package name */
    public final y f10503l;

    /* renamed from: m  reason: collision with root package name */
    public final l f10504m;

    /* renamed from: n  reason: collision with root package name */
    public final d f10505n;

    /* renamed from: o  reason: collision with root package name */
    public final f0 f10506o;

    /* renamed from: p  reason: collision with root package name */
    public final HandlerThread f10507p;

    /* renamed from: q  reason: collision with root package name */
    public final Looper f10508q;

    /* renamed from: r  reason: collision with root package name */
    public final t1 f10509r;

    /* renamed from: s  reason: collision with root package name */
    public final r1 f10510s;

    /* renamed from: t  reason: collision with root package name */
    public final long f10511t;

    /* renamed from: u  reason: collision with root package name */
    public final boolean f10512u;

    /* renamed from: v  reason: collision with root package name */
    public final n f10513v;

    /* renamed from: w  reason: collision with root package name */
    public final ArrayList f10514w;

    /* renamed from: x  reason: collision with root package name */
    public final j1.d f10515x;

    /* renamed from: y  reason: collision with root package name */
    public final x f10516y;

    /* renamed from: z  reason: collision with root package name */
    public final a1 f10517z;

    public u0(f[] fVarArr, z1.x xVar, y yVar, l lVar, d dVar, int i10, boolean z10, a aVar, p1 p1Var, j jVar, long j10, Looper looper, d0 d0Var, x xVar2, n1.f0 f0Var) {
        f[] fVarArr2 = fVarArr;
        z1.x xVar3 = xVar;
        l lVar2 = lVar;
        d dVar2 = dVar;
        a aVar2 = aVar;
        d0 d0Var2 = d0Var;
        n1.f0 f0Var2 = f0Var;
        this.f10516y = xVar2;
        this.f10499h = fVarArr2;
        this.f10502k = xVar3;
        this.f10503l = yVar;
        this.f10504m = lVar2;
        this.f10505n = dVar2;
        this.L = i10;
        this.M = z10;
        this.D = p1Var;
        this.B = jVar;
        this.C = j10;
        this.f10515x = d0Var2;
        this.W = -9223372036854775807L;
        this.f10511t = lVar2.f10341h;
        this.f10512u = lVar2.f10342i;
        k1 h10 = k1.h(yVar);
        this.E = h10;
        this.F = new r0(h10);
        this.f10501j = new f[fVarArr2.length];
        for (int i11 = 0; i11 < fVarArr2.length; i11++) {
            f fVar = fVarArr2[i11];
            fVar.f10219k = i11;
            fVar.f10220l = f0Var2;
            this.f10501j[i11] = fVar;
        }
        this.f10513v = new n(this, d0Var2);
        this.f10514w = new ArrayList();
        this.f10500i = Collections.newSetFromMap(new IdentityHashMap());
        this.f10509r = new t1();
        this.f10510s = new r1();
        xVar3.f17485a = this;
        xVar3.f17486b = dVar2;
        this.U = true;
        f0 a10 = d0Var2.a(looper, (Handler.Callback) null);
        this.f10517z = new a1(aVar2, a10);
        this.A = new j1(this, aVar2, a10, f0Var2);
        HandlerThread handlerThread = new HandlerThread("ExoPlayer:Playback", -16);
        this.f10507p = handlerThread;
        handlerThread.start();
        Looper looper2 = handlerThread.getLooper();
        this.f10508q = looper2;
        this.f10506o = d0Var2.a(looper2, this);
    }

    public static Pair G(u1 u1Var, t0 t0Var, boolean z10, int i10, boolean z11, t1 t1Var, r1 r1Var) {
        Object H2;
        u1 u1Var2 = u1Var;
        t0 t0Var2 = t0Var;
        r1 r1Var2 = r1Var;
        u1 u1Var3 = t0Var2.f10493a;
        if (u1Var.y()) {
            return null;
        }
        u1 u1Var4 = u1Var3.y() ? u1Var2 : u1Var3;
        try {
            Pair r10 = u1Var4.r(t1Var, r1Var, t0Var2.f10494b, t0Var2.f10495c);
            if (u1Var.equals(u1Var4)) {
                return r10;
            }
            if (u1Var.k(r10.first) == -1) {
                t1 t1Var2 = t1Var;
                if (z10 && (H2 = H(t1Var, r1Var, i10, z11, r10.first, u1Var4, u1Var)) != null) {
                    return u1Var.r(t1Var, r1Var, u1Var.p(H2, r1Var2).f6544j, -9223372036854775807L);
                }
                return null;
            } else if (!u1Var4.p(r10.first, r1Var2).f6547m || u1Var4.v(r1Var2.f6544j, t1Var).f6589v != u1Var4.k(r10.first)) {
                return r10;
            } else {
                return u1Var.r(t1Var, r1Var, u1Var.p(r10.first, r1Var2).f6544j, t0Var2.f10495c);
            }
        } catch (IndexOutOfBoundsException unused) {
        }
    }

    public static Object H(t1 t1Var, r1 r1Var, int i10, boolean z10, Object obj, u1 u1Var, u1 u1Var2) {
        int k10 = u1Var.k(obj);
        int q10 = u1Var.q();
        int i11 = k10;
        int i12 = -1;
        for (int i13 = 0; i13 < q10 && i12 == -1; i13++) {
            i11 = u1Var.m(i11, r1Var, t1Var, i10, z10);
            if (i11 == -1) {
                break;
            }
            i12 = u1Var2.k(u1Var.u(i11));
        }
        if (i12 == -1) {
            return null;
        }
        return u1Var2.u(i12);
    }

    public static void N(f fVar, long j10) {
        fVar.f10226r = true;
        if (fVar instanceof g) {
            g gVar = (g) fVar;
            j1.a.e(gVar.f10226r);
            gVar.H = j10;
        }
    }

    public static void b(m1 m1Var) {
        synchronized (m1Var) {
        }
        try {
            m1Var.f10351a.b(m1Var.f10354d, m1Var.f10355e);
        } finally {
            m1Var.b(true);
        }
    }

    public static boolean q(f fVar) {
        return fVar.f10221m != 0;
    }

    public final void A(int i10, int i11, e1 e1Var) {
        boolean z10 = true;
        this.F.a(1);
        j1 j1Var = this.A;
        j1Var.getClass();
        if (i10 < 0 || i10 > i11 || i11 > j1Var.f10296b.size()) {
            z10 = false;
        }
        j1.a.b(z10);
        j1Var.f10304j = e1Var;
        j1Var.f(i10, i11);
        l(j1Var.b(), false);
    }

    public final void B() {
        boolean z10;
        boolean z11;
        float f10 = this.f10513v.i().f6355h;
        a1 a1Var = this.f10517z;
        y0 y0Var = a1Var.f10181h;
        y0 y0Var2 = a1Var.f10182i;
        y0 y0Var3 = y0Var;
        boolean z12 = true;
        while (y0Var3 != null && y0Var3.f10532d) {
            y g10 = y0Var3.g(f10, this.E.f10316a);
            y yVar = y0Var3.f10542n;
            if (yVar != null) {
                int length = yVar.f17489c.length;
                s[] sVarArr = g10.f17489c;
                if (length == sVarArr.length) {
                    int i10 = 0;
                    while (true) {
                        if (i10 >= sVarArr.length) {
                            z10 = true;
                            break;
                        } else if (!g10.a(yVar, i10)) {
                            break;
                        } else {
                            i10++;
                        }
                    }
                }
            }
            z10 = false;
            if (!z10) {
                if (z12) {
                    a1 a1Var2 = this.f10517z;
                    y0 y0Var4 = a1Var2.f10181h;
                    boolean k10 = a1Var2.k(y0Var4);
                    boolean[] zArr = new boolean[this.f10499h.length];
                    long a10 = y0Var4.a(g10, this.E.f10333r, k10, zArr);
                    k1 k1Var = this.E;
                    if (k1Var.f10320e == 4 || a10 == k1Var.f10333r) {
                        z11 = false;
                    } else {
                        z11 = true;
                    }
                    k1 k1Var2 = this.E;
                    y0 y0Var5 = y0Var4;
                    boolean[] zArr2 = zArr;
                    this.E = o(k1Var2.f10317b, a10, k1Var2.f10318c, k1Var2.f10319d, z11, 5);
                    if (z11) {
                        E(a10);
                    }
                    boolean[] zArr3 = new boolean[this.f10499h.length];
                    int i11 = 0;
                    while (true) {
                        f[] fVarArr = this.f10499h;
                        if (i11 >= fVarArr.length) {
                            break;
                        }
                        f fVar = fVarArr[i11];
                        boolean q10 = q(fVar);
                        zArr3[i11] = q10;
                        b1 b1Var = y0Var5.f10531c[i11];
                        if (q10) {
                            if (b1Var != fVar.f10222n) {
                                c(fVar);
                            } else if (zArr2[i11]) {
                                long j10 = this.S;
                                fVar.f10226r = false;
                                fVar.f10225q = j10;
                                fVar.n(j10, false);
                                i11++;
                            }
                        }
                        i11++;
                    }
                    e(zArr3);
                } else {
                    this.f10517z.k(y0Var3);
                    if (y0Var3.f10532d) {
                        y0Var3.a(g10, Math.max(y0Var3.f10534f.f10548b, this.S - y0Var3.f10543o), false, new boolean[y0Var3.f10537i.length]);
                    }
                }
                k(true);
                if (this.E.f10320e != 4) {
                    t();
                    f0();
                    this.f10506o.d(2);
                    return;
                }
                return;
            }
            if (y0Var3 == y0Var2) {
                z12 = false;
            }
            y0Var3 = y0Var3.f10540l;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00ee  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0126  */
    /* JADX WARNING: Removed duplicated region for block: B:76:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void C(boolean r35, boolean r36, boolean r37, boolean r38) {
        /*
            r34 = this;
            r1 = r34
            j1.f0 r0 = r1.f10506o
            android.os.Handler r0 = r0.f8429a
            r2 = 2
            r0.removeMessages(r2)
            r2 = 0
            r1.V = r2
            r3 = 0
            r1.J = r3
            m1.n r0 = r1.f10513v
            r0.f10365m = r3
            m1.q1 r0 = r0.f10360h
            boolean r4 = r0.f10445i
            if (r4 == 0) goto L_0x0023
            long r4 = r0.a()
            r0.b(r4)
            r0.f10445i = r3
        L_0x0023:
            r4 = 1000000000000(0xe8d4a51000, double:4.94065645841E-312)
            r1.S = r4
            m1.f[] r4 = r1.f10499h
            int r5 = r4.length
            r6 = 0
        L_0x002e:
            java.lang.String r7 = "ExoPlayerImplInternal"
            if (r6 >= r5) goto L_0x0043
            r0 = r4[r6]
            r1.c(r0)     // Catch:{ p -> 0x003a, RuntimeException -> 0x0038 }
            goto L_0x0040
        L_0x0038:
            r0 = move-exception
            goto L_0x003b
        L_0x003a:
            r0 = move-exception
        L_0x003b:
            java.lang.String r8 = "Disable failed."
            j1.v.d(r7, r8, r0)
        L_0x0040:
            int r6 = r6 + 1
            goto L_0x002e
        L_0x0043:
            if (r35 == 0) goto L_0x0063
            m1.f[] r4 = r1.f10499h
            int r5 = r4.length
            r6 = 0
        L_0x0049:
            if (r6 >= r5) goto L_0x0063
            r0 = r4[r6]
            java.util.Set r8 = r1.f10500i
            boolean r8 = r8.remove(r0)
            if (r8 == 0) goto L_0x0060
            r0.v()     // Catch:{ RuntimeException -> 0x0059 }
            goto L_0x0060
        L_0x0059:
            r0 = move-exception
            r8 = r0
            java.lang.String r0 = "Reset failed."
            j1.v.d(r7, r0, r8)
        L_0x0060:
            int r6 = r6 + 1
            goto L_0x0049
        L_0x0063:
            r1.Q = r3
            m1.k1 r0 = r1.E
            v1.a0 r4 = r0.f10317b
            long r5 = r0.f10333r
            m1.k1 r0 = r1.E
            v1.a0 r0 = r0.f10317b
            boolean r0 = r0.a()
            r7 = 1
            if (r0 != 0) goto L_0x009a
            m1.k1 r0 = r1.E
            g1.r1 r8 = r1.f10510s
            v1.a0 r9 = r0.f10317b
            g1.u1 r0 = r0.f10316a
            boolean r10 = r0.y()
            if (r10 != 0) goto L_0x0091
            java.lang.Object r9 = r9.f6678a
            g1.r1 r0 = r0.p(r9, r8)
            boolean r0 = r0.f6547m
            if (r0 == 0) goto L_0x008f
            goto L_0x0091
        L_0x008f:
            r0 = 0
            goto L_0x0092
        L_0x0091:
            r0 = 1
        L_0x0092:
            if (r0 == 0) goto L_0x0095
            goto L_0x009a
        L_0x0095:
            m1.k1 r0 = r1.E
            long r8 = r0.f10333r
            goto L_0x009e
        L_0x009a:
            m1.k1 r0 = r1.E
            long r8 = r0.f10318c
        L_0x009e:
            if (r36 == 0) goto L_0x00cb
            r1.R = r2
            m1.k1 r0 = r1.E
            g1.u1 r0 = r0.f10316a
            android.util.Pair r0 = r1.g(r0)
            java.lang.Object r4 = r0.first
            v1.a0 r4 = (v1.a0) r4
            java.lang.Object r0 = r0.second
            java.lang.Long r0 = (java.lang.Long) r0
            long r5 = r0.longValue()
            m1.k1 r0 = r1.E
            v1.a0 r0 = r0.f10317b
            boolean r0 = r4.equals(r0)
            r8 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r0 != 0) goto L_0x00cb
            r23 = r4
            r31 = r5
            r13 = r8
            goto L_0x00d1
        L_0x00cb:
            r23 = r4
            r31 = r5
            r13 = r8
            r7 = 0
        L_0x00d1:
            m1.a1 r0 = r1.f10517z
            r0.b()
            r1.K = r3
            m1.k1 r0 = new m1.k1
            m1.k1 r4 = r1.E
            g1.u1 r11 = r4.f10316a
            int r5 = r4.f10320e
            if (r38 == 0) goto L_0x00e3
            goto L_0x00e5
        L_0x00e3:
            m1.p r2 = r4.f10321f
        L_0x00e5:
            r18 = r2
            r19 = 0
            if (r7 == 0) goto L_0x00ee
            v1.l1 r2 = v1.l1.f15714k
            goto L_0x00f0
        L_0x00ee:
            v1.l1 r2 = r4.f10323h
        L_0x00f0:
            r20 = r2
            if (r7 == 0) goto L_0x00f7
            z1.y r2 = r1.f10503l
            goto L_0x00f9
        L_0x00f7:
            z1.y r2 = r4.f10324i
        L_0x00f9:
            r21 = r2
            if (r7 == 0) goto L_0x0102
            d9.p0 r2 = d9.r0.f4657i
            d9.r1 r2 = d9.r1.f4658l
            goto L_0x0104
        L_0x0102:
            java.util.List r2 = r4.f10325j
        L_0x0104:
            r22 = r2
            boolean r2 = r4.f10327l
            r24 = r2
            int r2 = r4.f10328m
            r25 = r2
            g1.e1 r2 = r4.f10329n
            r26 = r2
            r29 = 0
            r33 = 0
            r10 = r0
            r12 = r23
            r15 = r31
            r17 = r5
            r27 = r31
            r10.<init>(r11, r12, r13, r15, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r29, r31, r33)
            r1.E = r0
            if (r37 == 0) goto L_0x0166
            m1.j1 r2 = r1.A
            java.util.HashMap r4 = r2.f10300f
            java.util.Collection r0 = r4.values()
            java.util.Iterator r5 = r0.iterator()
        L_0x0132:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L_0x015c
            java.lang.Object r0 = r5.next()
            r6 = r0
            m1.h1 r6 = (m1.h1) r6
            v1.a r0 = r6.f10259a     // Catch:{ RuntimeException -> 0x0147 }
            v1.b0 r7 = r6.f10260b     // Catch:{ RuntimeException -> 0x0147 }
            r0.o(r7)     // Catch:{ RuntimeException -> 0x0147 }
            goto L_0x014f
        L_0x0147:
            r0 = move-exception
            java.lang.String r7 = "MediaSourceList"
            java.lang.String r8 = "Failed to release child source."
            j1.v.d(r7, r8, r0)
        L_0x014f:
            v1.a r0 = r6.f10259a
            android.support.v4.media.n r7 = r6.f10261c
            r0.r(r7)
            v1.a r0 = r6.f10259a
            r0.q(r7)
            goto L_0x0132
        L_0x015c:
            r4.clear()
            java.util.HashSet r0 = r2.f10301g
            r0.clear()
            r2.f10305k = r3
        L_0x0166:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: m1.u0.C(boolean, boolean, boolean, boolean):void");
    }

    public final void D() {
        boolean z10;
        y0 y0Var = this.f10517z.f10181h;
        if (y0Var == null || !y0Var.f10534f.f10554h || !this.H) {
            z10 = false;
        } else {
            z10 = true;
        }
        this.I = z10;
    }

    public final void E(long j10) {
        long j11;
        a1 a1Var = this.f10517z;
        y0 y0Var = a1Var.f10181h;
        if (y0Var == null) {
            j11 = 1000000000000L;
        } else {
            j11 = y0Var.f10543o;
        }
        long j12 = j10 + j11;
        this.S = j12;
        this.f10513v.f10360h.b(j12);
        for (f fVar : this.f10499h) {
            if (q(fVar)) {
                long j13 = this.S;
                fVar.f10226r = false;
                fVar.f10225q = j13;
                fVar.n(j13, false);
            }
        }
        for (y0 y0Var2 = a1Var.f10181h; y0Var2 != null; y0Var2 = y0Var2.f10540l) {
            for (s sVar : y0Var2.f10542n.f17489c) {
                if (sVar != null) {
                    sVar.r();
                }
            }
        }
    }

    public final void F(u1 u1Var, u1 u1Var2) {
        if (!u1Var.y() || !u1Var2.y()) {
            ArrayList arrayList = this.f10514w;
            int size = arrayList.size() - 1;
            if (size < 0) {
                Collections.sort(arrayList);
            } else {
                h.y(arrayList.get(size));
                throw null;
            }
        }
    }

    public final void I(long j10, long j11) {
        this.f10506o.f8429a.sendEmptyMessageAtTime(2, j10 + j11);
    }

    public final void J(boolean z10) {
        a0 a0Var = this.f10517z.f10181h.f10534f.f10547a;
        long L2 = L(a0Var, this.E.f10333r, true, false);
        if (L2 != this.E.f10333r) {
            k1 k1Var = this.E;
            this.E = o(a0Var, L2, k1Var.f10318c, k1Var.f10319d, z10, 5);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x00a7 A[Catch:{ all -> 0x0143 }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00aa A[Catch:{ all -> 0x0143 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void K(m1.t0 r20) {
        /*
            r19 = this;
            r11 = r19
            r0 = r20
            m1.r0 r1 = r11.F
            r8 = 1
            r1.a(r8)
            m1.k1 r1 = r11.E
            g1.u1 r1 = r1.f10316a
            r3 = 1
            int r4 = r11.L
            boolean r5 = r11.M
            g1.t1 r6 = r11.f10509r
            g1.r1 r7 = r11.f10510s
            r2 = r20
            android.util.Pair r1 = G(r1, r2, r3, r4, r5, r6, r7)
            r2 = 0
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r7 = 0
            if (r1 != 0) goto L_0x0045
            m1.k1 r6 = r11.E
            g1.u1 r6 = r6.f10316a
            android.util.Pair r6 = r11.g(r6)
            java.lang.Object r9 = r6.first
            v1.a0 r9 = (v1.a0) r9
            java.lang.Object r6 = r6.second
            java.lang.Long r6 = (java.lang.Long) r6
            long r12 = r6.longValue()
            m1.k1 r6 = r11.E
            g1.u1 r6 = r6.f10316a
            boolean r6 = r6.y()
            r6 = r6 ^ r8
            goto L_0x009b
        L_0x0045:
            java.lang.Object r6 = r1.first
            java.lang.Object r9 = r1.second
            java.lang.Long r9 = (java.lang.Long) r9
            long r12 = r9.longValue()
            long r9 = r0.f10495c
            int r14 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r14 != 0) goto L_0x0057
            r9 = r4
            goto L_0x0058
        L_0x0057:
            r9 = r12
        L_0x0058:
            m1.a1 r14 = r11.f10517z
            m1.k1 r15 = r11.E
            g1.u1 r15 = r15.f10316a
            v1.a0 r6 = r14.m(r15, r6, r12)
            boolean r14 = r6.a()
            if (r14 == 0) goto L_0x008c
            m1.k1 r4 = r11.E
            g1.u1 r4 = r4.f10316a
            java.lang.Object r5 = r6.f6678a
            g1.r1 r12 = r11.f10510s
            r4.p(r5, r12)
            g1.r1 r4 = r11.f10510s
            int r5 = r6.f6679b
            int r4 = r4.n(r5)
            int r5 = r6.f6680c
            if (r4 != r5) goto L_0x0086
            g1.r1 r4 = r11.f10510s
            g1.c r4 = r4.f6548n
            long r4 = r4.f6330j
            goto L_0x0087
        L_0x0086:
            r4 = r2
        L_0x0087:
            r12 = r4
            r14 = r9
            r10 = 1
            r9 = r6
            goto L_0x009d
        L_0x008c:
            long r14 = r0.f10495c
            int r16 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1))
            if (r16 != 0) goto L_0x0094
            r4 = 1
            goto L_0x0095
        L_0x0094:
            r4 = 0
        L_0x0095:
            r18 = r6
            r6 = r4
            r4 = r9
            r9 = r18
        L_0x009b:
            r14 = r4
            r10 = r6
        L_0x009d:
            m1.k1 r4 = r11.E     // Catch:{ all -> 0x0143 }
            g1.u1 r4 = r4.f10316a     // Catch:{ all -> 0x0143 }
            boolean r4 = r4.y()     // Catch:{ all -> 0x0143 }
            if (r4 == 0) goto L_0x00aa
            r11.R = r0     // Catch:{ all -> 0x0143 }
            goto L_0x00b9
        L_0x00aa:
            r0 = 4
            if (r1 != 0) goto L_0x00bb
            m1.k1 r1 = r11.E     // Catch:{ all -> 0x0143 }
            int r1 = r1.f10320e     // Catch:{ all -> 0x0143 }
            if (r1 == r8) goto L_0x00b6
            r11.X(r0)     // Catch:{ all -> 0x0143 }
        L_0x00b6:
            r11.C(r7, r8, r7, r8)     // Catch:{ all -> 0x0143 }
        L_0x00b9:
            r7 = r12
            goto L_0x00f9
        L_0x00bb:
            m1.k1 r1 = r11.E     // Catch:{ all -> 0x0143 }
            v1.a0 r1 = r1.f10317b     // Catch:{ all -> 0x0143 }
            boolean r1 = r9.equals(r1)     // Catch:{ all -> 0x0143 }
            if (r1 == 0) goto L_0x010a
            m1.a1 r1 = r11.f10517z     // Catch:{ all -> 0x0143 }
            m1.y0 r1 = r1.f10181h     // Catch:{ all -> 0x0143 }
            if (r1 == 0) goto L_0x00dc
            boolean r4 = r1.f10532d     // Catch:{ all -> 0x0143 }
            if (r4 == 0) goto L_0x00dc
            int r4 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x00dc
            v1.y r1 = r1.f10529a     // Catch:{ all -> 0x0143 }
            m1.p1 r2 = r11.D     // Catch:{ all -> 0x0143 }
            long r1 = r1.f(r12, r2)     // Catch:{ all -> 0x0143 }
            goto L_0x00dd
        L_0x00dc:
            r1 = r12
        L_0x00dd:
            long r3 = j1.l0.Q(r1)     // Catch:{ all -> 0x0143 }
            m1.k1 r5 = r11.E     // Catch:{ all -> 0x0143 }
            long r5 = r5.f10333r     // Catch:{ all -> 0x0143 }
            long r5 = j1.l0.Q(r5)     // Catch:{ all -> 0x0143 }
            int r16 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r16 != 0) goto L_0x0108
            m1.k1 r3 = r11.E     // Catch:{ all -> 0x0143 }
            int r4 = r3.f10320e     // Catch:{ all -> 0x0143 }
            r5 = 2
            if (r4 == r5) goto L_0x00f7
            r5 = 3
            if (r4 != r5) goto L_0x0108
        L_0x00f7:
            long r7 = r3.f10333r     // Catch:{ all -> 0x0143 }
        L_0x00f9:
            r0 = 2
            r1 = r19
            r2 = r9
            r3 = r7
            r5 = r14
            r9 = r10
            r10 = r0
            m1.k1 r0 = r1.o(r2, r3, r5, r7, r9, r10)
            r11.E = r0
            return
        L_0x0108:
            r3 = r1
            goto L_0x010b
        L_0x010a:
            r3 = r12
        L_0x010b:
            m1.k1 r1 = r11.E     // Catch:{ all -> 0x0143 }
            int r1 = r1.f10320e     // Catch:{ all -> 0x0143 }
            if (r1 != r0) goto L_0x0113
            r6 = 1
            goto L_0x0114
        L_0x0113:
            r6 = 0
        L_0x0114:
            m1.a1 r0 = r11.f10517z     // Catch:{ all -> 0x0143 }
            m1.y0 r1 = r0.f10181h     // Catch:{ all -> 0x0143 }
            m1.y0 r0 = r0.f10182i     // Catch:{ all -> 0x0143 }
            if (r1 == r0) goto L_0x011e
            r5 = 1
            goto L_0x011f
        L_0x011e:
            r5 = 0
        L_0x011f:
            r1 = r19
            r2 = r9
            long r16 = r1.L(r2, r3, r5, r6)     // Catch:{ all -> 0x0143 }
            int r0 = (r12 > r16 ? 1 : (r12 == r16 ? 0 : -1))
            if (r0 == 0) goto L_0x012b
            goto L_0x012c
        L_0x012b:
            r8 = 0
        L_0x012c:
            r10 = r10 | r8
            m1.k1 r0 = r11.E     // Catch:{ all -> 0x013f }
            g1.u1 r4 = r0.f10316a     // Catch:{ all -> 0x013f }
            v1.a0 r5 = r0.f10317b     // Catch:{ all -> 0x013f }
            r8 = 1
            r1 = r19
            r2 = r4
            r3 = r9
            r6 = r14
            r1.g0(r2, r3, r4, r5, r6, r8)     // Catch:{ all -> 0x013f }
            r7 = r16
            goto L_0x00f9
        L_0x013f:
            r0 = move-exception
            r7 = r16
            goto L_0x0145
        L_0x0143:
            r0 = move-exception
            r7 = r12
        L_0x0145:
            r12 = 2
            r1 = r19
            r2 = r9
            r3 = r7
            r5 = r14
            r9 = r10
            r10 = r12
            m1.k1 r1 = r1.o(r2, r3, r5, r7, r9, r10)
            r11.E = r1
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: m1.u0.K(m1.t0):void");
    }

    public final long L(a0 a0Var, long j10, boolean z10, boolean z11) {
        c0();
        this.J = false;
        if (z11 || this.E.f10320e == 3) {
            X(2);
        }
        a1 a1Var = this.f10517z;
        y0 y0Var = a1Var.f10181h;
        y0 y0Var2 = y0Var;
        while (y0Var2 != null && !a0Var.equals(y0Var2.f10534f.f10547a)) {
            y0Var2 = y0Var2.f10540l;
        }
        if (z10 || y0Var != y0Var2 || (y0Var2 != null && y0Var2.f10543o + j10 < 0)) {
            f[] fVarArr = this.f10499h;
            for (f c10 : fVarArr) {
                c(c10);
            }
            if (y0Var2 != null) {
                while (a1Var.f10181h != y0Var2) {
                    a1Var.a();
                }
                a1Var.k(y0Var2);
                y0Var2.f10543o = 1000000000000L;
                e(new boolean[fVarArr.length]);
            }
        }
        if (y0Var2 != null) {
            a1Var.k(y0Var2);
            if (!y0Var2.f10532d) {
                y0Var2.f10534f = y0Var2.f10534f.b(j10);
            } else if (y0Var2.f10533e) {
                v1.y yVar = y0Var2.f10529a;
                j10 = yVar.B(j10);
                yVar.y(j10 - this.f10511t, this.f10512u);
            }
            E(j10);
            t();
        } else {
            a1Var.b();
            E(j10);
        }
        k(false);
        this.f10506o.d(2);
        return j10;
    }

    public final void M(m1 m1Var) {
        Looper looper = m1Var.f10356f;
        if (!looper.getThread().isAlive()) {
            v.g("TAG", "Trying to send message on a dead thread.");
            m1Var.b(false);
            return;
        }
        ((d0) this.f10515x).a(looper, (Handler.Callback) null).c(new r0(this, 9, m1Var));
    }

    public final void O(boolean z10, AtomicBoolean atomicBoolean) {
        if (this.N != z10) {
            this.N = z10;
            if (!z10) {
                for (f fVar : this.f10499h) {
                    if (!q(fVar) && this.f10500i.remove(fVar)) {
                        fVar.v();
                    }
                }
            }
        }
        if (atomicBoolean != null) {
            synchronized (this) {
                atomicBoolean.set(true);
                notifyAll();
            }
        }
    }

    public final void P(p0 p0Var) {
        this.F.a(1);
        int i10 = p0Var.f10433c;
        e1 e1Var = p0Var.f10432b;
        List list = p0Var.f10431a;
        if (i10 != -1) {
            this.R = new t0(new n1(list, e1Var), p0Var.f10433c, p0Var.f10434d);
        }
        j1 j1Var = this.A;
        ArrayList arrayList = j1Var.f10296b;
        j1Var.f(0, arrayList.size());
        l(j1Var.a(arrayList.size(), list, e1Var), false);
    }

    public final void Q(boolean z10) {
        if (z10 != this.P) {
            this.P = z10;
            if (!z10 && this.E.f10330o) {
                this.f10506o.d(2);
            }
        }
    }

    public final void R(boolean z10) {
        this.H = z10;
        D();
        if (this.I) {
            a1 a1Var = this.f10517z;
            if (a1Var.f10182i != a1Var.f10181h) {
                J(true);
                k(false);
            }
        }
    }

    public final void S(int i10, int i11, boolean z10, boolean z11) {
        this.F.a(z11 ? 1 : 0);
        r0 r0Var = this.F;
        r0Var.f10451a = true;
        r0Var.f10456f = true;
        r0Var.f10457g = i11;
        this.E = this.E.c(i10, z10);
        this.J = false;
        for (y0 y0Var = this.f10517z.f10181h; y0Var != null; y0Var = y0Var.f10540l) {
            for (s sVar : y0Var.f10542n.f17489c) {
                if (sVar != null) {
                    sVar.d(z10);
                }
            }
        }
        if (!Y()) {
            c0();
            f0();
            return;
        }
        int i12 = this.E.f10320e;
        if (i12 == 3) {
            a0();
        } else if (i12 != 2) {
            return;
        }
        this.f10506o.d(2);
    }

    public final void T(g1.e1 e1Var) {
        this.f10506o.f8429a.removeMessages(16);
        n nVar = this.f10513v;
        nVar.d(e1Var);
        g1.e1 i10 = nVar.i();
        n(i10, i10.f6355h, true, true);
    }

    public final void U(int i10) {
        this.L = i10;
        u1 u1Var = this.E.f10316a;
        a1 a1Var = this.f10517z;
        a1Var.f10179f = i10;
        if (!a1Var.n(u1Var)) {
            J(true);
        }
        k(false);
    }

    public final void V(boolean z10) {
        this.M = z10;
        u1 u1Var = this.E.f10316a;
        a1 a1Var = this.f10517z;
        a1Var.f10180g = z10;
        if (!a1Var.n(u1Var)) {
            J(true);
        }
        k(false);
    }

    public final void W(e1 e1Var) {
        this.F.a(1);
        j1 j1Var = this.A;
        int size = j1Var.f10296b.size();
        if (e1Var.f15616b.length != size) {
            e1Var = new e1(new Random(e1Var.f15615a.nextLong())).a(0, size);
        }
        j1Var.f10304j = e1Var;
        l(j1Var.b(), false);
    }

    public final void X(int i10) {
        k1 k1Var = this.E;
        if (k1Var.f10320e != i10) {
            if (i10 != 2) {
                this.W = -9223372036854775807L;
            }
            this.E = k1Var.f(i10);
        }
    }

    public final boolean Y() {
        k1 k1Var = this.E;
        return k1Var.f10327l && k1Var.f10328m == 0;
    }

    public final boolean Z(u1 u1Var, a0 a0Var) {
        if (a0Var.a() || u1Var.y()) {
            return false;
        }
        int i10 = u1Var.p(a0Var.f6678a, this.f10510s).f6544j;
        t1 t1Var = this.f10509r;
        u1Var.v(i10, t1Var);
        return t1Var.k() && t1Var.f6583p && t1Var.f6580m != -9223372036854775807L;
    }

    public final void a(p0 p0Var, int i10) {
        this.F.a(1);
        j1 j1Var = this.A;
        if (i10 == -1) {
            i10 = j1Var.f10296b.size();
        }
        l(j1Var.a(i10, p0Var.f10431a, p0Var.f10432b), false);
    }

    public final void a0() {
        boolean z10;
        this.J = false;
        n nVar = this.f10513v;
        nVar.f10365m = true;
        nVar.f10360h.c();
        for (f fVar : this.f10499h) {
            if (q(fVar)) {
                if (fVar.f10221m == 1) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                j1.a.e(z10);
                fVar.f10221m = 2;
                fVar.p();
            }
        }
    }

    public final void b0(boolean z10, boolean z11) {
        boolean z12;
        if (z10 || !this.N) {
            z12 = true;
        } else {
            z12 = false;
        }
        C(z12, false, true, false);
        this.F.a(z11 ? 1 : 0);
        this.f10504m.b(true);
        X(1);
    }

    public final void c(f fVar) {
        boolean z10;
        boolean z11;
        boolean z12;
        int i10 = fVar.f10221m;
        if (i10 != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            n nVar = this.f10513v;
            if (fVar == nVar.f10362j) {
                nVar.f10363k = null;
                nVar.f10362j = null;
                nVar.f10364l = true;
            }
            if (i10 == 2) {
                if (i10 == 2) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                j1.a.e(z12);
                fVar.f10221m = 1;
                fVar.q();
            }
            if (fVar.f10221m == 1) {
                z11 = true;
            } else {
                z11 = false;
            }
            j1.a.e(z11);
            fVar.f10217i.a();
            fVar.f10221m = 0;
            fVar.f10222n = null;
            fVar.f10223o = null;
            fVar.f10226r = false;
            fVar.l();
            this.Q--;
        }
    }

    public final void c0() {
        int i10;
        boolean z10;
        n nVar = this.f10513v;
        nVar.f10365m = false;
        q1 q1Var = nVar.f10360h;
        if (q1Var.f10445i) {
            q1Var.b(q1Var.a());
            q1Var.f10445i = false;
        }
        for (f fVar : this.f10499h) {
            if (q(fVar) && (i10 = fVar.f10221m) == 2) {
                if (i10 == 2) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                j1.a.e(z10);
                fVar.f10221m = 1;
                fVar.q();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x007f, code lost:
        if (r0.f10184k < 100) goto L_0x0084;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:340:0x0548, code lost:
        if (r2 >= r6.f10343j) goto L_0x0550;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:346:0x0551, code lost:
        if (r8 == false) goto L_0x0554;
     */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x02aa  */
    /* JADX WARNING: Removed duplicated region for block: B:186:0x0309  */
    /* JADX WARNING: Removed duplicated region for block: B:200:0x0335  */
    /* JADX WARNING: Removed duplicated region for block: B:201:0x0337  */
    /* JADX WARNING: Removed duplicated region for block: B:203:0x033a  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:384:0x05d1  */
    /* JADX WARNING: Removed duplicated region for block: B:402:0x060e  */
    /* JADX WARNING: Removed duplicated region for block: B:403:0x0610  */
    /* JADX WARNING: Removed duplicated region for block: B:413:0x063e  */
    /* JADX WARNING: Removed duplicated region for block: B:414:0x0640  */
    /* JADX WARNING: Removed duplicated region for block: B:424:0x0654  */
    /* JADX WARNING: Removed duplicated region for block: B:432:0x06b6  */
    /* JADX WARNING: Removed duplicated region for block: B:437:0x06c2  */
    /* JADX WARNING: Removed duplicated region for block: B:460:0x0305 A[EDGE_INSN: B:460:0x0305->B:184:0x0305 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:467:0x0399 A[EDGE_INSN: B:467:0x0399->B:217:0x0399 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0125  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x012f  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x013a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void d() {
        /*
            r52 = this;
            r11 = r52
            j1.d r0 = r11.f10515x
            j1.d0 r0 = (j1.d0) r0
            r0.getClass()
            long r12 = android.os.SystemClock.uptimeMillis()
            j1.f0 r0 = r11.f10506o
            android.os.Handler r0 = r0.f8429a
            r14 = 2
            r0.removeMessages(r14)
            m1.k1 r0 = r11.E
            g1.u1 r0 = r0.f10316a
            boolean r0 = r0.y()
            r16 = -9223372036854775808
            r9 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r8 = 0
            r6 = 1
            if (r0 != 0) goto L_0x0394
            m1.j1 r0 = r11.A
            boolean r0 = r0.f10305k
            if (r0 != 0) goto L_0x0030
            goto L_0x0394
        L_0x0030:
            m1.a1 r0 = r11.f10517z
            long r1 = r11.S
            m1.y0 r0 = r0.f10183j
            if (r0 == 0) goto L_0x004e
            m1.y0 r3 = r0.f10540l
            if (r3 != 0) goto L_0x003e
            r3 = 1
            goto L_0x003f
        L_0x003e:
            r3 = 0
        L_0x003f:
            j1.a.e(r3)
            boolean r3 = r0.f10532d
            if (r3 == 0) goto L_0x004e
            v1.y r3 = r0.f10529a
            long r4 = r0.f10543o
            long r1 = r1 - r4
            r3.D(r1)
        L_0x004e:
            m1.a1 r0 = r11.f10517z
            m1.y0 r1 = r0.f10183j
            if (r1 == 0) goto L_0x0084
            m1.z0 r2 = r1.f10534f
            boolean r2 = r2.f10555i
            if (r2 != 0) goto L_0x0082
            boolean r2 = r1.f10532d
            if (r2 == 0) goto L_0x006e
            boolean r2 = r1.f10533e
            if (r2 == 0) goto L_0x006c
            v1.y r1 = r1.f10529a
            long r1 = r1.u()
            int r3 = (r1 > r16 ? 1 : (r1 == r16 ? 0 : -1))
            if (r3 != 0) goto L_0x006e
        L_0x006c:
            r1 = 1
            goto L_0x006f
        L_0x006e:
            r1 = 0
        L_0x006f:
            if (r1 == 0) goto L_0x0082
            m1.y0 r1 = r0.f10183j
            m1.z0 r1 = r1.f10534f
            long r1 = r1.f10551e
            int r3 = (r1 > r9 ? 1 : (r1 == r9 ? 0 : -1))
            if (r3 == 0) goto L_0x0082
            int r0 = r0.f10184k
            r1 = 100
            if (r0 >= r1) goto L_0x0082
            goto L_0x0084
        L_0x0082:
            r0 = 0
            goto L_0x0085
        L_0x0084:
            r0 = 1
        L_0x0085:
            if (r0 == 0) goto L_0x0121
            m1.a1 r0 = r11.f10517z
            long r1 = r11.S
            m1.k1 r3 = r11.E
            m1.y0 r4 = r0.f10183j
            if (r4 != 0) goto L_0x00a8
            g1.u1 r1 = r3.f10316a
            v1.a0 r2 = r3.f10317b
            long r4 = r3.f10318c
            long r9 = r3.f10333r
            r18 = r0
            r19 = r1
            r20 = r2
            r21 = r4
            r23 = r9
            m1.z0 r0 = r18.d(r19, r20, r21, r23)
            goto L_0x00ae
        L_0x00a8:
            g1.u1 r3 = r3.f10316a
            m1.z0 r0 = r0.c(r3, r4, r1)
        L_0x00ae:
            if (r0 == 0) goto L_0x0121
            m1.a1 r1 = r11.f10517z
            m1.f[] r2 = r11.f10501j
            z1.x r3 = r11.f10502k
            m1.l r4 = r11.f10504m
            a2.e r4 = r4.f10334a
            m1.j1 r5 = r11.A
            z1.y r7 = r11.f10503l
            m1.y0 r9 = r1.f10183j
            if (r9 != 0) goto L_0x00ca
            r9 = 1000000000000(0xe8d4a51000, double:4.94065645841E-312)
            r29 = r9
            goto L_0x00d6
        L_0x00ca:
            long r14 = r9.f10543o
            m1.z0 r9 = r9.f10534f
            long r9 = r9.f10551e
            long r14 = r14 + r9
            long r9 = r0.f10548b
            long r14 = r14 - r9
            r29 = r14
        L_0x00d6:
            m1.y0 r9 = new m1.y0
            r27 = r9
            r28 = r2
            r31 = r3
            r32 = r4
            r33 = r5
            r34 = r0
            r35 = r7
            r27.<init>(r28, r29, r31, r32, r33, r34, r35)
            m1.y0 r2 = r1.f10183j
            if (r2 == 0) goto L_0x00fb
            m1.y0 r3 = r2.f10540l
            if (r9 != r3) goto L_0x00f2
            goto L_0x00ff
        L_0x00f2:
            r2.b()
            r2.f10540l = r9
            r2.c()
            goto L_0x00ff
        L_0x00fb:
            r1.f10181h = r9
            r1.f10182i = r9
        L_0x00ff:
            r2 = 0
            r1.f10185l = r2
            r1.f10183j = r9
            int r2 = r1.f10184k
            int r2 = r2 + r6
            r1.f10184k = r2
            r1.j()
            v1.y r1 = r9.f10529a
            long r2 = r0.f10548b
            r1.m(r11, r2)
            m1.a1 r1 = r11.f10517z
            m1.y0 r1 = r1.f10181h
            if (r1 != r9) goto L_0x011e
            long r0 = r0.f10548b
            r11.E(r0)
        L_0x011e:
            r11.k(r8)
        L_0x0121:
            boolean r0 = r11.K
            if (r0 == 0) goto L_0x012f
            boolean r0 = r52.p()
            r11.K = r0
            r52.d0()
            goto L_0x0132
        L_0x012f:
            r52.t()
        L_0x0132:
            m1.a1 r0 = r11.f10517z
            m1.y0 r1 = r0.f10182i
            if (r1 != 0) goto L_0x013a
            goto L_0x019e
        L_0x013a:
            m1.y0 r2 = r1.f10540l
            m1.f[] r9 = r11.f10499h
            if (r2 == 0) goto L_0x024a
            boolean r2 = r11.I
            if (r2 == 0) goto L_0x0146
            goto L_0x024a
        L_0x0146:
            boolean r2 = r1.f10532d
            if (r2 != 0) goto L_0x014b
            goto L_0x0188
        L_0x014b:
            r2 = 0
        L_0x014c:
            int r3 = r9.length
            if (r2 >= r3) goto L_0x018a
            r3 = r9[r2]
            v1.b1[] r4 = r1.f10531c
            r4 = r4[r2]
            v1.b1 r5 = r3.f10222n
            if (r5 != r4) goto L_0x0188
            if (r4 == 0) goto L_0x0185
            boolean r4 = r3.h()
            if (r4 != 0) goto L_0x0185
            m1.y0 r4 = r1.f10540l
            m1.z0 r5 = r1.f10534f
            boolean r5 = r5.f10552f
            if (r5 == 0) goto L_0x0181
            boolean r5 = r4.f10532d
            if (r5 == 0) goto L_0x0181
            boolean r5 = r3 instanceof y1.g
            if (r5 != 0) goto L_0x017f
            boolean r5 = r3 instanceof t1.c
            if (r5 != 0) goto L_0x017f
            long r14 = r3.f10225q
            long r3 = r4.e()
            int r5 = (r14 > r3 ? 1 : (r14 == r3 ? 0 : -1))
            if (r5 < 0) goto L_0x0181
        L_0x017f:
            r3 = 1
            goto L_0x0182
        L_0x0181:
            r3 = 0
        L_0x0182:
            if (r3 != 0) goto L_0x0185
            goto L_0x0188
        L_0x0185:
            int r2 = r2 + 1
            goto L_0x014c
        L_0x0188:
            r2 = 0
            goto L_0x018b
        L_0x018a:
            r2 = 1
        L_0x018b:
            if (r2 != 0) goto L_0x018e
            goto L_0x019e
        L_0x018e:
            m1.y0 r2 = r1.f10540l
            boolean r3 = r2.f10532d
            if (r3 != 0) goto L_0x01a9
            long r3 = r11.S
            long r14 = r2.e()
            int r2 = (r3 > r14 ? 1 : (r3 == r14 ? 0 : -1))
            if (r2 >= 0) goto L_0x01a9
        L_0x019e:
            r22 = r12
            r12 = 1
            r13 = 0
        L_0x01a2:
            r14 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            goto L_0x0291
        L_0x01a9:
            z1.y r10 = r1.f10542n
            m1.y0 r2 = r0.f10182i
            if (r2 == 0) goto L_0x01b5
            m1.y0 r2 = r2.f10540l
            if (r2 == 0) goto L_0x01b5
            r2 = 1
            goto L_0x01b6
        L_0x01b5:
            r2 = 0
        L_0x01b6:
            j1.a.e(r2)
            m1.y0 r2 = r0.f10182i
            m1.y0 r2 = r2.f10540l
            r0.f10182i = r2
            r0.j()
            m1.y0 r0 = r0.f10182i
            z1.y r14 = r0.f10542n
            m1.k1 r2 = r11.E
            g1.u1 r4 = r2.f10316a
            m1.z0 r2 = r0.f10534f
            v1.a0 r3 = r2.f10547a
            m1.z0 r1 = r1.f10534f
            v1.a0 r5 = r1.f10547a
            r20 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r15 = 0
            r1 = r52
            r2 = r4
            r22 = r12
            r12 = 1
            r6 = r20
            r13 = 0
            r8 = r15
            r1.g0(r2, r3, r4, r5, r6, r8)
            boolean r1 = r0.f10532d
            if (r1 == 0) goto L_0x020c
            v1.y r1 = r0.f10529a
            long r1 = r1.k()
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x020c
            long r0 = r0.e()
            int r2 = r9.length
            r8 = 0
        L_0x01fe:
            if (r8 >= r2) goto L_0x01a2
            r3 = r9[r8]
            v1.b1 r4 = r3.f10222n
            if (r4 == 0) goto L_0x0209
            N(r3, r0)
        L_0x0209:
            int r8 = r8 + 1
            goto L_0x01fe
        L_0x020c:
            r8 = 0
        L_0x020d:
            int r1 = r9.length
            if (r8 >= r1) goto L_0x01a2
            boolean r1 = r10.b(r8)
            boolean r2 = r14.b(r8)
            if (r1 == 0) goto L_0x0247
            r1 = r9[r8]
            boolean r1 = r1.f10226r
            if (r1 != 0) goto L_0x0247
            m1.f[] r1 = r11.f10501j
            r1 = r1[r8]
            int r1 = r1.f10216h
            r3 = -2
            if (r1 != r3) goto L_0x022b
            r1 = 1
            goto L_0x022c
        L_0x022b:
            r1 = 0
        L_0x022c:
            m1.o1[] r3 = r10.f17488b
            r3 = r3[r8]
            m1.o1[] r4 = r14.f17488b
            r4 = r4[r8]
            if (r2 == 0) goto L_0x023e
            boolean r2 = r4.equals(r3)
            if (r2 == 0) goto L_0x023e
            if (r1 == 0) goto L_0x0247
        L_0x023e:
            r1 = r9[r8]
            long r2 = r0.e()
            N(r1, r2)
        L_0x0247:
            int r8 = r8 + 1
            goto L_0x020d
        L_0x024a:
            r22 = r12
            r12 = 1
            r13 = 0
            m1.z0 r0 = r1.f10534f
            boolean r0 = r0.f10555i
            if (r0 != 0) goto L_0x0258
            boolean r0 = r11.I
            if (r0 == 0) goto L_0x01a2
        L_0x0258:
            r8 = 0
        L_0x0259:
            int r0 = r9.length
            if (r8 >= r0) goto L_0x01a2
            r0 = r9[r8]
            v1.b1[] r2 = r1.f10531c
            r2 = r2[r8]
            if (r2 == 0) goto L_0x0289
            v1.b1 r3 = r0.f10222n
            if (r3 != r2) goto L_0x0289
            boolean r2 = r0.h()
            if (r2 == 0) goto L_0x0289
            m1.z0 r2 = r1.f10534f
            long r2 = r2.f10551e
            r14 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r4 = (r2 > r14 ? 1 : (r2 == r14 ? 0 : -1))
            if (r4 == 0) goto L_0x0284
            int r4 = (r2 > r16 ? 1 : (r2 == r16 ? 0 : -1))
            if (r4 == 0) goto L_0x0284
            long r4 = r1.f10543o
            long r3 = r2 + r4
            goto L_0x0285
        L_0x0284:
            r3 = r14
        L_0x0285:
            N(r0, r3)
            goto L_0x028e
        L_0x0289:
            r14 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
        L_0x028e:
            int r8 = r8 + 1
            goto L_0x0259
        L_0x0291:
            m1.a1 r0 = r11.f10517z
            m1.y0 r1 = r0.f10182i
            if (r1 == 0) goto L_0x030f
            m1.y0 r0 = r0.f10181h
            if (r0 == r1) goto L_0x030f
            boolean r0 = r1.f10535g
            if (r0 == 0) goto L_0x02a1
            goto L_0x030f
        L_0x02a1:
            z1.y r0 = r1.f10542n
            r2 = 0
            r8 = 0
        L_0x02a5:
            m1.f[] r3 = r11.f10499h
            int r4 = r3.length
            if (r8 >= r4) goto L_0x0305
            r3 = r3[r8]
            boolean r4 = q(r3)
            if (r4 != 0) goto L_0x02b3
            goto L_0x0302
        L_0x02b3:
            v1.b1 r4 = r3.f10222n
            v1.b1[] r5 = r1.f10531c
            r6 = r5[r8]
            if (r4 == r6) goto L_0x02bd
            r4 = 1
            goto L_0x02be
        L_0x02bd:
            r4 = 0
        L_0x02be:
            boolean r6 = r0.b(r8)
            if (r6 == 0) goto L_0x02c7
            if (r4 != 0) goto L_0x02c7
            goto L_0x0302
        L_0x02c7:
            boolean r4 = r3.f10226r
            if (r4 != 0) goto L_0x02f7
            z1.s[] r4 = r0.f17489c
            r4 = r4[r8]
            if (r4 == 0) goto L_0x02d6
            int r6 = r4.length()
            goto L_0x02d7
        L_0x02d6:
            r6 = 0
        L_0x02d7:
            g1.a0[] r7 = new g1.a0[r6]
            r9 = 0
        L_0x02da:
            if (r9 >= r6) goto L_0x02e5
            g1.a0 r10 = r4.e(r9)
            r7[r9] = r10
            int r9 = r9 + 1
            goto L_0x02da
        L_0x02e5:
            r26 = r5[r8]
            long r27 = r1.e()
            long r4 = r1.f10543o
            r24 = r3
            r25 = r7
            r29 = r4
            r24.u(r25, r26, r27, r29)
            goto L_0x0302
        L_0x02f7:
            boolean r4 = r3.j()
            if (r4 == 0) goto L_0x0301
            r11.c(r3)
            goto L_0x0302
        L_0x0301:
            r2 = 1
        L_0x0302:
            int r8 = r8 + 1
            goto L_0x02a5
        L_0x0305:
            r0 = r2 ^ 1
            if (r0 == 0) goto L_0x030f
            int r0 = r3.length
            boolean[] r0 = new boolean[r0]
            r11.e(r0)
        L_0x030f:
            r8 = 0
        L_0x0310:
            boolean r0 = r52.Y()
            m1.a1 r1 = r11.f10517z
            if (r0 != 0) goto L_0x0319
            goto L_0x0337
        L_0x0319:
            boolean r0 = r11.I
            if (r0 == 0) goto L_0x031e
            goto L_0x0337
        L_0x031e:
            m1.y0 r0 = r1.f10181h
            if (r0 != 0) goto L_0x0323
            goto L_0x0337
        L_0x0323:
            m1.y0 r0 = r0.f10540l
            if (r0 == 0) goto L_0x0337
            long r2 = r11.S
            long r4 = r0.e()
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 < 0) goto L_0x0337
            boolean r0 = r0.f10535g
            if (r0 == 0) goto L_0x0337
            r0 = 1
            goto L_0x0338
        L_0x0337:
            r0 = 0
        L_0x0338:
            if (r0 == 0) goto L_0x0399
            if (r8 == 0) goto L_0x033f
            r52.u()
        L_0x033f:
            m1.y0 r0 = r1.a()
            r0.getClass()
            m1.k1 r1 = r11.E
            v1.a0 r1 = r1.f10317b
            java.lang.Object r1 = r1.f6678a
            m1.z0 r2 = r0.f10534f
            v1.a0 r2 = r2.f10547a
            java.lang.Object r2 = r2.f6678a
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0371
            m1.k1 r1 = r11.E
            v1.a0 r1 = r1.f10317b
            int r2 = r1.f6679b
            r3 = -1
            if (r2 != r3) goto L_0x0371
            m1.z0 r2 = r0.f10534f
            v1.a0 r2 = r2.f10547a
            int r4 = r2.f6679b
            if (r4 != r3) goto L_0x0371
            int r1 = r1.f6682e
            int r2 = r2.f6682e
            if (r1 == r2) goto L_0x0371
            r8 = 1
            goto L_0x0372
        L_0x0371:
            r8 = 0
        L_0x0372:
            m1.z0 r0 = r0.f10534f
            v1.a0 r2 = r0.f10547a
            long r9 = r0.f10548b
            long r5 = r0.f10549c
            r0 = r8 ^ 1
            r20 = 0
            r1 = r52
            r3 = r9
            r7 = r9
            r9 = r0
            r10 = r20
            m1.k1 r0 = r1.o(r2, r3, r5, r7, r9, r10)
            r11.E = r0
            r52.D()
            r52.f0()
            r8 = 1
            goto L_0x0310
        L_0x0394:
            r14 = r9
            r22 = r12
            r12 = 1
            r13 = 0
        L_0x0399:
            m1.k1 r0 = r11.E
            int r0 = r0.f10320e
            if (r0 == r12) goto L_0x06d5
            r1 = 4
            if (r0 != r1) goto L_0x03a4
            goto L_0x06d5
        L_0x03a4:
            m1.a1 r0 = r11.f10517z
            m1.y0 r0 = r0.f10181h
            r2 = 10
            if (r0 != 0) goto L_0x03b2
            r4 = r22
            r11.I(r4, r2)
            return
        L_0x03b2:
            r4 = r22
            java.lang.String r6 = "doSomeWork"
            j1.i0.a(r6)
            r52.f0()
            boolean r6 = r0.f10532d
            r7 = 1000(0x3e8, double:4.94E-321)
            if (r6 == 0) goto L_0x0437
            long r9 = android.os.SystemClock.elapsedRealtime()
            long r9 = r9 * r7
            v1.y r6 = r0.f10529a
            m1.k1 r2 = r11.E
            long r2 = r2.f10333r
            long r7 = r11.f10511t
            long r2 = r2 - r7
            boolean r7 = r11.f10512u
            r6.y(r2, r7)
            r2 = 1
            r6 = 1
            r8 = 0
        L_0x03d9:
            m1.f[] r3 = r11.f10499h
            int r7 = r3.length
            if (r8 >= r7) goto L_0x043e
            r3 = r3[r8]
            boolean r7 = q(r3)
            if (r7 != 0) goto L_0x03e7
            goto L_0x0432
        L_0x03e7:
            long r12 = r11.S
            r3.t(r12, r9)
            if (r6 == 0) goto L_0x03f6
            boolean r6 = r3.j()
            if (r6 == 0) goto L_0x03f6
            r6 = 1
            goto L_0x03f7
        L_0x03f6:
            r6 = 0
        L_0x03f7:
            v1.b1[] r12 = r0.f10531c
            r12 = r12[r8]
            v1.b1 r13 = r3.f10222n
            if (r12 == r13) goto L_0x0401
            r12 = 1
            goto L_0x0402
        L_0x0401:
            r12 = 0
        L_0x0402:
            if (r12 != 0) goto L_0x040c
            boolean r13 = r3.h()
            if (r13 == 0) goto L_0x040c
            r13 = 1
            goto L_0x040d
        L_0x040c:
            r13 = 0
        L_0x040d:
            if (r12 != 0) goto L_0x0420
            if (r13 != 0) goto L_0x0420
            boolean r12 = r3.k()
            if (r12 != 0) goto L_0x0420
            boolean r12 = r3.j()
            if (r12 == 0) goto L_0x041e
            goto L_0x0420
        L_0x041e:
            r12 = 0
            goto L_0x0421
        L_0x0420:
            r12 = 1
        L_0x0421:
            if (r2 == 0) goto L_0x0427
            if (r12 == 0) goto L_0x0427
            r2 = 1
            goto L_0x0428
        L_0x0427:
            r2 = 0
        L_0x0428:
            if (r12 != 0) goto L_0x0432
            v1.b1 r3 = r3.f10222n
            r3.getClass()
            r3.c()
        L_0x0432:
            int r8 = r8 + 1
            r12 = 1
            r13 = 0
            goto L_0x03d9
        L_0x0437:
            v1.y r2 = r0.f10529a
            r2.v()
            r2 = 1
            r6 = 1
        L_0x043e:
            m1.z0 r3 = r0.f10534f
            long r8 = r3.f10551e
            if (r6 == 0) goto L_0x0456
            boolean r3 = r0.f10532d
            if (r3 == 0) goto L_0x0456
            int r3 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r3 == 0) goto L_0x0454
            m1.k1 r3 = r11.E
            long r12 = r3.f10333r
            int r3 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r3 > 0) goto L_0x0456
        L_0x0454:
            r8 = 1
            goto L_0x0457
        L_0x0456:
            r8 = 0
        L_0x0457:
            if (r8 == 0) goto L_0x0468
            boolean r3 = r11.I
            if (r3 == 0) goto L_0x0468
            r3 = 0
            r11.I = r3
            m1.k1 r6 = r11.E
            int r6 = r6.f10328m
            r9 = 5
            r11.S(r6, r9, r3, r3)
        L_0x0468:
            if (r8 == 0) goto L_0x0477
            m1.z0 r6 = r0.f10534f
            boolean r6 = r6.f10555i
            if (r6 == 0) goto L_0x0477
            r11.X(r1)
            r26 = r4
            goto L_0x05c7
        L_0x0477:
            m1.k1 r6 = r11.E
            int r8 = r6.f10320e
            r9 = 2
            if (r8 != r9) goto L_0x056a
            int r8 = r11.Q
            if (r8 != 0) goto L_0x048c
            boolean r8 = r52.s()
            r25 = r2
            r26 = r4
            goto L_0x0557
        L_0x048c:
            if (r2 != 0) goto L_0x0494
            r25 = r2
            r26 = r4
            goto L_0x0554
        L_0x0494:
            boolean r8 = r6.f10322g
            if (r8 != 0) goto L_0x049e
        L_0x0498:
            r25 = r2
            r26 = r4
            goto L_0x0556
        L_0x049e:
            g1.u1 r6 = r6.f10316a
            m1.a1 r8 = r11.f10517z
            m1.y0 r9 = r8.f10181h
            m1.z0 r9 = r9.f10534f
            v1.a0 r9 = r9.f10547a
            boolean r6 = r11.Z(r6, r9)
            if (r6 == 0) goto L_0x04b3
            m1.j r6 = r11.B
            long r9 = r6.f10287m
            goto L_0x04b4
        L_0x04b3:
            r9 = r14
        L_0x04b4:
            m1.y0 r6 = r8.f10183j
            boolean r8 = r6.f10532d
            if (r8 == 0) goto L_0x04ca
            boolean r8 = r6.f10533e
            if (r8 == 0) goto L_0x04c8
            v1.y r8 = r6.f10529a
            long r12 = r8.u()
            int r8 = (r12 > r16 ? 1 : (r12 == r16 ? 0 : -1))
            if (r8 != 0) goto L_0x04ca
        L_0x04c8:
            r8 = 1
            goto L_0x04cb
        L_0x04ca:
            r8 = 0
        L_0x04cb:
            if (r8 == 0) goto L_0x04d5
            m1.z0 r8 = r6.f10534f
            boolean r8 = r8.f10555i
            if (r8 == 0) goto L_0x04d5
            r8 = 1
            goto L_0x04d6
        L_0x04d5:
            r8 = 0
        L_0x04d6:
            m1.z0 r12 = r6.f10534f
            v1.a0 r12 = r12.f10547a
            boolean r12 = r12.a()
            if (r12 == 0) goto L_0x04e6
            boolean r6 = r6.f10532d
            if (r6 != 0) goto L_0x04e6
            r6 = 1
            goto L_0x04e7
        L_0x04e6:
            r6 = 0
        L_0x04e7:
            if (r8 != 0) goto L_0x0498
            if (r6 != 0) goto L_0x0498
            m1.k1 r6 = r11.E
            long r12 = r6.f10331p
            m1.a1 r6 = r11.f10517z
            m1.y0 r6 = r6.f10183j
            r7 = 0
            if (r6 != 0) goto L_0x04fd
            r25 = r2
            r26 = r4
            r1 = r7
            goto L_0x050b
        L_0x04fd:
            r25 = r2
            long r1 = r11.S
            r26 = r4
            long r3 = r6.f10543o
            long r1 = r1 - r3
            long r12 = r12 - r1
            long r1 = java.lang.Math.max(r7, r12)
        L_0x050b:
            m1.n r3 = r11.f10513v
            g1.e1 r3 = r3.i()
            float r3 = r3.f6355h
            boolean r4 = r11.J
            m1.l r6 = r11.f10504m
            r6.getClass()
            long r1 = j1.l0.v(r1, r3)
            if (r4 == 0) goto L_0x0523
            long r3 = r6.f10338e
            goto L_0x0525
        L_0x0523:
            long r3 = r6.f10337d
        L_0x0525:
            int r12 = (r9 > r14 ? 1 : (r9 == r14 ? 0 : -1))
            if (r12 == 0) goto L_0x0530
            r12 = 2
            long r9 = r9 / r12
            long r3 = java.lang.Math.min(r9, r3)
        L_0x0530:
            int r9 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r9 <= 0) goto L_0x0550
            int r7 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r7 >= 0) goto L_0x0550
            boolean r1 = r6.f10340g
            if (r1 != 0) goto L_0x054e
            a2.e r1 = r6.f10334a
            monitor-enter(r1)
            int r2 = r1.f25d     // Catch:{ all -> 0x054b }
            int r3 = r1.f23b     // Catch:{ all -> 0x054b }
            int r2 = r2 * r3
            monitor-exit(r1)
            int r1 = r6.f10343j
            if (r2 < r1) goto L_0x054e
            goto L_0x0550
        L_0x054b:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        L_0x054e:
            r8 = 0
            goto L_0x0551
        L_0x0550:
            r8 = 1
        L_0x0551:
            if (r8 == 0) goto L_0x0554
            goto L_0x0556
        L_0x0554:
            r8 = 0
            goto L_0x0557
        L_0x0556:
            r8 = 1
        L_0x0557:
            r1 = 3
            if (r8 == 0) goto L_0x056f
            r11.X(r1)
            r2 = 0
            r11.V = r2
            boolean r2 = r52.Y()
            if (r2 == 0) goto L_0x05ca
            r52.a0()
            goto L_0x05ca
        L_0x056a:
            r25 = r2
            r26 = r4
            r1 = 3
        L_0x056f:
            m1.k1 r2 = r11.E
            int r2 = r2.f10320e
            if (r2 != r1) goto L_0x05ca
            int r1 = r11.Q
            if (r1 != 0) goto L_0x0580
            boolean r1 = r52.s()
            if (r1 == 0) goto L_0x0582
            goto L_0x05ca
        L_0x0580:
            if (r25 != 0) goto L_0x05ca
        L_0x0582:
            boolean r1 = r52.Y()
            r11.J = r1
            r1 = 2
            r11.X(r1)
            boolean r1 = r11.J
            if (r1 == 0) goto L_0x05c7
            m1.a1 r1 = r11.f10517z
            m1.y0 r1 = r1.f10181h
        L_0x0594:
            if (r1 == 0) goto L_0x05ab
            z1.y r2 = r1.f10542n
            z1.s[] r2 = r2.f17489c
            int r3 = r2.length
            r8 = 0
        L_0x059c:
            if (r8 >= r3) goto L_0x05a8
            r4 = r2[r8]
            if (r4 == 0) goto L_0x05a5
            r4.s()
        L_0x05a5:
            int r8 = r8 + 1
            goto L_0x059c
        L_0x05a8:
            m1.y0 r1 = r1.f10540l
            goto L_0x0594
        L_0x05ab:
            m1.j r1 = r11.B
            long r2 = r1.f10287m
            int r4 = (r2 > r14 ? 1 : (r2 == r14 ? 0 : -1))
            if (r4 != 0) goto L_0x05b4
            goto L_0x05c7
        L_0x05b4:
            long r6 = r1.f10280f
            long r2 = r2 + r6
            r1.f10287m = r2
            long r6 = r1.f10286l
            int r4 = (r6 > r14 ? 1 : (r6 == r14 ? 0 : -1))
            if (r4 == 0) goto L_0x05c5
            int r4 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r4 <= 0) goto L_0x05c5
            r1.f10287m = r6
        L_0x05c5:
            r1.f10291q = r14
        L_0x05c7:
            r52.c0()
        L_0x05ca:
            m1.k1 r1 = r11.E
            int r1 = r1.f10320e
            r2 = 2
            if (r1 != r2) goto L_0x060b
            r8 = 0
        L_0x05d2:
            m1.f[] r1 = r11.f10499h
            int r2 = r1.length
            if (r8 >= r2) goto L_0x05f4
            r1 = r1[r8]
            boolean r1 = q(r1)
            if (r1 == 0) goto L_0x05f1
            m1.f[] r1 = r11.f10499h
            r1 = r1[r8]
            v1.b1 r1 = r1.f10222n
            v1.b1[] r2 = r0.f10531c
            r2 = r2[r8]
            if (r1 != r2) goto L_0x05f1
            r1.getClass()
            r1.c()
        L_0x05f1:
            int r8 = r8 + 1
            goto L_0x05d2
        L_0x05f4:
            m1.k1 r0 = r11.E
            boolean r1 = r0.f10322g
            if (r1 != 0) goto L_0x060b
            long r0 = r0.f10332q
            r2 = 500000(0x7a120, double:2.47033E-318)
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 >= 0) goto L_0x060b
            boolean r0 = r52.p()
            if (r0 == 0) goto L_0x060b
            r8 = 1
            goto L_0x060c
        L_0x060b:
            r8 = 0
        L_0x060c:
            if (r8 != 0) goto L_0x0610
            r9 = r14
            goto L_0x0621
        L_0x0610:
            long r0 = r11.W
            int r2 = (r0 > r14 ? 1 : (r0 == r14 ? 0 : -1))
            j1.d r0 = r11.f10515x
            j1.d0 r0 = (j1.d0) r0
            r0.getClass()
            if (r2 != 0) goto L_0x0624
            long r9 = android.os.SystemClock.elapsedRealtime()
        L_0x0621:
            r11.W = r9
            goto L_0x0631
        L_0x0624:
            long r0 = android.os.SystemClock.elapsedRealtime()
            long r2 = r11.W
            long r0 = r0 - r2
            r2 = 4000(0xfa0, double:1.9763E-320)
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 >= 0) goto L_0x06cd
        L_0x0631:
            boolean r0 = r52.Y()
            if (r0 == 0) goto L_0x0640
            m1.k1 r0 = r11.E
            int r0 = r0.f10320e
            r1 = 3
            if (r0 != r1) goto L_0x0640
            r8 = 1
            goto L_0x0641
        L_0x0640:
            r8 = 0
        L_0x0641:
            boolean r0 = r11.P
            if (r0 == 0) goto L_0x064d
            boolean r0 = r11.O
            if (r0 == 0) goto L_0x064d
            if (r8 == 0) goto L_0x064d
            r0 = 1
            goto L_0x064e
        L_0x064d:
            r0 = 0
        L_0x064e:
            m1.k1 r1 = r11.E
            boolean r2 = r1.f10330o
            if (r2 == r0) goto L_0x06a3
            m1.k1 r2 = new m1.k1
            r28 = r2
            g1.u1 r3 = r1.f10316a
            r29 = r3
            v1.a0 r3 = r1.f10317b
            r30 = r3
            long r3 = r1.f10318c
            r31 = r3
            long r3 = r1.f10319d
            r33 = r3
            int r3 = r1.f10320e
            r35 = r3
            m1.p r3 = r1.f10321f
            r36 = r3
            boolean r3 = r1.f10322g
            r37 = r3
            v1.l1 r3 = r1.f10323h
            r38 = r3
            z1.y r3 = r1.f10324i
            r39 = r3
            java.util.List r3 = r1.f10325j
            r40 = r3
            v1.a0 r3 = r1.f10326k
            r41 = r3
            boolean r3 = r1.f10327l
            r42 = r3
            int r3 = r1.f10328m
            r43 = r3
            g1.e1 r3 = r1.f10329n
            r44 = r3
            long r3 = r1.f10331p
            r45 = r3
            long r3 = r1.f10332q
            r47 = r3
            long r3 = r1.f10333r
            r49 = r3
            r51 = r0
            r28.<init>(r29, r30, r31, r33, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r47, r49, r51)
            r11.E = r2
        L_0x06a3:
            r1 = 0
            r11.O = r1
            if (r0 != 0) goto L_0x06c9
            m1.k1 r0 = r11.E
            int r0 = r0.f10320e
            r1 = 4
            if (r0 != r1) goto L_0x06b0
            goto L_0x06c9
        L_0x06b0:
            if (r8 != 0) goto L_0x06c2
            r1 = 2
            if (r0 != r1) goto L_0x06b6
            goto L_0x06c2
        L_0x06b6:
            r1 = 3
            if (r0 != r1) goto L_0x06c9
            int r0 = r11.Q
            if (r0 == 0) goto L_0x06c9
            r0 = r26
            r2 = 1000(0x3e8, double:4.94E-321)
            goto L_0x06c6
        L_0x06c2:
            r0 = r26
            r2 = 10
        L_0x06c6:
            r11.I(r0, r2)
        L_0x06c9:
            j1.i0.b()
            return
        L_0x06cd:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Playback stuck buffering and not loading"
            r0.<init>(r1)
            throw r0
        L_0x06d5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: m1.u0.d():void");
    }

    public final void d0() {
        boolean z10;
        y0 y0Var = this.f10517z.f10183j;
        if (this.K || (y0Var != null && y0Var.f10529a.c())) {
            z10 = true;
        } else {
            z10 = false;
        }
        k1 k1Var = this.E;
        if (z10 != k1Var.f10322g) {
            k1 k1Var2 = r2;
            k1 k1Var3 = new k1(k1Var.f10316a, k1Var.f10317b, k1Var.f10318c, k1Var.f10319d, k1Var.f10320e, k1Var.f10321f, z10, k1Var.f10323h, k1Var.f10324i, k1Var.f10325j, k1Var.f10326k, k1Var.f10327l, k1Var.f10328m, k1Var.f10329n, k1Var.f10331p, k1Var.f10332q, k1Var.f10333r, k1Var.f10330o);
            this.E = k1Var2;
        }
    }

    public final void e(boolean[] zArr) {
        f[] fVarArr;
        Set set;
        int i10;
        f[] fVarArr2;
        y0 y0Var;
        a1 a1Var;
        boolean z10;
        int i11;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        x0 x0Var;
        a1 a1Var2 = this.f10517z;
        y0 y0Var2 = a1Var2.f10182i;
        y yVar = y0Var2.f10542n;
        int i12 = 0;
        while (true) {
            fVarArr = this.f10499h;
            int length = fVarArr.length;
            set = this.f10500i;
            if (i12 >= length) {
                break;
            }
            if (!yVar.b(i12) && set.remove(fVarArr[i12])) {
                fVarArr[i12].v();
            }
            i12++;
        }
        int i13 = 0;
        while (i13 < fVarArr.length) {
            if (yVar.b(i13)) {
                boolean z15 = zArr[i13];
                f fVar = fVarArr[i13];
                if (!q(fVar)) {
                    y0 y0Var3 = a1Var2.f10182i;
                    if (y0Var3 == a1Var2.f10181h) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    y yVar2 = y0Var3.f10542n;
                    o1 o1Var = yVar2.f17488b[i13];
                    s sVar = yVar2.f17489c[i13];
                    if (sVar != null) {
                        i11 = sVar.length();
                    } else {
                        i11 = 0;
                    }
                    g1.a0[] a0VarArr = new g1.a0[i11];
                    for (int i14 = 0; i14 < i11; i14++) {
                        a0VarArr[i14] = sVar.e(i14);
                    }
                    if (!Y() || this.E.f10320e != 3) {
                        z11 = false;
                    } else {
                        z11 = true;
                    }
                    if (z15 || !z11) {
                        z12 = false;
                    } else {
                        z12 = true;
                    }
                    this.Q++;
                    set.add(fVar);
                    b1 b1Var = y0Var3.f10531c[i13];
                    a1Var = a1Var2;
                    y0Var = y0Var2;
                    long j10 = this.S;
                    long e10 = y0Var3.e();
                    i10 = i13;
                    fVarArr2 = fVarArr;
                    long j11 = y0Var3.f10543o;
                    if (fVar.f10221m == 0) {
                        z13 = true;
                    } else {
                        z13 = false;
                    }
                    j1.a.e(z13);
                    fVar.f10218j = o1Var;
                    fVar.f10221m = 1;
                    fVar.m(z12, z10);
                    f fVar2 = fVar;
                    fVar.u(a0VarArr, b1Var, e10, j11);
                    fVar2.f10226r = false;
                    fVar2.f10225q = j10;
                    fVar2.n(j10, z12);
                    fVar2.b(11, new o0(this));
                    n nVar = this.f10513v;
                    nVar.getClass();
                    x0 f10 = fVar2.f();
                    if (!(f10 == null || f10 == (x0Var = nVar.f10363k))) {
                        if (x0Var == null) {
                            nVar.f10363k = f10;
                            nVar.f10362j = fVar2;
                            f10.d(nVar.f10360h.f10448l);
                        } else {
                            throw new p(2, new IllegalStateException("Multiple renderer media clocks enabled."), 1000);
                        }
                    }
                    if (z11) {
                        if (fVar2.f10221m == 1) {
                            z14 = true;
                        } else {
                            z14 = false;
                        }
                        j1.a.e(z14);
                        fVar2.f10221m = 2;
                        fVar2.p();
                    }
                    i13 = i10 + 1;
                    a1Var2 = a1Var;
                    y0Var2 = y0Var;
                    fVarArr = fVarArr2;
                }
            }
            a1Var = a1Var2;
            y0Var = y0Var2;
            i10 = i13;
            fVarArr2 = fVarArr;
            i13 = i10 + 1;
            a1Var2 = a1Var;
            y0Var2 = y0Var;
            fVarArr = fVarArr2;
        }
        y0Var2.f10535g = true;
    }

    public final void e0(y yVar) {
        s[] sVarArr = yVar.f17489c;
        l lVar = this.f10504m;
        int i10 = lVar.f10339f;
        if (i10 == -1) {
            int i11 = 0;
            int i12 = 0;
            while (true) {
                f[] fVarArr = this.f10499h;
                int i13 = 13107200;
                if (i11 < fVarArr.length) {
                    if (sVarArr[i11] != null) {
                        switch (fVarArr[i11].f10216h) {
                            case -2:
                                i13 = 0;
                                break;
                            case 0:
                                i13 = 144310272;
                                break;
                            case 1:
                                break;
                            case 2:
                                i13 = 131072000;
                                break;
                            case 3:
                            case 4:
                            case Constants.MAX_COMPATIBILITY_VERSION:
                            case 6:
                                i13 = 131072;
                                break;
                            default:
                                throw new IllegalArgumentException();
                        }
                        i12 += i13;
                    }
                    i11++;
                } else {
                    i10 = Math.max(13107200, i12);
                }
            }
        }
        lVar.f10343j = i10;
        lVar.f10334a.a(i10);
    }

    public final long f(u1 u1Var, Object obj, long j10) {
        long j11;
        r1 r1Var = this.f10510s;
        int i10 = u1Var.p(obj, r1Var).f6544j;
        t1 t1Var = this.f10509r;
        u1Var.v(i10, t1Var);
        if (t1Var.f6580m == -9223372036854775807L || !t1Var.k() || !t1Var.f6583p) {
            return -9223372036854775807L;
        }
        long j12 = t1Var.f6581n;
        if (j12 == -9223372036854775807L) {
            j11 = System.currentTimeMillis();
        } else {
            j11 = j12 + SystemClock.elapsedRealtime();
        }
        return l0.H(j11 - t1Var.f6580m) - (j10 + r1Var.f6546l);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:99:0x024c, code lost:
        if (r2 > r4) goto L_0x024e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x025f  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0262  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void f0() {
        /*
            r22 = this;
            r10 = r22
            m1.a1 r0 = r10.f10517z
            m1.y0 r0 = r0.f10181h
            if (r0 != 0) goto L_0x0009
            return
        L_0x0009:
            boolean r1 = r0.f10532d
            r11 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r1 == 0) goto L_0x001a
            v1.y r1 = r0.f10529a
            long r1 = r1.k()
            r6 = r1
            goto L_0x001b
        L_0x001a:
            r6 = r11
        L_0x001b:
            r13 = 16
            r14 = 0
            r15 = 1
            int r1 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1))
            if (r1 == 0) goto L_0x0041
            r10.E(r6)
            m1.k1 r0 = r10.E
            long r0 = r0.f10333r
            int r2 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r2 == 0) goto L_0x0126
            m1.k1 r0 = r10.E
            v1.a0 r1 = r0.f10317b
            long r4 = r0.f10318c
            r8 = 1
            r9 = 5
            r0 = r22
            r2 = r6
            m1.k1 r0 = r0.o(r1, r2, r4, r6, r8, r9)
            r10.E = r0
            goto L_0x0126
        L_0x0041:
            m1.n r1 = r10.f10513v
            m1.a1 r2 = r10.f10517z
            m1.y0 r2 = r2.f10182i
            if (r0 == r2) goto L_0x004b
            r2 = 1
            goto L_0x004c
        L_0x004b:
            r2 = 0
        L_0x004c:
            m1.f r3 = r1.f10362j
            if (r3 == 0) goto L_0x006b
            boolean r3 = r3.j()
            if (r3 != 0) goto L_0x006b
            m1.f r3 = r1.f10362j
            boolean r3 = r3.k()
            if (r3 != 0) goto L_0x0069
            if (r2 != 0) goto L_0x006b
            m1.f r2 = r1.f10362j
            boolean r2 = r2.h()
            if (r2 == 0) goto L_0x0069
            goto L_0x006b
        L_0x0069:
            r2 = 0
            goto L_0x006c
        L_0x006b:
            r2 = 1
        L_0x006c:
            m1.q1 r3 = r1.f10360h
            if (r2 == 0) goto L_0x007a
            r1.f10364l = r15
            boolean r2 = r1.f10365m
            if (r2 == 0) goto L_0x00c5
            r3.c()
            goto L_0x00c5
        L_0x007a:
            m1.x0 r2 = r1.f10363k
            r2.getClass()
            long r4 = r2.a()
            boolean r6 = r1.f10364l
            if (r6 == 0) goto L_0x00a6
            long r6 = r3.a()
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 >= 0) goto L_0x009d
            boolean r2 = r3.f10445i
            if (r2 == 0) goto L_0x00c5
            long r4 = r3.a()
            r3.b(r4)
            r3.f10445i = r14
            goto L_0x00c5
        L_0x009d:
            r1.f10364l = r14
            boolean r6 = r1.f10365m
            if (r6 == 0) goto L_0x00a6
            r3.c()
        L_0x00a6:
            r3.b(r4)
            g1.e1 r2 = r2.i()
            g1.e1 r4 = r3.f10448l
            boolean r4 = r2.equals(r4)
            if (r4 != 0) goto L_0x00c5
            r3.d(r2)
            m1.m r3 = r1.f10361i
            m1.u0 r3 = (m1.u0) r3
            j1.f0 r3 = r3.f10506o
            j1.e0 r2 = r3.a(r13, r2)
            r2.a()
        L_0x00c5:
            long r1 = r1.a()
            r10.S = r1
            long r3 = r0.f10543o
            long r1 = r1 - r3
            m1.k1 r0 = r10.E
            long r3 = r0.f10333r
            java.util.ArrayList r0 = r10.f10514w
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x0122
            m1.k1 r0 = r10.E
            v1.a0 r0 = r0.f10317b
            boolean r0 = r0.a()
            if (r0 == 0) goto L_0x00e5
            goto L_0x0122
        L_0x00e5:
            boolean r0 = r10.U
            if (r0 == 0) goto L_0x00eb
            r10.U = r14
        L_0x00eb:
            m1.k1 r0 = r10.E
            g1.u1 r3 = r0.f10316a
            v1.a0 r0 = r0.f10317b
            java.lang.Object r0 = r0.f6678a
            r3.k(r0)
            int r0 = r10.T
            java.util.ArrayList r3 = r10.f10514w
            int r3 = r3.size()
            int r0 = java.lang.Math.min(r0, r3)
            if (r0 <= 0) goto L_0x010f
            java.util.ArrayList r3 = r10.f10514w
            int r4 = r0 + -1
            java.lang.Object r3 = r3.get(r4)
            android.support.v4.media.h.y(r3)
        L_0x010f:
            java.util.ArrayList r3 = r10.f10514w
            int r3 = r3.size()
            if (r0 >= r3) goto L_0x0120
            java.util.ArrayList r3 = r10.f10514w
            java.lang.Object r3 = r3.get(r0)
            android.support.v4.media.h.y(r3)
        L_0x0120:
            r10.T = r0
        L_0x0122:
            m1.k1 r0 = r10.E
            r0.f10333r = r1
        L_0x0126:
            m1.a1 r0 = r10.f10517z
            m1.y0 r0 = r0.f10183j
            m1.k1 r1 = r10.E
            long r2 = r0.d()
            r1.f10331p = r2
            m1.k1 r0 = r10.E
            long r1 = r0.f10331p
            m1.a1 r3 = r10.f10517z
            m1.y0 r3 = r3.f10183j
            r4 = 0
            if (r3 != 0) goto L_0x0140
            r1 = r4
            goto L_0x014a
        L_0x0140:
            long r6 = r10.S
            long r8 = r3.f10543o
            long r6 = r6 - r8
            long r1 = r1 - r6
            long r1 = java.lang.Math.max(r4, r1)
        L_0x014a:
            r0.f10332q = r1
            m1.k1 r0 = r10.E
            boolean r1 = r0.f10327l
            if (r1 == 0) goto L_0x02a7
            int r1 = r0.f10320e
            r2 = 3
            if (r1 != r2) goto L_0x02a7
            g1.u1 r1 = r0.f10316a
            v1.a0 r0 = r0.f10317b
            boolean r0 = r10.Z(r1, r0)
            if (r0 == 0) goto L_0x02a7
            m1.k1 r0 = r10.E
            g1.e1 r1 = r0.f10329n
            float r1 = r1.f6355h
            r3 = 1065353216(0x3f800000, float:1.0)
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 != 0) goto L_0x02a7
            m1.j r1 = r10.B
            g1.u1 r6 = r0.f10316a
            v1.a0 r7 = r0.f10317b
            java.lang.Object r7 = r7.f6678a
            long r8 = r0.f10333r
            long r6 = r10.f(r6, r7, r8)
            m1.k1 r0 = r10.E
            long r8 = r0.f10331p
            m1.a1 r0 = r10.f10517z
            m1.y0 r0 = r0.f10183j
            if (r0 != 0) goto L_0x0187
            r2 = r4
            goto L_0x0191
        L_0x0187:
            long r13 = r10.S
            long r2 = r0.f10543o
            long r13 = r13 - r2
            long r8 = r8 - r13
            long r2 = java.lang.Math.max(r4, r8)
        L_0x0191:
            long r8 = r1.f10282h
            int r0 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
            if (r0 != 0) goto L_0x019b
            r3 = 1065353216(0x3f800000, float:1.0)
            goto L_0x0272
        L_0x019b:
            long r2 = r6 - r2
            long r8 = r1.f10292r
            int r0 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
            if (r0 != 0) goto L_0x01a6
            r1.f10292r = r2
            goto L_0x01c9
        L_0x01a6:
            float r0 = r1.f10281g
            float r4 = (float) r8
            float r4 = r4 * r0
            r5 = 1065353216(0x3f800000, float:1.0)
            float r8 = r5 - r0
            float r5 = (float) r2
            float r5 = r5 * r8
            float r5 = r5 + r4
            long r4 = (long) r5
            long r4 = java.lang.Math.max(r2, r4)
            r1.f10292r = r4
            long r2 = r2 - r4
            long r2 = java.lang.Math.abs(r2)
            long r4 = r1.f10293s
            float r4 = (float) r4
            float r4 = r4 * r0
            float r0 = (float) r2
            float r8 = r8 * r0
            float r8 = r8 + r4
            long r4 = (long) r8
        L_0x01c9:
            r1.f10293s = r4
            long r2 = r1.f10291q
            long r4 = r1.f10277c
            int r0 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
            if (r0 == 0) goto L_0x01e0
            long r2 = android.os.SystemClock.elapsedRealtime()
            long r8 = r1.f10291q
            long r2 = r2 - r8
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 >= 0) goto L_0x01e0
            goto L_0x0270
        L_0x01e0:
            long r2 = android.os.SystemClock.elapsedRealtime()
            r1.f10291q = r2
            long r2 = r1.f10292r
            r8 = 3
            long r13 = r1.f10293s
            long r13 = r13 * r8
            long r20 = r13 + r2
            long r2 = r1.f10287m
            float r0 = r1.f10278d
            int r8 = (r2 > r20 ? 1 : (r2 == r20 ? 0 : -1))
            if (r8 <= 0) goto L_0x022c
            long r2 = j1.l0.H(r4)
            float r4 = r1.f10290p
            r5 = 1065353216(0x3f800000, float:1.0)
            float r4 = r4 - r5
            float r2 = (float) r2
            float r4 = r4 * r2
            long r3 = (long) r4
            float r8 = r1.f10288n
            float r8 = r8 - r5
            float r8 = r8 * r2
            long r8 = (long) r8
            long r3 = r3 + r8
            r2 = 3
            long[] r5 = new long[r2]
            r8 = 0
            r5[r8] = r20
            long r8 = r1.f10284j
            r5[r15] = r8
            long r8 = r1.f10287m
            long r8 = r8 - r3
            r3 = 2
            r5[r3] = r8
        L_0x021c:
            if (r15 >= r2) goto L_0x0229
            r3 = r5[r15]
            int r8 = (r3 > r20 ? 1 : (r3 == r20 ? 0 : -1))
            if (r8 <= 0) goto L_0x0226
            r20 = r3
        L_0x0226:
            int r15 = r15 + 1
            goto L_0x021c
        L_0x0229:
            r4 = r20
            goto L_0x024e
        L_0x022c:
            float r2 = r1.f10290p
            r3 = 1065353216(0x3f800000, float:1.0)
            float r2 = r2 - r3
            r3 = 0
            float r2 = java.lang.Math.max(r3, r2)
            float r2 = r2 / r0
            long r2 = (long) r2
            long r16 = r6 - r2
            long r2 = r1.f10287m
            r18 = r2
            long r2 = j1.l0.i(r16, r18, r20)
            r1.f10287m = r2
            long r4 = r1.f10286l
            int r8 = (r4 > r11 ? 1 : (r4 == r11 ? 0 : -1))
            if (r8 == 0) goto L_0x0250
            int r8 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r8 <= 0) goto L_0x0250
        L_0x024e:
            r1.f10287m = r4
        L_0x0250:
            long r2 = r1.f10287m
            long r6 = r6 - r2
            long r2 = java.lang.Math.abs(r6)
            long r4 = r1.f10279e
            int r8 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            r2 = 1065353216(0x3f800000, float:1.0)
            if (r8 >= 0) goto L_0x0262
            r1.f10290p = r2
            goto L_0x0270
        L_0x0262:
            float r3 = (float) r6
            float r0 = r0 * r3
            float r0 = r0 + r2
            float r2 = r1.f10289o
            float r3 = r1.f10288n
            float r0 = j1.l0.g(r0, r2, r3)
            r1.f10290p = r0
        L_0x0270:
            float r3 = r1.f10290p
        L_0x0272:
            m1.n r0 = r10.f10513v
            g1.e1 r0 = r0.i()
            float r0 = r0.f6355h
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 == 0) goto L_0x02a7
            m1.k1 r0 = r10.E
            g1.e1 r0 = r0.f10329n
            g1.e1 r1 = new g1.e1
            float r0 = r0.f6356i
            r1.<init>(r3, r0)
            j1.f0 r0 = r10.f10506o
            android.os.Handler r0 = r0.f8429a
            r2 = 16
            r0.removeMessages(r2)
            m1.n r0 = r10.f10513v
            r0.d(r1)
            m1.k1 r0 = r10.E
            g1.e1 r0 = r0.f10329n
            m1.n r1 = r10.f10513v
            g1.e1 r1 = r1.i()
            float r1 = r1.f6355h
            r2 = 0
            r10.n(r0, r1, r2, r2)
        L_0x02a7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: m1.u0.f0():void");
    }

    public final Pair g(u1 u1Var) {
        long j10 = 0;
        if (u1Var.y()) {
            return Pair.create(k1.f10315s, 0L);
        }
        u1 u1Var2 = u1Var;
        Pair r10 = u1Var2.r(this.f10509r, this.f10510s, u1Var.j(this.M), -9223372036854775807L);
        a0 m10 = this.f10517z.m(u1Var, r10.first, 0);
        long longValue = ((Long) r10.second).longValue();
        if (m10.a()) {
            Object obj = m10.f6678a;
            r1 r1Var = this.f10510s;
            u1Var.p(obj, r1Var);
            if (m10.f6680c == r1Var.n(m10.f6679b)) {
                j10 = r1Var.f6548n.f6330j;
            }
            longValue = j10;
        }
        return Pair.create(m10, Long.valueOf(longValue));
    }

    public final void g0(u1 u1Var, a0 a0Var, u1 u1Var2, a0 a0Var2, long j10, boolean z10) {
        Object obj;
        g1.e1 e1Var;
        if (!Z(u1Var, a0Var)) {
            if (a0Var.a()) {
                e1Var = g1.e1.f6351k;
            } else {
                e1Var = this.E.f10329n;
            }
            n nVar = this.f10513v;
            if (!nVar.i().equals(e1Var)) {
                this.f10506o.f8429a.removeMessages(16);
                nVar.d(e1Var);
                n(this.E.f10329n, e1Var.f6355h, false, false);
                return;
            }
            return;
        }
        Object obj2 = a0Var.f6678a;
        r1 r1Var = this.f10510s;
        int i10 = u1Var.p(obj2, r1Var).f6544j;
        t1 t1Var = this.f10509r;
        u1Var.v(i10, t1Var);
        m0 m0Var = t1Var.f6585r;
        j jVar = this.B;
        jVar.getClass();
        jVar.f10282h = l0.H(m0Var.f6463h);
        jVar.f10285k = l0.H(m0Var.f6464i);
        jVar.f10286l = l0.H(m0Var.f6465j);
        float f10 = m0Var.f6466k;
        if (f10 == -3.4028235E38f) {
            f10 = jVar.f10275a;
        }
        jVar.f10289o = f10;
        float f11 = m0Var.f6467l;
        if (f11 == -3.4028235E38f) {
            f11 = jVar.f10276b;
        }
        jVar.f10288n = f11;
        if (f10 == 1.0f && f11 == 1.0f) {
            jVar.f10282h = -9223372036854775807L;
        }
        jVar.a();
        if (j10 != -9223372036854775807L) {
            jVar.f10283i = f(u1Var, obj2, j10);
        } else {
            Object obj3 = t1Var.f6575h;
            if (!u1Var2.y()) {
                obj = u1Var2.v(u1Var2.p(a0Var2.f6678a, r1Var).f6544j, t1Var).f6575h;
            } else {
                obj = null;
            }
            if (!l0.a(obj, obj3) || z10) {
                jVar.f10283i = -9223372036854775807L;
            } else {
                return;
            }
        }
        jVar.a();
    }

    public final void h(v1.y yVar) {
        this.f10506o.a(8, yVar).a();
    }

    public final synchronized void h0(q qVar, long j10) {
        ((d0) this.f10515x).getClass();
        long elapsedRealtime = SystemClock.elapsedRealtime() + j10;
        boolean z10 = false;
        while (!((Boolean) qVar.get()).booleanValue() && j10 > 0) {
            try {
                this.f10515x.getClass();
                wait(j10);
            } catch (InterruptedException unused) {
                z10 = true;
            }
            ((d0) this.f10515x).getClass();
            j10 = elapsedRealtime - SystemClock.elapsedRealtime();
        }
        if (z10) {
            Thread.currentThread().interrupt();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v14, resolved type: p1.m} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v17, resolved type: k1.i} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v65, resolved type: p1.m} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v66, resolved type: p1.m} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v67, resolved type: v1.b} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean handleMessage(android.os.Message r10) {
        /*
            r9 = this;
            java.lang.String r0 = "Playback error"
            java.lang.String r1 = "ExoPlayerImplInternal"
            r2 = 2
            r3 = 1000(0x3e8, float:1.401E-42)
            r4 = 0
            r5 = 1
            int r6 = r10.what     // Catch:{ p -> 0x015a, m -> 0x0153, b1 -> 0x0136, i -> 0x0132, b -> 0x012e, IOException -> 0x012a, RuntimeException -> 0x0118 }
            switch(r6) {
                case 0: goto L_0x0113;
                case 1: goto L_0x0105;
                case 2: goto L_0x0100;
                case 3: goto L_0x00f7;
                case 4: goto L_0x00ee;
                case 5: goto L_0x00e6;
                case 6: goto L_0x00e1;
                case 7: goto L_0x00dd;
                case 8: goto L_0x00d4;
                case 9: goto L_0x00cb;
                case 10: goto L_0x00c6;
                case 11: goto L_0x00bf;
                case 12: goto L_0x00b3;
                case 13: goto L_0x00a3;
                case 14: goto L_0x0078;
                case 15: goto L_0x006f;
                case 16: goto L_0x0064;
                case 17: goto L_0x005b;
                case 18: goto L_0x0050;
                case 19: goto L_0x0047;
                case 20: goto L_0x003a;
                case 21: goto L_0x0031;
                case 22: goto L_0x002c;
                case 23: goto L_0x0020;
                case 24: goto L_0x0014;
                case 25: goto L_0x000f;
                default: goto L_0x000e;
            }     // Catch:{ p -> 0x015a, m -> 0x0153, b1 -> 0x0136, i -> 0x0132, b -> 0x012e, IOException -> 0x012a, RuntimeException -> 0x0118 }
        L_0x000e:
            return r4
        L_0x000f:
            r9.J(r5)     // Catch:{ p -> 0x015a, m -> 0x0153, b1 -> 0x0136, i -> 0x0132, b -> 0x012e, IOException -> 0x012a, RuntimeException -> 0x0118 }
            goto L_0x01bf
        L_0x0014:
            int r10 = r10.arg1     // Catch:{ p -> 0x015a, m -> 0x0153, b1 -> 0x0136, i -> 0x0132, b -> 0x012e, IOException -> 0x012a, RuntimeException -> 0x0118 }
            if (r10 != r5) goto L_0x001a
            r10 = 1
            goto L_0x001b
        L_0x001a:
            r10 = 0
        L_0x001b:
            r9.Q(r10)     // Catch:{ p -> 0x015a, m -> 0x0153, b1 -> 0x0136, i -> 0x0132, b -> 0x012e, IOException -> 0x012a, RuntimeException -> 0x0118 }
            goto L_0x01bf
        L_0x0020:
            int r10 = r10.arg1     // Catch:{ p -> 0x015a, m -> 0x0153, b1 -> 0x0136, i -> 0x0132, b -> 0x012e, IOException -> 0x012a, RuntimeException -> 0x0118 }
            if (r10 == 0) goto L_0x0026
            r10 = 1
            goto L_0x0027
        L_0x0026:
            r10 = 0
        L_0x0027:
            r9.R(r10)     // Catch:{ p -> 0x015a, m -> 0x0153, b1 -> 0x0136, i -> 0x0132, b -> 0x012e, IOException -> 0x012a, RuntimeException -> 0x0118 }
            goto L_0x01bf
        L_0x002c:
            r9.v()     // Catch:{ p -> 0x015a, m -> 0x0153, b1 -> 0x0136, i -> 0x0132, b -> 0x012e, IOException -> 0x012a, RuntimeException -> 0x0118 }
            goto L_0x01bf
        L_0x0031:
            java.lang.Object r10 = r10.obj     // Catch:{ p -> 0x015a, m -> 0x0153, b1 -> 0x0136, i -> 0x0132, b -> 0x012e, IOException -> 0x012a, RuntimeException -> 0x0118 }
            v1.e1 r10 = (v1.e1) r10     // Catch:{ p -> 0x015a, m -> 0x0153, b1 -> 0x0136, i -> 0x0132, b -> 0x012e, IOException -> 0x012a, RuntimeException -> 0x0118 }
            r9.W(r10)     // Catch:{ p -> 0x015a, m -> 0x0153, b1 -> 0x0136, i -> 0x0132, b -> 0x012e, IOException -> 0x012a, RuntimeException -> 0x0118 }
            goto L_0x01bf
        L_0x003a:
            int r6 = r10.arg1     // Catch:{ p -> 0x015a, m -> 0x0153, b1 -> 0x0136, i -> 0x0132, b -> 0x012e, IOException -> 0x012a, RuntimeException -> 0x0118 }
            int r7 = r10.arg2     // Catch:{ p -> 0x015a, m -> 0x0153, b1 -> 0x0136, i -> 0x0132, b -> 0x012e, IOException -> 0x012a, RuntimeException -> 0x0118 }
            java.lang.Object r10 = r10.obj     // Catch:{ p -> 0x015a, m -> 0x0153, b1 -> 0x0136, i -> 0x0132, b -> 0x012e, IOException -> 0x012a, RuntimeException -> 0x0118 }
            v1.e1 r10 = (v1.e1) r10     // Catch:{ p -> 0x015a, m -> 0x0153, b1 -> 0x0136, i -> 0x0132, b -> 0x012e, IOException -> 0x012a, RuntimeException -> 0x0118 }
            r9.A(r6, r7, r10)     // Catch:{ p -> 0x015a, m -> 0x0153, b1 -> 0x0136, i -> 0x0132, b -> 0x012e, IOException -> 0x012a, RuntimeException -> 0x0118 }
            goto L_0x01bf
        L_0x0047:
            java.lang.Object r10 = r10.obj     // Catch:{ p -> 0x015a, m -> 0x0153, b1 -> 0x0136, i -> 0x0132, b -> 0x012e, IOException -> 0x012a, RuntimeException -> 0x0118 }
            m1.q0 r10 = (m1.q0) r10     // Catch:{ p -> 0x015a, m -> 0x0153, b1 -> 0x0136, i -> 0x0132, b -> 0x012e, IOException -> 0x012a, RuntimeException -> 0x0118 }
            r9.w(r10)     // Catch:{ p -> 0x015a, m -> 0x0153, b1 -> 0x0136, i -> 0x0132, b -> 0x012e, IOException -> 0x012a, RuntimeException -> 0x0118 }
            goto L_0x01bf
        L_0x0050:
            java.lang.Object r6 = r10.obj     // Catch:{ p -> 0x015a, m -> 0x0153, b1 -> 0x0136, i -> 0x0132, b -> 0x012e, IOException -> 0x012a, RuntimeException -> 0x0118 }
            m1.p0 r6 = (m1.p0) r6     // Catch:{ p -> 0x015a, m -> 0x0153, b1 -> 0x0136, i -> 0x0132, b -> 0x012e, IOException -> 0x012a, RuntimeException -> 0x0118 }
            int r10 = r10.arg1     // Catch:{ p -> 0x015a, m -> 0x0153, b1 -> 0x0136, i -> 0x0132, b -> 0x012e, IOException -> 0x012a, RuntimeException -> 0x0118 }
            r9.a(r6, r10)     // Catch:{ p -> 0x015a, m -> 0x0153, b1 -> 0x0136, i -> 0x0132, b -> 0x012e, IOException -> 0x012a, RuntimeException -> 0x0118 }
            goto L_0x01bf
        L_0x005b:
            java.lang.Object r10 = r10.obj     // Catch:{ p -> 0x015a, m -> 0x0153, b1 -> 0x0136, i -> 0x0132, b -> 0x012e, IOException -> 0x012a, RuntimeException -> 0x0118 }
            m1.p0 r10 = (m1.p0) r10     // Catch:{ p -> 0x015a, m -> 0x0153, b1 -> 0x0136, i -> 0x0132, b -> 0x012e, IOException -> 0x012a, RuntimeException -> 0x0118 }
            r9.P(r10)     // Catch:{ p -> 0x015a, m -> 0x0153, b1 -> 0x0136, i -> 0x0132, b -> 0x012e, IOException -> 0x012a, RuntimeException -> 0x0118 }
            goto L_0x01bf
        L_0x0064:
            java.lang.Object r10 = r10.obj     // Catch:{ p -> 0x015a, m -> 0x0153, b1 -> 0x0136, i -> 0x0132, b -> 0x012e, IOException -> 0x012a, RuntimeException -> 0x0118 }
            g1.e1 r10 = (g1.e1) r10     // Catch:{ p -> 0x015a, m -> 0x0153, b1 -> 0x0136, i -> 0x0132, b -> 0x012e, IOException -> 0x012a, RuntimeException -> 0x0118 }
            float r6 = r10.f6355h     // Catch:{ p -> 0x015a, m -> 0x0153, b1 -> 0x0136, i -> 0x0132, b -> 0x012e, IOException -> 0x012a, RuntimeException -> 0x0118 }
            r9.n(r10, r6, r5, r4)     // Catch:{ p -> 0x015a, m -> 0x0153, b1 -> 0x0136, i -> 0x0132, b -> 0x012e, IOException -> 0x012a, RuntimeException -> 0x0118 }
            goto L_0x01bf
        L_0x006f:
            java.lang.Object r10 = r10.obj     // Catch:{ p -> 0x015a, m -> 0x0153, b1 -> 0x0136, i -> 0x0132, b -> 0x012e, IOException -> 0x012a, RuntimeException -> 0x0118 }
            m1.m1 r10 = (m1.m1) r10     // Catch:{ p -> 0x015a, m -> 0x0153, b1 -> 0x0136, i -> 0x0132, b -> 0x012e, IOException -> 0x012a, RuntimeException -> 0x0118 }
            r9.M(r10)     // Catch:{ p -> 0x015a, m -> 0x0153, b1 -> 0x0136, i -> 0x0132, b -> 0x012e, IOException -> 0x012a, RuntimeException -> 0x0118 }
            goto L_0x01bf
        L_0x0078:
            java.lang.Object r10 = r10.obj     // Catch:{ p -> 0x015a, m -> 0x0153, b1 -> 0x0136, i -> 0x0132, b -> 0x012e, IOException -> 0x012a, RuntimeException -> 0x0118 }
            m1.m1 r10 = (m1.m1) r10     // Catch:{ p -> 0x015a, m -> 0x0153, b1 -> 0x0136, i -> 0x0132, b -> 0x012e, IOException -> 0x012a, RuntimeException -> 0x0118 }
            r10.getClass()     // Catch:{ p -> 0x015a, m -> 0x0153, b1 -> 0x0136, i -> 0x0132, b -> 0x012e, IOException -> 0x012a, RuntimeException -> 0x0118 }
            android.os.Looper r6 = r10.f10356f     // Catch:{ p -> 0x015a, m -> 0x0153, b1 -> 0x0136, i -> 0x0132, b -> 0x012e, IOException -> 0x012a, RuntimeException -> 0x0118 }
            android.os.Looper r7 = r9.f10508q     // Catch:{ p -> 0x015a, m -> 0x0153, b1 -> 0x0136, i -> 0x0132, b -> 0x012e, IOException -> 0x012a, RuntimeException -> 0x0118 }
            j1.f0 r8 = r9.f10506o     // Catch:{ p -> 0x015a, m -> 0x0153, b1 -> 0x0136, i -> 0x0132, b -> 0x012e, IOException -> 0x012a, RuntimeException -> 0x0118 }
            if (r6 != r7) goto L_0x0098
            b(r10)     // Catch:{ p -> 0x015a, m -> 0x0153, b1 -> 0x0136, i -> 0x0132, b -> 0x012e, IOException -> 0x012a, RuntimeException -> 0x0118 }
            m1.k1 r10 = r9.E     // Catch:{ p -> 0x015a, m -> 0x0153, b1 -> 0x0136, i -> 0x0132, b -> 0x012e, IOException -> 0x012a, RuntimeException -> 0x0118 }
            int r10 = r10.f10320e     // Catch:{ p -> 0x015a, m -> 0x0153, b1 -> 0x0136, i -> 0x0132, b -> 0x012e, IOException -> 0x012a, RuntimeException -> 0x0118 }
            r6 = 3
            if (r10 == r6) goto L_0x0093
            if (r10 != r2) goto L_0x01bf
        L_0x0093:
            r8.d(r2)     // Catch:{ p -> 0x015a, m -> 0x0153, b1 -> 0x0136, i -> 0x0132, b -> 0x012e, IOException -> 0x012a, RuntimeException -> 0x0118 }
            goto L_0x01bf
        L_0x0098:
            r6 = 15
            j1.e0 r10 = r8.a(r6, r10)     // Catch:{ p -> 0x015a, m -> 0x0153, b1 -> 0x0136, i -> 0x0132, b -> 0x012e, IOException -> 0x012a, RuntimeException -> 0x0118 }
            r10.a()     // Catch:{ p -> 0x015a, m -> 0x0153, b1 -> 0x0136, i -> 0x0132, b -> 0x012e, IOException -> 0x012a, RuntimeException -> 0x0118 }
            goto L_0x01bf
        L_0x00a3:
            int r6 = r10.arg1     // Catch:{ p -> 0x015a, m -> 0x0153, b1 -> 0x0136, i -> 0x0132, b -> 0x012e, IOException -> 0x012a, RuntimeException -> 0x0118 }
            if (r6 == 0) goto L_0x00a9
            r6 = 1
            goto L_0x00aa
        L_0x00a9:
            r6 = 0
        L_0x00aa:
            java.lang.Object r10 = r10.obj     // Catch:{ p -> 0x015a, m -> 0x0153, b1 -> 0x0136, i -> 0x0132, b -> 0x012e, IOException -> 0x012a, RuntimeException -> 0x0118 }
            java.util.concurrent.atomic.AtomicBoolean r10 = (java.util.concurrent.atomic.AtomicBoolean) r10     // Catch:{ p -> 0x015a, m -> 0x0153, b1 -> 0x0136, i -> 0x0132, b -> 0x012e, IOException -> 0x012a, RuntimeException -> 0x0118 }
            r9.O(r6, r10)     // Catch:{ p -> 0x015a, m -> 0x0153, b1 -> 0x0136, i -> 0x0132, b -> 0x012e, IOException -> 0x012a, RuntimeException -> 0x0118 }
            goto L_0x01bf
        L_0x00b3:
            int r10 = r10.arg1     // Catch:{ p -> 0x015a, m -> 0x0153, b1 -> 0x0136, i -> 0x0132, b -> 0x012e, IOException -> 0x012a, RuntimeException -> 0x0118 }
            if (r10 == 0) goto L_0x00b9
            r10 = 1
            goto L_0x00ba
        L_0x00b9:
            r10 = 0
        L_0x00ba:
            r9.V(r10)     // Catch:{ p -> 0x015a, m -> 0x0153, b1 -> 0x0136, i -> 0x0132, b -> 0x012e, IOException -> 0x012a, RuntimeException -> 0x0118 }
            goto L_0x01bf
        L_0x00bf:
            int r10 = r10.arg1     // Catch:{ p -> 0x015a, m -> 0x0153, b1 -> 0x0136, i -> 0x0132, b -> 0x012e, IOException -> 0x012a, RuntimeException -> 0x0118 }
            r9.U(r10)     // Catch:{ p -> 0x015a, m -> 0x0153, b1 -> 0x0136, i -> 0x0132, b -> 0x012e, IOException -> 0x012a, RuntimeException -> 0x0118 }
            goto L_0x01bf
        L_0x00c6:
            r9.B()     // Catch:{ p -> 0x015a, m -> 0x0153, b1 -> 0x0136, i -> 0x0132, b -> 0x012e, IOException -> 0x012a, RuntimeException -> 0x0118 }
            goto L_0x01bf
        L_0x00cb:
            java.lang.Object r10 = r10.obj     // Catch:{ p -> 0x015a, m -> 0x0153, b1 -> 0x0136, i -> 0x0132, b -> 0x012e, IOException -> 0x012a, RuntimeException -> 0x0118 }
            v1.y r10 = (v1.y) r10     // Catch:{ p -> 0x015a, m -> 0x0153, b1 -> 0x0136, i -> 0x0132, b -> 0x012e, IOException -> 0x012a, RuntimeException -> 0x0118 }
            r9.i(r10)     // Catch:{ p -> 0x015a, m -> 0x0153, b1 -> 0x0136, i -> 0x0132, b -> 0x012e, IOException -> 0x012a, RuntimeException -> 0x0118 }
            goto L_0x01bf
        L_0x00d4:
            java.lang.Object r10 = r10.obj     // Catch:{ p -> 0x015a, m -> 0x0153, b1 -> 0x0136, i -> 0x0132, b -> 0x012e, IOException -> 0x012a, RuntimeException -> 0x0118 }
            v1.y r10 = (v1.y) r10     // Catch:{ p -> 0x015a, m -> 0x0153, b1 -> 0x0136, i -> 0x0132, b -> 0x012e, IOException -> 0x012a, RuntimeException -> 0x0118 }
            r9.m(r10)     // Catch:{ p -> 0x015a, m -> 0x0153, b1 -> 0x0136, i -> 0x0132, b -> 0x012e, IOException -> 0x012a, RuntimeException -> 0x0118 }
            goto L_0x01bf
        L_0x00dd:
            r9.z()     // Catch:{ p -> 0x015a, m -> 0x0153, b1 -> 0x0136, i -> 0x0132, b -> 0x012e, IOException -> 0x012a, RuntimeException -> 0x0118 }
            return r5
        L_0x00e1:
            r9.b0(r4, r5)     // Catch:{ p -> 0x015a, m -> 0x0153, b1 -> 0x0136, i -> 0x0132, b -> 0x012e, IOException -> 0x012a, RuntimeException -> 0x0118 }
            goto L_0x01bf
        L_0x00e6:
            java.lang.Object r10 = r10.obj     // Catch:{ p -> 0x015a, m -> 0x0153, b1 -> 0x0136, i -> 0x0132, b -> 0x012e, IOException -> 0x012a, RuntimeException -> 0x0118 }
            m1.p1 r10 = (m1.p1) r10     // Catch:{ p -> 0x015a, m -> 0x0153, b1 -> 0x0136, i -> 0x0132, b -> 0x012e, IOException -> 0x012a, RuntimeException -> 0x0118 }
            r9.D = r10     // Catch:{ p -> 0x015a, m -> 0x0153, b1 -> 0x0136, i -> 0x0132, b -> 0x012e, IOException -> 0x012a, RuntimeException -> 0x0118 }
            goto L_0x01bf
        L_0x00ee:
            java.lang.Object r10 = r10.obj     // Catch:{ p -> 0x015a, m -> 0x0153, b1 -> 0x0136, i -> 0x0132, b -> 0x012e, IOException -> 0x012a, RuntimeException -> 0x0118 }
            g1.e1 r10 = (g1.e1) r10     // Catch:{ p -> 0x015a, m -> 0x0153, b1 -> 0x0136, i -> 0x0132, b -> 0x012e, IOException -> 0x012a, RuntimeException -> 0x0118 }
            r9.T(r10)     // Catch:{ p -> 0x015a, m -> 0x0153, b1 -> 0x0136, i -> 0x0132, b -> 0x012e, IOException -> 0x012a, RuntimeException -> 0x0118 }
            goto L_0x01bf
        L_0x00f7:
            java.lang.Object r10 = r10.obj     // Catch:{ p -> 0x015a, m -> 0x0153, b1 -> 0x0136, i -> 0x0132, b -> 0x012e, IOException -> 0x012a, RuntimeException -> 0x0118 }
            m1.t0 r10 = (m1.t0) r10     // Catch:{ p -> 0x015a, m -> 0x0153, b1 -> 0x0136, i -> 0x0132, b -> 0x012e, IOException -> 0x012a, RuntimeException -> 0x0118 }
            r9.K(r10)     // Catch:{ p -> 0x015a, m -> 0x0153, b1 -> 0x0136, i -> 0x0132, b -> 0x012e, IOException -> 0x012a, RuntimeException -> 0x0118 }
            goto L_0x01bf
        L_0x0100:
            r9.d()     // Catch:{ p -> 0x015a, m -> 0x0153, b1 -> 0x0136, i -> 0x0132, b -> 0x012e, IOException -> 0x012a, RuntimeException -> 0x0118 }
            goto L_0x01bf
        L_0x0105:
            int r6 = r10.arg1     // Catch:{ p -> 0x015a, m -> 0x0153, b1 -> 0x0136, i -> 0x0132, b -> 0x012e, IOException -> 0x012a, RuntimeException -> 0x0118 }
            if (r6 == 0) goto L_0x010b
            r6 = 1
            goto L_0x010c
        L_0x010b:
            r6 = 0
        L_0x010c:
            int r10 = r10.arg2     // Catch:{ p -> 0x015a, m -> 0x0153, b1 -> 0x0136, i -> 0x0132, b -> 0x012e, IOException -> 0x012a, RuntimeException -> 0x0118 }
            r9.S(r10, r5, r6, r5)     // Catch:{ p -> 0x015a, m -> 0x0153, b1 -> 0x0136, i -> 0x0132, b -> 0x012e, IOException -> 0x012a, RuntimeException -> 0x0118 }
            goto L_0x01bf
        L_0x0113:
            r9.x()     // Catch:{ p -> 0x015a, m -> 0x0153, b1 -> 0x0136, i -> 0x0132, b -> 0x012e, IOException -> 0x012a, RuntimeException -> 0x0118 }
            goto L_0x01bf
        L_0x0118:
            r10 = move-exception
            boolean r6 = r10 instanceof java.lang.IllegalStateException
            if (r6 != 0) goto L_0x0121
            boolean r6 = r10 instanceof java.lang.IllegalArgumentException
            if (r6 == 0) goto L_0x0123
        L_0x0121:
            r3 = 1004(0x3ec, float:1.407E-42)
        L_0x0123:
            m1.p r6 = new m1.p
            r6.<init>(r2, r10, r3)
            goto L_0x01b1
        L_0x012a:
            r10 = move-exception
            r0 = 2000(0x7d0, float:2.803E-42)
            goto L_0x0156
        L_0x012e:
            r10 = move-exception
            r0 = 1002(0x3ea, float:1.404E-42)
            goto L_0x0156
        L_0x0132:
            r10 = move-exception
            int r0 = r10.f9007h
            goto L_0x0156
        L_0x0136:
            r10 = move-exception
            boolean r0 = r10.f6309h
            int r1 = r10.f6310i
            if (r1 != r5) goto L_0x0145
            if (r0 == 0) goto L_0x0142
            r3 = 3001(0xbb9, float:4.205E-42)
            goto L_0x014f
        L_0x0142:
            r3 = 3003(0xbbb, float:4.208E-42)
            goto L_0x014f
        L_0x0145:
            r2 = 4
            if (r1 != r2) goto L_0x014f
            if (r0 == 0) goto L_0x014d
            r3 = 3002(0xbba, float:4.207E-42)
            goto L_0x014f
        L_0x014d:
            r3 = 3004(0xbbc, float:4.21E-42)
        L_0x014f:
            r9.j(r10, r3)
            goto L_0x01bf
        L_0x0153:
            r10 = move-exception
            int r0 = r10.f12499h
        L_0x0156:
            r9.j(r10, r0)
            goto L_0x01bf
        L_0x015a:
            r10 = move-exception
            int r2 = r10.f10424p
            if (r2 != r5) goto L_0x016d
            m1.a1 r2 = r9.f10517z
            m1.y0 r2 = r2.f10182i
            if (r2 == 0) goto L_0x016d
            m1.z0 r2 = r2.f10534f
            v1.a0 r2 = r2.f10547a
            m1.p r10 = r10.j(r2)
        L_0x016d:
            r6 = r10
            boolean r10 = r6.f10430v
            if (r10 == 0) goto L_0x01a8
            m1.p r10 = r9.V
            if (r10 != 0) goto L_0x01a8
            java.lang.String r10 = "Recoverable renderer error"
            j1.v.h(r1, r10, r6)
            r9.V = r6
            j1.f0 r10 = r9.f10506o
            r0 = 25
            j1.e0 r0 = r10.a(r0, r6)
            r10.getClass()
            android.os.Message r1 = r0.f8423a
            r1.getClass()
            android.os.Handler r10 = r10.f8429a
            r10.sendMessageAtFrontOfQueue(r1)
            r10 = 0
            r0.f8423a = r10
            java.util.ArrayList r10 = j1.f0.f8428b
            monitor-enter(r10)
            int r1 = r10.size()     // Catch:{ all -> 0x01a5 }
            r2 = 50
            if (r1 >= r2) goto L_0x01a3
            r10.add(r0)     // Catch:{ all -> 0x01a5 }
        L_0x01a3:
            monitor-exit(r10)     // Catch:{ all -> 0x01a5 }
            goto L_0x01bf
        L_0x01a5:
            r0 = move-exception
            monitor-exit(r10)     // Catch:{ all -> 0x01a5 }
            throw r0
        L_0x01a8:
            m1.p r10 = r9.V
            if (r10 == 0) goto L_0x01b1
            r10.addSuppressed(r6)
            m1.p r6 = r9.V
        L_0x01b1:
            j1.v.d(r1, r0, r6)
            r9.b0(r5, r4)
            m1.k1 r10 = r9.E
            m1.k1 r10 = r10.d(r6)
            r9.E = r10
        L_0x01bf:
            r9.u()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: m1.u0.handleMessage(android.os.Message):boolean");
    }

    public final void i(v1.y yVar) {
        boolean z10;
        y0 y0Var = this.f10517z.f10183j;
        boolean z11 = true;
        if (y0Var == null || y0Var.f10529a != yVar) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (z10) {
            long j10 = this.S;
            if (y0Var != null) {
                if (y0Var.f10540l != null) {
                    z11 = false;
                }
                j1.a.e(z11);
                if (y0Var.f10532d) {
                    y0Var.f10529a.D(j10 - y0Var.f10543o);
                }
            }
            t();
        }
    }

    public final void j(IOException iOException, int i10) {
        p pVar = new p(0, iOException, i10);
        y0 y0Var = this.f10517z.f10181h;
        if (y0Var != null) {
            pVar = pVar.j(y0Var.f10534f.f10547a);
        }
        v.d("ExoPlayerImplInternal", "Playback error", pVar);
        b0(false, false);
        this.E = this.E.d(pVar);
    }

    public final void k(boolean z10) {
        a0 a0Var;
        long j10;
        y0 y0Var = this.f10517z.f10183j;
        if (y0Var == null) {
            a0Var = this.E.f10317b;
        } else {
            a0Var = y0Var.f10534f.f10547a;
        }
        boolean z11 = !this.E.f10326k.equals(a0Var);
        if (z11) {
            this.E = this.E.a(a0Var);
        }
        k1 k1Var = this.E;
        if (y0Var == null) {
            j10 = k1Var.f10333r;
        } else {
            j10 = y0Var.d();
        }
        k1Var.f10331p = j10;
        k1 k1Var2 = this.E;
        long j11 = k1Var2.f10331p;
        y0 y0Var2 = this.f10517z.f10183j;
        long j12 = 0;
        if (y0Var2 != null) {
            j12 = Math.max(0, j11 - (this.S - y0Var2.f10543o));
        }
        k1Var2.f10332q = j12;
        if ((z11 || z10) && y0Var != null && y0Var.f10532d) {
            e0(y0Var.f10542n);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v1, resolved type: long} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v4, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v7, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v8, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v10, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v11, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v5, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r26v6, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v6, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v7, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r26v8, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v8, resolved type: long} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v9, resolved type: long} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r26v15, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v14, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v16, resolved type: long} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v18, resolved type: boolean} */
    /* JADX WARNING: type inference failed for: r10v1 */
    /* JADX WARNING: type inference failed for: r10v12 */
    /* JADX WARNING: type inference failed for: r10v13 */
    /* JADX WARNING: type inference failed for: r10v14 */
    /* JADX WARNING: type inference failed for: r10v18 */
    /* JADX WARNING: type inference failed for: r26v17 */
    /* JADX WARNING: type inference failed for: r10v21 */
    /* JADX WARNING: type inference failed for: r26v21 */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x01e2, code lost:
        if (r1.m(r6, r8) != 2) goto L_0x01f3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x01f1, code lost:
        if (r1.o(r4.f6679b) != false) goto L_0x01f3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x01f3, code lost:
        r1 = true;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:207:0x03a9  */
    /* JADX WARNING: Removed duplicated region for block: B:208:0x03ac  */
    /* JADX WARNING: Removed duplicated region for block: B:223:0x03ea  */
    /* JADX WARNING: Removed duplicated region for block: B:227:0x0414  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void l(g1.u1 r41, boolean r42) {
        /*
            r40 = this;
            r11 = r40
            r12 = r41
            m1.k1 r0 = r11.E
            m1.t0 r8 = r11.R
            m1.a1 r9 = r11.f10517z
            int r4 = r11.L
            boolean r10 = r11.M
            g1.t1 r13 = r11.f10509r
            g1.r1 r14 = r11.f10510s
            boolean r1 = r41.y()
            r17 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r1 == 0) goto L_0x0037
            m1.s0 r0 = new m1.s0
            v1.a0 r20 = m1.k1.f10315s
            r21 = 0
            r23 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r25 = 0
            r26 = 1
            r27 = 0
            r19 = r0
            r19.<init>(r20, r21, r23, r25, r26, r27)
            r7 = r0
            r11 = 4
            goto L_0x022f
        L_0x0037:
            v1.a0 r2 = r0.f10317b
            java.lang.Object r1 = r2.f6678a
            g1.u1 r3 = r0.f10316a
            boolean r20 = r3.y()
            if (r20 != 0) goto L_0x0051
            java.lang.Object r5 = r2.f6678a
            g1.r1 r3 = r3.p(r5, r14)
            boolean r3 = r3.f6547m
            if (r3 == 0) goto L_0x004e
            goto L_0x0051
        L_0x004e:
            r21 = 0
            goto L_0x0053
        L_0x0051:
            r21 = 1
        L_0x0053:
            v1.a0 r3 = r0.f10317b
            boolean r3 = r3.a()
            if (r3 != 0) goto L_0x0061
            if (r21 == 0) goto L_0x005e
            goto L_0x0061
        L_0x005e:
            long r6 = r0.f10333r
            goto L_0x0063
        L_0x0061:
            long r6 = r0.f10318c
        L_0x0063:
            r24 = r6
            if (r8 == 0) goto L_0x00c5
            r3 = 1
            r7 = r1
            r1 = r41
            r6 = r2
            r2 = r8
            r5 = 0
            r15 = 1
            r5 = r10
            r29 = r6
            r15 = -1
            r6 = r13
            r15 = r7
            r11 = 4
            r7 = r14
            android.util.Pair r1 = G(r1, r2, r3, r4, r5, r6, r7)
            if (r1 != 0) goto L_0x0087
            int r1 = r12.j(r10)
            r4 = r24
            r2 = 0
            r3 = 0
            r6 = 1
            goto L_0x00b7
        L_0x0087:
            long r2 = r8.f10495c
            int r4 = (r2 > r17 ? 1 : (r2 == r17 ? 0 : -1))
            if (r4 != 0) goto L_0x009a
            java.lang.Object r1 = r1.first
            g1.r1 r1 = r12.p(r1, r14)
            int r6 = r1.f6544j
            r1 = r15
            r3 = r24
            r5 = 0
            goto L_0x00a7
        L_0x009a:
            java.lang.Object r2 = r1.first
            java.lang.Object r1 = r1.second
            java.lang.Long r1 = (java.lang.Long) r1
            long r3 = r1.longValue()
            r1 = r2
            r5 = 1
            r6 = -1
        L_0x00a7:
            int r2 = r0.f10320e
            if (r2 != r11) goto L_0x00ad
            r2 = 1
            goto L_0x00ae
        L_0x00ad:
            r2 = 0
        L_0x00ae:
            r15 = r1
            r1 = r6
            r6 = 0
            r38 = r3
            r3 = r2
            r2 = r5
            r4 = r38
        L_0x00b7:
            r37 = r2
            r35 = r3
            r2 = r4
            r36 = r6
            r7 = r29
            r5 = -1
            r4 = r1
            r1 = r15
            goto L_0x0166
        L_0x00c5:
            r15 = r1
            r29 = r2
            r11 = 4
            g1.u1 r1 = r0.f10316a
            boolean r1 = r1.y()
            if (r1 == 0) goto L_0x00d9
            int r6 = r12.j(r10)
        L_0x00d5:
            r7 = r29
            goto L_0x0159
        L_0x00d9:
            int r1 = r12.k(r15)
            r2 = -1
            if (r1 != r2) goto L_0x0100
            g1.u1 r6 = r0.f10316a
            r1 = r13
            r2 = r14
            r3 = r4
            r4 = r10
            r5 = r15
            r7 = r41
            java.lang.Object r1 = H(r1, r2, r3, r4, r5, r6, r7)
            if (r1 != 0) goto L_0x00f5
            int r1 = r12.j(r10)
            r5 = 1
            goto L_0x00fc
        L_0x00f5:
            g1.r1 r1 = r12.p(r1, r14)
            int r1 = r1.f6544j
            r5 = 0
        L_0x00fc:
            r3 = r5
            r7 = r29
            goto L_0x015b
        L_0x0100:
            int r1 = (r24 > r17 ? 1 : (r24 == r17 ? 0 : -1))
            if (r1 != 0) goto L_0x010b
            g1.r1 r1 = r12.p(r15, r14)
            int r6 = r1.f6544j
            goto L_0x00d5
        L_0x010b:
            if (r21 == 0) goto L_0x0156
            g1.u1 r1 = r0.f10316a
            r7 = r29
            java.lang.Object r2 = r7.f6678a
            r1.p(r2, r14)
            g1.u1 r1 = r0.f10316a
            int r2 = r14.f6544j
            g1.t1 r1 = r1.v(r2, r13)
            int r1 = r1.f6589v
            g1.u1 r2 = r0.f10316a
            java.lang.Object r3 = r7.f6678a
            int r2 = r2.k(r3)
            if (r1 != r2) goto L_0x0149
            long r1 = r14.f6546l
            long r5 = r24 + r1
            g1.r1 r1 = r12.p(r15, r14)
            int r4 = r1.f6544j
            r1 = r41
            r2 = r13
            r3 = r14
            android.util.Pair r1 = r1.r(r2, r3, r4, r5)
            java.lang.Object r2 = r1.first
            java.lang.Object r1 = r1.second
            java.lang.Long r1 = (java.lang.Long) r1
            long r3 = r1.longValue()
            r1 = r2
            r4 = r3
            goto L_0x014c
        L_0x0149:
            r1 = r15
            r4 = r24
        L_0x014c:
            r2 = r4
            r4 = -1
            r5 = -1
            r35 = 0
            r36 = 0
            r37 = 1
            goto L_0x0166
        L_0x0156:
            r7 = r29
            r6 = -1
        L_0x0159:
            r1 = r6
            r3 = 0
        L_0x015b:
            r4 = r1
            r36 = r3
            r1 = r15
            r2 = r24
            r5 = -1
            r35 = 0
            r37 = 0
        L_0x0166:
            if (r4 == r5) goto L_0x0184
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r1 = r41
            r2 = r13
            r3 = r14
            android.util.Pair r1 = r1.r(r2, r3, r4, r5)
            java.lang.Object r2 = r1.first
            java.lang.Object r1 = r1.second
            java.lang.Long r1 = (java.lang.Long) r1
            long r3 = r1.longValue()
            r1 = r2
            r2 = r3
            r33 = r17
            goto L_0x0186
        L_0x0184:
            r33 = r2
        L_0x0186:
            v1.a0 r4 = r9.m(r12, r1, r2)
            int r5 = r4.f6682e
            r6 = -1
            if (r5 == r6) goto L_0x0198
            int r8 = r7.f6682e
            if (r8 == r6) goto L_0x0196
            if (r5 < r8) goto L_0x0196
            goto L_0x0198
        L_0x0196:
            r5 = 0
            goto L_0x0199
        L_0x0198:
            r5 = 1
        L_0x0199:
            java.lang.Object r6 = r7.f6678a
            boolean r6 = r6.equals(r1)
            if (r6 == 0) goto L_0x01b1
            boolean r6 = r7.a()
            if (r6 != 0) goto L_0x01b1
            boolean r6 = r4.a()
            if (r6 != 0) goto L_0x01b1
            if (r5 == 0) goto L_0x01b1
            r5 = 1
            goto L_0x01b2
        L_0x01b1:
            r5 = 0
        L_0x01b2:
            g1.r1 r1 = r12.p(r1, r14)
            if (r21 != 0) goto L_0x01f5
            int r6 = (r24 > r33 ? 1 : (r24 == r33 ? 0 : -1))
            if (r6 != 0) goto L_0x01f5
            java.lang.Object r6 = r7.f6678a
            java.lang.Object r8 = r4.f6678a
            boolean r6 = r6.equals(r8)
            if (r6 != 0) goto L_0x01c7
            goto L_0x01f5
        L_0x01c7:
            boolean r6 = r7.a()
            if (r6 == 0) goto L_0x01e5
            int r6 = r7.f6679b
            boolean r8 = r1.o(r6)
            if (r8 == 0) goto L_0x01e5
            int r8 = r7.f6680c
            int r9 = r1.m(r6, r8)
            if (r9 == r11) goto L_0x01f5
            int r1 = r1.m(r6, r8)
            r6 = 2
            if (r1 == r6) goto L_0x01f5
            goto L_0x01f3
        L_0x01e5:
            boolean r6 = r4.a()
            if (r6 == 0) goto L_0x01f5
            int r6 = r4.f6679b
            boolean r1 = r1.o(r6)
            if (r1 == 0) goto L_0x01f5
        L_0x01f3:
            r1 = 1
            goto L_0x01f6
        L_0x01f5:
            r1 = 0
        L_0x01f6:
            if (r5 != 0) goto L_0x01fa
            if (r1 == 0) goto L_0x01fb
        L_0x01fa:
            r4 = r7
        L_0x01fb:
            boolean r1 = r4.a()
            if (r1 == 0) goto L_0x0223
            boolean r1 = r4.equals(r7)
            if (r1 == 0) goto L_0x020a
            long r0 = r0.f10333r
            goto L_0x021d
        L_0x020a:
            java.lang.Object r0 = r4.f6678a
            r12.p(r0, r14)
            int r0 = r4.f6680c
            int r1 = r4.f6679b
            int r1 = r14.n(r1)
            if (r0 != r1) goto L_0x0220
            g1.c r0 = r14.f6548n
            long r0 = r0.f6330j
        L_0x021d:
            r31 = r0
            goto L_0x0225
        L_0x0220:
            r31 = 0
            goto L_0x0225
        L_0x0223:
            r31 = r2
        L_0x0225:
            m1.s0 r0 = new m1.s0
            r29 = r0
            r30 = r4
            r29.<init>(r30, r31, r33, r35, r36, r37)
            r7 = r0
        L_0x022f:
            v1.a0 r9 = r7.f10459a
            long r13 = r7.f10461c
            boolean r6 = r7.f10462d
            long r3 = r7.f10460b
            r10 = 4
            r11 = r40
            m1.k1 r0 = r11.E
            v1.a0 r0 = r0.f10317b
            boolean r0 = r0.equals(r9)
            if (r0 == 0) goto L_0x024f
            m1.k1 r0 = r11.E
            long r0 = r0.f10333r
            int r2 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r2 == 0) goto L_0x024d
            goto L_0x024f
        L_0x024d:
            r15 = 0
            goto L_0x0250
        L_0x024f:
            r15 = 1
        L_0x0250:
            r16 = 3
            boolean r0 = r7.f10463e     // Catch:{ all -> 0x0396 }
            if (r0 == 0) goto L_0x0265
            m1.k1 r0 = r11.E     // Catch:{ all -> 0x0396 }
            int r0 = r0.f10320e     // Catch:{ all -> 0x0396 }
            r5 = 1
            if (r0 == r5) goto L_0x0260
            r11.X(r10)     // Catch:{ all -> 0x0396 }
        L_0x0260:
            r2 = 0
            r11.C(r2, r2, r2, r5)     // Catch:{ all -> 0x0396 }
            goto L_0x0267
        L_0x0265:
            r2 = 0
            r5 = 1
        L_0x0267:
            if (r15 != 0) goto L_0x02d5
            m1.a1 r1 = r11.f10517z     // Catch:{ all -> 0x0396 }
            long r5 = r11.S     // Catch:{ all -> 0x0396 }
            m1.y0 r0 = r1.f10182i     // Catch:{ all -> 0x0396 }
            if (r0 != 0) goto L_0x0278
            r21 = r3
            r26 = r13
            r28 = 0
            goto L_0x02b9
        L_0x0278:
            r21 = r3
            long r2 = r0.f10543o     // Catch:{ all -> 0x02d2 }
            boolean r4 = r0.f10532d     // Catch:{ all -> 0x02d2 }
            if (r4 != 0) goto L_0x0283
        L_0x0280:
            r26 = r13
            goto L_0x02b7
        L_0x0283:
            r4 = 0
        L_0x0284:
            m1.f[] r8 = r11.f10499h     // Catch:{ all -> 0x02d2 }
            int r10 = r8.length     // Catch:{ all -> 0x02ca }
            if (r4 >= r10) goto L_0x0280
            r10 = r8[r4]     // Catch:{ all -> 0x02ca }
            boolean r10 = q(r10)     // Catch:{ all -> 0x02ca }
            if (r10 == 0) goto L_0x02af
            r8 = r8[r4]     // Catch:{ all -> 0x02ca }
            v1.b1 r10 = r8.f10222n     // Catch:{ all -> 0x02ca }
            r26 = r13
            v1.b1[] r13 = r0.f10531c     // Catch:{ all -> 0x02ac }
            r13 = r13[r4]     // Catch:{ all -> 0x02ac }
            if (r10 == r13) goto L_0x029e
            goto L_0x02b1
        L_0x029e:
            long r13 = r8.f10225q     // Catch:{ all -> 0x02ac }
            r28 = -9223372036854775808
            int r8 = (r13 > r28 ? 1 : (r13 == r28 ? 0 : -1))
            if (r8 != 0) goto L_0x02a7
            goto L_0x02b9
        L_0x02a7:
            long r2 = java.lang.Math.max(r13, r2)     // Catch:{ all -> 0x02ac }
            goto L_0x02b1
        L_0x02ac:
            r0 = move-exception
            goto L_0x039b
        L_0x02af:
            r26 = r13
        L_0x02b1:
            int r4 = r4 + 1
            r13 = r26
            r10 = 4
            goto L_0x0284
        L_0x02b7:
            r28 = r2
        L_0x02b9:
            r13 = 0
            r2 = r41
            r3 = r5
            r10 = 1
            r5 = r28
            boolean r0 = r1.o(r2, r3, r5)     // Catch:{ all -> 0x0393 }
            if (r0 != 0) goto L_0x0317
            r11.J(r13)     // Catch:{ all -> 0x0393 }
            goto L_0x0317
        L_0x02ca:
            r0 = move-exception
            r26 = r13
            goto L_0x039b
        L_0x02cf:
            r14 = 0
            goto L_0x039f
        L_0x02d2:
            r0 = move-exception
            goto L_0x0399
        L_0x02d5:
            r21 = r3
            r26 = r13
            r10 = 1
            r13 = 0
            boolean r0 = r41.y()     // Catch:{ all -> 0x0393 }
            if (r0 != 0) goto L_0x0317
            m1.a1 r0 = r11.f10517z     // Catch:{ all -> 0x0393 }
            m1.y0 r0 = r0.f10181h     // Catch:{ all -> 0x0393 }
        L_0x02e5:
            if (r0 == 0) goto L_0x0301
            m1.z0 r1 = r0.f10534f     // Catch:{ all -> 0x0393 }
            v1.a0 r1 = r1.f10547a     // Catch:{ all -> 0x0393 }
            boolean r1 = r1.equals(r9)     // Catch:{ all -> 0x0393 }
            if (r1 == 0) goto L_0x02fe
            m1.a1 r1 = r11.f10517z     // Catch:{ all -> 0x0393 }
            m1.z0 r2 = r0.f10534f     // Catch:{ all -> 0x0393 }
            m1.z0 r1 = r1.g(r12, r2)     // Catch:{ all -> 0x0393 }
            r0.f10534f = r1     // Catch:{ all -> 0x0393 }
            r0.h()     // Catch:{ all -> 0x0393 }
        L_0x02fe:
            m1.y0 r0 = r0.f10540l     // Catch:{ all -> 0x0393 }
            goto L_0x02e5
        L_0x0301:
            m1.a1 r0 = r11.f10517z     // Catch:{ all -> 0x0393 }
            m1.y0 r1 = r0.f10181h     // Catch:{ all -> 0x0393 }
            m1.y0 r0 = r0.f10182i     // Catch:{ all -> 0x0393 }
            if (r1 == r0) goto L_0x030b
            r5 = 1
            goto L_0x030c
        L_0x030b:
            r5 = 0
        L_0x030c:
            r1 = r40
            r2 = r9
            r3 = r21
            long r0 = r1.L(r2, r3, r5, r6)     // Catch:{ all -> 0x0393 }
            r21 = r0
        L_0x0317:
            m1.k1 r0 = r11.E
            g1.u1 r4 = r0.f10316a
            v1.a0 r5 = r0.f10317b
            boolean r0 = r7.f10464f
            if (r0 == 0) goto L_0x0324
            r6 = r21
            goto L_0x0326
        L_0x0324:
            r6 = r17
        L_0x0326:
            r8 = 0
            r1 = r40
            r2 = r41
            r3 = r9
            r14 = 0
            r1.g0(r2, r3, r4, r5, r6, r8)
            if (r15 != 0) goto L_0x033a
            m1.k1 r0 = r11.E
            long r0 = r0.f10318c
            int r2 = (r26 > r0 ? 1 : (r26 == r0 ? 0 : -1))
            if (r2 == 0) goto L_0x0375
        L_0x033a:
            m1.k1 r0 = r11.E
            v1.a0 r1 = r0.f10317b
            java.lang.Object r1 = r1.f6678a
            g1.u1 r0 = r0.f10316a
            if (r15 == 0) goto L_0x0357
            if (r42 == 0) goto L_0x0357
            boolean r2 = r0.y()
            if (r2 != 0) goto L_0x0357
            g1.r1 r2 = r11.f10510s
            g1.r1 r0 = r0.p(r1, r2)
            boolean r0 = r0.f6547m
            if (r0 != 0) goto L_0x0357
            goto L_0x0358
        L_0x0357:
            r10 = 0
        L_0x0358:
            m1.k1 r0 = r11.E
            long r7 = r0.f10319d
            int r0 = r12.k(r1)
            r1 = -1
            if (r0 != r1) goto L_0x0365
            r16 = 4
        L_0x0365:
            r1 = r40
            r2 = r9
            r3 = r21
            r5 = r26
            r9 = r10
            r10 = r16
            m1.k1 r0 = r1.o(r2, r3, r5, r7, r9, r10)
            r11.E = r0
        L_0x0375:
            r40.D()
            m1.k1 r0 = r11.E
            g1.u1 r0 = r0.f10316a
            r11.F(r12, r0)
            m1.k1 r0 = r11.E
            m1.k1 r0 = r0.g(r12)
            r11.E = r0
            boolean r0 = r41.y()
            if (r0 != 0) goto L_0x038f
            r11.R = r14
        L_0x038f:
            r11.k(r13)
            return
        L_0x0393:
            r0 = move-exception
            goto L_0x02cf
        L_0x0396:
            r0 = move-exception
            r21 = r3
        L_0x0399:
            r26 = r13
        L_0x039b:
            r10 = 1
            r13 = 0
            goto L_0x02cf
        L_0x039f:
            m1.k1 r1 = r11.E
            g1.u1 r4 = r1.f10316a
            v1.a0 r5 = r1.f10317b
            boolean r1 = r7.f10464f
            if (r1 == 0) goto L_0x03ac
            r6 = r21
            goto L_0x03ae
        L_0x03ac:
            r6 = r17
        L_0x03ae:
            r8 = 0
            r1 = r40
            r2 = r41
            r3 = r9
            r1.g0(r2, r3, r4, r5, r6, r8)
            if (r15 != 0) goto L_0x03c1
            m1.k1 r1 = r11.E
            long r1 = r1.f10318c
            int r3 = (r26 > r1 ? 1 : (r26 == r1 ? 0 : -1))
            if (r3 == 0) goto L_0x03fc
        L_0x03c1:
            m1.k1 r1 = r11.E
            v1.a0 r2 = r1.f10317b
            java.lang.Object r2 = r2.f6678a
            g1.u1 r1 = r1.f10316a
            if (r15 == 0) goto L_0x03de
            if (r42 == 0) goto L_0x03de
            boolean r3 = r1.y()
            if (r3 != 0) goto L_0x03de
            g1.r1 r3 = r11.f10510s
            g1.r1 r1 = r1.p(r2, r3)
            boolean r1 = r1.f6547m
            if (r1 != 0) goto L_0x03de
            goto L_0x03df
        L_0x03de:
            r10 = 0
        L_0x03df:
            m1.k1 r1 = r11.E
            long r7 = r1.f10319d
            int r1 = r12.k(r2)
            r2 = -1
            if (r1 != r2) goto L_0x03ec
            r16 = 4
        L_0x03ec:
            r1 = r40
            r2 = r9
            r3 = r21
            r5 = r26
            r9 = r10
            r10 = r16
            m1.k1 r1 = r1.o(r2, r3, r5, r7, r9, r10)
            r11.E = r1
        L_0x03fc:
            r40.D()
            m1.k1 r1 = r11.E
            g1.u1 r1 = r1.f10316a
            r11.F(r12, r1)
            m1.k1 r1 = r11.E
            m1.k1 r1 = r1.g(r12)
            r11.E = r1
            boolean r1 = r41.y()
            if (r1 != 0) goto L_0x0416
            r11.R = r14
        L_0x0416:
            r11.k(r13)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: m1.u0.l(g1.u1, boolean):void");
    }

    public final void m(v1.y yVar) {
        boolean z10;
        a1 a1Var = this.f10517z;
        y0 y0Var = a1Var.f10183j;
        if (y0Var == null || y0Var.f10529a != yVar) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (z10) {
            float f10 = this.f10513v.i().f6355h;
            u1 u1Var = this.E.f10316a;
            y0Var.f10532d = true;
            y0Var.f10541m = y0Var.f10529a.o();
            y g10 = y0Var.g(f10, u1Var);
            z0 z0Var = y0Var.f10534f;
            long j10 = z0Var.f10548b;
            long j11 = z0Var.f10551e;
            if (j11 != -9223372036854775807L && j10 >= j11) {
                j10 = Math.max(0, j11 - 1);
            }
            long a10 = y0Var.a(g10, j10, false, new boolean[y0Var.f10537i.length]);
            long j12 = y0Var.f10543o;
            z0 z0Var2 = y0Var.f10534f;
            y0Var.f10543o = (z0Var2.f10548b - a10) + j12;
            y0Var.f10534f = z0Var2.b(a10);
            e0(y0Var.f10542n);
            if (y0Var == a1Var.f10181h) {
                E(y0Var.f10534f.f10548b);
                e(new boolean[this.f10499h.length]);
                k1 k1Var = this.E;
                a0 a0Var = k1Var.f10317b;
                long j13 = y0Var.f10534f.f10548b;
                this.E = o(a0Var, j13, k1Var.f10318c, j13, false, 5);
            }
            t();
        }
    }

    public final void n(g1.e1 e1Var, float f10, boolean z10, boolean z11) {
        int i10;
        if (z10) {
            if (z11) {
                this.F.a(1);
            }
            this.E = this.E.e(e1Var);
        }
        float f11 = e1Var.f6355h;
        y0 y0Var = this.f10517z.f10181h;
        while (true) {
            i10 = 0;
            if (y0Var == null) {
                break;
            }
            s[] sVarArr = y0Var.f10542n.f17489c;
            int length = sVarArr.length;
            while (i10 < length) {
                s sVar = sVarArr[i10];
                if (sVar != null) {
                    sVar.p(f11);
                }
                i10++;
            }
            y0Var = y0Var.f10540l;
        }
        f[] fVarArr = this.f10499h;
        int length2 = fVarArr.length;
        while (i10 < length2) {
            f fVar = fVarArr[i10];
            if (fVar != null) {
                fVar.w(f10, e1Var.f6355h);
            }
            i10++;
        }
    }

    public final k1 o(a0 a0Var, long j10, long j11, long j12, boolean z10, int i10) {
        boolean z11;
        d9.r1 r1Var;
        y yVar;
        l1 l1Var;
        long j13;
        boolean z12;
        l1 l1Var2;
        y yVar2;
        d9.r1 r1Var2;
        a0 a0Var2 = a0Var;
        long j14 = j11;
        int i11 = i10;
        if (this.U || j10 != this.E.f10333r || !a0Var2.equals(this.E.f10317b)) {
            z11 = true;
        } else {
            z11 = false;
        }
        this.U = z11;
        D();
        k1 k1Var = this.E;
        l1 l1Var3 = k1Var.f10323h;
        y yVar3 = k1Var.f10324i;
        List list = k1Var.f10325j;
        if (this.A.f10305k) {
            y0 y0Var = this.f10517z.f10181h;
            if (y0Var == null) {
                l1Var2 = l1.f15714k;
            } else {
                l1Var2 = y0Var.f10541m;
            }
            if (y0Var == null) {
                yVar2 = this.f10503l;
            } else {
                yVar2 = y0Var.f10542n;
            }
            s[] sVarArr = yVar2.f17489c;
            o0 o0Var = new o0();
            boolean z13 = false;
            for (s sVar : sVarArr) {
                if (sVar != null) {
                    z0 z0Var = sVar.e(0).f6274q;
                    if (z0Var == null) {
                        o0Var.c(new z0(new y0[0]));
                    } else {
                        o0Var.c(z0Var);
                        z13 = true;
                    }
                }
            }
            if (z13) {
                r1Var2 = o0Var.e();
            } else {
                p0 p0Var = d9.r0.f4657i;
                r1Var2 = d9.r1.f4658l;
            }
            if (y0Var != null) {
                z0 z0Var2 = y0Var.f10534f;
                if (z0Var2.f10549c != j14) {
                    y0Var.f10534f = z0Var2.a(j14);
                }
            }
            r1Var = r1Var2;
            l1Var = l1Var2;
            yVar = yVar2;
        } else if (!a0Var2.equals(k1Var.f10317b)) {
            l1Var = l1.f15714k;
            yVar = this.f10503l;
            r1Var = d9.r1.f4658l;
        } else {
            l1Var = l1Var3;
            yVar = yVar3;
            r1Var = list;
        }
        if (z10) {
            r0 r0Var = this.F;
            if (!r0Var.f10454d || r0Var.f10455e == 5) {
                r0Var.f10451a = true;
                r0Var.f10454d = true;
                r0Var.f10455e = i11;
            } else {
                if (i11 == 5) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                j1.a.b(z12);
            }
        }
        k1 k1Var2 = this.E;
        long j15 = k1Var2.f10331p;
        y0 y0Var2 = this.f10517z.f10183j;
        if (y0Var2 == null) {
            j13 = 0;
        } else {
            j13 = Math.max(0, j15 - (this.S - y0Var2.f10543o));
        }
        return k1Var2.b(a0Var, j10, j11, j12, j13, l1Var, yVar, r1Var);
    }

    public final boolean p() {
        long j10;
        y0 y0Var = this.f10517z.f10183j;
        if (y0Var == null) {
            return false;
        }
        if (!y0Var.f10532d) {
            j10 = 0;
        } else {
            j10 = y0Var.f10529a.j();
        }
        if (j10 == Long.MIN_VALUE) {
            return false;
        }
        return true;
    }

    public final void r(d1 d1Var) {
        this.f10506o.a(9, (v1.y) d1Var).a();
    }

    public final boolean s() {
        y0 y0Var = this.f10517z.f10181h;
        long j10 = y0Var.f10534f.f10551e;
        if (!y0Var.f10532d || (j10 != -9223372036854775807L && this.E.f10333r >= j10 && Y())) {
            return false;
        }
        return true;
    }

    public final void t() {
        boolean z10;
        long j10;
        long j11;
        boolean z11 = false;
        if (!p()) {
            z10 = false;
        } else {
            y0 y0Var = this.f10517z.f10183j;
            if (!y0Var.f10532d) {
                j10 = 0;
            } else {
                j10 = y0Var.f10529a.j();
            }
            y0 y0Var2 = this.f10517z.f10183j;
            if (y0Var2 == null) {
                j11 = 0;
            } else {
                j11 = Math.max(0, j10 - (this.S - y0Var2.f10543o));
            }
            if (y0Var != this.f10517z.f10181h) {
                long j12 = y0Var.f10534f.f10548b;
            }
            z10 = this.f10504m.c(j11, this.f10513v.i().f6355h);
            if (!z10 && j11 < 500000 && (this.f10511t > 0 || this.f10512u)) {
                this.f10517z.f10181h.f10529a.y(this.E.f10333r, false);
                z10 = this.f10504m.c(j11, this.f10513v.i().f6355h);
            }
        }
        this.K = z10;
        if (z10) {
            y0 y0Var3 = this.f10517z.f10183j;
            long j13 = this.S;
            if (y0Var3.f10540l == null) {
                z11 = true;
            }
            j1.a.e(z11);
            y0Var3.f10529a.C(j13 - y0Var3.f10543o);
        }
        d0();
    }

    public final void u() {
        boolean z10;
        r0 r0Var = this.F;
        k1 k1Var = this.E;
        boolean z11 = r0Var.f10451a;
        if (r0Var.f10452b != k1Var) {
            z10 = true;
        } else {
            z10 = false;
        }
        boolean z12 = z11 | z10;
        r0Var.f10451a = z12;
        r0Var.f10452b = k1Var;
        if (z12) {
            n0 n0Var = this.f10516y.f10525i;
            n0Var.getClass();
            n0Var.f10382i.c(new r0(n0Var, 8, r0Var));
            this.F = new r0(this.E);
        }
    }

    public final void v() {
        l(this.A.b(), true);
    }

    public final void w(q0 q0Var) {
        boolean z10;
        this.F.a(1);
        int i10 = q0Var.f10440a;
        j1 j1Var = this.A;
        j1Var.getClass();
        ArrayList arrayList = j1Var.f10296b;
        int i11 = q0Var.f10441b;
        int i12 = q0Var.f10442c;
        if (i10 < 0 || i10 > i11 || i11 > arrayList.size() || i12 < 0) {
            z10 = false;
        } else {
            z10 = true;
        }
        j1.a.b(z10);
        j1Var.f10304j = q0Var.f10443d;
        if (!(i10 == i11 || i10 == i12)) {
            int min = Math.min(i10, i12);
            int max = Math.max(((i11 - i10) + i12) - 1, i11 - 1);
            int i13 = ((i1) arrayList.get(min)).f10273d;
            l0.G(arrayList, i10, i11, i12);
            while (min <= max) {
                i1 i1Var = (i1) arrayList.get(min);
                i1Var.f10273d = i13;
                i13 += i1Var.f10270a.f15809o.x();
                min++;
            }
        }
        l(j1Var.b(), false);
    }

    public final void x() {
        int i10;
        this.F.a(1);
        int i11 = 0;
        C(false, false, false, true);
        this.f10504m.b(false);
        if (this.E.f10316a.y()) {
            i10 = 4;
        } else {
            i10 = 2;
        }
        X(i10);
        a2.h hVar = (a2.h) this.f10505n;
        hVar.getClass();
        j1 j1Var = this.A;
        j1.a.e(!j1Var.f10305k);
        j1Var.f10306l = hVar;
        while (true) {
            ArrayList arrayList = j1Var.f10296b;
            if (i11 < arrayList.size()) {
                i1 i1Var = (i1) arrayList.get(i11);
                j1Var.e(i1Var);
                j1Var.f10301g.add(i1Var);
                i11++;
            } else {
                j1Var.f10305k = true;
                this.f10506o.d(2);
                return;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0028, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean y() {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.G     // Catch:{ all -> 0x0029 }
            r1 = 1
            if (r0 != 0) goto L_0x0027
            android.os.Looper r0 = r3.f10508q     // Catch:{ all -> 0x0029 }
            java.lang.Thread r0 = r0.getThread()     // Catch:{ all -> 0x0029 }
            boolean r0 = r0.isAlive()     // Catch:{ all -> 0x0029 }
            if (r0 != 0) goto L_0x0013
            goto L_0x0027
        L_0x0013:
            j1.f0 r0 = r3.f10506o     // Catch:{ all -> 0x0029 }
            r2 = 7
            r0.d(r2)     // Catch:{ all -> 0x0029 }
            m1.q r0 = new m1.q     // Catch:{ all -> 0x0029 }
            r0.<init>(r1, r3)     // Catch:{ all -> 0x0029 }
            long r1 = r3.C     // Catch:{ all -> 0x0029 }
            r3.h0(r0, r1)     // Catch:{ all -> 0x0029 }
            boolean r0 = r3.G     // Catch:{ all -> 0x0029 }
            monitor-exit(r3)
            return r0
        L_0x0027:
            monitor-exit(r3)
            return r1
        L_0x0029:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: m1.u0.y():boolean");
    }

    public final void z() {
        C(true, false, true, false);
        this.f10504m.b(true);
        X(1);
        HandlerThread handlerThread = this.f10507p;
        if (handlerThread != null) {
            handlerThread.quit();
        }
        synchronized (this) {
            this.G = true;
            notifyAll();
        }
    }
}
