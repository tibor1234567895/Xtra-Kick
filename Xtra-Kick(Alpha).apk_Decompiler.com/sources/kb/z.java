package kb;

import androidx.recyclerview.widget.RecyclerView;
import pa.e;
import ra.c;

public final class z extends c {

    /* renamed from: h  reason: collision with root package name */
    public a0 f9422h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f9423i;

    /* renamed from: j  reason: collision with root package name */
    public int f9424j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ a0 f9425k;

    /* renamed from: l  reason: collision with root package name */
    public Object f9426l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public z(a0 a0Var, e eVar) {
        super(eVar);
        this.f9425k = a0Var;
    }

    public final Object invokeSuspend(Object obj) {
        this.f9423i = obj;
        this.f9424j |= RecyclerView.UNDEFINED_DURATION;
        return this.f9425k.a((Object) null, this);
    }
}
