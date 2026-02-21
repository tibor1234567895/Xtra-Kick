package e6;

import androidx.recyclerview.widget.RecyclerView;
import pa.e;
import ra.c;

public final class u1 extends c {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f5250h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ z1 f5251i;

    /* renamed from: j  reason: collision with root package name */
    public int f5252j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public u1(z1 z1Var, e eVar) {
        super(eVar);
        this.f5251i = z1Var;
    }

    public final Object invokeSuspend(Object obj) {
        this.f5250h = obj;
        this.f5252j |= RecyclerView.UNDEFINED_DURATION;
        return this.f5251i.a(this);
    }
}
