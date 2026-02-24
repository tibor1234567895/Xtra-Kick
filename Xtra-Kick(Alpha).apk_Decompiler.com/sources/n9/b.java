package n9;

import java.lang.reflect.AccessibleObject;
import l9.g;

public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f11760a;

    static {
        b bVar;
        if (g.f9768a < 9) {
            bVar = new a();
        } else {
            bVar = new c();
        }
        f11760a = bVar;
    }

    public abstract void a(AccessibleObject accessibleObject);
}
