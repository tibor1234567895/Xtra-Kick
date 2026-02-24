package dc;

import fb.c;
import hb.h0;
import java.io.Serializable;
import java.security.MessageDigest;
import java.util.Arrays;
import ma.o;
import xa.j;

public class n implements Serializable, Comparable {

    /* renamed from: k  reason: collision with root package name */
    public static final m f4802k = new m(0);

    /* renamed from: l  reason: collision with root package name */
    public static final n f4803l = new n(new byte[0]);

    /* renamed from: h  reason: collision with root package name */
    public final byte[] f4804h;

    /* renamed from: i  reason: collision with root package name */
    public transient int f4805i;

    /* renamed from: j  reason: collision with root package name */
    public transient String f4806j;

    public n(byte[] bArr) {
        j.f("data", bArr);
        this.f4804h = bArr;
    }

    public static int g(n nVar, n nVar2) {
        nVar.getClass();
        j.f("other", nVar2);
        return nVar.f(0, nVar2.f4804h);
    }

    public static int k(n nVar, n nVar2) {
        int i10 = w0.f4842b;
        nVar.getClass();
        j.f("other", nVar2);
        return nVar.j(i10, nVar2.f4804h);
    }

    public static n o(n nVar, int i10, int i11, int i12) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = w0.f4842b;
        }
        return nVar.n(i10, i11);
    }

    public String a() {
        byte[] bArr = v0.f4835a;
        byte[] bArr2 = this.f4804h;
        j.f("<this>", bArr2);
        j.f("map", bArr);
        byte[] bArr3 = new byte[(((bArr2.length + 2) / 3) * 4)];
        int length = bArr2.length - (bArr2.length % 3);
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            int i12 = i10 + 1;
            byte b10 = bArr2[i10];
            int i13 = i12 + 1;
            byte b11 = bArr2[i12];
            int i14 = i13 + 1;
            byte b12 = bArr2[i13];
            int i15 = i11 + 1;
            bArr3[i11] = bArr[(b10 & 255) >> 2];
            int i16 = i15 + 1;
            bArr3[i15] = bArr[((b10 & 3) << 4) | ((b11 & 255) >> 4)];
            int i17 = i16 + 1;
            bArr3[i16] = bArr[((b11 & 15) << 2) | ((b12 & 255) >> 6)];
            i11 = i17 + 1;
            bArr3[i17] = bArr[b12 & 63];
            i10 = i14;
        }
        int length2 = bArr2.length - length;
        if (length2 == 1) {
            byte b13 = bArr2[i10];
            int i18 = i11 + 1;
            bArr3[i11] = bArr[(b13 & 255) >> 2];
            int i19 = i18 + 1;
            bArr3[i18] = bArr[(b13 & 3) << 4];
            bArr3[i19] = 61;
            bArr3[i19 + 1] = 61;
        } else if (length2 == 2) {
            int i20 = i10 + 1;
            byte b14 = bArr2[i10];
            byte b15 = bArr2[i20];
            int i21 = i11 + 1;
            bArr3[i11] = bArr[(b14 & 255) >> 2];
            int i22 = i21 + 1;
            bArr3[i21] = bArr[((b14 & 3) << 4) | ((b15 & 255) >> 4)];
            bArr3[i22] = bArr[(b15 & 15) << 2];
            bArr3[i22 + 1] = 61;
        }
        return new String(bArr3, c.f5986b);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0032 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0030 A[RETURN, SYNTHETIC] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int compareTo(dc.n r10) {
        /*
            r9 = this;
            java.lang.String r0 = "other"
            xa.j.f(r0, r10)
            int r0 = r9.d()
            int r1 = r10.d()
            int r2 = java.lang.Math.min(r0, r1)
            r3 = 0
            r4 = 0
        L_0x0013:
            r5 = -1
            r6 = 1
            if (r4 >= r2) goto L_0x002b
            byte r7 = r9.i(r4)
            r7 = r7 & 255(0xff, float:3.57E-43)
            byte r8 = r10.i(r4)
            r8 = r8 & 255(0xff, float:3.57E-43)
            if (r7 != r8) goto L_0x0028
            int r4 = r4 + 1
            goto L_0x0013
        L_0x0028:
            if (r7 >= r8) goto L_0x0032
            goto L_0x0030
        L_0x002b:
            if (r0 != r1) goto L_0x002e
            goto L_0x0033
        L_0x002e:
            if (r0 >= r1) goto L_0x0032
        L_0x0030:
            r3 = -1
            goto L_0x0033
        L_0x0032:
            r3 = 1
        L_0x0033:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.n.compareTo(dc.n):int");
    }

    public n c(String str) {
        MessageDigest instance = MessageDigest.getInstance(str);
        instance.update(this.f4804h, 0, d());
        byte[] digest = instance.digest();
        j.e("digestBytes", digest);
        return new n(digest);
    }

    public int d() {
        return this.f4804h.length;
    }

    public String e() {
        byte[] bArr = this.f4804h;
        char[] cArr = new char[(bArr.length * 2)];
        int i10 = 0;
        for (byte b10 : bArr) {
            int i11 = i10 + 1;
            char[] cArr2 = h0.f7802a;
            cArr[i10] = cArr2[(b10 >> 4) & 15];
            i10 = i11 + 1;
            cArr[i11] = cArr2[b10 & 15];
        }
        return new String(cArr);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof n) {
            n nVar = (n) obj;
            int d10 = nVar.d();
            byte[] bArr = this.f4804h;
            if (d10 != bArr.length || !nVar.l(0, 0, bArr.length, bArr)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int f(int i10, byte[] bArr) {
        j.f("other", bArr);
        byte[] bArr2 = this.f4804h;
        int length = bArr2.length - bArr.length;
        int max = Math.max(i10, 0);
        if (max <= length) {
            while (!w0.a(max, 0, bArr.length, bArr2, bArr)) {
                if (max != length) {
                    max++;
                }
            }
            return max;
        }
        return -1;
    }

    public byte[] h() {
        return this.f4804h;
    }

    public int hashCode() {
        int i10 = this.f4805i;
        if (i10 != 0) {
            return i10;
        }
        int hashCode = Arrays.hashCode(this.f4804h);
        this.f4805i = hashCode;
        return hashCode;
    }

    public byte i(int i10) {
        return this.f4804h[i10];
    }

    public int j(int i10, byte[] bArr) {
        j.f("other", bArr);
        int c10 = w0.c(i10, this);
        byte[] bArr2 = this.f4804h;
        for (int min = Math.min(c10, bArr2.length - bArr.length); -1 < min; min--) {
            if (w0.a(min, 0, bArr.length, bArr2, bArr)) {
                return min;
            }
        }
        return -1;
    }

    public boolean l(int i10, int i11, int i12, byte[] bArr) {
        j.f("other", bArr);
        if (i10 >= 0) {
            byte[] bArr2 = this.f4804h;
            return i10 <= bArr2.length - i12 && i11 >= 0 && i11 <= bArr.length - i12 && w0.a(i10, i11, i12, bArr2, bArr);
        }
    }

    public boolean m(int i10, n nVar, int i11) {
        j.f("other", nVar);
        return nVar.l(0, i10, i11, this.f4804h);
    }

    public n n(int i10, int i11) {
        int c10 = w0.c(i11, this);
        boolean z10 = false;
        if (i10 >= 0) {
            byte[] bArr = this.f4804h;
            if (c10 <= bArr.length) {
                if (c10 - i10 >= 0) {
                    z10 = true;
                }
                if (z10) {
                    return (i10 == 0 && c10 == bArr.length) ? this : new n(o.e(bArr, i10, c10));
                }
                throw new IllegalArgumentException("endIndex < beginIndex".toString());
            }
            throw new IllegalArgumentException(("endIndex > length(" + bArr.length + ')').toString());
        }
        throw new IllegalArgumentException("beginIndex < 0".toString());
    }

    public n p() {
        int i10 = 0;
        while (true) {
            byte[] bArr = this.f4804h;
            if (i10 >= bArr.length) {
                return this;
            }
            byte b10 = bArr[i10];
            if (b10 < 65 || b10 > 90) {
                i10++;
            } else {
                byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
                j.e("copyOf(this, size)", copyOf);
                copyOf[i10] = (byte) (b10 + 32);
                for (int i11 = i10 + 1; i11 < copyOf.length; i11++) {
                    byte b11 = copyOf[i11];
                    if (b11 >= 65 && b11 <= 90) {
                        copyOf[i11] = (byte) (b11 + 32);
                    }
                }
                return new n(copyOf);
            }
        }
    }

    public final String q() {
        String str = this.f4806j;
        if (str != null) {
            return str;
        }
        byte[] h10 = h();
        j.f("<this>", h10);
        String str2 = new String(h10, c.f5986b);
        this.f4806j = str2;
        return str2;
    }

    public void r(j jVar, int i10) {
        j.f("buffer", jVar);
        jVar.P0(this.f4804h, 0, i10);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x0100, code lost:
        if (r6 == 64) goto L_0x0228;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x0111, code lost:
        if (r6 == 64) goto L_0x0228;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x0120, code lost:
        if (r6 == 64) goto L_0x0228;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x0132, code lost:
        if (r6 == 64) goto L_0x0228;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x013f, code lost:
        if (r6 == 64) goto L_0x0228;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x0188, code lost:
        if (r6 == 64) goto L_0x0228;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x0199, code lost:
        if (r6 == 64) goto L_0x0228;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x01aa, code lost:
        if (r6 == 64) goto L_0x0228;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x01b9, code lost:
        if (r6 == 64) goto L_0x0228;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:173:0x01cf, code lost:
        if (r6 == 64) goto L_0x0228;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x01dc, code lost:
        if (r6 == 64) goto L_0x0228;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:182:0x01e3, code lost:
        if (r6 == 64) goto L_0x0228;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:211:0x0224, code lost:
        if (r6 == 64) goto L_0x0228;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:212:0x0227, code lost:
        r7 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x009d, code lost:
        if (r6 == 64) goto L_0x0228;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x00ac, code lost:
        if (r6 == 64) goto L_0x0228;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x00b7, code lost:
        if (r6 == 64) goto L_0x0228;
     */
    /* JADX WARNING: Removed duplicated region for block: B:244:0x0227 A[EDGE_INSN: B:244:0x0227->B:212:0x0227 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:253:0x0227 A[EDGE_INSN: B:253:0x0227->B:212:0x0227 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:256:0x0227 A[EDGE_INSN: B:256:0x0227->B:212:0x0227 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:259:0x0227 A[EDGE_INSN: B:259:0x0227->B:212:0x0227 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:271:0x0227 A[EDGE_INSN: B:271:0x0227->B:212:0x0227 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String toString() {
        /*
            r18 = this;
            r0 = r18
            byte[] r1 = r0.f4804h
            int r2 = r1.length
            if (r2 != 0) goto L_0x0009
            r2 = 1
            goto L_0x000a
        L_0x0009:
            r2 = 0
        L_0x000a:
            if (r2 == 0) goto L_0x0010
            java.lang.String r1 = "[size=0]"
            goto L_0x02fe
        L_0x0010:
            int r2 = r1.length
            r5 = 0
            r6 = 0
            r7 = 0
        L_0x0014:
            r9 = 64
            if (r5 >= r2) goto L_0x0228
            byte r10 = r1[r5]
            r11 = 13
            r12 = 127(0x7f, float:1.78E-43)
            r13 = 160(0xa0, float:2.24E-43)
            r14 = 32
            r15 = 65533(0xfffd, float:9.1831E-41)
            r4 = 65536(0x10000, float:9.18355E-41)
            r16 = 2
            r3 = 10
            if (r10 < 0) goto L_0x0092
            int r17 = r6 + 1
            if (r6 != r9) goto L_0x0033
            goto L_0x0228
        L_0x0033:
            if (r10 == r3) goto L_0x004f
            if (r10 == r11) goto L_0x004f
            if (r10 < 0) goto L_0x003d
            if (r10 >= r14) goto L_0x003d
            r6 = 1
            goto L_0x003e
        L_0x003d:
            r6 = 0
        L_0x003e:
            if (r6 != 0) goto L_0x004c
            if (r12 > r10) goto L_0x0046
            if (r10 >= r13) goto L_0x0046
            r6 = 1
            goto L_0x0047
        L_0x0046:
            r6 = 0
        L_0x0047:
            if (r6 == 0) goto L_0x004a
            goto L_0x004c
        L_0x004a:
            r6 = 0
            goto L_0x004d
        L_0x004c:
            r6 = 1
        L_0x004d:
            if (r6 != 0) goto L_0x0227
        L_0x004f:
            if (r10 != r15) goto L_0x0053
            goto L_0x0227
        L_0x0053:
            if (r10 >= r4) goto L_0x0057
            r6 = 1
            goto L_0x0058
        L_0x0057:
            r6 = 2
        L_0x0058:
            int r7 = r7 + r6
            int r5 = r5 + 1
        L_0x005b:
            r6 = r17
            if (r5 >= r2) goto L_0x0014
            byte r10 = r1[r5]
            if (r10 < 0) goto L_0x0014
            int r5 = r5 + 1
            int r17 = r6 + 1
            if (r6 != r9) goto L_0x006b
            goto L_0x0228
        L_0x006b:
            if (r10 == r3) goto L_0x0087
            if (r10 == r11) goto L_0x0087
            if (r10 < 0) goto L_0x0075
            if (r10 >= r14) goto L_0x0075
            r6 = 1
            goto L_0x0076
        L_0x0075:
            r6 = 0
        L_0x0076:
            if (r6 != 0) goto L_0x0084
            if (r12 > r10) goto L_0x007e
            if (r10 >= r13) goto L_0x007e
            r6 = 1
            goto L_0x007f
        L_0x007e:
            r6 = 0
        L_0x007f:
            if (r6 == 0) goto L_0x0082
            goto L_0x0084
        L_0x0082:
            r6 = 0
            goto L_0x0085
        L_0x0084:
            r6 = 1
        L_0x0085:
            if (r6 != 0) goto L_0x0227
        L_0x0087:
            if (r10 != r15) goto L_0x008b
            goto L_0x0227
        L_0x008b:
            if (r10 >= r4) goto L_0x008f
            r6 = 1
            goto L_0x0090
        L_0x008f:
            r6 = 2
        L_0x0090:
            int r7 = r7 + r6
            goto L_0x005b
        L_0x0092:
            int r8 = r10 >> 5
            r4 = -2
            r15 = 128(0x80, float:1.794E-43)
            if (r8 != r4) goto L_0x00f2
            int r4 = r5 + 1
            if (r2 > r4) goto L_0x00a1
            if (r6 != r9) goto L_0x0227
            goto L_0x0228
        L_0x00a1:
            byte r4 = r1[r4]
            r8 = r4 & 192(0xc0, float:2.69E-43)
            if (r8 != r15) goto L_0x00a9
            r8 = 1
            goto L_0x00aa
        L_0x00a9:
            r8 = 0
        L_0x00aa:
            if (r8 != 0) goto L_0x00b0
            if (r6 != r9) goto L_0x0227
            goto L_0x0228
        L_0x00b0:
            r4 = r4 ^ 3968(0xf80, float:5.56E-42)
            int r8 = r10 << 6
            r4 = r4 ^ r8
            if (r4 >= r15) goto L_0x00bb
            if (r6 != r9) goto L_0x0227
            goto L_0x0228
        L_0x00bb:
            int r8 = r6 + 1
            if (r6 != r9) goto L_0x00c1
            goto L_0x0228
        L_0x00c1:
            if (r4 == r3) goto L_0x00dd
            if (r4 == r11) goto L_0x00dd
            if (r4 < 0) goto L_0x00cb
            if (r4 >= r14) goto L_0x00cb
            r3 = 1
            goto L_0x00cc
        L_0x00cb:
            r3 = 0
        L_0x00cc:
            if (r3 != 0) goto L_0x00da
            if (r12 > r4) goto L_0x00d4
            if (r4 >= r13) goto L_0x00d4
            r3 = 1
            goto L_0x00d5
        L_0x00d4:
            r3 = 0
        L_0x00d5:
            if (r3 == 0) goto L_0x00d8
            goto L_0x00da
        L_0x00d8:
            r3 = 0
            goto L_0x00db
        L_0x00da:
            r3 = 1
        L_0x00db:
            if (r3 != 0) goto L_0x0227
        L_0x00dd:
            r3 = 65533(0xfffd, float:9.1831E-41)
            if (r4 != r3) goto L_0x00e4
            goto L_0x0227
        L_0x00e4:
            r3 = 65536(0x10000, float:9.18355E-41)
            if (r4 >= r3) goto L_0x00ea
            r16 = 1
        L_0x00ea:
            int r7 = r7 + r16
            la.v r3 = la.v.f9814a
            int r5 = r5 + 2
            goto L_0x0221
        L_0x00f2:
            int r8 = r10 >> 4
            r13 = 57344(0xe000, float:8.0356E-41)
            r12 = 55296(0xd800, float:7.7486E-41)
            if (r8 != r4) goto L_0x0180
            int r4 = r5 + 2
            if (r2 > r4) goto L_0x0104
            if (r6 != r9) goto L_0x0227
            goto L_0x0228
        L_0x0104:
            int r8 = r5 + 1
            byte r8 = r1[r8]
            r14 = r8 & 192(0xc0, float:2.69E-43)
            if (r14 != r15) goto L_0x010e
            r14 = 1
            goto L_0x010f
        L_0x010e:
            r14 = 0
        L_0x010f:
            if (r14 != 0) goto L_0x0115
            if (r6 != r9) goto L_0x0227
            goto L_0x0228
        L_0x0115:
            byte r4 = r1[r4]
            r14 = r4 & 192(0xc0, float:2.69E-43)
            if (r14 != r15) goto L_0x011d
            r14 = 1
            goto L_0x011e
        L_0x011d:
            r14 = 0
        L_0x011e:
            if (r14 != 0) goto L_0x0124
            if (r6 != r9) goto L_0x0227
            goto L_0x0228
        L_0x0124:
            r14 = -123008(0xfffffffffffe1f80, float:NaN)
            r4 = r4 ^ r14
            int r8 = r8 << 6
            r4 = r4 ^ r8
            int r8 = r10 << 12
            r4 = r4 ^ r8
            r8 = 2048(0x800, float:2.87E-42)
            if (r4 >= r8) goto L_0x0136
            if (r6 != r9) goto L_0x0227
            goto L_0x0228
        L_0x0136:
            if (r12 > r4) goto L_0x013c
            if (r4 >= r13) goto L_0x013c
            r8 = 1
            goto L_0x013d
        L_0x013c:
            r8 = 0
        L_0x013d:
            if (r8 == 0) goto L_0x0143
            if (r6 != r9) goto L_0x0227
            goto L_0x0228
        L_0x0143:
            int r8 = r6 + 1
            if (r6 != r9) goto L_0x0149
            goto L_0x0228
        L_0x0149:
            if (r4 == r3) goto L_0x016b
            if (r4 == r11) goto L_0x016b
            if (r4 < 0) goto L_0x0155
            r3 = 32
            if (r4 >= r3) goto L_0x0155
            r3 = 1
            goto L_0x0156
        L_0x0155:
            r3 = 0
        L_0x0156:
            if (r3 != 0) goto L_0x0168
            r3 = 127(0x7f, float:1.78E-43)
            if (r3 > r4) goto L_0x0162
            r3 = 160(0xa0, float:2.24E-43)
            if (r4 >= r3) goto L_0x0162
            r3 = 1
            goto L_0x0163
        L_0x0162:
            r3 = 0
        L_0x0163:
            if (r3 == 0) goto L_0x0166
            goto L_0x0168
        L_0x0166:
            r3 = 0
            goto L_0x0169
        L_0x0168:
            r3 = 1
        L_0x0169:
            if (r3 != 0) goto L_0x0227
        L_0x016b:
            r3 = 65533(0xfffd, float:9.1831E-41)
            if (r4 != r3) goto L_0x0172
            goto L_0x0227
        L_0x0172:
            r3 = 65536(0x10000, float:9.18355E-41)
            if (r4 >= r3) goto L_0x0178
            r16 = 1
        L_0x0178:
            int r7 = r7 + r16
            la.v r3 = la.v.f9814a
            int r5 = r5 + 3
            goto L_0x0221
        L_0x0180:
            int r8 = r10 >> 3
            if (r8 != r4) goto L_0x0224
            int r4 = r5 + 3
            if (r2 > r4) goto L_0x018c
            if (r6 != r9) goto L_0x0227
            goto L_0x0228
        L_0x018c:
            int r8 = r5 + 1
            byte r8 = r1[r8]
            r14 = r8 & 192(0xc0, float:2.69E-43)
            if (r14 != r15) goto L_0x0196
            r14 = 1
            goto L_0x0197
        L_0x0196:
            r14 = 0
        L_0x0197:
            if (r14 != 0) goto L_0x019d
            if (r6 != r9) goto L_0x0227
            goto L_0x0228
        L_0x019d:
            int r14 = r5 + 2
            byte r14 = r1[r14]
            r11 = r14 & 192(0xc0, float:2.69E-43)
            if (r11 != r15) goto L_0x01a7
            r11 = 1
            goto L_0x01a8
        L_0x01a7:
            r11 = 0
        L_0x01a8:
            if (r11 != 0) goto L_0x01ae
            if (r6 != r9) goto L_0x0227
            goto L_0x0228
        L_0x01ae:
            byte r4 = r1[r4]
            r11 = r4 & 192(0xc0, float:2.69E-43)
            if (r11 != r15) goto L_0x01b6
            r11 = 1
            goto L_0x01b7
        L_0x01b6:
            r11 = 0
        L_0x01b7:
            if (r11 != 0) goto L_0x01bd
            if (r6 != r9) goto L_0x0227
            goto L_0x0228
        L_0x01bd:
            r11 = 3678080(0x381f80, float:5.154088E-39)
            r4 = r4 ^ r11
            int r11 = r14 << 6
            r4 = r4 ^ r11
            int r8 = r8 << 12
            r4 = r4 ^ r8
            int r8 = r10 << 18
            r4 = r4 ^ r8
            r8 = 1114111(0x10ffff, float:1.561202E-39)
            if (r4 <= r8) goto L_0x01d3
            if (r6 != r9) goto L_0x0227
            goto L_0x0228
        L_0x01d3:
            if (r12 > r4) goto L_0x01d9
            if (r4 >= r13) goto L_0x01d9
            r8 = 1
            goto L_0x01da
        L_0x01d9:
            r8 = 0
        L_0x01da:
            if (r8 == 0) goto L_0x01df
            if (r6 != r9) goto L_0x0227
            goto L_0x0228
        L_0x01df:
            r8 = 65536(0x10000, float:9.18355E-41)
            if (r4 >= r8) goto L_0x01e6
            if (r6 != r9) goto L_0x0227
            goto L_0x0228
        L_0x01e6:
            int r8 = r6 + 1
            if (r6 != r9) goto L_0x01eb
            goto L_0x0228
        L_0x01eb:
            if (r4 == r3) goto L_0x020f
            r3 = 13
            if (r4 == r3) goto L_0x020f
            if (r4 < 0) goto L_0x01f9
            r3 = 32
            if (r4 >= r3) goto L_0x01f9
            r3 = 1
            goto L_0x01fa
        L_0x01f9:
            r3 = 0
        L_0x01fa:
            if (r3 != 0) goto L_0x020c
            r3 = 127(0x7f, float:1.78E-43)
            if (r3 > r4) goto L_0x0206
            r3 = 160(0xa0, float:2.24E-43)
            if (r4 >= r3) goto L_0x0206
            r3 = 1
            goto L_0x0207
        L_0x0206:
            r3 = 0
        L_0x0207:
            if (r3 == 0) goto L_0x020a
            goto L_0x020c
        L_0x020a:
            r3 = 0
            goto L_0x020d
        L_0x020c:
            r3 = 1
        L_0x020d:
            if (r3 != 0) goto L_0x0227
        L_0x020f:
            r3 = 65533(0xfffd, float:9.1831E-41)
            if (r4 != r3) goto L_0x0215
            goto L_0x0227
        L_0x0215:
            r3 = 65536(0x10000, float:9.18355E-41)
            if (r4 >= r3) goto L_0x021b
            r16 = 1
        L_0x021b:
            int r7 = r7 + r16
            la.v r3 = la.v.f9814a
            int r5 = r5 + 4
        L_0x0221:
            r6 = r8
            goto L_0x0014
        L_0x0224:
            if (r6 != r9) goto L_0x0227
            goto L_0x0228
        L_0x0227:
            r7 = -1
        L_0x0228:
            java.lang.String r2 = "[size="
            r3 = -1
            if (r7 != r3) goto L_0x02a4
            int r3 = r1.length
            if (r3 > r9) goto L_0x0240
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "[hex="
            r1.<init>(r2)
            java.lang.String r2 = r18.e()
            r1.append(r2)
            goto L_0x02f5
        L_0x0240:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r2)
            int r2 = r1.length
            r3.append(r2)
            java.lang.String r2 = " hex="
            r3.append(r2)
            int r2 = dc.w0.c(r9, r0)
            int r4 = r1.length
            if (r2 > r4) goto L_0x0257
            r4 = 1
            goto L_0x0258
        L_0x0257:
            r4 = 0
        L_0x0258:
            if (r4 == 0) goto L_0x0286
            int r4 = r2 + 0
            if (r4 < 0) goto L_0x0260
            r4 = 1
            goto L_0x0261
        L_0x0260:
            r4 = 0
        L_0x0261:
            if (r4 == 0) goto L_0x027a
            int r4 = r1.length
            if (r2 != r4) goto L_0x0268
            r4 = r0
            goto L_0x0272
        L_0x0268:
            dc.n r4 = new dc.n
            r5 = 0
            byte[] r1 = ma.o.e(r1, r5, r2)
            r4.<init>(r1)
        L_0x0272:
            java.lang.String r1 = r4.e()
            r3.append(r1)
            goto L_0x02e1
        L_0x027a:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "endIndex < beginIndex"
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x0286:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "endIndex > length("
            r2.<init>(r3)
            int r1 = r1.length
            r2.append(r1)
            r1 = 41
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r1 = r1.toString()
            r2.<init>(r1)
            throw r2
        L_0x02a4:
            java.lang.String r3 = r18.q()
            r4 = 0
            java.lang.String r4 = r3.substring(r4, r7)
            java.lang.String r5 = "this as java.lang.String…ing(startIndex, endIndex)"
            xa.j.e(r5, r4)
            java.lang.String r5 = "\\"
            java.lang.String r6 = "\\\\"
            java.lang.String r4 = fb.w.k(r4, r5, r6)
            java.lang.String r5 = "\n"
            java.lang.String r6 = "\\n"
            java.lang.String r4 = fb.w.k(r4, r5, r6)
            java.lang.String r5 = "\r"
            java.lang.String r6 = "\\r"
            java.lang.String r4 = fb.w.k(r4, r5, r6)
            int r3 = r3.length()
            if (r7 >= r3) goto L_0x02eb
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r2)
            int r1 = r1.length
            r3.append(r1)
            java.lang.String r1 = " text="
            r3.append(r1)
            r3.append(r4)
        L_0x02e1:
            java.lang.String r1 = "…]"
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            goto L_0x02fe
        L_0x02eb:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "[text="
            r1.<init>(r2)
            r1.append(r4)
        L_0x02f5:
            r2 = 93
            r1.append(r2)
            java.lang.String r1 = r1.toString()
        L_0x02fe:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.n.toString():java.lang.String");
    }
}
