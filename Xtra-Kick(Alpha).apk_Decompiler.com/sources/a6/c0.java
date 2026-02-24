package a6;

import android.database.Cursor;
import com.github.andreyasadchy.xtra.model.offline.OfflineVideo;
import hb.h0;
import java.util.ArrayList;
import r3.n0;
import r3.s0;

public final class c0 implements z {

    /* renamed from: a  reason: collision with root package name */
    public final n0 f221a;

    /* renamed from: b  reason: collision with root package name */
    public final c f222b;

    /* renamed from: c  reason: collision with root package name */
    public final a0 f223c;

    /* renamed from: d  reason: collision with root package name */
    public final a0 f224d;

    /* renamed from: e  reason: collision with root package name */
    public final b0 f225e;

    /* renamed from: f  reason: collision with root package name */
    public final b0 f226f;

    public c0(n0 n0Var) {
        this.f221a = n0Var;
        this.f222b = new c(this, n0Var, 8);
        this.f223c = new a0(n0Var, 0);
        this.f224d = new a0(n0Var, 1);
        this.f225e = new b0(n0Var, 0);
        this.f226f = new b0(n0Var, 1);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r26v0, resolved type: com.github.andreyasadchy.xtra.model.offline.OfflineVideo} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r26v1, resolved type: com.github.andreyasadchy.xtra.model.offline.OfflineVideo} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r26v3, resolved type: com.github.andreyasadchy.xtra.model.offline.OfflineVideo} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r49v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r26v4, resolved type: com.github.andreyasadchy.xtra.model.offline.OfflineVideo} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r26v5, resolved type: com.github.andreyasadchy.xtra.model.offline.OfflineVideo} */
    /* JADX WARNING: type inference failed for: r26v2, types: [java.lang.String] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.github.andreyasadchy.xtra.model.offline.OfflineVideo a(int r51) {
        /*
            r50 = this;
            java.lang.String r0 = "SELECT * FROM videos WHERE id = ?"
            r1 = 1
            r3.s0 r2 = r3.s0.k(r1, r0)
            r0 = r51
            long r3 = (long) r0
            r2.g0(r1, r3)
            r3 = r50
            r3.n0 r0 = r3.f221a
            r0.b()
            android.database.Cursor r4 = hb.h0.n1(r0, r2)
            java.lang.String r0 = "url"
            int r0 = hb.h0.c0(r4, r0)     // Catch:{ all -> 0x022b }
            java.lang.String r5 = "source_url"
            int r5 = hb.h0.c0(r4, r5)     // Catch:{ all -> 0x022b }
            java.lang.String r6 = "source_start_position"
            int r6 = hb.h0.c0(r4, r6)     // Catch:{ all -> 0x022b }
            java.lang.String r7 = "name"
            int r7 = hb.h0.c0(r4, r7)     // Catch:{ all -> 0x022b }
            java.lang.String r8 = "channel_id"
            int r8 = hb.h0.c0(r4, r8)     // Catch:{ all -> 0x022b }
            java.lang.String r9 = "channel_login"
            int r9 = hb.h0.c0(r4, r9)     // Catch:{ all -> 0x022b }
            java.lang.String r10 = "channel_name"
            int r10 = hb.h0.c0(r4, r10)     // Catch:{ all -> 0x022b }
            java.lang.String r11 = "channel_logo"
            int r11 = hb.h0.c0(r4, r11)     // Catch:{ all -> 0x022b }
            java.lang.String r12 = "thumbnail"
            int r12 = hb.h0.c0(r4, r12)     // Catch:{ all -> 0x022b }
            java.lang.String r13 = "gameId"
            int r13 = hb.h0.c0(r4, r13)     // Catch:{ all -> 0x022b }
            java.lang.String r14 = "gameName"
            int r14 = hb.h0.c0(r4, r14)     // Catch:{ all -> 0x022b }
            java.lang.String r15 = "gameSlug"
            int r15 = hb.h0.c0(r4, r15)     // Catch:{ all -> 0x022b }
            java.lang.String r1 = "boxArtUrl"
            int r1 = hb.h0.c0(r4, r1)     // Catch:{ all -> 0x022b }
            java.lang.String r3 = "duration"
            int r3 = hb.h0.c0(r4, r3)     // Catch:{ all -> 0x022b }
            r16 = r2
            java.lang.String r2 = "upload_date"
            int r2 = hb.h0.c0(r4, r2)     // Catch:{ all -> 0x0229 }
            r51 = r2
            java.lang.String r2 = "download_date"
            int r2 = hb.h0.c0(r4, r2)     // Catch:{ all -> 0x0229 }
            r17 = r2
            java.lang.String r2 = "last_watch_position"
            int r2 = hb.h0.c0(r4, r2)     // Catch:{ all -> 0x0229 }
            r18 = r2
            java.lang.String r2 = "progress"
            int r2 = hb.h0.c0(r4, r2)     // Catch:{ all -> 0x0229 }
            r19 = r2
            java.lang.String r2 = "max_progress"
            int r2 = hb.h0.c0(r4, r2)     // Catch:{ all -> 0x0229 }
            r20 = r2
            java.lang.String r2 = "status"
            int r2 = hb.h0.c0(r4, r2)     // Catch:{ all -> 0x0229 }
            r21 = r2
            java.lang.String r2 = "type"
            int r2 = hb.h0.c0(r4, r2)     // Catch:{ all -> 0x0229 }
            r22 = r2
            java.lang.String r2 = "videoId"
            int r2 = hb.h0.c0(r4, r2)     // Catch:{ all -> 0x0229 }
            r23 = r2
            java.lang.String r2 = "id"
            int r2 = hb.h0.c0(r4, r2)     // Catch:{ all -> 0x0229 }
            r24 = r2
            java.lang.String r2 = "is_vod"
            int r2 = hb.h0.c0(r4, r2)     // Catch:{ all -> 0x0229 }
            boolean r25 = r4.moveToFirst()     // Catch:{ all -> 0x0229 }
            r26 = 0
            if (r25 == 0) goto L_0x0222
            boolean r25 = r4.isNull(r0)     // Catch:{ all -> 0x0229 }
            if (r25 == 0) goto L_0x00cd
            r28 = r26
            goto L_0x00d3
        L_0x00cd:
            java.lang.String r0 = r4.getString(r0)     // Catch:{ all -> 0x0229 }
            r28 = r0
        L_0x00d3:
            boolean r0 = r4.isNull(r5)     // Catch:{ all -> 0x0229 }
            if (r0 == 0) goto L_0x00dc
            r29 = r26
            goto L_0x00e2
        L_0x00dc:
            java.lang.String r0 = r4.getString(r5)     // Catch:{ all -> 0x0229 }
            r29 = r0
        L_0x00e2:
            boolean r0 = r4.isNull(r6)     // Catch:{ all -> 0x0229 }
            if (r0 == 0) goto L_0x00eb
            r30 = r26
            goto L_0x00f5
        L_0x00eb:
            long r5 = r4.getLong(r6)     // Catch:{ all -> 0x0229 }
            java.lang.Long r0 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0229 }
            r30 = r0
        L_0x00f5:
            boolean r0 = r4.isNull(r7)     // Catch:{ all -> 0x0229 }
            if (r0 == 0) goto L_0x00fe
            r31 = r26
            goto L_0x0104
        L_0x00fe:
            java.lang.String r0 = r4.getString(r7)     // Catch:{ all -> 0x0229 }
            r31 = r0
        L_0x0104:
            int r32 = r4.getInt(r8)     // Catch:{ all -> 0x0229 }
            boolean r0 = r4.isNull(r9)     // Catch:{ all -> 0x0229 }
            if (r0 == 0) goto L_0x0111
            r33 = r26
            goto L_0x0117
        L_0x0111:
            java.lang.String r0 = r4.getString(r9)     // Catch:{ all -> 0x0229 }
            r33 = r0
        L_0x0117:
            boolean r0 = r4.isNull(r10)     // Catch:{ all -> 0x0229 }
            if (r0 == 0) goto L_0x0120
            r34 = r26
            goto L_0x0126
        L_0x0120:
            java.lang.String r0 = r4.getString(r10)     // Catch:{ all -> 0x0229 }
            r34 = r0
        L_0x0126:
            boolean r0 = r4.isNull(r11)     // Catch:{ all -> 0x0229 }
            if (r0 == 0) goto L_0x012f
            r35 = r26
            goto L_0x0135
        L_0x012f:
            java.lang.String r0 = r4.getString(r11)     // Catch:{ all -> 0x0229 }
            r35 = r0
        L_0x0135:
            boolean r0 = r4.isNull(r12)     // Catch:{ all -> 0x0229 }
            if (r0 == 0) goto L_0x013e
            r36 = r26
            goto L_0x0144
        L_0x013e:
            java.lang.String r0 = r4.getString(r12)     // Catch:{ all -> 0x0229 }
            r36 = r0
        L_0x0144:
            int r37 = r4.getInt(r13)     // Catch:{ all -> 0x0229 }
            boolean r0 = r4.isNull(r14)     // Catch:{ all -> 0x0229 }
            if (r0 == 0) goto L_0x0151
            r38 = r26
            goto L_0x0157
        L_0x0151:
            java.lang.String r0 = r4.getString(r14)     // Catch:{ all -> 0x0229 }
            r38 = r0
        L_0x0157:
            boolean r0 = r4.isNull(r15)     // Catch:{ all -> 0x0229 }
            if (r0 == 0) goto L_0x0160
            r39 = r26
            goto L_0x0166
        L_0x0160:
            java.lang.String r0 = r4.getString(r15)     // Catch:{ all -> 0x0229 }
            r39 = r0
        L_0x0166:
            boolean r0 = r4.isNull(r1)     // Catch:{ all -> 0x0229 }
            if (r0 == 0) goto L_0x016f
            r40 = r26
            goto L_0x0175
        L_0x016f:
            java.lang.String r0 = r4.getString(r1)     // Catch:{ all -> 0x0229 }
            r40 = r0
        L_0x0175:
            boolean r0 = r4.isNull(r3)     // Catch:{ all -> 0x0229 }
            if (r0 == 0) goto L_0x0180
            r0 = r51
            r41 = r26
            goto L_0x018c
        L_0x0180:
            long r0 = r4.getLong(r3)     // Catch:{ all -> 0x0229 }
            java.lang.Long r0 = java.lang.Long.valueOf(r0)     // Catch:{ all -> 0x0229 }
            r41 = r0
            r0 = r51
        L_0x018c:
            boolean r1 = r4.isNull(r0)     // Catch:{ all -> 0x0229 }
            if (r1 == 0) goto L_0x0197
            r0 = r17
            r42 = r26
            goto L_0x01a3
        L_0x0197:
            long r0 = r4.getLong(r0)     // Catch:{ all -> 0x0229 }
            java.lang.Long r0 = java.lang.Long.valueOf(r0)     // Catch:{ all -> 0x0229 }
            r42 = r0
            r0 = r17
        L_0x01a3:
            boolean r1 = r4.isNull(r0)     // Catch:{ all -> 0x0229 }
            if (r1 == 0) goto L_0x01ae
            r0 = r18
            r43 = r26
            goto L_0x01ba
        L_0x01ae:
            long r0 = r4.getLong(r0)     // Catch:{ all -> 0x0229 }
            java.lang.Long r0 = java.lang.Long.valueOf(r0)     // Catch:{ all -> 0x0229 }
            r43 = r0
            r0 = r18
        L_0x01ba:
            boolean r1 = r4.isNull(r0)     // Catch:{ all -> 0x0229 }
            if (r1 == 0) goto L_0x01c5
            r0 = r19
            r44 = r26
            goto L_0x01d1
        L_0x01c5:
            long r0 = r4.getLong(r0)     // Catch:{ all -> 0x0229 }
            java.lang.Long r0 = java.lang.Long.valueOf(r0)     // Catch:{ all -> 0x0229 }
            r44 = r0
            r0 = r19
        L_0x01d1:
            int r45 = r4.getInt(r0)     // Catch:{ all -> 0x0229 }
            r0 = r20
            int r46 = r4.getInt(r0)     // Catch:{ all -> 0x0229 }
            r0 = r21
            int r47 = r4.getInt(r0)     // Catch:{ all -> 0x0229 }
            r0 = r22
            boolean r1 = r4.isNull(r0)     // Catch:{ all -> 0x0229 }
            if (r1 == 0) goto L_0x01ee
            r0 = r23
            r48 = r26
            goto L_0x01f6
        L_0x01ee:
            java.lang.String r0 = r4.getString(r0)     // Catch:{ all -> 0x0229 }
            r48 = r0
            r0 = r23
        L_0x01f6:
            boolean r1 = r4.isNull(r0)     // Catch:{ all -> 0x0229 }
            if (r1 == 0) goto L_0x01ff
        L_0x01fc:
            r49 = r26
            goto L_0x0204
        L_0x01ff:
            java.lang.String r26 = r4.getString(r0)     // Catch:{ all -> 0x0229 }
            goto L_0x01fc
        L_0x0204:
            com.github.andreyasadchy.xtra.model.offline.OfflineVideo r0 = new com.github.andreyasadchy.xtra.model.offline.OfflineVideo     // Catch:{ all -> 0x0229 }
            r27 = r0
            r27.<init>(r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49)     // Catch:{ all -> 0x0229 }
            r1 = r24
            int r1 = r4.getInt(r1)     // Catch:{ all -> 0x0229 }
            r0.setId(r1)     // Catch:{ all -> 0x0229 }
            int r1 = r4.getInt(r2)     // Catch:{ all -> 0x0229 }
            if (r1 == 0) goto L_0x021c
            r1 = 1
            goto L_0x021d
        L_0x021c:
            r1 = 0
        L_0x021d:
            r0.setVod(r1)     // Catch:{ all -> 0x0229 }
            r26 = r0
        L_0x0222:
            r4.close()
            r16.v()
            return r26
        L_0x0229:
            r0 = move-exception
            goto L_0x022e
        L_0x022b:
            r0 = move-exception
            r16 = r2
        L_0x022e:
            r4.close()
            r16.v()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a6.c0.a(int):com.github.andreyasadchy.xtra.model.offline.OfflineVideo");
    }

    public final ArrayList b(int i10) {
        s0 s0Var;
        String str;
        int i11;
        String str2;
        int i12;
        int i13;
        boolean z10;
        s0 k10 = s0.k(1, "SELECT * FROM videos WHERE channel_id = ?");
        k10.g0(1, (long) i10);
        n0 n0Var = this.f221a;
        n0Var.b();
        Cursor n12 = h0.n1(n0Var, k10);
        try {
            int c02 = h0.c0(n12, "url");
            int c03 = h0.c0(n12, "source_url");
            int c04 = h0.c0(n12, "source_start_position");
            int c05 = h0.c0(n12, "name");
            int c06 = h0.c0(n12, "channel_id");
            int c07 = h0.c0(n12, "channel_login");
            int c08 = h0.c0(n12, "channel_name");
            int c09 = h0.c0(n12, "channel_logo");
            int c010 = h0.c0(n12, "thumbnail");
            int c011 = h0.c0(n12, "gameId");
            int c012 = h0.c0(n12, "gameName");
            int c013 = h0.c0(n12, "gameSlug");
            int c014 = h0.c0(n12, "boxArtUrl");
            int c015 = h0.c0(n12, "duration");
            s0Var = k10;
            try {
                int c016 = h0.c0(n12, "upload_date");
                int c017 = h0.c0(n12, "download_date");
                int c018 = h0.c0(n12, "last_watch_position");
                int c019 = h0.c0(n12, "progress");
                int c020 = h0.c0(n12, "max_progress");
                int c021 = h0.c0(n12, "status");
                int c022 = h0.c0(n12, "type");
                int c023 = h0.c0(n12, "videoId");
                int c024 = h0.c0(n12, "id");
                int c025 = h0.c0(n12, "is_vod");
                int i14 = c015;
                ArrayList arrayList = new ArrayList(n12.getCount());
                while (n12.moveToNext()) {
                    String str3 = null;
                    String string = n12.isNull(c02) ? null : n12.getString(c02);
                    String string2 = n12.isNull(c03) ? null : n12.getString(c03);
                    Long valueOf = n12.isNull(c04) ? null : Long.valueOf(n12.getLong(c04));
                    String string3 = n12.isNull(c05) ? null : n12.getString(c05);
                    int i15 = n12.getInt(c06);
                    String string4 = n12.isNull(c07) ? null : n12.getString(c07);
                    String string5 = n12.isNull(c08) ? null : n12.getString(c08);
                    String string6 = n12.isNull(c09) ? null : n12.getString(c09);
                    String string7 = n12.isNull(c010) ? null : n12.getString(c010);
                    int i16 = n12.getInt(c011);
                    String string8 = n12.isNull(c012) ? null : n12.getString(c012);
                    String string9 = n12.isNull(c013) ? null : n12.getString(c013);
                    if (n12.isNull(c014)) {
                        i11 = i14;
                        str = null;
                    } else {
                        str = n12.getString(c014);
                        i11 = i14;
                    }
                    Long valueOf2 = n12.isNull(i11) ? null : Long.valueOf(n12.getLong(i11));
                    int i17 = c02;
                    int i18 = c016;
                    Long valueOf3 = n12.isNull(i18) ? null : Long.valueOf(n12.getLong(i18));
                    c016 = i18;
                    int i19 = c017;
                    Long valueOf4 = n12.isNull(i19) ? null : Long.valueOf(n12.getLong(i19));
                    c017 = i19;
                    int i20 = c018;
                    Long valueOf5 = n12.isNull(i20) ? null : Long.valueOf(n12.getLong(i20));
                    c018 = i20;
                    int i21 = c019;
                    int i22 = n12.getInt(i21);
                    c019 = i21;
                    int i23 = c020;
                    int i24 = n12.getInt(i23);
                    c020 = i23;
                    int i25 = c021;
                    int i26 = n12.getInt(i25);
                    c021 = i25;
                    int i27 = c022;
                    if (n12.isNull(i27)) {
                        c022 = i27;
                        i12 = c023;
                        str2 = null;
                    } else {
                        str2 = n12.getString(i27);
                        c022 = i27;
                        i12 = c023;
                    }
                    if (!n12.isNull(i12)) {
                        str3 = n12.getString(i12);
                    }
                    c023 = i12;
                    OfflineVideo offlineVideo = new OfflineVideo(string, string2, valueOf, string3, i15, string4, string5, string6, string7, i16, string8, string9, str, valueOf2, valueOf3, valueOf4, valueOf5, i22, i24, i26, str2, str3);
                    int i28 = c014;
                    int i29 = c024;
                    int i30 = i11;
                    offlineVideo.setId(n12.getInt(i29));
                    int i31 = c025;
                    if (n12.getInt(i31) != 0) {
                        i13 = i29;
                        z10 = true;
                    } else {
                        i13 = i29;
                        z10 = false;
                    }
                    offlineVideo.setVod(z10);
                    arrayList.add(offlineVideo);
                    c025 = i31;
                    c02 = i17;
                    c014 = i28;
                    i14 = i30;
                    c024 = i13;
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
}
