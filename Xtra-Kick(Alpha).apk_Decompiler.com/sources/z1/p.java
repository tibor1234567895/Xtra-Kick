package z1;

import d9.c0;
import d9.e0;
import d9.o1;
import d9.p1;
import d9.y1;
import j1.l0;

public final class p extends o {

    /* renamed from: l  reason: collision with root package name */
    public final boolean f17453l;

    /* renamed from: m  reason: collision with root package name */
    public final j f17454m;

    /* renamed from: n  reason: collision with root package name */
    public final boolean f17455n;

    /* renamed from: o  reason: collision with root package name */
    public final boolean f17456o;

    /* renamed from: p  reason: collision with root package name */
    public final int f17457p;

    /* renamed from: q  reason: collision with root package name */
    public final int f17458q;

    /* renamed from: r  reason: collision with root package name */
    public final int f17459r;

    /* renamed from: s  reason: collision with root package name */
    public final int f17460s;

    /* renamed from: t  reason: collision with root package name */
    public final boolean f17461t;

    /* renamed from: u  reason: collision with root package name */
    public final boolean f17462u;

    /* renamed from: v  reason: collision with root package name */
    public final int f17463v;

    /* renamed from: w  reason: collision with root package name */
    public final boolean f17464w;

    /* renamed from: x  reason: collision with root package name */
    public final boolean f17465x;

