package j1;

import c9.h;
import d9.u0;
import java.nio.charset.Charset;
import java.util.Arrays;

public final class b0 {

    /* renamed from: d  reason: collision with root package name */
    public static final char[] f8411d = {13, 10};

    /* renamed from: e  reason: collision with root package name */
    public static final char[] f8412e = {10};

    /* renamed from: f  reason: collision with root package name */
    public static final u0 f8413f = u0.i(5, h.f3033a, h.f3035c, h.f3038f, h.f3036d, h.f3037e);

    /* renamed from: a  reason: collision with root package name */
    public byte[] f8414a;

    /* renamed from: b  reason: collision with root package name */
    public int f8415b;

    /* renamed from: c  reason: collision with root package name */
    public int f8416c;

    public b0() {
        this.f8414a = l0.f8458f;
    }

    public final int A() {
        byte[] bArr = this.f8414a;
        int i10 = this.f8415b;
        int i11 = i10 + 1;
        this.f8415b = i11 + 1;
        return (bArr[i11] & 255) | ((bArr[i10] & 255) << 8);
    }

    public final long B() {
        int i10;
        int i11;
        long j10 = (long) this.f8414a[this.f8415b];
        int i12 = 7;
        while (true) {
            i10 = 1;
            if (i12 < 0) {
                break;
            }
            int i13 = 1 << i12;
            if ((((long) i13) & j10) != 0) {
                i12--;
            } else if (i12 < 6) {
                j10 &= (long) (i13 - 1);
                i11 = 7 - i12;
            } else if (i12 == 7) {
                i11 = 1;
            }
        }
        i11 = 0;
        if (i11 != 0) {
            while (i10 < i11) {
                byte b10 = this.f8414a[this.f8415b + i10];
                if ((b10 & 192) == 128) {
                    j10 = (j10 << 6) | ((long) (b10 & 63));
                    i10++;
                } else {
                    throw new NumberFormatException(android.support.v4.media.h.k("Invalid UTF-8 sequence continuation byte: ", j10));
                }
            }
            this.f8415b += i11;
            return j10;
        }
        throw new NumberFormatException(android.support.v4.media.h.k("Invalid UTF-8 sequence first byte: ", j10));
    }

    public final Charset C() {
        int i10 = this.f8416c;
        int i11 = this.f8415b;
        if (i10 - i11 >= 3) {
            byte[] bArr = this.f8414a;
            if (bArr[i11] == -17 && bArr[i11 + 1] == -69 && bArr[i11 + 2] == -65) {
                this.f8415b = i11 + 3;
                return h.f3035c;
            }
        }
        if (i10 - i11 < 2) {
            return null;
        }
        byte[] bArr2 = this.f8414a;
        byte b10 = bArr2[i11];
        if (b10 == -2 && bArr2[i11 + 1] == -1) {
            this.f8415b = i11 + 2;
            return h.f3036d;
        } else if (b10 != -1 || bArr2[i11 + 1] != -2) {
            return null;
        } else {
            this.f8415b = i11 + 2;
            return h.f3037e;
        }
    }

    public final void D(int i10) {
        byte[] bArr = this.f8414a;
        if (bArr.length < i10) {
            bArr = new byte[i10];
        }
        E(i10, bArr);
    }

    public final void E(int i10, byte[] bArr) {
        this.f8414a = bArr;
        this.f8416c = i10;
        this.f8415b = 0;
    }

    public final void F(int i10) {
        a.b(i10 >= 0 && i10 <= this.f8414a.length);
        this.f8416c = i10;
    }

    public final void G(int i10) {
        a.b(i10 >= 0 && i10 <= this.f8416c);
        this.f8415b = i10;
    }

    public final void H(int i10) {
        G(this.f8415b + i10);
    }

    public final void a(int i10) {
        byte[] bArr = this.f8414a;
        if (i10 > bArr.length) {
            this.f8414a = Arrays.copyOf(bArr, i10);
        }
    }

