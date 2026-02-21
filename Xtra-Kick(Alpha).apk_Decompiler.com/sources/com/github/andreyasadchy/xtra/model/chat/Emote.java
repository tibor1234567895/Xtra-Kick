package com.github.andreyasadchy.xtra.model.chat;

import android.support.v4.media.h;
import xa.j;

public abstract class Emote {
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Emote) && j.a(getName(), ((Emote) obj).getName());
    }

    public abstract String getName();

    public String getType() {
        return null;
    }

    public abstract String getUrl1x();

    public abstract String getUrl2x();

    public abstract String getUrl3x();

    public abstract String getUrl4x();

    public int hashCode() {
        return getName().hashCode();
    }

    public Boolean isAnimated() {
        return null;
    }

    public boolean isZeroWidth() {
        return false;
    }

    public String toString() {
        return h.m(Constants.EXT_TAG_END, getName());
    }
}
