package n3;

import androidx.recyclerview.widget.RecyclerView;
import ob.d;
import pa.e;
import ra.c;

public final class p2 extends c {

    /* renamed from: h  reason: collision with root package name */
    public Object f11400h;

    /* renamed from: i  reason: collision with root package name */
    public Object f11401i;

    /* renamed from: j  reason: collision with root package name */
    public Object f11402j;

    /* renamed from: k  reason: collision with root package name */
    public d f11403k;

    /* renamed from: l  reason: collision with root package name */
    public /* synthetic */ Object f11404l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ g3 f11405m;

    /* renamed from: n  reason: collision with root package name */
    public int f11406n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public p2(g3 g3Var, e eVar) {
        super(eVar);
        this.f11405m = g3Var;
    }

    public final Object invokeSuspend(Object obj) {
        this.f11404l = obj;
        this.f11406n |= RecyclerView.UNDEFINED_DURATION;
        return this.f11405m.f(this);
    }
}
