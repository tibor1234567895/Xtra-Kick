package android.support.v4.media;

import android.media.MediaDescription;
import android.media.browse.MediaBrowser;

public final class a {
    private a() {
    }

    public static MediaDescription a(MediaBrowser.MediaItem mediaItem) {
        return mediaItem.getDescription();
    }

    public static int b(MediaBrowser.MediaItem mediaItem) {
        return mediaItem.getFlags();
    }
}
