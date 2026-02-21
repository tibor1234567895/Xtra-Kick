package kb;

import androidx.recyclerview.widget.RecyclerView;
import pa.e;
import ra.c;

public final class c0 extends c {

    /* renamed from: h  reason: collision with root package name */
    public d0 f9273h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f9274i;

    /* renamed from: j  reason: collision with root package name */
    public int f9275j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ d0 f9276k;

    /* renamed from: l  reason: collision with root package name */
    public Object f9277l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c0(d0 d0Var, e eVar) {
        super(eVar);
        this.f9276k = d0Var;
    }

    public final Object invokeSuspend(Object obj) {
        this.f9274i = obj;
        this.f9275j |= RecyclerView.UNDEFINED_DURATION;
        return this.f9276k.a((Object) null, this);
    }
}
