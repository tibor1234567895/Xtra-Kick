package i7;

import androidx.recyclerview.widget.w;
import com.github.andreyasadchy.xtra.model.ui.Stream;
import xa.j;

public final class d extends w {
    public final boolean a(Object obj, Object obj2) {
        Stream stream = (Stream) obj;
        Stream stream2 = (Stream) obj2;
        j.f("oldItem", stream);
        j.f("newItem", stream2);
        if (!j.a(stream.getViewerCount(), stream2.getViewerCount()) || !j.a(stream.getGameName(), stream2.getGameName()) || !j.a(stream.getTitle(), stream2.getTitle())) {
            return false;
        }
        return true;
    }

    public final boolean b(Object obj, Object obj2) {
        Stream stream = (Stream) obj;
        Stream stream2 = (Stream) obj2;
        j.f("oldItem", stream);
        j.f("newItem", stream2);
        if (stream.getId() == stream2.getId()) {
            return true;
        }
        return false;
    }
}
