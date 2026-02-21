package n3;

import androidx.recyclerview.widget.RecyclerView;
import pa.e;
import ra.c;
import xa.u;

public final class i0 extends c {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f11243h;

    /* renamed from: i  reason: collision with root package name */
    public int f11244i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ j0 f11245j;

    /* renamed from: k  reason: collision with root package name */
    public j0 f11246k;

    /* renamed from: l  reason: collision with root package name */
    public u f11247l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i0(j0 j0Var, e eVar) {
        super(eVar);
        this.f11245j = j0Var;
    }

    public final Object invokeSuspend(Object obj) {
        this.f11243h = obj;
        this.f11244i |= RecyclerView.UNDEFINED_DURATION;
        return this.f11245j.a((Object) null, this);
    }
}
