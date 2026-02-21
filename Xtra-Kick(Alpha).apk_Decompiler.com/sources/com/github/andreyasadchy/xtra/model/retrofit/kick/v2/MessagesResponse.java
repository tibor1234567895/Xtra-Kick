package com.github.andreyasadchy.xtra.model.retrofit.kick.v2;

import java.util.List;
import xa.j;

public final class MessagesResponse {
    private final String cursor;
    private final List<Message> messages;

    public MessagesResponse(List<Message> list, String str) {
        j.f("messages", list);
        j.f("cursor", str);
        this.messages = list;
        this.cursor = str;
    }

    public static /* synthetic */ MessagesResponse copy$default(MessagesResponse messagesResponse, List<Message> list, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = messagesResponse.messages;
        }
        if ((i10 & 2) != 0) {
            str = messagesResponse.cursor;
        }
        return messagesResponse.copy(list, str);
    }

    public final List<Message> component1() {
        return this.messages;
    }

    public final String component2() {
        return this.cursor;
    }

    public final MessagesResponse copy(List<Message> list, String str) {
        j.f("messages", list);
        j.f("cursor", str);
        return new MessagesResponse(list, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MessagesResponse)) {
            return false;
        }
        MessagesResponse messagesResponse = (MessagesResponse) obj;
        return j.a(this.messages, messagesResponse.messages) && j.a(this.cursor, messagesResponse.cursor);
    }

    public final String getCursor() {
        return this.cursor;
    }

    public final List<Message> getMessages() {
        return this.messages;
    }

    public int hashCode() {
        return this.cursor.hashCode() + (this.messages.hashCode() * 31);
    }

    public String toString() {
        List<Message> list = this.messages;
        String str = this.cursor;
        return "MessagesResponse(messages=" + list + ", cursor=" + str + ")";
    }
}
