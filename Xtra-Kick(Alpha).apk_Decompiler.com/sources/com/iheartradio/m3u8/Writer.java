package com.iheartradio.m3u8;

import android.support.v4.media.h;
import com.iheartradio.m3u8.data.Playlist;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

abstract class Writer {
    final TagWriter tagWriter;

    public Writer(OutputStream outputStream, Encoding encoding) {
        try {
            this.tagWriter = new TagWriter(new OutputStreamWriter(outputStream, encoding.getValue()));
        } catch (UnsupportedEncodingException e10) {
            throw new IllegalArgumentException(e10.getMessage(), e10);
        }
    }

    public abstract void doWrite(Playlist playlist) throws IOException, ParseException, PlaylistException;

    public final void write(Playlist playlist) throws IOException, ParseException, PlaylistException {
        doWrite(playlist);
        this.tagWriter.flush();
    }

    public void writeLine(String str) throws IOException {
        this.tagWriter.write(str);
        this.tagWriter.write(Constants.WRITE_NEW_LINE);
    }

    public void writeTagLine(String str) throws IOException {
        writeLine(h.m(Constants.COMMENT_PREFIX, str));
    }

    public void writeTagLine(String str, Object obj) throws IOException {
        writeLine(Constants.COMMENT_PREFIX + str + Constants.EXT_TAG_END + obj);
    }
}
