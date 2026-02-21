package com.iheartradio.m3u8;

import com.iheartradio.m3u8.data.Playlist;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;

abstract class ExtTagWriter implements IExtTagWriter {
    static final IExtTagWriter EXTM3U_HANDLER = new ExtTagWriter() {
        public String getTag() {
            return Constants.EXTM3U_TAG;
        }

        public boolean hasData() {
            return false;
        }
    };
    static final IExtTagWriter EXT_UNKNOWN_HANDLER = new ExtTagWriter() {
        public String getTag() {
            return null;
        }

        public boolean hasData() {
            return true;
        }

        public void write(TagWriter tagWriter, Playlist playlist) throws IOException {
            for (String writeLine : (!playlist.hasMasterPlaylist() || !playlist.getMasterPlaylist().hasUnknownTags()) ? playlist.getMediaPlaylist().hasUnknownTags() ? playlist.getMediaPlaylist().getUnknownTags() : Collections.emptyList() : playlist.getMasterPlaylist().getUnknownTags()) {
                tagWriter.writeLine(writeLine);
            }
        }
    };
    static final IExtTagWriter EXT_X_VERSION_HANDLER = new ExtTagWriter() {
        public String getTag() {
            return Constants.EXT_X_VERSION_TAG;
        }

        public boolean hasData() {
            return true;
        }

        public void write(TagWriter tagWriter, Playlist playlist) throws IOException {
            tagWriter.writeTag(getTag(), Integer.toString(playlist.getCompatibilityVersion()));
        }
    };

    public abstract boolean hasData();

    public void write(TagWriter tagWriter, Playlist playlist) throws IOException, ParseException {
        if (!hasData()) {
            tagWriter.writeTag(getTag());
        }
    }

    public <T> void writeAttributes(TagWriter tagWriter, T t10, Map<String, ? extends AttributeWriter<T>> map) throws IOException, ParseException {
        StringBuilder sb2 = new StringBuilder();
        for (Map.Entry next : map.entrySet()) {
            AttributeWriter attributeWriter = (AttributeWriter) next.getValue();
            String str = (String) next.getKey();
            if (attributeWriter.containsAttribute(t10)) {
                String write = attributeWriter.write(t10);
                sb2.append(str);
                sb2.append(Constants.ATTRIBUTE_SEPARATOR);
                sb2.append(write);
                sb2.append(Constants.ATTRIBUTE_LIST_SEPARATOR);
            }
        }
        sb2.deleteCharAt(sb2.length() - 1);
        tagWriter.writeTag(getTag(), sb2.toString());
    }
}
