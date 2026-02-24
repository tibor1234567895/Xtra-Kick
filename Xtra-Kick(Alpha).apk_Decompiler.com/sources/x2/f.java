package x2;

import d2.r0;
import j1.a;
import j1.a0;
import j1.b0;
import j1.v;
import java.nio.ByteBuffer;
import java.util.List;

public final class f extends i {

    /* renamed from: g  reason: collision with root package name */
    public final b0 f16625g = new b0();

    /* renamed from: h  reason: collision with root package name */
    public final a0 f16626h = new a0();

    /* renamed from: i  reason: collision with root package name */
    public int f16627i = -1;

    /* renamed from: j  reason: collision with root package name */
    public final int f16628j;

    /* renamed from: k  reason: collision with root package name */
    public final e[] f16629k;

    /* renamed from: l  reason: collision with root package name */
    public e f16630l;

    /* renamed from: m  reason: collision with root package name */
    public List f16631m;

    /* renamed from: n  reason: collision with root package name */
    public List f16632n;

    /* renamed from: o  reason: collision with root package name */
    public r0 f16633o;

    /* renamed from: p  reason: collision with root package name */
    public int f16634p;

    public f(List list, int i10) {
        this.f16628j = i10 == -1 ? 1 : i10;
        if (!(list == null || (list.size() == 1 && ((byte[]) list.get(0)).length == 1 && ((byte[]) list.get(0))[0] == 1))) {
        }
        this.f16629k = new e[8];
        for (int i11 = 0; i11 < 8; i11++) {
            this.f16629k[i11] = new e();
        }
        this.f16630l = this.f16629k[0];
    }

    public final j f() {
        List list = this.f16631m;
        this.f16632n = list;
        list.getClass();
        return new j(list, 0);
    }

    public final void flush() {
        super.flush();
        this.f16631m = null;
        this.f16632n = null;
        this.f16634p = 0;
        this.f16630l = this.f16629k[0];
        l();
        this.f16633o = null;
    }

    public final void g(g gVar) {
        boolean z10;
        ByteBuffer byteBuffer = gVar.f9515j;
        byteBuffer.getClass();
        byte[] array = byteBuffer.array();
        int limit = byteBuffer.limit();
        b0 b0Var = this.f16625g;
        b0Var.E(limit, array);
        while (b0Var.f8416c - b0Var.f8415b >= 3) {
            int v10 = b0Var.v() & 7;
            int i10 = v10 & 3;
            boolean z11 = false;
            if ((v10 & 4) == 4) {
                z10 = true;
            } else {
                z10 = false;
            }
            byte v11 = (byte) b0Var.v();
            byte v12 = (byte) b0Var.v();
            if ((i10 == 2 || i10 == 3) && z10) {
                if (i10 == 3) {
                    j();
                    int i11 = (v11 & 192) >> 6;
                    int i12 = this.f16627i;
                    if (!(i12 == -1 || i11 == (i12 + 1) % 4)) {
                        l();
                        v.g("Cea708Decoder", "Sequence number discontinuity. previous=" + this.f16627i + " current=" + i11);
                    }
                    this.f16627i = i11;
                    byte b10 = v11 & 63;
                    if (b10 == 0) {
                        b10 = 64;
                    }
                    r0 r0Var = new r0(i11, b10);
                    this.f16633o = r0Var;
                    int i13 = r0Var.f4292e;
                    r0Var.f4292e = i13 + 1;
                    ((byte[]) r0Var.f4289b)[i13] = v12;
                } else {
                    if (i10 == 2) {
                        z11 = true;
                    }
                    a.b(z11);
                    r0 r0Var2 = this.f16633o;
                    if (r0Var2 == null) {
                        v.c("Cea708Decoder", "Encountered DTVCC_PACKET_DATA before DTVCC_PACKET_START");
                    } else {
                        byte[] bArr = (byte[]) r0Var2.f4289b;
                        int i14 = r0Var2.f4292e;
                        int i15 = i14 + 1;
                        bArr[i14] = v11;
                        r0Var2.f4292e = i15 + 1;
                        bArr[i15] = v12;
                    }
                }
                r0 r0Var3 = this.f16633o;
                if (r0Var3.f4292e == (r0Var3.f4291d * 2) - 1) {
                    j();
                }
            }
        }
    }

