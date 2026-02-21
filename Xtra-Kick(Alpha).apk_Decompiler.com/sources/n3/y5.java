package n3;

import fb.p;

public final class y5 extends a6 {

    /* renamed from: e  reason: collision with root package name */
    public final int f11592e;

    /* renamed from: f  reason: collision with root package name */
    public final int f11593f;

    public y5(int i10, int i11, int i12, int i13, int i14, int i15) {
        super(i12, i13, i14, i15);
        this.f11592e = i10;
        this.f11593f = i11;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000a, code lost:
        r5 = (n3.y5) r5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r5) {
        /*
            r4 = this;
            r0 = 1
            if (r4 != r5) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r5 instanceof n3.y5
            r2 = 0
            if (r1 != 0) goto L_0x000a
            return r2
        L_0x000a:
            n3.y5 r5 = (n3.y5) r5
            int r1 = r5.f11592e
            int r3 = r4.f11592e
            if (r3 != r1) goto L_0x0031
            int r1 = r4.f11593f
            int r3 = r5.f11593f
            if (r1 != r3) goto L_0x0031
            int r1 = r5.f11051a
            int r3 = r4.f11051a
            if (r3 != r1) goto L_0x0031
            int r1 = r5.f11052b
            int r3 = r4.f11052b
            if (r3 != r1) goto L_0x0031
            int r1 = r5.f11053c
            int r3 = r4.f11053c
            if (r3 != r1) goto L_0x0031
            int r5 = r5.f11054d
            int r1 = r4.f11054d
            if (r1 != r5) goto L_0x0031
            goto L_0x0032
        L_0x0031:
            r0 = 0
        L_0x0032:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: n3.y5.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        return super.hashCode() + this.f11592e + this.f11593f;
    }

    public final String toString() {
        return p.b("ViewportHint.Access(\n            |    pageOffset=" + this.f11592e + ",\n            |    indexInPage=" + this.f11593f + ",\n            |    presentedItemsBefore=" + this.f11051a + ",\n            |    presentedItemsAfter=" + this.f11052b + ",\n            |    originalPageOffsetFirst=" + this.f11053c + ",\n            |    originalPageOffsetLast=" + this.f11054d + ",\n            |)");
    }
}
