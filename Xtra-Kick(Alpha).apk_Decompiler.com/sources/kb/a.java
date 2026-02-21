package kb;

import androidx.recyclerview.widget.RecyclerView;
import lb.v;
import pa.e;
import ra.c;

public final class a extends c {

    /* renamed from: h  reason: collision with root package name */
    public v f9259h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f9260i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ b f9261j;

    /* renamed from: k  reason: collision with root package name */
    public int f9262k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(b bVar, e eVar) {
        super(eVar);
        this.f9261j = bVar;
    }

    public final Object invokeSuspend(Object obj) {
        this.f9260i = obj;
        this.f9262k |= RecyclerView.UNDEFINED_DURATION;
        return this.f9261j.b((j) null, this);
    }
}
