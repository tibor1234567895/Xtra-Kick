package com.google.gson.stream;

import java.io.Closeable;
import java.io.IOException;
import java.io.Reader;
import l9.h;

public class JsonReader implements Closeable {
    private static final long MIN_INCOMPLETE_INTEGER = -922337203685477580L;
    private static final char[] NON_EXECUTE_PREFIX = ")]}'\n".toCharArray();
    private static final int NUMBER_CHAR_DECIMAL = 3;
    private static final int NUMBER_CHAR_DIGIT = 2;
    private static final int NUMBER_CHAR_EXP_DIGIT = 7;
    private static final int NUMBER_CHAR_EXP_E = 5;
    private static final int NUMBER_CHAR_EXP_SIGN = 6;
    private static final int NUMBER_CHAR_FRACTION_DIGIT = 4;
    private static final int NUMBER_CHAR_NONE = 0;
    private static final int NUMBER_CHAR_SIGN = 1;
    private static final int PEEKED_BEGIN_ARRAY = 3;
    private static final int PEEKED_BEGIN_OBJECT = 1;
    private static final int PEEKED_BUFFERED = 11;
    private static final int PEEKED_DOUBLE_QUOTED = 9;
    private static final int PEEKED_DOUBLE_QUOTED_NAME = 13;
    private static final int PEEKED_END_ARRAY = 4;
    private static final int PEEKED_END_OBJECT = 2;
    private static final int PEEKED_EOF = 17;
    private static final int PEEKED_FALSE = 6;
    private static final int PEEKED_LONG = 15;
    private static final int PEEKED_NONE = 0;
    private static final int PEEKED_NULL = 7;
    private static final int PEEKED_NUMBER = 16;
    private static final int PEEKED_SINGLE_QUOTED = 8;
    private static final int PEEKED_SINGLE_QUOTED_NAME = 12;
    private static final int PEEKED_TRUE = 5;
    private static final int PEEKED_UNQUOTED = 10;
    private static final int PEEKED_UNQUOTED_NAME = 14;
    private final char[] buffer = new char[1024];
    private final Reader in;
    private boolean lenient = false;
    private int limit = 0;
    private int lineNumber = 0;
    private int lineStart = 0;
    private int[] pathIndices;
    private String[] pathNames;
    int peeked = 0;
    private long peekedLong;
    private int peekedNumberLength;
    private String peekedString;
    private int pos = 0;
    private int[] stack;
    private int stackSize;

    static {
        h.INSTANCE = new h() {
            public void promoteNameToValue(JsonReader jsonReader) throws IOException {
                int i10;
                int i11 = jsonReader.peeked;
                if (i11 == 0) {
                    i11 = jsonReader.doPeek();
                }
                if (i11 == JsonReader.PEEKED_DOUBLE_QUOTED_NAME) {
                    i10 = JsonReader.PEEKED_DOUBLE_QUOTED;
                } else if (i11 == JsonReader.PEEKED_SINGLE_QUOTED_NAME) {
                    i10 = JsonReader.PEEKED_SINGLE_QUOTED;
                } else if (i11 == JsonReader.PEEKED_UNQUOTED_NAME) {
                    i10 = JsonReader.PEEKED_UNQUOTED;
                } else {
                    throw new IllegalStateException("Expected a name but was " + jsonReader.peek() + jsonReader.locationString());
                }
                jsonReader.peeked = i10;
            }
        };
    }

    public JsonReader(Reader reader) {
        int[] iArr = new int[32];
        this.stack = iArr;
        this.stackSize = 0 + 1;
        iArr[0] = 6;
        this.pathNames = new String[32];
        this.pathIndices = new int[32];
        if (reader != null) {
            this.in = reader;
            return;
        }
        throw new NullPointerException("in == null");
    }

