package com.github.andreyasadchy.xtra.model.ui;

import android.support.v4.media.h;
import xa.f;
import xa.j;

public final class BroadcastSettings {
    private final String boxArtUrl;
    private final int gameId;
    private final String gameName;
    private final String gameSlug;
    private final String title;

    public BroadcastSettings(String str, String str2, int i10, String str3, String str4) {
        this.title = str;
        this.gameName = str2;
        this.gameId = i10;
        this.gameSlug = str3;
        this.boxArtUrl = str4;
    }

    public static /* synthetic */ BroadcastSettings copy$default(BroadcastSettings broadcastSettings, String str, String str2, int i10, String str3, String str4, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = broadcastSettings.title;
        }
        if ((i11 & 2) != 0) {
            str2 = broadcastSettings.gameName;
        }
        String str5 = str2;
        if ((i11 & 4) != 0) {
            i10 = broadcastSettings.gameId;
        }
        int i12 = i10;
        if ((i11 & 8) != 0) {
            str3 = broadcastSettings.gameSlug;
        }
        String str6 = str3;
        if ((i11 & 16) != 0) {
            str4 = broadcastSettings.boxArtUrl;
        }
        return broadcastSettings.copy(str, str5, i12, str6, str4);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.gameName;
    }

    public final int component3() {
        return this.gameId;
    }

    public final String component4() {
        return this.gameSlug;
    }

    public final String component5() {
        return this.boxArtUrl;
    }

    public final BroadcastSettings copy(String str, String str2, int i10, String str3, String str4) {
        return new BroadcastSettings(str, str2, i10, str3, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BroadcastSettings)) {
            return false;
        }
        BroadcastSettings broadcastSettings = (BroadcastSettings) obj;
        return j.a(this.title, broadcastSettings.title) && j.a(this.gameName, broadcastSettings.gameName) && this.gameId == broadcastSettings.gameId && j.a(this.gameSlug, broadcastSettings.gameSlug) && j.a(this.boxArtUrl, broadcastSettings.boxArtUrl);
    }

    public final String getBoxArtUrl() {
        return this.boxArtUrl;
    }

    public final int getGameId() {
        return this.gameId;
    }

    public final String getGameName() {
        return this.gameName;
    }

    public final String getGameSlug() {
        return this.gameSlug;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        String str = this.title;
        int i10 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.gameName;
        int hashCode2 = (((hashCode + (str2 == null ? 0 : str2.hashCode())) * 31) + this.gameId) * 31;
        String str3 = this.gameSlug;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.boxArtUrl;
        if (str4 != null) {
            i10 = str4.hashCode();
        }
        return hashCode3 + i10;
    }

    public String toString() {
        String str = this.title;
        String str2 = this.gameName;
        int i10 = this.gameId;
        String str3 = this.gameSlug;
        String str4 = this.boxArtUrl;
        StringBuilder sb2 = new StringBuilder("BroadcastSettings(title=");
        sb2.append(str);
        sb2.append(", gameName=");
        sb2.append(str2);
        sb2.append(", gameId=");
        sb2.append(i10);
        sb2.append(", gameSlug=");
        sb2.append(str3);
        sb2.append(", boxArtUrl=");
        return h.p(sb2, str4, ")");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BroadcastSettings(String str, String str2, int i10, String str3, String str4, int i11, f fVar) {
        this(str, str2, (i11 & 4) != 0 ? 0 : i10, str3, str4);
    }
}
