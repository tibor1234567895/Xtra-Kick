package n3;

import androidx.recyclerview.widget.a0;
import androidx.recyclerview.widget.w;
import cb.c;
import cb.l;
import hb.f0;
import hb.h0;
import java.util.Collection;
import la.v;
import pa.e;
import ra.i;
import wa.p;
import xa.j;

public final class f extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ j1 f11138i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ j1 f11139j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ i f11140k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(j1 j1Var, j1 j1Var2, i iVar, e eVar) {
        super(2, eVar);
        this.f11138i = j1Var;
        this.f11139j = j1Var2;
        this.f11140k = iVar;
    }

    public final e create(Object obj, e eVar) {
        return new f(this.f11138i, this.f11139j, this.f11140k, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((f) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        boolean z10;
        h0.O1(obj);
        w wVar = this.f11140k.f11235a;
        j1 j1Var = this.f11138i;
        j.f("<this>", j1Var);
        j1 j1Var2 = this.f11139j;
        j.f("newList", j1Var2);
        j.f("diffCallback", wVar);
        n3 n3Var = (n3) j1Var;
        androidx.recyclerview.widget.v a10 = a0.a(new k1(j1Var, j1Var2, wVar, n3Var.f11356b, ((n3) j1Var2).f11356b));
        boolean z11 = false;
        cb.e c10 = l.c(0, n3Var.f11356b);
        if (!(c10 instanceof Collection) || !((Collection) c10).isEmpty()) {
            c a11 = c10.iterator();
            while (true) {
                if (a11.f3068j) {
                    if (a10.a(a11.a()) != -1) {
                        z10 = true;
                        continue;
                    } else {
                        z10 = false;
                        continue;
                    }
                    if (z10) {
                        z11 = true;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        return new i1(a10, z11);
    }
}
