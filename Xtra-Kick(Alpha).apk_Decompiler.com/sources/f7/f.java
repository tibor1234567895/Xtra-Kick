package f7;

import com.github.andreyasadchy.xtra.ui.search.tags.TagSearchFragment;
import com.github.andreyasadchy.xtra.ui.search.tags.TagSearchViewModel;
import hb.f0;
import hb.h0;
import la.v;
import pa.e;
import qa.a;
import ra.i;
import wa.p;

public final class f extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f5921i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ TagSearchFragment f5922j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(TagSearchFragment tagSearchFragment, e eVar) {
        super(2, eVar);
        this.f5922j = tagSearchFragment;
    }

    public final e create(Object obj, e eVar) {
        return new f(this.f5922j, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((f) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f5921i;
        if (i10 == 0) {
            h0.O1(obj);
            int i11 = TagSearchFragment.f3484t0;
            TagSearchFragment tagSearchFragment = this.f5922j;
            e eVar = new e(tagSearchFragment, (e) null);
            this.f5921i = 1;
            if (h0.B(((TagSearchViewModel) tagSearchFragment.f3487r0.getValue()).f3491f, eVar, this) == aVar) {
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
