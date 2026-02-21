package kb;

import androidx.recyclerview.widget.RecyclerView;
import jb.r;
import pa.e;

public final class c extends ra.c {

    /* renamed from: h  reason: collision with root package name */
    public r f9269h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f9270i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ d f9271j;

    /* renamed from: k  reason: collision with root package name */
    public int f9272k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(d dVar, e eVar) {
        super(eVar);
        this.f9271j = dVar;
    }

    public final Object invokeSuspend(Object obj) {
        this.f9270i = obj;
        this.f9272k |= RecyclerView.UNDEFINED_DURATION;
        return this.f9271j.f((r) null, this);
    }
}
