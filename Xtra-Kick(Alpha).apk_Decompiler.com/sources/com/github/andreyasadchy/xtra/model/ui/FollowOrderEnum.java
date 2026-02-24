package com.github.andreyasadchy.xtra.model.ui;

public enum FollowOrderEnum {
    ASC("asc"),
    DESC("desc");
    
    private final String value;

    private FollowOrderEnum(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }

    public String toString() {
        return this.value;
    }
}
