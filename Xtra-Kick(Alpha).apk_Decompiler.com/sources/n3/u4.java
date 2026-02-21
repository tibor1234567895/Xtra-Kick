package n3;

import androidx.recyclerview.widget.RecyclerView;
import pa.e;
import ra.c;

public final class u4 extends c {

    /* renamed from: h  reason: collision with root package name */
    public c5 f11507h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f11508i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ c5 f11509j;

    /* renamed from: k  reason: collision with root package name */
    public int f11510k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public u4(c5 c5Var, e eVar) {
        super(eVar);
        this.f11509j = c5Var;
    }

    public final Object invokeSuspend(Object obj) {
        this.f11508i = obj;
        this.f11510k |= RecyclerView.UNDEFINED_DURATION;
        return this.f11509j.a(this);
    }
}
