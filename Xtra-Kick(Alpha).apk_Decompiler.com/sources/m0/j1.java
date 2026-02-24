package m0;

import android.view.View;
import android.view.ViewGroup;
import eb.i;
import eb.j;
import hb.h0;
import la.v;
import pa.e;
import qa.a;
import qa.d;
import ra.h;
import wa.p;

public final class j1 extends h implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f10108i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f10109j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ View f10110k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public j1(View view, e eVar) {
        super(eVar);
        this.f10110k = view;
    }

    public final e create(Object obj, e eVar) {
        j1 j1Var = new j1(this.f10110k, eVar);
        j1Var.f10109j = obj;
        return j1Var;
    }

    public final Object g(Object obj, Object obj2) {
        return ((j1) create((j) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f10108i;
        View view = this.f10110k;
        if (i10 != 0) {
            if (i10 == 1) {
                j jVar = (j) this.f10109j;
                h0.O1(obj);
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    xa.j.f("<this>", viewGroup);
                    i1 i1Var = new i1(viewGroup, (e) null);
                    this.f10109j = null;
                    this.f10108i = 2;
                    jVar.getClass();
                    i iVar = new i();
                    iVar.f5348k = d.a(iVar, iVar, i1Var);
                    Object b10 = jVar.b(iVar, this);
                    if (b10 != aVar) {
                        b10 = v.f9814a;
                    }
                    if (b10 == aVar) {
                        return aVar;
                    }
                }
            } else if (i10 == 2) {
                h0.O1(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return v.f9814a;
        }
        h0.O1(obj);
        j jVar2 = (j) this.f10109j;
        this.f10109j = jVar2;
        this.f10108i = 1;
        jVar2.a(view, this);
        return aVar;
    }
}
