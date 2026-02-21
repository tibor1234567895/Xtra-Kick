package com.github.andreyasadchy.xtra.model.retrofit.kick.v2;

import android.support.v4.media.h;
import k9.b;
import xa.j;

public final class ClipChannel {
    private final int id;
    @b("profile_picture")
    private final String profilePicture;
    private final String slug;
    private final String username;

    public ClipChannel(int i10, String str, String str2, String str3) {
        j.f("username", str);
        j.f("slug", str2);
        j.f("profilePicture", str3);
        this.id = i10;
        this.username = str;
        this.slug = str2;
        this.profilePicture = str3;
    }

    public static /* synthetic */ ClipChannel copy$default(ClipChannel clipChannel, int i10, String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = clipChannel.id;
        }
        if ((i11 & 2) != 0) {
            str = clipChannel.username;
        }
        if ((i11 & 4) != 0) {
            str2 = clipChannel.slug;
        }
        if ((i11 & 8) != 0) {
            str3 = clipChannel.profilePicture;
        }
        return clipChannel.copy(i10, str, str2, str3);
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
        return this.profilePicture;
    }

    public final ClipChannel copy(int i10, String str, String str2, String str3) {
        j.f("username", str);
        j.f("slug", str2);
        j.f("profilePicture", str3);
        return new ClipChannel(i10, str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ClipChannel)) {
            return false;
        }
        ClipChannel clipChannel = (ClipChannel) obj;
        return this.id == clipChannel.id && j.a(this.username, clipChannel.username) && j.a(this.slug, clipChannel.slug) && j.a(this.profilePicture, clipChannel.profilePicture);
    }

    public final int getId() {
        return this.id;
    }

    public final String getProfilePicture() {
        return this.profilePicture;
    }

    public final String getSlug() {
        return this.slug;
    }

    public final String getUsername() {
        return this.username;
    }

    public int hashCode() {
        return this.profilePicture.hashCode() + h.e(this.slug, h.e(this.username, this.id * 31, 31), 31);
    }

    public String toString() {
        int i10 = this.id;
        String str = this.username;
        String str2 = this.slug;
        String str3 = this.profilePicture;
        return "ClipChannel(id=" + i10 + ", username=" + str + ", slug=" + str2 + ", profilePicture=" + str3 + ")";
    }
}
