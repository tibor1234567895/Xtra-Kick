package n3;

import androidx.activity.t;
import hb.h0;
import la.v;
import pa.e;
import qa.a;
import ra.i;
import wa.l;

public final class a4 extends i implements l {

    /* renamed from: i  reason: collision with root package name */
    public int f11045i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ g f11046j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ u3 f11047k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a4(g gVar, u3 u3Var, e eVar) {
        super(1, eVar);
        this.f11046j = gVar;
        this.f11047k = u3Var;
    }

    public final e create(e eVar) {
        return new a4(this.f11046j, this.f11047k, eVar);
    }

    public final Object invoke(Object obj) {
        return ((a4) create((e) obj)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f11045i;
        if (i10 == 0) {
            h0.O1(obj);
            u3 u3Var = this.f11047k;
            v5 v5Var = u3Var.f11506b;
            g gVar = this.f11046j;
            gVar.f11167d = v5Var;
            kb.i iVar = u3Var.f11505a;
            t tVar = new t(3, gVar);
            this.f11045i = 1;
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
