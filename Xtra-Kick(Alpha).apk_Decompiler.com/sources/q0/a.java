package q0;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public int f13090a;

    /* renamed from: b  reason: collision with root package name */
    public int f13091b;

    /* renamed from: c  reason: collision with root package name */
    public float f13092c;

    /* renamed from: d  reason: collision with root package name */
    public float f13093d;

    /* renamed from: e  reason: collision with root package name */
    public long f13094e = Long.MIN_VALUE;

    /* renamed from: f  reason: collision with root package name */
    public long f13095f = 0;

    /* renamed from: g  reason: collision with root package name */
    public long f13096g = -1;

    /* renamed from: h  reason: collision with root package name */
    public float f13097h;

    /* renamed from: i  reason: collision with root package name */
    public int f13098i;

    public final float a(long j10) {
        long j11 = this.f13094e;
        if (j10 < j11) {
            return 0.0f;
        }
        long j12 = this.f13096g;
        if (j12 < 0 || j10 < j12) {
            return i.b(((float) (j10 - j11)) / ((float) this.f13090a), 0.0f, 1.0f) * 0.5f;
        }
        float f10 = this.f13097h;
        return (i.b(((float) (j10 - j12)) / ((float) this.f13098i), 0.0f, 1.0f) * f10) + (1.0f - f10);
    }
}
