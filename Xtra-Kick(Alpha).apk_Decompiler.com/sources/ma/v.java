package ma;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class v extends u {
    public static final void j(List list, Comparator comparator) {
        if (list.size() > 1) {
            Collections.sort(list, comparator);
        }
    }
}
