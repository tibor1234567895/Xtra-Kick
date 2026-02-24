package f3;

import d2.k0;
import d2.w0;
import d2.x0;
import d2.y;
import g1.a0;
import g1.z;
import j1.a;
import j1.b0;

public final class x implements k {

    /* renamed from: a  reason: collision with root package name */
    public final b0 f5785a;

    /* renamed from: b  reason: collision with root package name */
    public final k0 f5786b;

    /* renamed from: c  reason: collision with root package name */
    public final String f5787c;

    /* renamed from: d  reason: collision with root package name */
    public x0 f5788d;

    /* renamed from: e  reason: collision with root package name */
    public String f5789e;

    /* renamed from: f  reason: collision with root package name */
    public int f5790f;

    /* renamed from: g  reason: collision with root package name */
    public int f5791g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f5792h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f5793i;

    /* renamed from: j  reason: collision with root package name */
    public long f5794j;

    /* renamed from: k  reason: collision with root package name */
    public int f5795k;

    /* renamed from: l  reason: collision with root package name */
    public long f5796l;

    public x() {
        this((String) null);
    }

    public final void a() {
        this.f5790f = 0;
        this.f5791g = 0;
        this.f5793i = false;
        this.f5796l = -9223372036854775807L;
    }

    public final void c(b0 b0Var) {
        boolean z10;
        boolean z11;
        a.f(this.f5788d);
        while (true) {
            int i10 = b0Var.f8416c;
            int i11 = b0Var.f8415b;
            int i12 = i10 - i11;
            if (i12 > 0) {
                int i13 = this.f5790f;
                b0 b0Var2 = this.f5785a;
                if (i13 == 0) {
                    byte[] bArr = b0Var.f8414a;
                    while (true) {
                        if (i11 >= i10) {
                            b0Var.G(i10);
                            break;
                        }
                        byte b10 = bArr[i11];
                        if ((b10 & 255) == 255) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        if (!this.f5793i || (b10 & 224) != 224) {
                            z11 = false;
                        } else {
                            z11 = true;
                        }
                        this.f5793i = z10;
                        if (z11) {
                            b0Var.G(i11 + 1);
                            this.f5793i = false;
                            b0Var2.f8414a[1] = bArr[i11];
                            this.f5791g = 2;
                            this.f5790f = 1;
                            break;
                        }
                        i11++;
                    }
                } else if (i13 == 1) {
                    int min = Math.min(i12, 4 - this.f5791g);
                    b0Var.d(b0Var2.f8414a, this.f5791g, min);
                    int i14 = this.f5791g + min;
                    this.f5791g = i14;
                    if (i14 >= 4) {
                        b0Var2.G(0);
                        int f10 = b0Var2.f();
                        k0 k0Var = this.f5786b;
                        if (!k0Var.a(f10)) {
                            this.f5791g = 0;
                            this.f5790f = 1;
                        } else {
                            this.f5795k = k0Var.f4214c;
                            if (!this.f5792h) {
                                this.f5794j = (((long) k0Var.f4218g) * 1000000) / ((long) k0Var.f4215d);
                                z zVar = new z();
                                zVar.f6744a = this.f5789e;
                                zVar.f6754k = k0Var.f4213b;
                                zVar.f6755l = 4096;
                                zVar.f6767x = k0Var.f4216e;
                                zVar.f6768y = k0Var.f4215d;
                                zVar.f6746c = this.f5787c;
                                this.f5788d.a(new a0(zVar));
                                this.f5792h = true;
                            }
                            b0Var2.G(0);
                            this.f5788d.d(4, b0Var2);
                            this.f5790f = 2;
                        }
                    }
                } else if (i13 == 2) {
                    int min2 = Math.min(i12, this.f5795k - this.f5791g);
                    this.f5788d.d(min2, b0Var);
                    int i15 = this.f5791g + min2;
                    this.f5791g = i15;
                    int i16 = this.f5795k;
                    if (i15 >= i16) {
                        long j10 = this.f5796l;
                        if (j10 != -9223372036854775807L) {
                            this.f5788d.e(j10, 1, i16, 0, (w0) null);
                            this.f5796l += this.f5794j;
                        }
                        this.f5791g = 0;
                        this.f5790f = 0;
                    }
                } else {
                    throw new IllegalStateException();
                }
            } else {
                return;
            }
        }
    }

    public final void d(y yVar, j0 j0Var) {
        j0Var.a();
        j0Var.b();
        this.f5789e = j0Var.f5631e;
        j0Var.b();
        this.f5788d = yVar.d(j0Var.f5630d, 1);
    }

    public final void e(int i10, long j10) {
        if (j10 != -9223372036854775807L) {
            this.f5796l = j10;
        }
    }

    public final void f() {
    }

    public x(String str) {
        this.f5790f = 0;
        b0 b0Var = new b0(4);
        this.f5785a = b0Var;
        b0Var.f8414a[0] = -1;
        this.f5786b = new k0();
        this.f5796l = -9223372036854775807L;
        this.f5787c = str;
    }
}
