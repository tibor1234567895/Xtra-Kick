package kb;

import androidx.recyclerview.widget.RecyclerView;
import pa.e;
import ra.c;

public final class f extends c {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f9300h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ g f9301i;

    /* renamed from: j  reason: collision with root package name */
    public int f9302j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(g gVar, e eVar) {
        super(eVar);
        this.f9301i = gVar;
    }

    public final Object invokeSuspend(Object obj) {
        this.f9300h = obj;
        this.f9302j |= RecyclerView.UNDEFINED_DURATION;
        return this.f9301i.a((Object) null, this);
    }
}
