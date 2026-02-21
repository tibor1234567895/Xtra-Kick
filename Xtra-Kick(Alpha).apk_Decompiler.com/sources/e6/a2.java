package e6;

import hb.f0;
import la.v;
import pa.e;
import ra.i;
import wa.p;

public final class a2 extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ c2 f5080i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ String f5081j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a2(c2 c2Var, String str, e eVar) {
        super(2, eVar);
        this.f5080i = c2Var;
        this.f5081j = str;
    }

    public final e create(Object obj, e eVar) {
        return new a2(this.f5080i, this.f5081j, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((a2) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v0, resolved type: com.github.andreyasadchy.xtra.model.offline.SortChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v1, resolved type: com.github.andreyasadchy.xtra.model.offline.SortChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v3, resolved type: com.github.andreyasadchy.xtra.model.offline.SortChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v4, resolved type: com.github.andreyasadchy.xtra.model.offline.SortChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: com.github.andreyasadchy.xtra.model.offline.SortChannel} */
    /* JADX WARNING: type inference failed for: r10v2, types: [java.lang.String] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r18) {
        /*
            r17 = this;
            r1 = r17
            hb.h0.O1(r18)
            e6.c2 r0 = r1.f5080i
            a6.t r0 = r0.f5094a
            a6.u r0 = (a6.u) r0
            r0.getClass()
            r2 = 1
            java.lang.String r3 = "SELECT * FROM sort_channel WHERE id = ?"
            r3.s0 r3 = r3.s0.k(r2, r3)
            java.lang.String r4 = r1.f5081j
            if (r4 != 0) goto L_0x001d
            r3.F(r2)
            goto L_0x0020
        L_0x001d:
            r3.q(r2, r4)
        L_0x0020:
            r3.n0 r0 = r0.f261a
            r0.b()
            android.database.Cursor r4 = hb.h0.n1(r0, r3)
            java.lang.String r0 = "id"
            int r0 = hb.h0.c0(r4, r0)     // Catch:{ all -> 0x00b1 }
            java.lang.String r5 = "saveSort"
            int r5 = hb.h0.c0(r4, r5)     // Catch:{ all -> 0x00b1 }
            java.lang.String r6 = "videoSort"
            int r6 = hb.h0.c0(r4, r6)     // Catch:{ all -> 0x00b1 }
            java.lang.String r7 = "videoType"
            int r7 = hb.h0.c0(r4, r7)     // Catch:{ all -> 0x00b1 }
            java.lang.String r8 = "clipPeriod"
            int r8 = hb.h0.c0(r4, r8)     // Catch:{ all -> 0x00b1 }
            boolean r9 = r4.moveToFirst()     // Catch:{ all -> 0x00b1 }
            r10 = 0
            if (r9 == 0) goto L_0x00aa
            boolean r9 = r4.isNull(r0)     // Catch:{ all -> 0x00b1 }
            if (r9 == 0) goto L_0x0056
            r12 = r10
            goto L_0x005b
        L_0x0056:
            java.lang.String r0 = r4.getString(r0)     // Catch:{ all -> 0x00b1 }
            r12 = r0
        L_0x005b:
            boolean r0 = r4.isNull(r5)     // Catch:{ all -> 0x00b1 }
            if (r0 == 0) goto L_0x0063
            r0 = r10
            goto L_0x006b
        L_0x0063:
            int r0 = r4.getInt(r5)     // Catch:{ all -> 0x00b1 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x00b1 }
        L_0x006b:
            if (r0 != 0) goto L_0x006f
            r13 = r10
            goto L_0x007c
        L_0x006f:
            int r0 = r0.intValue()     // Catch:{ all -> 0x00b1 }
            if (r0 == 0) goto L_0x0076
            goto L_0x0077
        L_0x0076:
            r2 = 0
        L_0x0077:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r2)     // Catch:{ all -> 0x00b1 }
            r13 = r0
        L_0x007c:
            boolean r0 = r4.isNull(r6)     // Catch:{ all -> 0x00b1 }
            if (r0 == 0) goto L_0x0084
            r14 = r10
            goto L_0x0089
        L_0x0084:
            java.lang.String r0 = r4.getString(r6)     // Catch:{ all -> 0x00b1 }
            r14 = r0
        L_0x0089:
            boolean r0 = r4.isNull(r7)     // Catch:{ all -> 0x00b1 }
            if (r0 == 0) goto L_0x0091
            r15 = r10
            goto L_0x0096
        L_0x0091:
            java.lang.String r0 = r4.getString(r7)     // Catch:{ all -> 0x00b1 }
            r15 = r0
        L_0x0096:
            boolean r0 = r4.isNull(r8)     // Catch:{ all -> 0x00b1 }
            if (r0 == 0) goto L_0x009f
        L_0x009c:
            r16 = r10
            goto L_0x00a4
        L_0x009f:
            java.lang.String r10 = r4.getString(r8)     // Catch:{ all -> 0x00b1 }
            goto L_0x009c
        L_0x00a4:
            com.github.andreyasadchy.xtra.model.offline.SortChannel r10 = new com.github.andreyasadchy.xtra.model.offline.SortChannel     // Catch:{ all -> 0x00b1 }
            r11 = r10
            r11.<init>(r12, r13, r14, r15, r16)     // Catch:{ all -> 0x00b1 }
        L_0x00aa:
            r4.close()
            r3.v()
            return r10
        L_0x00b1:
            r0 = move-exception
            r4.close()
            r3.v()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e6.a2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
