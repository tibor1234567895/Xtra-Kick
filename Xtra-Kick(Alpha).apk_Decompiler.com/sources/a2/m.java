package a2;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import j1.a;
import j1.v;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

public final class m extends Handler implements Runnable {

    /* renamed from: h  reason: collision with root package name */
    public final int f61h;

    /* renamed from: i  reason: collision with root package name */
    public final n f62i;

    /* renamed from: j  reason: collision with root package name */
    public final long f63j;

    /* renamed from: k  reason: collision with root package name */
    public l f64k;

    /* renamed from: l  reason: collision with root package name */
    public IOException f65l;

    /* renamed from: m  reason: collision with root package name */
    public int f66m;

    /* renamed from: n  reason: collision with root package name */
    public Thread f67n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f68o;

    /* renamed from: p  reason: collision with root package name */
    public volatile boolean f69p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ q f70q;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public m(q qVar, Looper looper, n nVar, l lVar, int i10, long j10) {
        super(looper);
        this.f70q = qVar;
        this.f62i = nVar;
        this.f64k = lVar;
        this.f61h = i10;
        this.f63j = j10;
    }

    public final void a(boolean z10) {
        this.f69p = z10;
        this.f65l = null;
        if (hasMessages(0)) {
            this.f68o = true;
            removeMessages(0);
            if (!z10) {
                sendEmptyMessage(1);
            }
        } else {
            synchronized (this) {
                this.f68o = true;
                this.f62i.b();
                Thread thread = this.f67n;
                if (thread != null) {
                    thread.interrupt();
                }
            }
        }
        if (z10) {
            this.f70q.f75b = null;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            l lVar = this.f64k;
            lVar.getClass();
            lVar.l(this.f62i, elapsedRealtime, elapsedRealtime - this.f63j, true);
            this.f64k = null;
        }
    }

