package dc;

import android.support.v4.media.h;
import ec.k;
import fb.c;
import hb.h0;
import java.io.EOFException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import ma.f;
import ma.o;

public final class j implements l, k, Cloneable, ByteChannel {

    /* renamed from: h  reason: collision with root package name */
    public k0 f4786h;

    /* renamed from: i  reason: collision with root package name */
    public long f4787i;

    public final /* bridge */ /* synthetic */ k A(int i10) {
        T0(i10);
        return this;
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x006c A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0092 A[EDGE_INSN: B:45:0x0092->B:30:0x0092 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:5:0x0017  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long D0() {
        /*
            r15 = this;
            long r0 = r15.f4787i
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x00ad
            r0 = 0
            r4 = r2
            r1 = 0
            r6 = 0
        L_0x000c:
            dc.k0 r7 = r15.f4786h
            xa.j.c(r7)
            int r8 = r7.f4789b
            int r9 = r7.f4790c
        L_0x0015:
            if (r8 >= r9) goto L_0x0092
            byte[] r10 = r7.f4788a
            byte r10 = r10[r8]
            r11 = 48
            if (r10 < r11) goto L_0x0026
            r11 = 57
            if (r10 > r11) goto L_0x0026
            int r11 = r10 + -48
            goto L_0x003d
        L_0x0026:
            r11 = 97
            if (r10 < r11) goto L_0x0031
            r11 = 102(0x66, float:1.43E-43)
            if (r10 > r11) goto L_0x0031
            int r11 = r10 + -97
            goto L_0x003b
        L_0x0031:
            r11 = 65
            if (r10 < r11) goto L_0x0068
            r11 = 70
            if (r10 > r11) goto L_0x0068
            int r11 = r10 + -65
        L_0x003b:
            int r11 = r11 + 10
        L_0x003d:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r4
            int r14 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r14 != 0) goto L_0x004d
            r10 = 4
            long r4 = r4 << r10
            long r10 = (long) r11
            long r4 = r4 | r10
            int r8 = r8 + 1
            int r1 = r1 + 1
            goto L_0x0015
        L_0x004d:
            dc.j r0 = new dc.j
            r0.<init>()
            r0.S0(r4)
            r0.Q0(r10)
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.String r0 = r0.j0()
            java.lang.String r2 = "Number too large: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        L_0x0068:
            r6 = 1
            if (r1 == 0) goto L_0x006c
            goto L_0x0092
        L_0x006c:
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            dc.g r2 = dc.w0.f4841a
            r2 = 2
            char[] r2 = new char[r2]
            char[] r3 = hb.h0.f7802a
            int r4 = r10 >> 4
            r4 = r4 & 15
            char r4 = r3[r4]
            r2[r0] = r4
            r0 = r10 & 15
            char r0 = r3[r0]
            r2[r6] = r0
            java.lang.String r0 = new java.lang.String
            r0.<init>(r2)
            java.lang.String r2 = "Expected leading [0-9a-fA-F] character but was 0x"
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        L_0x0092:
            if (r8 != r9) goto L_0x009e
            dc.k0 r8 = r7.a()
            r15.f4786h = r8
            dc.l0.a(r7)
            goto L_0x00a0
        L_0x009e:
            r7.f4789b = r8
        L_0x00a0:
            if (r6 != 0) goto L_0x00a6
            dc.k0 r7 = r15.f4786h
            if (r7 != 0) goto L_0x000c
        L_0x00a6:
            long r2 = r15.f4787i
            long r0 = (long) r1
            long r2 = r2 - r0
            r15.f4787i = r2
            return r4
        L_0x00ad:
            java.io.EOFException r0 = new java.io.EOFException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.j.D0():long");
    }

    public final boolean E(long j10, n nVar) {
        xa.j.f("bytes", nVar);
        byte[] bArr = nVar.f4804h;
        int length = bArr.length;
        if (j10 < 0 || length < 0 || this.f4787i - j10 < ((long) length) || bArr.length - 0 < length) {
            return false;
        }
        for (int i10 = 0; i10 < length; i10++) {
            if (v(((long) i10) + j10) != bArr[0 + i10]) {
                return false;
            }
        }
        return true;
    }

    public final String E0(Charset charset) {
        xa.j.f("charset", charset);
        return a0(this.f4787i, charset);
    }

    public final long F0(p0 p0Var) {
        xa.j.f("source", p0Var);
        long j10 = 0;
        while (true) {
            long read = p0Var.read(this, 8192);
            if (read == -1) {
                return j10;
            }
            j10 += read;
        }
    }

    public final h G0() {
        return new h(this, 0);
    }

    public final void H(j jVar, long j10) {
        xa.j.f("sink", jVar);
        long j11 = this.f4787i;
        if (j11 >= j10) {
            jVar.o0(this, j10);
        } else {
            jVar.o0(this, j11);
            throw new EOFException();
        }
    }

    public final String H0(long j10) {
        return a0(j10, c.f5986b);
    }

    public final n I0(int i10) {
        if (i10 == 0) {
            return n.f4803l;
        }
        w0.b(this.f4787i, 0, (long) i10);
        k0 k0Var = this.f4786h;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (i12 < i10) {
            xa.j.c(k0Var);
            int i14 = k0Var.f4790c;
            int i15 = k0Var.f4789b;
            if (i14 != i15) {
                i12 += i14 - i15;
                i13++;
                k0Var = k0Var.f4793f;
            } else {
                throw new AssertionError("s.limit == s.pos");
            }
        }
        byte[][] bArr = new byte[i13][];
        int[] iArr = new int[(i13 * 2)];
        k0 k0Var2 = this.f4786h;
        int i16 = 0;
        while (i11 < i10) {
            xa.j.c(k0Var2);
            bArr[i16] = k0Var2.f4788a;
            i11 += k0Var2.f4790c - k0Var2.f4789b;
            iArr[i16] = Math.min(i11, i10);
            iArr[i16 + i13] = k0Var2.f4789b;
            k0Var2.f4791d = true;
            i16++;
            k0Var2 = k0Var2.f4793f;
        }
        return new m0(bArr, iArr);
    }

    public final String K() {
        return e0(Long.MAX_VALUE);
    }

    public final int K0(d0 d0Var) {
        xa.j.f("options", d0Var);
        int b10 = k.b(this, d0Var, false);
        if (b10 == -1) {
            return -1;
        }
        a((long) d0Var.f4750i[b10].d());
        return b10;
    }

    public final byte[] M() {
        return Y(this.f4787i);
    }

    public final k0 M0(int i10) {
        boolean z10 = true;
        if (i10 < 1 || i10 > 8192) {
            z10 = false;
        }
        if (z10) {
            k0 k0Var = this.f4786h;
            if (k0Var == null) {
                k0 b10 = l0.b();
                this.f4786h = b10;
                b10.f4794g = b10;
                b10.f4793f = b10;
                return b10;
            }
            k0 k0Var2 = k0Var.f4794g;
            xa.j.c(k0Var2);
            if (k0Var2.f4790c + i10 <= 8192 && k0Var2.f4792e) {
                return k0Var2;
            }
            k0 b11 = l0.b();
            k0Var2.b(b11);
            return b11;
        }
        throw new IllegalArgumentException("unexpected capacity".toString());
    }

    public final int N(byte[] bArr, int i10, int i11) {
        xa.j.f("sink", bArr);
        w0.b((long) bArr.length, (long) i10, (long) i11);
        k0 k0Var = this.f4786h;
        if (k0Var == null) {
            return -1;
        }
        int min = Math.min(i11, k0Var.f4790c - k0Var.f4789b);
        int i12 = k0Var.f4789b;
        o.c(i10, i12, i12 + min, k0Var.f4788a, bArr);
        int i13 = k0Var.f4789b + min;
        k0Var.f4789b = i13;
        this.f4787i -= (long) min;
        if (i13 == k0Var.f4790c) {
            this.f4786h = k0Var.a();
            l0.a(k0Var);
        }
        return min;
    }

    public final void N0(n nVar) {
        xa.j.f("byteString", nVar);
        nVar.r(this, nVar.d());
    }

    public final int O() {
        int readInt = readInt();
        g gVar = w0.f4841a;
        return ((readInt & 255) << 24) | ((-16777216 & readInt) >>> 24) | ((16711680 & readInt) >>> 8) | ((65280 & readInt) << 8);
    }

    public final void O0(byte[] bArr) {
        xa.j.f("source", bArr);
        P0(bArr, 0, bArr.length);
    }

    public final void P0(byte[] bArr, int i10, int i11) {
        xa.j.f("source", bArr);
        long j10 = (long) i11;
        w0.b((long) bArr.length, (long) i10, j10);
        int i12 = i11 + i10;
        while (i10 < i12) {
            k0 M0 = M0(1);
            int min = Math.min(i12 - i10, 8192 - M0.f4790c);
            int i13 = i10 + min;
            o.c(M0.f4790c, i10, i13, bArr, M0.f4788a);
            M0.f4790c += min;
            i10 = i13;
        }
        this.f4787i += j10;
    }

    public final long Q(k kVar) {
        long j10 = this.f4787i;
        if (j10 > 0) {
            kVar.o0(this, j10);
        }
        return j10;
    }

    public final void Q0(int i10) {
        k0 M0 = M0(1);
        int i11 = M0.f4790c;
        M0.f4790c = i11 + 1;
        M0.f4788a[i11] = (byte) i10;
        this.f4787i++;
    }

    public final boolean R() {
        return this.f4787i == 0;
    }

    /* renamed from: R0 */
    public final j w0(long j10) {
        boolean z10;
        byte[] bArr;
        int i10 = (j10 > 0 ? 1 : (j10 == 0 ? 0 : -1));
        if (i10 == 0) {
            Q0(48);
        } else {
            int i11 = 1;
            if (i10 < 0) {
                j10 = -j10;
                if (j10 < 0) {
                    X0("-9223372036854775808");
                } else {
                    z10 = true;
                }
            } else {
                z10 = false;
            }
            if (j10 < 100000000) {
                if (j10 < 10000) {
                    if (j10 < 100) {
                        if (j10 >= 10) {
                            i11 = 2;
                        }
                    } else if (j10 < 1000) {
                        i11 = 3;
                    } else {
                        i11 = 4;
                    }
                } else if (j10 < 1000000) {
                    if (j10 < 100000) {
                        i11 = 5;
                    } else {
                        i11 = 6;
                    }
                } else if (j10 < 10000000) {
                    i11 = 7;
                } else {
                    i11 = 8;
                }
            } else if (j10 < 1000000000000L) {
                if (j10 < 10000000000L) {
                    if (j10 < 1000000000) {
                        i11 = 9;
                    } else {
                        i11 = 10;
                    }
                } else if (j10 < 100000000000L) {
                    i11 = 11;
                } else {
                    i11 = 12;
                }
            } else if (j10 < 1000000000000000L) {
                if (j10 < 10000000000000L) {
                    i11 = 13;
                } else if (j10 < 100000000000000L) {
                    i11 = 14;
                } else {
                    i11 = 15;
                }
            } else if (j10 < 100000000000000000L) {
                if (j10 < 10000000000000000L) {
                    i11 = 16;
                } else {
                    i11 = 17;
                }
            } else if (j10 < 1000000000000000000L) {
                i11 = 18;
            } else {
                i11 = 19;
            }
            if (z10) {
                i11++;
            }
            k0 M0 = M0(i11);
            int i12 = M0.f4790c + i11;
            while (true) {
                bArr = M0.f4788a;
                if (j10 == 0) {
                    break;
                }
                long j11 = (long) 10;
                i12--;
                bArr[i12] = k.f5385a[(int) (j10 % j11)];
                j10 /= j11;
            }
            if (z10) {
                bArr[i12 - 1] = 45;
            }
            M0.f4790c += i11;
            this.f4787i += (long) i11;
        }
        return this;
    }

    public final /* bridge */ /* synthetic */ k S(int i10) {
        Q0(i10);
        return this;
    }

    public final j S0(long j10) {
        if (j10 == 0) {
            Q0(48);
        } else {
            long j11 = (j10 >>> 1) | j10;
            long j12 = j11 | (j11 >>> 2);
            long j13 = j12 | (j12 >>> 4);
            long j14 = j13 | (j13 >>> 8);
            long j15 = j14 | (j14 >>> 16);
            long j16 = j15 | (j15 >>> 32);
            long j17 = j16 - ((j16 >>> 1) & 6148914691236517205L);
            long j18 = ((j17 >>> 2) & 3689348814741910323L) + (j17 & 3689348814741910323L);
            long j19 = ((j18 >>> 4) + j18) & 1085102592571150095L;
            long j20 = j19 + (j19 >>> 8);
            long j21 = j20 + (j20 >>> 16);
            int i10 = (int) ((((j21 & 63) + ((j21 >>> 32) & 63)) + ((long) 3)) / ((long) 4));
            k0 M0 = M0(i10);
            int i11 = M0.f4790c;
            for (int i12 = (i11 + i10) - 1; i12 >= i11; i12--) {
                M0.f4788a[i12] = k.f5385a[(int) (15 & j10)];
                j10 >>>= 4;
            }
            M0.f4790c += i10;
            this.f4787i += (long) i10;
        }
        return this;
    }

    public final void T0(int i10) {
        k0 M0 = M0(4);
        int i11 = M0.f4790c;
        int i12 = i11 + 1;
        byte[] bArr = M0.f4788a;
        bArr[i11] = (byte) ((i10 >>> 24) & 255);
        int i13 = i12 + 1;
        bArr[i12] = (byte) ((i10 >>> 16) & 255);
        int i14 = i13 + 1;
        bArr[i13] = (byte) ((i10 >>> 8) & 255);
        bArr[i14] = (byte) (i10 & 255);
        M0.f4790c = i14 + 1;
        this.f4787i += 4;
    }

    public final void U0(int i10) {
        k0 M0 = M0(2);
        int i11 = M0.f4790c;
        int i12 = i11 + 1;
        byte[] bArr = M0.f4788a;
        bArr[i11] = (byte) ((i10 >>> 8) & 255);
        bArr[i12] = (byte) (i10 & 255);
        M0.f4790c = i12 + 1;
        this.f4787i += 2;
    }

    public final j V0(String str, int i10, int i11, Charset charset) {
        boolean z10;
        boolean z11;
        xa.j.f("string", str);
        boolean z12 = true;
        if (i10 >= 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            if (i11 >= i10) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                if (i11 > str.length()) {
                    z12 = false;
                }
                if (!z12) {
                    StringBuilder r10 = h.r("endIndex > string.length: ", i11, " > ");
                    r10.append(str.length());
                    throw new IllegalArgumentException(r10.toString().toString());
                } else if (xa.j.a(charset, c.f5986b)) {
                    W0(i10, i11, str);
                    return this;
                } else {
                    String substring = str.substring(i10, i11);
                    xa.j.e("this as java.lang.String…ing(startIndex, endIndex)", substring);
                    byte[] bytes = substring.getBytes(charset);
                    xa.j.e("this as java.lang.String).getBytes(charset)", bytes);
                    P0(bytes, 0, bytes.length);
                    return this;
                }
            } else {
                throw new IllegalArgumentException(("endIndex < beginIndex: " + i11 + " < " + i10).toString());
            }
        } else {
            throw new IllegalArgumentException(h.i("beginIndex < 0: ", i10).toString());
        }
    }

    public final g W(g gVar) {
        boolean z10;
        xa.j.f("unsafeCursor", gVar);
        byte[] bArr = k.f5385a;
        if (gVar == w0.f4841a) {
            gVar = new g();
        }
        if (gVar.f4764h == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            gVar.f4764h = this;
            gVar.f4765i = true;
            return gVar;
        }
        throw new IllegalStateException("already attached to a buffer".toString());
    }

    public final void W0(int i10, int i11, String str) {
        boolean z10;
        boolean z11;
        boolean z12;
        long j10;
        long j11;
        char c10;
        boolean z13;
        char charAt;
        xa.j.f("string", str);
        if (i10 >= 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            if (i11 >= i10) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                if (i11 <= str.length()) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                if (z12) {
                    while (i10 < i11) {
                        char charAt2 = str.charAt(i10);
                        if (charAt2 < 128) {
                            k0 M0 = M0(1);
                            int i12 = M0.f4790c - i10;
                            int min = Math.min(i11, 8192 - i12);
                            int i13 = i10 + 1;
                            byte[] bArr = M0.f4788a;
                            bArr[i10 + i12] = (byte) charAt2;
                            while (true) {
                                i10 = i13;
                                if (i10 >= min || (charAt = str.charAt(i10)) >= 128) {
                                    int i14 = M0.f4790c;
                                    int i15 = (i12 + i10) - i14;
                                    M0.f4790c = i14 + i15;
                                    this.f4787i += (long) i15;
                                } else {
                                    i13 = i10 + 1;
                                    bArr[i10 + i12] = (byte) charAt;
                                }
                            }
                            int i142 = M0.f4790c;
                            int i152 = (i12 + i10) - i142;
                            M0.f4790c = i142 + i152;
                            this.f4787i += (long) i152;
                        } else {
                            if (charAt2 < 2048) {
                                k0 M02 = M0(2);
                                int i16 = M02.f4790c;
                                byte[] bArr2 = M02.f4788a;
                                bArr2[i16] = (byte) ((charAt2 >> 6) | 192);
                                bArr2[i16 + 1] = (byte) ((charAt2 & '?') | 128);
                                M02.f4790c = i16 + 2;
                                j11 = this.f4787i;
                                j10 = 2;
                            } else if (charAt2 < 55296 || charAt2 > 57343) {
                                k0 M03 = M0(3);
                                int i17 = M03.f4790c;
                                byte[] bArr3 = M03.f4788a;
                                bArr3[i17] = (byte) ((charAt2 >> 12) | 224);
                                bArr3[i17 + 1] = (byte) ((63 & (charAt2 >> 6)) | 128);
                                bArr3[i17 + 2] = (byte) ((charAt2 & '?') | 128);
                                M03.f4790c = i17 + 3;
                                j11 = this.f4787i;
                                j10 = 3;
                            } else {
                                int i18 = i10 + 1;
                                if (i18 < i11) {
                                    c10 = str.charAt(i18);
                                } else {
                                    c10 = 0;
                                }
                                if (charAt2 <= 56319) {
                                    if (56320 > c10 || c10 >= 57344) {
                                        z13 = false;
                                    } else {
                                        z13 = true;
                                    }
                                    if (z13) {
                                        int i19 = (((charAt2 & 1023) << 10) | (c10 & 1023)) + 0;
                                        k0 M04 = M0(4);
                                        int i20 = M04.f4790c;
                                        byte[] bArr4 = M04.f4788a;
                                        bArr4[i20] = (byte) ((i19 >> 18) | 240);
                                        bArr4[i20 + 1] = (byte) (((i19 >> 12) & 63) | 128);
                                        bArr4[i20 + 2] = (byte) (((i19 >> 6) & 63) | 128);
                                        bArr4[i20 + 3] = (byte) ((i19 & 63) | 128);
                                        M04.f4790c = i20 + 4;
                                        this.f4787i += 4;
                                        i10 += 2;
                                    }
                                }
                                Q0(63);
                                i10 = i18;
                            }
                            this.f4787i = j11 + j10;
                            i10++;
                        }
                    }
                    return;
                }
                StringBuilder r10 = h.r("endIndex > string.length: ", i11, " > ");
                r10.append(str.length());
                throw new IllegalArgumentException(r10.toString().toString());
            }
            throw new IllegalArgumentException(("endIndex < beginIndex: " + i11 + " < " + i10).toString());
        }
        throw new IllegalArgumentException(h.i("beginIndex < 0: ", i10).toString());
    }

    public final /* bridge */ /* synthetic */ k X(byte[] bArr) {
        O0(bArr);
        return this;
    }

    public final void X0(String str) {
        xa.j.f("string", str);
        W0(0, str.length(), str);
    }

    public final byte[] Y(long j10) {
        boolean z10;
        if (j10 < 0 || j10 > 2147483647L) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (!z10) {
            throw new IllegalArgumentException(h.k("byteCount: ", j10).toString());
        } else if (this.f4787i >= j10) {
            byte[] bArr = new byte[((int) j10)];
            readFully(bArr);
            return bArr;
        } else {
            throw new EOFException();
        }
    }

    public final void Y0(int i10) {
        long j10;
        long j11;
        boolean z10;
        String str;
        if (i10 < 128) {
            Q0(i10);
            return;
        }
        if (i10 < 2048) {
            k0 M0 = M0(2);
            int i11 = M0.f4790c;
            byte[] bArr = M0.f4788a;
            bArr[i11] = (byte) ((i10 >> 6) | 192);
            bArr[i11 + 1] = (byte) ((i10 & 63) | 128);
            M0.f4790c = i11 + 2;
            j11 = this.f4787i;
            j10 = 2;
        } else {
            int i12 = 0;
            if (55296 > i10 || i10 >= 57344) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (z10) {
                Q0(63);
                return;
            } else if (i10 < 65536) {
                k0 M02 = M0(3);
                int i13 = M02.f4790c;
                byte[] bArr2 = M02.f4788a;
                bArr2[i13] = (byte) ((i10 >> 12) | 224);
                bArr2[i13 + 1] = (byte) (((i10 >> 6) & 63) | 128);
                bArr2[i13 + 2] = (byte) ((i10 & 63) | 128);
                M02.f4790c = i13 + 3;
                j11 = this.f4787i;
                j10 = 3;
            } else if (i10 <= 1114111) {
                k0 M03 = M0(4);
                int i14 = M03.f4790c;
                byte[] bArr3 = M03.f4788a;
                bArr3[i14] = (byte) ((i10 >> 18) | 240);
                bArr3[i14 + 1] = (byte) (((i10 >> 12) & 63) | 128);
                bArr3[i14 + 2] = (byte) (((i10 >> 6) & 63) | 128);
                bArr3[i14 + 3] = (byte) ((i10 & 63) | 128);
                M03.f4790c = i14 + 4;
                j11 = this.f4787i;
                j10 = 4;
            } else {
                StringBuilder sb2 = new StringBuilder("Unexpected code point: 0x");
                g gVar = w0.f4841a;
                if (i10 != 0) {
                    char[] cArr = h0.f7802a;
                    char[] cArr2 = {cArr[(i10 >> 28) & 15], cArr[(i10 >> 24) & 15], cArr[(i10 >> 20) & 15], cArr[(i10 >> 16) & 15], cArr[(i10 >> 12) & 15], cArr[(i10 >> 8) & 15], cArr[(i10 >> 4) & 15], cArr[i10 & 15]};
                    while (i12 < 8 && cArr2[i12] == '0') {
                        i12++;
                    }
                    f.f10810h.getClass();
                    if (i12 < 0) {
                        throw new IndexOutOfBoundsException(h.j("startIndex: ", i12, ", endIndex: 8, size: 8"));
                    } else if (i12 <= 8) {
                        str = new String(cArr2, i12, 8 - i12);
                    } else {
                        throw new IllegalArgumentException(h.j("startIndex: ", i12, " > endIndex: 8"));
                    }
                } else {
                    str = "0";
                }
                sb2.append(str);
                throw new IllegalArgumentException(sb2.toString());
            }
        }
        this.f4787i = j11 + j10;
    }

    public final short Z() {
        short readShort = readShort();
        g gVar = w0.f4841a;
        short s10 = readShort & 65535;
        return (short) (((s10 & 255) << 8) | ((65280 & s10) >>> 8));
    }

    public final void a(long j10) {
        while (j10 > 0) {
            k0 k0Var = this.f4786h;
            if (k0Var != null) {
                int min = (int) Math.min(j10, (long) (k0Var.f4790c - k0Var.f4789b));
                long j11 = (long) min;
                this.f4787i -= j11;
                j10 -= j11;
                int i10 = k0Var.f4789b + min;
                k0Var.f4789b = i10;
                if (i10 == k0Var.f4790c) {
                    this.f4786h = k0Var.a();
                    l0.a(k0Var);
                }
            } else {
                throw new EOFException();
            }
        }
    }

    public final String a0(long j10, Charset charset) {
        boolean z10;
        xa.j.f("charset", charset);
        int i10 = (j10 > 0 ? 1 : (j10 == 0 ? 0 : -1));
        if (i10 < 0 || j10 > 2147483647L) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (!z10) {
            throw new IllegalArgumentException(h.k("byteCount: ", j10).toString());
        } else if (this.f4787i < j10) {
            throw new EOFException();
        } else if (i10 == 0) {
            return "";
        } else {
            k0 k0Var = this.f4786h;
            xa.j.c(k0Var);
            int i11 = k0Var.f4789b;
            if (((long) i11) + j10 > ((long) k0Var.f4790c)) {
                return new String(Y(j10), charset);
            }
            int i12 = (int) j10;
            String str = new String(k0Var.f4788a, i11, i12, charset);
            int i13 = k0Var.f4789b + i12;
            k0Var.f4789b = i13;
            this.f4787i -= j10;
            if (i13 == k0Var.f4790c) {
                this.f4786h = k0Var.a();
                l0.a(k0Var);
            }
            return str;
        }
    }

    public final j b() {
        return this;
    }

    public final k b0() {
        return this;
    }

    public final void c() {
        a(this.f4787i);
    }

    public final Object clone() {
        j jVar = new j();
        if (this.f4787i != 0) {
            k0 k0Var = this.f4786h;
            xa.j.c(k0Var);
            k0 c10 = k0Var.c();
            jVar.f4786h = c10;
            c10.f4794g = c10;
            c10.f4793f = c10;
            for (k0 k0Var2 = k0Var.f4793f; k0Var2 != k0Var; k0Var2 = k0Var2.f4793f) {
                k0 k0Var3 = c10.f4794g;
                xa.j.c(k0Var3);
                xa.j.c(k0Var2);
                k0Var3.b(k0Var2.c());
            }
            jVar.f4787i = this.f4787i;
        }
        return jVar;
    }

    public final void close() {
    }

    public final long d0() {
        long readLong = readLong();
        g gVar = w0.f4841a;
        return ((readLong & 255) << 56) | ((-72057594037927936L & readLong) >>> 56) | ((71776119061217280L & readLong) >>> 40) | ((280375465082880L & readLong) >>> 24) | ((1095216660480L & readLong) >>> 8) | ((4278190080L & readLong) << 8) | ((16711680 & readLong) << 24) | ((65280 & readLong) << 40);
    }

    public final long e() {
        long j10 = this.f4787i;
        if (j10 == 0) {
            return 0;
        }
        k0 k0Var = this.f4786h;
        xa.j.c(k0Var);
        k0 k0Var2 = k0Var.f4794g;
        xa.j.c(k0Var2);
        int i10 = k0Var2.f4790c;
        if (i10 < 8192 && k0Var2.f4792e) {
            j10 -= (long) (i10 - k0Var2.f4789b);
        }
        return j10;
    }

    public final String e0(long j10) {
        boolean z10;
        if (j10 >= 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            long j11 = Long.MAX_VALUE;
            if (j10 != Long.MAX_VALUE) {
                j11 = j10 + 1;
            }
            long w10 = w((byte) 10, 0, j11);
            if (w10 != -1) {
                return k.a(this, w10);
            }
            if (j11 < this.f4787i && v(j11 - 1) == 13 && v(j11) == 10) {
                return k.a(this, j11);
            }
            j jVar = new j();
            k(0, Math.min((long) 32, this.f4787i), jVar);
            throw new EOFException("\\n not found: limit=" + Math.min(this.f4787i, j10) + " content=" + jVar.m().e() + 8230);
        }
        throw new IllegalArgumentException(h.k("limit < 0: ", j10).toString());
    }

    /* JADX WARNING: type inference failed for: r19v0, types: [java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r19) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            if (r0 != r1) goto L_0x0009
        L_0x0006:
            r2 = 1
            goto L_0x0078
        L_0x0009:
            boolean r3 = r1 instanceof dc.j
            if (r3 != 0) goto L_0x0010
        L_0x000d:
            r2 = 0
            goto L_0x0078
        L_0x0010:
            long r5 = r0.f4787i
            dc.j r1 = (dc.j) r1
            long r7 = r1.f4787i
            int r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r3 == 0) goto L_0x001b
            goto L_0x000d
        L_0x001b:
            r7 = 0
            int r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r3 != 0) goto L_0x0022
            goto L_0x0006
        L_0x0022:
            dc.k0 r3 = r0.f4786h
            xa.j.c(r3)
            dc.k0 r1 = r1.f4786h
            xa.j.c(r1)
            int r5 = r3.f4789b
            int r6 = r1.f4789b
            r9 = r7
        L_0x0031:
            long r11 = r0.f4787i
            int r13 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r13 >= 0) goto L_0x0006
            int r11 = r3.f4790c
            int r11 = r11 - r5
            int r12 = r1.f4790c
            int r12 = r12 - r6
            int r11 = java.lang.Math.min(r11, r12)
            long r11 = (long) r11
            r13 = r7
        L_0x0043:
            int r15 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r15 >= 0) goto L_0x005d
            int r15 = r5 + 1
            byte[] r2 = r3.f4788a
            byte r2 = r2[r5]
            int r5 = r6 + 1
            byte[] r4 = r1.f4788a
            byte r4 = r4[r6]
            if (r2 == r4) goto L_0x0056
            goto L_0x000d
        L_0x0056:
            r16 = 1
            long r13 = r13 + r16
            r6 = r5
            r5 = r15
            goto L_0x0043
        L_0x005d:
            int r2 = r3.f4790c
            if (r5 != r2) goto L_0x006a
            dc.k0 r2 = r3.f4793f
            xa.j.c(r2)
            int r3 = r2.f4789b
            r5 = r3
            r3 = r2
        L_0x006a:
            int r2 = r1.f4790c
            if (r6 != r2) goto L_0x0076
            dc.k0 r1 = r1.f4793f
            xa.j.c(r1)
            int r2 = r1.f4789b
            r6 = r2
        L_0x0076:
            long r9 = r9 + r11
            goto L_0x0031
        L_0x0078:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.j.equals(java.lang.Object):boolean");
    }

    public final /* bridge */ /* synthetic */ k f(byte[] bArr, int i10, int i11) {
        P0(bArr, i10, i11);
        return this;
    }

    public final void flush() {
    }

    public final int hashCode() {
        k0 k0Var = this.f4786h;
        if (k0Var == null) {
            return 0;
        }
        int i10 = 1;
        do {
            int i11 = k0Var.f4790c;
            for (int i12 = k0Var.f4789b; i12 < i11; i12++) {
                i10 = (i10 * 31) + k0Var.f4788a[i12];
            }
            k0Var = k0Var.f4793f;
            xa.j.c(k0Var);
        } while (k0Var != this.f4786h);
        return i10;
    }

    public final /* bridge */ /* synthetic */ k i0(n nVar) {
        N0(nVar);
        return this;
    }

    public final boolean isOpen() {
        return true;
    }

    public final String j0() {
        return a0(this.f4787i, c.f5986b);
    }

    public final void k(long j10, long j11, j jVar) {
        xa.j.f("out", jVar);
        w0.b(this.f4787i, j10, j11);
        if (j11 != 0) {
            jVar.f4787i += j11;
            k0 k0Var = this.f4786h;
            while (true) {
                xa.j.c(k0Var);
                long j12 = (long) (k0Var.f4790c - k0Var.f4789b);
                if (j10 < j12) {
                    break;
                }
                j10 -= j12;
                k0Var = k0Var.f4793f;
            }
            while (j11 > 0) {
                xa.j.c(k0Var);
                k0 c10 = k0Var.c();
                int i10 = c10.f4789b + ((int) j10);
                c10.f4789b = i10;
                c10.f4790c = Math.min(i10 + ((int) j11), c10.f4790c);
                k0 k0Var2 = jVar.f4786h;
                if (k0Var2 == null) {
                    c10.f4794g = c10;
                    c10.f4793f = c10;
                    jVar.f4786h = c10;
                } else {
                    k0 k0Var3 = k0Var2.f4794g;
                    xa.j.c(k0Var3);
                    k0Var3.b(c10);
                }
                j11 -= (long) (c10.f4790c - c10.f4789b);
                k0Var = k0Var.f4793f;
                j10 = 0;
            }
        }
    }

    public final /* bridge */ /* synthetic */ k l(long j10) {
        S0(j10);
        return this;
    }

    public final n m() {
        return n(this.f4787i);
    }

    public final n n(long j10) {
        boolean z10;
        if (j10 < 0 || j10 > 2147483647L) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (!z10) {
            throw new IllegalArgumentException(h.k("byteCount: ", j10).toString());
        } else if (this.f4787i < j10) {
            throw new EOFException();
        } else if (j10 < 4096) {
            return new n(Y(j10));
        } else {
            n I0 = I0((int) j10);
            a(j10);
            return I0;
        }
    }

    public final void o0(j jVar, long j10) {
        boolean z10;
        boolean z11;
        int i10;
        k0 k0Var;
        boolean z12;
        k0 k0Var2;
        int i11;
        xa.j.f("source", jVar);
        if (jVar != this) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            w0.b(jVar.f4787i, 0, j10);
            while (j10 > 0) {
                k0 k0Var3 = jVar.f4786h;
                xa.j.c(k0Var3);
                int i12 = k0Var3.f4790c;
                k0 k0Var4 = jVar.f4786h;
                xa.j.c(k0Var4);
                if (j10 < ((long) (i12 - k0Var4.f4789b))) {
                    k0 k0Var5 = this.f4786h;
                    if (k0Var5 != null) {
                        k0Var = k0Var5.f4794g;
                    } else {
                        k0Var = null;
                    }
                    if (k0Var != null && k0Var.f4792e) {
                        long j11 = ((long) k0Var.f4790c) + j10;
                        if (k0Var.f4791d) {
                            i11 = 0;
                        } else {
                            i11 = k0Var.f4789b;
                        }
                        if (j11 - ((long) i11) <= 8192) {
                            k0 k0Var6 = jVar.f4786h;
                            xa.j.c(k0Var6);
                            k0Var6.d(k0Var, (int) j10);
                            jVar.f4787i -= j10;
                            this.f4787i += j10;
                            return;
                        }
                    }
                    k0 k0Var7 = jVar.f4786h;
                    xa.j.c(k0Var7);
                    int i13 = (int) j10;
                    if (i13 <= 0 || i13 > k0Var7.f4790c - k0Var7.f4789b) {
                        z12 = false;
                    } else {
                        z12 = true;
                    }
                    if (z12) {
                        if (i13 >= 1024) {
                            k0Var2 = k0Var7.c();
                        } else {
                            k0Var2 = l0.b();
                            int i14 = k0Var7.f4789b;
                            o.c(0, i14, i14 + i13, k0Var7.f4788a, k0Var2.f4788a);
                        }
                        k0Var2.f4790c = k0Var2.f4789b + i13;
                        k0Var7.f4789b += i13;
                        k0 k0Var8 = k0Var7.f4794g;
                        xa.j.c(k0Var8);
                        k0Var8.b(k0Var2);
                        jVar.f4786h = k0Var2;
                    } else {
                        throw new IllegalArgumentException("byteCount out of range".toString());
                    }
                }
                k0 k0Var9 = jVar.f4786h;
                xa.j.c(k0Var9);
                long j12 = (long) (k0Var9.f4790c - k0Var9.f4789b);
                jVar.f4786h = k0Var9.a();
                k0 k0Var10 = this.f4786h;
                if (k0Var10 == null) {
                    this.f4786h = k0Var9;
                    k0Var9.f4794g = k0Var9;
                    k0Var9.f4793f = k0Var9;
                } else {
                    k0 k0Var11 = k0Var10.f4794g;
                    xa.j.c(k0Var11);
                    k0Var11.b(k0Var9);
                    k0 k0Var12 = k0Var9.f4794g;
                    if (k0Var12 != k0Var9) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    if (z11) {
                        xa.j.c(k0Var12);
                        if (k0Var12.f4792e) {
                            int i15 = k0Var9.f4790c - k0Var9.f4789b;
                            k0 k0Var13 = k0Var9.f4794g;
                            xa.j.c(k0Var13);
                            int i16 = 8192 - k0Var13.f4790c;
                            k0 k0Var14 = k0Var9.f4794g;
                            xa.j.c(k0Var14);
                            if (k0Var14.f4791d) {
                                i10 = 0;
                            } else {
                                k0 k0Var15 = k0Var9.f4794g;
                                xa.j.c(k0Var15);
                                i10 = k0Var15.f4789b;
                            }
                            if (i15 <= i16 + i10) {
                                k0 k0Var16 = k0Var9.f4794g;
                                xa.j.c(k0Var16);
                                k0Var9.d(k0Var16, i15);
                                k0Var9.a();
                                l0.a(k0Var9);
                            }
                        }
                    } else {
                        throw new IllegalStateException("cannot compact".toString());
                    }
                }
                jVar.f4787i -= j12;
                this.f4787i += j12;
                j10 -= j12;
            }
            return;
        }
        throw new IllegalArgumentException("source == this".toString());
    }

