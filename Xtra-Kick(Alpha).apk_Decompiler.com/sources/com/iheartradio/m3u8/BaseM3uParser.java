package com.iheartradio.m3u8;

import java.io.EOFException;
import java.io.InputStream;

abstract class BaseM3uParser implements IPlaylistParser {
    protected final Encoding mEncoding;
    protected final M3uScanner mScanner;

    public BaseM3uParser(InputStream inputStream, Encoding encoding) {
        this.mScanner = new M3uScanner(inputStream, encoding);
        this.mEncoding = encoding;
    }

    public boolean isAvailable() {
        return this.mScanner.hasNext();
    }

    public final void validateAvailable() throws EOFException {
        if (!isAvailable()) {
            throw new EOFException();
        }
    }
}
