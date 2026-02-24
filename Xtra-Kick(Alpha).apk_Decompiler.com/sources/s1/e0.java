package s1;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.view.Surface;
import b2.f;
import j1.l0;
import java.nio.ByteBuffer;
import l1.d;

public final class e0 implements m {

    /* renamed from: a  reason: collision with root package name */
    public final MediaCodec f14000a;

    /* renamed from: b  reason: collision with root package name */
    public ByteBuffer[] f14001b;

    /* renamed from: c  reason: collision with root package name */
    public ByteBuffer[] f14002c;

    public e0(MediaCodec mediaCodec) {
        this.f14000a = mediaCodec;
        if (l0.f8453a < 21) {
            this.f14001b = mediaCodec.getInputBuffers();
            this.f14002c = mediaCodec.getOutputBuffers();
        }
    }

    public final void a() {
        this.f14001b = null;
        this.f14002c = null;
        this.f14000a.release();
    }

    public final int b(MediaCodec.BufferInfo bufferInfo) {
        int dequeueOutputBuffer;
        do {
            MediaCodec mediaCodec = this.f14000a;
            dequeueOutputBuffer = mediaCodec.dequeueOutputBuffer(bufferInfo, 0);
            if (dequeueOutputBuffer == -3 && l0.f8453a < 21) {
                this.f14002c = mediaCodec.getOutputBuffers();
                continue;
            }
        } while (dequeueOutputBuffer == -3);
        return dequeueOutputBuffer;
    }

    public final void c() {
    }

    public final void d(int i10, boolean z10) {
        this.f14000a.releaseOutputBuffer(i10, z10);
    }

    public final void e(f fVar, Handler handler) {
        this.f14000a.setOnFrameRenderedListener(new a(this, fVar, 1), handler);
    }

    public final void f(int i10) {
        this.f14000a.setVideoScalingMode(i10);
    }

    public final void flush() {
        this.f14000a.flush();
    }

    public final void g(int i10, d dVar, long j10) {
        this.f14000a.queueSecureInputBuffer(i10, 0, dVar.f9512i, j10, 0);
    }

    public final MediaFormat h() {
        return this.f14000a.getOutputFormat();
    }

    public final ByteBuffer i(int i10) {
        return l0.f8453a >= 21 ? this.f14000a.getInputBuffer(i10) : this.f14001b[i10];
    }

    public final void j(Surface surface) {
        this.f14000a.setOutputSurface(surface);
    }

    public final void k(Bundle bundle) {
        this.f14000a.setParameters(bundle);
    }

    public final ByteBuffer l(int i10) {
        return l0.f8453a >= 21 ? this.f14000a.getOutputBuffer(i10) : this.f14002c[i10];
    }

    public final void m(int i10, long j10) {
        this.f14000a.releaseOutputBuffer(i10, j10);
    }

    public final int n() {
        return this.f14000a.dequeueInputBuffer(0);
    }

    public final void o(int i10, int i11, long j10, int i12) {
        this.f14000a.queueInputBuffer(i10, 0, i11, j10, i12);
    }
}
