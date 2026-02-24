package kotlinx.coroutines.android;

import kotlinx.coroutines.CoroutineExceptionHandler;
import pa.a;

public final class AndroidExceptionPreHandler extends a implements CoroutineExceptionHandler {
    private volatile Object _preHandler = this;

    public AndroidExceptionPreHandler() {
        super(CoroutineExceptionHandler.f9430e);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0039, code lost:
        if (r1 != false) goto L_0x003d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void z(pa.k r6, java.lang.Throwable r7) {
        /*
            r5 = this;
            int r6 = android.os.Build.VERSION.SDK_INT
            r0 = 26
            r1 = 1
            r2 = 0
            if (r0 > r6) goto L_0x000e
            r0 = 28
            if (r6 >= r0) goto L_0x000e
            r6 = 1
            goto L_0x000f
        L_0x000e:
            r6 = 0
        L_0x000f:
            if (r6 == 0) goto L_0x0059
            java.lang.Object r6 = r5._preHandler
            r0 = 0
            if (r6 == r5) goto L_0x0019
            java.lang.reflect.Method r6 = (java.lang.reflect.Method) r6
            goto L_0x003f
        L_0x0019:
            java.lang.Class<java.lang.Thread> r6 = java.lang.Thread.class
            java.lang.String r3 = "getUncaughtExceptionPreHandler"
            java.lang.Class[] r4 = new java.lang.Class[r2]     // Catch:{ all -> 0x003c }
            java.lang.reflect.Method r6 = r6.getDeclaredMethod(r3, r4)     // Catch:{ all -> 0x003c }
            int r3 = r6.getModifiers()     // Catch:{ all -> 0x003c }
            boolean r3 = java.lang.reflect.Modifier.isPublic(r3)     // Catch:{ all -> 0x003c }
            if (r3 == 0) goto L_0x0038
            int r3 = r6.getModifiers()     // Catch:{ all -> 0x003c }
            boolean r3 = java.lang.reflect.Modifier.isStatic(r3)     // Catch:{ all -> 0x003c }
            if (r3 == 0) goto L_0x0038
            goto L_0x0039
        L_0x0038:
            r1 = 0
        L_0x0039:
            if (r1 == 0) goto L_0x003c
            goto L_0x003d
        L_0x003c:
            r6 = r0
        L_0x003d:
            r5._preHandler = r6
        L_0x003f:
            if (r6 == 0) goto L_0x0048
            java.lang.Object[] r1 = new java.lang.Object[r2]
            java.lang.Object r6 = r6.invoke(r0, r1)
            goto L_0x0049
        L_0x0048:
            r6 = r0
        L_0x0049:
            boolean r1 = r6 instanceof java.lang.Thread.UncaughtExceptionHandler
            if (r1 == 0) goto L_0x0050
            r0 = r6
            java.lang.Thread$UncaughtExceptionHandler r0 = (java.lang.Thread.UncaughtExceptionHandler) r0
        L_0x0050:
            if (r0 == 0) goto L_0x0059
            java.lang.Thread r6 = java.lang.Thread.currentThread()
            r0.uncaughtException(r6, r7)
        L_0x0059:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.android.AndroidExceptionPreHandler.z(pa.k, java.lang.Throwable):void");
    }
}
