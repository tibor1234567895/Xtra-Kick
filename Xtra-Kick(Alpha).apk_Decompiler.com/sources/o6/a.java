package o6;

import androidx.recyclerview.widget.w;
import com.github.andreyasadchy.xtra.model.ui.User;
import xa.j;

public final class a extends w {
    public final boolean a(Object obj, Object obj2) {
        j.f("oldItem", (User) obj);
        j.f("newItem", (User) obj2);
        return true;
    }

    public final boolean b(Object obj, Object obj2) {
        User user = (User) obj;
        User user2 = (User) obj2;
        j.f("oldItem", user);
        j.f("newItem", user2);
        if (user.getChannelId() == user2.getChannelId()) {
            return true;
        }
        return false;
    }
}
