package n3;

import java.util.Iterator;
import wa.l;
import xa.j;
import xa.k;

public final class z4 extends k implements l {

    /* renamed from: h  reason: collision with root package name */
    public static final z4 f11618h = new z4();

    public z4() {
        super(1);
    }

    public final Object invoke(Object obj) {
        Object obj2;
        boolean z10;
        c cVar = (c) obj;
        j.f("it", cVar);
        Iterator it = cVar.f11072c.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj2 = null;
                break;
            }
            obj2 = it.next();
            if (((a) obj2).f11034a == d1.REFRESH) {
                z10 = true;
                continue;
            } else {
                z10 = false;
                continue;
            }
            if (z10) {
                break;
            }
        }
        a aVar = (a) obj2;
        if (aVar == null) {
            return null;
        }
        return aVar.f11035b;
    }
}
