package com.github.andreyasadchy.xtra.model.chat;

import java.util.List;
import xa.f;
import xa.j;

public final class LiveChatMessage implements ChatMessage {
    private final List<Badge> badges;
    private final int chatroomId;
    private final String color;
    private final List<KickEmote> emotes;
    private final String fullMsg;
    private final String id;
    private final boolean isAction;
    private final boolean isFirst;
    private final String message;
    private final String systemMsg;
    private final Long timestamp;
    private final int userId;
    private final String userLogin;
    private final String userName;

    public LiveChatMessage() {
        this((String) null, 0, (String) null, (String) null, (String) null, (String) null, false, (List) null, (List) null, (String) null, 0, false, (String) null, (Long) null, 16383, (f) null);
    }

    public static /* synthetic */ LiveChatMessage copy$default(LiveChatMessage liveChatMessage, String str, int i10, String str2, String str3, String str4, String str5, boolean z10, List list, List list2, String str6, int i11, boolean z11, String str7, Long l10, int i12, Object obj) {
        LiveChatMessage liveChatMessage2 = liveChatMessage;
        int i13 = i12;
        return liveChatMessage.copy((i13 & 1) != 0 ? liveChatMessage2.id : str, (i13 & 2) != 0 ? liveChatMessage2.userId : i10, (i13 & 4) != 0 ? liveChatMessage2.userLogin : str2, (i13 & 8) != 0 ? liveChatMessage2.userName : str3, (i13 & 16) != 0 ? liveChatMessage2.message : str4, (i13 & 32) != 0 ? liveChatMessage2.color : str5, (i13 & 64) != 0 ? liveChatMessage2.isAction : z10, (i13 & 128) != 0 ? liveChatMessage2.emotes : list, (i13 & 256) != 0 ? liveChatMessage2.badges : list2, (i13 & 512) != 0 ? liveChatMessage2.fullMsg : str6, (i13 & 1024) != 0 ? liveChatMessage2.chatroomId : i11, (i13 & 2048) != 0 ? liveChatMessage2.isFirst : z11, (i13 & 4096) != 0 ? liveChatMessage2.systemMsg : str7, (i13 & 8192) != 0 ? liveChatMessage2.timestamp : l10);
    }

    public final String component1() {
        return this.id;
    }

    public final String component10() {
        return this.fullMsg;
    }

    public final int component11() {
        return this.chatroomId;
    }

    public final boolean component12() {
        return this.isFirst;
    }

    public final String component13() {
        return this.systemMsg;
    }

    public final Long component14() {
        return this.timestamp;
    }

    public final int component2() {
        return this.userId;
    }

    public final String component3() {
        return this.userLogin;
    }

    public final String component4() {
        return this.userName;
    }

    public final String component5() {
        return this.message;
    }

    public final String component6() {
        return this.color;
    }

    public final boolean component7() {
        return this.isAction;
    }

    public final List<KickEmote> component8() {
        return this.emotes;
    }

    public final List<Badge> component9() {
        return this.badges;
    }

