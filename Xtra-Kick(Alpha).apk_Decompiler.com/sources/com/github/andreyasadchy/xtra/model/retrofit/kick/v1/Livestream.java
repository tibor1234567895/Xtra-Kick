package com.github.andreyasadchy.xtra.model.retrofit.kick.v1;

import android.support.v4.media.h;
import java.util.List;
import k9.b;
import xa.f;
import xa.j;

public final class Livestream {
    private final List<CategoriesItem> categories;
    @b("channel_id")
    private final int channelId;
    @b("created_at")
    private final String createdAt;
    private final int duration;
    private final int id;
    private final String language;
    @b("is_live")
    private final boolean live;
    @b("is_mature")
    private final boolean mature;
    @b("playback_url")
    private final String playbackUrl;
    private final String slug;
    private final List<String> tags;
    private final Thumbnail thumbnail;
    @b("session_title")
    private final String title;
    private final Video video;
    @b("viewer_count")
    private final int viewerCount;
    private final int views;

    public Livestream(int i10, String str, int i11, String str2, String str3, boolean z10, int i12, String str4, boolean z11, int i13, Thumbnail thumbnail2, int i14, List<String> list, List<CategoriesItem> list2, String str5, Video video2) {
        String str6 = str4;
        Thumbnail thumbnail3 = thumbnail2;
        List<String> list3 = list;
        List<CategoriesItem> list4 = list2;
        Video video3 = video2;
        j.f("slug", str);
        j.f("createdAt", str2);
        j.f("title", str3);
        j.f("language", str6);
        j.f("thumbnail", thumbnail3);
        j.f("tags", list3);
        j.f("categories", list4);
        j.f("video", video3);
        this.id = i10;
        this.slug = str;
        this.channelId = i11;
        this.createdAt = str2;
        this.title = str3;
        this.live = z10;
        this.duration = i12;
        this.language = str6;
        this.mature = z11;
        this.viewerCount = i13;
        this.thumbnail = thumbnail3;
        this.views = i14;
        this.tags = list3;
        this.categories = list4;
        this.playbackUrl = str5;
        this.video = video3;
    }

    public static /* synthetic */ Livestream copy$default(Livestream livestream, int i10, String str, int i11, String str2, String str3, boolean z10, int i12, String str4, boolean z11, int i13, Thumbnail thumbnail2, int i14, List list, List list2, String str5, Video video2, int i15, Object obj) {
        Livestream livestream2 = livestream;
        int i16 = i15;
        return livestream.copy((i16 & 1) != 0 ? livestream2.id : i10, (i16 & 2) != 0 ? livestream2.slug : str, (i16 & 4) != 0 ? livestream2.channelId : i11, (i16 & 8) != 0 ? livestream2.createdAt : str2, (i16 & 16) != 0 ? livestream2.title : str3, (i16 & 32) != 0 ? livestream2.live : z10, (i16 & 64) != 0 ? livestream2.duration : i12, (i16 & 128) != 0 ? livestream2.language : str4, (i16 & 256) != 0 ? livestream2.mature : z11, (i16 & 512) != 0 ? livestream2.viewerCount : i13, (i16 & 1024) != 0 ? livestream2.thumbnail : thumbnail2, (i16 & 2048) != 0 ? livestream2.views : i14, (i16 & 4096) != 0 ? livestream2.tags : list, (i16 & 8192) != 0 ? livestream2.categories : list2, (i16 & 16384) != 0 ? livestream2.playbackUrl : str5, (i16 & 32768) != 0 ? livestream2.video : video2);
    }

    public final int component1() {
        return this.id;
    }

    public final int component10() {
        return this.viewerCount;
    }

    public final Thumbnail component11() {
        return this.thumbnail;
    }

    public final int component12() {
        return this.views;
    }

    public final List<String> component13() {
        return this.tags;
    }

    public final List<CategoriesItem> component14() {
        return this.categories;
    }

    public final String component15() {
        return this.playbackUrl;
    }

    public final Video component16() {
        return this.video;
    }

    public final String component2() {
        return this.slug;
    }

    public final int component3() {
        return this.channelId;
    }

    public final String component4() {
        return this.createdAt;
    }

    public final String component5() {
        return this.title;
    }

    public final boolean component6() {
        return this.live;
    }

    public final int component7() {
        return this.duration;
    }

    public final String component8() {
        return this.language;
    }

    public final boolean component9() {
        return this.mature;
    }

