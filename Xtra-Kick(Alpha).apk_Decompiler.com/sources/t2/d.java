package t2;

import d2.g0;
import d2.i0;
import d2.k0;
import d2.u;
import d2.v;
import d2.w;
import d2.x0;
import d2.y;
import g1.y0;
import g1.z0;
import i1.c;
import j1.b0;
import j1.l0;
import java.io.EOFException;
import o2.x;

public final class d implements v {

    /* renamed from: u  reason: collision with root package name */
    public static final c f14500u = new c(26);

    /* renamed from: a  reason: collision with root package name */
    public final int f14501a;

    /* renamed from: b  reason: collision with root package name */
    public final long f14502b;

    /* renamed from: c  reason: collision with root package name */
    public final b0 f14503c;

    /* renamed from: d  reason: collision with root package name */
    public final k0 f14504d;

    /* renamed from: e  reason: collision with root package name */
    public final g0 f14505e;

    /* renamed from: f  reason: collision with root package name */
    public final i0 f14506f;

    /* renamed from: g  reason: collision with root package name */
    public final u f14507g;

    /* renamed from: h  reason: collision with root package name */
    public y f14508h;

    /* renamed from: i  reason: collision with root package name */
    public x0 f14509i;

    /* renamed from: j  reason: collision with root package name */
    public x0 f14510j;

    /* renamed from: k  reason: collision with root package name */
    public int f14511k;

    /* renamed from: l  reason: collision with root package name */
    public z0 f14512l;

    /* renamed from: m  reason: collision with root package name */
    public long f14513m;

    /* renamed from: n  reason: collision with root package name */
    public long f14514n;

    /* renamed from: o  reason: collision with root package name */
    public long f14515o;

    /* renamed from: p  reason: collision with root package name */
    public int f14516p;

    /* renamed from: q  reason: collision with root package name */
    public f f14517q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f14518r;

    /* renamed from: s  reason: collision with root package name */
    public boolean f14519s;

    /* renamed from: t  reason: collision with root package name */
    public long f14520t;

    public d() {
        this(0);
    }

    public static long f(z0 z0Var) {
        if (z0Var == null) {
            return -9223372036854775807L;
        }
        for (y0 y0Var : z0Var.f6770h) {
            if (y0Var instanceof x) {
                x xVar = (x) y0Var;
                if (xVar.f12090h.equals("TLEN")) {
                    return l0.H(Long.parseLong((String) xVar.f12102j.get(0)));
                }
            }
        }
        return -9223372036854775807L;
    }

    public final void a() {
    }

    public final a b(w wVar, boolean z10) {
        b0 b0Var = this.f14503c;
        wVar.m(b0Var.f8414a, 0, 4);
        b0Var.G(0);
        this.f14504d.a(b0Var.f());
        return new a(wVar.c(), wVar.p(), this.f14504d, z10);
    }

