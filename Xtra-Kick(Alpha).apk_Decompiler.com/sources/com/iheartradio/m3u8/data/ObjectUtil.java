package com.iheartradio.m3u8.data;

final class ObjectUtil {
    public static boolean equals(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }
}
