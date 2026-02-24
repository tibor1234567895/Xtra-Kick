package u2;

import android.util.Pair;
import d2.z;
import g1.a1;
import j1.b0;
import j1.l0;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f15220a = l0.z("OpusHead");

    private h() {
    }

    public static e a(int i10, b0 b0Var) {
        b0Var.G(i10 + 8 + 4);
        b0Var.H(1);
        b(b0Var);
        b0Var.H(2);
        int v10 = b0Var.v();
        if ((v10 & 128) != 0) {
            b0Var.H(2);
        }
        if ((v10 & 64) != 0) {
            b0Var.H(b0Var.v());
        }
        if ((v10 & 32) != 0) {
            b0Var.H(2);
        }
        b0Var.H(1);
        b(b0Var);
        String e10 = a1.e(b0Var.v());
        if ("audio/mpeg".equals(e10) || "audio/vnd.dts".equals(e10) || "audio/vnd.dts.hd".equals(e10)) {
            return new e(e10, (byte[]) null, -1, -1);
        }
        b0Var.H(4);
        long w10 = b0Var.w();
        long w11 = b0Var.w();
        b0Var.H(1);
        int b10 = b(b0Var);
        byte[] bArr = new byte[b10];
        b0Var.d(bArr, 0, b10);
        long j10 = -1;
        long j11 = w11 > 0 ? w11 : -1;
        if (w10 > 0) {
            j10 = w10;
        }
        return new e(e10, bArr, j11, j10);
    }

    public static int b(b0 b0Var) {
        int v10 = b0Var.v();
        int i10 = v10 & 127;
        while ((v10 & 128) == 128) {
            v10 = b0Var.v();
            i10 = (i10 << 7) | (v10 & 127);
        }
        return i10;
    }

    public static Pair c(int i10, int i11, b0 b0Var) {
        boolean z10;
        Pair pair;
        boolean z11;
        boolean z12;
        Integer num;
        v vVar;
        int i12;
        int i13;
        boolean z13;
        byte[] bArr;
        b0 b0Var2 = b0Var;
        int i14 = b0Var2.f8415b;
        while (i14 - i10 < i11) {
            b0Var2.G(i14);
            int f10 = b0Var.f();
            boolean z14 = true;
            if (f10 > 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            z.a("childAtomSize must be positive", z10);
            if (b0Var.f() == 1936289382) {
                int i15 = i14 + 8;
                int i16 = -1;
                int i17 = 0;
                String str = null;
                Integer num2 = null;
                while (i15 - i14 < f10) {
                    b0Var2.G(i15);
                    int f11 = b0Var.f();
                    int f12 = b0Var.f();
                    if (f12 == 1718775137) {
                        num2 = Integer.valueOf(b0Var.f());
                    } else if (f12 == 1935894637) {
                        b0Var2.H(4);
                        str = b0Var2.s(4);
                    } else if (f12 == 1935894633) {
                        i16 = i15;
                        i17 = f11;
                    }
                    i15 += f11;
                }
                if ("cenc".equals(str) || "cbc1".equals(str) || "cens".equals(str) || "cbcs".equals(str)) {
                    if (num2 != null) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    z.a("frma atom is mandatory", z11);
                    if (i16 != -1) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    z.a("schi atom is mandatory", z12);
                    int i18 = i16 + 8;
                    while (true) {
                        if (i18 - i16 >= i17) {
                            num = num2;
                            vVar = null;
                            break;
                        }
                        b0Var2.G(i18);
                        int f13 = b0Var.f();
                        if (b0Var.f() == 1952804451) {
                            int f14 = (b0Var.f() >> 24) & 255;
                            b0Var2.H(1);
                            if (f14 == 0) {
                                b0Var2.H(1);
                                i13 = 0;
                                i12 = 0;
                            } else {
                                int v10 = b0Var.v();
                                i13 = v10 & 15;
                                i12 = (v10 & 240) >> 4;
                            }
                            if (b0Var.v() == 1) {
                                z13 = true;
                            } else {
                                z13 = false;
                            }
                            int v11 = b0Var.v();
                            byte[] bArr2 = new byte[16];
                            b0Var2.d(bArr2, 0, 16);
                            if (!z13 || v11 != 0) {
                                bArr = null;
                            } else {
                                int v12 = b0Var.v();
                                byte[] bArr3 = new byte[v12];
                                b0Var2.d(bArr3, 0, v12);
                                bArr = bArr3;
                            }
                            num = num2;
                            vVar = new v(z13, str, v11, bArr2, i12, i13, bArr);
                        } else {
                            Integer num3 = num2;
                            i18 += f13;
                        }
                    }
                    if (vVar == null) {
                        z14 = false;
                    }
                    z.a("tenc atom is mandatory", z14);
                    int i19 = l0.f8453a;
                    pair = Pair.create(num, vVar);
                } else {
                    pair = null;
                }
                if (pair != null) {
                    return pair;
                }
            }
            i14 += f10;
        }
        return null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v1, resolved type: d9.r1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v6, resolved type: d9.r1} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:220:0x0360  */
    /* JADX WARNING: Removed duplicated region for block: B:330:0x06fc  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static androidx.activity.result.j d(j1.b0 r43, int r44, int r45, java.lang.String r46, g1.u r47, boolean r48) {
        /*
            r0 = r43
            r1 = r46
            r2 = r47
            r3 = 12
            r0.G(r3)
            int r3 = r43.f()
            androidx.activity.result.j r4 = new androidx.activity.result.j
            r4.<init>((int) r3)
            r7 = r44
            r6 = 0
        L_0x0017:
            if (r6 >= r3) goto L_0x0b57
            int r8 = r0.f8415b
            int r9 = r43.f()
            if (r9 <= 0) goto L_0x0023
            r11 = 1
            goto L_0x0024
        L_0x0023:
            r11 = 0
        L_0x0024:
            java.lang.String r12 = "childAtomSize must be positive"
            d2.z.a(r12, r11)
            int r11 = r43.f()
            r14 = 1211250227(0x48323633, float:182488.8)
            r10 = 1635148593(0x61766331, float:2.840654E20)
            r5 = 1831958048(0x6d317620, float:3.4326032E27)
            r15 = 1701733238(0x656e6376, float:7.035987E22)
            java.lang.Object r13 = r4.f519j
            if (r11 == r10) goto L_0x071d
            r10 = 1635148595(0x61766333, float:2.8406544E20)
            if (r11 == r10) goto L_0x071d
            if (r11 == r15) goto L_0x071d
            if (r11 == r5) goto L_0x071d
            r10 = 1836070006(0x6d703476, float:4.646239E27)
            if (r11 == r10) goto L_0x071d
            r10 = 1752589105(0x68766331, float:4.6541277E24)
            if (r11 == r10) goto L_0x071d
            r10 = 1751479857(0x68657631, float:4.3344087E24)
            if (r11 == r10) goto L_0x071d
            r10 = 1932670515(0x73323633, float:1.4119387E31)
            if (r11 == r10) goto L_0x071d
            if (r11 == r14) goto L_0x071d
            r10 = 1987063864(0x76703038, float:1.21789965E33)
            if (r11 == r10) goto L_0x071d
            r10 = 1987063865(0x76703039, float:1.2178997E33)
            if (r11 == r10) goto L_0x071d
            r10 = 1635135537(0x61763031, float:2.8383572E20)
            if (r11 == r10) goto L_0x071d
            r10 = 1685479798(0x64766176, float:1.8179687E22)
            if (r11 == r10) goto L_0x071d
            r10 = 1685479729(0x64766131, float:1.817961E22)
            if (r11 == r10) goto L_0x071d
            r10 = 1685481573(0x64766865, float:1.8181686E22)
            if (r11 == r10) goto L_0x071d
            r10 = 1685481521(0x64766831, float:1.8181627E22)
            if (r11 != r10) goto L_0x0081
            goto L_0x071d
        L_0x0081:
            r5 = 1836069985(0x6d703461, float:4.6462328E27)
            r14 = 1633889587(0x61632d33, float:2.6191674E20)
            r15 = 1701733217(0x656e6361, float:7.0359778E22)
            r10 = 1634492771(0x616c6163, float:2.7252807E20)
            if (r11 == r5) goto L_0x01d1
            if (r11 == r15) goto L_0x01d1
            if (r11 == r14) goto L_0x01d1
            r5 = 1700998451(0x65632d33, float:6.7050686E22)
            if (r11 == r5) goto L_0x01d1
            r5 = 1633889588(0x61632d34, float:2.6191676E20)
            if (r11 == r5) goto L_0x01d1
            r5 = 1835823201(0x6d6c7061, float:4.573395E27)
            if (r11 == r5) goto L_0x01d1
            r5 = 1685353315(0x64747363, float:1.803728E22)
            if (r11 == r5) goto L_0x01d1
            r5 = 1685353317(0x64747365, float:1.8037282E22)
            if (r11 == r5) goto L_0x01d1
            r5 = 1685353320(0x64747368, float:1.8037286E22)
            if (r11 == r5) goto L_0x01d1
            r5 = 1685353324(0x6474736c, float:1.803729E22)
            if (r11 == r5) goto L_0x01d1
            r5 = 1685353336(0x64747378, float:1.8037304E22)
            if (r11 == r5) goto L_0x01d1
            r5 = 1935764850(0x73616d72, float:1.7860208E31)
            if (r11 == r5) goto L_0x01d1
            r5 = 1935767394(0x73617762, float:1.7863284E31)
            if (r11 == r5) goto L_0x01d1
            r5 = 1819304813(0x6c70636d, float:1.1624469E27)
            if (r11 == r5) goto L_0x01d1
            r5 = 1936684916(0x736f7774, float:1.89725E31)
            if (r11 == r5) goto L_0x01d1
            r5 = 1953984371(0x74776f73, float:7.841539E31)
            if (r11 == r5) goto L_0x01d1
            r5 = 778924082(0x2e6d7032, float:5.398721E-11)
            if (r11 == r5) goto L_0x01d1
            r5 = 778924083(0x2e6d7033, float:5.3987214E-11)
            if (r11 == r5) goto L_0x01d1
            r5 = 1835557169(0x6d686131, float:4.4948762E27)
            if (r11 == r5) goto L_0x01d1
            r5 = 1835560241(0x6d686d31, float:4.495783E27)
            if (r11 == r5) goto L_0x01d1
            if (r11 == r10) goto L_0x01d1
            r5 = 1634492791(0x616c6177, float:2.7252842E20)
            if (r11 == r5) goto L_0x01d1
            r5 = 1970037111(0x756c6177, float:2.9964816E32)
            if (r11 == r5) goto L_0x01d1
            r5 = 1332770163(0x4f707573, float:4.03422899E9)
            if (r11 == r5) goto L_0x01d1
            r5 = 1716281667(0x664c6143, float:2.4128923E23)
            if (r11 != r5) goto L_0x0100
            goto L_0x01d1
        L_0x0100:
            r5 = 1414810956(0x54544d4c, float:3.64731957E12)
            if (r11 == r5) goto L_0x0161
            r5 = 1954034535(0x74783367, float:7.865797E31)
            if (r11 == r5) goto L_0x0161
            r5 = 2004251764(0x77767474, float:4.998699E33)
            if (r11 == r5) goto L_0x0161
            r5 = 1937010800(0x73747070, float:1.9366469E31)
            if (r11 == r5) goto L_0x0161
            r5 = 1664495672(0x63363038, float:3.360782E21)
            if (r11 != r5) goto L_0x011a
            goto L_0x0161
        L_0x011a:
            r5 = 1835365492(0x6d657474, float:4.4383032E27)
            if (r11 != r5) goto L_0x0148
            int r5 = r8 + 8
            r10 = 8
            int r5 = r5 + r10
            r0.G(r5)
            r5 = 1835365492(0x6d657474, float:4.4383032E27)
            if (r11 != r5) goto L_0x01c0
            r43.p()
            java.lang.String r5 = r43.p()
            if (r5 == 0) goto L_0x01c0
            g1.z r10 = new g1.z
            r10.<init>()
            r10.b(r7)
            r10.f6754k = r5
            g1.a0 r5 = new g1.a0
            r5.<init>(r10)
            r4.f520k = r5
            goto L_0x01c0
        L_0x0148:
            r5 = 1667329389(0x63616d6d, float:4.1584024E21)
            if (r11 != r5) goto L_0x01c0
            g1.z r5 = new g1.z
            r5.<init>()
            r5.b(r7)
            java.lang.String r10 = "application/x-camera-motion"
            r5.f6754k = r10
            g1.a0 r10 = new g1.a0
            r10.<init>(r5)
            r4.f520k = r10
            goto L_0x01c0
        L_0x0161:
            int r5 = r8 + 8
            r10 = 8
            int r5 = r5 + r10
            r0.G(r5)
            r5 = 1414810956(0x54544d4c, float:3.64731957E12)
            java.lang.String r10 = "application/ttml+xml"
            r12 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            if (r11 != r5) goto L_0x0176
            goto L_0x01a7
        L_0x0176:
            r5 = 1954034535(0x74783367, float:7.865797E31)
            if (r11 != r5) goto L_0x018c
            int r5 = r9 + -8
            int r5 = r5 + -8
            byte[] r10 = new byte[r5]
            r11 = 0
            r0.d(r10, r11, r5)
            d9.r1 r10 = d9.r0.n(r10)
            java.lang.String r5 = "application/x-quicktime-tx3g"
            goto L_0x01a9
        L_0x018c:
            r5 = 2004251764(0x77767474, float:4.998699E33)
            if (r11 != r5) goto L_0x0194
            java.lang.String r10 = "application/x-mp4-vtt"
            goto L_0x01a7
        L_0x0194:
            r5 = 1937010800(0x73747070, float:1.9366469E31)
            if (r11 != r5) goto L_0x019d
            r11 = 0
            r12 = r11
            goto L_0x01a7
        L_0x019d:
            r5 = 1664495672(0x63363038, float:3.360782E21)
            if (r11 != r5) goto L_0x01cb
            r5 = 1
            r4.f518i = r5
            java.lang.String r10 = "application/x-mp4-cea-608"
        L_0x01a7:
            r5 = r10
            r10 = 0
        L_0x01a9:
            g1.z r11 = new g1.z
            r11.<init>()
            r11.b(r7)
            r11.f6754k = r5
            r11.f6746c = r1
            r11.f6758o = r12
            r11.f6756m = r10
            g1.a0 r5 = new g1.a0
            r5.<init>(r11)
            r4.f520k = r5
        L_0x01c0:
            r23 = r3
            r25 = r6
        L_0x01c4:
            r31 = r8
            r28 = r9
            r9 = 0
            goto L_0x0713
        L_0x01cb:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r0.<init>()
            throw r0
        L_0x01d1:
            int r5 = r8 + 8
            r10 = 8
            int r5 = r5 + r10
            r0.G(r5)
            r5 = 6
            if (r48 == 0) goto L_0x01e6
            int r19 = r43.A()
            r0.H(r5)
            r10 = r19
            goto L_0x01ea
        L_0x01e6:
            r0.H(r10)
            r10 = 0
        L_0x01ea:
            r14 = 20
            if (r10 == 0) goto L_0x0217
            r15 = 1
            if (r10 != r15) goto L_0x01f2
            goto L_0x0217
        L_0x01f2:
            r15 = 2
            if (r10 != r15) goto L_0x0212
            r10 = 16
            r0.H(r10)
            long r15 = r43.o()
            double r15 = java.lang.Double.longBitsToDouble(r15)
            r25 = r6
            long r5 = java.lang.Math.round(r15)
            int r6 = (int) r5
            int r5 = r43.y()
            r0.H(r14)
            r14 = 0
            goto L_0x024c
        L_0x0212:
            r25 = r6
            r23 = r3
            goto L_0x01c4
        L_0x0217:
            r25 = r6
            int r5 = r43.A()
            r6 = 6
            r0.H(r6)
            byte[] r6 = r0.f8414a
            int r15 = r0.f8415b
            int r27 = r15 + 1
            byte r15 = r6[r15]
            r15 = r15 & 255(0xff, float:3.57E-43)
            r19 = 8
            int r15 = r15 << 8
            int r28 = r27 + 1
            byte r6 = r6[r27]
            r6 = r6 & 255(0xff, float:3.57E-43)
            r6 = r6 | r15
            r15 = 2
            int r14 = r28 + 2
            r0.f8415b = r14
            r15 = 4
            int r14 = r14 - r15
            r0.G(r14)
            int r14 = r43.f()
            r15 = 1
            if (r10 != r15) goto L_0x024c
            r10 = 16
            r0.H(r10)
        L_0x024c:
            int r10 = r0.f8415b
            r15 = 1701733217(0x656e6361, float:7.0359778E22)
            if (r11 != r15) goto L_0x0281
            android.util.Pair r15 = c(r8, r9, r0)
            if (r15 == 0) goto L_0x027a
            java.lang.Object r11 = r15.first
            java.lang.Integer r11 = (java.lang.Integer) r11
            int r11 = r11.intValue()
            r23 = r3
            if (r2 != 0) goto L_0x0267
            r3 = 0
            goto L_0x0271
        L_0x0267:
            java.lang.Object r3 = r15.second
            u2.v r3 = (u2.v) r3
            java.lang.String r3 = r3.f15317b
            g1.u r3 = r2.u(r3)
        L_0x0271:
            u2.v[] r13 = (u2.v[]) r13
            java.lang.Object r15 = r15.second
            u2.v r15 = (u2.v) r15
            r13[r25] = r15
            goto L_0x027d
        L_0x027a:
            r23 = r3
            r3 = r2
        L_0x027d:
            r0.G(r10)
            goto L_0x0284
        L_0x0281:
            r23 = r3
            r3 = r2
        L_0x0284:
            java.lang.String r13 = "audio/ac4"
            java.lang.String r15 = "audio/eac3"
            r16 = r5
            java.lang.String r5 = "audio/ac3"
            r28 = r6
            r6 = 1633889587(0x61632d33, float:2.6191674E20)
            if (r11 != r6) goto L_0x0296
            r6 = r5
            goto L_0x034b
        L_0x0296:
            r6 = 1700998451(0x65632d33, float:6.7050686E22)
            if (r11 != r6) goto L_0x029e
            r6 = r15
            goto L_0x034b
        L_0x029e:
            r6 = 1633889588(0x61632d34, float:2.6191676E20)
            if (r11 != r6) goto L_0x02a6
            r6 = r13
            goto L_0x034b
        L_0x02a6:
            r6 = 1685353315(0x64747363, float:1.803728E22)
            if (r11 != r6) goto L_0x02af
            java.lang.String r6 = "audio/vnd.dts"
            goto L_0x034b
        L_0x02af:
            r6 = 1685353320(0x64747368, float:1.8037286E22)
            if (r11 == r6) goto L_0x0349
            r6 = 1685353324(0x6474736c, float:1.803729E22)
            if (r11 != r6) goto L_0x02bb
            goto L_0x0349
        L_0x02bb:
            r6 = 1685353317(0x64747365, float:1.8037282E22)
            if (r11 != r6) goto L_0x02c4
            java.lang.String r6 = "audio/vnd.dts.hd;profile=lbr"
            goto L_0x034b
        L_0x02c4:
            r6 = 1685353336(0x64747378, float:1.8037304E22)
            if (r11 != r6) goto L_0x02cd
            java.lang.String r6 = "audio/vnd.dts.uhd;profile=p2"
            goto L_0x034b
        L_0x02cd:
            r6 = 1935764850(0x73616d72, float:1.7860208E31)
            if (r11 != r6) goto L_0x02d6
            java.lang.String r6 = "audio/3gpp"
            goto L_0x034b
        L_0x02d6:
            r6 = 1935767394(0x73617762, float:1.7863284E31)
            if (r11 != r6) goto L_0x02df
            java.lang.String r6 = "audio/amr-wb"
            goto L_0x034b
        L_0x02df:
            r6 = 1819304813(0x6c70636d, float:1.1624469E27)
            if (r11 == r6) goto L_0x0345
            r6 = 1936684916(0x736f7774, float:1.89725E31)
            if (r11 != r6) goto L_0x02eb
            goto L_0x0345
        L_0x02eb:
            r6 = 1953984371(0x74776f73, float:7.841539E31)
            if (r11 != r6) goto L_0x02f5
            java.lang.String r6 = "audio/raw"
            r11 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x034c
        L_0x02f5:
            r6 = 778924082(0x2e6d7032, float:5.398721E-11)
            if (r11 == r6) goto L_0x0342
            r6 = 778924083(0x2e6d7033, float:5.3987214E-11)
            if (r11 != r6) goto L_0x0300
            goto L_0x0342
        L_0x0300:
            r6 = 1835557169(0x6d686131, float:4.4948762E27)
            if (r11 != r6) goto L_0x0308
            java.lang.String r6 = "audio/mha1"
            goto L_0x034b
        L_0x0308:
            r6 = 1835560241(0x6d686d31, float:4.495783E27)
            if (r11 != r6) goto L_0x0310
            java.lang.String r6 = "audio/mhm1"
            goto L_0x034b
        L_0x0310:
            r6 = 1634492771(0x616c6163, float:2.7252807E20)
            if (r11 != r6) goto L_0x0318
            java.lang.String r6 = "audio/alac"
            goto L_0x034b
        L_0x0318:
            r6 = 1634492791(0x616c6177, float:2.7252842E20)
            if (r11 != r6) goto L_0x0320
            java.lang.String r6 = "audio/g711-alaw"
            goto L_0x034b
        L_0x0320:
            r6 = 1970037111(0x756c6177, float:2.9964816E32)
            if (r11 != r6) goto L_0x0328
            java.lang.String r6 = "audio/g711-mlaw"
            goto L_0x034b
        L_0x0328:
            r6 = 1332770163(0x4f707573, float:4.03422899E9)
            if (r11 != r6) goto L_0x0330
            java.lang.String r6 = "audio/opus"
            goto L_0x034b
        L_0x0330:
            r6 = 1716281667(0x664c6143, float:2.4128923E23)
            if (r11 != r6) goto L_0x0338
            java.lang.String r6 = "audio/flac"
            goto L_0x034b
        L_0x0338:
            r6 = 1835823201(0x6d6c7061, float:4.573395E27)
            if (r11 != r6) goto L_0x0340
            java.lang.String r6 = "audio/true-hd"
            goto L_0x034b
        L_0x0340:
            r6 = 0
            goto L_0x034b
        L_0x0342:
            java.lang.String r6 = "audio/mpeg"
            goto L_0x034b
        L_0x0345:
            java.lang.String r6 = "audio/raw"
            r11 = 2
            goto L_0x034c
        L_0x0349:
            java.lang.String r6 = "audio/vnd.dts.hd"
        L_0x034b:
            r11 = -1
        L_0x034c:
            r20 = r11
            r2 = r16
            r22 = 0
            r29 = 0
            r30 = 0
            r16 = r15
            r15 = r10
            r10 = r6
            r6 = r28
        L_0x035c:
            int r11 = r15 - r8
            if (r11 >= r9) goto L_0x06ca
            r0.G(r15)
            int r11 = r43.f()
            r28 = r9
            if (r11 <= 0) goto L_0x036d
            r9 = 1
            goto L_0x036e
        L_0x036d:
            r9 = 0
        L_0x036e:
            d2.z.a(r12, r9)
            int r9 = r43.f()
            r31 = r8
            r8 = 1835557187(0x6d686143, float:4.4948815E27)
            if (r9 != r8) goto L_0x039c
            int r8 = r11 + -13
            byte[] r9 = new byte[r8]
            r32 = r12
            int r12 = r15 + 13
            r0.G(r12)
            r12 = 0
            r0.d(r9, r12, r8)
            d9.r1 r8 = d9.r0.n(r9)
            r34 = r2
            r36 = r5
            r33 = r6
            r29 = r8
            r35 = r10
            r6 = 4
            goto L_0x05a0
        L_0x039c:
            r32 = r12
            r8 = 1702061171(0x65736473, float:7.183675E22)
            if (r9 == r8) goto L_0x062d
            if (r48 == 0) goto L_0x03b7
            r8 = 2002876005(0x77617665, float:4.5729223E33)
            if (r9 != r8) goto L_0x03b7
            r12 = r2
            r36 = r5
            r2 = r6
            r8 = r10
            r5 = 1702061171(0x65736473, float:7.183675E22)
            r6 = 4
            r10 = 20
            goto L_0x0638
        L_0x03b7:
            int[] r8 = d2.c.f4153d
            int[] r12 = d2.c.f4151b
            r33 = r6
            r6 = 1684103987(0x64616333, float:1.6630662E22)
            if (r9 != r6) goto L_0x0433
            int r6 = r15 + 8
            r0.G(r6)
            java.lang.String r6 = java.lang.Integer.toString(r44)
            j1.a0 r9 = new j1.a0
            r9.<init>()
            r34 = r2
            byte[] r2 = r0.f8414a
            r35 = r10
            int r10 = r0.f8416c
            r9.j(r10, r2)
            int r2 = r0.f8415b
            r10 = 8
            int r2 = r2 * 8
            r9.k(r2)
            r2 = 2
            int r19 = r9.g(r2)
            r2 = r12[r19]
            r9.m(r10)
            r10 = 3
            int r12 = r9.g(r10)
            r8 = r8[r12]
            r10 = 1
            int r12 = r9.g(r10)
            if (r12 == 0) goto L_0x03fe
            int r8 = r8 + 1
        L_0x03fe:
            r10 = 5
            int r10 = r9.g(r10)
            int[] r12 = d2.c.f4154e
            r10 = r12[r10]
            int r10 = r10 * 1000
            r9.c()
            int r9 = r9.d()
            r0.G(r9)
            g1.z r9 = new g1.z
            r9.<init>()
            r9.f6744a = r6
            r9.f6754k = r5
            r9.f6767x = r8
            r9.f6768y = r2
            r9.f6757n = r3
            r9.f6746c = r1
            r9.f6749f = r10
            r9.f6750g = r10
            g1.a0 r2 = new g1.a0
            r2.<init>(r9)
            r4.f520k = r2
            r36 = r5
            goto L_0x051c
        L_0x0433:
            r34 = r2
            r35 = r10
            r2 = 1684366131(0x64656333, float:1.692581E22)
            if (r9 != r2) goto L_0x04de
            int r2 = r15 + 8
            r0.G(r2)
            java.lang.String r2 = java.lang.Integer.toString(r44)
            j1.a0 r6 = new j1.a0
            r6.<init>()
            byte[] r9 = r0.f8414a
            int r10 = r0.f8416c
            r6.j(r10, r9)
            int r9 = r0.f8415b
            r10 = 8
            int r9 = r9 * 8
            r6.k(r9)
            r9 = 13
            int r9 = r6.g(r9)
            int r9 = r9 * 1000
            r10 = 3
            r6.m(r10)
            r10 = 2
            int r36 = r6.g(r10)
            r10 = r12[r36]
            r12 = 10
            r6.m(r12)
            r12 = 3
            int r17 = r6.g(r12)
            r8 = r8[r17]
            r12 = 1
            int r18 = r6.g(r12)
            if (r18 == 0) goto L_0x0482
            int r8 = r8 + 1
        L_0x0482:
            r12 = 3
            r6.m(r12)
            r12 = 4
            int r36 = r6.g(r12)
            r12 = 1
            r6.m(r12)
            if (r36 <= 0) goto L_0x04a3
            r36 = r5
            r5 = 6
            r6.n(r5)
            int r18 = r6.g(r12)
            if (r18 == 0) goto L_0x049f
            int r8 = r8 + 2
        L_0x049f:
            r6.m(r12)
            goto L_0x04a5
        L_0x04a3:
            r36 = r5
        L_0x04a5:
            int r5 = r6.b()
            r12 = 7
            if (r5 <= r12) goto L_0x04b9
            r6.m(r12)
            r5 = 1
            int r12 = r6.g(r5)
            if (r12 == 0) goto L_0x04b9
            java.lang.String r5 = "audio/eac3-joc"
            goto L_0x04bb
        L_0x04b9:
            r5 = r16
        L_0x04bb:
            r6.c()
            int r6 = r6.d()
            r0.G(r6)
            g1.z r6 = new g1.z
            r6.<init>()
            r6.f6744a = r2
            r6.f6754k = r5
            r6.f6767x = r8
            r6.f6768y = r10
            r6.f6757n = r3
            r6.f6746c = r1
            r6.f6750g = r9
            g1.a0 r2 = new g1.a0
            r2.<init>(r6)
            goto L_0x051a
        L_0x04de:
            r36 = r5
            r2 = 1684103988(0x64616334, float:1.6630663E22)
            if (r9 != r2) goto L_0x0525
            int r2 = r15 + 8
            r0.G(r2)
            java.lang.String r2 = java.lang.Integer.toString(r44)
            r5 = 1
            r0.H(r5)
            int r6 = r43.v()
            r6 = r6 & 32
            int r6 = r6 >> 5
            if (r6 != r5) goto L_0x0500
            r5 = 48000(0xbb80, float:6.7262E-41)
            goto L_0x0503
        L_0x0500:
            r5 = 44100(0xac44, float:6.1797E-41)
        L_0x0503:
            g1.z r6 = new g1.z
            r6.<init>()
            r6.f6744a = r2
            r6.f6754k = r13
            r2 = 2
            r6.f6767x = r2
            r6.f6768y = r5
            r6.f6757n = r3
            r6.f6746c = r1
            g1.a0 r2 = new g1.a0
            r2.<init>(r6)
        L_0x051a:
            r4.f520k = r2
        L_0x051c:
            r9 = r33
            r12 = r34
            r8 = r35
            r6 = 4
            goto L_0x05a6
        L_0x0525:
            r2 = 1684892784(0x646d6c70, float:1.7518768E22)
            if (r9 != r2) goto L_0x0548
            if (r14 <= 0) goto L_0x0534
            r6 = r14
            r10 = r32
            r8 = r35
            r2 = 2
            goto L_0x0628
        L_0x0534:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Invalid sample rate for Dolby TrueHD MLP stream: "
            r0.<init>(r1)
            r0.append(r14)
            java.lang.String r0 = r0.toString()
            r1 = 0
            g1.b1 r0 = g1.b1.a(r0, r1)
            throw r0
        L_0x0548:
            r2 = 1684305011(0x64647473, float:1.6856995E22)
            if (r9 == r2) goto L_0x05ff
            r2 = 1969517683(0x75647473, float:2.8960097E32)
            if (r9 != r2) goto L_0x0554
            goto L_0x05ff
        L_0x0554:
            r2 = 1682927731(0x644f7073, float:1.5306315E22)
            if (r9 != r2) goto L_0x0572
            int r2 = r11 + -8
            byte[] r5 = f15220a
            int r6 = r5.length
            int r6 = r6 + r2
            byte[] r6 = java.util.Arrays.copyOf(r5, r6)
            int r8 = r15 + 8
            r0.G(r8)
            int r5 = r5.length
            r0.d(r6, r5, r2)
            java.util.ArrayList r2 = d2.q0.a(r6)
            r6 = 4
            goto L_0x059e
        L_0x0572:
            r2 = 1684425825(0x64664c61, float:1.6993019E22)
            if (r9 != r2) goto L_0x05aa
            int r2 = r11 + -12
            int r5 = r2 + 4
            byte[] r5 = new byte[r5]
            r6 = 102(0x66, float:1.43E-43)
            r8 = 0
            r5[r8] = r6
            r6 = 76
            r8 = 1
            r5[r8] = r6
            r6 = 97
            r8 = 2
            r5[r8] = r6
            r6 = 67
            r8 = 3
            r5[r8] = r6
            int r6 = r15 + 12
            r0.G(r6)
            r6 = 4
            r0.d(r5, r6, r2)
            d9.r1 r2 = d9.r0.n(r5)
        L_0x059e:
            r29 = r2
        L_0x05a0:
            r9 = r33
            r12 = r34
            r8 = r35
        L_0x05a6:
            r10 = 20
            goto L_0x0624
        L_0x05aa:
            r2 = 1634492771(0x616c6163, float:2.7252807E20)
            r6 = 4
            if (r9 != r2) goto L_0x05f8
            int r5 = r11 + -12
            byte[] r8 = new byte[r5]
            int r9 = r15 + 12
            r0.G(r9)
            r9 = 0
            r0.d(r8, r9, r5)
            j1.b0 r5 = new j1.b0
            r5.<init>((byte[]) r8)
            r9 = 9
            r5.G(r9)
            int r9 = r5.v()
            r10 = 20
            r5.G(r10)
            int r5 = r5.y()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            android.util.Pair r5 = android.util.Pair.create(r5, r9)
            java.lang.Object r9 = r5.first
            java.lang.Integer r9 = (java.lang.Integer) r9
            int r9 = r9.intValue()
            java.lang.Object r5 = r5.second
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            d9.r1 r29 = d9.r0.n(r8)
            r12 = r5
        L_0x05f5:
            r8 = r35
            goto L_0x0624
        L_0x05f8:
            r10 = 20
            r9 = r33
            r12 = r34
            goto L_0x05f5
        L_0x05ff:
            r2 = 1634492771(0x616c6163, float:2.7252807E20)
            r6 = 4
            r10 = 20
            g1.z r5 = new g1.z
            r5.<init>()
            r5.b(r7)
            r8 = r35
            r5.f6754k = r8
            r12 = r34
            r5.f6767x = r12
            r9 = r33
            r5.f6768y = r9
            r5.f6757n = r3
            r5.f6746c = r1
            g1.a0 r2 = new g1.a0
            r2.<init>(r5)
            r4.f520k = r2
        L_0x0624:
            r6 = r9
            r2 = r12
            r10 = r32
        L_0x0628:
            r9 = 0
            r32 = r13
            goto L_0x06bd
        L_0x062d:
            r12 = r2
            r36 = r5
            r2 = r6
            r8 = r10
            r6 = 4
            r10 = 20
            r5 = 1702061171(0x65736473, float:7.183675E22)
        L_0x0638:
            if (r9 != r5) goto L_0x0641
            r5 = r15
            r10 = r32
            r6 = -1
            r32 = r13
            goto L_0x067b
        L_0x0641:
            int r5 = r0.f8415b
            r6 = 0
            if (r5 < r15) goto L_0x0648
            r9 = 1
            goto L_0x0649
        L_0x0648:
            r9 = 0
        L_0x0649:
            d2.z.a(r6, r9)
        L_0x064c:
            int r6 = r5 - r15
            if (r6 >= r11) goto L_0x0675
            r0.G(r5)
            int r6 = r43.f()
            r10 = r32
            if (r6 <= 0) goto L_0x065d
            r9 = 1
            goto L_0x065e
        L_0x065d:
            r9 = 0
        L_0x065e:
            d2.z.a(r10, r9)
            int r9 = r43.f()
            r32 = r13
            r13 = 1702061171(0x65736473, float:7.183675E22)
            if (r9 != r13) goto L_0x066d
            goto L_0x067a
        L_0x066d:
            int r5 = r5 + r6
            r13 = r32
            r32 = r10
            r10 = 20
            goto L_0x064c
        L_0x0675:
            r10 = r32
            r32 = r13
            r5 = -1
        L_0x067a:
            r6 = -1
        L_0x067b:
            if (r5 == r6) goto L_0x06ba
            u2.e r5 = a(r5, r0)
            java.lang.String r6 = r5.f15211a
            byte[] r8 = r5.f15212b
            if (r8 == 0) goto L_0x06af
            java.lang.String r9 = "audio/mp4a-latm"
            boolean r9 = r9.equals(r6)
            if (r9 == 0) goto L_0x06a4
            j1.a0 r2 = new j1.a0
            int r9 = r8.length
            r2.<init>(r9, r8)
            r9 = 0
            j1.k r2 = d2.a.b(r2, r9)
            int r12 = r2.f8450a
            int r13 = r2.f8451b
            java.lang.String r2 = r2.f8452c
            r22 = r2
            r2 = r13
            goto L_0x06aa
        L_0x06a4:
            r9 = 0
            r42 = r12
            r12 = r2
            r2 = r42
        L_0x06aa:
            d9.r1 r29 = d9.r0.n(r8)
            goto L_0x06b5
        L_0x06af:
            r9 = 0
            r42 = r12
            r12 = r2
            r2 = r42
        L_0x06b5:
            r30 = r5
            r8 = r6
            r6 = r12
            goto L_0x06bd
        L_0x06ba:
            r9 = 0
            r6 = r2
            r2 = r12
        L_0x06bd:
            int r15 = r15 + r11
            r12 = r10
            r9 = r28
            r13 = r32
            r5 = r36
            r10 = r8
            r8 = r31
            goto L_0x035c
        L_0x06ca:
            r12 = r2
            r2 = r6
            r31 = r8
            r28 = r9
            r8 = r10
            r9 = 0
            java.lang.Object r5 = r4.f520k
            g1.a0 r5 = (g1.a0) r5
            if (r5 != 0) goto L_0x0713
            if (r8 == 0) goto L_0x0713
            g1.z r5 = new g1.z
            r5.<init>()
            r5.b(r7)
            r5.f6754k = r8
            r6 = r22
            r5.f6751h = r6
            r5.f6767x = r12
            r5.f6768y = r2
            r11 = r20
            r5.f6769z = r11
            r2 = r29
            r5.f6756m = r2
            r5.f6757n = r3
            r5.f6746c = r1
            r2 = r30
            if (r2 == 0) goto L_0x070c
            long r10 = r2.f15213c
            int r3 = g9.b.c(r10)
            r5.f6749f = r3
            long r2 = r2.f15214d
            int r2 = g9.b.c(r2)
            r5.f6750g = r2
        L_0x070c:
            g1.a0 r2 = new g1.a0
            r2.<init>(r5)
            r4.f520k = r2
        L_0x0713:
            r3 = r45
            r2 = r4
            r1 = r7
            r33 = r28
            r7 = r44
            goto L_0x0b46
        L_0x071d:
            r23 = r3
            r25 = r6
            r31 = r8
            r28 = r9
            r10 = r12
            r9 = 0
            int r8 = r31 + 8
            r2 = 8
            int r8 = r8 + r2
            r0.G(r8)
            r2 = 16
            r0.H(r2)
            int r2 = r43.A()
            int r3 = r43.A()
            r6 = 50
            r0.H(r6)
            int r6 = r0.f8415b
            if (r11 != r15) goto L_0x0777
            r8 = r28
            r7 = r31
            android.util.Pair r12 = c(r7, r8, r0)
            if (r12 == 0) goto L_0x0770
            java.lang.Object r11 = r12.first
            java.lang.Integer r11 = (java.lang.Integer) r11
            int r11 = r11.intValue()
            r15 = r47
            if (r15 != 0) goto L_0x075d
            r9 = 0
            goto L_0x0767
        L_0x075d:
            java.lang.Object r9 = r12.second
            u2.v r9 = (u2.v) r9
            java.lang.String r9 = r9.f15317b
            g1.u r9 = r15.u(r9)
        L_0x0767:
            u2.v[] r13 = (u2.v[]) r13
            java.lang.Object r12 = r12.second
            u2.v r12 = (u2.v) r12
            r13[r25] = r12
            goto L_0x0773
        L_0x0770:
            r15 = r47
            r9 = r15
        L_0x0773:
            r0.G(r6)
            goto L_0x077e
        L_0x0777:
            r15 = r47
            r8 = r28
            r7 = r31
            r9 = r15
        L_0x077e:
            java.lang.String r12 = "video/3gpp"
            if (r11 != r5) goto L_0x0785
            java.lang.String r5 = "video/mpeg"
            goto L_0x078a
        L_0x0785:
            if (r11 != r14) goto L_0x0789
            r5 = r12
            goto L_0x078a
        L_0x0789:
            r5 = 0
        L_0x078a:
            r13 = 1065353216(0x3f800000, float:1.0)
            r15 = r6
            r21 = r9
            r16 = r12
            r1 = -1
            r6 = -1
            r9 = -1
            r14 = 0
            r19 = 0
            r22 = 0
            r24 = 0
            r26 = 0
            r27 = 1065353216(0x3f800000, float:1.0)
            r37 = -1
            r12 = r5
            r5 = 0
        L_0x07a3:
            int r13 = r15 - r7
            if (r13 >= r8) goto L_0x0aca
            r0.G(r15)
            int r13 = r0.f8415b
            r28 = r3
            int r3 = r43.f()
            r29 = r2
            if (r3 != 0) goto L_0x07bd
            int r2 = r0.f8415b
            int r2 = r2 - r7
            if (r2 != r8) goto L_0x07bd
            goto L_0x0ace
        L_0x07bd:
            if (r3 <= 0) goto L_0x07c1
            r2 = 1
            goto L_0x07c2
        L_0x07c1:
            r2 = 0
        L_0x07c2:
            d2.z.a(r10, r2)
            int r2 = r43.f()
            r32 = r10
            r10 = 1635148611(0x61766343, float:2.8406573E20)
            if (r2 != r10) goto L_0x07f7
            if (r12 != 0) goto L_0x07d4
            r2 = 1
            goto L_0x07d5
        L_0x07d4:
            r2 = 0
        L_0x07d5:
            r5 = 0
            d2.z.a(r5, r2)
            int r13 = r13 + 8
            r0.G(r13)
            d2.e r2 = d2.e.a(r43)
            int r5 = r2.f4158b
            r4.f517h = r5
            if (r24 != 0) goto L_0x07eb
            float r13 = r2.f4161e
            goto L_0x07ed
        L_0x07eb:
            r13 = r27
        L_0x07ed:
            java.lang.String r5 = "video/avc"
            java.util.List r10 = r2.f4157a
            java.lang.String r2 = r2.f4162f
            r12 = r5
            r5 = r2
            goto L_0x08c0
        L_0x07f7:
            r10 = 1752589123(0x68766343, float:4.6541328E24)
            if (r2 != r10) goto L_0x0834
            if (r12 != 0) goto L_0x0800
            r1 = 1
            goto L_0x0801
        L_0x0800:
            r1 = 0
        L_0x0801:
            r2 = 0
            d2.z.a(r2, r1)
            int r13 = r13 + 8
            r0.G(r13)
            d2.h0 r1 = d2.h0.a(r43)
            int r2 = r1.f4197b
            r4.f517h = r2
            if (r24 != 0) goto L_0x0817
            float r13 = r1.f4198c
            goto L_0x0819
        L_0x0817:
            r13 = r27
        L_0x0819:
            java.lang.String r12 = "video/hevc"
            java.util.List r6 = r1.f4196a
            java.lang.String r5 = r1.f4202g
            int r2 = r1.f4199d
            int r9 = r1.f4200e
            int r1 = r1.f4201f
            r34 = r4
            r10 = r6
            r31 = r7
            r33 = r8
            r30 = r11
            r36 = r15
            r6 = r1
            r1 = r2
            goto L_0x0944
        L_0x0834:
            r10 = 1685480259(0x64766343, float:1.8180206E22)
            if (r2 == r10) goto L_0x0a8c
            r10 = 1685485123(0x64767643, float:1.8185683E22)
            if (r2 != r10) goto L_0x0840
            goto L_0x0a8c
        L_0x0840:
            r10 = 1987076931(0x76706343, float:1.21891066E33)
            if (r2 != r10) goto L_0x0885
            if (r12 != 0) goto L_0x0849
            r1 = 1
            goto L_0x084a
        L_0x0849:
            r1 = 0
        L_0x084a:
            r2 = 0
            d2.z.a(r2, r1)
            r10 = 1987063864(0x76703038, float:1.21789965E33)
            if (r11 != r10) goto L_0x0856
            java.lang.String r1 = "video/x-vnd.on2.vp8"
            goto L_0x0858
        L_0x0856:
            java.lang.String r1 = "video/x-vnd.on2.vp9"
        L_0x0858:
            r12 = r1
            int r13 = r13 + 12
            r0.G(r13)
            r1 = 2
            r0.H(r1)
            int r1 = r43.v()
            r2 = 1
            r1 = r1 & r2
            if (r1 == 0) goto L_0x086c
            r1 = 1
            goto L_0x086d
        L_0x086c:
            r1 = 0
        L_0x086d:
            int r2 = r43.v()
            int r6 = r43.v()
            int r2 = g1.o.i(r2)
            if (r1 == 0) goto L_0x087d
            r1 = 1
            goto L_0x087e
        L_0x087d:
            r1 = 2
        L_0x087e:
            int r6 = g1.o.j(r6)
            r9 = r1
            r1 = r2
            goto L_0x08bc
        L_0x0885:
            r10 = 1635135811(0x61763143, float:2.8384055E20)
            if (r2 != r10) goto L_0x0896
            if (r12 != 0) goto L_0x088e
            r2 = 1
            goto L_0x088f
        L_0x088e:
            r2 = 0
        L_0x088f:
            r10 = 0
            d2.z.a(r10, r2)
            java.lang.String r12 = "video/av01"
            goto L_0x08bc
        L_0x0896:
            r10 = 1668050025(0x636c6c69, float:4.3612434E21)
            r30 = 25
            if (r2 != r10) goto L_0x08cc
            if (r14 != 0) goto L_0x08a9
            java.nio.ByteBuffer r2 = java.nio.ByteBuffer.allocate(r30)
            java.nio.ByteOrder r10 = java.nio.ByteOrder.LITTLE_ENDIAN
            java.nio.ByteBuffer r14 = r2.order(r10)
        L_0x08a9:
            r2 = 21
            r14.position(r2)
            short r2 = r43.r()
            r14.putShort(r2)
            short r2 = r43.r()
            r14.putShort(r2)
        L_0x08bc:
            r10 = r22
            r13 = r27
        L_0x08c0:
            r34 = r4
            r31 = r7
            r33 = r8
            r30 = r11
            r36 = r15
            goto L_0x0944
        L_0x08cc:
            r10 = 1835295606(0x6d646376, float:4.4176764E27)
            if (r2 != r10) goto L_0x0953
            if (r14 != 0) goto L_0x08de
            java.nio.ByteBuffer r2 = java.nio.ByteBuffer.allocate(r30)
            java.nio.ByteOrder r10 = java.nio.ByteOrder.LITTLE_ENDIAN
            java.nio.ByteBuffer r2 = r2.order(r10)
            r14 = r2
        L_0x08de:
            short r2 = r43.r()
            short r10 = r43.r()
            short r13 = r43.r()
            r30 = r11
            short r11 = r43.r()
            r31 = r7
            short r7 = r43.r()
            r33 = r8
            short r8 = r43.r()
            r34 = r4
            short r4 = r43.r()
            r35 = r5
            short r5 = r43.r()
            long r38 = r43.w()
            long r40 = r43.w()
            r36 = r15
            r15 = 1
            r14.position(r15)
            r14.putShort(r7)
            r14.putShort(r8)
            r14.putShort(r2)
            r14.putShort(r10)
            r14.putShort(r13)
            r14.putShort(r11)
            r14.putShort(r4)
            r14.putShort(r5)
            r4 = 10000(0x2710, double:4.9407E-320)
            long r7 = r38 / r4
            int r2 = (int) r7
            short r2 = (short) r2
            r14.putShort(r2)
            long r4 = r40 / r4
            int r2 = (int) r4
            short r2 = (short) r2
            r14.putShort(r2)
            r10 = r22
            r13 = r27
            r5 = r35
        L_0x0944:
            r35 = r5
            r22 = r10
            r27 = r13
            r4 = 0
            r5 = 1702061171(0x65736473, float:7.183675E22)
            r7 = 1
            r8 = 2
            r11 = 3
            goto L_0x0ab6
        L_0x0953:
            r34 = r4
            r35 = r5
            r31 = r7
            r33 = r8
            r30 = r11
            r36 = r15
            r4 = 1681012275(0x64323633, float:1.3149704E22)
            if (r2 != r4) goto L_0x0974
            r4 = 0
            if (r12 != 0) goto L_0x0969
            r11 = 1
            goto L_0x096a
        L_0x0969:
            r11 = 0
        L_0x096a:
            d2.z.a(r4, r11)
            r12 = r16
            r5 = 1702061171(0x65736473, float:7.183675E22)
            goto L_0x09e1
        L_0x0974:
            r4 = 0
            r5 = 1702061171(0x65736473, float:7.183675E22)
            if (r2 != r5) goto L_0x099a
            if (r12 != 0) goto L_0x097e
            r11 = 1
            goto L_0x097f
        L_0x097e:
            r11 = 0
        L_0x097f:
            d2.z.a(r4, r11)
            u2.e r2 = a(r13, r0)
            byte[] r7 = r2.f15212b
            if (r7 == 0) goto L_0x0990
            d9.r1 r7 = d9.r0.n(r7)
            r22 = r7
        L_0x0990:
            java.lang.String r7 = r2.f15211a
            r12 = r7
            r13 = r26
            r7 = 1
            r8 = 2
            r11 = 3
            goto L_0x0ab2
        L_0x099a:
            r7 = 1885434736(0x70617370, float:2.7909473E29)
            if (r2 != r7) goto L_0x09b8
            int r13 = r13 + 8
            r0.G(r13)
            int r2 = r43.y()
            int r7 = r43.y()
            float r2 = (float) r2
            float r7 = (float) r7
            float r2 = r2 / r7
            r27 = r2
            r7 = 1
            r8 = 2
            r11 = 3
            r24 = 1
            goto L_0x0ab6
        L_0x09b8:
            r7 = 1937126244(0x73763364, float:1.9506033E31)
            if (r2 != r7) goto L_0x09e8
            int r2 = r13 + 8
        L_0x09bf:
            int r7 = r2 - r13
            if (r7 >= r3) goto L_0x09df
            r0.G(r2)
            int r7 = r43.f()
            int r8 = r43.f()
            r10 = 1886547818(0x70726f6a, float:3.0012025E29)
            if (r8 != r10) goto L_0x09dd
            byte[] r8 = r0.f8414a
            int r7 = r7 + r2
            byte[] r2 = java.util.Arrays.copyOfRange(r8, r2, r7)
            r26 = r2
            goto L_0x09e1
        L_0x09dd:
            int r2 = r2 + r7
            goto L_0x09bf
        L_0x09df:
            r26 = r4
        L_0x09e1:
            r13 = r26
            r7 = 1
            r8 = 2
            r11 = 3
            goto L_0x0ab0
        L_0x09e8:
            r7 = 1936995172(0x73743364, float:1.9347576E31)
            if (r2 != r7) goto L_0x0a28
            int r2 = r43.v()
            r11 = 3
            r0.H(r11)
            if (r2 != 0) goto L_0x0a22
            int r2 = r43.v()
            r7 = 1
            if (r2 == 0) goto L_0x0a1b
            if (r2 == r7) goto L_0x0a14
            r8 = 2
            if (r2 == r8) goto L_0x0a0d
            if (r2 == r11) goto L_0x0a06
            goto L_0x0a23
        L_0x0a06:
            r13 = r26
            r8 = 2
            r37 = 3
            goto L_0x0ab0
        L_0x0a0d:
            r13 = r26
            r8 = 2
            r37 = 2
            goto L_0x0ab0
        L_0x0a14:
            r13 = r26
            r8 = 2
            r37 = 1
            goto L_0x0ab0
        L_0x0a1b:
            r13 = r26
            r8 = 2
            r37 = 0
            goto L_0x0ab0
        L_0x0a22:
            r7 = 1
        L_0x0a23:
            r13 = r26
            r8 = 2
            goto L_0x0ab0
        L_0x0a28:
            r7 = 1
            r11 = 3
            r8 = 1668246642(0x636f6c72, float:4.4165861E21)
            if (r2 != r8) goto L_0x0a8a
            r2 = -1
            if (r1 != r2) goto L_0x0a8a
            if (r9 != r2) goto L_0x0a8a
            if (r6 != r2) goto L_0x0a8a
            int r2 = r43.f()
            r8 = 1852009592(0x6e636c78, float:1.7596057E28)
            if (r2 == r8) goto L_0x0a5d
            r8 = 1852009571(0x6e636c63, float:1.7596032E28)
            if (r2 != r8) goto L_0x0a45
            goto L_0x0a5d
        L_0x0a45:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r10 = "Unsupported color type: "
            r8.<init>(r10)
            java.lang.String r2 = u2.c.c(r2)
            r8.append(r2)
            java.lang.String r2 = r8.toString()
            java.lang.String r8 = "AtomParsers"
            j1.v.g(r8, r2)
            goto L_0x0a8a
        L_0x0a5d:
            int r1 = r43.A()
            int r2 = r43.A()
            r8 = 2
            r0.H(r8)
            r6 = 19
            if (r3 != r6) goto L_0x0a77
            int r6 = r43.v()
            r6 = r6 & 128(0x80, float:1.794E-43)
            if (r6 == 0) goto L_0x0a77
            r6 = 1
            goto L_0x0a78
        L_0x0a77:
            r6 = 0
        L_0x0a78:
            int r1 = g1.o.i(r1)
            if (r6 == 0) goto L_0x0a80
            r6 = 1
            goto L_0x0a81
        L_0x0a80:
            r6 = 2
        L_0x0a81:
            int r2 = g1.o.j(r2)
            r9 = r6
            r13 = r26
            r6 = r2
            goto L_0x0ab0
        L_0x0a8a:
            r8 = 2
            goto L_0x0aaa
        L_0x0a8c:
            r34 = r4
            r35 = r5
            r31 = r7
            r33 = r8
            r30 = r11
            r36 = r15
            r4 = 0
            r5 = 1702061171(0x65736473, float:7.183675E22)
            r7 = 1
            r8 = 2
            r11 = 3
            j1.k r2 = j1.k.a(r43)
            if (r2 == 0) goto L_0x0aaa
            java.lang.String r2 = r2.f8452c
            java.lang.String r12 = "video/dolby-vision"
            goto L_0x0aac
        L_0x0aaa:
            r2 = r35
        L_0x0aac:
            r35 = r2
            r13 = r26
        L_0x0ab0:
            r2 = r19
        L_0x0ab2:
            r19 = r2
            r26 = r13
        L_0x0ab6:
            int r15 = r36 + r3
            r3 = r28
            r2 = r29
            r11 = r30
            r7 = r31
            r10 = r32
            r8 = r33
            r4 = r34
            r5 = r35
            goto L_0x07a3
        L_0x0aca:
            r29 = r2
            r28 = r3
        L_0x0ace:
            r34 = r4
            r35 = r5
            r31 = r7
            r33 = r8
            r4 = 0
            if (r12 != 0) goto L_0x0ae0
            r7 = r44
            r3 = r45
            r2 = r34
            goto L_0x0b45
        L_0x0ae0:
            g1.z r2 = new g1.z
            r2.<init>()
            r7 = r44
            r2.b(r7)
            r2.f6754k = r12
            r3 = r35
            r2.f6751h = r3
            r3 = r29
            r2.f6759p = r3
            r3 = r28
            r2.f6760q = r3
            r13 = r27
            r2.f6763t = r13
            r3 = r45
            r2.f6762s = r3
            r5 = r26
            r2.f6764u = r5
            r5 = r37
            r2.f6765v = r5
            r5 = r22
            r2.f6756m = r5
            r15 = r21
            r2.f6757n = r15
            r5 = -1
            if (r1 != r5) goto L_0x0b19
            if (r9 != r5) goto L_0x0b19
            if (r6 != r5) goto L_0x0b19
            if (r14 == 0) goto L_0x0b28
        L_0x0b19:
            g1.o r5 = new g1.o
            if (r14 == 0) goto L_0x0b22
            byte[] r10 = r14.array()
            goto L_0x0b23
        L_0x0b22:
            r10 = r4
        L_0x0b23:
            r5.<init>(r1, r9, r6, r10)
            r2.f6766w = r5
        L_0x0b28:
            if (r19 == 0) goto L_0x0b3c
            r1 = r19
            long r4 = r1.f15213c
            int r4 = g9.b.c(r4)
            r2.f6749f = r4
            long r4 = r1.f15214d
            int r1 = g9.b.c(r4)
            r2.f6750g = r1
        L_0x0b3c:
            g1.a0 r1 = new g1.a0
            r1.<init>(r2)
            r2 = r34
            r2.f520k = r1
        L_0x0b45:
            r1 = r7
        L_0x0b46:
            int r8 = r31 + r33
            r0.G(r8)
            int r6 = r25 + 1
            r7 = r1
            r4 = r2
            r3 = r23
            r1 = r46
            r2 = r47
            goto L_0x0017
        L_0x0b57:
            r2 = r4
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: u2.h.d(j1.b0, int, int, java.lang.String, g1.u, boolean):androidx.activity.result.j");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00ea, code lost:
        if (r13 == 0) goto L_0x00ec;
     */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x02a5  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x02dd  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x02e1  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x03ef  */
    /* JADX WARNING: Removed duplicated region for block: B:185:0x0485  */
    /* JADX WARNING: Removed duplicated region for block: B:244:0x05e7  */
    /* JADX WARNING: Removed duplicated region for block: B:245:0x05f5  */
    /* JADX WARNING: Removed duplicated region for block: B:276:0x06bc  */
    /* JADX WARNING: Removed duplicated region for block: B:284:0x0700  */
    /* JADX WARNING: Removed duplicated region for block: B:286:0x0705  */
    /* JADX WARNING: Removed duplicated region for block: B:287:0x0707  */
    /* JADX WARNING: Removed duplicated region for block: B:291:0x0718  */
    /* JADX WARNING: Removed duplicated region for block: B:308:0x0781  */
    /* JADX WARNING: Removed duplicated region for block: B:311:0x0786  */
    /* JADX WARNING: Removed duplicated region for block: B:312:0x0789  */
    /* JADX WARNING: Removed duplicated region for block: B:314:0x078c  */
    /* JADX WARNING: Removed duplicated region for block: B:315:0x0790  */
    /* JADX WARNING: Removed duplicated region for block: B:317:0x0794  */
    /* JADX WARNING: Removed duplicated region for block: B:319:0x0798  */
    /* JADX WARNING: Removed duplicated region for block: B:320:0x079c  */
    /* JADX WARNING: Removed duplicated region for block: B:324:0x07a9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.ArrayList e(u2.a r46, d2.g0 r47, long r48, g1.u r50, boolean r51, boolean r52, c9.j r53) {
        /*
            r0 = r46
            r1 = r47
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r4 = 0
        L_0x000a:
            java.util.ArrayList r5 = r0.f15198e
            int r6 = r5.size()
            if (r4 >= r6) goto L_0x087c
            java.lang.Object r5 = r5.get(r4)
            u2.a r5 = (u2.a) r5
            int r6 = r5.f15201b
            r7 = 1953653099(0x7472616b, float:7.681346E31)
            if (r6 == r7) goto L_0x0024
            r0 = r2
            r38 = r4
            goto L_0x0863
        L_0x0024:
            r6 = 1836476516(0x6d766864, float:4.7662196E27)
            u2.b r6 = r0.j(r6)
            r6.getClass()
            r7 = 1835297121(0x6d646961, float:4.4181236E27)
            u2.a r8 = r5.i(r7)
            r8.getClass()
            r9 = 1751411826(0x68646c72, float:4.3148E24)
            u2.b r9 = r8.j(r9)
            r9.getClass()
            j1.b0 r9 = r9.f15199c
            r10 = 16
            r9.G(r10)
            int r9 = r9.f()
            r11 = 1936684398(0x736f756e, float:1.8971874E31)
            r13 = -1
            if (r9 != r11) goto L_0x0055
            r9 = 1
            goto L_0x007b
        L_0x0055:
            r11 = 1986618469(0x76696465, float:1.1834389E33)
            if (r9 != r11) goto L_0x005c
            r9 = 2
            goto L_0x007b
        L_0x005c:
            r11 = 1952807028(0x74657874, float:7.272211E31)
            if (r9 == r11) goto L_0x007a
            r11 = 1935832172(0x7362746c, float:1.7941596E31)
            if (r9 == r11) goto L_0x007a
            r11 = 1937072756(0x73756274, float:1.944137E31)
            if (r9 == r11) goto L_0x007a
            r11 = 1668047728(0x636c6370, float:4.3605968E21)
            if (r9 != r11) goto L_0x0071
            goto L_0x007a
        L_0x0071:
            r11 = 1835365473(0x6d657461, float:4.4382975E27)
            if (r9 != r11) goto L_0x0078
            r9 = 5
            goto L_0x007b
        L_0x0078:
            r9 = -1
            goto L_0x007b
        L_0x007a:
            r9 = 3
        L_0x007b:
            r3 = 4
            java.lang.String r7 = ""
            if (r9 != r13) goto L_0x008a
            r39 = r2
            r38 = r4
            r37 = r7
            r25 = 0
            goto L_0x029c
        L_0x008a:
            r12 = 1953196132(0x746b6864, float:7.46037E31)
            u2.b r12 = r5.j(r12)
            r12.getClass()
            j1.b0 r12 = r12.f15199c
            r11 = 8
            r12.G(r11)
            int r17 = r12.f()
            int r11 = r17 >> 24
            r11 = r11 & 255(0xff, float:3.57E-43)
            if (r11 != 0) goto L_0x00a7
            r10 = 8
        L_0x00a7:
            r12.H(r10)
            int r10 = r12.f()
            r12.H(r3)
            int r3 = r12.f8415b
            if (r11 != 0) goto L_0x00b7
            r14 = 4
            goto L_0x00b9
        L_0x00b7:
            r14 = 8
        L_0x00b9:
            r15 = 0
        L_0x00ba:
            if (r15 >= r14) goto L_0x00cd
            byte[] r13 = r12.f8414a
            int r19 = r3 + r15
            byte r13 = r13[r19]
            r0 = -1
            if (r13 == r0) goto L_0x00c7
            r0 = 0
            goto L_0x00ce
        L_0x00c7:
            int r15 = r15 + 1
            r0 = r46
            r13 = -1
            goto L_0x00ba
        L_0x00cd:
            r0 = 1
        L_0x00ce:
            r19 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r0 == 0) goto L_0x00db
            r12.H(r14)
            r25 = 0
            goto L_0x00ec
        L_0x00db:
            if (r11 != 0) goto L_0x00e2
            long r13 = r12.w()
            goto L_0x00e6
        L_0x00e2:
            long r13 = r12.z()
        L_0x00e6:
            r25 = 0
            int r0 = (r13 > r25 ? 1 : (r13 == r25 ? 0 : -1))
            if (r0 != 0) goto L_0x00ee
        L_0x00ec:
            r13 = r19
        L_0x00ee:
            r0 = 16
            r12.H(r0)
            int r3 = r12.f()
            int r11 = r12.f()
            r15 = 4
            r12.H(r15)
            int r15 = r12.f()
            int r12 = r12.f()
            r0 = 65536(0x10000, float:9.18355E-41)
            r21 = r13
            r13 = -65536(0xffffffffffff0000, float:NaN)
            if (r3 != 0) goto L_0x0118
            if (r11 != r0) goto L_0x0118
            if (r15 != r13) goto L_0x0118
            if (r12 != 0) goto L_0x0118
            r0 = 90
            goto L_0x012f
        L_0x0118:
            if (r3 != 0) goto L_0x0123
            if (r11 != r13) goto L_0x0123
            if (r15 != r0) goto L_0x0123
            if (r12 != 0) goto L_0x0123
            r0 = 270(0x10e, float:3.78E-43)
            goto L_0x012f
        L_0x0123:
            if (r3 != r13) goto L_0x012e
            if (r11 != 0) goto L_0x012e
            if (r15 != 0) goto L_0x012e
            if (r12 != r13) goto L_0x012e
            r0 = 180(0xb4, float:2.52E-43)
            goto L_0x012f
        L_0x012e:
            r0 = 0
        L_0x012f:
            int r3 = (r48 > r19 ? 1 : (r48 == r19 ? 0 : -1))
            if (r3 != 0) goto L_0x0136
            r37 = r21
            goto L_0x0138
        L_0x0136:
            r37 = r48
        L_0x0138:
            j1.b0 r3 = r6.f15199c
            r6 = 8
            r3.G(r6)
            int r6 = r3.f()
            int r6 = r6 >> 24
            r6 = r6 & 255(0xff, float:3.57E-43)
            if (r6 != 0) goto L_0x014c
            r6 = 8
            goto L_0x014e
        L_0x014c:
            r6 = 16
        L_0x014e:
            r3.H(r6)
            long r11 = r3.w()
            int r3 = (r37 > r19 ? 1 : (r37 == r19 ? 0 : -1))
            if (r3 != 0) goto L_0x015c
            r13 = r19
            goto L_0x0165
        L_0x015c:
            r39 = 1000000(0xf4240, double:4.940656E-318)
            r41 = r11
            long r13 = j1.l0.M(r37, r39, r41)
        L_0x0165:
            r3 = 1835626086(0x6d696e66, float:4.515217E27)
            u2.a r6 = r8.i(r3)
            r6.getClass()
            r3 = 1937007212(0x7374626c, float:1.9362132E31)
            u2.a r6 = r6.i(r3)
            r6.getClass()
            r15 = 1835296868(0x6d646864, float:4.418049E27)
            u2.b r8 = r8.j(r15)
            r8.getClass()
            j1.b0 r8 = r8.f15199c
            r15 = 8
            r8.G(r15)
            int r15 = r8.f()
            int r15 = r15 >> 24
            r15 = r15 & 255(0xff, float:3.57E-43)
            if (r15 != 0) goto L_0x0197
            r3 = 8
            goto L_0x0199
        L_0x0197:
            r3 = 16
        L_0x0199:
            r8.H(r3)
            long r19 = r8.w()
            if (r15 != 0) goto L_0x01a4
            r15 = 4
            goto L_0x01a6
        L_0x01a4:
            r15 = 8
        L_0x01a6:
            r8.H(r15)
            int r3 = r8.A()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>(r7)
            int r15 = r3 >> 10
            r15 = r15 & 31
            int r15 = r15 + 96
            char r15 = (char) r15
            r8.append(r15)
            int r15 = r3 >> 5
            r15 = r15 & 31
            int r15 = r15 + 96
            char r15 = (char) r15
            r8.append(r15)
            r3 = r3 & 31
            int r3 = r3 + 96
            char r3 = (char) r3
            r8.append(r3)
            java.lang.String r3 = r8.toString()
            java.lang.Long r8 = java.lang.Long.valueOf(r19)
            android.util.Pair r3 = android.util.Pair.create(r8, r3)
            r8 = 1937011556(0x73747364, float:1.9367383E31)
            u2.b r6 = r6.j(r8)
            if (r6 == 0) goto L_0x0874
            j1.b0 r6 = r6.f15199c
            java.lang.Object r8 = r3.second
            r22 = r8
            java.lang.String r22 = (java.lang.String) r22
            r19 = r6
            r20 = r10
            r21 = r0
            r23 = r50
            r24 = r52
            androidx.activity.result.j r0 = d(r19, r20, r21, r22, r23, r24)
            if (r51 != 0) goto L_0x028a
            r6 = 1701082227(0x65647473, float:6.742798E22)
            u2.a r6 = r5.i(r6)
            if (r6 == 0) goto L_0x028a
            r8 = 1701606260(0x656c7374, float:6.9788014E22)
            u2.b r6 = r6.j(r8)
            if (r6 != 0) goto L_0x0217
            r39 = r2
            r38 = r4
            r37 = r7
            r22 = r13
            r2 = 0
            goto L_0x027b
        L_0x0217:
            j1.b0 r6 = r6.f15199c
            r8 = 8
            r6.G(r8)
            int r8 = r6.f()
            int r8 = r8 >> 24
            r8 = r8 & 255(0xff, float:3.57E-43)
            int r15 = r6.y()
            r37 = r7
            long[] r7 = new long[r15]
            r38 = r4
            long[] r4 = new long[r15]
            r39 = r2
            r2 = 0
        L_0x0235:
            if (r2 >= r15) goto L_0x0275
            r17 = r15
            r15 = 1
            if (r8 != r15) goto L_0x0241
            long r18 = r6.z()
            goto L_0x0245
        L_0x0241:
            long r18 = r6.w()
        L_0x0245:
            r7[r2] = r18
            if (r8 != r15) goto L_0x0250
            long r18 = r6.o()
            r22 = r13
            goto L_0x0259
        L_0x0250:
            int r15 = r6.f()
            r22 = r13
            long r13 = (long) r15
            r18 = r13
        L_0x0259:
            r4[r2] = r18
            short r13 = r6.r()
            r14 = 1
            if (r13 != r14) goto L_0x026d
            r13 = 2
            r6.H(r13)
            int r2 = r2 + 1
            r15 = r17
            r13 = r22
            goto L_0x0235
        L_0x026d:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Unsupported media rate."
            r0.<init>(r1)
            throw r0
        L_0x0275:
            r22 = r13
            android.util.Pair r2 = android.util.Pair.create(r7, r4)
        L_0x027b:
            if (r2 == 0) goto L_0x0292
            java.lang.Object r4 = r2.first
            long[] r4 = (long[]) r4
            java.lang.Object r2 = r2.second
            long[] r2 = (long[]) r2
            r29 = r2
            r28 = r4
            goto L_0x0296
        L_0x028a:
            r39 = r2
            r38 = r4
            r37 = r7
            r22 = r13
        L_0x0292:
            r28 = 0
            r29 = 0
        L_0x0296:
            java.lang.Object r2 = r0.f520k
            g1.a0 r2 = (g1.a0) r2
            if (r2 != 0) goto L_0x02a5
        L_0x029c:
            r0 = r53
            r6 = r25
            r2 = 0
            r8 = 1937007212(0x7374626c, float:1.9362132E31)
            goto L_0x02d4
        L_0x02a5:
            u2.u r2 = new u2.u
            java.lang.Object r3 = r3.first
            java.lang.Long r3 = (java.lang.Long) r3
            long r18 = r3.longValue()
            java.lang.Object r3 = r0.f520k
            r24 = r3
            g1.a0 r24 = (g1.a0) r24
            int r3 = r0.f518i
            java.lang.Object r4 = r0.f519j
            u2.v[] r4 = (u2.v[]) r4
            int r0 = r0.f517h
            r6 = r25
            r8 = 1937007212(0x7374626c, float:1.9362132E31)
            r15 = r2
            r16 = r10
            r17 = r9
            r20 = r11
            r25 = r3
            r26 = r4
            r27 = r0
            r15.<init>(r16, r17, r18, r20, r22, r24, r25, r26, r27, r28, r29)
            r0 = r53
        L_0x02d4:
            java.lang.Object r2 = r0.apply(r2)
            r10 = r2
            u2.u r10 = (u2.u) r10
            if (r10 != 0) goto L_0x02e1
            r0 = r39
            goto L_0x0863
        L_0x02e1:
            r2 = 1835297121(0x6d646961, float:4.4181236E27)
            u2.a r2 = r5.i(r2)
            r2.getClass()
            r3 = 1835626086(0x6d696e66, float:4.515217E27)
            u2.a r2 = r2.i(r3)
            r2.getClass()
            u2.a r2 = r2.i(r8)
            r2.getClass()
            r3 = 1937011578(0x7374737a, float:1.936741E31)
            u2.b r3 = r2.j(r3)
            g1.a0 r4 = r10.f15310f
            if (r3 == 0) goto L_0x030d
            w0.c r5 = new w0.c
            r5.<init>(r3, r4)
            goto L_0x031b
        L_0x030d:
            r3 = 1937013298(0x73747a32, float:1.9369489E31)
            u2.b r3 = r2.j(r3)
            if (r3 == 0) goto L_0x086c
            u2.g r5 = new u2.g
            r5.<init>(r3)
        L_0x031b:
            int r3 = r5.b()
            if (r3 != 0) goto L_0x0337
            u2.x r2 = new u2.x
            r3 = 0
            long[] r11 = new long[r3]
            int[] r12 = new int[r3]
            r13 = 0
            long[] r14 = new long[r3]
            int[] r15 = new int[r3]
            r16 = 0
            r9 = r2
            r9.<init>(r10, r11, r12, r13, r14, r15, r16)
        L_0x0333:
            r0 = r39
            goto L_0x0860
        L_0x0337:
            r8 = 1937007471(0x7374636f, float:1.9362445E31)
            u2.b r8 = r2.j(r8)
            if (r8 != 0) goto L_0x034c
            r8 = 1668232756(0x636f3634, float:4.4126776E21)
            u2.b r8 = r2.j(r8)
            r8.getClass()
            r9 = 1
            goto L_0x034d
        L_0x034c:
            r9 = 0
        L_0x034d:
            r11 = 1937011555(0x73747363, float:1.9367382E31)
            u2.b r11 = r2.j(r11)
            r11.getClass()
            r12 = 1937011827(0x73747473, float:1.9367711E31)
            u2.b r12 = r2.j(r12)
            r12.getClass()
            r13 = 1937011571(0x73747373, float:1.9367401E31)
            u2.b r13 = r2.j(r13)
            if (r13 == 0) goto L_0x036d
            j1.b0 r13 = r13.f15199c
            goto L_0x036e
        L_0x036d:
            r13 = 0
        L_0x036e:
            r14 = 1668576371(0x63747473, float:4.5093966E21)
            u2.b r2 = r2.j(r14)
            if (r2 == 0) goto L_0x037a
            j1.b0 r2 = r2.f15199c
            goto L_0x037b
        L_0x037a:
            r2 = 0
        L_0x037b:
            u2.d r14 = new u2.d
            j1.b0 r11 = r11.f15199c
            j1.b0 r8 = r8.f15199c
            r14.<init>(r11, r8, r9)
            j1.b0 r8 = r12.f15199c
            r9 = 12
            r8.G(r9)
            int r11 = r8.y()
            r12 = 1
            int r11 = r11 - r12
            int r12 = r8.y()
            int r15 = r8.y()
            if (r2 == 0) goto L_0x03a3
            r2.G(r9)
            int r16 = r2.y()
            goto L_0x03a5
        L_0x03a3:
            r16 = 0
        L_0x03a5:
            if (r13 == 0) goto L_0x03bd
            r13.G(r9)
            int r9 = r13.y()
            if (r9 <= 0) goto L_0x03ba
            int r17 = r13.y()
            r6 = -1
            int r36 = r17 + -1
            r7 = r36
            goto L_0x03c2
        L_0x03ba:
            r6 = -1
            r7 = 0
            goto L_0x03c0
        L_0x03bd:
            r6 = -1
            r7 = r13
            r9 = 0
        L_0x03c0:
            r13 = r7
            r7 = -1
        L_0x03c2:
            int r0 = r5.a()
            r17 = r7
            java.lang.String r7 = r4.f6276s
            if (r0 == r6) goto L_0x03ec
            java.lang.String r6 = "audio/raw"
            boolean r6 = r6.equals(r7)
            if (r6 != 0) goto L_0x03e4
            java.lang.String r6 = "audio/g711-mlaw"
            boolean r6 = r6.equals(r7)
            if (r6 != 0) goto L_0x03e4
            java.lang.String r6 = "audio/g711-alaw"
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x03ec
        L_0x03e4:
            if (r11 != 0) goto L_0x03ec
            if (r16 != 0) goto L_0x03ec
            if (r9 != 0) goto L_0x03ec
            r6 = 1
            goto L_0x03ed
        L_0x03ec:
            r6 = 0
        L_0x03ed:
            if (r6 == 0) goto L_0x0485
            int r2 = r14.f15202a
            long[] r5 = new long[r2]
            int[] r6 = new int[r2]
        L_0x03f5:
            boolean r7 = r14.a()
            if (r7 == 0) goto L_0x0406
            int r7 = r14.f15203b
            long r8 = r14.f15205d
            r5[r7] = r8
            int r8 = r14.f15204c
            r6[r7] = r8
            goto L_0x03f5
        L_0x0406:
            long r7 = (long) r15
            r9 = 8192(0x2000, float:1.14794E-41)
            int r9 = r9 / r0
            r11 = 0
            r12 = 0
        L_0x040c:
            if (r11 >= r2) goto L_0x041a
            r13 = r6[r11]
            int r14 = j1.l0.f8453a
            int r13 = r13 + r9
            r14 = -1
            int r13 = r13 + r14
            int r13 = r13 / r9
            int r12 = r12 + r13
            int r11 = r11 + 1
            goto L_0x040c
        L_0x041a:
            long[] r11 = new long[r12]
            int[] r13 = new int[r12]
            long[] r14 = new long[r12]
            int[] r12 = new int[r12]
            r1 = 0
            r15 = 0
            r16 = 0
            r17 = 0
        L_0x0428:
            if (r15 >= r2) goto L_0x0476
            r18 = r6[r15]
            r19 = r5[r15]
            r20 = r19
            r19 = r5
            r5 = r18
            r18 = r2
            r2 = r17
        L_0x0438:
            if (r5 <= 0) goto L_0x0466
            int r17 = java.lang.Math.min(r9, r5)
            r11[r16] = r20
            r22 = r6
            int r6 = r0 * r17
            r13[r16] = r6
            int r2 = java.lang.Math.max(r2, r6)
            r23 = r9
            r6 = r10
            long r9 = (long) r1
            long r9 = r9 * r7
            r14[r16] = r9
            r9 = 1
            r12[r16] = r9
            r9 = r13[r16]
            long r9 = (long) r9
            long r20 = r20 + r9
            int r1 = r1 + r17
            int r5 = r5 - r17
            int r16 = r16 + 1
            r10 = r6
            r6 = r22
            r9 = r23
            goto L_0x0438
        L_0x0466:
            r22 = r6
            r23 = r9
            r6 = r10
            int r15 = r15 + 1
            r17 = r2
            r2 = r18
            r5 = r19
            r6 = r22
            goto L_0x0428
        L_0x0476:
            r6 = r10
            long r0 = (long) r1
            long r7 = r7 * r0
            r20 = r4
            r0 = r7
            r15 = r12
            r12 = r13
            r2 = r14
            r13 = r17
            r14 = r6
            goto L_0x05d7
        L_0x0485:
            r6 = r10
            long[] r0 = new long[r3]
            int[] r1 = new int[r3]
            long[] r7 = new long[r3]
            int[] r10 = new int[r3]
            r20 = r4
            r22 = r6
            r24 = r8
            r27 = r11
            r4 = r15
            r21 = r16
            r6 = 0
            r8 = 0
            r18 = 0
            r23 = 0
            r43 = 0
            r44 = 0
            r11 = r9
            r15 = r12
            r9 = r17
            r16 = 0
        L_0x04a9:
            java.lang.String r12 = "AtomParsers"
            if (r6 >= r3) goto L_0x0552
            r28 = 1
        L_0x04af:
            if (r23 != 0) goto L_0x04c8
            boolean r28 = r14.a()
            if (r28 == 0) goto L_0x04c8
            r29 = r3
            r31 = r4
            long r3 = r14.f15205d
            r18 = r3
            int r3 = r14.f15204c
            r23 = r3
            r3 = r29
            r4 = r31
            goto L_0x04af
        L_0x04c8:
            r29 = r3
            r31 = r4
            if (r28 != 0) goto L_0x04e6
            java.lang.String r3 = "Unexpected end of chunk data"
            j1.v.g(r12, r3)
            long[] r0 = java.util.Arrays.copyOf(r0, r6)
            int[] r1 = java.util.Arrays.copyOf(r1, r6)
            long[] r7 = java.util.Arrays.copyOf(r7, r6)
            int[] r10 = java.util.Arrays.copyOf(r10, r6)
            r3 = r6
            goto L_0x0555
        L_0x04e6:
            if (r2 == 0) goto L_0x04f9
        L_0x04e8:
            if (r44 != 0) goto L_0x04f7
            if (r21 <= 0) goto L_0x04f7
            int r44 = r2.y()
            int r43 = r2.f()
            int r21 = r21 + -1
            goto L_0x04e8
        L_0x04f7:
            int r44 = r44 + -1
        L_0x04f9:
            r3 = r43
            r0[r6] = r18
            int r4 = r5.c()
            r1[r6] = r4
            if (r4 <= r8) goto L_0x0506
            r8 = r4
        L_0x0506:
            r28 = r5
            long r4 = (long) r3
            long r4 = r16 + r4
            r7[r6] = r4
            if (r13 != 0) goto L_0x0511
            r4 = 1
            goto L_0x0512
        L_0x0511:
            r4 = 0
        L_0x0512:
            r10[r6] = r4
            if (r6 != r9) goto L_0x0526
            r4 = 1
            r10[r6] = r4
            int r11 = r11 + -1
            if (r11 <= 0) goto L_0x0526
            r13.getClass()
            int r5 = r13.y()
            int r5 = r5 - r4
            r9 = r5
        L_0x0526:
            r5 = r7
            r12 = r8
            r4 = r31
            long r7 = (long) r4
            long r16 = r16 + r7
            int r15 = r15 + -1
            if (r15 != 0) goto L_0x053f
            if (r27 <= 0) goto L_0x053f
            int r4 = r24.y()
            int r7 = r24.f()
            int r27 = r27 + -1
            r15 = r4
            r4 = r7
        L_0x053f:
            r7 = r1[r6]
            long r7 = (long) r7
            long r18 = r18 + r7
            int r23 = r23 + -1
            int r6 = r6 + 1
            r43 = r3
            r7 = r5
            r8 = r12
            r5 = r28
            r3 = r29
            goto L_0x04a9
        L_0x0552:
            r29 = r3
            r5 = r7
        L_0x0555:
            r4 = r23
            r5 = r43
            long r5 = (long) r5
            long r5 = r16 + r5
            if (r2 == 0) goto L_0x056e
        L_0x055e:
            if (r21 <= 0) goto L_0x056e
            int r9 = r2.y()
            if (r9 == 0) goto L_0x0568
            r2 = 0
            goto L_0x056f
        L_0x0568:
            r2.f()
            int r21 = r21 + -1
            goto L_0x055e
        L_0x056e:
            r2 = 1
        L_0x056f:
            if (r11 != 0) goto L_0x0583
            if (r15 != 0) goto L_0x0583
            if (r4 != 0) goto L_0x0583
            if (r27 != 0) goto L_0x0583
            r9 = r44
            if (r9 != 0) goto L_0x0585
            if (r2 != 0) goto L_0x057e
            goto L_0x0585
        L_0x057e:
            r16 = r0
            r14 = r22
            goto L_0x05d0
        L_0x0583:
            r9 = r44
        L_0x0585:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            java.lang.String r14 = "Inconsistent stbl box for track "
            r13.<init>(r14)
            r16 = r0
            r14 = r22
            int r0 = r14.f15305a
            r13.append(r0)
            java.lang.String r0 = ": remainingSynchronizationSamples "
            r13.append(r0)
            r13.append(r11)
            java.lang.String r0 = ", remainingSamplesAtTimestampDelta "
            r13.append(r0)
            r13.append(r15)
            java.lang.String r0 = ", remainingSamplesInChunk "
            r13.append(r0)
            r13.append(r4)
            java.lang.String r0 = ", remainingTimestampDeltaChanges "
            r13.append(r0)
            r11 = r27
            r13.append(r11)
            java.lang.String r0 = ", remainingSamplesAtTimestampOffset "
            r13.append(r0)
            r13.append(r9)
            if (r2 != 0) goto L_0x05c4
            java.lang.String r0 = ", ctts invalid"
            goto L_0x05c6
        L_0x05c4:
            r0 = r37
        L_0x05c6:
            r13.append(r0)
            java.lang.String r0 = r13.toString()
            j1.v.g(r12, r0)
        L_0x05d0:
            r12 = r1
            r0 = r5
            r2 = r7
            r13 = r8
            r15 = r10
            r11 = r16
        L_0x05d7:
            long r8 = r14.f15307c
            r6 = 1000000(0xf4240, double:4.940656E-318)
            r4 = r0
            long r16 = j1.l0.M(r4, r6, r8)
            long r4 = r14.f15307c
            long[] r6 = r14.f15312h
            if (r6 != 0) goto L_0x05f5
            j1.l0.N(r2, r4)
            u2.x r0 = new u2.x
            r9 = r0
            r10 = r14
            r14 = r2
            r9.<init>(r10, r11, r12, r13, r14, r15, r16)
            r2 = r0
            goto L_0x0333
        L_0x05f5:
            int r7 = r6.length
            int r8 = r14.f15306b
            long[] r9 = r14.f15313i
            r10 = 1
            if (r7 != r10) goto L_0x06ad
            if (r8 != r10) goto L_0x06ad
            int r7 = r2.length
            r10 = 2
            if (r7 < r10) goto L_0x06ad
            r9.getClass()
            r7 = 0
            r16 = r9[r7]
            r40 = r6[r7]
            r10 = r8
            long r7 = r14.f15307c
            r18 = r9
            r19 = r10
            long r9 = r14.f15308d
            r42 = r7
            r44 = r9
            long r7 = j1.l0.M(r40, r42, r44)
            long r7 = r7 + r16
            int r9 = r2.length
            r10 = 1
            int r9 = r9 - r10
            r21 = r3
            r3 = 0
            r10 = 4
            int r22 = j1.l0.h(r10, r3, r9)
            r23 = r15
            int r15 = r2.length
            int r15 = r15 - r10
            int r9 = j1.l0.h(r15, r3, r9)
            r27 = r2[r3]
            int r3 = (r27 > r16 ? 1 : (r27 == r16 ? 0 : -1))
            if (r3 > 0) goto L_0x0649
            r31 = r2[r22]
            int r3 = (r16 > r31 ? 1 : (r16 == r31 ? 0 : -1))
            if (r3 >= 0) goto L_0x0649
            r9 = r2[r9]
            int r3 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r3 >= 0) goto L_0x0649
            int r3 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r3 > 0) goto L_0x0649
            r3 = 1
            goto L_0x064a
        L_0x0649:
            r3 = 0
        L_0x064a:
            if (r3 == 0) goto L_0x06aa
            long r31 = r0 - r7
            long r40 = r16 - r27
            r3 = r20
            int r3 = r3.G
            long r7 = (long) r3
            long r9 = r14.f15307c
            r42 = r7
            r44 = r9
            long r7 = j1.l0.M(r40, r42, r44)
            long r9 = (long) r3
            r15 = r0
            long r0 = r14.f15307c
            r33 = r9
            r35 = r0
            long r0 = j1.l0.M(r31, r33, r35)
            r9 = 0
            int r3 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r3 != 0) goto L_0x0675
            int r3 = (r0 > r9 ? 1 : (r0 == r9 ? 0 : -1))
            if (r3 == 0) goto L_0x06a7
        L_0x0675:
            r9 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r3 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r3 > 0) goto L_0x06a7
            int r3 = (r0 > r9 ? 1 : (r0 == r9 ? 0 : -1))
            if (r3 > 0) goto L_0x06a7
            int r3 = (int) r7
            r7 = r47
            r7.f4186a = r3
            int r1 = (int) r0
            r7.f4187b = r1
            j1.l0.N(r2, r4)
            r0 = 0
            r15 = r6[r0]
            r17 = 1000000(0xf4240, double:4.940656E-318)
            long r0 = r14.f15308d
            r19 = r0
            long r16 = j1.l0.M(r15, r17, r19)
            u2.x r0 = new u2.x
            r9 = r0
            r10 = r14
            r14 = r2
            r15 = r23
            r9.<init>(r10, r11, r12, r13, r14, r15, r16)
            r2 = r0
            r0 = 0
            goto L_0x0333
        L_0x06a7:
            r7 = r47
            goto L_0x06b8
        L_0x06aa:
            r7 = r47
            goto L_0x06b7
        L_0x06ad:
            r7 = r47
            r21 = r3
            r19 = r8
            r18 = r9
            r23 = r15
        L_0x06b7:
            r15 = r0
        L_0x06b8:
            int r0 = r6.length
            r1 = 1
            if (r0 != r1) goto L_0x0700
            r0 = 0
            r3 = r6[r0]
            r8 = 0
            int r1 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r1 != 0) goto L_0x06fc
            r18.getClass()
            r3 = r18[r0]
            r1 = 0
        L_0x06cb:
            int r5 = r2.length
            if (r1 >= r5) goto L_0x06e2
            r5 = r2[r1]
            long r17 = r5 - r3
            r19 = 1000000(0xf4240, double:4.940656E-318)
            long r5 = r14.f15307c
            r21 = r5
            long r5 = j1.l0.M(r17, r19, r21)
            r2[r1] = r5
            int r1 = r1 + 1
            goto L_0x06cb
        L_0x06e2:
            long r17 = r15 - r3
            r19 = 1000000(0xf4240, double:4.940656E-318)
            long r3 = r14.f15307c
            r21 = r3
            long r16 = j1.l0.M(r17, r19, r21)
            u2.x r1 = new u2.x
            r9 = r1
            r10 = r14
            r14 = r2
            r15 = r23
            r9.<init>(r10, r11, r12, r13, r14, r15, r16)
            r2 = r1
            goto L_0x0333
        L_0x06fc:
            r3 = r19
            r1 = 1
            goto L_0x0703
        L_0x0700:
            r0 = 0
            r3 = r19
        L_0x0703:
            if (r3 != r1) goto L_0x0707
            r15 = 1
            goto L_0x0708
        L_0x0707:
            r15 = 0
        L_0x0708:
            int r1 = r6.length
            int[] r1 = new int[r1]
            int r3 = r6.length
            int[] r3 = new int[r3]
            r18.getClass()
            r4 = 0
            r5 = 0
            r8 = 0
            r9 = 0
        L_0x0715:
            int r10 = r6.length
            if (r4 >= r10) goto L_0x0774
            r10 = r1
            r0 = r18[r4]
            r16 = -1
            int r19 = (r0 > r16 ? 1 : (r0 == r16 ? 0 : -1))
            if (r19 == 0) goto L_0x0760
            r31 = r6[r4]
            r16 = r12
            r17 = r13
            long r12 = r14.f15307c
            r19 = r6
            long r6 = r14.f15308d
            r33 = r12
            r35 = r6
            long r6 = j1.l0.M(r31, r33, r35)
            r12 = 1
            int r13 = j1.l0.f(r2, r0, r12)
            r10[r4] = r13
            long r0 = r0 + r6
            int r0 = j1.l0.b(r2, r0, r15)
            r3[r4] = r0
        L_0x0743:
            r0 = r10[r4]
            r1 = r3[r4]
            if (r0 >= r1) goto L_0x0753
            r6 = r23[r0]
            r6 = r6 & r12
            if (r6 != 0) goto L_0x0753
            int r0 = r0 + 1
            r10[r4] = r0
            goto L_0x0743
        L_0x0753:
            int r6 = r1 - r0
            int r6 = r6 + r5
            if (r9 == r0) goto L_0x075a
            r0 = 1
            goto L_0x075b
        L_0x075a:
            r0 = 0
        L_0x075b:
            r0 = r0 | r8
            r8 = r0
            r9 = r1
            r5 = r6
            goto L_0x0767
        L_0x0760:
            r19 = r6
            r16 = r12
            r17 = r13
            r12 = 1
        L_0x0767:
            int r4 = r4 + 1
            r7 = r47
            r1 = r10
            r12 = r16
            r13 = r17
            r6 = r19
            r0 = 0
            goto L_0x0715
        L_0x0774:
            r10 = r1
            r19 = r6
            r16 = r12
            r17 = r13
            r0 = r21
            r12 = 1
            if (r5 == r0) goto L_0x0781
            goto L_0x0782
        L_0x0781:
            r12 = 0
        L_0x0782:
            r0 = r8 | r12
            if (r0 == 0) goto L_0x0789
            long[] r1 = new long[r5]
            goto L_0x078a
        L_0x0789:
            r1 = r11
        L_0x078a:
            if (r0 == 0) goto L_0x0790
            int[] r4 = new int[r5]
            r12 = r4
            goto L_0x0792
        L_0x0790:
            r12 = r16
        L_0x0792:
            if (r0 == 0) goto L_0x0796
            r17 = 0
        L_0x0796:
            if (r0 == 0) goto L_0x079c
            int[] r4 = new int[r5]
            r15 = r4
            goto L_0x079e
        L_0x079c:
            r15 = r23
        L_0x079e:
            long[] r4 = new long[r5]
            r9 = r19
            r5 = 0
            r6 = 0
            r7 = 0
        L_0x07a6:
            int r13 = r9.length
            if (r5 >= r13) goto L_0x083f
            r19 = r18[r5]
            r13 = r10[r5]
            r21 = r10
            r10 = r3[r5]
            r22 = r3
            if (r0 == 0) goto L_0x07c9
            int r3 = r10 - r13
            java.lang.System.arraycopy(r11, r13, r1, r6, r3)
            r24 = r11
            r11 = r16
            java.lang.System.arraycopy(r11, r13, r12, r6, r3)
            r16 = r1
            r1 = r23
            java.lang.System.arraycopy(r1, r13, r15, r6, r3)
            goto L_0x07d1
        L_0x07c9:
            r24 = r11
            r11 = r16
            r16 = r1
            r1 = r23
        L_0x07d1:
            r3 = r17
        L_0x07d3:
            if (r13 >= r10) goto L_0x081c
            r32 = 1000000(0xf4240, double:4.940656E-318)
            r23 = r9
            r27 = r10
            long r9 = r14.f15308d
            r30 = r7
            r34 = r9
            long r9 = j1.l0.M(r30, r32, r34)
            r28 = r2[r13]
            r31 = r1
            r30 = r2
            long r1 = r28 - r19
            r28 = r7
            r7 = 0
            long r32 = java.lang.Math.max(r7, r1)
            r34 = 1000000(0xf4240, double:4.940656E-318)
            long r1 = r14.f15307c
            r36 = r1
            long r1 = j1.l0.M(r32, r34, r36)
            long r9 = r9 + r1
            r4[r6] = r9
            if (r0 == 0) goto L_0x080d
            r1 = r12[r6]
            if (r1 <= r3) goto L_0x080d
            r1 = r11[r13]
            r3 = r1
        L_0x080d:
            int r6 = r6 + 1
            int r13 = r13 + 1
            r9 = r23
            r10 = r27
            r7 = r28
            r2 = r30
            r1 = r31
            goto L_0x07d3
        L_0x081c:
            r31 = r1
            r30 = r2
            r28 = r7
            r23 = r9
            r7 = 0
            r1 = r23[r5]
            long r1 = r28 + r1
            int r5 = r5 + 1
            r7 = r1
            r17 = r3
            r1 = r16
            r10 = r21
            r3 = r22
            r2 = r30
            r23 = r31
            r16 = r11
            r11 = r24
            goto L_0x07a6
        L_0x083f:
            r16 = r1
            r28 = r7
            r32 = 1000000(0xf4240, double:4.940656E-318)
            long r0 = r14.f15308d
            r30 = r28
            r34 = r0
            long r0 = j1.l0.M(r30, r32, r34)
            u2.x r2 = new u2.x
            r9 = r2
            r10 = r14
            r11 = r16
            r13 = r17
            r14 = r4
            r16 = r0
            r9.<init>(r10, r11, r12, r13, r14, r15, r16)
            goto L_0x0333
        L_0x0860:
            r0.add(r2)
        L_0x0863:
            int r4 = r38 + 1
            r1 = r47
            r2 = r0
            r0 = r46
            goto L_0x000a
        L_0x086c:
            java.lang.String r0 = "Track has no sample table size information"
            r1 = 0
            g1.b1 r0 = g1.b1.a(r0, r1)
            throw r0
        L_0x0874:
            r1 = 0
            java.lang.String r0 = "Malformed sample table (stbl) missing sample description (stsd)"
            g1.b1 r0 = g1.b1.a(r0, r1)
            throw r0
        L_0x087c:
            r0 = r2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: u2.h.e(u2.a, d2.g0, long, g1.u, boolean, boolean, c9.j):java.util.ArrayList");
    }
}
