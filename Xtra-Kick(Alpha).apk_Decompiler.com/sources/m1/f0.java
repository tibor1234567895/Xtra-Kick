package m1;

import android.content.Context;
import android.media.metrics.LogSessionId;
import android.media.metrics.MediaMetricsManager;
import j1.v;
import n1.b0;
import n1.c0;
import n1.x;

public final class f0 {
    private f0() {
    }

    public static n1.f0 a(Context context, n0 n0Var, boolean z10) {
        c0 c0Var;
        MediaMetricsManager g10 = b0.g(context.getSystemService("media_metrics"));
        if (g10 == null) {
            c0Var = null;
        } else {
            c0Var = new c0(context, g10.createPlaybackSession());
        }
        if (c0Var == null) {
            v.g("ExoPlayerImpl", "MediaMetricsService unavailable.");
            return new n1.f0(LogSessionId.LOG_SESSION_ID_NONE);
        }
        if (z10) {
            n0Var.getClass();
            x xVar = (x) n0Var.f10394r;
            xVar.getClass();
            xVar.f11002m.a(c0Var);
        }
        return new n1.f0(c0Var.f10933c.getSessionId());
    }
}
