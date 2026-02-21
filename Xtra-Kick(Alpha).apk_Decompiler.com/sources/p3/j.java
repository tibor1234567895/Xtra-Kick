package p3;

import android.view.Choreographer;

public final /* synthetic */ class j implements Choreographer.FrameCallback {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Runnable f12548h;

    public /* synthetic */ j(Runnable runnable) {
        this.f12548h = runnable;
    }

    public final void doFrame(long j10) {
        this.f12548h.run();
    }
}
