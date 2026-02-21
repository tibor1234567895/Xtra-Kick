package j4;

import androidx.recyclerview.widget.RecyclerView;
import pa.e;
import ra.c;
import xa.q;

public final class y extends c {

    /* renamed from: h  reason: collision with root package name */
    public Object f8796h;

    /* renamed from: i  reason: collision with root package name */
    public q f8797i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f8798j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ c0 f8799k;

    /* renamed from: l  reason: collision with root package name */
    public int f8800l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public y(c0 c0Var, e eVar) {
        super(eVar);
        this.f8799k = c0Var;
    }

    public final Object invokeSuspend(Object obj) {
        this.f8798j = obj;
        this.f8800l |= RecyclerView.UNDEFINED_DURATION;
        return this.f8799k.a(this);
    }
}
