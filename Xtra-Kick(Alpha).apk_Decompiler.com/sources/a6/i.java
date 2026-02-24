package a6;

import r3.n0;

public final class i implements g {

    /* renamed from: a  reason: collision with root package name */
    public final n0 f239a;

    /* renamed from: b  reason: collision with root package name */
    public final c f240b;

    /* renamed from: c  reason: collision with root package name */
    public final h f241c;

    /* renamed from: d  reason: collision with root package name */
    public final h f242d;

    public i(n0 n0Var) {
        this.f239a = n0Var;
        this.f240b = new c(this, n0Var, 1);
        this.f241c = new h(n0Var, 0);
        this.f242d = new h(n0Var, 1);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: com.github.andreyasadchy.xtra.model.offline.LocalFollowChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r7v0 */
    /* JADX WARNING: type inference failed for: r7v3 */
    /* JADX WARNING: type inference failed for: r7v5 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.github.andreyasadchy.xtra.model.offline.LocalFollowChannel a(int r9) {
        /*
            r8 = this;
            java.lang.String r0 = "SELECT * FROM local_follows WHERE userId = ?"
            r1 = 1
            r3.s0 r0 = r3.s0.k(r1, r0)
            long r2 = (long) r9
            r0.g0(r1, r2)
            r3.n0 r9 = r8.f239a
            r9.b()
            android.database.Cursor r9 = hb.h0.n1(r9, r0)
            java.lang.String r1 = "userId"
            int r1 = hb.h0.c0(r9, r1)     // Catch:{ all -> 0x0074 }
            java.lang.String r2 = "userLogin"
            int r2 = hb.h0.c0(r9, r2)     // Catch:{ all -> 0x0074 }
            java.lang.String r3 = "userName"
            int r3 = hb.h0.c0(r9, r3)     // Catch:{ all -> 0x0074 }
            java.lang.String r4 = "channelLogo"
            int r4 = hb.h0.c0(r9, r4)     // Catch:{ all -> 0x0074 }
            java.lang.String r5 = "id"
            int r5 = hb.h0.c0(r9, r5)     // Catch:{ all -> 0x0074 }
            boolean r6 = r9.moveToFirst()     // Catch:{ all -> 0x0074 }
            r7 = 0
            if (r6 == 0) goto L_0x006d
            int r1 = r9.getInt(r1)     // Catch:{ all -> 0x0074 }
            boolean r6 = r9.isNull(r2)     // Catch:{ all -> 0x0074 }
            if (r6 == 0) goto L_0x0045
            r2 = r7
            goto L_0x0049
        L_0x0045:
            java.lang.String r2 = r9.getString(r2)     // Catch:{ all -> 0x0074 }
        L_0x0049:
            boolean r6 = r9.isNull(r3)     // Catch:{ all -> 0x0074 }
            if (r6 == 0) goto L_0x0051
            r3 = r7
            goto L_0x0055
        L_0x0051:
            java.lang.String r3 = r9.getString(r3)     // Catch:{ all -> 0x0074 }
        L_0x0055:
            boolean r6 = r9.isNull(r4)     // Catch:{ all -> 0x0074 }
            if (r6 == 0) goto L_0x005c
            goto L_0x0060
        L_0x005c:
            java.lang.String r7 = r9.getString(r4)     // Catch:{ all -> 0x0074 }
        L_0x0060:
            com.github.andreyasadchy.xtra.model.offline.LocalFollowChannel r4 = new com.github.andreyasadchy.xtra.model.offline.LocalFollowChannel     // Catch:{ all -> 0x0074 }
            r4.<init>(r1, r2, r3, r7)     // Catch:{ all -> 0x0074 }
            int r1 = r9.getInt(r5)     // Catch:{ all -> 0x0074 }
            r4.setId(r1)     // Catch:{ all -> 0x0074 }
            r7 = r4
        L_0x006d:
            r9.close()
            r0.v()
            return r7
        L_0x0074:
            r1 = move-exception
            r9.close()
            r0.v()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: a6.i.a(int):com.github.andreyasadchy.xtra.model.offline.LocalFollowChannel");
    }
}
