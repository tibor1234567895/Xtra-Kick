package kb;

import androidx.recyclerview.widget.RecyclerView;
import pa.e;
import ra.c;

public final class s extends c {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f9380h;

    /* renamed from: i  reason: collision with root package name */
    public int f9381i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ t f9382j;

    /* renamed from: k  reason: collision with root package name */
    public Object f9383k;

    /* renamed from: l  reason: collision with root package name */
    public j f9384l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public s(t tVar, e eVar) {
        super(eVar);
        this.f9382j = tVar;
    }

    public final Object invokeSuspend(Object obj) {
        this.f9380h = obj;
        this.f9381i |= RecyclerView.UNDEFINED_DURATION;
        return this.f9382j.b((j) null, this);
    }
}
