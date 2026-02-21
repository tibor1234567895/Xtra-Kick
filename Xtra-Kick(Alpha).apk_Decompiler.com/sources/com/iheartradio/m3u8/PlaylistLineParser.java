package com.iheartradio.m3u8;

import com.iheartradio.m3u8.data.PlaylistData;

class PlaylistLineParser implements LineParser {
    public void parse(String str, ParseState parseState) {
        PlaylistData.Builder builder = new PlaylistData.Builder();
        MasterParseState master = parseState.getMaster();
        master.playlists.add(builder.withUri(str).withStreamInfo(master.streamInfo).build());
        master.streamInfo = null;
    }
}
