package c7;

import com.github.andreyasadchy.xtra.ui.search.channels.ChannelSearchViewModel;
import hb.f0;
import hb.h0;
import la.v;
import n3.u3;
import o6.c;
import pa.e;
import qa.a;
import ra.i;
import wa.p;
import xa.j;

public final class g extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f2988i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ h f2989j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ String f2990k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g(h hVar, String str, e eVar) {
        super(2, eVar);
        this.f2989j = hVar;
        this.f2990k = str;
    }

    public final e create(Object obj, e eVar) {
        return new g(this.f2989j, this.f2990k, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((g) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f2988i;
        String str = this.f2990k;
        h hVar = this.f2989j;
        if (i10 == 0) {
            h0.O1(obj);
            if (!j.a(((ChannelSearchViewModel) hVar.f2993q0.getValue()).f3477e.getValue(), str)) {
                c cVar = hVar.f2994r0;
                if (cVar != null) {
                    u3.f11503c.getClass();
                    u3 u3Var = u3.f11504d;
                    this.f2988i = 1;
                    if (cVar.d(u3Var, this) == aVar) {
                        return aVar;
                    }
                } else {
                    j.l("pagingAdapter");
                    throw null;
                }
            }
            return v.f9814a;
        } else if (i10 == 1) {
            h0.O1(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        j.f("query", str);
        ((ChannelSearchViewModel) hVar.f2993q0.getValue()).f3477e.k(str);
        return v.f9814a;
    }
}
