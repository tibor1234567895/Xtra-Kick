package f3;

import d2.w0;
import d2.x0;
import d2.y;
import g1.a0;
import g1.z;
import j1.a;
import j1.b0;

public final class v implements k {

    /* renamed from: a  reason: collision with root package name */
    public final b0 f5758a = new b0(10);

    /* renamed from: b  reason: collision with root package name */
    public x0 f5759b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f5760c;

    /* renamed from: d  reason: collision with root package name */
    public long f5761d = -9223372036854775807L;

    /* renamed from: e  reason: collision with root package name */
    public int f5762e;

    /* renamed from: f  reason: collision with root package name */
    public int f5763f;

    public final void a() {
        this.f5760c = false;
        this.f5761d = -9223372036854775807L;
    }

    public final void c(b0 b0Var) {
        a.f(this.f5759b);
        if (this.f5760c) {
            int i10 = b0Var.f8416c - b0Var.f8415b;
            int i11 = this.f5763f;
            if (i11 < 10) {
                int min = Math.min(i10, 10 - i11);
                byte[] bArr = b0Var.f8414a;
                int i12 = b0Var.f8415b;
                b0 b0Var2 = this.f5758a;
                System.arraycopy(bArr, i12, b0Var2.f8414a, this.f5763f, min);
                if (this.f5763f + min == 10) {
                    b0Var2.G(0);
                    if (73 == b0Var2.v() && 68 == b0Var2.v() && 51 == b0Var2.v()) {
                        b0Var2.H(3);
                        this.f5762e = b0Var2.u() + 10;
                    } else {
                        j1.v.g("Id3Reader", "Discarding invalid ID3 tag");
                        this.f5760c = false;
                        return;
                    }
                }
            }
            int min2 = Math.min(i10, this.f5762e - this.f5763f);
            this.f5759b.d(min2, b0Var);
            this.f5763f += min2;
        }
    }

    public final void d(y yVar, j0 j0Var) {
        j0Var.a();
        j0Var.b();
        x0 d10 = yVar.d(j0Var.f5630d, 5);
        this.f5759b = d10;
        z zVar = new z();
        j0Var.b();
        zVar.f6744a = j0Var.f5631e;
        zVar.f6754k = "application/id3";
        d10.a(new a0(zVar));
    }

    public final void e(int i10, long j10) {
        if ((i10 & 4) != 0) {
            this.f5760c = true;
            if (j10 != -9223372036854775807L) {
                this.f5761d = j10;
            }
            this.f5762e = 0;
            this.f5763f = 0;
        }
    }

    public final void f() {
        int i10;
        a.f(this.f5759b);
        if (this.f5760c && (i10 = this.f5762e) != 0 && this.f5763f == i10) {
            long j10 = this.f5761d;
            if (j10 != -9223372036854775807L) {
                this.f5759b.e(j10, 1, i10, 0, (w0) null);
            }
            this.f5760c = false;
        }
    }
}
