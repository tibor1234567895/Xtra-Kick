package n3;

import androidx.activity.t;
import hb.f0;
import hb.h0;
import jb.g;
import la.v;
import pa.e;
import qa.a;
import ra.i;
import wa.p;

public final class t2 extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f11489i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ g3 f11490j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ g f11491k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public t2(g3 g3Var, e eVar, g gVar) {
        super(2, eVar);
        this.f11490j = g3Var;
        this.f11491k = gVar;
    }

    public final e create(Object obj, e eVar) {
        return new t2(this.f11490j, eVar, this.f11491k);
    }

    public final Object g(Object obj, Object obj2) {
        return ((t2) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f11489i;
        if (i10 == 0) {
            h0.O1(obj);
            kb.i iVar = this.f11490j.f11197d;
            t tVar = new t(2, this.f11491k);
            this.f11489i = 1;
            if (iVar.b(tVar, this) == aVar) {
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
