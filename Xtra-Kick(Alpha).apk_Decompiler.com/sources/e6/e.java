package e6;

import androidx.recyclerview.widget.RecyclerView;
import ra.c;

public final class e extends c {

    /* renamed from: h  reason: collision with root package name */
    public x f5101h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f5102i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ x f5103j;

    /* renamed from: k  reason: collision with root package name */
    public int f5104k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(x xVar, pa.e eVar) {
        super(eVar);
        this.f5103j = xVar;
    }

    public final Object invokeSuspend(Object obj) {
        this.f5102i = obj;
        this.f5104k |= RecyclerView.UNDEFINED_DURATION;
        return this.f5103j.b(0, (String) null, (String) null, this);
    }
}
