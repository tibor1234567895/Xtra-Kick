package com.iheartradio.m3u8;

import com.iheartradio.m3u8.data.EncryptionData;
import com.iheartradio.m3u8.data.EncryptionMethod;
import com.iheartradio.m3u8.data.TrackInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;

abstract class MediaPlaylistTagHandler extends ExtTagHandler {
    static final IExtTagHandler EXTINF = new MediaPlaylistTagHandler() {
        public String getTag() {
            return Constants.EXTINF_TAG;
        }

        public void handle(String str, ParseState parseState) throws ParseException {
            MediaPlaylistTagHandler.super.handle(str, parseState);
            Matcher match = match(Constants.EXTINF_PATTERN, str);
            parseState.getMedia().trackInfo = new TrackInfo(ParseUtil.parseFloat(match.group(1), getTag()), match.group(2));
        }

        public boolean hasData() {
            return true;
        }
    };
    static final IExtTagHandler EXT_X_ALLOW_CACHE = new ExtTagHandler() {
        public String getTag() {
            return Constants.EXT_X_ALLOW_CACHE_TAG;
        }

        public void handle(String str, ParseState parseState) throws ParseException {
            super.handle(str, parseState);
        }

        public boolean hasData() {
            return false;
        }
    };
    static final IExtTagHandler EXT_X_KEY = new MediaPlaylistTagHandler() {
        private final Map<String, AttributeHandler<EncryptionData.Builder>> HANDLERS;
        private final String IV = Constants.IV;
        private final String KEY_FORMAT = Constants.KEY_FORMAT;
        private final String KEY_FORMAT_VERSIONS = Constants.KEY_FORMAT_VERSIONS;
        private final String METHOD = Constants.METHOD;
        private final String URI = Constants.URI;

        {
            HashMap hashMap = new HashMap();
            this.HANDLERS = hashMap;
            hashMap.put(Constants.METHOD, new AttributeHandler<EncryptionData.Builder>() {
                public void handle(Attribute attribute, EncryptionData.Builder builder, ParseState parseState) throws ParseException {
                    EncryptionMethod fromValue = EncryptionMethod.fromValue(attribute.value);
                    if (fromValue != null) {
                        builder.withMethod(fromValue);
                        return;
                    }
                    throw ParseException.create(ParseExceptionType.INVALID_ENCRYPTION_METHOD, AnonymousClass6.this.getTag(), attribute.toString());
                }
            });
            hashMap.put(Constants.URI, new AttributeHandler<EncryptionData.Builder>() {
                public void handle(Attribute attribute, EncryptionData.Builder builder, ParseState parseState) throws ParseException {
                    builder.withUri(ParseUtil.decodeUrl(ParseUtil.parseQuotedString(attribute.value, AnonymousClass6.this.getTag()), parseState.encoding));
                }
            });
            hashMap.put(Constants.IV, new AttributeHandler<EncryptionData.Builder>() {
                public void handle(Attribute attribute, EncryptionData.Builder builder, ParseState parseState) throws ParseException {
                    List<Byte> parseHexadecimal = ParseUtil.parseHexadecimal(attribute.value, AnonymousClass6.this.getTag());
                    if (parseHexadecimal.size() == 16) {
                        builder.withInitializationVector(parseHexadecimal);
                        return;
                    }
                    throw ParseException.create(ParseExceptionType.INVALID_IV_SIZE, AnonymousClass6.this.getTag(), attribute.toString());
                }
            });
            hashMap.put(Constants.KEY_FORMAT, new AttributeHandler<EncryptionData.Builder>() {
                public void handle(Attribute attribute, EncryptionData.Builder builder, ParseState parseState) throws ParseException {
                    builder.withKeyFormat(ParseUtil.parseQuotedString(attribute.value, AnonymousClass6.this.getTag()));
                }
            });
            hashMap.put(Constants.KEY_FORMAT_VERSIONS, new AttributeHandler<EncryptionData.Builder>() {
                public void handle(Attribute attribute, EncryptionData.Builder builder, ParseState parseState) throws ParseException {
                    String[] split = ParseUtil.parseQuotedString(attribute.value, AnonymousClass6.this.getTag()).split(Constants.LIST_SEPARATOR);
                    ArrayList arrayList = new ArrayList();
                    int length = split.length;
                    int i10 = 0;
                    while (i10 < length) {
                        try {
                            arrayList.add(Integer.valueOf(Integer.parseInt(split[i10])));
                            i10++;
                        } catch (NumberFormatException unused) {
                            throw ParseException.create(ParseExceptionType.INVALID_KEY_FORMAT_VERSIONS, AnonymousClass6.this.getTag(), attribute.toString());
                        }
                    }
                    builder.withKeyFormatVersions(arrayList);
                }
            });
        }

        public String getTag() {
            return Constants.EXT_X_KEY_TAG;
        }

        public void handle(String str, ParseState parseState) throws ParseException {
            MediaPlaylistTagHandler.super.handle(str, parseState);
            EncryptionData.Builder withKeyFormatVersions = new EncryptionData.Builder().withKeyFormat(Constants.DEFAULT_KEY_FORMAT).withKeyFormatVersions(Constants.DEFAULT_KEY_FORMAT_VERSIONS);
            parseAttributes(str, withKeyFormatVersions, parseState, this.HANDLERS);
            EncryptionData build = withKeyFormatVersions.build();
            if (build.getMethod() == EncryptionMethod.NONE || build.getUri() != null) {
                parseState.getMedia().encryptionData = build;
                return;
            }
            throw ParseException.create(ParseExceptionType.MISSING_ENCRYPTION_URI, getTag(), str);
        }

        public boolean hasData() {
            return true;
        }
    };
    static final IExtTagHandler EXT_X_MEDIA_SEQUENCE = new MediaPlaylistTagHandler() {
        public String getTag() {
            return Constants.EXT_X_MEDIA_SEQUENCE_TAG;
        }

        public void handle(String str, ParseState parseState) throws ParseException {
            MediaPlaylistTagHandler.super.handle(str, parseState);
            Matcher match = match(Constants.EXT_X_MEDIA_SEQUENCE_PATTERN, str);
            if (parseState.getMedia().mediaSequenceNumber == null) {
                parseState.getMedia().mediaSequenceNumber = Integer.valueOf(ParseUtil.parseInt(match.group(1), getTag()));
                return;
            }
            throw ParseException.create(ParseExceptionType.MULTIPLE_EXT_TAG_INSTANCES, getTag(), str);
        }

        public boolean hasData() {
            return true;
        }
    };
    static final IExtTagHandler EXT_X_PROGRAM_DATE_TIME = new ExtTagHandler() {
        public String getTag() {
            return Constants.EXT_X_PROGRAM_DATE_TIME_TAG;
        }

        public void handle(String str, ParseState parseState) throws ParseException {
            super.handle(str, parseState);
        }

        public boolean hasData() {
            return false;
        }
    };
    static final IExtTagHandler EXT_X_TARGETDURATION = new MediaPlaylistTagHandler() {
        public String getTag() {
            return Constants.EXT_X_TARGETDURATION_TAG;
        }

        public void handle(String str, ParseState parseState) throws ParseException {
            MediaPlaylistTagHandler.super.handle(str, parseState);
            Matcher match = match(Constants.EXT_X_TARGETDURATION_PATTERN, str);
            if (parseState.getMedia().targetDuration == null) {
                parseState.getMedia().targetDuration = Integer.valueOf(ParseUtil.parseInt(match.group(1), getTag()));
                return;
            }
            throw ParseException.create(ParseExceptionType.MULTIPLE_EXT_TAG_INSTANCES, getTag(), str);
        }

        public boolean hasData() {
            return true;
        }
    };

    private void validateNotMaster(ParseState parseState) throws ParseException {
        if (parseState.isMaster()) {
            throw ParseException.create(ParseExceptionType.MEDIA_IN_MASTER, getTag());
        }
    }

    public void handle(String str, ParseState parseState) throws ParseException {
        validateNotMaster(parseState);
        parseState.setMedia();
        super.handle(str, parseState);
    }
}
