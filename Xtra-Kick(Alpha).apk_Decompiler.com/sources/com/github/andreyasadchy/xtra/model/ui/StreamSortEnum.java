package com.github.andreyasadchy.xtra.model.ui;

public enum StreamSortEnum {
    RECOMMENDED("RELEVANCE"),
    VIEWERS_HIGH("VIEWER_COUNT"),
    VIEWERS_LOW("VIEWER_COUNT_ASC"),
    RECENT("RECENT");
    
    private final String value;

    private StreamSortEnum(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }

    public String toString() {
        return this.value;
    }
}