    public final LiveChatMessage copy(String str, int i10, String str2, String str3, String str4, String str5, boolean z10, List<KickEmote> list, List<Badge> list2, String str6, int i11, boolean z11, String str7, Long l10) {
        return new LiveChatMessage(str, i10, str2, str3, str4, str5, z10, list, list2, str6, i11, z11, str7, l10);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LiveChatMessage)) {
            return false;
        }
        LiveChatMessage liveChatMessage = (LiveChatMessage) obj;
        return j.a(this.id, liveChatMessage.id) && this.userId == liveChatMessage.userId && j.a(this.userLogin, liveChatMessage.userLogin) && j.a(this.userName, liveChatMessage.userName) && j.a(this.message, liveChatMessage.message) && j.a(this.color, liveChatMessage.color) && this.isAction == liveChatMessage.isAction && j.a(this.emotes, liveChatMessage.emotes) && j.a(this.badges, liveChatMessage.badges) && j.a(this.fullMsg, liveChatMessage.fullMsg) && this.chatroomId == liveChatMessage.chatroomId && this.isFirst == liveChatMessage.isFirst && j.a(this.systemMsg, liveChatMessage.systemMsg) && j.a(this.timestamp, liveChatMessage.timestamp);
    }

    public List<Badge> getBadges() {
        return this.badges;
    }

    public final int getChatroomId() {
        return this.chatroomId;
    }

    public String getColor() {
        return this.color;
    }

    public List<KickEmote> getEmotes() {
        return this.emotes;
    }

    public String getFullMsg() {
        return this.fullMsg;
    }

    public String getId() {
        return this.id;
    }

    public String getMessage() {
        return this.message;
    }

    public final String getSystemMsg() {
        return this.systemMsg;
    }

    public final Long getTimestamp() {
        return this.timestamp;
    }

    public int getUserId() {
        return this.userId;
    }

    public String getUserLogin() {
        return this.userLogin;
    }

    public String getUserName() {
        return this.userName;
    }

    public int hashCode() {
        String str = this.id;
        int i10 = 0;
        int hashCode = (((str == null ? 0 : str.hashCode()) * 31) + this.userId) * 31;
        String str2 = this.userLogin;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.userName;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.message;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.color;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        boolean z10 = this.isAction;
        boolean z11 = true;
        if (z10) {
            z10 = true;
        }
        int i11 = (hashCode5 + (z10 ? 1 : 0)) * 31;
        List<KickEmote> list = this.emotes;
        int hashCode6 = (i11 + (list == null ? 0 : list.hashCode())) * 31;
        List<Badge> list2 = this.badges;
        int hashCode7 = (hashCode6 + (list2 == null ? 0 : list2.hashCode())) * 31;
        String str6 = this.fullMsg;
        int hashCode8 = (((hashCode7 + (str6 == null ? 0 : str6.hashCode())) * 31) + this.chatroomId) * 31;
        boolean z12 = this.isFirst;
        if (!z12) {
            z11 = z12;
        }
        int i12 = (hashCode8 + (z11 ? 1 : 0)) * 31;
        String str7 = this.systemMsg;
        int hashCode9 = (i12 + (str7 == null ? 0 : str7.hashCode())) * 31;
        Long l10 = this.timestamp;
        if (l10 != null) {
            i10 = l10.hashCode();
        }
        return hashCode9 + i10;
    }

    public boolean isAction() {
        return this.isAction;
    }

    public final boolean isFirst() {
        return this.isFirst;
    }

    public String toString() {
        String str = this.id;
        int i10 = this.userId;
        String str2 = this.userLogin;
        String str3 = this.userName;
        String str4 = this.message;
        String str5 = this.color;
        boolean z10 = this.isAction;
        List<KickEmote> list = this.emotes;
        List<Badge> list2 = this.badges;
        String str6 = this.fullMsg;
        int i11 = this.chatroomId;
        boolean z11 = this.isFirst;
        String str7 = this.systemMsg;
        Long l10 = this.timestamp;
        StringBuilder sb2 = new StringBuilder("LiveChatMessage(id=");
        sb2.append(str);
        sb2.append(", userId=");
        sb2.append(i10);
        sb2.append(", userLogin=");
        q0.f.k(sb2, str2, ", userName=", str3, ", message=");
        q0.f.k(sb2, str4, ", color=", str5, ", isAction=");
        sb2.append(z10);
        sb2.append(", emotes=");
        sb2.append(list);
        sb2.append(", badges=");
        sb2.append(list2);
        sb2.append(", fullMsg=");
        sb2.append(str6);
        sb2.append(", chatroomId=");
        sb2.append(i11);
        sb2.append(", isFirst=");
        sb2.append(z11);
        sb2.append(", systemMsg=");
        sb2.append(str7);
        sb2.append(", timestamp=");
        sb2.append(l10);
        sb2.append(")");
        return sb2.toString();
    }

    public LiveChatMessage(String str, int i10, String str2, String str3, String str4, String str5, boolean z10, List<KickEmote> list, List<Badge> list2, String str6, int i11, boolean z11, String str7, Long l10) {
        this.id = str;
        this.userId = i10;
        this.userLogin = str2;
        this.userName = str3;
        this.message = str4;
        this.color = str5;
        this.isAction = z10;
        this.emotes = list;
        this.badges = list2;
        this.fullMsg = str6;
        this.chatroomId = i11;
        this.isFirst = z11;
        this.systemMsg = str7;
        this.timestamp = l10;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ LiveChatMessage(java.lang.String r16, int r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, boolean r22, java.util.List r23, java.util.List r24, java.lang.String r25, int r26, boolean r27, java.lang.String r28, java.lang.Long r29, int r30, xa.f r31) {
        /*
            r15 = this;
            r0 = r30
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000b
        L_0x0009:
            r1 = r16
        L_0x000b:
            r3 = r0 & 2
            r4 = 0
            if (r3 == 0) goto L_0x0012
            r3 = 0
            goto L_0x0014
        L_0x0012:
            r3 = r17
        L_0x0014:
            r5 = r0 & 4
            if (r5 == 0) goto L_0x001a
            r5 = r2
            goto L_0x001c
        L_0x001a:
            r5 = r18
        L_0x001c:
            r6 = r0 & 8
            if (r6 == 0) goto L_0x0022
            r6 = r2
            goto L_0x0024
        L_0x0022:
            r6 = r19
        L_0x0024:
            r7 = r0 & 16
            if (r7 == 0) goto L_0x002a
            r7 = r2
            goto L_0x002c
        L_0x002a:
            r7 = r20
        L_0x002c:
            r8 = r0 & 32
            if (r8 == 0) goto L_0x0032
            r8 = r2
            goto L_0x0034
        L_0x0032:
            r8 = r21
        L_0x0034:
            r9 = r0 & 64
            if (r9 == 0) goto L_0x003a
            r9 = 0
            goto L_0x003c
        L_0x003a:
            r9 = r22
        L_0x003c:
            r10 = r0 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x0042
            r10 = r2
            goto L_0x0044
        L_0x0042:
            r10 = r23
        L_0x0044:
            r11 = r0 & 256(0x100, float:3.59E-43)
            if (r11 == 0) goto L_0x004a
            r11 = r2
            goto L_0x004c
        L_0x004a:
            r11 = r24
        L_0x004c:
            r12 = r0 & 512(0x200, float:7.175E-43)
            if (r12 == 0) goto L_0x0052
            r12 = r2
            goto L_0x0054
        L_0x0052:
            r12 = r25
        L_0x0054:
            r13 = r0 & 1024(0x400, float:1.435E-42)
            if (r13 == 0) goto L_0x005a
            r13 = 0
            goto L_0x005c
        L_0x005a:
            r13 = r26
        L_0x005c:
            r14 = r0 & 2048(0x800, float:2.87E-42)
            if (r14 == 0) goto L_0x0061
            goto L_0x0063
        L_0x0061:
            r4 = r27
        L_0x0063:
            r14 = r0 & 4096(0x1000, float:5.74E-42)
            if (r14 == 0) goto L_0x0069
            r14 = r2
            goto L_0x006b
        L_0x0069:
            r14 = r28
        L_0x006b:
            r0 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r0 == 0) goto L_0x0070
            goto L_0x0072
        L_0x0070:
            r2 = r29
        L_0x0072:
            r16 = r15
            r17 = r1
            r18 = r3
            r19 = r5
            r20 = r6
            r21 = r7
            r22 = r8
            r23 = r9
            r24 = r10
            r25 = r11
            r26 = r12
            r27 = r13
            r28 = r4
            r29 = r14
            r30 = r2
            r16.<init>(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.andreyasadchy.xtra.model.chat.LiveChatMessage.<init>(java.lang.String, int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean, java.util.List, java.util.List, java.lang.String, int, boolean, java.lang.String, java.lang.Long, int, xa.f):void");
    }
}
