package n3;

import androidx.fragment.app.k;
import hb.h0;
import hb.l1;
import hb.u1;
import la.v;
import pa.e;
import qa.a;
import ra.i;
import wa.p;

public final class x extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f11549i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f11550j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ l1 f11551k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ p f11552l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public x(l1 l1Var, p pVar, e eVar) {
        super(2, eVar);
        this.f11551k = l1Var;
        this.f11552l = pVar;
    }

    public final e create(Object obj, e eVar) {
        x xVar = new x(this.f11551k, this.f11552l, eVar);
        xVar.f11550j = obj;
        return xVar;
    }

    public final Object g(Object obj, Object obj2) {
        return ((x) create((k5) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f11549i;
        if (i10 == 0) {
            h0.O1(obj);
            k5 k5Var = (k5) this.f11550j;
            ((u1) this.f11551k).L(new k(5, k5Var));
            this.f11549i = 1;
            if (this.f11552l.g(k5Var, this) == aVar) {
                return aVar;
            }
        } else if (i10 == 1) {
            h0.O1(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return v.f9814a;
    }
}
