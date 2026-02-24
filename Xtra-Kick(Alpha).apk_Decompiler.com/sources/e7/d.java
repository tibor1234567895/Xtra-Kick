package e7;

import com.github.andreyasadchy.xtra.ui.search.streams.StreamSearchViewModel;
import hb.f0;
import hb.h0;
import la.v;
import pa.e;
import qa.a;
import ra.i;
import wa.p;

public final class d extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f5299i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ g f5300j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(g gVar, e eVar) {
        super(2, eVar);
        this.f5300j = gVar;
    }

    public final e create(Object obj, e eVar) {
        return new d(this.f5300j, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((d) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f5299i;
        if (i10 == 0) {
            h0.O1(obj);
            int i11 = g.f5307s0;
            g gVar = this.f5300j;
            c cVar = new c(gVar, (e) null);
            this.f5299i = 1;
            if (h0.B(((StreamSearchViewModel) gVar.f5309q0.getValue()).f3483e, cVar, this) == aVar) {
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
