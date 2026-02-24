package u2;

import d2.p0;
import d2.u0;
import d2.v;
import d2.w;
import d2.y;
import d2.y0;
import j1.b0;
import j1.l0;
import java.util.ArrayDeque;
import java.util.ArrayList;
import p2.d;

public final class p implements v, u0 {

    /* renamed from: a  reason: collision with root package name */
    public final int f15273a;

    /* renamed from: b  reason: collision with root package name */
    public final b0 f15274b;

    /* renamed from: c  reason: collision with root package name */
    public final b0 f15275c;

    /* renamed from: d  reason: collision with root package name */
    public final b0 f15276d;

    /* renamed from: e  reason: collision with root package name */
    public final b0 f15277e;

    /* renamed from: f  reason: collision with root package name */
    public final ArrayDeque f15278f;

    /* renamed from: g  reason: collision with root package name */
    public final s f15279g;

    /* renamed from: h  reason: collision with root package name */
    public final ArrayList f15280h;

    /* renamed from: i  reason: collision with root package name */
    public int f15281i;

    /* renamed from: j  reason: collision with root package name */
    public int f15282j;

    /* renamed from: k  reason: collision with root package name */
    public long f15283k;

    /* renamed from: l  reason: collision with root package name */
    public int f15284l;

    /* renamed from: m  reason: collision with root package name */
    public b0 f15285m;

    /* renamed from: n  reason: collision with root package name */
    public int f15286n;

    /* renamed from: o  reason: collision with root package name */
    public int f15287o;

    /* renamed from: p  reason: collision with root package name */
    public int f15288p;

    /* renamed from: q  reason: collision with root package name */
    public int f15289q;

    /* renamed from: r  reason: collision with root package name */
    public y f15290r;

    /* renamed from: s  reason: collision with root package name */
    public o[] f15291s;

    /* renamed from: t  reason: collision with root package name */
    public long[][] f15292t;

    /* renamed from: u  reason: collision with root package name */
    public int f15293u;

    /* renamed from: v  reason: collision with root package name */
    public long f15294v;

    /* renamed from: w  reason: collision with root package name */
    public int f15295w;

    /* renamed from: x  reason: collision with root package name */
    public d f15296x;

    public p() {
        this(0);
    }

    public final void a() {
    }

