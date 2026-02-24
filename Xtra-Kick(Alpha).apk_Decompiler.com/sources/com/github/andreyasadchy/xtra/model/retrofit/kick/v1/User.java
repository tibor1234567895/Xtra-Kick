package com.github.andreyasadchy.xtra.model.retrofit.kick.v1;

import xa.j;

public final class User {
    private final String bio;
    private final int id;
    private final String profilepic;
    private final String username;

    public User(String str, int i10, String str2, String str3) {
        j.f("username", str3);
        this.bio = str;
        this.id = i10;
        this.profilepic = str2;
        this.username = str3;
    }

    public static /* synthetic */ User copy$default(User user, String str, int i10, String str2, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = user.bio;
        }
        if ((i11 & 2) != 0) {
            i10 = user.id;
        }
        if ((i11 & 4) != 0) {
            str2 = user.profilepic;
        }
        if ((i11 & 8) != 0) {
            str3 = user.username;
        }
        return user.copy(str, i10, str2, str3);
    }

    public final String component1() {
        return this.bio;
    }

    public final int component2() {
        return this.id;
    }

    public final String component3() {
        return this.profilepic;
    }

    public final String component4() {
        return this.username;
    }

    public final User copy(String str, int i10, String str2, String str3) {
        j.f("username", str3);
        return new User(str, i10, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof User)) {
            return false;
        }
        User user = (User) obj;
        return j.a(this.bio, user.bio) && this.id == user.id && j.a(this.profilepic, user.profilepic) && j.a(this.username, user.username);
    }

    public final String getBio() {
        return this.bio;
    }

    public final int getId() {
        return this.id;
    }

    public final String getProfilepic() {
        return this.profilepic;
    }

    public final String getUsername() {
        return this.username;
    }

    public int hashCode() {
        String str = this.bio;
        int i10 = 0;
        int hashCode = (((str == null ? 0 : str.hashCode()) * 31) + this.id) * 31;
        String str2 = this.profilepic;
        if (str2 != null) {
            i10 = str2.hashCode();
        }
        return this.username.hashCode() + ((hashCode + i10) * 31);
    }

    public String toString() {
        String str = this.bio;
        int i10 = this.id;
        String str2 = this.profilepic;
        String str3 = this.username;
        return "User(bio=" + str + ", id=" + i10 + ", profilepic=" + str2 + ", username=" + str3 + ")";
    }
}
