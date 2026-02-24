package j9;

import java.util.ArrayList;
import java.util.Iterator;

public final class p extends s implements Iterable {

    /* renamed from: h  reason: collision with root package name */
    public final ArrayList f8876h = new ArrayList();

    public final int a() {
        ArrayList arrayList = this.f8876h;
        if (arrayList.size() == 1) {
            return ((s) arrayList.get(0)).a();
        }
        throw new IllegalStateException();
    }

    public final String e() {
        ArrayList arrayList = this.f8876h;
        if (arrayList.size() == 1) {
            return ((s) arrayList.get(0)).e();
        }
        throw new IllegalStateException();
    }

    public final boolean equals(Object obj) {
        return obj == this || ((obj instanceof p) && ((p) obj).f8876h.equals(this.f8876h));
    }

    public final int hashCode() {
        return this.f8876h.hashCode();
    }

    public final Iterator iterator() {
        return this.f8876h.iterator();
    }
}
