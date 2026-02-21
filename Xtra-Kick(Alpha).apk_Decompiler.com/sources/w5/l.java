package w5;

import androidx.recyclerview.widget.RecyclerView;
import java.io.FilterInputStream;

public final class l extends FilterInputStream {

    /* renamed from: h  reason: collision with root package name */
    public int f16121h = RecyclerView.UNDEFINED_DURATION;

    public l(d dVar) {
        super(dVar);
    }

    public final int available() {
        int i10 = this.f16121h;
        return i10 == Integer.MIN_VALUE ? super.available() : Math.min(i10, super.available());
    }

    public final long c(long j10) {
        int i10 = this.f16121h;
        if (i10 == 0) {
            return -1;
        }
        return (i10 == Integer.MIN_VALUE || j10 <= ((long) i10)) ? j10 : (long) i10;
    }

    public final void e(long j10) {
        int i10 = this.f16121h;
        if (i10 != Integer.MIN_VALUE && j10 != -1) {
            this.f16121h = (int) (((long) i10) - j10);
        }
    }

    public final synchronized void mark(int i10) {
        super.mark(i10);
        this.f16121h = i10;
    }

    public final int read() {
        if (c(1) == -1) {
            return -1;
        }
        int read = super.read();
        e(1);
        return read;
    }

    public final synchronized void reset() {
        super.reset();
        this.f16121h = RecyclerView.UNDEFINED_DURATION;
    }

    public final long skip(long j10) {
        long c10 = c(j10);
        if (c10 == -1) {
            return 0;
        }
        long skip = super.skip(c10);
        e(skip);
        return skip;
    }

    public final int read(byte[] bArr, int i10, int i11) {
        int c10 = (int) c((long) i11);
        if (c10 == -1) {
            return -1;
        }
        int read = super.read(bArr, i10, c10);
        e((long) read);
        return read;
    }
}
