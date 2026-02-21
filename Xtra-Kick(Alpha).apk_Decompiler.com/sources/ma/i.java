package ma;

import java.util.AbstractSet;
import java.util.Set;
import ya.b;

public abstract class i extends AbstractSet implements Set, b {
    public abstract int a();

    public final /* bridge */ int size() {
        return a();
    }
}
