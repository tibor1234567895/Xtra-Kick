package n3;

import androidx.activity.t;
import hb.h0;
import la.v;
import pa.e;
import qa.a;
import ra.i;
import wa.p;
import wa.q;

public final class o0 extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f11367i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f11368j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ q f11369k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ t f11370l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public o0(q qVar, t tVar, e eVar) {
        super(2, eVar);
        this.f11369k = qVar;
        this.f11370l = tVar;
    }

    public final e create(Object obj, e eVar) {
        o0 o0Var = new o0(this.f11369k, this.f11370l, eVar);
        o0Var.f11368j = obj;
        return o0Var;
    }

    public final Object g(Object obj, Object obj2) {
        return ((o0) create(obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f11367i;
        if (i10 == 0) {
            h0.O1(obj);
            Object obj2 = this.f11368j;
            this.f11367i = 1;
            if (this.f11369k.e(this.f11370l, obj2, this) == aVar) {
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
