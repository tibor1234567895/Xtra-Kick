package com.github.andreyasadchy.xtra.model.retrofit.kick.v1;

import k9.b;
import q0.f;
import xa.j;

public final class Video {
    @b("created_at")
    private final String createdAt;
    private final int id;
    @b("live_stream_id")
    private final int liveStreamId;
    private final LivestreamVideo livestream;
    private final String slug;
    private final String source;
    @b("updated_at")
    private final String updatedAt;
    private final String uuid;
    private final int views;

    public Video(int i10, int i11, String str, String str2, String str3, String str4, int i12, String str5, LivestreamVideo livestreamVideo) {
        this.id = i10;
        this.liveStreamId = i11;
        this.slug = str;
        this.createdAt = str2;
        this.updatedAt = str3;
        this.uuid = str4;
        this.views = i12;
        this.source = str5;
        this.livestream = livestreamVideo;
    }

    public static /* synthetic */ Video copy$default(Video video, int i10, int i11, String str, String str2, String str3, String str4, int i12, String str5, LivestreamVideo livestreamVideo, int i13, Object obj) {
        Video video2 = video;
        int i14 = i13;
        return video.copy((i14 & 1) != 0 ? video2.id : i10, (i14 & 2) != 0 ? video2.liveStreamId : i11, (i14 & 4) != 0 ? video2.slug : str, (i14 & 8) != 0 ? video2.createdAt : str2, (i14 & 16) != 0 ? video2.updatedAt : str3, (i14 & 32) != 0 ? video2.uuid : str4, (i14 & 64) != 0 ? video2.views : i12, (i14 & 128) != 0 ? video2.source : str5, (i14 & 256) != 0 ? video2.livestream : livestreamVideo);
    }

    public final int component1() {
        return this.id;
    }

    public final int component2() {
        return this.liveStreamId;
    }

    public final String component3() {
        return this.slug;
    }

    public final String component4() {
        return this.createdAt;
    }

    public final String component5() {
        return this.updatedAt;
    }

    public final String component6() {
        return this.uuid;
    }

    public final int component7() {
        return this.views;
    }

    public final String component8() {
        return this.source;
    }

    public final LivestreamVideo component9() {
        return this.livestream;
    }

    public final Video copy(int i10, int i11, String str, String str2, String str3, String str4, int i12, String str5, LivestreamVideo livestreamVideo) {
        return new Video(i10, i11, str, str2, str3, str4, i12, str5, livestreamVideo);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Video)) {
            return false;
        }
        Video video = (Video) obj;
        return this.id == video.id && this.liveStreamId == video.liveStreamId && j.a(this.slug, video.slug) && j.a(this.createdAt, video.createdAt) && j.a(this.updatedAt, video.updatedAt) && j.a(this.uuid, video.uuid) && this.views == video.views && j.a(this.source, video.source) && j.a(this.livestream, video.livestream);
    }

    public final String getCreatedAt() {
        return this.createdAt;
    }

    public final int getId() {
        return this.id;
    }

    public final int getLiveStreamId() {
        return this.liveStreamId;
    }

    public final LivestreamVideo getLivestream() {
        return this.livestream;
    }

    public final String getSlug() {
        return this.slug;
    }

    public final String getSource() {
        return this.source;
    }

    public final String getUpdatedAt() {
        return this.updatedAt;
    }

    public final String getUuid() {
        return this.uuid;
    }

    public final int getViews() {
        return this.views;
    }

    public int hashCode() {
        int i10 = ((this.id * 31) + this.liveStreamId) * 31;
        String str = this.slug;
        int i11 = 0;
        int hashCode = (i10 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.createdAt;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.updatedAt;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.uuid;
        int hashCode4 = (((hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31) + this.views) * 31;
        String str5 = this.source;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        LivestreamVideo livestreamVideo = this.livestream;
        if (livestreamVideo != null) {
            i11 = livestreamVideo.hashCode();
        }
        return hashCode5 + i11;
    }

    public String toString() {
        int i10 = this.id;
        int i11 = this.liveStreamId;
        String str = this.slug;
        String str2 = this.createdAt;
        String str3 = this.updatedAt;
        String str4 = this.uuid;
        int i12 = this.views;
        String str5 = this.source;
        LivestreamVideo livestreamVideo = this.livestream;
        StringBuilder sb2 = new StringBuilder("Video(id=");
        sb2.append(i10);
        sb2.append(", liveStreamId=");
        sb2.append(i11);
        sb2.append(", slug=");
        f.k(sb2, str, ", createdAt=", str2, ", updatedAt=");
        f.k(sb2, str3, ", uuid=", str4, ", views=");
        sb2.append(i12);
        sb2.append(", source=");
        sb2.append(str5);
        sb2.append(", livestream=");
        sb2.append(livestreamVideo);
        sb2.append(")");
        return sb2.toString();
    }
}
