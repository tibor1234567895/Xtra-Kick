package com.github.andreyasadchy.xtra.model.ui;

import android.os.Parcel;
import android.os.Parcelable;
import xa.f;
import xa.j;

public final class User implements Parcelable {
    public static final Parcelable.Creator<User> CREATOR = new Creator();
    private final String bannerImageURL;
    private final String broadcasterType;
    private final int channelId;
    private final String channelName;
    private final String channelSlug;
    private final String createdAt;
    private boolean followAccount;
    private final boolean followLocal;
    private String followedAt;
    private final Integer followersCount;
    private final Boolean isLive;
    private String lastBroadcast;
    private String profileImageUrl;
    private final Stream stream;
    private final String type;
    private final int userId;

    public static final class Creator implements Parcelable.Creator<User> {
        public final User createFromParcel(Parcel parcel) {
            Boolean bool;
            Parcel parcel2 = parcel;
            j.f("parcel", parcel2);
            int readInt = parcel.readInt();
            int readInt2 = parcel.readInt();
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            String readString5 = parcel.readString();
            String readString6 = parcel.readString();
            Stream stream = null;
            Integer valueOf = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            String readString7 = parcel.readString();
            String readString8 = parcel.readString();
            String readString9 = parcel.readString();
            if (parcel.readInt() == 0) {
                bool = null;
            } else {
                bool = Boolean.valueOf(parcel.readInt() != 0);
            }
            if (parcel.readInt() != 0) {
                stream = Stream.CREATOR.createFromParcel(parcel2);
            }
            return new User(readInt, readInt2, readString, readString2, readString3, readString4, readString5, readString6, valueOf, readString7, readString8, readString9, bool, stream, parcel.readInt() != 0, parcel.readInt() != 0);
        }

        public final User[] newArray(int i10) {
            return new User[i10];
        }
    }

