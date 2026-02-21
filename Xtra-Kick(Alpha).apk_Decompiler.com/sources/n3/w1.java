package n3;

import i6.g;
import la.v;
import wa.a;
import xa.i;

public final /* synthetic */ class w1 extends i implements a {

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ int f11536q;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public w1(int i10, Object obj) {
        super(0, obj, i2.class, "refresh", "refresh()V");
        this.f11536q = i10;
        if (i10 == 1) {
            super(0, obj, i2.class, "invalidate", "invalidate()V");
        } else if (i10 == 2) {
            super(0, obj, i2.class, "invalidate", "invalidate()V");
        } else if (i10 != 3) {
        } else {
            super(0, obj, g.class, "getCurrentPosition", "getCurrentPosition()D");
        }
    }

    public final Object b() {
        switch (this.f11536q) {
            case 0:
                i();
                return v.f9814a;
            case 1:
                i();
                return v.f9814a;
            case 2:
                i();
                return v.f9814a;
            default:
                return Double.valueOf(((g) this.f16801i).j());
        }
    }

    public final void i() {
        int i10 = this.f11536q;
        Object obj = this.f16801i;
        switch (i10) {
            case 0:
                ((i2) obj).f11253d.a(Boolean.TRUE);
                return;
            case 1:
                ((i2) obj).f11253d.a(Boolean.FALSE);
                return;
            default:
                ((i2) obj).f11253d.a(Boolean.FALSE);
                return;
        }
    }
}
