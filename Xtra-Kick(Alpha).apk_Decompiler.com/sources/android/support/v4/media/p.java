package android.support.v4.media;

import android.media.browse.MediaBrowser;
import java.util.List;

public class p extends MediaBrowser.SubscriptionCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ r f341a;

    public p(r rVar) {
        this.f341a = rVar;
    }

    public final void onChildrenLoaded(String str, List list) {
        this.f341a.getClass();
        MediaBrowserCompat$MediaItem.u(list);
    }

    public final void onError(String str) {
        this.f341a.getClass();
    }
}
