package z6;

import androidx.recyclerview.widget.w;
import com.github.andreyasadchy.xtra.model.offline.Bookmark;
import xa.j;

public final class a extends w {
    public final boolean a(Object obj, Object obj2) {
        Bookmark bookmark = (Bookmark) obj;
        Bookmark bookmark2 = (Bookmark) obj2;
        j.f("oldItem", bookmark);
        j.f("newItem", bookmark2);
        if (!j.a(bookmark.getTitle(), bookmark2.getTitle()) || !j.a(bookmark.getDuration(), bookmark2.getDuration())) {
            return false;
        }
        return true;
    }

    public final boolean b(Object obj, Object obj2) {
        Bookmark bookmark = (Bookmark) obj;
        Bookmark bookmark2 = (Bookmark) obj2;
        j.f("oldItem", bookmark);
        j.f("newItem", bookmark2);
        if (bookmark.getId() == bookmark2.getId()) {
            return true;
        }
        return false;
    }
}
