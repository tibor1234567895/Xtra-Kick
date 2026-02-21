package m1;

public final class j {

    /* renamed from: a  reason: collision with root package name */
    public final float f10275a;

    /* renamed from: b  reason: collision with root package name */
    public final float f10276b;

    /* renamed from: c  reason: collision with root package name */
    public final long f10277c;

    /* renamed from: d  reason: collision with root package name */
    public final float f10278d;

    /* renamed from: e  reason: collision with root package name */
    public final long f10279e;

    /* renamed from: f  reason: collision with root package name */
    public final long f10280f;

    /* renamed from: g  reason: collision with root package name */
    public final float f10281g;

    /* renamed from: h  reason: collision with root package name */
    public long f10282h = -9223372036854775807L;

    /* renamed from: i  reason: collision with root package name */
    public long f10283i = -9223372036854775807L;

    /* renamed from: j  reason: collision with root package name */
    public long f10284j;

    /* renamed from: k  reason: collision with root package name */
    public long f10285k = -9223372036854775807L;

    /* renamed from: l  reason: collision with root package name */
    public long f10286l = -9223372036854775807L;

    /* renamed from: m  reason: collision with root package name */
    public long f10287m;

    /* renamed from: n  reason: collision with root package name */
    public float f10288n;

    /* renamed from: o  reason: collision with root package name */
    public float f10289o;

    /* renamed from: p  reason: collision with root package name */
    public float f10290p;

    /* renamed from: q  reason: collision with root package name */
    public long f10291q;

    /* renamed from: r  reason: collision with root package name */
    public long f10292r;

    /* renamed from: s  reason: collision with root package name */
    public long f10293s;

    public j(float f10, float f11, long j10, float f12, long j11, long j12, float f13) {
        this.f10275a = f10;
        this.f10276b = f11;
        this.f10277c = j10;
        this.f10278d = f12;
        this.f10279e = j11;
        this.f10280f = j12;
        this.f10281g = f13;
        this.f10289o = f10;
        this.f10288n = f11;
        this.f10290p = 1.0f;
        this.f10291q = -9223372036854775807L;
        this.f10284j = -9223372036854775807L;
        this.f10287m = -9223372036854775807L;
        this.f10292r = -9223372036854775807L;
        this.f10293s = -9223372036854775807L;
    }

    public final void a() {
        long j10 = this.f10282h;
        if (j10 != -9223372036854775807L) {
            long j11 = this.f10283i;
            if (j11 != -9223372036854775807L) {
                j10 = j11;
            }
            long j12 = this.f10285k;
            if (j12 != -9223372036854775807L && j10 < j12) {
                j10 = j12;
            }
            long j13 = this.f10286l;
            if (j13 != -9223372036854775807L && j10 > j13) {
                j10 = j13;
            }
        } else {
            j10 = -9223372036854775807L;
        }
        if (this.f10284j != j10) {
            this.f10284j = j10;
            this.f10287m = j10;
            this.f10292r = -9223372036854775807L;
            this.f10293s = -9223372036854775807L;
            this.f10291q = -9223372036854775807L;
        }
    }
}
