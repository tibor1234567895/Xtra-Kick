package a7;

import androidx.recyclerview.widget.w;
import com.github.andreyasadchy.xtra.model.offline.OfflineVideo;
import xa.j;

public final class a extends w {
    public final boolean a(Object obj, Object obj2) {
        j.f("oldItem", (OfflineVideo) obj);
        j.f("newItem", (OfflineVideo) obj2);
        return false;
    }

    public final boolean b(Object obj, Object obj2) {
        OfflineVideo offlineVideo = (OfflineVideo) obj;
        OfflineVideo offlineVideo2 = (OfflineVideo) obj2;
        j.f("oldItem", offlineVideo);
        j.f("newItem", offlineVideo2);
        if (offlineVideo.getId() == offlineVideo2.getId()) {
            return true;
        }
        return false;
    }
}
