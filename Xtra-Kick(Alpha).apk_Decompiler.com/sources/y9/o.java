package y9;

public final class o {

    /* renamed from: a  reason: collision with root package name */
    public final int f17274a;

    /* renamed from: b  reason: collision with root package name */
    public final long f17275b;

    public o(int i10, long j10) {
        this.f17274a = i10;
        this.f17275b = j10;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0006, code lost:
        r5 = (y9.o) r5;
        r0 = r5.f17274a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r5) {
        /*
            r4 = this;
            if (r4 == r5) goto L_0x0019
            boolean r0 = r5 instanceof y9.o
            if (r0 == 0) goto L_0x0017
            y9.o r5 = (y9.o) r5
            int r0 = r5.f17274a
            int r1 = r4.f17274a
            if (r1 != r0) goto L_0x0017
            long r0 = r4.f17275b
            long r2 = r5.f17275b
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 != 0) goto L_0x0017
            goto L_0x0019
        L_0x0017:
            r5 = 0
            return r5
        L_0x0019:
            r5 = 1
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: y9.o.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        long j10 = this.f17275b;
        return (this.f17274a * 31) + ((int) (j10 ^ (j10 >>> 32)));
    }

    public final String toString() {
        return "FileSliceInfo(slicingCount=" + this.f17274a + ", bytesPerFileSlice=" + this.f17275b + ")";
    }
}
