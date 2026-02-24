package d5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class a0 implements Iterable {

    /* renamed from: h  reason: collision with root package name */
    public final List f4336h;

    public a0() {
        this(new ArrayList(2));
    }

    public final Iterator iterator() {
        return this.f4336h.iterator();
    }

    public a0(ArrayList arrayList) {
        this.f4336h = arrayList;
    }
}
