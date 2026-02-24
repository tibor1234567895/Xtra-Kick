package android.support.v4.media.session;

import android.media.session.MediaController;
import android.net.Uri;
import android.os.Bundle;

public class s extends r {
    public s(MediaController.TransportControls transportControls) {
        super(transportControls);
    }

    public final void b() {
        this.f413a.prepare();
    }

    public final void c(Bundle bundle, String str) {
        this.f413a.prepareFromMediaId(str, bundle);
    }

    public final void d(Bundle bundle, String str) {
        this.f413a.prepareFromSearch(str, bundle);
    }

    public final void e(Uri uri, Bundle bundle) {
        this.f413a.prepareFromUri(uri, bundle);
    }
}
