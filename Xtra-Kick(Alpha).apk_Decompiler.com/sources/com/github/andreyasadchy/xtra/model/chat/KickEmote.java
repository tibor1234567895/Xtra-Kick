package com.github.andreyasadchy.xtra.model.chat;

import xa.f;
import xa.j;

public final class KickEmote extends Emote {
    private int begin;
    private int end;
    private final String id;
    private final Boolean isAnimated;
    private final boolean isZeroWidth;
    private final String name;
    private final int ownerId;
    private final String setId;
    private final String type;
    private final String url1x;
    private final String url2x;
    private final String url3x;
    private final String url4x;

    public KickEmote() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Boolean) null, false, 0, 0, (String) null, 0, 8191, (f) null);
    }

    public final int getBegin() {
        return this.begin;
    }

    public final int getEnd() {
        return this.end;
    }

    public final String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public final int getOwnerId() {
        return this.ownerId;
    }

    public final String getSetId() {
        return this.setId;
    }

    public String getType() {
        return this.type;
    }

    public String getUrl1x() {
        return this.url1x;
    }

    public String getUrl2x() {
        return this.url2x;
    }

    public String getUrl3x() {
        return this.url3x;
    }

    public String getUrl4x() {
        return this.url4x;
    }

    public Boolean isAnimated() {
        return this.isAnimated;
    }

    public boolean isZeroWidth() {
        return this.isZeroWidth;
    }

    public final void setBegin(int i10) {
        this.begin = i10;
    }

    public final void setEnd(int i10) {
        this.end = i10;
    }

    public KickEmote(String str, String str2, String str3, String str4, String str5, String str6, String str7, Boolean bool, boolean z10, int i10, int i11, String str8, int i12) {
        j.f("name", str2);
        this.id = str;
        this.name = str2;
        this.url1x = str3;
        this.url2x = str4;
        this.url3x = str5;
        this.url4x = str6;
        this.type = str7;
        this.isAnimated = bool;
        this.isZeroWidth = z10;
        this.begin = i10;
        this.end = i11;
        this.setId = str8;
        this.ownerId = i12;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ KickEmote(java.lang.String r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, java.lang.Boolean r23, boolean r24, int r25, int r26, java.lang.String r27, int r28, int r29, xa.f r30) {
        /*
            r15 = this;
            r0 = r29
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000b
        L_0x0009:
            r1 = r16
        L_0x000b:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0012
            java.lang.String r3 = ""
            goto L_0x0014
        L_0x0012:
            r3 = r17
        L_0x0014:
            r4 = r0 & 4
            java.lang.String r5 = "/fullsize"
            java.lang.String r6 = "https://files.kick.com/emotes/"
            if (r4 == 0) goto L_0x0021
            java.lang.String r4 = android.support.v4.media.h.n(r6, r1, r5)
            goto L_0x0023
        L_0x0021:
            r4 = r18
        L_0x0023:
            r7 = r0 & 8
            if (r7 == 0) goto L_0x002c
            java.lang.String r7 = android.support.v4.media.h.n(r6, r1, r5)
            goto L_0x002e
        L_0x002c:
            r7 = r19
        L_0x002e:
            r8 = r0 & 16
            if (r8 == 0) goto L_0x0037
            java.lang.String r8 = android.support.v4.media.h.n(r6, r1, r5)
            goto L_0x0039
        L_0x0037:
            r8 = r20
        L_0x0039:
            r9 = r0 & 32
            if (r9 == 0) goto L_0x0042
            java.lang.String r5 = android.support.v4.media.h.n(r6, r1, r5)
            goto L_0x0044
        L_0x0042:
            r5 = r21
        L_0x0044:
            r6 = r0 & 64
            if (r6 == 0) goto L_0x004b
            java.lang.String r6 = "gif"
            goto L_0x004d
        L_0x004b:
            r6 = r22
        L_0x004d:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x0054
            java.lang.Boolean r9 = java.lang.Boolean.TRUE
            goto L_0x0056
        L_0x0054:
            r9 = r23
        L_0x0056:
            r10 = r0 & 256(0x100, float:3.59E-43)
            r11 = 0
            if (r10 == 0) goto L_0x005d
            r10 = 0
            goto L_0x005f
        L_0x005d:
            r10 = r24
        L_0x005f:
            r12 = r0 & 512(0x200, float:7.175E-43)
            if (r12 == 0) goto L_0x0065
            r12 = 0
            goto L_0x0067
        L_0x0065:
            r12 = r25
        L_0x0067:
            r13 = r0 & 1024(0x400, float:1.435E-42)
            if (r13 == 0) goto L_0x006d
            r13 = 0
            goto L_0x006f
        L_0x006d:
            r13 = r26
        L_0x006f:
            r14 = r0 & 2048(0x800, float:2.87E-42)
            if (r14 == 0) goto L_0x0074
            goto L_0x0076
        L_0x0074:
            r2 = r27
        L_0x0076:
            r0 = r0 & 4096(0x1000, float:5.74E-42)
            if (r0 == 0) goto L_0x007b
            goto L_0x007d
        L_0x007b:
            r11 = r28
        L_0x007d:
            r16 = r15
            r17 = r1
            r18 = r3
            r19 = r4
            r20 = r7
            r21 = r8
            r22 = r5
            r23 = r6
            r24 = r9
            r25 = r10
            r26 = r12
            r27 = r13
            r28 = r2
            r29 = r11
            r16.<init>(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.andreyasadchy.xtra.model.chat.KickEmote.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Boolean, boolean, int, int, java.lang.String, int, int, xa.f):void");
    }
}
