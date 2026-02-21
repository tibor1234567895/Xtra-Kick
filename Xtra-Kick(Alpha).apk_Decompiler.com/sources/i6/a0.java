package i6;

import com.github.andreyasadchy.xtra.model.chat.Emote;
import com.github.andreyasadchy.xtra.model.chat.StvEmote;
import java.util.Comparator;
import oa.b;

public final class a0 implements Comparator {
    public final int compare(Object obj, Object obj2) {
        return b.a(Boolean.valueOf(((Emote) obj) instanceof StvEmote), Boolean.valueOf(((Emote) obj2) instanceof StvEmote));
    }
}
