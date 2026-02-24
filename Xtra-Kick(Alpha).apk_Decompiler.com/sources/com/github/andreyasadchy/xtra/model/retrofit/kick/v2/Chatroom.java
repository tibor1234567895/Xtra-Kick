package com.github.andreyasadchy.xtra.model.retrofit.kick.v2;

import android.support.v4.media.h;

public final class Chatroom {
    private final int id;

    public Chatroom(int i10) {
        this.id = i10;
    }

    public static /* synthetic */ Chatroom copy$default(Chatroom chatroom, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = chatroom.id;
        }
        return chatroom.copy(i10);
    }

    public final int component1() {
        return this.id;
    }

    public final Chatroom copy(int i10) {
        return new Chatroom(i10);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Chatroom) && this.id == ((Chatroom) obj).id;
    }

    public final int getId() {
        return this.id;
    }

    public int hashCode() {
        return this.id;
    }

    public String toString() {
        return h.j("Chatroom(id=", this.id, ")");
    }
}
