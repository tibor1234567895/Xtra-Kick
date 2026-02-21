package n3;

import androidx.recyclerview.widget.RecyclerView;
import pa.e;
import ra.c;

public final class a0 extends c {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f11036h;

    /* renamed from: i  reason: collision with root package name */
    public int f11037i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ s f11038j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a0(s sVar, e eVar) {
        super(eVar);
        this.f11038j = sVar;
    }

    public final Object invokeSuspend(Object obj) {
        this.f11036h = obj;
        this.f11037i |= RecyclerView.UNDEFINED_DURATION;
        return this.f11038j.a((Object) null, this);
    }
}
