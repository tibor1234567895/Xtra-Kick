package s1;

import android.media.MediaCodec;
import android.os.Handler;
import android.os.Message;
import b2.f;
import j1.l0;

public final /* synthetic */ class a implements MediaCodec.OnFrameRenderedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f13972a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ f f13973b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ m f13974c;

    public /* synthetic */ a(m mVar, f fVar, int i10) {
        this.f13972a = i10;
        this.f13974c = mVar;
        this.f13973b = fVar;
    }

    public final void onFrameRendered(MediaCodec mediaCodec, long j10, long j11) {
        switch (this.f13972a) {
            case 0:
                f fVar = this.f13973b;
                ((c) this.f13974c).getClass();
                fVar.getClass();
                if (l0.f8453a < 30) {
                    Handler handler = fVar.f2431h;
                    handler.sendMessageAtFrontOfQueue(Message.obtain(handler, 0, (int) (j10 >> 32), (int) j10));
                    return;
                }
                fVar.a(j10);
                return;
            default:
                f fVar2 = this.f13973b;
                ((e0) this.f13974c).getClass();
                fVar2.getClass();
                if (l0.f8453a < 30) {
                    Handler handler2 = fVar2.f2431h;
                    handler2.sendMessageAtFrontOfQueue(Message.obtain(handler2, 0, (int) (j10 >> 32), (int) j10));
                    return;
                }
                fVar2.a(j10);
                return;
        }
    }
}
