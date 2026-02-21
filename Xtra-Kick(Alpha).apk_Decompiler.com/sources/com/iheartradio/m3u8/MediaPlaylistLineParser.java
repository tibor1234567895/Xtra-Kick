package com.iheartradio.m3u8;

import com.iheartradio.m3u8.data.EncryptionData;
import com.iheartradio.m3u8.data.EncryptionMethod;
import com.iheartradio.m3u8.data.PlaylistType;
import com.iheartradio.m3u8.data.StartData;
import com.iheartradio.m3u8.data.TrackInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;

class MediaPlaylistLineParser implements LineParser {
    static final IExtTagParser EXTINF = new IExtTagParser() {
        private final LineParser lineParser = new MediaPlaylistLineParser(this);

        public String getTag() {
            return Constants.EXTINF_TAG;
        }

        public boolean hasData() {
            return true;
        }

        public void parse(String str, ParseState parseState) throws ParseException {
            this.lineParser.parse(str, parseState);
            Matcher match = ParseUtil.match(Constants.EXTINF_PATTERN, str, getTag());
            parseState.getMedia().trackInfo = new TrackInfo(ParseUtil.parseFloat(match.group(1), getTag()), match.group(2));
        }
    };
    static final IExtTagParser EXT_X_ALLOW_CACHE = new IExtTagParser() {
        private final LineParser lineParser = new MediaPlaylistLineParser(this);

        public String getTag() {
            return Constants.EXT_X_ALLOW_CACHE_TAG;
        }

        public boolean hasData() {
            return true;
        }

        public void parse(String str, ParseState parseState) throws ParseException {
            this.lineParser.parse(str, parseState);
        }
    };
    static final IExtTagParser EXT_X_DISCONTINUITY = new IExtTagParser() {
        private final LineParser lineParser = new MediaPlaylistLineParser(this);

        public String getTag() {
            return Constants.EXT_X_DISCONTINUITY_TAG;
        }

        public boolean hasData() {
            return false;
        }

        public void parse(String str, ParseState parseState) throws ParseException {
            this.lineParser.parse(str, parseState);
            ParseUtil.match(Constants.EXT_X_DISCONTINUITY_PATTERN, str, getTag());
            parseState.getMedia().hasDiscontinuity = true;
        }
    };
    static final IExtTagParser EXT_X_ENDLIST = new IExtTagParser() {
        private final LineParser lineParser = new MediaPlaylistLineParser(this);

        public String getTag() {
            return Constants.EXT_X_ENDLIST_TAG;
        }

        public boolean hasData() {
            return false;
        }

        public void parse(String str, ParseState parseState) throws ParseException {
            this.lineParser.parse(str, parseState);
            ParseUtil.match(Constants.EXT_X_ENDLIST_PATTERN, str, getTag());
            parseState.getMedia().endOfList = true;
        }
    };
    static final IExtTagParser EXT_X_I_FRAMES_ONLY = new IExtTagParser() {
        private final LineParser lineParser = new MediaPlaylistLineParser(this);

        public String getTag() {
            return Constants.EXT_X_I_FRAMES_ONLY_TAG;
        }

        public boolean hasData() {
            return false;
        }

        public void parse(String str, ParseState parseState) throws ParseException {
            this.lineParser.parse(str, parseState);
            ParseUtil.match(Constants.EXT_X_I_FRAMES_ONLY_PATTERN, str, getTag());
            if (parseState.getCompatibilityVersion() >= 4) {
                parseState.setIsIframesOnly();
                return;
            }
            throw ParseException.create(ParseExceptionType.REQUIRES_PROTOCOL_VERSION_4_OR_HIGHER, getTag());
        }
    };
    static final IExtTagParser EXT_X_KEY = new IExtTagParser() {
        private final Map<String, AttributeParser<EncryptionData.Builder>> HANDLERS;
        private final LineParser lineParser = new MediaPlaylistLineParser(this);

        {
            HashMap hashMap = new HashMap();
            this.HANDLERS = hashMap;
            hashMap.put(Constants.METHOD, new AttributeParser<EncryptionData.Builder>() {
                public void parse(Attribute attribute, EncryptionData.Builder builder, ParseState parseState) throws ParseException {
                    EncryptionMethod fromValue = EncryptionMethod.fromValue(attribute.value);
                    if (fromValue != null) {
                        builder.withMethod(fromValue);
                        return;
                    }
                    throw ParseException.create(ParseExceptionType.INVALID_ENCRYPTION_METHOD, AnonymousClass11.this.getTag(), attribute.toString());
                }
            });
            hashMap.put(Constants.URI, new AttributeParser<EncryptionData.Builder>() {
                public void parse(Attribute attribute, EncryptionData.Builder builder, ParseState parseState) throws ParseException {
                    builder.withUri(ParseUtil.decodeUri(ParseUtil.parseQuotedString(attribute.value, AnonymousClass11.this.getTag()), parseState.encoding));
                }
            });
            hashMap.put(Constants.IV, new AttributeParser<EncryptionData.Builder>() {
                public void parse(Attribute attribute, EncryptionData.Builder builder, ParseState parseState) throws ParseException {
                    List<Byte> parseHexadecimal = ParseUtil.parseHexadecimal(attribute.value, AnonymousClass11.this.getTag());
                    if (parseHexadecimal.size() == 16 || parseHexadecimal.size() == 32) {
                        builder.withInitializationVector(parseHexadecimal);
                        return;
                    }
                    throw ParseException.create(ParseExceptionType.INVALID_IV_SIZE, AnonymousClass11.this.getTag(), attribute.toString());
                }
            });
            hashMap.put(Constants.KEY_FORMAT, new AttributeParser<EncryptionData.Builder>() {
                public void parse(Attribute attribute, EncryptionData.Builder builder, ParseState parseState) throws ParseException {
                    builder.withKeyFormat(ParseUtil.parseQuotedString(attribute.value, AnonymousClass11.this.getTag()));
                }
            });
            hashMap.put(Constants.KEY_FORMAT_VERSIONS, new AttributeParser<EncryptionData.Builder>() {
                public void parse(Attribute attribute, EncryptionData.Builder builder, ParseState parseState) throws ParseException {
                    String[] split = ParseUtil.parseQuotedString(attribute.value, AnonymousClass11.this.getTag()).split(Constants.LIST_SEPARATOR);
                    ArrayList arrayList = new ArrayList();
                    int length = split.length;
                    int i10 = 0;
                    while (i10 < length) {
                        try {
                            arrayList.add(Integer.valueOf(Integer.parseInt(split[i10])));
                            i10++;
                        } catch (NumberFormatException unused) {
                            throw ParseException.create(ParseExceptionType.INVALID_KEY_FORMAT_VERSIONS, AnonymousClass11.this.getTag(), attribute.toString());
                        }
                    }
                    builder.withKeyFormatVersions(arrayList);
                }
            });
        }

        public String getTag() {
            return Constants.EXT_X_KEY_TAG;
        }

        public boolean hasData() {
            return true;
        }

        public void parse(String str, ParseState parseState) throws ParseException {
            this.lineParser.parse(str, parseState);
            EncryptionData.Builder withKeyFormatVersions = new EncryptionData.Builder().withKeyFormat(Constants.DEFAULT_KEY_FORMAT).withKeyFormatVersions(Constants.DEFAULT_KEY_FORMAT_VERSIONS);
            ParseUtil.parseAttributes(str, withKeyFormatVersions, parseState, this.HANDLERS, getTag());
            EncryptionData build = withKeyFormatVersions.build();
            if (build.getMethod() == EncryptionMethod.NONE || build.getUri() != null) {
                parseState.getMedia().encryptionData = build;
                return;
            }
            throw ParseException.create(ParseExceptionType.MISSING_ENCRYPTION_URI, getTag(), str);
        }
    };
    static final IExtTagParser EXT_X_MEDIA_SEQUENCE = new IExtTagParser() {
        private final LineParser lineParser = new MediaPlaylistLineParser(this);

        public String getTag() {
            return Constants.EXT_X_MEDIA_SEQUENCE_TAG;
        }

        public boolean hasData() {
            return true;
        }

        public void parse(String str, ParseState parseState) throws ParseException {
            this.lineParser.parse(str, parseState);
            Matcher match = ParseUtil.match(Constants.EXT_X_MEDIA_SEQUENCE_PATTERN, str, getTag());
            if (parseState.getMedia().mediaSequenceNumber == null) {
                parseState.getMedia().mediaSequenceNumber = Integer.valueOf(ParseUtil.parseInt(match.group(1), getTag()));
                return;
            }
            throw ParseException.create(ParseExceptionType.MULTIPLE_EXT_TAG_INSTANCES, getTag(), str);
        }
    };
    static final IExtTagParser EXT_X_PLAYLIST_TYPE = new IExtTagParser() {
        private final LineParser lineParser = new MediaPlaylistLineParser(this);

        public String getTag() {
            return Constants.EXT_X_PLAYLIST_TYPE_TAG;
        }

        public boolean hasData() {
            return true;
        }

        public void parse(String str, ParseState parseState) throws ParseException {
            this.lineParser.parse(str, parseState);
            Matcher match = ParseUtil.match(Constants.EXT_X_PLAYLIST_TYPE_PATTERN, str, getTag());
            if (parseState.getMedia().playlistType == null) {
                parseState.getMedia().playlistType = (PlaylistType) ParseUtil.parseEnum(match.group(1), PlaylistType.class, getTag());
                return;
            }
            throw ParseException.create(ParseExceptionType.MULTIPLE_EXT_TAG_INSTANCES, getTag(), str);
        }
    };
    static final IExtTagParser EXT_X_PROGRAM_DATE_TIME = new IExtTagParser() {
        private final LineParser lineParser = new MediaPlaylistLineParser(this);

        public String getTag() {
            return Constants.EXT_X_PROGRAM_DATE_TIME_TAG;
        }

        public boolean hasData() {
            return true;
        }

        public void parse(String str, ParseState parseState) throws ParseException {
            this.lineParser.parse(str, parseState);
            ParseUtil.match(Constants.EXT_X_PROGRAM_DATE_TIME_PATTERN, str, getTag());
            if (parseState.getMedia().programDateTime == null) {
                parseState.getMedia().programDateTime = ParseUtil.parseDateTime(str, getTag());
                return;
            }
            throw ParseException.create(ParseExceptionType.MULTIPLE_EXT_TAG_INSTANCES, getTag(), str);
        }
    };
    static final IExtTagParser EXT_X_START = new IExtTagParser() {
        private final Map<String, AttributeParser<StartData.Builder>> HANDLERS;
        private final LineParser lineParser = new MediaPlaylistLineParser(this);

        {
            HashMap hashMap = new HashMap();
            this.HANDLERS = hashMap;
            hashMap.put(Constants.TIME_OFFSET, new AttributeParser<StartData.Builder>() {
                public void parse(Attribute attribute, StartData.Builder builder, ParseState parseState) throws ParseException {
                    builder.withTimeOffset(ParseUtil.parseFloat(attribute.value, AnonymousClass5.this.getTag()));
                }
            });
            hashMap.put(Constants.PRECISE, new AttributeParser<StartData.Builder>() {
                public void parse(Attribute attribute, StartData.Builder builder, ParseState parseState) throws ParseException {
                    builder.withPrecise(ParseUtil.parseYesNo(attribute, AnonymousClass5.this.getTag()));
                }
            });
        }

        public String getTag() {
            return Constants.EXT_X_START_TAG;
        }

        public boolean hasData() {
            return true;
        }

        public void parse(String str, ParseState parseState) throws ParseException {
            this.lineParser.parse(str, parseState);
            StartData.Builder builder = new StartData.Builder();
            ParseUtil.parseAttributes(str, builder, parseState, this.HANDLERS, getTag());
            parseState.getMedia().startData = builder.build();
        }
    };
    static final IExtTagParser EXT_X_TARGETDURATION = new IExtTagParser() {
        private final LineParser lineParser = new MediaPlaylistLineParser(this);

        public String getTag() {
            return Constants.EXT_X_TARGETDURATION_TAG;
        }

        public boolean hasData() {
            return true;
        }

        public void parse(String str, ParseState parseState) throws ParseException {
            this.lineParser.parse(str, parseState);
            Matcher match = ParseUtil.match(Constants.EXT_X_TARGETDURATION_PATTERN, str, getTag());
            if (parseState.getMedia().targetDuration == null) {
                parseState.getMedia().targetDuration = Integer.valueOf(ParseUtil.parseInt(match.group(1), getTag()));
                return;
            }
            throw ParseException.create(ParseExceptionType.MULTIPLE_EXT_TAG_INSTANCES, getTag(), str);
        }
    };
    private final LineParser lineParser;
    private final IExtTagParser tagParser;

    public MediaPlaylistLineParser(IExtTagParser iExtTagParser) {
        this(iExtTagParser, new ExtLineParser(iExtTagParser));
    }

    public void parse(String str, ParseState parseState) throws ParseException {
        if (!parseState.isMaster()) {
            parseState.setMedia();
            this.lineParser.parse(str, parseState);
            return;
        }
        throw ParseException.create(ParseExceptionType.MEDIA_IN_MASTER, this.tagParser.getTag());
    }

    public MediaPlaylistLineParser(IExtTagParser iExtTagParser, LineParser lineParser2) {
        this.tagParser = iExtTagParser;
        this.lineParser = lineParser2;
    }
}
