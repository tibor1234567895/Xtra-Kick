package dc;

import android.support.v4.media.h;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import xa.j;

public class s0 {

    /* renamed from: d  reason: collision with root package name */
    public static final q0 f4821d = new q0();

    /* renamed from: a  reason: collision with root package name */
    public boolean f4822a;

    /* renamed from: b  reason: collision with root package name */
    public long f4823b;

    /* renamed from: c  reason: collision with root package name */
    public long f4824c;

    static {
        new r0(0);
    }

    public s0 a() {
        this.f4822a = false;
        return this;
    }

    public s0 b() {
        this.f4824c = 0;
        return this;
    }

    public long c() {
        if (this.f4822a) {
            return this.f4823b;
        }
        throw new IllegalStateException("No deadline".toString());
    }

    public s0 d(long j10) {
        this.f4822a = true;
        this.f4823b = j10;
        return this;
    }

    public boolean e() {
        return this.f4822a;
    }

    public void f() {
        if (Thread.currentThread().isInterrupted()) {
            throw new InterruptedIOException("interrupted");
        } else if (this.f4822a && this.f4823b - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }

    public s0 g(long j10, TimeUnit timeUnit) {
        boolean z10;
        j.f("unit", timeUnit);
        if (j10 >= 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            this.f4824c = timeUnit.toNanos(j10);
            return this;
        }
        throw new IllegalArgumentException(h.k("timeout < 0: ", j10).toString());
    }

    public long h() {
        return this.f4824c;
    }
}
