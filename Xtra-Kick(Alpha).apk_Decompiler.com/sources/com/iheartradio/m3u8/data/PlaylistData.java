package com.iheartradio.m3u8.data;

import android.support.v4.media.h;
import java.util.Objects;

public class PlaylistData {
    private final StreamInfo mStreamInfo;
    private final String mUri;

    public static class Builder {
        private StreamInfo mStreamInfo;
        private String mUri;

        public Builder() {
        }

        private Builder(String str, StreamInfo streamInfo) {
            this.mUri = str;
            this.mStreamInfo = streamInfo;
        }

        public PlaylistData build() {
            return new PlaylistData(this.mUri, this.mStreamInfo);
        }

        public Builder withPath(String str) {
            this.mUri = str;
            return this;
        }

        public Builder withStreamInfo(StreamInfo streamInfo) {
            this.mStreamInfo = streamInfo;
            return this;
        }

        public Builder withUri(String str) {
            this.mUri = str;
            return this;
        }
    }

    private PlaylistData(String str, StreamInfo streamInfo) {
        this.mUri = str;
        this.mStreamInfo = streamInfo;
    }

    public Builder buildUpon() {
        return new Builder(this.mUri, this.mStreamInfo);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PlaylistData)) {
            return false;
        }
        PlaylistData playlistData = (PlaylistData) obj;
        return Objects.equals(this.mUri, playlistData.mUri) && Objects.equals(this.mStreamInfo, playlistData.mStreamInfo);
    }

    public StreamInfo getStreamInfo() {
        return this.mStreamInfo;
    }

    public String getUri() {
        return this.mUri;
    }

    public boolean hasStreamInfo() {
        return this.mStreamInfo != null;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.mUri, this.mStreamInfo});
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("PlaylistData [mStreamInfo=");
        sb2.append(this.mStreamInfo);
        sb2.append(", mUri=");
        return h.p(sb2, this.mUri, "]");
    }
}
