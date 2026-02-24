package com.iheartradio.m3u8;

import com.iheartradio.m3u8.data.IFrameStreamInfo;
import com.iheartradio.m3u8.data.MasterPlaylist;
import com.iheartradio.m3u8.data.MediaData;
import com.iheartradio.m3u8.data.MediaPlaylist;
import com.iheartradio.m3u8.data.Playlist;
import com.iheartradio.m3u8.data.PlaylistData;
import com.iheartradio.m3u8.data.StartData;
import com.iheartradio.m3u8.data.TrackData;
import java.util.Collections;
import java.util.Set;

public class PlaylistValidation {
    private final Set<PlaylistError> mErrors;

    private PlaylistValidation(Set<PlaylistError> set) {
        this.mErrors = Collections.unmodifiableSet(set);
    }

    private static void addIFrameStreamInfoErrors(IFrameStreamInfo iFrameStreamInfo, Set<PlaylistError> set) {
        if (iFrameStreamInfo.getUri() == null || iFrameStreamInfo.getUri().isEmpty()) {
            set.add(PlaylistError.I_FRAME_STREAM_WITHOUT_URI);
        }
        if (iFrameStreamInfo.getBandwidth() == -1) {
            set.add(PlaylistError.I_FRAME_STREAM_WITH_NO_BANDWIDTH);
        }
        if (iFrameStreamInfo.getAverageBandwidth() < -1) {
            set.add(PlaylistError.I_FRAME_STREAM_WITH_INVALID_AVERAGE_BANDWIDTH);
        }
    }

