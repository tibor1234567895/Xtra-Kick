package com.github.andreyasadchy.xtra.model.retrofit.kick.v1;

import android.support.v4.media.h;
import xa.j;

public final class Category {
    private final int id;
    private final String name;
    private final String slug;

    public Category(int i10, String str, String str2) {
        j.f("name", str);
        j.f("slug", str2);
        this.id = i10;
        this.name = str;
        this.slug = str2;
    }

    public static /* synthetic */ Category copy$default(Category category, int i10, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = category.id;
        }
        if ((i11 & 2) != 0) {
            str = category.name;
        }
        if ((i11 & 4) != 0) {
            str2 = category.slug;
        }
        return category.copy(i10, str, str2);
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

    public final Category copy(int i10, String str, String str2) {
        j.f("name", str);
        j.f("slug", str2);
        return new Category(i10, str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Category)) {
            return false;
        }
        Category category = (Category) obj;
        return this.id == category.id && j.a(this.name, category.name) && j.a(this.slug, category.slug);
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

    public int hashCode() {
        return this.slug.hashCode() + h.e(this.name, this.id * 31, 31);
    }

    public String toString() {
        int i10 = this.id;
        String str = this.name;
        String str2 = this.slug;
        StringBuilder sb2 = new StringBuilder("Category(id=");
        sb2.append(i10);
        sb2.append(", name=");
        sb2.append(str);
        sb2.append(", slug=");
        return h.p(sb2, str2, ")");
    }
}
