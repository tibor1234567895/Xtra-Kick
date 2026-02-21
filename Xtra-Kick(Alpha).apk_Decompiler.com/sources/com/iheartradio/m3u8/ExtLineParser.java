package com.iheartradio.m3u8;

import java.util.List;
import java.util.regex.Matcher;

class ExtLineParser implements LineParser {
    static final IExtTagParser EXTM3U_HANDLER = new IExtTagParser() {
        public String getTag() {
            return Constants.EXTM3U_TAG;
        }

        public boolean hasData() {
            return false;
        }

        public void parse(String str, ParseState parseState) throws ParseException {
            if (!parseState.isExtended()) {
                parseState.setExtended();
                return;
            }
            throw ParseException.create(ParseExceptionType.MULTIPLE_EXT_TAG_INSTANCES, getTag(), str);
        }
    };
    static final IExtTagParser EXT_UNKNOWN_HANDLER = new IExtTagParser() {
        public String getTag() {
            return null;
        }

        public boolean hasData() {
            return false;
        }

        public void parse(String str, ParseState parseState) throws ParseException {
            List<String> list;
            if (parseState.isMaster()) {
                list = parseState.getMaster().unknownTags;
            } else if (parseState.isMedia()) {
                list = parseState.getMedia().unknownTags;
            } else {
                return;
            }
            list.add(str);
        }
    };
    static final IExtTagParser EXT_X_VERSION_HANDLER = new IExtTagParser() {
        private final ExtLineParser mLineParser = new ExtLineParser(this);

        public String getTag() {
            return Constants.EXT_X_VERSION_TAG;
        }

        public boolean hasData() {
            return true;
        }

        public void parse(String str, ParseState parseState) throws ParseException {
            this.mLineParser.parse(str, parseState);
            Matcher match = ParseUtil.match(Constants.EXT_X_VERSION_PATTERN, str, getTag());
            if (parseState.getCompatibilityVersion() == -1) {
                int parseInt = ParseUtil.parseInt(match.group(1), getTag());
                if (parseInt < 1) {
                    throw ParseException.create(ParseExceptionType.INVALID_COMPATIBILITY_VERSION, getTag(), str);
                } else if (parseInt <= 5) {
                    parseState.setCompatibilityVersion(parseInt);
                } else {
                    throw ParseException.create(ParseExceptionType.UNSUPPORTED_COMPATIBILITY_VERSION, getTag(), str);
                }
            } else {
                throw ParseException.create(ParseExceptionType.MULTIPLE_EXT_TAG_INSTANCES, getTag(), str);
            }
        }
    };
    private final IExtTagParser mTagParser;

    public ExtLineParser(IExtTagParser iExtTagParser) {
        this.mTagParser = iExtTagParser;
    }

    public void parse(String str, ParseState parseState) throws ParseException {
        if (this.mTagParser.hasData() && str.indexOf(Constants.EXT_TAG_END) != this.mTagParser.getTag().length() + 1) {
            throw ParseException.create(ParseExceptionType.MISSING_EXT_TAG_SEPARATOR, this.mTagParser.getTag(), str);
        }
    }
}
