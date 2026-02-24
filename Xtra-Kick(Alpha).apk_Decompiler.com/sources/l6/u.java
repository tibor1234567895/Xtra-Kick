package l6;

import androidx.appcompat.widget.j3;
import androidx.fragment.app.p0;
import hb.f0;
import hb.h0;
import la.v;
import n3.x3;
import pa.e;
import qa.a;
import ra.i;
import wa.p;

public final class u extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f9670i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ x3 f9671j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ j3 f9672k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ boolean f9673l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public u(j3 j3Var, x3 x3Var, e eVar, boolean z10) {
        super(2, eVar);
        this.f9671j = x3Var;
        this.f9672k = j3Var;
        this.f9673l = z10;
    }

    public final e create(Object obj, e eVar) {
        return new u(this.f9672k, this.f9671j, eVar, this.f9673l);
    }

    public final Object g(Object obj, Object obj2) {
        return ((u) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f9670i;
        if (i10 == 0) {
            h0.O1(obj);
            x3 x3Var = this.f9671j;
            p0 p0Var = x3Var.f11566c;
            t tVar = new t(this.f9672k, x3Var, (e) null, this.f9673l);
            this.f9670i = 1;
            if (h0.B(p0Var, tVar, this) == aVar) {
                return aVar;
            }
        } else if (i10 == 1) {
            h0.O1(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return v.f9814a;
    }
}
