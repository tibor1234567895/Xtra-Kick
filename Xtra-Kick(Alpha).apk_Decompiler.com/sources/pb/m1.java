package pb;

import dc.h0;
import dc.k;
import dc.v;
import xa.j;

public final class m1 extends o1 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ o1 f12908a;

    public m1(o1 o1Var) {
        this.f12908a = o1Var;
    }

    public final long contentLength() {
        return -1;
    }

    public final x0 contentType() {
        return this.f12908a.contentType();
    }

    public final boolean isOneShot() {
        return this.f12908a.isOneShot();
    }

    public final void writeTo(k kVar) {
        j.f("sink", kVar);
        h0 n10 = hb.h0.n(new v(kVar));
        this.f12908a.writeTo(n10);
        n10.close();
    }
}
