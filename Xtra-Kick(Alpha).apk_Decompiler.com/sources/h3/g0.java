package h3;

import java.util.List;

public final /* synthetic */ class g0 implements u0, o3, r3 {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f7041h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ long f7042i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Object f7043j;

    public /* synthetic */ g0(int i10, long j10, Object obj) {
        this.f7043j = obj;
        this.f7041h = i10;
        this.f7042i = j10;
    }

    public final void c(a4 a4Var, e2 e2Var) {
        int i10 = s3.f7316j;
        a4Var.v(((s3) this.f7043j).F0(this.f7041h, e2Var, a4Var), this.f7042i);
    }

    public final void d(r rVar, int i10) {
        r rVar2 = rVar;
        rVar2.s(((y0) this.f7043j).f7455c, i10, this.f7041h, this.f7042i);
    }

    public final Object h(n2 n2Var, e2 e2Var, int i10) {
        int i11;
        long j10;
        List list = (List) this.f7043j;
        int i12 = s3.f7316j;
        int i13 = this.f7041h;
        if (i13 == -1) {
            i11 = n2Var.f7246s.U();
        } else {
            i11 = i13;
        }
        if (i13 == -1) {
            j10 = n2Var.f7246s.j();
        } else {
            j10 = this.f7042i;
        }
        return n2Var.i(e2Var, list, i11, j10);
    }
}
