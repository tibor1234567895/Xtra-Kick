package androidx.lifecycle;

import hb.l1;
import j3.r;
import java.util.List;
import java.util.concurrent.CancellationException;
import l3.m;
import xa.j;

public final /* synthetic */ class u implements b0 {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f1766h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Object f1767i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Object f1768j;

    public /* synthetic */ u(Object obj, int i10, Object obj2) {
        this.f1766h = i10;
        this.f1767i = obj;
        this.f1768j = obj2;
    }

    public final void d(d0 d0Var, r rVar) {
        int i10 = this.f1766h;
        Object obj = this.f1768j;
        Object obj2 = this.f1767i;
        switch (i10) {
            case 0:
                v vVar = (v) obj2;
                l1 l1Var = (l1) obj;
                j.f("this$0", vVar);
                j.f("$parentJob", l1Var);
                if (d0Var.o().b() == s.DESTROYED) {
                    l1Var.e((CancellationException) null);
                    vVar.a();
                    return;
                }
                int compareTo = d0Var.o().b().compareTo(vVar.f1773b);
                j jVar = vVar.f1774c;
                if (compareTo < 0) {
                    jVar.f1703a = true;
                    return;
                } else if (jVar.f1703a) {
                    if (!jVar.f1704b) {
                        jVar.f1703a = false;
                        jVar.a();
                        return;
                    }
                    throw new IllegalStateException("Cannot resume a finished dispatcher".toString());
                } else {
                    return;
                }
            default:
                m mVar = (m) obj2;
                r rVar2 = (r) obj;
                j.f("this$0", mVar);
                j.f("$entry", rVar2);
                if (rVar == r.ON_RESUME) {
                    int i11 = m.f9553i;
                    if (((List) mVar.b().f8678e.getValue()).contains(rVar2)) {
                        mVar.b().b(rVar2);
                    }
                }
                if (rVar == r.ON_DESTROY) {
                    int i12 = m.f9553i;
                    if (!((List) mVar.b().f8678e.getValue()).contains(rVar2)) {
                        mVar.b().b(rVar2);
                        return;
                    }
                    return;
                }
                return;
        }
    }
}
