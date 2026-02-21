package com.github.andreyasadchy.xtra.model.retrofit.kick.v1;

import android.support.v4.media.h;
import java.util.List;
import k9.b;
import xa.j;

public final class PreviousLivestream {
    private final List<CategoriesItem> categories;
    @b("channel_id")
    private final int channelId;
    private final int duration;
    private final Thumbnail thumbnail;
    @b("session_title")
    private final String title;
    private final Video video;
    @b("viewer_count")
    private final int viewerCount;

    public PreviousLivestream(Video video2, List<CategoriesItem> list, int i10, String str, Thumbnail thumbnail2, int i11, int i12) {
        j.f("video", video2);
        j.f("categories", list);
        j.f("title", str);
        j.f("thumbnail", thumbnail2);
        this.video = video2;
        this.categories = list;
        this.channelId = i10;
        this.title = str;
        this.thumbnail = thumbnail2;
        this.viewerCount = i11;
        this.duration = i12;
    }

    public static /* synthetic */ PreviousLivestream copy$default(PreviousLivestream previousLivestream, Video video2, List<CategoriesItem> list, int i10, String str, Thumbnail thumbnail2, int i11, int i12, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            video2 = previousLivestream.video;
        }
        if ((i13 & 2) != 0) {
            list = previousLivestream.categories;
        }
        List<CategoriesItem> list2 = list;
        if ((i13 & 4) != 0) {
            i10 = previousLivestream.channelId;
        }
        int i14 = i10;
        if ((i13 & 8) != 0) {
            str = previousLivestream.title;
        }
        String str2 = str;
        if ((i13 & 16) != 0) {
            thumbnail2 = previousLivestream.thumbnail;
        }
        Thumbnail thumbnail3 = thumbnail2;
        if ((i13 & 32) != 0) {
            i11 = previousLivestream.viewerCount;
        }
        int i15 = i11;
        if ((i13 & 64) != 0) {
            i12 = previousLivestream.duration;
        }
        return previousLivestream.copy(video2, list2, i14, str2, thumbnail3, i15, i12);
    }

    public final Video component1() {
        return this.video;
    }

    public final List<CategoriesItem> component2() {
        return this.categories;
    }

    public final int component3() {
        return this.channelId;
    }

    public final String component4() {
        return this.title;
    }

    public final Thumbnail component5() {
        return this.thumbnail;
    }

    public final int component6() {
        return this.viewerCount;
    }

    public final int component7() {
        return this.duration;
    }

    public final PreviousLivestream copy(Video video2, List<CategoriesItem> list, int i10, String str, Thumbnail thumbnail2, int i11, int i12) {
        j.f("video", video2);
        j.f("categories", list);
        j.f("title", str);
        j.f("thumbnail", thumbnail2);
        return new PreviousLivestream(video2, list, i10, str, thumbnail2, i11, i12);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PreviousLivestream)) {
            return false;
        }
        PreviousLivestream previousLivestream = (PreviousLivestream) obj;
        return j.a(this.video, previousLivestream.video) && j.a(this.categories, previousLivestream.categories) && this.channelId == previousLivestream.channelId && j.a(this.title, previousLivestream.title) && j.a(this.thumbnail, previousLivestream.thumbnail) && this.viewerCount == previousLivestream.viewerCount && this.duration == previousLivestream.duration;
    }

    public final List<CategoriesItem> getCategories() {
        return this.categories;
    }

    public final int getChannelId() {
        return this.channelId;
    }

    public final int getDuration() {
        return this.duration;
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

    public int hashCode() {
        int hashCode = this.categories.hashCode();
        return ((((this.thumbnail.hashCode() + h.e(this.title, (((hashCode + (this.video.hashCode() * 31)) * 31) + this.channelId) * 31, 31)) * 31) + this.viewerCount) * 31) + this.duration;
    }

    public String toString() {
        Video video2 = this.video;
        List<CategoriesItem> list = this.categories;
        int i10 = this.channelId;
        String str = this.title;
        Thumbnail thumbnail2 = this.thumbnail;
        int i11 = this.viewerCount;
        int i12 = this.duration;
        StringBuilder sb2 = new StringBuilder("PreviousLivestream(video=");
        sb2.append(video2);
        sb2.append(", categories=");
        sb2.append(list);
        sb2.append(", channelId=");
        sb2.append(i10);
        sb2.append(", title=");
        sb2.append(str);
        sb2.append(", thumbnail=");
        sb2.append(thumbnail2);
        sb2.append(", viewerCount=");
        sb2.append(i11);
        sb2.append(", duration=");
        return h.o(sb2, i12, ")");
    }
}
