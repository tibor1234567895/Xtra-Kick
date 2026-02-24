package com.github.andreyasadchy.xtra.model.retrofit.kick.post;

public enum PresetType {
    CATEGORY("category_search"),
    CHANNEL("channel_search");
    
    private final String raw;

    private PresetType(String str) {
        this.raw = str;
    }

    public final String getRaw() {
        return this.raw;
    }
}
