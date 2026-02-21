package n3;

import xa.j;

public final class w0 extends a1 {

    /* renamed from: b  reason: collision with root package name */
    public final Throwable f11535b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public w0(Throwable th) {
        super(false);
        j.f("error", th);
        this.f11535b = th;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r3 = (n3.w0) r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r3) {
        /*
            r2 = this;
            boolean r0 = r3 instanceof n3.w0
            if (r0 == 0) goto L_0x0018
            n3.w0 r3 = (n3.w0) r3
            boolean r0 = r3.f11039a
            boolean r1 = r2.f11039a
            if (r1 != r0) goto L_0x0018
            java.lang.Throwable r0 = r2.f11535b
            java.lang.Throwable r3 = r3.f11535b
            boolean r3 = xa.j.a(r0, r3)
            if (r3 == 0) goto L_0x0018
            r3 = 1
            goto L_0x0019
        L_0x0018:
            r3 = 0
        L_0x0019:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: n3.w0.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        return this.f11535b.hashCode() + (this.f11039a ? 1231 : 1237);
    }

    public final String toString() {
        return "Error(endOfPaginationReached=" + this.f11039a + ", error=" + this.f11535b + ')';
    }
}
