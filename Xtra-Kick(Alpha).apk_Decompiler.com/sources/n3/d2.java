package n3;

import androidx.recyclerview.widget.RecyclerView;
import pa.e;
import ra.c;

public final class d2 extends c {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f11105h;

    /* renamed from: i  reason: collision with root package name */
    public int f11106i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ e2 f11107j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d2(e2 e2Var, e eVar) {
        super(eVar);
        this.f11107j = e2Var;
    }

    public final Object invokeSuspend(Object obj) {
        this.f11105h = obj;
        this.f11106i |= RecyclerView.UNDEFINED_DURATION;
        return this.f11107j.a((Object) null, this);
    }
}
