package s1;

import android.media.MediaCodec;
import android.os.HandlerThread;
import android.support.v4.media.session.w;
import j1.g;
import java.util.ArrayDeque;
import java.util.concurrent.atomic.AtomicReference;

public final class e {

    /* renamed from: g  reason: collision with root package name */
    public static final ArrayDeque f13992g = new ArrayDeque();

    /* renamed from: h  reason: collision with root package name */
    public static final Object f13993h = new Object();

    /* renamed from: a  reason: collision with root package name */
    public final MediaCodec f13994a;

    /* renamed from: b  reason: collision with root package name */
    public final HandlerThread f13995b;

    /* renamed from: c  reason: collision with root package name */
    public w f13996c;

    /* renamed from: d  reason: collision with root package name */
    public final AtomicReference f13997d = new AtomicReference();

    /* renamed from: e  reason: collision with root package name */
    public final g f13998e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f13999f;

    public e(MediaCodec mediaCodec, HandlerThread handlerThread) {
        g gVar = new g();
        this.f13994a = mediaCodec;
        this.f13995b = handlerThread;
        this.f13998e = gVar;
    }

    public static void c(d dVar) {
        ArrayDeque arrayDeque = f13992g;
        synchronized (arrayDeque) {
            arrayDeque.add(dVar);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002d, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002e, code lost:
        java.lang.Thread.currentThread().interrupt();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003a, code lost:
        throw new java.lang.IllegalStateException(r0);
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a() {
        /*
            r3 = this;
            boolean r0 = r3.f13999f
            if (r0 == 0) goto L_0x003b
            android.support.v4.media.session.w r0 = r3.f13996c     // Catch:{ InterruptedException -> 0x002d }
            r0.getClass()     // Catch:{ InterruptedException -> 0x002d }
            r1 = 0
            r0.removeCallbacksAndMessages(r1)     // Catch:{ InterruptedException -> 0x002d }
            j1.g r0 = r3.f13998e     // Catch:{ InterruptedException -> 0x002d }
            r0.a()     // Catch:{ InterruptedException -> 0x002d }
            android.support.v4.media.session.w r1 = r3.f13996c     // Catch:{ InterruptedException -> 0x002d }
            r1.getClass()     // Catch:{ InterruptedException -> 0x002d }
            r2 = 2
            android.os.Message r1 = r1.obtainMessage(r2)     // Catch:{ InterruptedException -> 0x002d }
            r1.sendToTarget()     // Catch:{ InterruptedException -> 0x002d }
            monitor-enter(r0)     // Catch:{ InterruptedException -> 0x002d }
        L_0x0020:
            boolean r1 = r0.f8430a     // Catch:{ all -> 0x002a }
            if (r1 != 0) goto L_0x0028
            r0.wait()     // Catch:{ all -> 0x002a }
            goto L_0x0020
        L_0x0028:
            monitor-exit(r0)     // Catch:{ InterruptedException -> 0x002d }
            goto L_0x003b
        L_0x002a:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ InterruptedException -> 0x002d }
            throw r1     // Catch:{ InterruptedException -> 0x002d }
        L_0x002d:
            r0 = move-exception
            java.lang.Thread r1 = java.lang.Thread.currentThread()
            r1.interrupt()
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            r1.<init>(r0)
            throw r1
        L_0x003b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: s1.e.a():void");
    }

    public final void b() {
        RuntimeException runtimeException = (RuntimeException) this.f13997d.getAndSet((Object) null);
        if (runtimeException != null) {
            throw runtimeException;
        }
    }
}
