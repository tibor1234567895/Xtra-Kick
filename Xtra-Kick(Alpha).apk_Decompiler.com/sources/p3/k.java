package p3;

import android.view.Choreographer;

public final class k {
    private k() {
    }

    public static void a(Runnable runnable) {
        Choreographer.getInstance().postFrameCallback(new j(runnable));
    }
}
