package com.github.andreyasadchy.xtra.model.retrofit.kick.v1;

import android.support.v4.media.h;
import java.util.List;
import k9.b;
import xa.j;

public final class CategoriesItem {
    private final CategoryBanner banner;
    private final Category category;
    @b("category_id")
    private final int categoryId;
    private final int id;
    private final String name;
    private final String slug;
    private final List<String> tags;
    private final int viewers;

    public CategoriesItem(int i10, int i11, Category category2, String str, String str2, List<String> list, int i12, CategoryBanner categoryBanner) {
        j.f("category", category2);
        j.f("name", str);
        j.f("slug", str2);
        j.f("tags", list);
        this.id = i10;
        this.categoryId = i11;
        this.category = category2;
        this.name = str;
        this.slug = str2;
        this.tags = list;
        this.viewers = i12;
        this.banner = categoryBanner;
    }

    public static /* synthetic */ CategoriesItem copy$default(CategoriesItem categoriesItem, int i10, int i11, Category category2, String str, String str2, List list, int i12, CategoryBanner categoryBanner, int i13, Object obj) {
        CategoriesItem categoriesItem2 = categoriesItem;
        int i14 = i13;
        return categoriesItem.copy((i14 & 1) != 0 ? categoriesItem2.id : i10, (i14 & 2) != 0 ? categoriesItem2.categoryId : i11, (i14 & 4) != 0 ? categoriesItem2.category : category2, (i14 & 8) != 0 ? categoriesItem2.name : str, (i14 & 16) != 0 ? categoriesItem2.slug : str2, (i14 & 32) != 0 ? categoriesItem2.tags : list, (i14 & 64) != 0 ? categoriesItem2.viewers : i12, (i14 & 128) != 0 ? categoriesItem2.banner : categoryBanner);
    }

    public final int component1() {
        return this.id;
    }

    public final int component2() {
        return this.categoryId;
    }

    public final Category component3() {
        return this.category;
    }

    public final String component4() {
        return this.name;
    }

    public final String component5() {
        return this.slug;
    }

    public final List<String> component6() {
        return this.tags;
    }

    public final int component7() {
        return this.viewers;
    }

    public final CategoryBanner component8() {
        return this.banner;
    }

    public final CategoriesItem copy(int i10, int i11, Category category2, String str, String str2, List<String> list, int i12, CategoryBanner categoryBanner) {
        j.f("category", category2);
        j.f("name", str);
        j.f("slug", str2);
        List<String> list2 = list;
        j.f("tags", list2);
        return new CategoriesItem(i10, i11, category2, str, str2, list2, i12, categoryBanner);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CategoriesItem)) {
            return false;
        }
        CategoriesItem categoriesItem = (CategoriesItem) obj;
        return this.id == categoriesItem.id && this.categoryId == categoriesItem.categoryId && j.a(this.category, categoriesItem.category) && j.a(this.name, categoriesItem.name) && j.a(this.slug, categoriesItem.slug) && j.a(this.tags, categoriesItem.tags) && this.viewers == categoriesItem.viewers && j.a(this.banner, categoriesItem.banner);
    }

    public final CategoryBanner getBanner() {
        return this.banner;
    }

    public final Category getCategory() {
        return this.category;
    }

    public final int getCategoryId() {
        return this.categoryId;
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
        int i10;
        int hashCode = this.category.hashCode();
        int hashCode2 = (((this.tags.hashCode() + h.e(this.slug, h.e(this.name, (hashCode + (((this.id * 31) + this.categoryId) * 31)) * 31, 31), 31)) * 31) + this.viewers) * 31;
        CategoryBanner categoryBanner = this.banner;
        if (categoryBanner == null) {
            i10 = 0;
        } else {
            i10 = categoryBanner.hashCode();
        }
        return hashCode2 + i10;
    }

    public String toString() {
        int i10 = this.id;
        int i11 = this.categoryId;
        Category category2 = this.category;
        String str = this.name;
        String str2 = this.slug;
        List<String> list = this.tags;
        int i12 = this.viewers;
        CategoryBanner categoryBanner = this.banner;
        return "CategoriesItem(id=" + i10 + ", categoryId=" + i11 + ", category=" + category2 + ", name=" + str + ", slug=" + str2 + ", tags=" + list + ", viewers=" + i12 + ", banner=" + categoryBanner + ")";
    }
}
