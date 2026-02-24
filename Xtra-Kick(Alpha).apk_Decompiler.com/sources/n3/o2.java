package n3;

import androidx.recyclerview.widget.RecyclerView;
import ob.d;
import pa.e;
import ra.c;

public final class o2 extends c {

    /* renamed from: h  reason: collision with root package name */
    public g3 f11375h;

    /* renamed from: i  reason: collision with root package name */
    public h3 f11376i;

    /* renamed from: j  reason: collision with root package name */
    public d f11377j;

    /* renamed from: k  reason: collision with root package name */
    public /* synthetic */ Object f11378k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ g3 f11379l;

    /* renamed from: m  reason: collision with root package name */
    public int f11380m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public o2(g3 g3Var, e eVar) {
        super(eVar);
        this.f11379l = g3Var;
    }

    public final Object invokeSuspend(Object obj) {
        this.f11378k = obj;
        this.f11380m |= RecyclerView.UNDEFINED_DURATION;
        return this.f11379l.e(this);
    }
}
