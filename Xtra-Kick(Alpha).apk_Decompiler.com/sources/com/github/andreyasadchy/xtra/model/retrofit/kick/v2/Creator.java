package com.github.andreyasadchy.xtra.model.retrofit.kick.v2;

import android.support.v4.media.h;
import xa.j;

public final class Creator {
    private final int id;
    private final String profile_picture;
    private final String slug;
    private final String username;

    public Creator(int i10, String str, String str2, String str3) {
        j.f("username", str);
        j.f("slug", str2);
        this.id = i10;
        this.username = str;
        this.slug = str2;
        this.profile_picture = str3;
    }

    public static /* synthetic */ Creator copy$default(Creator creator, int i10, String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = creator.id;
        }
        if ((i11 & 2) != 0) {
            str = creator.username;
        }
        if ((i11 & 4) != 0) {
            str2 = creator.slug;
        }
        if ((i11 & 8) != 0) {
            str3 = creator.profile_picture;
        }
        return creator.copy(i10, str, str2, str3);
    }

    public final int component1() {
        return this.id;
    }

    public final String component2() {
        return this.username;
    }

    public final String component3() {
        return this.slug;
    }

    public final String component4() {
        return this.profile_picture;
    }

    public final Creator copy(int i10, String str, String str2, String str3) {
        j.f("username", str);
        j.f("slug", str2);
        return new Creator(i10, str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Creator)) {
            return false;
        }
        Creator creator = (Creator) obj;
        return this.id == creator.id && j.a(this.username, creator.username) && j.a(this.slug, creator.slug) && j.a(this.profile_picture, creator.profile_picture);
    }

    public final int getId() {
        return this.id;
    }

    public final String getProfile_picture() {
        return this.profile_picture;
    }

    public final String getSlug() {
        return this.slug;
    }

    public final String getUsername() {
        return this.username;
    }

    public int hashCode() {
        int i10;
        int e10 = h.e(this.slug, h.e(this.username, this.id * 31, 31), 31);
        String str = this.profile_picture;
        if (str == null) {
            i10 = 0;
        } else {
            i10 = str.hashCode();
        }
        return e10 + i10;
    }

    public String toString() {
        int i10 = this.id;
        String str = this.username;
        String str2 = this.slug;
        String str3 = this.profile_picture;
        return "Creator(id=" + i10 + ", username=" + str + ", slug=" + str2 + ", profile_picture=" + str3 + ")";
    }
}
