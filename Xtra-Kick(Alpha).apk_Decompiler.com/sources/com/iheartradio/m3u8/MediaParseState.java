package com.iheartradio.m3u8;

import com.iheartradio.m3u8.data.EncryptionData;
import com.iheartradio.m3u8.data.MediaPlaylist;
import com.iheartradio.m3u8.data.PlaylistType;
import com.iheartradio.m3u8.data.StartData;
import com.iheartradio.m3u8.data.TrackData;
import com.iheartradio.m3u8.data.TrackInfo;
import java.util.ArrayList;
import java.util.List;

class MediaParseState implements IParseState<MediaPlaylist> {
    public EncryptionData encryptionData;
    public boolean endOfList;
    public boolean hasDiscontinuity;
    public Boolean isIframesOnly;
    public Integer mediaSequenceNumber;
    public PlaylistType playlistType;
    public String programDateTime;
    public StartData startData;
    public Integer targetDuration;
    public TrackInfo trackInfo;
    public final List<TrackData> tracks = new ArrayList();
    public final List<String> unknownTags = new ArrayList();

    private static int maximumDuration(List<TrackData> list, float f10) {
        for (TrackData next : list) {
            if (next.hasTrackInfo()) {
                f10 = Math.max(f10, next.getTrackInfo().duration);
            }
        }
        return 0;
    }

    public MediaPlaylist buildPlaylist() throws ParseException {
        MediaPlaylist.Builder withUnknownTags = new MediaPlaylist.Builder().withTracks(this.tracks).withUnknownTags(this.unknownTags);
        Integer num = this.targetDuration;
        int i10 = 0;
        MediaPlaylist.Builder withStartData = withUnknownTags.withTargetDuration(num == null ? maximumDuration(this.tracks, 0.0f) : num.intValue()).withIsIframesOnly(this.isIframesOnly != null).withIsOngoing(!this.endOfList).withStartData(this.startData);
        Integer num2 = this.mediaSequenceNumber;
        if (num2 != null) {
            i10 = num2.intValue();
        }
        return withStartData.withMediaSequenceNumber(i10).withPlaylistType(this.playlistType).build();
    }
}
