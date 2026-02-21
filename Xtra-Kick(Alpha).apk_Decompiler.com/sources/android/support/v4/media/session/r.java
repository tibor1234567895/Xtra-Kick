package android.support.v4.media.session;

import android.media.session.MediaController;
import android.net.Uri;
import android.os.Bundle;

public class r extends q {
    public r(MediaController.TransportControls transportControls) {
        super(transportControls);
    }

    public final void a(Uri uri, Bundle bundle) {
        this.f413a.playFromUri(uri, bundle);
    }
}
