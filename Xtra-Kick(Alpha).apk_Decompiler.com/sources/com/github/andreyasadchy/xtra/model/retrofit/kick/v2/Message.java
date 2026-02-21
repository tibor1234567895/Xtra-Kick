package com.github.andreyasadchy.xtra.model.retrofit.kick.v2;

import android.support.v4.media.h;
import k9.b;
import q0.f;
import xa.j;

public final class Message {
    @b("chat_id")
    private final int chatId;
    private final String content;
    @b("created_at")
    private final String createdAt;
    private final String id;
    private final MessageSender sender;
    private final String type;
    @b("user_id")
    private final int userId;

    public Message(String str, int i10, int i11, String str2, String str3, String str4, MessageSender messageSender) {
        j.f("id", str);
        j.f("content", str2);
        j.f("type", str3);
        j.f("createdAt", str4);
        j.f("sender", messageSender);
        this.id = str;
        this.chatId = i10;
        this.userId = i11;
        this.content = str2;
        this.type = str3;
        this.createdAt = str4;
        this.sender = messageSender;
    }

    public static /* synthetic */ Message copy$default(Message message, String str, int i10, int i11, String str2, String str3, String str4, MessageSender messageSender, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            str = message.id;
        }
        if ((i12 & 2) != 0) {
            i10 = message.chatId;
        }
        int i13 = i10;
        if ((i12 & 4) != 0) {
            i11 = message.userId;
        }
        int i14 = i11;
        if ((i12 & 8) != 0) {
            str2 = message.content;
        }
        String str5 = str2;
        if ((i12 & 16) != 0) {
            str3 = message.type;
        }
        String str6 = str3;
        if ((i12 & 32) != 0) {
            str4 = message.createdAt;
        }
        String str7 = str4;
        if ((i12 & 64) != 0) {
            messageSender = message.sender;
        }
        return message.copy(str, i13, i14, str5, str6, str7, messageSender);
    }

    public final String component1() {
        return this.id;
    }

    public final int component2() {
        return this.chatId;
    }

    public final int component3() {
        return this.userId;
    }

    public final String component4() {
        return this.content;
    }

    public final String component5() {
        return this.type;
    }

    public final String component6() {
        return this.createdAt;
    }

    public final MessageSender component7() {
        return this.sender;
    }

    public final Message copy(String str, int i10, int i11, String str2, String str3, String str4, MessageSender messageSender) {
        j.f("id", str);
        j.f("content", str2);
        j.f("type", str3);
        j.f("createdAt", str4);
        MessageSender messageSender2 = messageSender;
        j.f("sender", messageSender2);
        return new Message(str, i10, i11, str2, str3, str4, messageSender2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Message)) {
            return false;
        }
        Message message = (Message) obj;
        return j.a(this.id, message.id) && this.chatId == message.chatId && this.userId == message.userId && j.a(this.content, message.content) && j.a(this.type, message.type) && j.a(this.createdAt, message.createdAt) && j.a(this.sender, message.sender);
    }

    public final int getChatId() {
        return this.chatId;
    }

    public final String getContent() {
        return this.content;
    }

    public final String getCreatedAt() {
        return this.createdAt;
    }

    public final String getId() {
        return this.id;
    }

    public final MessageSender getSender() {
        return this.sender;
    }

    public final String getType() {
        return this.type;
    }

    public final int getUserId() {
        return this.userId;
    }

    public int hashCode() {
        return this.sender.hashCode() + h.e(this.createdAt, h.e(this.type, h.e(this.content, ((((this.id.hashCode() * 31) + this.chatId) * 31) + this.userId) * 31, 31), 31), 31);
    }

    public String toString() {
        String str = this.id;
        int i10 = this.chatId;
        int i11 = this.userId;
        String str2 = this.content;
        String str3 = this.type;
        String str4 = this.createdAt;
        MessageSender messageSender = this.sender;
        StringBuilder sb2 = new StringBuilder("Message(id=");
        sb2.append(str);
        sb2.append(", chatId=");
        sb2.append(i10);
        sb2.append(", userId=");
        sb2.append(i11);
        sb2.append(", content=");
        sb2.append(str2);
        sb2.append(", type=");
        f.k(sb2, str3, ", createdAt=", str4, ", sender=");
        sb2.append(messageSender);
        sb2.append(")");
        return sb2.toString();
    }
}
