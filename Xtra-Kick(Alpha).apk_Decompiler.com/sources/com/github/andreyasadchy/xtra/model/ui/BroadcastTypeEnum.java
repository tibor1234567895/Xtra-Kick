package com.github.andreyasadchy.xtra.model.ui;

public enum BroadcastTypeEnum {
    ALL("all"),
    ARCHIVE("archive"),
    HIGHLIGHT("highlight"),
    UPLOAD("upload");
    
    private final String value;

    private BroadcastTypeEnum(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }

    public String toString() {
        return this.value;
    }
}
