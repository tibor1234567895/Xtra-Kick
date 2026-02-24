package f6;

import androidx.recyclerview.widget.RecyclerView;
import n3.g4;
import pa.e;
import ra.c;

public final class x extends c {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f5898h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ b f5899i;

    /* renamed from: j  reason: collision with root package name */
    public int f5900j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public x(b bVar, e eVar) {
        super(eVar);
        this.f5899i = bVar;
    }

    public final Object invokeSuspend(Object obj) {
        this.f5898h = obj;
        this.f5900j |= RecyclerView.UNDEFINED_DURATION;
        return this.f5899i.b((g4) null, this);
    }
}
