package com.github.andreyasadchy.xtra.model.retrofit.kick.v1;

import android.support.v4.media.h;
import xa.j;

public final class Thumbnail {
    private final String src;

    public Thumbnail(String str) {
        j.f("src", str);
        this.src = str;
    }

    public static /* synthetic */ Thumbnail copy$default(Thumbnail thumbnail, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = thumbnail.src;
        }
        return thumbnail.copy(str);
    }

    public final String component1() {
        return this.src;
    }

    public final Thumbnail copy(String str) {
        j.f("src", str);
        return new Thumbnail(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Thumbnail) && j.a(this.src, ((Thumbnail) obj).src);
    }

    public final String getSrc() {
        return this.src;
    }

    public int hashCode() {
        return this.src.hashCode();
    }

    public String toString() {
        return h.n("Thumbnail(src=", this.src, ")");
    }
}
