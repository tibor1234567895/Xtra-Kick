package s1;

import android.os.HandlerThread;
import c9.w;

public final /* synthetic */ class b implements w {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f13975h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f13976i;

    public /* synthetic */ b(int i10, int i11) {
        this.f13975h = i11;
        this.f13976i = i10;
    }

    public final Object get() {
        int i10 = this.f13975h;
        int i11 = this.f13976i;
        switch (i10) {
            case 0:
                return new HandlerThread(c.q(i11, "ExoPlayer:MediaCodecAsyncAdapter:"));
            default:
                return new HandlerThread(c.q(i11, "ExoPlayer:MediaCodecQueueingThread:"));
        }
    }
}
