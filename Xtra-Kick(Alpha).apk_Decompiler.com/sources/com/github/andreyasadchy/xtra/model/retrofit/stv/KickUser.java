package com.github.andreyasadchy.xtra.model.retrofit.stv;

import k9.b;
import xa.j;

public final class KickUser {
    @b("emote_set")
    private final EmoteSet emoteSet;

    public KickUser(EmoteSet emoteSet2) {
        j.f("emoteSet", emoteSet2);
        this.emoteSet = emoteSet2;
    }

    public static /* synthetic */ KickUser copy$default(KickUser kickUser, EmoteSet emoteSet2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            emoteSet2 = kickUser.emoteSet;
        }
        return kickUser.copy(emoteSet2);
    }

    public final EmoteSet component1() {
        return this.emoteSet;
    }

    public final KickUser copy(EmoteSet emoteSet2) {
        j.f("emoteSet", emoteSet2);
        return new KickUser(emoteSet2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof KickUser) && j.a(this.emoteSet, ((KickUser) obj).emoteSet);
    }

    public final EmoteSet getEmoteSet() {
        return this.emoteSet;
    }

    public int hashCode() {
        return this.emoteSet.hashCode();
    }

    public String toString() {
        EmoteSet emoteSet2 = this.emoteSet;
        return "KickUser(emoteSet=" + emoteSet2 + ")";
    }
}
