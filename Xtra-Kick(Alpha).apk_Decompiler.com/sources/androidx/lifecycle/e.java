package androidx.lifecycle;

import java.lang.reflect.Method;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public final int f1674a;

    /* renamed from: b  reason: collision with root package name */
    public final Method f1675b;

    public e(Method method, int i10) {
        this.f1674a = i10;
        this.f1675b = method;
        method.setAccessible(true);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000a, code lost:
        r5 = (androidx.lifecycle.e) r5;
        r1 = r5.f1674a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r5) {
        /*
            r4 = this;
            r0 = 1
            if (r4 != r5) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r5 instanceof androidx.lifecycle.e
            r2 = 0
            if (r1 != 0) goto L_0x000a
            return r2
        L_0x000a:
            androidx.lifecycle.e r5 = (androidx.lifecycle.e) r5
            int r1 = r5.f1674a
            int r3 = r4.f1674a
            if (r3 != r1) goto L_0x0025
            java.lang.reflect.Method r1 = r4.f1675b
            java.lang.String r1 = r1.getName()
            java.lang.reflect.Method r5 = r5.f1675b
            java.lang.String r5 = r5.getName()
            boolean r5 = r1.equals(r5)
            if (r5 == 0) goto L_0x0025
            goto L_0x0026
        L_0x0025:
            r0 = 0
        L_0x0026:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.e.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        return this.f1675b.getName().hashCode() + (this.f1674a * 31);
    }
}
