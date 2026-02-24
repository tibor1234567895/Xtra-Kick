package v2;

import d2.w;
import g1.b1;
import j1.a;
import j1.b0;
import java.io.EOFException;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    public int f15864a;

    /* renamed from: b  reason: collision with root package name */
    public long f15865b;

    /* renamed from: c  reason: collision with root package name */
    public int f15866c;

    /* renamed from: d  reason: collision with root package name */
    public int f15867d;

    /* renamed from: e  reason: collision with root package name */
    public int f15868e;

    /* renamed from: f  reason: collision with root package name */
    public final int[] f15869f = new int[255];

    /* renamed from: g  reason: collision with root package name */
    public final b0 f15870g = new b0(255);

    public final boolean a(w wVar, boolean z10) {
        boolean z11;
        boolean z12;
        this.f15864a = 0;
        this.f15865b = 0;
        this.f15866c = 0;
        this.f15867d = 0;
        this.f15868e = 0;
        b0 b0Var = this.f15870g;
        b0Var.D(27);
        try {
            z11 = wVar.k(b0Var.f8414a, 0, 27, z10);
        } catch (EOFException e10) {
            if (z10) {
                z11 = false;
            } else {
                throw e10;
            }
        }
        if (!z11 || b0Var.w() != 1332176723) {
            return false;
        }
        if (b0Var.v() == 0) {
            this.f15864a = b0Var.v();
            this.f15865b = b0Var.j();
            b0Var.l();
            b0Var.l();
            b0Var.l();
            int v10 = b0Var.v();
            this.f15866c = v10;
            this.f15867d = v10 + 27;
            b0Var.D(v10);
            try {
                z12 = wVar.k(b0Var.f8414a, 0, this.f15866c, z10);
            } catch (EOFException e11) {
                if (z10) {
                    z12 = false;
                } else {
                    throw e11;
                }
            }
            if (!z12) {
                return false;
            }
            for (int i10 = 0; i10 < this.f15866c; i10++) {
                int v11 = b0Var.v();
                this.f15869f[i10] = v11;
                this.f15868e += v11;
            }
            return true;
        } else if (z10) {
            return false;
        } else {
            throw b1.c("unsupported bit stream revision");
        }
    }

    public final boolean b(w wVar, long j10) {
        boolean z10;
        int i10;
        boolean z11;
        if (wVar.p() == wVar.l()) {
            z10 = true;
        } else {
            z10 = false;
        }
        a.b(z10);
        b0 b0Var = this.f15870g;
        b0Var.D(4);
        while (true) {
            i10 = (j10 > -1 ? 1 : (j10 == -1 ? 0 : -1));
            if (i10 != 0 && wVar.p() + 4 >= j10) {
                break;
            }
            try {
                z11 = wVar.k(b0Var.f8414a, 0, 4, true);
            } catch (EOFException unused) {
                z11 = false;
            }
            if (!z11) {
                break;
            }
            b0Var.G(0);
            if (b0Var.w() == 1332176723) {
                wVar.f();
                return true;
            }
            wVar.g(1);
        }
        do {
            if ((i10 != 0 && wVar.p() >= j10) || wVar.a(1) == -1) {
                return false;
            }
            break;
        } while (wVar.a(1) == -1);
        return false;
    }
}
