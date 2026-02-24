package com.iheartradio.m3u8;

import com.iheartradio.m3u8.data.Playlist;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class ExtendedM3uWriter extends Writer {
    private List<SectionWriter> mExtTagWriter = new ArrayList();

    public ExtendedM3uWriter(OutputStream outputStream, Encoding encoding) {
        super(outputStream, encoding);
        putWriters(ExtTagWriter.EXTM3U_HANDLER, ExtTagWriter.EXT_X_VERSION_HANDLER, MediaPlaylistTagWriter.EXT_X_PLAYLIST_TYPE, MediaPlaylistTagWriter.EXT_X_TARGETDURATION, MediaPlaylistTagWriter.EXT_X_START, MediaPlaylistTagWriter.EXT_X_MEDIA_SEQUENCE, MediaPlaylistTagWriter.EXT_X_I_FRAMES_ONLY, MasterPlaylistTagWriter.EXT_X_MEDIA, MediaPlaylistTagWriter.EXT_X_ALLOW_CACHE, MasterPlaylistTagWriter.EXT_X_STREAM_INF, MasterPlaylistTagWriter.EXT_X_I_FRAME_STREAM_INF, MediaPlaylistTagWriter.MEDIA_SEGMENTS, MediaPlaylistTagWriter.EXT_X_ENDLIST);
    }

    private void putWriters(SectionWriter... sectionWriterArr) {
        if (sectionWriterArr != null) {
            Collections.addAll(this.mExtTagWriter, sectionWriterArr);
        }
    }

    public void doWrite(Playlist playlist) throws IOException, ParseException, PlaylistException {
        for (SectionWriter write : this.mExtTagWriter) {
            write.write(this.tagWriter, playlist);
        }
    }
}
