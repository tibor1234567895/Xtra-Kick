package com.github.andreyasadchy.xtra.model.chat;

import java.util.List;
import xa.j;

public final class StvGlobalResponse {
    private final List<StvEmote> emotes;

    public StvGlobalResponse(List<StvEmote> list) {
        j.f("emotes", list);
        this.emotes = list;
    }

    public static /* synthetic */ StvGlobalResponse copy$default(StvGlobalResponse stvGlobalResponse, List<StvEmote> list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = stvGlobalResponse.emotes;
        }
        return stvGlobalResponse.copy(list);
    }

    public final List<StvEmote> component1() {
        return this.emotes;
    }

    public final StvGlobalResponse copy(List<StvEmote> list) {
        j.f("emotes", list);
        return new StvGlobalResponse(list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof StvGlobalResponse) && j.a(this.emotes, ((StvGlobalResponse) obj).emotes);
    }

    public final List<StvEmote> getEmotes() {
        return this.emotes;
    }

    public int hashCode() {
        return this.emotes.hashCode();
    }

    public String toString() {
        List<StvEmote> list = this.emotes;
        return "StvGlobalResponse(emotes=" + list + ")";
    }
}
