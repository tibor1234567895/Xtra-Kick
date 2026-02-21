package s1;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.support.v4.media.session.w;
import android.view.Surface;
import androidx.activity.e;
import b2.f;
import g.a0;
import j1.a;
import j1.i0;
import j1.l0;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.Arrays;
import l1.d;
import m0.q0;

public final class c implements m {

    /* renamed from: a  reason: collision with root package name */
    public final MediaCodec f13977a;

    /* renamed from: b  reason: collision with root package name */
    public final f f13978b;

    /* renamed from: c  reason: collision with root package name */
    public final e f13979c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f13980d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f13981e;

    /* renamed from: f  reason: collision with root package name */
    public int f13982f = 0;

    public c(MediaCodec mediaCodec, HandlerThread handlerThread, HandlerThread handlerThread2, boolean z10) {
        this.f13977a = mediaCodec;
        this.f13978b = new f(handlerThread);
        this.f13979c = new e(mediaCodec, handlerThread2);
        this.f13980d = z10;
    }

    public static void p(c cVar, MediaFormat mediaFormat, Surface surface, MediaCrypto mediaCrypto) {
        boolean z10;
        f fVar = cVar.f13978b;
        if (fVar.f14005c == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        a.e(z10);
        HandlerThread handlerThread = fVar.f14004b;
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper());
        MediaCodec mediaCodec = cVar.f13977a;
        mediaCodec.setCallback(fVar, handler);
        fVar.f14005c = handler;
        i0.a("configureCodec");
        mediaCodec.configure(mediaFormat, surface, mediaCrypto, 0);
        i0.b();
        e eVar = cVar.f13979c;
        if (!eVar.f13999f) {
            HandlerThread handlerThread2 = eVar.f13995b;
            handlerThread2.start();
            eVar.f13996c = new w(eVar, handlerThread2.getLooper(), 4);
            eVar.f13999f = true;
        }
        i0.a("startCodec");
        mediaCodec.start();
        i0.b();
        cVar.f13982f = 1;
    }

    public static String q(int i10, String str) {
        String str2;
        StringBuilder sb2 = new StringBuilder(str);
        if (i10 == 1) {
            str2 = "Audio";
        } else if (i10 == 2) {
            str2 = "Video";
        } else {
            sb2.append("Unknown(");
            sb2.append(i10);
            str2 = ")";
        }
        sb2.append(str2);
        return sb2.toString();
    }

