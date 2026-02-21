package com.github.andreyasadchy.xtra.model.chat;

import java.util.List;
import xa.j;

public final class StvChannelResponse {
    private final List<StvEmote> emotes;

    public StvChannelResponse(List<StvEmote> list) {
        j.f("emotes", list);
        this.emotes = list;
    }

    public static /* synthetic */ StvChannelResponse copy$default(StvChannelResponse stvChannelResponse, List<StvEmote> list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = stvChannelResponse.emotes;
        }
        return stvChannelResponse.copy(list);
    }

    public final List<StvEmote> component1() {
        return this.emotes;
    }

    public final StvChannelResponse copy(List<StvEmote> list) {
        j.f("emotes", list);
        return new StvChannelResponse(list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof StvChannelResponse) && j.a(this.emotes, ((StvChannelResponse) obj).emotes);
    }

    public final List<StvEmote> getEmotes() {
        return this.emotes;
    }

    public int hashCode() {
        return this.emotes.hashCode();
    }

    public String toString() {
        List<StvEmote> list = this.emotes;
        return "StvChannelResponse(emotes=" + list + ")";
    }
}
