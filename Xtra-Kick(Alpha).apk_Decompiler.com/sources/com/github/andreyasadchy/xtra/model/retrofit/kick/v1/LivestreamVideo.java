package com.github.andreyasadchy.xtra.model.retrofit.kick.v1;

import android.support.v4.media.h;
import java.util.List;
import k9.b;
import xa.j;

public final class LivestreamVideo {
    private final List<CategoriesItem> categories;
    private final Channel channel;
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
    private final String slug;
    private final String thumbnail;
    @b("session_title")
    private final String title;
    @b("viewer_count")
    private final int viewerCount;

    public LivestreamVideo(int i10, String str, int i11, String str2, String str3, boolean z10, int i12, String str4, boolean z11, int i13, String str5, Channel channel2, List<CategoriesItem> list) {
        j.f("slug", str);
        j.f("createdAt", str2);
        j.f("title", str3);
        j.f("language", str4);
        j.f("channel", channel2);
        j.f("categories", list);
        this.id = i10;
        this.slug = str;
        this.channelId = i11;
        this.createdAt = str2;
        this.title = str3;
        this.live = z10;
        this.duration = i12;
        this.language = str4;
        this.mature = z11;
        this.viewerCount = i13;
        this.thumbnail = str5;
        this.channel = channel2;
        this.categories = list;
    }

    public static /* synthetic */ LivestreamVideo copy$default(LivestreamVideo livestreamVideo, int i10, String str, int i11, String str2, String str3, boolean z10, int i12, String str4, boolean z11, int i13, String str5, Channel channel2, List list, int i14, Object obj) {
        LivestreamVideo livestreamVideo2 = livestreamVideo;
        int i15 = i14;
        return livestreamVideo.copy((i15 & 1) != 0 ? livestreamVideo2.id : i10, (i15 & 2) != 0 ? livestreamVideo2.slug : str, (i15 & 4) != 0 ? livestreamVideo2.channelId : i11, (i15 & 8) != 0 ? livestreamVideo2.createdAt : str2, (i15 & 16) != 0 ? livestreamVideo2.title : str3, (i15 & 32) != 0 ? livestreamVideo2.live : z10, (i15 & 64) != 0 ? livestreamVideo2.duration : i12, (i15 & 128) != 0 ? livestreamVideo2.language : str4, (i15 & 256) != 0 ? livestreamVideo2.mature : z11, (i15 & 512) != 0 ? livestreamVideo2.viewerCount : i13, (i15 & 1024) != 0 ? livestreamVideo2.thumbnail : str5, (i15 & 2048) != 0 ? livestreamVideo2.channel : channel2, (i15 & 4096) != 0 ? livestreamVideo2.categories : list);
    }

    public final int component1() {
        return this.id;
    }

    public final int component10() {
        return this.viewerCount;
    }

    public final String component11() {
        return this.thumbnail;
    }

    public final Channel component12() {
        return this.channel;
    }

    public final List<CategoriesItem> component13() {
        return this.categories;
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

    public final LivestreamVideo copy(int i10, String str, int i11, String str2, String str3, boolean z10, int i12, String str4, boolean z11, int i13, String str5, Channel channel2, List<CategoriesItem> list) {
        String str6 = str;
        j.f("slug", str6);
        String str7 = str2;
        j.f("createdAt", str7);
        String str8 = str3;
        j.f("title", str8);
        String str9 = str4;
        j.f("language", str9);
        Channel channel3 = channel2;
        j.f("channel", channel3);
        List<CategoriesItem> list2 = list;
        j.f("categories", list2);
        return new LivestreamVideo(i10, str6, i11, str7, str8, z10, i12, str9, z11, i13, str5, channel3, list2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LivestreamVideo)) {
            return false;
        }
        LivestreamVideo livestreamVideo = (LivestreamVideo) obj;
        return this.id == livestreamVideo.id && j.a(this.slug, livestreamVideo.slug) && this.channelId == livestreamVideo.channelId && j.a(this.createdAt, livestreamVideo.createdAt) && j.a(this.title, livestreamVideo.title) && this.live == livestreamVideo.live && this.duration == livestreamVideo.duration && j.a(this.language, livestreamVideo.language) && this.mature == livestreamVideo.mature && this.viewerCount == livestreamVideo.viewerCount && j.a(this.thumbnail, livestreamVideo.thumbnail) && j.a(this.channel, livestreamVideo.channel) && j.a(this.categories, livestreamVideo.categories);
    }

    public final List<CategoriesItem> getCategories() {
        return this.categories;
    }

    public final Channel getChannel() {
        return this.channel;
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

    public final String getSlug() {
        return this.slug;
    }

    public final String getThumbnail() {
        return this.thumbnail;
    }

    public final String getTitle() {
        return this.title;
    }

    public final int getViewerCount() {
        return this.viewerCount;
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
        int i11 = (((e11 + (z11 ? 1 : 0)) * 31) + this.viewerCount) * 31;
        String str2 = this.thumbnail;
        if (str2 == null) {
            i10 = 0;
        } else {
            i10 = str2.hashCode();
        }
        int hashCode = this.channel.hashCode();
        return this.categories.hashCode() + ((hashCode + ((i11 + i10) * 31)) * 31);
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
        String str5 = this.thumbnail;
        Channel channel2 = this.channel;
        List<CategoriesItem> list = this.categories;
        return "LivestreamVideo(id=" + i10 + ", slug=" + str + ", channelId=" + i11 + ", createdAt=" + str2 + ", title=" + str3 + ", live=" + z10 + ", duration=" + i12 + ", language=" + str4 + ", mature=" + z11 + ", viewerCount=" + i13 + ", thumbnail=" + str5 + ", channel=" + channel2 + ", categories=" + list + ")";
    }
}
