package com.github.andreyasadchy.xtra.model.retrofit.kick.v2;

import java.util.List;
import xa.j;

public final class ClipResponse {
    private final List<Clip> clips;
    private final int nextCursor;

    public ClipResponse(List<Clip> list, int i10) {
        j.f("clips", list);
        this.clips = list;
        this.nextCursor = i10;
    }

    public static /* synthetic */ ClipResponse copy$default(ClipResponse clipResponse, List<Clip> list, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = clipResponse.clips;
        }
        if ((i11 & 2) != 0) {
            i10 = clipResponse.nextCursor;
        }
        return clipResponse.copy(list, i10);
    }

    public final List<Clip> component1() {
        return this.clips;
    }

    public final int component2() {
        return this.nextCursor;
    }

    public final ClipResponse copy(List<Clip> list, int i10) {
        j.f("clips", list);
        return new ClipResponse(list, i10);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ClipResponse)) {
            return false;
        }
        ClipResponse clipResponse = (ClipResponse) obj;
        return j.a(this.clips, clipResponse.clips) && this.nextCursor == clipResponse.nextCursor;
    }

    public final List<Clip> getClips() {
        return this.clips;
    }

    public final int getNextCursor() {
        return this.nextCursor;
    }

    public int hashCode() {
        return (this.clips.hashCode() * 31) + this.nextCursor;
    }

    public String toString() {
        List<Clip> list = this.clips;
        int i10 = this.nextCursor;
        return "ClipResponse(clips=" + list + ", nextCursor=" + i10 + ")";
    }
}
