package l9;

import java.util.Comparator;

public final class j implements Comparator {
    public final int compare(Object obj, Object obj2) {
        return ((Comparable) obj).compareTo((Comparable) obj2);
    }
}
