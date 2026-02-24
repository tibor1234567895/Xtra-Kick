package com.github.andreyasadchy.xtra.model.chat;

import android.support.v4.media.h;
import java.util.List;
import q0.f;
import xa.j;

public final class VideoChatMessage implements ChatMessage {
    private final List<Badge> badges;
    private final String color;
    private final List<KickEmote> emotes;
    private final String fullMsg;
    private final String id;
    private final boolean isAction;
    private final String message;
    private final Integer offsetSeconds;
    private final int userId;
    private final String userLogin;
    private final String userName;

    public VideoChatMessage(String str, Integer num, int i10, String str2, String str3, String str4, String str5, boolean z10, List<KickEmote> list, List<Badge> list2, String str6) {
        this.id = str;
        this.offsetSeconds = num;
        this.userId = i10;
        this.userLogin = str2;
        this.userName = str3;
        this.message = str4;
        this.color = str5;
        this.isAction = z10;
        this.emotes = list;
        this.badges = list2;
        this.fullMsg = str6;
    }

    public static /* synthetic */ VideoChatMessage copy$default(VideoChatMessage videoChatMessage, String str, Integer num, int i10, String str2, String str3, String str4, String str5, boolean z10, List list, List list2, String str6, int i11, Object obj) {
        VideoChatMessage videoChatMessage2 = videoChatMessage;
        int i12 = i11;
        return videoChatMessage.copy((i12 & 1) != 0 ? videoChatMessage2.id : str, (i12 & 2) != 0 ? videoChatMessage2.offsetSeconds : num, (i12 & 4) != 0 ? videoChatMessage2.userId : i10, (i12 & 8) != 0 ? videoChatMessage2.userLogin : str2, (i12 & 16) != 0 ? videoChatMessage2.userName : str3, (i12 & 32) != 0 ? videoChatMessage2.message : str4, (i12 & 64) != 0 ? videoChatMessage2.color : str5, (i12 & 128) != 0 ? videoChatMessage2.isAction : z10, (i12 & 256) != 0 ? videoChatMessage2.emotes : list, (i12 & 512) != 0 ? videoChatMessage2.badges : list2, (i12 & 1024) != 0 ? videoChatMessage2.fullMsg : str6);
    }

    public final String component1() {
        return this.id;
    }

    public final List<Badge> component10() {
        return this.badges;
    }

    public final String component11() {
        return this.fullMsg;
    }

    public final Integer component2() {
        return this.offsetSeconds;
    }

    public final int component3() {
        return this.userId;
    }

    public final String component4() {
        return this.userLogin;
    }

    public final String component5() {
        return this.userName;
    }

    public final String component6() {
        return this.message;
    }

    public final String component7() {
        return this.color;
    }

    public final boolean component8() {
        return this.isAction;
    }

    public final List<KickEmote> component9() {
        return this.emotes;
    }

    public final VideoChatMessage copy(String str, Integer num, int i10, String str2, String str3, String str4, String str5, boolean z10, List<KickEmote> list, List<Badge> list2, String str6) {
        return new VideoChatMessage(str, num, i10, str2, str3, str4, str5, z10, list, list2, str6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VideoChatMessage)) {
            return false;
        }
        VideoChatMessage videoChatMessage = (VideoChatMessage) obj;
        return j.a(this.id, videoChatMessage.id) && j.a(this.offsetSeconds, videoChatMessage.offsetSeconds) && this.userId == videoChatMessage.userId && j.a(this.userLogin, videoChatMessage.userLogin) && j.a(this.userName, videoChatMessage.userName) && j.a(this.message, videoChatMessage.message) && j.a(this.color, videoChatMessage.color) && this.isAction == videoChatMessage.isAction && j.a(this.emotes, videoChatMessage.emotes) && j.a(this.badges, videoChatMessage.badges) && j.a(this.fullMsg, videoChatMessage.fullMsg);
    }

    public List<Badge> getBadges() {
        return this.badges;
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

    public final Integer getOffsetSeconds() {
        return this.offsetSeconds;
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
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.offsetSeconds;
        int hashCode2 = (((hashCode + (num == null ? 0 : num.hashCode())) * 31) + this.userId) * 31;
        String str2 = this.userLogin;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.userName;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.message;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.color;
        int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        boolean z10 = this.isAction;
        if (z10) {
            z10 = true;
        }
        int i11 = (hashCode6 + (z10 ? 1 : 0)) * 31;
        List<KickEmote> list = this.emotes;
        int hashCode7 = (i11 + (list == null ? 0 : list.hashCode())) * 31;
        List<Badge> list2 = this.badges;
        int hashCode8 = (hashCode7 + (list2 == null ? 0 : list2.hashCode())) * 31;
        String str6 = this.fullMsg;
        if (str6 != null) {
            i10 = str6.hashCode();
        }
        return hashCode8 + i10;
    }

    public boolean isAction() {
        return this.isAction;
    }

    public String toString() {
        String str = this.id;
        Integer num = this.offsetSeconds;
        int i10 = this.userId;
        String str2 = this.userLogin;
        String str3 = this.userName;
        String str4 = this.message;
        String str5 = this.color;
        boolean z10 = this.isAction;
        List<KickEmote> list = this.emotes;
        List<Badge> list2 = this.badges;
        String str6 = this.fullMsg;
        StringBuilder sb2 = new StringBuilder("VideoChatMessage(id=");
        sb2.append(str);
        sb2.append(", offsetSeconds=");
        sb2.append(num);
        sb2.append(", userId=");
        sb2.append(i10);
        sb2.append(", userLogin=");
        sb2.append(str2);
        sb2.append(", userName=");
        f.k(sb2, str3, ", message=", str4, ", color=");
        sb2.append(str5);
        sb2.append(", isAction=");
        sb2.append(z10);
        sb2.append(", emotes=");
        sb2.append(list);
        sb2.append(", badges=");
        sb2.append(list2);
        sb2.append(", fullMsg=");
        return h.p(sb2, str6, ")");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ VideoChatMessage(String str, Integer num, int i10, String str2, String str3, String str4, String str5, boolean z10, List list, List list2, String str6, int i11, xa.f fVar) {
        this(str, num, i10, str2, str3, str4, str5, (i11 & 128) != 0 ? false : z10, list, list2, str6);
    }
}
