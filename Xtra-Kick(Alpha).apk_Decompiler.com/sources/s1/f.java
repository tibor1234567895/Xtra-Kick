package s1;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.HandlerThread;
import java.util.ArrayDeque;

public final class f extends MediaCodec.Callback {

    /* renamed from: a  reason: collision with root package name */
    public final Object f14003a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public final HandlerThread f14004b;

    /* renamed from: c  reason: collision with root package name */
    public Handler f14005c;

    /* renamed from: d  reason: collision with root package name */
    public final j f14006d;

    /* renamed from: e  reason: collision with root package name */
    public final j f14007e;

    /* renamed from: f  reason: collision with root package name */
    public final ArrayDeque f14008f;

    /* renamed from: g  reason: collision with root package name */
    public final ArrayDeque f14009g;

    /* renamed from: h  reason: collision with root package name */
    public MediaFormat f14010h;

    /* renamed from: i  reason: collision with root package name */
    public MediaFormat f14011i;

    /* renamed from: j  reason: collision with root package name */
    public MediaCodec.CodecException f14012j;

    /* renamed from: k  reason: collision with root package name */
    public long f14013k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f14014l;

    /* renamed from: m  reason: collision with root package name */
    public IllegalStateException f14015m;

    public f(HandlerThread handlerThread) {
        this.f14004b = handlerThread;
        this.f14006d = new j();
        this.f14007e = new j();
        this.f14008f = new ArrayDeque();
        this.f14009g = new ArrayDeque();
    }

    public final void a() {
        ArrayDeque arrayDeque = this.f14009g;
        if (!arrayDeque.isEmpty()) {
            this.f14011i = (MediaFormat) arrayDeque.getLast();
        }
        j jVar = this.f14006d;
        jVar.f14022a = 0;
        jVar.f14023b = -1;
        jVar.f14024c = 0;
        j jVar2 = this.f14007e;
        jVar2.f14022a = 0;
        jVar2.f14023b = -1;
        jVar2.f14024c = 0;
        this.f14008f.clear();
        arrayDeque.clear();
    }

    public final void b(IllegalStateException illegalStateException) {
        synchronized (this.f14003a) {
            this.f14015m = illegalStateException;
        }
    }

    public final void onError(MediaCodec mediaCodec, MediaCodec.CodecException codecException) {
        synchronized (this.f14003a) {
            this.f14012j = codecException;
        }
    }

    public final void onInputBufferAvailable(MediaCodec mediaCodec, int i10) {
        synchronized (this.f14003a) {
            this.f14006d.a(i10);
        }
    }

    public final void onOutputBufferAvailable(MediaCodec mediaCodec, int i10, MediaCodec.BufferInfo bufferInfo) {
        synchronized (this.f14003a) {
            MediaFormat mediaFormat = this.f14011i;
            if (mediaFormat != null) {
                this.f14007e.a(-2);
                this.f14009g.add(mediaFormat);
                this.f14011i = null;
            }
            this.f14007e.a(i10);
            this.f14008f.add(bufferInfo);
        }
    }

    public final void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        synchronized (this.f14003a) {
            this.f14007e.a(-2);
            this.f14009g.add(mediaFormat);
            this.f14011i = null;
        }
    }
}
