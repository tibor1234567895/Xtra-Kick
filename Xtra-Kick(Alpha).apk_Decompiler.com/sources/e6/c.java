package e6;

import androidx.recyclerview.widget.RecyclerView;
import pa.e;

public final class c extends ra.c {

    /* renamed from: h  reason: collision with root package name */
    public x f5086h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f5087i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ x f5088j;

    /* renamed from: k  reason: collision with root package name */
    public int f5089k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(x xVar, e eVar) {
        super(eVar);
        this.f5088j = xVar;
    }

    public final Object invokeSuspend(Object obj) {
        this.f5087i = obj;
        this.f5089k |= RecyclerView.UNDEFINED_DURATION;
        return this.f5088j.a(0, (String) null, this);
    }
}
