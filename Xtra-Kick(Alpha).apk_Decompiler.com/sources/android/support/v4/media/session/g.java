package android.support.v4.media.session;

import android.media.MediaMetadata;
import android.media.session.MediaController;
import android.media.session.PlaybackState;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.media.MediaMetadataCompat;
import androidx.media.AudioAttributesCompat;
import java.lang.ref.WeakReference;
import java.util.List;

public final class g extends MediaController.Callback {

    /* renamed from: a  reason: collision with root package name */
    public final WeakReference f394a;

    public g(j jVar) {
        this.f394a = new WeakReference(jVar);
    }

    public final void onAudioInfoChanged(MediaController.PlaybackInfo playbackInfo) {
        j jVar = (j) this.f394a.get();
        if (jVar != null) {
            jVar.a(new o(playbackInfo.getPlaybackType(), AudioAttributesCompat.f(playbackInfo.getAudioAttributes()), playbackInfo.getVolumeControl(), playbackInfo.getMaxVolume(), playbackInfo.getCurrentVolume()));
        }
    }

    public final void onExtrasChanged(Bundle bundle) {
        u.p(bundle);
        j jVar = (j) this.f394a.get();
        if (jVar != null) {
            jVar.c(bundle);
        }
    }

    public final void onMetadataChanged(MediaMetadata mediaMetadata) {
        j jVar = (j) this.f394a.get();
        if (jVar != null) {
            jVar.d(MediaMetadataCompat.v(mediaMetadata));
        }
    }

    public final void onPlaybackStateChanged(PlaybackState playbackState) {
        j jVar = (j) this.f394a.get();
        if (jVar != null && jVar.f402c == null) {
            jVar.e(PlaybackStateCompat.u(playbackState));
        }
    }

    public final void onQueueChanged(List list) {
        j jVar = (j) this.f394a.get();
        if (jVar != null) {
            jVar.f(MediaSessionCompat$QueueItem.u(list));
        }
    }

    public final void onQueueTitleChanged(CharSequence charSequence) {
        j jVar = (j) this.f394a.get();
        if (jVar != null) {
            jVar.g(charSequence);
        }
    }

    public final void onSessionDestroyed() {
        j jVar = (j) this.f394a.get();
        if (jVar != null) {
            jVar.i();
        }
    }

    public final void onSessionEvent(String str, Bundle bundle) {
        u.p(bundle);
        j jVar = (j) this.f394a.get();
        if (jVar == null) {
            return;
        }
        if (jVar.f402c == null || Build.VERSION.SDK_INT >= 23) {
            jVar.j(str, bundle);
        }
    }
}
