package m4;

import androidx.recyclerview.widget.RecyclerView;
import pa.e;
import pb.j1;
import ra.c;

public final class p extends c {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f10582h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ r f10583i;

    /* renamed from: j  reason: collision with root package name */
    public int f10584j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public p(r rVar, e eVar) {
        super(eVar);
        this.f10583i = rVar;
    }

    public final Object invokeSuspend(Object obj) {
        this.f10582h = obj;
        this.f10584j |= RecyclerView.UNDEFINED_DURATION;
        return this.f10583i.b((j1) null, this);
    }
}
