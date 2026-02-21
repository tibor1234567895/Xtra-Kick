package com.iheartradio.m3u8;

import com.iheartradio.m3u8.data.Playlist;

class ParseState implements IParseState<Playlist> {
    static final int NONE = -1;
    public final Encoding encoding;
    private int mCompatibilityVersion = -1;
    private boolean mIsExtended;
    private boolean mIsIframesOnly;
    private MasterParseState mMasterParseState;
    private MediaParseState mMediaParseState;

    public ParseState(Encoding encoding2) {
        this.encoding = encoding2;
    }

    public Playlist buildPlaylist() throws ParseException {
        Playlist.Builder builder = new Playlist.Builder();
        if (isMaster()) {
            builder.withMasterPlaylist(this.mMasterParseState.buildPlaylist());
        } else if (isMedia()) {
            builder.withMediaPlaylist(this.mMediaParseState.buildPlaylist()).withExtended(this.mIsExtended);
        } else {
            throw new ParseException(ParseExceptionType.UNKNOWN_PLAYLIST_TYPE);
        }
        int i10 = this.mCompatibilityVersion;
        if (i10 == -1) {
            i10 = 1;
        }
        return builder.withCompatibilityVersion(i10).build();
    }

    public int getCompatibilityVersion() {
        return this.mCompatibilityVersion;
    }

    public MasterParseState getMaster() {
        return this.mMasterParseState;
    }

    public MediaParseState getMedia() {
        return this.mMediaParseState;
    }

    public boolean isExtended() {
        return this.mIsExtended;
    }

    public boolean isIframesOnly() {
        return this.mIsIframesOnly;
    }

    public boolean isMaster() {
        return this.mMasterParseState != null;
    }

    public boolean isMedia() {
        return this.mMediaParseState != null;
    }

    public void setCompatibilityVersion(int i10) {
        this.mCompatibilityVersion = i10;
    }

    public void setExtended() {
        this.mIsExtended = true;
    }

    public void setIsIframesOnly() throws ParseException {
        if (!isMaster()) {
            getMedia().isIframesOnly = Boolean.TRUE;
            return;
        }
        throw new ParseException(ParseExceptionType.MEDIA_IN_MASTER);
    }

    public void setMaster() throws ParseException {
        if (isMedia()) {
            throw new ParseException(ParseExceptionType.MASTER_IN_MEDIA);
        } else if (this.mMasterParseState == null) {
            this.mMasterParseState = new MasterParseState();
        }
    }

    public void setMedia() throws ParseException {
        if (this.mMediaParseState == null) {
            this.mMediaParseState = new MediaParseState();
        }
    }
}
