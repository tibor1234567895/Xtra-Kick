package e6;

import androidx.recyclerview.widget.RecyclerView;
import pa.e;
import ra.c;

public final class w1 extends c {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f5262h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ z1 f5263i;

    /* renamed from: j  reason: collision with root package name */
    public int f5264j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public w1(z1 z1Var, e eVar) {
        super(eVar);
        this.f5263i = z1Var;
    }

    public final Object invokeSuspend(Object obj) {
        this.f5262h = obj;
        this.f5264j |= RecyclerView.UNDEFINED_DURATION;
        return this.f5263i.b((String) null, this);
    }
}