    public final Livestream copy(int i10, String str, int i11, String str2, String str3, boolean z10, int i12, String str4, boolean z11, int i13, Thumbnail thumbnail2, int i14, List<String> list, List<CategoriesItem> list2, String str5, Video video2) {
        int i15 = i10;
        j.f("slug", str);
        j.f("createdAt", str2);
        j.f("title", str3);
        j.f("language", str4);
        j.f("thumbnail", thumbnail2);
        j.f("tags", list);
        j.f("categories", list2);
        j.f("video", video2);
        return new Livestream(i10, str, i11, str2, str3, z10, i12, str4, z11, i13, thumbnail2, i14, list, list2, str5, video2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Livestream)) {
            return false;
        }
        Livestream livestream = (Livestream) obj;
        return this.id == livestream.id && j.a(this.slug, livestream.slug) && this.channelId == livestream.channelId && j.a(this.createdAt, livestream.createdAt) && j.a(this.title, livestream.title) && this.live == livestream.live && this.duration == livestream.duration && j.a(this.language, livestream.language) && this.mature == livestream.mature && this.viewerCount == livestream.viewerCount && j.a(this.thumbnail, livestream.thumbnail) && this.views == livestream.views && j.a(this.tags, livestream.tags) && j.a(this.categories, livestream.categories) && j.a(this.playbackUrl, livestream.playbackUrl) && j.a(this.video, livestream.video);
    }

    public final List<CategoriesItem> getCategories() {
        return this.categories;
    }

    public final int getChannelId() {
        return this.channelId;
    }

    public final String getCreatedAt() {
        return this.createdAt;
    }

    public final int getDuration() {
        return this.duration;
    }

    public final int getId() {
        return this.id;
    }

    public final String getLanguage() {
        return this.language;
    }

    public final boolean getLive() {
        return this.live;
    }

    public final boolean getMature() {
        return this.mature;
    }

    public final String getPlaybackUrl() {
        return this.playbackUrl;
    }

    public final String getSlug() {
        return this.slug;
    }

    public final List<String> getTags() {
        return this.tags;
    }

    public final Thumbnail getThumbnail() {
        return this.thumbnail;
    }

    public final String getTitle() {
        return this.title;
    }

    public final Video getVideo() {
        return this.video;
    }

    public final int getViewerCount() {
        return this.viewerCount;
    }

    public final int getViews() {
        return this.views;
    }

    public int hashCode() {
        int i10;
        String str = this.slug;
        int e10 = h.e(this.title, h.e(this.createdAt, (h.e(str, this.id * 31, 31) + this.channelId) * 31, 31), 31);
        boolean z10 = this.live;
        boolean z11 = true;
        if (z10) {
            z10 = true;
        }
        int e11 = h.e(this.language, (((e10 + (z10 ? 1 : 0)) * 31) + this.duration) * 31, 31);
        boolean z12 = this.mature;
        if (!z12) {
            z11 = z12;
        }
        int hashCode = this.thumbnail.hashCode();
        int hashCode2 = this.tags.hashCode();
        int hashCode3 = (this.categories.hashCode() + ((hashCode2 + ((((hashCode + ((((e11 + (z11 ? 1 : 0)) * 31) + this.viewerCount) * 31)) * 31) + this.views) * 31)) * 31)) * 31;
        String str2 = this.playbackUrl;
        if (str2 == null) {
            i10 = 0;
        } else {
            i10 = str2.hashCode();
        }
        return this.video.hashCode() + ((hashCode3 + i10) * 31);
    }

    public String toString() {
        int i10 = this.id;
        String str = this.slug;
        int i11 = this.channelId;
        String str2 = this.createdAt;
        String str3 = this.title;
        boolean z10 = this.live;
        int i12 = this.duration;
        String str4 = this.language;
        boolean z11 = this.mature;
        int i13 = this.viewerCount;
        Thumbnail thumbnail2 = this.thumbnail;
        int i14 = this.views;
        List<String> list = this.tags;
        List<CategoriesItem> list2 = this.categories;
        String str5 = this.playbackUrl;
        return "Livestream(id=" + i10 + ", slug=" + str + ", channelId=" + i11 + ", createdAt=" + str2 + ", title=" + str3 + ", live=" + z10 + ", duration=" + i12 + ", language=" + str4 + ", mature=" + z11 + ", viewerCount=" + i13 + ", thumbnail=" + thumbnail2 + ", views=" + i14 + ", tags=" + list + ", categories=" + list2 + ", playbackUrl=" + str5 + ", video=" + this.video + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Livestream(int i10, String str, int i11, String str2, String str3, boolean z10, int i12, String str4, boolean z11, int i13, Thumbnail thumbnail2, int i14, List list, List list2, String str5, Video video2, int i15, f fVar) {
        this(i10, str, i11, str2, str3, z10, i12, str4, z11, i13, thumbnail2, i14, list, list2, (i15 & 16384) != 0 ? null : str5, video2);
    }
}
