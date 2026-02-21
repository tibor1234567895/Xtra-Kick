package f7;

import com.github.andreyasadchy.xtra.ui.search.tags.TagSearchFragment;
import hb.h0;
import k6.c;
import la.v;
import n3.u3;
import qa.a;
import ra.i;
import wa.p;
import xa.j;

public final class e extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f5918i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f5919j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ TagSearchFragment f5920k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(TagSearchFragment tagSearchFragment, pa.e eVar) {
        super(2, eVar);
        this.f5920k = tagSearchFragment;
    }

    public final pa.e create(Object obj, pa.e eVar) {
        e eVar2 = new e(this.f5920k, eVar);
        eVar2.f5919j = obj;
        return eVar2;
    }

    public final Object g(Object obj, Object obj2) {
        return ((e) create((u3) obj, (pa.e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f5918i;
        if (i10 == 0) {
            h0.O1(obj);
            u3 u3Var = (u3) this.f5919j;
            c cVar = this.f5920k.f3488s0;
            if (cVar != null) {
                this.f5918i = 1;
                if (cVar.d(u3Var, this) == aVar) {
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
