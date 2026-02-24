package n7;

import androidx.recyclerview.widget.w;
import com.github.andreyasadchy.xtra.model.ui.Video;
import xa.j;

public final class a extends w {
    public final boolean a(Object obj, Object obj2) {
        Video video = (Video) obj;
        Video video2 = (Video) obj2;
        j.f("oldItem", video);
        j.f("newItem", video2);
        if (!j.a(video.getViewCount(), video2.getViewCount()) || !j.a(video.getThumbnailUrl(), video2.getThumbnailUrl()) || !j.a(video.getTitle(), video2.getTitle()) || !j.a(video.getDuration(), video2.getDuration())) {
            return false;
        }
        return true;
    }

    public final boolean b(Object obj, Object obj2) {
        Video video = (Video) obj;
        Video video2 = (Video) obj2;
        j.f("oldItem", video);
        j.f("newItem", video2);
        return j.a(video.getUuid(), video2.getUuid());
    }
}
