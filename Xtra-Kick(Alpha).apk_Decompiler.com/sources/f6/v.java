package f6;

import androidx.recyclerview.widget.RecyclerView;
import n3.g4;
import pa.e;
import ra.c;

public final class v extends c {

    /* renamed from: h  reason: collision with root package name */
    public int f5891h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f5892i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ k f5893j;

    /* renamed from: k  reason: collision with root package name */
    public int f5894k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public v(k kVar, e eVar) {
        super(eVar);
        this.f5893j = kVar;
    }

    public final Object invokeSuspend(Object obj) {
        this.f5892i = obj;
        this.f5894k |= RecyclerView.UNDEFINED_DURATION;
        return this.f5893j.b((g4) null, this);
    }
}
