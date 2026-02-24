package com.github.andreyasadchy.xtra.model.chat;

import xa.j;

public final class StvEmote extends Emote {
    private final Boolean isAnimated;
    private final boolean isZeroWidth;
    private final String name;
    private final String type;
    private final String url1x;
    private final String url2x;
    private final String url3x;
    private final String url4x;

    public StvEmote(String str, String str2, String str3, String str4, String str5, String str6, Boolean bool, boolean z10) {
        j.f("name", str);
        this.name = str;
        this.url1x = str2;
        this.url2x = str3;
        this.url3x = str4;
        this.url4x = str5;
        this.type = str6;
        this.isAnimated = bool;
        this.isZeroWidth = z10;
    }

    public String getName() {
        return this.name;
    }

    public String getType() {
        return this.type;
    }

    public String getUrl1x() {
        return this.url1x;
    }

    public String getUrl2x() {
        return this.url2x;
    }

    public String getUrl3x() {
        return this.url3x;
    }

    public String getUrl4x() {
        return this.url4x;
    }

    public Boolean isAnimated() {
        return this.isAnimated;
    }

    public boolean isZeroWidth() {
        return this.isZeroWidth;
    }
}
