package com.github.andreyasadchy.xtra.model.ui;

public enum FollowSortEnum {
    FOLLOWED_AT("created_at"),
    ALPHABETICALLY("login"),
    LAST_BROADCAST("last_broadcast");
    
    private final String value;

    private FollowSortEnum(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }

    public String toString() {
        return this.value;
    }
}
