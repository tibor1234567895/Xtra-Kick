package e6;

import com.github.andreyasadchy.xtra.model.ui.Clip;
import java.util.Comparator;

public final class b implements Comparator {
    public final int compare(Object obj, Object obj2) {
        return oa.b.a(((Clip) obj2).getViewCount(), ((Clip) obj).getViewCount());
    }
}
