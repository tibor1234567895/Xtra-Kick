package com.github.andreyasadchy.xtra.model.retrofit.kick.v2;

import android.support.v4.media.h;
import k9.b;
import q0.f;
import xa.j;

public final class Clip {
    private final Category category;
    private final ClipChannel channel;
    @b("created_at")
    private final String createdAt;
    private final Creator creator;
    private final int duration;
    private final int id;
    @b("is_mature")
    private final boolean isMature;
    @b("likes_count")
    private final int likesCount;
    @b("thumbnail_url")
    private final String thumbnailUrl;
    private final String title;
    @b("video_url")
    private final String videoUrl;
    @b("view_count")
    private final int viewCount;

    public Clip(int i10, boolean z10, String str, int i11, String str2, String str3, int i12, int i13, String str4, Creator creator2, ClipChannel clipChannel, Category category2) {
        j.f("title", str);
        j.f("thumbnailUrl", str2);
        j.f("videoUrl", str3);
        j.f("createdAt", str4);
        j.f("creator", creator2);
        j.f("channel", clipChannel);
        j.f("category", category2);
        this.id = i10;
        this.isMature = z10;
        this.title = str;
        this.duration = i11;
        this.thumbnailUrl = str2;
        this.videoUrl = str3;
        this.viewCount = i12;
        this.likesCount = i13;
        this.createdAt = str4;
        this.creator = creator2;
        this.channel = clipChannel;
        this.category = category2;
    }

    public static /* synthetic */ Clip copy$default(Clip clip, int i10, boolean z10, String str, int i11, String str2, String str3, int i12, int i13, String str4, Creator creator2, ClipChannel clipChannel, Category category2, int i14, Object obj) {
        Clip clip2 = clip;
        int i15 = i14;
        return clip.copy((i15 & 1) != 0 ? clip2.id : i10, (i15 & 2) != 0 ? clip2.isMature : z10, (i15 & 4) != 0 ? clip2.title : str, (i15 & 8) != 0 ? clip2.duration : i11, (i15 & 16) != 0 ? clip2.thumbnailUrl : str2, (i15 & 32) != 0 ? clip2.videoUrl : str3, (i15 & 64) != 0 ? clip2.viewCount : i12, (i15 & 128) != 0 ? clip2.likesCount : i13, (i15 & 256) != 0 ? clip2.createdAt : str4, (i15 & 512) != 0 ? clip2.creator : creator2, (i15 & 1024) != 0 ? clip2.channel : clipChannel, (i15 & 2048) != 0 ? clip2.category : category2);
    }

    public final int component1() {
        return this.id;
    }

    public final Creator component10() {
        return this.creator;
    }

    public final ClipChannel component11() {
        return this.channel;
    }

    public final Category component12() {
        return this.category;
    }

    public final boolean component2() {
        return this.isMature;
    }

    public final String component3() {
        return this.title;
    }

    public final int component4() {
        return this.duration;
    }

    public final String component5() {
        return this.thumbnailUrl;
    }

    public final String component6() {
        return this.videoUrl;
    }

    public final int component7() {
        return this.viewCount;
    }

    public final int component8() {
        return this.likesCount;
    }

    public final String component9() {
        return this.createdAt;
    }

    public final Clip copy(int i10, boolean z10, String str, int i11, String str2, String str3, int i12, int i13, String str4, Creator creator2, ClipChannel clipChannel, Category category2) {
        String str5 = str;
        j.f("title", str5);
        String str6 = str2;
        j.f("thumbnailUrl", str6);
        String str7 = str3;
        j.f("videoUrl", str7);
        String str8 = str4;
        j.f("createdAt", str8);
        Creator creator3 = creator2;
        j.f("creator", creator3);
        ClipChannel clipChannel2 = clipChannel;
        j.f("channel", clipChannel2);
        Category category3 = category2;
        j.f("category", category3);
        return new Clip(i10, z10, str5, i11, str6, str7, i12, i13, str8, creator3, clipChannel2, category3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Clip)) {
            return false;
        }
        Clip clip = (Clip) obj;
        return this.id == clip.id && this.isMature == clip.isMature && j.a(this.title, clip.title) && this.duration == clip.duration && j.a(this.thumbnailUrl, clip.thumbnailUrl) && j.a(this.videoUrl, clip.videoUrl) && this.viewCount == clip.viewCount && this.likesCount == clip.likesCount && j.a(this.createdAt, clip.createdAt) && j.a(this.creator, clip.creator) && j.a(this.channel, clip.channel) && j.a(this.category, clip.category);
    }

    public final Category getCategory() {
        return this.category;
    }

    public final ClipChannel getChannel() {
        return this.channel;
    }

    public final String getCreatedAt() {
        return this.createdAt;
    }

    public final Creator getCreator() {
        return this.creator;
    }

    public final int getDuration() {
        return this.duration;
    }

    public final int getId() {
        return this.id;
    }

    public final int getLikesCount() {
        return this.likesCount;
    }

    public final String getThumbnailUrl() {
        return this.thumbnailUrl;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getVideoUrl() {
        return this.videoUrl;
    }

    public final int getViewCount() {
        return this.viewCount;
    }

    public int hashCode() {
        int i10 = this.id * 31;
        boolean z10 = this.isMature;
        if (z10) {
            z10 = true;
        }
        String str = this.title;
        int e10 = h.e(this.thumbnailUrl, (h.e(str, (i10 + (z10 ? 1 : 0)) * 31, 31) + this.duration) * 31, 31);
        int e11 = h.e(this.createdAt, (((h.e(this.videoUrl, e10, 31) + this.viewCount) * 31) + this.likesCount) * 31, 31);
        int hashCode = this.channel.hashCode();
        return this.category.hashCode() + ((hashCode + ((this.creator.hashCode() + e11) * 31)) * 31);
    }

    public final boolean isMature() {
        return this.isMature;
    }

    public String toString() {
        int i10 = this.id;
        boolean z10 = this.isMature;
        String str = this.title;
        int i11 = this.duration;
        String str2 = this.thumbnailUrl;
        String str3 = this.videoUrl;
        int i12 = this.viewCount;
        int i13 = this.likesCount;
        String str4 = this.createdAt;
        Creator creator2 = this.creator;
        ClipChannel clipChannel = this.channel;
        Category category2 = this.category;
        StringBuilder sb2 = new StringBuilder("Clip(id=");
        sb2.append(i10);
        sb2.append(", isMature=");
        sb2.append(z10);
        sb2.append(", title=");
        sb2.append(str);
        sb2.append(", duration=");
        sb2.append(i11);
        sb2.append(", thumbnailUrl=");
        f.k(sb2, str2, ", videoUrl=", str3, ", viewCount=");
        sb2.append(i12);
        sb2.append(", likesCount=");
        sb2.append(i13);
        sb2.append(", createdAt=");
        sb2.append(str4);
        sb2.append(", creator=");
        sb2.append(creator2);
        sb2.append(", channel=");
        sb2.append(clipChannel);
        sb2.append(", category=");
        sb2.append(category2);
        sb2.append(")");
        return sb2.toString();
    }
}
