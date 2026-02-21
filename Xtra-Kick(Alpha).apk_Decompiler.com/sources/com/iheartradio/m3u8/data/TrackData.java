package com.iheartradio.m3u8.data;

import java.util.Objects;

public class TrackData {
    private final EncryptionData mEncryptionData;
    private final boolean mHasDiscontinuity;
    private final String mProgramDateTime;
    private final TrackInfo mTrackInfo;
    private final String mUri;

    public static class Builder {
        private EncryptionData mEncryptionData;
        private boolean mHasDiscontinuity;
        private String mProgramDateTime;
        private TrackInfo mTrackInfo;
        private String mUri;

        public Builder() {
        }

        private Builder(String str, TrackInfo trackInfo, EncryptionData encryptionData, boolean z10) {
            this.mUri = str;
            this.mTrackInfo = trackInfo;
            this.mEncryptionData = encryptionData;
            this.mHasDiscontinuity = z10;
        }

        public TrackData build() {
            return new TrackData(this.mUri, this.mTrackInfo, this.mEncryptionData, this.mProgramDateTime, this.mHasDiscontinuity);
        }

        public Builder withDiscontinuity(boolean z10) {
            this.mHasDiscontinuity = z10;
            return this;
        }

        public Builder withEncryptionData(EncryptionData encryptionData) {
            this.mEncryptionData = encryptionData;
            return this;
        }

        public Builder withProgramDateTime(String str) {
            this.mProgramDateTime = str;
            return this;
        }

        public Builder withTrackInfo(TrackInfo trackInfo) {
            this.mTrackInfo = trackInfo;
            return this;
        }

        public Builder withUri(String str) {
            this.mUri = str;
            return this;
        }
    }

    private TrackData(String str, TrackInfo trackInfo, EncryptionData encryptionData, String str2, boolean z10) {
        this.mUri = str;
        this.mTrackInfo = trackInfo;
        this.mEncryptionData = encryptionData;
        this.mProgramDateTime = str2;
        this.mHasDiscontinuity = z10;
    }

    public Builder buildUpon() {
        return new Builder(getUri(), this.mTrackInfo, this.mEncryptionData, this.mHasDiscontinuity);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof TrackData)) {
            return false;
        }
        TrackData trackData = (TrackData) obj;
        return Objects.equals(this.mUri, trackData.mUri) && Objects.equals(this.mTrackInfo, trackData.mTrackInfo) && Objects.equals(this.mEncryptionData, trackData.mEncryptionData) && Objects.equals(this.mProgramDateTime, trackData.mProgramDateTime) && Objects.equals(Boolean.valueOf(this.mHasDiscontinuity), Boolean.valueOf(trackData.mHasDiscontinuity));
    }

    public EncryptionData getEncryptionData() {
        return this.mEncryptionData;
    }

    public String getProgramDateTime() {
        return this.mProgramDateTime;
    }

    public TrackInfo getTrackInfo() {
        return this.mTrackInfo;
    }

    public String getUri() {
        return this.mUri;
    }

    public boolean hasDiscontinuity() {
        return this.mHasDiscontinuity;
    }

    public boolean hasEncryptionData() {
        return this.mEncryptionData != null;
    }

    public boolean hasProgramDateTime() {
        String str = this.mProgramDateTime;
        return str != null && str.length() > 0;
    }

    public boolean hasTrackInfo() {
        return this.mTrackInfo != null;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.mUri, this.mEncryptionData, this.mTrackInfo, Boolean.valueOf(this.mHasDiscontinuity)});
    }

    public boolean isEncrypted() {
        return (!hasEncryptionData() || this.mEncryptionData.getMethod() == null || this.mEncryptionData.getMethod() == EncryptionMethod.NONE) ? false : true;
    }

    public String toString() {
        return "(TrackData mUri=" + this.mUri + " mTrackInfo=" + this.mTrackInfo + " mEncryptionData=" + this.mEncryptionData + " mProgramDateTime=" + this.mProgramDateTime + " mHasDiscontinuity=" + this.mHasDiscontinuity + ")";
    }
}
