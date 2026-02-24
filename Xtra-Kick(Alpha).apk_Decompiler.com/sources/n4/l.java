package n4;

import androidx.recyclerview.widget.RecyclerView;
import pa.e;
import ra.c;
import s4.i;

public final class l extends c {

    /* renamed from: h  reason: collision with root package name */
    public m f11692h;

    /* renamed from: i  reason: collision with root package name */
    public k f11693i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f11694j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ m f11695k;

    /* renamed from: l  reason: collision with root package name */
    public int f11696l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public l(m mVar, e eVar) {
        super(eVar);
        this.f11695k = mVar;
    }

    public final Object invokeSuspend(Object obj) {
        this.f11694j = obj;
        this.f11696l |= RecyclerView.UNDEFINED_DURATION;
        return this.f11695k.b((i) null, this);
    }
}
