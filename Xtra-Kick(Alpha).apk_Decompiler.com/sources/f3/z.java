package f3;

import android.support.v4.media.h;
import d2.y;
import j1.a;
import j1.a0;
import j1.b0;
import j1.h0;
import j1.v;

public final class z implements k0 {

    /* renamed from: a  reason: collision with root package name */
    public final k f5802a;

    /* renamed from: b  reason: collision with root package name */
    public final a0 f5803b = new a0(10, new byte[10]);

    /* renamed from: c  reason: collision with root package name */
    public int f5804c = 0;

    /* renamed from: d  reason: collision with root package name */
    public int f5805d;

    /* renamed from: e  reason: collision with root package name */
    public h0 f5806e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f5807f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f5808g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f5809h;

    /* renamed from: i  reason: collision with root package name */
    public int f5810i;

    /* renamed from: j  reason: collision with root package name */
    public int f5811j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f5812k;

    /* renamed from: l  reason: collision with root package name */
    public long f5813l;

    public z(k kVar) {
        this.f5802a = kVar;
    }

    public final void a() {
        this.f5804c = 0;
        this.f5805d = 0;
        this.f5809h = false;
        this.f5802a.a();
    }

    public final void b(h0 h0Var, y yVar, j0 j0Var) {
        this.f5806e = h0Var;
        this.f5802a.d(yVar, j0Var);
    }

    public final void c(int i10, b0 b0Var) {
        boolean z10;
        int i11;
        int i12;
        int i13;
        b0 b0Var2 = b0Var;
        a.f(this.f5806e);
        int i14 = i10 & 1;
        k kVar = this.f5802a;
        int i15 = -1;
        int i16 = 3;
        int i17 = 2;
        if (i14 != 0) {
            int i18 = this.f5804c;
            if (!(i18 == 0 || i18 == 1)) {
                if (i18 == 2) {
                    v.g("PesReader", "Unexpected start indicator reading extended header");
                } else if (i18 == 3) {
                    if (this.f5811j != -1) {
                        v.g("PesReader", "Unexpected start indicator: expected " + this.f5811j + " more bytes");
                    }
                    kVar.f();
                } else {
                    throw new IllegalStateException();
                }
            }
            this.f5804c = 1;
            this.f5805d = 0;
        }
        int i19 = i10;
        while (true) {
            int i20 = b0Var2.f8416c;
            int i21 = b0Var2.f8415b;
            int i22 = i20 - i21;
            if (i22 > 0) {
                int i23 = this.f5804c;
                if (i23 != 0) {
                    a0 a0Var = this.f5803b;
                    if (i23 != 1) {
                        if (i23 != i17) {
                            if (i23 == i16) {
                                int i24 = this.f5811j;
                                if (i24 == i15) {
                                    i13 = 0;
                                } else {
                                    i13 = i22 - i24;
                                }
                                if (i13 > 0) {
                                    i22 -= i13;
                                    b0Var2.F(i21 + i22);
                                }
                                kVar.c(b0Var2);
                                int i25 = this.f5811j;
                                if (i25 != i15) {
                                    int i26 = i25 - i22;
                                    this.f5811j = i26;
                                    if (i26 == 0) {
                                        kVar.f();
                                        this.f5804c = 1;
                                    }
                                }
                            } else {
                                throw new IllegalStateException();
                            }
                        } else if (d(Math.min(10, this.f5810i), b0Var2, a0Var.f8405a) && d(this.f5810i, b0Var2, (byte[]) null)) {
                            a0Var.k(0);
                            this.f5813l = -9223372036854775807L;
                            if (this.f5807f) {
                                a0Var.m(4);
                                a0Var.m(1);
                                a0Var.m(1);
                                long g10 = (((long) a0Var.g(i16)) << 30) | ((long) (a0Var.g(15) << 15)) | ((long) a0Var.g(15));
                                a0Var.m(1);
                                if (!this.f5809h && this.f5808g) {
                                    a0Var.m(4);
                                    a0Var.m(1);
                                    long g11 = (long) (a0Var.g(15) << 15);
                                    a0Var.m(1);
                                    long g12 = g11 | (((long) a0Var.g(3)) << 30) | ((long) a0Var.g(15));
                                    a0Var.m(1);
                                    this.f5806e.b(g12);
                                    this.f5809h = true;
                                }
                                this.f5813l = this.f5806e.b(g10);
                            }
                            if (this.f5812k) {
                                i12 = 4;
                            } else {
                                i12 = 0;
                            }
                            i19 |= i12;
                            kVar.e(i19, this.f5813l);
                            i11 = 3;
                            this.f5804c = i11;
                        }
                    } else if (d(9, b0Var2, a0Var.f8405a)) {
                        a0Var.k(0);
                        int g13 = a0Var.g(24);
                        if (g13 != 1) {
                            h.z("Unexpected start code prefix: ", g13, "PesReader");
                            this.f5811j = -1;
                            z10 = false;
                        } else {
                            a0Var.m(8);
                            int g14 = a0Var.g(16);
                            a0Var.m(5);
                            this.f5812k = a0Var.f();
                            a0Var.m(2);
                            this.f5807f = a0Var.f();
                            this.f5808g = a0Var.f();
                            a0Var.m(6);
                            int g15 = a0Var.g(8);
                            this.f5810i = g15;
                            if (g14 != 0) {
                                int i27 = ((g14 + 6) - 9) - g15;
                                this.f5811j = i27;
                                if (i27 < 0) {
                                    v.g("PesReader", "Found negative packet payload size: " + this.f5811j);
                                }
                                z10 = true;
                            }
                            this.f5811j = -1;
                            z10 = true;
                        }
                        if (z10) {
                            i11 = 2;
                        } else {
                            i11 = 0;
                        }
                        this.f5804c = i11;
                    }
                    this.f5805d = 0;
                } else {
                    b0Var2.H(i22);
                }
                i15 = -1;
                i16 = 3;
                i17 = 2;
            } else {
                return;
            }
        }
    }

    public final boolean d(int i10, b0 b0Var, byte[] bArr) {
        int min = Math.min(b0Var.f8416c - b0Var.f8415b, i10 - this.f5805d);
        if (min <= 0) {
            return true;
        }
        if (bArr == null) {
            b0Var.H(min);
        } else {
            b0Var.d(bArr, this.f5805d, min);
        }
        int i11 = this.f5805d + min;
        this.f5805d = i11;
        if (i11 == i10) {
            return true;
        }
        return false;
    }
}
