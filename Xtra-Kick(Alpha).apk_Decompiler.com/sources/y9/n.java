package y9;

public final class n {

    /* renamed from: a  reason: collision with root package name */
    public final int f17269a;

    /* renamed from: b  reason: collision with root package name */
    public final int f17270b;

    /* renamed from: c  reason: collision with root package name */
    public final long f17271c;

    /* renamed from: d  reason: collision with root package name */
    public final long f17272d;

    /* renamed from: e  reason: collision with root package name */
    public long f17273e;

    public n() {
        this(0, 0, 0, 0, 0);
    }

    public final long a() {
        return this.f17273e;
    }

    public final long b() {
        return this.f17272d;
    }

    public final int c() {
        return this.f17269a;
    }

    public final int d() {
        return this.f17270b;
    }

    public final long e() {
        return this.f17271c;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0006, code lost:
        r6 = (y9.n) r6;
        r0 = r6.f17269a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r6) {
        /*
            r5 = this;
            if (r5 == r6) goto L_0x002f
            boolean r0 = r6 instanceof y9.n
            if (r0 == 0) goto L_0x002d
            y9.n r6 = (y9.n) r6
            int r0 = r6.f17269a
            int r1 = r5.f17269a
            if (r1 != r0) goto L_0x002d
            int r0 = r5.f17270b
            int r1 = r6.f17270b
            if (r0 != r1) goto L_0x002d
            long r0 = r5.f17271c
            long r2 = r6.f17271c
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L_0x002d
            long r0 = r5.f17272d
            long r2 = r6.f17272d
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L_0x002d
            long r0 = r5.f17273e
            long r2 = r6.f17273e
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 != 0) goto L_0x002d
            goto L_0x002f
        L_0x002d:
            r6 = 0
            return r6
        L_0x002f:
            r6 = 1
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: y9.n.equals(java.lang.Object):boolean");
    }

    public final boolean f() {
        return this.f17271c + this.f17273e == this.f17272d;
    }

    public final int hashCode() {
        long j10 = this.f17271c;
        long j11 = this.f17272d;
        long j12 = this.f17273e;
        return (((((((this.f17269a * 31) + this.f17270b) * 31) + ((int) (j10 ^ (j10 >>> 32)))) * 31) + ((int) (j11 ^ (j11 >>> 32)))) * 31) + ((int) (j12 ^ (j12 >>> 32)));
    }

    public final String toString() {
        return "FileSlice(id=" + this.f17269a + ", position=" + this.f17270b + ", startBytes=" + this.f17271c + ", endBytes=" + this.f17272d + ", downloaded=" + this.f17273e + ")";
    }

    public n(int i10, int i11, long j10, long j11, long j12) {
        this.f17269a = i10;
        this.f17270b = i11;
        this.f17271c = j10;
        this.f17272d = j11;
        this.f17273e = j12;
    }
}
