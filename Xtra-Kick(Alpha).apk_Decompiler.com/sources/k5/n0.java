package k5;

import android.media.MediaDataSource;
import java.nio.ByteBuffer;

public final class n0 extends MediaDataSource {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ ByteBuffer f9168h;

    public n0(ByteBuffer byteBuffer) {
        this.f9168h = byteBuffer;
    }

    public final void close() {
    }

    public final long getSize() {
        return (long) this.f9168h.limit();
    }

    public final int readAt(long j10, byte[] bArr, int i10, int i11) {
        if (j10 >= ((long) this.f9168h.limit())) {
            return -1;
        }
        this.f9168h.position((int) j10);
        int min = Math.min(i11, this.f9168h.remaining());
        this.f9168h.get(bArr, i10, min);
        return min;
    }
}
