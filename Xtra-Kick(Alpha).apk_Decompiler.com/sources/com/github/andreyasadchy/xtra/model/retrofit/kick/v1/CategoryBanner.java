package com.github.andreyasadchy.xtra.model.retrofit.kick.v1;

import android.support.v4.media.h;
import xa.j;

public final class CategoryBanner {
    private final String url;

    public CategoryBanner(String str) {
        j.f("url", str);
        this.url = str;
    }

    public static /* synthetic */ CategoryBanner copy$default(CategoryBanner categoryBanner, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = categoryBanner.url;
        }
        return categoryBanner.copy(str);
    }

    public final String component1() {
        return this.url;
    }

    public final CategoryBanner copy(String str) {
        j.f("url", str);
        return new CategoryBanner(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof CategoryBanner) && j.a(this.url, ((CategoryBanner) obj).url);
    }

    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        return this.url.hashCode();
    }

    public String toString() {
        return h.n("CategoryBanner(url=", this.url, ")");
    }
}
