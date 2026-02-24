package w5;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayDeque;

public final class d extends InputStream {

    /* renamed from: j  reason: collision with root package name */
    public static final ArrayDeque f16110j = new ArrayDeque(0);

    /* renamed from: h  reason: collision with root package name */
    public InputStream f16111h;

    /* renamed from: i  reason: collision with root package name */
    public IOException f16112i;

    static {
        char[] cArr = p.f16126a;
    }

    public final int available() {
        return this.f16111h.available();
    }

    public final void c() {
        this.f16112i = null;
        this.f16111h = null;
        ArrayDeque arrayDeque = f16110j;
        synchronized (arrayDeque) {
            arrayDeque.offer(this);
        }
    }

    public final void close() {
        this.f16111h.close();
    }

    public final void mark(int i10) {
        this.f16111h.mark(i10);
    }

    public final boolean markSupported() {
        return this.f16111h.markSupported();
    }

    public final int read() {
        try {
            return this.f16111h.read();
        } catch (IOException e10) {
            this.f16112i = e10;
            throw e10;
        }
    }

    public final synchronized void reset() {
        this.f16111h.reset();
    }

    public final long skip(long j10) {
        try {
            return this.f16111h.skip(j10);
        } catch (IOException e10) {
            this.f16112i = e10;
            throw e10;
        }
    }

    public final int read(byte[] bArr) {
        try {
            return this.f16111h.read(bArr);
        } catch (IOException e10) {
            this.f16112i = e10;
            throw e10;
        }
    }

    public final int read(byte[] bArr, int i10, int i11) {
        try {
            return this.f16111h.read(bArr, i10, i11);
        } catch (IOException e10) {
            this.f16112i = e10;
            throw e10;
        }
    }
}
