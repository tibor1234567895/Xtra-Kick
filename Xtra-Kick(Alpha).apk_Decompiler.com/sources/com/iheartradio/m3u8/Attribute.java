package com.iheartradio.m3u8;

import android.support.v4.media.h;

class Attribute {
    public final String name;
    public final String value;

    public Attribute(String str, String str2) {
        this.name = str;
        this.value = str2;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("(Attribute name=");
        sb2.append(this.name);
        sb2.append(" value=");
        return h.p(sb2, this.value, ")");
    }
}
