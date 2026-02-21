package y9;

import java.io.FileOutputStream;

public final class w extends t {

    /* renamed from: h  reason: collision with root package name */
    public final FileOutputStream f17296h;

    public w(FileOutputStream fileOutputStream) {
        this.f17296h = fileOutputStream;
        fileOutputStream.getChannel().position(0);
    }

    public final void c(long j10) {
        this.f17296h.getChannel().position(j10);
    }

    public final void close() {
        this.f17296h.close();
    }

    public final void e(byte[] bArr, int i10) {
        this.f17296h.write(bArr, 0, i10);
    }

    public final void flush() {
        this.f17296h.flush();
    }
}
