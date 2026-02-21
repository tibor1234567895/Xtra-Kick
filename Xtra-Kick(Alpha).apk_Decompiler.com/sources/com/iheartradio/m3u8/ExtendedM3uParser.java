package com.iheartradio.m3u8;

import com.iheartradio.m3u8.data.Playlist;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

class ExtendedM3uParser extends BaseM3uParser {
    private final Map<String, IExtTagParser> mExtTagParsers = new HashMap();
    private final ParsingMode mParsingMode;

    public ExtendedM3uParser(InputStream inputStream, Encoding encoding, ParsingMode parsingMode) {
        super(inputStream, encoding);
        this.mParsingMode = parsingMode;
        putParsers(ExtLineParser.EXTM3U_HANDLER, ExtLineParser.EXT_X_VERSION_HANDLER, MediaPlaylistLineParser.EXT_X_PLAYLIST_TYPE, MediaPlaylistLineParser.EXT_X_PROGRAM_DATE_TIME, MediaPlaylistLineParser.EXT_X_KEY, MediaPlaylistLineParser.EXT_X_TARGETDURATION, MediaPlaylistLineParser.EXT_X_START, MediaPlaylistLineParser.EXT_X_MEDIA_SEQUENCE, MediaPlaylistLineParser.EXT_X_I_FRAMES_ONLY, MasterPlaylistLineParser.EXT_X_MEDIA, MediaPlaylistLineParser.EXT_X_ALLOW_CACHE, MasterPlaylistLineParser.EXT_X_STREAM_INF, MasterPlaylistLineParser.EXT_X_I_FRAME_STREAM_INF, MediaPlaylistLineParser.EXTINF, MediaPlaylistLineParser.EXT_X_ENDLIST, MediaPlaylistLineParser.EXT_X_DISCONTINUITY);
    }

    private void checkWhitespace(String str) throws ParseException {
        if (!isComment(str) && str.length() != str.trim().length()) {
            throw ParseException.create(ParseExceptionType.WHITESPACE_IN_TRACK, str);
        }
    }

    private String getExtTagKey(String str) {
        int indexOf = str.indexOf(Constants.EXT_TAG_END);
        return indexOf == -1 ? str.substring(1) : str.substring(1, indexOf);
    }

    private boolean isComment(String str) {
        return str.startsWith(Constants.COMMENT_PREFIX) && !isExtTag(str);
    }

    private boolean isExtTag(String str) {
        return str.startsWith(Constants.EXT_TAG_PREFIX);
    }

    private void putParsers(IExtTagParser... iExtTagParserArr) {
        if (iExtTagParserArr != null) {
            for (IExtTagParser iExtTagParser : iExtTagParserArr) {
                this.mExtTagParsers.put(iExtTagParser.getTag(), iExtTagParser);
            }
        }
    }

    public Playlist parse() throws IOException, ParseException, PlaylistException {
        validateAvailable();
        ParseState parseState = new ParseState(this.mEncoding);
        PlaylistLineParser playlistLineParser = new PlaylistLineParser();
        TrackLineParser trackLineParser = new TrackLineParser();
        while (true) {
            try {
                if (!this.mScanner.hasNext()) {
                    break;
                }
                String next = this.mScanner.next();
                checkWhitespace(next);
                if (next.length() != 0) {
                    if (!isComment(next)) {
                        if (isExtTag(next)) {
                            String extTagKey = getExtTagKey(next);
                            IExtTagParser iExtTagParser = this.mExtTagParsers.get(extTagKey);
                            if (iExtTagParser == null) {
                                if (this.mParsingMode.allowUnknownTags) {
                                    iExtTagParser = ExtLineParser.EXT_UNKNOWN_HANDLER;
                                } else {
                                    throw ParseException.create(ParseExceptionType.UNSUPPORTED_EXT_TAG_DETECTED, extTagKey, next);
                                }
                            }
                            iExtTagParser.parse(next, parseState);
                            if (parseState.isMedia() && parseState.getMedia().endOfList) {
                                break;
                            }
                        } else if (parseState.isMaster()) {
                            playlistLineParser.parse(next, parseState);
                        } else if (parseState.isMedia()) {
                            trackLineParser.parse(next, parseState);
                        } else {
                            throw ParseException.create(ParseExceptionType.UNKNOWN_PLAYLIST_TYPE, next);
                        }
                    }
                }
            } catch (ParseException e10) {
                e10.setInput(this.mScanner.getInput());
                throw e10;
            }
        }
        Playlist buildPlaylist = parseState.buildPlaylist();
        PlaylistValidation from = PlaylistValidation.from(buildPlaylist, this.mParsingMode);
        if (from.isValid()) {
            return buildPlaylist;
        }
        throw new PlaylistException(this.mScanner.getInput(), from.getErrors());
    }
}
