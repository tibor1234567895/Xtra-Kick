package f7;

import androidx.recyclerview.widget.w;
import com.github.andreyasadchy.xtra.model.ui.Tag;
import xa.j;

public final class b extends w {
    public final boolean a(Object obj, Object obj2) {
        j.f("oldItem", (Tag) obj);
        j.f("newItem", (Tag) obj2);
        return true;
    }

    public final boolean b(Object obj, Object obj2) {
        Tag tag = (Tag) obj;
        Tag tag2 = (Tag) obj2;
        j.f("oldItem", tag);
        j.f("newItem", tag2);
        return j.a(tag.getName(), tag2.getName());
    }
}
