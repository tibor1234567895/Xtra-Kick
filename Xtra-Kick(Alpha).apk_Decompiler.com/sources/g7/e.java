package g7;

import androidx.appcompat.widget.j3;
import hb.f0;
import hb.h0;
import la.v;
import m7.h;
import qa.a;
import ra.i;
import wa.p;
import xa.j;

public final class e extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f6854i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ h f6855j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ j3 f6856k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(j3 j3Var, h hVar, pa.e eVar) {
        super(2, eVar);
        this.f6855j = hVar;
        this.f6856k = j3Var;
    }

    public final pa.e create(Object obj, pa.e eVar) {
        return new e(this.f6856k, this.f6855j, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((e) create((f0) obj, (pa.e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f6854i;
        if (i10 == 0) {
            h0.O1(obj);
            h hVar = this.f6855j;
            h hVar2 = hVar.f6864s0;
            if (hVar2 != null) {
                d dVar = new d(this.f6856k, hVar, (pa.e) null);
                this.f6854i = 1;
                if (h0.B(hVar2.f11566c, dVar, this) == aVar) {
                    return aVar;
                }
            } else {
                j.l("pagingAdapter");
                throw null;
            }
        } else if (i10 == 1) {
            h0.O1(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return v.f9814a;
    }
}
