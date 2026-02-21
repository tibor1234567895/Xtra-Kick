package kb;

import androidx.recyclerview.widget.RecyclerView;
import hb.l1;
import pa.e;
import qa.a;
import ra.c;

public final class r0 extends c {

    /* renamed from: h  reason: collision with root package name */
    public s0 f9373h;

    /* renamed from: i  reason: collision with root package name */
    public j f9374i;

    /* renamed from: j  reason: collision with root package name */
    public u0 f9375j;

    /* renamed from: k  reason: collision with root package name */
    public l1 f9376k;

    /* renamed from: l  reason: collision with root package name */
    public /* synthetic */ Object f9377l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ s0 f9378m;

    /* renamed from: n  reason: collision with root package name */
    public int f9379n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public r0(s0 s0Var, e eVar) {
        super(eVar);
        this.f9378m = s0Var;
    }

    public final Object invokeSuspend(Object obj) {
        this.f9377l = obj;
        this.f9379n |= RecyclerView.UNDEFINED_DURATION;
        s0.m(this.f9378m, (j) null, this);
        return a.COROUTINE_SUSPENDED;
    }
}
