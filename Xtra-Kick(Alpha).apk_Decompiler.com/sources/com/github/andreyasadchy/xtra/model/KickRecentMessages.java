package com.github.andreyasadchy.xtra.model;

import com.github.andreyasadchy.xtra.model.chat.ChatMessage;
import java.util.List;
import xa.f;
import xa.j;

public final class KickRecentMessages {
    private final List<ChatMessage> messages;
    private final boolean status;

    public KickRecentMessages(boolean z10, List<? extends ChatMessage> list) {
        j.f("messages", list);
        this.status = z10;
        this.messages = list;
    }

    public static /* synthetic */ KickRecentMessages copy$default(KickRecentMessages kickRecentMessages, boolean z10, List<ChatMessage> list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = kickRecentMessages.status;
        }
        if ((i10 & 2) != 0) {
            list = kickRecentMessages.messages;
        }
        return kickRecentMessages.copy(z10, list);
    }

    public final boolean component1() {
        return this.status;
    }

    public final List<ChatMessage> component2() {
        return this.messages;
    }

    public final KickRecentMessages copy(boolean z10, List<? extends ChatMessage> list) {
        j.f("messages", list);
        return new KickRecentMessages(z10, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof KickRecentMessages)) {
            return false;
        }
        KickRecentMessages kickRecentMessages = (KickRecentMessages) obj;
        return this.status == kickRecentMessages.status && j.a(this.messages, kickRecentMessages.messages);
    }

    public final List<ChatMessage> getMessages() {
        return this.messages;
    }

    public final boolean getStatus() {
        return this.status;
    }

    public int hashCode() {
        boolean z10 = this.status;
        if (z10) {
            z10 = true;
        }
        return this.messages.hashCode() + ((z10 ? 1 : 0) * true);
    }

    public String toString() {
        boolean z10 = this.status;
        List<ChatMessage> list = this.messages;
        return "KickRecentMessages(status=" + z10 + ", messages=" + list + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ KickRecentMessages(boolean z10, List list, int i10, f fVar) {
        this((i10 & 1) != 0 ? false : z10, list);
    }
}
