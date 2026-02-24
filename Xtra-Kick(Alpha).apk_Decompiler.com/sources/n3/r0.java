package n3;

import xa.j;

public final class r0 {

    /* renamed from: a  reason: collision with root package name */
    public final int f11451a;

    /* renamed from: b  reason: collision with root package name */
    public final a6 f11452b;

    public r0(int i10, a6 a6Var) {
        j.f("hint", a6Var);
        this.f11451a = i10;
        this.f11452b = a6Var;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000a, code lost:
        r5 = (n3.r0) r5;
        r1 = r5.f11451a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r5) {
        /*
            r4 = this;
            r0 = 1
            if (r4 != r5) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r5 instanceof n3.r0
            r2 = 0
            if (r1 != 0) goto L_0x000a
            return r2
        L_0x000a:
            n3.r0 r5 = (n3.r0) r5
            int r1 = r5.f11451a
            int r3 = r4.f11451a
            if (r3 == r1) goto L_0x0013
            return r2
        L_0x0013:
            n3.a6 r1 = r4.f11452b
            n3.a6 r5 = r5.f11452b
            boolean r5 = xa.j.a(r1, r5)
            if (r5 != 0) goto L_0x001e
            return r2
        L_0x001e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: n3.r0.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        return this.f11452b.hashCode() + (this.f11451a * 31);
    }

    public final String toString() {
        return "GenerationalViewportHint(generationId=" + this.f11451a + ", hint=" + this.f11452b + ')';
    }
}
