package ma;

import java.util.AbstractList;
import java.util.List;
import ya.b;

public abstract class h extends AbstractList implements List, b {
    public abstract int a();

    public abstract Object b(int i10);

    public final /* bridge */ Object remove(int i10) {
        return b(i10);
    }

    public final /* bridge */ int size() {
        return a();
    }
}
