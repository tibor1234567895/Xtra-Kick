package kb;

import androidx.recyclerview.widget.RecyclerView;
import pa.e;
import qa.a;
import ra.c;

public final class j1 extends c {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f9337h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ k1 f9338i;

    /* renamed from: j  reason: collision with root package name */
    public int f9339j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public j1(k1 k1Var, e eVar) {
        super(eVar);
        this.f9338i = k1Var;
    }

    public final Object invokeSuspend(Object obj) {
        this.f9337h = obj;
        this.f9339j |= RecyclerView.UNDEFINED_DURATION;
        this.f9338i.b((j) null, this);
        return a.COROUTINE_SUSPENDED;
    }
}
