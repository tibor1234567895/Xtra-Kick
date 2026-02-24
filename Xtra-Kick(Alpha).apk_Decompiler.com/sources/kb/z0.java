package kb;

import androidx.recyclerview.widget.RecyclerView;
import n3.k2;
import pa.e;
import ra.c;

public final class z0 extends c {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f9427h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ k2 f9428i;

    /* renamed from: j  reason: collision with root package name */
    public int f9429j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public z0(k2 k2Var, e eVar) {
        super(eVar);
        this.f9428i = k2Var;
    }

    public final Object invokeSuspend(Object obj) {
        this.f9427h = obj;
        this.f9429j |= RecyclerView.UNDEFINED_DURATION;
        return this.f9428i.b(0, this);
    }
}