    public final char b(Charset charset) {
        boolean contains = f8413f.contains(charset);
        a.a("Unsupported charset: " + charset, contains);
        return (char) (c(charset) >> 16);
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0095  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int c(java.nio.charset.Charset r10) {
        /*
            r9 = this;
            java.nio.charset.Charset r0 = c9.h.f3035c
            boolean r0 = r10.equals(r0)
            java.lang.String r1 = "Out of range: %s"
            r2 = 0
            r3 = 1
            if (r0 != 0) goto L_0x0014
            java.nio.charset.Charset r0 = c9.h.f3033a
            boolean r0 = r10.equals(r0)
            if (r0 == 0) goto L_0x0043
        L_0x0014:
            int r0 = r9.f8416c
            int r4 = r9.f8415b
            int r0 = r0 - r4
            if (r0 < r3) goto L_0x0043
            byte[] r10 = r9.f8414a
            byte r10 = r10[r4]
            r10 = r10 & 255(0xff, float:3.57E-43)
            long r4 = (long) r10
            int r10 = (int) r4
            char r10 = (char) r10
            long r6 = (long) r10
            int r0 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r0 != 0) goto L_0x002b
            r0 = 1
            goto L_0x002c
        L_0x002b:
            r0 = 0
        L_0x002c:
            if (r0 == 0) goto L_0x0031
            byte r10 = (byte) r10
            r4 = 1
            goto L_0x0084
        L_0x0031:
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.Object[] r0 = new java.lang.Object[r3]
            java.lang.Long r3 = java.lang.Long.valueOf(r4)
            r0[r2] = r3
            java.lang.String r0 = c9.v.a(r1, r0)
            r10.<init>(r0)
            throw r10
        L_0x0043:
            java.nio.charset.Charset r0 = c9.h.f3038f
            boolean r0 = r10.equals(r0)
            r4 = 2
            if (r0 != 0) goto L_0x0054
            java.nio.charset.Charset r0 = c9.h.f3036d
            boolean r0 = r10.equals(r0)
            if (r0 == 0) goto L_0x0069
        L_0x0054:
            int r0 = r9.f8416c
            int r5 = r9.f8415b
            int r0 = r0 - r5
            if (r0 < r4) goto L_0x0069
            byte[] r10 = r9.f8414a
            byte r0 = r10[r5]
            int r5 = r5 + r3
            byte r10 = r10[r5]
            int r0 = r0 << 8
        L_0x0064:
            r10 = r10 & 255(0xff, float:3.57E-43)
            r10 = r10 | r0
            char r10 = (char) r10
            goto L_0x0083
        L_0x0069:
            java.nio.charset.Charset r0 = c9.h.f3037e
            boolean r10 = r10.equals(r0)
            if (r10 == 0) goto L_0x00a7
            int r10 = r9.f8416c
            int r0 = r9.f8415b
            int r10 = r10 - r0
            if (r10 < r4) goto L_0x00a7
            byte[] r10 = r9.f8414a
            int r5 = r0 + 1
            byte r5 = r10[r5]
            byte r10 = r10[r0]
            int r0 = r5 << 8
            goto L_0x0064
        L_0x0083:
            byte r10 = (byte) r10
        L_0x0084:
            long r5 = (long) r10
            int r10 = (int) r5
            char r10 = (char) r10
            long r7 = (long) r10
            int r0 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r0 != 0) goto L_0x008e
            r0 = 1
            goto L_0x008f
        L_0x008e:
            r0 = 0
        L_0x008f:
            if (r0 == 0) goto L_0x0095
            int r10 = r10 << 16
            int r10 = r10 + r4
            return r10
        L_0x0095:
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.Object[] r0 = new java.lang.Object[r3]
            java.lang.Long r3 = java.lang.Long.valueOf(r5)
            r0[r2] = r3
            java.lang.String r0 = c9.v.a(r1, r0)
            r10.<init>(r0)
            throw r10
        L_0x00a7:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: j1.b0.c(java.nio.charset.Charset):int");
    }

    public final void d(byte[] bArr, int i10, int i11) {
        System.arraycopy(this.f8414a, this.f8415b, bArr, i10, i11);
        this.f8415b += i11;
    }

    public final char e(Charset charset, char[] cArr) {
        boolean z10;
        int c10 = c(charset);
        if (c10 != 0) {
            char c11 = (char) (c10 >> 16);
            int length = cArr.length;
            int i10 = 0;
            while (true) {
                if (i10 >= length) {
                    z10 = false;
                    break;
                } else if (cArr[i10] == c11) {
                    z10 = true;
                    break;
                } else {
                    i10++;
                }
            }
            if (z10) {
                this.f8415b += c10 & 65535;
                return c11;
            }
        }
        return 0;
    }

    public final int f() {
        byte[] bArr = this.f8414a;
        int i10 = this.f8415b;
        int i11 = i10 + 1;
        int i12 = i11 + 1;
        byte b10 = ((bArr[i10] & 255) << 24) | ((bArr[i11] & 255) << 16);
        int i13 = i12 + 1;
        byte b11 = b10 | ((bArr[i12] & 255) << 8);
        this.f8415b = i13 + 1;
        return (bArr[i13] & 255) | b11;
    }

    public final String g() {
        return h(h.f3035c);
    }

    public final String h(Charset charset) {
        int i10;
        boolean contains = f8413f.contains(charset);
        a.a("Unsupported charset: " + charset, contains);
        if (this.f8416c - this.f8415b == 0) {
            return null;
        }
        Charset charset2 = h.f3033a;
        if (!charset.equals(charset2)) {
            C();
        }
        if (charset.equals(h.f3035c) || charset.equals(charset2)) {
            i10 = 1;
        } else if (charset.equals(h.f3038f) || charset.equals(h.f3037e) || charset.equals(h.f3036d)) {
            i10 = 2;
        } else {
            throw new IllegalArgumentException("Unsupported charset: " + charset);
        }
        int i11 = this.f8415b;
        while (true) {
            int i12 = this.f8416c;
            if (i11 >= i12 - (i10 - 1)) {
                i11 = i12;
                break;
            } else if ((charset.equals(h.f3035c) || charset.equals(h.f3033a)) && l0.E(this.f8414a[i11])) {
                break;
            } else {
                if (charset.equals(h.f3038f) || charset.equals(h.f3036d)) {
                    byte[] bArr = this.f8414a;
                    if (bArr[i11] == 0 && l0.E(bArr[i11 + 1])) {
                        break;
                    }
                }
                if (charset.equals(h.f3037e)) {
                    byte[] bArr2 = this.f8414a;
                    if (bArr2[i11 + 1] == 0 && l0.E(bArr2[i11])) {
                        break;
                    }
                }
                i11 += i10;
            }
        }
        String t10 = t(i11 - this.f8415b, charset);
        if (this.f8415b != this.f8416c && e(charset, f8411d) == 13) {
            e(charset, f8412e);
        }
        return t10;
    }

    public final int i() {
        byte[] bArr = this.f8414a;
        int i10 = this.f8415b;
        int i11 = i10 + 1;
        int i12 = i11 + 1;
        byte b10 = (bArr[i10] & 255) | ((bArr[i11] & 255) << 8);
        int i13 = i12 + 1;
        byte b11 = b10 | ((bArr[i12] & 255) << 16);
        this.f8415b = i13 + 1;
        return ((bArr[i13] & 255) << 24) | b11;
    }

    public final long j() {
        byte[] bArr = this.f8414a;
        int i10 = this.f8415b;
        int i11 = i10 + 1;
        int i12 = i11 + 1;
        int i13 = i12 + 1;
        int i14 = i13 + 1;
        int i15 = i14 + 1;
        int i16 = i15 + 1;
        int i17 = i16 + 1;
        this.f8415b = i17 + 1;
        return (((long) bArr[i10]) & 255) | ((((long) bArr[i11]) & 255) << 8) | ((((long) bArr[i12]) & 255) << 16) | ((((long) bArr[i13]) & 255) << 24) | ((((long) bArr[i14]) & 255) << 32) | ((((long) bArr[i15]) & 255) << 40) | ((((long) bArr[i16]) & 255) << 48) | ((((long) bArr[i17]) & 255) << 56);
    }

    public final short k() {
        byte[] bArr = this.f8414a;
        int i10 = this.f8415b;
        int i11 = i10 + 1;
        this.f8415b = i11 + 1;
        return (short) (((bArr[i11] & 255) << 8) | (bArr[i10] & 255));
    }

    public final long l() {
        byte[] bArr = this.f8414a;
        int i10 = this.f8415b;
        int i11 = i10 + 1;
        int i12 = i11 + 1;
        int i13 = i12 + 1;
        this.f8415b = i13 + 1;
        return (((long) bArr[i10]) & 255) | ((((long) bArr[i11]) & 255) << 8) | ((((long) bArr[i12]) & 255) << 16) | ((((long) bArr[i13]) & 255) << 24);
    }

    public final int m() {
        int i10 = i();
        if (i10 >= 0) {
            return i10;
        }
        throw new IllegalStateException(android.support.v4.media.h.i("Top bit not zero: ", i10));
    }

    public final int n() {
        byte[] bArr = this.f8414a;
        int i10 = this.f8415b;
        int i11 = i10 + 1;
        this.f8415b = i11 + 1;
        return ((bArr[i11] & 255) << 8) | (bArr[i10] & 255);
    }

    public final long o() {
        byte[] bArr = this.f8414a;
        int i10 = this.f8415b;
        int i11 = i10 + 1;
        int i12 = i11 + 1;
        int i13 = i12 + 1;
        int i14 = i13 + 1;
        int i15 = i14 + 1;
        int i16 = i15 + 1;
        int i17 = i16 + 1;
        this.f8415b = i17 + 1;
        return ((((long) bArr[i10]) & 255) << 56) | ((((long) bArr[i11]) & 255) << 48) | ((((long) bArr[i12]) & 255) << 40) | ((((long) bArr[i13]) & 255) << 32) | ((((long) bArr[i14]) & 255) << 24) | ((((long) bArr[i15]) & 255) << 16) | ((((long) bArr[i16]) & 255) << 8) | (((long) bArr[i17]) & 255);
    }

    public final String p() {
        int i10 = this.f8416c;
        int i11 = this.f8415b;
        if (i10 - i11 == 0) {
            return null;
        }
        while (i11 < this.f8416c && this.f8414a[i11] != 0) {
            i11++;
        }
        byte[] bArr = this.f8414a;
        int i12 = this.f8415b;
        int i13 = l0.f8453a;
        String str = new String(bArr, i12, i11 - i12, h.f3035c);
        this.f8415b = i11;
        if (i11 < this.f8416c) {
            this.f8415b = i11 + 1;
        }
        return str;
    }

    public final String q(int i10) {
        int i11;
        if (i10 == 0) {
            return "";
        }
        int i12 = this.f8415b;
        int i13 = (i12 + i10) - 1;
        if (i13 >= this.f8416c || this.f8414a[i13] != 0) {
            i11 = i10;
        } else {
            i11 = i10 - 1;
        }
        byte[] bArr = this.f8414a;
        int i14 = l0.f8453a;
        String str = new String(bArr, i12, i11, h.f3035c);
        this.f8415b += i10;
        return str;
    }

    public final short r() {
        byte[] bArr = this.f8414a;
        int i10 = this.f8415b;
        int i11 = i10 + 1;
        this.f8415b = i11 + 1;
        return (short) ((bArr[i11] & 255) | ((bArr[i10] & 255) << 8));
    }

    public final String s(int i10) {
        return t(i10, h.f3035c);
    }

    public final String t(int i10, Charset charset) {
        String str = new String(this.f8414a, this.f8415b, i10, charset);
        this.f8415b += i10;
        return str;
    }

    public final int u() {
        return (v() << 21) | (v() << 14) | (v() << 7) | v();
    }

    public final int v() {
        byte[] bArr = this.f8414a;
        int i10 = this.f8415b;
        this.f8415b = i10 + 1;
        return bArr[i10] & 255;
    }

    public final long w() {
        byte[] bArr = this.f8414a;
        int i10 = this.f8415b;
        int i11 = i10 + 1;
        int i12 = i11 + 1;
        int i13 = i12 + 1;
        this.f8415b = i13 + 1;
        return ((((long) bArr[i10]) & 255) << 24) | ((((long) bArr[i11]) & 255) << 16) | ((((long) bArr[i12]) & 255) << 8) | (((long) bArr[i13]) & 255);
    }

    public final int x() {
        byte[] bArr = this.f8414a;
        int i10 = this.f8415b;
        int i11 = i10 + 1;
        int i12 = i11 + 1;
        byte b10 = ((bArr[i10] & 255) << 16) | ((bArr[i11] & 255) << 8);
        this.f8415b = i12 + 1;
        return (bArr[i12] & 255) | b10;
    }

    public final int y() {
        int f10 = f();
        if (f10 >= 0) {
            return f10;
        }
        throw new IllegalStateException(android.support.v4.media.h.i("Top bit not zero: ", f10));
    }

    public final long z() {
        long o10 = o();
        if (o10 >= 0) {
            return o10;
        }
        throw new IllegalStateException(android.support.v4.media.h.k("Top bit not zero: ", o10));
    }

    public b0(int i10) {
        this.f8414a = new byte[i10];
        this.f8416c = i10;
    }

    public b0(int i10, byte[] bArr) {
        this.f8414a = bArr;
        this.f8416c = i10;
    }

    public b0(byte[] bArr) {
        this.f8414a = bArr;
        this.f8416c = bArr.length;
    }
}
