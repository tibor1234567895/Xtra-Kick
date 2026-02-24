package n3;

import androidx.recyclerview.widget.RecyclerView;
import hb.l1;
import ob.d;
import pa.e;
import ra.c;

public final class n5 extends c {

    /* renamed from: h  reason: collision with root package name */
    public p5 f11360h;

    /* renamed from: i  reason: collision with root package name */
    public l1 f11361i;

    /* renamed from: j  reason: collision with root package name */
    public d f11362j;

    /* renamed from: k  reason: collision with root package name */
    public /* synthetic */ Object f11363k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ p5 f11364l;

    /* renamed from: m  reason: collision with root package name */
    public int f11365m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public n5(p5 p5Var, e eVar) {
        super(eVar);
        this.f11364l = p5Var;
    }

    public final Object invokeSuspend(Object obj) {
        this.f11363k = obj;
        this.f11365m |= RecyclerView.UNDEFINED_DURATION;
        return this.f11364l.a((l1) null, this);
    }
}
