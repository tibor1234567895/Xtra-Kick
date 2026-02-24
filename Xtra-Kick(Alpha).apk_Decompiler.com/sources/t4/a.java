package t4;

public final class a extends c {

    /* renamed from: a  reason: collision with root package name */
    public final int f14542a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(int i10) {
        super(0);
        boolean z10 = false;
        this.f14542a = i10;
        if (!(i10 > 0 ? true : z10)) {
            throw new IllegalArgumentException("px must be > 0.".toString());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0008, code lost:
        r3 = ((t4.a) r3).f14542a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r3) {
        /*
            r2 = this;
            r0 = 1
            if (r2 != r3) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r3 instanceof t4.a
            if (r1 == 0) goto L_0x0011
            t4.a r3 = (t4.a) r3
            int r3 = r3.f14542a
            int r1 = r2.f14542a
            if (r1 != r3) goto L_0x0011
            goto L_0x0012
        L_0x0011:
            r0 = 0
        L_0x0012:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: t4.a.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        return this.f14542a;
    }

    public final String toString() {
        return String.valueOf(this.f14542a);
    }
}
