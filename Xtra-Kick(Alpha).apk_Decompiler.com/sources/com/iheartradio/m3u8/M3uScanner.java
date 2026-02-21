package com.iheartradio.m3u8;

import java.io.InputStream;
import java.util.Locale;
import java.util.Scanner;

class M3uScanner {
    private boolean mCheckedByteOrderMark;
    private final StringBuilder mInput = new StringBuilder();
    private final Scanner mScanner;
    private final boolean mSupportsByteOrderMark;

    public M3uScanner(InputStream inputStream, Encoding encoding) {
        this.mScanner = new Scanner(inputStream, encoding.value).useLocale(Locale.US).useDelimiter(Constants.PARSE_NEW_LINE);
        this.mSupportsByteOrderMark = encoding.supportsByteOrderMark;
    }

    public String getInput() {
        return this.mInput.toString();
    }

    public boolean hasNext() {
        return this.mScanner.hasNext();
    }

    public String next() throws ParseException {
        String next = this.mScanner.next();
        if (this.mSupportsByteOrderMark && !this.mCheckedByteOrderMark) {
            if (!next.isEmpty() && next.charAt(0) == 65279) {
                next = next.substring(1);
            }
            this.mCheckedByteOrderMark = true;
        }
        StringBuilder sb2 = this.mInput;
        sb2.append(next);
        sb2.append(Constants.WRITE_NEW_LINE);
        return next;
    }
}
