package v1;

import a2.e;
import a2.i;
import a2.l;
import a2.m;
import a2.o;
import android.net.Uri;
import android.os.Handler;
import d2.t0;
import d2.u0;
import d2.x0;
import d2.y;
import g1.a0;
import g1.a1;
import g1.b1;
import g1.v1;
import g1.y0;
import g1.z;
import g1.z0;
import j1.a;
import j1.g;
import j1.l0;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import k1.h;
import m1.p1;
import n2.c;
import p1.n;
import p1.q;
import p1.u;
import z1.s;

public final class r0 implements y, y, l, o, z0 {
    public static final Map T;
    public static final a0 U;
    public p0[] A;
    public boolean B;
    public boolean C;
    public boolean D;
    public q0 E;
    public u0 F;
    public long G;
    public boolean H;
    public int I;
    public boolean J;
    public boolean K;
    public int L;
    public boolean M;
    public long N;
    public long O;
    public boolean P;
    public int Q;
    public boolean R;
    public boolean S;

    /* renamed from: h  reason: collision with root package name */
    public final Uri f15759h;

    /* renamed from: i  reason: collision with root package name */
    public final h f15760i;

    /* renamed from: j  reason: collision with root package name */
    public final u f15761j;

    /* renamed from: k  reason: collision with root package name */
    public final i f15762k;

    /* renamed from: l  reason: collision with root package name */
    public final f0 f15763l;

    /* renamed from: m  reason: collision with root package name */
    public final q f15764m;

    /* renamed from: n  reason: collision with root package name */
    public final u0 f15765n;

    /* renamed from: o  reason: collision with root package name */
    public final e f15766o;

    /* renamed from: p  reason: collision with root package name */
    public final String f15767p;

    /* renamed from: q  reason: collision with root package name */
    public final long f15768q;

    /* renamed from: r  reason: collision with root package name */
    public final a2.q f15769r = new a2.q("ProgressiveMediaPeriod");

    /* renamed from: s  reason: collision with root package name */
    public final android.support.v4.media.session.u f15770s;

    /* renamed from: t  reason: collision with root package name */
    public final g f15771t;

    /* renamed from: u  reason: collision with root package name */
    public final m0 f15772u;

    /* renamed from: v  reason: collision with root package name */
    public final m0 f15773v;

    /* renamed from: w  reason: collision with root package name */
    public final Handler f15774w;

    /* renamed from: x  reason: collision with root package name */
    public x f15775x;

    /* renamed from: y  reason: collision with root package name */
    public c f15776y;

