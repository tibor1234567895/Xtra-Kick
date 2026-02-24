package com.iheartradio.m3u8.data;

import java.util.HashMap;
import java.util.Map;

public enum PlaylistType {
    EVENT("EVENT"),
    VOD("VOD");
    
    private static final Map<String, PlaylistType> sMap = null;
    private final String value;

    /* access modifiers changed from: public */
    static {
        int i10;
        sMap = new HashMap();
        for (PlaylistType playlistType : values()) {
            sMap.put(playlistType.value, playlistType);
        }
    }

    private PlaylistType(String str) {
        this.value = str;
    }

    public static PlaylistType fromValue(String str) {
        return sMap.get(str);
    }

    public String getValue() {
        return this.value;
    }
}
