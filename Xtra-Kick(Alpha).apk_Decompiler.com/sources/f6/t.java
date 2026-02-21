package f6;

import androidx.recyclerview.widget.RecyclerView;
import n3.g4;
import pa.e;
import ra.c;

public final class t extends c {

    /* renamed from: h  reason: collision with root package name */
    public int f5887h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f5888i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ s f5889j;

    /* renamed from: k  reason: collision with root package name */
    public int f5890k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public t(s sVar, e eVar) {
        super(eVar);
        this.f5889j = sVar;
    }

    public final Object invokeSuspend(Object obj) {
        this.f5888i = obj;
        this.f5890k |= RecyclerView.UNDEFINED_DURATION;
        return this.f5889j.b((g4) null, this);
    }
}
