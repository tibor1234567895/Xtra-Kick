package com.github.andreyasadchy.xtra.model.retrofit.kick.v2;

import android.support.v4.media.h;
import k9.b;
import xa.j;

public final class Channel {
    @b("banner_image")
    private final BannerImage bannerImage;
    private final Chatroom chatroom;
    @b("followers_count")
    private final int followers;
    private final int id;
    private final Livestream livestream;
    private final String slug;
    private final User user;
    @b("user_id")
    private final int userId;

    public Channel(int i10, int i11, String str, int i12, BannerImage bannerImage2, Chatroom chatroom2, Livestream livestream2, User user2) {
        j.f("slug", str);
        j.f("bannerImage", bannerImage2);
        j.f("chatroom", chatroom2);
        j.f("user", user2);
        this.id = i10;
        this.userId = i11;
        this.slug = str;
        this.followers = i12;
        this.bannerImage = bannerImage2;
        this.chatroom = chatroom2;
        this.livestream = livestream2;
        this.user = user2;
    }

    public static /* synthetic */ Channel copy$default(Channel channel, int i10, int i11, String str, int i12, BannerImage bannerImage2, Chatroom chatroom2, Livestream livestream2, User user2, int i13, Object obj) {
        Channel channel2 = channel;
        int i14 = i13;
        return channel.copy((i14 & 1) != 0 ? channel2.id : i10, (i14 & 2) != 0 ? channel2.userId : i11, (i14 & 4) != 0 ? channel2.slug : str, (i14 & 8) != 0 ? channel2.followers : i12, (i14 & 16) != 0 ? channel2.bannerImage : bannerImage2, (i14 & 32) != 0 ? channel2.chatroom : chatroom2, (i14 & 64) != 0 ? channel2.livestream : livestream2, (i14 & 128) != 0 ? channel2.user : user2);
    }

    public final int component1() {
        return this.id;
    }

    public final int component2() {
        return this.userId;
    }

    public final String component3() {
        return this.slug;
    }

    public final int component4() {
        return this.followers;
    }

    public final BannerImage component5() {
        return this.bannerImage;
    }

    public final Chatroom component6() {
        return this.chatroom;
    }

    public final Livestream component7() {
        return this.livestream;
    }

    public final User component8() {
        return this.user;
    }

    public final Channel copy(int i10, int i11, String str, int i12, BannerImage bannerImage2, Chatroom chatroom2, Livestream livestream2, User user2) {
        j.f("slug", str);
        j.f("bannerImage", bannerImage2);
        Chatroom chatroom3 = chatroom2;
        j.f("chatroom", chatroom3);
        User user3 = user2;
        j.f("user", user3);
        return new Channel(i10, i11, str, i12, bannerImage2, chatroom3, livestream2, user3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Channel)) {
            return false;
        }
        Channel channel = (Channel) obj;
        return this.id == channel.id && this.userId == channel.userId && j.a(this.slug, channel.slug) && this.followers == channel.followers && j.a(this.bannerImage, channel.bannerImage) && j.a(this.chatroom, channel.chatroom) && j.a(this.livestream, channel.livestream) && j.a(this.user, channel.user);
    }

    public final BannerImage getBannerImage() {
        return this.bannerImage;
    }

    public final Chatroom getChatroom() {
        return this.chatroom;
    }

    public final int getFollowers() {
        return this.followers;
    }

    public final int getId() {
        return this.id;
    }

    public final Livestream getLivestream() {
        return this.livestream;
    }

    public final String getSlug() {
        return this.slug;
    }

    public final User getUser() {
        return this.user;
    }

    public final int getUserId() {
        return this.userId;
    }

    public int hashCode() {
        int i10;
        String str = this.slug;
        int hashCode = this.bannerImage.hashCode();
        int hashCode2 = (this.chatroom.hashCode() + ((hashCode + ((h.e(str, ((this.id * 31) + this.userId) * 31, 31) + this.followers) * 31)) * 31)) * 31;
        Livestream livestream2 = this.livestream;
        if (livestream2 == null) {
            i10 = 0;
        } else {
            i10 = livestream2.hashCode();
        }
        return this.user.hashCode() + ((hashCode2 + i10) * 31);
    }

    public String toString() {
        int i10 = this.id;
        int i11 = this.userId;
        String str = this.slug;
        int i12 = this.followers;
        BannerImage bannerImage2 = this.bannerImage;
        Chatroom chatroom2 = this.chatroom;
        Livestream livestream2 = this.livestream;
        User user2 = this.user;
        return "Channel(id=" + i10 + ", userId=" + i11 + ", slug=" + str + ", followers=" + i12 + ", bannerImage=" + bannerImage2 + ", chatroom=" + chatroom2 + ", livestream=" + livestream2 + ", user=" + user2 + ")";
    }
}
