package f6;

import androidx.recyclerview.widget.RecyclerView;
import n3.g4;
import pa.e;
import ra.c;

public final class w extends c {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f5895h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ b f5896i;

    /* renamed from: j  reason: collision with root package name */
    public int f5897j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public w(b bVar, e eVar) {
        super(eVar);
        this.f5896i = bVar;
    }

    public final Object invokeSuspend(Object obj) {
        this.f5895h = obj;
        this.f5897j |= RecyclerView.UNDEFINED_DURATION;
        return this.f5896i.b((g4) null, this);
    }
}
