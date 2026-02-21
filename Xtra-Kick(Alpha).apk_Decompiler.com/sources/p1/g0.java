package p1;

import android.media.MediaDrm;
import android.media.metrics.LogSessionId;
import n1.b0;
import n1.e0;
import n1.f0;

public final class g0 {
    private g0() {
    }

    public static boolean a(MediaDrm mediaDrm, String str) {
        return mediaDrm.requiresSecureDecoder(str);
    }

    public static void b(MediaDrm mediaDrm, byte[] bArr, f0 f0Var) {
        e0 e0Var = f0Var.f10966a;
        e0Var.getClass();
        LogSessionId f10 = LogSessionId.LOG_SESSION_ID_NONE;
        LogSessionId logSessionId = e0Var.f10963a;
        if (!logSessionId.equals(f10)) {
            MediaDrm.PlaybackComponent d10 = mediaDrm.getPlaybackComponent(bArr);
            d10.getClass();
            b0.e(d10).setLogSessionId(logSessionId);
        }
    }
}
