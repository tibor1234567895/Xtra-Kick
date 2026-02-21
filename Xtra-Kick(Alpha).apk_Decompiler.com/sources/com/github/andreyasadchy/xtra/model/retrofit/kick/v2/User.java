package com.github.andreyasadchy.xtra.model.retrofit.kick.v2;

import android.support.v4.media.h;
import k9.b;
import xa.j;

public final class User {
    private final int id;
    @b("profile_pic")
    private final String profilePicture;
    private final String username;

    public User(int i10, String str, String str2) {
        j.f("username", str);
        this.id = i10;
        this.username = str;
        this.profilePicture = str2;
    }

    public static /* synthetic */ User copy$default(User user, int i10, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = user.id;
        }
        if ((i11 & 2) != 0) {
            str = user.username;
        }
        if ((i11 & 4) != 0) {
            str2 = user.profilePicture;
        }
        return user.copy(i10, str, str2);
    }

    public final int component1() {
        return this.id;
    }

    public final String component2() {
        return this.username;
    }

    public final String component3() {
        return this.profilePicture;
    }

    public final User copy(int i10, String str, String str2) {
        j.f("username", str);
        return new User(i10, str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof User)) {
            return false;
        }
        User user = (User) obj;
        return this.id == user.id && j.a(this.username, user.username) && j.a(this.profilePicture, user.profilePicture);
    }

    public final int getId() {
        return this.id;
    }

    public final String getProfilePicture() {
        return this.profilePicture;
    }

    public final String getUsername() {
        return this.username;
    }

    public int hashCode() {
        int i10;
        int e10 = h.e(this.username, this.id * 31, 31);
        String str = this.profilePicture;
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
        String str2 = this.profilePicture;
        StringBuilder sb2 = new StringBuilder("User(id=");
        sb2.append(i10);
        sb2.append(", username=");
        sb2.append(str);
        sb2.append(", profilePicture=");
        return h.p(sb2, str2, ")");
    }
}
