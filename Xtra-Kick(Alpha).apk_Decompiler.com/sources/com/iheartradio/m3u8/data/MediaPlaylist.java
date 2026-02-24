package com.iheartradio.m3u8.data;

import java.util.List;
import java.util.Objects;

public class MediaPlaylist {
    private final boolean mIsIframesOnly;
    private final boolean mIsOngoing;
    private final int mMediaSequenceNumber;
    private final PlaylistType mPlaylistType;
    private final StartData mStartData;
    private final int mTargetDuration;
    private final List<TrackData> mTracks;
    private final List<String> mUnknownTags;

    public static class Builder {
        private boolean mIsIframesOnly;
        private boolean mIsOngoing;
        private int mMediaSequenceNumber;
        private PlaylistType mPlaylistType;
        private StartData mStartData;
        private int mTargetDuration;
        private List<TrackData> mTracks;
        private List<String> mUnknownTags;

        public Builder() {
        }

        private Builder(List<TrackData> list, List<String> list2, int i10, int i11, boolean z10, boolean z11, PlaylistType playlistType, StartData startData) {
            this.mTracks = list;
            this.mUnknownTags = list2;
            this.mTargetDuration = i10;
            this.mMediaSequenceNumber = i11;
            this.mIsIframesOnly = z10;
            this.mIsOngoing = z11;
            this.mPlaylistType = playlistType;
            this.mStartData = startData;
        }

        public MediaPlaylist build() {
            return new MediaPlaylist(this.mTracks, this.mUnknownTags, this.mTargetDuration, this.mStartData, this.mMediaSequenceNumber, this.mIsIframesOnly, this.mIsOngoing, this.mPlaylistType);
        }

        public Builder withIsIframesOnly(boolean z10) {
            this.mIsIframesOnly = z10;
            return this;
        }

        public Builder withIsOngoing(boolean z10) {
            this.mIsOngoing = z10;
            return this;
        }

        public Builder withMediaSequenceNumber(int i10) {
            this.mMediaSequenceNumber = i10;
            return this;
        }

        public Builder withPlaylistType(PlaylistType playlistType) {
            this.mPlaylistType = playlistType;
            return this;
        }

        public Builder withStartData(StartData startData) {
            this.mStartData = startData;
            return this;
        }

        public Builder withTargetDuration(int i10) {
            this.mTargetDuration = i10;
            return this;
        }

        public Builder withTracks(List<TrackData> list) {
            this.mTracks = list;
            return this;
        }

        public Builder withUnknownTags(List<String> list) {
            this.mUnknownTags = list;
            return this;
        }
    }

    private MediaPlaylist(List<TrackData> list, List<String> list2, int i10, StartData startData, int i11, boolean z10, boolean z11, PlaylistType playlistType) {
        this.mTracks = DataUtil.emptyOrUnmodifiable(list);
        this.mUnknownTags = DataUtil.emptyOrUnmodifiable(list2);
        this.mTargetDuration = i10;
        this.mMediaSequenceNumber = i11;
        this.mIsIframesOnly = z10;
        this.mIsOngoing = z11;
        this.mStartData = startData;
        this.mPlaylistType = playlistType;
    }

    public Builder buildUpon() {
        return new Builder(this.mTracks, this.mUnknownTags, this.mTargetDuration, this.mMediaSequenceNumber, this.mIsIframesOnly, this.mIsOngoing, this.mPlaylistType, this.mStartData);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof MediaPlaylist)) {
            return false;
        }
        MediaPlaylist mediaPlaylist = (MediaPlaylist) obj;
        return Objects.equals(this.mTracks, mediaPlaylist.mTracks) && Objects.equals(this.mUnknownTags, mediaPlaylist.mUnknownTags) && this.mTargetDuration == mediaPlaylist.mTargetDuration && this.mMediaSequenceNumber == mediaPlaylist.mMediaSequenceNumber && this.mIsIframesOnly == mediaPlaylist.mIsIframesOnly && this.mIsOngoing == mediaPlaylist.mIsOngoing && Objects.equals(this.mPlaylistType, mediaPlaylist.mPlaylistType) && Objects.equals(this.mStartData, mediaPlaylist.mStartData);
    }

    public int getDiscontinuitySequenceNumber(int i10) {
        if (i10 < 0 || i10 >= this.mTracks.size()) {
            throw new IndexOutOfBoundsException();
        }
        int i11 = 0;
        for (int i12 = 0; i12 <= i10; i12++) {
            if (this.mTracks.get(i12).hasDiscontinuity()) {
                i11++;
            }
        }
        return i11;
    }

    public int getMediaSequenceNumber() {
        return this.mMediaSequenceNumber;
    }

    public PlaylistType getPlaylistType() {
        return this.mPlaylistType;
    }

    public StartData getStartData() {
        return this.mStartData;
    }

    public int getTargetDuration() {
        return this.mTargetDuration;
    }

    public List<TrackData> getTracks() {
        return this.mTracks;
    }

    public List<String> getUnknownTags() {
        return this.mUnknownTags;
    }

    public boolean hasPlaylistType() {
        return this.mPlaylistType != null;
    }

    public boolean hasStartData() {
        return this.mStartData != null;
    }

    public boolean hasTracks() {
        return !this.mTracks.isEmpty();
    }

    public boolean hasUnknownTags() {
        return !this.mUnknownTags.isEmpty();
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.mTracks, this.mUnknownTags, Integer.valueOf(this.mTargetDuration), Integer.valueOf(this.mMediaSequenceNumber), Boolean.valueOf(this.mIsIframesOnly), Boolean.valueOf(this.mIsOngoing), this.mPlaylistType, this.mStartData});
    }

    public boolean isIframesOnly() {
        return this.mIsIframesOnly;
    }

    public boolean isOngoing() {
        return this.mIsOngoing;
    }

    public String toString() {
        return "(MediaPlaylist mTracks=" + this.mTracks + " mUnknownTags=" + this.mUnknownTags + " mTargetDuration=" + this.mTargetDuration + " mMediaSequenceNumber=" + this.mMediaSequenceNumber + " mIsIframesOnly=" + this.mIsIframesOnly + " mIsOngoing=" + this.mIsOngoing + " mPlaylistType=" + this.mPlaylistType + " mStartData=" + this.mStartData + ")";
    }
}
