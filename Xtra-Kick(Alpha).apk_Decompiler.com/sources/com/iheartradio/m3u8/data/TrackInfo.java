package com.iheartradio.m3u8.data;

import java.util.Objects;

public class TrackInfo {
    public final float duration;
    public final String title;

    public TrackInfo(float f10, String str) {
        this.duration = f10;
        this.title = str;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof TrackInfo)) {
            return false;
        }
        TrackInfo trackInfo = (TrackInfo) obj;
        return this.duration == trackInfo.duration && Objects.equals(this.title, trackInfo.title);
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Float.valueOf(this.duration), this.title});
    }
}
