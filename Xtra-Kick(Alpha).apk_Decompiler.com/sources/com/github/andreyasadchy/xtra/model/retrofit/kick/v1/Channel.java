package com.github.andreyasadchy.xtra.model.retrofit.kick.v1;

import android.support.v4.media.h;
import java.util.List;
import k9.b;
import xa.j;

public final class Channel {
    private final Integer followersCount;
    private final int id;
    @b("is_banned")
    private final boolean isBanned;
    @b("playback_url")
    private final String playbackUrl;
    @b("previous_livestreams")
    private final List<PreviousLivestream> previousLivestreams;
    private final String slug;
    @b("subscription_enabled")
    private final boolean subscriptionEnabled;
    private final User user;
    @b("user_id")
    private final int userId;
    @b("vod_enabled")
    private final boolean vodEnabled;

    public Channel(int i10, int i11, String str, boolean z10, String str2, boolean z11, boolean z12, Integer num, User user2, List<PreviousLivestream> list) {
        j.f("slug", str);
        j.f("playbackUrl", str2);
        j.f("user", user2);
        this.id = i10;
        this.userId = i11;
        this.slug = str;
        this.isBanned = z10;
        this.playbackUrl = str2;
        this.vodEnabled = z11;
        this.subscriptionEnabled = z12;
        this.followersCount = num;
        this.user = user2;
        this.previousLivestreams = list;
    }

    public static /* synthetic */ Channel copy$default(Channel channel, int i10, int i11, String str, boolean z10, String str2, boolean z11, boolean z12, Integer num, User user2, List list, int i12, Object obj) {
        Channel channel2 = channel;
        int i13 = i12;
        return channel.copy((i13 & 1) != 0 ? channel2.id : i10, (i13 & 2) != 0 ? channel2.userId : i11, (i13 & 4) != 0 ? channel2.slug : str, (i13 & 8) != 0 ? channel2.isBanned : z10, (i13 & 16) != 0 ? channel2.playbackUrl : str2, (i13 & 32) != 0 ? channel2.vodEnabled : z11, (i13 & 64) != 0 ? channel2.subscriptionEnabled : z12, (i13 & 128) != 0 ? channel2.followersCount : num, (i13 & 256) != 0 ? channel2.user : user2, (i13 & 512) != 0 ? channel2.previousLivestreams : list);
    }

    public final int component1() {
        return this.id;
    }

    public final List<PreviousLivestream> component10() {
        return this.previousLivestreams;
    }

    public final int component2() {
        return this.userId;
    }

    public final String component3() {
        return this.slug;
    }

    public final boolean component4() {
        return this.isBanned;
    }

    public final String component5() {
        return this.playbackUrl;
    }

    public final boolean component6() {
        return this.vodEnabled;
    }

    public final boolean component7() {
        return this.subscriptionEnabled;
    }

    public final Integer component8() {
        return this.followersCount;
    }

    public final User component9() {
        return this.user;
    }

    public final Channel copy(int i10, int i11, String str, boolean z10, String str2, boolean z11, boolean z12, Integer num, User user2, List<PreviousLivestream> list) {
        j.f("slug", str);
        String str3 = str2;
        j.f("playbackUrl", str3);
        User user3 = user2;
        j.f("user", user3);
        return new Channel(i10, i11, str, z10, str3, z11, z12, num, user3, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Channel)) {
            return false;
        }
        Channel channel = (Channel) obj;
        return this.id == channel.id && this.userId == channel.userId && j.a(this.slug, channel.slug) && this.isBanned == channel.isBanned && j.a(this.playbackUrl, channel.playbackUrl) && this.vodEnabled == channel.vodEnabled && this.subscriptionEnabled == channel.subscriptionEnabled && j.a(this.followersCount, channel.followersCount) && j.a(this.user, channel.user) && j.a(this.previousLivestreams, channel.previousLivestreams);
    }

    public final Integer getFollowersCount() {
        return this.followersCount;
    }

    public final int getId() {
        return this.id;
    }

    public final String getPlaybackUrl() {
        return this.playbackUrl;
    }

    public final List<PreviousLivestream> getPreviousLivestreams() {
        return this.previousLivestreams;
    }

    public final String getSlug() {
        return this.slug;
    }

    public final boolean getSubscriptionEnabled() {
        return this.subscriptionEnabled;
    }

    public final User getUser() {
        return this.user;
    }

    public final int getUserId() {
        return this.userId;
    }

    public final boolean getVodEnabled() {
        return this.vodEnabled;
    }

    public int hashCode() {
        int i10;
        int e10 = h.e(this.slug, ((this.id * 31) + this.userId) * 31, 31);
        boolean z10 = this.isBanned;
        boolean z11 = true;
        if (z10) {
            z10 = true;
        }
        int e11 = h.e(this.playbackUrl, (e10 + (z10 ? 1 : 0)) * 31, 31);
        boolean z12 = this.vodEnabled;
        if (z12) {
            z12 = true;
        }
        int i11 = (e11 + (z12 ? 1 : 0)) * 31;
        boolean z13 = this.subscriptionEnabled;
        if (!z13) {
            z11 = z13;
        }
        int i12 = (i11 + (z11 ? 1 : 0)) * 31;
        Integer num = this.followersCount;
        int i13 = 0;
        if (num == null) {
            i10 = 0;
        } else {
            i10 = num.hashCode();
        }
        int hashCode = (this.user.hashCode() + ((i12 + i10) * 31)) * 31;
        List<PreviousLivestream> list = this.previousLivestreams;
        if (list != null) {
            i13 = list.hashCode();
        }
        return hashCode + i13;
    }

    public final boolean isBanned() {
        return this.isBanned;
    }

    public String toString() {
        int i10 = this.id;
        int i11 = this.userId;
        String str = this.slug;
        boolean z10 = this.isBanned;
        String str2 = this.playbackUrl;
        boolean z11 = this.vodEnabled;
        boolean z12 = this.subscriptionEnabled;
        Integer num = this.followersCount;
        User user2 = this.user;
        List<PreviousLivestream> list = this.previousLivestreams;
        return "Channel(id=" + i10 + ", userId=" + i11 + ", slug=" + str + ", isBanned=" + z10 + ", playbackUrl=" + str2 + ", vodEnabled=" + z11 + ", subscriptionEnabled=" + z12 + ", followersCount=" + num + ", user=" + user2 + ", previousLivestreams=" + list + ")";
    }
}
