package pa;

import wa.p;
import xa.j;
import xa.k;

public final class c extends k implements p {

    /* renamed from: h  reason: collision with root package name */
    public static final c f12748h = new c();

    public c() {
        super(2);
    }

    public final Object g(Object obj, Object obj2) {
        boolean z10;
        String str = (String) obj;
        h hVar = (h) obj2;
        j.f("acc", str);
        j.f("element", hVar);
        if (str.length() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            return hVar.toString();
        }
        return str + ", " + hVar;
    }
}