    /* renamed from: y  reason: collision with root package name */
    public final int f17466y;

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0158  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x00da A[EDGE_INSN: B:139:0x00da->B:76:0x00da ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00a0 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x00ef  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x00fa  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public p(int r5, g1.v1 r6, int r7, z1.j r8, int r9, int r10, boolean r11) {
        /*
            r4 = this;
            r4.<init>(r5, r7, r6)
            r4.f17454m = r8
            boolean r5 = r8.f17420k0
            if (r5 == 0) goto L_0x000c
            r5 = 24
            goto L_0x000e
        L_0x000c:
            r5 = 16
        L_0x000e:
            boolean r6 = r8.f17419j0
            r7 = 0
            r0 = 1
            if (r6 == 0) goto L_0x001a
            r6 = r10 & r5
            if (r6 == 0) goto L_0x001a
            r6 = 1
            goto L_0x001b
        L_0x001a:
            r6 = 0
        L_0x001b:
            r4.f17462u = r6
            r6 = -1
            r10 = -1082130432(0xffffffffbf800000, float:-1.0)
            if (r11 == 0) goto L_0x004b
            g1.a0 r1 = r4.f17452k
            int r2 = r1.f6281x
            if (r2 == r6) goto L_0x002c
            int r3 = r8.f6725h
            if (r2 > r3) goto L_0x004b
        L_0x002c:
            int r2 = r1.f6282y
            if (r2 == r6) goto L_0x0034
            int r3 = r8.f6726i
            if (r2 > r3) goto L_0x004b
        L_0x0034:
            float r2 = r1.f6283z
            int r3 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1))
            if (r3 == 0) goto L_0x0041
            int r3 = r8.f6727j
            float r3 = (float) r3
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 > 0) goto L_0x004b
        L_0x0041:
            int r1 = r1.f6272o
            if (r1 == r6) goto L_0x0049
            int r2 = r8.f6728k
            if (r1 > r2) goto L_0x004b
        L_0x0049:
            r1 = 1
            goto L_0x004c
        L_0x004b:
            r1 = 0
        L_0x004c:
            r4.f17453l = r1
            if (r11 == 0) goto L_0x0079
            g1.a0 r11 = r4.f17452k
            int r1 = r11.f6281x
            if (r1 == r6) goto L_0x005a
            int r2 = r8.f6729l
            if (r1 < r2) goto L_0x0079
        L_0x005a:
            int r1 = r11.f6282y
            if (r1 == r6) goto L_0x0062
            int r2 = r8.f6730m
            if (r1 < r2) goto L_0x0079
        L_0x0062:
            float r1 = r11.f6283z
            int r10 = (r1 > r10 ? 1 : (r1 == r10 ? 0 : -1))
            if (r10 == 0) goto L_0x006f
            int r10 = r8.f6731n
            float r10 = (float) r10
            int r10 = (r1 > r10 ? 1 : (r1 == r10 ? 0 : -1))
            if (r10 < 0) goto L_0x0079
        L_0x006f:
            int r10 = r11.f6272o
            if (r10 == r6) goto L_0x0077
            int r11 = r8.f6732o
            if (r10 < r11) goto L_0x0079
        L_0x0077:
            r10 = 1
            goto L_0x007a
        L_0x0079:
            r10 = 0
        L_0x007a:
            r4.f17455n = r10
            boolean r10 = z1.q.j(r9, r7)
            r4.f17456o = r10
            g1.a0 r10 = r4.f17452k
            int r11 = r10.f6272o
            r4.f17457p = r11
            int r11 = r10.f6281x
            if (r11 == r6) goto L_0x0094
            int r1 = r10.f6282y
            if (r1 != r6) goto L_0x0091
            goto L_0x0094
        L_0x0091:
            int r11 = r11 * r1
            goto L_0x0095
        L_0x0094:
            r11 = -1
        L_0x0095:
            r4.f17458q = r11
            int r10 = r10.f6269l
            r11 = 2147483647(0x7fffffff, float:NaN)
            int r1 = r8.f6737t
            if (r10 == 0) goto L_0x00a6
            if (r10 != r1) goto L_0x00a6
            r10 = 2147483647(0x7fffffff, float:NaN)
            goto L_0x00ab
        L_0x00a6:
            r10 = r10 & r1
            int r10 = java.lang.Integer.bitCount(r10)
        L_0x00ab:
            r4.f17460s = r10
            g1.a0 r10 = r4.f17452k
            int r10 = r10.f6269l
            if (r10 == 0) goto L_0x00b9
            r10 = r10 & r0
            if (r10 == 0) goto L_0x00b7
            goto L_0x00b9
        L_0x00b7:
            r10 = 0
            goto L_0x00ba
        L_0x00b9:
            r10 = 1
        L_0x00ba:
            r4.f17461t = r10
            r10 = 0
        L_0x00bd:
            d9.r0 r1 = r8.f6736s
            int r2 = r1.size()
            if (r10 >= r2) goto L_0x00da
            g1.a0 r2 = r4.f17452k
            java.lang.String r2 = r2.f6276s
            if (r2 == 0) goto L_0x00d7
            java.lang.Object r1 = r1.get(r10)
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x00d7
            r11 = r10
            goto L_0x00da
        L_0x00d7:
            int r10 = r10 + 1
            goto L_0x00bd
        L_0x00da:
            r4.f17459r = r11
            r8 = r9 & 384(0x180, float:5.38E-43)
            r10 = 128(0x80, float:1.794E-43)
            if (r8 != r10) goto L_0x00e4
            r8 = 1
            goto L_0x00e5
        L_0x00e4:
            r8 = 0
        L_0x00e5:
            r4.f17464w = r8
            r8 = r9 & 64
            r10 = 64
            if (r8 != r10) goto L_0x00ef
            r8 = 1
            goto L_0x00f0
        L_0x00ef:
            r8 = 0
        L_0x00f0:
            r4.f17465x = r8
            g1.a0 r8 = r4.f17452k
            java.lang.String r10 = r8.f6276s
            r11 = 2
            if (r10 != 0) goto L_0x00fa
            goto L_0x0146
        L_0x00fa:
            int r1 = r10.hashCode()
            r2 = 3
            r3 = 4
            switch(r1) {
                case -1851077871: goto L_0x0130;
                case -1662735862: goto L_0x0125;
                case -1662541442: goto L_0x011a;
                case 1331836730: goto L_0x010f;
                case 1599127257: goto L_0x0104;
                default: goto L_0x0103;
            }
        L_0x0103:
            goto L_0x013b
        L_0x0104:
            java.lang.String r1 = "video/x-vnd.on2.vp9"
            boolean r10 = r10.equals(r1)
            if (r10 != 0) goto L_0x010d
            goto L_0x013b
        L_0x010d:
            r10 = 4
            goto L_0x013c
        L_0x010f:
            java.lang.String r1 = "video/avc"
            boolean r10 = r10.equals(r1)
            if (r10 != 0) goto L_0x0118
            goto L_0x013b
        L_0x0118:
            r10 = 3
            goto L_0x013c
        L_0x011a:
            java.lang.String r1 = "video/hevc"
            boolean r10 = r10.equals(r1)
            if (r10 != 0) goto L_0x0123
            goto L_0x013b
        L_0x0123:
            r10 = 2
            goto L_0x013c
        L_0x0125:
            java.lang.String r1 = "video/av01"
            boolean r10 = r10.equals(r1)
            if (r10 != 0) goto L_0x012e
            goto L_0x013b
        L_0x012e:
            r10 = 1
            goto L_0x013c
        L_0x0130:
            java.lang.String r1 = "video/dolby-vision"
            boolean r10 = r10.equals(r1)
            if (r10 != 0) goto L_0x0139
            goto L_0x013b
        L_0x0139:
            r10 = 0
            goto L_0x013c
        L_0x013b:
            r10 = -1
        L_0x013c:
            if (r10 == 0) goto L_0x014e
            if (r10 == r0) goto L_0x014c
            if (r10 == r11) goto L_0x014f
            if (r10 == r2) goto L_0x014a
            if (r10 == r3) goto L_0x0148
        L_0x0146:
            r2 = 0
            goto L_0x014f
        L_0x0148:
            r2 = 2
            goto L_0x014f
        L_0x014a:
            r2 = 1
            goto L_0x014f
        L_0x014c:
            r2 = 4
            goto L_0x014f
        L_0x014e:
            r2 = 5
        L_0x014f:
            r4.f17466y = r2
            int r10 = r8.f6269l
            r10 = r10 & 16384(0x4000, float:2.2959E-41)
            if (r10 == 0) goto L_0x0158
            goto L_0x018a
        L_0x0158:
            z1.j r10 = r4.f17454m
            boolean r1 = r10.f17428s0
            boolean r1 = z1.q.j(r9, r1)
            if (r1 != 0) goto L_0x0163
            goto L_0x018a
        L_0x0163:
            boolean r1 = r4.f17453l
            if (r1 != 0) goto L_0x016c
            boolean r2 = r10.f17418i0
            if (r2 != 0) goto L_0x016c
            goto L_0x018a
        L_0x016c:
            boolean r7 = z1.q.j(r9, r7)
            if (r7 == 0) goto L_0x0189
            boolean r7 = r4.f17455n
            if (r7 == 0) goto L_0x0189
            if (r1 == 0) goto L_0x0189
            int r7 = r8.f6272o
            if (r7 == r6) goto L_0x0189
            boolean r6 = r10.E
            if (r6 != 0) goto L_0x0189
            boolean r6 = r10.D
            if (r6 != 0) goto L_0x0189
            r5 = r5 & r9
            if (r5 == 0) goto L_0x0189
            r7 = 2
            goto L_0x018a
        L_0x0189:
            r7 = 1
        L_0x018a:
            r4.f17463v = r7
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: z1.p.<init>(int, g1.v1, int, z1.j, int, int, boolean):void");
    }

    public static int c(p pVar, p pVar2) {
        p1 p1Var;
        p1 p1Var2;
        if (!pVar.f17453l || !pVar.f17456o) {
            p1Var = q.f17467j.a();
        } else {
            p1Var = q.f17467j;
        }
        c0 c0Var = e0.f4608a;
        int i10 = pVar.f17457p;
        Integer valueOf = Integer.valueOf(i10);
        Integer valueOf2 = Integer.valueOf(pVar2.f17457p);
        if (pVar.f17454m.D) {
            p1Var2 = q.f17467j.a();
        } else {
            p1Var2 = q.f17468k;
        }
        return c0Var.b(valueOf, valueOf2, p1Var2).b(Integer.valueOf(pVar.f17458q), Integer.valueOf(pVar2.f17458q), p1Var).b(Integer.valueOf(i10), Integer.valueOf(pVar2.f17457p), p1Var).e();
    }

    public static int d(p pVar, p pVar2) {
        e0 c10 = e0.f4608a.c(pVar.f17456o, pVar2.f17456o).a(pVar.f17460s, pVar2.f17460s).c(pVar.f17461t, pVar2.f17461t).c(pVar.f17453l, pVar2.f17453l).c(pVar.f17455n, pVar2.f17455n);
        Integer valueOf = Integer.valueOf(pVar.f17459r);
        Integer valueOf2 = Integer.valueOf(pVar2.f17459r);
        o1.f4642h.getClass();
        e0 b10 = c10.b(valueOf, valueOf2, y1.f4713h);
        boolean z10 = pVar2.f17464w;
        boolean z11 = pVar.f17464w;
        e0 c11 = b10.c(z11, z10);
        boolean z12 = pVar2.f17465x;
        boolean z13 = pVar.f17465x;
        e0 c12 = c11.c(z13, z12);
        if (z11 && z13) {
            c12 = c12.a(pVar.f17466y, pVar2.f17466y);
        }
        return c12.e();
    }

    public final int a() {
        return this.f17463v;
    }

    public final boolean b(o oVar) {
        p pVar = (p) oVar;
        if ((this.f17462u || l0.a(this.f17452k.f6276s, pVar.f17452k.f6276s)) && (this.f17454m.f17421l0 || (this.f17464w == pVar.f17464w && this.f17465x == pVar.f17465x))) {
            return true;
        }
        return false;
    }
}
