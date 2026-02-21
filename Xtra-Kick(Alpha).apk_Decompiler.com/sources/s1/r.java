package s1;

import android.media.metrics.LogSessionId;
import n1.e0;
import n1.f0;

public final class r {
    private r() {
    }

    public static void a(k kVar, f0 f0Var) {
        e0 e0Var = f0Var.f10966a;
        e0Var.getClass();
        LogSessionId f10 = LogSessionId.LOG_SESSION_ID_NONE;
        LogSessionId logSessionId = e0Var.f10963a;
        if (!logSessionId.equals(f10)) {
            kVar.f14028b.setString("log-session-id", logSessionId.getStringId());
        }
    }
}
