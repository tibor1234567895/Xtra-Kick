package com.iheartradio.m3u8;

import com.iheartradio.m3u8.data.TrackData;

class TrackHandler implements LineHandler {
    public void handle(String str, ParseState parseState) throws ParseException {
        TrackData.Builder builder = new TrackData.Builder();
        MediaParseState media = parseState.getMedia();
        if (!parseState.isExtended() || media.trackInfo != null) {
            if (Constants.URL_PATTERN.matcher(str).matches()) {
                builder.withUrl(str);
            } else {
                builder.withPath(str);
            }
            media.tracks.add(builder.withTrackInfo(media.trackInfo).withEncryptionData(media.encryptionData).build());
            media.trackInfo = null;
            return;
        }
        throw ParseException.create(ParseExceptionType.MISSING_TRACK_INFO, str);
    }
}
