package la;

import s.i;
import wa.a;
import xa.j;

public class f {
    public static final e a(a aVar) {
        q0.f.j("mode", 3);
        int a10 = i.a(3);
        if (a10 == 0) {
            return new o(aVar);
        }
        if (a10 == 1) {
            return new n(aVar);
        }
        if (a10 == 2) {
            return new w(aVar);
        }
        throw new g();
    }

    public static final o b(a aVar) {
        j.f("initializer", aVar);
        return new o(aVar);
    }
}
