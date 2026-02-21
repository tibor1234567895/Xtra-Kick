package com.github.andreyasadchy.xtra.model.retrofit.stv;

import android.support.v4.media.h;
import xa.j;

public final class EmoteFile {
    private final EmoteFormat format;
    private final String name;
    private final String static_name;

    public EmoteFile(String str, String str2, EmoteFormat emoteFormat) {
        j.f("name", str);
        j.f("static_name", str2);
        j.f("format", emoteFormat);
        this.name = str;
        this.static_name = str2;
        this.format = emoteFormat;
    }

    public static /* synthetic */ EmoteFile copy$default(EmoteFile emoteFile, String str, String str2, EmoteFormat emoteFormat, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = emoteFile.name;
        }
        if ((i10 & 2) != 0) {
            str2 = emoteFile.static_name;
        }
        if ((i10 & 4) != 0) {
            emoteFormat = emoteFile.format;
        }
        return emoteFile.copy(str, str2, emoteFormat);
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.static_name;
    }

    public final EmoteFormat component3() {
        return this.format;
    }

    public final EmoteFile copy(String str, String str2, EmoteFormat emoteFormat) {
        j.f("name", str);
        j.f("static_name", str2);
        j.f("format", emoteFormat);
        return new EmoteFile(str, str2, emoteFormat);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EmoteFile)) {
            return false;
        }
        EmoteFile emoteFile = (EmoteFile) obj;
        return j.a(this.name, emoteFile.name) && j.a(this.static_name, emoteFile.static_name) && this.format == emoteFile.format;
    }

    public final EmoteFormat getFormat() {
        return this.format;
    }

    public final String getName() {
        return this.name;
    }

    public final String getStatic_name() {
        return this.static_name;
    }

    public int hashCode() {
        return this.format.hashCode() + h.e(this.static_name, this.name.hashCode() * 31, 31);
    }

    public String toString() {
        String str = this.name;
        String str2 = this.static_name;
        EmoteFormat emoteFormat = this.format;
        return "EmoteFile(name=" + str + ", static_name=" + str2 + ", format=" + emoteFormat + ")";
    }
}
