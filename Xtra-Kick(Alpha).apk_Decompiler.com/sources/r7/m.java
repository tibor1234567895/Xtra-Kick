package r7;

import androidx.recyclerview.widget.w;
import com.github.andreyasadchy.xtra.model.chat.Emote;
import xa.j;

public final class m extends w {
    public final boolean a(Object obj, Object obj2) {
        j.f("oldItem", (Emote) obj);
        j.f("newItem", (Emote) obj2);
        return true;
    }

    public final boolean b(Object obj, Object obj2) {
        Emote emote = (Emote) obj;
        Emote emote2 = (Emote) obj2;
        j.f("oldItem", emote);
        j.f("newItem", emote2);
        return j.a(emote.getName(), emote2.getName());
    }
}
