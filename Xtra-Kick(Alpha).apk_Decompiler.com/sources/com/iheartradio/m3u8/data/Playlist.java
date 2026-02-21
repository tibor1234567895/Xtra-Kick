package com.iheartradio.m3u8.data;

import android.support.v4.media.h;
import java.util.Objects;

public class Playlist {
    public static final int MIN_COMPATIBILITY_VERSION = 1;
    private final int mCompatibilityVersion;
    private final boolean mIsExtended;
    private final MasterPlaylist mMasterPlaylist;
    private final MediaPlaylist mMediaPlaylist;

    public static class Builder {
        private int mCompatibilityVersion;
        private boolean mIsExtended;
        private MasterPlaylist mMasterPlaylist;
        private MediaPlaylist mMediaPlaylist;

        public Builder() {
            this.mCompatibilityVersion = 1;
        }

        public Playlist build() {
            return new Playlist(this.mMasterPlaylist, this.mMediaPlaylist, this.mIsExtended, this.mCompatibilityVersion);
        }

        public Builder withCompatibilityVersion(int i10) {
            this.mCompatibilityVersion = i10;
            return this;
        }

        public Builder withExtended(boolean z10) {
            this.mIsExtended = z10;
            return this;
        }

        public Builder withMasterPlaylist(MasterPlaylist masterPlaylist) {
            this.mMasterPlaylist = masterPlaylist;
            return withExtended(true);
        }

        public Builder withMediaPlaylist(MediaPlaylist mediaPlaylist) {
            this.mMediaPlaylist = mediaPlaylist;
            return this;
        }

        private Builder(MasterPlaylist masterPlaylist, MediaPlaylist mediaPlaylist, boolean z10, int i10) {
            this.mMasterPlaylist = masterPlaylist;
            this.mMediaPlaylist = mediaPlaylist;
            this.mIsExtended = z10;
            this.mCompatibilityVersion = i10;
        }
    }

    private Playlist(MasterPlaylist masterPlaylist, MediaPlaylist mediaPlaylist, boolean z10, int i10) {
        this.mMasterPlaylist = masterPlaylist;
        this.mMediaPlaylist = mediaPlaylist;
        this.mIsExtended = z10;
        this.mCompatibilityVersion = i10;
    }

    public Builder buildUpon() {
        return new Builder(this.mMasterPlaylist, this.mMediaPlaylist, this.mIsExtended, this.mCompatibilityVersion);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Playlist)) {
            return false;
        }
        Playlist playlist = (Playlist) obj;
        return Objects.equals(this.mMasterPlaylist, playlist.mMasterPlaylist) && Objects.equals(this.mMediaPlaylist, playlist.mMediaPlaylist) && this.mIsExtended == playlist.mIsExtended && this.mCompatibilityVersion == playlist.mCompatibilityVersion;
    }

    public int getCompatibilityVersion() {
        return this.mCompatibilityVersion;
    }

    public MasterPlaylist getMasterPlaylist() {
        return this.mMasterPlaylist;
    }

    public MediaPlaylist getMediaPlaylist() {
        return this.mMediaPlaylist;
    }

    public boolean hasMasterPlaylist() {
        return this.mMasterPlaylist != null;
    }

    public boolean hasMediaPlaylist() {
        return this.mMediaPlaylist != null;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(this.mCompatibilityVersion), Boolean.valueOf(this.mIsExtended), this.mMasterPlaylist, this.mMediaPlaylist});
    }

    public boolean isExtended() {
        return this.mIsExtended;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("(Playlist mMasterPlaylist=");
        sb2.append(this.mMasterPlaylist);
        sb2.append(" mMediaPlaylist=");
        sb2.append(this.mMediaPlaylist);
        sb2.append(" mIsExtended=");
        sb2.append(this.mIsExtended);
        sb2.append(" mCompatibilityVersion=");
        return h.o(sb2, this.mCompatibilityVersion, ")");
    }
}
