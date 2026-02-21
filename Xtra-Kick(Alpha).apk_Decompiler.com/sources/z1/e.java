package z1;

import d9.o0;
import d9.p0;
import d9.r0;
import d9.r1;
import g1.k;
import g1.s0;
import g1.v1;
import h3.e2;
import h3.r;
import h3.s2;
import h3.u0;
import h3.w2;
import h3.x2;
import h3.y0;
import h9.q;
import h9.w;
import j1.c;
import java.util.List;

public final /* synthetic */ class e implements n, u0, w2 {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f17393h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f17394i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Object f17395j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Object f17396k;

    public /* synthetic */ e(Object obj, Object obj2, boolean z10, int i10) {
        this.f17393h = i10;
        this.f17395j = obj;
        this.f17396k = obj2;
        this.f17394i = z10;
    }

    public final r1 a(int i10, v1 v1Var, int[] iArr) {
        q qVar = (q) this.f17395j;
        j jVar = (j) this.f17396k;
        boolean z10 = this.f17394i;
        qVar.getClass();
        f fVar = new f(qVar);
        p0 p0Var = r0.f4657i;
        o0 o0Var = new o0();
        v1 v1Var2 = v1Var;
        for (int i11 = 0; i11 < v1Var2.f6673h; i11++) {
            o0Var.c(new g(i10, v1Var, i11, jVar, iArr[i11], z10, fVar));
        }
        return o0Var.e();
    }

    public final void d(r rVar, int i10) {
        int i11 = this.f17393h;
        boolean z10 = this.f17394i;
        Object obj = this.f17396k;
        Object obj2 = this.f17395j;
        switch (i11) {
            case 1:
                y0 y0Var = (y0) obj2;
                y0Var.getClass();
                rVar.o(y0Var.f7455c, i10, new k(c.c((List) obj)), z10);
                return;
            default:
                y0 y0Var2 = (y0) obj2;
                y0Var2.getClass();
                rVar.O(y0Var2.f7455c, i10, ((s0) obj).h(), z10);
                return;
        }
    }

    public final void e(e2 e2Var) {
        x2 x2Var = (x2) this.f17395j;
        w.a(x2Var.f7437g.i(e2Var, r0.n((s0) this.f17396k), -1, -9223372036854775807L), new s2((Object) x2Var, this.f17394i), q.f7765h);
    }
}
