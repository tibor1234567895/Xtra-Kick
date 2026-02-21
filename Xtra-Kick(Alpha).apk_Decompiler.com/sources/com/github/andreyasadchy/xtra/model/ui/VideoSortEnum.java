package com.github.andreyasadchy.xtra.model.ui;

public enum VideoSortEnum {
    TIME("time"),
    VIEWS("views");
    
    private final String value;

    private VideoSortEnum(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }

    public String toString() {
        return this.value;
    }
}
