package w5;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class c extends FilterInputStream {

    /* renamed from: h  reason: collision with root package name */
    public final long f16108h;

    /* renamed from: i  reason: collision with root package name */
    public int f16109i;

    public c(InputStream inputStream, long j10) {
        super(inputStream);
        this.f16108h = j10;
    }

    public final synchronized int available() {
        return (int) Math.max(this.f16108h - ((long) this.f16109i), (long) this.in.available());
    }

    public final void c(int i10) {
        int i11 = this.f16109i;
        if (i10 >= 0) {
            this.f16109i = i11 + i10;
            return;
        }
        long j10 = this.f16108h;
        if (j10 - ((long) i11) > 0) {
            throw new IOException("Failed to read all expected data, expected: " + j10 + ", but read: " + this.f16109i);
        }
    }

    public final synchronized int read() {
        int read;
        read = super.read();
        c(read >= 0 ? 1 : -1);
        return read;
    }

    public final int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    public final synchronized int read(byte[] bArr, int i10, int i11) {
        int read;
        read = super.read(bArr, i10, i11);
        c(read);
        return read;
    }
}
