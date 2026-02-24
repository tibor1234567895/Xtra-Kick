package android.support.v4.media.session;

import android.media.session.MediaController;

public final class t extends s {
    public t(MediaController.TransportControls transportControls) {
        super(transportControls);
    }

    public final void g(float f10) {
        if (f10 != 0.0f) {
            this.f413a.setPlaybackSpeed(f10);
            return;
        }
        throw new IllegalArgumentException("speed must not be zero");
    }
}
