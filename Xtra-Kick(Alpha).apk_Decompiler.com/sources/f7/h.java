package f7;

import androidx.appcompat.widget.j3;
import com.github.andreyasadchy.xtra.ui.search.tags.TagSearchFragment;
import hb.f0;
import hb.h0;
import k6.c;
import la.v;
import pa.e;
import qa.a;
import ra.i;
import wa.p;
import xa.j;

public final class h extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f5926i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ TagSearchFragment f5927j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ j3 f5928k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h(j3 j3Var, TagSearchFragment tagSearchFragment, e eVar) {
        super(2, eVar);
        this.f5927j = tagSearchFragment;
        this.f5928k = j3Var;
    }

    public final e create(Object obj, e eVar) {
        return new h(this.f5928k, this.f5927j, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((h) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f5926i;
        if (i10 == 0) {
            h0.O1(obj);
            TagSearchFragment tagSearchFragment = this.f5927j;
            c cVar = tagSearchFragment.f3488s0;
            if (cVar != null) {
                g gVar = new g(this.f5928k, tagSearchFragment, (e) null);
                this.f5926i = 1;
                if (h0.B(cVar.f11566c, gVar, this) == aVar) {
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
