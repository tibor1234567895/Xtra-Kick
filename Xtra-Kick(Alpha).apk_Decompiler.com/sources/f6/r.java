package f6;

import androidx.recyclerview.widget.RecyclerView;
import n3.g4;
import pa.e;
import ra.c;

public final class r extends c {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f5880h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ s f5881i;

    /* renamed from: j  reason: collision with root package name */
    public int f5882j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public r(s sVar, e eVar) {
        super(eVar);
        this.f5881i = sVar;
    }

    public final Object invokeSuspend(Object obj) {
        this.f5880h = obj;
        this.f5882j |= RecyclerView.UNDEFINED_DURATION;
        return this.f5881i.b((g4) null, this);
    }
}
