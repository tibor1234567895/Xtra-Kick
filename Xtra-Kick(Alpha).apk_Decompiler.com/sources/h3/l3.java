package h3;

import android.support.v4.media.h;

public final /* synthetic */ class l3 implements r3 {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f7187h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ r3 f7188i;

    public /* synthetic */ l3(r3 r3Var, int i10) {
        this.f7187h = i10;
        this.f7188i = r3Var;
    }

    public final Object h(n2 n2Var, e2 e2Var, int i10) {
        int i11 = this.f7187h;
        r3 r3Var = this.f7188i;
        switch (i11) {
            case 0:
                return s3.E0(n2Var, e2Var, i10, r3Var, new f3(e2Var, i10, 1));
            default:
                h.y(n2Var);
                s3.E0((n2) null, e2Var, i10, r3Var, new f3(e2Var, i10, 0));
                throw null;
        }
    }
}
