package com.iheartradio.m3u8;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public enum Extension {
    M3U("m3u", Encoding.WINDOWS_1252),
    M3U8("m3u8", Encoding.UTF_8);
    
    private static final Map<String, Extension> sMap = null;
    final Encoding encoding;
    final String value;

    /* access modifiers changed from: public */
    static {
        int i10;
        sMap = new HashMap();
        for (Extension extension : values()) {
            sMap.put(extension.value, extension);
        }
    }

    private Extension(String str, Encoding encoding2) {
        this.value = str;
        this.encoding = encoding2;
    }

    public static Extension fromValue(String str) {
        if (str == null) {
            return null;
        }
        return sMap.get(str.toLowerCase(Locale.US));
    }

    public Encoding getEncoding() {
        return this.encoding;
    }

    public String getValue() {
        return this.value;
    }
}
