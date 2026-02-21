package k4;

import p1.i0;
import x4.d;

public final class l {

    /* renamed from: a  reason: collision with root package name */
    public final i0 f9118a;

    public l(i0 i0Var) {
        this.f9118a = i0Var;
    }

    public final m a() {
        f v10;
        i0 i0Var = this.f9118a;
        i iVar = (i) i0Var.f12467l;
        synchronized (iVar) {
            switch (i0Var.f12463h) {
                case 2:
                    i0Var.e(true);
                    break;
                default:
                    d.c((d) i0Var.f12467l, i0Var, true);
                    i0Var.f12464i = true;
                    break;
            }
            v10 = iVar.v(((e) i0Var.f12465j).f9085a);
        }
        if (v10 != null) {
            return new m(v10);
        }
        return null;
    }
}
