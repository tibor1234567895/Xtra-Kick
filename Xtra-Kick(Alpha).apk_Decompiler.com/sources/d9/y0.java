package d9;

import c9.q;
import java.util.Iterator;
import java.util.NoSuchElementException;

public enum y0 implements Iterator {
    ;

    /* access modifiers changed from: public */
    y0() {
    }

    public final boolean hasNext() {
        return false;
    }

    public final Object next() {
        throw new NoSuchElementException();
    }

    public final void remove() {
        q.f("no calls to next() since the last call to remove()", false);
    }
}
