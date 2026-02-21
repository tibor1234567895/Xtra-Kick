package mb;

import hb.e2;
import pa.h;
import wa.p;
import xa.k;

public final class c0 extends k implements p {

    /* renamed from: h  reason: collision with root package name */
    public static final c0 f10842h = new c0();

    public c0() {
        super(2);
    }

    public final Object g(Object obj, Object obj2) {
        Integer num;
        int i10;
        h hVar = (h) obj2;
        if (!(hVar instanceof e2)) {
            return obj;
        }
        if (obj instanceof Integer) {
            num = (Integer) obj;
        } else {
            num = null;
        }
        if (num != null) {
            i10 = num.intValue();
        } else {
            i10 = 1;
        }
        if (i10 == 0) {
            return hVar;
        }
        return Integer.valueOf(i10 + 1);
    }
}
