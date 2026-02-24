package n3;

import androidx.recyclerview.widget.RecyclerView;
import hb.l1;
import ob.a;
import pa.e;
import ra.c;

public final class o5 extends c {

    /* renamed from: h  reason: collision with root package name */
    public p5 f11386h;

    /* renamed from: i  reason: collision with root package name */
    public l1 f11387i;

    /* renamed from: j  reason: collision with root package name */
    public a f11388j;

    /* renamed from: k  reason: collision with root package name */
    public int f11389k;

    /* renamed from: l  reason: collision with root package name */
    public /* synthetic */ Object f11390l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ p5 f11391m;

    /* renamed from: n  reason: collision with root package name */
    public int f11392n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public o5(p5 p5Var, e eVar) {
        super(eVar);
        this.f11391m = p5Var;
    }

    public final Object invokeSuspend(Object obj) {
        this.f11390l = obj;
        this.f11392n |= RecyclerView.UNDEFINED_DURATION;
        return this.f11391m.b(0, (l1) null, this);
    }
}
