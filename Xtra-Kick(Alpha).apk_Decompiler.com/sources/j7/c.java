package j7;

import com.github.andreyasadchy.xtra.model.ui.StreamSortEnum;
import com.github.andreyasadchy.xtra.ui.streams.common.StreamsViewModel;
import hb.f0;
import hb.h0;
import kb.e1;
import la.v;
import n3.u3;
import pa.e;
import qa.a;
import ra.i;
import wa.p;
import xa.j;

public final class c extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f8830i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ d f8831j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ StreamSortEnum f8832k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(d dVar, StreamSortEnum streamSortEnum, e eVar) {
        super(2, eVar);
        this.f8831j = dVar;
        this.f8832k = streamSortEnum;
    }

    public final e create(Object obj, e eVar) {
        return new c(this.f8831j, this.f8832k, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((c) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f8830i;
        d dVar = this.f8831j;
        if (i10 == 0) {
            h0.O1(obj);
            i7.c cVar = dVar.f8837s0;
            if (cVar != null) {
                u3.f11503c.getClass();
                u3 u3Var = u3.f11504d;
                this.f8830i = 1;
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
        int i11 = d.f8833t0;
        StreamSortEnum streamSortEnum = this.f8832k;
        j.f("sort", streamSortEnum);
        e1 e1Var = ((StreamsViewModel) dVar.f8836r0.getValue()).f3508f;
        ((i) e1Var.getValue()).getClass();
        e1Var.k(new i(streamSortEnum));
        return v.f9814a;
    }
}
