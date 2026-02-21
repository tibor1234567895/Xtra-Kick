package com.github.andreyasadchy.xtra.model.offline;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.h;
import xa.f;
import xa.j;

public final class Bookmark implements Parcelable {
    public static final Parcelable.Creator<Bookmark> CREATOR = new Creator();
    private final String animatedPreviewURL;
    private final String boxArtUrl;
    private final String createdAt;
    private final String duration;
    private final int gameId;
    private final String gameName;
    private final String gameSlug;
    private int id;
    private final String thumbnail;
    private final String title;
    private final String type;
    private String userBroadcasterType;
    private final int userId;
    private String userLogin;
    private String userLogo;
    private String userName;
    private String userType;
    private final String videoId;

    public static final class Creator implements Parcelable.Creator<Bookmark> {
        public final Bookmark createFromParcel(Parcel parcel) {
            j.f("parcel", parcel);
            return new Bookmark(parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        public final Bookmark[] newArray(int i10) {
            return new Bookmark[i10];
        }
    }

    public Bookmark() {
        this((String) null, 0, (String) null, (String) null, (String) null, (String) null, (String) null, 0, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 131071, (f) null);
    }

    public static /* synthetic */ Bookmark copy$default(Bookmark bookmark, String str, int i10, String str2, String str3, String str4, String str5, String str6, int i11, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, int i12, Object obj) {
        Bookmark bookmark2 = bookmark;
        int i13 = i12;
        return bookmark.copy((i13 & 1) != 0 ? bookmark2.videoId : str, (i13 & 2) != 0 ? bookmark2.userId : i10, (i13 & 4) != 0 ? bookmark2.userLogin : str2, (i13 & 8) != 0 ? bookmark2.userName : str3, (i13 & 16) != 0 ? bookmark2.userType : str4, (i13 & 32) != 0 ? bookmark2.userBroadcasterType : str5, (i13 & 64) != 0 ? bookmark2.userLogo : str6, (i13 & 128) != 0 ? bookmark2.gameId : i11, (i13 & 256) != 0 ? bookmark2.gameName : str7, (i13 & 512) != 0 ? bookmark2.gameSlug : str8, (i13 & 1024) != 0 ? bookmark2.boxArtUrl : str9, (i13 & 2048) != 0 ? bookmark2.title : str10, (i13 & 4096) != 0 ? bookmark2.createdAt : str11, (i13 & 8192) != 0 ? bookmark2.thumbnail : str12, (i13 & 16384) != 0 ? bookmark2.type : str13, (i13 & 32768) != 0 ? bookmark2.duration : str14, (i13 & 65536) != 0 ? bookmark2.animatedPreviewURL : str15);
    }

    public static /* synthetic */ void getId$annotations() {
    }

    public final String component1() {
        return this.videoId;
    }

    public final String component10() {
        return this.gameSlug;
    }

    public final String component11() {
        return this.boxArtUrl;
    }

    public final String component12() {
        return this.title;
    }

    public final String component13() {
        return this.createdAt;
    }

    public final String component14() {
        return this.thumbnail;
    }

    public final String component15() {
        return this.type;
    }

    public final String component16() {
        return this.duration;
    }

    public final String component17() {
        return this.animatedPreviewURL;
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
        return this.userType;
    }

    public final String component6() {
        return this.userBroadcasterType;
    }

    public final String component7() {
        return this.userLogo;
    }

    public final int component8() {
        return this.gameId;
    }

    public final String component9() {
        return this.gameName;
    }

    public final Bookmark copy(String str, int i10, String str2, String str3, String str4, String str5, String str6, int i11, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15) {
        return new Bookmark(str, i10, str2, str3, str4, str5, str6, i11, str7, str8, str9, str10, str11, str12, str13, str14, str15);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Bookmark)) {
            return false;
        }
        Bookmark bookmark = (Bookmark) obj;
        return j.a(this.videoId, bookmark.videoId) && this.userId == bookmark.userId && j.a(this.userLogin, bookmark.userLogin) && j.a(this.userName, bookmark.userName) && j.a(this.userType, bookmark.userType) && j.a(this.userBroadcasterType, bookmark.userBroadcasterType) && j.a(this.userLogo, bookmark.userLogo) && this.gameId == bookmark.gameId && j.a(this.gameName, bookmark.gameName) && j.a(this.gameSlug, bookmark.gameSlug) && j.a(this.boxArtUrl, bookmark.boxArtUrl) && j.a(this.title, bookmark.title) && j.a(this.createdAt, bookmark.createdAt) && j.a(this.thumbnail, bookmark.thumbnail) && j.a(this.type, bookmark.type) && j.a(this.duration, bookmark.duration) && j.a(this.animatedPreviewURL, bookmark.animatedPreviewURL);
    }

    public final String getAnimatedPreviewURL() {
        return this.animatedPreviewURL;
    }

