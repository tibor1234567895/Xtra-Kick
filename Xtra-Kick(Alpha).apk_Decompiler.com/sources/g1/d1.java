package g1;

import android.os.Bundle;
import j1.l0;

public class d1 extends Exception implements m {

    /* renamed from: j  reason: collision with root package name */
    public static final String f6343j = l0.C(0);

    /* renamed from: k  reason: collision with root package name */
    public static final String f6344k = l0.C(1);

    /* renamed from: l  reason: collision with root package name */
    public static final String f6345l = l0.C(2);

    /* renamed from: m  reason: collision with root package name */
    public static final String f6346m = l0.C(3);

    /* renamed from: n  reason: collision with root package name */
    public static final String f6347n = l0.C(4);

    /* renamed from: o  reason: collision with root package name */
    public static final a f6348o = new a(13);

    /* renamed from: h  reason: collision with root package name */
    public final int f6349h;

    /* renamed from: i  reason: collision with root package name */
    public final long f6350i;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: android.os.RemoteException} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: java.lang.Throwable} */
    /* JADX WARNING: Illegal instructions before constructor call */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public d1(android.os.Bundle r8) {
        /*
            r7 = this;
            java.lang.String r0 = f6345l
            java.lang.String r2 = r8.getString(r0)
            java.lang.String r0 = f6346m
            java.lang.String r0 = r8.getString(r0)
            java.lang.String r1 = f6347n
            java.lang.String r1 = r8.getString(r1)
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            r4 = 0
            if (r3 != 0) goto L_0x0051
            java.lang.Class<g1.d1> r3 = g1.d1.class
            java.lang.ClassLoader r3 = r3.getClassLoader()     // Catch:{ all -> 0x004a }
            r5 = 1
            java.lang.Class r0 = java.lang.Class.forName(r0, r5, r3)     // Catch:{ all -> 0x004a }
            java.lang.Class<java.lang.Throwable> r3 = java.lang.Throwable.class
            boolean r3 = r3.isAssignableFrom(r0)     // Catch:{ all -> 0x004a }
            if (r3 == 0) goto L_0x0042
            java.lang.Class[] r3 = new java.lang.Class[r5]     // Catch:{ all -> 0x004a }
            java.lang.Class<java.lang.String> r4 = java.lang.String.class
            r6 = 0
            r3[r6] = r4     // Catch:{ all -> 0x004a }
            java.lang.reflect.Constructor r0 = r0.getConstructor(r3)     // Catch:{ all -> 0x004a }
            java.lang.Object[] r3 = new java.lang.Object[r5]     // Catch:{ all -> 0x004a }
            r3[r6] = r1     // Catch:{ all -> 0x004a }
            java.lang.Object r0 = r0.newInstance(r3)     // Catch:{ all -> 0x004a }
            r4 = r0
            java.lang.Throwable r4 = (java.lang.Throwable) r4     // Catch:{ all -> 0x004a }
        L_0x0042:
            if (r4 != 0) goto L_0x0051
            android.os.RemoteException r0 = new android.os.RemoteException
            r0.<init>(r1)
            goto L_0x004f
        L_0x004a:
            android.os.RemoteException r0 = new android.os.RemoteException
            r0.<init>(r1)
        L_0x004f:
            r3 = r0
            goto L_0x0052
        L_0x0051:
            r3 = r4
        L_0x0052:
            java.lang.String r0 = f6343j
            r1 = 1000(0x3e8, float:1.401E-42)
            int r4 = r8.getInt(r0, r1)
            java.lang.String r0 = f6344k
            long r5 = android.os.SystemClock.elapsedRealtime()
            long r5 = r8.getLong(r0, r5)
            r1 = r7
            r1.<init>(r2, r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: g1.d1.<init>(android.os.Bundle):void");
    }

    public Bundle h() {
        Bundle bundle = new Bundle();
        bundle.putInt(f6343j, this.f6349h);
        bundle.putLong(f6344k, this.f6350i);
        bundle.putString(f6345l, getMessage());
        Throwable cause = getCause();
        if (cause != null) {
            bundle.putString(f6346m, cause.getClass().getName());
            bundle.putString(f6347n, cause.getMessage());
        }
        return bundle;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003e, code lost:
        if (r3 == null) goto L_0x0041;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean i(g1.d1 r7) {
        /*
            r6 = this;
            r0 = 1
            if (r6 != r7) goto L_0x0004
            return r0
        L_0x0004:
            r1 = 0
            if (r7 == 0) goto L_0x0060
            java.lang.Class r2 = r6.getClass()
            java.lang.Class r3 = r7.getClass()
            if (r2 == r3) goto L_0x0012
            goto L_0x0060
        L_0x0012:
            java.lang.Throwable r2 = r6.getCause()
            java.lang.Throwable r3 = r7.getCause()
            if (r2 == 0) goto L_0x003c
            if (r3 == 0) goto L_0x003c
            java.lang.String r4 = r2.getMessage()
            java.lang.String r5 = r3.getMessage()
            boolean r4 = j1.l0.a(r4, r5)
            if (r4 != 0) goto L_0x002d
            return r1
        L_0x002d:
            java.lang.Class r2 = r2.getClass()
            java.lang.Class r3 = r3.getClass()
            boolean r2 = j1.l0.a(r2, r3)
            if (r2 != 0) goto L_0x0041
            return r1
        L_0x003c:
            if (r2 != 0) goto L_0x0060
            if (r3 == 0) goto L_0x0041
            goto L_0x0060
        L_0x0041:
            int r2 = r6.f6349h
            int r3 = r7.f6349h
            if (r2 != r3) goto L_0x005e
            java.lang.String r2 = r6.getMessage()
            java.lang.String r3 = r7.getMessage()
            boolean r2 = j1.l0.a(r2, r3)
            if (r2 == 0) goto L_0x005e
            long r2 = r6.f6350i
            long r4 = r7.f6350i
            int r7 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r7 != 0) goto L_0x005e
            goto L_0x005f
        L_0x005e:
            r0 = 0
        L_0x005f:
            return r0
        L_0x0060:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: g1.d1.i(g1.d1):boolean");
    }

    public d1(String str, Throwable th, int i10, long j10) {
        super(str, th);
        this.f6349h = i10;
        this.f6350i = j10;
    }
}
