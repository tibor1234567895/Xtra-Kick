package kb;

import androidx.recyclerview.widget.RecyclerView;
import n3.c3;
import pa.e;
import ra.c;

public final class y extends c {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f9418h;

    /* renamed from: i  reason: collision with root package name */
    public int f9419i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ c3 f9420j;

    /* renamed from: k  reason: collision with root package name */
    public a0 f9421k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public y(c3 c3Var, e eVar) {
        super(eVar);
        this.f9420j = c3Var;
    }

    public final Object invokeSuspend(Object obj) {
        this.f9418h = obj;
        this.f9419i |= RecyclerView.UNDEFINED_DURATION;
        return this.f9420j.b((j) null, this);
    }
}
