package c7;

import com.github.andreyasadchy.xtra.ui.search.channels.ChannelSearchViewModel;
import hb.f0;
import hb.h0;
import la.v;
import pa.e;
import qa.a;
import ra.i;
import wa.p;

public final class d extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f2980i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ h f2981j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(h hVar, e eVar) {
        super(2, eVar);
        this.f2981j = hVar;
    }

    public final e create(Object obj, e eVar) {
        return new d(this.f2981j, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((d) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f2980i;
        if (i10 == 0) {
            h0.O1(obj);
            h hVar = this.f2981j;
            c cVar = new c(hVar, (e) null);
            this.f2980i = 1;
            if (h0.B(((ChannelSearchViewModel) hVar.f2993q0.getValue()).f3478f, cVar, this) == aVar) {
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
