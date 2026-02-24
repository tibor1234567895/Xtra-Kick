package e6;

import hb.f0;
import la.v;
import pa.e;
import ra.i;
import wa.p;

public final class d2 extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ f2 f5099i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ String f5100j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d2(f2 f2Var, String str, e eVar) {
        super(2, eVar);
        this.f5099i = f2Var;
        this.f5100j = str;
    }

    public final e create(Object obj, e eVar) {
        return new d2(this.f5099i, this.f5100j, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((d2) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v0, resolved type: com.github.andreyasadchy.xtra.model.offline.SortGame} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v1, resolved type: com.github.andreyasadchy.xtra.model.offline.SortGame} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v3, resolved type: com.github.andreyasadchy.xtra.model.offline.SortGame} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v0, resolved type: java.lang.Integer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v4, resolved type: com.github.andreyasadchy.xtra.model.offline.SortGame} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v1, resolved type: com.github.andreyasadchy.xtra.model.offline.SortGame} */
    /* JADX WARNING: type inference failed for: r13v2, types: [java.lang.Integer] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r24) {
        /*
            r23 = this;
            r1 = r23
            hb.h0.O1(r24)
            e6.f2 r0 = r1.f5099i
            a6.v r0 = r0.f5121a
            a6.w r0 = (a6.w) r0
            r0.getClass()
            r2 = 1
            java.lang.String r3 = "SELECT * FROM sort_game WHERE id = ?"
            r3.s0 r3 = r3.s0.k(r2, r3)
            java.lang.String r4 = r1.f5100j
            if (r4 != 0) goto L_0x001d
            r3.F(r2)
            goto L_0x0020
        L_0x001d:
            r3.q(r2, r4)
        L_0x0020:
            r3.n0 r0 = r0.f263a
            r0.b()
            android.database.Cursor r4 = hb.h0.n1(r0, r3)
            java.lang.String r0 = "id"
            int r0 = hb.h0.c0(r4, r0)     // Catch:{ all -> 0x00fe }
            java.lang.String r5 = "saveSort"
            int r5 = hb.h0.c0(r4, r5)     // Catch:{ all -> 0x00fe }
            java.lang.String r6 = "videoSort"
            int r6 = hb.h0.c0(r4, r6)     // Catch:{ all -> 0x00fe }
            java.lang.String r7 = "videoPeriod"
            int r7 = hb.h0.c0(r4, r7)     // Catch:{ all -> 0x00fe }
            java.lang.String r8 = "videoType"
            int r8 = hb.h0.c0(r4, r8)     // Catch:{ all -> 0x00fe }
            java.lang.String r9 = "videoLanguageIndex"
            int r9 = hb.h0.c0(r4, r9)     // Catch:{ all -> 0x00fe }
            java.lang.String r10 = "clipPeriod"
            int r10 = hb.h0.c0(r4, r10)     // Catch:{ all -> 0x00fe }
            java.lang.String r11 = "clipLanguageIndex"
            int r11 = hb.h0.c0(r4, r11)     // Catch:{ all -> 0x00fe }
            boolean r12 = r4.moveToFirst()     // Catch:{ all -> 0x00fe }
            r13 = 0
            if (r12 == 0) goto L_0x00f7
            boolean r12 = r4.isNull(r0)     // Catch:{ all -> 0x00fe }
            if (r12 == 0) goto L_0x0068
            r15 = r13
            goto L_0x006d
        L_0x0068:
            java.lang.String r0 = r4.getString(r0)     // Catch:{ all -> 0x00fe }
            r15 = r0
        L_0x006d:
            boolean r0 = r4.isNull(r5)     // Catch:{ all -> 0x00fe }
            if (r0 == 0) goto L_0x0075
            r0 = r13
            goto L_0x007d
        L_0x0075:
            int r0 = r4.getInt(r5)     // Catch:{ all -> 0x00fe }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x00fe }
        L_0x007d:
            if (r0 != 0) goto L_0x0082
            r16 = r13
            goto L_0x0090
        L_0x0082:
            int r0 = r0.intValue()     // Catch:{ all -> 0x00fe }
            if (r0 == 0) goto L_0x0089
            goto L_0x008a
        L_0x0089:
            r2 = 0
        L_0x008a:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r2)     // Catch:{ all -> 0x00fe }
            r16 = r0
        L_0x0090:
            boolean r0 = r4.isNull(r6)     // Catch:{ all -> 0x00fe }
            if (r0 == 0) goto L_0x0099
            r17 = r13
            goto L_0x009f
        L_0x0099:
            java.lang.String r0 = r4.getString(r6)     // Catch:{ all -> 0x00fe }
            r17 = r0
        L_0x009f:
            boolean r0 = r4.isNull(r7)     // Catch:{ all -> 0x00fe }
            if (r0 == 0) goto L_0x00a8
            r18 = r13
            goto L_0x00ae
        L_0x00a8:
            java.lang.String r0 = r4.getString(r7)     // Catch:{ all -> 0x00fe }
            r18 = r0
        L_0x00ae:
            boolean r0 = r4.isNull(r8)     // Catch:{ all -> 0x00fe }
            if (r0 == 0) goto L_0x00b7
            r19 = r13
            goto L_0x00bd
        L_0x00b7:
            java.lang.String r0 = r4.getString(r8)     // Catch:{ all -> 0x00fe }
            r19 = r0
        L_0x00bd:
            boolean r0 = r4.isNull(r9)     // Catch:{ all -> 0x00fe }
            if (r0 == 0) goto L_0x00c6
            r20 = r13
            goto L_0x00d0
        L_0x00c6:
            int r0 = r4.getInt(r9)     // Catch:{ all -> 0x00fe }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x00fe }
            r20 = r0
        L_0x00d0:
            boolean r0 = r4.isNull(r10)     // Catch:{ all -> 0x00fe }
            if (r0 == 0) goto L_0x00d9
            r21 = r13
            goto L_0x00df
        L_0x00d9:
            java.lang.String r0 = r4.getString(r10)     // Catch:{ all -> 0x00fe }
            r21 = r0
        L_0x00df:
            boolean r0 = r4.isNull(r11)     // Catch:{ all -> 0x00fe }
            if (r0 == 0) goto L_0x00e8
        L_0x00e5:
            r22 = r13
            goto L_0x00f1
        L_0x00e8:
            int r0 = r4.getInt(r11)     // Catch:{ all -> 0x00fe }
            java.lang.Integer r13 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x00fe }
            goto L_0x00e5
        L_0x00f1:
            com.github.andreyasadchy.xtra.model.offline.SortGame r13 = new com.github.andreyasadchy.xtra.model.offline.SortGame     // Catch:{ all -> 0x00fe }
            r14 = r13
            r14.<init>(r15, r16, r17, r18, r19, r20, r21, r22)     // Catch:{ all -> 0x00fe }
        L_0x00f7:
            r4.close()
            r3.v()
            return r13
        L_0x00fe:
            r0 = move-exception
            r4.close()
            r3.v()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e6.d2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
