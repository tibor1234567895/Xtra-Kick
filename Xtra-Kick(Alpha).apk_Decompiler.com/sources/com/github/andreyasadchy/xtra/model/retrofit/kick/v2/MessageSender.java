package com.github.andreyasadchy.xtra.model.retrofit.kick.v2;

import android.support.v4.media.h;
import xa.j;

public final class MessageSender {
    private final int id;
    private final MessageIdentity identity;
    private final String slug;
    private final String username;

    public MessageSender(int i10, String str, String str2, MessageIdentity messageIdentity) {
        j.f("slug", str);
        j.f("username", str2);
        j.f(Constants.DEFAULT_KEY_FORMAT, messageIdentity);
        this.id = i10;
        this.slug = str;
        this.username = str2;
        this.identity = messageIdentity;
    }

    public static /* synthetic */ MessageSender copy$default(MessageSender messageSender, int i10, String str, String str2, MessageIdentity messageIdentity, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = messageSender.id;
        }
        if ((i11 & 2) != 0) {
            str = messageSender.slug;
        }
        if ((i11 & 4) != 0) {
            str2 = messageSender.username;
        }
        if ((i11 & 8) != 0) {
            messageIdentity = messageSender.identity;
        }
        return messageSender.copy(i10, str, str2, messageIdentity);
    }

    public final int component1() {
        return this.id;
    }

    public final String component2() {
        return this.slug;
    }

    public final String component3() {
        return this.username;
    }

    public final MessageIdentity component4() {
        return this.identity;
    }

    public final MessageSender copy(int i10, String str, String str2, MessageIdentity messageIdentity) {
        j.f("slug", str);
        j.f("username", str2);
        j.f(Constants.DEFAULT_KEY_FORMAT, messageIdentity);
        return new MessageSender(i10, str, str2, messageIdentity);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MessageSender)) {
            return false;
        }
        MessageSender messageSender = (MessageSender) obj;
        return this.id == messageSender.id && j.a(this.slug, messageSender.slug) && j.a(this.username, messageSender.username) && j.a(this.identity, messageSender.identity);
    }

    public final int getId() {
        return this.id;
    }

    public final MessageIdentity getIdentity() {
        return this.identity;
    }

    public final String getSlug() {
        return this.slug;
    }

    public final String getUsername() {
        return this.username;
    }

    public int hashCode() {
        return this.identity.hashCode() + h.e(this.username, h.e(this.slug, this.id * 31, 31), 31);
    }

    public String toString() {
        int i10 = this.id;
        String str = this.slug;
        String str2 = this.username;
        MessageIdentity messageIdentity = this.identity;
        return "MessageSender(id=" + i10 + ", slug=" + str + ", username=" + str2 + ", identity=" + messageIdentity + ")";
    }
}
