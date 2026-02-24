package com.iheartradio.m3u8;

import android.support.v4.media.h;
import java.io.IOException;
import java.io.OutputStreamWriter;
import q0.f;

class TagWriter {
    private final OutputStreamWriter mWriter;

    public TagWriter(OutputStreamWriter outputStreamWriter) {
        this.mWriter = outputStreamWriter;
    }

    public void flush() throws IOException {
        this.mWriter.flush();
    }

    public void write(String str) throws IOException {
        this.mWriter.write(str);
    }

    public void writeLine(String str) throws IOException {
        write(f.g(str, Constants.WRITE_NEW_LINE));
    }

    public void writeTag(String str) throws IOException {
        writeLine(h.m(Constants.COMMENT_PREFIX, str));
    }

    public void writeTag(String str, String str2) throws IOException {
        writeLine(Constants.COMMENT_PREFIX + str + Constants.EXT_TAG_END + str2);
    }
}
