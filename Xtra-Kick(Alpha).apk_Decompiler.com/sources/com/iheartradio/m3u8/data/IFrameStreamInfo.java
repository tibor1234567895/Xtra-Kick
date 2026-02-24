package com.iheartradio.m3u8.data;

import java.util.List;
import java.util.Objects;

public class IFrameStreamInfo implements IStreamInfo {
    public static final int NO_BANDWIDTH = -1;
    private final int mAverageBandwidth;
    private final int mBandwidth;
    private final List<String> mCodecs;
    private final float mFrameRate;
    private final Resolution mResolution;
    private final String mUri;
    private final String mVideo;

    public static class Builder implements StreamInfoBuilder {
        private int mAverageBandwidth;
        private int mBandwidth;
        private List<String> mCodecs;
        private float mFrameRate;
        private Resolution mResolution;
        private String mUri;
        private String mVideo;

        public Builder() {
            this.mBandwidth = -1;
            this.mAverageBandwidth = -1;
            this.mFrameRate = Float.NaN;
        }

        public IFrameStreamInfo build() {
            return new IFrameStreamInfo(this.mBandwidth, this.mAverageBandwidth, this.mCodecs, this.mResolution, this.mFrameRate, this.mVideo, this.mUri);
        }

        public Builder withAverageBandwidth(int i10) {
            this.mAverageBandwidth = i10;
            return this;
        }

        public Builder withBandwidth(int i10) {
            this.mBandwidth = i10;
            return this;
        }

        public Builder withCodecs(List<String> list) {
            this.mCodecs = list;
            return this;
        }

        public Builder withFrameRate(float f10) {
            this.mFrameRate = f10;
            return this;
        }

        public Builder withResolution(Resolution resolution) {
            this.mResolution = resolution;
            return this;
        }

        public Builder withUri(String str) {
            this.mUri = str;
            return this;
        }

        public Builder withVideo(String str) {
            this.mVideo = str;
            return this;
        }

        private Builder(int i10, int i11, List<String> list, Resolution resolution, float f10, String str, String str2) {
            this.mBandwidth = i10;
            this.mAverageBandwidth = i11;
            this.mCodecs = list;
            this.mResolution = resolution;
            this.mFrameRate = f10;
            this.mVideo = str;
            this.mUri = str2;
        }
    }

    private IFrameStreamInfo(int i10, int i11, List<String> list, Resolution resolution, float f10, String str, String str2) {
        this.mBandwidth = i10;
        this.mAverageBandwidth = i11;
        this.mCodecs = list;
        this.mResolution = resolution;
        this.mFrameRate = f10;
        this.mVideo = str;
        this.mUri = str2;
    }

    public Builder buildUpon() {
        return new Builder(this.mBandwidth, this.mAverageBandwidth, this.mCodecs, this.mResolution, this.mFrameRate, this.mVideo, this.mUri);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof IFrameStreamInfo)) {
            return false;
        }
        IFrameStreamInfo iFrameStreamInfo = (IFrameStreamInfo) obj;
        return this.mBandwidth == iFrameStreamInfo.mBandwidth && this.mAverageBandwidth == iFrameStreamInfo.mAverageBandwidth && Objects.equals(this.mCodecs, iFrameStreamInfo.mCodecs) && Objects.equals(this.mResolution, iFrameStreamInfo.mResolution) && Objects.equals(Float.valueOf(this.mFrameRate), Float.valueOf(iFrameStreamInfo.mFrameRate)) && Objects.equals(this.mVideo, iFrameStreamInfo.mVideo) && Objects.equals(this.mUri, iFrameStreamInfo.mUri);
    }

    public int getAverageBandwidth() {
        return this.mAverageBandwidth;
    }

    public int getBandwidth() {
        return this.mBandwidth;
    }

    public List<String> getCodecs() {
        return this.mCodecs;
    }

    public float getFrameRate() {
        return this.mFrameRate;
    }

    public Resolution getResolution() {
        return this.mResolution;
    }

    public String getUri() {
        return this.mUri;
    }

    public String getVideo() {
        return this.mVideo;
    }

    public boolean hasAverageBandwidth() {
        return this.mAverageBandwidth != -1;
    }

    public boolean hasCodecs() {
        return this.mCodecs != null;
    }

    public boolean hasFrameRate() {
        return !Float.isNaN(this.mFrameRate);
    }

    public boolean hasResolution() {
        return this.mResolution != null;
    }

    public boolean hasVideo() {
        return this.mVideo != null;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(this.mBandwidth), Integer.valueOf(this.mAverageBandwidth), this.mCodecs, this.mResolution, Float.valueOf(this.mFrameRate), this.mVideo, this.mUri});
    }
}
