package com.github.andreyasadchy.xtra.model.retrofit.kick.v2;

import android.support.v4.media.h;
import java.util.List;
import xa.j;

public final class Category {
    private final String banner;
    private final int id;
    private final String name;
    private final String slug;
    private final List<String> tags;

    public Category(int i10, String str, String str2, List<String> list, String str3) {
        j.f("name", str);
        j.f("slug", str2);
        this.id = i10;
        this.name = str;
        this.slug = str2;
        this.tags = list;
        this.banner = str3;
    }

    public static /* synthetic */ Category copy$default(Category category, int i10, String str, String str2, List<String> list, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = category.id;
        }
        if ((i11 & 2) != 0) {
            str = category.name;
        }
        String str4 = str;
        if ((i11 & 4) != 0) {
            str2 = category.slug;
        }
        String str5 = str2;
        if ((i11 & 8) != 0) {
            list = category.tags;
        }
        List<String> list2 = list;
        if ((i11 & 16) != 0) {
            str3 = category.banner;
        }
        return category.copy(i10, str4, str5, list2, str3);
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

    public final List<String> component4() {
        return this.tags;
    }

    public final String component5() {
        return this.banner;
    }

    public final Category copy(int i10, String str, String str2, List<String> list, String str3) {
        j.f("name", str);
        j.f("slug", str2);
        return new Category(i10, str, str2, list, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Category)) {
            return false;
        }
        Category category = (Category) obj;
        return this.id == category.id && j.a(this.name, category.name) && j.a(this.slug, category.slug) && j.a(this.tags, category.tags) && j.a(this.banner, category.banner);
    }

    public final String getBanner() {
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

    public int hashCode() {
        int i10;
        int e10 = h.e(this.slug, h.e(this.name, this.id * 31, 31), 31);
        List<String> list = this.tags;
        int i11 = 0;
        if (list == null) {
            i10 = 0;
        } else {
            i10 = list.hashCode();
        }
        int i12 = (e10 + i10) * 31;
        String str = this.banner;
        if (str != null) {
            i11 = str.hashCode();
        }
        return i12 + i11;
    }

    public String toString() {
        int i10 = this.id;
        String str = this.name;
        String str2 = this.slug;
        List<String> list = this.tags;
        String str3 = this.banner;
        StringBuilder sb2 = new StringBuilder("Category(id=");
        sb2.append(i10);
        sb2.append(", name=");
        sb2.append(str);
        sb2.append(", slug=");
        sb2.append(str2);
        sb2.append(", tags=");
        sb2.append(list);
        sb2.append(", banner=");
        return h.p(sb2, str3, ")");
    }
}
