package d7;

import com.github.andreyasadchy.xtra.ui.search.games.GameSearchViewModel;
import hb.f0;
import hb.h0;
import la.v;
import pa.e;
import qa.a;
import ra.i;
import wa.p;

public final class b extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f4566i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ f f4567j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(f fVar, e eVar) {
        super(2, eVar);
        this.f4567j = fVar;
    }

    public final e create(Object obj, e eVar) {
        return new b(this.f4567j, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((b) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f4566i;
        if (i10 == 0) {
            h0.O1(obj);
            f fVar = this.f4567j;
            a aVar2 = new a(fVar, (e) null);
            this.f4566i = 1;
            if (h0.B(((GameSearchViewModel) fVar.f4579q0.getValue()).f3481f, aVar2, this) == aVar) {
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
