package x0;

import java.io.InputStream;

public final class f extends b {
    public f(InputStream inputStream) {
        super(inputStream);
        if (inputStream.markSupported()) {
            this.f16514h.mark(Integer.MAX_VALUE);
            return;
        }
        throw new IllegalArgumentException("Cannot create SeekableByteOrderedDataInputStream with stream that does not support mark/reset");
    }

    public final void e(long j10) {
        int i10 = this.f16516j;
        if (((long) i10) > j10) {
            this.f16516j = 0;
            this.f16514h.reset();
        } else {
            j10 -= (long) i10;
        }
        c((int) j10);
    }

    public f(byte[] bArr) {
        super(bArr);
        this.f16514h.mark(Integer.MAX_VALUE);
    }
}
