package com.github.andreyasadchy.xtra.model.retrofit.kick.v2;

import android.support.v4.media.h;
import xa.j;

public final class Thumbnail {
    private final String url;

    public Thumbnail(String str) {
        j.f("url", str);
        this.url = str;
    }

    public static /* synthetic */ Thumbnail copy$default(Thumbnail thumbnail, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = thumbnail.url;
        }
        return thumbnail.copy(str);
    }

    public final String component1() {
        return this.url;
    }

    public final Thumbnail copy(String str) {
        j.f("url", str);
        return new Thumbnail(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Thumbnail) && j.a(this.url, ((Thumbnail) obj).url);
    }

    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        return this.url.hashCode();
    }

    public String toString() {
        return h.n("Thumbnail(url=", this.url, ")");
    }
}
