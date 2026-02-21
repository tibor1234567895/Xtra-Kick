package com.iheartradio.m3u8;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract class ExtTagHandler implements IExtTagHandler {
    static final IExtTagHandler EXTM3U_HANDLER = new ExtTagHandler() {
        public String getTag() {
            return Constants.EXTM3U_TAG;
        }

        public void handle(String str, ParseState parseState) throws ParseException {
            if (!parseState.isExtended()) {
                parseState.setExtended();
                return;
            }
            throw ParseException.create(ParseExceptionType.MULTIPLE_EXT_TAG_INSTANCES, getTag(), str);
        }

        public boolean hasData() {
            return false;
        }
    };
    static final IExtTagHandler EXT_X_VERSION_HANDLER = new ExtTagHandler() {
        public String getTag() {
            return Constants.EXT_X_VERSION_TAG;
        }

        public void handle(String str, ParseState parseState) throws ParseException {
            ExtTagHandler.super.handle(str, parseState);
            Matcher match = match(Constants.EXT_X_VERSION_PATTERN, str);
            if (parseState.getCompatibilityVersion() == -1) {
                int parseInt = ParseUtil.parseInt(match.group(1), getTag());
                if (parseInt < 1) {
                    throw ParseException.create(ParseExceptionType.INVALID_COMPATIBILITY_VERSION, getTag(), str);
                } else if (parseInt <= 3) {
                    parseState.setCompatibilityVersion(parseInt);
                } else {
                    throw ParseException.create(ParseExceptionType.UNSUPPORTED_COMPATIBILITY_VERSION, getTag(), str);
                }
            } else {
                throw ParseException.create(ParseExceptionType.MULTIPLE_EXT_TAG_INSTANCES, getTag(), str);
            }
        }

        public boolean hasData() {
            return true;
        }
    };

    public void handle(String str, ParseState parseState) throws ParseException {
        if (hasData() && str.indexOf(Constants.EXT_TAG_END) != getTag().length() + 1) {
            throw ParseException.create(ParseExceptionType.MISSING_EXT_TAG_SEPARATOR, getTag(), str);
        }
    }

    public abstract boolean hasData();

    public Matcher match(Pattern pattern, String str) throws ParseException {
        Matcher matcher = pattern.matcher(str);
        if (matcher.matches()) {
            return matcher;
        }
        throw ParseException.create(ParseExceptionType.BAD_EXT_TAG_FORMAT, getTag(), str);
    }

    public <T> void parseAttributes(String str, T t10, ParseState parseState, Map<String, AttributeHandler<T>> map) throws ParseException {
        for (Attribute next : ParseUtil.parseAttributeList(str, getTag())) {
            if (map.containsKey(next.name)) {
                map.get(next.name).handle(next, t10, parseState);
            } else {
                throw ParseException.create(ParseExceptionType.INVALID_ATTRIBUTE_NAME, getTag(), str);
            }
        }
    }
}
