package com.iheartradio.m3u8;

import com.iheartradio.m3u8.data.IFrameStreamInfo;
import com.iheartradio.m3u8.data.MasterPlaylist;
import com.iheartradio.m3u8.data.MediaData;
import com.iheartradio.m3u8.data.PlaylistData;
import com.iheartradio.m3u8.data.StreamInfo;
import java.util.ArrayList;
import java.util.List;

class MasterParseState implements IParseState<MasterPlaylist> {
    public final List<IFrameStreamInfo> iFramePlaylists = new ArrayList();
    public boolean isDefault;
    public boolean isNotAutoSelect;
    public final List<MediaData> mediaData = new ArrayList();
    public final List<PlaylistData> playlists = new ArrayList();
    public StreamInfo streamInfo;
    public final List<String> unknownTags = new ArrayList();

    public MasterPlaylist buildPlaylist() throws ParseException {
        return new MasterPlaylist.Builder().withPlaylists(this.playlists).withIFramePlaylists(this.iFramePlaylists).withMediaData(this.mediaData).withUnknownTags(this.unknownTags).build();
    }

    public void clearMediaDataState() {
        this.isDefault = false;
        this.isNotAutoSelect = false;
    }
}
