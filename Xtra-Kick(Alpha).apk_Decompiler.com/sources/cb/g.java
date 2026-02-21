package cb;

import java.util.Iterator;
import ya.a;

public abstract class g implements Iterable, a {

    /* renamed from: h  reason: collision with root package name */
    public final long f3072h;

    /* renamed from: i  reason: collision with root package name */
    public final long f3073i;

    /* renamed from: j  reason: collision with root package name */
    public final long f3074j;

    static {
        new f(0);
    }

    public g(long j10, long j11) {
        this.f3072h = j10;
        if (j10 < j11) {
            long j12 = j11 % 1;
            long j13 = j10 % 1;
            long j14 = ((j12 < 0 ? j12 + 1 : j12) - (j13 < 0 ? j13 + 1 : j13)) % 1;
            j11 -= j14 < 0 ? j14 + 1 : j14;
        }
        this.f3073i = j11;
        this.f3074j = 1;
    }

    public final Iterator iterator() {
        return new h(this.f3072h, this.f3073i, this.f3074j);
    }
}
