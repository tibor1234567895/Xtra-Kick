package com.iheartradio.m3u8.data;

import java.util.List;
import java.util.Objects;

public class MasterPlaylist {
    private final List<IFrameStreamInfo> mIFramePlaylists;
    private final List<MediaData> mMediaData;
    private final List<PlaylistData> mPlaylists;
    private final List<String> mUnknownTags;

    public static class Builder {
        private List<IFrameStreamInfo> mIFramePlaylists;
        private List<MediaData> mMediaData;
        private List<PlaylistData> mPlaylists;
        private List<String> mUnknownTags;

        public Builder() {
        }

        private Builder(List<PlaylistData> list, List<MediaData> list2) {
            this.mPlaylists = list;
            this.mMediaData = list2;
        }

        public MasterPlaylist build() {
            return new MasterPlaylist(this.mPlaylists, this.mIFramePlaylists, this.mMediaData, this.mUnknownTags);
        }

        public Builder withIFramePlaylists(List<IFrameStreamInfo> list) {
            this.mIFramePlaylists = list;
            return this;
        }

        public Builder withMediaData(List<MediaData> list) {
            this.mMediaData = list;
            return this;
        }

        public Builder withPlaylists(List<PlaylistData> list) {
            this.mPlaylists = list;
            return this;
        }

        public Builder withUnknownTags(List<String> list) {
            this.mUnknownTags = list;
            return this;
        }

        private Builder(List<PlaylistData> list, List<IFrameStreamInfo> list2, List<MediaData> list3, List<String> list4) {
            this.mPlaylists = list;
            this.mIFramePlaylists = list2;
            this.mMediaData = list3;
            this.mUnknownTags = list4;
        }
    }

    private MasterPlaylist(List<PlaylistData> list, List<IFrameStreamInfo> list2, List<MediaData> list3, List<String> list4) {
        this.mPlaylists = DataUtil.emptyOrUnmodifiable(list);
        this.mIFramePlaylists = DataUtil.emptyOrUnmodifiable(list2);
        this.mMediaData = DataUtil.emptyOrUnmodifiable(list3);
        this.mUnknownTags = DataUtil.emptyOrUnmodifiable(list4);
    }

    public Builder buildUpon() {
        return new Builder(this.mPlaylists, this.mIFramePlaylists, this.mMediaData, this.mUnknownTags);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof MasterPlaylist)) {
            return false;
        }
        MasterPlaylist masterPlaylist = (MasterPlaylist) obj;
        return Objects.equals(this.mMediaData, masterPlaylist.mMediaData) && Objects.equals(this.mPlaylists, masterPlaylist.mPlaylists) && Objects.equals(this.mIFramePlaylists, masterPlaylist.mIFramePlaylists) && Objects.equals(this.mUnknownTags, masterPlaylist.mUnknownTags);
    }

    public List<IFrameStreamInfo> getIFramePlaylists() {
        return this.mIFramePlaylists;
    }

    public List<MediaData> getMediaData() {
        return this.mMediaData;
    }

    public List<PlaylistData> getPlaylists() {
        return this.mPlaylists;
    }

    public List<String> getUnknownTags() {
        return this.mUnknownTags;
    }

    public boolean hasUnknownTags() {
        return this.mUnknownTags.size() > 0;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.mMediaData, this.mPlaylists, this.mIFramePlaylists, this.mUnknownTags});
    }

    public String toString() {
        return "(MasterPlaylist mPlaylists=" + this.mPlaylists.toString() + " mIFramePlaylists=" + this.mIFramePlaylists.toString() + " mMediaData=" + this.mMediaData.toString() + " mUnknownTags=" + this.mUnknownTags.toString() + ")";
    }
}
