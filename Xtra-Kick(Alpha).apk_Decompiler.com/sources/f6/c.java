package f6;

import androidx.recyclerview.widget.RecyclerView;
import n3.g4;
import pa.e;

public final class c extends ra.c {

    /* renamed from: h  reason: collision with root package name */
    public d f5839h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f5840i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ d f5841j;

    /* renamed from: k  reason: collision with root package name */
    public int f5842k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(d dVar, e eVar) {
        super(eVar);
        this.f5841j = dVar;
    }

    public final Object invokeSuspend(Object obj) {
        this.f5840i = obj;
        this.f5842k |= RecyclerView.UNDEFINED_DURATION;
        return this.f5841j.b((g4) null, this);
    }
}
