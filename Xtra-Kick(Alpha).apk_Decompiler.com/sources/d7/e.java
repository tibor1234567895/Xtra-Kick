package d7;

import com.github.andreyasadchy.xtra.ui.search.games.GameSearchViewModel;
import hb.f0;
import hb.h0;
import la.v;
import n3.u3;
import o6.c;
import qa.a;
import ra.i;
import wa.p;
import xa.j;

public final class e extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f4574i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ f f4575j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ String f4576k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(f fVar, String str, pa.e eVar) {
        super(2, eVar);
        this.f4575j = fVar;
        this.f4576k = str;
    }

    public final pa.e create(Object obj, pa.e eVar) {
        return new e(this.f4575j, this.f4576k, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((e) create((f0) obj, (pa.e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f4574i;
        String str = this.f4576k;
        f fVar = this.f4575j;
        if (i10 == 0) {
            h0.O1(obj);
            if (!j.a(((GameSearchViewModel) fVar.f4579q0.getValue()).f3480e.getValue(), str)) {
                c cVar = fVar.f4580r0;
                if (cVar != null) {
                    u3.f11503c.getClass();
                    u3 u3Var = u3.f11504d;
                    this.f4574i = 1;
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
        ((GameSearchViewModel) fVar.f4579q0.getValue()).f3480e.k(str);
        return v.f9814a;
    }
}
