package y9;

import java.io.RandomAccessFile;

public final class x extends t {

    /* renamed from: h  reason: collision with root package name */
    public final RandomAccessFile f17297h;

    public x(RandomAccessFile randomAccessFile) {
        this.f17297h = randomAccessFile;
        randomAccessFile.seek(0);
    }

    public final void c(long j10) {
        this.f17297h.seek(j10);
    }

    public final void close() {
        this.f17297h.close();
    }

    public final void e(byte[] bArr, int i10) {
        this.f17297h.write(bArr, 0, i10);
    }

    public final void flush() {
    }
}
