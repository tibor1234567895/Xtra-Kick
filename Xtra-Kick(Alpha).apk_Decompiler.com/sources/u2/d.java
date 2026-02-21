package u2;

import d2.z;
import j1.b0;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public final int f15202a;

    /* renamed from: b  reason: collision with root package name */
    public int f15203b;

    /* renamed from: c  reason: collision with root package name */
    public int f15204c;

    /* renamed from: d  reason: collision with root package name */
    public long f15205d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f15206e;

    /* renamed from: f  reason: collision with root package name */
    public final b0 f15207f;

    /* renamed from: g  reason: collision with root package name */
    public final b0 f15208g;

    /* renamed from: h  reason: collision with root package name */
    public int f15209h;

    /* renamed from: i  reason: collision with root package name */
    public int f15210i;

    public d(b0 b0Var, b0 b0Var2, boolean z10) {
        this.f15208g = b0Var;
        this.f15207f = b0Var2;
        this.f15206e = z10;
        b0Var2.G(12);
        this.f15202a = b0Var2.y();
        b0Var.G(12);
        this.f15210i = b0Var.y();
        z.a("first_chunk must be 1", b0Var.f() != 1 ? false : true);
        this.f15203b = -1;
    }

    public final boolean a() {
        int i10 = this.f15203b + 1;
        this.f15203b = i10;
        if (i10 == this.f15202a) {
            return false;
        }
        boolean z10 = this.f15206e;
        b0 b0Var = this.f15207f;
        this.f15205d = z10 ? b0Var.z() : b0Var.w();
        if (this.f15203b == this.f15209h) {
            b0 b0Var2 = this.f15208g;
            this.f15204c = b0Var2.y();
            b0Var2.H(4);
            int i11 = this.f15210i - 1;
            this.f15210i = i11;
            this.f15209h = i11 > 0 ? b0Var2.y() - 1 : -1;
        }
        return true;
    }
}
