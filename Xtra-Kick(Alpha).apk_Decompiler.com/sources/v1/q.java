package v1;

import android.net.Uri;
import d2.w0;
import j1.a;
import j1.b0;
import java.util.Map;
import k1.e0;
import k1.f0;
import k1.h;
import k1.m;

public final class q implements h {

    /* renamed from: a  reason: collision with root package name */
    public final h f15749a;

    /* renamed from: b  reason: collision with root package name */
    public final int f15750b;

    /* renamed from: c  reason: collision with root package name */
    public final n0 f15751c;

    /* renamed from: d  reason: collision with root package name */
    public final byte[] f15752d;

    /* renamed from: e  reason: collision with root package name */
    public int f15753e;

    public q(e0 e0Var, int i10, n0 n0Var) {
        a.b(i10 > 0);
        this.f15749a = e0Var;
        this.f15750b = i10;
        this.f15751c = n0Var;
        this.f15752d = new byte[1];
        this.f15753e = i10;
    }

    public final void close() {
        throw new UnsupportedOperationException();
    }

    public final Map e() {
        return this.f15749a.e();
    }

    public final void i(f0 f0Var) {
        f0Var.getClass();
        this.f15749a.i(f0Var);
    }

    public final Uri j() {
        return this.f15749a.j();
    }

    public final int o(byte[] bArr, int i10, int i11) {
        long j10;
        int i12 = this.f15753e;
        h hVar = this.f15749a;
        if (i12 == 0) {
            byte[] bArr2 = this.f15752d;
            boolean z10 = false;
            if (hVar.o(bArr2, 0, 1) != -1) {
                int i13 = (bArr2[0] & 255) << 4;
                if (i13 != 0) {
                    byte[] bArr3 = new byte[i13];
                    int i14 = i13;
                    int i15 = 0;
                    while (true) {
                        if (i14 <= 0) {
                            while (i13 > 0) {
                                int i16 = i13 - 1;
                                if (bArr3[i16] != 0) {
                                    break;
                                }
                                i13 = i16;
                            }
                            if (i13 > 0) {
                                b0 b0Var = new b0(i13, bArr3);
                                n0 n0Var = this.f15751c;
                                if (!n0Var.f15742l) {
                                    j10 = n0Var.f15739i;
                                } else {
                                    j10 = Math.max(n0Var.f15743m.r(true), n0Var.f15739i);
                                }
                                int i17 = b0Var.f8416c - b0Var.f8415b;
                                a1 a1Var = n0Var.f15741k;
                                a1Var.getClass();
                                a1Var.b(i17, b0Var);
                                a1Var.e(j10, 1, i17, 0, (w0) null);
                                n0Var.f15742l = true;
                            }
                        } else {
                            int o10 = hVar.o(bArr3, i15, i14);
                            if (o10 == -1) {
                                break;
                            }
                            i15 += o10;
                            i14 -= o10;
                        }
                    }
                }
                z10 = true;
            }
            if (!z10) {
                return -1;
            }
            this.f15753e = this.f15750b;
        }
        int o11 = hVar.o(bArr, i10, Math.min(this.f15753e, i11));
        if (o11 != -1) {
            this.f15753e -= o11;
        }
        return o11;
    }

    public final long q(m mVar) {
        throw new UnsupportedOperationException();
    }
}
