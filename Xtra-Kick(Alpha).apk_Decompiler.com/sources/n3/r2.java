package n3;

import androidx.recyclerview.widget.RecyclerView;
import pa.e;
import ra.c;

public final class r2 extends c {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f11455h;

    /* renamed from: i  reason: collision with root package name */
    public int f11456i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ y1 f11457j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public r2(y1 y1Var, e eVar) {
        super(eVar);
        this.f11457j = y1Var;
    }

    public final Object invokeSuspend(Object obj) {
        this.f11455h = obj;
        this.f11456i |= RecyclerView.UNDEFINED_DURATION;
        return this.f11457j.a((Object) null, this);
    }
}
