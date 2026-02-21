package kb;

import androidx.recyclerview.widget.RecyclerView;
import hb.l1;
import pa.e;
import ra.c;

public final class d1 extends c {

    /* renamed from: h  reason: collision with root package name */
    public e1 f9282h;

    /* renamed from: i  reason: collision with root package name */
    public j f9283i;

    /* renamed from: j  reason: collision with root package name */
    public g1 f9284j;

    /* renamed from: k  reason: collision with root package name */
    public l1 f9285k;

    /* renamed from: l  reason: collision with root package name */
    public Object f9286l;

    /* renamed from: m  reason: collision with root package name */
    public /* synthetic */ Object f9287m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ e1 f9288n;

    /* renamed from: o  reason: collision with root package name */
    public int f9289o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d1(e1 e1Var, e eVar) {
        super(eVar);
        this.f9288n = e1Var;
    }

    public final Object invokeSuspend(Object obj) {
        this.f9287m = obj;
        this.f9289o |= RecyclerView.UNDEFINED_DURATION;
        return this.f9288n.b((j) null, this);
    }
}