    public final void a() {
        try {
            if (this.f13982f == 1) {
                e eVar = this.f13979c;
                if (eVar.f13999f) {
                    eVar.a();
                    eVar.f13995b.quit();
                }
                eVar.f13999f = false;
                f fVar = this.f13978b;
                synchronized (fVar.f14003a) {
                    fVar.f14014l = true;
                    fVar.f14004b.quit();
                    fVar.a();
                }
            }
            this.f13982f = 2;
            if (!this.f13981e) {
                this.f13977a.release();
                this.f13981e = true;
            }
        } catch (Throwable th) {
            if (!this.f13981e) {
                this.f13977a.release();
                this.f13981e = true;
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x001f  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0020  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int b(android.media.MediaCodec.BufferInfo r13) {
        /*
            r12 = this;
            s1.e r0 = r12.f13979c
            r0.b()
            s1.f r0 = r12.f13978b
            java.lang.Object r1 = r0.f14003a
            monitor-enter(r1)
            long r2 = r0.f14013k     // Catch:{ all -> 0x007e }
            r4 = 0
            r6 = 0
            r7 = 1
            int r8 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r8 > 0) goto L_0x001b
            boolean r2 = r0.f14014l     // Catch:{ all -> 0x007e }
            if (r2 == 0) goto L_0x0019
            goto L_0x001b
        L_0x0019:
            r2 = 0
            goto L_0x001c
        L_0x001b:
            r2 = 1
        L_0x001c:
            r3 = -1
            if (r2 == 0) goto L_0x0020
            goto L_0x006e
        L_0x0020:
            java.lang.IllegalStateException r2 = r0.f14015m     // Catch:{ all -> 0x007e }
            r4 = 0
            if (r2 != 0) goto L_0x0079
            android.media.MediaCodec$CodecException r2 = r0.f14012j     // Catch:{ all -> 0x007e }
            if (r2 != 0) goto L_0x0076
            s1.j r2 = r0.f14007e     // Catch:{ all -> 0x007e }
            int r4 = r2.f14024c     // Catch:{ all -> 0x007e }
            if (r4 != 0) goto L_0x0030
            r6 = 1
        L_0x0030:
            if (r6 == 0) goto L_0x0033
            goto L_0x006e
        L_0x0033:
            if (r4 == 0) goto L_0x0070
            int[] r5 = r2.f14025d     // Catch:{ all -> 0x007e }
            int r6 = r2.f14022a     // Catch:{ all -> 0x007e }
            r5 = r5[r6]     // Catch:{ all -> 0x007e }
            int r6 = r6 + r7
            int r7 = r2.f14026e     // Catch:{ all -> 0x007e }
            r6 = r6 & r7
            r2.f14022a = r6     // Catch:{ all -> 0x007e }
            int r4 = r4 + r3
            r2.f14024c = r4     // Catch:{ all -> 0x007e }
            if (r5 < 0) goto L_0x0060
            android.media.MediaFormat r2 = r0.f14010h     // Catch:{ all -> 0x007e }
            j1.a.f(r2)     // Catch:{ all -> 0x007e }
            java.util.ArrayDeque r0 = r0.f14008f     // Catch:{ all -> 0x007e }
            java.lang.Object r0 = r0.remove()     // Catch:{ all -> 0x007e }
            android.media.MediaCodec$BufferInfo r0 = (android.media.MediaCodec.BufferInfo) r0     // Catch:{ all -> 0x007e }
            int r7 = r0.offset     // Catch:{ all -> 0x007e }
            int r8 = r0.size     // Catch:{ all -> 0x007e }
            long r9 = r0.presentationTimeUs     // Catch:{ all -> 0x007e }
            int r11 = r0.flags     // Catch:{ all -> 0x007e }
            r6 = r13
            r6.set(r7, r8, r9, r11)     // Catch:{ all -> 0x007e }
            goto L_0x006d
        L_0x0060:
            r13 = -2
            if (r5 != r13) goto L_0x006d
            java.util.ArrayDeque r13 = r0.f14009g     // Catch:{ all -> 0x007e }
            java.lang.Object r13 = r13.remove()     // Catch:{ all -> 0x007e }
            android.media.MediaFormat r13 = (android.media.MediaFormat) r13     // Catch:{ all -> 0x007e }
            r0.f14010h = r13     // Catch:{ all -> 0x007e }
        L_0x006d:
            r3 = r5
        L_0x006e:
            monitor-exit(r1)     // Catch:{ all -> 0x007e }
            return r3
        L_0x0070:
            java.util.NoSuchElementException r13 = new java.util.NoSuchElementException     // Catch:{ all -> 0x007e }
            r13.<init>()     // Catch:{ all -> 0x007e }
            throw r13     // Catch:{ all -> 0x007e }
        L_0x0076:
            r0.f14012j = r4     // Catch:{ all -> 0x007e }
            throw r2     // Catch:{ all -> 0x007e }
        L_0x0079:
            r0.f14015m = r4     // Catch:{ all -> 0x007e }
            throw r2     // Catch:{ all -> 0x007e }
        L_0x007c:
            monitor-exit(r1)     // Catch:{ all -> 0x007e }
            throw r13
        L_0x007e:
            r13 = move-exception
            goto L_0x007c
        */
        throw new UnsupportedOperationException("Method not decompiled: s1.c.b(android.media.MediaCodec$BufferInfo):int");
    }

    public final void c() {
    }

    public final void d(int i10, boolean z10) {
        this.f13977a.releaseOutputBuffer(i10, z10);
    }

    public final void e(f fVar, Handler handler) {
        r();
        this.f13977a.setOnFrameRenderedListener(new a(this, fVar, 0), handler);
    }

    public final void f(int i10) {
        r();
        this.f13977a.setVideoScalingMode(i10);
    }

    public final void flush() {
        this.f13979c.a();
        this.f13977a.flush();
        f fVar = this.f13978b;
        synchronized (fVar.f14003a) {
            fVar.f14013k++;
            Handler handler = fVar.f14005c;
            int i10 = l0.f8453a;
            handler.post(new e(12, fVar));
        }
        this.f13977a.start();
    }

    public final void g(int i10, d dVar, long j10) {
        d dVar2;
        e eVar = this.f13979c;
        eVar.b();
        ArrayDeque arrayDeque = e.f13992g;
        synchronized (arrayDeque) {
            if (arrayDeque.isEmpty()) {
                dVar2 = new d();
            } else {
                dVar2 = (d) arrayDeque.removeFirst();
            }
        }
        dVar2.f13986a = i10;
        dVar2.f13987b = 0;
        dVar2.f13988c = 0;
        dVar2.f13990e = j10;
        dVar2.f13991f = 0;
        int i11 = dVar.f9509f;
        MediaCodec.CryptoInfo cryptoInfo = dVar2.f13989d;
        cryptoInfo.numSubSamples = i11;
        int[] iArr = dVar.f9507d;
        int[] iArr2 = cryptoInfo.numBytesOfClearData;
        if (iArr != null) {
            if (iArr2 == null || iArr2.length < iArr.length) {
                iArr2 = Arrays.copyOf(iArr, iArr.length);
            } else {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
            }
        }
        cryptoInfo.numBytesOfClearData = iArr2;
        int[] iArr3 = dVar.f9508e;
        int[] iArr4 = cryptoInfo.numBytesOfEncryptedData;
        if (iArr3 != null) {
            if (iArr4 == null || iArr4.length < iArr3.length) {
                iArr4 = Arrays.copyOf(iArr3, iArr3.length);
            } else {
                System.arraycopy(iArr3, 0, iArr4, 0, iArr3.length);
            }
        }
        cryptoInfo.numBytesOfEncryptedData = iArr4;
        byte[] bArr = dVar.f9505b;
        byte[] bArr2 = cryptoInfo.key;
        if (bArr != null) {
            if (bArr2 == null || bArr2.length < bArr.length) {
                bArr2 = Arrays.copyOf(bArr, bArr.length);
            } else {
                System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            }
        }
        bArr2.getClass();
        cryptoInfo.key = bArr2;
        byte[] bArr3 = dVar.f9504a;
        byte[] bArr4 = cryptoInfo.iv;
        if (bArr3 != null) {
            if (bArr4 == null || bArr4.length < bArr3.length) {
                bArr4 = Arrays.copyOf(bArr3, bArr3.length);
            } else {
                System.arraycopy(bArr3, 0, bArr4, 0, bArr3.length);
            }
        }
        bArr4.getClass();
        cryptoInfo.iv = bArr4;
        cryptoInfo.mode = dVar.f9506c;
        if (l0.f8453a >= 24) {
            a0.D();
            cryptoInfo.setPattern(q0.d(dVar.f9510g, dVar.f9511h));
        }
        eVar.f13996c.obtainMessage(1, dVar2).sendToTarget();
    }

    public final MediaFormat h() {
        MediaFormat mediaFormat;
        f fVar = this.f13978b;
        synchronized (fVar.f14003a) {
            mediaFormat = fVar.f14010h;
            if (mediaFormat == null) {
                throw new IllegalStateException();
            }
        }
        return mediaFormat;
    }

    public final ByteBuffer i(int i10) {
        return this.f13977a.getInputBuffer(i10);
    }

    public final void j(Surface surface) {
        r();
        this.f13977a.setOutputSurface(surface);
    }

    public final void k(Bundle bundle) {
        r();
        this.f13977a.setParameters(bundle);
    }

    public final ByteBuffer l(int i10) {
        return this.f13977a.getOutputBuffer(i10);
    }

    public final void m(int i10, long j10) {
        this.f13977a.releaseOutputBuffer(i10, j10);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x001f  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0020  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int n() {
        /*
            r9 = this;
            s1.e r0 = r9.f13979c
            r0.b()
            s1.f r0 = r9.f13978b
            java.lang.Object r1 = r0.f14003a
            monitor-enter(r1)
            long r2 = r0.f14013k     // Catch:{ all -> 0x0055 }
            r4 = 0
            r6 = 0
            r7 = 1
            int r8 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r8 > 0) goto L_0x001b
            boolean r2 = r0.f14014l     // Catch:{ all -> 0x0055 }
            if (r2 == 0) goto L_0x0019
            goto L_0x001b
        L_0x0019:
            r2 = 0
            goto L_0x001c
        L_0x001b:
            r2 = 1
        L_0x001c:
            r3 = -1
            if (r2 == 0) goto L_0x0020
            goto L_0x0045
        L_0x0020:
            java.lang.IllegalStateException r2 = r0.f14015m     // Catch:{ all -> 0x0055 }
            r4 = 0
            if (r2 != 0) goto L_0x0050
            android.media.MediaCodec$CodecException r2 = r0.f14012j     // Catch:{ all -> 0x0055 }
            if (r2 != 0) goto L_0x004d
            s1.j r0 = r0.f14006d     // Catch:{ all -> 0x0055 }
            int r2 = r0.f14024c     // Catch:{ all -> 0x0055 }
            if (r2 != 0) goto L_0x0030
            r6 = 1
        L_0x0030:
            if (r6 == 0) goto L_0x0033
            goto L_0x0045
        L_0x0033:
            if (r2 == 0) goto L_0x0047
            int[] r4 = r0.f14025d     // Catch:{ all -> 0x0055 }
            int r5 = r0.f14022a     // Catch:{ all -> 0x0055 }
            r4 = r4[r5]     // Catch:{ all -> 0x0055 }
            int r5 = r5 + r7
            int r6 = r0.f14026e     // Catch:{ all -> 0x0055 }
            r5 = r5 & r6
            r0.f14022a = r5     // Catch:{ all -> 0x0055 }
            int r2 = r2 + r3
            r0.f14024c = r2     // Catch:{ all -> 0x0055 }
            r3 = r4
        L_0x0045:
            monitor-exit(r1)     // Catch:{ all -> 0x0055 }
            return r3
        L_0x0047:
            java.util.NoSuchElementException r0 = new java.util.NoSuchElementException     // Catch:{ all -> 0x0055 }
            r0.<init>()     // Catch:{ all -> 0x0055 }
            throw r0     // Catch:{ all -> 0x0055 }
        L_0x004d:
            r0.f14012j = r4     // Catch:{ all -> 0x0055 }
            throw r2     // Catch:{ all -> 0x0055 }
        L_0x0050:
            r0.f14015m = r4     // Catch:{ all -> 0x0055 }
            throw r2     // Catch:{ all -> 0x0055 }
        L_0x0053:
            monitor-exit(r1)     // Catch:{ all -> 0x0055 }
            throw r0
        L_0x0055:
            r0 = move-exception
            goto L_0x0053
        */
        throw new UnsupportedOperationException("Method not decompiled: s1.c.n():int");
    }

    public final void o(int i10, int i11, long j10, int i12) {
        d dVar;
        e eVar = this.f13979c;
        eVar.b();
        ArrayDeque arrayDeque = e.f13992g;
        synchronized (arrayDeque) {
            if (arrayDeque.isEmpty()) {
                dVar = new d();
            } else {
                dVar = (d) arrayDeque.removeFirst();
            }
        }
        dVar.f13986a = i10;
        dVar.f13987b = 0;
        dVar.f13988c = i11;
        dVar.f13990e = j10;
        dVar.f13991f = i12;
        w wVar = eVar.f13996c;
        int i13 = l0.f8453a;
        wVar.obtainMessage(0, dVar).sendToTarget();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0026, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0027, code lost:
        java.lang.Thread.currentThread().interrupt();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0033, code lost:
        throw new java.lang.IllegalStateException(r0);
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void r() {
        /*
            r3 = this;
            boolean r0 = r3.f13980d
            if (r0 == 0) goto L_0x0034
            s1.e r0 = r3.f13979c     // Catch:{ InterruptedException -> 0x0026 }
            j1.g r1 = r0.f13998e     // Catch:{ InterruptedException -> 0x0026 }
            r1.a()     // Catch:{ InterruptedException -> 0x0026 }
            android.support.v4.media.session.w r0 = r0.f13996c     // Catch:{ InterruptedException -> 0x0026 }
            r0.getClass()     // Catch:{ InterruptedException -> 0x0026 }
            r2 = 2
            android.os.Message r0 = r0.obtainMessage(r2)     // Catch:{ InterruptedException -> 0x0026 }
            r0.sendToTarget()     // Catch:{ InterruptedException -> 0x0026 }
            monitor-enter(r1)     // Catch:{ InterruptedException -> 0x0026 }
        L_0x0019:
            boolean r0 = r1.f8430a     // Catch:{ all -> 0x0023 }
            if (r0 != 0) goto L_0x0021
            r1.wait()     // Catch:{ all -> 0x0023 }
            goto L_0x0019
        L_0x0021:
            monitor-exit(r1)     // Catch:{ InterruptedException -> 0x0026 }
            goto L_0x0034
        L_0x0023:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ InterruptedException -> 0x0026 }
            throw r0     // Catch:{ InterruptedException -> 0x0026 }
        L_0x0026:
            r0 = move-exception
            java.lang.Thread r1 = java.lang.Thread.currentThread()
            r1.interrupt()
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            r1.<init>(r0)
            throw r1
        L_0x0034:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: s1.c.r():void");
    }
}
