package c0;

public final class j {
    private j() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0089 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int a(android.content.Context r8, java.lang.String r9) {
        /*
            int r0 = android.os.Process.myPid()
            int r1 = android.os.Process.myUid()
            java.lang.String r2 = r8.getPackageName()
            int r0 = r8.checkPermission(r9, r0, r1)
            r3 = -1
            if (r0 != r3) goto L_0x0015
            goto L_0x008a
        L_0x0015:
            int r0 = android.os.Build.VERSION.SDK_INT
            r4 = 23
            if (r0 < r4) goto L_0x0020
            java.lang.String r9 = b0.h.d(r9)
            goto L_0x0021
        L_0x0020:
            r9 = 0
        L_0x0021:
            r5 = 0
            if (r9 != 0) goto L_0x0025
            goto L_0x0087
        L_0x0025:
            if (r2 != 0) goto L_0x0037
            android.content.pm.PackageManager r2 = r8.getPackageManager()
            java.lang.String[] r2 = r2.getPackagesForUid(r1)
            if (r2 == 0) goto L_0x008a
            int r6 = r2.length
            if (r6 > 0) goto L_0x0035
            goto L_0x008a
        L_0x0035:
            r2 = r2[r5]
        L_0x0037:
            int r3 = android.os.Process.myUid()
            java.lang.String r6 = r8.getPackageName()
            r7 = 1
            if (r3 != r1) goto L_0x004a
            boolean r3 = l0.b.a(r6, r2)
            if (r3 == 0) goto L_0x004a
            r3 = 1
            goto L_0x004b
        L_0x004a:
            r3 = 0
        L_0x004b:
            java.lang.Class<android.app.AppOpsManager> r6 = android.app.AppOpsManager.class
            if (r3 == 0) goto L_0x0078
            r3 = 29
            if (r0 < r3) goto L_0x006b
            android.app.AppOpsManager r0 = b0.i.c(r8)
            int r3 = android.os.Binder.getCallingUid()
            int r2 = b0.i.a(r0, r9, r3, r2)
            if (r2 == 0) goto L_0x0062
            goto L_0x0085
        L_0x0062:
            java.lang.String r8 = b0.i.b(r8)
            int r2 = b0.i.a(r0, r9, r1, r8)
            goto L_0x0085
        L_0x006b:
            if (r0 < r4) goto L_0x0084
            java.lang.Object r8 = b0.h.a(r8, r6)
            android.app.AppOpsManager r8 = (android.app.AppOpsManager) r8
            int r7 = b0.h.c(r8, r9, r2)
            goto L_0x0084
        L_0x0078:
            if (r0 < r4) goto L_0x0084
            java.lang.Object r8 = b0.h.a(r8, r6)
            android.app.AppOpsManager r8 = (android.app.AppOpsManager) r8
            int r7 = b0.h.c(r8, r9, r2)
        L_0x0084:
            r2 = r7
        L_0x0085:
            if (r2 != 0) goto L_0x0089
        L_0x0087:
            r3 = 0
            goto L_0x008a
        L_0x0089:
            r3 = -2
        L_0x008a:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: c0.j.a(android.content.Context, java.lang.String):int");
    }
}
