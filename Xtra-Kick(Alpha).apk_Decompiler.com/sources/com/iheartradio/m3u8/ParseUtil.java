package com.iheartradio.m3u8;

import com.iheartradio.m3u8.data.Resolution;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class ParseUtil {
    public static String decodeUri(String str, Encoding encoding) throws ParseException {
        try {
            return URLDecoder.decode(str.replace("+", "%2B"), encoding.value);
        } catch (UnsupportedEncodingException unused) {
            throw new ParseException(ParseExceptionType.INTERNAL_ERROR);
        }
    }

    private static byte hexCharToByte(char c10) {
        return (byte) (c10 >= 'A' ? (c10 & 15) + 9 : c10 & 15);
    }

    public static boolean isWhitespace(char c10) {
        return c10 == ' ' || c10 == 9 || c10 == 13 || c10 == 10;
    }

    public static Matcher match(Pattern pattern, String str, String str2) throws ParseException {
        Matcher matcher = pattern.matcher(str);
        if (matcher.matches()) {
            return matcher;
        }
        throw ParseException.create(ParseExceptionType.BAD_EXT_TAG_FORMAT, str2, str);
    }

    public static List<Attribute> parseAttributeList(String str, String str2) throws ParseException {
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        for (String next : splitAttributeList(str, str2)) {
            int indexOf = next.indexOf(Constants.ATTRIBUTE_SEPARATOR);
            int indexOf2 = next.indexOf("\"");
            if (indexOf == -1 || (indexOf2 != -1 && indexOf2 < indexOf)) {
                throw ParseException.create(ParseExceptionType.MISSING_ATTRIBUTE_SEPARATOR, str2, arrayList.toString());
            }
            String trim = next.substring(0, indexOf).trim();
            String substring = next.substring(indexOf + 1);
            if (trim.isEmpty()) {
                throw ParseException.create(ParseExceptionType.MISSING_ATTRIBUTE_NAME, str2, arrayList.toString());
            } else if (substring.isEmpty()) {
                throw ParseException.create(ParseExceptionType.MISSING_ATTRIBUTE_VALUE, str2, arrayList.toString());
            } else if (hashSet.add(trim)) {
                arrayList.add(new Attribute(trim, substring));
            } else {
                throw ParseException.create(ParseExceptionType.MULTIPLE_ATTRIBUTE_NAME_INSTANCES, str2, arrayList.toString());
            }
        }
        return arrayList;
    }

    public static <T> void parseAttributes(String str, T t10, ParseState parseState, Map<String, ? extends AttributeParser<T>> map, String str2) throws ParseException {
        for (Attribute next : parseAttributeList(str, str2)) {
            if (map.containsKey(next.name)) {
                ((AttributeParser) map.get(next.name)).parse(next, t10, parseState);
            } else {
                throw ParseException.create(ParseExceptionType.INVALID_ATTRIBUTE_NAME, str2, str);
            }
        }
    }

    public static String parseDateTime(String str, String str2) throws ParseException {
        Matcher matcher = Constants.EXT_X_PROGRAM_DATE_TIME_PATTERN.matcher(str);
        if (matcher.matches()) {
            return matcher.group(1);
        }
        throw new ParseException(ParseExceptionType.INVALID_DATE_TIME_FORMAT, str2);
    }

    public static <T extends Enum<T>> T parseEnum(String str, Class<T> cls, String str2) throws ParseException {
        try {
            return Enum.valueOf(cls, str);
        } catch (IllegalArgumentException unused) {
            throw ParseException.create(ParseExceptionType.NOT_JAVA_ENUM, str2, str);
        }
    }

    public static float parseFloat(String str, String str2) throws ParseException {
        try {
            return Float.parseFloat(str);
        } catch (NumberFormatException unused) {
            throw ParseException.create(ParseExceptionType.NOT_JAVA_FLOAT, str2, str);
        }
    }

    public static List<Byte> parseHexadecimal(String str, String str2) throws ParseException {
        ArrayList arrayList = new ArrayList();
        Matcher matcher = Constants.HEXADECIMAL_PATTERN.matcher(str.toUpperCase(Locale.US));
        if (matcher.matches()) {
            for (char hexCharToByte : matcher.group(1).toCharArray()) {
                arrayList.add(Byte.valueOf(hexCharToByte(hexCharToByte)));
            }
            return arrayList;
        }
        throw ParseException.create(ParseExceptionType.INVALID_HEXADECIMAL_STRING, str2, str);
    }

    public static int parseInt(String str, String str2) throws ParseException {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            throw ParseException.create(ParseExceptionType.NOT_JAVA_INTEGER, str2, str);
        }
    }

    public static String parseQuotedString(String str, String str2) throws ParseException {
        StringBuilder sb2 = new StringBuilder();
        int i10 = 0;
        int i11 = 0;
        boolean z10 = false;
        while (i10 < str.length()) {
            char charAt = str.charAt(i10);
            if (i10 != 0 || charAt == '\"') {
                if (i11 != 2) {
                    if (i10 == str.length() - 1) {
                        if (charAt != '\"' || z10) {
                            throw new ParseException(ParseExceptionType.UNCLOSED_QUOTED_STRING, str2);
                        }
                    } else if (z10) {
                        sb2.append(charAt);
                        z10 = false;
                    } else if (charAt == '\\') {
                        z10 = true;
                    } else if (charAt == '\"') {
                        i11++;
                    } else {
                        sb2.append(charAt);
                    }
                    i10++;
                } else if (isWhitespace(charAt)) {
                    throw new ParseException(ParseExceptionType.ILLEGAL_WHITESPACE, str2);
                } else {
                    throw new ParseException(ParseExceptionType.INVALID_QUOTED_STRING, str2);
                }
            } else if (isWhitespace(charAt)) {
                throw new ParseException(ParseExceptionType.ILLEGAL_WHITESPACE, str2);
            } else {
                throw new ParseException(ParseExceptionType.INVALID_QUOTED_STRING, str2);
            }
        }
        return sb2.toString();
    }

    public static Resolution parseResolution(String str, String str2) throws ParseException {
        Matcher matcher = Constants.RESOLUTION_PATTERN.matcher(str);
        if (matcher.matches()) {
            return new Resolution(parseInt(matcher.group(1), str2), parseInt(matcher.group(2), str2));
        }
        throw new ParseException(ParseExceptionType.INVALID_RESOLUTION_FORMAT, str2);
    }

    public static boolean parseYesNo(Attribute attribute, String str) throws ParseException {
        if (attribute.value.equals(Constants.YES)) {
            return true;
        }
        if (attribute.value.equals(Constants.NO)) {
            return false;
        }
        throw ParseException.create(ParseExceptionType.NOT_YES_OR_NO, str, attribute.toString());
    }

    public static List<String> splitAttributeList(String str, String str2) throws ParseException {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int indexOf = str.indexOf(Constants.EXT_TAG_END) + 1;
        boolean z10 = false;
        boolean z11 = false;
        for (int i10 = indexOf; i10 < str.length(); i10++) {
            if (!z10) {
                char charAt = str.charAt(i10);
                if (charAt == ',') {
                    arrayList.add(Integer.valueOf(i10));
                } else if (charAt == '\"') {
                    z10 = true;
                }
            } else if (z11) {
                z11 = false;
            } else {
                char charAt2 = str.charAt(i10);
                if (charAt2 == '\\') {
                    z11 = true;
                } else if (charAt2 == '\"') {
                    z10 = false;
                }
            }
        }
        if (!z10) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Integer num = (Integer) it.next();
                arrayList2.add(str.substring(indexOf, num.intValue()));
                indexOf = num.intValue() + 1;
            }
            arrayList2.add(str.substring(indexOf));
            return arrayList2;
        }
        throw new ParseException(ParseExceptionType.UNCLOSED_QUOTED_STRING, str2);
    }
}
