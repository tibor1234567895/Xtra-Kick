package j4;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class n extends InputStream {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f8767h;

    /* renamed from: i  reason: collision with root package name */
    public int f8768i;

    /* renamed from: j  reason: collision with root package name */
    public final Object f8769j;

    public n(InputStream inputStream) {
        this.f8767h = 0;
        this.f8769j = inputStream;
        this.f8768i = 1073741824;
    }

    private synchronized void c() {
        this.f8768i = ((ByteBuffer) this.f8769j).position();
    }

    private synchronized void e() {
        int i10 = this.f8768i;
        if (i10 != -1) {
            ((ByteBuffer) this.f8769j).position(i10);
        } else {
            throw new IOException("Cannot reset to unset mark position");
        }
    }

    public final int available() {
        switch (this.f8767h) {
            case 0:
                return this.f8768i;
            default:
                return ((ByteBuffer) this.f8769j).remaining();
        }
    }

    public final void close() {
        switch (this.f8767h) {
            case 0:
                ((InputStream) this.f8769j).close();
                return;
            default:
                super.close();
                return;
        }
    }

    public final synchronized void mark(int i10) {
        switch (this.f8767h) {
            case 1:
                c();
                return;
            default:
                super.mark(i10);
                return;
        }
    }

    public final boolean markSupported() {
        switch (this.f8767h) {
            case 1:
                return true;
            default:
                return super.markSupported();
        }
    }

    public final int read() {
        int i10 = this.f8767h;
        Object obj = this.f8769j;
        switch (i10) {
            case 0:
                int read = ((InputStream) obj).read();
                if (read == -1) {
                    this.f8768i = 0;
                }
                return read;
            default:
                ByteBuffer byteBuffer = (ByteBuffer) obj;
                if (!byteBuffer.hasRemaining()) {
                    return -1;
                }
                return byteBuffer.get() & 255;
        }
    }

    public final synchronized void reset() {
        switch (this.f8767h) {
            case 1:
                e();
                return;
            default:
                super.reset();
                return;
        }
    }

    public final long skip(long j10) {
        int i10 = this.f8767h;
        Object obj = this.f8769j;
        switch (i10) {
            case 0:
                return ((InputStream) obj).skip(j10);
            default:
                ByteBuffer byteBuffer = (ByteBuffer) obj;
                if (!byteBuffer.hasRemaining()) {
                    return -1;
                }
                long min = Math.min(j10, (long) available());
                byteBuffer.position((int) (((long) byteBuffer.position()) + min));
                return min;
        }
    }

    public n(ByteBuffer byteBuffer) {
        this.f8767h = 1;
        this.f8768i = -1;
        this.f8769j = byteBuffer;
    }

    public final int read(byte[] bArr) {
        switch (this.f8767h) {
            case 0:
                int read = ((InputStream) this.f8769j).read(bArr);
                if (read == -1) {
                    this.f8768i = 0;
                }
                return read;
            default:
                return super.read(bArr);
        }
    }

    public final int read(byte[] bArr, int i10, int i11) {
        int i12 = this.f8767h;
        Object obj = this.f8769j;
        switch (i12) {
            case 0:
                int read = ((InputStream) obj).read(bArr, i10, i11);
                if (read == -1) {
                    this.f8768i = 0;
                }
                return read;
            default:
                ByteBuffer byteBuffer = (ByteBuffer) obj;
                if (!byteBuffer.hasRemaining()) {
                    return -1;
                }
                int min = Math.min(i11, available());
                byteBuffer.get(bArr, i10, min);
                return min;
        }
    }
}
