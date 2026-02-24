package la;

import java.io.Serializable;
import wa.a;
import xa.j;

public final class w implements e, Serializable {

    /* renamed from: h  reason: collision with root package name */
    public a f9815h;

    /* renamed from: i  reason: collision with root package name */
    public Object f9816i = t.f9813a;

    public w(a aVar) {
        this.f9815h = aVar;
    }

    public final Object getValue() {
        if (this.f9816i == t.f9813a) {
            a aVar = this.f9815h;
            j.c(aVar);
            this.f9816i = aVar.b();
            this.f9815h = null;
        }
        return this.f9816i;
    }

    public final String toString() {
        boolean z10;
        if (this.f9816i != t.f9813a) {
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
