package x0;

import android.media.MediaDataSource;
import java.io.IOException;

public final class a extends MediaDataSource {

    /* renamed from: h  reason: collision with root package name */
    public long f16510h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ f f16511i;

    public a(f fVar) {
        this.f16511i = fVar;
    }

    public final void close() {
    }

    public final long getSize() {
        return -1;
    }

    public final int readAt(long j10, byte[] bArr, int i10, int i11) {
        if (i11 == 0) {
            return 0;
        }
        if (j10 < 0) {
            return -1;
        }
        try {
            long j11 = this.f16510h;
            if (j11 != j10) {
                if (j11 >= 0 && j10 >= j11 + ((long) this.f16511i.available())) {
                    return -1;
                }
                this.f16511i.e(j10);
                this.f16510h = j10;
            }
            if (i11 > this.f16511i.available()) {
                i11 = this.f16511i.available();
            }
            int read = this.f16511i.read(bArr, i10, i11);
            if (read >= 0) {
                this.f16510h += (long) read;
                return read;
            }
        } catch (IOException unused) {
        }
        this.f16510h = -1;
        return -1;
    }
}
