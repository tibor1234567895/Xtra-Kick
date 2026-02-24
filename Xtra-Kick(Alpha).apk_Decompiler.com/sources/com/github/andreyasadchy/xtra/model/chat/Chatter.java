package com.github.andreyasadchy.xtra.model.chat;

import android.support.v4.media.h;
import xa.j;

public final class Chatter {
    private final String name;

    public Chatter(String str) {
        this.name = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!j.a(Chatter.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        j.d("null cannot be cast to non-null type com.github.andreyasadchy.xtra.model.chat.Chatter", obj);
        return j.a(this.name, ((Chatter) obj).name);
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        String str = this.name;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return h.m("@", this.name);
    }
}
