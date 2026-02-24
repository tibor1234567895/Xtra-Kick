package com.iheartradio.m3u8;

import com.iheartradio.m3u8.data.PlaylistData;

class PlaylistHandler implements LineHandler {
    public void handle(String str, ParseState parseState) {
        PlaylistData.Builder builder = new PlaylistData.Builder();
        if (Constants.URL_PATTERN.matcher(str).matches()) {
            builder.withUrl(str);
        } else {
            builder.withPath(str);
        }
        MasterParseState master = parseState.getMaster();
        master.playlists.add(builder.withStreamInfo(master.streamInfo).build());
        master.streamInfo = null;
    }
}
