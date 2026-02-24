package com.iheartradio.m3u8.data;

import java.util.Objects;

public class Resolution {
    public final int height;
    public final int width;

    public Resolution(int i10, int i11) {
        this.width = i10;
        this.height = i11;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Resolution)) {
            return false;
        }
        Resolution resolution = (Resolution) obj;
        return this.width == resolution.width && this.height == resolution.height;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(this.height), Integer.valueOf(this.width)});
    }
}
