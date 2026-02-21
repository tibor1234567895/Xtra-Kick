package d2;

import j1.l0;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    public final long f4188a;

    /* renamed from: b  reason: collision with root package name */
    public final long f4189b;

    /* renamed from: c  reason: collision with root package name */
    public final long f4190c;

    /* renamed from: d  reason: collision with root package name */
    public long f4191d;

    /* renamed from: e  reason: collision with root package name */
    public long f4192e;

    /* renamed from: f  reason: collision with root package name */
    public long f4193f;

    /* renamed from: g  reason: collision with root package name */
    public long f4194g;

    /* renamed from: h  reason: collision with root package name */
    public long f4195h;

    public h(long j10, long j11, long j12, long j13, long j14, long j15, long j16) {
        this.f4188a = j10;
        this.f4189b = j11;
        this.f4191d = j12;
        this.f4192e = j13;
        this.f4193f = j14;
        this.f4194g = j15;
        this.f4190c = j16;
        this.f4195h = a(j11, j12, j13, j14, j15, j16);
    }

    public static long a(long j10, long j11, long j12, long j13, long j14, long j15) {
        if (j13 + 1 >= j14 || j11 + 1 >= j12) {
            return j13;
        }
        long j16 = (long) (((float) (j10 - j11)) * (((float) (j14 - j13)) / ((float) (j12 - j11))));
        return l0.i(((j16 + j13) - j15) - (j16 / 20), j13, j14 - 1);
    }
}
