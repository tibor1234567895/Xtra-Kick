package u2;

import j1.b0;

public final class g implements f {

    /* renamed from: a  reason: collision with root package name */
    public final b0 f15215a;

    /* renamed from: b  reason: collision with root package name */
    public final int f15216b;

    /* renamed from: c  reason: collision with root package name */
    public final int f15217c;

    /* renamed from: d  reason: collision with root package name */
    public int f15218d;

    /* renamed from: e  reason: collision with root package name */
    public int f15219e;

    public g(b bVar) {
        b0 b0Var = bVar.f15199c;
        this.f15215a = b0Var;
        b0Var.G(12);
        this.f15217c = b0Var.y() & 255;
        this.f15216b = b0Var.y();
    }

    public final int a() {
        return -1;
    }

    public final int b() {
        return this.f15216b;
    }

    public final int c() {
        b0 b0Var = this.f15215a;
        int i10 = this.f15217c;
        if (i10 == 8) {
            return b0Var.v();
        }
        if (i10 == 16) {
            return b0Var.A();
        }
        int i11 = this.f15218d;
        this.f15218d = i11 + 1;
        if (i11 % 2 != 0) {
            return this.f15219e & 15;
        }
        int v10 = b0Var.v();
        this.f15219e = v10;
        return (v10 & 240) >> 4;
    }
}
