package a7;

import android.view.View;
import com.github.andreyasadchy.xtra.model.offline.OfflineVideo;
import xa.j;

public final /* synthetic */ class b implements View.OnLongClickListener {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f268h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ d f269i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ OfflineVideo f270j;

    public /* synthetic */ b(d dVar, OfflineVideo offlineVideo, int i10) {
        this.f268h = i10;
        this.f269i = dVar;
        this.f270j = offlineVideo;
    }

    public final boolean onLongClick(View view) {
        int i10 = this.f268h;
        OfflineVideo offlineVideo = this.f270j;
        d dVar = this.f269i;
        switch (i10) {
            case 0:
                j.f("this$0", dVar);
                dVar.f276c.invoke(offlineVideo);
                return true;
            default:
                j.f("this$0", dVar);
                dVar.f276c.invoke(offlineVideo);
                return true;
        }
    }
}
