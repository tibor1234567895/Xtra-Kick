package f6;

import com.github.andreyasadchy.xtra.model.ui.Stream;
import java.util.Comparator;
import oa.b;

public final class l implements Comparator {
    public final int compare(Object obj, Object obj2) {
        return b.a(((Stream) obj2).getViewerCount(), ((Stream) obj).getViewerCount());
    }
}
