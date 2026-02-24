package android.support.v4.media;

import android.os.Bundle;
import android.support.v4.media.session.u;
import java.util.List;

public final class q extends p {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ r f342b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public q(r rVar) {
        super(rVar);
        this.f342b = rVar;
    }

    public final void onChildrenLoaded(String str, List list, Bundle bundle) {
        u.p(bundle);
        MediaBrowserCompat$MediaItem.u(list);
        this.f342b.getClass();
    }

    public final void onError(String str, Bundle bundle) {
        u.p(bundle);
        this.f342b.getClass();
    }
}
