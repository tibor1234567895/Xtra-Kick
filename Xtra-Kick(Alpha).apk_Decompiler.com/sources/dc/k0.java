package dc;

import ma.o;
import xa.j;

public final class k0 {

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f4788a;

    /* renamed from: b  reason: collision with root package name */
    public int f4789b;

    /* renamed from: c  reason: collision with root package name */
    public int f4790c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f4791d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f4792e;

    /* renamed from: f  reason: collision with root package name */
    public k0 f4793f;

    /* renamed from: g  reason: collision with root package name */
    public k0 f4794g;

    static {
        new j0(0);
    }

    public k0() {
        this.f4788a = new byte[8192];
        this.f4792e = true;
        this.f4791d = false;
    }

    public final k0 a() {
        k0 k0Var = this.f4793f;
        if (k0Var == this) {
            k0Var = null;
        }
        k0 k0Var2 = this.f4794g;
        j.c(k0Var2);
        k0Var2.f4793f = this.f4793f;
        k0 k0Var3 = this.f4793f;
        j.c(k0Var3);
        k0Var3.f4794g = this.f4794g;
        this.f4793f = null;
        this.f4794g = null;
        return k0Var;
    }

    public final void b(k0 k0Var) {
        k0Var.f4794g = this;
        k0Var.f4793f = this.f4793f;
        k0 k0Var2 = this.f4793f;
        j.c(k0Var2);
        k0Var2.f4794g = k0Var;
        this.f4793f = k0Var;
    }

    public final k0 c() {
        this.f4791d = true;
        return new k0(this.f4788a, this.f4789b, this.f4790c, true, false);
    }

    public final void d(k0 k0Var, int i10) {
        if (k0Var.f4792e) {
            int i11 = k0Var.f4790c;
            int i12 = i11 + i10;
            byte[] bArr = k0Var.f4788a;
            if (i12 > 8192) {
                if (!k0Var.f4791d) {
                    int i13 = k0Var.f4789b;
                    if (i12 - i13 <= 8192) {
                        o.c(0, i13, i11, bArr, bArr);
                        k0Var.f4790c -= k0Var.f4789b;
                        k0Var.f4789b = 0;
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else {
                    throw new IllegalArgumentException();
                }
            }
            int i14 = k0Var.f4790c;
            int i15 = this.f4789b;
            o.c(i14, i15, i15 + i10, this.f4788a, bArr);
            k0Var.f4790c += i10;
            this.f4789b += i10;
            return;
        }
        throw new IllegalStateException("only owner can write".toString());
    }

    public k0(byte[] bArr, int i10, int i11, boolean z10, boolean z11) {
        j.f("data", bArr);
        this.f4788a = bArr;
        this.f4789b = i10;
        this.f4790c = i11;
        this.f4791d = z10;
        this.f4792e = z11;
    }
}
