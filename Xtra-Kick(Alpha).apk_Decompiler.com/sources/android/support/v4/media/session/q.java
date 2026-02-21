package android.support.v4.media.session;

import android.media.session.MediaController;
import android.net.Uri;
import android.os.Bundle;

public class q extends p {

    /* renamed from: a  reason: collision with root package name */
    public final MediaController.TransportControls f413a;

    public q(MediaController.TransportControls transportControls) {
        this.f413a = transportControls;
    }

    public void a(Uri uri, Bundle bundle) {
        if (uri == null || Uri.EMPTY.equals(uri)) {
            throw new IllegalArgumentException("You must specify a non-empty Uri for playFromUri.");
        }
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("android.support.v4.media.session.action.ARGUMENT_URI", uri);
        bundle2.putBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS", bundle);
        f(bundle2, "android.support.v4.media.session.action.PLAY_FROM_URI");
    }

    public void b() {
        f((Bundle) null, "android.support.v4.media.session.action.PREPARE");
    }

    public void c(Bundle bundle, String str) {
        Bundle bundle2 = new Bundle();
        bundle2.putString("android.support.v4.media.session.action.ARGUMENT_MEDIA_ID", str);
        bundle2.putBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS", bundle);
        f(bundle2, "android.support.v4.media.session.action.PREPARE_FROM_MEDIA_ID");
    }

    public void d(Bundle bundle, String str) {
        Bundle bundle2 = new Bundle();
        bundle2.putString("android.support.v4.media.session.action.ARGUMENT_QUERY", str);
        bundle2.putBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS", bundle);
        f(bundle2, "android.support.v4.media.session.action.PREPARE_FROM_SEARCH");
    }

    public void e(Uri uri, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("android.support.v4.media.session.action.ARGUMENT_URI", uri);
        bundle2.putBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS", bundle);
        f(bundle2, "android.support.v4.media.session.action.PREPARE_FROM_URI");
    }

    public final void f(Bundle bundle, String str) {
        u.Q(bundle, str);
        this.f413a.sendCustomAction(str, bundle);
    }

    public void g(float f10) {
        if (f10 != 0.0f) {
            Bundle bundle = new Bundle();
            bundle.putFloat("android.support.v4.media.session.action.ARGUMENT_PLAYBACK_SPEED", f10);
            f(bundle, "android.support.v4.media.session.action.SET_PLAYBACK_SPEED");
            return;
        }
        throw new IllegalArgumentException("speed must not be zero");
    }
}
