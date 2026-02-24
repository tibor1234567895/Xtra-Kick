package f3;

import d2.w0;
import d2.x0;
import d2.y;
import g1.a0;
import g1.z;
import j1.b0;
import java.util.Collections;
import java.util.List;

public final class j implements k {

    /* renamed from: a  reason: collision with root package name */
    public final List f5621a;

    /* renamed from: b  reason: collision with root package name */
    public final x0[] f5622b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f5623c;

    /* renamed from: d  reason: collision with root package name */
    public int f5624d;

    /* renamed from: e  reason: collision with root package name */
    public int f5625e;

    /* renamed from: f  reason: collision with root package name */
    public long f5626f = -9223372036854775807L;

    public j(List list) {
        this.f5621a = list;
        this.f5622b = new x0[list.size()];
    }

    public final void a() {
        this.f5623c = false;
        this.f5626f = -9223372036854775807L;
    }

    public final void c(b0 b0Var) {
        boolean z10;
        boolean z11;
        if (this.f5623c) {
            if (this.f5624d == 2) {
                if (b0Var.f8416c - b0Var.f8415b == 0) {
                    z11 = false;
                } else {
                    if (b0Var.v() != 32) {
                        this.f5623c = false;
                    }
                    this.f5624d--;
                    z11 = this.f5623c;
                }
                if (!z11) {
                    return;
                }
            }
            if (this.f5624d == 1) {
                if (b0Var.f8416c - b0Var.f8415b == 0) {
                    z10 = false;
                } else {
                    if (b0Var.v() != 0) {
                        this.f5623c = false;
                    }
                    this.f5624d--;
                    z10 = this.f5623c;
                }
                if (!z10) {
                    return;
                }
            }
            int i10 = b0Var.f8415b;
            int i11 = b0Var.f8416c - i10;
            for (x0 d10 : this.f5622b) {
                b0Var.G(i10);
                d10.d(i11, b0Var);
            }
            this.f5625e += i11;
        }
    }

    public final void d(y yVar, j0 j0Var) {
        int i10 = 0;
        while (true) {
            x0[] x0VarArr = this.f5622b;
            if (i10 < x0VarArr.length) {
                i0 i0Var = (i0) this.f5621a.get(i10);
                j0Var.a();
                j0Var.b();
                x0 d10 = yVar.d(j0Var.f5630d, 3);
                z zVar = new z();
                j0Var.b();
                zVar.f6744a = j0Var.f5631e;
                zVar.f6754k = "application/dvbsubs";
                zVar.f6756m = Collections.singletonList(i0Var.f5620b);
                zVar.f6746c = i0Var.f5619a;
                d10.a(new a0(zVar));
                x0VarArr[i10] = d10;
                i10++;
            } else {
                return;
            }
        }
    }

    public final void e(int i10, long j10) {
        if ((i10 & 4) != 0) {
            this.f5623c = true;
            if (j10 != -9223372036854775807L) {
                this.f5626f = j10;
            }
            this.f5625e = 0;
            this.f5624d = 2;
        }
    }

    public final void f() {
        if (this.f5623c) {
            if (this.f5626f != -9223372036854775807L) {
                for (x0 e10 : this.f5622b) {
                    e10.e(this.f5626f, 1, this.f5625e, 0, (w0) null);
                }
            }
            this.f5623c = false;
        }
    }
}