    private void checkLenient() throws IOException {
        if (!this.lenient) {
            throw syntaxError("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private void consumeNonExecutePrefix() throws IOException {
        nextNonWhitespace(true);
        int i10 = this.pos - 1;
        this.pos = i10;
        char[] cArr = NON_EXECUTE_PREFIX;
        if (i10 + cArr.length <= this.limit || fillBuffer(cArr.length)) {
            int i11 = 0;
            while (true) {
                char[] cArr2 = NON_EXECUTE_PREFIX;
                if (i11 >= cArr2.length) {
                    this.pos += cArr2.length;
                    return;
                } else if (this.buffer[this.pos + i11] == cArr2[i11]) {
                    i11++;
                } else {
                    return;
                }
            }
        }
    }

    private boolean fillBuffer(int i10) throws IOException {
        int i11;
        int i12;
        char[] cArr = this.buffer;
        int i13 = this.lineStart;
        int i14 = this.pos;
        this.lineStart = i13 - i14;
        int i15 = this.limit;
        if (i15 != i14) {
            int i16 = i15 - i14;
            this.limit = i16;
            System.arraycopy(cArr, i14, cArr, 0, i16);
        } else {
            this.limit = 0;
        }
        this.pos = 0;
        do {
            Reader reader = this.in;
            int i17 = this.limit;
            int read = reader.read(cArr, i17, cArr.length - i17);
            if (read == -1) {
                return false;
            }
            i11 = this.limit + read;
            this.limit = i11;
            if (this.lineNumber == 0 && (i12 = this.lineStart) == 0 && i11 > 0 && cArr[0] == 65279) {
                this.pos++;
                this.lineStart = i12 + 1;
                i10++;
                continue;
            }
        } while (i11 < i10);
        return true;
    }

    private boolean isLiteral(char c10) throws IOException {
        if (c10 == PEEKED_DOUBLE_QUOTED || c10 == PEEKED_UNQUOTED || c10 == PEEKED_SINGLE_QUOTED_NAME || c10 == PEEKED_DOUBLE_QUOTED_NAME || c10 == ' ') {
            return false;
        }
        if (c10 != '#') {
            if (c10 == ',') {
                return false;
            }
            if (!(c10 == '/' || c10 == '=')) {
                if (c10 == '{' || c10 == '}' || c10 == ':') {
                    return false;
                }
                if (c10 != ';') {
                    switch (c10) {
                        case '[':
                        case ']':
                            return false;
                        case '\\':
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        checkLenient();
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0050, code lost:
        if (r1 != '/') goto L_0x0095;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0052, code lost:
        r7.pos = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0055, code lost:
        if (r4 != r2) goto L_0x0067;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0057, code lost:
        r7.pos = r4 - 1;
        r2 = fillBuffer(2);
        r7.pos++;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0064, code lost:
        if (r2 != false) goto L_0x0067;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0066, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0067, code lost:
        checkLenient();
        r2 = r7.pos;
        r3 = r0[r2];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0070, code lost:
        if (r3 == '*') goto L_0x007d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0072, code lost:
        if (r3 == '/') goto L_0x0075;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0074, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0075, code lost:
        r7.pos = r2 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x007d, code lost:
        r7.pos = r2 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0087, code lost:
        if (skipTo("*/") == false) goto L_0x008e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0094, code lost:
        throw syntaxError("Unterminated comment");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0095, code lost:
        r7.pos = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0099, code lost:
        if (r1 != '#') goto L_0x009f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x009b, code lost:
        checkLenient();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x009f, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int nextNonWhitespace(boolean r8) throws java.io.IOException {
        /*
            r7 = this;
            char[] r0 = r7.buffer
        L_0x0002:
            int r1 = r7.pos
        L_0x0004:
            int r2 = r7.limit
        L_0x0006:
            r3 = 1
            if (r1 != r2) goto L_0x0031
            r7.pos = r1
            boolean r1 = r7.fillBuffer(r3)
            if (r1 != 0) goto L_0x002d
            if (r8 != 0) goto L_0x0015
            r8 = -1
            return r8
        L_0x0015:
            java.io.EOFException r8 = new java.io.EOFException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "End of input"
            r0.<init>(r1)
            java.lang.String r1 = r7.locationString()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r8.<init>(r0)
            throw r8
        L_0x002d:
            int r1 = r7.pos
            int r2 = r7.limit
        L_0x0031:
            int r4 = r1 + 1
            char r1 = r0[r1]
            r5 = 10
            if (r1 != r5) goto L_0x0041
            int r1 = r7.lineNumber
            int r1 = r1 + r3
            r7.lineNumber = r1
            r7.lineStart = r4
            goto L_0x00a0
        L_0x0041:
            r5 = 32
            if (r1 == r5) goto L_0x00a0
            r5 = 13
            if (r1 == r5) goto L_0x00a0
            r5 = 9
            if (r1 != r5) goto L_0x004e
            goto L_0x00a0
        L_0x004e:
            r5 = 47
            if (r1 != r5) goto L_0x0095
            r7.pos = r4
            r6 = 2
            if (r4 != r2) goto L_0x0067
            int r4 = r4 + -1
            r7.pos = r4
            boolean r2 = r7.fillBuffer(r6)
            int r4 = r7.pos
            int r4 = r4 + r3
            r7.pos = r4
            if (r2 != 0) goto L_0x0067
            return r1
        L_0x0067:
            r7.checkLenient()
            int r2 = r7.pos
            char r3 = r0[r2]
            r4 = 42
            if (r3 == r4) goto L_0x007d
            if (r3 == r5) goto L_0x0075
            return r1
        L_0x0075:
            int r2 = r2 + 1
            r7.pos = r2
        L_0x0079:
            r7.skipToEndOfLine()
            goto L_0x0002
        L_0x007d:
            int r2 = r2 + 1
            r7.pos = r2
            java.lang.String r1 = "*/"
            boolean r1 = r7.skipTo(r1)
            if (r1 == 0) goto L_0x008e
            int r1 = r7.pos
            int r1 = r1 + r6
            goto L_0x0004
        L_0x008e:
            java.lang.String r8 = "Unterminated comment"
            java.io.IOException r8 = r7.syntaxError(r8)
            throw r8
        L_0x0095:
            r2 = 35
            r7.pos = r4
            if (r1 != r2) goto L_0x009f
            r7.checkLenient()
            goto L_0x0079
        L_0x009f:
            return r1
        L_0x00a0:
            r1 = r4
            goto L_0x0006
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.stream.JsonReader.nextNonWhitespace(boolean):int");
    }

    private String nextQuotedValue(char c10) throws IOException {
        char[] cArr = this.buffer;
        StringBuilder sb2 = null;
        while (true) {
            int i10 = this.pos;
            int i11 = this.limit;
            int i12 = i10;
            while (true) {
                if (i10 < i11) {
                    int i13 = i10 + 1;
                    char c11 = cArr[i10];
                    if (c11 == c10) {
                        this.pos = i13;
                        int i14 = (i13 - i12) - 1;
                        if (sb2 == null) {
                            return new String(cArr, i12, i14);
                        }
                        sb2.append(cArr, i12, i14);
                        return sb2.toString();
                    } else if (c11 == '\\') {
                        this.pos = i13;
                        int i15 = (i13 - i12) - 1;
                        if (sb2 == null) {
                            sb2 = new StringBuilder(Math.max((i15 + 1) * 2, 16));
                        }
                        sb2.append(cArr, i12, i15);
                        sb2.append(readEscapeCharacter());
                    } else {
                        if (c11 == PEEKED_UNQUOTED) {
                            this.lineNumber++;
                            this.lineStart = i13;
                        }
                        i10 = i13;
                    }
                } else {
                    if (sb2 == null) {
                        sb2 = new StringBuilder(Math.max((i10 - i12) * 2, 16));
                    }
                    sb2.append(cArr, i12, i10 - i12);
                    this.pos = i10;
                    if (!fillBuffer(1)) {
                        throw syntaxError("Unterminated string");
                    }
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x004a, code lost:
        checkLenient();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String nextUnquotedValue() throws java.io.IOException {
        /*
            r6 = this;
            r0 = 0
            r1 = 0
        L_0x0002:
            r2 = 0
        L_0x0003:
            int r3 = r6.pos
            int r4 = r3 + r2
            int r5 = r6.limit
            if (r4 >= r5) goto L_0x004e
            char[] r4 = r6.buffer
            int r3 = r3 + r2
            char r3 = r4[r3]
            r4 = 9
            if (r3 == r4) goto L_0x005c
            r4 = 10
            if (r3 == r4) goto L_0x005c
            r4 = 12
            if (r3 == r4) goto L_0x005c
            r4 = 13
            if (r3 == r4) goto L_0x005c
            r4 = 32
            if (r3 == r4) goto L_0x005c
            r4 = 35
            if (r3 == r4) goto L_0x004a
            r4 = 44
            if (r3 == r4) goto L_0x005c
            r4 = 47
            if (r3 == r4) goto L_0x004a
            r4 = 61
            if (r3 == r4) goto L_0x004a
            r4 = 123(0x7b, float:1.72E-43)
            if (r3 == r4) goto L_0x005c
            r4 = 125(0x7d, float:1.75E-43)
            if (r3 == r4) goto L_0x005c
            r4 = 58
            if (r3 == r4) goto L_0x005c
            r4 = 59
            if (r3 == r4) goto L_0x004a
            switch(r3) {
                case 91: goto L_0x005c;
                case 92: goto L_0x004a;
                case 93: goto L_0x005c;
                default: goto L_0x0047;
            }
        L_0x0047:
            int r2 = r2 + 1
            goto L_0x0003
        L_0x004a:
            r6.checkLenient()
            goto L_0x005c
        L_0x004e:
            char[] r3 = r6.buffer
            int r3 = r3.length
            if (r2 >= r3) goto L_0x005e
            int r3 = r2 + 1
            boolean r3 = r6.fillBuffer(r3)
            if (r3 == 0) goto L_0x005c
            goto L_0x0003
        L_0x005c:
            r1 = r2
            goto L_0x007e
        L_0x005e:
            if (r0 != 0) goto L_0x006b
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r3 = 16
            int r3 = java.lang.Math.max(r2, r3)
            r0.<init>(r3)
        L_0x006b:
            char[] r3 = r6.buffer
            int r4 = r6.pos
            r0.append(r3, r4, r2)
            int r3 = r6.pos
            int r3 = r3 + r2
            r6.pos = r3
            r2 = 1
            boolean r2 = r6.fillBuffer(r2)
            if (r2 != 0) goto L_0x0002
        L_0x007e:
            if (r0 != 0) goto L_0x008a
            java.lang.String r0 = new java.lang.String
            char[] r2 = r6.buffer
            int r3 = r6.pos
            r0.<init>(r2, r3, r1)
            goto L_0x0095
        L_0x008a:
            char[] r2 = r6.buffer
            int r3 = r6.pos
            r0.append(r2, r3, r1)
            java.lang.String r0 = r0.toString()
        L_0x0095:
            int r2 = r6.pos
            int r2 = r2 + r1
            r6.pos = r2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.stream.JsonReader.nextUnquotedValue():java.lang.String");
    }

    private int peekKeyword() throws IOException {
        int i10;
        String str;
        String str2;
        char c10 = this.buffer[this.pos];
        if (c10 == 't' || c10 == 'T') {
            str2 = "true";
            str = "TRUE";
            i10 = 5;
        } else if (c10 == 'f' || c10 == 'F') {
            str2 = "false";
            str = "FALSE";
            i10 = 6;
        } else if (c10 != 'n' && c10 != 'N') {
            return 0;
        } else {
            str2 = "null";
            str = "NULL";
            i10 = 7;
        }
        int length = str2.length();
        for (int i11 = 1; i11 < length; i11++) {
            if (this.pos + i11 >= this.limit && !fillBuffer(i11 + 1)) {
                return 0;
            }
            char c11 = this.buffer[this.pos + i11];
            if (c11 != str2.charAt(i11) && c11 != str.charAt(i11)) {
                return 0;
            }
        }
        if ((this.pos + length < this.limit || fillBuffer(length + 1)) && isLiteral(this.buffer[this.pos + length])) {
            return 0;
        }
        this.pos += length;
        this.peeked = i10;
        return i10;
    }

    private int peekNumber() throws IOException {
        int i10;
        char c10;
        char[] cArr = this.buffer;
        int i11 = this.pos;
        int i12 = this.limit;
        int i13 = 0;
        int i14 = 0;
        char c11 = 0;
        boolean z10 = true;
        long j10 = 0;
        boolean z11 = false;
        while (true) {
            if (i11 + i14 == i12) {
                if (i14 == cArr.length) {
                    return i13;
                }
                if (!fillBuffer(i14 + 1)) {
                    break;
                }
                i11 = this.pos;
                i12 = this.limit;
            }
            c10 = cArr[i11 + i14];
            if (c10 == '+') {
                i13 = 0;
                if (c11 != 5) {
                    return 0;
                }
            } else if (c10 == 'E' || c10 == 'e') {
                i13 = 0;
                if (c11 != 2 && c11 != 4) {
                    return 0;
                }
                c11 = 5;
                i14++;
            } else {
                if (c10 == '-') {
                    i13 = 0;
                    if (c11 == 0) {
                        c11 = 1;
                        z11 = true;
                    } else if (c11 != 5) {
                        return 0;
                    }
                } else if (c10 == '.') {
                    i13 = 0;
                    if (c11 != 2) {
                        return 0;
                    }
                    c11 = 3;
                } else if (c10 >= '0' && c10 <= '9') {
                    if (c11 == 1 || c11 == 0) {
                        j10 = (long) (-(c10 - '0'));
                        i13 = 0;
                        c11 = 2;
                    } else {
                        if (c11 == 2) {
                            if (j10 == 0) {
                                return 0;
                            }
                            long j11 = (10 * j10) - ((long) (c10 - '0'));
                            int i15 = (j10 > MIN_INCOMPLETE_INTEGER ? 1 : (j10 == MIN_INCOMPLETE_INTEGER ? 0 : -1));
                            z10 &= i15 > 0 || (i15 == 0 && j11 < j10);
                            j10 = j11;
                        } else if (c11 == 3) {
                            i13 = 0;
                            c11 = 4;
                        } else if (c11 == 5 || c11 == 6) {
                            i13 = 0;
                            c11 = 7;
                        }
                        i13 = 0;
                    }
                }
                i14++;
            }
            c11 = 6;
            i14++;
        }
        if (isLiteral(c10)) {
            return 0;
        }
        if (c11 == 2 && z10 && ((j10 != Long.MIN_VALUE || z11) && (j10 != 0 || !z11))) {
            if (!z11) {
                j10 = -j10;
            }
            this.peekedLong = j10;
            this.pos += i14;
            i10 = PEEKED_LONG;
        } else if (c11 != 2 && c11 != 4 && c11 != 7) {
            return 0;
        } else {
            this.peekedNumberLength = i14;
            i10 = 16;
        }
        this.peeked = i10;
        return i10;
    }

    private void push(int i10) {
        int i11 = this.stackSize;
        int[] iArr = this.stack;
        if (i11 == iArr.length) {
            int[] iArr2 = new int[(i11 * 2)];
            int[] iArr3 = new int[(i11 * 2)];
            String[] strArr = new String[(i11 * 2)];
            System.arraycopy(iArr, 0, iArr2, 0, i11);
            System.arraycopy(this.pathIndices, 0, iArr3, 0, this.stackSize);
            System.arraycopy(this.pathNames, 0, strArr, 0, this.stackSize);
            this.stack = iArr2;
            this.pathIndices = iArr3;
            this.pathNames = strArr;
        }
        int[] iArr4 = this.stack;
        int i12 = this.stackSize;
        this.stackSize = i12 + 1;
        iArr4[i12] = i10;
    }

    private char readEscapeCharacter() throws IOException {
        int i10;
        int i11;
        if (this.pos != this.limit || fillBuffer(1)) {
            char[] cArr = this.buffer;
            int i12 = this.pos;
            int i13 = i12 + 1;
            this.pos = i13;
            char c10 = cArr[i12];
            if (c10 == PEEKED_UNQUOTED) {
                this.lineNumber++;
                this.lineStart = i13;
            } else if (!(c10 == '\"' || c10 == '\'' || c10 == '/' || c10 == '\\')) {
                if (c10 == 'b') {
                    return 8;
                }
                if (c10 == 'f') {
                    return 12;
                }
                if (c10 == 'n') {
                    return 10;
                }
                if (c10 == 'r') {
                    return 13;
                }
                if (c10 == 't') {
                    return 9;
                }
                if (c10 != 'u') {
                    throw syntaxError("Invalid escape sequence");
                } else if (i13 + 4 <= this.limit || fillBuffer(4)) {
                    int i14 = this.pos;
                    int i15 = i14 + 4;
                    char c11 = 0;
                    while (i14 < i15) {
                        char c12 = this.buffer[i14];
                        char c13 = (char) (c11 << 4);
                        if (c12 < '0' || c12 > '9') {
                            if (c12 >= 'a' && c12 <= 'f') {
                                i10 = c12 - 'a';
                            } else if (c12 < 'A' || c12 > 'F') {
                                throw new NumberFormatException("\\u".concat(new String(this.buffer, this.pos, 4)));
                            } else {
                                i10 = c12 - 'A';
                            }
                            i11 = i10 + PEEKED_UNQUOTED;
                        } else {
                            i11 = c12 - '0';
                        }
                        c11 = (char) (i11 + c13);
                        i14++;
                    }
                    this.pos += 4;
                    return c11;
                } else {
                    throw syntaxError("Unterminated escape sequence");
                }
            }
            return c10;
        }
        throw syntaxError("Unterminated escape sequence");
    }

    private void skipQuotedValue(char c10) throws IOException {
        char[] cArr = this.buffer;
        while (true) {
            int i10 = this.pos;
            int i11 = this.limit;
            while (true) {
                if (i10 < i11) {
                    int i12 = i10 + 1;
                    char c11 = cArr[i10];
                    if (c11 == c10) {
                        this.pos = i12;
                        return;
                    } else if (c11 == '\\') {
                        this.pos = i12;
                        readEscapeCharacter();
                        break;
                    } else {
                        if (c11 == PEEKED_UNQUOTED) {
                            this.lineNumber++;
                            this.lineStart = i12;
                        }
                        i10 = i12;
                    }
                } else {
                    this.pos = i10;
                    if (!fillBuffer(1)) {
                        throw syntaxError("Unterminated string");
                    }
                }
            }
        }
    }

    private boolean skipTo(String str) throws IOException {
        int length = str.length();
        while (true) {
            int i10 = 0;
            if (this.pos + length > this.limit && !fillBuffer(length)) {
                return false;
            }
            char[] cArr = this.buffer;
            int i11 = this.pos;
            if (cArr[i11] == PEEKED_UNQUOTED) {
                this.lineNumber++;
                this.lineStart = i11 + 1;
            } else {
                while (i10 < length) {
                    if (this.buffer[this.pos + i10] == str.charAt(i10)) {
                        i10++;
                    }
                }
                return true;
            }
            this.pos++;
        }
    }

    private void skipToEndOfLine() throws IOException {
        char c10;
        do {
            if (this.pos < this.limit || fillBuffer(1)) {
                char[] cArr = this.buffer;
                int i10 = this.pos;
                int i11 = i10 + 1;
                this.pos = i11;
                c10 = cArr[i10];
                if (c10 == PEEKED_UNQUOTED) {
                    this.lineNumber++;
                    this.lineStart = i11;
                    return;
                }
            } else {
                return;
            }
        } while (c10 != PEEKED_DOUBLE_QUOTED_NAME);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0048, code lost:
        checkLenient();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void skipUnquotedValue() throws java.io.IOException {
        /*
            r4 = this;
        L_0x0000:
            r0 = 0
        L_0x0001:
            int r1 = r4.pos
            int r2 = r1 + r0
            int r3 = r4.limit
            if (r2 >= r3) goto L_0x0051
            char[] r2 = r4.buffer
            int r1 = r1 + r0
            char r1 = r2[r1]
            r2 = 9
            if (r1 == r2) goto L_0x004b
            r2 = 10
            if (r1 == r2) goto L_0x004b
            r2 = 12
            if (r1 == r2) goto L_0x004b
            r2 = 13
            if (r1 == r2) goto L_0x004b
            r2 = 32
            if (r1 == r2) goto L_0x004b
            r2 = 35
            if (r1 == r2) goto L_0x0048
            r2 = 44
            if (r1 == r2) goto L_0x004b
            r2 = 47
            if (r1 == r2) goto L_0x0048
            r2 = 61
            if (r1 == r2) goto L_0x0048
            r2 = 123(0x7b, float:1.72E-43)
            if (r1 == r2) goto L_0x004b
            r2 = 125(0x7d, float:1.75E-43)
            if (r1 == r2) goto L_0x004b
            r2 = 58
            if (r1 == r2) goto L_0x004b
            r2 = 59
            if (r1 == r2) goto L_0x0048
            switch(r1) {
                case 91: goto L_0x004b;
                case 92: goto L_0x0048;
                case 93: goto L_0x004b;
                default: goto L_0x0045;
            }
        L_0x0045:
            int r0 = r0 + 1
            goto L_0x0001
        L_0x0048:
            r4.checkLenient()
        L_0x004b:
            int r1 = r4.pos
            int r1 = r1 + r0
            r4.pos = r1
            return
        L_0x0051:
            int r1 = r1 + r0
            r4.pos = r1
            r0 = 1
            boolean r0 = r4.fillBuffer(r0)
            if (r0 != 0) goto L_0x0000
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.stream.JsonReader.skipUnquotedValue():void");
    }

    private IOException syntaxError(String str) throws IOException {
        StringBuilder q10 = android.support.v4.media.h.q(str);
        q10.append(locationString());
        throw new MalformedJsonException(q10.toString());
    }

    public void beginArray() throws IOException {
        int i10 = this.peeked;
        if (i10 == 0) {
            i10 = doPeek();
        }
        if (i10 == 3) {
            push(1);
            this.pathIndices[this.stackSize - 1] = 0;
            this.peeked = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_ARRAY but was " + peek() + locationString());
    }

    public void beginObject() throws IOException {
        int i10 = this.peeked;
        if (i10 == 0) {
            i10 = doPeek();
        }
        if (i10 == 1) {
            push(3);
            this.peeked = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_OBJECT but was " + peek() + locationString());
    }

    public void close() throws IOException {
        this.peeked = 0;
        this.stack[0] = PEEKED_SINGLE_QUOTED;
        this.stackSize = 1;
        this.in.close();
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x010c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int doPeek() throws java.io.IOException {
        /*
            r15 = this;
            int[] r0 = r15.stack
            int r1 = r15.stackSize
            int r2 = r1 + -1
            r2 = r0[r2]
            r3 = 8
            r4 = 39
            r5 = 34
            r6 = 93
            r7 = 3
            r8 = 7
            r9 = 59
            r10 = 44
            r11 = 4
            r12 = 2
            r13 = 1
            if (r2 != r13) goto L_0x0020
            int r1 = r1 - r13
            r0[r1] = r12
            goto L_0x00a2
        L_0x0020:
            if (r2 != r12) goto L_0x003a
            int r0 = r15.nextNonWhitespace(r13)
            if (r0 == r10) goto L_0x00a2
            if (r0 == r9) goto L_0x0036
            if (r0 != r6) goto L_0x002f
            r15.peeked = r11
            return r11
        L_0x002f:
            java.lang.String r0 = "Unterminated array"
            java.io.IOException r0 = r15.syntaxError(r0)
            throw r0
        L_0x0036:
            r15.checkLenient()
            goto L_0x00a2
        L_0x003a:
            r14 = 5
            if (r2 == r7) goto L_0x0117
            if (r2 != r14) goto L_0x0041
            goto L_0x0117
        L_0x0041:
            if (r2 != r11) goto L_0x0076
            int r1 = r1 - r13
            r0[r1] = r14
            int r0 = r15.nextNonWhitespace(r13)
            r1 = 58
            if (r0 == r1) goto L_0x00a2
            r1 = 61
            if (r0 != r1) goto L_0x006f
            r15.checkLenient()
            int r0 = r15.pos
            int r1 = r15.limit
            if (r0 < r1) goto L_0x0061
            boolean r0 = r15.fillBuffer(r13)
            if (r0 == 0) goto L_0x00a2
        L_0x0061:
            char[] r0 = r15.buffer
            int r1 = r15.pos
            char r0 = r0[r1]
            r14 = 62
            if (r0 != r14) goto L_0x00a2
            int r1 = r1 + r13
            r15.pos = r1
            goto L_0x00a2
        L_0x006f:
            java.lang.String r0 = "Expected ':'"
            java.io.IOException r0 = r15.syntaxError(r0)
            throw r0
        L_0x0076:
            r0 = 6
            if (r2 != r0) goto L_0x0088
            boolean r0 = r15.lenient
            if (r0 == 0) goto L_0x0080
            r15.consumeNonExecutePrefix()
        L_0x0080:
            int[] r0 = r15.stack
            int r1 = r15.stackSize
            int r1 = r1 - r13
            r0[r1] = r8
            goto L_0x00a2
        L_0x0088:
            if (r2 != r8) goto L_0x00a0
            r0 = 0
            int r0 = r15.nextNonWhitespace(r0)
            r1 = -1
            if (r0 != r1) goto L_0x0097
            r0 = 17
        L_0x0094:
            r15.peeked = r0
            return r0
        L_0x0097:
            r15.checkLenient()
            int r0 = r15.pos
            int r0 = r0 - r13
            r15.pos = r0
            goto L_0x00a2
        L_0x00a0:
            if (r2 == r3) goto L_0x010f
        L_0x00a2:
            int r0 = r15.nextNonWhitespace(r13)
            if (r0 == r5) goto L_0x010c
            if (r0 == r4) goto L_0x0106
            if (r0 == r10) goto L_0x00ef
            if (r0 == r9) goto L_0x00ef
            r1 = 91
            if (r0 == r1) goto L_0x00ec
            if (r0 == r6) goto L_0x00e7
            r1 = 123(0x7b, float:1.72E-43)
            if (r0 == r1) goto L_0x00e4
            int r0 = r15.pos
            int r0 = r0 - r13
            r15.pos = r0
            int r0 = r15.peekKeyword()
            if (r0 == 0) goto L_0x00c4
            return r0
        L_0x00c4:
            int r0 = r15.peekNumber()
            if (r0 == 0) goto L_0x00cb
            return r0
        L_0x00cb:
            char[] r0 = r15.buffer
            int r1 = r15.pos
            char r0 = r0[r1]
            boolean r0 = r15.isLiteral(r0)
            if (r0 == 0) goto L_0x00dd
            r15.checkLenient()
            r0 = 10
            goto L_0x0094
        L_0x00dd:
            java.lang.String r0 = "Expected value"
            java.io.IOException r0 = r15.syntaxError(r0)
            throw r0
        L_0x00e4:
            r15.peeked = r13
            return r13
        L_0x00e7:
            if (r2 != r13) goto L_0x00ef
            r15.peeked = r11
            return r11
        L_0x00ec:
            r15.peeked = r7
            return r7
        L_0x00ef:
            if (r2 == r13) goto L_0x00fb
            if (r2 != r12) goto L_0x00f4
            goto L_0x00fb
        L_0x00f4:
            java.lang.String r0 = "Unexpected value"
            java.io.IOException r0 = r15.syntaxError(r0)
            throw r0
        L_0x00fb:
            r15.checkLenient()
            int r0 = r15.pos
            int r0 = r0 - r13
            r15.pos = r0
            r15.peeked = r8
            return r8
        L_0x0106:
            r15.checkLenient()
            r15.peeked = r3
            return r3
        L_0x010c:
            r0 = 9
            goto L_0x0094
        L_0x010f:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "JsonReader is closed"
            r0.<init>(r1)
            throw r0
        L_0x0117:
            int r1 = r1 - r13
            r0[r1] = r11
            r0 = 125(0x7d, float:1.75E-43)
            if (r2 != r14) goto L_0x0135
            int r1 = r15.nextNonWhitespace(r13)
            if (r1 == r10) goto L_0x0135
            if (r1 == r9) goto L_0x0132
            if (r1 != r0) goto L_0x012b
            r15.peeked = r12
            return r12
        L_0x012b:
            java.lang.String r0 = "Unterminated object"
            java.io.IOException r0 = r15.syntaxError(r0)
            throw r0
        L_0x0132:
            r15.checkLenient()
        L_0x0135:
            int r1 = r15.nextNonWhitespace(r13)
            if (r1 == r5) goto L_0x016a
            if (r1 == r4) goto L_0x0163
            java.lang.String r3 = "Expected name"
            if (r1 == r0) goto L_0x0159
            r15.checkLenient()
            int r0 = r15.pos
            int r0 = r0 - r13
            r15.pos = r0
            char r0 = (char) r1
            boolean r0 = r15.isLiteral(r0)
            if (r0 == 0) goto L_0x0154
            r0 = 14
            goto L_0x0094
        L_0x0154:
            java.io.IOException r0 = r15.syntaxError(r3)
            throw r0
        L_0x0159:
            if (r2 == r14) goto L_0x015e
            r15.peeked = r12
            return r12
        L_0x015e:
            java.io.IOException r0 = r15.syntaxError(r3)
            throw r0
        L_0x0163:
            r15.checkLenient()
            r0 = 12
            goto L_0x0094
        L_0x016a:
            r0 = 13
            goto L_0x0094
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.stream.JsonReader.doPeek():int");
    }

    public void endArray() throws IOException {
        int i10 = this.peeked;
        if (i10 == 0) {
            i10 = doPeek();
        }
        if (i10 == 4) {
            int i11 = this.stackSize - 1;
            this.stackSize = i11;
            int[] iArr = this.pathIndices;
            int i12 = i11 - 1;
            iArr[i12] = iArr[i12] + 1;
            this.peeked = 0;
            return;
        }
        throw new IllegalStateException("Expected END_ARRAY but was " + peek() + locationString());
    }

    public void endObject() throws IOException {
        int i10 = this.peeked;
        if (i10 == 0) {
            i10 = doPeek();
        }
        if (i10 == 2) {
            int i11 = this.stackSize - 1;
            this.stackSize = i11;
            this.pathNames[i11] = null;
            int[] iArr = this.pathIndices;
            int i12 = i11 - 1;
            iArr[i12] = iArr[i12] + 1;
            this.peeked = 0;
            return;
        }
        throw new IllegalStateException("Expected END_OBJECT but was " + peek() + locationString());
    }

    public String getPath() {
        StringBuilder sb2 = new StringBuilder("$");
        int i10 = this.stackSize;
        for (int i11 = 0; i11 < i10; i11++) {
            int i12 = this.stack[i11];
            if (i12 == 1 || i12 == 2) {
                sb2.append('[');
                sb2.append(this.pathIndices[i11]);
                sb2.append(']');
            } else if (i12 == 3 || i12 == 4 || i12 == 5) {
                sb2.append('.');
                String str = this.pathNames[i11];
                if (str != null) {
                    sb2.append(str);
                }
            }
        }
        return sb2.toString();
    }

    public boolean hasNext() throws IOException {
        int i10 = this.peeked;
        if (i10 == 0) {
            i10 = doPeek();
        }
        return (i10 == 2 || i10 == 4) ? false : true;
    }

    public final boolean isLenient() {
        return this.lenient;
    }

    public String locationString() {
        return " at line " + (this.lineNumber + 1) + " column " + ((this.pos - this.lineStart) + 1) + " path " + getPath();
    }

    public boolean nextBoolean() throws IOException {
        int i10 = this.peeked;
        if (i10 == 0) {
            i10 = doPeek();
        }
        if (i10 == 5) {
            this.peeked = 0;
            int[] iArr = this.pathIndices;
            int i11 = this.stackSize - 1;
            iArr[i11] = iArr[i11] + 1;
            return true;
        } else if (i10 == 6) {
            this.peeked = 0;
            int[] iArr2 = this.pathIndices;
            int i12 = this.stackSize - 1;
            iArr2[i12] = iArr2[i12] + 1;
            return false;
        } else {
            throw new IllegalStateException("Expected a boolean but was " + peek() + locationString());
        }
    }

    public double nextDouble() throws IOException {
        String str;
        int i10 = this.peeked;
        if (i10 == 0) {
            i10 = doPeek();
        }
        if (i10 == PEEKED_LONG) {
            this.peeked = 0;
            int[] iArr = this.pathIndices;
            int i11 = this.stackSize - 1;
            iArr[i11] = iArr[i11] + 1;
            return (double) this.peekedLong;
        }
        if (i10 == 16) {
            this.peekedString = new String(this.buffer, this.pos, this.peekedNumberLength);
            this.pos += this.peekedNumberLength;
        } else {
            if (i10 == PEEKED_SINGLE_QUOTED || i10 == PEEKED_DOUBLE_QUOTED) {
                str = nextQuotedValue(i10 == PEEKED_SINGLE_QUOTED ? '\'' : '\"');
            } else if (i10 == PEEKED_UNQUOTED) {
                str = nextUnquotedValue();
            } else if (i10 != PEEKED_BUFFERED) {
                throw new IllegalStateException("Expected a double but was " + peek() + locationString());
            }
            this.peekedString = str;
        }
        this.peeked = PEEKED_BUFFERED;
        double parseDouble = Double.parseDouble(this.peekedString);
        if (this.lenient || (!Double.isNaN(parseDouble) && !Double.isInfinite(parseDouble))) {
            this.peekedString = null;
            this.peeked = 0;
            int[] iArr2 = this.pathIndices;
            int i12 = this.stackSize - 1;
            iArr2[i12] = iArr2[i12] + 1;
            return parseDouble;
        }
        throw new MalformedJsonException("JSON forbids NaN and infinities: " + parseDouble + locationString());
    }

    public int nextInt() throws IOException {
        String nextQuotedValue;
        int i10 = this.peeked;
        if (i10 == 0) {
            i10 = doPeek();
        }
        if (i10 == PEEKED_LONG) {
            long j10 = this.peekedLong;
            int i11 = (int) j10;
            if (j10 == ((long) i11)) {
                this.peeked = 0;
                int[] iArr = this.pathIndices;
                int i12 = this.stackSize - 1;
                iArr[i12] = iArr[i12] + 1;
                return i11;
            }
            throw new NumberFormatException("Expected an int but was " + this.peekedLong + locationString());
        }
        if (i10 == 16) {
            this.peekedString = new String(this.buffer, this.pos, this.peekedNumberLength);
            this.pos += this.peekedNumberLength;
        } else if (i10 == PEEKED_SINGLE_QUOTED || i10 == PEEKED_DOUBLE_QUOTED || i10 == PEEKED_UNQUOTED) {
            if (i10 == PEEKED_UNQUOTED) {
                nextQuotedValue = nextUnquotedValue();
            } else {
                nextQuotedValue = nextQuotedValue(i10 == PEEKED_SINGLE_QUOTED ? '\'' : '\"');
            }
            this.peekedString = nextQuotedValue;
            try {
                int parseInt = Integer.parseInt(this.peekedString);
                this.peeked = 0;
                int[] iArr2 = this.pathIndices;
                int i13 = this.stackSize - 1;
                iArr2[i13] = iArr2[i13] + 1;
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        } else {
            throw new IllegalStateException("Expected an int but was " + peek() + locationString());
        }
        this.peeked = PEEKED_BUFFERED;
        double parseDouble = Double.parseDouble(this.peekedString);
        int i14 = (int) parseDouble;
        if (((double) i14) == parseDouble) {
            this.peekedString = null;
            this.peeked = 0;
            int[] iArr3 = this.pathIndices;
            int i15 = this.stackSize - 1;
            iArr3[i15] = iArr3[i15] + 1;
            return i14;
        }
        throw new NumberFormatException("Expected an int but was " + this.peekedString + locationString());
    }

    public long nextLong() throws IOException {
        String nextQuotedValue;
        int i10 = this.peeked;
        if (i10 == 0) {
            i10 = doPeek();
        }
        if (i10 == PEEKED_LONG) {
            this.peeked = 0;
            int[] iArr = this.pathIndices;
            int i11 = this.stackSize - 1;
            iArr[i11] = iArr[i11] + 1;
            return this.peekedLong;
        }
        if (i10 == 16) {
            this.peekedString = new String(this.buffer, this.pos, this.peekedNumberLength);
            this.pos += this.peekedNumberLength;
        } else if (i10 == PEEKED_SINGLE_QUOTED || i10 == PEEKED_DOUBLE_QUOTED || i10 == PEEKED_UNQUOTED) {
            if (i10 == PEEKED_UNQUOTED) {
                nextQuotedValue = nextUnquotedValue();
            } else {
                nextQuotedValue = nextQuotedValue(i10 == PEEKED_SINGLE_QUOTED ? '\'' : '\"');
            }
            this.peekedString = nextQuotedValue;
            try {
                long parseLong = Long.parseLong(this.peekedString);
                this.peeked = 0;
                int[] iArr2 = this.pathIndices;
                int i12 = this.stackSize - 1;
                iArr2[i12] = iArr2[i12] + 1;
                return parseLong;
            } catch (NumberFormatException unused) {
            }
        } else {
            throw new IllegalStateException("Expected a long but was " + peek() + locationString());
        }
        this.peeked = PEEKED_BUFFERED;
        double parseDouble = Double.parseDouble(this.peekedString);
        long j10 = (long) parseDouble;
        if (((double) j10) == parseDouble) {
            this.peekedString = null;
            this.peeked = 0;
            int[] iArr3 = this.pathIndices;
            int i13 = this.stackSize - 1;
            iArr3[i13] = iArr3[i13] + 1;
            return j10;
        }
        throw new NumberFormatException("Expected a long but was " + this.peekedString + locationString());
    }

    public String nextName() throws IOException {
        String str;
        char c10;
        int i10 = this.peeked;
        if (i10 == 0) {
            i10 = doPeek();
        }
        if (i10 == PEEKED_UNQUOTED_NAME) {
            str = nextUnquotedValue();
        } else {
            if (i10 == PEEKED_SINGLE_QUOTED_NAME) {
                c10 = '\'';
            } else if (i10 == PEEKED_DOUBLE_QUOTED_NAME) {
                c10 = '\"';
            } else {
                throw new IllegalStateException("Expected a name but was " + peek() + locationString());
            }
            str = nextQuotedValue(c10);
        }
        this.peeked = 0;
        this.pathNames[this.stackSize - 1] = str;
        return str;
    }

    public void nextNull() throws IOException {
        int i10 = this.peeked;
        if (i10 == 0) {
            i10 = doPeek();
        }
        if (i10 == 7) {
            this.peeked = 0;
            int[] iArr = this.pathIndices;
            int i11 = this.stackSize - 1;
            iArr[i11] = iArr[i11] + 1;
            return;
        }
        throw new IllegalStateException("Expected null but was " + peek() + locationString());
    }

    public String nextString() throws IOException {
        String str;
        char c10;
        int i10 = this.peeked;
        if (i10 == 0) {
            i10 = doPeek();
        }
        if (i10 == PEEKED_UNQUOTED) {
            str = nextUnquotedValue();
        } else {
            if (i10 == PEEKED_SINGLE_QUOTED) {
                c10 = '\'';
            } else if (i10 == PEEKED_DOUBLE_QUOTED) {
                c10 = '\"';
            } else if (i10 == PEEKED_BUFFERED) {
                str = this.peekedString;
                this.peekedString = null;
            } else if (i10 == PEEKED_LONG) {
                str = Long.toString(this.peekedLong);
            } else if (i10 == 16) {
                str = new String(this.buffer, this.pos, this.peekedNumberLength);
                this.pos += this.peekedNumberLength;
            } else {
                throw new IllegalStateException("Expected a string but was " + peek() + locationString());
            }
            str = nextQuotedValue(c10);
        }
        this.peeked = 0;
        int[] iArr = this.pathIndices;
        int i11 = this.stackSize - 1;
        iArr[i11] = iArr[i11] + 1;
        return str;
    }

    public JsonToken peek() throws IOException {
        int i10 = this.peeked;
        if (i10 == 0) {
            i10 = doPeek();
        }
        switch (i10) {
            case 1:
                return JsonToken.BEGIN_OBJECT;
            case 2:
                return JsonToken.END_OBJECT;
            case 3:
                return JsonToken.BEGIN_ARRAY;
            case 4:
                return JsonToken.END_ARRAY;
            case Constants.MAX_COMPATIBILITY_VERSION:
            case 6:
                return JsonToken.BOOLEAN;
            case 7:
                return JsonToken.NULL;
            case PEEKED_SINGLE_QUOTED /*8*/:
            case PEEKED_DOUBLE_QUOTED /*9*/:
            case PEEKED_UNQUOTED /*10*/:
            case PEEKED_BUFFERED /*11*/:
                return JsonToken.STRING;
            case PEEKED_SINGLE_QUOTED_NAME /*12*/:
            case PEEKED_DOUBLE_QUOTED_NAME /*13*/:
            case PEEKED_UNQUOTED_NAME /*14*/:
                return JsonToken.NAME;
            case PEEKED_LONG /*15*/:
            case 16:
                return JsonToken.NUMBER;
            case PEEKED_EOF /*17*/:
                return JsonToken.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    public final void setLenient(boolean z10) {
        this.lenient = z10;
    }

    public void skipValue() throws IOException {
        char c10;
        int i10 = 0;
        do {
            int i11 = this.peeked;
            if (i11 == 0) {
                i11 = doPeek();
            }
            if (i11 == 3) {
                push(1);
            } else if (i11 == 1) {
                push(3);
            } else if (i11 == 4 || i11 == 2) {
                this.stackSize--;
                i10--;
                this.peeked = 0;
            } else if (i11 == PEEKED_UNQUOTED_NAME || i11 == PEEKED_UNQUOTED) {
                skipUnquotedValue();
                this.peeked = 0;
            } else {
                if (i11 == PEEKED_SINGLE_QUOTED || i11 == PEEKED_SINGLE_QUOTED_NAME) {
                    c10 = '\'';
                } else if (i11 == PEEKED_DOUBLE_QUOTED || i11 == PEEKED_DOUBLE_QUOTED_NAME) {
                    c10 = '\"';
                } else {
                    if (i11 == 16) {
                        this.pos += this.peekedNumberLength;
                    }
                    this.peeked = 0;
                }
                skipQuotedValue(c10);
                this.peeked = 0;
            }
            i10++;
            this.peeked = 0;
        } while (i10 != 0);
        int[] iArr = this.pathIndices;
        int i12 = this.stackSize;
        int i13 = i12 - 1;
        iArr[i13] = iArr[i13] + 1;
        this.pathNames[i12 - 1] = "null";
    }

    public String toString() {
        return getClass().getSimpleName() + locationString();
    }
}
