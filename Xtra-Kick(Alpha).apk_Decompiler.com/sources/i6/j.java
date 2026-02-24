package i6;

import com.github.andreyasadchy.xtra.model.chat.KickEmote;
import java.util.Comparator;
import oa.b;

public final class j implements Comparator {
    public final int compare(Object obj, Object obj2) {
        return b.a(((KickEmote) obj2).getSetId(), ((KickEmote) obj).getSetId());
    }
}
