package f6;

import androidx.recyclerview.widget.RecyclerView;
import n3.g4;
import pa.e;
import ra.c;

public final class z extends c {

    /* renamed from: h  reason: collision with root package name */
    public int f5902h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f5903i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ b f5904j;

    /* renamed from: k  reason: collision with root package name */
    public int f5905k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public z(b bVar, e eVar) {
        super(eVar);
        this.f5904j = bVar;
    }

    public final Object invokeSuspend(Object obj) {
        this.f5903i = obj;
        this.f5905k |= RecyclerView.UNDEFINED_DURATION;
        return this.f5904j.b((g4) null, this);
    }
}
