package com.iheartradio.m3u8;

import java.io.Closeable;
import java.io.InputStream;
import java.util.Locale;
import java.util.Scanner;

public class ExtendedM3uScanner implements Closeable {
    private boolean mClosed = false;
    private final StringBuilder mInput = new StringBuilder();
    private final Scanner mScanner;

    public ExtendedM3uScanner(InputStream inputStream, Encoding encoding) {
        this.mScanner = new Scanner(inputStream, encoding.value).useLocale(Locale.US).useDelimiter(Constants.PARSE_NEW_LINE);
    }

    public void close() {
        this.mScanner.close();
        this.mClosed = true;
    }

    public String getInput() {
        return this.mInput.toString();
    }

    public boolean hasNext() {
        return !this.mClosed && this.mScanner.hasNext();
    }

    public String next() throws ParseException {
        String next = this.mScanner.next();
        this.mInput.append(next);
        return next;
    }
}
