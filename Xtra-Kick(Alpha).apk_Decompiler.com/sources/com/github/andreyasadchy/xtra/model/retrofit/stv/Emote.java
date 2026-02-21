package com.github.andreyasadchy.xtra.model.retrofit.stv;

import android.support.v4.media.h;
import xa.j;

public final class Emote {
    private final EmoteData data;
    private final String id;
    private final String name;

    public Emote(String str, String str2, EmoteData emoteData) {
        j.f("id", str);
        j.f("name", str2);
        j.f("data", emoteData);
        this.id = str;
        this.name = str2;
        this.data = emoteData;
    }

    public static /* synthetic */ Emote copy$default(Emote emote, String str, String str2, EmoteData emoteData, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = emote.id;
        }
        if ((i10 & 2) != 0) {
            str2 = emote.name;
        }
        if ((i10 & 4) != 0) {
            emoteData = emote.data;
        }
        return emote.copy(str, str2, emoteData);
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.name;
    }

    public final EmoteData component3() {
        return this.data;
    }

    public final Emote copy(String str, String str2, EmoteData emoteData) {
        j.f("id", str);
        j.f("name", str2);
        j.f("data", emoteData);
        return new Emote(str, str2, emoteData);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Emote)) {
            return false;
        }
        Emote emote = (Emote) obj;
        return j.a(this.id, emote.id) && j.a(this.name, emote.name) && j.a(this.data, emote.data);
    }

    public final EmoteData getData() {
        return this.data;
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        return this.data.hashCode() + h.e(this.name, this.id.hashCode() * 31, 31);
    }

    public String toString() {
        String str = this.id;
        String str2 = this.name;
        EmoteData emoteData = this.data;
        return "Emote(id=" + str + ", name=" + str2 + ", data=" + emoteData + ")";
    }
}
