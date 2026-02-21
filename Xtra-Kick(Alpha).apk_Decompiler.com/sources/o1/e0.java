package o1;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.media.n;
import android.support.v4.media.session.u;
import e.a;
import g.r0;
import g1.a0;
import g1.a1;
import g1.e1;
import g1.h;
import g1.i;
import h1.c;
import j1.d;
import j1.d0;
import j1.g;
import j1.l0;
import j1.v;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import n0.f;
import n1.f0;

public final class e0 implements m {

    /* renamed from: d0  reason: collision with root package name */
    public static final Object f11874d0 = new Object();

    /* renamed from: e0  reason: collision with root package name */
    public static ExecutorService f11875e0;

    /* renamed from: f0  reason: collision with root package name */
    public static int f11876f0;
    public int A;
    public long B;
    public long C;
    public long D;
    public long E;
    public int F;
    public boolean G;
    public boolean H;
    public long I;
    public float J;
    public c[] K;
    public ByteBuffer[] L;
    public ByteBuffer M;
    public int N;
    public ByteBuffer O;
    public byte[] P;
    public int Q;
    public int R;
    public boolean S;
    public boolean T;
    public boolean U;
    public boolean V;
    public int W;
    public i X;
    public u Y;
    public boolean Z;

    /* renamed from: a  reason: collision with root package name */
    public final b f11877a;

    /* renamed from: a0  reason: collision with root package name */
    public long f11878a0;

    /* renamed from: b  reason: collision with root package name */
    public final u f11879b;

    /* renamed from: b0  reason: collision with root package name */
    public boolean f11880b0;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f11881c;

    /* renamed from: c0  reason: collision with root package name */
    public boolean f11882c0;

    /* renamed from: d  reason: collision with root package name */
    public final r f11883d;

    /* renamed from: e  reason: collision with root package name */
    public final o0 f11884e;

    /* renamed from: f  reason: collision with root package name */
    public final c[] f11885f;

    /* renamed from: g  reason: collision with root package name */
    public final c[] f11886g;

    /* renamed from: h  reason: collision with root package name */
    public final g f11887h;

    /* renamed from: i  reason: collision with root package name */
    public final p f11888i;

    /* renamed from: j  reason: collision with root package name */
    public final ArrayDeque f11889j;

    /* renamed from: k  reason: collision with root package name */
    public final boolean f11890k;

    /* renamed from: l  reason: collision with root package name */
    public final int f11891l;

    /* renamed from: m  reason: collision with root package name */
    public d0 f11892m;

    /* renamed from: n  reason: collision with root package name */
    public final z f11893n;

    /* renamed from: o  reason: collision with root package name */
    public final z f11894o;

    /* renamed from: p  reason: collision with root package name */
    public final g0 f11895p;

    /* renamed from: q  reason: collision with root package name */
    public f0 f11896q;

    /* renamed from: r  reason: collision with root package name */
    public a f11897r;

    /* renamed from: s  reason: collision with root package name */
    public x f11898s;

    /* renamed from: t  reason: collision with root package name */
    public x f11899t;

    /* renamed from: u  reason: collision with root package name */
    public AudioTrack f11900u;

    /* renamed from: v  reason: collision with root package name */
    public h f11901v;

    /* renamed from: w  reason: collision with root package name */
    public y f11902w;

    /* renamed from: x  reason: collision with root package name */
    public y f11903x;

    /* renamed from: y  reason: collision with root package name */
    public e1 f11904y;

    /* renamed from: z  reason: collision with root package name */
    public ByteBuffer f11905z;

