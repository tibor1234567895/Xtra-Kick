package com.iheartradio.m3u8.data;

import java.util.List;
import java.util.Objects;

public class StreamInfo implements IStreamInfo {
    public static final int NO_BANDWIDTH = -1;
    private final String mAudio;
    private final int mAverageBandwidth;
    private final int mBandwidth;
    private final String mClosedCaptions;
    private final List<String> mCodecs;
    private final float mFrameRate;
    private final Resolution mResolution;
    private final String mSubtitles;
    private final String mVideo;

    public static class Builder implements StreamInfoBuilder {
        private String mAudio;
        private int mAverageBandwidth;
        private int mBandwidth;
        private String mClosedCaptions;
        private List<String> mCodecs;
        private float mFrameRate;
        private Resolution mResolution;
        private String mSubtitles;
        private String mVideo;

        public Builder() {
            this.mBandwidth = -1;
            this.mAverageBandwidth = -1;
            this.mFrameRate = Float.NaN;
        }

        public StreamInfo build() {
            return new StreamInfo(this.mBandwidth, this.mAverageBandwidth, this.mCodecs, this.mResolution, this.mFrameRate, this.mAudio, this.mVideo, this.mSubtitles, this.mClosedCaptions);
        }

        public Builder withAudio(String str) {
            this.mAudio = str;
            return this;
        }

        public Builder withAverageBandwidth(int i10) {
            this.mAverageBandwidth = i10;
            return this;
        }

        public Builder withBandwidth(int i10) {
            this.mBandwidth = i10;
            return this;
        }

        public Builder withClosedCaptions(String str) {
            this.mClosedCaptions = str;
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

        public Builder withSubtitles(String str) {
            this.mSubtitles = str;
            return this;
        }

        public Builder withVideo(String str) {
            this.mVideo = str;
            return this;
        }

        private Builder(int i10, int i11, List<String> list, Resolution resolution, float f10, String str, String str2, String str3, String str4) {
            this.mBandwidth = i10;
            this.mAverageBandwidth = i11;
            this.mCodecs = list;
            this.mResolution = resolution;
            this.mFrameRate = f10;
            this.mAudio = str;
            this.mVideo = str2;
            this.mSubtitles = str3;
            this.mClosedCaptions = str4;
        }
    }

    private StreamInfo(int i10, int i11, List<String> list, Resolution resolution, float f10, String str, String str2, String str3, String str4) {
        this.mBandwidth = i10;
        this.mAverageBandwidth = i11;
        this.mCodecs = list;
        this.mResolution = resolution;
        this.mFrameRate = f10;
        this.mAudio = str;
        this.mVideo = str2;
        this.mSubtitles = str3;
        this.mClosedCaptions = str4;
    }

    public Builder buildUpon() {
        return new Builder(this.mBandwidth, this.mAverageBandwidth, this.mCodecs, this.mResolution, this.mFrameRate, this.mAudio, this.mVideo, this.mSubtitles, this.mClosedCaptions);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof StreamInfo)) {
            return false;
        }
        StreamInfo streamInfo = (StreamInfo) obj;
        return this.mBandwidth == streamInfo.mBandwidth && this.mAverageBandwidth == streamInfo.mAverageBandwidth && Objects.equals(this.mCodecs, streamInfo.mCodecs) && Objects.equals(this.mResolution, streamInfo.mResolution) && Objects.equals(Float.valueOf(this.mFrameRate), Float.valueOf(streamInfo.mFrameRate)) && Objects.equals(this.mAudio, streamInfo.mAudio) && Objects.equals(this.mVideo, streamInfo.mVideo) && Objects.equals(this.mSubtitles, streamInfo.mSubtitles) && Objects.equals(this.mClosedCaptions, streamInfo.mClosedCaptions);
    }

    public String getAudio() {
        return this.mAudio;
    }

    public int getAverageBandwidth() {
        return this.mAverageBandwidth;
    }

    public int getBandwidth() {
        return this.mBandwidth;
    }

    public String getClosedCaptions() {
        return this.mClosedCaptions;
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

    public String getSubtitles() {
        return this.mSubtitles;
    }

    public String getVideo() {
        return this.mVideo;
    }

    public boolean hasAudio() {
        return this.mAudio != null;
    }

    public boolean hasAverageBandwidth() {
        return this.mAverageBandwidth != -1;
    }

    public boolean hasClosedCaptions() {
        return this.mClosedCaptions != null;
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

    public boolean hasSubtitles() {
        return this.mSubtitles != null;
    }

    public boolean hasVideo() {
        return this.mVideo != null;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(this.mBandwidth), Integer.valueOf(this.mAverageBandwidth), this.mCodecs, this.mResolution, Float.valueOf(this.mFrameRate), this.mAudio, this.mVideo, this.mSubtitles, this.mClosedCaptions});
    }
}