    public final String getBoxArtUrl() {
        return this.boxArtUrl;
    }

    public final String getCreatedAt() {
        return this.createdAt;
    }

    public final String getDuration() {
        return this.duration;
    }

    public final int getGameId() {
        return this.gameId;
    }

    public final String getGameName() {
        return this.gameName;
    }

    public final String getGameSlug() {
        return this.gameSlug;
    }

    public final int getId() {
        return this.id;
    }

    public final String getThumbnail() {
        return this.thumbnail;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getType() {
        return this.type;
    }

    public final String getUserBroadcasterType() {
        return this.userBroadcasterType;
    }

    public final int getUserId() {
        return this.userId;
    }

    public final String getUserLogin() {
        return this.userLogin;
    }

    public final String getUserLogo() {
        return this.userLogo;
    }

    public final String getUserName() {
        return this.userName;
    }

    public final String getUserType() {
        return this.userType;
    }

    public final String getVideoId() {
        return this.videoId;
    }

    public int hashCode() {
        String str = this.videoId;
        int i10 = 0;
        int hashCode = (((str == null ? 0 : str.hashCode()) * 31) + this.userId) * 31;
        String str2 = this.userLogin;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.userName;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.userType;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.userBroadcasterType;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.userLogo;
        int hashCode6 = (((hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31) + this.gameId) * 31;
        String str7 = this.gameName;
        int hashCode7 = (hashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.gameSlug;
        int hashCode8 = (hashCode7 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.boxArtUrl;
        int hashCode9 = (hashCode8 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.title;
        int hashCode10 = (hashCode9 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.createdAt;
        int hashCode11 = (hashCode10 + (str11 == null ? 0 : str11.hashCode())) * 31;
        String str12 = this.thumbnail;
        int hashCode12 = (hashCode11 + (str12 == null ? 0 : str12.hashCode())) * 31;
        String str13 = this.type;
        int hashCode13 = (hashCode12 + (str13 == null ? 0 : str13.hashCode())) * 31;
        String str14 = this.duration;
        int hashCode14 = (hashCode13 + (str14 == null ? 0 : str14.hashCode())) * 31;
        String str15 = this.animatedPreviewURL;
        if (str15 != null) {
            i10 = str15.hashCode();
        }
        return hashCode14 + i10;
    }

    public final void setId(int i10) {
        this.id = i10;
    }

    public final void setUserBroadcasterType(String str) {
        this.userBroadcasterType = str;
    }

    public final void setUserLogin(String str) {
        this.userLogin = str;
    }

    public final void setUserLogo(String str) {
        this.userLogo = str;
    }

    public final void setUserName(String str) {
        this.userName = str;
    }

    public final void setUserType(String str) {
        this.userType = str;
    }

    public String toString() {
        String str = this.videoId;
        int i10 = this.userId;
        String str2 = this.userLogin;
        String str3 = this.userName;
        String str4 = this.userType;
        String str5 = this.userBroadcasterType;
        String str6 = this.userLogo;
        int i11 = this.gameId;
        String str7 = this.gameName;
        String str8 = this.gameSlug;
        String str9 = this.boxArtUrl;
        String str10 = this.title;
        String str11 = this.createdAt;
        String str12 = this.thumbnail;
        String str13 = this.type;
        String str14 = this.duration;
        StringBuilder sb2 = new StringBuilder("Bookmark(videoId=");
        sb2.append(str);
        sb2.append(", userId=");
        sb2.append(i10);
        sb2.append(", userLogin=");
        q0.f.k(sb2, str2, ", userName=", str3, ", userType=");
        q0.f.k(sb2, str4, ", userBroadcasterType=", str5, ", userLogo=");
        sb2.append(str6);
        sb2.append(", gameId=");
        sb2.append(i11);
        sb2.append(", gameName=");
        q0.f.k(sb2, str7, ", gameSlug=", str8, ", boxArtUrl=");
        q0.f.k(sb2, str9, ", title=", str10, ", createdAt=");
        q0.f.k(sb2, str11, ", thumbnail=", str12, ", type=");
        q0.f.k(sb2, str13, ", duration=", str14, ", animatedPreviewURL=");
        return h.p(sb2, this.animatedPreviewURL, ")");
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.f("out", parcel);
        parcel.writeString(this.videoId);
        parcel.writeInt(this.userId);
        parcel.writeString(this.userLogin);
        parcel.writeString(this.userName);
        parcel.writeString(this.userType);
        parcel.writeString(this.userBroadcasterType);
        parcel.writeString(this.userLogo);
        parcel.writeInt(this.gameId);
        parcel.writeString(this.gameName);
        parcel.writeString(this.gameSlug);
        parcel.writeString(this.boxArtUrl);
        parcel.writeString(this.title);
        parcel.writeString(this.createdAt);
        parcel.writeString(this.thumbnail);
        parcel.writeString(this.type);
        parcel.writeString(this.duration);
        parcel.writeString(this.animatedPreviewURL);
    }

    public Bookmark(String str, int i10, String str2, String str3, String str4, String str5, String str6, int i11, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15) {
        this.videoId = str;
        this.userId = i10;
        this.userLogin = str2;
        this.userName = str3;
        this.userType = str4;
        this.userBroadcasterType = str5;
        this.userLogo = str6;
        this.gameId = i11;
        this.gameName = str7;
        this.gameSlug = str8;
        this.boxArtUrl = str9;
        this.title = str10;
        this.createdAt = str11;
        this.thumbnail = str12;
        this.type = str13;
        this.duration = str14;
        this.animatedPreviewURL = str15;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ Bookmark(java.lang.String r19, int r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, java.lang.String r24, java.lang.String r25, int r26, java.lang.String r27, java.lang.String r28, java.lang.String r29, java.lang.String r30, java.lang.String r31, java.lang.String r32, java.lang.String r33, java.lang.String r34, java.lang.String r35, int r36, xa.f r37) {
        /*
            r18 = this;
            r0 = r36
            r1 = r0 & 1
            if (r1 == 0) goto L_0x0008
            r1 = 0
            goto L_0x000a
        L_0x0008:
            r1 = r19
        L_0x000a:
            r3 = r0 & 2
            r4 = 0
            if (r3 == 0) goto L_0x0011
            r3 = 0
            goto L_0x0013
        L_0x0011:
            r3 = r20
        L_0x0013:
            r5 = r0 & 4
            if (r5 == 0) goto L_0x0019
            r5 = 0
            goto L_0x001b
        L_0x0019:
            r5 = r21
        L_0x001b:
            r6 = r0 & 8
            if (r6 == 0) goto L_0x0021
            r6 = 0
            goto L_0x0023
        L_0x0021:
            r6 = r22
        L_0x0023:
            r7 = r0 & 16
            if (r7 == 0) goto L_0x0029
            r7 = 0
            goto L_0x002b
        L_0x0029:
            r7 = r23
        L_0x002b:
            r8 = r0 & 32
            if (r8 == 0) goto L_0x0031
            r8 = 0
            goto L_0x0033
        L_0x0031:
            r8 = r24
        L_0x0033:
            r9 = r0 & 64
            if (r9 == 0) goto L_0x0039
            r9 = 0
            goto L_0x003b
        L_0x0039:
            r9 = r25
        L_0x003b:
            r10 = r0 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x0040
            goto L_0x0042
        L_0x0040:
            r4 = r26
        L_0x0042:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0048
            r10 = 0
            goto L_0x004a
        L_0x0048:
            r10 = r27
        L_0x004a:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x0050
            r11 = 0
            goto L_0x0052
        L_0x0050:
            r11 = r28
        L_0x0052:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x0058
            r12 = 0
            goto L_0x005a
        L_0x0058:
            r12 = r29
        L_0x005a:
            r13 = r0 & 2048(0x800, float:2.87E-42)
            if (r13 == 0) goto L_0x0060
            r13 = 0
            goto L_0x0062
        L_0x0060:
            r13 = r30
        L_0x0062:
            r14 = r0 & 4096(0x1000, float:5.74E-42)
            if (r14 == 0) goto L_0x0068
            r14 = 0
            goto L_0x006a
        L_0x0068:
            r14 = r31
        L_0x006a:
            r15 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r15 == 0) goto L_0x0070
            r15 = 0
            goto L_0x0072
        L_0x0070:
            r15 = r32
        L_0x0072:
            r2 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r2 == 0) goto L_0x0078
            r2 = 0
            goto L_0x007a
        L_0x0078:
            r2 = r33
        L_0x007a:
            r16 = 32768(0x8000, float:4.5918E-41)
            r16 = r0 & r16
            if (r16 == 0) goto L_0x0084
            r16 = 0
            goto L_0x0086
        L_0x0084:
            r16 = r34
        L_0x0086:
            r17 = 65536(0x10000, float:9.18355E-41)
            r0 = r0 & r17
            if (r0 == 0) goto L_0x008e
            r0 = 0
            goto L_0x0090
        L_0x008e:
            r0 = r35
        L_0x0090:
            r19 = r18
            r20 = r1
            r21 = r3
            r22 = r5
            r23 = r6
            r24 = r7
            r25 = r8
            r26 = r9
            r27 = r4
            r28 = r10
            r29 = r11
            r30 = r12
            r31 = r13
            r32 = r14
            r33 = r15
            r34 = r2
            r35 = r16
            r36 = r0
            r19.<init>(r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.andreyasadchy.xtra.model.offline.Bookmark.<init>(java.lang.String, int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, xa.f):void");
    }
}
