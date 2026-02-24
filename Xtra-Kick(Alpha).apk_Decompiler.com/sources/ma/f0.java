package ma;

import java.util.Iterator;
import ya.a;

public abstract class f0 implements Iterator, a {
    public abstract int a();

    public final /* bridge */ /* synthetic */ Object next() {
        return Integer.valueOf(a());
    }

    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
