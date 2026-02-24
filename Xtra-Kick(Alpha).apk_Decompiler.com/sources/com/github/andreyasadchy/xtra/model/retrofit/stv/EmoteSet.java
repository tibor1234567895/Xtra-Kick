package com.github.andreyasadchy.xtra.model.retrofit.stv;

import java.util.List;
import xa.j;

public final class EmoteSet {
    private final List<Emote> emotes;

    public EmoteSet(List<Emote> list) {
        j.f("emotes", list);
        this.emotes = list;
    }

    public static /* synthetic */ EmoteSet copy$default(EmoteSet emoteSet, List<Emote> list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = emoteSet.emotes;
        }
        return emoteSet.copy(list);
    }

    public final List<Emote> component1() {
        return this.emotes;
    }

    public final EmoteSet copy(List<Emote> list) {
        j.f("emotes", list);
        return new EmoteSet(list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof EmoteSet) && j.a(this.emotes, ((EmoteSet) obj).emotes);
    }

    public final List<Emote> getEmotes() {
        return this.emotes;
    }

    public int hashCode() {
        return this.emotes.hashCode();
    }

    public String toString() {
        List<Emote> list = this.emotes;
        return "EmoteSet(emotes=" + list + ")";
    }
}
