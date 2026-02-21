package cb;

public final class e extends b {

    /* renamed from: l  reason: collision with root package name */
    public static final d f3070l = new d(0);

    /* renamed from: m  reason: collision with root package name */
    public static final e f3071m = new e(1, 0);

    public e(int i10, int i11) {
        super(i10, i11, 1);
    }

    public final boolean b(int i10) {
        return this.f3063h <= i10 && i10 <= this.f3064i;
    }

    public final Comparable c() {
        return Integer.valueOf(this.f3064i);
    }

    public final Comparable d() {
        return Integer.valueOf(this.f3063h);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0013, code lost:
        r3 = (cb.e) r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r3) {
        /*
            r2 = this;
            boolean r0 = r3 instanceof cb.e
            if (r0 == 0) goto L_0x0023
            boolean r0 = r2.isEmpty()
            if (r0 == 0) goto L_0x0013
            r0 = r3
            cb.e r0 = (cb.e) r0
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x0021
        L_0x0013:
            cb.e r3 = (cb.e) r3
            int r0 = r3.f3063h
            int r1 = r2.f3063h
            if (r1 != r0) goto L_0x0023
            int r3 = r3.f3064i
            int r0 = r2.f3064i
            if (r0 != r3) goto L_0x0023
        L_0x0021:
            r3 = 1
            goto L_0x0024
        L_0x0023:
            r3 = 0
        L_0x0024:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: cb.e.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (this.f3063h * 31) + this.f3064i;
    }

    public final boolean isEmpty() {
        return this.f3063h > this.f3064i;
    }

    public final String toString() {
        return this.f3063h + ".." + this.f3064i;
    }
}
