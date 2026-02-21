package com.iheartradio.m3u8;

import com.iheartradio.m3u8.data.IFrameStreamInfo;
import com.iheartradio.m3u8.data.IStreamInfo;
import com.iheartradio.m3u8.data.MasterPlaylist;
import com.iheartradio.m3u8.data.MediaData;
import com.iheartradio.m3u8.data.Playlist;
import com.iheartradio.m3u8.data.PlaylistData;
import com.iheartradio.m3u8.data.StreamInfo;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

abstract class MasterPlaylistTagWriter extends ExtTagWriter {
    static final IExtTagWriter EXT_X_I_FRAME_STREAM_INF = new EXT_STREAM_INF<IFrameStreamInfo>() {
        {
            this.HANDLERS.put(Constants.URI, new AttributeWriter<IFrameStreamInfo>() {
                public boolean containsAttribute(IFrameStreamInfo iFrameStreamInfo) {
                    return true;
                }

                public String write(IFrameStreamInfo iFrameStreamInfo) throws ParseException {
                    return WriteUtil.writeQuotedString(iFrameStreamInfo.getUri(), AnonymousClass2.this.getTag());
                }
            });
        }

        public void doWrite(TagWriter tagWriter, Playlist playlist, MasterPlaylist masterPlaylist) throws IOException, ParseException {
            for (IFrameStreamInfo writeAttributes : masterPlaylist.getIFramePlaylists()) {
                writeAttributes(tagWriter, writeAttributes, this.HANDLERS);
            }
        }

        public String getTag() {
            return Constants.EXT_X_I_FRAME_STREAM_INF_TAG;
        }
    };
    static final IExtTagWriter EXT_X_MEDIA = new MasterPlaylistTagWriter() {
        private final Map<String, AttributeWriter<MediaData>> HANDLERS;

        {
            HashMap hashMap = new HashMap();
            this.HANDLERS = hashMap;
            hashMap.put(Constants.TYPE, new AttributeWriter<MediaData>() {
                public boolean containsAttribute(MediaData mediaData) {
                    return true;
                }

                public String write(MediaData mediaData) throws ParseException {
                    return mediaData.getType().getValue();
                }
            });
            hashMap.put(Constants.URI, new AttributeWriter<MediaData>() {
                public boolean containsAttribute(MediaData mediaData) {
                    return mediaData.hasUri();
                }

                public String write(MediaData mediaData) throws ParseException {
                    return WriteUtil.writeQuotedString(mediaData.getUri(), AnonymousClass1.this.getTag());
                }
            });
            hashMap.put(Constants.GROUP_ID, new AttributeWriter<MediaData>() {
                public boolean containsAttribute(MediaData mediaData) {
                    return true;
                }

                public String write(MediaData mediaData) throws ParseException {
                    return WriteUtil.writeQuotedString(mediaData.getGroupId(), AnonymousClass1.this.getTag());
                }
            });
            hashMap.put(Constants.LANGUAGE, new AttributeWriter<MediaData>() {
                public boolean containsAttribute(MediaData mediaData) {
                    return mediaData.hasLanguage();
                }

                public String write(MediaData mediaData) throws ParseException {
                    return WriteUtil.writeQuotedString(mediaData.getLanguage(), AnonymousClass1.this.getTag());
                }
            });
            hashMap.put(Constants.ASSOCIATED_LANGUAGE, new AttributeWriter<MediaData>() {
                public boolean containsAttribute(MediaData mediaData) {
                    return mediaData.hasAssociatedLanguage();
                }

                public String write(MediaData mediaData) throws ParseException {
                    return WriteUtil.writeQuotedString(mediaData.getAssociatedLanguage(), AnonymousClass1.this.getTag());
                }
            });
            hashMap.put(Constants.NAME, new AttributeWriter<MediaData>() {
                public boolean containsAttribute(MediaData mediaData) {
                    return true;
                }

                public String write(MediaData mediaData) throws ParseException {
                    return WriteUtil.writeQuotedString(mediaData.getName(), AnonymousClass1.this.getTag());
                }
            });
            hashMap.put(Constants.DEFAULT, new AttributeWriter<MediaData>() {
                public boolean containsAttribute(MediaData mediaData) {
                    return true;
                }

                public String write(MediaData mediaData) throws ParseException {
                    return WriteUtil.writeYesNo(mediaData.isDefault());
                }
            });
            hashMap.put(Constants.AUTO_SELECT, new AttributeWriter<MediaData>() {
                public boolean containsAttribute(MediaData mediaData) {
                    return true;
                }

                public String write(MediaData mediaData) throws ParseException {
                    return WriteUtil.writeYesNo(mediaData.isAutoSelect());
                }
            });
            hashMap.put(Constants.FORCED, new AttributeWriter<MediaData>() {
                public boolean containsAttribute(MediaData mediaData) {
                    return true;
                }

                public String write(MediaData mediaData) throws ParseException {
                    return WriteUtil.writeYesNo(mediaData.isForced());
                }
            });
            hashMap.put(Constants.IN_STREAM_ID, new AttributeWriter<MediaData>() {
                public boolean containsAttribute(MediaData mediaData) {
                    return mediaData.hasInStreamId();
                }

                public String write(MediaData mediaData) throws ParseException {
                    return WriteUtil.writeQuotedString(mediaData.getInStreamId(), AnonymousClass1.this.getTag());
                }
            });
            hashMap.put(Constants.CHARACTERISTICS, new AttributeWriter<MediaData>() {
                public boolean containsAttribute(MediaData mediaData) {
                    return mediaData.hasCharacteristics();
                }

                public String write(MediaData mediaData) throws ParseException {
                    return WriteUtil.writeQuotedString(WriteUtil.join(mediaData.getCharacteristics(), Constants.COMMA), AnonymousClass1.this.getTag());
                }
            });
        }

        public void doWrite(TagWriter tagWriter, Playlist playlist, MasterPlaylist masterPlaylist) throws IOException, ParseException {
            if (masterPlaylist.getMediaData().size() > 0) {
                for (MediaData writeAttributes : masterPlaylist.getMediaData()) {
                    writeAttributes(tagWriter, writeAttributes, this.HANDLERS);
                }
            }
        }

        public String getTag() {
            return Constants.EXT_X_MEDIA_TAG;
        }

        public boolean hasData() {
            return true;
        }
    };
    static final IExtTagWriter EXT_X_STREAM_INF = new EXT_STREAM_INF<StreamInfo>() {
        {
            this.HANDLERS.put(Constants.AUDIO, new AttributeWriter<StreamInfo>() {
                public boolean containsAttribute(StreamInfo streamInfo) {
                    return streamInfo.hasAudio();
                }

                public String write(StreamInfo streamInfo) throws ParseException {
                    return WriteUtil.writeQuotedString(streamInfo.getAudio(), AnonymousClass3.this.getTag());
                }
            });
            this.HANDLERS.put(Constants.SUBTITLES, new AttributeWriter<StreamInfo>() {
                public boolean containsAttribute(StreamInfo streamInfo) {
                    return streamInfo.hasSubtitles();
                }

                public String write(StreamInfo streamInfo) throws ParseException {
                    return WriteUtil.writeQuotedString(streamInfo.getSubtitles(), AnonymousClass3.this.getTag());
                }
            });
            this.HANDLERS.put(Constants.CLOSED_CAPTIONS, new AttributeWriter<StreamInfo>() {
                public boolean containsAttribute(StreamInfo streamInfo) {
                    return streamInfo.hasClosedCaptions();
                }

                public String write(StreamInfo streamInfo) throws ParseException {
                    return WriteUtil.writeQuotedString(streamInfo.getClosedCaptions(), AnonymousClass3.this.getTag());
                }
            });
        }

        public void doWrite(TagWriter tagWriter, Playlist playlist, MasterPlaylist masterPlaylist) throws IOException, ParseException {
            for (PlaylistData next : masterPlaylist.getPlaylists()) {
                if (next.hasStreamInfo()) {
                    writeAttributes(tagWriter, next.getStreamInfo(), this.HANDLERS);
                    tagWriter.writeLine(next.getUri());
                }
            }
        }

        public String getTag() {
            return Constants.EXT_X_STREAM_INF_TAG;
        }
    };

