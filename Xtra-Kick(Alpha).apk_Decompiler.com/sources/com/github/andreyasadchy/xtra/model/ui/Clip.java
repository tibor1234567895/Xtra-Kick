package com.github.andreyasadchy.xtra.model.ui;

import android.os.Parcel;
import android.os.Parcelable;
import com.github.andreyasadchy.xtra.model.offline.Downloadable;
import xa.f;
import xa.j;

public final class Clip implements Parcelable, Downloadable {
    public static final Parcelable.Creator<Clip> CREATOR = new Creator();
    private String boxArtUrl;
    private final int channelId;
    private final String channelName;
    private String channelSlug;
    private final Double duration;
    private int gameId;
    private String gameName;
    private final String gameSlug;
    private String profileImageUrl;
    private final String thumbnailUrl;
    private final String title;
    private final String uploadDate;
    private final String uuid;
    private final String videoAnimatedPreviewURL;
    private final String videoId;
    private final String videoUrl;
    private final Integer viewCount;
    private final Integer vodOffset;

    public static final class Creator implements Parcelable.Creator<Clip> {
        public final Clip createFromParcel(Parcel parcel) {
            j.f("parcel", parcel);
            return new Clip(parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : Double.valueOf(parcel.readDouble()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        public final Clip[] newArray(int i10) {
            return new Clip[i10];
        }
    }

    public Clip() {
        this((String) null, 0, (String) null, (String) null, 0, (String) null, (String) null, (Integer) null, (String) null, (String) null, (Double) null, (Integer) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 262143, (f) null);
    }

    public static /* synthetic */ Clip copy$default(Clip clip, String str, int i10, String str2, String str3, int i11, String str4, String str5, Integer num, String str6, String str7, Double d10, Integer num2, String str8, String str9, String str10, String str11, String str12, String str13, int i12, Object obj) {
        Clip clip2 = clip;
        int i13 = i12;
        return clip.copy((i13 & 1) != 0 ? clip2.uuid : str, (i13 & 2) != 0 ? clip2.channelId : i10, (i13 & 4) != 0 ? clip2.channelName : str2, (i13 & 8) != 0 ? clip2.videoId : str3, (i13 & 16) != 0 ? clip2.gameId : i11, (i13 & 32) != 0 ? clip2.gameSlug : str4, (i13 & 64) != 0 ? clip2.title : str5, (i13 & 128) != 0 ? clip2.viewCount : num, (i13 & 256) != 0 ? clip2.uploadDate : str6, (i13 & 512) != 0 ? clip2.thumbnailUrl : str7, (i13 & 1024) != 0 ? clip2.duration : d10, (i13 & 2048) != 0 ? clip2.vodOffset : num2, (i13 & 4096) != 0 ? clip2.videoUrl : str8, (i13 & 8192) != 0 ? clip2.gameName : str9, (i13 & 16384) != 0 ? clip2.channelSlug : str10, (i13 & 32768) != 0 ? clip2.boxArtUrl : str11, (i13 & 65536) != 0 ? clip2.profileImageUrl : str12, (i13 & 131072) != 0 ? clip2.videoAnimatedPreviewURL : str13);
    }

    public final String component1() {
        return this.uuid;
    }

    public final String component10() {
        return this.thumbnailUrl;
    }

    public final Double component11() {
        return this.duration;
    }

    public final Integer component12() {
        return this.vodOffset;
    }

    public final String component13() {
        return this.videoUrl;
    }

    public final String component14() {
        return this.gameName;
    }

    public final String component15() {
        return this.channelSlug;
    }

    public final String component16() {
        return this.boxArtUrl;
    }

    public final String component17() {
        return this.profileImageUrl;
    }

    public final String component18() {
        return this.videoAnimatedPreviewURL;
    }

    public final int component2() {
        return this.channelId;
    }

    public final String component3() {
        return this.channelName;
    }

    public final String component4() {
        return this.videoId;
    }

    public final int component5() {
        return this.gameId;
    }

    public final String component6() {
        return this.gameSlug;
    }

    public final String component7() {
        return this.title;
    }

    public final Integer component8() {
        return this.viewCount;
    }

    public final String component9() {
        return this.uploadDate;
    }

    public final Clip copy(String str, int i10, String str2, String str3, int i11, String str4, String str5, Integer num, String str6, String str7, Double d10, Integer num2, String str8, String str9, String str10, String str11, String str12, String str13) {
        return new Clip(str, i10, str2, str3, i11, str4, str5, num, str6, str7, d10, num2, str8, str9, str10, str11, str12, str13);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Clip)) {
            return false;
        }
        Clip clip = (Clip) obj;
        return j.a(this.uuid, clip.uuid) && this.channelId == clip.channelId && j.a(this.channelName, clip.channelName) && j.a(this.videoId, clip.videoId) && this.gameId == clip.gameId && j.a(this.gameSlug, clip.gameSlug) && j.a(this.title, clip.title) && j.a(this.viewCount, clip.viewCount) && j.a(this.uploadDate, clip.uploadDate) && j.a(this.thumbnailUrl, clip.thumbnailUrl) && j.a(this.duration, clip.duration) && j.a(this.vodOffset, clip.vodOffset) && j.a(this.videoUrl, clip.videoUrl) && j.a(this.gameName, clip.gameName) && j.a(this.channelSlug, clip.channelSlug) && j.a(this.boxArtUrl, clip.boxArtUrl) && j.a(this.profileImageUrl, clip.profileImageUrl) && j.a(this.videoAnimatedPreviewURL, clip.videoAnimatedPreviewURL);
    }

