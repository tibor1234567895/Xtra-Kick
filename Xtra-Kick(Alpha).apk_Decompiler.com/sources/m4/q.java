package m4;

import androidx.recyclerview.widget.RecyclerView;
import k4.m;
import pa.e;
import ra.c;

public final class q extends c {

    /* renamed from: h  reason: collision with root package name */
    public r f10585h;

    /* renamed from: i  reason: collision with root package name */
    public m f10586i;

    /* renamed from: j  reason: collision with root package name */
    public Object f10587j;

    /* renamed from: k  reason: collision with root package name */
    public /* synthetic */ Object f10588k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ r f10589l;

    /* renamed from: m  reason: collision with root package name */
    public int f10590m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public q(r rVar, e eVar) {
        super(eVar);
        this.f10589l = rVar;
    }

    public final Object invokeSuspend(Object obj) {
        this.f10588k = obj;
        this.f10590m |= RecyclerView.UNDEFINED_DURATION;
        return this.f10589l.a(this);
    }
}
