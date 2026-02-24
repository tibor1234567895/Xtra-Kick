package com.github.andreyasadchy.xtra.model.retrofit.kick.v2;

import android.support.v4.media.h;
import xa.j;

public final class BannerImage {
    private final String url;

    public BannerImage(String str) {
        j.f("url", str);
        this.url = str;
    }

    public static /* synthetic */ BannerImage copy$default(BannerImage bannerImage, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = bannerImage.url;
        }
        return bannerImage.copy(str);
    }

    public final String component1() {
        return this.url;
    }

    public final BannerImage copy(String str) {
        j.f("url", str);
        return new BannerImage(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof BannerImage) && j.a(this.url, ((BannerImage) obj).url);
    }

    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        return this.url.hashCode();
    }

    public String toString() {
        return h.n("BannerImage(url=", this.url, ")");
    }
}
