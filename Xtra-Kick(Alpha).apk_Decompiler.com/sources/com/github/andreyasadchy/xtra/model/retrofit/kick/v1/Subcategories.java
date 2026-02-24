package com.github.andreyasadchy.xtra.model.retrofit.kick.v1;

import android.support.v4.media.h;
import java.util.List;
import xa.j;

public final class Subcategories {
    private final CategoryBanner banner;
    private final int id;
    private final String name;
    private final String slug;
    private final List<String> tags;
    private final int viewers;

    public Subcategories(int i10, String str, String str2, CategoryBanner categoryBanner, int i11, List<String> list) {
        j.f("name", str);
        j.f("slug", str2);
        j.f("banner", categoryBanner);
        j.f("tags", list);
        this.id = i10;
        this.name = str;
        this.slug = str2;
        this.banner = categoryBanner;
        this.viewers = i11;
        this.tags = list;
    }

    public static /* synthetic */ Subcategories copy$default(Subcategories subcategories, int i10, String str, String str2, CategoryBanner categoryBanner, int i11, List<String> list, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = subcategories.id;
        }
        if ((i12 & 2) != 0) {
            str = subcategories.name;
        }
        String str3 = str;
        if ((i12 & 4) != 0) {
            str2 = subcategories.slug;
        }
        String str4 = str2;
        if ((i12 & 8) != 0) {
            categoryBanner = subcategories.banner;
        }
        CategoryBanner categoryBanner2 = categoryBanner;
        if ((i12 & 16) != 0) {
            i11 = subcategories.viewers;
        }
        int i13 = i11;
        if ((i12 & 32) != 0) {
            list = subcategories.tags;
        }
        return subcategories.copy(i10, str3, str4, categoryBanner2, i13, list);
    }

    public final int component1() {
        return this.id;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.slug;
    }

    public final CategoryBanner component4() {
        return this.banner;
    }

    public final int component5() {
        return this.viewers;
    }

    public final List<String> component6() {
        return this.tags;
    }

    public final Subcategories copy(int i10, String str, String str2, CategoryBanner categoryBanner, int i11, List<String> list) {
        j.f("name", str);
        j.f("slug", str2);
        j.f("banner", categoryBanner);
        j.f("tags", list);
        return new Subcategories(i10, str, str2, categoryBanner, i11, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Subcategories)) {
            return false;
        }
        Subcategories subcategories = (Subcategories) obj;
        return this.id == subcategories.id && j.a(this.name, subcategories.name) && j.a(this.slug, subcategories.slug) && j.a(this.banner, subcategories.banner) && this.viewers == subcategories.viewers && j.a(this.tags, subcategories.tags);
    }

    public final CategoryBanner getBanner() {
        return this.banner;
    }

    public final int getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getSlug() {
        return this.slug;
    }

    public final List<String> getTags() {
        return this.tags;
    }

    public final int getViewers() {
        return this.viewers;
    }

    public int hashCode() {
        int e10 = h.e(this.slug, h.e(this.name, this.id * 31, 31), 31);
        return this.tags.hashCode() + ((((this.banner.hashCode() + e10) * 31) + this.viewers) * 31);
    }

    public String toString() {
        int i10 = this.id;
        String str = this.name;
        String str2 = this.slug;
        CategoryBanner categoryBanner = this.banner;
        int i11 = this.viewers;
        List<String> list = this.tags;
        return "Subcategories(id=" + i10 + ", name=" + str + ", slug=" + str2 + ", banner=" + categoryBanner + ", viewers=" + i11 + ", tags=" + list + ")";
    }
}
