package com.iheartradio.m3u8.data;

import java.util.Objects;

public class StartData {
    private final boolean mPrecise;
    private final float mTimeOffset;

    public static class Builder {
        private boolean mPrecise;
        private float mTimeOffset;

        public Builder() {
            this.mTimeOffset = Float.NaN;
        }

        public StartData build() {
            return new StartData(this.mTimeOffset, this.mPrecise);
        }

        public Builder withPrecise(boolean z10) {
            this.mPrecise = z10;
            return this;
        }

        public Builder withTimeOffset(float f10) {
            this.mTimeOffset = f10;
            return this;
        }

        private Builder(float f10, boolean z10) {
            this.mTimeOffset = f10;
            this.mPrecise = z10;
        }
    }

    public StartData(float f10, boolean z10) {
        this.mTimeOffset = f10;
        this.mPrecise = z10;
    }

    public Builder buildUpon() {
        return new Builder(this.mTimeOffset, this.mPrecise);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof StartData)) {
            return false;
        }
        StartData startData = (StartData) obj;
        return this.mPrecise == startData.mPrecise && this.mTimeOffset == startData.mTimeOffset;
    }

    public float getTimeOffset() {
        return this.mTimeOffset;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Boolean.valueOf(this.mPrecise), Float.valueOf(this.mTimeOffset)});
    }

    public boolean isPrecise() {
        return this.mPrecise;
    }
}
