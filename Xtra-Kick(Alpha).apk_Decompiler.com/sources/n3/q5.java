package n3;

import androidx.recyclerview.widget.RecyclerView;
import pa.e;
import ra.c;
import wa.l;

public final class q5 extends c {

    /* renamed from: h  reason: collision with root package name */
    public s5 f11444h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f11445i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ s5 f11446j;

    /* renamed from: k  reason: collision with root package name */
    public int f11447k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public q5(s5 s5Var, e eVar) {
        super(eVar);
        this.f11446j = s5Var;
    }

    public final Object invokeSuspend(Object obj) {
        this.f11445i = obj;
        this.f11447k |= RecyclerView.UNDEFINED_DURATION;
        return this.f11446j.a(0, (l) null, this);
    }
}
