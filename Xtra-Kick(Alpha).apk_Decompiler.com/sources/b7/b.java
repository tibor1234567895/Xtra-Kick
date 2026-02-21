package b7;

import androidx.fragment.app.c0;
import com.github.andreyasadchy.xtra.ui.search.SearchPagerFragment;
import hb.f0;
import hb.h0;
import la.v;
import pa.e;
import qa.a;
import ra.i;
import wa.p;

public final class b extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f2646i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ SearchPagerFragment f2647j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ String f2648k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(SearchPagerFragment searchPagerFragment, String str, e eVar) {
        super(2, eVar);
        this.f2647j = searchPagerFragment;
        this.f2648k = str;
    }

    public final e create(Object obj, e eVar) {
        return new b(this.f2647j, this.f2648k, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((b) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f2646i;
        if (i10 == 0) {
            h0.O1(obj);
            this.f2646i = 1;
            if (h0.L(750, this) == aVar) {
                return aVar;
            }
        } else if (i10 == 1) {
            h0.O1(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c0 q02 = this.f2647j.q0();
        i iVar = q02 instanceof i ? (i) q02 : null;
        if (iVar != null) {
            iVar.k(this.f2648k);
        }
        return v.f9814a;
    }
}
