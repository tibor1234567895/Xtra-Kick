package n3;

import androidx.recyclerview.widget.RecyclerView;
import pa.e;
import ra.c;
import xa.u;

public final class l0 extends c {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f11296h;

    /* renamed from: i  reason: collision with root package name */
    public int f11297i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ m0 f11298j;

    /* renamed from: k  reason: collision with root package name */
    public m0 f11299k;

    /* renamed from: l  reason: collision with root package name */
    public u f11300l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public l0(m0 m0Var, e eVar) {
        super(eVar);
        this.f11298j = m0Var;
    }

    public final Object invokeSuspend(Object obj) {
        this.f11296h = obj;
        this.f11297i |= RecyclerView.UNDEFINED_DURATION;
        return this.f11298j.a((Object) null, this);
    }
}
