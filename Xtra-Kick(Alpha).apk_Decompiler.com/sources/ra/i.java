package ra;

import pa.e;
import xa.h;
import xa.j;
import xa.v;
import xa.w;

public abstract class i extends c implements h {

    /* renamed from: h  reason: collision with root package name */
    public final int f13897h;

    public i(int i10, e eVar) {
        super(eVar);
        this.f13897h = i10;
    }

    public final int getArity() {
        return this.f13897h;
    }

    public final String toString() {
        if (getCompletion() != null) {
            return super.toString();
        }
        v.f16819a.getClass();
        String a10 = w.a(this);
        j.e("renderLambdaToString(this)", a10);
        return a10;
    }
}
