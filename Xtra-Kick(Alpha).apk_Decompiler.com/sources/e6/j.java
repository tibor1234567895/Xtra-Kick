package e6;

import androidx.recyclerview.widget.RecyclerView;
import pa.e;
import ra.c;

public final class j extends c {

    /* renamed from: h  reason: collision with root package name */
    public x f5157h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f5158i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ x f5159j;

    /* renamed from: k  reason: collision with root package name */
    public int f5160k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public j(x xVar, e eVar) {
        super(eVar);
        this.f5159j = xVar;
    }

    public final Object invokeSuspend(Object obj) {
        this.f5158i = obj;
        this.f5160k |= RecyclerView.UNDEFINED_DURATION;
        return this.f5159j.f((String) null, this);
    }
}
