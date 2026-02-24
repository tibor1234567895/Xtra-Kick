package c9;

import java.io.Serializable;
import m1.s;

public final class x implements w, Serializable {

    /* renamed from: h  reason: collision with root package name */
    public final w f3055h;

    /* renamed from: i  reason: collision with root package name */
    public volatile transient boolean f3056i;

    /* renamed from: j  reason: collision with root package name */
    public transient Object f3057j;

    public x(s sVar) {
        this.f3055h = sVar;
    }

    public final Object get() {
        if (!this.f3056i) {
            synchronized (this) {
                if (!this.f3056i) {
                    Object obj = this.f3055h.get();
                    this.f3057j = obj;
                    this.f3056i = true;
                    return obj;
                }
            }
        }
        return this.f3057j;
    }

    public final String toString() {
        Object obj;
        if (this.f3056i) {
            String valueOf = String.valueOf(this.f3057j);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 25);
            sb2.append("<supplier that returned ");
            sb2.append(valueOf);
            sb2.append(">");
            obj = sb2.toString();
        } else {
            obj = this.f3055h;
        }
        String valueOf2 = String.valueOf(obj);
        StringBuilder sb3 = new StringBuilder(valueOf2.length() + 19);
        sb3.append("Suppliers.memoize(");
        sb3.append(valueOf2);
        sb3.append(")");
        return sb3.toString();
    }
}
