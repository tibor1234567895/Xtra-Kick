package com.github.andreyasadchy.xtra.model.ui;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
import xa.f;
import xa.j;

public final class Game implements Parcelable {
    public static final Parcelable.Creator<Game> CREATOR = new Creator();
    private final String boxArtUrl;
    private Integer broadcastersCount;
    private boolean followAccount;
    private final boolean followLocal;
    private final int gameId;
    private final String gameName;
    private final String gameSlug;
    private List<Tag> tags;
    private Integer viewersCount;
    private final Integer vodDuration;
    private final Integer vodPosition;

    public static final class Creator implements Parcelable.Creator<Game> {
        public final Game createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            j.f("parcel", parcel);
            int readInt = parcel.readInt();
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            Integer num = null;
            Integer valueOf = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            Integer valueOf2 = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int readInt2 = parcel.readInt();
                arrayList = new ArrayList(readInt2);
                for (int i10 = 0; i10 != readInt2; i10++) {
                    arrayList.add(Tag.CREATOR.createFromParcel(parcel));
                }
            }
            Integer valueOf3 = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            if (parcel.readInt() != 0) {
                num = Integer.valueOf(parcel.readInt());
            }
            return new Game(readInt, readString, readString2, readString3, valueOf, valueOf2, arrayList, valueOf3, num, parcel.readInt() != 0, parcel.readInt() != 0);
        }

        public final Game[] newArray(int i10) {
            return new Game[i10];
        }
    }

    public Game() {
        this(0, (String) null, (String) null, (String) null, (Integer) null, (Integer) null, (List) null, (Integer) null, (Integer) null, false, false, 2047, (f) null);
    }

    public static /* synthetic */ Game copy$default(Game game, int i10, String str, String str2, String str3, Integer num, Integer num2, List list, Integer num3, Integer num4, boolean z10, boolean z11, int i11, Object obj) {
        Game game2 = game;
        int i12 = i11;
        return game.copy((i12 & 1) != 0 ? game2.gameId : i10, (i12 & 2) != 0 ? game2.gameName : str, (i12 & 4) != 0 ? game2.gameSlug : str2, (i12 & 8) != 0 ? game2.boxArtUrl : str3, (i12 & 16) != 0 ? game2.viewersCount : num, (i12 & 32) != 0 ? game2.broadcastersCount : num2, (i12 & 64) != 0 ? game2.tags : list, (i12 & 128) != 0 ? game2.vodPosition : num3, (i12 & 256) != 0 ? game2.vodDuration : num4, (i12 & 512) != 0 ? game2.followAccount : z10, (i12 & 1024) != 0 ? game2.followLocal : z11);
    }

    public final int component1() {
        return this.gameId;
    }

    public final boolean component10() {
        return this.followAccount;
    }

    public final boolean component11() {
        return this.followLocal;
    }

    public final String component2() {
        return this.gameName;
    }

    public final String component3() {
        return this.gameSlug;
    }

    public final String component4() {
        return this.boxArtUrl;
    }

    public final Integer component5() {
        return this.viewersCount;
    }

    public final Integer component6() {
        return this.broadcastersCount;
    }

    public final List<Tag> component7() {
        return this.tags;
    }

    public final Integer component8() {
        return this.vodPosition;
    }

    public final Integer component9() {
        return this.vodDuration;
    }

    public final Game copy(int i10, String str, String str2, String str3, Integer num, Integer num2, List<Tag> list, Integer num3, Integer num4, boolean z10, boolean z11) {
        return new Game(i10, str, str2, str3, num, num2, list, num3, num4, z10, z11);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Game)) {
            return false;
        }
        Game game = (Game) obj;
        return this.gameId == game.gameId && j.a(this.gameName, game.gameName) && j.a(this.gameSlug, game.gameSlug) && j.a(this.boxArtUrl, game.boxArtUrl) && j.a(this.viewersCount, game.viewersCount) && j.a(this.broadcastersCount, game.broadcastersCount) && j.a(this.tags, game.tags) && j.a(this.vodPosition, game.vodPosition) && j.a(this.vodDuration, game.vodDuration) && this.followAccount == game.followAccount && this.followLocal == game.followLocal;
    }

    public final String getBoxArt() {
        return this.boxArtUrl;
    }

    public final String getBoxArtUrl() {
        return this.boxArtUrl;
    }

    public final Integer getBroadcastersCount() {
        return this.broadcastersCount;
    }

    public final boolean getFollowAccount() {
        return this.followAccount;
    }

    public final boolean getFollowLocal() {
        return this.followLocal;
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

    public final List<Tag> getTags() {
        return this.tags;
    }

    public final Integer getViewersCount() {
        return this.viewersCount;
    }

    public final Integer getVodDuration() {
        return this.vodDuration;
    }

    public final Integer getVodPosition() {
        return this.vodPosition;
    }

    public int hashCode() {
        int i10 = this.gameId * 31;
        String str = this.gameName;
        int i11 = 0;
        int hashCode = (i10 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.gameSlug;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.boxArtUrl;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num = this.viewersCount;
        int hashCode4 = (hashCode3 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.broadcastersCount;
        int hashCode5 = (hashCode4 + (num2 == null ? 0 : num2.hashCode())) * 31;
        List<Tag> list = this.tags;
        int hashCode6 = (hashCode5 + (list == null ? 0 : list.hashCode())) * 31;
        Integer num3 = this.vodPosition;
        int hashCode7 = (hashCode6 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.vodDuration;
        if (num4 != null) {
            i11 = num4.hashCode();
        }
        int i12 = (hashCode7 + i11) * 31;
        boolean z10 = this.followAccount;
        boolean z11 = true;
        if (z10) {
            z10 = true;
        }
        int i13 = (i12 + (z10 ? 1 : 0)) * 31;
        boolean z12 = this.followLocal;
        if (!z12) {
            z11 = z12;
        }
        return i13 + (z11 ? 1 : 0);
    }

    public final void setBroadcastersCount(Integer num) {
        this.broadcastersCount = num;
    }

    public final void setFollowAccount(boolean z10) {
        this.followAccount = z10;
    }

    public final void setTags(List<Tag> list) {
        this.tags = list;
    }

    public final void setViewersCount(Integer num) {
        this.viewersCount = num;
    }

    public String toString() {
        int i10 = this.gameId;
        String str = this.gameName;
        String str2 = this.gameSlug;
        String str3 = this.boxArtUrl;
        Integer num = this.viewersCount;
        Integer num2 = this.broadcastersCount;
        List<Tag> list = this.tags;
        Integer num3 = this.vodPosition;
        Integer num4 = this.vodDuration;
        boolean z10 = this.followAccount;
        boolean z11 = this.followLocal;
        StringBuilder sb2 = new StringBuilder("Game(gameId=");
        sb2.append(i10);
        sb2.append(", gameName=");
        sb2.append(str);
        sb2.append(", gameSlug=");
        q0.f.k(sb2, str2, ", boxArtUrl=", str3, ", viewersCount=");
        sb2.append(num);
        sb2.append(", broadcastersCount=");
        sb2.append(num2);
        sb2.append(", tags=");
        sb2.append(list);
        sb2.append(", vodPosition=");
        sb2.append(num3);
        sb2.append(", vodDuration=");
        sb2.append(num4);
        sb2.append(", followAccount=");
        sb2.append(z10);
        sb2.append(", followLocal=");
        sb2.append(z11);
        sb2.append(")");
        return sb2.toString();
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.f("out", parcel);
        parcel.writeInt(this.gameId);
        parcel.writeString(this.gameName);
        parcel.writeString(this.gameSlug);
        parcel.writeString(this.boxArtUrl);
        Integer num = this.viewersCount;
        if (num == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        }
        Integer num2 = this.broadcastersCount;
        if (num2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num2.intValue());
        }
        List<Tag> list = this.tags;
        if (list == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(list.size());
            for (Tag writeToParcel : list) {
                writeToParcel.writeToParcel(parcel, i10);
            }
        }
        Integer num3 = this.vodPosition;
        if (num3 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num3.intValue());
        }
        Integer num4 = this.vodDuration;
        if (num4 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num4.intValue());
        }
        parcel.writeInt(this.followAccount ? 1 : 0);
        parcel.writeInt(this.followLocal ? 1 : 0);
    }

    public Game(int i10, String str, String str2, String str3, Integer num, Integer num2, List<Tag> list, Integer num3, Integer num4, boolean z10, boolean z11) {
        this.gameId = i10;
        this.gameName = str;
        this.gameSlug = str2;
        this.boxArtUrl = str3;
        this.viewersCount = num;
        this.broadcastersCount = num2;
        this.tags = list;
        this.vodPosition = num3;
        this.vodDuration = num4;
        this.followAccount = z10;
        this.followLocal = z11;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ Game(int r13, java.lang.String r14, java.lang.String r15, java.lang.String r16, java.lang.Integer r17, java.lang.Integer r18, java.util.List r19, java.lang.Integer r20, java.lang.Integer r21, boolean r22, boolean r23, int r24, xa.f r25) {
        /*
            r12 = this;
            r0 = r24
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = 0
            goto L_0x000a
        L_0x0009:
            r1 = r13
        L_0x000a:
            r3 = r0 & 2
            r4 = 0
            if (r3 == 0) goto L_0x0011
            r3 = r4
            goto L_0x0012
        L_0x0011:
            r3 = r14
        L_0x0012:
            r5 = r0 & 4
            if (r5 == 0) goto L_0x0018
            r5 = r4
            goto L_0x0019
        L_0x0018:
            r5 = r15
        L_0x0019:
            r6 = r0 & 8
            if (r6 == 0) goto L_0x001f
            r6 = r4
            goto L_0x0021
        L_0x001f:
            r6 = r16
        L_0x0021:
            r7 = r0 & 16
            if (r7 == 0) goto L_0x0027
            r7 = r4
            goto L_0x0029
        L_0x0027:
            r7 = r17
        L_0x0029:
            r8 = r0 & 32
            if (r8 == 0) goto L_0x002f
            r8 = r4
            goto L_0x0031
        L_0x002f:
            r8 = r18
        L_0x0031:
            r9 = r0 & 64
            if (r9 == 0) goto L_0x0037
            r9 = r4
            goto L_0x0039
        L_0x0037:
            r9 = r19
        L_0x0039:
            r10 = r0 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x003f
            r10 = r4
            goto L_0x0041
        L_0x003f:
            r10 = r20
        L_0x0041:
            r11 = r0 & 256(0x100, float:3.59E-43)
            if (r11 == 0) goto L_0x0046
            goto L_0x0048
        L_0x0046:
            r4 = r21
        L_0x0048:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x004e
            r11 = 0
            goto L_0x0050
        L_0x004e:
            r11 = r22
        L_0x0050:
            r0 = r0 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x0055
            goto L_0x0057
        L_0x0055:
            r2 = r23
        L_0x0057:
            r13 = r12
            r14 = r1
            r15 = r3
            r16 = r5
            r17 = r6
            r18 = r7
            r19 = r8
            r20 = r9
            r21 = r10
            r22 = r4
            r23 = r11
            r24 = r2
            r13.<init>(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.andreyasadchy.xtra.model.ui.Game.<init>(int, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.Integer, java.util.List, java.lang.Integer, java.lang.Integer, boolean, boolean, int, xa.f):void");
    }
}
