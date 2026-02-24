package com.github.andreyasadchy.xtra.model.retrofit.stv;

import java.util.List;
import xa.j;

public final class EmoteData {
    private final boolean animated;
    private final EmoteHost host;
    private final List<String> tags;

    public EmoteData(EmoteHost emoteHost, boolean z10, List<String> list) {
        j.f("host", emoteHost);
        this.host = emoteHost;
        this.animated = z10;
        this.tags = list;
    }

    public static /* synthetic */ EmoteData copy$default(EmoteData emoteData, EmoteHost emoteHost, boolean z10, List<String> list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            emoteHost = emoteData.host;
        }
        if ((i10 & 2) != 0) {
            z10 = emoteData.animated;
        }
        if ((i10 & 4) != 0) {
            list = emoteData.tags;
        }
        return emoteData.copy(emoteHost, z10, list);
    }

    public final EmoteHost component1() {
        return this.host;
    }

    public final boolean component2() {
        return this.animated;
    }

    public final List<String> component3() {
        return this.tags;
    }

    public final EmoteData copy(EmoteHost emoteHost, boolean z10, List<String> list) {
        j.f("host", emoteHost);
        return new EmoteData(emoteHost, z10, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EmoteData)) {
            return false;
        }
        EmoteData emoteData = (EmoteData) obj;
        return j.a(this.host, emoteData.host) && this.animated == emoteData.animated && j.a(this.tags, emoteData.tags);
    }

    public final boolean getAnimated() {
        return this.animated;
    }

    public final EmoteHost getHost() {
        return this.host;
    }

    public final List<String> getTags() {
        return this.tags;
    }

    public int hashCode() {
        int hashCode = this.host.hashCode() * 31;
        boolean z10 = this.animated;
        if (z10) {
            z10 = true;
        }
        int i10 = (hashCode + (z10 ? 1 : 0)) * 31;
        List<String> list = this.tags;
        return i10 + (list == null ? 0 : list.hashCode());
    }

    public String toString() {
        EmoteHost emoteHost = this.host;
        boolean z10 = this.animated;
        List<String> list = this.tags;
        return "EmoteData(host=" + emoteHost + ", animated=" + z10 + ", tags=" + list + ")";
    }
}
