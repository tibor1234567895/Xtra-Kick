package n3;

import androidx.recyclerview.widget.RecyclerView;
import ma.e0;
import ob.d;
import pa.e;
import ra.c;

public final class f0 extends c {

    /* renamed from: h  reason: collision with root package name */
    public g0 f11141h;

    /* renamed from: i  reason: collision with root package name */
    public e0 f11142i;

    /* renamed from: j  reason: collision with root package name */
    public d f11143j;

    /* renamed from: k  reason: collision with root package name */
    public /* synthetic */ Object f11144k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ g0 f11145l;

    /* renamed from: m  reason: collision with root package name */
    public int f11146m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f0(g0 g0Var, e eVar) {
        super(eVar);
        this.f11145l = g0Var;
    }

    public final Object invokeSuspend(Object obj) {
        this.f11144k = obj;
        this.f11146m |= RecyclerView.UNDEFINED_DURATION;
        return this.f11145l.b((e0) null, this);
    }
}
