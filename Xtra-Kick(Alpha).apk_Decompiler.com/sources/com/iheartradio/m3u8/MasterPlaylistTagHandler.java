package com.iheartradio.m3u8;

import com.iheartradio.m3u8.data.MediaData;
import com.iheartradio.m3u8.data.MediaType;
import com.iheartradio.m3u8.data.StreamInfo;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

abstract class MasterPlaylistTagHandler extends ExtTagHandler {
    static final IExtTagHandler EXT_X_MEDIA = new MasterPlaylistTagHandler() {
        private final String ASSOCIATED_LANGUAGE = Constants.ASSOCIATED_LANGUAGE;
        private final String AUTO_SELECT = Constants.AUTO_SELECT;
        private final String CHARACTERISTICS = Constants.CHARACTERISTICS;
        private final String DEFAULT = Constants.DEFAULT;
        private final String FORCED = Constants.FORCED;
        private final String GROUP_ID = Constants.GROUP_ID;
        private final Map<String, AttributeHandler<MediaData.Builder>> HANDLERS;
        private final String IN_STREAM_ID = Constants.IN_STREAM_ID;
        private final String LANGUAGE = Constants.LANGUAGE;
        private final String NAME = Constants.NAME;
        private final String TYPE = Constants.TYPE;
        private final String URI = Constants.URI;

        {
            HashMap hashMap = new HashMap();
            this.HANDLERS = hashMap;
            hashMap.put(Constants.TYPE, new AttributeHandler<MediaData.Builder>() {
                public void handle(Attribute attribute, MediaData.Builder builder, ParseState parseState) throws ParseException {
                    MediaType fromValue = MediaType.fromValue(attribute.value);
                    if (fromValue != null) {
                        builder.withType(fromValue);
                        return;
                    }
                    throw ParseException.create(ParseExceptionType.INVALID_MEDIA_TYPE, AnonymousClass1.this.getTag(), attribute.toString());
                }
            });
            hashMap.put(Constants.URI, new AttributeHandler<MediaData.Builder>() {
                public void handle(Attribute attribute, MediaData.Builder builder, ParseState parseState) throws ParseException {
                    builder.withUri(ParseUtil.decodeUrl(ParseUtil.parseQuotedString(attribute.value, AnonymousClass1.this.getTag()), parseState.encoding));
                }
            });
            hashMap.put(Constants.GROUP_ID, new AttributeHandler<MediaData.Builder>() {
                public void handle(Attribute attribute, MediaData.Builder builder, ParseState parseState) throws ParseException {
                    String parseQuotedString = ParseUtil.parseQuotedString(attribute.value, AnonymousClass1.this.getTag());
                    if (!parseQuotedString.isEmpty()) {
                        builder.withGroupId(parseQuotedString);
                        return;
                    }
                    throw ParseException.create(ParseExceptionType.EMPTY_MEDIA_GROUP_ID, AnonymousClass1.this.getTag(), attribute.toString());
                }
            });
            hashMap.put(Constants.LANGUAGE, new AttributeHandler<MediaData.Builder>() {
                public void handle(Attribute attribute, MediaData.Builder builder, ParseState parseState) throws ParseException {
                    builder.withLanguage(ParseUtil.parseQuotedString(attribute.value, AnonymousClass1.this.getTag()));
                }
            });
            hashMap.put(Constants.ASSOCIATED_LANGUAGE, new AttributeHandler<MediaData.Builder>() {
                public void handle(Attribute attribute, MediaData.Builder builder, ParseState parseState) throws ParseException {
                    builder.withAssociatedLanguage(ParseUtil.parseQuotedString(attribute.value, AnonymousClass1.this.getTag()));
                }
            });
            hashMap.put(Constants.NAME, new AttributeHandler<MediaData.Builder>() {
                public void handle(Attribute attribute, MediaData.Builder builder, ParseState parseState) throws ParseException {
                    String parseQuotedString = ParseUtil.parseQuotedString(attribute.value, AnonymousClass1.this.getTag());
                    if (!parseQuotedString.isEmpty()) {
                        builder.withName(parseQuotedString);
                        return;
                    }
                    throw ParseException.create(ParseExceptionType.EMPTY_MEDIA_NAME, AnonymousClass1.this.getTag(), attribute.toString());
                }
            });
            hashMap.put(Constants.DEFAULT, new AttributeHandler<MediaData.Builder>() {
                public void handle(Attribute attribute, MediaData.Builder builder, ParseState parseState) throws ParseException {
                    builder.withDefault(ParseUtil.parseYesNo(attribute.value, AnonymousClass1.this.getTag()));
                }
            });
            hashMap.put(Constants.AUTO_SELECT, new AttributeHandler<MediaData.Builder>() {
                public void handle(Attribute attribute, MediaData.Builder builder, ParseState parseState) throws ParseException {
                    builder.withAutoSelect(ParseUtil.parseYesNo(attribute.value, AnonymousClass1.this.getTag()));
                }
            });
            hashMap.put(Constants.FORCED, new AttributeHandler<MediaData.Builder>() {
                public void handle(Attribute attribute, MediaData.Builder builder, ParseState parseState) throws ParseException {
                    builder.withForced(ParseUtil.parseYesNo(attribute.value, AnonymousClass1.this.getTag()));
                }
            });
            hashMap.put(Constants.IN_STREAM_ID, new AttributeHandler<MediaData.Builder>() {
                public void handle(Attribute attribute, MediaData.Builder builder, ParseState parseState) throws ParseException {
                    String parseQuotedString = ParseUtil.parseQuotedString(attribute.value, AnonymousClass1.this.getTag());
                    if (Constants.EXT_X_MEDIA_IN_STREAM_ID_PATTERN.matcher(parseQuotedString).matches()) {
                        builder.withInStreamId(parseQuotedString);
                        return;
                    }
                    throw ParseException.create(ParseExceptionType.INVALID_MEDIA_IN_STREAM_ID, AnonymousClass1.this.getTag(), attribute.toString());
                }
            });
            hashMap.put(Constants.CHARACTERISTICS, new AttributeHandler<MediaData.Builder>() {
                public void handle(Attribute attribute, MediaData.Builder builder, ParseState parseState) throws ParseException {
                    String[] split = ParseUtil.parseQuotedString(attribute.value, AnonymousClass1.this.getTag()).split(",");
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

        public void handle(String str, ParseState parseState) throws ParseException {
            MasterPlaylistTagHandler.super.handle(str, parseState);
            MediaData.Builder builder = new MediaData.Builder();
            parseAttributes(str, builder, parseState, this.HANDLERS);
            MediaData build = builder.build();
            if (build.getType() == null) {
                throw ParseException.create(ParseExceptionType.MISSING_MEDIA_TYPE, getTag(), str);
            } else if (build.getGroupId() == null) {
                throw ParseException.create(ParseExceptionType.MISSING_MEDIA_GROUP_ID, getTag(), str);
            } else if (build.getName() != null) {
                MediaType type = build.getType();
                MediaType mediaType = MediaType.CLOSED_CAPTIONS;
                if (type == mediaType && build.getUri() != null) {
                    throw ParseException.create(ParseExceptionType.CLOSE_CAPTIONS_WITH_URI, getTag(), str);
                } else if (build.getType() == mediaType && build.getInStreamId() == null) {
                    throw ParseException.create(ParseExceptionType.CLOSE_CAPTIONS_WITHOUT_IN_STREAM_ID, getTag(), str);
                } else if (build.getType() != mediaType && build.getInStreamId() != null) {
                    throw ParseException.create(ParseExceptionType.IN_STREAM_ID_WITHOUT_CLOSE_CAPTIONS, getTag(), str);
                } else if (build.isDefault() && builder.isAutoSelectSet() && !build.isAutoSelect()) {
                    throw ParseException.create(ParseExceptionType.DEFAULT_WITHOUT_AUTO_SELECT, getTag(), str);
                } else if (build.getType() == MediaType.SUBTITLES || !builder.isForcedSet()) {
                    parseState.getMaster().mediaData.add(build);
                } else {
                    throw ParseException.create(ParseExceptionType.FORCED_WITHOUT_SUBTITLES, getTag(), str);
                }
            } else {
                throw ParseException.create(ParseExceptionType.MISSING_MEDIA_NAME, getTag(), str);
            }
        }

        public boolean hasData() {
            return true;
        }
    };
    static final IExtTagHandler EXT_X_STREAM_INF = new MasterPlaylistTagHandler() {
        private final String AUDIO = Constants.AUDIO;
        private final String AVERAGE_BANDWIDTH = Constants.AVERAGE_BANDWIDTH;
        private final String BANDWIDTH = Constants.BANDWIDTH;
        private final String CLOSED_CAPTIONS = Constants.CLOSED_CAPTIONS;
        private final String CODECS = Constants.CODECS;
        private final Map<String, AttributeHandler<StreamInfo.Builder>> HANDLERS;
        private final String PROGRAM_ID = Constants.PROGRAM_ID;
        private final String RESOLUTION = Constants.RESOLUTION;
        private final String SUBTITLES = Constants.SUBTITLES;
        private final String VIDEO = Constants.VIDEO;

        {
            HashMap hashMap = new HashMap();
            this.HANDLERS = hashMap;
            hashMap.put(Constants.BANDWIDTH, new AttributeHandler<StreamInfo.Builder>() {
                public void handle(Attribute attribute, StreamInfo.Builder builder, ParseState parseState) throws ParseException {
                    builder.withBandwidth(ParseUtil.parseInt(attribute.value, AnonymousClass2.this.getTag()));
                }
            });
            hashMap.put(Constants.AVERAGE_BANDWIDTH, new AttributeHandler<StreamInfo.Builder>() {
                public void handle(Attribute attribute, StreamInfo.Builder builder, ParseState parseState) throws ParseException {
                    builder.withAverageBandwidth(ParseUtil.parseInt(attribute.value, AnonymousClass2.this.getTag()));
                }
            });
            hashMap.put(Constants.CODECS, new AttributeHandler<StreamInfo.Builder>() {
                public void handle(Attribute attribute, StreamInfo.Builder builder, ParseState parseState) throws ParseException {
                    String[] split = ParseUtil.parseQuotedString(attribute.value, AnonymousClass2.this.getTag()).split(",");
                    if (split.length > 0) {
                        builder.withCodecs((List<String>) Arrays.asList(split));
                    }
                }
            });
            hashMap.put(Constants.RESOLUTION, new AttributeHandler<StreamInfo.Builder>() {
                public void handle(Attribute attribute, StreamInfo.Builder builder, ParseState parseState) throws ParseException {
                    builder.withResolution(ParseUtil.parseResolution(attribute.value, AnonymousClass2.this.getTag()));
                }
            });
            hashMap.put(Constants.AUDIO, new AttributeHandler<StreamInfo.Builder>() {
                public void handle(Attribute attribute, StreamInfo.Builder builder, ParseState parseState) throws ParseException {
                    builder.withAudio(ParseUtil.parseQuotedString(attribute.value, AnonymousClass2.this.getTag()));
                }
            });
            hashMap.put(Constants.VIDEO, new AttributeHandler<StreamInfo.Builder>() {
                public void handle(Attribute attribute, StreamInfo.Builder builder, ParseState parseState) throws ParseException {
                    builder.withVideo(ParseUtil.parseQuotedString(attribute.value, AnonymousClass2.this.getTag()));
                }
            });
            hashMap.put(Constants.SUBTITLES, new AttributeHandler<StreamInfo.Builder>() {
                public void handle(Attribute attribute, StreamInfo.Builder builder, ParseState parseState) throws ParseException {
                    builder.withSubtitles(ParseUtil.parseQuotedString(attribute.value, AnonymousClass2.this.getTag()));
                }
            });
            hashMap.put(Constants.CLOSED_CAPTIONS, new AttributeHandler<StreamInfo.Builder>() {
                public void handle(Attribute attribute, StreamInfo.Builder builder, ParseState parseState) throws ParseException {
                    if (!attribute.value.equals(Constants.NO_CLOSED_CAPTIONS)) {
                        builder.withClosedCaptions(ParseUtil.parseQuotedString(attribute.value, AnonymousClass2.this.getTag()));
                    }
                }
            });
            hashMap.put(Constants.PROGRAM_ID, new AttributeHandler<StreamInfo.Builder>() {
                public void handle(Attribute attribute, StreamInfo.Builder builder, ParseState parseState) throws ParseException {
                }
            });
        }

        public String getTag() {
            return Constants.EXT_X_STREAM_INF_TAG;
        }

        public void handle(String str, ParseState parseState) throws ParseException {
            MasterPlaylistTagHandler.super.handle(str, parseState);
            StreamInfo.Builder builder = new StreamInfo.Builder();
            parseAttributes(str, builder, parseState, this.HANDLERS);
            StreamInfo build = builder.build();
            if (builder.isBandwidthSet()) {
                parseState.getMaster().streamInfo = build;
                return;
            }
            throw new ParseException(ParseExceptionType.MISSING_STREAM_BANDWIDTH, getTag());
        }

        public boolean hasData() {
            return true;
        }
    };

    private void validateNotMedia(ParseState parseState) throws ParseException {
        if (parseState.isMedia()) {
            throw ParseException.create(ParseExceptionType.MASTER_IN_MEDIA, getTag());
        }
    }

    public void handle(String str, ParseState parseState) throws ParseException {
        validateNotMedia(parseState);
        parseState.setMaster();
        super.handle(str, parseState);
    }
}
