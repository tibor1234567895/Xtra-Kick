package kb;

import androidx.recyclerview.widget.RecyclerView;
import pa.e;
import ra.c;

public final class w extends c {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f9408h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ x f9409i;

    /* renamed from: j  reason: collision with root package name */
    public int f9410j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public w(x xVar, e eVar) {
        super(eVar);
        this.f9409i = xVar;
    }

    public final Object invokeSuspend(Object obj) {
        this.f9408h = obj;
        this.f9410j |= RecyclerView.UNDEFINED_DURATION;
        return this.f9409i.a((Object) null, this);
    }
}
