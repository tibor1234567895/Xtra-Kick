package android.support.v4.media.session;

import android.media.MediaDescription;
import android.media.session.MediaSession;

public final class k0 {
    private k0() {
    }

    public static MediaSession.QueueItem a(MediaDescription mediaDescription, long j10) {
        return new MediaSession.QueueItem(mediaDescription, j10);
    }

    public static MediaDescription b(MediaSession.QueueItem queueItem) {
        return queueItem.getDescription();
    }

    public static long c(MediaSession.QueueItem queueItem) {
        return queueItem.getQueueId();
    }
}
