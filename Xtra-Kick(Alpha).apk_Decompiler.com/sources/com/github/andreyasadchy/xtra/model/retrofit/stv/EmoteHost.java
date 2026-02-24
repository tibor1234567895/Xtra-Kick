package com.github.andreyasadchy.xtra.model.retrofit.stv;

import java.util.List;
import xa.j;

public final class EmoteHost {
    private final List<EmoteFile> files;
    private final String url;

    public EmoteHost(String str, List<EmoteFile> list) {
        j.f("url", str);
        j.f("files", list);
        this.url = str;
        this.files = list;
    }

    public static /* synthetic */ EmoteHost copy$default(EmoteHost emoteHost, String str, List<EmoteFile> list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = emoteHost.url;
        }
        if ((i10 & 2) != 0) {
            list = emoteHost.files;
        }
        return emoteHost.copy(str, list);
    }

    public final String component1() {
        return this.url;
    }

    public final List<EmoteFile> component2() {
        return this.files;
    }

    public final EmoteHost copy(String str, List<EmoteFile> list) {
        j.f("url", str);
        j.f("files", list);
        return new EmoteHost(str, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EmoteHost)) {
            return false;
        }
        EmoteHost emoteHost = (EmoteHost) obj;
        return j.a(this.url, emoteHost.url) && j.a(this.files, emoteHost.files);
    }

    public final List<EmoteFile> getFiles() {
        return this.files;
    }

    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        return this.files.hashCode() + (this.url.hashCode() * 31);
    }

    public String toString() {
        String str = this.url;
        List<EmoteFile> list = this.files;
        return "EmoteHost(url=" + str + ", files=" + list + ")";
    }
}
