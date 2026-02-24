package com.iheartradio.m3u8;

import com.iheartradio.m3u8.data.Resolution;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

public class WriteUtil {
    public static String encodeUri(String str) throws ParseException {
        try {
            return URLEncoder.encode(str.replace("%2B", "+"), "utf-8");
        } catch (UnsupportedEncodingException unused) {
            throw new ParseException(ParseExceptionType.INTERNAL_ERROR);
        }
    }

    public static String join(List<? extends Object> list, String str) {
        if (list == null || list.size() == 0) {
            throw new IllegalArgumentException("valueList might not be null or empty!");
        } else if (str != null) {
            StringBuilder sb2 = new StringBuilder();
            int i10 = 0;
            while (i10 < list.size()) {
                sb2.append(list.get(i10).toString());
                i10++;
                if (i10 < list.size()) {
                    sb2.append(str);
                }
            }
            return sb2.toString();
        } else {
            throw new IllegalArgumentException("separator might not be null!");
        }
    }

    public static String writeHexadecimal(List<Byte> list) {
        if (list == null || list.size() == 0) {
            throw new IllegalArgumentException("hex might not be null or empty!");
        }
        StringBuilder sb2 = new StringBuilder(list.size() + 2);
        sb2.append("0x");
        for (Byte byteValue : list) {
            sb2.append(Integer.toHexString(byteValue.byteValue()));
        }
        return sb2.toString();
    }

    public static String writeQuotedString(String str, String str2) throws ParseException {
        StringBuilder sb2 = new StringBuilder(str.length() + 2);
        sb2.append("\"");
        int i10 = 0;
        while (i10 < str.length()) {
            char charAt = str.charAt(i10);
            if (i10 != 0 || !ParseUtil.isWhitespace(charAt)) {
                if (charAt == '\"') {
                    sb2.append('\\');
                }
                sb2.append(charAt);
                i10++;
            } else {
                throw new ParseException(ParseExceptionType.ILLEGAL_WHITESPACE, str2);
            }
        }
        sb2.append("\"");
        return sb2.toString();
    }

    public static String writeResolution(Resolution resolution) {
        return resolution.width + "x" + resolution.height;
    }

    public static String writeYesNo(boolean z10) {
        return z10 ? Constants.YES : Constants.NO;
    }
}
