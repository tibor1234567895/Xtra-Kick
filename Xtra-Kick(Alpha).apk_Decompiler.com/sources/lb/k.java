package lb;

import androidx.recyclerview.widget.RecyclerView;
import pa.e;
import ra.c;

public final class k extends c {

    /* renamed from: h  reason: collision with root package name */
    public l f9843h;

    /* renamed from: i  reason: collision with root package name */
    public Object f9844i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f9845j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ l f9846k;

    /* renamed from: l  reason: collision with root package name */
    public int f9847l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public k(l lVar, e eVar) {
        super(eVar);
        this.f9846k = lVar;
    }

    public final Object invokeSuspend(Object obj) {
        this.f9845j = obj;
        this.f9847l |= RecyclerView.UNDEFINED_DURATION;
        return this.f9846k.a((Object) null, this);
    }
}
