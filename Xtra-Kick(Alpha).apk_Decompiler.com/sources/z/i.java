package z;

import android.view.View;
import java.util.Comparator;
import java.util.WeakHashMap;
import m0.c1;
import m0.o0;

public final class i implements Comparator {
    public final int compare(Object obj, Object obj2) {
        WeakHashMap weakHashMap = c1.f10054a;
        float m10 = o0.m((View) obj);
        float m11 = o0.m((View) obj2);
        if (m10 > m11) {
            return -1;
        }
        if (m10 < m11) {
            return 1;
        }
        return 0;
    }
}
