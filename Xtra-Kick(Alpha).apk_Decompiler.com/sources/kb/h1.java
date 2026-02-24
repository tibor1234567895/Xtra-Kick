package kb;

import androidx.recyclerview.widget.RecyclerView;
import lb.v;
import pa.e;
import ra.c;

public final class h1 extends c {

    /* renamed from: h  reason: collision with root package name */
    public i1 f9324h;

    /* renamed from: i  reason: collision with root package name */
    public v f9325i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f9326j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ i1 f9327k;

    /* renamed from: l  reason: collision with root package name */
    public int f9328l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h1(i1 i1Var, e eVar) {
        super(eVar);
        this.f9327k = i1Var;
    }

    public final Object invokeSuspend(Object obj) {
        this.f9326j = obj;
        this.f9328l |= RecyclerView.UNDEFINED_DURATION;
        return this.f9327k.b(this);
    }
}
