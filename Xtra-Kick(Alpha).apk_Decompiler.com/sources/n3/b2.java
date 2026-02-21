package n3;

import androidx.recyclerview.widget.RecyclerView;
import pa.e;
import ra.c;

public final class b2 extends c {

    /* renamed from: h  reason: collision with root package name */
    public i2 f11058h;

    /* renamed from: i  reason: collision with root package name */
    public n4 f11059i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f11060j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ i2 f11061k;

    /* renamed from: l  reason: collision with root package name */
    public int f11062l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b2(i2 i2Var, e eVar) {
        super(eVar);
        this.f11061k = i2Var;
    }

    public final Object invokeSuspend(Object obj) {
        this.f11060j = obj;
        this.f11062l |= RecyclerView.UNDEFINED_DURATION;
        return i2.a(this.f11061k, (n4) null, this);
    }
}
