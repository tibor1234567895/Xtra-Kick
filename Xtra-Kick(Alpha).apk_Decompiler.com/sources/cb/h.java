package cb;

import java.util.NoSuchElementException;
import ma.g0;

public final class h extends g0 {

    /* renamed from: h  reason: collision with root package name */
    public final long f3075h;

    /* renamed from: i  reason: collision with root package name */
    public final long f3076i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f3077j;

    /* renamed from: k  reason: collision with root package name */
    public long f3078k;

    public h(long j10, long j11, long j12) {
        this.f3075h = j12;
        this.f3076i = j11;
        boolean z10 = true;
        int i10 = (j12 > 0 ? 1 : (j12 == 0 ? 0 : -1));
        int i11 = (j10 > j11 ? 1 : (j10 == j11 ? 0 : -1));
        if (i10 <= 0 ? i11 < 0 : i11 > 0) {
            z10 = false;
        }
        this.f3077j = z10;
        this.f3078k = !z10 ? j11 : j10;
    }

    public final long a() {
        long j10 = this.f3078k;
        if (j10 != this.f3076i) {
            this.f3078k = this.f3075h + j10;
        } else if (this.f3077j) {
            this.f3077j = false;
        } else {
            throw new NoSuchElementException();
        }
        return j10;
    }

    public final boolean hasNext() {
        return this.f3077j;
    }
}
