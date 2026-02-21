package n3;

import androidx.recyclerview.widget.RecyclerView;
import ob.d;
import pa.e;
import ra.c;

public final class e0 extends c {

    /* renamed from: h  reason: collision with root package name */
    public g0 f11119h;

    /* renamed from: i  reason: collision with root package name */
    public d f11120i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f11121j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ g0 f11122k;

    /* renamed from: l  reason: collision with root package name */
    public int f11123l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e0(g0 g0Var, e eVar) {
        super(eVar);
        this.f11122k = g0Var;
    }

    public final Object invokeSuspend(Object obj) {
        this.f11121j = obj;
        this.f11123l |= RecyclerView.UNDEFINED_DURATION;
        return this.f11122k.a(this);
    }
}
