package n3;

import androidx.recyclerview.widget.RecyclerView;
import pa.e;
import ra.c;

public final class b3 extends c {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f11063h;

    /* renamed from: i  reason: collision with root package name */
    public int f11064i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ k2 f11065j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b3(k2 k2Var, e eVar) {
        super(eVar);
        this.f11065j = k2Var;
    }

    public final Object invokeSuspend(Object obj) {
        this.f11063h = obj;
        this.f11064i |= RecyclerView.UNDEFINED_DURATION;
        return this.f11065j.a((Object) null, this);
    }
}
