package com.github.andreyasadchy.xtra.model.offline;

import android.os.Parcel;
import android.os.Parcelable;
import fb.w;
import xa.f;
import xa.j;

public final class OfflineVideo implements Parcelable {
    public static final Parcelable.Creator<OfflineVideo> CREATOR = new Creator();
    public static final Companion Companion = new Companion((f) null);
    public static final int STATUS_DOWNLOADED = 2;
    public static final int STATUS_DOWNLOADING = 1;
    public static final int STATUS_PENDING = 0;
    private final String boxArtUrl;
    private final int channelId;
    private String channelLogin;
    private String channelLogo;
    private String channelName;
    private final Long downloadDate;
    private final Long duration;
    private final int gameId;
    private final String gameName;
    private final String gameSlug;
    private int id;
    private Long lastWatchPosition;
    private final int maxProgress;
    private final String name;
    private int progress;
    private final Long sourceStartPosition;
    private final String sourceUrl;
    private int status;
    private final String thumbnail;
    private final String type;
    private final Long uploadDate;
    private final String url;
    private final String videoId;
    private boolean vod;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    public static final class Creator implements Parcelable.Creator<OfflineVideo> {
        public final OfflineVideo createFromParcel(Parcel parcel) {
            j.f("parcel", parcel);
            return new OfflineVideo(parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()), parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()), parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()), parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readString());
        }

        public final OfflineVideo[] newArray(int i10) {
            return new OfflineVideo[i10];
        }
    }

    public OfflineVideo(String str, String str2, Long l10, String str3, int i10, String str4, String str5, String str6, String str7, int i11, String str8, String str9, String str10, Long l11, Long l12, Long l13, Long l14, int i12, int i13, int i14, String str11, String str12) {
        j.f("url", str);
        this.url = str;
        this.sourceUrl = str2;
        this.sourceStartPosition = l10;
        this.name = str3;
        this.channelId = i10;
        this.channelLogin = str4;
        this.channelName = str5;
        this.channelLogo = str6;
        this.thumbnail = str7;
        this.gameId = i11;
        this.gameName = str8;
        this.gameSlug = str9;
        this.boxArtUrl = str10;
        this.duration = l11;
        this.uploadDate = l12;
        this.downloadDate = l13;
        this.lastWatchPosition = l14;
        this.progress = i12;
        this.maxProgress = i13;
        this.status = i14;
        this.type = str11;
        this.videoId = str12;
        this.vod = w.f(str, ".m3u8", false);
    }

    public static /* synthetic */ OfflineVideo copy$default(OfflineVideo offlineVideo, String str, String str2, Long l10, String str3, int i10, String str4, String str5, String str6, String str7, int i11, String str8, String str9, String str10, Long l11, Long l12, Long l13, Long l14, int i12, int i13, int i14, String str11, String str12, int i15, Object obj) {
        OfflineVideo offlineVideo2 = offlineVideo;
        int i16 = i15;
        return offlineVideo.copy((i16 & 1) != 0 ? offlineVideo2.url : str, (i16 & 2) != 0 ? offlineVideo2.sourceUrl : str2, (i16 & 4) != 0 ? offlineVideo2.sourceStartPosition : l10, (i16 & 8) != 0 ? offlineVideo2.name : str3, (i16 & 16) != 0 ? offlineVideo2.channelId : i10, (i16 & 32) != 0 ? offlineVideo2.channelLogin : str4, (i16 & 64) != 0 ? offlineVideo2.channelName : str5, (i16 & 128) != 0 ? offlineVideo2.channelLogo : str6, (i16 & 256) != 0 ? offlineVideo2.thumbnail : str7, (i16 & 512) != 0 ? offlineVideo2.gameId : i11, (i16 & 1024) != 0 ? offlineVideo2.gameName : str8, (i16 & 2048) != 0 ? offlineVideo2.gameSlug : str9, (i16 & 4096) != 0 ? offlineVideo2.boxArtUrl : str10, (i16 & 8192) != 0 ? offlineVideo2.duration : l11, (i16 & 16384) != 0 ? offlineVideo2.uploadDate : l12, (i16 & 32768) != 0 ? offlineVideo2.downloadDate : l13, (i16 & 65536) != 0 ? offlineVideo2.lastWatchPosition : l14, (i16 & 131072) != 0 ? offlineVideo2.progress : i12, (i16 & 262144) != 0 ? offlineVideo2.maxProgress : i13, (i16 & 524288) != 0 ? offlineVideo2.status : i14, (i16 & 1048576) != 0 ? offlineVideo2.type : str11, (i16 & 2097152) != 0 ? offlineVideo2.videoId : str12);
    }

    public static /* synthetic */ void getId$annotations() {
    }

    public static /* synthetic */ void getVod$annotations() {
    }

    public final String component1() {
        return this.url;
    }

    public final int component10() {
        return this.gameId;
    }

    public final String component11() {
        return this.gameName;
    }

    public final String component12() {
        return this.gameSlug;
    }

    public final String component13() {
        return this.boxArtUrl;
    }

    public final Long component14() {
        return this.duration;
    }

    public final Long component15() {
        return this.uploadDate;
    }

    public final Long component16() {
        return this.downloadDate;
    }

    public final Long component17() {
        return this.lastWatchPosition;
    }

    public final int component18() {
        return this.progress;
    }

    public final int component19() {
        return this.maxProgress;
    }

    public final String component2() {
        return this.sourceUrl;
    }

    public final int component20() {
        return this.status;
    }

    public final String component21() {
        return this.type;
    }

    public final String component22() {
        return this.videoId;
    }

    public final Long component3() {
        return this.sourceStartPosition;
    }

    public final String component4() {
        return this.name;
    }

    public final int component5() {
        return this.channelId;
    }

    public final String component6() {
        return this.channelLogin;
    }

    public final String component7() {
        return this.channelName;
    }

    public final String component8() {
        return this.channelLogo;
    }

    public final String component9() {
        return this.thumbnail;
    }

    public final OfflineVideo copy(String str, String str2, Long l10, String str3, int i10, String str4, String str5, String str6, String str7, int i11, String str8, String str9, String str10, Long l11, Long l12, Long l13, Long l14, int i12, int i13, int i14, String str11, String str12) {
        String str13 = str;
        String str14 = str13;
        j.f("url", str13);
        return new OfflineVideo(str13, str2, l10, str3, i10, str4, str5, str6, str7, i11, str8, str9, str10, l11, l12, l13, l14, i12, i13, i14, str11, str12);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OfflineVideo)) {
            return false;
        }
        OfflineVideo offlineVideo = (OfflineVideo) obj;
        return j.a(this.url, offlineVideo.url) && j.a(this.sourceUrl, offlineVideo.sourceUrl) && j.a(this.sourceStartPosition, offlineVideo.sourceStartPosition) && j.a(this.name, offlineVideo.name) && this.channelId == offlineVideo.channelId && j.a(this.channelLogin, offlineVideo.channelLogin) && j.a(this.channelName, offlineVideo.channelName) && j.a(this.channelLogo, offlineVideo.channelLogo) && j.a(this.thumbnail, offlineVideo.thumbnail) && this.gameId == offlineVideo.gameId && j.a(this.gameName, offlineVideo.gameName) && j.a(this.gameSlug, offlineVideo.gameSlug) && j.a(this.boxArtUrl, offlineVideo.boxArtUrl) && j.a(this.duration, offlineVideo.duration) && j.a(this.uploadDate, offlineVideo.uploadDate) && j.a(this.downloadDate, offlineVideo.downloadDate) && j.a(this.lastWatchPosition, offlineVideo.lastWatchPosition) && this.progress == offlineVideo.progress && this.maxProgress == offlineVideo.maxProgress && this.status == offlineVideo.status && j.a(this.type, offlineVideo.type) && j.a(this.videoId, offlineVideo.videoId);
    }

    public final String getBoxArtUrl() {
        return this.boxArtUrl;
    }

    public final int getChannelId() {
        return this.channelId;
    }

    public final String getChannelLogin() {
        return this.channelLogin;
    }

    public final String getChannelLogo() {
        return this.channelLogo;
    }

    public final String getChannelName() {
        return this.channelName;
    }

    public final Long getDownloadDate() {
        return this.downloadDate;
    }

    public final Long getDuration() {
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

    public final Long getLastWatchPosition() {
        return this.lastWatchPosition;
    }

    public final int getMaxProgress() {
        return this.maxProgress;
    }

    public final String getName() {
        return this.name;
    }

    public final int getProgress() {
        return this.progress;
    }

    public final Long getSourceStartPosition() {
        return this.sourceStartPosition;
    }

    public final String getSourceUrl() {
        return this.sourceUrl;
    }

    public final int getStatus() {
        return this.status;
    }

    public final String getThumbnail() {
        return this.thumbnail;
    }

    public final String getType() {
        return this.type;
    }

    public final Long getUploadDate() {
        return this.uploadDate;
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getVideoId() {
        return this.videoId;
    }

    public final boolean getVod() {
        return this.vod;
    }

    public int hashCode() {
        int hashCode = this.url.hashCode() * 31;
        String str = this.sourceUrl;
        int i10 = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Long l10 = this.sourceStartPosition;
        int hashCode3 = (hashCode2 + (l10 == null ? 0 : l10.hashCode())) * 31;
        String str2 = this.name;
        int hashCode4 = (((hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.channelId) * 31;
        String str3 = this.channelLogin;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.channelName;
        int hashCode6 = (hashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.channelLogo;
        int hashCode7 = (hashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.thumbnail;
        int hashCode8 = (((hashCode7 + (str6 == null ? 0 : str6.hashCode())) * 31) + this.gameId) * 31;
        String str7 = this.gameName;
        int hashCode9 = (hashCode8 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.gameSlug;
        int hashCode10 = (hashCode9 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.boxArtUrl;
        int hashCode11 = (hashCode10 + (str9 == null ? 0 : str9.hashCode())) * 31;
        Long l11 = this.duration;
        int hashCode12 = (hashCode11 + (l11 == null ? 0 : l11.hashCode())) * 31;
        Long l12 = this.uploadDate;
        int hashCode13 = (hashCode12 + (l12 == null ? 0 : l12.hashCode())) * 31;
        Long l13 = this.downloadDate;
        int hashCode14 = (hashCode13 + (l13 == null ? 0 : l13.hashCode())) * 31;
        Long l14 = this.lastWatchPosition;
        int hashCode15 = (((((((hashCode14 + (l14 == null ? 0 : l14.hashCode())) * 31) + this.progress) * 31) + this.maxProgress) * 31) + this.status) * 31;
        String str10 = this.type;
        int hashCode16 = (hashCode15 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.videoId;
        if (str11 != null) {
            i10 = str11.hashCode();
        }
        return hashCode16 + i10;
    }

    public final void setChannelLogin(String str) {
        this.channelLogin = str;
    }

    public final void setChannelLogo(String str) {
        this.channelLogo = str;
    }

    public final void setChannelName(String str) {
        this.channelName = str;
    }

    public final void setId(int i10) {
        this.id = i10;
    }

    public final void setLastWatchPosition(Long l10) {
        this.lastWatchPosition = l10;
    }

    public final void setProgress(int i10) {
        this.progress = i10;
    }

    public final void setStatus(int i10) {
        this.status = i10;
    }

    public final void setVod(boolean z10) {
        this.vod = z10;
    }

    public String toString() {
        String str = this.url;
        String str2 = this.sourceUrl;
        Long l10 = this.sourceStartPosition;
        String str3 = this.name;
        int i10 = this.channelId;
        String str4 = this.channelLogin;
        String str5 = this.channelName;
        String str6 = this.channelLogo;
        String str7 = this.thumbnail;
        int i11 = this.gameId;
        String str8 = this.gameName;
        String str9 = this.gameSlug;
        String str10 = this.boxArtUrl;
        Long l11 = this.duration;
        Long l12 = this.uploadDate;
        Long l13 = this.downloadDate;
        Long l14 = this.lastWatchPosition;
        int i12 = this.progress;
        int i13 = this.maxProgress;
        int i14 = this.status;
        String str11 = this.type;
        StringBuilder sb2 = new StringBuilder("OfflineVideo(url=");
        sb2.append(str);
        sb2.append(", sourceUrl=");
        sb2.append(str2);
        sb2.append(", sourceStartPosition=");
        sb2.append(l10);
        sb2.append(", name=");
        sb2.append(str3);
        sb2.append(", channelId=");
        sb2.append(i10);
        sb2.append(", channelLogin=");
        sb2.append(str4);
        sb2.append(", channelName=");
        q0.f.k(sb2, str5, ", channelLogo=", str6, ", thumbnail=");
        sb2.append(str7);
        sb2.append(", gameId=");
        sb2.append(i11);
        sb2.append(", gameName=");
        q0.f.k(sb2, str8, ", gameSlug=", str9, ", boxArtUrl=");
        sb2.append(str10);
        sb2.append(", duration=");
        sb2.append(l11);
        sb2.append(", uploadDate=");
        sb2.append(l12);
        sb2.append(", downloadDate=");
        sb2.append(l13);
        sb2.append(", lastWatchPosition=");
        sb2.append(l14);
        sb2.append(", progress=");
        sb2.append(i12);
        sb2.append(", maxProgress=");
        sb2.append(i13);
        sb2.append(", status=");
        sb2.append(i14);
        sb2.append(", type=");
        sb2.append(str11);
        sb2.append(", videoId=");
        sb2.append(this.videoId);
        sb2.append(")");
        return sb2.toString();
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.f("out", parcel);
        parcel.writeString(this.url);
        parcel.writeString(this.sourceUrl);
        Long l10 = this.sourceStartPosition;
        if (l10 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeLong(l10.longValue());
        }
        parcel.writeString(this.name);
        parcel.writeInt(this.channelId);
        parcel.writeString(this.channelLogin);
        parcel.writeString(this.channelName);
        parcel.writeString(this.channelLogo);
        parcel.writeString(this.thumbnail);
        parcel.writeInt(this.gameId);
        parcel.writeString(this.gameName);
        parcel.writeString(this.gameSlug);
        parcel.writeString(this.boxArtUrl);
        Long l11 = this.duration;
        if (l11 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeLong(l11.longValue());
        }
        Long l12 = this.uploadDate;
        if (l12 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeLong(l12.longValue());
        }
        Long l13 = this.downloadDate;
        if (l13 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeLong(l13.longValue());
        }
        Long l14 = this.lastWatchPosition;
        if (l14 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeLong(l14.longValue());
        }
        parcel.writeInt(this.progress);
        parcel.writeInt(this.maxProgress);
        parcel.writeInt(this.status);
        parcel.writeString(this.type);
        parcel.writeString(this.videoId);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ OfflineVideo(java.lang.String r27, java.lang.String r28, java.lang.Long r29, java.lang.String r30, int r31, java.lang.String r32, java.lang.String r33, java.lang.String r34, java.lang.String r35, int r36, java.lang.String r37, java.lang.String r38, java.lang.String r39, java.lang.Long r40, java.lang.Long r41, java.lang.Long r42, java.lang.Long r43, int r44, int r45, int r46, java.lang.String r47, java.lang.String r48, int r49, xa.f r50) {
        /*
            r26 = this;
            r0 = r49
            r1 = r0 & 2
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r5 = r2
            goto L_0x000b
        L_0x0009:
            r5 = r28
        L_0x000b:
            r1 = r0 & 4
            if (r1 == 0) goto L_0x0011
            r6 = r2
            goto L_0x0013
        L_0x0011:
            r6 = r29
        L_0x0013:
            r1 = r0 & 8
            if (r1 == 0) goto L_0x0019
            r7 = r2
            goto L_0x001b
        L_0x0019:
            r7 = r30
        L_0x001b:
            r1 = r0 & 16
            r3 = 0
            if (r1 == 0) goto L_0x0022
            r8 = 0
            goto L_0x0024
        L_0x0022:
            r8 = r31
        L_0x0024:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x002a
            r9 = r2
            goto L_0x002c
        L_0x002a:
            r9 = r32
        L_0x002c:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x0032
            r10 = r2
            goto L_0x0034
        L_0x0032:
            r10 = r33
        L_0x0034:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x003a
            r11 = r2
            goto L_0x003c
        L_0x003a:
            r11 = r34
        L_0x003c:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0042
            r12 = r2
            goto L_0x0044
        L_0x0042:
            r12 = r35
        L_0x0044:
            r1 = r0 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x004a
            r13 = 0
            goto L_0x004c
        L_0x004a:
            r13 = r36
        L_0x004c:
            r1 = r0 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L_0x0052
            r14 = r2
            goto L_0x0054
        L_0x0052:
            r14 = r37
        L_0x0054:
            r1 = r0 & 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L_0x005a
            r15 = r2
            goto L_0x005c
        L_0x005a:
            r15 = r38
        L_0x005c:
            r1 = r0 & 4096(0x1000, float:5.74E-42)
            if (r1 == 0) goto L_0x0063
            r16 = r2
            goto L_0x0065
        L_0x0063:
            r16 = r39
        L_0x0065:
            r1 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r1 == 0) goto L_0x006c
            r17 = r2
            goto L_0x006e
        L_0x006c:
            r17 = r40
        L_0x006e:
            r1 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r1 == 0) goto L_0x0075
            r18 = r2
            goto L_0x0077
        L_0x0075:
            r18 = r41
        L_0x0077:
            r1 = 32768(0x8000, float:4.5918E-41)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x0080
            r19 = r2
            goto L_0x0082
        L_0x0080:
            r19 = r42
        L_0x0082:
            r1 = 65536(0x10000, float:9.18355E-41)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x008a
            r20 = r2
            goto L_0x008c
        L_0x008a:
            r20 = r43
        L_0x008c:
            r1 = 524288(0x80000, float:7.34684E-40)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x0094
            r23 = 0
            goto L_0x0096
        L_0x0094:
            r23 = r46
        L_0x0096:
            r1 = 1048576(0x100000, float:1.469368E-39)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x009e
            r24 = r2
            goto L_0x00a0
        L_0x009e:
            r24 = r47
        L_0x00a0:
            r1 = 2097152(0x200000, float:2.938736E-39)
            r0 = r0 & r1
            if (r0 == 0) goto L_0x00a8
            r25 = r2
            goto L_0x00aa
        L_0x00a8:
            r25 = r48
        L_0x00aa:
            r3 = r26
            r4 = r27
            r21 = r44
            r22 = r45
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.andreyasadchy.xtra.model.offline.OfflineVideo.<init>(java.lang.String, java.lang.String, java.lang.Long, java.lang.String, int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, java.lang.String, java.lang.String, java.lang.String, java.lang.Long, java.lang.Long, java.lang.Long, java.lang.Long, int, int, int, java.lang.String, java.lang.String, int, xa.f):void");
    }
}
