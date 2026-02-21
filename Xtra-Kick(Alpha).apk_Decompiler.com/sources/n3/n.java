package n3;

import androidx.recyclerview.widget.RecyclerView;
import ma.e0;
import pa.e;
import ra.c;

public final class n extends c {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f11338h;

    /* renamed from: i  reason: collision with root package name */
    public int f11339i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ o f11340j;

    /* renamed from: k  reason: collision with root package name */
    public o f11341k;

    /* renamed from: l  reason: collision with root package name */
    public e0 f11342l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public n(o oVar, e eVar) {
        super(eVar);
        this.f11340j = oVar;
    }

    public final Object invokeSuspend(Object obj) {
        this.f11338h = obj;
        this.f11339i |= RecyclerView.UNDEFINED_DURATION;
        return this.f11340j.a((Object) null, this);
    }
}
