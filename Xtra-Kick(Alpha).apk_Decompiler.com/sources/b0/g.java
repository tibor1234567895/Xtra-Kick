package b0;

import android.os.Handler;
import android.os.Looper;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    public static final Class f2346a;

    /* renamed from: b  reason: collision with root package name */
    public static final Field f2347b;

    /* renamed from: c  reason: collision with root package name */
    public static final Field f2348c;

    /* renamed from: d  reason: collision with root package name */
    public static final Method f2349d;

    /* renamed from: e  reason: collision with root package name */
    public static final Method f2350e;

    /* renamed from: f  reason: collision with root package name */
    public static final Method f2351f;

    /* renamed from: g  reason: collision with root package name */
    public static final Handler f2352g = new Handler(Looper.getMainLooper());

    /* JADX WARNING: Removed duplicated region for block: B:23:0x005d A[SYNTHETIC, Splitter:B:23:0x005d] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0083  */
    static {
        /*
            java.lang.Class<android.app.Activity> r0 = android.app.Activity.class
            android.os.Handler r1 = new android.os.Handler
            android.os.Looper r2 = android.os.Looper.getMainLooper()
            r1.<init>(r2)
            f2352g = r1
            r1 = 0
            java.lang.String r2 = "android.app.ActivityThread"
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch:{ all -> 0x0015 }
            goto L_0x0016
        L_0x0015:
            r2 = r1
        L_0x0016:
            f2346a = r2
            r2 = 1
            java.lang.String r3 = "mMainThread"
            java.lang.reflect.Field r3 = r0.getDeclaredField(r3)     // Catch:{ all -> 0x0023 }
            r3.setAccessible(r2)     // Catch:{ all -> 0x0023 }
            goto L_0x0024
        L_0x0023:
            r3 = r1
        L_0x0024:
            f2347b = r3
            java.lang.String r3 = "mToken"
            java.lang.reflect.Field r0 = r0.getDeclaredField(r3)     // Catch:{ all -> 0x0030 }
            r0.setAccessible(r2)     // Catch:{ all -> 0x0030 }
            goto L_0x0032
        L_0x0030:
            r0 = r1
        L_0x0032:
            f2348c = r0
            java.lang.Class r0 = f2346a
            r3 = 0
            r4 = 3
            java.lang.String r5 = "performStopActivity"
            r6 = 2
            java.lang.Class<android.os.IBinder> r7 = android.os.IBinder.class
            if (r0 != 0) goto L_0x0040
            goto L_0x0055
        L_0x0040:
            java.lang.Class[] r8 = new java.lang.Class[r4]     // Catch:{ all -> 0x0054 }
            r8[r3] = r7     // Catch:{ all -> 0x0054 }
            java.lang.Class r9 = java.lang.Boolean.TYPE     // Catch:{ all -> 0x0054 }
            r8[r2] = r9     // Catch:{ all -> 0x0054 }
            java.lang.Class<java.lang.String> r9 = java.lang.String.class
            r8[r6] = r9     // Catch:{ all -> 0x0054 }
            java.lang.reflect.Method r0 = r0.getDeclaredMethod(r5, r8)     // Catch:{ all -> 0x0054 }
            r0.setAccessible(r2)     // Catch:{ all -> 0x0054 }
            goto L_0x0056
        L_0x0054:
        L_0x0055:
            r0 = r1
        L_0x0056:
            f2349d = r0
            java.lang.Class r0 = f2346a
            if (r0 != 0) goto L_0x005d
            goto L_0x006d
        L_0x005d:
            java.lang.Class[] r8 = new java.lang.Class[r6]     // Catch:{ all -> 0x006d }
            r8[r3] = r7     // Catch:{ all -> 0x006d }
            java.lang.Class r9 = java.lang.Boolean.TYPE     // Catch:{ all -> 0x006d }
            r8[r2] = r9     // Catch:{ all -> 0x006d }
            java.lang.reflect.Method r0 = r0.getDeclaredMethod(r5, r8)     // Catch:{ all -> 0x006d }
            r0.setAccessible(r2)     // Catch:{ all -> 0x006d }
            goto L_0x006e
        L_0x006d:
            r0 = r1
        L_0x006e:
            f2350e = r0
            java.lang.Class r0 = f2346a
            java.lang.Class<android.content.res.Configuration> r5 = android.content.res.Configuration.class
            java.lang.Class<java.util.List> r8 = java.util.List.class
            int r9 = android.os.Build.VERSION.SDK_INT
            r10 = 26
            if (r9 == r10) goto L_0x0083
            r10 = 27
            if (r9 != r10) goto L_0x0081
            goto L_0x0083
        L_0x0081:
            r9 = 0
            goto L_0x0084
        L_0x0083:
            r9 = 1
        L_0x0084:
            if (r9 == 0) goto L_0x00b3
            if (r0 != 0) goto L_0x0089
            goto L_0x00b3
        L_0x0089:
            java.lang.String r9 = "requestRelaunchActivity"
            r10 = 9
            java.lang.Class[] r10 = new java.lang.Class[r10]     // Catch:{ all -> 0x00b3 }
            r10[r3] = r7     // Catch:{ all -> 0x00b3 }
            r10[r2] = r8     // Catch:{ all -> 0x00b3 }
            r10[r6] = r8     // Catch:{ all -> 0x00b3 }
            java.lang.Class r3 = java.lang.Integer.TYPE     // Catch:{ all -> 0x00b3 }
            r10[r4] = r3     // Catch:{ all -> 0x00b3 }
            java.lang.Class r3 = java.lang.Boolean.TYPE     // Catch:{ all -> 0x00b3 }
            r4 = 4
            r10[r4] = r3     // Catch:{ all -> 0x00b3 }
            r4 = 5
            r10[r4] = r5     // Catch:{ all -> 0x00b3 }
            r4 = 6
            r10[r4] = r5     // Catch:{ all -> 0x00b3 }
            r4 = 7
            r10[r4] = r3     // Catch:{ all -> 0x00b3 }
            r4 = 8
            r10[r4] = r3     // Catch:{ all -> 0x00b3 }
            java.lang.reflect.Method r0 = r0.getDeclaredMethod(r9, r10)     // Catch:{ all -> 0x00b3 }
            r0.setAccessible(r2)     // Catch:{ all -> 0x00b3 }
            r1 = r0
        L_0x00b3:
            f2351f = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: b0.g.<clinit>():void");
    }

    private g() {
    }
}
