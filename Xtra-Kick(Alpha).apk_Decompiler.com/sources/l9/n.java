package l9;

import java.util.Map;

public final class n implements Map.Entry {

    /* renamed from: h  reason: collision with root package name */
    public n f9777h;

    /* renamed from: i  reason: collision with root package name */
    public n f9778i;

    /* renamed from: j  reason: collision with root package name */
    public n f9779j;

    /* renamed from: k  reason: collision with root package name */
    public n f9780k;

    /* renamed from: l  reason: collision with root package name */
    public n f9781l;

    /* renamed from: m  reason: collision with root package name */
    public final Object f9782m;

    /* renamed from: n  reason: collision with root package name */
    public Object f9783n;

    /* renamed from: o  reason: collision with root package name */
    public int f9784o;

    public n() {
        this.f9782m = null;
        this.f9781l = this;
        this.f9780k = this;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x002d A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            boolean r0 = r4 instanceof java.util.Map.Entry
            r1 = 0
            if (r0 == 0) goto L_0x002e
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            java.lang.Object r0 = r3.f9782m
            if (r0 != 0) goto L_0x0012
            java.lang.Object r0 = r4.getKey()
            if (r0 != 0) goto L_0x002e
            goto L_0x001c
        L_0x0012:
            java.lang.Object r2 = r4.getKey()
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x002e
        L_0x001c:
            java.lang.Object r0 = r3.f9783n
            java.lang.Object r4 = r4.getValue()
            if (r0 != 0) goto L_0x0027
            if (r4 != 0) goto L_0x002e
            goto L_0x002d
        L_0x0027:
            boolean r4 = r0.equals(r4)
            if (r4 == 0) goto L_0x002e
        L_0x002d:
            r1 = 1
        L_0x002e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: l9.n.equals(java.lang.Object):boolean");
    }

    public final Object getKey() {
        return this.f9782m;
    }

    public final Object getValue() {
        return this.f9783n;
    }

    public final int hashCode() {
        int i10 = 0;
        Object obj = this.f9782m;
        int hashCode = obj == null ? 0 : obj.hashCode();
        Object obj2 = this.f9783n;
        if (obj2 != null) {
            i10 = obj2.hashCode();
        }
        return i10 ^ hashCode;
    }

    public final Object setValue(Object obj) {
        Object obj2 = this.f9783n;
        this.f9783n = obj;
        return obj2;
    }

    public final String toString() {
        return this.f9782m + Constants.ATTRIBUTE_SEPARATOR + this.f9783n;
    }

    public n(n nVar, Object obj, n nVar2, n nVar3) {
        this.f9777h = nVar;
        this.f9782m = obj;
        this.f9784o = 1;
        this.f9780k = nVar2;
        this.f9781l = nVar3;
        nVar3.f9780k = this;
        nVar2.f9781l = this;
    }
}
