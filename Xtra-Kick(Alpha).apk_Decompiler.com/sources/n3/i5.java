package n3;

import androidx.lifecycle.p1;
import androidx.recyclerview.widget.RecyclerView;
import pa.e;
import ra.c;
import wa.a;

public final class i5 extends c {

    /* renamed from: h  reason: collision with root package name */
    public a f11257h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f11258i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ k5 f11259j;

    /* renamed from: k  reason: collision with root package name */
    public int f11260k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i5(k5 k5Var, e eVar) {
        super(eVar);
        this.f11259j = k5Var;
    }

    public final Object invokeSuspend(Object obj) {
        this.f11258i = obj;
        this.f11260k |= RecyclerView.UNDEFINED_DURATION;
        return this.f11259j.c((p1) null, this);
    }
}
