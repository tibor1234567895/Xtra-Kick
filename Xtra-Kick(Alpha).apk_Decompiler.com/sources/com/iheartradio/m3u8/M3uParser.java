package com.iheartradio.m3u8;

import com.iheartradio.m3u8.data.MediaPlaylist;
import com.iheartradio.m3u8.data.Playlist;
import java.io.IOException;
import java.io.InputStream;

class M3uParser extends BaseM3uParser {
    public M3uParser(InputStream inputStream, Encoding encoding) {
        super(inputStream, encoding);
    }

    private boolean isComment(String str) {
        return str.indexOf(Constants.COMMENT_PREFIX) == 0;
    }

    private void validateLine(String str) throws ParseException {
        if (!isComment(str) && str.length() != str.trim().length()) {
            ParseExceptionType parseExceptionType = ParseExceptionType.WHITESPACE_IN_TRACK;
            throw ParseException.create(parseExceptionType, str, "" + str.length());
        }
    }

    public Playlist parse() throws IOException, ParseException, PlaylistException {
        validateAvailable();
        ParseState parseState = new ParseState(this.mEncoding);
        TrackLineParser trackLineParser = new TrackLineParser();
        try {
            parseState.setMedia();
            while (this.mScanner.hasNext()) {
                String next = this.mScanner.next();
                validateLine(next);
                if (next.length() != 0) {
                    if (!isComment(next)) {
                        trackLineParser.parse(next, parseState);
                    }
                }
            }
            Playlist build = new Playlist.Builder().withMediaPlaylist(new MediaPlaylist.Builder().withTracks(parseState.getMedia().tracks).build()).build();
            PlaylistValidation from = PlaylistValidation.from(build);
            if (from.isValid()) {
                return build;
            }
            throw new PlaylistException(this.mScanner.getInput(), from.getErrors());
        } catch (ParseException e10) {
            e10.setInput(this.mScanner.getInput());
            throw e10;
        }
    }
}
