package com.iheartradio.m3u8;

public class ParsingMode {
    public static final ParsingMode LENIENT = new Builder().allowUnknownTags().allowNegativeNumbers().build();
    public static final ParsingMode STRICT = new Builder().build();
    public final boolean allowNegativeNumbers;
    public final boolean allowUnknownTags;

    public static class Builder {
        private boolean mAllowNegativeNumbers = false;
        private boolean mAllowUnknownTags = false;

        public Builder allowNegativeNumbers() {
            this.mAllowNegativeNumbers = true;
            return this;
        }

        public Builder allowUnknownTags() {
            this.mAllowUnknownTags = true;
            return this;
        }

        public ParsingMode build() {
            return new ParsingMode(this.mAllowUnknownTags, this.mAllowNegativeNumbers);
        }
    }

    private ParsingMode(boolean z10, boolean z11) {
        this.allowUnknownTags = z10;
        this.allowNegativeNumbers = z11;
    }
}