    public final void b(long j10) {
        boolean z10;
        q qVar = this.f70q;
        if (qVar.f75b == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        a.e(z10);
        qVar.f75b = this;
        if (j10 > 0) {
            sendEmptyMessageDelayed(0, j10);
            return;
        }
        this.f65l = null;
        ExecutorService executorService = qVar.f74a;
        m mVar = qVar.f75b;
        mVar.getClass();
        executorService.execute(mVar);
    }

    public final void handleMessage(Message message) {
        if (!this.f69p) {
            int i10 = message.what;
            if (i10 == 0) {
                this.f65l = null;
                q qVar = this.f70q;
                ExecutorService executorService = qVar.f74a;
                m mVar = qVar.f75b;
                mVar.getClass();
                executorService.execute(mVar);
            } else if (i10 != 3) {
                this.f70q.f75b = null;
                long elapsedRealtime = SystemClock.elapsedRealtime();
                long j10 = elapsedRealtime - this.f63j;
                l lVar = this.f64k;
                lVar.getClass();
                if (this.f68o) {
                    lVar.l(this.f62i, elapsedRealtime, j10, false);
                    return;
                }
                int i11 = message.what;
                if (i11 == 1) {
                    try {
                        lVar.n(this.f62i, elapsedRealtime, j10);
                    } catch (RuntimeException e10) {
                        v.d("LoadTask", "Unexpected exception handling load completed", e10);
                        this.f70q.f76c = new p(e10);
                    }
                } else if (i11 == 2) {
                    IOException iOException = (IOException) message.obj;
                    this.f65l = iOException;
                    int i12 = this.f66m + 1;
                    this.f66m = i12;
                    k h10 = lVar.h(this.f62i, elapsedRealtime, j10, iOException, i12);
                    int i13 = h10.f59a;
                    if (i13 == 3) {
                        this.f70q.f76c = this.f65l;
                    } else if (i13 != 2) {
                        if (i13 == 1) {
                            this.f66m = 1;
                        }
                        long j11 = h10.f60b;
                        if (j11 == -9223372036854775807L) {
                            j11 = (long) Math.min((this.f66m - 1) * 1000, 5000);
                        }
                        b(j11);
                    }
                }
            } else {
                throw ((Error) message.obj);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0074, code lost:
        r0.sendToTarget();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r5 = this;
            java.lang.String r0 = "load:"
            r1 = 2
            monitor-enter(r5)     // Catch:{ IOException -> 0x008a, Exception -> 0x0078, OutOfMemoryError -> 0x005f, Error -> 0x004a }
            boolean r2 = r5.f68o     // Catch:{ all -> 0x0047 }
            r3 = 1
            if (r2 != 0) goto L_0x000b
            r2 = 1
            goto L_0x000c
        L_0x000b:
            r2 = 0
        L_0x000c:
            java.lang.Thread r4 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0047 }
            r5.f67n = r4     // Catch:{ all -> 0x0047 }
            monitor-exit(r5)     // Catch:{ all -> 0x0047 }
            if (r2 == 0) goto L_0x0034
            a2.n r2 = r5.f62i     // Catch:{ IOException -> 0x008a, Exception -> 0x0078, OutOfMemoryError -> 0x005f, Error -> 0x004a }
            java.lang.Class r2 = r2.getClass()     // Catch:{ IOException -> 0x008a, Exception -> 0x0078, OutOfMemoryError -> 0x005f, Error -> 0x004a }
            java.lang.String r2 = r2.getSimpleName()     // Catch:{ IOException -> 0x008a, Exception -> 0x0078, OutOfMemoryError -> 0x005f, Error -> 0x004a }
            java.lang.String r0 = r0.concat(r2)     // Catch:{ IOException -> 0x008a, Exception -> 0x0078, OutOfMemoryError -> 0x005f, Error -> 0x004a }
            j1.i0.a(r0)     // Catch:{ IOException -> 0x008a, Exception -> 0x0078, OutOfMemoryError -> 0x005f, Error -> 0x004a }
            a2.n r0 = r5.f62i     // Catch:{ all -> 0x002f }
            r0.a()     // Catch:{ all -> 0x002f }
            j1.i0.b()     // Catch:{ IOException -> 0x008a, Exception -> 0x0078, OutOfMemoryError -> 0x005f, Error -> 0x004a }
            goto L_0x0034
        L_0x002f:
            r0 = move-exception
            j1.i0.b()     // Catch:{ IOException -> 0x008a, Exception -> 0x0078, OutOfMemoryError -> 0x005f, Error -> 0x004a }
            throw r0     // Catch:{ IOException -> 0x008a, Exception -> 0x0078, OutOfMemoryError -> 0x005f, Error -> 0x004a }
        L_0x0034:
            monitor-enter(r5)     // Catch:{ IOException -> 0x008a, Exception -> 0x0078, OutOfMemoryError -> 0x005f, Error -> 0x004a }
            r0 = 0
            r5.f67n = r0     // Catch:{ all -> 0x0044 }
            java.lang.Thread.interrupted()     // Catch:{ all -> 0x0044 }
            monitor-exit(r5)     // Catch:{ all -> 0x0044 }
            boolean r0 = r5.f69p     // Catch:{ IOException -> 0x008a, Exception -> 0x0078, OutOfMemoryError -> 0x005f, Error -> 0x004a }
            if (r0 != 0) goto L_0x0094
            r5.sendEmptyMessage(r3)     // Catch:{ IOException -> 0x008a, Exception -> 0x0078, OutOfMemoryError -> 0x005f, Error -> 0x004a }
            goto L_0x0094
        L_0x0044:
            r0 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x0044 }
            throw r0     // Catch:{ IOException -> 0x008a, Exception -> 0x0078, OutOfMemoryError -> 0x005f, Error -> 0x004a }
        L_0x0047:
            r0 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x0047 }
            throw r0     // Catch:{ IOException -> 0x008a, Exception -> 0x0078, OutOfMemoryError -> 0x005f, Error -> 0x004a }
        L_0x004a:
            r0 = move-exception
            boolean r1 = r5.f69p
            if (r1 != 0) goto L_0x005e
            java.lang.String r1 = "LoadTask"
            java.lang.String r2 = "Unexpected error loading stream"
            j1.v.d(r1, r2, r0)
            r1 = 3
            android.os.Message r1 = r5.obtainMessage(r1, r0)
            r1.sendToTarget()
        L_0x005e:
            throw r0
        L_0x005f:
            r0 = move-exception
            boolean r2 = r5.f69p
            if (r2 != 0) goto L_0x0094
            java.lang.String r2 = "LoadTask"
            java.lang.String r3 = "OutOfMemory error loading stream"
            j1.v.d(r2, r3, r0)
            a2.p r2 = new a2.p
            r2.<init>(r0)
        L_0x0070:
            android.os.Message r0 = r5.obtainMessage(r1, r2)
        L_0x0074:
            r0.sendToTarget()
            goto L_0x0094
        L_0x0078:
            r0 = move-exception
            boolean r2 = r5.f69p
            if (r2 != 0) goto L_0x0094
            java.lang.String r2 = "LoadTask"
            java.lang.String r3 = "Unexpected exception loading stream"
            j1.v.d(r2, r3, r0)
            a2.p r2 = new a2.p
            r2.<init>(r0)
            goto L_0x0070
        L_0x008a:
            r0 = move-exception
            boolean r2 = r5.f69p
            if (r2 != 0) goto L_0x0094
            android.os.Message r0 = r5.obtainMessage(r1, r0)
            goto L_0x0074
        L_0x0094:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.m.run():void");
    }
}