    private static void addMasterPlaylistErrors(MasterPlaylist masterPlaylist, Set<PlaylistError> set) {
        for (PlaylistData addPlaylistDataErrors : masterPlaylist.getPlaylists()) {
            addPlaylistDataErrors(addPlaylistDataErrors, set);
        }
        for (IFrameStreamInfo addIFrameStreamInfoErrors : masterPlaylist.getIFramePlaylists()) {
            addIFrameStreamInfoErrors(addIFrameStreamInfoErrors, set);
        }
        for (MediaData addMediaDataErrors : masterPlaylist.getMediaData()) {
            addMediaDataErrors(addMediaDataErrors, set);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void addMediaDataErrors(com.iheartradio.m3u8.data.MediaData r2, java.util.Set<com.iheartradio.m3u8.PlaylistError> r3) {
        /*
            com.iheartradio.m3u8.data.MediaType r0 = r2.getType()
            if (r0 != 0) goto L_0x000b
            com.iheartradio.m3u8.PlaylistError r0 = com.iheartradio.m3u8.PlaylistError.MEDIA_DATA_WITHOUT_TYPE
            r3.add(r0)
        L_0x000b:
            java.lang.String r0 = r2.getGroupId()
            if (r0 != 0) goto L_0x0016
            com.iheartradio.m3u8.PlaylistError r0 = com.iheartradio.m3u8.PlaylistError.MEDIA_DATA_WITHOUT_GROUP_ID
            r3.add(r0)
        L_0x0016:
            java.lang.String r0 = r2.getName()
            if (r0 != 0) goto L_0x0021
            com.iheartradio.m3u8.PlaylistError r0 = com.iheartradio.m3u8.PlaylistError.MEDIA_DATA_WITHOUT_NAME
            r3.add(r0)
        L_0x0021:
            com.iheartradio.m3u8.data.MediaType r0 = r2.getType()
            com.iheartradio.m3u8.data.MediaType r1 = com.iheartradio.m3u8.data.MediaType.CLOSED_CAPTIONS
            if (r0 != r1) goto L_0x003d
            boolean r0 = r2.hasUri()
            if (r0 == 0) goto L_0x0034
            com.iheartradio.m3u8.PlaylistError r0 = com.iheartradio.m3u8.PlaylistError.CLOSE_CAPTIONS_WITH_URI
            r3.add(r0)
        L_0x0034:
            java.lang.String r0 = r2.getInStreamId()
            if (r0 != 0) goto L_0x004e
            com.iheartradio.m3u8.PlaylistError r0 = com.iheartradio.m3u8.PlaylistError.CLOSE_CAPTIONS_WITHOUT_IN_STREAM_ID
            goto L_0x004b
        L_0x003d:
            com.iheartradio.m3u8.data.MediaType r0 = r2.getType()
            if (r0 == r1) goto L_0x004e
            java.lang.String r0 = r2.getInStreamId()
            if (r0 == 0) goto L_0x004e
            com.iheartradio.m3u8.PlaylistError r0 = com.iheartradio.m3u8.PlaylistError.IN_STREAM_ID_WITHOUT_CLOSE_CAPTIONS
        L_0x004b:
            r3.add(r0)
        L_0x004e:
            boolean r0 = r2.isDefault()
            if (r0 == 0) goto L_0x005f
            boolean r0 = r2.isAutoSelect()
            if (r0 != 0) goto L_0x005f
            com.iheartradio.m3u8.PlaylistError r0 = com.iheartradio.m3u8.PlaylistError.DEFAULT_WITHOUT_AUTO_SELECT
            r3.add(r0)
        L_0x005f:
            com.iheartradio.m3u8.data.MediaType r0 = r2.getType()
            com.iheartradio.m3u8.data.MediaType r1 = com.iheartradio.m3u8.data.MediaType.SUBTITLES
            if (r0 == r1) goto L_0x0072
            boolean r2 = r2.isForced()
            if (r2 == 0) goto L_0x0072
            com.iheartradio.m3u8.PlaylistError r2 = com.iheartradio.m3u8.PlaylistError.FORCED_WITHOUT_SUBTITLES
            r3.add(r2)
        L_0x0072:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iheartradio.m3u8.PlaylistValidation.addMediaDataErrors(com.iheartradio.m3u8.data.MediaData, java.util.Set):void");
    }

    private static void addMediaPlaylistErrors(MediaPlaylist mediaPlaylist, Set<PlaylistError> set, boolean z10, ParsingMode parsingMode) {
        if (z10 && mediaPlaylist.hasStartData()) {
            addStartErrors(mediaPlaylist.getStartData(), set);
        }
        for (TrackData addTrackDataErrors : mediaPlaylist.getTracks()) {
            addTrackDataErrors(addTrackDataErrors, set, z10, parsingMode);
        }
    }

    private static void addPlaylistDataErrors(PlaylistData playlistData, Set<PlaylistError> set) {
        if (playlistData.getUri() == null || playlistData.getUri().isEmpty()) {
            set.add(PlaylistError.PLAYLIST_DATA_WITHOUT_URI);
        }
        if (playlistData.hasStreamInfo()) {
            if (playlistData.getStreamInfo().getBandwidth() == -1) {
                set.add(PlaylistError.STREAM_INFO_WITH_NO_BANDWIDTH);
            }
            if (playlistData.getStreamInfo().getAverageBandwidth() < -1) {
                set.add(PlaylistError.STREAM_INFO_WITH_INVALID_AVERAGE_BANDWIDTH);
            }
        }
    }

    private static void addStartErrors(StartData startData, Set<PlaylistError> set) {
        if (Float.isNaN(startData.getTimeOffset())) {
            set.add(PlaylistError.START_DATA_WITHOUT_TIME_OFFSET);
        }
    }

    private static void addTrackDataErrors(TrackData trackData, Set<PlaylistError> set, boolean z10, ParsingMode parsingMode) {
        if (trackData.getUri() == null || trackData.getUri().isEmpty()) {
            set.add(PlaylistError.TRACK_DATA_WITHOUT_URI);
        }
        if (z10 && !trackData.hasTrackInfo()) {
            set.add(PlaylistError.EXTENDED_TRACK_DATA_WITHOUT_TRACK_INFO);
        }
        if (trackData.hasEncryptionData() && trackData.getEncryptionData().getMethod() == null) {
            set.add(PlaylistError.ENCRYPTION_DATA_WITHOUT_METHOD);
        }
        if (trackData.hasTrackInfo() && !parsingMode.allowNegativeNumbers && trackData.getTrackInfo().duration < 0.0f) {
            set.add(PlaylistError.TRACK_INFO_WITH_NEGATIVE_DURATION);
        }
    }

    public static PlaylistValidation from(Playlist playlist) {
        return from(playlist, ParsingMode.STRICT);
    }

    private static boolean hasBothPlaylistTypes(Playlist playlist) {
        return playlist.hasMasterPlaylist() && playlist.hasMediaPlaylist();
    }

    private static boolean hasNoPlaylistTypes(Playlist playlist) {
        return !playlist.hasMasterPlaylist() && !playlist.hasMediaPlaylist();
    }

    public Set<PlaylistError> getErrors() {
        return this.mErrors;
    }

    public boolean isValid() {
        return this.mErrors.isEmpty();
    }

    public String toString() {
        return "(PlaylistValidation valid=" + isValid() + " errors=" + this.mErrors + ")";
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0051  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.iheartradio.m3u8.PlaylistValidation from(com.iheartradio.m3u8.data.Playlist r3, com.iheartradio.m3u8.ParsingMode r4) {
        /*
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>()
            if (r3 != 0) goto L_0x0012
            com.iheartradio.m3u8.PlaylistError r3 = com.iheartradio.m3u8.PlaylistError.NO_PLAYLIST
            r0.add(r3)
            com.iheartradio.m3u8.PlaylistValidation r3 = new com.iheartradio.m3u8.PlaylistValidation
            r3.<init>(r0)
            return r3
        L_0x0012:
            int r1 = r3.getCompatibilityVersion()
            r2 = 1
            if (r1 >= r2) goto L_0x001e
            com.iheartradio.m3u8.PlaylistError r1 = com.iheartradio.m3u8.PlaylistError.COMPATIBILITY_TOO_LOW
            r0.add(r1)
        L_0x001e:
            boolean r1 = hasNoPlaylistTypes(r3)
            if (r1 == 0) goto L_0x002a
            com.iheartradio.m3u8.PlaylistError r1 = com.iheartradio.m3u8.PlaylistError.NO_MASTER_OR_MEDIA
        L_0x0026:
            r0.add(r1)
            goto L_0x0033
        L_0x002a:
            boolean r1 = hasBothPlaylistTypes(r3)
            if (r1 == 0) goto L_0x0033
            com.iheartradio.m3u8.PlaylistError r1 = com.iheartradio.m3u8.PlaylistError.BOTH_MASTER_AND_MEDIA
            goto L_0x0026
        L_0x0033:
            boolean r1 = r3.hasMasterPlaylist()
            if (r1 == 0) goto L_0x004b
            boolean r1 = r3.isExtended()
            if (r1 != 0) goto L_0x0044
            com.iheartradio.m3u8.PlaylistError r1 = com.iheartradio.m3u8.PlaylistError.MASTER_NOT_EXTENDED
            r0.add(r1)
        L_0x0044:
            com.iheartradio.m3u8.data.MasterPlaylist r1 = r3.getMasterPlaylist()
            addMasterPlaylistErrors(r1, r0)
        L_0x004b:
            boolean r1 = r3.hasMediaPlaylist()
            if (r1 == 0) goto L_0x005c
            com.iheartradio.m3u8.data.MediaPlaylist r1 = r3.getMediaPlaylist()
            boolean r3 = r3.isExtended()
            addMediaPlaylistErrors(r1, r0, r3, r4)
        L_0x005c:
            com.iheartradio.m3u8.PlaylistValidation r3 = new com.iheartradio.m3u8.PlaylistValidation
            r3.<init>(r0)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iheartradio.m3u8.PlaylistValidation.from(com.iheartradio.m3u8.data.Playlist, com.iheartradio.m3u8.ParsingMode):com.iheartradio.m3u8.PlaylistValidation");
    }
}
