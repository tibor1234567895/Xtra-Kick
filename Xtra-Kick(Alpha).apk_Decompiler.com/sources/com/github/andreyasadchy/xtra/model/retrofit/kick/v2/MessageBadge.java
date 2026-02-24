package com.github.andreyasadchy.xtra.model.retrofit.kick.v2;

import android.support.v4.media.h;
import xa.j;

public final class MessageBadge {
    private final boolean active;
    private final int count;
    private final String text;
    private final String type;

    public MessageBadge(String str, String str2, int i10, boolean z10) {
        j.f("type", str);
        j.f("text", str2);
        this.type = str;
        this.text = str2;
        this.count = i10;
        this.active = z10;
    }

    public static /* synthetic */ MessageBadge copy$default(MessageBadge messageBadge, String str, String str2, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = messageBadge.type;
        }
        if ((i11 & 2) != 0) {
            str2 = messageBadge.text;
        }
        if ((i11 & 4) != 0) {
            i10 = messageBadge.count;
        }
        if ((i11 & 8) != 0) {
            z10 = messageBadge.active;
        }
        return messageBadge.copy(str, str2, i10, z10);
    }

    public final String component1() {
        return this.type;
    }

    public final String component2() {
        return this.text;
    }

    public final int component3() {
        return this.count;
    }

    public final boolean component4() {
        return this.active;
    }

    public final MessageBadge copy(String str, String str2, int i10, boolean z10) {
        j.f("type", str);
        j.f("text", str2);
        return new MessageBadge(str, str2, i10, z10);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MessageBadge)) {
            return false;
        }
        MessageBadge messageBadge = (MessageBadge) obj;
        return j.a(this.type, messageBadge.type) && j.a(this.text, messageBadge.text) && this.count == messageBadge.count && this.active == messageBadge.active;
    }

    public final boolean getActive() {
        return this.active;
    }

    public final int getCount() {
        return this.count;
    }

    public final String getText() {
        return this.text;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        int e10 = (h.e(this.text, this.type.hashCode() * 31, 31) + this.count) * 31;
        boolean z10 = this.active;
        if (z10) {
            z10 = true;
        }
        return e10 + (z10 ? 1 : 0);
    }

    public String toString() {
        String str = this.type;
        String str2 = this.text;
        int i10 = this.count;
        boolean z10 = this.active;
        return "MessageBadge(type=" + str + ", text=" + str2 + ", count=" + i10 + ", active=" + z10 + ")";
    }
}
