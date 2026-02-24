package e6;

import hb.f0;
import la.v;
import pa.e;
import ra.i;
import wa.p;

public final class a1 extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ e1 f5078i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f5079j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a1(e1 e1Var, int i10, e eVar) {
        super(2, eVar);
        this.f5078i = e1Var;
        this.f5079j = i10;
    }

    public final e create(Object obj, e eVar) {
        return new a1(this.f5078i, this.f5079j, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((a1) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: com.github.andreyasadchy.xtra.model.offline.LocalFollowGame} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v3, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v4, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            hb.h0.O1(r9)
            e6.e1 r9 = r8.f5078i
            a6.j r9 = r9.f5108a
            a6.l r9 = (a6.l) r9
            r9.getClass()
            r0 = 1
            java.lang.String r1 = "SELECT * FROM local_follows_games WHERE gameId = ?"
            r3.s0 r1 = r3.s0.k(r0, r1)
            int r2 = r8.f5079j
            long r2 = (long) r2
            r1.g0(r0, r2)
            r3.n0 r9 = r9.f244a
            r9.b()
            android.database.Cursor r9 = hb.h0.n1(r9, r1)
            java.lang.String r0 = "gameId"
            int r0 = hb.h0.c0(r9, r0)     // Catch:{ all -> 0x008e }
            java.lang.String r2 = "gameSlug"
            int r2 = hb.h0.c0(r9, r2)     // Catch:{ all -> 0x008e }
            java.lang.String r3 = "gameName"
            int r3 = hb.h0.c0(r9, r3)     // Catch:{ all -> 0x008e }
            java.lang.String r4 = "boxArt"
            int r4 = hb.h0.c0(r9, r4)     // Catch:{ all -> 0x008e }
            java.lang.String r5 = "id"
            int r5 = hb.h0.c0(r9, r5)     // Catch:{ all -> 0x008e }
            boolean r6 = r9.moveToFirst()     // Catch:{ all -> 0x008e }
            r7 = 0
            if (r6 == 0) goto L_0x0087
            boolean r6 = r9.isNull(r0)     // Catch:{ all -> 0x008e }
            if (r6 == 0) goto L_0x004f
            r0 = r7
            goto L_0x0057
        L_0x004f:
            int r0 = r9.getInt(r0)     // Catch:{ all -> 0x008e }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x008e }
        L_0x0057:
            boolean r6 = r9.isNull(r2)     // Catch:{ all -> 0x008e }
            if (r6 == 0) goto L_0x005f
            r2 = r7
            goto L_0x0063
        L_0x005f:
            java.lang.String r2 = r9.getString(r2)     // Catch:{ all -> 0x008e }
        L_0x0063:
            boolean r6 = r9.isNull(r3)     // Catch:{ all -> 0x008e }
            if (r6 == 0) goto L_0x006b
            r3 = r7
            goto L_0x006f
        L_0x006b:
            java.lang.String r3 = r9.getString(r3)     // Catch:{ all -> 0x008e }
        L_0x006f:
            boolean r6 = r9.isNull(r4)     // Catch:{ all -> 0x008e }
            if (r6 == 0) goto L_0x0076
            goto L_0x007a
        L_0x0076:
            java.lang.String r7 = r9.getString(r4)     // Catch:{ all -> 0x008e }
        L_0x007a:
            com.github.andreyasadchy.xtra.model.offline.LocalFollowGame r4 = new com.github.andreyasadchy.xtra.model.offline.LocalFollowGame     // Catch:{ all -> 0x008e }
            r4.<init>(r0, r2, r3, r7)     // Catch:{ all -> 0x008e }
            int r0 = r9.getInt(r5)     // Catch:{ all -> 0x008e }
            r4.setId(r0)     // Catch:{ all -> 0x008e }
            r7 = r4
        L_0x0087:
            r9.close()
            r1.v()
            return r7
        L_0x008e:
            r0 = move-exception
            r9.close()
            r1.v()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e6.a1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
