package o1;

import android.media.AudioTrack;
import android.media.metrics.LogSessionId;
import n1.e0;
import n1.f0;

public final class t {
    private t() {
    }

    public static void a(AudioTrack audioTrack, f0 f0Var) {
        e0 e0Var = f0Var.f10966a;
        e0Var.getClass();
        LogSessionId f10 = LogSessionId.LOG_SESSION_ID_NONE;
        LogSessionId logSessionId = e0Var.f10963a;
        if (!logSessionId.equals(f10)) {
            audioTrack.setLogSessionId(logSessionId);
        }
    }
}
