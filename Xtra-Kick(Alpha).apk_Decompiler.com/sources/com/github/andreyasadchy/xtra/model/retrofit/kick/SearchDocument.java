package com.github.andreyasadchy.xtra.model.retrofit.kick;

import android.support.v4.media.h;
import k9.b;
import q0.f;
import xa.j;

public final class SearchDocument {
    @b("category_id")
    private final Integer categoryId;
    private final String id;
    private final boolean is_live;
    private final String name;
    private final String slug;
    private final String src;
    private final String username;

    public SearchDocument(String str, boolean z10, String str2, String str3, String str4, String str5, Integer num) {
        j.f("id", str);
        j.f("slug", str2);
        this.id = str;
        this.is_live = z10;
        this.slug = str2;
        this.username = str3;
        this.name = str4;
        this.src = str5;
        this.categoryId = num;
    }

    public static /* synthetic */ SearchDocument copy$default(SearchDocument searchDocument, String str, boolean z10, String str2, String str3, String str4, String str5, Integer num, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = searchDocument.id;
        }
        if ((i10 & 2) != 0) {
            z10 = searchDocument.is_live;
        }
        boolean z11 = z10;
        if ((i10 & 4) != 0) {
            str2 = searchDocument.slug;
        }
        String str6 = str2;
        if ((i10 & 8) != 0) {
            str3 = searchDocument.username;
        }
        String str7 = str3;
        if ((i10 & 16) != 0) {
            str4 = searchDocument.name;
        }
        String str8 = str4;
        if ((i10 & 32) != 0) {
            str5 = searchDocument.src;
        }
        String str9 = str5;
        if ((i10 & 64) != 0) {
            num = searchDocument.categoryId;
        }
        return searchDocument.copy(str, z11, str6, str7, str8, str9, num);
    }

    public final String component1() {
        return this.id;
    }

    public final boolean component2() {
        return this.is_live;
    }

    public final String component3() {
        return this.slug;
    }

    public final String component4() {
        return this.username;
    }

    public final String component5() {
        return this.name;
    }

    public final String component6() {
        return this.src;
    }

    public final Integer component7() {
        return this.categoryId;
    }

    public final SearchDocument copy(String str, boolean z10, String str2, String str3, String str4, String str5, Integer num) {
        j.f("id", str);
        j.f("slug", str2);
        return new SearchDocument(str, z10, str2, str3, str4, str5, num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SearchDocument)) {
            return false;
        }
        SearchDocument searchDocument = (SearchDocument) obj;
        return j.a(this.id, searchDocument.id) && this.is_live == searchDocument.is_live && j.a(this.slug, searchDocument.slug) && j.a(this.username, searchDocument.username) && j.a(this.name, searchDocument.name) && j.a(this.src, searchDocument.src) && j.a(this.categoryId, searchDocument.categoryId);
    }

    public final Integer getCategoryId() {
        return this.categoryId;
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getSlug() {
        return this.slug;
    }

    public final String getSrc() {
        return this.src;
    }

    public final String getUsername() {
        return this.username;
    }

    public int hashCode() {
        int i10;
        int i11;
        int i12;
        int hashCode = this.id.hashCode() * 31;
        boolean z10 = this.is_live;
        if (z10) {
            z10 = true;
        }
        int e10 = h.e(this.slug, (hashCode + (z10 ? 1 : 0)) * 31, 31);
        String str = this.username;
        int i13 = 0;
        if (str == null) {
            i10 = 0;
        } else {
            i10 = str.hashCode();
        }
        int i14 = (e10 + i10) * 31;
        String str2 = this.name;
        if (str2 == null) {
            i11 = 0;
        } else {
            i11 = str2.hashCode();
        }
        int i15 = (i14 + i11) * 31;
        String str3 = this.src;
        if (str3 == null) {
            i12 = 0;
        } else {
            i12 = str3.hashCode();
        }
        int i16 = (i15 + i12) * 31;
        Integer num = this.categoryId;
        if (num != null) {
            i13 = num.hashCode();
        }
        return i16 + i13;
    }

    public final boolean is_live() {
        return this.is_live;
    }

    public String toString() {
        String str = this.id;
        boolean z10 = this.is_live;
        String str2 = this.slug;
        String str3 = this.username;
        String str4 = this.name;
        String str5 = this.src;
        Integer num = this.categoryId;
        StringBuilder sb2 = new StringBuilder("SearchDocument(id=");
        sb2.append(str);
        sb2.append(", is_live=");
        sb2.append(z10);
        sb2.append(", slug=");
        f.k(sb2, str2, ", username=", str3, ", name=");
        f.k(sb2, str4, ", src=", str5, ", categoryId=");
        sb2.append(num);
        sb2.append(")");
        return sb2.toString();
    }
}
