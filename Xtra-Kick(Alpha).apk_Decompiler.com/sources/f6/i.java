package f6;

import com.github.andreyasadchy.xtra.model.ui.Game;
import java.util.Comparator;
import oa.b;

public final class i implements Comparator {
    public final int compare(Object obj, Object obj2) {
        return b.a(((Game) obj).getGameName(), ((Game) obj2).getGameName());
    }
}
