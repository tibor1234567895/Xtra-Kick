package com.github.andreyasadchy.xtra.model.ui;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
import xa.f;
import xa.j;

public final class Stream implements Parcelable {
    public static final Parcelable.Creator<Stream> CREATOR = new Creator();
    private String boxArtUrl;
    private final int channelId;
    private final String channelName;
    private final String channelSlug;
    private int gameId;
    private String gameName;
    private String gameSlug;
    private int id;
    private String profileImageUrl;
    private final String startedAt;
    private final List<String> tags;
    private final String thumbnailUrl;
    private String title;
    private final String type;
    private final User user;
    private Integer viewerCount;

    public static final class Creator implements Parcelable.Creator<Stream> {
        public final Stream createFromParcel(Parcel parcel) {
            Parcel parcel2 = parcel;
            j.f("parcel", parcel2);
            int readInt = parcel.readInt();
            int readInt2 = parcel.readInt();
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            int readInt3 = parcel.readInt();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            String readString5 = parcel.readString();
            String readString6 = parcel.readString();
            User user = null;
            Integer valueOf = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            String readString7 = parcel.readString();
            String readString8 = parcel.readString();
            String readString9 = parcel.readString();
            String readString10 = parcel.readString();
            ArrayList<String> createStringArrayList = parcel.createStringArrayList();
            if (parcel.readInt() != 0) {
                user = User.CREATOR.createFromParcel(parcel2);
            }
            return new Stream(readInt, readInt2, readString, readString2, readInt3, readString3, readString4, readString5, readString6, valueOf, readString7, readString8, readString9, readString10, createStringArrayList, user);
        }

        public final Stream[] newArray(int i10) {
            return new Stream[i10];
        }
    }

    public Stream() {
        this(0, 0, (String) null, (String) null, 0, (String) null, (String) null, (String) null, (String) null, (Integer) null, (String) null, (String) null, (String) null, (String) null, (List) null, (User) null, 65535, (f) null);
    }

    public static /* synthetic */ Stream copy$default(Stream stream, int i10, int i11, String str, String str2, int i12, String str3, String str4, String str5, String str6, Integer num, String str7, String str8, String str9, String str10, List list, User user2, int i13, Object obj) {
        Stream stream2 = stream;
        int i14 = i13;
        return stream.copy((i14 & 1) != 0 ? stream2.id : i10, (i14 & 2) != 0 ? stream2.channelId : i11, (i14 & 4) != 0 ? stream2.channelSlug : str, (i14 & 8) != 0 ? stream2.channelName : str2, (i14 & 16) != 0 ? stream2.gameId : i12, (i14 & 32) != 0 ? stream2.gameName : str3, (i14 & 64) != 0 ? stream2.gameSlug : str4, (i14 & 128) != 0 ? stream2.type : str5, (i14 & 256) != 0 ? stream2.title : str6, (i14 & 512) != 0 ? stream2.viewerCount : num, (i14 & 1024) != 0 ? stream2.startedAt : str7, (i14 & 2048) != 0 ? stream2.thumbnailUrl : str8, (i14 & 4096) != 0 ? stream2.profileImageUrl : str9, (i14 & 8192) != 0 ? stream2.boxArtUrl : str10, (i14 & 16384) != 0 ? stream2.tags : list, (i14 & 32768) != 0 ? stream2.user : user2);
    }

    public final int component1() {
        return this.id;
    }

    public final Integer component10() {
        return this.viewerCount;
    }

    public final String component11() {
        return this.startedAt;
    }

    public final String component12() {
        return this.thumbnailUrl;
    }

    public final String component13() {
        return this.profileImageUrl;
    }

    public final String component14() {
        return this.boxArtUrl;
    }

    public final List<String> component15() {
        return this.tags;
    }

    public final User component16() {
        return this.user;
    }

    public final int component2() {
        return this.channelId;
    }

    public final String component3() {
        return this.channelSlug;
    }

    public final String component4() {
        return this.channelName;
    }

    public final int component5() {
        return this.gameId;
    }

    public final String component6() {
        return this.gameName;
    }

    public final String component7() {
        return this.gameSlug;
    }

    public final String component8() {
        return this.type;
    }

    public final String component9() {
        return this.title;
    }

