package d2;

public class o implements u0 {

    /* renamed from: a  reason: collision with root package name */
    public final long f4251a;

    /* renamed from: b  reason: collision with root package name */
    public final long f4252b;

    /* renamed from: c  reason: collision with root package name */
    public final int f4253c;

    /* renamed from: d  reason: collision with root package name */
    public final long f4254d;

    /* renamed from: e  reason: collision with root package name */
    public final int f4255e;

    /* renamed from: f  reason: collision with root package name */
    public final long f4256f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f4257g;

    public o(int i10, int i11, long j10, long j11, boolean z10) {
        long j12;
        this.f4251a = j10;
        this.f4252b = j11;
        this.f4253c = i11 == -1 ? 1 : i11;
        this.f4255e = i10;
        this.f4257g = z10;
        if (j10 == -1) {
            this.f4254d = -1;
            j12 = -9223372036854775807L;
        } else {
            long j13 = j10 - j11;
            this.f4254d = j13;
            j12 = ((Math.max(0, j13) * 8) * 1000000) / ((long) i10);
        }
        this.f4256f = j12;
    }

    public final boolean f() {
        return this.f4254d != -1 || this.f4257g;
    }

    public final t0 i(long j10) {
        long j11 = this.f4252b;
        long j12 = this.f4254d;
        int i10 = (j12 > -1 ? 1 : (j12 == -1 ? 0 : -1));
        if (i10 != 0 || this.f4257g) {
            int i11 = this.f4255e;
            long j13 = (long) this.f4253c;
            long j14 = (((((long) i11) * j10) / 8000000) / j13) * j13;
            if (i10 != 0) {
                j14 = Math.min(j14, j12 - j13);
            }
            long max = Math.max(j14, 0) + j11;
            long max2 = ((Math.max(0, max - j11) * 8) * 1000000) / ((long) i11);
            v0 v0Var = new v0(max2, max);
            if (i10 != 0 && max2 < j10) {
                long j15 = j13 + max;
                if (j15 < this.f4251a) {
                    return new t0(v0Var, new v0(((Math.max(0, j15 - j11) * 8) * 1000000) / ((long) i11), j15));
                }
            }
            return new t0(v0Var, v0Var);
        }
        v0 v0Var2 = new v0(0, j11);
        return new t0(v0Var2, v0Var2);
    }

    public final long j() {
        return this.f4256f;
    }
}
