package g7;

import com.github.andreyasadchy.xtra.ui.search.videos.VideoSearchViewModel;
import hb.f0;
import hb.h0;
import la.v;
import pa.e;
import qa.a;
import ra.i;
import wa.p;

public final class c extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f6849i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ h f6850j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(h hVar, e eVar) {
        super(2, eVar);
        this.f6850j = hVar;
    }

    public final e create(Object obj, e eVar) {
        return new c(this.f6850j, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((c) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f6849i;
        if (i10 == 0) {
            h0.O1(obj);
            int i11 = h.f6861t0;
            h hVar = this.f6850j;
            VideoSearchViewModel t02 = hVar.t0();
            b bVar = new b(hVar, (e) null);
            this.f6849i = 1;
            if (h0.B(t02.f3493i, bVar, this) == aVar) {
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