    public final void c(long j10, long j11) {
        this.f14511k = 0;
        this.f14513m = -9223372036854775807L;
        this.f14514n = 0;
        this.f14516p = 0;
        this.f14520t = j11;
        f fVar = this.f14517q;
        if ((fVar instanceof b) && !((b) fVar).a(j11)) {
            this.f14519s = true;
            this.f14510j = this.f14507g;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v9, resolved type: t2.a} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v20, resolved type: t2.a} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v21, resolved type: t2.a} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v30, resolved type: t2.b} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v31, resolved type: t2.b} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v31, resolved type: t2.h} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v32, resolved type: t2.a} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v33, resolved type: t2.g} */
    /* JADX WARNING: type inference failed for: r2v11 */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x030d, code lost:
        if ((r5 & 1) != 0) goto L_0x030f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0064, code lost:
        if (r14 != 1231971951) goto L_0x0067;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x024c  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0254  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x025e  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x02cb  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x02d1  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x0305  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x0313  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x0315  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x0346  */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x0349  */
    /* JADX WARNING: Removed duplicated region for block: B:190:0x046f  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0085 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0193  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0201  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0205  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int d(d2.w r40, d2.s0 r41) {
        /*
            r39 = this;
            r0 = r39
            r1 = r40
            d2.x0 r2 = r0.f14509i
            j1.a.f(r2)
            int r2 = j1.l0.f8453a
            int r2 = r0.f14511k
            r3 = 1000000(0xf4240, double:4.940656E-318)
            d2.k0 r5 = r0.f14504d
            r7 = 0
            if (r2 != 0) goto L_0x0020
            r0.i(r1, r7)     // Catch:{ EOFException -> 0x0019 }
            goto L_0x0020
        L_0x0019:
            r4 = r0
            r2 = r5
            r0 = -1
            r6 = -1
            goto L_0x046d
        L_0x0020:
            t2.f r2 = r0.f14517q
            r10 = 1
            j1.b0 r11 = r0.f14503c
            if (r2 != 0) goto L_0x035c
            j1.b0 r2 = new j1.b0
            int r12 = r5.f4214c
            r2.<init>((int) r12)
            byte[] r12 = r2.f8414a
            int r13 = r5.f4214c
            r1.m(r12, r7, r13)
            int r12 = r5.f4212a
            r12 = r12 & r10
            r13 = 36
            if (r12 == 0) goto L_0x0043
            int r12 = r5.f4216e
            if (r12 == r10) goto L_0x0047
            r12 = 36
            goto L_0x004c
        L_0x0043:
            int r12 = r5.f4216e
            if (r12 == r10) goto L_0x004a
        L_0x0047:
            r12 = 21
            goto L_0x004c
        L_0x004a:
            r12 = 13
        L_0x004c:
            int r14 = r2.f8416c
            int r15 = r12 + 4
            r8 = 1447187017(0x56425249, float:5.3414667E13)
            r9 = 1231971951(0x496e666f, float:976486.94)
            r7 = 1483304551(0x58696e67, float:1.02664153E15)
            if (r14 < r15) goto L_0x0067
            r2.G(r12)
            int r14 = r2.f()
            if (r14 == r7) goto L_0x007b
            if (r14 != r9) goto L_0x0067
            goto L_0x007b
        L_0x0067:
            int r14 = r2.f8416c
            r15 = 40
            if (r14 < r15) goto L_0x007a
            r2.G(r13)
            int r13 = r2.f()
            if (r13 != r8) goto L_0x007a
            r14 = 1447187017(0x56425249, float:5.3414667E13)
            goto L_0x007b
        L_0x007a:
            r14 = 0
        L_0x007b:
            d2.g0 r15 = r0.f14505e
            r18 = -1
            r20 = 0
            java.lang.String r6 = ", "
            if (r14 == r7) goto L_0x0171
            if (r14 != r9) goto L_0x0089
            goto L_0x0171
        L_0x0089:
            if (r14 != r8) goto L_0x0162
            long r7 = r40.c()
            long r21 = r40.p()
            r9 = 10
            r2.H(r9)
            int r9 = r2.f()
            if (r9 > 0) goto L_0x00a3
            r21 = r5
            r29 = r11
            goto L_0x00fa
        L_0x00a3:
            int r12 = r5.f4215d
            long r13 = (long) r9
            r9 = 32000(0x7d00, float:4.4842E-41)
            if (r12 < r9) goto L_0x00ad
            r9 = 1152(0x480, float:1.614E-42)
            goto L_0x00af
        L_0x00ad:
            r9 = 576(0x240, float:8.07E-43)
        L_0x00af:
            r29 = r11
            long r10 = (long) r9
            long r25 = r10 * r3
            long r9 = (long) r12
            r23 = r13
            r27 = r9
            long r33 = j1.l0.M(r23, r25, r27)
            int r9 = r2.A()
            int r10 = r2.A()
            int r11 = r2.A()
            r12 = 2
            r2.H(r12)
            int r13 = r5.f4214c
            long r13 = (long) r13
            long r13 = r21 + r13
            long[] r3 = new long[r9]
            long[] r4 = new long[r9]
            r0 = r21
            r12 = 0
        L_0x00d9:
            r21 = r5
            r22 = r6
            if (r12 >= r9) goto L_0x0125
            long r5 = (long) r12
            long r5 = r5 * r33
            r26 = r7
            long r7 = (long) r9
            long r5 = r5 / r7
            r3[r12] = r5
            long r5 = java.lang.Math.max(r0, r13)
            r4[r12] = r5
            r5 = 1
            if (r11 == r5) goto L_0x010e
            r5 = 2
            if (r11 == r5) goto L_0x0109
            r6 = 3
            if (r11 == r6) goto L_0x0104
            r6 = 4
            if (r11 == r6) goto L_0x00ff
        L_0x00fa:
            r2 = r20
        L_0x00fc:
            r0 = r21
            goto L_0x015a
        L_0x00ff:
            int r6 = r2.y()
            goto L_0x0113
        L_0x0104:
            int r6 = r2.x()
            goto L_0x0113
        L_0x0109:
            int r6 = r2.A()
            goto L_0x0113
        L_0x010e:
            r5 = 2
            int r6 = r2.v()
        L_0x0113:
            long r6 = (long) r6
            r25 = r9
            long r8 = (long) r10
            long r6 = r6 * r8
            long r0 = r0 + r6
            int r12 = r12 + 1
            r5 = r21
            r6 = r22
            r9 = r25
            r7 = r26
            goto L_0x00d9
        L_0x0125:
            r26 = r7
            int r2 = (r26 > r18 ? 1 : (r26 == r18 ? 0 : -1))
            if (r2 == 0) goto L_0x014c
            int r2 = (r26 > r0 ? 1 : (r26 == r0 ? 0 : -1))
            if (r2 == 0) goto L_0x014c
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r5 = "VBRI data size mismatch: "
            r2.<init>(r5)
            r5 = r26
            r2.append(r5)
            r5 = r22
            r2.append(r5)
            r2.append(r0)
            java.lang.String r2 = r2.toString()
            java.lang.String r5 = "VbriSeeker"
            j1.v.g(r5, r2)
        L_0x014c:
            t2.g r2 = new t2.g
            r30 = r2
            r31 = r3
            r32 = r4
            r35 = r0
            r30.<init>(r31, r32, r33, r35)
            goto L_0x00fc
        L_0x015a:
            int r1 = r0.f4214c
            r3 = r40
            r3.g(r1)
            goto L_0x016b
        L_0x0162:
            r3 = r1
            r0 = r5
            r29 = r11
            r40.f()
            r2 = r20
        L_0x016b:
            r4 = r39
            r1 = r29
            goto L_0x0256
        L_0x0171:
            r3 = r1
            r0 = r5
            r5 = r6
            r29 = r11
            long r6 = r40.c()
            long r31 = r40.p()
            int r1 = r0.f4218g
            int r4 = r0.f4215d
            int r8 = r2.f()
            r10 = r8 & 1
            r11 = 1
            if (r10 != r11) goto L_0x0201
            int r10 = r2.y()
            if (r10 != 0) goto L_0x0193
            goto L_0x0201
        L_0x0193:
            long r10 = (long) r10
            r21 = r10
            long r9 = (long) r1
            r23 = 1000000(0xf4240, double:4.940656E-318)
            long r35 = r9 * r23
            long r9 = (long) r4
            r33 = r21
            r37 = r9
            long r34 = j1.l0.M(r33, r35, r37)
            r1 = 6
            r4 = r8 & 6
            if (r4 == r1) goto L_0x01ba
            t2.h r1 = new t2.h
            int r2 = r0.f4214c
            r36 = -1
            r38 = 0
            r30 = r1
            r33 = r2
            r30.<init>(r31, r33, r34, r36, r38)
            goto L_0x01ff
        L_0x01ba:
            long r36 = r2.w()
            r1 = 100
            long[] r4 = new long[r1]
            r8 = 0
        L_0x01c3:
            if (r8 >= r1) goto L_0x01cf
            int r9 = r2.v()
            long r9 = (long) r9
            r4[r8] = r9
            int r8 = r8 + 1
            goto L_0x01c3
        L_0x01cf:
            int r1 = (r6 > r18 ? 1 : (r6 == r18 ? 0 : -1))
            if (r1 == 0) goto L_0x01f2
            long r1 = r31 + r36
            int r8 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r8 == 0) goto L_0x01f2
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r9 = "XING data size mismatch: "
            r8.<init>(r9)
            r8.append(r6)
            r8.append(r5)
            r8.append(r1)
            java.lang.String r1 = r8.toString()
            java.lang.String r2 = "XingSeeker"
            j1.v.g(r2, r1)
        L_0x01f2:
            t2.h r1 = new t2.h
            int r2 = r0.f4214c
            r30 = r1
            r33 = r2
            r38 = r4
            r30.<init>(r31, r33, r34, r36, r38)
        L_0x01ff:
            r2 = r1
            goto L_0x0203
        L_0x0201:
            r2 = r20
        L_0x0203:
            if (r2 == 0) goto L_0x0238
            int r1 = r15.f4186a
            r4 = -1
            if (r1 == r4) goto L_0x0210
            int r1 = r15.f4187b
            if (r1 == r4) goto L_0x0210
            r1 = 1
            goto L_0x0211
        L_0x0210:
            r1 = 0
        L_0x0211:
            if (r1 != 0) goto L_0x0238
            r40.f()
            int r12 = r12 + 141
            r3.n(r12)
            r1 = r29
            byte[] r4 = r1.f8414a
            r5 = 3
            r6 = 0
            r3.m(r4, r6, r5)
            r1.G(r6)
            int r4 = r1.x()
            int r5 = r4 >> 12
            r4 = r4 & 4095(0xfff, float:5.738E-42)
            if (r5 > 0) goto L_0x0233
            if (r4 <= 0) goto L_0x023a
        L_0x0233:
            r15.f4186a = r5
            r15.f4187b = r4
            goto L_0x023a
        L_0x0238:
            r1 = r29
        L_0x023a:
            int r4 = r0.f4214c
            r3.g(r4)
            if (r2 == 0) goto L_0x0254
            boolean r4 = r2.f()
            if (r4 != 0) goto L_0x0254
            r4 = 1231971951(0x496e666f, float:976486.94)
            if (r14 != r4) goto L_0x0254
            r5 = 0
            r4 = r39
            t2.a r2 = r4.b(r3, r5)
            goto L_0x0256
        L_0x0254:
            r4 = r39
        L_0x0256:
            g1.z0 r5 = r4.f14512l
            long r6 = r40.p()
            if (r5 == 0) goto L_0x02bf
            g1.y0[] r8 = r5.f6770h
            int r9 = r8.length
            r10 = 0
        L_0x0262:
            if (r10 >= r9) goto L_0x02bf
            r11 = r8[r10]
            boolean r12 = r11 instanceof o2.t
            if (r12 == 0) goto L_0x02b8
            o2.t r11 = (o2.t) r11
            long r8 = f(r5)
            int[] r5 = r11.f12097l
            int r5 = r5.length
            int r10 = r5 + 1
            long[] r12 = new long[r10]
            long[] r10 = new long[r10]
            r13 = 0
            r12[r13] = r6
            r16 = 0
            r10[r13] = r16
            r13 = r6
            r6 = 1
            r21 = 0
        L_0x0284:
            if (r6 > r5) goto L_0x02ae
            int r7 = r6 + -1
            r25 = r5
            int[] r5 = r11.f12097l
            r5 = r5[r7]
            r29 = r1
            int r1 = r11.f12095j
            int r1 = r1 + r5
            r26 = r0
            long r0 = (long) r1
            long r13 = r13 + r0
            int[] r0 = r11.f12098m
            r0 = r0[r7]
            int r1 = r11.f12096k
            int r1 = r1 + r0
            long r0 = (long) r1
            long r21 = r21 + r0
            r12[r6] = r13
            r10[r6] = r21
            int r6 = r6 + 1
            r5 = r25
            r0 = r26
            r1 = r29
            goto L_0x0284
        L_0x02ae:
            r26 = r0
            r29 = r1
            t2.c r0 = new t2.c
            r0.<init>(r8, r12, r10)
            goto L_0x02c5
        L_0x02b8:
            r26 = r0
            r29 = r1
            int r10 = r10 + 1
            goto L_0x0262
        L_0x02bf:
            r26 = r0
            r29 = r1
            r0 = r20
        L_0x02c5:
            boolean r1 = r4.f14518r
            int r5 = r4.f14501a
            if (r1 == 0) goto L_0x02d1
            t2.e r0 = new t2.e
            r0.<init>()
            goto L_0x031a
        L_0x02d1:
            r1 = r5 & 4
            if (r1 == 0) goto L_0x02fa
            if (r0 == 0) goto L_0x02da
            long r0 = r0.f14499c
            goto L_0x02e4
        L_0x02da:
            if (r2 == 0) goto L_0x02e8
            long r0 = r2.j()
            long r18 = r2.b()
        L_0x02e4:
            r7 = r0
            r11 = r18
            goto L_0x02ef
        L_0x02e8:
            g1.z0 r0 = r4.f14512l
            long r0 = f(r0)
            goto L_0x02e4
        L_0x02ef:
            t2.b r2 = new t2.b
            long r9 = r40.p()
            r6 = r2
            r6.<init>(r7, r9, r11)
            goto L_0x02ff
        L_0x02fa:
            if (r0 == 0) goto L_0x02fd
            goto L_0x0303
        L_0x02fd:
            if (r2 == 0) goto L_0x0301
        L_0x02ff:
            r0 = r2
            goto L_0x0303
        L_0x0301:
            r0 = r20
        L_0x0303:
            if (r0 == 0) goto L_0x030f
            boolean r1 = r0.f()
            if (r1 != 0) goto L_0x031a
            r1 = r5 & 1
            if (r1 == 0) goto L_0x031a
        L_0x030f:
            r0 = r5 & 2
            if (r0 == 0) goto L_0x0315
            r0 = 1
            goto L_0x0316
        L_0x0315:
            r0 = 0
        L_0x0316:
            t2.a r0 = r4.b(r3, r0)
        L_0x031a:
            r4.f14517q = r0
            d2.y r1 = r4.f14508h
            r1.g(r0)
            d2.x0 r0 = r4.f14510j
            g1.z r1 = new g1.z
            r1.<init>()
            r2 = r26
            java.lang.String r6 = r2.f4213b
            r1.f6754k = r6
            r6 = 4096(0x1000, float:5.74E-42)
            r1.f6755l = r6
            int r6 = r2.f4216e
            r1.f6767x = r6
            int r6 = r2.f4215d
            r1.f6768y = r6
            int r6 = r15.f4186a
            r1.A = r6
            int r6 = r15.f4187b
            r1.B = r6
            r5 = r5 & 8
            if (r5 == 0) goto L_0x0349
            r5 = r20
            goto L_0x034b
        L_0x0349:
            g1.z0 r5 = r4.f14512l
        L_0x034b:
            r1.f6752i = r5
            g1.a0 r5 = new g1.a0
            r5.<init>(r1)
            r0.a(r5)
            long r0 = r40.p()
            r4.f14515o = r0
            goto L_0x0378
        L_0x035c:
            r4 = r0
            r3 = r1
            r2 = r5
            r29 = r11
            long r0 = r4.f14515o
            r5 = 0
            int r7 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x0378
            long r0 = r40.p()
            long r5 = r4.f14515o
            int r7 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r7 >= 0) goto L_0x0378
            long r5 = r5 - r0
            int r0 = (int) r5
            r3.g(r0)
        L_0x0378:
            int r0 = r4.f14516p
            if (r0 != 0) goto L_0x0430
            r40.f()
            boolean r0 = r39.g(r40)
            if (r0 == 0) goto L_0x0387
            goto L_0x043c
        L_0x0387:
            r1 = r29
            r0 = 0
            r1.G(r0)
            int r0 = r1.f()
            int r1 = r4.f14511k
            long r5 = (long) r1
            r1 = -128000(0xfffffffffffe0c00, float:NaN)
            r1 = r1 & r0
            long r7 = (long) r1
            r9 = -128000(0xfffffffffffe0c00, double:NaN)
            long r5 = r5 & r9
            int r1 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r1 != 0) goto L_0x03a3
            r1 = 1
            goto L_0x03a4
        L_0x03a3:
            r1 = 0
        L_0x03a4:
            if (r1 == 0) goto L_0x0428
            int r1 = d2.l0.a(r0)
            r5 = -1
            if (r1 != r5) goto L_0x03af
            goto L_0x0428
        L_0x03af:
            r2.a(r0)
            long r0 = r4.f14513m
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r7 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r7 != 0) goto L_0x03dd
            t2.f r0 = r4.f14517q
            long r7 = r40.p()
            long r0 = r0.g(r7)
            r4.f14513m = r0
            long r0 = r4.f14502b
            int r7 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x03dd
            t2.f r5 = r4.f14517q
            r6 = 0
            long r5 = r5.g(r6)
            long r7 = r4.f14513m
            long r0 = r0 - r5
            long r0 = r0 + r7
            r4.f14513m = r0
        L_0x03dd:
            int r0 = r2.f4214c
            r4.f14516p = r0
            t2.f r0 = r4.f14517q
            boolean r1 = r0 instanceof t2.b
            if (r1 == 0) goto L_0x0430
            t2.b r0 = (t2.b) r0
            long r5 = r4.f14514n
            int r1 = r2.f4218g
            long r7 = (long) r1
            long r5 = r5 + r7
            long r7 = r4.f14513m
            r9 = 1000000(0xf4240, double:4.940656E-318)
            long r5 = r5 * r9
            int r1 = r2.f4215d
            long r9 = (long) r1
            long r5 = r5 / r9
            long r5 = r5 + r7
            long r7 = r40.p()
            int r1 = r2.f4214c
            long r9 = (long) r1
            long r7 = r7 + r9
            boolean r1 = r0.a(r5)
            if (r1 == 0) goto L_0x040a
            goto L_0x0414
        L_0x040a:
            j1.w r1 = r0.f14494b
            r1.a(r5)
            j1.w r1 = r0.f14495c
            r1.a(r7)
        L_0x0414:
            boolean r1 = r4.f14519s
            if (r1 == 0) goto L_0x0430
            long r5 = r4.f14520t
            boolean r0 = r0.a(r5)
            if (r0 == 0) goto L_0x0430
            r0 = 0
            r4.f14519s = r0
            d2.x0 r1 = r4.f14509i
            r4.f14510j = r1
            goto L_0x0430
        L_0x0428:
            r0 = 0
            r1 = 1
            r3.g(r1)
            r4.f14511k = r0
            goto L_0x0445
        L_0x0430:
            r1 = 1
            d2.x0 r0 = r4.f14510j
            int r5 = r4.f14516p
            int r0 = r0.c(r3, r5, r1)
            r1 = -1
            if (r0 != r1) goto L_0x043e
        L_0x043c:
            r7 = -1
            goto L_0x046b
        L_0x043e:
            int r1 = r4.f14516p
            int r1 = r1 - r0
            r4.f14516p = r1
            if (r1 <= 0) goto L_0x0447
        L_0x0445:
            r0 = 0
            goto L_0x046a
        L_0x0447:
            d2.x0 r5 = r4.f14510j
            long r0 = r4.f14514n
            long r6 = r4.f14513m
            r8 = 1000000(0xf4240, double:4.940656E-318)
            long r0 = r0 * r8
            int r3 = r2.f4215d
            long r8 = (long) r3
            long r0 = r0 / r8
            long r6 = r6 + r0
            r8 = 1
            int r9 = r2.f4214c
            r10 = 0
            r11 = 0
            r5.e(r6, r8, r9, r10, r11)
            long r0 = r4.f14514n
            int r3 = r2.f4218g
            long r5 = (long) r3
            long r0 = r0 + r5
            r4.f14514n = r0
            r0 = 0
            r4.f14516p = r0
        L_0x046a:
            r7 = 0
        L_0x046b:
            r6 = r7
            r0 = -1
        L_0x046d:
            if (r6 != r0) goto L_0x0497
            t2.f r0 = r4.f14517q
            boolean r1 = r0 instanceof t2.b
            if (r1 == 0) goto L_0x0497
            long r7 = r4.f14514n
            long r9 = r4.f14513m
            r11 = 1000000(0xf4240, double:4.940656E-318)
            long r7 = r7 * r11
            int r1 = r2.f4215d
            long r1 = (long) r1
            long r7 = r7 / r1
            long r7 = r7 + r9
            long r0 = r0.j()
            int r2 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r2 == 0) goto L_0x0497
            t2.f r0 = r4.f14517q
            r1 = r0
            t2.b r1 = (t2.b) r1
            r1.f14496d = r7
            d2.y r1 = r4.f14508h
            r1.g(r0)
        L_0x0497:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: t2.d.d(d2.w, d2.s0):int");
    }

    public final void e(y yVar) {
        this.f14508h = yVar;
        x0 d10 = yVar.d(0, 1);
        this.f14509i = d10;
        this.f14510j = d10;
        this.f14508h.a();
    }

    public final boolean g(w wVar) {
        f fVar = this.f14517q;
        if (fVar != null) {
            long b10 = fVar.b();
            if (b10 != -1 && wVar.l() > b10 - 4) {
                return true;
            }
        }
        try {
            return !wVar.k(this.f14503c.f8414a, 0, 4, true);
        } catch (EOFException unused) {
            return true;
        }
    }

    public final boolean h(w wVar) {
        return i(wVar, true);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0074, code lost:
        if ((((long) (-128000 & r10)) == (((long) r3) & -128000)) != false) goto L_0x0076;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean i(d2.w r18, boolean r19) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            if (r19 == 0) goto L_0x000a
            r2 = 32768(0x8000, float:4.5918E-41)
            goto L_0x000c
        L_0x000a:
            r2 = 131072(0x20000, float:1.83671E-40)
        L_0x000c:
            r18.f()
            long r3 = r18.p()
            r5 = 1
            r6 = 0
            r7 = 0
            r9 = 0
            int r10 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r10 != 0) goto L_0x0045
            int r3 = r0.f14501a
            r3 = r3 & 8
            if (r3 != 0) goto L_0x0024
            r3 = 1
            goto L_0x0025
        L_0x0024:
            r3 = 0
        L_0x0025:
            if (r3 == 0) goto L_0x0029
            r3 = r9
            goto L_0x002b
        L_0x0029:
            i1.c r3 = f14500u
        L_0x002b:
            d2.i0 r4 = r0.f14506f
            g1.z0 r3 = r4.a(r1, r3)
            r0.f14512l = r3
            if (r3 == 0) goto L_0x003a
            d2.g0 r4 = r0.f14505e
            r4.b(r3)
        L_0x003a:
            long r3 = r18.l()
            int r4 = (int) r3
            if (r19 != 0) goto L_0x0046
            r1.g(r4)
            goto L_0x0046
        L_0x0045:
            r4 = 0
        L_0x0046:
            r3 = 0
            r7 = 0
            r8 = 0
        L_0x0049:
            boolean r10 = r17.g(r18)
            if (r10 == 0) goto L_0x0058
            if (r7 <= 0) goto L_0x0052
            goto L_0x00ab
        L_0x0052:
            java.io.EOFException r1 = new java.io.EOFException
            r1.<init>()
            throw r1
        L_0x0058:
            j1.b0 r10 = r0.f14503c
            r10.G(r6)
            int r10 = r10.f()
            if (r3 == 0) goto L_0x0076
            long r11 = (long) r3
            r13 = -128000(0xfffffffffffe0c00, float:NaN)
            r13 = r13 & r10
            long r13 = (long) r13
            r15 = -128000(0xfffffffffffe0c00, double:NaN)
            long r11 = r11 & r15
            int r15 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r15 != 0) goto L_0x0073
            r11 = 1
            goto L_0x0074
        L_0x0073:
            r11 = 0
        L_0x0074:
            if (r11 == 0) goto L_0x007d
        L_0x0076:
            int r11 = d2.l0.a(r10)
            r12 = -1
            if (r11 != r12) goto L_0x009d
        L_0x007d:
            int r3 = r8 + 1
            if (r8 != r2) goto L_0x008b
            if (r19 == 0) goto L_0x0084
            return r6
        L_0x0084:
            java.lang.String r1 = "Searched too many bytes."
            g1.b1 r1 = g1.b1.a(r1, r9)
            throw r1
        L_0x008b:
            if (r19 == 0) goto L_0x0096
            r18.f()
            int r7 = r4 + r3
            r1.n(r7)
            goto L_0x0099
        L_0x0096:
            r1.g(r5)
        L_0x0099:
            r8 = r3
            r3 = 0
            r7 = 0
            goto L_0x0049
        L_0x009d:
            int r7 = r7 + 1
            if (r7 != r5) goto L_0x00a8
            d2.k0 r3 = r0.f14504d
            r3.a(r10)
            r3 = r10
            goto L_0x00b8
        L_0x00a8:
            r10 = 4
            if (r7 != r10) goto L_0x00b8
        L_0x00ab:
            if (r19 == 0) goto L_0x00b2
            int r4 = r4 + r8
            r1.g(r4)
            goto L_0x00b5
        L_0x00b2:
            r18.f()
        L_0x00b5:
            r0.f14511k = r3
            return r5
        L_0x00b8:
            int r11 = r11 + -4
            r1.n(r11)
            goto L_0x0049
        */
        throw new UnsupportedOperationException("Method not decompiled: t2.d.i(d2.w, boolean):boolean");
    }

    public d(int i10) {
        this(-9223372036854775807L);
    }

    public d(long j10) {
        this.f14501a = 0;
        this.f14502b = j10;
        this.f14503c = new b0(10);
        this.f14504d = new k0();
        this.f14505e = new g0();
        this.f14513m = -9223372036854775807L;
        this.f14506f = new i0();
        u uVar = new u();
        this.f14507g = uVar;
        this.f14510j = uVar;
    }
}
