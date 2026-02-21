package mb;

import hb.x1;

public final class u {

    /* renamed from: a  reason: collision with root package name */
    public static final x1 f10886a;

    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        r3.a();
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0068 */
    static {
        /*
            mb.u r0 = new mb.u
            r0.<init>()
            java.lang.String r0 = "kotlinx.coroutines.fast.service.loader"
            int r1 = mb.b0.f10840a
            r1 = 0
            java.lang.String r0 = java.lang.System.getProperty(r0)     // Catch:{ SecurityException -> 0x000f }
            goto L_0x0011
        L_0x000f:
            r0 = r1
        L_0x0011:
            if (r0 == 0) goto L_0x0016
            java.lang.Boolean.parseBoolean(r0)
        L_0x0016:
            java.lang.Class<kotlinx.coroutines.internal.MainDispatcherFactory> r0 = kotlinx.coroutines.internal.MainDispatcherFactory.class
            java.lang.ClassLoader r2 = r0.getClassLoader()     // Catch:{ all -> 0x0078 }
            java.util.ServiceLoader r0 = java.util.ServiceLoader.load(r0, r2)     // Catch:{ all -> 0x0078 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0078 }
            eb.h r0 = eb.m.a(r0)     // Catch:{ all -> 0x0078 }
            java.util.List r0 = eb.q.d(r0)     // Catch:{ all -> 0x0078 }
            java.util.Iterator r2 = r0.iterator()     // Catch:{ all -> 0x0078 }
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x0078 }
            if (r3 != 0) goto L_0x0038
            r3 = r1
            goto L_0x005f
        L_0x0038:
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x0078 }
            boolean r4 = r2.hasNext()     // Catch:{ all -> 0x0078 }
            if (r4 != 0) goto L_0x0043
            goto L_0x005f
        L_0x0043:
            r4 = r3
            kotlinx.coroutines.internal.MainDispatcherFactory r4 = (kotlinx.coroutines.internal.MainDispatcherFactory) r4     // Catch:{ all -> 0x0078 }
            int r4 = r4.c()     // Catch:{ all -> 0x0078 }
        L_0x004a:
            java.lang.Object r5 = r2.next()     // Catch:{ all -> 0x0078 }
            r6 = r5
            kotlinx.coroutines.internal.MainDispatcherFactory r6 = (kotlinx.coroutines.internal.MainDispatcherFactory) r6     // Catch:{ all -> 0x0078 }
            int r6 = r6.c()     // Catch:{ all -> 0x0078 }
            if (r4 >= r6) goto L_0x0059
            r3 = r5
            r4 = r6
        L_0x0059:
            boolean r5 = r2.hasNext()     // Catch:{ all -> 0x0078 }
            if (r5 != 0) goto L_0x004a
        L_0x005f:
            kotlinx.coroutines.internal.MainDispatcherFactory r3 = (kotlinx.coroutines.internal.MainDispatcherFactory) r3     // Catch:{ all -> 0x0078 }
            if (r3 == 0) goto L_0x0070
            hb.x1 r1 = r3.b(r0)     // Catch:{ all -> 0x0068 }
            goto L_0x006b
        L_0x0068:
            r3.a()     // Catch:{ all -> 0x0078 }
        L_0x006b:
            if (r1 == 0) goto L_0x0070
            f10886a = r1
            return
        L_0x0070:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0078 }
            java.lang.String r1 = "Module with the Main dispatcher is missing. Add dependency providing the Main dispatcher, e.g. 'kotlinx-coroutines-android' and ensure it has the same version as 'kotlinx-coroutines-core'"
            r0.<init>(r1)     // Catch:{ all -> 0x0078 }
            throw r0     // Catch:{ all -> 0x0078 }
        L_0x0078:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: mb.u.<clinit>():void");
    }

    private u() {
    }
}