    public static abstract class EXT_STREAM_INF<T extends IStreamInfo> extends MasterPlaylistTagWriter {
        final Map<String, AttributeWriter<T>> HANDLERS;

        public EXT_STREAM_INF() {
            HashMap hashMap = new HashMap();
            this.HANDLERS = hashMap;
            hashMap.put(Constants.BANDWIDTH, new AttributeWriter<T>() {
                public boolean containsAttribute(T t10) {
                    return true;
                }

                public String write(T t10) {
                    return Integer.toString(t10.getBandwidth());
                }
            });
            hashMap.put(Constants.AVERAGE_BANDWIDTH, new AttributeWriter<T>() {
                public boolean containsAttribute(T t10) {
                    return t10.hasAverageBandwidth();
                }

                public String write(T t10) {
                    return Integer.toString(t10.getAverageBandwidth());
                }
            });
            hashMap.put(Constants.CODECS, new AttributeWriter<T>() {
                public boolean containsAttribute(T t10) {
                    return t10.hasCodecs();
                }

                public String write(T t10) throws ParseException {
                    return WriteUtil.writeQuotedString(WriteUtil.join(t10.getCodecs(), Constants.COMMA), EXT_STREAM_INF.this.getTag());
                }
            });
            hashMap.put(Constants.RESOLUTION, new AttributeWriter<T>() {
                public boolean containsAttribute(T t10) {
                    return t10.hasResolution();
                }

                public String write(T t10) throws ParseException {
                    return WriteUtil.writeResolution(t10.getResolution());
                }
            });
            hashMap.put(Constants.FRAME_RATE, new AttributeWriter<T>() {
                public boolean containsAttribute(T t10) {
                    return t10.hasFrameRate();
                }

                public String write(T t10) throws ParseException {
                    return String.valueOf(t10.getFrameRate());
                }
            });
            hashMap.put(Constants.VIDEO, new AttributeWriter<T>() {
                public boolean containsAttribute(T t10) {
                    return t10.hasVideo();
                }

                public String write(T t10) throws ParseException {
                    return WriteUtil.writeQuotedString(t10.getVideo(), EXT_STREAM_INF.this.getTag());
                }
            });
            hashMap.put(Constants.PROGRAM_ID, new AttributeWriter<T>() {
                public boolean containsAttribute(T t10) {
                    return false;
                }

                public String write(T t10) {
                    return "";
                }
            });
        }

        public abstract void doWrite(TagWriter tagWriter, Playlist playlist, MasterPlaylist masterPlaylist) throws IOException, ParseException;

        public boolean hasData() {
            return true;
        }
    }

    public void doWrite(TagWriter tagWriter, Playlist playlist, MasterPlaylist masterPlaylist) throws IOException, ParseException {
        tagWriter.writeTag(getTag());
    }

    public final void write(TagWriter tagWriter, Playlist playlist) throws IOException, ParseException {
        if (playlist.hasMasterPlaylist()) {
            doWrite(tagWriter, playlist, playlist.getMasterPlaylist());
        }
    }
}
