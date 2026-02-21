package kb;

import androidx.recyclerview.widget.RecyclerView;
import n3.k2;
import pa.e;
import ra.c;

public final class j0 extends c {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f9334h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ k2 f9335i;

    /* renamed from: j  reason: collision with root package name */
    public int f9336j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public j0(k2 k2Var, e eVar) {
        super(eVar);
        this.f9335i = k2Var;
    }

    public final Object invokeSuspend(Object obj) {
        this.f9334h = obj;
        this.f9336j |= RecyclerView.UNDEFINED_DURATION;
        return this.f9335i.a((Object) null, this);
    }
}