    public String getBoxArtUrl() {
        return this.boxArtUrl;
    }

    public int getChannelId() {
        return this.channelId;
    }

    public String getChannelLogo() {
        return this.profileImageUrl;
    }

    public String getChannelName() {
        return this.channelName;
    }

    public String getChannelSlug() {
        return this.channelSlug;
    }

    public final Double getDuration() {
        return this.duration;
    }

    public int getGameId() {
        return this.gameId;
    }

    public String getGameName() {
        return this.gameName;
    }

    public String getGameSlug() {
        return this.gameSlug;
    }

    public final String getProfileImageUrl() {
        return this.profileImageUrl;
    }

    public String getThumbnail() {
        return this.thumbnailUrl;
    }

    public final String getThumbnailUrl() {
        return this.thumbnailUrl;
    }

    public String getTitle() {
        return this.title;
    }

    public String getType() {
        return null;
    }

    public String getUploadDate() {
        return this.uploadDate;
    }

    public String getUuid() {
        return this.uuid;
    }

    public final String getVideoAnimatedPreviewURL() {
        return this.videoAnimatedPreviewURL;
    }

    public final String getVideoId() {
        return this.videoId;
    }

    public final String getVideoUrl() {
        return this.videoUrl;
    }

    public final Integer getViewCount() {
        return this.viewCount;
    }

    public final Integer getVodOffset() {
        return this.vodOffset;
    }

