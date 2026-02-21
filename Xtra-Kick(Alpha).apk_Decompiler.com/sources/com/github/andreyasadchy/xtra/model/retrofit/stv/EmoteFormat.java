package com.github.andreyasadchy.xtra.model.retrofit.stv;

public enum EmoteFormat {
    AVIF("AVIF"),
    WEBP("WEBP");
    
    private final String raw;

    private EmoteFormat(String str) {
        this.raw = str;
    }

    public final String getRaw() {
        return this.raw;
    }
}
