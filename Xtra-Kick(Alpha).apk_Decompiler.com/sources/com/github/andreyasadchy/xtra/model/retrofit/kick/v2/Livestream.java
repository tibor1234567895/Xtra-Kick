package com.github.andreyasadchy.xtra.model.retrofit.kick.v2;

import android.support.v4.media.h;
import java.util.List;
import k9.b;
import q0.f;
import xa.j;

public final class Livestream {
    private final List<CategoriesItem> categories;
    private final Category category;
    @b("created_at")
    private final String createdAt;
    private final int id;
    @b("is_live")
    private final boolean isLive;
    @b("is_mature")
    private final boolean isMature;
    private final String language;
    @b("playback_url")
    private final String playbackUrl;
    private final String slug;
    private final Thumbnail thumbnail;
    @b("session_title")
    private final String title;
    @b("viewer_count")
    private final int viewers;

    public Livestream(int i10, String str, String str2, String str3, String str4, boolean z10, boolean z11, int i11, Category category2, List<CategoriesItem> list, String str5, Thumbnail thumbnail2) {
        j.f("slug", str);
        j.f("title", str2);
        j.f("createdAt", str3);
        j.f("language", str4);
        j.f("category", category2);
        j.f("categories", list);
        j.f("playbackUrl", str5);
        j.f("thumbnail", thumbnail2);
        this.id = i10;
        this.slug = str;
        this.title = str2;
        this.createdAt = str3;
        this.language = str4;
        this.isMature = z10;
        this.isLive = z11;
        this.viewers = i11;
        this.category = category2;
        this.categories = list;
        this.playbackUrl = str5;
        this.thumbnail = thumbnail2;
    }

    public static /* synthetic */ Livestream copy$default(Livestream livestream, int i10, String str, String str2, String str3, String str4, boolean z10, boolean z11, int i11, Category category2, List list, String str5, Thumbnail thumbnail2, int i12, Object obj) {
        Livestream livestream2 = livestream;
        int i13 = i12;
        return livestream.copy((i13 & 1) != 0 ? livestream2.id : i10, (i13 & 2) != 0 ? livestream2.slug : str, (i13 & 4) != 0 ? livestream2.title : str2, (i13 & 8) != 0 ? livestream2.createdAt : str3, (i13 & 16) != 0 ? livestream2.language : str4, (i13 & 32) != 0 ? livestream2.isMature : z10, (i13 & 64) != 0 ? livestream2.isLive : z11, (i13 & 128) != 0 ? livestream2.viewers : i11, (i13 & 256) != 0 ? livestream2.category : category2, (i13 & 512) != 0 ? livestream2.categories : list, (i13 & 1024) != 0 ? livestream2.playbackUrl : str5, (i13 & 2048) != 0 ? livestream2.thumbnail : thumbnail2);
    }

    public final int component1() {
        return this.id;
    }

    public final List<CategoriesItem> component10() {
        return this.categories;
    }

    public final String component11() {
        return this.playbackUrl;
    }

    public final Thumbnail component12() {
        return this.thumbnail;
    }

    public final String component2() {
        return this.slug;
    }

    public final String component3() {
        return this.title;
    }

    public final String component4() {
        return this.createdAt;
    }

    public final String component5() {
        return this.language;
    }

    public final boolean component6() {
        return this.isMature;
    }

    public final boolean component7() {
        return this.isLive;
    }

    public final int component8() {
        return this.viewers;
    }

    public final Category component9() {
        return this.category;
    }

    public final Livestream copy(int i10, String str, String str2, String str3, String str4, boolean z10, boolean z11, int i11, Category category2, List<CategoriesItem> list, String str5, Thumbnail thumbnail2) {
        String str6 = str;
        j.f("slug", str6);
        String str7 = str2;
        j.f("title", str7);
        String str8 = str3;
        j.f("createdAt", str8);
        String str9 = str4;
        j.f("language", str9);
        Category category3 = category2;
        j.f("category", category3);
        List<CategoriesItem> list2 = list;
        j.f("categories", list2);
        String str10 = str5;
        j.f("playbackUrl", str10);
        Thumbnail thumbnail3 = thumbnail2;
        j.f("thumbnail", thumbnail3);
        return new Livestream(i10, str6, str7, str8, str9, z10, z11, i11, category3, list2, str10, thumbnail3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Livestream)) {
            return false;
        }
        Livestream livestream = (Livestream) obj;
        return this.id == livestream.id && j.a(this.slug, livestream.slug) && j.a(this.title, livestream.title) && j.a(this.createdAt, livestream.createdAt) && j.a(this.language, livestream.language) && this.isMature == livestream.isMature && this.isLive == livestream.isLive && this.viewers == livestream.viewers && j.a(this.category, livestream.category) && j.a(this.categories, livestream.categories) && j.a(this.playbackUrl, livestream.playbackUrl) && j.a(this.thumbnail, livestream.thumbnail);
    }

    public final List<CategoriesItem> getCategories() {
        return this.categories;
    }

    public final Category getCategory() {
        return this.category;
    }

    public final String getCreatedAt() {
        return this.createdAt;
    }

    public final int getId() {
        return this.id;
    }

    public final String getLanguage() {
        return this.language;
    }

    public final String getPlaybackUrl() {
        return this.playbackUrl;
    }

    public final String getSlug() {
        return this.slug;
    }

    public final Thumbnail getThumbnail() {
        return this.thumbnail;
    }

    public final String getTitle() {
        return this.title;
    }

    public final int getViewers() {
        return this.viewers;
    }

    public int hashCode() {
        int e10 = h.e(this.language, h.e(this.createdAt, h.e(this.title, h.e(this.slug, this.id * 31, 31), 31), 31), 31);
        boolean z10 = this.isMature;
        boolean z11 = true;
        if (z10) {
            z10 = true;
        }
        int i10 = (e10 + (z10 ? 1 : 0)) * 31;
        boolean z12 = this.isLive;
        if (!z12) {
            z11 = z12;
        }
        int hashCode = this.category.hashCode();
        int hashCode2 = this.categories.hashCode();
        return this.thumbnail.hashCode() + h.e(this.playbackUrl, (hashCode2 + ((hashCode + ((((i10 + (z11 ? 1 : 0)) * 31) + this.viewers) * 31)) * 31)) * 31, 31);
    }

    public final boolean isLive() {
        return this.isLive;
    }

    public final boolean isMature() {
        return this.isMature;
    }

    public String toString() {
        int i10 = this.id;
        String str = this.slug;
        String str2 = this.title;
        String str3 = this.createdAt;
        String str4 = this.language;
        boolean z10 = this.isMature;
        boolean z11 = this.isLive;
        int i11 = this.viewers;
        Category category2 = this.category;
        List<CategoriesItem> list = this.categories;
        String str5 = this.playbackUrl;
        Thumbnail thumbnail2 = this.thumbnail;
        StringBuilder sb2 = new StringBuilder("Livestream(id=");
        sb2.append(i10);
        sb2.append(", slug=");
        sb2.append(str);
        sb2.append(", title=");
        f.k(sb2, str2, ", createdAt=", str3, ", language=");
        sb2.append(str4);
        sb2.append(", isMature=");
        sb2.append(z10);
        sb2.append(", isLive=");
        sb2.append(z11);
        sb2.append(", viewers=");
        sb2.append(i11);
        sb2.append(", category=");
        sb2.append(category2);
        sb2.append(", categories=");
        sb2.append(list);
        sb2.append(", playbackUrl=");
        sb2.append(str5);
        sb2.append(", thumbnail=");
        sb2.append(thumbnail2);
        sb2.append(")");
        return sb2.toString();
    }
}
