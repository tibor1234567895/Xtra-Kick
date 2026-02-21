package n3;

import androidx.recyclerview.widget.RecyclerView;
import ma.e0;
import pa.e;
import ra.c;

public final class k extends c {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f11269h;

    /* renamed from: i  reason: collision with root package name */
    public int f11270i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ l f11271j;

    /* renamed from: k  reason: collision with root package name */
    public l f11272k;

    /* renamed from: l  reason: collision with root package name */
    public e0 f11273l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public k(l lVar, e eVar) {
        super(eVar);
        this.f11271j = lVar;
    }

    public final Object invokeSuspend(Object obj) {
        this.f11269h = obj;
        this.f11270i |= RecyclerView.UNDEFINED_DURATION;
        return this.f11271j.a((Object) null, this);
    }
}
