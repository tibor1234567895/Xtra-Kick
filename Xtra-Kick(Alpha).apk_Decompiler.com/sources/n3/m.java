package n3;

import androidx.recyclerview.widget.RecyclerView;
import hb.h0;
import j3.w0;
import kb.j;
import kb.p0;
import la.v;
import pa.e;
import qa.a;
import ra.i;
import wa.p;
import xa.s;

public final class m extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f11321i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f11322j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ w0 f11323k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public m(w0 w0Var, e eVar) {
        super(2, eVar);
        this.f11323k = w0Var;
    }

    public final e create(Object obj, e eVar) {
        m mVar = new m(this.f11323k, eVar);
        mVar.f11322j = obj;
        return mVar;
    }

    public final Object g(Object obj, Object obj2) {
        return ((m) create((j) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f11321i;
        if (i10 == 0) {
            h0.O1(obj);
            s sVar = new s();
            sVar.f16816h = RecyclerView.UNDEFINED_DURATION;
            c3 c3Var = new c3((p0) this.f11323k.f8716c, new j((e) null), 1);
            l lVar = new l(sVar, (j) this.f11322j);
            this.f11321i = 1;
            if (c3Var.b(lVar, this) == aVar) {
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
