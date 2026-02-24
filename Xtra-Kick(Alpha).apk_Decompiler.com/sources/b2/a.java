package b2;

import java.util.Arrays;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public long f2415a;

    /* renamed from: b  reason: collision with root package name */
    public long f2416b;

    /* renamed from: c  reason: collision with root package name */
    public long f2417c;

    /* renamed from: d  reason: collision with root package name */
    public long f2418d;

    /* renamed from: e  reason: collision with root package name */
    public long f2419e;

    /* renamed from: f  reason: collision with root package name */
    public long f2420f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean[] f2421g = new boolean[15];

    /* renamed from: h  reason: collision with root package name */
    public int f2422h;

    public final boolean a() {
        return this.f2418d > 15 && this.f2422h == 0;
    }

    public final void b(long j10) {
        int i10;
        long j11 = this.f2418d;
        if (j11 == 0) {
            this.f2415a = j10;
        } else if (j11 == 1) {
            long j12 = j10 - this.f2415a;
            this.f2416b = j12;
            this.f2420f = j12;
            this.f2419e = 1;
        } else {
            long j13 = j10 - this.f2417c;
            int i11 = (int) (j11 % 15);
            long abs = Math.abs(j13 - this.f2416b);
            boolean[] zArr = this.f2421g;
            if (abs <= 1000000) {
                this.f2419e++;
                this.f2420f += j13;
                if (zArr[i11]) {
                    zArr[i11] = false;
                    i10 = this.f2422h - 1;
                }
            } else if (!zArr[i11]) {
                zArr[i11] = true;
                i10 = this.f2422h + 1;
            }
            this.f2422h = i10;
        }
        this.f2418d++;
        this.f2417c = j10;
    }

    public final void c() {
        this.f2418d = 0;
        this.f2419e = 0;
        this.f2420f = 0;
        this.f2422h = 0;
        Arrays.fill(this.f2421g, false);
    }
}
