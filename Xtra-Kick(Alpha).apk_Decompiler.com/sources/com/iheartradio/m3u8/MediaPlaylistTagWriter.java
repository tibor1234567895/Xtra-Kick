package com.iheartradio.m3u8;

import com.iheartradio.m3u8.data.EncryptionData;
import com.iheartradio.m3u8.data.MediaPlaylist;
import com.iheartradio.m3u8.data.Playlist;
import com.iheartradio.m3u8.data.StartData;
import com.iheartradio.m3u8.data.TrackData;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

abstract class MediaPlaylistTagWriter extends ExtTagWriter {
    static final IExtTagWriter EXT_X_ALLOW_CACHE = new MediaPlaylistTagWriter() {
        public void doWrite(TagWriter tagWriter, Playlist playlist, MediaPlaylist mediaPlaylist) {
        }

        public String getTag() {
            return Constants.EXT_X_ALLOW_CACHE_TAG;
        }

        public boolean hasData() {
            return true;
        }
    };
    static final IExtTagWriter EXT_X_ENDLIST = new MediaPlaylistTagWriter() {
        public void doWrite(TagWriter tagWriter, Playlist playlist, MediaPlaylist mediaPlaylist) throws IOException {
            if (!mediaPlaylist.isOngoing()) {
                tagWriter.writeTag(getTag());
            }
        }

        public String getTag() {
            return Constants.EXT_X_ENDLIST_TAG;
        }

        public boolean hasData() {
            return false;
        }
    };
    static final IExtTagWriter EXT_X_I_FRAMES_ONLY = new MediaPlaylistTagWriter() {
        public void doWrite(TagWriter tagWriter, Playlist playlist, MediaPlaylist mediaPlaylist) throws IOException {
            if (mediaPlaylist.isIframesOnly()) {
                tagWriter.writeTag(getTag());
            }
        }

        public String getTag() {
            return Constants.EXT_X_I_FRAMES_ONLY_TAG;
        }

        public boolean hasData() {
            return false;
        }
    };
    static final IExtTagWriter EXT_X_MEDIA_SEQUENCE = new MediaPlaylistTagWriter() {
        public void doWrite(TagWriter tagWriter, Playlist playlist, MediaPlaylist mediaPlaylist) throws IOException, ParseException {
            tagWriter.writeTag(getTag(), Integer.toString(mediaPlaylist.getMediaSequenceNumber()));
        }

        public String getTag() {
            return Constants.EXT_X_MEDIA_SEQUENCE_TAG;
        }

        public boolean hasData() {
            return true;
        }
    };
    static final IExtTagWriter EXT_X_PLAYLIST_TYPE = new MediaPlaylistTagWriter() {
        public void doWrite(TagWriter tagWriter, Playlist playlist, MediaPlaylist mediaPlaylist) throws IOException {
            if (mediaPlaylist.getPlaylistType() != null) {
                tagWriter.writeTag(getTag(), mediaPlaylist.getPlaylistType().getValue());
            }
        }

        public String getTag() {
            return Constants.EXT_X_PLAYLIST_TYPE_TAG;
        }

        public boolean hasData() {
            return true;
        }
    };
    static final IExtTagWriter EXT_X_START = new MediaPlaylistTagWriter() {
        private final Map<String, AttributeWriter<StartData>> HANDLERS;

        {
            HashMap hashMap = new HashMap();
            this.HANDLERS = hashMap;
            hashMap.put(Constants.TIME_OFFSET, new AttributeWriter<StartData>() {
                public boolean containsAttribute(StartData startData) {
                    return true;
                }

                public String write(StartData startData) throws ParseException {
                    return Float.toString(startData.getTimeOffset());
                }
            });
            hashMap.put(Constants.PRECISE, new AttributeWriter<StartData>() {
                public boolean containsAttribute(StartData startData) {
                    return true;
                }

                public String write(StartData startData) throws ParseException {
                    return startData.isPrecise() ? Constants.YES : Constants.NO;
                }
            });
        }

        public void doWrite(TagWriter tagWriter, Playlist playlist, MediaPlaylist mediaPlaylist) throws IOException, ParseException {
            if (mediaPlaylist.hasStartData()) {
                writeAttributes(tagWriter, mediaPlaylist.getStartData(), this.HANDLERS);
            }
        }

        public String getTag() {
            return Constants.EXT_X_START_TAG;
        }

        public boolean hasData() {
            return true;
        }
    };
    static final IExtTagWriter EXT_X_TARGETDURATION = new MediaPlaylistTagWriter() {
        public void doWrite(TagWriter tagWriter, Playlist playlist, MediaPlaylist mediaPlaylist) throws IOException, ParseException {
            tagWriter.writeTag(getTag(), Integer.toString(mediaPlaylist.getTargetDuration()));
        }

        public String getTag() {
            return Constants.EXT_X_TARGETDURATION_TAG;
        }

        public boolean hasData() {
            return true;
        }
    };
    static final SectionWriter MEDIA_SEGMENTS = new SectionWriter() {
        public void write(TagWriter tagWriter, Playlist playlist) throws IOException, ParseException {
            if (playlist.hasMediaPlaylist()) {
                KeyWriter keyWriter = new KeyWriter();
                for (TrackData next : playlist.getMediaPlaylist().getTracks()) {
                    if (next.hasDiscontinuity()) {
                        tagWriter.writeTag(Constants.EXT_X_DISCONTINUITY_TAG);
                    }
                    keyWriter.writeTrackData(tagWriter, playlist, next);
                    MediaPlaylistTagWriter.writeExtinf(tagWriter, playlist, next);
                    tagWriter.writeLine(next.getUri());
                }
            }
        }
    };