    public final void c(long j10, long j11) {
        this.f15278f.clear();
        this.f15284l = 0;
        this.f15286n = -1;
        this.f15287o = 0;
        this.f15288p = 0;
        this.f15289q = 0;
        if (j10 != 0) {
            for (o oVar : this.f15291s) {
                x xVar = oVar.f15269b;
                int f10 = l0.f(xVar.f15343f, j11, false);
                while (true) {
                    if (f10 < 0) {
                        f10 = -1;
                        break;
                    } else if ((xVar.f15344g[f10] & 1) != 0) {
                        break;
                    } else {
                        f10--;
                    }
                }
                if (f10 == -1) {
                    f10 = xVar.a(j11);
                }
                oVar.f15272e = f10;
                y0 y0Var = oVar.f15271d;
                if (y0Var != null) {
                    y0Var.f4309b = false;
                    y0Var.f4310c = 0;
                }
            }
        } else if (this.f15281i != 3) {
            this.f15281i = 0;
            this.f15284l = 0;
        } else {
            s sVar = this.f15279g;
            sVar.f15301a.clear();
            sVar.f15302b = 0;
            this.f15280h.clear();
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Removed duplicated region for block: B:224:0x0469  */
    /* JADX WARNING: Removed duplicated region for block: B:225:0x046b  */
    /* JADX WARNING: Removed duplicated region for block: B:259:0x052b  */
    /* JADX WARNING: Removed duplicated region for block: B:347:0x0674 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:348:0x046e A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:349:0x0672 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:350:0x0006 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:351:0x0006 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int d(d2.w r37, d2.s0 r38) {
        /*
            r36 = this;
            r1 = r36
            r0 = r37
            r2 = r38
        L_0x0006:
            int r3 = r1.f15281i
            java.util.ArrayDeque r4 = r1.f15278f
            r8 = 0
            r9 = 4
            r13 = 2
            r15 = 1
            r7 = 0
            j1.b0 r10 = r1.f15276d
            if (r3 == 0) goto L_0x0470
            r17 = 262144(0x40000, double:1.295163E-318)
            if (r3 == r15) goto L_0x03dc
            r19 = 8
            if (r3 == r13) goto L_0x023e
            r4 = 3
            if (r3 != r4) goto L_0x0238
            java.util.ArrayList r3 = r1.f15280h
            u2.s r10 = r1.f15279g
            int r5 = r10.f15302b
            if (r5 == 0) goto L_0x0210
            if (r5 == r15) goto L_0x01df
            java.util.ArrayList r6 = r10.f15301a
            r14 = 2192(0x890, float:3.072E-42)
            if (r5 == r13) goto L_0x0169
            if (r5 != r4) goto L_0x0163
            long r18 = r37.p()
            long r20 = r37.c()
            long r22 = r37.p()
            long r20 = r20 - r22
            int r5 = r10.f15303c
            long r11 = (long) r5
            long r10 = r20 - r11
            int r5 = (int) r10
            j1.b0 r10 = new j1.b0
            r10.<init>((int) r5)
            byte[] r11 = r10.f8414a
            r0.readFully(r11, r7, r5)
            r0 = 0
        L_0x0050:
            int r5 = r6.size()
            if (r0 >= r5) goto L_0x015d
            java.lang.Object r5 = r6.get(r0)
            u2.r r5 = (u2.r) r5
            long r11 = r5.f15297a
            long r11 = r11 - r18
            int r12 = (int) r11
            r10.G(r12)
            r10.H(r9)
            int r11 = r10.i()
            java.lang.String r12 = r10.s(r11)
            int r20 = r12.hashCode()
            switch(r20) {
                case -1711564334: goto L_0x00a3;
                case -1332107749: goto L_0x0098;
                case -1251387154: goto L_0x008d;
                case -830665521: goto L_0x0082;
                case 1760745220: goto L_0x0077;
                default: goto L_0x0076;
            }
        L_0x0076:
            goto L_0x00ae
        L_0x0077:
            java.lang.String r7 = "Super_SlowMotion_BGM"
            boolean r7 = r12.equals(r7)
            if (r7 != 0) goto L_0x0080
            goto L_0x00ae
        L_0x0080:
            r7 = 4
            goto L_0x00af
        L_0x0082:
            java.lang.String r7 = "Super_SlowMotion_Deflickering_On"
            boolean r7 = r12.equals(r7)
            if (r7 != 0) goto L_0x008b
            goto L_0x00ae
        L_0x008b:
            r7 = 3
            goto L_0x00af
        L_0x008d:
            java.lang.String r7 = "Super_SlowMotion_Data"
            boolean r7 = r12.equals(r7)
            if (r7 != 0) goto L_0x0096
            goto L_0x00ae
        L_0x0096:
            r7 = 2
            goto L_0x00af
        L_0x0098:
            java.lang.String r7 = "Super_SlowMotion_Edit_Data"
            boolean r7 = r12.equals(r7)
            if (r7 != 0) goto L_0x00a1
            goto L_0x00ae
        L_0x00a1:
            r7 = 1
            goto L_0x00af
        L_0x00a3:
            java.lang.String r7 = "SlowMotion_Data"
            boolean r7 = r12.equals(r7)
            if (r7 != 0) goto L_0x00ac
            goto L_0x00ae
        L_0x00ac:
            r7 = 0
            goto L_0x00af
        L_0x00ae:
            r7 = -1
        L_0x00af:
            if (r7 == 0) goto L_0x00cc
            if (r7 == r15) goto L_0x00c9
            if (r7 == r13) goto L_0x00c6
            if (r7 == r4) goto L_0x00c3
            if (r7 != r9) goto L_0x00bc
            r7 = 2817(0xb01, float:3.947E-42)
            goto L_0x00ce
        L_0x00bc:
            java.lang.String r0 = "Invalid SEF name"
            g1.b1 r0 = g1.b1.a(r0, r8)
            throw r0
        L_0x00c3:
            r7 = 2820(0xb04, float:3.952E-42)
            goto L_0x00ce
        L_0x00c6:
            r7 = 2816(0xb00, float:3.946E-42)
            goto L_0x00ce
        L_0x00c9:
            r7 = 2819(0xb03, float:3.95E-42)
            goto L_0x00ce
        L_0x00cc:
            r7 = 2192(0x890, float:3.072E-42)
        L_0x00ce:
            int r11 = r11 + 8
            int r5 = r5.f15298b
            int r5 = r5 - r11
            if (r7 == r14) goto L_0x00ec
            r11 = 2816(0xb00, float:3.946E-42)
            if (r7 == r11) goto L_0x0157
            r5 = 2817(0xb01, float:3.947E-42)
            if (r7 == r5) goto L_0x0157
            r5 = 2819(0xb03, float:3.95E-42)
            if (r7 == r5) goto L_0x0157
            r5 = 2820(0xb04, float:3.952E-42)
            if (r7 != r5) goto L_0x00e6
            goto L_0x0157
        L_0x00e6:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r0.<init>()
            throw r0
        L_0x00ec:
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.lang.String r5 = r10.s(r5)
            c9.u r11 = u2.s.f15300e
            java.util.List r5 = r11.a(r5)
            r11 = 0
        L_0x00fc:
            int r12 = r5.size()
            if (r11 >= r12) goto L_0x014f
            java.lang.Object r12 = r5.get(r11)
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            c9.u r9 = u2.s.f15299d
            java.util.List r9 = r9.a(r12)
            int r12 = r9.size()
            if (r12 != r4) goto L_0x014a
            r12 = 0
            java.lang.Object r20 = r9.get(r12)     // Catch:{ NumberFormatException -> 0x0144 }
            java.lang.String r20 = (java.lang.String) r20     // Catch:{ NumberFormatException -> 0x0144 }
            long r26 = java.lang.Long.parseLong(r20)     // Catch:{ NumberFormatException -> 0x0144 }
            java.lang.Object r12 = r9.get(r15)     // Catch:{ NumberFormatException -> 0x0144 }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ NumberFormatException -> 0x0144 }
            long r28 = java.lang.Long.parseLong(r12)     // Catch:{ NumberFormatException -> 0x0144 }
            java.lang.Object r9 = r9.get(r13)     // Catch:{ NumberFormatException -> 0x0144 }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ NumberFormatException -> 0x0144 }
            int r9 = java.lang.Integer.parseInt(r9)     // Catch:{ NumberFormatException -> 0x0144 }
            int r9 = r9 - r15
            int r25 = r15 << r9
            p2.g r9 = new p2.g     // Catch:{ NumberFormatException -> 0x0144 }
            r24 = r9
            r24.<init>(r25, r26, r28)     // Catch:{ NumberFormatException -> 0x0144 }
            r7.add(r9)     // Catch:{ NumberFormatException -> 0x0144 }
            int r11 = r11 + 1
            r9 = 4
            goto L_0x00fc
        L_0x0144:
            r0 = move-exception
            g1.b1 r0 = g1.b1.a(r8, r0)
            throw r0
        L_0x014a:
            g1.b1 r0 = g1.b1.a(r8, r8)
            throw r0
        L_0x014f:
            p2.h r5 = new p2.h
            r5.<init>(r7)
            r3.add(r5)
        L_0x0157:
            int r0 = r0 + 1
            r7 = 0
            r9 = 4
            goto L_0x0050
        L_0x015d:
            r11 = 0
            r2.f4296a = r11
            goto L_0x0229
        L_0x0163:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r0.<init>()
            throw r0
        L_0x0169:
            long r7 = r37.c()
            int r3 = r10.f15303c
            int r3 = r3 + -12
            r5 = 8
            int r3 = r3 - r5
            j1.b0 r5 = new j1.b0
            r5.<init>((int) r3)
            byte[] r9 = r5.f8414a
            r11 = 0
            r0.readFully(r9, r11, r3)
            r0 = 0
        L_0x0180:
            int r9 = r3 / 12
            if (r0 >= r9) goto L_0x01c7
            r5.H(r13)
            short r9 = r5.k()
            if (r9 == r14) goto L_0x01a6
            r11 = 2816(0xb00, float:3.946E-42)
            if (r9 == r11) goto L_0x01a6
            r12 = 2817(0xb01, float:3.947E-42)
            if (r9 == r12) goto L_0x01a3
            r11 = 2819(0xb03, float:3.95E-42)
            if (r9 == r11) goto L_0x01a3
            r11 = 2820(0xb04, float:3.952E-42)
            if (r9 == r11) goto L_0x01aa
            r9 = 8
            r5.H(r9)
            goto L_0x01c1
        L_0x01a3:
            r11 = 2820(0xb04, float:3.952E-42)
            goto L_0x01aa
        L_0x01a6:
            r11 = 2820(0xb04, float:3.952E-42)
            r12 = 2817(0xb01, float:3.947E-42)
        L_0x01aa:
            int r9 = r10.f15303c
            long r11 = (long) r9
            long r11 = r7 - r11
            int r9 = r5.i()
            long r14 = (long) r9
            long r11 = r11 - r14
            int r9 = r5.i()
            u2.r r14 = new u2.r
            r14.<init>(r11, r9)
            r6.add(r14)
        L_0x01c1:
            int r0 = r0 + 1
            r14 = 2192(0x890, float:3.072E-42)
            r15 = 1
            goto L_0x0180
        L_0x01c7:
            boolean r0 = r6.isEmpty()
            if (r0 == 0) goto L_0x01d1
            r3 = 0
            r4 = 0
            goto L_0x01dc
        L_0x01d1:
            r10.f15302b = r4
            r3 = 0
            java.lang.Object r0 = r6.get(r3)
            u2.r r0 = (u2.r) r0
            long r4 = r0.f15297a
        L_0x01dc:
            r2.f4296a = r4
            goto L_0x0229
        L_0x01df:
            r3 = 0
            j1.b0 r4 = new j1.b0
            r5 = 8
            r4.<init>((int) r5)
            byte[] r6 = r4.f8414a
            r0.readFully(r6, r3, r5)
            int r3 = r4.i()
            int r3 = r3 + r5
            r10.f15303c = r3
            int r3 = r4.f()
            r4 = 1397048916(0x53454654, float:8.4728847E11)
            if (r3 == r4) goto L_0x0201
            r3 = 0
            r2.f4296a = r3
            goto L_0x0229
        L_0x0201:
            long r3 = r37.p()
            int r0 = r10.f15303c
            int r0 = r0 + -12
            long r5 = (long) r0
            long r3 = r3 - r5
            r2.f4296a = r3
            r10.f15302b = r13
            goto L_0x0229
        L_0x0210:
            long r3 = r37.c()
            r5 = -1
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 == 0) goto L_0x0222
            int r0 = (r3 > r19 ? 1 : (r3 == r19 ? 0 : -1))
            if (r0 >= 0) goto L_0x021f
            goto L_0x0222
        L_0x021f:
            long r3 = r3 - r19
            goto L_0x0224
        L_0x0222:
            r3 = 0
        L_0x0224:
            r2.f4296a = r3
            r0 = 1
            r10.f15302b = r0
        L_0x0229:
            long r2 = r2.f4296a
            r4 = 0
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 != 0) goto L_0x0236
            r0 = 0
            r1.f15281i = r0
            r1.f15284l = r0
        L_0x0236:
            r0 = 1
            return r0
        L_0x0238:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r0.<init>()
            throw r0
        L_0x023e:
            long r3 = r37.p()
            int r5 = r1.f15286n
            r6 = -1
            if (r5 != r6) goto L_0x02bf
            r7 = -1
            r9 = -1
            r11 = 0
            r12 = 1
            r14 = 1
            r15 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r21 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r25 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
        L_0x025b:
            u2.o[] r8 = r1.f15291s
            int r13 = r8.length
            if (r11 >= r13) goto L_0x02a3
            r8 = r8[r11]
            int r13 = r8.f15272e
            u2.x r8 = r8.f15269b
            int r5 = r8.f15339b
            if (r13 != r5) goto L_0x026b
            goto L_0x029f
        L_0x026b:
            long[] r5 = r8.f15340c
            r30 = r5[r13]
            long[][] r5 = r1.f15292t
            int r6 = j1.l0.f8453a
            r5 = r5[r11]
            r32 = r5[r13]
            long r30 = r30 - r3
            r5 = 0
            int r8 = (r30 > r5 ? 1 : (r30 == r5 ? 0 : -1))
            if (r8 < 0) goto L_0x0286
            int r5 = (r30 > r17 ? 1 : (r30 == r17 ? 0 : -1))
            if (r5 < 0) goto L_0x0284
            goto L_0x0286
        L_0x0284:
            r5 = 0
            goto L_0x0287
        L_0x0286:
            r5 = 1
        L_0x0287:
            if (r5 != 0) goto L_0x028b
            if (r14 != 0) goto L_0x0291
        L_0x028b:
            if (r5 != r14) goto L_0x0297
            int r6 = (r30 > r25 ? 1 : (r30 == r25 ? 0 : -1))
            if (r6 >= 0) goto L_0x0297
        L_0x0291:
            r14 = r5
            r9 = r11
            r25 = r30
            r21 = r32
        L_0x0297:
            int r6 = (r32 > r15 ? 1 : (r32 == r15 ? 0 : -1))
            if (r6 >= 0) goto L_0x029f
            r12 = r5
            r7 = r11
            r15 = r32
        L_0x029f:
            int r11 = r11 + 1
            r13 = 2
            goto L_0x025b
        L_0x02a3:
            r5 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            int r8 = (r15 > r5 ? 1 : (r15 == r5 ? 0 : -1))
            if (r8 == 0) goto L_0x02b6
            if (r12 == 0) goto L_0x02b6
            r5 = 10485760(0xa00000, double:5.180654E-317)
            long r15 = r15 + r5
            int r5 = (r21 > r15 ? 1 : (r21 == r15 ? 0 : -1))
            if (r5 >= 0) goto L_0x02b7
        L_0x02b6:
            r7 = r9
        L_0x02b7:
            r1.f15286n = r7
            r5 = -1
            if (r7 != r5) goto L_0x02bf
            r10 = -1
            goto L_0x03db
        L_0x02bf:
            u2.o[] r5 = r1.f15291s
            int r6 = r1.f15286n
            r5 = r5[r6]
            d2.x0 r6 = r5.f15270c
            int r7 = r5.f15272e
            u2.x r8 = r5.f15269b
            long[] r9 = r8.f15340c
            r11 = r9[r7]
            int[] r9 = r8.f15341d
            r9 = r9[r7]
            long r3 = r11 - r3
            int r13 = r1.f15287o
            long r13 = (long) r13
            long r3 = r3 + r13
            r13 = 0
            int r15 = (r3 > r13 ? 1 : (r3 == r13 ? 0 : -1))
            if (r15 < 0) goto L_0x03d8
            int r13 = (r3 > r17 ? 1 : (r3 == r17 ? 0 : -1))
            if (r13 < 0) goto L_0x02e5
            goto L_0x03d8
        L_0x02e5:
            u2.u r2 = r5.f15268a
            int r11 = r2.f15311g
            r12 = 1
            if (r11 != r12) goto L_0x02f0
            long r3 = r3 + r19
            int r9 = r9 + -8
        L_0x02f0:
            int r4 = (int) r3
            r0.g(r4)
            int r3 = r2.f15314j
            d2.y0 r4 = r5.f15271d
            if (r3 == 0) goto L_0x0352
            j1.b0 r2 = r1.f15275c
            byte[] r10 = r2.f8414a
            r11 = 0
            r10[r11] = r11
            r12 = 1
            r10[r12] = r11
            r12 = 2
            r10[r12] = r11
            int r11 = 4 - r3
        L_0x0309:
            int r12 = r1.f15288p
            if (r12 >= r9) goto L_0x0391
            int r12 = r1.f15289q
            if (r12 != 0) goto L_0x033d
            r0.readFully(r10, r11, r3)
            int r12 = r1.f15287o
            int r12 = r12 + r3
            r1.f15287o = r12
            r13 = 0
            r2.G(r13)
            int r12 = r2.f()
            if (r12 < 0) goto L_0x0335
            r1.f15289q = r12
            j1.b0 r12 = r1.f15274b
            r12.G(r13)
            r14 = 4
            r6.d(r14, r12)
            int r12 = r1.f15288p
            int r12 = r12 + r14
            r1.f15288p = r12
            int r9 = r9 + r11
            goto L_0x0309
        L_0x0335:
            java.lang.String r0 = "Invalid NAL length"
            r2 = 0
            g1.b1 r0 = g1.b1.a(r0, r2)
            throw r0
        L_0x033d:
            r13 = 0
            int r12 = r6.c(r0, r12, r13)
            int r13 = r1.f15287o
            int r13 = r13 + r12
            r1.f15287o = r13
            int r13 = r1.f15288p
            int r13 = r13 + r12
            r1.f15288p = r13
            int r13 = r1.f15289q
            int r13 = r13 - r12
            r1.f15289q = r13
            goto L_0x0309
        L_0x0352:
            g1.a0 r2 = r2.f15310f
            java.lang.String r2 = r2.f6276s
            java.lang.String r3 = "audio/ac4"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x0371
            int r2 = r1.f15288p
            if (r2 != 0) goto L_0x036e
            d2.d.a(r9, r10)
            r2 = 7
            r6.d(r2, r10)
            int r3 = r1.f15288p
            int r3 = r3 + r2
            r1.f15288p = r3
        L_0x036e:
            int r9 = r9 + 7
            goto L_0x0376
        L_0x0371:
            if (r4 == 0) goto L_0x0376
            r4.c(r0)
        L_0x0376:
            int r2 = r1.f15288p
            if (r2 >= r9) goto L_0x0391
            int r2 = r9 - r2
            r3 = 0
            int r2 = r6.c(r0, r2, r3)
            int r3 = r1.f15287o
            int r3 = r3 + r2
            r1.f15287o = r3
            int r3 = r1.f15288p
            int r3 = r3 + r2
            r1.f15288p = r3
            int r3 = r1.f15289q
            int r3 = r3 - r2
            r1.f15289q = r3
            goto L_0x0376
        L_0x0391:
            long[] r0 = r8.f15343f
            r2 = r0[r7]
            int[] r0 = r8.f15344g
            r0 = r0[r7]
            if (r4 == 0) goto L_0x03b7
            r34 = 0
            r35 = 0
            r28 = r4
            r29 = r6
            r30 = r2
            r32 = r0
            r33 = r9
            r28.b(r29, r30, r32, r33, r34, r35)
            r0 = 1
            int r7 = r7 + r0
            int r0 = r8.f15339b
            if (r7 != r0) goto L_0x03c6
            r2 = 0
            r4.a(r6, r2)
            goto L_0x03c6
        L_0x03b7:
            r33 = 0
            r34 = 0
            r28 = r6
            r29 = r2
            r31 = r0
            r32 = r9
            r28.e(r29, r31, r32, r33, r34)
        L_0x03c6:
            int r0 = r5.f15272e
            r2 = 1
            int r0 = r0 + r2
            r5.f15272e = r0
            r0 = -1
            r1.f15286n = r0
            r0 = 0
            r1.f15287o = r0
            r1.f15288p = r0
            r1.f15289q = r0
            r10 = 0
            goto L_0x03db
        L_0x03d8:
            r2.f4296a = r11
            r10 = 1
        L_0x03db:
            return r10
        L_0x03dc:
            long r5 = r1.f15283k
            int r3 = r1.f15284l
            long r7 = (long) r3
            long r5 = r5 - r7
            long r7 = r37.p()
            long r7 = r7 + r5
            j1.b0 r3 = r1.f15285m
            if (r3 == 0) goto L_0x044d
            byte[] r9 = r3.f8414a
            int r10 = r1.f15284l
            int r6 = (int) r5
            r0.readFully(r9, r10, r6)
            int r5 = r1.f15282j
            r6 = 1718909296(0x66747970, float:2.8862439E23)
            if (r5 != r6) goto L_0x0434
            r5 = 8
            r3.G(r5)
            int r4 = r3.f()
            r5 = 1903435808(0x71742020, float:1.2088509E30)
            r6 = 1751476579(0x68656963, float:4.333464E24)
            if (r4 == r6) goto L_0x0411
            if (r4 == r5) goto L_0x040f
            r4 = 0
            goto L_0x0412
        L_0x040f:
            r4 = 1
            goto L_0x0412
        L_0x0411:
            r4 = 2
        L_0x0412:
            if (r4 == 0) goto L_0x0415
            goto L_0x0431
        L_0x0415:
            r4 = 4
            r3.H(r4)
        L_0x0419:
            int r4 = r3.f8416c
            int r9 = r3.f8415b
            int r4 = r4 - r9
            if (r4 <= 0) goto L_0x0430
            int r4 = r3.f()
            if (r4 == r6) goto L_0x042c
            if (r4 == r5) goto L_0x042a
            r4 = 0
            goto L_0x042d
        L_0x042a:
            r4 = 1
            goto L_0x042d
        L_0x042c:
            r4 = 2
        L_0x042d:
            if (r4 == 0) goto L_0x0419
            goto L_0x0431
        L_0x0430:
            r4 = 0
        L_0x0431:
            r1.f15295w = r4
            goto L_0x0455
        L_0x0434:
            boolean r5 = r4.isEmpty()
            if (r5 != 0) goto L_0x0455
            java.lang.Object r4 = r4.peek()
            u2.a r4 = (u2.a) r4
            u2.b r5 = new u2.b
            int r6 = r1.f15282j
            r5.<init>(r6, r3)
            java.util.ArrayList r3 = r4.f15197d
            r3.add(r5)
            goto L_0x0455
        L_0x044d:
            int r3 = (r5 > r17 ? 1 : (r5 == r17 ? 0 : -1))
            if (r3 >= 0) goto L_0x0457
            int r3 = (int) r5
            r0.g(r3)
        L_0x0455:
            r3 = 0
            goto L_0x045f
        L_0x0457:
            long r3 = r37.p()
            long r3 = r3 + r5
            r2.f4296a = r3
            r3 = 1
        L_0x045f:
            r1.k(r7)
            if (r3 == 0) goto L_0x046b
            int r3 = r1.f15281i
            r4 = 2
            if (r3 == r4) goto L_0x046b
            r7 = 1
            goto L_0x046c
        L_0x046b:
            r7 = 0
        L_0x046c:
            if (r7 == 0) goto L_0x0006
            r3 = 1
            return r3
        L_0x0470:
            r3 = 1
            int r5 = r1.f15284l
            j1.b0 r6 = r1.f15277e
            if (r5 != 0) goto L_0x04e0
            byte[] r5 = r6.f8414a
            r7 = 8
            r8 = 0
            boolean r5 = r0.b(r5, r8, r7, r3)
            if (r5 != 0) goto L_0x04cc
            int r3 = r1.f15295w
            r4 = 2
            if (r3 != r4) goto L_0x04c9
            int r3 = r1.f15273a
            r3 = r3 & r4
            if (r3 == 0) goto L_0x04c9
            d2.y r3 = r1.f15290r
            r4 = 4
            d2.x0 r3 = r3.d(r8, r4)
            p2.d r4 = r1.f15296x
            if (r4 != 0) goto L_0x0499
            r8 = 0
            goto L_0x04a6
        L_0x0499:
            g1.z0 r4 = new g1.z0
            r5 = 1
            g1.y0[] r5 = new g1.y0[r5]
            p2.d r6 = r1.f15296x
            r5[r8] = r6
            r4.<init>((g1.y0[]) r5)
            r8 = r4
        L_0x04a6:
            g1.z r4 = new g1.z
            r4.<init>()
            r4.f6752i = r8
            g1.a0 r5 = new g1.a0
            r5.<init>(r4)
            r3.a(r5)
            d2.y r3 = r1.f15290r
            r3.a()
            d2.y r3 = r1.f15290r
            d2.e0 r4 = new d2.e0
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r4.<init>(r5)
            r3.g(r4)
        L_0x04c9:
            r15 = 0
            goto L_0x0670
        L_0x04cc:
            r3 = 8
            r1.f15284l = r3
            r3 = 0
            r6.G(r3)
            long r7 = r6.w()
            r1.f15283k = r7
            int r3 = r6.f()
            r1.f15282j = r3
        L_0x04e0:
            long r7 = r1.f15283k
            r11 = 1
            int r3 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r3 != 0) goto L_0x04f9
            byte[] r3 = r6.f8414a
            r5 = 8
            r0.readFully(r3, r5, r5)
            int r3 = r1.f15284l
            int r3 = r3 + r5
            r1.f15284l = r3
            long r7 = r6.z()
            goto L_0x0520
        L_0x04f9:
            r11 = 0
            int r3 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r3 != 0) goto L_0x0522
            long r7 = r37.c()
            r11 = -1
            int r3 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r3 != 0) goto L_0x0513
            java.lang.Object r3 = r4.peek()
            u2.a r3 = (u2.a) r3
            if (r3 == 0) goto L_0x0513
            long r7 = r3.f15196c
        L_0x0513:
            int r3 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r3 == 0) goto L_0x0522
            long r11 = r37.p()
            long r7 = r7 - r11
            int r3 = r1.f15284l
            long r11 = (long) r3
            long r7 = r7 + r11
        L_0x0520:
            r1.f15283k = r7
        L_0x0522:
            long r7 = r1.f15283k
            int r3 = r1.f15284l
            long r11 = (long) r3
            int r5 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r5 < 0) goto L_0x0674
            int r5 = r1.f15282j
            r7 = 1836019574(0x6d6f6f76, float:4.631354E27)
            r8 = 1835365473(0x6d657461, float:4.4382975E27)
            if (r5 == r7) goto L_0x0553
            r7 = 1953653099(0x7472616b, float:7.681346E31)
            if (r5 == r7) goto L_0x0553
            r7 = 1835297121(0x6d646961, float:4.4181236E27)
            if (r5 == r7) goto L_0x0553
            r7 = 1835626086(0x6d696e66, float:4.515217E27)
            if (r5 == r7) goto L_0x0553
            r7 = 1937007212(0x7374626c, float:1.9362132E31)
            if (r5 == r7) goto L_0x0553
            r7 = 1701082227(0x65647473, float:6.742798E22)
            if (r5 == r7) goto L_0x0553
            if (r5 != r8) goto L_0x0551
            goto L_0x0553
        L_0x0551:
            r7 = 0
            goto L_0x0554
        L_0x0553:
            r7 = 1
        L_0x0554:
            r9 = 1751411826(0x68646c72, float:4.3148E24)
            if (r7 == 0) goto L_0x05b1
            long r5 = r37.p()
            long r11 = r1.f15283k
            long r5 = r5 + r11
            int r3 = r1.f15284l
            long r13 = (long) r3
            long r5 = r5 - r13
            int r3 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r3 == 0) goto L_0x0592
            int r3 = r1.f15282j
            if (r3 != r8) goto L_0x0592
            r3 = 8
            r10.D(r3)
            byte[] r7 = r10.f8414a
            r8 = 0
            r0.m(r7, r8, r3)
            byte[] r3 = u2.h.f15220a
            int r3 = r10.f8415b
            r7 = 4
            r10.H(r7)
            int r7 = r10.f()
            if (r7 == r9) goto L_0x0587
            int r3 = r3 + 4
        L_0x0587:
            r10.G(r3)
            int r3 = r10.f8415b
            r0.g(r3)
            r37.f()
        L_0x0592:
            u2.a r3 = new u2.a
            int r7 = r1.f15282j
            r3.<init>(r7, r5)
            r4.push(r3)
            long r3 = r1.f15283k
            int r7 = r1.f15284l
            long r7 = (long) r7
            int r9 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r9 != 0) goto L_0x05aa
            r1.k(r5)
            goto L_0x063e
        L_0x05aa:
            r3 = 0
            r1.f15281i = r3
            r1.f15284l = r3
            goto L_0x063e
        L_0x05b1:
            r4 = 1835296868(0x6d646864, float:4.418049E27)
            if (r5 == r4) goto L_0x060b
            r4 = 1836476516(0x6d766864, float:4.7662196E27)
            if (r5 == r4) goto L_0x060b
            if (r5 == r9) goto L_0x060b
            r4 = 1937011556(0x73747364, float:1.9367383E31)
            if (r5 == r4) goto L_0x060b
            r4 = 1937011827(0x73747473, float:1.9367711E31)
            if (r5 == r4) goto L_0x060b
            r4 = 1937011571(0x73747373, float:1.9367401E31)
            if (r5 == r4) goto L_0x060b
            r4 = 1668576371(0x63747473, float:4.5093966E21)
            if (r5 == r4) goto L_0x060b
            r4 = 1701606260(0x656c7374, float:6.9788014E22)
            if (r5 == r4) goto L_0x060b
            r4 = 1937011555(0x73747363, float:1.9367382E31)
            if (r5 == r4) goto L_0x060b
            r4 = 1937011578(0x7374737a, float:1.936741E31)
            if (r5 == r4) goto L_0x060b
            r4 = 1937013298(0x73747a32, float:1.9369489E31)
            if (r5 == r4) goto L_0x060b
            r4 = 1937007471(0x7374636f, float:1.9362445E31)
            if (r5 == r4) goto L_0x060b
            r4 = 1668232756(0x636f3634, float:4.4126776E21)
            if (r5 == r4) goto L_0x060b
            r4 = 1953196132(0x746b6864, float:7.46037E31)
            if (r5 == r4) goto L_0x060b
            r4 = 1718909296(0x66747970, float:2.8862439E23)
            if (r5 == r4) goto L_0x060b
            r4 = 1969517665(0x75647461, float:2.8960062E32)
            if (r5 == r4) goto L_0x060b
            r4 = 1801812339(0x6b657973, float:2.7741754E26)
            if (r5 == r4) goto L_0x060b
            r4 = 1768715124(0x696c7374, float:1.7865732E25)
            if (r5 != r4) goto L_0x0609
            goto L_0x060b
        L_0x0609:
            r12 = 0
            goto L_0x060c
        L_0x060b:
            r12 = 1
        L_0x060c:
            if (r12 == 0) goto L_0x0640
            r4 = 8
            if (r3 != r4) goto L_0x0614
            r12 = 1
            goto L_0x0615
        L_0x0614:
            r12 = 0
        L_0x0615:
            j1.a.e(r12)
            long r3 = r1.f15283k
            r7 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r5 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r5 > 0) goto L_0x0623
            r12 = 1
            goto L_0x0624
        L_0x0623:
            r12 = 0
        L_0x0624:
            j1.a.e(r12)
            j1.b0 r3 = new j1.b0
            long r4 = r1.f15283k
            int r5 = (int) r4
            r3.<init>((int) r5)
            byte[] r4 = r6.f8414a
            byte[] r5 = r3.f8414a
            r6 = 8
            r7 = 0
            java.lang.System.arraycopy(r4, r7, r5, r7, r6)
            r1.f15285m = r3
            r3 = 1
            r1.f15281i = r3
        L_0x063e:
            r3 = 1
            goto L_0x066f
        L_0x0640:
            long r3 = r37.p()
            int r5 = r1.f15284l
            long r5 = (long) r5
            long r28 = r3 - r5
            int r3 = r1.f15282j
            r4 = 1836086884(0x6d707664, float:4.6512205E27)
            if (r3 != r4) goto L_0x0669
            p2.d r3 = new p2.d
            r26 = 0
            r30 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r4 = r1.f15284l
            long r4 = (long) r4
            long r32 = r28 + r4
            long r6 = r1.f15283k
            long r34 = r6 - r4
            r25 = r3
            r25.<init>(r26, r28, r30, r32, r34)
            r1.f15296x = r3
        L_0x0669:
            r3 = 0
            r1.f15285m = r3
            r3 = 1
            r1.f15281i = r3
        L_0x066f:
            r15 = 1
        L_0x0670:
            if (r15 != 0) goto L_0x0006
            r3 = -1
            return r3
        L_0x0674:
            java.lang.String r0 = "Atom size less than header length (unsupported)."
            g1.b1 r0 = g1.b1.c(r0)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: u2.p.d(d2.w, d2.s0):int");
    }

    public final void e(y yVar) {
        this.f15290r = yVar;
    }

    public final boolean f() {
        return true;
    }

    public final boolean h(w wVar) {
        boolean z10;
        if ((this.f15273a & 2) != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        return t.a(wVar, false, z10);
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00ec  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00d8 A[EDGE_INSN: B:62:0x00d8->B:55:0x00d8 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final d2.t0 i(long r17) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            u2.o[] r3 = r0.f15291s
            int r4 = r3.length
            d2.v0 r5 = d2.v0.f4300c
            if (r4 != 0) goto L_0x0012
            d2.t0 r1 = new d2.t0
            r1.<init>(r5, r5)
            goto L_0x00f7
        L_0x0012:
            int r4 = r0.f15293u
            r6 = 0
            r7 = -1
            if (r4 == r7) goto L_0x0060
            r3 = r3[r4]
            u2.x r3 = r3.f15269b
            long[] r4 = r3.f15343f
            int r4 = j1.l0.f(r4, r1, r6)
        L_0x0022:
            if (r4 < 0) goto L_0x0030
            int[] r10 = r3.f15344g
            r10 = r10[r4]
            r10 = r10 & 1
            if (r10 == 0) goto L_0x002d
            goto L_0x0031
        L_0x002d:
            int r4 = r4 + -1
            goto L_0x0022
        L_0x0030:
            r4 = -1
        L_0x0031:
            if (r4 != r7) goto L_0x0037
            int r4 = r3.a(r1)
        L_0x0037:
            if (r4 != r7) goto L_0x0040
            d2.t0 r1 = new d2.t0
            r1.<init>(r5, r5)
            goto L_0x00f7
        L_0x0040:
            long[] r5 = r3.f15343f
            r10 = r5[r4]
            long[] r12 = r3.f15340c
            r13 = r12[r4]
            int r15 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r15 >= 0) goto L_0x005e
            int r15 = r3.f15339b
            int r15 = r15 + r7
            if (r4 >= r15) goto L_0x005e
            int r1 = r3.a(r1)
            if (r1 == r7) goto L_0x005e
            if (r1 == r4) goto L_0x005e
            r2 = r5[r1]
            r4 = r12[r1]
            goto L_0x006d
        L_0x005e:
            r1 = r10
            goto L_0x0065
        L_0x0060:
            r13 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
        L_0x0065:
            r4 = -1
            r10 = r1
            r2 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
        L_0x006d:
            r1 = 0
        L_0x006e:
            u2.o[] r12 = r0.f15291s
            int r15 = r12.length
            if (r1 >= r15) goto L_0x00d8
            int r15 = r0.f15293u
            if (r1 == r15) goto L_0x00d3
            r12 = r12[r1]
            u2.x r12 = r12.f15269b
            long[] r15 = r12.f15343f
            int r15 = j1.l0.f(r15, r10, r6)
        L_0x0081:
            if (r15 < 0) goto L_0x0090
            int[] r6 = r12.f15344g
            r6 = r6[r15]
            r6 = r6 & 1
            if (r6 == 0) goto L_0x008c
            goto L_0x0091
        L_0x008c:
            int r15 = r15 + -1
            r6 = 0
            goto L_0x0081
        L_0x0090:
            r15 = -1
        L_0x0091:
            if (r15 != r7) goto L_0x0097
            int r15 = r12.a(r10)
        L_0x0097:
            if (r15 != r7) goto L_0x009a
            goto L_0x00a2
        L_0x009a:
            long[] r6 = r12.f15340c
            r7 = r6[r15]
            long r13 = java.lang.Math.min(r7, r13)
        L_0x00a2:
            r6 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r8 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x00d3
            long[] r6 = r12.f15343f
            r7 = 0
            int r6 = j1.l0.f(r6, r2, r7)
        L_0x00b2:
            if (r6 < 0) goto L_0x00c0
            int[] r8 = r12.f15344g
            r8 = r8[r6]
            r8 = r8 & 1
            if (r8 == 0) goto L_0x00bd
            goto L_0x00c1
        L_0x00bd:
            int r6 = r6 + -1
            goto L_0x00b2
        L_0x00c0:
            r6 = -1
        L_0x00c1:
            r8 = -1
            if (r6 != r8) goto L_0x00c8
            int r6 = r12.a(r2)
        L_0x00c8:
            if (r6 != r8) goto L_0x00cb
            goto L_0x00d3
        L_0x00cb:
            long[] r9 = r12.f15340c
            r7 = r9[r6]
            long r4 = java.lang.Math.min(r7, r4)
        L_0x00d3:
            int r1 = r1 + 1
            r6 = 0
            r7 = -1
            goto L_0x006e
        L_0x00d8:
            d2.v0 r1 = new d2.v0
            r1.<init>(r10, r13)
            r6 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r8 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r8 != 0) goto L_0x00ec
            d2.t0 r2 = new d2.t0
            r2.<init>(r1, r1)
            goto L_0x00f6
        L_0x00ec:
            d2.v0 r6 = new d2.v0
            r6.<init>(r2, r4)
            d2.t0 r2 = new d2.t0
            r2.<init>(r1, r6)
        L_0x00f6:
            r1 = r2
        L_0x00f7:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: u2.p.i(long):d2.t0");
    }

    public final long j() {
        return this.f15294v;
    }

    /* JADX WARNING: Removed duplicated region for block: B:173:0x02e4  */
    /* JADX WARNING: Removed duplicated region for block: B:243:0x04a1  */
    /* JADX WARNING: Removed duplicated region for block: B:244:0x04a4  */
    /* JADX WARNING: Removed duplicated region for block: B:247:0x04c1  */
    /* JADX WARNING: Removed duplicated region for block: B:317:0x062c A[LOOP:12: B:315:0x0629->B:317:0x062c, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:321:0x0648  */
    /* JADX WARNING: Removed duplicated region for block: B:356:0x02e7 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void k(long r26) {
        /*
            r25 = this;
            r1 = r25
        L_0x0002:
            java.util.ArrayDeque r0 = r1.f15278f
            boolean r2 = r0.isEmpty()
            if (r2 != 0) goto L_0x06ad
            java.lang.Object r2 = r0.peek()
            u2.a r2 = (u2.a) r2
            long r2 = r2.f15196c
            int r4 = (r2 > r26 ? 1 : (r2 == r26 ? 0 : -1))
            if (r4 != 0) goto L_0x06ad
            java.lang.Object r2 = r0.pop()
            r3 = r2
            u2.a r3 = (u2.a) r3
            int r2 = r3.f15201b
            r4 = 1836019574(0x6d6f6f76, float:4.631354E27)
            if (r2 != r4) goto L_0x0698
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            int r4 = r1.f15295w
            r5 = 1
            if (r4 != r5) goto L_0x0031
            r4 = 1
            r9 = 1
            goto L_0x0033
        L_0x0031:
            r4 = 0
            r9 = 0
        L_0x0033:
            d2.g0 r11 = new d2.g0
            r11.<init>()
            r4 = 1969517665(0x75647461, float:2.8960062E32)
            u2.b r4 = r3.j(r4)
            r5 = 1768715124(0x696c7374, float:1.7865732E25)
            r6 = 1751411826(0x68646c72, float:4.3148E24)
            r7 = 1835365473(0x6d657461, float:4.4382975E27)
            r8 = 4
            r10 = 8
            if (r4 == 0) goto L_0x03b9
            byte[] r12 = u2.h.f15220a
            j1.b0 r4 = r4.f15199c
            r4.G(r10)
            r12 = 0
            r13 = 0
        L_0x0056:
            int r14 = r4.f8416c
            int r15 = r4.f8415b
            int r14 = r14 - r15
            if (r14 < r10) goto L_0x039e
            int r14 = r4.f()
            r16 = r5
            int r5 = r4.f()
            if (r5 != r7) goto L_0x0323
            r4.G(r15)
            int r5 = r15 + r14
            r4.H(r10)
            int r7 = r4.f8415b
            r4.H(r8)
            int r8 = r4.f()
            if (r8 == r6) goto L_0x007e
            int r7 = r7 + 4
        L_0x007e:
            r4.G(r7)
            r6 = r16
        L_0x0083:
            int r7 = r4.f8415b
            if (r7 >= r5) goto L_0x031a
            int r8 = r4.f()
            int r12 = r4.f()
            if (r12 != r6) goto L_0x0309
            r4.G(r7)
            int r7 = r7 + r8
            r4.H(r10)
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
        L_0x009d:
            int r6 = r4.f8415b
            if (r6 >= r7) goto L_0x02f5
            int r8 = r4.f()
            int r8 = r8 + r6
            int r6 = r4.f()
            int r10 = r6 >> 24
            r10 = r10 & 255(0xff, float:3.57E-43)
            r12 = 169(0xa9, float:2.37E-43)
            r16 = r7
            java.lang.String r7 = "TCON"
            if (r10 == r12) goto L_0x0266
            r12 = 253(0xfd, float:3.55E-43)
            if (r10 != r12) goto L_0x00bc
            goto L_0x0266
        L_0x00bc:
            r10 = 1735291493(0x676e7265, float:1.1260334E24)
            java.lang.String r12 = "MetadataUtil"
            if (r6 != r10) goto L_0x00f6
            int r6 = u2.n.e(r4)     // Catch:{ all -> 0x027c }
            if (r6 <= 0) goto L_0x00d4
            r10 = 192(0xc0, float:2.69E-43)
            if (r6 > r10) goto L_0x00d4
            java.lang.String[] r10 = u2.n.f15267a     // Catch:{ all -> 0x027c }
            int r6 = r6 + -1
            r6 = r10[r6]     // Catch:{ all -> 0x027c }
            goto L_0x00d5
        L_0x00d4:
            r6 = 0
        L_0x00d5:
            if (r6 == 0) goto L_0x00e9
            o2.x r10 = new o2.x     // Catch:{ all -> 0x027c }
            d9.r1 r6 = d9.r0.n(r6)     // Catch:{ all -> 0x027c }
            r12 = 0
            r10.<init>(r7, r12, r6)     // Catch:{ all -> 0x027c }
            r17 = r0
            r18 = r2
            r20 = r9
            goto L_0x025b
        L_0x00e9:
            java.lang.String r6 = "Failed to parse standard genre code"
            j1.v.g(r12, r6)     // Catch:{ all -> 0x027c }
            r17 = r0
            r18 = r2
            r20 = r9
            goto L_0x025e
        L_0x00f6:
            r7 = 1684632427(0x6469736b, float:1.7225632E22)
            if (r6 != r7) goto L_0x00fe
            java.lang.String r7 = "TPOS"
            goto L_0x0105
        L_0x00fe:
            r7 = 1953655662(0x74726b6e, float:7.6825853E31)
            if (r6 != r7) goto L_0x0171
            java.lang.String r7 = "TRCK"
        L_0x0105:
            int r10 = r4.f()     // Catch:{ all -> 0x027c }
            r17 = r0
            int r0 = r4.f()     // Catch:{ all -> 0x027c }
            r18 = r2
            r2 = 1684108385(0x64617461, float:1.6635614E22)
            if (r0 != r2) goto L_0x0159
            r0 = 22
            if (r10 < r0) goto L_0x0159
            r0 = 10
            r4.H(r0)     // Catch:{ all -> 0x027c }
            int r0 = r4.A()     // Catch:{ all -> 0x027c }
            if (r0 <= 0) goto L_0x0159
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x027c }
            java.lang.String r6 = ""
            r2.<init>(r6)     // Catch:{ all -> 0x027c }
            r2.append(r0)     // Catch:{ all -> 0x027c }
            java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x027c }
            int r2 = r4.A()     // Catch:{ all -> 0x027c }
            if (r2 <= 0) goto L_0x014d
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x027c }
            r6.<init>()     // Catch:{ all -> 0x027c }
            r6.append(r0)     // Catch:{ all -> 0x027c }
            java.lang.String r0 = "/"
            r6.append(r0)     // Catch:{ all -> 0x027c }
            r6.append(r2)     // Catch:{ all -> 0x027c }
            java.lang.String r0 = r6.toString()     // Catch:{ all -> 0x027c }
        L_0x014d:
            o2.x r2 = new o2.x     // Catch:{ all -> 0x027c }
            d9.r1 r0 = d9.r0.n(r0)     // Catch:{ all -> 0x027c }
            r6 = 0
            r2.<init>(r7, r6, r0)     // Catch:{ all -> 0x027c }
            goto L_0x01e1
        L_0x0159:
            r2 = 0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x027c }
            java.lang.String r7 = "Failed to parse index/count attribute: "
            r0.<init>(r7)     // Catch:{ all -> 0x027c }
            java.lang.String r6 = u2.c.c(r6)     // Catch:{ all -> 0x027c }
            r0.append(r6)     // Catch:{ all -> 0x027c }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x027c }
            j1.v.g(r12, r0)     // Catch:{ all -> 0x027c }
            goto L_0x01e1
        L_0x0171:
            r17 = r0
            r18 = r2
            r0 = 0
            r2 = 1953329263(0x746d706f, float:7.5247484E31)
            if (r6 != r2) goto L_0x0184
            java.lang.String r0 = "TBPM"
            r2 = 1
            r7 = 0
            o2.p r2 = u2.n.d(r6, r0, r4, r2, r7)     // Catch:{ all -> 0x027c }
            goto L_0x01e1
        L_0x0184:
            r2 = 1668311404(0x6370696c, float:4.434815E21)
            if (r6 != r2) goto L_0x018d
            java.lang.String r0 = "TCMP"
            r2 = 1
            goto L_0x01cf
        L_0x018d:
            r2 = 1668249202(0x636f7672, float:4.4173067E21)
            if (r6 != r2) goto L_0x0197
            o2.b r2 = u2.n.b(r4)     // Catch:{ all -> 0x027c }
            goto L_0x01e1
        L_0x0197:
            r2 = 1631670868(0x61415254, float:2.2288462E20)
            if (r6 != r2) goto L_0x019f
            java.lang.String r0 = "TPE2"
            goto L_0x01f4
        L_0x019f:
            r2 = 1936682605(0x736f6e6d, float:1.8969706E31)
            if (r6 != r2) goto L_0x01a7
            java.lang.String r0 = "TSOT"
            goto L_0x01f4
        L_0x01a7:
            r2 = 1936679276(0x736f616c, float:1.8965681E31)
            if (r6 != r2) goto L_0x01af
            java.lang.String r0 = "TSO2"
            goto L_0x01f4
        L_0x01af:
            r2 = 1936679282(0x736f6172, float:1.8965689E31)
            if (r6 != r2) goto L_0x01b7
            java.lang.String r0 = "TSOA"
            goto L_0x01f4
        L_0x01b7:
            r2 = 1936679265(0x736f6161, float:1.8965668E31)
            if (r6 != r2) goto L_0x01bf
            java.lang.String r0 = "TSOP"
            goto L_0x01f4
        L_0x01bf:
            r2 = 1936679791(0x736f636f, float:1.8966304E31)
            if (r6 != r2) goto L_0x01c7
            java.lang.String r0 = "TSOC"
            goto L_0x01f4
        L_0x01c7:
            r2 = 1920233063(0x72746e67, float:4.84146E30)
            if (r6 != r2) goto L_0x01d4
            java.lang.String r0 = "ITUNESADVISORY"
            r2 = 0
        L_0x01cf:
            o2.p r2 = u2.n.d(r6, r0, r4, r2, r2)     // Catch:{ all -> 0x027c }
            goto L_0x01e1
        L_0x01d4:
            r2 = 1885823344(0x70676170, float:2.8643533E29)
            if (r6 != r2) goto L_0x01e5
            java.lang.String r0 = "ITUNESGAPLESS"
            r2 = 1
            r7 = 0
            o2.p r2 = u2.n.d(r6, r0, r4, r7, r2)     // Catch:{ all -> 0x027c }
        L_0x01e1:
            r20 = r9
            goto L_0x02df
        L_0x01e5:
            r2 = 1936683886(0x736f736e, float:1.8971255E31)
            if (r6 != r2) goto L_0x01ed
            java.lang.String r0 = "TVSHOWSORT"
            goto L_0x01f4
        L_0x01ed:
            r2 = 1953919848(0x74767368, float:7.810338E31)
            if (r6 != r2) goto L_0x01f8
            java.lang.String r0 = "TVSHOW"
        L_0x01f4:
            r20 = r9
            goto L_0x02db
        L_0x01f8:
            r2 = 757935405(0x2d2d2d2d, float:9.8439425E-12)
            if (r6 != r2) goto L_0x0262
            r2 = -1
            r6 = -1
            r2 = r0
            r6 = -1
            r7 = -1
        L_0x0202:
            int r10 = r4.f8415b     // Catch:{ all -> 0x027c }
            if (r10 >= r8) goto L_0x023e
            int r12 = r4.f()     // Catch:{ all -> 0x027c }
            r19 = r10
            int r10 = r4.f()     // Catch:{ all -> 0x027c }
            r20 = r9
            r9 = 4
            r4.H(r9)     // Catch:{ all -> 0x027c }
            r9 = 1835360622(0x6d65616e, float:4.4368658E27)
            if (r10 != r9) goto L_0x0222
            int r12 = r12 + -12
            java.lang.String r0 = r4.q(r12)     // Catch:{ all -> 0x027c }
            goto L_0x023b
        L_0x0222:
            r9 = 1851878757(0x6e616d65, float:1.7441594E28)
            if (r10 != r9) goto L_0x022e
            int r12 = r12 + -12
            java.lang.String r2 = r4.q(r12)     // Catch:{ all -> 0x027c }
            goto L_0x023b
        L_0x022e:
            r9 = 1684108385(0x64617461, float:1.6635614E22)
            if (r10 != r9) goto L_0x0236
            r7 = r12
            r6 = r19
        L_0x0236:
            int r12 = r12 + -12
            r4.H(r12)     // Catch:{ all -> 0x027c }
        L_0x023b:
            r9 = r20
            goto L_0x0202
        L_0x023e:
            r20 = r9
            if (r0 == 0) goto L_0x025e
            if (r2 == 0) goto L_0x025e
            r9 = -1
            if (r6 != r9) goto L_0x0248
            goto L_0x025e
        L_0x0248:
            r4.G(r6)     // Catch:{ all -> 0x027c }
            r6 = 16
            r4.H(r6)     // Catch:{ all -> 0x027c }
            int r7 = r7 + -16
            java.lang.String r6 = r4.q(r7)     // Catch:{ all -> 0x027c }
            o2.r r10 = new o2.r     // Catch:{ all -> 0x027c }
            r10.<init>(r0, r2, r6)     // Catch:{ all -> 0x027c }
        L_0x025b:
            r2 = r10
            goto L_0x02df
        L_0x025e:
            r0 = 0
        L_0x025f:
            r2 = r0
            goto L_0x02df
        L_0x0262:
            r20 = r9
            goto L_0x02cf
        L_0x0266:
            r17 = r0
            r18 = r2
            r20 = r9
            r0 = 0
            r2 = 16777215(0xffffff, float:2.3509886E-38)
            r2 = r2 & r6
            r9 = 6516084(0x636d74, float:9.130979E-39)
            if (r2 != r9) goto L_0x027f
            o2.j r2 = u2.n.a(r6, r4)     // Catch:{ all -> 0x027c }
            goto L_0x02df
        L_0x027c:
            r0 = move-exception
            goto L_0x02f1
        L_0x027f:
            r9 = 7233901(0x6e616d, float:1.0136854E-38)
            if (r2 == r9) goto L_0x02d9
            r9 = 7631467(0x74726b, float:1.0693963E-38)
            if (r2 != r9) goto L_0x028a
            goto L_0x02d9
        L_0x028a:
            r9 = 6516589(0x636f6d, float:9.131686E-39)
            if (r2 == r9) goto L_0x02d6
            r9 = 7828084(0x777274, float:1.0969482E-38)
            if (r2 != r9) goto L_0x0295
            goto L_0x02d6
        L_0x0295:
            r9 = 6578553(0x646179, float:9.218516E-39)
            if (r2 != r9) goto L_0x029d
            java.lang.String r0 = "TDRC"
            goto L_0x02db
        L_0x029d:
            r9 = 4280916(0x415254, float:5.998841E-39)
            if (r2 != r9) goto L_0x02a5
            java.lang.String r0 = "TPE1"
            goto L_0x02db
        L_0x02a5:
            r9 = 7630703(0x746f6f, float:1.0692892E-38)
            if (r2 != r9) goto L_0x02ad
            java.lang.String r0 = "TSSE"
            goto L_0x02db
        L_0x02ad:
            r9 = 6384738(0x616c62, float:8.946924E-39)
            if (r2 != r9) goto L_0x02b5
            java.lang.String r0 = "TALB"
            goto L_0x02db
        L_0x02b5:
            r9 = 7108978(0x6c7972, float:9.9618E-39)
            if (r2 != r9) goto L_0x02bd
            java.lang.String r0 = "USLT"
            goto L_0x02db
        L_0x02bd:
            r9 = 6776174(0x67656e, float:9.495442E-39)
            if (r2 != r9) goto L_0x02c7
            o2.x r2 = u2.n.c(r6, r4, r7)     // Catch:{ all -> 0x027c }
            goto L_0x02df
        L_0x02c7:
            r7 = 6779504(0x677270, float:9.500109E-39)
            if (r2 != r7) goto L_0x02cf
            java.lang.String r0 = "TIT1"
            goto L_0x02db
        L_0x02cf:
            u2.c.c(r6)     // Catch:{ all -> 0x027c }
            j1.v.b()     // Catch:{ all -> 0x027c }
            goto L_0x025f
        L_0x02d6:
            java.lang.String r0 = "TCOM"
            goto L_0x02db
        L_0x02d9:
            java.lang.String r0 = "TIT2"
        L_0x02db:
            o2.x r2 = u2.n.c(r6, r4, r0)     // Catch:{ all -> 0x027c }
        L_0x02df:
            r4.G(r8)
            if (r2 == 0) goto L_0x02e7
            r5.add(r2)
        L_0x02e7:
            r7 = r16
            r0 = r17
            r2 = r18
            r9 = r20
            goto L_0x009d
        L_0x02f1:
            r4.G(r8)
            throw r0
        L_0x02f5:
            r17 = r0
            r18 = r2
            r20 = r9
            r0 = 0
            boolean r2 = r5.isEmpty()
            if (r2 == 0) goto L_0x0303
            goto L_0x0321
        L_0x0303:
            g1.z0 r0 = new g1.z0
            r0.<init>((java.util.List) r5)
            goto L_0x0321
        L_0x0309:
            r17 = r0
            r18 = r2
            r20 = r9
            int r7 = r7 + r8
            r4.G(r7)
            r6 = 1768715124(0x696c7374, float:1.7865732E25)
            r10 = 8
            goto L_0x0083
        L_0x031a:
            r17 = r0
            r18 = r2
            r20 = r9
            r0 = 0
        L_0x0321:
            r12 = r0
            goto L_0x0386
        L_0x0323:
            r17 = r0
            r18 = r2
            r20 = r9
            r0 = 0
            r2 = 1936553057(0x736d7461, float:1.8813092E31)
            if (r5 != r2) goto L_0x0386
            r4.G(r15)
            int r2 = r15 + r14
            r5 = 12
            r4.H(r5)
        L_0x0339:
            int r5 = r4.f8415b
            if (r5 >= r2) goto L_0x0385
            int r6 = r4.f()
            int r7 = r4.f()
            r8 = 1935766900(0x73617574, float:1.7862687E31)
            if (r7 != r8) goto L_0x0380
            r2 = 14
            if (r6 >= r2) goto L_0x034f
            goto L_0x0385
        L_0x034f:
            r2 = 5
            r4.H(r2)
            int r2 = r4.v()
            r5 = 12
            if (r2 == r5) goto L_0x0360
            r6 = 13
            if (r2 == r6) goto L_0x0360
            goto L_0x0385
        L_0x0360:
            if (r2 != r5) goto L_0x0365
            r0 = 1131413504(0x43700000, float:240.0)
            goto L_0x0367
        L_0x0365:
            r0 = 1123024896(0x42f00000, float:120.0)
        L_0x0367:
            r2 = 1
            r4.H(r2)
            int r5 = r4.v()
            g1.z0 r6 = new g1.z0
            g1.y0[] r2 = new g1.y0[r2]
            p2.j r7 = new p2.j
            r7.<init>(r5, r0)
            r0 = 0
            r2[r0] = r7
            r6.<init>((g1.y0[]) r2)
            r13 = r6
            goto L_0x0386
        L_0x0380:
            int r5 = r5 + r6
            r4.G(r5)
            goto L_0x0339
        L_0x0385:
            r13 = r0
        L_0x0386:
            int r15 = r15 + r14
            r4.G(r15)
            r8 = 4
            r5 = 1768715124(0x696c7374, float:1.7865732E25)
            r6 = 1751411826(0x68646c72, float:4.3148E24)
            r7 = 1835365473(0x6d657461, float:4.4382975E27)
            r10 = 8
            r0 = r17
            r2 = r18
            r9 = r20
            goto L_0x0056
        L_0x039e:
            r17 = r0
            r18 = r2
            r20 = r9
            android.util.Pair r0 = android.util.Pair.create(r12, r13)
            java.lang.Object r2 = r0.first
            g1.z0 r2 = (g1.z0) r2
            java.lang.Object r0 = r0.second
            g1.z0 r0 = (g1.z0) r0
            if (r2 == 0) goto L_0x03b5
            r11.b(r2)
        L_0x03b5:
            r4 = 1835365473(0x6d657461, float:4.4382975E27)
            goto L_0x03c4
        L_0x03b9:
            r17 = r0
            r18 = r2
            r20 = r9
            r2 = 0
            r4 = 1835365473(0x6d657461, float:4.4382975E27)
            r0 = r2
        L_0x03c4:
            u2.a r4 = r3.i(r4)
            if (r4 == 0) goto L_0x0499
            byte[] r5 = u2.h.f15220a
            r5 = 1751411826(0x68646c72, float:4.3148E24)
            u2.b r5 = r4.j(r5)
            r6 = 1801812339(0x6b657973, float:2.7741754E26)
            u2.b r6 = r4.j(r6)
            r7 = 1768715124(0x696c7374, float:1.7865732E25)
            u2.b r4 = r4.j(r7)
            if (r5 == 0) goto L_0x0499
            if (r6 == 0) goto L_0x0499
            if (r4 == 0) goto L_0x0499
            j1.b0 r5 = r5.f15199c
            r7 = 16
            r5.G(r7)
            int r5 = r5.f()
            r7 = 1835299937(0x6d647461, float:4.4189547E27)
            if (r5 == r7) goto L_0x03f9
            goto L_0x0499
        L_0x03f9:
            j1.b0 r5 = r6.f15199c
            r6 = 12
            r5.G(r6)
            int r6 = r5.f()
            java.lang.String[] r7 = new java.lang.String[r6]
            r8 = 0
        L_0x0407:
            if (r8 >= r6) goto L_0x041c
            int r9 = r5.f()
            r10 = 4
            r5.H(r10)
            int r9 = r9 + -8
            java.lang.String r9 = r5.s(r9)
            r7[r8] = r9
            int r8 = r8 + 1
            goto L_0x0407
        L_0x041c:
            r5 = 8
            j1.b0 r4 = r4.f15199c
            r4.G(r5)
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
        L_0x0428:
            int r9 = r4.f8416c
            int r10 = r4.f8415b
            int r9 = r9 - r10
            if (r9 <= r5) goto L_0x048c
            int r5 = r4.f()
            int r9 = r4.f()
            int r9 = r9 + -1
            if (r9 < 0) goto L_0x047a
            if (r9 >= r6) goto L_0x047a
            r9 = r7[r9]
            int r12 = r10 + r5
        L_0x0441:
            int r13 = r4.f8415b
            if (r13 >= r12) goto L_0x0471
            int r14 = r4.f()
            int r15 = r4.f()
            r16 = r6
            r6 = 1684108385(0x64617461, float:1.6635614E22)
            if (r15 != r6) goto L_0x046a
            int r6 = r4.f()
            int r12 = r4.f()
            int r14 = r14 + -16
            byte[] r13 = new byte[r14]
            r15 = 0
            r4.d(r13, r15, r14)
            p2.b r14 = new p2.b
            r14.<init>(r9, r13, r12, r6)
            goto L_0x0474
        L_0x046a:
            int r13 = r13 + r14
            r4.G(r13)
            r6 = r16
            goto L_0x0441
        L_0x0471:
            r16 = r6
            r14 = 0
        L_0x0474:
            if (r14 == 0) goto L_0x0483
            r8.add(r14)
            goto L_0x0483
        L_0x047a:
            r16 = r6
            java.lang.String r6 = "Skipped metadata with unknown key index: "
            java.lang.String r12 = "AtomParsers"
            android.support.v4.media.h.z(r6, r9, r12)
        L_0x0483:
            int r10 = r10 + r5
            r4.G(r10)
            r5 = 8
            r6 = r16
            goto L_0x0428
        L_0x048c:
            boolean r4 = r8.isEmpty()
            if (r4 == 0) goto L_0x0493
            goto L_0x0499
        L_0x0493:
            g1.z0 r4 = new g1.z0
            r4.<init>((java.util.List) r8)
            goto L_0x049a
        L_0x0499:
            r4 = 0
        L_0x049a:
            r12 = r4
            int r4 = r1.f15273a
            r5 = 1
            r4 = r4 & r5
            if (r4 == 0) goto L_0x04a4
            r4 = 1
            r8 = 1
            goto L_0x04a6
        L_0x04a4:
            r4 = 0
            r8 = 0
        L_0x04a6:
            r13 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r7 = 0
            f3.a r10 = new f3.a
            r10.<init>(r5)
            r4 = r11
            r5 = r13
            r9 = r20
            java.util.ArrayList r3 = u2.h.e(r3, r4, r5, r7, r8, r9, r10)
            int r4 = r3.size()
            r5 = 0
            r6 = -1
        L_0x04bf:
            if (r5 >= r4) goto L_0x0609
            java.lang.Object r7 = r3.get(r5)
            u2.x r7 = (u2.x) r7
            int r8 = r7.f15339b
            if (r8 != 0) goto L_0x04d7
            r22 = r0
            r23 = r2
            r16 = r3
            r19 = r4
            r0 = r18
            goto L_0x05fb
        L_0x04d7:
            u2.u r8 = r7.f15338a
            long r9 = r8.f15309e
            r15 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r19 = (r9 > r15 ? 1 : (r9 == r15 ? 0 : -1))
            if (r19 == 0) goto L_0x04e5
            goto L_0x04e7
        L_0x04e5:
            long r9 = r7.f15345h
        L_0x04e7:
            long r13 = java.lang.Math.max(r13, r9)
            u2.o r15 = new u2.o
            r16 = r3
            d2.y r3 = r1.f15290r
            r19 = r4
            int r4 = r8.f15306b
            d2.x0 r3 = r3.d(r5, r4)
            r15.<init>(r8, r7, r3)
            g1.a0 r3 = r8.f15310f
            java.lang.String r8 = r3.f6276s
            r20 = r13
            java.lang.String r13 = "audio/true-hd"
            boolean r8 = r13.equals(r8)
            int r13 = r7.f15342e
            if (r8 == 0) goto L_0x050f
            int r13 = r13 * 16
            goto L_0x0511
        L_0x050f:
            int r13 = r13 + 30
        L_0x0511:
            g1.z r8 = new g1.z
            r8.<init>(r3)
            r8.f6755l = r13
            r3 = 2
            if (r4 != r3) goto L_0x052f
            r13 = 0
            int r3 = (r9 > r13 ? 1 : (r9 == r13 ? 0 : -1))
            if (r3 <= 0) goto L_0x052f
            int r3 = r7.f15339b
            r7 = 1
            if (r3 <= r7) goto L_0x052f
            float r3 = (float) r3
            float r7 = (float) r9
            r9 = 1232348160(0x49742400, float:1000000.0)
            float r7 = r7 / r9
            float r3 = r3 / r7
            r8.f6761r = r3
        L_0x052f:
            r3 = 1
            if (r4 != r3) goto L_0x0546
            int r3 = r11.f4186a
            r7 = -1
            if (r3 == r7) goto L_0x053d
            int r9 = r11.f4187b
            if (r9 == r7) goto L_0x053d
            r7 = 1
            goto L_0x053e
        L_0x053d:
            r7 = 0
        L_0x053e:
            if (r7 == 0) goto L_0x0546
            r8.A = r3
            int r3 = r11.f4187b
            r8.B = r3
        L_0x0546:
            r3 = 2
            g1.z0[] r3 = new g1.z0[r3]
            r7 = 0
            r3[r7] = r0
            java.util.ArrayList r9 = r1.f15280h
            boolean r10 = r9.isEmpty()
            if (r10 == 0) goto L_0x0557
            r9 = 1
            r10 = 0
            goto L_0x055d
        L_0x0557:
            g1.z0 r10 = new g1.z0
            r10.<init>((java.util.List) r9)
            r9 = 1
        L_0x055d:
            r3[r9] = r10
            g1.z0 r10 = new g1.z0
            g1.y0[] r7 = new g1.y0[r7]
            r10.<init>((g1.y0[]) r7)
            if (r4 != r9) goto L_0x056c
            if (r2 == 0) goto L_0x0598
            r10 = r2
            goto L_0x0598
        L_0x056c:
            r7 = 2
            if (r4 != r7) goto L_0x0598
            if (r12 == 0) goto L_0x0598
            r7 = 0
        L_0x0572:
            g1.y0[] r9 = r12.f6770h
            int r13 = r9.length
            if (r7 >= r13) goto L_0x0598
            r9 = r9[r7]
            boolean r13 = r9 instanceof p2.b
            if (r13 == 0) goto L_0x0595
            p2.b r9 = (p2.b) r9
            java.lang.String r13 = r9.f12511h
            java.lang.String r14 = "com.android.capture.fps"
            boolean r13 = r14.equals(r13)
            if (r13 == 0) goto L_0x0595
            g1.z0 r10 = new g1.z0
            r7 = 1
            g1.y0[] r7 = new g1.y0[r7]
            r13 = 0
            r7[r13] = r9
            r10.<init>((g1.y0[]) r7)
            goto L_0x0598
        L_0x0595:
            int r7 = r7 + 1
            goto L_0x0572
        L_0x0598:
            r7 = 0
        L_0x0599:
            g1.y0[] r9 = r10.f6770h
            r13 = 2
            if (r7 >= r13) goto L_0x05d7
            r13 = r3[r7]
            if (r13 != 0) goto L_0x05a3
            goto L_0x05a8
        L_0x05a3:
            g1.y0[] r13 = r13.f6770h
            int r14 = r13.length
            if (r14 != 0) goto L_0x05af
        L_0x05a8:
            r22 = r0
            r23 = r2
            r24 = r3
            goto L_0x05ce
        L_0x05af:
            g1.z0 r14 = new g1.z0
            int r22 = j1.l0.f8453a
            r22 = r0
            int r0 = r9.length
            r23 = r2
            int r2 = r13.length
            int r0 = r0 + r2
            java.lang.Object[] r0 = java.util.Arrays.copyOf(r9, r0)
            int r2 = r9.length
            int r9 = r13.length
            r24 = r3
            r3 = 0
            java.lang.System.arraycopy(r13, r3, r0, r2, r9)
            g1.y0[] r0 = (g1.y0[]) r0
            long r2 = r10.f6771i
            r14.<init>(r2, r0)
            r10 = r14
        L_0x05ce:
            int r7 = r7 + 1
            r0 = r22
            r2 = r23
            r3 = r24
            goto L_0x0599
        L_0x05d7:
            r22 = r0
            r23 = r2
            int r0 = r9.length
            if (r0 <= 0) goto L_0x05e0
            r8.f6752i = r10
        L_0x05e0:
            g1.a0 r0 = new g1.a0
            r0.<init>(r8)
            d2.x0 r2 = r15.f15270c
            r2.a(r0)
            r0 = 2
            if (r4 != r0) goto L_0x05f4
            r0 = -1
            if (r6 != r0) goto L_0x05f4
            int r6 = r18.size()
        L_0x05f4:
            r0 = r18
            r0.add(r15)
            r13 = r20
        L_0x05fb:
            int r5 = r5 + 1
            r18 = r0
            r3 = r16
            r4 = r19
            r0 = r22
            r2 = r23
            goto L_0x04bf
        L_0x0609:
            r0 = r18
            r2 = 0
            r1.f15293u = r6
            r1.f15294v = r13
            r4 = 0
            u2.o[] r4 = new u2.o[r4]
            java.lang.Object[] r0 = r0.toArray(r4)
            u2.o[] r0 = (u2.o[]) r0
            r1.f15291s = r0
            int r4 = r0.length
            long[][] r4 = new long[r4][]
            int r5 = r0.length
            int[] r5 = new int[r5]
            int r6 = r0.length
            long[] r6 = new long[r6]
            int r7 = r0.length
            boolean[] r7 = new boolean[r7]
            r8 = 0
        L_0x0629:
            int r9 = r0.length
            if (r8 >= r9) goto L_0x0644
            r9 = r0[r8]
            u2.x r9 = r9.f15269b
            int r9 = r9.f15339b
            long[] r9 = new long[r9]
            r4[r8] = r9
            r9 = r0[r8]
            u2.x r9 = r9.f15269b
            long[] r9 = r9.f15343f
            r10 = 0
            r10 = r9[r10]
            r6[r8] = r10
            int r8 = r8 + 1
            goto L_0x0629
        L_0x0644:
            r8 = 0
        L_0x0645:
            int r9 = r0.length
            if (r8 >= r9) goto L_0x0684
            r9 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r11 = 0
            r12 = -1
        L_0x064f:
            int r13 = r0.length
            if (r11 >= r13) goto L_0x0661
            boolean r13 = r7[r11]
            if (r13 != 0) goto L_0x065e
            r13 = r6[r11]
            int r15 = (r13 > r9 ? 1 : (r13 == r9 ? 0 : -1))
            if (r15 > 0) goto L_0x065e
            r12 = r11
            r9 = r13
        L_0x065e:
            int r11 = r11 + 1
            goto L_0x064f
        L_0x0661:
            r9 = r5[r12]
            r10 = r4[r12]
            r10[r9] = r2
            r11 = r0[r12]
            u2.x r11 = r11.f15269b
            int[] r13 = r11.f15341d
            r13 = r13[r9]
            long r13 = (long) r13
            long r2 = r2 + r13
            r13 = 1
            int r9 = r9 + r13
            r5[r12] = r9
            int r10 = r10.length
            if (r9 >= r10) goto L_0x067f
            long[] r10 = r11.f15343f
            r9 = r10[r9]
            r6[r12] = r9
            goto L_0x0645
        L_0x067f:
            r7[r12] = r13
            int r8 = r8 + 1
            goto L_0x0645
        L_0x0684:
            r1.f15292t = r4
            d2.y r0 = r1.f15290r
            r0.a()
            d2.y r0 = r1.f15290r
            r0.g(r1)
            r17.clear()
            r0 = 2
            r1.f15281i = r0
            goto L_0x0002
        L_0x0698:
            r17 = r0
            boolean r0 = r17.isEmpty()
            if (r0 != 0) goto L_0x0002
            java.lang.Object r0 = r17.peek()
            u2.a r0 = (u2.a) r0
            java.util.ArrayList r0 = r0.f15198e
            r0.add(r3)
            goto L_0x0002
        L_0x06ad:
            int r0 = r1.f15281i
            r2 = 2
            if (r0 == r2) goto L_0x06b7
            r0 = 0
            r1.f15281i = r0
            r1.f15284l = r0
        L_0x06b7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: u2.p.k(long):void");
    }

    public p(int i10) {
        this.f15273a = 0;
        this.f15281i = 0;
        this.f15279g = new s();
        this.f15280h = new ArrayList();
        this.f15277e = new b0(16);
        this.f15278f = new ArrayDeque();
        this.f15274b = new b0(p0.f4278a);
        this.f15275c = new b0(4);
        this.f15276d = new b0();
        this.f15286n = -1;
        this.f15290r = y.f4307a;
        this.f15291s = new o[0];
    }
}