    public final boolean i() {
        return this.f16631m != this.f16632n;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x0387, code lost:
        r0.f16630l = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x0261, code lost:
        r3.m(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x02b3, code lost:
        r3.m(16);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void j() {
        /*
            r18 = this;
            r0 = r18
            d2.r0 r1 = r0.f16633o
            if (r1 != 0) goto L_0x0007
            return
        L_0x0007:
            int r2 = r1.f4292e
            int r3 = r1.f4291d
            r4 = 2
            int r3 = r3 * 2
            int r3 = r3 + -1
            if (r2 == r3) goto L_0x0017
            int r1 = r1.f4290c
            j1.v.b()
        L_0x0017:
            d2.r0 r1 = r0.f16633o
            java.lang.Cloneable r2 = r1.f4289b
            byte[] r2 = (byte[]) r2
            int r1 = r1.f4292e
            j1.a0 r3 = r0.f16626h
            r3.j(r1, r2)
            r1 = 0
        L_0x0025:
            int r2 = r3.b()
            if (r2 <= 0) goto L_0x04d2
            r2 = 3
            int r5 = r3.g(r2)
            r6 = 5
            int r6 = r3.g(r6)
            r7 = 7
            r8 = 6
            java.lang.String r9 = "Cea708Decoder"
            if (r5 != r7) goto L_0x0049
            r3.m(r4)
            int r5 = r3.g(r8)
            if (r5 >= r7) goto L_0x0049
            java.lang.String r7 = "Invalid extended service number: "
            android.support.v4.media.h.z(r7, r5, r9)
        L_0x0049:
            if (r6 != 0) goto L_0x0065
            if (r5 == 0) goto L_0x04d2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "serviceNumber is non-zero ("
            r2.<init>(r3)
            r2.append(r5)
            java.lang.String r3 = ") when blockSize is 0"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            j1.v.g(r9, r2)
            goto L_0x04d2
        L_0x0065:
            int r7 = r0.f16628j
            if (r5 == r7) goto L_0x006d
            r3.n(r6)
            goto L_0x0025
        L_0x006d:
            int r5 = r3.e()
            int r6 = r6 * 8
            int r6 = r6 + r5
        L_0x0074:
            int r5 = r3.e()
            if (r5 >= r6) goto L_0x0025
            r5 = 8
            int r7 = r3.g(r5)
            r8 = 24
            r10 = 16
            r11 = 23
            r12 = 159(0x9f, float:2.23E-43)
            r13 = 127(0x7f, float:1.78E-43)
            r14 = 31
            if (r7 == r10) goto L_0x03a5
            r15 = 10
            if (r7 > r14) goto L_0x00f6
            if (r7 == 0) goto L_0x0106
            if (r7 == r2) goto L_0x00ef
            if (r7 == r5) goto L_0x00df
            switch(r7) {
                case 12: goto L_0x00bc;
                case 13: goto L_0x00b6;
                case 14: goto L_0x0106;
                default: goto L_0x009b;
            }
        L_0x009b:
            r2 = 17
            if (r7 < r2) goto L_0x00c0
            if (r7 > r11) goto L_0x00c0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r4 = "Currently unsupported COMMAND_EXT1 Command: "
            r2.<init>(r4)
            r2.append(r7)
            java.lang.String r2 = r2.toString()
            j1.v.g(r9, r2)
            r3.m(r5)
            goto L_0x0106
        L_0x00b6:
            x2.e r2 = r0.f16630l
            r2.a(r15)
            goto L_0x0106
        L_0x00bc:
            r18.l()
            goto L_0x0106
        L_0x00c0:
            if (r7 < r8) goto L_0x00d9
            if (r7 > r14) goto L_0x00d9
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r4 = "Currently unsupported COMMAND_P16 Command: "
            r2.<init>(r4)
            r2.append(r7)
            java.lang.String r2 = r2.toString()
            j1.v.g(r9, r2)
            r3.m(r10)
            goto L_0x0106
        L_0x00d9:
            java.lang.String r2 = "Invalid C0 command: "
            android.support.v4.media.h.z(r2, r7, r9)
            goto L_0x0106
        L_0x00df:
            x2.e r2 = r0.f16630l
            android.text.SpannableStringBuilder r2 = r2.f16604b
            int r4 = r2.length()
            if (r4 <= 0) goto L_0x0106
            int r5 = r4 + -1
            r2.delete(r5, r4)
            goto L_0x0106
        L_0x00ef:
            java.util.List r2 = r18.k()
            r0.f16631m = r2
            goto L_0x0106
        L_0x00f6:
            if (r7 > r13) goto L_0x010b
            x2.e r1 = r0.f16630l
            if (r7 != r13) goto L_0x00ff
            r2 = 9835(0x266b, float:1.3782E-41)
            goto L_0x0102
        L_0x00ff:
            r2 = r7 & 255(0xff, float:3.57E-43)
            char r2 = (char) r2
        L_0x0102:
            r1.a(r2)
            r1 = 1
        L_0x0106:
            r16 = r6
            r2 = r9
            goto L_0x04ca
        L_0x010b:
            if (r7 > r12) goto L_0x038d
            r1 = 4
            x2.e[] r11 = r0.f16629k
            switch(r7) {
                case 128: goto L_0x0379;
                case 129: goto L_0x0379;
                case 130: goto L_0x0379;
                case 131: goto L_0x0379;
                case 132: goto L_0x0379;
                case 133: goto L_0x0379;
                case 134: goto L_0x0379;
                case 135: goto L_0x0379;
                case 136: goto L_0x034f;
                case 137: goto L_0x0338;
                case 138: goto L_0x0321;
                case 139: goto L_0x0307;
                case 140: goto L_0x02f0;
                case 141: goto L_0x02e7;
                case 142: goto L_0x02e1;
                case 143: goto L_0x02d8;
                case 144: goto L_0x02a9;
                case 145: goto L_0x0257;
                case 146: goto L_0x022f;
                case 147: goto L_0x0113;
                case 148: goto L_0x0113;
                case 149: goto L_0x0113;
                case 150: goto L_0x0113;
                case 151: goto L_0x01de;
                case 152: goto L_0x0120;
                case 153: goto L_0x0120;
                case 154: goto L_0x0120;
                case 155: goto L_0x0120;
                case 156: goto L_0x0120;
                case 157: goto L_0x0120;
                case 158: goto L_0x0120;
                case 159: goto L_0x0120;
                default: goto L_0x0113;
            }
        L_0x0113:
            r16 = r6
            r17 = r9
            java.lang.String r1 = "Invalid C1 command: "
            r2 = r17
            android.support.v4.media.h.z(r1, r7, r2)
            goto L_0x04c3
        L_0x0120:
            int r7 = r7 + -152
            r8 = r11[r7]
            r3.m(r4)
            boolean r10 = r3.f()
            boolean r12 = r3.f()
            r3.f()
            int r2 = r3.g(r2)
            boolean r13 = r3.f()
            r14 = 7
            int r14 = r3.g(r14)
            int r5 = r3.g(r5)
            int r15 = r3.g(r1)
            int r1 = r3.g(r1)
            r3.m(r4)
            r16 = r6
            r6 = 6
            r3.g(r6)
            r3.m(r4)
            r4 = 3
            int r6 = r3.g(r4)
            int r4 = r3.g(r4)
            r17 = r9
            r9 = 1
            r8.f16605c = r9
            r8.f16606d = r10
            r8.f16613k = r12
            r8.f16607e = r2
            r8.f16608f = r13
            r8.f16609g = r14
            r8.f16610h = r5
            r8.f16611i = r15
            int r2 = r8.f16612j
            int r1 = r1 + r9
            if (r2 == r1) goto L_0x0193
            r8.f16612j = r1
        L_0x017a:
            java.util.ArrayList r1 = r8.f16603a
            if (r12 == 0) goto L_0x0186
            int r2 = r1.size()
            int r5 = r8.f16612j
            if (r2 >= r5) goto L_0x018e
        L_0x0186:
            int r2 = r1.size()
            r5 = 15
            if (r2 < r5) goto L_0x0193
        L_0x018e:
            r2 = 0
            r1.remove(r2)
            goto L_0x017a
        L_0x0193:
            if (r6 == 0) goto L_0x01b5
            int r1 = r8.f16615m
            if (r1 == r6) goto L_0x01b5
            r8.f16615m = r6
            int r6 = r6 + -1
            int[] r1 = x2.e.C
            r1 = r1[r6]
            boolean[] r2 = x2.e.B
            boolean r2 = r2[r6]
            int[] r2 = x2.e.f16602z
            r2 = r2[r6]
            int[] r2 = x2.e.A
            r2 = r2[r6]
            int[] r2 = x2.e.f16601y
            r2 = r2[r6]
            r8.f16617o = r1
            r8.f16614l = r2
        L_0x01b5:
            if (r4 == 0) goto L_0x01d4
            int r1 = r8.f16616n
            if (r1 == r4) goto L_0x01d4
            r8.f16616n = r4
            int r4 = r4 + -1
            int[] r1 = x2.e.E
            r1 = r1[r4]
            int[] r1 = x2.e.D
            r1 = r1[r4]
            r1 = 0
            r8.e(r1, r1)
            int[] r1 = x2.e.F
            r1 = r1[r4]
            int r2 = x2.e.f16599w
            r8.f(r2, r1)
        L_0x01d4:
            int r1 = r0.f16634p
            if (r1 == r7) goto L_0x0389
            r0.f16634p = r7
            r1 = r11[r7]
            goto L_0x0387
        L_0x01de:
            r16 = r6
            r17 = r9
            x2.e r1 = r0.f16630l
            boolean r1 = r1.f16605c
            if (r1 != 0) goto L_0x01ec
            r8 = 32
            goto L_0x0261
        L_0x01ec:
            r1 = 2
            int r2 = r3.g(r1)
            int r4 = r3.g(r1)
            int r6 = r3.g(r1)
            int r7 = r3.g(r1)
            int r2 = x2.e.c(r4, r6, r7, r2)
            r3.g(r1)
            int r4 = r3.g(r1)
            int r6 = r3.g(r1)
            int r7 = r3.g(r1)
            r8 = 0
            x2.e.c(r4, r6, r7, r8)
            r3.f()
            r3.f()
            r3.g(r1)
            r3.g(r1)
            int r1 = r3.g(r1)
            r3.m(r5)
            x2.e r4 = r0.f16630l
            r4.f16617o = r2
            r4.f16614l = r1
            goto L_0x0389
        L_0x022f:
            r16 = r6
            r17 = r9
            x2.e r2 = r0.f16630l
            boolean r2 = r2.f16605c
            if (r2 != 0) goto L_0x023b
            goto L_0x02b3
        L_0x023b:
            r3.m(r1)
            int r1 = r3.g(r1)
            r2 = 2
            r3.m(r2)
            r2 = 6
            r3.g(r2)
            x2.e r2 = r0.f16630l
            int r4 = r2.f16624v
            if (r4 == r1) goto L_0x0253
            r2.a(r15)
        L_0x0253:
            r2.f16624v = r1
            goto L_0x0389
        L_0x0257:
            r16 = r6
            r17 = r9
            x2.e r1 = r0.f16630l
            boolean r1 = r1.f16605c
            if (r1 != 0) goto L_0x0266
        L_0x0261:
            r3.m(r8)
            goto L_0x0389
        L_0x0266:
            r1 = 2
            int r2 = r3.g(r1)
            int r4 = r3.g(r1)
            int r5 = r3.g(r1)
            int r6 = r3.g(r1)
            int r2 = x2.e.c(r4, r5, r6, r2)
            int r4 = r3.g(r1)
            int r5 = r3.g(r1)
            int r6 = r3.g(r1)
            int r7 = r3.g(r1)
            int r4 = x2.e.c(r5, r6, r7, r4)
            r3.m(r1)
            int r5 = r3.g(r1)
            int r6 = r3.g(r1)
            int r1 = r3.g(r1)
            r7 = 0
            x2.e.c(r5, r6, r1, r7)
            x2.e r1 = r0.f16630l
            r1.f(r2, r4)
            goto L_0x0389
        L_0x02a9:
            r16 = r6
            r17 = r9
            x2.e r2 = r0.f16630l
            boolean r2 = r2.f16605c
            if (r2 != 0) goto L_0x02b8
        L_0x02b3:
            r3.m(r10)
            goto L_0x0389
        L_0x02b8:
            r3.g(r1)
            r1 = 2
            r3.g(r1)
            r3.g(r1)
            boolean r1 = r3.f()
            boolean r2 = r3.f()
            r4 = 3
            r3.g(r4)
            r3.g(r4)
            x2.e r4 = r0.f16630l
            r4.e(r1, r2)
            goto L_0x0389
        L_0x02d8:
            r16 = r6
            r17 = r9
            r18.l()
            goto L_0x0389
        L_0x02e1:
            r16 = r6
            r17 = r9
            goto L_0x0389
        L_0x02e7:
            r16 = r6
            r17 = r9
            r3.m(r5)
            goto L_0x0389
        L_0x02f0:
            r16 = r6
            r17 = r9
            r1 = 1
        L_0x02f5:
            if (r1 > r5) goto L_0x0389
            boolean r2 = r3.f()
            if (r2 == 0) goto L_0x0304
            int r2 = 8 - r1
            r2 = r11[r2]
            r2.d()
        L_0x0304:
            int r1 = r1 + 1
            goto L_0x02f5
        L_0x0307:
            r16 = r6
            r17 = r9
            r1 = 1
        L_0x030c:
            if (r1 > r5) goto L_0x0389
            boolean r2 = r3.f()
            if (r2 == 0) goto L_0x031e
            int r2 = 8 - r1
            r2 = r11[r2]
            boolean r4 = r2.f16606d
            r4 = r4 ^ 1
            r2.f16606d = r4
        L_0x031e:
            int r1 = r1 + 1
            goto L_0x030c
        L_0x0321:
            r16 = r6
            r17 = r9
            r1 = 1
        L_0x0326:
            if (r1 > r5) goto L_0x0389
            boolean r2 = r3.f()
            if (r2 == 0) goto L_0x0335
            int r2 = 8 - r1
            r2 = r11[r2]
            r4 = 0
            r2.f16606d = r4
        L_0x0335:
            int r1 = r1 + 1
            goto L_0x0326
        L_0x0338:
            r16 = r6
            r17 = r9
            r1 = 1
        L_0x033d:
            if (r1 > r5) goto L_0x0389
            boolean r2 = r3.f()
            if (r2 == 0) goto L_0x034c
            int r2 = 8 - r1
            r2 = r11[r2]
            r4 = 1
            r2.f16606d = r4
        L_0x034c:
            int r1 = r1 + 1
            goto L_0x033d
        L_0x034f:
            r16 = r6
            r17 = r9
            r1 = 1
        L_0x0354:
            if (r1 > r5) goto L_0x0389
            boolean r2 = r3.f()
            if (r2 == 0) goto L_0x0376
            int r2 = 8 - r1
            r2 = r11[r2]
            java.util.ArrayList r4 = r2.f16603a
            r4.clear()
            android.text.SpannableStringBuilder r4 = r2.f16604b
            r4.clear()
            r4 = -1
            r2.f16618p = r4
            r2.f16619q = r4
            r2.f16620r = r4
            r2.f16622t = r4
            r4 = 0
            r2.f16624v = r4
        L_0x0376:
            int r1 = r1 + 1
            goto L_0x0354
        L_0x0379:
            r16 = r6
            r17 = r9
            int r7 = r7 + -128
            int r1 = r0.f16634p
            if (r1 == r7) goto L_0x0389
            r0.f16634p = r7
            r1 = r11[r7]
        L_0x0387:
            r0.f16630l = r1
        L_0x0389:
            r2 = r17
            goto L_0x04c3
        L_0x038d:
            r16 = r6
            r2 = r9
            r4 = 255(0xff, float:3.57E-43)
            if (r7 > r4) goto L_0x039e
            x2.e r1 = r0.f16630l
            r4 = r7 & 255(0xff, float:3.57E-43)
            char r4 = (char) r4
            r1.a(r4)
            goto L_0x04c3
        L_0x039e:
            java.lang.String r4 = "Invalid base command: "
            android.support.v4.media.h.z(r4, r7, r2)
            goto L_0x04ca
        L_0x03a5:
            r16 = r6
            r2 = r9
            int r4 = r3.g(r5)
            if (r4 > r14) goto L_0x03c6
            r6 = 7
            if (r4 > r6) goto L_0x03b3
            goto L_0x04ca
        L_0x03b3:
            r6 = 15
            if (r4 > r6) goto L_0x03b8
            goto L_0x03c1
        L_0x03b8:
            if (r4 > r11) goto L_0x03bd
            r5 = 16
            goto L_0x03c1
        L_0x03bd:
            if (r4 > r14) goto L_0x04ca
            r5 = 24
        L_0x03c1:
            r3.m(r5)
            goto L_0x04ca
        L_0x03c6:
            r5 = 160(0xa0, float:2.24E-43)
            if (r4 > r13) goto L_0x048b
            r1 = 32
            if (r4 == r1) goto L_0x0483
            r1 = 33
            if (r4 == r1) goto L_0x047e
            r1 = 37
            if (r4 == r1) goto L_0x0479
            r1 = 42
            if (r4 == r1) goto L_0x0474
            r1 = 44
            if (r4 == r1) goto L_0x046f
            r1 = 63
            if (r4 == r1) goto L_0x046a
            r1 = 57
            if (r4 == r1) goto L_0x0465
            r1 = 58
            if (r4 == r1) goto L_0x0460
            r1 = 60
            if (r4 == r1) goto L_0x045b
            r1 = 61
            if (r4 == r1) goto L_0x0456
            switch(r4) {
                case 48: goto L_0x041d;
                case 49: goto L_0x0417;
                case 50: goto L_0x0411;
                case 51: goto L_0x040b;
                case 52: goto L_0x0405;
                case 53: goto L_0x03ff;
                default: goto L_0x03f5;
            }
        L_0x03f5:
            switch(r4) {
                case 118: goto L_0x0451;
                case 119: goto L_0x044c;
                case 120: goto L_0x0447;
                case 121: goto L_0x0442;
                case 122: goto L_0x043d;
                case 123: goto L_0x0438;
                case 124: goto L_0x0433;
                case 125: goto L_0x042e;
                case 126: goto L_0x0429;
                case 127: goto L_0x0423;
                default: goto L_0x03f8;
            }
        L_0x03f8:
            java.lang.String r1 = "Invalid G2 character: "
            android.support.v4.media.h.z(r1, r4, r2)
            goto L_0x04c3
        L_0x03ff:
            x2.e r1 = r0.f16630l
            r4 = 8226(0x2022, float:1.1527E-41)
            goto L_0x0487
        L_0x0405:
            x2.e r1 = r0.f16630l
            r4 = 8221(0x201d, float:1.152E-41)
            goto L_0x0487
        L_0x040b:
            x2.e r1 = r0.f16630l
            r4 = 8220(0x201c, float:1.1519E-41)
            goto L_0x0487
        L_0x0411:
            x2.e r1 = r0.f16630l
            r4 = 8217(0x2019, float:1.1514E-41)
            goto L_0x0487
        L_0x0417:
            x2.e r1 = r0.f16630l
            r4 = 8216(0x2018, float:1.1513E-41)
            goto L_0x0487
        L_0x041d:
            x2.e r1 = r0.f16630l
            r4 = 9608(0x2588, float:1.3464E-41)
            goto L_0x0487
        L_0x0423:
            x2.e r1 = r0.f16630l
            r4 = 9484(0x250c, float:1.329E-41)
            goto L_0x0487
        L_0x0429:
            x2.e r1 = r0.f16630l
            r4 = 9496(0x2518, float:1.3307E-41)
            goto L_0x0487
        L_0x042e:
            x2.e r1 = r0.f16630l
            r4 = 9472(0x2500, float:1.3273E-41)
            goto L_0x0487
        L_0x0433:
            x2.e r1 = r0.f16630l
            r4 = 9492(0x2514, float:1.3301E-41)
            goto L_0x0487
        L_0x0438:
            x2.e r1 = r0.f16630l
            r4 = 9488(0x2510, float:1.3296E-41)
            goto L_0x0487
        L_0x043d:
            x2.e r1 = r0.f16630l
            r4 = 9474(0x2502, float:1.3276E-41)
            goto L_0x0487
        L_0x0442:
            x2.e r1 = r0.f16630l
            r4 = 8542(0x215e, float:1.197E-41)
            goto L_0x0487
        L_0x0447:
            x2.e r1 = r0.f16630l
            r4 = 8541(0x215d, float:1.1968E-41)
            goto L_0x0487
        L_0x044c:
            x2.e r1 = r0.f16630l
            r4 = 8540(0x215c, float:1.1967E-41)
            goto L_0x0487
        L_0x0451:
            x2.e r1 = r0.f16630l
            r4 = 8539(0x215b, float:1.1966E-41)
            goto L_0x0487
        L_0x0456:
            x2.e r1 = r0.f16630l
            r4 = 8480(0x2120, float:1.1883E-41)
            goto L_0x0487
        L_0x045b:
            x2.e r1 = r0.f16630l
            r4 = 339(0x153, float:4.75E-43)
            goto L_0x0487
        L_0x0460:
            x2.e r1 = r0.f16630l
            r4 = 353(0x161, float:4.95E-43)
            goto L_0x0487
        L_0x0465:
            x2.e r1 = r0.f16630l
            r4 = 8482(0x2122, float:1.1886E-41)
            goto L_0x0487
        L_0x046a:
            x2.e r1 = r0.f16630l
            r4 = 376(0x178, float:5.27E-43)
            goto L_0x0487
        L_0x046f:
            x2.e r1 = r0.f16630l
            r4 = 338(0x152, float:4.74E-43)
            goto L_0x0487
        L_0x0474:
            x2.e r1 = r0.f16630l
            r4 = 352(0x160, float:4.93E-43)
            goto L_0x0487
        L_0x0479:
            x2.e r1 = r0.f16630l
            r4 = 8230(0x2026, float:1.1533E-41)
            goto L_0x0487
        L_0x047e:
            x2.e r1 = r0.f16630l
            r4 = 160(0xa0, float:2.24E-43)
            goto L_0x0487
        L_0x0483:
            x2.e r1 = r0.f16630l
            r4 = 32
        L_0x0487:
            r1.a(r4)
            goto L_0x04c3
        L_0x048b:
            if (r4 > r12) goto L_0x04ac
            r5 = 135(0x87, float:1.89E-43)
            if (r4 > r5) goto L_0x0494
            r4 = 32
            goto L_0x04a8
        L_0x0494:
            r5 = 143(0x8f, float:2.0E-43)
            if (r4 > r5) goto L_0x049b
            r4 = 40
            goto L_0x04a8
        L_0x049b:
            if (r4 > r12) goto L_0x04ca
            r4 = 2
            r3.m(r4)
            r4 = 6
            int r4 = r3.g(r4)
            int r4 = r4 * 8
        L_0x04a8:
            r3.m(r4)
            goto L_0x04ca
        L_0x04ac:
            r6 = 255(0xff, float:3.57E-43)
            if (r4 > r6) goto L_0x04c5
            if (r4 != r5) goto L_0x04b7
            x2.e r1 = r0.f16630l
            r4 = 13252(0x33c4, float:1.857E-41)
            goto L_0x04c0
        L_0x04b7:
            java.lang.String r1 = "Invalid G3 character: "
            android.support.v4.media.h.z(r1, r4, r2)
            x2.e r1 = r0.f16630l
            r4 = 95
        L_0x04c0:
            r1.a(r4)
        L_0x04c3:
            r1 = 1
            goto L_0x04ca
        L_0x04c5:
            java.lang.String r5 = "Invalid extended command: "
            android.support.v4.media.h.z(r5, r4, r2)
        L_0x04ca:
            r4 = 2
            r5 = 3
            r9 = r2
            r6 = r16
            r2 = 3
            goto L_0x0074
        L_0x04d2:
            if (r1 == 0) goto L_0x04da
            java.util.List r1 = r18.k()
            r0.f16631m = r1
        L_0x04da:
            r1 = 0
            r0.f16633o = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: x2.f.j():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00cf  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00e9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List k() {
        /*
            r17 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            r2 = 0
        L_0x0007:
            r3 = 8
            if (r2 >= r3) goto L_0x0107
            r3 = r17
            x2.e[] r4 = r3.f16629k
            r5 = r4[r2]
            boolean r6 = r5.f16605c
            r7 = 1
            if (r6 == 0) goto L_0x0029
            java.util.ArrayList r6 = r5.f16603a
            boolean r6 = r6.isEmpty()
            if (r6 == 0) goto L_0x0027
            android.text.SpannableStringBuilder r5 = r5.f16604b
            int r5 = r5.length()
            if (r5 != 0) goto L_0x0027
            goto L_0x0029
        L_0x0027:
            r5 = 0
            goto L_0x002a
        L_0x0029:
            r5 = 1
        L_0x002a:
            if (r5 != 0) goto L_0x0103
            r4 = r4[r2]
            boolean r5 = r4.f16606d
            if (r5 == 0) goto L_0x0103
            boolean r5 = r4.f16605c
            java.util.ArrayList r6 = r4.f16603a
            if (r5 == 0) goto L_0x0049
            boolean r5 = r6.isEmpty()
            if (r5 == 0) goto L_0x0047
            android.text.SpannableStringBuilder r5 = r4.f16604b
            int r5 = r5.length()
            if (r5 != 0) goto L_0x0047
            goto L_0x0049
        L_0x0047:
            r5 = 0
            goto L_0x004a
        L_0x0049:
            r5 = 1
        L_0x004a:
            if (r5 == 0) goto L_0x004f
            r4 = 0
            goto L_0x00fe
        L_0x004f:
            android.text.SpannableStringBuilder r8 = new android.text.SpannableStringBuilder
            r8.<init>()
            r5 = 0
        L_0x0055:
            int r9 = r6.size()
            if (r5 >= r9) goto L_0x006c
            java.lang.Object r9 = r6.get(r5)
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            r8.append(r9)
            r9 = 10
            r8.append(r9)
            int r5 = r5 + 1
            goto L_0x0055
        L_0x006c:
            android.text.SpannableString r5 = r4.b()
            r8.append(r5)
            int r5 = r4.f16614l
            r6 = 2
            if (r5 == 0) goto L_0x009c
            if (r5 == r7) goto L_0x0099
            if (r5 == r6) goto L_0x0096
            r9 = 3
            if (r5 != r9) goto L_0x0080
            goto L_0x009c
        L_0x0080:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Unexpected justification value: "
            r1.<init>(r2)
            int r2 = r4.f16614l
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0096:
            android.text.Layout$Alignment r5 = android.text.Layout.Alignment.ALIGN_CENTER
            goto L_0x009e
        L_0x0099:
            android.text.Layout$Alignment r5 = android.text.Layout.Alignment.ALIGN_OPPOSITE
            goto L_0x009e
        L_0x009c:
            android.text.Layout$Alignment r5 = android.text.Layout.Alignment.ALIGN_NORMAL
        L_0x009e:
            r9 = r5
            boolean r5 = r4.f16608f
            if (r5 == 0) goto L_0x00ae
            int r5 = r4.f16610h
            float r5 = (float) r5
            r10 = 1120272384(0x42c60000, float:99.0)
            float r5 = r5 / r10
            int r11 = r4.f16609g
            float r11 = (float) r11
            float r11 = r11 / r10
            goto L_0x00bb
        L_0x00ae:
            int r5 = r4.f16610h
            float r5 = (float) r5
            r10 = 1129381888(0x43510000, float:209.0)
            float r5 = r5 / r10
            int r10 = r4.f16609g
            float r10 = (float) r10
            r11 = 1116995584(0x42940000, float:74.0)
            float r11 = r10 / r11
        L_0x00bb:
            r10 = 1063675494(0x3f666666, float:0.9)
            float r5 = r5 * r10
            r12 = 1028443341(0x3d4ccccd, float:0.05)
            float r13 = r5 + r12
            float r11 = r11 * r10
            float r10 = r11 + r12
            int r5 = r4.f16611i
            int r11 = r5 / 3
            if (r11 != 0) goto L_0x00d1
            r11 = 0
            goto L_0x00d6
        L_0x00d1:
            if (r11 != r7) goto L_0x00d5
            r11 = 1
            goto L_0x00d6
        L_0x00d5:
            r11 = 2
        L_0x00d6:
            int r5 = r5 % 3
            if (r5 != 0) goto L_0x00dc
            r12 = 0
            goto L_0x00e1
        L_0x00dc:
            if (r5 != r7) goto L_0x00e0
            r12 = 1
            goto L_0x00e1
        L_0x00e0:
            r12 = 2
        L_0x00e1:
            int r14 = r4.f16617o
            int r5 = x2.e.f16600x
            if (r14 == r5) goto L_0x00e9
            r15 = 1
            goto L_0x00ea
        L_0x00e9:
            r15 = 0
        L_0x00ea:
            x2.d r16 = new x2.d
            int r4 = r4.f16607e
            r5 = r16
            r6 = r8
            r7 = r9
            r8 = r10
            r9 = r11
            r10 = r13
            r11 = r12
            r12 = r15
            r13 = r14
            r14 = r4
            r5.<init>(r6, r7, r8, r9, r10, r11, r12, r13, r14)
            r4 = r16
        L_0x00fe:
            if (r4 == 0) goto L_0x0103
            r0.add(r4)
        L_0x0103:
            int r2 = r2 + 1
            goto L_0x0007
        L_0x0107:
            r3 = r17
            j0.a r2 = x2.d.f16596c
            java.util.Collections.sort(r0, r2)
            java.util.ArrayList r2 = new java.util.ArrayList
            int r4 = r0.size()
            r2.<init>(r4)
        L_0x0117:
            int r4 = r0.size()
            if (r1 >= r4) goto L_0x012b
            java.lang.Object r4 = r0.get(r1)
            x2.d r4 = (x2.d) r4
            i1.b r4 = r4.f16597a
            r2.add(r4)
            int r1 = r1 + 1
            goto L_0x0117
        L_0x012b:
            java.util.List r0 = java.util.Collections.unmodifiableList(r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: x2.f.k():java.util.List");
    }

    public final void l() {
        for (int i10 = 0; i10 < 8; i10++) {
            this.f16629k[i10].d();
        }
    }
}
