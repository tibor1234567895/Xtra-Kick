package com.github.andreyasadchy.xtra.model.retrofit.kick.v2;

import android.support.v4.media.h;
import java.util.List;
import q0.f;
import xa.j;

public final class CategoriesItem {
    private final Category category;
    private final int category_id;
    private final String description;
    private final int id;
    private final String name;
    private final String slug;
    private final List<String> tags;
    private final int viewers;

    public CategoriesItem(int i10, int i11, String str, String str2, List<String> list, String str3, int i12, Category category2) {
        j.f("name", str);
        j.f("slug", str2);
        j.f("tags", list);
        j.f("description", str3);
        j.f("category", category2);
        this.id = i10;
        this.category_id = i11;
        this.name = str;
        this.slug = str2;
        this.tags = list;
        this.description = str3;
        this.viewers = i12;
        this.category = category2;
    }

    public static /* synthetic */ CategoriesItem copy$default(CategoriesItem categoriesItem, int i10, int i11, String str, String str2, List list, String str3, int i12, Category category2, int i13, Object obj) {
        CategoriesItem categoriesItem2 = categoriesItem;
        int i14 = i13;
        return categoriesItem.copy((i14 & 1) != 0 ? categoriesItem2.id : i10, (i14 & 2) != 0 ? categoriesItem2.category_id : i11, (i14 & 4) != 0 ? categoriesItem2.name : str, (i14 & 8) != 0 ? categoriesItem2.slug : str2, (i14 & 16) != 0 ? categoriesItem2.tags : list, (i14 & 32) != 0 ? categoriesItem2.description : str3, (i14 & 64) != 0 ? categoriesItem2.viewers : i12, (i14 & 128) != 0 ? categoriesItem2.category : category2);
    }

    public final int component1() {
        return this.id;
    }

    public final int component2() {
        return this.category_id;
    }

    public final String component3() {
        return this.name;
    }

    public final String component4() {
        return this.slug;
    }

    public final List<String> component5() {
        return this.tags;
    }

    public final String component6() {
        return this.description;
    }

    public final int component7() {
        return this.viewers;
    }

    public final Category component8() {
        return this.category;
    }

    public final CategoriesItem copy(int i10, int i11, String str, String str2, List<String> list, String str3, int i12, Category category2) {
        j.f("name", str);
        j.f("slug", str2);
        j.f("tags", list);
        String str4 = str3;
        j.f("description", str4);
        Category category3 = category2;
        j.f("category", category3);
        return new CategoriesItem(i10, i11, str, str2, list, str4, i12, category3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CategoriesItem)) {
            return false;
        }
        CategoriesItem categoriesItem = (CategoriesItem) obj;
        return this.id == categoriesItem.id && this.category_id == categoriesItem.category_id && j.a(this.name, categoriesItem.name) && j.a(this.slug, categoriesItem.slug) && j.a(this.tags, categoriesItem.tags) && j.a(this.description, categoriesItem.description) && this.viewers == categoriesItem.viewers && j.a(this.category, categoriesItem.category);
    }

    public final Category getCategory() {
        return this.category;
    }

    public final int getCategory_id() {
        return this.category_id;
    }

    public final String getDescription() {
        return this.description;
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
        int e10 = h.e(this.slug, h.e(this.name, ((this.id * 31) + this.category_id) * 31, 31), 31);
        String str = this.description;
        return this.category.hashCode() + ((h.e(str, (this.tags.hashCode() + e10) * 31, 31) + this.viewers) * 31);
    }

    public String toString() {
        int i10 = this.id;
        int i11 = this.category_id;
        String str = this.name;
        String str2 = this.slug;
        List<String> list = this.tags;
        String str3 = this.description;
        int i12 = this.viewers;
        Category category2 = this.category;
        StringBuilder sb2 = new StringBuilder("CategoriesItem(id=");
        sb2.append(i10);
        sb2.append(", category_id=");
        sb2.append(i11);
        sb2.append(", name=");
        f.k(sb2, str, ", slug=", str2, ", tags=");
        sb2.append(list);
        sb2.append(", description=");
        sb2.append(str3);
        sb2.append(", viewers=");
        sb2.append(i12);
        sb2.append(", category=");
        sb2.append(category2);
        sb2.append(")");
        return sb2.toString();
    }
}
