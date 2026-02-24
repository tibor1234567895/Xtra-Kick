package f6;

import la.h;
import n3.g4;
import n3.h4;
import n3.k4;
import n3.n4;
import n3.o4;
import pa.e;

public final class q extends n4 {
    public final Integer a(o4 o4Var) {
        int i10;
        Integer num;
        Integer num2;
        Integer num3 = o4Var.f11383b;
        if (num3 != null) {
            k4 a10 = o4Var.a(num3.intValue());
            if (a10 != null && (num2 = (Integer) a10.f11288b) != null) {
                i10 = num2.intValue() + 1;
            } else if (!(a10 == null || (num = (Integer) a10.f11289c) == null)) {
                i10 = num.intValue() - 1;
            }
            return Integer.valueOf(i10);
        }
        return null;
    }

    public final Object b(g4 g4Var, e eVar) {
        return new h4(new h("FollowedVideosDataSource"));
    }
}