    public final Stream copy(int i10, int i11, String str, String str2, int i12, String str3, String str4, String str5, String str6, Integer num, String str7, String str8, String str9, String str10, List<String> list, User user2) {
        return new Stream(i10, i11, str, str2, i12, str3, str4, str5, str6, num, str7, str8, str9, str10, list, user2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Stream)) {
            return false;
        }
        Stream stream = (Stream) obj;
        return this.id == stream.id && this.channelId == stream.channelId && j.a(this.channelSlug, stream.channelSlug) && j.a(this.channelName, stream.channelName) && this.gameId == stream.gameId && j.a(this.gameName, stream.gameName) && j.a(this.gameSlug, stream.gameSlug) && j.a(this.type, stream.type) && j.a(this.title, stream.title) && j.a(this.viewerCount, stream.viewerCount) && j.a(this.startedAt, stream.startedAt) && j.a(this.thumbnailUrl, stream.thumbnailUrl) && j.a(this.profileImageUrl, stream.profileImageUrl) && j.a(this.boxArtUrl, stream.boxArtUrl) && j.a(this.tags, stream.tags) && j.a(this.user, stream.user);
    }

    public final String getBoxArtUrl() {
        return this.boxArtUrl;
    }

    public final int getChannelId() {
        return this.channelId;
    }

    public final String getChannelLogo() {
        return this.profileImageUrl;
    }

    public final String getChannelName() {
        return this.channelName;
    }

    public final String getChannelSlug() {
        return this.channelSlug;
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

    public final String getProfileImageUrl() {
        return this.profileImageUrl;
    }

    public final String getStartedAt() {
        return this.startedAt;
    }

    public final List<String> getTags() {
        return this.tags;
    }

    public final String getThumbnail() {
        return this.thumbnailUrl;
    }

    public final String getThumbnailUrl() {
        return this.thumbnailUrl;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getType() {
        return this.type;
    }

    public final User getUser() {
        return this.user;
    }

    public final Integer getViewerCount() {
        return this.viewerCount;
    }

    public int hashCode() {
        int i10 = ((this.id * 31) + this.channelId) * 31;
        String str = this.channelSlug;
        int i11 = 0;
        int hashCode = (i10 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.channelName;
        int hashCode2 = (((hashCode + (str2 == null ? 0 : str2.hashCode())) * 31) + this.gameId) * 31;
        String str3 = this.gameName;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.gameSlug;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.type;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.title;
        int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        Integer num = this.viewerCount;
        int hashCode7 = (hashCode6 + (num == null ? 0 : num.hashCode())) * 31;
        String str7 = this.startedAt;
        int hashCode8 = (hashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.thumbnailUrl;
        int hashCode9 = (hashCode8 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.profileImageUrl;
        int hashCode10 = (hashCode9 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.boxArtUrl;
        int hashCode11 = (hashCode10 + (str10 == null ? 0 : str10.hashCode())) * 31;
        List<String> list = this.tags;
        int hashCode12 = (hashCode11 + (list == null ? 0 : list.hashCode())) * 31;
        User user2 = this.user;
        if (user2 != null) {
            i11 = user2.hashCode();
        }
        return hashCode12 + i11;
    }

    public final void setBoxArtUrl(String str) {
        this.boxArtUrl = str;
    }

    public final void setGameId(int i10) {
        this.gameId = i10;
    }

    public final void setGameName(String str) {
        this.gameName = str;
    }

    public final void setGameSlug(String str) {
        this.gameSlug = str;
    }

    public final void setId(int i10) {
        this.id = i10;
    }

    public final void setProfileImageUrl(String str) {
        this.profileImageUrl = str;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final void setViewerCount(Integer num) {
        this.viewerCount = num;
    }

    public String toString() {
        int i10 = this.id;
        int i11 = this.channelId;
        String str = this.channelSlug;
        String str2 = this.channelName;
        int i12 = this.gameId;
        String str3 = this.gameName;
        String str4 = this.gameSlug;
        String str5 = this.type;
        String str6 = this.title;
        Integer num = this.viewerCount;
        String str7 = this.startedAt;
        String str8 = this.thumbnailUrl;
        String str9 = this.profileImageUrl;
        String str10 = this.boxArtUrl;
        List<String> list = this.tags;
        StringBuilder sb2 = new StringBuilder("Stream(id=");
        sb2.append(i10);
        sb2.append(", channelId=");
        sb2.append(i11);
        sb2.append(", channelSlug=");
        q0.f.k(sb2, str, ", channelName=", str2, ", gameId=");
        sb2.append(i12);
        sb2.append(", gameName=");
        sb2.append(str3);
        sb2.append(", gameSlug=");
        q0.f.k(sb2, str4, ", type=", str5, ", title=");
        sb2.append(str6);
        sb2.append(", viewerCount=");
        sb2.append(num);
        sb2.append(", startedAt=");
        q0.f.k(sb2, str7, ", thumbnailUrl=", str8, ", profileImageUrl=");
        q0.f.k(sb2, str9, ", boxArtUrl=", str10, ", tags=");
        sb2.append(list);
        sb2.append(", user=");
        sb2.append(this.user);
        sb2.append(")");
        return sb2.toString();
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.f("out", parcel);
        parcel.writeInt(this.id);
        parcel.writeInt(this.channelId);
        parcel.writeString(this.channelSlug);
        parcel.writeString(this.channelName);
        parcel.writeInt(this.gameId);
        parcel.writeString(this.gameName);
        parcel.writeString(this.gameSlug);
        parcel.writeString(this.type);
        parcel.writeString(this.title);
        Integer num = this.viewerCount;
        if (num == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        }
        parcel.writeString(this.startedAt);
        parcel.writeString(this.thumbnailUrl);
        parcel.writeString(this.profileImageUrl);
        parcel.writeString(this.boxArtUrl);
        parcel.writeStringList(this.tags);
        User user2 = this.user;
        if (user2 == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        user2.writeToParcel(parcel, i10);
    }

    public Stream(int i10, int i11, String str, String str2, int i12, String str3, String str4, String str5, String str6, Integer num, String str7, String str8, String str9, String str10, List<String> list, User user2) {
        this.id = i10;
        this.channelId = i11;
        this.channelSlug = str;
        this.channelName = str2;
        this.gameId = i12;
        this.gameName = str3;
        this.gameSlug = str4;
        this.type = str5;
        this.title = str6;
        this.viewerCount = num;
        this.startedAt = str7;
        this.thumbnailUrl = str8;
        this.profileImageUrl = str9;
        this.boxArtUrl = str10;
        this.tags = list;
        this.user = user2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ Stream(int r18, int r19, java.lang.String r20, java.lang.String r21, int r22, java.lang.String r23, java.lang.String r24, java.lang.String r25, java.lang.String r26, java.lang.Integer r27, java.lang.String r28, java.lang.String r29, java.lang.String r30, java.lang.String r31, java.util.List r32, com.github.andreyasadchy.xtra.model.ui.User r33, int r34, xa.f r35) {
        /*
            r17 = this;
            r0 = r34
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = 0
            goto L_0x000b
        L_0x0009:
            r1 = r18
        L_0x000b:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0011
            r3 = 0
            goto L_0x0013
        L_0x0011:
            r3 = r19
        L_0x0013:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0019
            r4 = 0
            goto L_0x001b
        L_0x0019:
            r4 = r20
        L_0x001b:
            r6 = r0 & 8
            if (r6 == 0) goto L_0x0021
            r6 = 0
            goto L_0x0023
        L_0x0021:
            r6 = r21
        L_0x0023:
            r7 = r0 & 16
            if (r7 == 0) goto L_0x0028
            goto L_0x002a
        L_0x0028:
            r2 = r22
        L_0x002a:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0030
            r7 = 0
            goto L_0x0032
        L_0x0030:
            r7 = r23
        L_0x0032:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0038
            r8 = 0
            goto L_0x003a
        L_0x0038:
            r8 = r24
        L_0x003a:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x0040
            r9 = 0
            goto L_0x0042
        L_0x0040:
            r9 = r25
        L_0x0042:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0048
            r10 = 0
            goto L_0x004a
        L_0x0048:
            r10 = r26
        L_0x004a:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x0050
            r11 = 0
            goto L_0x0052
        L_0x0050:
            r11 = r27
        L_0x0052:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x0058
            r12 = 0
            goto L_0x005a
        L_0x0058:
            r12 = r28
        L_0x005a:
            r13 = r0 & 2048(0x800, float:2.87E-42)
            if (r13 == 0) goto L_0x0060
            r13 = 0
            goto L_0x0062
        L_0x0060:
            r13 = r29
        L_0x0062:
            r14 = r0 & 4096(0x1000, float:5.74E-42)
            if (r14 == 0) goto L_0x0068
            r14 = 0
            goto L_0x006a
        L_0x0068:
            r14 = r30
        L_0x006a:
            r15 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r15 == 0) goto L_0x0070
            r15 = 0
            goto L_0x0072
        L_0x0070:
            r15 = r31
        L_0x0072:
            r5 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r5 == 0) goto L_0x0078
            r5 = 0
            goto L_0x007a
        L_0x0078:
            r5 = r32
        L_0x007a:
            r16 = 32768(0x8000, float:4.5918E-41)
            r0 = r0 & r16
            if (r0 == 0) goto L_0x0083
            r0 = 0
            goto L_0x0085
        L_0x0083:
            r0 = r33
        L_0x0085:
            r18 = r17
            r19 = r1
            r20 = r3
            r21 = r4
            r22 = r6
            r23 = r2
            r24 = r7
            r25 = r8
            r26 = r9
            r27 = r10
            r28 = r11
            r29 = r12
            r30 = r13
            r31 = r14
            r32 = r15
            r33 = r5
            r34 = r0
            r18.<init>(r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.andreyasadchy.xtra.model.ui.Stream.<init>(int, int, java.lang.String, java.lang.String, int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.List, com.github.andreyasadchy.xtra.model.ui.User, int, xa.f):void");
    }
}
