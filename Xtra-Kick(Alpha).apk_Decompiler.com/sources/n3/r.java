package n3;

import androidx.recyclerview.widget.RecyclerView;
import pa.e;
import ra.c;

public final class r extends c {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f11448h;

    /* renamed from: i  reason: collision with root package name */
    public int f11449i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ s f11450j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public r(s sVar, e eVar) {
        super(eVar);
        this.f11450j = sVar;
    }

    public final Object invokeSuspend(Object obj) {
        this.f11448h = obj;
        this.f11449i |= RecyclerView.UNDEFINED_DURATION;
        return this.f11450j.a((Object) null, this);
    }
}
