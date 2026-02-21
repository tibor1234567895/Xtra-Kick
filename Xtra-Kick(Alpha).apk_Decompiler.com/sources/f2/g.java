package f2;

import d9.p0;
import d9.r0;
import d9.r1;

public final class g implements a {

    /* renamed from: a  reason: collision with root package name */
    public final r0 f5471a;

    /* renamed from: b  reason: collision with root package name */
    public final int f5472b;

    public g(int i10, r1 r1Var) {
        this.f5472b = i10;
        this.f5471a = r1Var;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v14, resolved type: f2.h} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v22, resolved type: f2.e} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v5, resolved type: f2.e} */
    /* JADX WARNING: type inference failed for: r4v17 */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0070, code lost:
        r3 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x016e, code lost:
        r3 = null;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static f2.g b(int r13, j1.b0 r14) {
        /*
            d9.o0 r0 = new d9.o0
            r0.<init>()
            int r1 = r14.f8416c
            r2 = -2
        L_0x0008:
            int r3 = r14.f8416c
            int r4 = r14.f8415b
            int r3 = r3 - r4
            r4 = 8
            if (r3 <= r4) goto L_0x01b7
            int r3 = r14.i()
            int r5 = r14.i()
            int r6 = r14.f8415b
            int r6 = r6 + r5
            r14.F(r6)
            r5 = 1414744396(0x5453494c, float:3.62987127E12)
            r7 = 2
            r8 = 1
            if (r3 != r5) goto L_0x0030
            int r3 = r14.i()
            f2.g r3 = b(r3, r14)
            goto L_0x016f
        L_0x0030:
            r5 = 12
            r9 = 0
            r10 = 4
            switch(r3) {
                case 1718776947: goto L_0x0093;
                case 1751742049: goto L_0x0073;
                case 1752331379: goto L_0x0049;
                case 1852994675: goto L_0x0039;
                default: goto L_0x0037;
            }
        L_0x0037:
            goto L_0x016e
        L_0x0039:
            f2.i r3 = new f2.i
            int r4 = r14.f8416c
            int r5 = r14.f8415b
            int r4 = r4 - r5
            java.lang.String r4 = r14.s(r4)
            r3.<init>(r4)
            goto L_0x016f
        L_0x0049:
            int r8 = r14.i()
            r14.H(r5)
            r14.i()
            int r9 = r14.i()
            int r3 = r14.i()
            r14.H(r10)
            int r11 = r14.i()
            int r12 = r14.i()
            r14.H(r4)
            f2.e r4 = new f2.e
            r7 = r4
            r10 = r3
            r7.<init>(r8, r9, r10, r11, r12)
        L_0x0070:
            r3 = r4
            goto L_0x016f
        L_0x0073:
            int r3 = r14.i()
            r14.H(r4)
            int r4 = r14.i()
            int r7 = r14.i()
            r14.H(r10)
            r14.i()
            r14.H(r5)
            f2.d r5 = new f2.d
            r5.<init>(r3, r4, r7)
            r3 = r5
            goto L_0x016f
        L_0x0093:
            java.lang.String r3 = "StreamFormatChunk"
            if (r2 != r7) goto L_0x00db
            r14.H(r10)
            int r4 = r14.i()
            int r5 = r14.i()
            r14.H(r10)
            int r7 = r14.i()
            switch(r7) {
                case 808802372: goto L_0x00ba;
                case 826496577: goto L_0x00b7;
                case 828601953: goto L_0x00b7;
                case 842289229: goto L_0x00b4;
                case 859066445: goto L_0x00b1;
                case 875967048: goto L_0x00b7;
                case 877677894: goto L_0x00ba;
                case 1145656883: goto L_0x00ba;
                case 1145656920: goto L_0x00ba;
                case 1196444237: goto L_0x00ae;
                case 1482049860: goto L_0x00ba;
                case 1684633208: goto L_0x00ba;
                case 1735420525: goto L_0x00ae;
                case 2021026148: goto L_0x00ba;
                default: goto L_0x00ac;
            }
        L_0x00ac:
            r8 = r9
            goto L_0x00bc
        L_0x00ae:
            java.lang.String r8 = "video/mjpeg"
            goto L_0x00bc
        L_0x00b1:
            java.lang.String r8 = "video/mp43"
            goto L_0x00bc
        L_0x00b4:
            java.lang.String r8 = "video/mp42"
            goto L_0x00bc
        L_0x00b7:
            java.lang.String r8 = "video/avc"
            goto L_0x00bc
        L_0x00ba:
            java.lang.String r8 = "video/mp4v-es"
        L_0x00bc:
            if (r8 != 0) goto L_0x00c5
            java.lang.String r4 = "Ignoring track with unsupported compression "
            android.support.v4.media.h.z(r4, r7, r3)
            goto L_0x016e
        L_0x00c5:
            g1.z r3 = new g1.z
            r3.<init>()
            r3.f6759p = r4
            r3.f6760q = r5
            r3.f6754k = r8
            f2.h r4 = new f2.h
            g1.a0 r5 = new g1.a0
            r5.<init>(r3)
            r4.<init>(r5)
            goto L_0x0070
        L_0x00db:
            if (r2 != r8) goto L_0x0159
            int r4 = r14.n()
            java.lang.String r5 = "audio/mp4a-latm"
            java.lang.String r7 = "audio/raw"
            if (r4 == r8) goto L_0x0104
            r8 = 85
            if (r4 == r8) goto L_0x0101
            r8 = 255(0xff, float:3.57E-43)
            if (r4 == r8) goto L_0x00ff
            r8 = 8192(0x2000, float:1.14794E-41)
            if (r4 == r8) goto L_0x00fc
            r8 = 8193(0x2001, float:1.1481E-41)
            if (r4 == r8) goto L_0x00f9
            r8 = r9
            goto L_0x0105
        L_0x00f9:
            java.lang.String r8 = "audio/vnd.dts"
            goto L_0x0105
        L_0x00fc:
            java.lang.String r8 = "audio/ac3"
            goto L_0x0105
        L_0x00ff:
            r8 = r5
            goto L_0x0105
        L_0x0101:
            java.lang.String r8 = "audio/mpeg"
            goto L_0x0105
        L_0x0104:
            r8 = r7
        L_0x0105:
            if (r8 != 0) goto L_0x010d
            java.lang.String r5 = "Ignoring track with unsupported format tag "
            android.support.v4.media.h.z(r5, r4, r3)
            goto L_0x016e
        L_0x010d:
            int r3 = r14.n()
            int r4 = r14.i()
            r9 = 6
            r14.H(r9)
            int r9 = r14.A()
            int r9 = j1.l0.t(r9)
            int r10 = r14.n()
            byte[] r11 = new byte[r10]
            r12 = 0
            r14.d(r11, r12, r10)
            g1.z r12 = new g1.z
            r12.<init>()
            r12.f6754k = r8
            r12.f6767x = r3
            r12.f6768y = r4
            boolean r3 = r7.equals(r8)
            if (r3 == 0) goto L_0x0140
            if (r9 == 0) goto L_0x0140
            r12.f6769z = r9
        L_0x0140:
            boolean r3 = r5.equals(r8)
            if (r3 == 0) goto L_0x014e
            if (r10 <= 0) goto L_0x014e
            d9.r1 r3 = d9.r0.n(r11)
            r12.f6756m = r3
        L_0x014e:
            f2.h r3 = new f2.h
            g1.a0 r4 = new g1.a0
            r4.<init>(r12)
            r3.<init>(r4)
            goto L_0x016f
        L_0x0159:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "Ignoring strf box for unsupported track type: "
            r4.<init>(r5)
            java.lang.String r5 = j1.l0.y(r2)
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            j1.v.g(r3, r4)
        L_0x016e:
            r3 = r9
        L_0x016f:
            if (r3 == 0) goto L_0x01af
            int r4 = r3.getType()
            r5 = 1752331379(0x68727473, float:4.5798432E24)
            if (r4 != r5) goto L_0x01ac
            r2 = r3
            f2.e r2 = (f2.e) r2
            r4 = 1935960438(0x73646976, float:1.809666E31)
            int r2 = r2.f5454a
            if (r2 == r4) goto L_0x01ab
            r4 = 1935963489(0x73647561, float:1.8100348E31)
            if (r2 == r4) goto L_0x01a9
            r4 = 1937012852(0x73747874, float:1.936895E31)
            if (r2 == r4) goto L_0x01a7
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "Found unsupported streamType fourCC: "
            r4.<init>(r5)
            java.lang.String r2 = java.lang.Integer.toHexString(r2)
            r4.append(r2)
            java.lang.String r2 = r4.toString()
            java.lang.String r4 = "AviStreamHeaderChunk"
            j1.v.g(r4, r2)
            r2 = -1
            goto L_0x01ac
        L_0x01a7:
            r2 = 3
            goto L_0x01ac
        L_0x01a9:
            r2 = 1
            goto L_0x01ac
        L_0x01ab:
            r2 = 2
        L_0x01ac:
            r0.c(r3)
        L_0x01af:
            r14.G(r6)
            r14.F(r1)
            goto L_0x0008
        L_0x01b7:
            f2.g r14 = new f2.g
            d9.r1 r0 = r0.e()
            r14.<init>(r13, r0)
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: f2.g.b(int, j1.b0):f2.g");
    }

    public final a a(Class cls) {
        p0 l10 = this.f5471a.listIterator(0);
        while (l10.hasNext()) {
            a aVar = (a) l10.next();
            if (aVar.getClass() == cls) {
                return aVar;
            }
        }
        return null;
    }

    public final int getType() {
        return this.f5472b;
    }
}