    public static class KeyWriter extends MediaPlaylistTagWriter {
        private final Map<String, AttributeWriter<EncryptionData>> HANDLERS;
        private EncryptionData mEncryptionData;

        public KeyWriter() {
            HashMap hashMap = new HashMap();
            this.HANDLERS = hashMap;
            hashMap.put(Constants.METHOD, new AttributeWriter<EncryptionData>() {
                public boolean containsAttribute(EncryptionData encryptionData) {
                    return true;
                }

                public String write(EncryptionData encryptionData) {
                    return encryptionData.getMethod().getValue();
                }
            });
            hashMap.put(Constants.URI, new AttributeWriter<EncryptionData>() {
                public boolean containsAttribute(EncryptionData encryptionData) {
                    return true;
                }

                public String write(EncryptionData encryptionData) throws ParseException {
                    return WriteUtil.writeQuotedString(encryptionData.getUri(), KeyWriter.this.getTag());
                }
            });
            hashMap.put(Constants.IV, new AttributeWriter<EncryptionData>() {
                public boolean containsAttribute(EncryptionData encryptionData) {
                    return encryptionData.hasInitializationVector();
                }

                public String write(EncryptionData encryptionData) {
                    return WriteUtil.writeHexadecimal(encryptionData.getInitializationVector());
                }
            });
            hashMap.put(Constants.KEY_FORMAT, new AttributeWriter<EncryptionData>() {
                public boolean containsAttribute(EncryptionData encryptionData) {
                    return true;
                }

                public String write(EncryptionData encryptionData) throws ParseException {
                    return WriteUtil.writeQuotedString(encryptionData.getKeyFormat(), KeyWriter.this.getTag());
                }
            });
            hashMap.put(Constants.KEY_FORMAT_VERSIONS, new AttributeWriter<EncryptionData>() {
                public boolean containsAttribute(EncryptionData encryptionData) {
                    return true;
                }

                public String write(EncryptionData encryptionData) throws ParseException {
                    return WriteUtil.writeQuotedString(WriteUtil.join(encryptionData.getKeyFormatVersions(), Constants.LIST_SEPARATOR), KeyWriter.this.getTag());
                }
            });
        }

        public void doWrite(TagWriter tagWriter, Playlist playlist, MediaPlaylist mediaPlaylist) throws IOException, ParseException {
            writeAttributes(tagWriter, this.mEncryptionData, this.HANDLERS);
        }

        public String getTag() {
            return Constants.EXT_X_KEY_TAG;
        }

        public boolean hasData() {
            return true;
        }

        public void writeTrackData(TagWriter tagWriter, Playlist playlist, TrackData trackData) throws IOException, ParseException {
            if (trackData != null && trackData.hasEncryptionData()) {
                EncryptionData encryptionData = trackData.getEncryptionData();
                if (!encryptionData.equals(this.mEncryptionData)) {
                    this.mEncryptionData = encryptionData;
                    write(tagWriter, playlist);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public static void writeExtinf(TagWriter tagWriter, Playlist playlist, TrackData trackData) throws IOException {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(playlist.getCompatibilityVersion() <= 3 ? Integer.toString((int) trackData.getTrackInfo().duration) : Float.toString(trackData.getTrackInfo().duration));
        if (trackData.getTrackInfo().title != null) {
            sb2.append(Constants.COMMA);
            sb2.append(trackData.getTrackInfo().title);
        }
        tagWriter.writeTag(Constants.EXTINF_TAG, sb2.toString());
    }

    public void doWrite(TagWriter tagWriter, Playlist playlist, MediaPlaylist mediaPlaylist) throws IOException, ParseException {
        tagWriter.writeTag(getTag());
    }

    public final void write(TagWriter tagWriter, Playlist playlist) throws IOException, ParseException {
        if (playlist.hasMediaPlaylist()) {
            doWrite(tagWriter, playlist, playlist.getMediaPlaylist());
        }
    }
}
