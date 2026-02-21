package android.support.v4.media;

import android.media.MediaDescription;
import android.net.Uri;

public final class w {
    private w() {
    }

    public static Uri a(MediaDescription mediaDescription) {
        return mediaDescription.getMediaUri();
    }

    public static void b(MediaDescription.Builder builder, Uri uri) {
        builder.setMediaUri(uri);
    }
}
