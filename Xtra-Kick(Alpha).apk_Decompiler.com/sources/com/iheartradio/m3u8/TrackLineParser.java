package com.iheartradio.m3u8;

import com.iheartradio.m3u8.data.TrackData;

class TrackLineParser implements LineParser {
    public void parse(String str, ParseState parseState) throws ParseException {
        TrackData.Builder builder = new TrackData.Builder();
        MediaParseState media = parseState.getMedia();
        if (!parseState.isExtended() || media.trackInfo != null) {
            media.tracks.add(builder.withUri(str).withTrackInfo(media.trackInfo).withEncryptionData(media.encryptionData).withProgramDateTime(media.programDateTime).withDiscontinuity(media.hasDiscontinuity).build());
            media.trackInfo = null;
            media.programDateTime = null;
            media.hasDiscontinuity = false;
            return;
        }
        throw ParseException.create(ParseExceptionType.MISSING_TRACK_INFO, str);
    }
}
