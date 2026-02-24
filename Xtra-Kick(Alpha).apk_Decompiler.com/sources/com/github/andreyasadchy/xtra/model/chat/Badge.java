package com.github.andreyasadchy.xtra.model.chat;

import xa.j;

public final class Badge {
    private final String setId;
    private final String version;

    public Badge(String str, String str2) {
        j.f("setId", str);
        j.f("version", str2);
        this.setId = str;
        this.version = str2;
    }

    public static /* synthetic */ Badge copy$default(Badge badge, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = badge.setId;
        }
        if ((i10 & 2) != 0) {
            str2 = badge.version;
        }
        return badge.copy(str, str2);
    }

    public final String component1() {
        return this.setId;
    }

    public final String component2() {
        return this.version;
    }

    public final Badge copy(String str, String str2) {
        j.f("setId", str);
        j.f("version", str2);
        return new Badge(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Badge)) {
            return false;
        }
        Badge badge = (Badge) obj;
        return j.a(this.setId, badge.setId) && j.a(this.version, badge.version);
    }

    public final String getSetId() {
        return this.setId;
    }

    public final String getVersion() {
        return this.version;
    }

    public int hashCode() {
        return this.version.hashCode() + (this.setId.hashCode() * 31);
    }

    public String toString() {
        String str = this.setId;
        String str2 = this.version;
        return "Badge(setId=" + str + ", version=" + str2 + ")";
    }
}