    public User() {
        this(0, 0, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Integer) null, (String) null, (String) null, (String) null, (Boolean) null, (Stream) null, false, false, 65535, (f) null);
    }

    public static /* synthetic */ User copy$default(User user, int i10, int i11, String str, String str2, String str3, String str4, String str5, String str6, Integer num, String str7, String str8, String str9, Boolean bool, Stream stream2, boolean z10, boolean z11, int i12, Object obj) {
        User user2 = user;
        int i13 = i12;
        return user.copy((i13 & 1) != 0 ? user2.channelId : i10, (i13 & 2) != 0 ? user2.userId : i11, (i13 & 4) != 0 ? user2.channelSlug : str, (i13 & 8) != 0 ? user2.channelName : str2, (i13 & 16) != 0 ? user2.type : str3, (i13 & 32) != 0 ? user2.broadcasterType : str4, (i13 & 64) != 0 ? user2.profileImageUrl : str5, (i13 & 128) != 0 ? user2.createdAt : str6, (i13 & 256) != 0 ? user2.followersCount : num, (i13 & 512) != 0 ? user2.bannerImageURL : str7, (i13 & 1024) != 0 ? user2.followedAt : str8, (i13 & 2048) != 0 ? user2.lastBroadcast : str9, (i13 & 4096) != 0 ? user2.isLive : bool, (i13 & 8192) != 0 ? user2.stream : stream2, (i13 & 16384) != 0 ? user2.followAccount : z10, (i13 & 32768) != 0 ? user2.followLocal : z11);
    }

    public final int component1() {
        return this.channelId;
    }

    public final String component10() {
        return this.bannerImageURL;
    }

    public final String component11() {
        return this.followedAt;
    }

    public final String component12() {
        return this.lastBroadcast;
    }

    public final Boolean component13() {
        return this.isLive;
    }

    public final Stream component14() {
        return this.stream;
    }

    public final boolean component15() {
        return this.followAccount;
    }

    public final boolean component16() {
        return this.followLocal;
    }

    public final int component2() {
        return this.userId;
    }

    public final String component3() {
        return this.channelSlug;
    }

    public final String component4() {
        return this.channelName;
    }

    public final String component5() {
        return this.type;
    }

    public final String component6() {
        return this.broadcasterType;
    }

    public final String component7() {
        return this.profileImageUrl;
    }

    public final String component8() {
        return this.createdAt;
    }

    public final Integer component9() {
        return this.followersCount;
    }

    public final User copy(int i10, int i11, String str, String str2, String str3, String str4, String str5, String str6, Integer num, String str7, String str8, String str9, Boolean bool, Stream stream2, boolean z10, boolean z11) {
        return new User(i10, i11, str, str2, str3, str4, str5, str6, num, str7, str8, str9, bool, stream2, z10, z11);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof User)) {
            return false;
        }
        User user = (User) obj;
        return this.channelId == user.channelId && this.userId == user.userId && j.a(this.channelSlug, user.channelSlug) && j.a(this.channelName, user.channelName) && j.a(this.type, user.type) && j.a(this.broadcasterType, user.broadcasterType) && j.a(this.profileImageUrl, user.profileImageUrl) && j.a(this.createdAt, user.createdAt) && j.a(this.followersCount, user.followersCount) && j.a(this.bannerImageURL, user.bannerImageURL) && j.a(this.followedAt, user.followedAt) && j.a(this.lastBroadcast, user.lastBroadcast) && j.a(this.isLive, user.isLive) && j.a(this.stream, user.stream) && this.followAccount == user.followAccount && this.followLocal == user.followLocal;
    }

    public final String getBannerImageURL() {
        return this.bannerImageURL;
    }

    public final String getBroadcasterType() {
        return this.broadcasterType;
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

    public final String getCreatedAt() {
        return this.createdAt;
    }

    public final boolean getFollowAccount() {
        return this.followAccount;
    }

    public final boolean getFollowLocal() {
        return this.followLocal;
    }

    public final String getFollowedAt() {
        return this.followedAt;
    }

    public final Integer getFollowersCount() {
        return this.followersCount;
    }

    public final String getLastBroadcast() {
        return this.lastBroadcast;
    }

    public final String getProfileImageUrl() {
        return this.profileImageUrl;
    }

    public final Stream getStream() {
        return this.stream;
    }

    public final String getType() {
        return this.type;
    }

    public final int getUserId() {
        return this.userId;
    }

    public int hashCode() {
        int i10 = ((this.channelId * 31) + this.userId) * 31;
        String str = this.channelSlug;
        int i11 = 0;
        int hashCode = (i10 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.channelName;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.type;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.broadcasterType;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.profileImageUrl;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.createdAt;
        int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        Integer num = this.followersCount;
        int hashCode7 = (hashCode6 + (num == null ? 0 : num.hashCode())) * 31;
        String str7 = this.bannerImageURL;
        int hashCode8 = (hashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.followedAt;
        int hashCode9 = (hashCode8 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.lastBroadcast;
        int hashCode10 = (hashCode9 + (str9 == null ? 0 : str9.hashCode())) * 31;
        Boolean bool = this.isLive;
        int hashCode11 = (hashCode10 + (bool == null ? 0 : bool.hashCode())) * 31;
        Stream stream2 = this.stream;
        if (stream2 != null) {
            i11 = stream2.hashCode();
        }
        int i12 = (hashCode11 + i11) * 31;
        boolean z10 = this.followAccount;
        boolean z11 = true;
        if (z10) {
            z10 = true;
        }
        int i13 = (i12 + (z10 ? 1 : 0)) * 31;
        boolean z12 = this.followLocal;
        if (!z12) {
            z11 = z12;
        }
        return i13 + (z11 ? 1 : 0);
    }

    public final Boolean isLive() {
        return this.isLive;
    }

    public final void setFollowAccount(boolean z10) {
        this.followAccount = z10;
    }

    public final void setFollowedAt(String str) {
        this.followedAt = str;
    }

    public final void setLastBroadcast(String str) {
        this.lastBroadcast = str;
    }

    public final void setProfileImageUrl(String str) {
        this.profileImageUrl = str;
    }

    public String toString() {
        int i10 = this.channelId;
        int i11 = this.userId;
        String str = this.channelSlug;
        String str2 = this.channelName;
        String str3 = this.type;
        String str4 = this.broadcasterType;
        String str5 = this.profileImageUrl;
        String str6 = this.createdAt;
        Integer num = this.followersCount;
        String str7 = this.bannerImageURL;
        String str8 = this.followedAt;
        String str9 = this.lastBroadcast;
        Boolean bool = this.isLive;
        Stream stream2 = this.stream;
        boolean z10 = this.followAccount;
        StringBuilder sb2 = new StringBuilder("User(channelId=");
        sb2.append(i10);
        sb2.append(", userId=");
        sb2.append(i11);
        sb2.append(", channelSlug=");
        q0.f.k(sb2, str, ", channelName=", str2, ", type=");
        q0.f.k(sb2, str3, ", broadcasterType=", str4, ", profileImageUrl=");
        q0.f.k(sb2, str5, ", createdAt=", str6, ", followersCount=");
        sb2.append(num);
        sb2.append(", bannerImageURL=");
        sb2.append(str7);
        sb2.append(", followedAt=");
        q0.f.k(sb2, str8, ", lastBroadcast=", str9, ", isLive=");
        sb2.append(bool);
        sb2.append(", stream=");
        sb2.append(stream2);
        sb2.append(", followAccount=");
        sb2.append(z10);
        sb2.append(", followLocal=");
        sb2.append(this.followLocal);
        sb2.append(")");
        return sb2.toString();
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.f("out", parcel);
        parcel.writeInt(this.channelId);
        parcel.writeInt(this.userId);
        parcel.writeString(this.channelSlug);
        parcel.writeString(this.channelName);
        parcel.writeString(this.type);
        parcel.writeString(this.broadcasterType);
        parcel.writeString(this.profileImageUrl);
        parcel.writeString(this.createdAt);
        Integer num = this.followersCount;
        if (num == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        }
        parcel.writeString(this.bannerImageURL);
        parcel.writeString(this.followedAt);
        parcel.writeString(this.lastBroadcast);
        Boolean bool = this.isLive;
        if (bool == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        }
        Stream stream2 = this.stream;
        if (stream2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            stream2.writeToParcel(parcel, i10);
        }
        parcel.writeInt(this.followAccount ? 1 : 0);
        parcel.writeInt(this.followLocal ? 1 : 0);
    }

    public User(int i10, int i11, String str, String str2, String str3, String str4, String str5, String str6, Integer num, String str7, String str8, String str9, Boolean bool, Stream stream2, boolean z10, boolean z11) {
        this.channelId = i10;
        this.userId = i11;
        this.channelSlug = str;
        this.channelName = str2;
        this.type = str3;
        this.broadcasterType = str4;
        this.profileImageUrl = str5;
        this.createdAt = str6;
        this.followersCount = num;
        this.bannerImageURL = str7;
        this.followedAt = str8;
        this.lastBroadcast = str9;
        this.isLive = bool;
        this.stream = stream2;
        this.followAccount = z10;
        this.followLocal = z11;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ User(int r18, int r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, java.lang.String r24, java.lang.String r25, java.lang.Integer r26, java.lang.String r27, java.lang.String r28, java.lang.String r29, java.lang.Boolean r30, com.github.andreyasadchy.xtra.model.ui.Stream r31, boolean r32, boolean r33, int r34, xa.f r35) {
        /*
            r17 = this;
            r0 = r34
            r1 = r0 & 1
            if (r1 == 0) goto L_0x0008
            r1 = 0
            goto L_0x000a
        L_0x0008:
            r1 = r18
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = 0
            goto L_0x0012
        L_0x0010:
            r3 = r19
        L_0x0012:
            r4 = r0 & 4
            r5 = 0
            if (r4 == 0) goto L_0x0019
            r4 = r5
            goto L_0x001b
        L_0x0019:
            r4 = r20
        L_0x001b:
            r6 = r0 & 8
            if (r6 == 0) goto L_0x0021
            r6 = r5
            goto L_0x0023
        L_0x0021:
            r6 = r21
        L_0x0023:
            r7 = r0 & 16
            if (r7 == 0) goto L_0x0029
            r7 = r5
            goto L_0x002b
        L_0x0029:
            r7 = r22
        L_0x002b:
            r8 = r0 & 32
            if (r8 == 0) goto L_0x0031
            r8 = r5
            goto L_0x0033
        L_0x0031:
            r8 = r23
        L_0x0033:
            r9 = r0 & 64
            if (r9 == 0) goto L_0x0039
            r9 = r5
            goto L_0x003b
        L_0x0039:
            r9 = r24
        L_0x003b:
            r10 = r0 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x0041
            r10 = r5
            goto L_0x0043
        L_0x0041:
            r10 = r25
        L_0x0043:
            r11 = r0 & 256(0x100, float:3.59E-43)
            if (r11 == 0) goto L_0x0049
            r11 = r5
            goto L_0x004b
        L_0x0049:
            r11 = r26
        L_0x004b:
            r12 = r0 & 512(0x200, float:7.175E-43)
            if (r12 == 0) goto L_0x0051
            r12 = r5
            goto L_0x0053
        L_0x0051:
            r12 = r27
        L_0x0053:
            r13 = r0 & 1024(0x400, float:1.435E-42)
            if (r13 == 0) goto L_0x0059
            r13 = r5
            goto L_0x005b
        L_0x0059:
            r13 = r28
        L_0x005b:
            r14 = r0 & 2048(0x800, float:2.87E-42)
            if (r14 == 0) goto L_0x0061
            r14 = r5
            goto L_0x0063
        L_0x0061:
            r14 = r29
        L_0x0063:
            r15 = r0 & 4096(0x1000, float:5.74E-42)
            if (r15 == 0) goto L_0x006a
            java.lang.Boolean r15 = java.lang.Boolean.FALSE
            goto L_0x006c
        L_0x006a:
            r15 = r30
        L_0x006c:
            r2 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r2 == 0) goto L_0x0071
            goto L_0x0073
        L_0x0071:
            r5 = r31
        L_0x0073:
            r2 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r2 == 0) goto L_0x0079
            r2 = 0
            goto L_0x007b
        L_0x0079:
            r2 = r32
        L_0x007b:
            r16 = 32768(0x8000, float:4.5918E-41)
            r0 = r0 & r16
            if (r0 == 0) goto L_0x0084
            r0 = 0
            goto L_0x0086
        L_0x0084:
            r0 = r33
        L_0x0086:
            r18 = r17
            r19 = r1
            r20 = r3
            r21 = r4
            r22 = r6
            r23 = r7
            r24 = r8
            r25 = r9
            r26 = r10
            r27 = r11
            r28 = r12
            r29 = r13
            r30 = r14
            r31 = r15
            r32 = r5
            r33 = r2
            r34 = r0
            r18.<init>(r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.andreyasadchy.xtra.model.ui.User.<init>(int, int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, java.lang.Boolean, com.github.andreyasadchy.xtra.model.ui.Stream, boolean, boolean, int, xa.f):void");
    }
}
