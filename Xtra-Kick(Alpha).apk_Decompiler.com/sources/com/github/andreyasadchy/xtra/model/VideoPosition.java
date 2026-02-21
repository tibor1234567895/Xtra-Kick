package com.github.andreyasadchy.xtra.model;

public final class VideoPosition {
    private final long id;
    private final long position;

    public VideoPosition(long j10, long j11) {
        this.id = j10;
        this.position = j11;
    }

    public static /* synthetic */ VideoPosition copy$default(VideoPosition videoPosition, long j10, long j11, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = videoPosition.id;
        }
        if ((i10 & 2) != 0) {
            j11 = videoPosition.position;
        }
        return videoPosition.copy(j10, j11);
    }

    public final long component1() {
        return this.id;
    }

    public final long component2() {
        return this.position;
    }

    public final VideoPosition copy(long j10, long j11) {
        return new VideoPosition(j10, j11);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VideoPosition)) {
            return false;
        }
        VideoPosition videoPosition = (VideoPosition) obj;
        return this.id == videoPosition.id && this.position == videoPosition.position;
    }

    public final long getId() {
        return this.id;
    }

    public final long getPosition() {
        return this.position;
    }

    public int hashCode() {
        long j10 = this.id;
        long j11 = this.position;
        return (((int) (j10 ^ (j10 >>> 32))) * 31) + ((int) (j11 ^ (j11 >>> 32)));
    }

    public String toString() {
        long j10 = this.id;
        long j11 = this.position;
        return "VideoPosition(id=" + j10 + ", position=" + j11 + ")";
    }
}
