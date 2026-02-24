package com.iheartradio.m3u8.data;

import java.util.Collections;
import java.util.List;

class DataUtil {
    public static <T> List<T> emptyOrUnmodifiable(List<T> list) {
        return list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
    }
}