    public e0(w wVar) {
        boolean z10;
        boolean z11;
        int i10;
        this.f11877a = wVar.f12041a;
        u uVar = wVar.f12042b;
        this.f11879b = uVar;
        int i11 = l0.f8453a;
        if (i11 < 21 || !wVar.f12043c) {
            z10 = false;
        } else {
            z10 = true;
        }
        this.f11881c = z10;
        if (i11 < 23 || !wVar.f12044d) {
            z11 = false;
        } else {
            z11 = true;
        }
        this.f11890k = z11;
        if (i11 >= 29) {
            i10 = wVar.f12045e;
        } else {
            i10 = 0;
        }
        this.f11891l = i10;
        this.f11895p = wVar.f12046f;
        d0 d0Var = d.f8420a;
        g gVar = new g(0);
        this.f11887h = gVar;
        gVar.b();
        this.f11888i = new p(new a0(this));
        r rVar = new r();
        this.f11883d = rVar;
        o0 o0Var = new o0();
        this.f11884e = o0Var;
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, new q[]{new k0(), rVar, o0Var});
        Collections.addAll(arrayList, (c[]) uVar.f428i);
        this.f11885f = (c[]) arrayList.toArray(new c[0]);
        this.f11886g = new c[]{new h0()};
        this.J = 1.0f;
        this.f11901v = h.f6386n;
        this.W = 0;
        this.X = new i();
        e1 e1Var = e1.f6351k;
        this.f11903x = new y(e1Var, false, 0, 0);
        this.f11904y = e1Var;
        this.R = -1;
        this.K = new c[0];
        this.L = new ByteBuffer[0];
        this.f11889j = new ArrayDeque();
        this.f11893n = new z();
        this.f11894o = new z();
    }

    public static AudioFormat e(int i10, int i11, int i12) {
        return new AudioFormat.Builder().setSampleRate(i10).setChannelMask(i11).setEncoding(i12).build();
    }

    public static boolean n(AudioTrack audioTrack) {
        return l0.f8453a >= 29 && audioTrack.isOffloadedPlayback();
    }

    public final void a(long j10) {
        e1 e1Var;
        boolean z10;
        boolean u10 = u();
        u uVar = this.f11879b;
        if (u10) {
            e1Var = g().f12056a;
            n0 n0Var = (n0) uVar.f430k;
            float f10 = e1Var.f6355h;
            if (n0Var.f11977c != f10) {
                n0Var.f11977c = f10;
                n0Var.f11983i = true;
            }
            float f11 = n0Var.f11978d;
            float f12 = e1Var.f6356i;
            if (f11 != f12) {
                n0Var.f11978d = f12;
                n0Var.f11983i = true;
            }
        } else {
            e1Var = e1.f6351k;
        }
        e1 e1Var2 = e1Var;
        int i10 = 0;
        if (u()) {
            z10 = g().f12057b;
            ((l0) uVar.f429j).f11941m = z10;
        } else {
            z10 = false;
        }
        this.f11889j.add(new y(e1Var2, z10, Math.max(0, j10), (i() * 1000000) / ((long) this.f11899t.f12051e)));
        c[] cVarArr = this.f11899t.f12055i;
        ArrayList arrayList = new ArrayList();
        for (c cVar : cVarArr) {
            if (cVar.c()) {
                arrayList.add(cVar);
            } else {
                cVar.flush();
            }
        }
        int size = arrayList.size();
        this.K = (c[]) arrayList.toArray(new c[size]);
        this.L = new ByteBuffer[size];
        while (true) {
            c[] cVarArr2 = this.K;
            if (i10 >= cVarArr2.length) {
                break;
            }
            c cVar2 = cVarArr2[i10];
            cVar2.flush();
            this.L[i10] = cVar2.a();
            i10++;
        }
        a aVar = this.f11897r;
        if (aVar != null) {
            n nVar = ((j0) aVar.f4852i).K0;
            Handler handler = (Handler) nVar.f337i;
            if (handler != null) {
                handler.post(new g(nVar, z10));
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:88:0x0156, code lost:
        if ((r4 & r5) != false) goto L_0x0161;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x0159, code lost:
        if (r21 > 0) goto L_0x0161;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x015c, code lost:
        if (r2 > 0) goto L_0x0161;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x015f, code lost:
        if (r2 < 0) goto L_0x0161;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x0161, code lost:
        r4 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x016a, code lost:
        r4 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x016b, code lost:
        if (r4 == false) goto L_0x017b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x016d, code lost:
        r6 = r6 + r2;
     */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0072  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(g1.a0 r25, int[] r26) {
        /*
            r24 = this;
            r1 = r24
            r3 = r25
            java.lang.String r0 = r3.f6276s
            java.lang.String r2 = "audio/raw"
            boolean r0 = r2.equals(r0)
            r2 = 2
            r4 = 8
            r5 = -1
            r6 = 0
            r7 = 1
            int r8 = r3.G
            int r9 = r3.F
            if (r0 == 0) goto L_0x009a
            int r0 = r3.H
            boolean r10 = j1.l0.D(r0)
            j1.a.b(r10)
            int r10 = j1.l0.u(r0, r9)
            boolean r11 = r1.f11881c
            if (r11 == 0) goto L_0x003c
            r11 = 536870912(0x20000000, float:1.0842022E-19)
            if (r0 == r11) goto L_0x0037
            r11 = 805306368(0x30000000, float:4.656613E-10)
            if (r0 == r11) goto L_0x0037
            r11 = 4
            if (r0 != r11) goto L_0x0035
            goto L_0x0037
        L_0x0035:
            r11 = 0
            goto L_0x0038
        L_0x0037:
            r11 = 1
        L_0x0038:
            if (r11 == 0) goto L_0x003c
            r11 = 1
            goto L_0x003d
        L_0x003c:
            r11 = 0
        L_0x003d:
            if (r11 == 0) goto L_0x0042
            h1.c[] r11 = r1.f11886g
            goto L_0x0044
        L_0x0042:
            h1.c[] r11 = r1.f11885f
        L_0x0044:
            int r12 = r3.I
            o1.o0 r13 = r1.f11884e
            r13.f11997i = r12
            int r12 = r3.J
            r13.f11998j = r12
            int r12 = j1.l0.f8453a
            r13 = 21
            if (r12 >= r13) goto L_0x0063
            if (r9 != r4) goto L_0x0063
            if (r26 != 0) goto L_0x0063
            r12 = 6
            int[] r13 = new int[r12]
            r14 = 0
        L_0x005c:
            if (r14 >= r12) goto L_0x0065
            r13[r14] = r14
            int r14 = r14 + 1
            goto L_0x005c
        L_0x0063:
            r13 = r26
        L_0x0065:
            o1.r r12 = r1.f11883d
            r12.f12037i = r13
            h1.a r12 = new h1.a
            r12.<init>(r8, r9, r0)
            int r0 = r11.length
            r8 = 0
        L_0x0070:
            if (r8 >= r0) goto L_0x0089
            r9 = r11[r8]
            h1.a r13 = r9.f(r12)     // Catch:{ b -> 0x0082 }
            boolean r9 = r9.c()     // Catch:{ b -> 0x0082 }
            if (r9 == 0) goto L_0x007f
            r12 = r13
        L_0x007f:
            int r8 = r8 + 1
            goto L_0x0070
        L_0x0082:
            r0 = move-exception
            o1.i r2 = new o1.i
            r2.<init>((h1.b) r0, (g1.a0) r3)
            throw r2
        L_0x0089:
            int r0 = r12.f6880c
            int r8 = r12.f6879b
            int r9 = j1.l0.m(r8)
            int r8 = j1.l0.u(r0, r8)
            int r12 = r12.f6878a
            r13 = r11
            r11 = 0
            goto L_0x00d3
        L_0x009a:
            h1.c[] r0 = new h1.c[r6]
            g1.h r10 = r1.f11901v
            boolean r10 = r1.v(r10, r3)
            if (r10 == 0) goto L_0x00b5
            java.lang.String r10 = r3.f6276s
            r10.getClass()
            java.lang.String r11 = r3.f6273p
            int r10 = g1.a1.c(r10, r11)
            int r9 = j1.l0.m(r9)
            r11 = 1
            goto L_0x00ce
        L_0x00b5:
            o1.b r9 = r1.f11877a
            android.util.Pair r9 = r9.a(r3)
            if (r9 == 0) goto L_0x0231
            java.lang.Object r10 = r9.first
            java.lang.Integer r10 = (java.lang.Integer) r10
            int r10 = r10.intValue()
            java.lang.Object r9 = r9.second
            java.lang.Integer r9 = (java.lang.Integer) r9
            int r9 = r9.intValue()
            r11 = 2
        L_0x00ce:
            r13 = r0
            r12 = r8
            r0 = r10
            r8 = -1
            r10 = -1
        L_0x00d3:
            java.lang.String r14 = ") for: "
            if (r0 == 0) goto L_0x0217
            if (r9 == 0) goto L_0x01fd
            int r14 = android.media.AudioTrack.getMinBufferSize(r12, r9, r0)
            r15 = -2
            if (r14 == r15) goto L_0x00e2
            r15 = 1
            goto L_0x00e3
        L_0x00e2:
            r15 = 0
        L_0x00e3:
            j1.a.e(r15)
            if (r8 == r5) goto L_0x00ea
            r15 = r8
            goto L_0x00eb
        L_0x00ea:
            r15 = 1
        L_0x00eb:
            boolean r6 = r1.f11890k
            if (r6 == 0) goto L_0x00f2
            r16 = 4620693217682128896(0x4020000000000000, double:8.0)
            goto L_0x00f4
        L_0x00f2:
            r16 = 4607182418800017408(0x3ff0000000000000, double:1.0)
        L_0x00f4:
            o1.g0 r6 = r1.f11895p
            r6.getClass()
            r18 = 1000000(0xf4240, double:4.940656E-318)
            if (r11 == 0) goto L_0x01a3
            if (r11 == r7) goto L_0x018c
            if (r11 != r2) goto L_0x0186
            r2 = 5
            int r7 = r6.f11922e
            if (r0 != r2) goto L_0x010b
            int r2 = r6.f11924g
            int r7 = r7 * r2
        L_0x010b:
            int r2 = r3.f6272o
            if (r2 == r5) goto L_0x0177
            java.math.RoundingMode r5 = java.math.RoundingMode.CEILING
            r5.getClass()
            int r6 = r2 / 8
            int r21 = r6 * 8
            int r21 = r2 - r21
            if (r21 != 0) goto L_0x011d
            goto L_0x017b
        L_0x011d:
            r2 = r2 ^ r4
            int r2 = r2 >> 31
            r20 = 1
            r2 = r2 | 1
            int[] r22 = f9.a.f5983a
            int r23 = r5.ordinal()
            r22 = r22[r23]
            switch(r22) {
                case 1: goto L_0x0163;
                case 2: goto L_0x016a;
                case 3: goto L_0x015f;
                case 4: goto L_0x0161;
                case 5: goto L_0x015c;
                case 6: goto L_0x0135;
                case 7: goto L_0x0135;
                case 8: goto L_0x0135;
                default: goto L_0x012f;
            }
        L_0x012f:
            java.lang.AssertionError r0 = new java.lang.AssertionError
            r0.<init>()
            throw r0
        L_0x0135:
            int r21 = java.lang.Math.abs(r21)
            int r4 = java.lang.Math.abs(r4)
            int r4 = r4 - r21
            int r21 = r21 - r4
            if (r21 != 0) goto L_0x0159
            java.math.RoundingMode r4 = java.math.RoundingMode.HALF_UP
            if (r5 == r4) goto L_0x0161
            java.math.RoundingMode r4 = java.math.RoundingMode.HALF_EVEN
            if (r5 != r4) goto L_0x014d
            r4 = 1
            goto L_0x014e
        L_0x014d:
            r4 = 0
        L_0x014e:
            r5 = r6 & 1
            if (r5 == 0) goto L_0x0154
            r5 = 1
            goto L_0x0155
        L_0x0154:
            r5 = 0
        L_0x0155:
            r4 = r4 & r5
            if (r4 == 0) goto L_0x016a
            goto L_0x0161
        L_0x0159:
            if (r21 <= 0) goto L_0x016a
            goto L_0x0161
        L_0x015c:
            if (r2 <= 0) goto L_0x016a
            goto L_0x0161
        L_0x015f:
            if (r2 >= 0) goto L_0x016a
        L_0x0161:
            r4 = 1
            goto L_0x016b
        L_0x0163:
            if (r21 != 0) goto L_0x0167
            r4 = 1
            goto L_0x0168
        L_0x0167:
            r4 = 0
        L_0x0168:
            if (r4 == 0) goto L_0x016f
        L_0x016a:
            r4 = 0
        L_0x016b:
            if (r4 == 0) goto L_0x017b
            int r6 = r6 + r2
            goto L_0x017b
        L_0x016f:
            java.lang.ArithmeticException r0 = new java.lang.ArithmeticException
            java.lang.String r2 = "mode was UNNECESSARY, but rounding was necessary"
            r0.<init>(r2)
            throw r0
        L_0x0177:
            int r6 = o1.g0.a(r0)
        L_0x017b:
            long r4 = (long) r7
            long r6 = (long) r6
            long r4 = r4 * r6
            long r4 = r4 / r18
            int r2 = g9.b.a(r4)
            goto L_0x019c
        L_0x0186:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>()
            throw r0
        L_0x018c:
            int r2 = o1.g0.a(r0)
            int r4 = r6.f11923f
            long r4 = (long) r4
            long r6 = (long) r2
            long r4 = r4 * r6
            long r4 = r4 / r18
            int r2 = g9.b.a(r4)
        L_0x019c:
            r21 = r8
            r22 = r12
            r26 = r13
            goto L_0x01cd
        L_0x01a3:
            int r2 = r6.f11921d
            int r2 = r2 * r14
            int r4 = r6.f11919b
            long r4 = (long) r4
            r21 = r8
            long r7 = (long) r12
            long r4 = r4 * r7
            r22 = r12
            r26 = r13
            long r12 = (long) r15
            long r4 = r4 * r12
            long r4 = r4 / r18
            int r4 = g9.b.a(r4)
            int r5 = r6.f11920c
            long r5 = (long) r5
            long r5 = r5 * r7
            long r5 = r5 * r12
            long r5 = r5 / r18
            int r5 = g9.b.a(r5)
            int r2 = j1.l0.h(r2, r4, r5)
        L_0x01cd:
            double r4 = (double) r2
            double r4 = r4 * r16
            int r2 = (int) r4
            int r2 = java.lang.Math.max(r14, r2)
            int r2 = r2 + r15
            r4 = 1
            int r2 = r2 - r4
            int r2 = r2 / r15
            int r12 = r2 * r15
            r2 = 0
            r1.f11880b0 = r2
            o1.x r13 = new o1.x
            r2 = r13
            r3 = r25
            r4 = r10
            r5 = r11
            r6 = r21
            r7 = r22
            r8 = r9
            r9 = r0
            r10 = r12
            r11 = r26
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11)
            boolean r0 = r24.m()
            if (r0 == 0) goto L_0x01fa
            r1.f11898s = r13
            goto L_0x01fc
        L_0x01fa:
            r1.f11899t = r13
        L_0x01fc:
            return
        L_0x01fd:
            o1.i r0 = new o1.i
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r4 = "Invalid output channel config (mode="
            r2.<init>(r4)
            r2.append(r11)
            r2.append(r14)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r0.<init>((java.lang.String) r2, (g1.a0) r3)
            throw r0
        L_0x0217:
            o1.i r0 = new o1.i
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r4 = "Invalid output encoding (mode="
            r2.<init>(r4)
            r2.append(r11)
            r2.append(r14)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r0.<init>((java.lang.String) r2, (g1.a0) r3)
            throw r0
        L_0x0231:
            o1.i r0 = new o1.i
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r4 = "Unable to configure passthrough for: "
            r2.<init>(r4)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r0.<init>((java.lang.String) r2, (g1.a0) r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: o1.e0.b(g1.a0, int[]):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0018  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean c() {
        /*
            r9 = this;
            int r0 = r9.R
            r1 = 1
            r2 = 0
            r3 = -1
            if (r0 != r3) goto L_0x000b
            r9.R = r2
        L_0x0009:
            r0 = 1
            goto L_0x000c
        L_0x000b:
            r0 = 0
        L_0x000c:
            int r4 = r9.R
            h1.c[] r5 = r9.K
            int r6 = r5.length
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r4 >= r6) goto L_0x002f
            r4 = r5[r4]
            if (r0 == 0) goto L_0x001f
            r4.b()
        L_0x001f:
            r9.p(r7)
            boolean r0 = r4.d()
            if (r0 != 0) goto L_0x0029
            return r2
        L_0x0029:
            int r0 = r9.R
            int r0 = r0 + r1
            r9.R = r0
            goto L_0x0009
        L_0x002f:
            java.nio.ByteBuffer r0 = r9.O
            if (r0 == 0) goto L_0x003b
            r9.w(r0, r7)
            java.nio.ByteBuffer r0 = r9.O
            if (r0 == 0) goto L_0x003b
            return r2
        L_0x003b:
            r9.R = r3
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: o1.e0.c():boolean");
    }

    public final void d() {
        boolean z10;
        if (m()) {
            this.B = 0;
            this.C = 0;
            this.D = 0;
            this.E = 0;
            this.f11882c0 = false;
            this.F = 0;
            this.f11903x = new y(g().f12056a, g().f12057b, 0, 0);
            this.I = 0;
            this.f11902w = null;
            this.f11889j.clear();
            this.M = null;
            this.N = 0;
            this.O = null;
            this.T = false;
            this.S = false;
            this.R = -1;
            this.f11905z = null;
            this.A = 0;
            this.f11884e.f12003o = 0;
            int i10 = 0;
            while (true) {
                c[] cVarArr = this.K;
                if (i10 >= cVarArr.length) {
                    break;
                }
                c cVar = cVarArr[i10];
                cVar.flush();
                this.L[i10] = cVar.a();
                i10++;
            }
            AudioTrack audioTrack = this.f11888i.f12006c;
            audioTrack.getClass();
            if (audioTrack.getPlayState() == 3) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                this.f11900u.pause();
            }
            if (n(this.f11900u)) {
                d0 d0Var = this.f11892m;
                d0Var.getClass();
                this.f11900u.unregisterStreamEventCallback(d0Var.f11870b);
                d0Var.f11869a.removeCallbacksAndMessages((Object) null);
            }
            if (l0.f8453a < 21 && !this.V) {
                this.W = 0;
            }
            x xVar = this.f11898s;
            if (xVar != null) {
                this.f11899t = xVar;
                this.f11898s = null;
            }
            p pVar = this.f11888i;
            pVar.c();
            pVar.f12006c = null;
            pVar.f12009f = null;
            AudioTrack audioTrack2 = this.f11900u;
            g gVar = this.f11887h;
            gVar.a();
            synchronized (f11874d0) {
                try {
                    if (f11875e0 == null) {
                        f11875e0 = Executors.newSingleThreadExecutor(new androidx.emoji2.text.a("ExoPlayer:AudioTrackReleaseThread", 1));
                    }
                    f11876f0++;
                    f11875e0.execute(new r0(audioTrack2, 11, gVar));
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
            this.f11900u = null;
        }
        this.f11894o.f12060a = null;
        this.f11893n.f12060a = null;
    }

    public final int f(a0 a0Var) {
        boolean z10 = true;
        if ("audio/raw".equals(a0Var.f6276s)) {
            int i10 = a0Var.H;
            if (!l0.D(i10)) {
                v.g("DefaultAudioSink", "Invalid PCM encoding: " + i10);
                return 0;
            } else if (i10 == 2 || (this.f11881c && i10 == 4)) {
                return 2;
            } else {
                return 1;
            }
        } else if (!this.f11880b0 && v(this.f11901v, a0Var)) {
            return 2;
        } else {
            if (this.f11877a.a(a0Var) == null) {
                z10 = false;
            }
            if (z10) {
                return 2;
            }
            return 0;
        }
    }

    public final y g() {
        y yVar = this.f11902w;
        if (yVar != null) {
            return yVar;
        }
        ArrayDeque arrayDeque = this.f11889j;
        return !arrayDeque.isEmpty() ? (y) arrayDeque.getLast() : this.f11903x;
    }

    public final long h() {
        x xVar = this.f11899t;
        return xVar.f12049c == 0 ? this.B / ((long) xVar.f12048b) : this.C;
    }

    public final long i() {
        x xVar = this.f11899t;
        return xVar.f12049c == 0 ? this.D / ((long) xVar.f12050d) : this.E;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0105, code lost:
        if (r8.a() == 0) goto L_0x0107;
     */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0150 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0151  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean j(java.nio.ByteBuffer r25, long r26, int r28) {
        /*
            r24 = this;
            r1 = r24
            r0 = r25
            r2 = r26
            r4 = r28
            java.nio.ByteBuffer r5 = r1.M
            r6 = 1
            r7 = 0
            if (r5 == 0) goto L_0x0013
            if (r0 != r5) goto L_0x0011
            goto L_0x0013
        L_0x0011:
            r5 = 0
            goto L_0x0014
        L_0x0013:
            r5 = 1
        L_0x0014:
            j1.a.b(r5)
            o1.x r5 = r1.f11898s
            r8 = 0
            r9 = 3
            if (r5 == 0) goto L_0x008d
            boolean r5 = r24.c()
            if (r5 != 0) goto L_0x0024
            return r7
        L_0x0024:
            o1.x r5 = r1.f11898s
            o1.x r10 = r1.f11899t
            r5.getClass()
            int r11 = r10.f12049c
            int r12 = r5.f12049c
            if (r11 != r12) goto L_0x004b
            int r11 = r10.f12053g
            int r12 = r5.f12053g
            if (r11 != r12) goto L_0x004b
            int r11 = r10.f12051e
            int r12 = r5.f12051e
            if (r11 != r12) goto L_0x004b
            int r11 = r10.f12052f
            int r12 = r5.f12052f
            if (r11 != r12) goto L_0x004b
            int r10 = r10.f12050d
            int r5 = r5.f12050d
            if (r10 != r5) goto L_0x004b
            r5 = 1
            goto L_0x004c
        L_0x004b:
            r5 = 0
        L_0x004c:
            if (r5 != 0) goto L_0x005c
            r24.o()
            boolean r5 = r24.k()
            if (r5 == 0) goto L_0x0058
            return r7
        L_0x0058:
            r24.d()
            goto L_0x008a
        L_0x005c:
            o1.x r5 = r1.f11898s
            r1.f11899t = r5
            r1.f11898s = r8
            android.media.AudioTrack r5 = r1.f11900u
            boolean r5 = n(r5)
            if (r5 == 0) goto L_0x008a
            int r5 = r1.f11891l
            if (r5 == r9) goto L_0x008a
            android.media.AudioTrack r5 = r1.f11900u
            int r5 = r5.getPlayState()
            if (r5 != r9) goto L_0x007b
            android.media.AudioTrack r5 = r1.f11900u
            r5.setOffloadEndOfStream()
        L_0x007b:
            android.media.AudioTrack r5 = r1.f11900u
            o1.x r10 = r1.f11899t
            g1.a0 r10 = r10.f12047a
            int r11 = r10.I
            int r10 = r10.J
            r5.setOffloadDelayPadding(r11, r10)
            r1.f11882c0 = r6
        L_0x008a:
            r1.a(r2)
        L_0x008d:
            boolean r5 = r24.m()
            o1.z r10 = r1.f11893n
            if (r5 != 0) goto L_0x00a7
            boolean r5 = r24.l()     // Catch:{ j -> 0x009c }
            if (r5 != 0) goto L_0x00a7
            return r7
        L_0x009c:
            r0 = move-exception
            r2 = r0
            boolean r0 = r2.f11933i
            if (r0 != 0) goto L_0x00a6
            r10.a(r2)
            return r7
        L_0x00a6:
            throw r2
        L_0x00a7:
            r10.f12060a = r8
            boolean r5 = r1.H
            o1.p r8 = r1.f11888i
            r10 = 0
            if (r5 == 0) goto L_0x00e6
            long r12 = java.lang.Math.max(r10, r2)
            r1.I = r12
            r1.G = r7
            r1.H = r7
            boolean r5 = r1.f11890k
            if (r5 == 0) goto L_0x00ca
            int r5 = j1.l0.f8453a
            r12 = 23
            if (r5 < r12) goto L_0x00ca
            g1.e1 r5 = r1.f11904y
            r1.s(r5)
        L_0x00ca:
            r1.a(r2)
            boolean r5 = r1.U
            if (r5 == 0) goto L_0x00e6
            r1.U = r6
            boolean r5 = r24.m()
            if (r5 == 0) goto L_0x00e6
            o1.o r5 = r8.f12009f
            r5.getClass()
            r5.a()
            android.media.AudioTrack r5 = r1.f11900u
            r5.play()
        L_0x00e6:
            long r12 = r24.i()
            android.media.AudioTrack r5 = r8.f12006c
            r5.getClass()
            int r5 = r5.getPlayState()
            boolean r14 = r8.f12011h
            r15 = 2
            if (r14 == 0) goto L_0x0109
            if (r5 != r15) goto L_0x00fd
            r8.f12019p = r7
            goto L_0x0107
        L_0x00fd:
            if (r5 != r6) goto L_0x0109
            long r16 = r8.a()
            int r14 = (r16 > r10 ? 1 : (r16 == r10 ? 0 : -1))
            if (r14 != 0) goto L_0x0109
        L_0x0107:
            r5 = 0
            goto L_0x014e
        L_0x0109:
            boolean r10 = r8.f12019p
            boolean r11 = r8.b(r12)
            r8.f12019p = r11
            if (r10 == 0) goto L_0x014d
            if (r11 != 0) goto L_0x014d
            if (r5 == r6) goto L_0x014d
            int r5 = r8.f12008e
            long r10 = r8.f12012i
            long r19 = j1.l0.Q(r10)
            o1.a0 r10 = r8.f12004a
            o1.e0 r10 = r10.f11854a
            e.a r11 = r10.f11897r
            if (r11 == 0) goto L_0x014d
            long r11 = android.os.SystemClock.elapsedRealtime()
            long r13 = r10.f11878a0
            long r21 = r11 - r13
            e.a r10 = r10.f11897r
            java.lang.Object r10 = r10.f4852i
            o1.j0 r10 = (o1.j0) r10
            android.support.v4.media.n r10 = r10.K0
            java.lang.Object r11 = r10.f337i
            android.os.Handler r11 = (android.os.Handler) r11
            if (r11 == 0) goto L_0x014d
            o1.h r12 = new o1.h
            r23 = 0
            r16 = r12
            r17 = r10
            r18 = r5
            r16.<init>(r17, r18, r19, r21, r23)
            r11.post(r12)
        L_0x014d:
            r5 = 1
        L_0x014e:
            if (r5 != 0) goto L_0x0151
            return r7
        L_0x0151:
            java.nio.ByteBuffer r5 = r1.M
            if (r5 != 0) goto L_0x0381
            java.nio.ByteOrder r5 = r25.order()
            java.nio.ByteOrder r10 = java.nio.ByteOrder.LITTLE_ENDIAN
            if (r5 != r10) goto L_0x015f
            r5 = 1
            goto L_0x0160
        L_0x015f:
            r5 = 0
        L_0x0160:
            j1.a.b(r5)
            boolean r5 = r25.hasRemaining()
            if (r5 != 0) goto L_0x016a
            return r6
        L_0x016a:
            o1.x r5 = r1.f11899t
            int r10 = r5.f12049c
            r11 = 1000000(0xf4240, double:4.940656E-318)
            if (r10 == 0) goto L_0x02ee
            int r10 = r1.F
            if (r10 != 0) goto L_0x02ee
            r10 = 16
            r13 = -1
            int r5 = r5.f12053g
            r14 = -2
            switch(r5) {
                case 5: goto L_0x02ab;
                case 6: goto L_0x02ab;
                case 7: goto L_0x0258;
                case 8: goto L_0x0258;
                case 9: goto L_0x0233;
                case 10: goto L_0x022f;
                case 11: goto L_0x022b;
                case 12: goto L_0x022b;
                case 13: goto L_0x0180;
                case 14: goto L_0x01c6;
                case 15: goto L_0x01c2;
                case 16: goto L_0x022f;
                case 17: goto L_0x01a9;
                case 18: goto L_0x02ab;
                case 19: goto L_0x0180;
                case 20: goto L_0x018c;
                default: goto L_0x0180;
            }
        L_0x0180:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "Unexpected audio encoding: "
            java.lang.String r2 = android.support.v4.media.h.i(r2, r5)
            r0.<init>(r2)
            throw r0
        L_0x018c:
            byte r5 = r0.get(r7)
            int r7 = r25.limit()
            if (r7 <= r6) goto L_0x019b
            byte r7 = r0.get(r6)
            goto L_0x019c
        L_0x019b:
            r7 = 0
        L_0x019c:
            long r9 = d2.q0.b(r5, r7)
            r13 = 48000(0xbb80, double:2.3715E-319)
            long r9 = r9 * r13
            long r9 = r9 / r11
            int r5 = (int) r9
            goto L_0x02e9
        L_0x01a9:
            byte[] r5 = new byte[r10]
            int r7 = r25.position()
            r0.get(r5)
            r0.position(r7)
            j1.a0 r7 = new j1.a0
            r7.<init>(r10, r5)
            b2.e r5 = d2.d.b(r7)
            int r5 = r5.f2430c
            goto L_0x02e9
        L_0x01c2:
            r5 = 512(0x200, float:7.175E-43)
            goto L_0x02e9
        L_0x01c6:
            int r5 = r25.position()
            int r7 = r25.limit()
            int r7 = r7 + -10
            r9 = r5
        L_0x01d1:
            if (r9 > r7) goto L_0x01f4
            int r10 = r9 + 4
            int r11 = j1.l0.f8453a
            int r10 = r0.getInt(r10)
            java.nio.ByteOrder r11 = r25.order()
            java.nio.ByteOrder r12 = java.nio.ByteOrder.BIG_ENDIAN
            if (r11 != r12) goto L_0x01e4
            goto L_0x01e8
        L_0x01e4:
            int r10 = java.lang.Integer.reverseBytes(r10)
        L_0x01e8:
            r10 = r10 & -2
            r11 = -126718022(0xfffffffff8726fba, float:-1.966878E34)
            if (r10 != r11) goto L_0x01f1
            int r9 = r9 - r5
            goto L_0x01f5
        L_0x01f1:
            int r9 = r9 + 1
            goto L_0x01d1
        L_0x01f4:
            r9 = -1
        L_0x01f5:
            if (r9 != r13) goto L_0x01fa
            r5 = 0
            goto L_0x02e9
        L_0x01fa:
            int r5 = r25.position()
            int r5 = r5 + r9
            int r5 = r5 + 7
            byte r5 = r0.get(r5)
            r5 = r5 & 255(0xff, float:3.57E-43)
            r7 = 187(0xbb, float:2.62E-43)
            if (r5 != r7) goto L_0x020d
            r5 = 1
            goto L_0x020e
        L_0x020d:
            r5 = 0
        L_0x020e:
            int r7 = r25.position()
            int r7 = r7 + r9
            if (r5 == 0) goto L_0x0218
            r5 = 9
            goto L_0x021a
        L_0x0218:
            r5 = 8
        L_0x021a:
            int r7 = r7 + r5
            byte r5 = r0.get(r7)
            int r5 = r5 >> 4
            r5 = r5 & 7
            r7 = 40
            int r5 = r7 << r5
            int r5 = r5 * 16
            goto L_0x02e9
        L_0x022b:
            r5 = 2048(0x800, float:2.87E-42)
            goto L_0x02e9
        L_0x022f:
            r5 = 1024(0x400, float:1.435E-42)
            goto L_0x02e9
        L_0x0233:
            int r5 = r25.position()
            int r7 = j1.l0.f8453a
            int r5 = r0.getInt(r5)
            java.nio.ByteOrder r7 = r25.order()
            java.nio.ByteOrder r9 = java.nio.ByteOrder.BIG_ENDIAN
            if (r7 != r9) goto L_0x0246
            goto L_0x024a
        L_0x0246:
            int r5 = java.lang.Integer.reverseBytes(r5)
        L_0x024a:
            int r5 = d2.l0.b(r5)
            if (r5 == r13) goto L_0x0252
            goto L_0x02e9
        L_0x0252:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>()
            throw r0
        L_0x0258:
            int r5 = r25.position()
            byte r7 = r0.get(r5)
            if (r7 == r14) goto L_0x0294
            if (r7 == r13) goto L_0x0281
            r9 = 31
            if (r7 == r9) goto L_0x0274
            int r7 = r5 + 4
            byte r7 = r0.get(r7)
            r7 = r7 & r6
            int r7 = r7 << 6
            int r5 = r5 + 5
            goto L_0x029f
        L_0x0274:
            int r7 = r5 + 5
            byte r7 = r0.get(r7)
            r7 = r7 & 7
            int r7 = r7 << 4
            int r5 = r5 + 6
            goto L_0x028d
        L_0x0281:
            int r7 = r5 + 4
            byte r7 = r0.get(r7)
            r7 = r7 & 7
            int r7 = r7 << 4
            int r5 = r5 + 7
        L_0x028d:
            byte r5 = r0.get(r5)
            r5 = r5 & 60
            goto L_0x02a5
        L_0x0294:
            int r7 = r5 + 5
            byte r7 = r0.get(r7)
            r7 = r7 & r6
            int r7 = r7 << 6
            int r5 = r5 + 4
        L_0x029f:
            byte r5 = r0.get(r5)
            r5 = r5 & 252(0xfc, float:3.53E-43)
        L_0x02a5:
            int r5 = r5 >> r15
            r5 = r5 | r7
            int r5 = r5 + r6
            int r5 = r5 * 32
            goto L_0x02e9
        L_0x02ab:
            int r5 = r25.position()
            int r5 = r5 + 5
            byte r5 = r0.get(r5)
            r5 = r5 & 248(0xf8, float:3.48E-43)
            int r5 = r5 >> r9
            r7 = 10
            if (r5 <= r7) goto L_0x02be
            r5 = 1
            goto L_0x02bf
        L_0x02be:
            r5 = 0
        L_0x02bf:
            if (r5 == 0) goto L_0x02e7
            int r5 = r25.position()
            int r5 = r5 + 4
            byte r5 = r0.get(r5)
            r5 = r5 & 192(0xc0, float:2.69E-43)
            int r5 = r5 >> 6
            if (r5 != r9) goto L_0x02d2
            goto L_0x02e0
        L_0x02d2:
            int r5 = r25.position()
            int r5 = r5 + 4
            byte r5 = r0.get(r5)
            r5 = r5 & 48
            int r9 = r5 >> 4
        L_0x02e0:
            int[] r5 = d2.c.f4150a
            r5 = r5[r9]
            int r5 = r5 * 256
            goto L_0x02e9
        L_0x02e7:
            r5 = 1536(0x600, float:2.152E-42)
        L_0x02e9:
            r1.F = r5
            if (r5 != 0) goto L_0x02ee
            return r6
        L_0x02ee:
            o1.y r5 = r1.f11902w
            if (r5 == 0) goto L_0x0300
            boolean r5 = r24.c()
            if (r5 != 0) goto L_0x02fa
            r0 = 0
            return r0
        L_0x02fa:
            r1.a(r2)
            r5 = 0
            r1.f11902w = r5
        L_0x0300:
            long r9 = r1.I
            o1.x r5 = r1.f11899t
            long r11 = r24.h()
            o1.o0 r7 = r1.f11884e
            long r13 = r7.f12003o
            long r11 = r11 - r13
            r13 = 1000000(0xf4240, double:4.940656E-318)
            long r11 = r11 * r13
            g1.a0 r5 = r5.f12047a
            int r5 = r5.G
            long r13 = (long) r5
            long r11 = r11 / r13
            long r11 = r11 + r9
            boolean r5 = r1.G
            if (r5 != 0) goto L_0x0338
            long r9 = r11 - r2
            long r9 = java.lang.Math.abs(r9)
            r13 = 200000(0x30d40, double:9.8813E-319)
            int r5 = (r9 > r13 ? 1 : (r9 == r13 ? 0 : -1))
            if (r5 <= 0) goto L_0x0338
            e.a r5 = r1.f11897r
            if (r5 == 0) goto L_0x0336
            o1.k r7 = new o1.k
            r7.<init>(r2, r11)
            r5.G(r7)
        L_0x0336:
            r1.G = r6
        L_0x0338:
            boolean r5 = r1.G
            if (r5 == 0) goto L_0x0361
            boolean r5 = r24.c()
            if (r5 != 0) goto L_0x0344
            r0 = 0
            return r0
        L_0x0344:
            r5 = 0
            long r9 = r2 - r11
            long r11 = r1.I
            long r11 = r11 + r9
            r1.I = r11
            r1.G = r5
            r1.a(r2)
            e.a r5 = r1.f11897r
            if (r5 == 0) goto L_0x0361
            r11 = 0
            int r7 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r7 == 0) goto L_0x0361
            java.lang.Object r5 = r5.f4852i
            o1.j0 r5 = (o1.j0) r5
            r5.S0 = r6
        L_0x0361:
            o1.x r5 = r1.f11899t
            int r5 = r5.f12049c
            if (r5 != 0) goto L_0x0372
            long r9 = r1.B
            int r5 = r25.remaining()
            long r11 = (long) r5
            long r9 = r9 + r11
            r1.B = r9
            goto L_0x037d
        L_0x0372:
            long r9 = r1.C
            int r5 = r1.F
            long r11 = (long) r5
            long r13 = (long) r4
            long r11 = r11 * r13
            long r11 = r11 + r9
            r1.C = r11
        L_0x037d:
            r1.M = r0
            r1.N = r4
        L_0x0381:
            r1.p(r2)
            java.nio.ByteBuffer r0 = r1.M
            boolean r0 = r0.hasRemaining()
            if (r0 != 0) goto L_0x0393
            r0 = 0
            r1.M = r0
            r0 = 0
            r1.N = r0
            return r6
        L_0x0393:
            long r2 = r24.i()
            long r4 = r8.f12029z
            r9 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r0 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
            if (r0 == 0) goto L_0x03b7
            r4 = 0
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 <= 0) goto L_0x03b7
            long r2 = android.os.SystemClock.elapsedRealtime()
            long r4 = r8.f12029z
            long r2 = r2 - r4
            r4 = 200(0xc8, double:9.9E-322)
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 < 0) goto L_0x03b7
            r0 = 1
            goto L_0x03b8
        L_0x03b7:
            r0 = 0
        L_0x03b8:
            if (r0 == 0) goto L_0x03c5
            java.lang.String r0 = "DefaultAudioSink"
            java.lang.String r2 = "Resetting stalled audio track"
            j1.v.g(r0, r2)
            r24.d()
            return r6
        L_0x03c5:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: o1.e0.j(java.nio.ByteBuffer, long, int):boolean");
    }

    public final boolean k() {
        return m() && this.f11888i.b(i());
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00f1  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0140  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0144  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean l() {
        /*
            r17 = this;
            r1 = r17
            j1.g r2 = r1.f11887h
            monitor-enter(r2)
            boolean r0 = r2.f8430a     // Catch:{ all -> 0x0147 }
            monitor-exit(r2)
            r2 = 0
            if (r0 != 0) goto L_0x000c
            return r2
        L_0x000c:
            r3 = 1
            o1.x r0 = r1.f11899t     // Catch:{ j -> 0x0026 }
            r0.getClass()     // Catch:{ j -> 0x0026 }
            boolean r4 = r1.Z     // Catch:{ j -> 0x001d }
            g1.h r5 = r1.f11901v     // Catch:{ j -> 0x001d }
            int r6 = r1.W     // Catch:{ j -> 0x001d }
            android.media.AudioTrack r0 = r0.a(r4, r5, r6)     // Catch:{ j -> 0x001d }
            goto L_0x0058
        L_0x001d:
            r0 = move-exception
            e.a r4 = r1.f11897r     // Catch:{ j -> 0x0026 }
            if (r4 == 0) goto L_0x0025
            r4.G(r0)     // Catch:{ j -> 0x0026 }
        L_0x0025:
            throw r0     // Catch:{ j -> 0x0026 }
        L_0x0026:
            r0 = move-exception
            r4 = r0
            o1.x r0 = r1.f11899t
            int r5 = r0.f12054h
            r6 = 1000000(0xf4240, float:1.401298E-39)
            if (r5 <= r6) goto L_0x013a
            r15 = 1000000(0xf4240, float:1.401298E-39)
            o1.x r5 = new o1.x
            g1.a0 r8 = r0.f12047a
            int r9 = r0.f12048b
            int r10 = r0.f12049c
            int r11 = r0.f12050d
            int r12 = r0.f12051e
            int r13 = r0.f12052f
            int r14 = r0.f12053g
            h1.c[] r0 = r0.f12055i
            r7 = r5
            r16 = r0
            r7.<init>(r8, r9, r10, r11, r12, r13, r14, r15, r16)
            boolean r0 = r1.Z     // Catch:{ j -> 0x012e }
            g1.h r6 = r1.f11901v     // Catch:{ j -> 0x012e }
            int r7 = r1.W     // Catch:{ j -> 0x012e }
            android.media.AudioTrack r0 = r5.a(r0, r6, r7)     // Catch:{ j -> 0x012e }
            r1.f11899t = r5     // Catch:{ j -> 0x012c }
        L_0x0058:
            r1.f11900u = r0
            boolean r0 = n(r0)
            if (r0 == 0) goto L_0x0090
            android.media.AudioTrack r0 = r1.f11900u
            o1.d0 r4 = r1.f11892m
            if (r4 != 0) goto L_0x006d
            o1.d0 r4 = new o1.d0
            r4.<init>(r1)
            r1.f11892m = r4
        L_0x006d:
            o1.d0 r4 = r1.f11892m
            android.os.Handler r5 = r4.f11869a
            java.util.Objects.requireNonNull(r5)
            o1.b0 r6 = new o1.b0
            r6.<init>(r2, r5)
            o1.c0 r4 = r4.f11870b
            r0.registerStreamEventCallback(r6, r4)
            int r0 = r1.f11891l
            r4 = 3
            if (r0 == r4) goto L_0x0090
            android.media.AudioTrack r0 = r1.f11900u
            o1.x r4 = r1.f11899t
            g1.a0 r4 = r4.f12047a
            int r5 = r4.I
            int r4 = r4.J
            r0.setOffloadDelayPadding(r5, r4)
        L_0x0090:
            int r0 = j1.l0.f8453a
            r4 = 31
            if (r0 < r4) goto L_0x009f
            n1.f0 r4 = r1.f11896q
            if (r4 == 0) goto L_0x009f
            android.media.AudioTrack r5 = r1.f11900u
            o1.t.a(r5, r4)
        L_0x009f:
            android.media.AudioTrack r4 = r1.f11900u
            int r4 = r4.getAudioSessionId()
            r1.W = r4
            o1.p r4 = r1.f11888i
            android.media.AudioTrack r5 = r1.f11900u
            o1.x r6 = r1.f11899t
            int r7 = r6.f12049c
            r8 = 2
            if (r7 != r8) goto L_0x00b4
            r7 = 1
            goto L_0x00b5
        L_0x00b4:
            r7 = 0
        L_0x00b5:
            int r8 = r6.f12053g
            int r9 = r6.f12050d
            int r6 = r6.f12054h
            r4.f12006c = r5
            r4.f12007d = r9
            r4.f12008e = r6
            o1.o r10 = new o1.o
            r10.<init>(r5)
            r4.f12009f = r10
            int r5 = r5.getSampleRate()
            r4.f12010g = r5
            r5 = 23
            if (r7 == 0) goto L_0x00e1
            if (r0 >= r5) goto L_0x00dc
            r7 = 5
            if (r8 == r7) goto L_0x00da
            r7 = 6
            if (r8 != r7) goto L_0x00dc
        L_0x00da:
            r7 = 1
            goto L_0x00dd
        L_0x00dc:
            r7 = 0
        L_0x00dd:
            if (r7 == 0) goto L_0x00e1
            r7 = 1
            goto L_0x00e2
        L_0x00e1:
            r7 = 0
        L_0x00e2:
            r4.f12011h = r7
            boolean r7 = j1.l0.D(r8)
            r4.f12020q = r7
            r10 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r7 == 0) goto L_0x00fd
            int r6 = r6 / r9
            long r6 = (long) r6
            r8 = 1000000(0xf4240, double:4.940656E-318)
            long r6 = r6 * r8
            int r8 = r4.f12010g
            long r8 = (long) r8
            long r6 = r6 / r8
            goto L_0x00fe
        L_0x00fd:
            r6 = r10
        L_0x00fe:
            r4.f12012i = r6
            r6 = 0
            r4.f12023t = r6
            r4.f12024u = r6
            r4.f12025v = r6
            r4.f12019p = r2
            r4.f12028y = r10
            r4.f12029z = r10
            r4.f12021r = r6
            r4.f12018o = r6
            r2 = 1065353216(0x3f800000, float:1.0)
            r4.f12013j = r2
            r17.t()
            g1.i r2 = r1.X
            r2.getClass()
            o1.u r2 = r1.Y
            if (r2 == 0) goto L_0x0129
            if (r0 < r5) goto L_0x0129
            android.media.AudioTrack r0 = r1.f11900u
            o1.s.a(r0, r2)
        L_0x0129:
            r1.H = r3
            return r3
        L_0x012c:
            r0 = move-exception
            goto L_0x0137
        L_0x012e:
            r0 = move-exception
            e.a r5 = r1.f11897r     // Catch:{ j -> 0x012c }
            if (r5 == 0) goto L_0x0136
            r5.G(r0)     // Catch:{ j -> 0x012c }
        L_0x0136:
            throw r0     // Catch:{ j -> 0x012c }
        L_0x0137:
            r4.addSuppressed(r0)
        L_0x013a:
            o1.x r0 = r1.f11899t
            int r0 = r0.f12049c
            if (r0 != r3) goto L_0x0141
            r2 = 1
        L_0x0141:
            if (r2 != 0) goto L_0x0144
            goto L_0x0146
        L_0x0144:
            r1.f11880b0 = r3
        L_0x0146:
            throw r4
        L_0x0147:
            r0 = move-exception
            r3 = r0
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: o1.e0.l():boolean");
    }

    public final boolean m() {
        return this.f11900u != null;
    }

    public final void o() {
        if (!this.T) {
            this.T = true;
            long i10 = i();
            p pVar = this.f11888i;
            pVar.A = pVar.a();
            pVar.f12028y = SystemClock.elapsedRealtime() * 1000;
            pVar.B = i10;
            this.f11900u.stop();
            this.A = 0;
        }
    }

    public final void p(long j10) {
        ByteBuffer byteBuffer;
        int length = this.K.length;
        int i10 = length;
        while (i10 >= 0) {
            if (i10 > 0) {
                byteBuffer = this.L[i10 - 1];
            } else {
                byteBuffer = this.M;
                if (byteBuffer == null) {
                    byteBuffer = c.f6882a;
                }
            }
            if (i10 == length) {
                w(byteBuffer, j10);
            } else {
                c cVar = this.K[i10];
                if (i10 > this.R) {
                    cVar.e(byteBuffer);
                }
                ByteBuffer a10 = cVar.a();
                this.L[i10] = a10;
                if (a10.hasRemaining()) {
                    i10++;
                }
            }
            if (!byteBuffer.hasRemaining()) {
                i10--;
            } else {
                return;
            }
        }
    }

    public final void q() {
        d();
        for (c g10 : this.f11885f) {
            g10.g();
        }
        for (c g11 : this.f11886g) {
            g11.g();
        }
        this.U = false;
        this.f11880b0 = false;
    }

    public final void r(e1 e1Var, boolean z10) {
        y g10 = g();
        if (!e1Var.equals(g10.f12056a) || z10 != g10.f12057b) {
            y yVar = new y(e1Var, z10, -9223372036854775807L, -9223372036854775807L);
            if (m()) {
                this.f11902w = yVar;
            } else {
                this.f11903x = yVar;
            }
        }
    }

    public final void s(e1 e1Var) {
        if (m()) {
            f.q();
            try {
                this.f11900u.setPlaybackParams(f.l().allowDefaults().setSpeed(e1Var.f6355h).setPitch(e1Var.f6356i).setAudioFallbackMode(2));
            } catch (IllegalArgumentException e10) {
                v.h("DefaultAudioSink", "Failed to set playback params", e10);
            }
            e1Var = new e1(this.f11900u.getPlaybackParams().getSpeed(), this.f11900u.getPlaybackParams().getPitch());
            float f10 = e1Var.f6355h;
            p pVar = this.f11888i;
            pVar.f12013j = f10;
            o oVar = pVar.f12009f;
            if (oVar != null) {
                oVar.a();
            }
            pVar.c();
        }
        this.f11904y = e1Var;
    }

    public final void t() {
        if (m()) {
            if (l0.f8453a >= 21) {
                this.f11900u.setVolume(this.J);
                return;
            }
            AudioTrack audioTrack = this.f11900u;
            float f10 = this.J;
            audioTrack.setStereoVolume(f10, f10);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0036 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean u() {
        /*
            r4 = this;
            boolean r0 = r4.Z
            r1 = 0
            if (r0 != 0) goto L_0x0037
            o1.x r0 = r4.f11899t
            g1.a0 r0 = r0.f12047a
            java.lang.String r0 = r0.f6276s
            java.lang.String r2 = "audio/raw"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x0037
            o1.x r0 = r4.f11899t
            g1.a0 r0 = r0.f12047a
            int r0 = r0.H
            boolean r2 = r4.f11881c
            r3 = 1
            if (r2 == 0) goto L_0x0033
            int r2 = j1.l0.f8453a
            r2 = 536870912(0x20000000, float:1.0842022E-19)
            if (r0 == r2) goto L_0x002e
            r2 = 805306368(0x30000000, float:4.656613E-10)
            if (r0 == r2) goto L_0x002e
            r2 = 4
            if (r0 != r2) goto L_0x002c
            goto L_0x002e
        L_0x002c:
            r0 = 0
            goto L_0x002f
        L_0x002e:
            r0 = 1
        L_0x002f:
            if (r0 == 0) goto L_0x0033
            r0 = 1
            goto L_0x0034
        L_0x0033:
            r0 = 0
        L_0x0034:
            if (r0 != 0) goto L_0x0037
            r1 = 1
        L_0x0037:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: o1.e0.u():boolean");
    }

    public final boolean v(h hVar, a0 a0Var) {
        int i10;
        int m10;
        int i11;
        boolean z10;
        boolean z11;
        int i12 = l0.f8453a;
        if (i12 < 29 || (i10 = this.f11891l) == 0) {
            return false;
        }
        String str = a0Var.f6276s;
        str.getClass();
        int c10 = a1.c(str, a0Var.f6273p);
        if (c10 == 0 || (m10 = l0.m(a0Var.F)) == 0) {
            return false;
        }
        AudioFormat e10 = e(a0Var.G, m10, c10);
        AudioAttributes audioAttributes = (AudioAttributes) hVar.i().f4852i;
        if (i12 >= 31) {
            i11 = AudioManager.getPlaybackOffloadSupport(e10, audioAttributes);
        } else if (!AudioManager.isOffloadedPlaybackSupported(e10, audioAttributes)) {
            i11 = 0;
        } else if (i12 != 30 || !l0.f8456d.startsWith("Pixel")) {
            i11 = 1;
        } else {
            i11 = 2;
        }
        if (i11 == 0) {
            return false;
        }
        if (i11 == 1) {
            if (a0Var.I == 0 && a0Var.J == 0) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (i10 == 1) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z10 || !z11) {
                return true;
            }
            return false;
        } else if (i11 == 2) {
            return true;
        } else {
            throw new IllegalStateException();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00df, code lost:
        if (r12 < r11) goto L_0x00e1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0104  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0135  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void w(java.nio.ByteBuffer r10, long r11) {
        /*
            r9 = this;
            boolean r0 = r10.hasRemaining()
            if (r0 != 0) goto L_0x0007
            return
        L_0x0007:
            java.nio.ByteBuffer r0 = r9.O
            r1 = 1
            r2 = 0
            r3 = 21
            if (r0 == 0) goto L_0x0018
            if (r0 != r10) goto L_0x0013
            r0 = 1
            goto L_0x0014
        L_0x0013:
            r0 = 0
        L_0x0014:
            j1.a.b(r0)
            goto L_0x003b
        L_0x0018:
            r9.O = r10
            int r0 = j1.l0.f8453a
            if (r0 >= r3) goto L_0x003b
            int r0 = r10.remaining()
            byte[] r4 = r9.P
            if (r4 == 0) goto L_0x0029
            int r4 = r4.length
            if (r4 >= r0) goto L_0x002d
        L_0x0029:
            byte[] r4 = new byte[r0]
            r9.P = r4
        L_0x002d:
            int r4 = r10.position()
            byte[] r5 = r9.P
            r10.get(r5, r2, r0)
            r10.position(r4)
            r9.Q = r2
        L_0x003b:
            int r0 = r10.remaining()
            int r4 = j1.l0.f8453a
            if (r4 >= r3) goto L_0x0076
            long r11 = r9.D
            o1.p r3 = r9.f11888i
            long r5 = r3.a()
            int r7 = r3.f12007d
            long r7 = (long) r7
            long r5 = r5 * r7
            long r11 = r11 - r5
            int r12 = (int) r11
            int r11 = r3.f12008e
            int r11 = r11 - r12
            if (r11 <= 0) goto L_0x00e1
            int r11 = java.lang.Math.min(r0, r11)
            android.media.AudioTrack r12 = r9.f11900u
            byte[] r3 = r9.P
            int r5 = r9.Q
            int r11 = r12.write(r3, r5, r11)
            if (r11 <= 0) goto L_0x00f8
            int r12 = r9.Q
            int r12 = r12 + r11
            r9.Q = r12
            int r12 = r10.position()
            int r12 = r12 + r11
            r10.position(r12)
            goto L_0x00f8
        L_0x0076:
            boolean r3 = r9.Z
            if (r3 == 0) goto L_0x00f2
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r3 = (r11 > r5 ? 1 : (r11 == r5 ? 0 : -1))
            if (r3 == 0) goto L_0x0085
            r3 = 1
            goto L_0x0086
        L_0x0085:
            r3 = 0
        L_0x0086:
            j1.a.e(r3)
            android.media.AudioTrack r3 = r9.f11900u
            r5 = 26
            r6 = 1000(0x3e8, double:4.94E-321)
            if (r4 < r5) goto L_0x0098
            long r11 = r11 * r6
            int r11 = r3.write(r10, r0, 1, r11)
            goto L_0x00f8
        L_0x0098:
            java.nio.ByteBuffer r5 = r9.f11905z
            if (r5 != 0) goto L_0x00b1
            r5 = 16
            java.nio.ByteBuffer r5 = java.nio.ByteBuffer.allocate(r5)
            r9.f11905z = r5
            java.nio.ByteOrder r8 = java.nio.ByteOrder.BIG_ENDIAN
            r5.order(r8)
            java.nio.ByteBuffer r5 = r9.f11905z
            r8 = 1431633921(0x55550001, float:1.46372496E13)
            r5.putInt(r8)
        L_0x00b1:
            int r5 = r9.A
            if (r5 != 0) goto L_0x00cb
            java.nio.ByteBuffer r5 = r9.f11905z
            r8 = 4
            r5.putInt(r8, r0)
            java.nio.ByteBuffer r5 = r9.f11905z
            r8 = 8
            long r11 = r11 * r6
            r5.putLong(r8, r11)
            java.nio.ByteBuffer r11 = r9.f11905z
            r11.position(r2)
            r9.A = r0
        L_0x00cb:
            java.nio.ByteBuffer r11 = r9.f11905z
            int r11 = r11.remaining()
            if (r11 <= 0) goto L_0x00e3
            java.nio.ByteBuffer r12 = r9.f11905z
            int r12 = r3.write(r12, r11, r1)
            if (r12 >= 0) goto L_0x00df
            r9.A = r2
            r11 = r12
            goto L_0x00f8
        L_0x00df:
            if (r12 >= r11) goto L_0x00e3
        L_0x00e1:
            r11 = 0
            goto L_0x00f8
        L_0x00e3:
            int r11 = r3.write(r10, r0, r1)
            if (r11 >= 0) goto L_0x00ec
            r9.A = r2
            goto L_0x00f8
        L_0x00ec:
            int r12 = r9.A
            int r12 = r12 - r11
            r9.A = r12
            goto L_0x00f8
        L_0x00f2:
            android.media.AudioTrack r11 = r9.f11900u
            int r11 = r11.write(r10, r0, r1)
        L_0x00f8:
            long r5 = android.os.SystemClock.elapsedRealtime()
            r9.f11878a0 = r5
            r5 = 0
            o1.z r12 = r9.f11894o
            if (r11 >= 0) goto L_0x0135
            r10 = 24
            if (r4 < r10) goto L_0x010b
            r10 = -6
            if (r11 == r10) goto L_0x010f
        L_0x010b:
            r10 = -32
            if (r11 != r10) goto L_0x0111
        L_0x010f:
            r10 = 1
            goto L_0x0112
        L_0x0111:
            r10 = 0
        L_0x0112:
            if (r10 == 0) goto L_0x011b
            long r3 = r9.E
            int r10 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r10 <= 0) goto L_0x011b
            goto L_0x011c
        L_0x011b:
            r1 = 0
        L_0x011c:
            o1.l r10 = new o1.l
            o1.x r0 = r9.f11899t
            g1.a0 r0 = r0.f12047a
            r10.<init>(r11, r0, r1)
            e.a r11 = r9.f11897r
            if (r11 == 0) goto L_0x012c
            r11.G(r10)
        L_0x012c:
            boolean r11 = r10.f11935i
            if (r11 != 0) goto L_0x0134
            r12.a(r10)
            return
        L_0x0134:
            throw r10
        L_0x0135:
            r3 = 0
            r12.f12060a = r3
            android.media.AudioTrack r12 = r9.f11900u
            boolean r12 = n(r12)
            if (r12 == 0) goto L_0x0162
            long r7 = r9.E
            int r12 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r12 <= 0) goto L_0x0148
            r9.f11882c0 = r2
        L_0x0148:
            boolean r12 = r9.U
            if (r12 == 0) goto L_0x0162
            e.a r12 = r9.f11897r
            if (r12 == 0) goto L_0x0162
            if (r11 >= r0) goto L_0x0162
            boolean r4 = r9.f11882c0
            if (r4 != 0) goto L_0x0162
            java.lang.Object r12 = r12.f4852i
            o1.j0 r12 = (o1.j0) r12
            m1.o0 r12 = r12.U0
            if (r12 == 0) goto L_0x0162
            m1.u0 r12 = r12.f10417a
            r12.O = r1
        L_0x0162:
            o1.x r12 = r9.f11899t
            int r12 = r12.f12049c
            if (r12 != 0) goto L_0x016e
            long r4 = r9.D
            long r6 = (long) r11
            long r4 = r4 + r6
            r9.D = r4
        L_0x016e:
            if (r11 != r0) goto L_0x018a
            if (r12 == 0) goto L_0x0188
            java.nio.ByteBuffer r11 = r9.M
            if (r10 != r11) goto L_0x0177
            goto L_0x0178
        L_0x0177:
            r1 = 0
        L_0x0178:
            j1.a.e(r1)
            long r10 = r9.E
            int r12 = r9.F
            long r0 = (long) r12
            int r12 = r9.N
            long r4 = (long) r12
            long r0 = r0 * r4
            long r0 = r0 + r10
            r9.E = r0
        L_0x0188:
            r9.O = r3
        L_0x018a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: o1.e0.w(java.nio.ByteBuffer, long):void");
    }
}
