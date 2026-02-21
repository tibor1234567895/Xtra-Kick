package n1;

import d0.d;
import g1.a0;
import g1.u1;
import j1.q;
import java.io.Serializable;
import v1.w;

public final /* synthetic */ class s implements q {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f10989h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ b f10990i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ w f10991j;

    public /* synthetic */ s(b bVar, w wVar, int i10) {
        this.f10989h = i10;
        this.f10990i = bVar;
        this.f10991j = wVar;
    }

    public final void invoke(Object obj) {
        String str;
        switch (this.f10989h) {
            case 0:
                ((c) obj).getClass();
                return;
            default:
                c0 c0Var = (c0) ((c) obj);
                c0Var.getClass();
                b bVar = this.f10990i;
                if (bVar.f10924d != null) {
                    w wVar = this.f10991j;
                    a0 a0Var = wVar.f15820c;
                    a0Var.getClass();
                    z zVar = c0Var.f10932b;
                    v1.a0 a0Var2 = bVar.f10924d;
                    a0Var2.getClass();
                    u1 u1Var = bVar.f10922b;
                    synchronized (zVar) {
                        str = zVar.b(u1Var.p(a0Var2.f6678a, zVar.f11016b).f6544j, a0Var2).f11006a;
                    }
                    d dVar = new d((Object) a0Var, wVar.f15821d, (Serializable) str);
                    int i10 = wVar.f15819b;
                    if (i10 != 0) {
                        if (i10 == 1) {
                            c0Var.f10946p = dVar;
                            return;
                        } else if (i10 != 2) {
                            if (i10 == 3) {
                                c0Var.f10947q = dVar;
                                return;
                            }
                            return;
                        }
                    }
                    c0Var.f10945o = dVar;
                    return;
                }
                return;
        }
    }
}
