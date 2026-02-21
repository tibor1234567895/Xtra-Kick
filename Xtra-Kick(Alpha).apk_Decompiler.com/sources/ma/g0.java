package ma;

import java.util.Iterator;
import ya.a;

public abstract class g0 implements Iterator, a {
    public abstract long a();

    public final /* bridge */ /* synthetic */ Object next() {
        return Long.valueOf(a());
    }

    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