    public final k r() {
        return this;
    }

    public final int read(ByteBuffer byteBuffer) {
        xa.j.f("sink", byteBuffer);
        k0 k0Var = this.f4786h;
        if (k0Var == null) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), k0Var.f4790c - k0Var.f4789b);
        byteBuffer.put(k0Var.f4788a, k0Var.f4789b, min);
        int i10 = k0Var.f4789b + min;
        k0Var.f4789b = i10;
        this.f4787i -= (long) min;
        if (i10 == k0Var.f4790c) {
            this.f4786h = k0Var.a();
            l0.a(k0Var);
        }
        return min;
    }

    public final byte readByte() {
        if (this.f4787i != 0) {
            k0 k0Var = this.f4786h;
            xa.j.c(k0Var);
            int i10 = k0Var.f4789b;
            int i11 = k0Var.f4790c;
            int i12 = i10 + 1;
            byte b10 = k0Var.f4788a[i10];
            this.f4787i--;
            if (i12 == i11) {
                this.f4786h = k0Var.a();
                l0.a(k0Var);
            } else {
                k0Var.f4789b = i12;
            }
            return b10;
        }
        throw new EOFException();
    }

    public final void readFully(byte[] bArr) {
        int i10 = 0;
        while (i10 < bArr.length) {
            int N = N(bArr, i10, bArr.length - i10);
            if (N != -1) {
                i10 += N;
            } else {
                throw new EOFException();
            }
        }
    }

    public final int readInt() {
        if (this.f4787i >= 4) {
            k0 k0Var = this.f4786h;
            xa.j.c(k0Var);
            int i10 = k0Var.f4789b;
            int i11 = k0Var.f4790c;
            if (((long) (i11 - i10)) < 4) {
                return ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8) | (readByte() & 255);
            }
            int i12 = i10 + 1;
            byte[] bArr = k0Var.f4788a;
            int i13 = i12 + 1;
            byte b10 = ((bArr[i10] & 255) << 24) | ((bArr[i12] & 255) << 16);
            int i14 = i13 + 1;
            byte b11 = b10 | ((bArr[i13] & 255) << 8);
            int i15 = i14 + 1;
            byte b12 = b11 | (bArr[i14] & 255);
            this.f4787i -= 4;
            if (i15 == i11) {
                this.f4786h = k0Var.a();
                l0.a(k0Var);
            } else {
                k0Var.f4789b = i15;
            }
            return b12;
        }
        throw new EOFException();
    }

    public final long readLong() {
        if (this.f4787i >= 8) {
            k0 k0Var = this.f4786h;
            xa.j.c(k0Var);
            int i10 = k0Var.f4789b;
            int i11 = k0Var.f4790c;
            if (((long) (i11 - i10)) < 8) {
                return ((((long) readInt()) & 4294967295L) << 32) | (4294967295L & ((long) readInt()));
            }
            int i12 = i10 + 1;
            byte[] bArr = k0Var.f4788a;
            int i13 = i12 + 1;
            int i14 = i13 + 1;
            int i15 = i14 + 1;
            int i16 = i15 + 1;
            int i17 = i16 + 1;
            int i18 = i17 + 1;
            int i19 = i18 + 1;
            long j10 = (((long) bArr[i18]) & 255) | ((((long) bArr[i10]) & 255) << 56) | ((((long) bArr[i12]) & 255) << 48) | ((((long) bArr[i13]) & 255) << 40) | ((((long) bArr[i14]) & 255) << 32) | ((((long) bArr[i15]) & 255) << 24) | ((((long) bArr[i16]) & 255) << 16) | ((((long) bArr[i17]) & 255) << 8);
            this.f4787i -= 8;
            if (i19 == i11) {
                this.f4786h = k0Var.a();
                l0.a(k0Var);
            } else {
                k0Var.f4789b = i19;
            }
            return j10;
        }
        throw new EOFException();
    }

    public final short readShort() {
        if (this.f4787i >= 2) {
            k0 k0Var = this.f4786h;
            xa.j.c(k0Var);
            int i10 = k0Var.f4789b;
            int i11 = k0Var.f4790c;
            if (i11 - i10 < 2) {
                return (short) (((readByte() & 255) << 8) | (readByte() & 255));
            }
            int i12 = i10 + 1;
            byte[] bArr = k0Var.f4788a;
            int i13 = i12 + 1;
            byte b10 = ((bArr[i10] & 255) << 8) | (bArr[i12] & 255);
            this.f4787i -= 2;
            if (i13 == i11) {
                this.f4786h = k0Var.a();
                l0.a(k0Var);
            } else {
                k0Var.f4789b = i13;
            }
            return (short) b10;
        }
        throw new EOFException();
    }

    public final /* bridge */ /* synthetic */ k s(int i10) {
        U0(i10);
        return this;
    }

    public final boolean t(long j10) {
        return this.f4787i >= j10;
    }

    public final s0 timeout() {
        return s0.f4821d;
    }

    public final String toString() {
        boolean z10;
        long j10 = this.f4787i;
        if (j10 <= 2147483647L) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            return I0((int) j10).toString();
        }
        throw new IllegalStateException(("size > Int.MAX_VALUE: " + this.f4787i).toString());
    }

    public final void u0(long j10) {
        if (this.f4787i < j10) {
            throw new EOFException();
        }
    }

    public final byte v(long j10) {
        w0.b(this.f4787i, j10, 1);
        k0 k0Var = this.f4786h;
        if (k0Var != null) {
            long j11 = this.f4787i;
            if (j11 - j10 < j10) {
                while (j11 > j10) {
                    k0Var = k0Var.f4794g;
                    xa.j.c(k0Var);
                    j11 -= (long) (k0Var.f4790c - k0Var.f4789b);
                }
                return k0Var.f4788a[(int) ((((long) k0Var.f4789b) + j10) - j11)];
            }
            long j12 = 0;
            while (true) {
                int i10 = k0Var.f4790c;
                int i11 = k0Var.f4789b;
                long j13 = ((long) (i10 - i11)) + j12;
                if (j13 <= j10) {
                    k0Var = k0Var.f4793f;
                    xa.j.c(k0Var);
                    j12 = j13;
                } else {
                    return k0Var.f4788a[(int) ((((long) i11) + j10) - j12)];
                }
            }
        } else {
            xa.j.c((Object) null);
            throw null;
        }
    }

    public final /* bridge */ /* synthetic */ k v0(String str) {
        X0(str);
        return this;
    }

    public final long w(byte b10, long j10, long j11) {
        k0 k0Var;
        boolean z10 = false;
        long j12 = 0;
        if (0 <= j10 && j10 <= j11) {
            z10 = true;
        }
        if (z10) {
            long j13 = this.f4787i;
            if (j11 > j13) {
                j11 = j13;
            }
            if (j10 == j11 || (k0Var = this.f4786h) == null) {
                return -1;
            }
            if (j13 - j10 < j10) {
                while (j13 > j10) {
                    k0Var = k0Var.f4794g;
                    xa.j.c(k0Var);
                    j13 -= (long) (k0Var.f4790c - k0Var.f4789b);
                }
                while (j13 < j11) {
                    int min = (int) Math.min((long) k0Var.f4790c, (((long) k0Var.f4789b) + j11) - j13);
                    for (int i10 = (int) ((((long) k0Var.f4789b) + j10) - j13); i10 < min; i10++) {
                        if (k0Var.f4788a[i10] == b10) {
                            return ((long) (i10 - k0Var.f4789b)) + j13;
                        }
                    }
                    j13 += (long) (k0Var.f4790c - k0Var.f4789b);
                    k0Var = k0Var.f4793f;
                    xa.j.c(k0Var);
                    j10 = j13;
                }
                return -1;
            }
            while (true) {
                long j14 = ((long) (k0Var.f4790c - k0Var.f4789b)) + j12;
                if (j14 > j10) {
                    break;
                }
                k0Var = k0Var.f4793f;
                xa.j.c(k0Var);
                j12 = j14;
            }
            while (j12 < j11) {
                int min2 = (int) Math.min((long) k0Var.f4790c, (((long) k0Var.f4789b) + j11) - j12);
                for (int i11 = (int) ((((long) k0Var.f4789b) + j10) - j12); i11 < min2; i11++) {
                    if (k0Var.f4788a[i11] == b10) {
                        return ((long) (i11 - k0Var.f4789b)) + j12;
                    }
                }
                j12 += (long) (k0Var.f4790c - k0Var.f4789b);
                k0Var = k0Var.f4793f;
                xa.j.c(k0Var);
                j10 = j12;
            }
            return -1;
        }
        throw new IllegalArgumentException(("size=" + this.f4787i + " fromIndex=" + j10 + " toIndex=" + j11).toString());
    }

    public final int write(ByteBuffer byteBuffer) {
        xa.j.f("source", byteBuffer);
        int remaining = byteBuffer.remaining();
        int i10 = remaining;
        while (i10 > 0) {
            k0 M0 = M0(1);
            int min = Math.min(i10, 8192 - M0.f4790c);
            byteBuffer.get(M0.f4788a, M0.f4790c, min);
            i10 -= min;
            M0.f4790c += min;
        }
        this.f4787i += (long) remaining;
        return remaining;
    }

    public final long z(n nVar) {
        int i10;
        long j10;
        xa.j.f("targetBytes", nVar);
        k0 k0Var = this.f4786h;
        if (k0Var != null) {
            long j11 = this.f4787i;
            long j12 = 0;
            byte[] bArr = nVar.f4804h;
            if (j11 - 0 < 0) {
                while (j11 > 0) {
                    k0Var = k0Var.f4794g;
                    xa.j.c(k0Var);
                    j11 -= (long) (k0Var.f4790c - k0Var.f4789b);
                }
                if (bArr.length == 2) {
                    byte b10 = bArr[0];
                    byte b11 = bArr[1];
                    while (j10 < this.f4787i) {
                        i10 = (int) ((((long) k0Var.f4789b) + j12) - j10);
                        int i11 = k0Var.f4790c;
                        while (i10 < i11) {
                            byte b12 = k0Var.f4788a[i10];
                            if (!(b12 == b10 || b12 == b11)) {
                                i10++;
                            }
                        }
                        j12 = ((long) (k0Var.f4790c - k0Var.f4789b)) + j10;
                        k0Var = k0Var.f4793f;
                        xa.j.c(k0Var);
                        j11 = j12;
                    }
                } else {
                    while (j10 < this.f4787i) {
                        int i12 = (int) ((((long) k0Var.f4789b) + j12) - j10);
                        int i13 = k0Var.f4790c;
                        while (i10 < i13) {
                            byte b13 = k0Var.f4788a[i10];
                            int length = bArr.length;
                            int i14 = 0;
                            while (i14 < length) {
                                if (b13 != bArr[i14]) {
                                    i14++;
                                }
                            }
                            i12 = i10 + 1;
                        }
                        j12 = ((long) (k0Var.f4790c - k0Var.f4789b)) + j10;
                        k0Var = k0Var.f4793f;
                        xa.j.c(k0Var);
                        j11 = j12;
                    }
                }
            } else {
                j10 = 0;
                while (true) {
                    long j13 = ((long) (k0Var.f4790c - k0Var.f4789b)) + j10;
                    if (j13 > 0) {
                        break;
                    }
                    k0Var = k0Var.f4793f;
                    xa.j.c(k0Var);
                    j10 = j13;
                }
                if (bArr.length == 2) {
                    byte b14 = bArr[0];
                    byte b15 = bArr[1];
                    while (j10 < this.f4787i) {
                        int i15 = (int) ((((long) k0Var.f4789b) + j12) - j10);
                        int i16 = k0Var.f4790c;
                        while (i10 < i16) {
                            byte b16 = k0Var.f4788a[i10];
                            if (!(b16 == b14 || b16 == b15)) {
                                i15 = i10 + 1;
                            }
                        }
                        j12 = ((long) (k0Var.f4790c - k0Var.f4789b)) + j10;
                        k0Var = k0Var.f4793f;
                        xa.j.c(k0Var);
                        j10 = j12;
                    }
                } else {
                    while (j10 < this.f4787i) {
                        int i17 = (int) ((((long) k0Var.f4789b) + j12) - j10);
                        int i18 = k0Var.f4790c;
                        while (i10 < i18) {
                            byte b17 = k0Var.f4788a[i10];
                            int length2 = bArr.length;
                            int i19 = 0;
                            while (i19 < length2) {
                                if (b17 != bArr[i19]) {
                                    i19++;
                                }
                            }
                            i17 = i10 + 1;
                        }
                        j12 = ((long) (k0Var.f4790c - k0Var.f4789b)) + j10;
                        k0Var = k0Var.f4793f;
                        xa.j.c(k0Var);
                        j10 = j12;
                    }
                }
            }
            return ((long) (i10 - k0Var.f4789b)) + j10;
        }
        return -1;
    }

    public final long read(j jVar, long j10) {
        xa.j.f("sink", jVar);
        if (j10 >= 0) {
            long j11 = this.f4787i;
            if (j11 == 0) {
                return -1;
            }
            if (j10 > j11) {
                j10 = j11;
            }
            jVar.o0(this, j10);
            return j10;
        }
        throw new IllegalArgumentException(h.k("byteCount < 0: ", j10).toString());
    }
}