    public int hashCode() {
        String str = this.uuid;
        int i10 = 0;
        int hashCode = (((str == null ? 0 : str.hashCode()) * 31) + this.channelId) * 31;
        String str2 = this.channelName;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.videoId;
        int hashCode3 = (((hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.gameId) * 31;
        String str4 = this.gameSlug;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.title;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Integer num = this.viewCount;
        int hashCode6 = (hashCode5 + (num == null ? 0 : num.hashCode())) * 31;
        String str6 = this.uploadDate;
        int hashCode7 = (hashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.thumbnailUrl;
        int hashCode8 = (hashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31;
        Double d10 = this.duration;
        int hashCode9 = (hashCode8 + (d10 == null ? 0 : d10.hashCode())) * 31;
        Integer num2 = this.vodOffset;
        int hashCode10 = (hashCode9 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str8 = this.videoUrl;
        int hashCode11 = (hashCode10 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.gameName;
        int hashCode12 = (hashCode11 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.channelSlug;
        int hashCode13 = (hashCode12 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.boxArtUrl;
        int hashCode14 = (hashCode13 + (str11 == null ? 0 : str11.hashCode())) * 31;
        String str12 = this.profileImageUrl;
        int hashCode15 = (hashCode14 + (str12 == null ? 0 : str12.hashCode())) * 31;
        String str13 = this.videoAnimatedPreviewURL;
        if (str13 != null) {
            i10 = str13.hashCode();
        }
        return hashCode15 + i10;
    }

    public void setBoxArtUrl(String str) {
        this.boxArtUrl = str;
    }

    public void setChannelSlug(String str) {
        this.channelSlug = str;
    }

    public void setGameId(int i10) {
        this.gameId = i10;
    }

    public void setGameName(String str) {
        this.gameName = str;
    }

    public final void setProfileImageUrl(String str) {
        this.profileImageUrl = str;
    }

    public String toString() {
        String str = this.uuid;
        int i10 = this.channelId;
        String str2 = this.channelName;
        String str3 = this.videoId;
        int i11 = this.gameId;
        String str4 = this.gameSlug;
        String str5 = this.title;
        Integer num = this.viewCount;
        String str6 = this.uploadDate;
        String str7 = this.thumbnailUrl;
        Double d10 = this.duration;
        Integer num2 = this.vodOffset;
        String str8 = this.videoUrl;
        String str9 = this.gameName;
        String str10 = this.channelSlug;
        String str11 = this.boxArtUrl;
        String str12 = this.profileImageUrl;
        StringBuilder sb2 = new StringBuilder("Clip(uuid=");
        sb2.append(str);
        sb2.append(", channelId=");
        sb2.append(i10);
        sb2.append(", channelName=");
        q0.f.k(sb2, str2, ", videoId=", str3, ", gameId=");
        sb2.append(i11);
        sb2.append(", gameSlug=");
        sb2.append(str4);
        sb2.append(", title=");
        sb2.append(str5);
        sb2.append(", viewCount=");
        sb2.append(num);
        sb2.append(", uploadDate=");
        q0.f.k(sb2, str6, ", thumbnailUrl=", str7, ", duration=");
        sb2.append(d10);
        sb2.append(", vodOffset=");
        sb2.append(num2);
        sb2.append(", videoUrl=");
        q0.f.k(sb2, str8, ", gameName=", str9, ", channelSlug=");
        q0.f.k(sb2, str10, ", boxArtUrl=", str11, ", profileImageUrl=");
        sb2.append(str12);
        sb2.append(", videoAnimatedPreviewURL=");
        sb2.append(this.videoAnimatedPreviewURL);
        sb2.append(")");
        return sb2.toString();
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.f("out", parcel);
        parcel.writeString(this.uuid);
        parcel.writeInt(this.channelId);
        parcel.writeString(this.channelName);
        parcel.writeString(this.videoId);
        parcel.writeInt(this.gameId);
        parcel.writeString(this.gameSlug);
        parcel.writeString(this.title);
        Integer num = this.viewCount;
        if (num == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        }
        parcel.writeString(this.uploadDate);
        parcel.writeString(this.thumbnailUrl);
        Double d10 = this.duration;
        if (d10 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeDouble(d10.doubleValue());
        }
        Integer num2 = this.vodOffset;
        if (num2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num2.intValue());
        }
        parcel.writeString(this.videoUrl);
        parcel.writeString(this.gameName);
        parcel.writeString(this.channelSlug);
        parcel.writeString(this.boxArtUrl);
        parcel.writeString(this.profileImageUrl);
        parcel.writeString(this.videoAnimatedPreviewURL);
    }

    public Clip(String str, int i10, String str2, String str3, int i11, String str4, String str5, Integer num, String str6, String str7, Double d10, Integer num2, String str8, String str9, String str10, String str11, String str12, String str13) {
        this.uuid = str;
        this.channelId = i10;
        this.channelName = str2;
        this.videoId = str3;
        this.gameId = i11;
        this.gameSlug = str4;
        this.title = str5;
        this.viewCount = num;
        this.uploadDate = str6;
        this.thumbnailUrl = str7;
        this.duration = d10;
        this.vodOffset = num2;
        this.videoUrl = str8;
        this.gameName = str9;
        this.channelSlug = str10;
        this.boxArtUrl = str11;
        this.profileImageUrl = str12;
        this.videoAnimatedPreviewURL = str13;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ Clip(java.lang.String r20, int r21, java.lang.String r22, java.lang.String r23, int r24, java.lang.String r25, java.lang.String r26, java.lang.Integer r27, java.lang.String r28, java.lang.String r29, java.lang.Double r30, java.lang.Integer r31, java.lang.String r32, java.lang.String r33, java.lang.String r34, java.lang.String r35, java.lang.String r36, java.lang.String r37, int r38, xa.f r39) {
        /*
            r19 = this;
            r0 = r38
            r1 = r0 & 1
            if (r1 == 0) goto L_0x0008
            r1 = 0
            goto L_0x000a
        L_0x0008:
            r1 = r20
        L_0x000a:
            r3 = r0 & 2
            r4 = 0
            if (r3 == 0) goto L_0x0011
            r3 = 0
            goto L_0x0013
        L_0x0011:
            r3 = r21
        L_0x0013:
            r5 = r0 & 4
            if (r5 == 0) goto L_0x0019
            r5 = 0
            goto L_0x001b
        L_0x0019:
            r5 = r22
        L_0x001b:
            r6 = r0 & 8
            if (r6 == 0) goto L_0x0021
            r6 = 0
            goto L_0x0023
        L_0x0021:
            r6 = r23
        L_0x0023:
            r7 = r0 & 16
            if (r7 == 0) goto L_0x0028
            goto L_0x002a
        L_0x0028:
            r4 = r24
        L_0x002a:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0030
            r7 = 0
            goto L_0x0032
        L_0x0030:
            r7 = r25
        L_0x0032:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0038
            r8 = 0
            goto L_0x003a
        L_0x0038:
            r8 = r26
        L_0x003a:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x0040
            r9 = 0
            goto L_0x0042
        L_0x0040:
            r9 = r27
        L_0x0042:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0048
            r10 = 0
            goto L_0x004a
        L_0x0048:
            r10 = r28
        L_0x004a:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x0050
            r11 = 0
            goto L_0x0052
        L_0x0050:
            r11 = r29
        L_0x0052:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x0058
            r12 = 0
            goto L_0x005a
        L_0x0058:
            r12 = r30
        L_0x005a:
            r13 = r0 & 2048(0x800, float:2.87E-42)
            if (r13 == 0) goto L_0x0060
            r13 = 0
            goto L_0x0062
        L_0x0060:
            r13 = r31
        L_0x0062:
            r14 = r0 & 4096(0x1000, float:5.74E-42)
            if (r14 == 0) goto L_0x0068
            r14 = 0
            goto L_0x006a
        L_0x0068:
            r14 = r32
        L_0x006a:
            r15 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r15 == 0) goto L_0x0070
            r15 = 0
            goto L_0x0072
        L_0x0070:
            r15 = r33
        L_0x0072:
            r2 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r2 == 0) goto L_0x0078
            r2 = 0
            goto L_0x007a
        L_0x0078:
            r2 = r34
        L_0x007a:
            r16 = 32768(0x8000, float:4.5918E-41)
            r16 = r0 & r16
            if (r16 == 0) goto L_0x0084
            r16 = 0
            goto L_0x0086
        L_0x0084:
            r16 = r35
        L_0x0086:
            r17 = 65536(0x10000, float:9.18355E-41)
            r17 = r0 & r17
            if (r17 == 0) goto L_0x008f
            r17 = 0
            goto L_0x0091
        L_0x008f:
            r17 = r36
        L_0x0091:
            r18 = 131072(0x20000, float:1.83671E-40)
            r0 = r0 & r18
            if (r0 == 0) goto L_0x0099
            r0 = 0
            goto L_0x009b
        L_0x0099:
            r0 = r37
        L_0x009b:
            r20 = r19
            r21 = r1
            r22 = r3
            r23 = r5
            r24 = r6
            r25 = r4
            r26 = r7
            r27 = r8
            r28 = r9
            r29 = r10
            r30 = r11
            r31 = r12
            r32 = r13
            r33 = r14
            r34 = r15
            r35 = r2
            r36 = r16
            r37 = r17
            r38 = r0
            r20.<init>(r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.andreyasadchy.xtra.model.ui.Clip.<init>(java.lang.String, int, java.lang.String, java.lang.String, int, java.lang.String, java.lang.String, java.lang.Integer, java.lang.String, java.lang.String, java.lang.Double, java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, xa.f):void");
    }
}
