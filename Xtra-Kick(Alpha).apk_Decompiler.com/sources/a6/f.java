package a6;

import android.database.Cursor;
import com.github.andreyasadchy.xtra.model.offline.Bookmark;
import hb.h0;
import java.util.ArrayList;
import r3.n0;
import r3.s0;

public final class f implements b {

    /* renamed from: a  reason: collision with root package name */
    public final n0 f234a;

    /* renamed from: b  reason: collision with root package name */
    public final c f235b;

    /* renamed from: c  reason: collision with root package name */
    public final d f236c;

    /* renamed from: d  reason: collision with root package name */
    public final d f237d;

    public f(n0 n0Var) {
        this.f234a = n0Var;
        this.f235b = new c(this, n0Var, 0);
        this.f236c = new d(n0Var, 0);
        this.f237d = new d(n0Var, 1);
    }

    public final ArrayList a(int i10) {
        s0 s0Var;
        String str;
        int i11;
        s0 k10 = s0.k(1, "SELECT * FROM bookmarks WHERE userId = ?");
        k10.g0(1, (long) i10);
        n0 n0Var = this.f234a;
        n0Var.b();
        Cursor n12 = h0.n1(n0Var, k10);
        try {
            int c02 = h0.c0(n12, "videoId");
            int c03 = h0.c0(n12, "userId");
            int c04 = h0.c0(n12, "userLogin");
            int c05 = h0.c0(n12, "userName");
            int c06 = h0.c0(n12, "userType");
            int c07 = h0.c0(n12, "userBroadcasterType");
            int c08 = h0.c0(n12, "userLogo");
            int c09 = h0.c0(n12, "gameId");
            int c010 = h0.c0(n12, "gameName");
            int c011 = h0.c0(n12, "gameSlug");
            int c012 = h0.c0(n12, "boxArtUrl");
            int c013 = h0.c0(n12, "title");
            int c014 = h0.c0(n12, "createdAt");
            int c015 = h0.c0(n12, "thumbnail");
            s0Var = k10;
            try {
                int c016 = h0.c0(n12, "type");
                int c017 = h0.c0(n12, "duration");
                int c018 = h0.c0(n12, "animatedPreviewURL");
                int c019 = h0.c0(n12, "id");
                int i12 = c015;
                ArrayList arrayList = new ArrayList(n12.getCount());
                while (n12.moveToNext()) {
                    String str2 = null;
                    String string = n12.isNull(c02) ? null : n12.getString(c02);
                    int i13 = n12.getInt(c03);
                    String string2 = n12.isNull(c04) ? null : n12.getString(c04);
                    String string3 = n12.isNull(c05) ? null : n12.getString(c05);
                    String string4 = n12.isNull(c06) ? null : n12.getString(c06);
                    String string5 = n12.isNull(c07) ? null : n12.getString(c07);
                    String string6 = n12.isNull(c08) ? null : n12.getString(c08);
                    int i14 = n12.getInt(c09);
                    String string7 = n12.isNull(c010) ? null : n12.getString(c010);
                    String string8 = n12.isNull(c011) ? null : n12.getString(c011);
                    String string9 = n12.isNull(c012) ? null : n12.getString(c012);
                    String string10 = n12.isNull(c013) ? null : n12.getString(c013);
                    if (n12.isNull(c014)) {
                        i11 = i12;
                        str = null;
                    } else {
                        str = n12.getString(c014);
                        i11 = i12;
                    }
                    String string11 = n12.isNull(i11) ? null : n12.getString(i11);
                    int i15 = c02;
                    int i16 = c016;
                    String string12 = n12.isNull(i16) ? null : n12.getString(i16);
                    c016 = i16;
                    int i17 = c017;
                    String string13 = n12.isNull(i17) ? null : n12.getString(i17);
                    c017 = i17;
                    int i18 = c018;
                    if (!n12.isNull(i18)) {
                        str2 = n12.getString(i18);
                    }
                    c018 = i18;
                    Bookmark bookmark = new Bookmark(string, i13, string2, string3, string4, string5, string6, i14, string7, string8, string9, string10, str, string11, string12, string13, str2);
                    int i19 = i11;
                    int i20 = c019;
                    int i21 = c03;
                    bookmark.setId(n12.getInt(i20));
                    arrayList.add(bookmark);
                    c03 = i21;
                    c02 = i15;
                    i12 = i19;
                    c019 = i20;
                }
                n12.close();
                s0Var.v();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                n12.close();
                s0Var.v();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            s0Var = k10;
            n12.close();
            s0Var.v();
            throw th;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v0, resolved type: com.github.andreyasadchy.xtra.model.offline.Bookmark} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v1, resolved type: com.github.andreyasadchy.xtra.model.offline.Bookmark} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v3, resolved type: com.github.andreyasadchy.xtra.model.offline.Bookmark} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r38v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v4, resolved type: com.github.andreyasadchy.xtra.model.offline.Bookmark} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v5, resolved type: com.github.andreyasadchy.xtra.model.offline.Bookmark} */
    /* JADX WARNING: type inference failed for: r20v2, types: [java.lang.String] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.github.andreyasadchy.xtra.model.offline.Bookmark b(java.lang.String r40) {
        /*
            r39 = this;
            r0 = r40
            java.lang.String r1 = "SELECT * FROM bookmarks WHERE videoId = ?"
            r2 = 1
            r3.s0 r1 = r3.s0.k(r2, r1)
            if (r0 != 0) goto L_0x000f
            r1.F(r2)
            goto L_0x0012
        L_0x000f:
            r1.q(r2, r0)
        L_0x0012:
            r2 = r39
            r3.n0 r0 = r2.f234a
            r0.b()
            android.database.Cursor r3 = hb.h0.n1(r0, r1)
            java.lang.String r0 = "videoId"
            int r0 = hb.h0.c0(r3, r0)     // Catch:{ all -> 0x01a6 }
            java.lang.String r4 = "userId"
            int r4 = hb.h0.c0(r3, r4)     // Catch:{ all -> 0x01a6 }
            java.lang.String r5 = "userLogin"
            int r5 = hb.h0.c0(r3, r5)     // Catch:{ all -> 0x01a6 }
            java.lang.String r6 = "userName"
            int r6 = hb.h0.c0(r3, r6)     // Catch:{ all -> 0x01a6 }
            java.lang.String r7 = "userType"
            int r7 = hb.h0.c0(r3, r7)     // Catch:{ all -> 0x01a6 }
            java.lang.String r8 = "userBroadcasterType"
            int r8 = hb.h0.c0(r3, r8)     // Catch:{ all -> 0x01a6 }
            java.lang.String r9 = "userLogo"
            int r9 = hb.h0.c0(r3, r9)     // Catch:{ all -> 0x01a6 }
            java.lang.String r10 = "gameId"
            int r10 = hb.h0.c0(r3, r10)     // Catch:{ all -> 0x01a6 }
            java.lang.String r11 = "gameName"
            int r11 = hb.h0.c0(r3, r11)     // Catch:{ all -> 0x01a6 }
            java.lang.String r12 = "gameSlug"
            int r12 = hb.h0.c0(r3, r12)     // Catch:{ all -> 0x01a6 }
            java.lang.String r13 = "boxArtUrl"
            int r13 = hb.h0.c0(r3, r13)     // Catch:{ all -> 0x01a6 }
            java.lang.String r14 = "title"
            int r14 = hb.h0.c0(r3, r14)     // Catch:{ all -> 0x01a6 }
            java.lang.String r15 = "createdAt"
            int r15 = hb.h0.c0(r3, r15)     // Catch:{ all -> 0x01a6 }
            java.lang.String r2 = "thumbnail"
            int r2 = hb.h0.c0(r3, r2)     // Catch:{ all -> 0x01a6 }
            r16 = r1
            java.lang.String r1 = "type"
            int r1 = hb.h0.c0(r3, r1)     // Catch:{ all -> 0x01a4 }
            r40 = r1
            java.lang.String r1 = "duration"
            int r1 = hb.h0.c0(r3, r1)     // Catch:{ all -> 0x01a4 }
            r17 = r1
            java.lang.String r1 = "animatedPreviewURL"
            int r1 = hb.h0.c0(r3, r1)     // Catch:{ all -> 0x01a4 }
            r18 = r1
            java.lang.String r1 = "id"
            int r1 = hb.h0.c0(r3, r1)     // Catch:{ all -> 0x01a4 }
            boolean r19 = r3.moveToFirst()     // Catch:{ all -> 0x01a4 }
            r20 = 0
            if (r19 == 0) goto L_0x019d
            boolean r19 = r3.isNull(r0)     // Catch:{ all -> 0x01a4 }
            if (r19 == 0) goto L_0x00a2
            r22 = r20
            goto L_0x00a8
        L_0x00a2:
            java.lang.String r0 = r3.getString(r0)     // Catch:{ all -> 0x01a4 }
            r22 = r0
        L_0x00a8:
            int r23 = r3.getInt(r4)     // Catch:{ all -> 0x01a4 }
            boolean r0 = r3.isNull(r5)     // Catch:{ all -> 0x01a4 }
            if (r0 == 0) goto L_0x00b5
            r24 = r20
            goto L_0x00bb
        L_0x00b5:
            java.lang.String r0 = r3.getString(r5)     // Catch:{ all -> 0x01a4 }
            r24 = r0
        L_0x00bb:
            boolean r0 = r3.isNull(r6)     // Catch:{ all -> 0x01a4 }
            if (r0 == 0) goto L_0x00c4
            r25 = r20
            goto L_0x00ca
        L_0x00c4:
            java.lang.String r0 = r3.getString(r6)     // Catch:{ all -> 0x01a4 }
            r25 = r0
        L_0x00ca:
            boolean r0 = r3.isNull(r7)     // Catch:{ all -> 0x01a4 }
            if (r0 == 0) goto L_0x00d3
            r26 = r20
            goto L_0x00d9
        L_0x00d3:
            java.lang.String r0 = r3.getString(r7)     // Catch:{ all -> 0x01a4 }
            r26 = r0
        L_0x00d9:
            boolean r0 = r3.isNull(r8)     // Catch:{ all -> 0x01a4 }
            if (r0 == 0) goto L_0x00e2
            r27 = r20
            goto L_0x00e8
        L_0x00e2:
            java.lang.String r0 = r3.getString(r8)     // Catch:{ all -> 0x01a4 }
            r27 = r0
        L_0x00e8:
            boolean r0 = r3.isNull(r9)     // Catch:{ all -> 0x01a4 }
            if (r0 == 0) goto L_0x00f1
            r28 = r20
            goto L_0x00f7
        L_0x00f1:
            java.lang.String r0 = r3.getString(r9)     // Catch:{ all -> 0x01a4 }
            r28 = r0
        L_0x00f7:
            int r29 = r3.getInt(r10)     // Catch:{ all -> 0x01a4 }
            boolean r0 = r3.isNull(r11)     // Catch:{ all -> 0x01a4 }
            if (r0 == 0) goto L_0x0104
            r30 = r20
            goto L_0x010a
        L_0x0104:
            java.lang.String r0 = r3.getString(r11)     // Catch:{ all -> 0x01a4 }
            r30 = r0
        L_0x010a:
            boolean r0 = r3.isNull(r12)     // Catch:{ all -> 0x01a4 }
            if (r0 == 0) goto L_0x0113
            r31 = r20
            goto L_0x0119
        L_0x0113:
            java.lang.String r0 = r3.getString(r12)     // Catch:{ all -> 0x01a4 }
            r31 = r0
        L_0x0119:
            boolean r0 = r3.isNull(r13)     // Catch:{ all -> 0x01a4 }
            if (r0 == 0) goto L_0x0122
            r32 = r20
            goto L_0x0128
        L_0x0122:
            java.lang.String r0 = r3.getString(r13)     // Catch:{ all -> 0x01a4 }
            r32 = r0
        L_0x0128:
            boolean r0 = r3.isNull(r14)     // Catch:{ all -> 0x01a4 }
            if (r0 == 0) goto L_0x0131
            r33 = r20
            goto L_0x0137
        L_0x0131:
            java.lang.String r0 = r3.getString(r14)     // Catch:{ all -> 0x01a4 }
            r33 = r0
        L_0x0137:
            boolean r0 = r3.isNull(r15)     // Catch:{ all -> 0x01a4 }
            if (r0 == 0) goto L_0x0140
            r34 = r20
            goto L_0x0146
        L_0x0140:
            java.lang.String r0 = r3.getString(r15)     // Catch:{ all -> 0x01a4 }
            r34 = r0
        L_0x0146:
            boolean r0 = r3.isNull(r2)     // Catch:{ all -> 0x01a4 }
            if (r0 == 0) goto L_0x0151
            r0 = r40
            r35 = r20
            goto L_0x0159
        L_0x0151:
            java.lang.String r0 = r3.getString(r2)     // Catch:{ all -> 0x01a4 }
            r35 = r0
            r0 = r40
        L_0x0159:
            boolean r2 = r3.isNull(r0)     // Catch:{ all -> 0x01a4 }
            if (r2 == 0) goto L_0x0164
            r0 = r17
            r36 = r20
            goto L_0x016c
        L_0x0164:
            java.lang.String r0 = r3.getString(r0)     // Catch:{ all -> 0x01a4 }
            r36 = r0
            r0 = r17
        L_0x016c:
            boolean r2 = r3.isNull(r0)     // Catch:{ all -> 0x01a4 }
            if (r2 == 0) goto L_0x0177
            r0 = r18
            r37 = r20
            goto L_0x017f
        L_0x0177:
            java.lang.String r0 = r3.getString(r0)     // Catch:{ all -> 0x01a4 }
            r37 = r0
            r0 = r18
        L_0x017f:
            boolean r2 = r3.isNull(r0)     // Catch:{ all -> 0x01a4 }
            if (r2 == 0) goto L_0x0188
        L_0x0185:
            r38 = r20
            goto L_0x018d
        L_0x0188:
            java.lang.String r20 = r3.getString(r0)     // Catch:{ all -> 0x01a4 }
            goto L_0x0185
        L_0x018d:
            com.github.andreyasadchy.xtra.model.offline.Bookmark r0 = new com.github.andreyasadchy.xtra.model.offline.Bookmark     // Catch:{ all -> 0x01a4 }
            r21 = r0
            r21.<init>(r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38)     // Catch:{ all -> 0x01a4 }
            int r1 = r3.getInt(r1)     // Catch:{ all -> 0x01a4 }
            r0.setId(r1)     // Catch:{ all -> 0x01a4 }
            r20 = r0
        L_0x019d:
            r3.close()
            r16.v()
            return r20
        L_0x01a4:
            r0 = move-exception
            goto L_0x01a9
        L_0x01a6:
            r0 = move-exception
            r16 = r1
        L_0x01a9:
            r3.close()
            r16.v()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a6.f.b(java.lang.String):com.github.andreyasadchy.xtra.model.offline.Bookmark");
    }
}
