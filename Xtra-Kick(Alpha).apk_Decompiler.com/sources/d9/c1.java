package d9;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.Set;

public abstract class c1 extends AbstractMap {

    /* renamed from: h  reason: collision with root package name */
    public transient Set f4599h;

    /* renamed from: i  reason: collision with root package name */
    public transient Set f4600i;

    /* renamed from: j  reason: collision with root package name */
    public transient s f4601j;

    public abstract d a();

    public Set b() {
        return new b1(this);
    }

    public final Set entrySet() {
        Set set = this.f4599h;
        if (set != null) {
            return set;
        }
        d a10 = a();
        this.f4599h = a10;
        return a10;
    }

    public Set keySet() {
        Set set = this.f4600i;
        if (set != null) {
            return set;
        }
        Set b10 = b();
        this.f4600i = b10;
        return b10;
    }

    public final Collection values() {
        s sVar = this.f4601j;
        if (sVar != null) {
            return sVar;
        }
        s sVar2 = new s(this);
        this.f4601j = sVar2;
        return sVar2;
    }
}
