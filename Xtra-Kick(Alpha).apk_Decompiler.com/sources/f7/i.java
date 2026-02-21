package f7;

import com.github.andreyasadchy.xtra.ui.search.tags.TagSearchFragment;
import hb.f0;
import hb.h0;
import la.v;
import pa.e;
import qa.a;
import wa.p;

public final class i extends ra.i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f5929i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ TagSearchFragment f5930j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ String f5931k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i(TagSearchFragment tagSearchFragment, String str, e eVar) {
        super(2, eVar);
        this.f5930j = tagSearchFragment;
        this.f5931k = str;
    }

    public final e create(Object obj, e eVar) {
        return new i(this.f5930j, this.f5931k, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((i) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f5929i;
        if (i10 == 0) {
            h0.O1(obj);
            this.f5929i = 1;
            if (h0.L(750, this) == aVar) {
                return aVar;
            }
        } else if (i10 == 1) {
            h0.O1(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        TagSearchFragment.s0(this.f5930j, this.f5931k);
        return v.f9814a;
    }
}
