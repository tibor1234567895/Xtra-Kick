package kb;

import androidx.recyclerview.widget.RecyclerView;
import pa.e;
import ra.c;

public final class k extends c {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f9340h;

    /* renamed from: i  reason: collision with root package name */
    public int f9341i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ l f9342j;

    /* renamed from: k  reason: collision with root package name */
    public l f9343k;

    /* renamed from: l  reason: collision with root package name */
    public j f9344l;

    /* renamed from: m  reason: collision with root package name */
    public int f9345m;

    /* renamed from: n  reason: collision with root package name */
    public int f9346n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public k(l lVar, e eVar) {
        super(eVar);
        this.f9342j = lVar;
    }

    public final Object invokeSuspend(Object obj) {
        this.f9340h = obj;
        this.f9341i |= RecyclerView.UNDEFINED_DURATION;
        return this.f9342j.b((j) null, this);
    }
}
