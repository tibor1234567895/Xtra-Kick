package kb;

import androidx.recyclerview.widget.RecyclerView;
import n3.s;
import pa.e;
import ra.c;

public final class i0 extends c {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f9329h;

    /* renamed from: i  reason: collision with root package name */
    public int f9330i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ s f9331j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i0(s sVar, e eVar) {
        super(eVar);
        this.f9331j = sVar;
    }

    public final Object invokeSuspend(Object obj) {
        this.f9329h = obj;
        this.f9330i |= RecyclerView.UNDEFINED_DURATION;
        return this.f9331j.a((Object) null, this);
    }
}
