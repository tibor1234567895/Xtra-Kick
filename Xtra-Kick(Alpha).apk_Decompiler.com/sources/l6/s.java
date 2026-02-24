package l6;

import hb.f0;
import hb.h0;
import la.v;
import n3.x3;
import pa.e;
import qa.a;
import ra.i;
import wa.p;

public final class s extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f9663i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ kb.i f9664j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ x3 f9665k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public s(kb.i iVar, x3 x3Var, e eVar) {
        super(2, eVar);
        this.f9664j = iVar;
        this.f9665k = x3Var;
    }

    public final e create(Object obj, e eVar) {
        return new s(this.f9664j, this.f9665k, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((s) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f9663i;
        if (i10 == 0) {
            h0.O1(obj);
            r rVar = new r(this.f9665k, (e) null);
            this.f9663i = 1;
            if (h0.B(this.f9664j, rVar, this) == aVar) {
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
