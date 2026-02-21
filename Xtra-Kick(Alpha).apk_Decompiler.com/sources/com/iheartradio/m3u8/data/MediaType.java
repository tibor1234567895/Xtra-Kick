package com.iheartradio.m3u8.data;

import java.util.HashMap;
import java.util.Map;

public enum MediaType {
    AUDIO(Constants.AUDIO),
    VIDEO(Constants.VIDEO),
    SUBTITLES(Constants.SUBTITLES),
    CLOSED_CAPTIONS(Constants.CLOSED_CAPTIONS);
    
    private static final Map<String, MediaType> sMap = null;
    private final String value;

    /* access modifiers changed from: public */
    static {
        int i10;
        sMap = new HashMap();
        for (MediaType mediaType : values()) {
            sMap.put(mediaType.value, mediaType);
        }
    }

    private MediaType(String str) {
        this.value = str;
    }

    public static MediaType fromValue(String str) {
        return sMap.get(str);
    }

    public String getValue() {
        return this.value;
    }
}
