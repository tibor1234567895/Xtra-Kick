package j6;

import androidx.recyclerview.widget.w;
import com.github.andreyasadchy.xtra.model.ui.Clip;
import xa.j;

public final class b extends w {
    public final boolean a(Object obj, Object obj2) {
        Clip clip = (Clip) obj;
        Clip clip2 = (Clip) obj2;
        j.f("oldItem", clip);
        j.f("newItem", clip2);
        if (!j.a(clip.getViewCount(), clip2.getViewCount()) || !j.a(clip.getTitle(), clip2.getTitle())) {
            return false;
        }
        return true;
    }

    public final boolean b(Object obj, Object obj2) {
        Clip clip = (Clip) obj;
        Clip clip2 = (Clip) obj2;
        j.f("oldItem", clip);
        j.f("newItem", clip2);
        return j.a(clip.getUuid(), clip2.getUuid());
    }
}
