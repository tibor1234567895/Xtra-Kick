package ma;

public final class e0 {

    /* renamed from: a  reason: collision with root package name */
    public final int f10808a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f10809b;

    public e0(int i10, Object obj) {
        this.f10808a = i10;
        this.f10809b = obj;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000a, code lost:
        r5 = (ma.e0) r5;
        r1 = r5.f10808a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r5) {
        /*
            r4 = this;
            r0 = 1
            if (r4 != r5) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r5 instanceof ma.e0
            r2 = 0
            if (r1 != 0) goto L_0x000a
            return r2
        L_0x000a:
            ma.e0 r5 = (ma.e0) r5
            int r1 = r5.f10808a
            int r3 = r4.f10808a
            if (r3 == r1) goto L_0x0013
            return r2
        L_0x0013:
            java.lang.Object r1 = r4.f10809b
            java.lang.Object r5 = r5.f10809b
            boolean r5 = xa.j.a(r1, r5)
            if (r5 != 0) goto L_0x001e
            return r2
        L_0x001e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ma.e0.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int i10 = this.f10808a * 31;
        Object obj = this.f10809b;
        return i10 + (obj == null ? 0 : obj.hashCode());
    }

    public final String toString() {
        return "IndexedValue(index=" + this.f10808a + ", value=" + this.f10809b + ')';
    }
}
