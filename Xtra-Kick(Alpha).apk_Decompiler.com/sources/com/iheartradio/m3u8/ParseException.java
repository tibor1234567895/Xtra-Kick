package com.iheartradio.m3u8;

public class ParseException extends Exception {
    private static final long serialVersionUID = -2217152001086567983L;
    private String mInput;
    private final String mMessageSuffix;
    public final ParseExceptionType type;

    public ParseException(ParseExceptionType parseExceptionType) {
        this(parseExceptionType, (String) null);
    }

    public static ParseException create(ParseExceptionType parseExceptionType, String str) {
        return create(parseExceptionType, str, (String) null);
    }

    public String getInput() {
        return this.mInput;
    }

    public String getMessage() {
        if (this.mMessageSuffix == null) {
            return this.type.message;
        }
        return this.type.message + ": " + this.mMessageSuffix;
    }

    public void setInput(String str) {
        this.mInput = str;
    }

    public ParseException(ParseExceptionType parseExceptionType, String str) {
        this.type = parseExceptionType;
        this.mMessageSuffix = str;
    }

    public static ParseException create(ParseExceptionType parseExceptionType, String str, String str2) {
        StringBuilder sb2 = new StringBuilder();
        if (str != null) {
            sb2.append(str);
        }
        if (str2 != null) {
            if (sb2.length() > 0) {
                sb2.append(" - ");
            }
            sb2.append(str2);
        }
        return sb2.length() > 0 ? new ParseException(parseExceptionType, sb2.toString()) : new ParseException(parseExceptionType);
    }
}
