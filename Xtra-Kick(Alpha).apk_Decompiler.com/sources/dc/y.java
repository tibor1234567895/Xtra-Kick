package dc;

import java.io.Closeable;
import java.io.RandomAccessFile;
import java.util.concurrent.locks.ReentrantLock;
import la.v;

public final class y implements Closeable {

    /* renamed from: h  reason: collision with root package name */
    public boolean f4847h;

    /* renamed from: i  reason: collision with root package name */
    public int f4848i;

    /* renamed from: j  reason: collision with root package name */
    public final ReentrantLock f4849j = new ReentrantLock();

    /* renamed from: k  reason: collision with root package name */
    public final RandomAccessFile f4850k;

    public y(RandomAccessFile randomAccessFile) {
        this.f4850k = randomAccessFile;
    }

    /* renamed from: c */
    public final void close() {
        ReentrantLock reentrantLock = this.f4849j;
        reentrantLock.lock();
        try {
            if (!this.f4847h) {
                this.f4847h = true;
                if (this.f4848i != 0) {
                    reentrantLock.unlock();
                    return;
                }
                v vVar = v.f9814a;
                reentrantLock.unlock();
                synchronized (this) {
                    this.f4850k.close();
                }
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    public final long e() {
        long length;
        ReentrantLock reentrantLock = this.f4849j;
        reentrantLock.lock();
        try {
            if (!this.f4847h) {
                v vVar = v.f9814a;
                synchronized (this) {
                    length = this.f4850k.length();
                }
                return length;
            }
            throw new IllegalStateException("closed".toString());
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: finally extract failed */
    public final o k(long j10) {
        ReentrantLock reentrantLock = this.f4849j;
        reentrantLock.lock();
        try {
            if (!this.f4847h) {
                this.f4848i++;
                reentrantLock.unlock();
                return new o(this, j10);
            }
            throw new IllegalStateException("closed".toString());
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }
}
