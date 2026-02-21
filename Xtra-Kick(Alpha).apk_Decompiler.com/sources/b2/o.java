package b2;

import android.view.Surface;
import j1.v;

public final class o {
    private o() {
    }

    public static void a(Surface surface, float f10) {
        try {
            surface.setFrameRate(f10, f10 == 0.0f ? 0 : 1);
        } catch (IllegalStateException e10) {
            v.d("VideoFrameReleaseHelper", "Failed to call Surface.setFrameRate", e10);
        }
    }
}
