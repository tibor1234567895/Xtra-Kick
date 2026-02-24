package com.iheartradio.m3u8;

import com.iheartradio.m3u8.data.IFrameStreamInfo;
import com.iheartradio.m3u8.data.MediaData;
import com.iheartradio.m3u8.data.MediaType;
import com.iheartradio.m3u8.data.StreamInfo;
import com.iheartradio.m3u8.data.StreamInfoBuilder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class MasterPlaylistLineParser implements LineParser {
    static final IExtTagParser EXT_X_I_FRAME_STREAM_INF = new IExtTagParser() {
        private final Map<String, AttributeParser<IFrameStreamInfo.Builder>> HANDLERS;
        private final LineParser mLineParser = new MasterPlaylistLineParser(this);

        {
            Map<String, AttributeParser<IFrameStreamInfo.Builder>> makeExtStreamInfHandlers = MasterPlaylistLineParser.makeExtStreamInfHandlers(getTag());
            this.HANDLERS = makeExtStreamInfHandlers;
            makeExtStreamInfHandlers.put(Constants.URI, new AttributeParser<IFrameStreamInfo.Builder>() {
                public void parse(Attribute attribute, IFrameStreamInfo.Builder builder, ParseState parseState) throws ParseException {
                    builder.withUri(ParseUtil.parseQuotedString(attribute.value, AnonymousClass2.this.getTag()));
                }
            });
        }

        public String getTag() {
            return Constants.EXT_X_I_FRAME_STREAM_INF_TAG;
        }

        public boolean hasData() {
            return true;
        }

        public void parse(String str, ParseState parseState) throws ParseException {
            this.mLineParser.parse(str, parseState);
            IFrameStreamInfo.Builder builder = new IFrameStreamInfo.Builder();
            ParseUtil.parseAttributes(str, builder, parseState, this.HANDLERS, getTag());
            parseState.getMaster().iFramePlaylists.add(builder.build());
        }
    };
    static final IExtTagParser EXT_X_MEDIA = new IExtTagParser() {
        private final Map<String, AttributeParser<MediaData.Builder>> HANDLERS;
        private final LineParser mLineParser = new MasterPlaylistLineParser(this);

        {
            HashMap hashMap = new HashMap();
            this.HANDLERS = hashMap;
            hashMap.put(Constants.TYPE, new AttributeParser<MediaData.Builder>() {
                public void parse(Attribute attribute, MediaData.Builder builder, ParseState parseState) throws ParseException {
                    MediaType fromValue = MediaType.fromValue(attribute.value);
                    if (fromValue != null) {
                        builder.withType(fromValue);
                        return;
                    }
                    throw ParseException.create(ParseExceptionType.INVALID_MEDIA_TYPE, AnonymousClass1.this.getTag(), attribute.toString());
                }
            });
            hashMap.put(Constants.URI, new AttributeParser<MediaData.Builder>() {
                public void parse(Attribute attribute, MediaData.Builder builder, ParseState parseState) throws ParseException {
                    builder.withUri(ParseUtil.decodeUri(ParseUtil.parseQuotedString(attribute.value, AnonymousClass1.this.getTag()), parseState.encoding));
                }
            });
            hashMap.put(Constants.GROUP_ID, new AttributeParser<MediaData.Builder>() {
                public void parse(Attribute attribute, MediaData.Builder builder, ParseState parseState) throws ParseException {
                    String parseQuotedString = ParseUtil.parseQuotedString(attribute.value, AnonymousClass1.this.getTag());
                    if (!parseQuotedString.isEmpty()) {
                        builder.withGroupId(parseQuotedString);
                        return;
                    }
                    throw ParseException.create(ParseExceptionType.EMPTY_MEDIA_GROUP_ID, AnonymousClass1.this.getTag(), attribute.toString());
                }
            });
            hashMap.put(Constants.LANGUAGE, new AttributeParser<MediaData.Builder>() {
                public void parse(Attribute attribute, MediaData.Builder builder, ParseState parseState) throws ParseException {
                    builder.withLanguage(ParseUtil.parseQuotedString(attribute.value, AnonymousClass1.this.getTag()));
                }
            });
            hashMap.put(Constants.ASSOCIATED_LANGUAGE, new AttributeParser<MediaData.Builder>() {
                public void parse(Attribute attribute, MediaData.Builder builder, ParseState parseState) throws ParseException {
                    builder.withAssociatedLanguage(ParseUtil.parseQuotedString(attribute.value, AnonymousClass1.this.getTag()));
                }
            });
            hashMap.put(Constants.NAME, new AttributeParser<MediaData.Builder>() {
                public void parse(Attribute attribute, MediaData.Builder builder, ParseState parseState) throws ParseException {
                    String parseQuotedString = ParseUtil.parseQuotedString(attribute.value, AnonymousClass1.this.getTag());
                    if (!parseQuotedString.isEmpty()) {
                        builder.withName(parseQuotedString);
                        return;
                    }
                    throw ParseException.create(ParseExceptionType.EMPTY_MEDIA_NAME, AnonymousClass1.this.getTag(), attribute.toString());
                }
            });
            hashMap.put(Constants.DEFAULT, new AttributeParser<MediaData.Builder>() {
                public void parse(Attribute attribute, MediaData.Builder builder, ParseState parseState) throws ParseException {
                    boolean parseYesNo = ParseUtil.parseYesNo(attribute, AnonymousClass1.this.getTag());
                    builder.withDefault(parseYesNo);
                    parseState.getMaster().isDefault = parseYesNo;
                    if (!parseYesNo) {
                        return;
                    }
                    if (!parseState.getMaster().isNotAutoSelect) {
                        builder.withAutoSelect(true);
                        return;
                    }
                    throw ParseException.create(ParseExceptionType.AUTO_SELECT_DISABLED_FOR_DEFAULT, AnonymousClass1.this.getTag(), attribute.toString());
                }
            });
            hashMap.put(Constants.AUTO_SELECT, new AttributeParser<MediaData.Builder>() {
                public void parse(Attribute attribute, MediaData.Builder builder, ParseState parseState) throws ParseException {
                    boolean parseYesNo = ParseUtil.parseYesNo(attribute, AnonymousClass1.this.getTag());
                    builder.withAutoSelect(parseYesNo);
                    parseState.getMaster().isNotAutoSelect = !parseYesNo;
                    if (parseState.getMaster().isDefault && !parseYesNo) {
                        throw ParseException.create(ParseExceptionType.AUTO_SELECT_DISABLED_FOR_DEFAULT, AnonymousClass1.this.getTag(), attribute.toString());
                    }
                }
            });
            hashMap.put(Constants.FORCED, new AttributeParser<MediaData.Builder>() {
                public void parse(Attribute attribute, MediaData.Builder builder, ParseState parseState) throws ParseException {
                    builder.withForced(ParseUtil.parseYesNo(attribute, AnonymousClass1.this.getTag()));
                }
            });
            hashMap.put(Constants.IN_STREAM_ID, new AttributeParser<MediaData.Builder>() {
                public void parse(Attribute attribute, MediaData.Builder builder, ParseState parseState) throws ParseException {
                    String parseQuotedString = ParseUtil.parseQuotedString(attribute.value, AnonymousClass1.this.getTag());
                    if (Constants.EXT_X_MEDIA_IN_STREAM_ID_PATTERN.matcher(parseQuotedString).matches()) {
                        builder.withInStreamId(parseQuotedString);
                        return;
                    }
                    throw ParseException.create(ParseExceptionType.INVALID_MEDIA_IN_STREAM_ID, AnonymousClass1.this.getTag(), attribute.toString());
                }
            });
            hashMap.put(Constants.CHARACTERISTICS, new AttributeParser<MediaData.Builder>() {
                public void parse(Attribute attribute, MediaData.Builder builder, ParseState parseState) throws ParseException {
                    String[] split = ParseUtil.parseQuotedString(attribute.value, AnonymousClass1.this.getTag()).split(Constants.COMMA);
                    if (split.length != 0) {
                        builder.withCharacteristics(Arrays.asList(split));
                        return;
                    }
                    throw ParseException.create(ParseExceptionType.EMPTY_MEDIA_CHARACTERISTICS, AnonymousClass1.this.getTag(), attribute.toString());
                }
            });
        }

        public String getTag() {
            return Constants.EXT_X_MEDIA_TAG;
        }

        public boolean hasData() {
            return true;
        }

        public void parse(String str, ParseState parseState) throws ParseException {
            this.mLineParser.parse(str, parseState);
            MediaData.Builder builder = new MediaData.Builder();
            parseState.getMaster().clearMediaDataState();
            ParseUtil.parseAttributes(str, builder, parseState, this.HANDLERS, getTag());
            parseState.getMaster().mediaData.add(builder.build());
        }
    };
    static final IExtTagParser EXT_X_STREAM_INF = new IExtTagParser() {
        private final Map<String, AttributeParser<StreamInfo.Builder>> HANDLERS;
        private final LineParser mLineParser = new MasterPlaylistLineParser(this);

        {
            Map<String, AttributeParser<StreamInfo.Builder>> makeExtStreamInfHandlers = MasterPlaylistLineParser.makeExtStreamInfHandlers(getTag());
            this.HANDLERS = makeExtStreamInfHandlers;
            makeExtStreamInfHandlers.put(Constants.AUDIO, new AttributeParser<StreamInfo.Builder>() {
                public void parse(Attribute attribute, StreamInfo.Builder builder, ParseState parseState) throws ParseException {
                    builder.withAudio(ParseUtil.parseQuotedString(attribute.value, AnonymousClass3.this.getTag()));
                }
            });
            makeExtStreamInfHandlers.put(Constants.SUBTITLES, new AttributeParser<StreamInfo.Builder>() {
                public void parse(Attribute attribute, StreamInfo.Builder builder, ParseState parseState) throws ParseException {
                    builder.withSubtitles(ParseUtil.parseQuotedString(attribute.value, AnonymousClass3.this.getTag()));
                }
            });
            makeExtStreamInfHandlers.put(Constants.CLOSED_CAPTIONS, new AttributeParser<StreamInfo.Builder>() {
                public void parse(Attribute attribute, StreamInfo.Builder builder, ParseState parseState) throws ParseException {
                    if (!attribute.value.equals(Constants.NO_CLOSED_CAPTIONS)) {
                        builder.withClosedCaptions(ParseUtil.parseQuotedString(attribute.value, AnonymousClass3.this.getTag()));
                    }
                }
            });
        }

        public String getTag() {
            return Constants.EXT_X_STREAM_INF_TAG;
        }

        public boolean hasData() {
            return true;
        }

        public void parse(String str, ParseState parseState) throws ParseException {
            this.mLineParser.parse(str, parseState);
            StreamInfo.Builder builder = new StreamInfo.Builder();
            ParseUtil.parseAttributes(str, builder, parseState, this.HANDLERS, getTag());
            parseState.getMaster().streamInfo = builder.build();
        }
    };
    private final LineParser mLineParser;
    private final IExtTagParser mTagParser;

    public MasterPlaylistLineParser(IExtTagParser iExtTagParser) {
        this(iExtTagParser, new ExtLineParser(iExtTagParser));
    }

    public static <T extends StreamInfoBuilder> Map<String, AttributeParser<T>> makeExtStreamInfHandlers(final String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(Constants.BANDWIDTH, new AttributeParser<T>() {
            public void parse(Attribute attribute, T t10, ParseState parseState) throws ParseException {
                t10.withBandwidth(ParseUtil.parseInt(attribute.value, str));
            }
        });
        hashMap.put(Constants.AVERAGE_BANDWIDTH, new AttributeParser<T>() {
            public void parse(Attribute attribute, T t10, ParseState parseState) throws ParseException {
                t10.withAverageBandwidth(ParseUtil.parseInt(attribute.value, str));
            }
        });
        hashMap.put(Constants.CODECS, new AttributeParser<T>() {
            public void parse(Attribute attribute, T t10, ParseState parseState) throws ParseException {
                String[] split = ParseUtil.parseQuotedString(attribute.value, str).split(Constants.COMMA);
                if (split.length > 0) {
                    t10.withCodecs(Arrays.asList(split));
                }
            }
        });
        hashMap.put(Constants.RESOLUTION, new AttributeParser<T>() {
            public void parse(Attribute attribute, T t10, ParseState parseState) throws ParseException {
                t10.withResolution(ParseUtil.parseResolution(attribute.value, str));
            }
        });
        hashMap.put(Constants.FRAME_RATE, new AttributeParser<T>() {
            public void parse(Attribute attribute, T t10, ParseState parseState) throws ParseException {
                t10.withFrameRate(ParseUtil.parseFloat(attribute.value, str));
            }
        });
        hashMap.put(Constants.VIDEO, new AttributeParser<T>() {
            public void parse(Attribute attribute, T t10, ParseState parseState) throws ParseException {
                t10.withVideo(ParseUtil.parseQuotedString(attribute.value, str));
            }
        });
        hashMap.put(Constants.PROGRAM_ID, new AttributeParser<T>() {
            public void parse(Attribute attribute, T t10, ParseState parseState) throws ParseException {
            }
        });
        return hashMap;
    }

    public void parse(String str, ParseState parseState) throws ParseException {
        if (!parseState.isMedia()) {
            parseState.setMaster();
            this.mLineParser.parse(str, parseState);
            return;
        }
        throw ParseException.create(ParseExceptionType.MASTER_IN_MEDIA, this.mTagParser.getTag());
    }

    public MasterPlaylistLineParser(IExtTagParser iExtTagParser, LineParser lineParser) {
        this.mTagParser = iExtTagParser;
        this.mLineParser = lineParser;
    }
}
