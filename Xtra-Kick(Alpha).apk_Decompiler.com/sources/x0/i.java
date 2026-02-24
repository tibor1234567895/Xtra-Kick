package x0;

import android.media.MediaDataSource;
import android.media.MediaMetadataRetriever;

public final class i {
    private i() {
    }

    public static void a(MediaMetadataRetriever mediaMetadataRetriever, MediaDataSource mediaDataSource) {
        mediaMetadataRetriever.setDataSource(mediaDataSource);
    }
}
