package com.github.andreyasadchy.xtra.model.retrofit.kick.v2;

import java.util.List;
import xa.j;

public final class MessageIdentity {
    private final List<MessageBadge> badges;
    private final String color;

    public MessageIdentity(String str, List<MessageBadge> list) {
        j.f("color", str);
        j.f("badges", list);
        this.color = str;
        this.badges = list;
    }

    public static /* synthetic */ MessageIdentity copy$default(MessageIdentity messageIdentity, String str, List<MessageBadge> list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = messageIdentity.color;
        }
        if ((i10 & 2) != 0) {
            list = messageIdentity.badges;
        }
        return messageIdentity.copy(str, list);
    }

    public final String component1() {
        return this.color;
    }

    public final List<MessageBadge> component2() {
        return this.badges;
    }

    public final MessageIdentity copy(String str, List<MessageBadge> list) {
        j.f("color", str);
        j.f("badges", list);
        return new MessageIdentity(str, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MessageIdentity)) {
            return false;
        }
        MessageIdentity messageIdentity = (MessageIdentity) obj;
        return j.a(this.color, messageIdentity.color) && j.a(this.badges, messageIdentity.badges);
    }

    public final List<MessageBadge> getBadges() {
        return this.badges;
    }

    public final String getColor() {
        return this.color;
    }

    public int hashCode() {
        return this.badges.hashCode() + (this.color.hashCode() * 31);
    }

    public String toString() {
        String str = this.color;
        List<MessageBadge> list = this.badges;
        return "MessageIdentity(color=" + str + ", badges=" + list + ")";
    }
}
