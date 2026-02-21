package n4;

import androidx.recyclerview.widget.RecyclerView;
import pa.e;
import ra.c;

public final class g extends c {

    /* renamed from: h  reason: collision with root package name */
    public j f11663h;

    /* renamed from: i  reason: collision with root package name */
    public m f11664i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f11665j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ j f11666k;

    /* renamed from: l  reason: collision with root package name */
    public int f11667l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g(j jVar, e eVar) {
        super(eVar);
        this.f11666k = jVar;
    }

    public final Object invokeSuspend(Object obj) {
        this.f11665j = obj;
        this.f11667l |= RecyclerView.UNDEFINED_DURATION;
        return this.f11666k.d((m) null, this);
    }
}
