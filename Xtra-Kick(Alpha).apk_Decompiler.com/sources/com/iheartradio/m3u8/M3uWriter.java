package com.iheartradio.m3u8;

import com.iheartradio.m3u8.data.Playlist;
import java.io.IOException;
import java.io.OutputStream;

class M3uWriter extends Writer {
    public M3uWriter(OutputStream outputStream, Encoding encoding) {
        super(outputStream, encoding);
    }

    public void doWrite(Playlist playlist) throws IOException {
        throw new UnsupportedOperationException();
    }
}
