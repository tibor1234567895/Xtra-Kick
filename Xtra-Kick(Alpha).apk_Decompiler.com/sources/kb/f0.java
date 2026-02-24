package kb;

import hb.h0;
import la.v;
import pa.e;
import ra.i;
import wa.p;

public final class f0 extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ int f9303i;

    public f0(e eVar) {
        super(2, eVar);
    }

    public final e create(Object obj, e eVar) {
        f0 f0Var = new f0(eVar);
        f0Var.f9303i = ((Number) obj).intValue();
        return f0Var;
    }

    public final Object g(Object obj, Object obj2) {
        return ((f0) create(Integer.valueOf(((Number) obj).intValue()), (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        boolean z10;
        h0.O1(obj);
        if (this.f9303i > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        return Boolean.valueOf(z10);
    }
}
