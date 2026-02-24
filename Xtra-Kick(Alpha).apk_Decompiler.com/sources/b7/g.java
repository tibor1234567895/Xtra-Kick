package b7;

import com.github.andreyasadchy.xtra.ui.search.SearchPagerViewModel;
import e6.s;
import e6.x;
import hb.f0;
import hb.h0;
import hb.p0;
import l0.c;
import la.v;
import pa.e;
import qa.a;
import ra.i;
import wa.p;

public final class g extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f2653i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ SearchPagerViewModel f2654j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f2655k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g(SearchPagerViewModel searchPagerViewModel, int i10, e eVar) {
        super(2, eVar);
        this.f2654j = searchPagerViewModel;
        this.f2655k = i10;
    }

    public final e create(Object obj, e eVar) {
        return new g(this.f2654j, this.f2655k, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((g) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f2653i;
        SearchPagerViewModel searchPagerViewModel = this.f2654j;
        if (i10 == 0) {
            h0.O1(obj);
            x xVar = searchPagerViewModel.f3473d;
            this.f2653i = 1;
            xVar.getClass();
            obj = h0.c2(p0.f7834b, new s((e) null), this);
            if (obj == aVar) {
                return aVar;
            }
        } else if (i10 == 1) {
            try {
                h0.O1(obj);
            } catch (Exception unused) {
            } catch (Throwable th) {
                searchPagerViewModel.f3475f = false;
                throw th;
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        searchPagerViewModel.f3474e.j((c) obj);
        searchPagerViewModel.f3475f = false;
        return v.f9814a;
    }
}
