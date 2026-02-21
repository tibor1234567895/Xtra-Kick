package m8;

import android.view.View;
import java.util.Comparator;

public final class s implements Comparator {
    public final int compare(Object obj, Object obj2) {
        return ((View) obj).getTop() - ((View) obj2).getTop();
    }
}
