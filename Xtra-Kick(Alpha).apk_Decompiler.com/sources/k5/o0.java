package k5;

import android.media.MediaExtractor;
import android.media.MediaMetadataRetriever;
import java.nio.ByteBuffer;

public final class o0 implements p0 {
    public final void a(MediaMetadataRetriever mediaMetadataRetriever, Object obj) {
        mediaMetadataRetriever.setDataSource(new n0((ByteBuffer) obj));
    }

    public final void b(MediaExtractor mediaExtractor, Object obj) {
        mediaExtractor.setDataSource(new n0((ByteBuffer) obj));
    }
}
