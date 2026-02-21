package n3;

import androidx.recyclerview.widget.RecyclerView;
import pa.e;
import ra.c;

public final class m2 extends c {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f11334h;

    /* renamed from: i  reason: collision with root package name */
    public int f11335i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ e2 f11336j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public m2(e2 e2Var, e eVar) {
        super(eVar);
        this.f11336j = e2Var;
    }

    public final Object invokeSuspend(Object obj) {
        this.f11334h = obj;
        this.f11335i |= RecyclerView.UNDEFINED_DURATION;
        return this.f11336j.a((Object) null, this);
    }
}
