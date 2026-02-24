package dc;

import android.support.v4.media.h;
import hb.h0;
import java.security.MessageDigest;
import java.util.Arrays;
import ma.m;
import ma.o;
import xa.j;

public final class m0 extends n {

    /* renamed from: m  reason: collision with root package name */
    public final transient byte[][] f4800m;

    /* renamed from: n  reason: collision with root package name */
    public final transient int[] f4801n;

    public m0(byte[][] bArr, int[] iArr) {
        super(n.f4803l.f4804h);
        this.f4800m = bArr;
        this.f4801n = iArr;
    }

    public final String a() {
        return t().a();
    }

    public final n c(String str) {
        MessageDigest instance = MessageDigest.getInstance(str);
        byte[][] bArr = this.f4800m;
        int length = bArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            int[] iArr = this.f4801n;
            int i12 = iArr[length + i10];
            int i13 = iArr[i10];
            instance.update(bArr[i10], i12, i13 - i11);
            i10++;
            i11 = i13;
        }
        byte[] digest = instance.digest();
        j.e("digestBytes", digest);
        return new n(digest);
    }

    public final int d() {
        return this.f4801n[this.f4800m.length - 1];
    }

    public final String e() {
        return t().e();
    }

    public final boolean equals(Object obj) {
        if (obj != this) {
            if (!(obj instanceof n)) {
                return false;
            }
            n nVar = (n) obj;
            if (nVar.d() != d() || !m(0, nVar, d())) {
                return false;
            }
        }
        return true;
    }

    public final int f(int i10, byte[] bArr) {
        j.f("other", bArr);
        return t().f(i10, bArr);
    }

    public final byte[] h() {
        return s();
    }

    public final int hashCode() {
        int i10 = this.f4805i;
        if (i10 != 0) {
            return i10;
        }
        byte[][] bArr = this.f4800m;
        int length = bArr.length;
        int i11 = 0;
        int i12 = 1;
        int i13 = 0;
        while (i11 < length) {
            int[] iArr = this.f4801n;
            int i14 = iArr[length + i11];
            int i15 = iArr[i11];
            byte[] bArr2 = bArr[i11];
            int i16 = (i15 - i13) + i14;
            while (i14 < i16) {
                i12 = (i12 * 31) + bArr2[i14];
                i14++;
            }
            i11++;
            i13 = i15;
        }
        this.f4805i = i12;
        return i12;
    }

    public final byte i(int i10) {
        byte[][] bArr = this.f4800m;
        int[] iArr = this.f4801n;
        w0.b((long) iArr[bArr.length - 1], (long) i10, 1);
        int z12 = h0.z1(this, i10);
        return bArr[z12][(i10 - (z12 == 0 ? 0 : iArr[z12 - 1])) + iArr[bArr.length + z12]];
    }

    public final int j(int i10, byte[] bArr) {
        j.f("other", bArr);
        return t().j(i10, bArr);
    }

    public final boolean l(int i10, int i11, int i12, byte[] bArr) {
        int i13;
        j.f("other", bArr);
        if (i10 < 0 || i10 > d() - i12 || i11 < 0 || i11 > bArr.length - i12) {
            return false;
        }
        int i14 = i12 + i10;
        int z12 = h0.z1(this, i10);
        while (i10 < i14) {
            int[] iArr = this.f4801n;
            if (z12 == 0) {
                i13 = 0;
            } else {
                i13 = iArr[z12 - 1];
            }
            byte[][] bArr2 = this.f4800m;
            int i15 = iArr[bArr2.length + z12];
            int min = Math.min(i14, (iArr[z12] - i13) + i13) - i10;
            if (!w0.a((i10 - i13) + i15, i11, min, bArr2[z12], bArr)) {
                return false;
            }
            i11 += min;
            i10 += min;
            z12++;
        }
        return true;
    }

    public final boolean m(int i10, n nVar, int i11) {
        int i12;
        j.f("other", nVar);
        if (i10 < 0 || i10 > d() - i11) {
            return false;
        }
        int i13 = i11 + i10;
        int z12 = h0.z1(this, i10);
        int i14 = 0;
        while (i10 < i13) {
            int[] iArr = this.f4801n;
            if (z12 == 0) {
                i12 = 0;
            } else {
                i12 = iArr[z12 - 1];
            }
            byte[][] bArr = this.f4800m;
            int i15 = iArr[bArr.length + z12];
            int min = Math.min(i13, (iArr[z12] - i12) + i12) - i10;
            if (!nVar.l(i14, (i10 - i12) + i15, min, bArr[z12])) {
                return false;
            }
            i14 += min;
            i10 += min;
            z12++;
        }
        return true;
    }

    public final n n(int i10, int i11) {
        boolean z10;
        boolean z11;
        boolean z12;
        int c10 = w0.c(i11, this);
        int i12 = 0;
        if (i10 >= 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            if (c10 <= d()) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                int i13 = c10 - i10;
                if (i13 >= 0) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                if (!z12) {
                    throw new IllegalArgumentException(("endIndex=" + c10 + " < beginIndex=" + i10).toString());
                } else if (i10 == 0 && c10 == d()) {
                    return this;
                } else {
                    if (i10 == c10) {
                        return n.f4803l;
                    }
                    int z13 = h0.z1(this, i10);
                    int z14 = h0.z1(this, c10 - 1);
                    int i14 = z14 + 1;
                    byte[][] bArr = this.f4800m;
                    j.f("<this>", bArr);
                    m.a(i14, bArr.length);
                    Object[] copyOfRange = Arrays.copyOfRange(bArr, z13, i14);
                    j.e("copyOfRange(this, fromIndex, toIndex)", copyOfRange);
                    byte[][] bArr2 = (byte[][]) copyOfRange;
                    int[] iArr = new int[(bArr2.length * 2)];
                    int[] iArr2 = this.f4801n;
                    if (z13 <= z14) {
                        int i15 = 0;
                        int i16 = z13;
                        while (true) {
                            iArr[i15] = Math.min(iArr2[i16] - i10, i13);
                            int i17 = i15 + 1;
                            iArr[i15 + bArr2.length] = iArr2[bArr.length + i16];
                            if (i16 == z14) {
                                break;
                            }
                            i16++;
                            i15 = i17;
                        }
                    }
                    if (z13 != 0) {
                        i12 = iArr2[z13 - 1];
                    }
                    int length = bArr2.length;
                    iArr[length] = (i10 - i12) + iArr[length];
                    return new m0(bArr2, iArr);
                }
            } else {
                StringBuilder r10 = h.r("endIndex=", c10, " > length(");
                r10.append(d());
                r10.append(')');
                throw new IllegalArgumentException(r10.toString().toString());
            }
        } else {
            throw new IllegalArgumentException(h.j("beginIndex=", i10, " < 0").toString());
        }
    }

    public final n p() {
        return t().p();
    }

    public final void r(j jVar, int i10) {
        int i11;
        j jVar2 = jVar;
        int i12 = i10;
        j.f("buffer", jVar2);
        int i13 = 0 + i12;
        int z12 = h0.z1(this, 0);
        int i14 = 0;
        while (i14 < i13) {
            int[] iArr = this.f4801n;
            if (z12 == 0) {
                i11 = 0;
            } else {
                i11 = iArr[z12 - 1];
            }
            byte[][] bArr = this.f4800m;
            int i15 = iArr[bArr.length + z12];
            int min = Math.min(i13, (iArr[z12] - i11) + i11) - i14;
            int i16 = (i14 - i11) + i15;
            k0 k0Var = new k0(bArr[z12], i16, i16 + min, true, false);
            k0 k0Var2 = jVar2.f4786h;
            if (k0Var2 == null) {
                k0Var.f4794g = k0Var;
                k0Var.f4793f = k0Var;
                jVar2.f4786h = k0Var;
            } else {
                k0 k0Var3 = k0Var2.f4794g;
                j.c(k0Var3);
                k0Var3.b(k0Var);
            }
            i14 += min;
            z12++;
        }
        jVar2.f4787i += (long) i12;
    }

    public final byte[] s() {
        byte[] bArr = new byte[d()];
        byte[][] bArr2 = this.f4800m;
        int length = bArr2.length;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        while (i10 < length) {
            int[] iArr = this.f4801n;
            int i13 = iArr[length + i10];
            int i14 = iArr[i10];
            int i15 = i14 - i11;
            o.c(i12, i13, i13 + i15, bArr2[i10], bArr);
            i12 += i15;
            i10++;
            i11 = i14;
        }
        return bArr;
    }

    public final n t() {
        return new n(s());
    }

    public final String toString() {
        return t().toString();
    }
}
