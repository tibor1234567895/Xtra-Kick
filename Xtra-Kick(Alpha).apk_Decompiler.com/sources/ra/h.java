package ra;

import pa.e;
import xa.j;
import xa.v;
import xa.w;

public abstract class h extends g implements xa.h {

    /* renamed from: h  reason: collision with root package name */
    public final int f13896h = 2;

    public h(e eVar) {
        super(eVar);
    }

    public final int getArity() {
        return this.f13896h;
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
