package b2;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.Choreographer;
import j1.l0;
import j1.v;

public final class s implements Choreographer.FrameCallback, Handler.Callback {

    /* renamed from: l  reason: collision with root package name */
    public static final s f2479l = new s();

    /* renamed from: h  reason: collision with root package name */
    public volatile long f2480h = -9223372036854775807L;

    /* renamed from: i  reason: collision with root package name */
    public final Handler f2481i;

    /* renamed from: j  reason: collision with root package name */
    public Choreographer f2482j;

    /* renamed from: k  reason: collision with root package name */
    public int f2483k;

    private s() {
        HandlerThread handlerThread = new HandlerThread("ExoPlayer:FrameReleaseChoreographer");
        handlerThread.start();
        Looper looper = handlerThread.getLooper();
        int i10 = l0.f8453a;
        Handler handler = new Handler(looper, this);
        this.f2481i = handler;
        handler.sendEmptyMessage(0);
    }

    public final void doFrame(long j10) {
        this.f2480h = j10;
        Choreographer choreographer = this.f2482j;
        choreographer.getClass();
        choreographer.postFrameCallbackDelayed(this, 500);
    }

    public final boolean handleMessage(Message message) {
        int i10 = message.what;
        if (i10 == 0) {
            try {
                this.f2482j = Choreographer.getInstance();
            } catch (RuntimeException e10) {
                v.h("VideoFrameReleaseHelper", "Vsync sampling disabled due to platform error", e10);
            }
            return true;
        } else if (i10 == 1) {
            Choreographer choreographer = this.f2482j;
            if (choreographer != null) {
                int i11 = this.f2483k + 1;
                this.f2483k = i11;
                if (i11 == 1) {
                    choreographer.postFrameCallback(this);
                }
            }
            return true;
        } else if (i10 != 2) {
            return false;
        } else {
            Choreographer choreographer2 = this.f2482j;
            if (choreographer2 != null) {
                int i12 = this.f2483k - 1;
                this.f2483k = i12;
                if (i12 == 0) {
                    choreographer2.removeFrameCallback(this);
                    this.f2480h = -9223372036854775807L;
                }
            }
            return true;
        }
    }
}
