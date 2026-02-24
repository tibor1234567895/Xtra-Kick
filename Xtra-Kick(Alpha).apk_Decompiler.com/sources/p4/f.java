package p4;

public final class f implements d {
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0032 A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0034  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(java.lang.Object r6, s4.m r7) {
        /*
            r5 = this;
            android.net.Uri r6 = (android.net.Uri) r6
            java.lang.String r0 = r6.getScheme()
            java.lang.String r1 = "android.resource"
            boolean r0 = xa.j.a(r0, r1)
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x002f
            java.lang.String r0 = r6.getAuthority()
            if (r0 == 0) goto L_0x001f
            boolean r0 = fb.w.h(r0)
            if (r0 == 0) goto L_0x001d
            goto L_0x001f
        L_0x001d:
            r0 = 0
            goto L_0x0020
        L_0x001f:
            r0 = 1
        L_0x0020:
            if (r0 != 0) goto L_0x002f
            java.util.List r0 = r6.getPathSegments()
            int r0 = r0.size()
            r3 = 2
            if (r0 != r3) goto L_0x002f
            r0 = 1
            goto L_0x0030
        L_0x002f:
            r0 = 0
        L_0x0030:
            if (r0 != 0) goto L_0x0034
            r6 = 0
            goto L_0x007f
        L_0x0034:
            java.lang.String r0 = r6.getAuthority()
            if (r0 != 0) goto L_0x003c
            java.lang.String r0 = ""
        L_0x003c:
            android.content.Context r7 = r7.f14276a
            android.content.pm.PackageManager r7 = r7.getPackageManager()
            android.content.res.Resources r7 = r7.getResourcesForApplication(r0)
            java.util.List r3 = r6.getPathSegments()
            java.lang.Object r4 = r3.get(r2)
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r3 = r3.get(r1)
            java.lang.String r3 = (java.lang.String) r3
            int r7 = r7.getIdentifier(r3, r4, r0)
            if (r7 == 0) goto L_0x005d
            goto L_0x005e
        L_0x005d:
            r1 = 0
        L_0x005e:
            if (r1 == 0) goto L_0x0080
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r1 = "android.resource://"
            r6.<init>(r1)
            r6.append(r0)
            r0 = 47
            r6.append(r0)
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            android.net.Uri r6 = android.net.Uri.parse(r6)
            java.lang.String r7 = "parse(this)"
            xa.j.e(r7, r6)
        L_0x007f:
            return r6
        L_0x0080:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r0 = "Invalid android.resource URI: "
            r7.<init>(r0)
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r6 = r6.toString()
            r7.<init>(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: p4.f.a(java.lang.Object, s4.m):java.lang.Object");
    }
}
