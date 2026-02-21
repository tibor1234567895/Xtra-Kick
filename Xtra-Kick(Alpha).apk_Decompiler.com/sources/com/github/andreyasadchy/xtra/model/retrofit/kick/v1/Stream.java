package com.github.andreyasadchy.xtra.model.retrofit.kick.v1;

import android.support.v4.media.h;
import java.util.List;
import k9.b;
import xa.j;

public final class Stream {
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
    private final String source;
    private final Thumbnail thumbnail;
    @b("session_title")
    private final String title;
    @b("viewer_count")
    private final int viewerCount;
    private final int viewers;

    public Stream(int i10, String str, int i11, String str2, String str3, boolean z10, int i12, String str4, Channel channel2, List<CategoriesItem> list, boolean z11, String str5, Thumbnail thumbnail2, int i13, int i14) {
        String str6 = str4;
        Channel channel3 = channel2;
        List<CategoriesItem> list2 = list;
        Thumbnail thumbnail3 = thumbnail2;
        j.f("slug", str);
        j.f("createdAt", str2);
        j.f("title", str3);
        j.f("language", str6);
        j.f("channel", channel3);
        j.f("categories", list2);
        j.f("thumbnail", thumbnail3);
        this.id = i10;
        this.slug = str;
        this.channelId = i11;
        this.createdAt = str2;
        this.title = str3;
        this.live = z10;
        this.duration = i12;
        this.language = str6;
        this.channel = channel3;
        this.categories = list2;
        this.mature = z11;
        this.source = str5;
        this.thumbnail = thumbnail3;
        this.viewerCount = i13;
        this.viewers = i14;
    }

    public static /* synthetic */ Stream copy$default(Stream stream, int i10, String str, int i11, String str2, String str3, boolean z10, int i12, String str4, Channel channel2, List list, boolean z11, String str5, Thumbnail thumbnail2, int i13, int i14, int i15, Object obj) {
        Stream stream2 = stream;
        int i16 = i15;
        return stream.copy((i16 & 1) != 0 ? stream2.id : i10, (i16 & 2) != 0 ? stream2.slug : str, (i16 & 4) != 0 ? stream2.channelId : i11, (i16 & 8) != 0 ? stream2.createdAt : str2, (i16 & 16) != 0 ? stream2.title : str3, (i16 & 32) != 0 ? stream2.live : z10, (i16 & 64) != 0 ? stream2.duration : i12, (i16 & 128) != 0 ? stream2.language : str4, (i16 & 256) != 0 ? stream2.channel : channel2, (i16 & 512) != 0 ? stream2.categories : list, (i16 & 1024) != 0 ? stream2.mature : z11, (i16 & 2048) != 0 ? stream2.source : str5, (i16 & 4096) != 0 ? stream2.thumbnail : thumbnail2, (i16 & 8192) != 0 ? stream2.viewerCount : i13, (i16 & 16384) != 0 ? stream2.viewers : i14);
    }

    public final int component1() {
        return this.id;
    }

    public final List<CategoriesItem> component10() {
        return this.categories;
    }

    public final boolean component11() {
        return this.mature;
    }

    public final String component12() {
        return this.source;
    }

    public final Thumbnail component13() {
        return this.thumbnail;
    }

    public final int component14() {
        return this.viewerCount;
    }

    public final int component15() {
        return this.viewers;
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

    public final Channel component9() {
        return this.channel;
    }

    public final Stream copy(int i10, String str, int i11, String str2, String str3, boolean z10, int i12, String str4, Channel channel2, List<CategoriesItem> list, boolean z11, String str5, Thumbnail thumbnail2, int i13, int i14) {
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
        Thumbnail thumbnail3 = thumbnail2;
        j.f("thumbnail", thumbnail3);
        return new Stream(i10, str6, i11, str7, str8, z10, i12, str9, channel3, list2, z11, str5, thumbnail3, i13, i14);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Stream)) {
            return false;
        }
        Stream stream = (Stream) obj;
        return this.id == stream.id && j.a(this.slug, stream.slug) && this.channelId == stream.channelId && j.a(this.createdAt, stream.createdAt) && j.a(this.title, stream.title) && this.live == stream.live && this.duration == stream.duration && j.a(this.language, stream.language) && j.a(this.channel, stream.channel) && j.a(this.categories, stream.categories) && this.mature == stream.mature && j.a(this.source, stream.source) && j.a(this.thumbnail, stream.thumbnail) && this.viewerCount == stream.viewerCount && this.viewers == stream.viewers;
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

    public final String getSource() {
        return this.source;
    }

    public final Thumbnail getThumbnail() {
        return this.thumbnail;
    }

    public final String getTitle() {
        return this.title;
    }

    public final int getViewerCount() {
        return this.viewerCount;
    }

    public final int getViewers() {
        return this.viewers;
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
        int hashCode = (this.categories.hashCode() + ((this.channel.hashCode() + e11) * 31)) * 31;
        boolean z12 = this.mature;
        if (!z12) {
            z11 = z12;
        }
        int i11 = (hashCode + (z11 ? 1 : 0)) * 31;
        String str2 = this.source;
        if (str2 == null) {
            i10 = 0;
        } else {
            i10 = str2.hashCode();
        }
        return ((((this.thumbnail.hashCode() + ((i11 + i10) * 31)) * 31) + this.viewerCount) * 31) + this.viewers;
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
        Channel channel2 = this.channel;
        List<CategoriesItem> list = this.categories;
        boolean z11 = this.mature;
        String str5 = this.source;
        Thumbnail thumbnail2 = this.thumbnail;
        int i13 = this.viewerCount;
        StringBuilder sb2 = new StringBuilder("Stream(id=");
        sb2.append(i10);
        sb2.append(", slug=");
        sb2.append(str);
        sb2.append(", channelId=");
        sb2.append(i11);
        sb2.append(", createdAt=");
        sb2.append(str2);
        sb2.append(", title=");
        sb2.append(str3);
        sb2.append(", live=");
        sb2.append(z10);
        sb2.append(", duration=");
        sb2.append(i12);
        sb2.append(", language=");
        sb2.append(str4);
        sb2.append(", channel=");
        sb2.append(channel2);
        sb2.append(", categories=");
        sb2.append(list);
        sb2.append(", mature=");
        sb2.append(z11);
        sb2.append(", source=");
        sb2.append(str5);
        sb2.append(", thumbnail=");
        sb2.append(thumbnail2);
        sb2.append(", viewerCount=");
        sb2.append(i13);
        sb2.append(", viewers=");
        return h.o(sb2, this.viewers, ")");
    }
}
