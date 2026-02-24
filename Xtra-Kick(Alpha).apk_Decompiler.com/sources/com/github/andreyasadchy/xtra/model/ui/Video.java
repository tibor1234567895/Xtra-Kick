package com.github.andreyasadchy.xtra.model.ui;

import android.os.Parcel;
import android.os.Parcelable;
import com.github.andreyasadchy.xtra.model.offline.Downloadable;
import java.util.ArrayList;
import java.util.List;
import xa.f;
import xa.j;

public final class Video implements Parcelable, Downloadable {
    public static final Parcelable.Creator<Video> CREATOR = new Creator();
    private final String animatedPreviewURL;
    private final String boxArtUrl;
    private final int channelId;
    private final String channelName;
    private final String channelSlug;
    private final String duration;
    private int gameId;
    private String gameName;
    private final String gameSlug;
    private String profileImageUrl;
    private final List<Tag> tags;
    private final String thumbnailUrl;
    private final String title;
    private final String type;
    private final String uploadDate;
    private final String uuid;
    private final String videoUrl;
    private final Integer viewCount;

    public static final class Creator implements Parcelable.Creator<Video> {
        public final Video createFromParcel(Parcel parcel) {
            String str;
            ArrayList arrayList;
            Parcel parcel2 = parcel;
            j.f("parcel", parcel2);
            String readString = parcel.readString();
            int readInt = parcel.readInt();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            String readString5 = parcel.readString();
            String readString6 = parcel.readString();
            Integer valueOf = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            String readString7 = parcel.readString();
            String readString8 = parcel.readString();
            String readString9 = parcel.readString();
            int readInt2 = parcel.readInt();
            String readString10 = parcel.readString();
            String readString11 = parcel.readString();
            String readString12 = parcel.readString();
            String readString13 = parcel.readString();
            if (parcel.readInt() == 0) {
                arrayList = null;
                str = readString10;
            } else {
                int readInt3 = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(readInt3);
                str = readString10;
                int i10 = 0;
                while (i10 != readInt3) {
                    arrayList2.add(Tag.CREATOR.createFromParcel(parcel2));
                    i10++;
                    readInt3 = readInt3;
                }
                arrayList = arrayList2;
            }
            return new Video(readString, readInt, readString2, readString3, readString4, readString5, readString6, valueOf, readString7, readString8, readString9, readInt2, str, readString11, readString12, readString13, arrayList, parcel.readString());
        }

        public final Video[] newArray(int i10) {
            return new Video[i10];
        }
    }

    public Video() {
        this((String) null, 0, (String) null, (String) null, (String) null, (String) null, (String) null, (Integer) null, (String) null, (String) null, (String) null, 0, (String) null, (String) null, (String) null, (String) null, (List) null, (String) null, 262143, (f) null);
    }

    public static /* synthetic */ Video copy$default(Video video, String str, int i10, String str2, String str3, String str4, String str5, String str6, Integer num, String str7, String str8, String str9, int i11, String str10, String str11, String str12, String str13, List list, String str14, int i12, Object obj) {
        Video video2 = video;
        int i13 = i12;
        return video.copy((i13 & 1) != 0 ? video2.uuid : str, (i13 & 2) != 0 ? video2.channelId : i10, (i13 & 4) != 0 ? video2.channelSlug : str2, (i13 & 8) != 0 ? video2.channelName : str3, (i13 & 16) != 0 ? video2.title : str4, (i13 & 32) != 0 ? video2.uploadDate : str5, (i13 & 64) != 0 ? video2.thumbnailUrl : str6, (i13 & 128) != 0 ? video2.viewCount : num, (i13 & 256) != 0 ? video2.type : str7, (i13 & 512) != 0 ? video2.duration : str8, (i13 & 1024) != 0 ? video2.videoUrl : str9, (i13 & 2048) != 0 ? video2.gameId : i11, (i13 & 4096) != 0 ? video2.gameName : str10, (i13 & 8192) != 0 ? video2.gameSlug : str11, (i13 & 16384) != 0 ? video2.boxArtUrl : str12, (i13 & 32768) != 0 ? video2.profileImageUrl : str13, (i13 & 65536) != 0 ? video2.tags : list, (i13 & 131072) != 0 ? video2.animatedPreviewURL : str14);
    }

    public final String component1() {
        return this.uuid;
    }

    public final String component10() {
        return this.duration;
    }

    public final String component11() {
        return this.videoUrl;
    }

    public final int component12() {
        return this.gameId;
    }

    public final String component13() {
        return this.gameName;
    }

    public final String component14() {
        return this.gameSlug;
    }

    public final String component15() {
        return this.boxArtUrl;
    }

    public final String component16() {
        return this.profileImageUrl;
    }

