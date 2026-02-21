package com.github.andreyasadchy.xtra.model.offline;

import android.os.Parcel;
import android.os.Parcelable;
import xa.f;
import xa.j;

public final class LocalFollowGame implements Parcelable {
    public static final Parcelable.Creator<LocalFollowGame> CREATOR = new Creator();
    private String boxArt;
    private final Integer gameId;
    private String gameName;
    private String gameSlug;
    private int id;

    public static final class Creator implements Parcelable.Creator<LocalFollowGame> {
        public final LocalFollowGame createFromParcel(Parcel parcel) {
            j.f("parcel", parcel);
            return new LocalFollowGame(parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readString(), parcel.readString(), parcel.readString());
        }

        public final LocalFollowGame[] newArray(int i10) {
            return new LocalFollowGame[i10];
        }
    }

    public LocalFollowGame(Integer num, String str, String str2, String str3) {
        this.gameId = num;
        this.gameSlug = str;
        this.gameName = str2;
        this.boxArt = str3;
    }

    public static /* synthetic */ LocalFollowGame copy$default(LocalFollowGame localFollowGame, Integer num, String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            num = localFollowGame.gameId;
        }
        if ((i10 & 2) != 0) {
            str = localFollowGame.gameSlug;
        }
        if ((i10 & 4) != 0) {
            str2 = localFollowGame.gameName;
        }
        if ((i10 & 8) != 0) {
            str3 = localFollowGame.boxArt;
        }
        return localFollowGame.copy(num, str, str2, str3);
    }

    public static /* synthetic */ void getId$annotations() {
    }

    public final Integer component1() {
        return this.gameId;
    }

    public final String component2() {
        return this.gameSlug;
    }

    public final String component3() {
        return this.gameName;
    }

    public final String component4() {
        return this.boxArt;
    }

    public final LocalFollowGame copy(Integer num, String str, String str2, String str3) {
        return new LocalFollowGame(num, str, str2, str3);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocalFollowGame)) {
            return false;
        }
        LocalFollowGame localFollowGame = (LocalFollowGame) obj;
        return j.a(this.gameId, localFollowGame.gameId) && j.a(this.gameSlug, localFollowGame.gameSlug) && j.a(this.gameName, localFollowGame.gameName) && j.a(this.boxArt, localFollowGame.boxArt);
    }

    public final String getBoxArt() {
        return this.boxArt;
    }

    public final Integer getGameId() {
        return this.gameId;
    }

    public final String getGameName() {
        return this.gameName;
    }

    public final String getGameSlug() {
        return this.gameSlug;
    }

    public final int getId() {
        return this.id;
    }

    public int hashCode() {
        Integer num = this.gameId;
        int i10 = 0;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.gameSlug;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.gameName;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.boxArt;
        if (str3 != null) {
            i10 = str3.hashCode();
        }
        return hashCode3 + i10;
    }

    public final void setBoxArt(String str) {
        this.boxArt = str;
    }

    public final void setGameName(String str) {
        this.gameName = str;
    }

    public final void setGameSlug(String str) {
        this.gameSlug = str;
    }

    public final void setId(int i10) {
        this.id = i10;
    }

    public String toString() {
        Integer num = this.gameId;
        String str = this.gameSlug;
        String str2 = this.gameName;
        String str3 = this.boxArt;
        return "LocalFollowGame(gameId=" + num + ", gameSlug=" + str + ", gameName=" + str2 + ", boxArt=" + str3 + ")";
    }

    public void writeToParcel(Parcel parcel, int i10) {
        int i11;
        j.f("out", parcel);
        Integer num = this.gameId;
        if (num == null) {
            i11 = 0;
        } else {
            parcel.writeInt(1);
            i11 = num.intValue();
        }
        parcel.writeInt(i11);
        parcel.writeString(this.gameSlug);
        parcel.writeString(this.gameName);
        parcel.writeString(this.boxArt);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LocalFollowGame(Integer num, String str, String str2, String str3, int i10, f fVar) {
        this(num, (i10 & 2) != 0 ? null : str, (i10 & 4) != 0 ? null : str2, (i10 & 8) != 0 ? null : str3);
    }
}