    /* renamed from: z  reason: collision with root package name */
    public a1[] f15777z;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put("Icy-MetaData", "1");
        T = Collections.unmodifiableMap(hashMap);
        z zVar = new z();
        zVar.f6744a = "icy";
        zVar.f6754k = "application/x-icy";
        U = zVar.a();
    }

    public r0(Uri uri, h hVar, android.support.v4.media.session.u uVar, u uVar2, q qVar, i iVar, f0 f0Var, u0 u0Var, e eVar, String str, int i10) {
        this.f15759h = uri;
        this.f15760i = hVar;
        this.f15761j = uVar2;
        this.f15764m = qVar;
        this.f15762k = iVar;
        this.f15763l = f0Var;
        this.f15765n = u0Var;
        this.f15766o = eVar;
        this.f15767p = str;
        this.f15768q = (long) i10;
        this.f15770s = uVar;
        this.f15771t = new g();
        this.f15772u = new m0(this, 0);
        this.f15773v = new m0(this, 1);
        this.f15774w = l0.k((Handler.Callback) null);
        this.A = new p0[0];
        this.f15777z = new a1[0];
        this.O = -9223372036854775807L;
        this.G = -9223372036854775807L;
        this.I = 1;
    }

    public final void A() {
        n0 n0Var = new n0(this, this.f15759h, this.f15760i, this.f15770s, this, this.f15771t);
        if (this.C) {
            a.e(s());
            long j10 = this.G;
            if (j10 == -9223372036854775807L || this.O <= j10) {
                u0 u0Var = this.F;
                u0Var.getClass();
                long j11 = u0Var.i(this.O).f4297a.f4302b;
                long j12 = this.O;
                n0Var.f15736f.f4296a = j11;
                n0Var.f15739i = j12;
                n0Var.f15738h = true;
                n0Var.f15742l = false;
                for (a1 a1Var : this.f15777z) {
                    a1Var.f15582t = this.O;
                }
                this.O = -9223372036854775807L;
            } else {
                this.R = true;
                this.O = -9223372036854775807L;
                return;
            }
        }
        this.Q = q();
        this.f15769r.g(n0Var, this, this.f15762k.b(this.I));
        this.f15763l.n(new r(n0Var.f15740j), 1, -1, (a0) null, 0, (Object) null, n0Var.f15739i, this.G);
    }

    public final long B(long j10) {
        boolean z10;
        i();
        boolean[] zArr = this.E.f15755b;
        if (!this.F.f()) {
            j10 = 0;
        }
        this.K = false;
        this.N = j10;
        if (s()) {
            this.O = j10;
            return j10;
        }
        if (this.I != 7) {
            int length = this.f15777z.length;
            int i10 = 0;
            while (true) {
                if (i10 >= length) {
                    z10 = true;
                    break;
                } else if (this.f15777z[i10].A(j10, false) || (!zArr[i10] && this.D)) {
                    i10++;
                }
            }
            z10 = false;
            if (z10) {
                return j10;
            }
        }
        this.P = false;
        this.O = j10;
        this.R = false;
        a2.q qVar = this.f15769r;
        if (qVar.d()) {
            for (a1 i11 : this.f15777z) {
                i11.i();
            }
            qVar.a();
        } else {
            qVar.f76c = null;
            for (a1 x10 : this.f15777z) {
                x10.x(false);
            }
        }
        return j10;
    }

    public final boolean C(long j10) {
        if (this.R) {
            return false;
        }
        a2.q qVar = this.f15769r;
        if (qVar.c() || this.P) {
            return false;
        }
        if (this.C && this.L == 0) {
            return false;
        }
        boolean b10 = this.f15771t.b();
        if (qVar.d()) {
            return b10;
        }
        A();
        return true;
    }

    public final void D(long j10) {
    }

    public final boolean E() {
        return this.K || s();
    }

    public final void a() {
        this.B = true;
        this.f15774w.post(this.f15772u);
    }

    public final void b() {
        for (a1 a1Var : this.f15777z) {
            a1Var.x(true);
            n nVar = a1Var.f15570h;
            if (nVar != null) {
                nVar.d(a1Var.f15567e);
                a1Var.f15570h = null;
                a1Var.f15569g = null;
            }
        }
        this.f15770s.I();
    }

    public final boolean c() {
        boolean z10;
        if (this.f15769r.d()) {
            g gVar = this.f15771t;
            synchronized (gVar) {
                z10 = gVar.f8430a;
            }
            if (z10) {
                return true;
            }
        }
        return false;
    }

    public final x0 d(int i10, int i11) {
        return z(new p0(i10, false));
    }

    public final void e() {
        this.f15774w.post(this.f15772u);
    }

    public final long f(long j10, p1 p1Var) {
        i();
        if (!this.F.f()) {
            return 0;
        }
        t0 i10 = this.F.i(j10);
        return p1Var.a(j10, i10.f4297a.f4301a, i10.f4298b.f4301a);
    }

    public final void g(u0 u0Var) {
        this.f15774w.post(new g.r0(this, 14, u0Var));
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00c0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final a2.k h(a2.n r17, long r18, long r20, java.io.IOException r22, int r23) {
        /*
            r16 = this;
            r0 = r16
            r12 = r22
            r1 = r17
            v1.n0 r1 = (v1.n0) r1
            k1.e0 r2 = r1.f15732b
            v1.r r3 = new v1.r
            android.net.Uri r2 = r2.f8992c
            r3.<init>()
            long r4 = r1.f15739i
            j1.l0.Q(r4)
            long r4 = r0.G
            j1.l0.Q(r4)
            a2.i r2 = r0.f15762k
            r2.getClass()
            boolean r2 = r12 instanceof g1.b1
            r4 = 0
            r5 = 1
            r6 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r2 != 0) goto L_0x0060
            boolean r2 = r12 instanceof java.io.FileNotFoundException
            if (r2 != 0) goto L_0x0060
            boolean r2 = r12 instanceof k1.w
            if (r2 != 0) goto L_0x0060
            boolean r2 = r12 instanceof a2.p
            if (r2 != 0) goto L_0x0060
            int r2 = k1.i.f9006i
            r2 = r12
        L_0x003a:
            if (r2 == 0) goto L_0x0050
            boolean r8 = r2 instanceof k1.i
            if (r8 == 0) goto L_0x004b
            r8 = r2
            k1.i r8 = (k1.i) r8
            int r8 = r8.f9007h
            r9 = 2008(0x7d8, float:2.814E-42)
            if (r8 != r9) goto L_0x004b
            r2 = 1
            goto L_0x0051
        L_0x004b:
            java.lang.Throwable r2 = r2.getCause()
            goto L_0x003a
        L_0x0050:
            r2 = 0
        L_0x0051:
            if (r2 == 0) goto L_0x0054
            goto L_0x0060
        L_0x0054:
            int r2 = r23 + -1
            int r2 = r2 * 1000
            r8 = 5000(0x1388, float:7.006E-42)
            int r2 = java.lang.Math.min(r2, r8)
            long r8 = (long) r2
            goto L_0x0061
        L_0x0060:
            r8 = r6
        L_0x0061:
            int r2 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r2 != 0) goto L_0x0069
            a2.k r2 = a2.q.f73f
        L_0x0067:
            r14 = r2
            goto L_0x00c3
        L_0x0069:
            int r2 = r16.q()
            int r10 = r0.Q
            if (r2 <= r10) goto L_0x0073
            r10 = 1
            goto L_0x0074
        L_0x0073:
            r10 = 0
        L_0x0074:
            boolean r11 = r0.M
            if (r11 != 0) goto L_0x00b6
            d2.u0 r11 = r0.F
            if (r11 == 0) goto L_0x0085
            long r13 = r11.j()
            int r11 = (r13 > r6 ? 1 : (r13 == r6 ? 0 : -1))
            if (r11 == 0) goto L_0x0085
            goto L_0x00b6
        L_0x0085:
            boolean r2 = r0.C
            if (r2 == 0) goto L_0x0093
            boolean r2 = r16.E()
            if (r2 != 0) goto L_0x0093
            r0.P = r5
            r2 = 0
            goto L_0x00b9
        L_0x0093:
            boolean r2 = r0.C
            r0.K = r2
            r6 = 0
            r0.N = r6
            r0.Q = r4
            v1.a1[] r2 = r0.f15777z
            int r11 = r2.length
            r13 = 0
        L_0x00a1:
            if (r13 >= r11) goto L_0x00ab
            r14 = r2[r13]
            r14.x(r4)
            int r13 = r13 + 1
            goto L_0x00a1
        L_0x00ab:
            d2.s0 r2 = r1.f15736f
            r2.f4296a = r6
            r1.f15739i = r6
            r1.f15738h = r5
            r1.f15742l = r4
            goto L_0x00b8
        L_0x00b6:
            r0.Q = r2
        L_0x00b8:
            r2 = 1
        L_0x00b9:
            if (r2 == 0) goto L_0x00c0
            a2.k r2 = a2.q.b(r8, r10)
            goto L_0x0067
        L_0x00c0:
            a2.k r2 = a2.q.f72e
            goto L_0x0067
        L_0x00c3:
            int r2 = r14.f59a
            if (r2 == 0) goto L_0x00c9
            if (r2 != r5) goto L_0x00ca
        L_0x00c9:
            r4 = 1
        L_0x00ca:
            r13 = r4 ^ 1
            v1.f0 r2 = r0.f15763l
            r4 = 1
            r5 = -1
            r6 = 0
            r7 = 0
            long r8 = r1.f15739i
            long r10 = r0.G
            r15 = 0
            r1 = r2
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r15
            r12 = r22
            r1.j(r2, r3, r4, r5, r6, r7, r8, r10, r12, r13)
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: v1.r0.h(a2.n, long, long, java.io.IOException, int):a2.k");
    }

    public final void i() {
        a.e(this.C);
        this.E.getClass();
        this.F.getClass();
    }

    public final long j() {
        return u();
    }

    public final long k() {
        if (!this.K) {
            return -9223372036854775807L;
        }
        if (!this.R && q() <= this.Q) {
            return -9223372036854775807L;
        }
        this.K = false;
        return this.N;
    }

    public final void l(a2.n nVar, long j10, long j11, boolean z10) {
        n0 n0Var = (n0) nVar;
        Uri uri = n0Var.f15732b.f8992c;
        r rVar = new r();
        this.f15762k.getClass();
        this.f15763l.e(rVar, 1, -1, (a0) null, 0, (Object) null, n0Var.f15739i, this.G);
        if (!z10) {
            for (a1 x10 : this.f15777z) {
                x10.x(false);
            }
            if (this.L > 0) {
                x xVar = this.f15775x;
                xVar.getClass();
                xVar.r(this);
            }
        }
    }

    public final void m(x xVar, long j10) {
        this.f15775x = xVar;
        this.f15771t.b();
        A();
    }

    public final void n(a2.n nVar, long j10, long j11) {
        u0 u0Var;
        long j12;
        n0 n0Var = (n0) nVar;
        if (this.G == -9223372036854775807L && (u0Var = this.F) != null) {
            boolean f10 = u0Var.f();
            long r10 = r(true);
            if (r10 == Long.MIN_VALUE) {
                j12 = 0;
            } else {
                j12 = r10 + 10000;
            }
            this.G = j12;
            this.f15765n.t(j12, f10, this.H);
        }
        Uri uri = n0Var.f15732b.f8992c;
        r rVar = new r();
        this.f15762k.getClass();
        this.f15763l.h(rVar, 1, -1, (a0) null, 0, (Object) null, n0Var.f15739i, this.G);
        this.R = true;
        x xVar = this.f15775x;
        xVar.getClass();
        xVar.r(this);
    }

    public final l1 o() {
        i();
        return this.E.f15754a;
    }

    public final long p(s[] sVarArr, boolean[] zArr, b1[] b1VarArr, boolean[] zArr2, long j10) {
        boolean[] zArr3;
        boolean z10;
        s sVar;
        boolean z11;
        boolean z12;
        i();
        q0 q0Var = this.E;
        l1 l1Var = q0Var.f15754a;
        int i10 = this.L;
        int i11 = 0;
        int i12 = 0;
        while (true) {
            int length = sVarArr.length;
            zArr3 = q0Var.f15756c;
            if (i12 >= length) {
                break;
            }
            o0 o0Var = b1VarArr[i12];
            if (o0Var != null && (sVarArr[i12] == null || !zArr[i12])) {
                int i13 = o0Var.f15744a;
                a.e(zArr3[i13]);
                this.L--;
                zArr3[i13] = false;
                b1VarArr[i12] = null;
            }
            i12++;
        }
        if (!this.J ? j10 == 0 : i10 != 0) {
            z10 = false;
        } else {
            z10 = true;
        }
        for (int i14 = 0; i14 < sVarArr.length; i14++) {
            if (b1VarArr[i14] == null && (sVar = sVarArr[i14]) != null) {
                if (sVar.length() == 1) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                a.e(z11);
                if (sVar.g(0) == 0) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                a.e(z12);
                int j11 = l1Var.j(sVar.l());
                a.e(!zArr3[j11]);
                this.L++;
                zArr3[j11] = true;
                b1VarArr[i14] = new o0(this, j11);
                zArr2[i14] = true;
                if (!z10) {
                    a1 a1Var = this.f15777z[j11];
                    if (a1Var.A(j10, true) || a1Var.f15579q + a1Var.f15581s == 0) {
                        z10 = false;
                    } else {
                        z10 = true;
                    }
                }
            }
        }
        if (this.L == 0) {
            this.P = false;
            this.K = false;
            a2.q qVar = this.f15769r;
            if (qVar.d()) {
                a1[] a1VarArr = this.f15777z;
                int length2 = a1VarArr.length;
                while (i11 < length2) {
                    a1VarArr[i11].i();
                    i11++;
                }
                qVar.a();
            } else {
                for (a1 x10 : this.f15777z) {
                    x10.x(false);
                }
            }
        } else if (z10) {
            j10 = B(j10);
            while (i11 < b1VarArr.length) {
                if (b1VarArr[i11] != null) {
                    zArr2[i11] = true;
                }
                i11++;
            }
        }
        this.J = true;
        return j10;
    }

    public final int q() {
        int i10 = 0;
        for (a1 a1Var : this.f15777z) {
            i10 += a1Var.f15579q + a1Var.f15578p;
        }
        return i10;
    }

    public final long r(boolean z10) {
        long j10 = Long.MIN_VALUE;
        for (int i10 = 0; i10 < this.f15777z.length; i10++) {
            if (!z10) {
                q0 q0Var = this.E;
                q0Var.getClass();
                if (!q0Var.f15756c[i10]) {
                }
            }
            j10 = Math.max(j10, this.f15777z[i10].m());
        }
        return j10;
    }

    public final boolean s() {
        return this.O != -9223372036854775807L;
    }

    public final void t() {
        boolean z10;
        int i10;
        z0 z0Var;
        if (!this.S && !this.C && this.B && this.F != null) {
            a1[] a1VarArr = this.f15777z;
            int length = a1VarArr.length;
            int i11 = 0;
            while (i11 < length) {
                if (a1VarArr[i11].r() != null) {
                    i11++;
                } else {
                    return;
                }
            }
            this.f15771t.a();
            int length2 = this.f15777z.length;
            v1[] v1VarArr = new v1[length2];
            boolean[] zArr = new boolean[length2];
            for (int i12 = 0; i12 < length2; i12++) {
                a0 r10 = this.f15777z[i12].r();
                r10.getClass();
                String str = r10.f6276s;
                boolean i13 = a1.i(str);
                if (i13 || a1.k(str)) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                zArr[i12] = z10;
                this.D = z10 | this.D;
                c cVar = this.f15776y;
                if (cVar != null) {
                    if (i13 || this.A[i12].f15748b) {
                        z0 z0Var2 = r10.f6274q;
                        if (z0Var2 == null) {
                            z0Var = new z0(cVar);
                        } else {
                            int i14 = l0.f8453a;
                            y0[] y0VarArr = z0Var2.f6770h;
                            Object[] copyOf = Arrays.copyOf(y0VarArr, y0VarArr.length + 1);
                            System.arraycopy(new y0[]{cVar}, 0, copyOf, y0VarArr.length, 1);
                            z0Var = new z0(z0Var2.f6771i, (y0[]) copyOf);
                        }
                        z zVar = new z(r10);
                        zVar.f6752i = z0Var;
                        r10 = new a0(zVar);
                    }
                    if (i13 && r10.f6270m == -1 && r10.f6271n == -1 && (i10 = cVar.f11025h) != -1) {
                        z zVar2 = new z(r10);
                        zVar2.f6749f = i10;
                        r10 = new a0(zVar2);
                    }
                }
                int b10 = this.f15761j.b(r10);
                z i15 = r10.i();
                i15.F = b10;
                a0 a10 = i15.a();
                v1VarArr[i12] = new v1(Integer.toString(i12), a10);
            }
            this.E = new q0(new l1(v1VarArr), zArr);
            this.C = true;
            x xVar = this.f15775x;
            xVar.getClass();
            xVar.h(this);
        }
    }

    public final long u() {
        long j10;
        boolean z10;
        i();
        if (this.R || this.L == 0) {
            return Long.MIN_VALUE;
        }
        if (s()) {
            return this.O;
        }
        if (this.D) {
            int length = this.f15777z.length;
            j10 = Long.MAX_VALUE;
            for (int i10 = 0; i10 < length; i10++) {
                q0 q0Var = this.E;
                if (q0Var.f15755b[i10] && q0Var.f15756c[i10]) {
                    a1 a1Var = this.f15777z[i10];
                    synchronized (a1Var) {
                        z10 = a1Var.f15585w;
                    }
                    if (!z10) {
                        j10 = Math.min(j10, this.f15777z[i10].m());
                    }
                }
            }
        } else {
            j10 = Long.MAX_VALUE;
        }
        if (j10 == Long.MAX_VALUE) {
            j10 = r(false);
        }
        if (j10 == Long.MIN_VALUE) {
            return this.N;
        }
        return j10;
    }

    public final void v() {
        int b10 = this.f15762k.b(this.I);
        a2.q qVar = this.f15769r;
        IOException iOException = qVar.f76c;
        if (iOException == null) {
            m mVar = qVar.f75b;
            if (mVar != null) {
                if (b10 == Integer.MIN_VALUE) {
                    b10 = mVar.f61h;
                }
                IOException iOException2 = mVar.f65l;
                if (iOException2 != null && mVar.f66m > b10) {
                    throw iOException2;
                }
            }
            if (this.R && !this.C) {
                throw b1.a("Loading finished before preparation is complete.", (Exception) null);
            }
            return;
        }
        throw iOException;
    }

    public final void w(int i10) {
        i();
        q0 q0Var = this.E;
        boolean[] zArr = q0Var.f15757d;
        if (!zArr[i10]) {
            a0 a0Var = q0Var.f15754a.i(i10).f6676k[0];
            this.f15763l.b(a1.h(a0Var.f6276s), a0Var, 0, (Object) null, this.N);
            zArr[i10] = true;
        }
    }

    public final void x(int i10) {
        i();
        boolean[] zArr = this.E.f15755b;
        if (this.P && zArr[i10] && !this.f15777z[i10].s(false)) {
            this.O = 0;
            this.P = false;
            this.K = true;
            this.N = 0;
            this.Q = 0;
            for (a1 x10 : this.f15777z) {
                x10.x(false);
            }
            x xVar = this.f15775x;
            xVar.getClass();
            xVar.r(this);
        }
    }

    public final void y(long j10, boolean z10) {
        i();
        if (!s()) {
            boolean[] zArr = this.E.f15756c;
            int length = this.f15777z.length;
            for (int i10 = 0; i10 < length; i10++) {
                this.f15777z[i10].h(j10, z10, zArr[i10]);
            }
        }
    }

    public final a1 z(p0 p0Var) {
        int length = this.f15777z.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (p0Var.equals(this.A[i10])) {
                return this.f15777z[i10];
            }
        }
        u uVar = this.f15761j;
        uVar.getClass();
        q qVar = this.f15764m;
        qVar.getClass();
        a1 a1Var = new a1(this.f15766o, uVar, qVar);
        a1Var.f15568f = this;
        int i11 = length + 1;
        p0[] p0VarArr = (p0[]) Arrays.copyOf(this.A, i11);
        p0VarArr[length] = p0Var;
        this.A = p0VarArr;
        a1[] a1VarArr = (a1[]) Arrays.copyOf(this.f15777z, i11);
        a1VarArr[length] = a1Var;
        this.f15777z = a1VarArr;
        return a1Var;
    }
}
