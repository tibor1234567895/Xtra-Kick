package o2;

import c9.h;
import d9.o0;
import d9.p0;
import d9.r0;
import d9.r1;
import g1.z0;
import i1.c;
import j1.a0;
import j1.b0;
import j1.l0;
import j2.a;
import j2.b;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public final class o extends b {

    /* renamed from: b  reason: collision with root package name */
    public static final c f12088b = new c(23);

    /* renamed from: a  reason: collision with root package name */
    public final m f12089a;

    public o() {
        this((c) null);
    }

    public static b d(int i10, int i11, b0 b0Var) {
        String str;
        int i12;
        byte[] bArr;
        int v10 = b0Var.v();
        Charset n10 = n(v10);
        int i13 = i10 - 1;
        byte[] bArr2 = new byte[i13];
        b0Var.d(bArr2, 0, i13);
        if (i11 == 2) {
            String str2 = "image/" + c9.b.a(new String(bArr2, 0, 3, h.f3034b));
            if ("image/jpg".equals(str2)) {
                str2 = "image/jpeg";
            }
            str = str2;
            i12 = 2;
        } else {
            i12 = q(0, bArr2);
            String a10 = c9.b.a(new String(bArr2, 0, i12, h.f3034b));
            if (a10.indexOf(47) == -1) {
                str = "image/".concat(a10);
            } else {
                str = a10;
            }
        }
        byte b10 = bArr2[i12 + 1] & 255;
        int i14 = i12 + 2;
        int p10 = p(bArr2, i14, v10);
        String str3 = new String(bArr2, i14, p10 - i14, n10);
        int m10 = m(v10) + p10;
        if (i13 <= m10) {
            bArr = l0.f8458f;
        } else {
            bArr = Arrays.copyOfRange(bArr2, m10, i13);
        }
        return new b(str, str3, b10, bArr);
    }

    public static f e(b0 b0Var, int i10, int i11, boolean z10, int i12, m mVar) {
        long j10;
        long j11;
        b0 b0Var2 = b0Var;
        int i13 = b0Var2.f8415b;
        int q10 = q(i13, b0Var2.f8414a);
        String str = new String(b0Var2.f8414a, i13, q10 - i13, h.f3034b);
        b0Var.G(q10 + 1);
        int f10 = b0Var.f();
        int f11 = b0Var.f();
        long w10 = b0Var.w();
        if (w10 == 4294967295L) {
            j10 = -1;
        } else {
            j10 = w10;
        }
        long w11 = b0Var.w();
        if (w11 == 4294967295L) {
            j11 = -1;
        } else {
            j11 = w11;
        }
        ArrayList arrayList = new ArrayList();
        int i14 = i13 + i10;
        while (b0Var2.f8415b < i14) {
            p h10 = h(i11, b0Var, z10, i12, mVar);
            if (h10 != null) {
                arrayList.add(h10);
            }
        }
        return new f(str, f10, f11, j10, j11, (p[]) arrayList.toArray(new p[0]));
    }

    public static h f(b0 b0Var, int i10, int i11, boolean z10, int i12, m mVar) {
        boolean z11;
        boolean z12;
        b0 b0Var2 = b0Var;
        int i13 = b0Var2.f8415b;
        int q10 = q(i13, b0Var2.f8414a);
        String str = new String(b0Var2.f8414a, i13, q10 - i13, h.f3034b);
        b0Var2.G(q10 + 1);
        int v10 = b0Var.v();
        if ((v10 & 2) != 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if ((v10 & 1) != 0) {
            z12 = true;
        } else {
            z12 = false;
        }
        int v11 = b0Var.v();
        String[] strArr = new String[v11];
        for (int i14 = 0; i14 < v11; i14++) {
            int i15 = b0Var2.f8415b;
            int q11 = q(i15, b0Var2.f8414a);
            strArr[i14] = new String(b0Var2.f8414a, i15, q11 - i15, h.f3034b);
            b0Var2.G(q11 + 1);
        }
        ArrayList arrayList = new ArrayList();
        int i16 = i13 + i10;
        while (b0Var2.f8415b < i16) {
            p h10 = h(i11, b0Var2, z10, i12, mVar);
            if (h10 != null) {
                arrayList.add(h10);
            }
        }
        return new h(str, z11, z12, strArr, (p[]) arrayList.toArray(new p[0]));
    }

    public static j g(int i10, b0 b0Var) {
        if (i10 < 4) {
            return null;
        }
        int v10 = b0Var.v();
        Charset n10 = n(v10);
        byte[] bArr = new byte[3];
        b0Var.d(bArr, 0, 3);
        String str = new String(bArr, 0, 3);
        int i11 = i10 - 4;
        byte[] bArr2 = new byte[i11];
        b0Var.d(bArr2, 0, i11);
        int p10 = p(bArr2, 0, v10);
        String str2 = new String(bArr2, 0, p10, n10);
        int m10 = m(v10) + p10;
        return new j(str, str2, k(bArr2, m10, p(bArr2, m10, v10), n10));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:153:0x023f, code lost:
        if (r12 == 67) goto L_0x0241;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x009f, code lost:
        if (r14 == false) goto L_0x02d8;
     */
    /* JADX WARNING: Removed duplicated region for block: B:184:0x02b0 A[Catch:{ all -> 0x015a }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static o2.p h(int r21, j1.b0 r22, boolean r23, int r24, o2.m r25) {
        /*
            r0 = r21
            r7 = r22
            java.lang.String r8 = "Failed to decode frame: id="
            int r9 = r22.v()
            int r10 = r22.v()
            int r11 = r22.v()
            r2 = 3
            if (r0 < r2) goto L_0x001b
            int r3 = r22.v()
            r12 = r3
            goto L_0x001c
        L_0x001b:
            r12 = 0
        L_0x001c:
            r3 = 4
            if (r0 != r3) goto L_0x003d
            int r4 = r22.y()
            if (r23 != 0) goto L_0x0048
            r5 = r4 & 255(0xff, float:3.57E-43)
            int r6 = r4 >> 8
            r6 = r6 & 255(0xff, float:3.57E-43)
            int r6 = r6 << 7
            r5 = r5 | r6
            int r6 = r4 >> 16
            r6 = r6 & 255(0xff, float:3.57E-43)
            int r6 = r6 << 14
            r5 = r5 | r6
            int r4 = r4 >> 24
            r4 = r4 & 255(0xff, float:3.57E-43)
            int r4 = r4 << 21
            r4 = r4 | r5
            goto L_0x0048
        L_0x003d:
            if (r0 != r2) goto L_0x0044
            int r4 = r22.y()
            goto L_0x0048
        L_0x0044:
            int r4 = r22.x()
        L_0x0048:
            if (r0 < r2) goto L_0x004f
            int r5 = r22.A()
            goto L_0x0050
        L_0x004f:
            r5 = 0
        L_0x0050:
            r6 = 0
            if (r9 != 0) goto L_0x0063
            if (r10 != 0) goto L_0x0063
            if (r11 != 0) goto L_0x0063
            if (r12 != 0) goto L_0x0063
            if (r4 != 0) goto L_0x0063
            if (r5 != 0) goto L_0x0063
        L_0x005d:
            int r0 = r7.f8416c
            r7.G(r0)
            return r6
        L_0x0063:
            int r13 = r7.f8415b
            int r13 = r13 + r4
            int r14 = r7.f8416c
            java.lang.String r15 = "Id3Decoder"
            if (r13 <= r14) goto L_0x0072
            java.lang.String r0 = "Frame size exceeds remaining tag data"
            j1.v.g(r15, r0)
            goto L_0x005d
        L_0x0072:
            r6 = 2
            r1 = 77
            r2 = 79
            r3 = 67
            if (r25 == 0) goto L_0x00a3
            r14 = r25
            i1.c r14 = (i1.c) r14
            int r14 = r14.f7989h
            switch(r14) {
                case 23: goto L_0x009e;
                default: goto L_0x0084;
            }
        L_0x0084:
            if (r9 != r3) goto L_0x008e
            if (r10 != r2) goto L_0x008e
            if (r11 != r1) goto L_0x008e
            if (r12 == r1) goto L_0x009c
            if (r0 == r6) goto L_0x009c
        L_0x008e:
            if (r9 != r1) goto L_0x009e
            r14 = 76
            if (r10 != r14) goto L_0x009e
            if (r11 != r14) goto L_0x009e
            r14 = 84
            if (r12 == r14) goto L_0x009c
            if (r0 != r6) goto L_0x009e
        L_0x009c:
            r14 = 1
            goto L_0x009f
        L_0x009e:
            r14 = 0
        L_0x009f:
            if (r14 != 0) goto L_0x00a3
            goto L_0x02d8
        L_0x00a3:
            r14 = 3
            if (r0 != r14) goto L_0x00c0
            r14 = r5 & 128(0x80, float:1.794E-43)
            if (r14 == 0) goto L_0x00ac
            r14 = 1
            goto L_0x00ad
        L_0x00ac:
            r14 = 0
        L_0x00ad:
            r16 = r5 & 64
            if (r16 == 0) goto L_0x00b4
            r16 = 1
            goto L_0x00b6
        L_0x00b4:
            r16 = 0
        L_0x00b6:
            r5 = r5 & 32
            if (r5 == 0) goto L_0x00bc
            r5 = 1
            goto L_0x00bd
        L_0x00bc:
            r5 = 0
        L_0x00bd:
            r18 = r14
            goto L_0x00f5
        L_0x00c0:
            r14 = 4
            if (r0 != r14) goto L_0x00ef
            r14 = r5 & 64
            if (r14 == 0) goto L_0x00c9
            r14 = 1
            goto L_0x00ca
        L_0x00c9:
            r14 = 0
        L_0x00ca:
            r16 = r5 & 8
            if (r16 == 0) goto L_0x00d1
            r16 = 1
            goto L_0x00d3
        L_0x00d1:
            r16 = 0
        L_0x00d3:
            r18 = r5 & 4
            if (r18 == 0) goto L_0x00da
            r18 = 1
            goto L_0x00dc
        L_0x00da:
            r18 = 0
        L_0x00dc:
            r19 = r5 & 2
            r17 = 1
            if (r19 == 0) goto L_0x00e5
            r19 = 1
            goto L_0x00e7
        L_0x00e5:
            r19 = 0
        L_0x00e7:
            r5 = r5 & 1
            if (r5 == 0) goto L_0x00ed
            r5 = 1
            goto L_0x0100
        L_0x00ed:
            r5 = 0
            goto L_0x0100
        L_0x00ef:
            r5 = 0
            r14 = 0
            r16 = 0
            r18 = 0
        L_0x00f5:
            r19 = 0
            r20 = r14
            r14 = r5
            r5 = r18
            r18 = r16
            r16 = r20
        L_0x0100:
            if (r16 != 0) goto L_0x02d3
            if (r18 == 0) goto L_0x0106
            goto L_0x02d3
        L_0x0106:
            if (r14 == 0) goto L_0x010e
            int r4 = r4 + -1
            r14 = 1
            r7.H(r14)
        L_0x010e:
            if (r5 == 0) goto L_0x0116
            int r4 = r4 + -4
            r5 = 4
            r7.H(r5)
        L_0x0116:
            if (r19 == 0) goto L_0x011c
            int r4 = r(r4, r7)
        L_0x011c:
            r14 = r4
            r4 = 88
            r5 = 84
            if (r9 != r5) goto L_0x015f
            if (r10 != r4) goto L_0x015d
            if (r11 != r4) goto L_0x015d
            if (r0 == r6) goto L_0x012b
            if (r12 != r4) goto L_0x015d
        L_0x012b:
            r1 = 1
            if (r14 >= r1) goto L_0x012f
            goto L_0x0191
        L_0x012f:
            int r1 = r22.v()     // Catch:{ all -> 0x015a }
            int r2 = r14 + -1
            byte[] r3 = new byte[r2]     // Catch:{ all -> 0x015a }
            r4 = 0
            r7.d(r3, r4, r2)     // Catch:{ all -> 0x015a }
            int r2 = p(r3, r4, r1)     // Catch:{ all -> 0x015a }
            java.lang.String r5 = new java.lang.String     // Catch:{ all -> 0x015a }
            java.nio.charset.Charset r6 = n(r1)     // Catch:{ all -> 0x015a }
            r5.<init>(r3, r4, r2, r6)     // Catch:{ all -> 0x015a }
            int r4 = m(r1)     // Catch:{ all -> 0x015a }
            int r4 = r4 + r2
            d9.r1 r1 = l(r3, r1, r4)     // Catch:{ all -> 0x015a }
            o2.x r6 = new o2.x     // Catch:{ all -> 0x015a }
            java.lang.String r2 = "TXXX"
            r6.<init>(r2, r5, r1)     // Catch:{ all -> 0x015a }
            goto L_0x02ae
        L_0x015a:
            r0 = move-exception
            goto L_0x02cf
        L_0x015d:
            r5 = 84
        L_0x015f:
            if (r9 != r5) goto L_0x0182
            java.lang.String r1 = o(r0, r9, r10, r11, r12)     // Catch:{ all -> 0x015a }
            r2 = 1
            if (r14 >= r2) goto L_0x0169
            goto L_0x0191
        L_0x0169:
            int r2 = r22.v()     // Catch:{ all -> 0x015a }
            int r3 = r14 + -1
            byte[] r4 = new byte[r3]     // Catch:{ all -> 0x015a }
            r5 = 0
            r7.d(r4, r5, r3)     // Catch:{ all -> 0x015a }
            d9.r1 r2 = l(r4, r2, r5)     // Catch:{ all -> 0x015a }
            o2.x r3 = new o2.x     // Catch:{ all -> 0x015a }
            r4 = 0
            r3.<init>(r1, r4, r2)     // Catch:{ all -> 0x015a }
            r6 = r3
            goto L_0x02ae
        L_0x0182:
            r5 = 87
            if (r9 != r5) goto L_0x01c5
            if (r10 != r4) goto L_0x01c5
            if (r11 != r4) goto L_0x01c5
            if (r0 == r6) goto L_0x018e
            if (r12 != r4) goto L_0x01c5
        L_0x018e:
            r1 = 1
            if (r14 >= r1) goto L_0x0194
        L_0x0191:
            r6 = 0
            goto L_0x02ae
        L_0x0194:
            int r1 = r22.v()     // Catch:{ all -> 0x015a }
            int r2 = r14 + -1
            byte[] r3 = new byte[r2]     // Catch:{ all -> 0x015a }
            r4 = 0
            r7.d(r3, r4, r2)     // Catch:{ all -> 0x015a }
            int r2 = p(r3, r4, r1)     // Catch:{ all -> 0x015a }
            java.lang.String r5 = new java.lang.String     // Catch:{ all -> 0x015a }
            java.nio.charset.Charset r6 = n(r1)     // Catch:{ all -> 0x015a }
            r5.<init>(r3, r4, r2, r6)     // Catch:{ all -> 0x015a }
            int r1 = m(r1)     // Catch:{ all -> 0x015a }
            int r1 = r1 + r2
            int r2 = q(r1, r3)     // Catch:{ all -> 0x015a }
            java.nio.charset.Charset r4 = c9.h.f3034b     // Catch:{ all -> 0x015a }
            java.lang.String r1 = k(r3, r1, r2, r4)     // Catch:{ all -> 0x015a }
            o2.z r6 = new o2.z     // Catch:{ all -> 0x015a }
            java.lang.String r2 = "WXXX"
            r6.<init>(r2, r5, r1)     // Catch:{ all -> 0x015a }
            goto L_0x02ae
        L_0x01c5:
            if (r9 != r5) goto L_0x01e5
            java.lang.String r1 = o(r0, r9, r10, r11, r12)     // Catch:{ all -> 0x015a }
            byte[] r2 = new byte[r14]     // Catch:{ all -> 0x015a }
            r3 = 0
            r7.d(r2, r3, r14)     // Catch:{ all -> 0x015a }
            int r4 = q(r3, r2)     // Catch:{ all -> 0x015a }
            java.lang.String r5 = new java.lang.String     // Catch:{ all -> 0x015a }
            java.nio.charset.Charset r6 = c9.h.f3034b     // Catch:{ all -> 0x015a }
            r5.<init>(r2, r3, r4, r6)     // Catch:{ all -> 0x015a }
            o2.z r2 = new o2.z     // Catch:{ all -> 0x015a }
            r3 = 0
            r2.<init>(r1, r3, r5)     // Catch:{ all -> 0x015a }
            r6 = r2
            goto L_0x02ae
        L_0x01e5:
            r4 = 73
            r5 = 80
            if (r9 != r5) goto L_0x0218
            r1 = 82
            if (r10 != r1) goto L_0x0218
            if (r11 != r4) goto L_0x0218
            r1 = 86
            if (r12 != r1) goto L_0x0218
            byte[] r1 = new byte[r14]     // Catch:{ all -> 0x015a }
            r2 = 0
            r7.d(r1, r2, r14)     // Catch:{ all -> 0x015a }
            int r3 = q(r2, r1)     // Catch:{ all -> 0x015a }
            java.lang.String r4 = new java.lang.String     // Catch:{ all -> 0x015a }
            java.nio.charset.Charset r5 = c9.h.f3034b     // Catch:{ all -> 0x015a }
            r4.<init>(r1, r2, r3, r5)     // Catch:{ all -> 0x015a }
            r2 = 1
            int r3 = r3 + r2
            if (r14 > r3) goto L_0x020d
            byte[] r1 = j1.l0.f8458f     // Catch:{ all -> 0x015a }
            goto L_0x0211
        L_0x020d:
            byte[] r1 = java.util.Arrays.copyOfRange(r1, r3, r14)     // Catch:{ all -> 0x015a }
        L_0x0211:
            o2.v r6 = new o2.v     // Catch:{ all -> 0x015a }
            r6.<init>(r4, r1)     // Catch:{ all -> 0x015a }
            goto L_0x02ae
        L_0x0218:
            r1 = 71
            if (r9 != r1) goto L_0x022e
            r1 = 69
            if (r10 != r1) goto L_0x022e
            if (r11 != r2) goto L_0x022e
            r1 = 66
            if (r12 == r1) goto L_0x0228
            if (r0 != r6) goto L_0x022e
        L_0x0228:
            o2.l r6 = i(r14, r7)     // Catch:{ all -> 0x015a }
            goto L_0x02ae
        L_0x022e:
            r1 = 65
            if (r0 != r6) goto L_0x0239
            if (r9 != r5) goto L_0x0247
            if (r10 != r4) goto L_0x0247
            if (r11 != r3) goto L_0x0247
            goto L_0x0241
        L_0x0239:
            if (r9 != r1) goto L_0x0247
            if (r10 != r5) goto L_0x0247
            if (r11 != r4) goto L_0x0247
            if (r12 != r3) goto L_0x0247
        L_0x0241:
            o2.b r6 = d(r14, r0, r7)     // Catch:{ all -> 0x015a }
            goto L_0x02ae
        L_0x0247:
            if (r9 != r3) goto L_0x0258
            if (r10 != r2) goto L_0x0258
            r4 = 77
            if (r11 != r4) goto L_0x0258
            if (r12 == r4) goto L_0x0253
            if (r0 != r6) goto L_0x0258
        L_0x0253:
            o2.j r6 = g(r14, r7)     // Catch:{ all -> 0x015a }
            goto L_0x02ae
        L_0x0258:
            if (r9 != r3) goto L_0x0272
            r4 = 72
            if (r10 != r4) goto L_0x0272
            if (r11 != r1) goto L_0x0272
            if (r12 != r5) goto L_0x0272
            r1 = r22
            r2 = r14
            r3 = r21
            r4 = r23
            r5 = r24
            r6 = r25
            o2.f r6 = e(r1, r2, r3, r4, r5, r6)     // Catch:{ all -> 0x015a }
            goto L_0x02ae
        L_0x0272:
            if (r9 != r3) goto L_0x028c
            r1 = 84
            if (r10 != r1) goto L_0x028c
            if (r11 != r2) goto L_0x028c
            if (r12 != r3) goto L_0x028c
            r1 = r22
            r2 = r14
            r3 = r21
            r4 = r23
            r5 = r24
            r6 = r25
            o2.h r6 = f(r1, r2, r3, r4, r5, r6)     // Catch:{ all -> 0x015a }
            goto L_0x02ae
        L_0x028c:
            r1 = 77
            if (r9 != r1) goto L_0x029f
            r1 = 76
            if (r10 != r1) goto L_0x029f
            if (r11 != r1) goto L_0x029f
            r1 = 84
            if (r12 != r1) goto L_0x029f
            o2.t r6 = j(r14, r7)     // Catch:{ all -> 0x015a }
            goto L_0x02ae
        L_0x029f:
            java.lang.String r1 = o(r0, r9, r10, r11, r12)     // Catch:{ all -> 0x015a }
            byte[] r2 = new byte[r14]     // Catch:{ all -> 0x015a }
            r3 = 0
            r7.d(r2, r3, r14)     // Catch:{ all -> 0x015a }
            o2.d r6 = new o2.d     // Catch:{ all -> 0x015a }
            r6.<init>(r1, r2)     // Catch:{ all -> 0x015a }
        L_0x02ae:
            if (r6 != 0) goto L_0x02cb
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x015a }
            r1.<init>(r8)     // Catch:{ all -> 0x015a }
            java.lang.String r0 = o(r0, r9, r10, r11, r12)     // Catch:{ all -> 0x015a }
            r1.append(r0)     // Catch:{ all -> 0x015a }
            java.lang.String r0 = ", frameSize="
            r1.append(r0)     // Catch:{ all -> 0x015a }
            r1.append(r14)     // Catch:{ all -> 0x015a }
            java.lang.String r0 = r1.toString()     // Catch:{ all -> 0x015a }
            j1.v.g(r15, r0)     // Catch:{ all -> 0x015a }
        L_0x02cb:
            r7.G(r13)
            return r6
        L_0x02cf:
            r7.G(r13)
            throw r0
        L_0x02d3:
            java.lang.String r0 = "Skipping unsupported compressed or encrypted frame"
            j1.v.g(r15, r0)
        L_0x02d8:
            r7.G(r13)
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: o2.o.h(int, j1.b0, boolean, int, o2.m):o2.p");
    }

    public static l i(int i10, b0 b0Var) {
        byte[] bArr;
        int v10 = b0Var.v();
        Charset n10 = n(v10);
        int i11 = i10 - 1;
        byte[] bArr2 = new byte[i11];
        b0Var.d(bArr2, 0, i11);
        int q10 = q(0, bArr2);
        String str = new String(bArr2, 0, q10, h.f3034b);
        int i12 = q10 + 1;
        int p10 = p(bArr2, i12, v10);
        String k10 = k(bArr2, i12, p10, n10);
        int m10 = m(v10) + p10;
        int p11 = p(bArr2, m10, v10);
        String k11 = k(bArr2, m10, p11, n10);
        int m11 = m(v10) + p11;
        if (i11 <= m11) {
            bArr = l0.f8458f;
        } else {
            bArr = Arrays.copyOfRange(bArr2, m11, i11);
        }
        return new l(str, k10, k11, bArr);
    }

    public static t j(int i10, b0 b0Var) {
        int A = b0Var.A();
        int x10 = b0Var.x();
        int x11 = b0Var.x();
        int v10 = b0Var.v();
        int v11 = b0Var.v();
        a0 a0Var = new a0();
        a0Var.j(b0Var.f8416c, b0Var.f8414a);
        a0Var.k(b0Var.f8415b * 8);
        int i11 = ((i10 - 10) * 8) / (v10 + v11);
        int[] iArr = new int[i11];
        int[] iArr2 = new int[i11];
        for (int i12 = 0; i12 < i11; i12++) {
            int g10 = a0Var.g(v10);
            int g11 = a0Var.g(v11);
            iArr[i12] = g10;
            iArr2[i12] = g11;
        }
        return new t(A, x10, iArr, iArr2, x11);
    }

    public static String k(byte[] bArr, int i10, int i11, Charset charset) {
        return (i11 <= i10 || i11 > bArr.length) ? "" : new String(bArr, i10, i11 - i10, charset);
    }

    public static r1 l(byte[] bArr, int i10, int i11) {
        if (i11 >= bArr.length) {
            return r0.n("");
        }
        p0 p0Var = r0.f4657i;
        o0 o0Var = new o0();
        while (true) {
            int p10 = p(bArr, i11, i10);
            if (i11 >= p10) {
                break;
            }
            o0Var.c(new String(bArr, i11, p10 - i11, n(i10)));
            i11 = m(i10) + p10;
        }
        r1 e10 = o0Var.e();
        if (e10.isEmpty()) {
            return r0.n("");
        }
        return e10;
    }

    public static int m(int i10) {
        return (i10 == 0 || i10 == 3) ? 1 : 2;
    }

    public static Charset n(int i10) {
        return i10 != 1 ? i10 != 2 ? i10 != 3 ? h.f3034b : h.f3035c : h.f3036d : h.f3038f;
    }

    public static String o(int i10, int i11, int i12, int i13, int i14) {
        if (i10 == 2) {
            return String.format(Locale.US, "%c%c%c", new Object[]{Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13)});
        }
        return String.format(Locale.US, "%c%c%c%c", new Object[]{Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13), Integer.valueOf(i14)});
    }

    public static int p(byte[] bArr, int i10, int i11) {
        int q10 = q(i10, bArr);
        if (i11 == 0 || i11 == 3) {
            return q10;
        }
        while (q10 < bArr.length - 1) {
            if ((q10 - i10) % 2 == 0 && bArr[q10 + 1] == 0) {
                return q10;
            }
            q10 = q(q10 + 1, bArr);
        }
        return bArr.length;
    }

    public static int q(int i10, byte[] bArr) {
        while (i10 < bArr.length) {
            if (bArr[i10] == 0) {
                return i10;
            }
            i10++;
        }
        return bArr.length;
    }

    public static int r(int i10, b0 b0Var) {
        byte[] bArr = b0Var.f8414a;
        int i11 = b0Var.f8415b;
        int i12 = i11;
        while (true) {
            int i13 = i12 + 1;
            if (i13 >= i11 + i10) {
                return i10;
            }
            if ((bArr[i12] & 255) == 255 && bArr[i13] == 0) {
                System.arraycopy(bArr, i12 + 2, bArr, i13, (i10 - (i12 - i11)) - 2);
                i10--;
            }
            i12 = i13;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0075, code lost:
        if ((r10 & 1) != 0) goto L_0x0088;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0083, code lost:
        if ((r10 & 128) != 0) goto L_0x0088;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean s(j1.b0 r18, int r19, int r20, boolean r21) {
        /*
            r1 = r18
            r0 = r19
            int r2 = r1.f8415b
        L_0x0006:
            int r3 = r1.f8416c     // Catch:{ all -> 0x00ad }
            int r4 = r1.f8415b     // Catch:{ all -> 0x00ad }
            int r3 = r3 - r4
            r4 = 1
            r5 = r20
            if (r3 < r5) goto L_0x00a9
            r3 = 0
            r6 = 3
            if (r0 < r6) goto L_0x0021
            int r7 = r18.f()     // Catch:{ all -> 0x00ad }
            long r8 = r18.w()     // Catch:{ all -> 0x00ad }
            int r10 = r18.A()     // Catch:{ all -> 0x00ad }
            goto L_0x002b
        L_0x0021:
            int r7 = r18.x()     // Catch:{ all -> 0x00ad }
            int r8 = r18.x()     // Catch:{ all -> 0x00ad }
            long r8 = (long) r8
            r10 = 0
        L_0x002b:
            r11 = 0
            if (r7 != 0) goto L_0x0039
            int r7 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
            if (r7 != 0) goto L_0x0039
            if (r10 != 0) goto L_0x0039
            r1.G(r2)
            return r4
        L_0x0039:
            r7 = 4
            if (r0 != r7) goto L_0x006a
            if (r21 != 0) goto L_0x006a
            r13 = 8421504(0x808080, double:4.160776E-317)
            long r13 = r13 & r8
            int r15 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r15 == 0) goto L_0x004a
            r1.G(r2)
            return r3
        L_0x004a:
            r11 = 255(0xff, double:1.26E-321)
            long r13 = r8 & r11
            r15 = 8
            long r15 = r8 >> r15
            long r15 = r15 & r11
            r17 = 7
            long r15 = r15 << r17
            long r13 = r13 | r15
            r15 = 16
            long r15 = r8 >> r15
            long r15 = r15 & r11
            r17 = 14
            long r15 = r15 << r17
            long r13 = r13 | r15
            r15 = 24
            long r8 = r8 >> r15
            long r8 = r8 & r11
            r11 = 21
            long r8 = r8 << r11
            long r8 = r8 | r13
        L_0x006a:
            if (r0 != r7) goto L_0x0078
            r6 = r10 & 64
            if (r6 == 0) goto L_0x0072
            r6 = 1
            goto L_0x0073
        L_0x0072:
            r6 = 0
        L_0x0073:
            r7 = r10 & 1
            if (r7 == 0) goto L_0x0087
            goto L_0x0088
        L_0x0078:
            if (r0 != r6) goto L_0x0086
            r6 = r10 & 32
            if (r6 == 0) goto L_0x0080
            r6 = 1
            goto L_0x0081
        L_0x0080:
            r6 = 0
        L_0x0081:
            r7 = r10 & 128(0x80, float:1.794E-43)
            if (r7 == 0) goto L_0x0087
            goto L_0x0088
        L_0x0086:
            r6 = 0
        L_0x0087:
            r4 = 0
        L_0x0088:
            if (r4 == 0) goto L_0x008c
            int r6 = r6 + 4
        L_0x008c:
            long r6 = (long) r6
            int r4 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r4 >= 0) goto L_0x0095
            r1.G(r2)
            return r3
        L_0x0095:
            int r4 = r1.f8416c     // Catch:{ all -> 0x00ad }
            int r6 = r1.f8415b     // Catch:{ all -> 0x00ad }
            int r4 = r4 - r6
            long r6 = (long) r4
            int r4 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r4 >= 0) goto L_0x00a3
            r1.G(r2)
            return r3
        L_0x00a3:
            int r3 = (int) r8
            r1.H(r3)     // Catch:{ all -> 0x00ad }
            goto L_0x0006
        L_0x00a9:
            r1.G(r2)
            return r4
        L_0x00ad:
            r0 = move-exception
            r1.G(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: o2.o.s(j1.b0, int, int, boolean):boolean");
    }

    public final z0 b(a aVar, ByteBuffer byteBuffer) {
        return c(byteBuffer.limit(), byteBuffer.array());
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x00b7 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00b8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final g1.z0 c(int r13, byte[] r14) {
        /*
            r12 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            j1.b0 r1 = new j1.b0
            r1.<init>(r13, r14)
            int r13 = r1.f8416c
            int r14 = r1.f8415b
            int r13 = r13 - r14
            r14 = 2
            java.lang.String r2 = "Id3Decoder"
            r3 = 10
            r4 = 4
            r5 = 0
            r6 = 0
            r7 = 1
            if (r13 >= r3) goto L_0x001e
            java.lang.String r13 = "Data too short to be an ID3 tag"
            goto L_0x00b1
        L_0x001e:
            int r13 = r1.x()
            r8 = 4801587(0x494433, float:6.728456E-39)
            if (r13 == r8) goto L_0x0041
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r9 = "Unexpected first three bytes of ID3 tag header: 0x"
            r8.<init>(r9)
            java.lang.Object[] r9 = new java.lang.Object[r7]
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
            r9[r6] = r13
            java.lang.String r13 = "%06X"
            java.lang.String r13 = java.lang.String.format(r13, r9)
            r8.append(r13)
            goto L_0x00ad
        L_0x0041:
            int r13 = r1.v()
            r1.H(r7)
            int r8 = r1.v()
            int r9 = r1.u()
            if (r13 != r14) goto L_0x005e
            r10 = r8 & 64
            if (r10 == 0) goto L_0x0058
            r10 = 1
            goto L_0x0059
        L_0x0058:
            r10 = 0
        L_0x0059:
            if (r10 == 0) goto L_0x0094
            java.lang.String r13 = "Skipped ID3 tag with majorVersion=2 and undefined compression scheme"
            goto L_0x00b1
        L_0x005e:
            r10 = 3
            if (r13 != r10) goto L_0x0074
            r10 = r8 & 64
            if (r10 == 0) goto L_0x0067
            r10 = 1
            goto L_0x0068
        L_0x0067:
            r10 = 0
        L_0x0068:
            if (r10 == 0) goto L_0x0094
            int r10 = r1.f()
            r1.H(r10)
            int r10 = r10 + r4
            int r9 = r9 - r10
            goto L_0x0094
        L_0x0074:
            if (r13 != r4) goto L_0x00a3
            r10 = r8 & 64
            if (r10 == 0) goto L_0x007c
            r10 = 1
            goto L_0x007d
        L_0x007c:
            r10 = 0
        L_0x007d:
            if (r10 == 0) goto L_0x0089
            int r10 = r1.u()
            int r11 = r10 + -4
            r1.H(r11)
            int r9 = r9 - r10
        L_0x0089:
            r10 = r8 & 16
            if (r10 == 0) goto L_0x008f
            r10 = 1
            goto L_0x0090
        L_0x008f:
            r10 = 0
        L_0x0090:
            if (r10 == 0) goto L_0x0094
            int r9 = r9 + -10
        L_0x0094:
            if (r13 >= r4) goto L_0x009c
            r8 = r8 & 128(0x80, float:1.794E-43)
            if (r8 == 0) goto L_0x009c
            r8 = 1
            goto L_0x009d
        L_0x009c:
            r8 = 0
        L_0x009d:
            o2.n r10 = new o2.n
            r10.<init>(r13, r9, r8)
            goto L_0x00b5
        L_0x00a3:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r9 = "Skipped ID3 tag with unsupported majorVersion="
            r8.<init>(r9)
            r8.append(r13)
        L_0x00ad:
            java.lang.String r13 = r8.toString()
        L_0x00b1:
            j1.v.g(r2, r13)
            r10 = r5
        L_0x00b5:
            if (r10 != 0) goto L_0x00b8
            return r5
        L_0x00b8:
            int r13 = r1.f8415b
            int r8 = r10.f12085a
            if (r8 != r14) goto L_0x00bf
            r3 = 6
        L_0x00bf:
            int r14 = r10.f12087c
            boolean r9 = r10.f12086b
            if (r9 == 0) goto L_0x00c9
            int r14 = r(r14, r1)
        L_0x00c9:
            int r13 = r13 + r14
            r1.F(r13)
            boolean r13 = s(r1, r8, r3, r6)
            if (r13 != 0) goto L_0x00ef
            if (r8 != r4) goto L_0x00dd
            boolean r13 = s(r1, r4, r3, r7)
            if (r13 == 0) goto L_0x00dd
            r6 = 1
            goto L_0x00ef
        L_0x00dd:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            java.lang.String r14 = "Failed to validate ID3 tag with majorVersion="
            r13.<init>(r14)
            r13.append(r8)
            java.lang.String r13 = r13.toString()
            j1.v.g(r2, r13)
            return r5
        L_0x00ef:
            int r13 = r1.f8416c
            int r14 = r1.f8415b
            int r13 = r13 - r14
            if (r13 < r3) goto L_0x0102
            o2.m r13 = r12.f12089a
            o2.p r13 = h(r8, r1, r6, r3, r13)
            if (r13 == 0) goto L_0x00ef
            r0.add(r13)
            goto L_0x00ef
        L_0x0102:
            g1.z0 r13 = new g1.z0
            r13.<init>((java.util.List) r0)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: o2.o.c(int, byte[]):g1.z0");
    }

    public o(c cVar) {
        this.f12089a = cVar;
    }
}
