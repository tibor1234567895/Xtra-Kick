package e6;

import androidx.recyclerview.widget.RecyclerView;
import pa.e;
import ra.c;

public final class g extends c {

    /* renamed from: h  reason: collision with root package name */
    public x f5122h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f5123i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ x f5124j;

    /* renamed from: k  reason: collision with root package name */
    public int f5125k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g(x xVar, e eVar) {
        super(eVar);
        this.f5124j = xVar;
    }

    public final Object invokeSuspend(Object obj) {
        this.f5123i = obj;
        this.f5125k |= RecyclerView.UNDEFINED_DURATION;
        return this.f5124j.d(0, this);
    }
}
