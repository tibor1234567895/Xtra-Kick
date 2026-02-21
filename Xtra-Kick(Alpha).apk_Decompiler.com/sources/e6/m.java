package e6;

import androidx.recyclerview.widget.RecyclerView;
import c6.b;
import pa.e;
import ra.c;

public final class m extends c {

    /* renamed from: h  reason: collision with root package name */
    public b f5179h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f5180i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ x f5181j;

    /* renamed from: k  reason: collision with root package name */
    public int f5182k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public m(x xVar, e eVar) {
        super(eVar);
        this.f5181j = xVar;
    }

    public final Object invokeSuspend(Object obj) {
        this.f5180i = obj;
        this.f5182k |= RecyclerView.UNDEFINED_DURATION;
        return this.f5181j.g(0, this);
    }
}
