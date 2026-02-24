package e6;

import androidx.recyclerview.widget.RecyclerView;
import pa.e;
import ra.c;

public final class i extends c {

    /* renamed from: h  reason: collision with root package name */
    public x f5145h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f5146i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ x f5147j;

    /* renamed from: k  reason: collision with root package name */
    public int f5148k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i(x xVar, e eVar) {
        super(eVar);
        this.f5147j = xVar;
    }

    public final Object invokeSuspend(Object obj) {
        this.f5146i = obj;
        this.f5148k |= RecyclerView.UNDEFINED_DURATION;
        return this.f5147j.e((String) null, this);
    }
}
