package sa;

import java.lang.reflect.Method;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final Method f14455a;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: java.lang.Class[]} */
    /* JADX WARNING: type inference failed for: r5v5 */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0037, code lost:
        if (xa.j.a(r5, r0) != false) goto L_0x003b;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    static {
        /*
            sa.a r0 = new sa.a
            r0.<init>()
            java.lang.Class<java.lang.Throwable> r0 = java.lang.Throwable.class
            java.lang.reflect.Method[] r1 = r0.getMethods()
            java.lang.String r2 = "throwableMethods"
            xa.j.e(r2, r1)
            int r2 = r1.length
            r3 = 0
            r4 = 0
        L_0x0013:
            r5 = 0
            if (r4 >= r2) goto L_0x0042
            r6 = r1[r4]
            java.lang.String r7 = r6.getName()
            java.lang.String r8 = "addSuppressed"
            boolean r7 = xa.j.a(r7, r8)
            if (r7 == 0) goto L_0x003a
            java.lang.Class[] r7 = r6.getParameterTypes()
            java.lang.String r8 = "it.parameterTypes"
            xa.j.e(r8, r7)
            int r8 = r7.length
            r9 = 1
            if (r8 != r9) goto L_0x0033
            r5 = r7[r3]
        L_0x0033:
            boolean r5 = xa.j.a(r5, r0)
            if (r5 == 0) goto L_0x003a
            goto L_0x003b
        L_0x003a:
            r9 = 0
        L_0x003b:
            if (r9 == 0) goto L_0x003f
            r5 = r6
            goto L_0x0042
        L_0x003f:
            int r4 = r4 + 1
            goto L_0x0013
        L_0x0042:
            f14455a = r5
            int r0 = r1.length
        L_0x0045:
            if (r3 >= r0) goto L_0x0059
            r2 = r1[r3]
            java.lang.String r2 = r2.getName()
            java.lang.String r4 = "getSuppressed"
            boolean r2 = xa.j.a(r2, r4)
            if (r2 == 0) goto L_0x0056
            goto L_0x0059
        L_0x0056:
            int r3 = r3 + 1
            goto L_0x0045
        L_0x0059:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: sa.a.<clinit>():void");
    }

    private a() {
    }
}
