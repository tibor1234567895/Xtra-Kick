package sa;

import ab.c;
import ab.e;
import java.lang.reflect.Method;
import xa.j;

public class b {
    public void a(Throwable th, Throwable th2) {
        j.f("cause", th);
        j.f("exception", th2);
        Method method = a.f14455a;
        if (method != null) {
            method.invoke(th, new Object[]{th2});
        }
    }

    public e b() {
        return new c();
    }
}
