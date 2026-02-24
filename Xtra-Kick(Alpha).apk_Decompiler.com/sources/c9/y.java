package c9;

import java.util.Objects;
import m1.s;

public final class y implements w {

    /* renamed from: h  reason: collision with root package name */
    public volatile w f3058h;

    /* renamed from: i  reason: collision with root package name */
    public volatile boolean f3059i;

    /* renamed from: j  reason: collision with root package name */
    public Object f3060j;

    public y(s sVar) {
        this.f3058h = sVar;
    }

    public final Object get() {
        if (!this.f3059i) {
            synchronized (this) {
                if (!this.f3059i) {
                    w wVar = this.f3058h;
                    Objects.requireNonNull(wVar);
                    Object obj = wVar.get();
                    this.f3060j = obj;
                    this.f3059i = true;
                    this.f3058h = null;
                    return obj;
                }
            }
        }
        return this.f3060j;
    }

    public final String toString() {
        Object obj = this.f3058h;
        if (obj == null) {
            String valueOf = String.valueOf(this.f3060j);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 25);
            sb2.append("<supplier that returned ");
            sb2.append(valueOf);
            sb2.append(">");
            obj = sb2.toString();
        }
        String valueOf2 = String.valueOf(obj);
        StringBuilder sb3 = new StringBuilder(valueOf2.length() + 19);
        sb3.append("Suppliers.memoize(");
        sb3.append(valueOf2);
        sb3.append(")");
        return sb3.toString();
    }
}