    public final List<Tag> component17() {
        return this.tags;
    }

    public final String component18() {
        return this.animatedPreviewURL;
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

    public final String component5() {
        return this.title;
    }

    public final String component6() {
        return this.uploadDate;
    }

    public final String component7() {
        return this.thumbnailUrl;
    }

    public final Integer component8() {
        return this.viewCount;
    }

    public final String component9() {
        return this.type;
    }

    public final Video copy(String str, int i10, String str2, String str3, String str4, String str5, String str6, Integer num, String str7, String str8, String str9, int i11, String str10, String str11, String str12, String str13, List<Tag> list, String str14) {
        return new Video(str, i10, str2, str3, str4, str5, str6, num, str7, str8, str9, i11, str10, str11, str12, str13, list, str14);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Video)) {
            return false;
        }
        Video video = (Video) obj;
        return j.a(this.uuid, video.uuid) && this.channelId == video.channelId && j.a(this.channelSlug, video.channelSlug) && j.a(this.channelName, video.channelName) && j.a(this.title, video.title) && j.a(this.uploadDate, video.uploadDate) && j.a(this.thumbnailUrl, video.thumbnailUrl) && j.a(this.viewCount, video.viewCount) && j.a(this.type, video.type) && j.a(this.duration, video.duration) && j.a(this.videoUrl, video.videoUrl) && this.gameId == video.gameId && j.a(this.gameName, video.gameName) && j.a(this.gameSlug, video.gameSlug) && j.a(this.boxArtUrl, video.boxArtUrl) && j.a(this.profileImageUrl, video.profileImageUrl) && j.a(this.tags, video.tags) && j.a(this.animatedPreviewURL, video.animatedPreviewURL);
    }

    public final String getAnimatedPreviewURL() {
        return this.animatedPreviewURL;
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

    public final String getDuration() {
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

    public final List<Tag> getTags() {
        return this.tags;
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
        return this.type;
    }

    public String getUploadDate() {
        return this.uploadDate;
    }

    public String getUuid() {
        return this.uuid;
    }

    public final String getVideoUrl() {
        return this.videoUrl;
    }

    public final Integer getViewCount() {
        return this.viewCount;
    }

    public int hashCode() {
        String str = this.uuid;
        int i10 = 0;
        int hashCode = (((str == null ? 0 : str.hashCode()) * 31) + this.channelId) * 31;
        String str2 = this.channelSlug;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.channelName;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.title;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.uploadDate;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.thumbnailUrl;
        int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        Integer num = this.viewCount;
        int hashCode7 = (hashCode6 + (num == null ? 0 : num.hashCode())) * 31;
        String str7 = this.type;
        int hashCode8 = (hashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.duration;
        int hashCode9 = (hashCode8 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.videoUrl;
        int hashCode10 = (((hashCode9 + (str9 == null ? 0 : str9.hashCode())) * 31) + this.gameId) * 31;
        String str10 = this.gameName;
        int hashCode11 = (hashCode10 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.gameSlug;
        int hashCode12 = (hashCode11 + (str11 == null ? 0 : str11.hashCode())) * 31;
        String str12 = this.boxArtUrl;
        int hashCode13 = (hashCode12 + (str12 == null ? 0 : str12.hashCode())) * 31;
        String str13 = this.profileImageUrl;
        int hashCode14 = (hashCode13 + (str13 == null ? 0 : str13.hashCode())) * 31;
        List<Tag> list = this.tags;
        int hashCode15 = (hashCode14 + (list == null ? 0 : list.hashCode())) * 31;
        String str14 = this.animatedPreviewURL;
        if (str14 != null) {
            i10 = str14.hashCode();
        }
        return hashCode15 + i10;
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
        String str2 = this.channelSlug;
        String str3 = this.channelName;
        String str4 = this.title;
        String str5 = this.uploadDate;
        String str6 = this.thumbnailUrl;
        Integer num = this.viewCount;
        String str7 = this.type;
        String str8 = this.duration;
        String str9 = this.videoUrl;
        int i11 = this.gameId;
        String str10 = this.gameName;
        String str11 = this.gameSlug;
        String str12 = this.boxArtUrl;
        String str13 = this.profileImageUrl;
        List<Tag> list = this.tags;
        StringBuilder sb2 = new StringBuilder("Video(uuid=");
        sb2.append(str);
        sb2.append(", channelId=");
        sb2.append(i10);
        sb2.append(", channelSlug=");
        q0.f.k(sb2, str2, ", channelName=", str3, ", title=");
        q0.f.k(sb2, str4, ", uploadDate=", str5, ", thumbnailUrl=");
        sb2.append(str6);
        sb2.append(", viewCount=");
        sb2.append(num);
        sb2.append(", type=");
        q0.f.k(sb2, str7, ", duration=", str8, ", videoUrl=");
        sb2.append(str9);
        sb2.append(", gameId=");
        sb2.append(i11);
        sb2.append(", gameName=");
        q0.f.k(sb2, str10, ", gameSlug=", str11, ", boxArtUrl=");
        q0.f.k(sb2, str12, ", profileImageUrl=", str13, ", tags=");
        sb2.append(list);
        sb2.append(", animatedPreviewURL=");
        sb2.append(this.animatedPreviewURL);
        sb2.append(")");
        return sb2.toString();
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.f("out", parcel);
        parcel.writeString(this.uuid);
        parcel.writeInt(this.channelId);
        parcel.writeString(this.channelSlug);
        parcel.writeString(this.channelName);
        parcel.writeString(this.title);
        parcel.writeString(this.uploadDate);
        parcel.writeString(this.thumbnailUrl);
        Integer num = this.viewCount;
        if (num == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        }
        parcel.writeString(this.type);
        parcel.writeString(this.duration);
        parcel.writeString(this.videoUrl);
        parcel.writeInt(this.gameId);
        parcel.writeString(this.gameName);
        parcel.writeString(this.gameSlug);
        parcel.writeString(this.boxArtUrl);
        parcel.writeString(this.profileImageUrl);
        List<Tag> list = this.tags;
        if (list == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(list.size());
            for (Tag writeToParcel : list) {
                writeToParcel.writeToParcel(parcel, i10);
            }
        }
        parcel.writeString(this.animatedPreviewURL);
    }

    public Video(String str, int i10, String str2, String str3, String str4, String str5, String str6, Integer num, String str7, String str8, String str9, int i11, String str10, String str11, String str12, String str13, List<Tag> list, String str14) {
        this.uuid = str;
        this.channelId = i10;
        this.channelSlug = str2;
        this.channelName = str3;
        this.title = str4;
        this.uploadDate = str5;
        this.thumbnailUrl = str6;
        this.viewCount = num;
        this.type = str7;
        this.duration = str8;
        this.videoUrl = str9;
        this.gameId = i11;
        this.gameName = str10;
        this.gameSlug = str11;
        this.boxArtUrl = str12;
        this.profileImageUrl = str13;
        this.tags = list;
        this.animatedPreviewURL = str14;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ Video(java.lang.String r20, int r21, java.lang.String r22, java.lang.String r23, java.lang.String r24, java.lang.String r25, java.lang.String r26, java.lang.Integer r27, java.lang.String r28, java.lang.String r29, java.lang.String r30, int r31, java.lang.String r32, java.lang.String r33, java.lang.String r34, java.lang.String r35, java.util.List r36, java.lang.String r37, int r38, xa.f r39) {
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
            if (r7 == 0) goto L_0x0029
            r7 = 0
            goto L_0x002b
        L_0x0029:
            r7 = r24
        L_0x002b:
            r8 = r0 & 32
            if (r8 == 0) goto L_0x0031
            r8 = 0
            goto L_0x0033
        L_0x0031:
            r8 = r25
        L_0x0033:
            r9 = r0 & 64
            if (r9 == 0) goto L_0x0039
            r9 = 0
            goto L_0x003b
        L_0x0039:
            r9 = r26
        L_0x003b:
            r10 = r0 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x0041
            r10 = 0
            goto L_0x0043
        L_0x0041:
            r10 = r27
        L_0x0043:
            r11 = r0 & 256(0x100, float:3.59E-43)
            if (r11 == 0) goto L_0x0049
            r11 = 0
            goto L_0x004b
        L_0x0049:
            r11 = r28
        L_0x004b:
            r12 = r0 & 512(0x200, float:7.175E-43)
            if (r12 == 0) goto L_0x0051
            r12 = 0
            goto L_0x0053
        L_0x0051:
            r12 = r29
        L_0x0053:
            r13 = r0 & 1024(0x400, float:1.435E-42)
            if (r13 == 0) goto L_0x0059
            r13 = 0
            goto L_0x005b
        L_0x0059:
            r13 = r30
        L_0x005b:
            r14 = r0 & 2048(0x800, float:2.87E-42)
            if (r14 == 0) goto L_0x0060
            goto L_0x0062
        L_0x0060:
            r4 = r31
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
            r25 = r7
            r26 = r8
            r27 = r9
            r28 = r10
            r29 = r11
            r30 = r12
            r31 = r13
            r32 = r4
            r33 = r14
            r34 = r15
            r35 = r2
            r36 = r16
            r37 = r17
            r38 = r0
            r20.<init>(r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.andreyasadchy.xtra.model.ui.Video.<init>(java.lang.String, int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.List, java.lang.String, int, xa.f):void");
    }
}
