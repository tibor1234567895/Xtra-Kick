package ma;

import java.util.AbstractCollection;
import java.util.Collection;
import ya.b;

public abstract class g extends AbstractCollection implements Collection, b {
    public abstract int a();

    public final /* bridge */ int size() {
        return a();
    }
}
