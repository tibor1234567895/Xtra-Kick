package la;

import java.io.Serializable;
import wa.a;
import xa.j;

public final class o implements e, Serializable {

    /* renamed from: h  reason: collision with root package name */
    public a f9806h;

    /* renamed from: i  reason: collision with root package name */
    public volatile Object f9807i = t.f9813a;

    /* renamed from: j  reason: collision with root package name */
    public final Object f9808j = this;

    public o(a aVar) {
        j.f("initializer", aVar);
        this.f9806h = aVar;
    }

    public final Object getValue() {
        Object obj;
        Object obj2 = this.f9807i;
        t tVar = t.f9813a;
        if (obj2 != tVar) {
            return obj2;
        }
        synchronized (this.f9808j) {
            obj = this.f9807i;
            if (obj == tVar) {
                a aVar = this.f9806h;
                j.c(aVar);
                obj = aVar.b();
                this.f9807i = obj;
                this.f9806h = null;
            }
        }
        return obj;
    }

    public final String toString() {
        boolean z10;
        if (this.f9807i != t.f9813a) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            return String.valueOf(getValue());
        }
        return "Lazy value not initialized yet.";
    }
}
