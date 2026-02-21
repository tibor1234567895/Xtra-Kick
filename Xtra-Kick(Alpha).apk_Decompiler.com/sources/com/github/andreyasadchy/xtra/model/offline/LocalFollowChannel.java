package com.github.andreyasadchy.xtra.model.offline;

import android.os.Parcel;
import android.os.Parcelable;
import xa.f;
import xa.j;

public final class LocalFollowChannel implements Parcelable {
    public static final Parcelable.Creator<LocalFollowChannel> CREATOR = new Creator();
    private String channelLogo;
    private int id;
    private final int userId;
    private String userLogin;
    private String userName;

    public static final class Creator implements Parcelable.Creator<LocalFollowChannel> {
        public final LocalFollowChannel createFromParcel(Parcel parcel) {
            j.f("parcel", parcel);
            return new LocalFollowChannel(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        public final LocalFollowChannel[] newArray(int i10) {
            return new LocalFollowChannel[i10];
        }
    }

    public LocalFollowChannel() {
        this(0, (String) null, (String) null, (String) null, 15, (f) null);
    }

    public static /* synthetic */ LocalFollowChannel copy$default(LocalFollowChannel localFollowChannel, int i10, String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = localFollowChannel.userId;
        }
        if ((i11 & 2) != 0) {
            str = localFollowChannel.userLogin;
        }
        if ((i11 & 4) != 0) {
            str2 = localFollowChannel.userName;
        }
        if ((i11 & 8) != 0) {
            str3 = localFollowChannel.channelLogo;
        }
        return localFollowChannel.copy(i10, str, str2, str3);
    }

    public static /* synthetic */ void getId$annotations() {
    }

    public final int component1() {
        return this.userId;
    }

    public final String component2() {
        return this.userLogin;
    }

    public final String component3() {
        return this.userName;
    }

    public final String component4() {
        return this.channelLogo;
    }

    public final LocalFollowChannel copy(int i10, String str, String str2, String str3) {
        return new LocalFollowChannel(i10, str, str2, str3);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocalFollowChannel)) {
            return false;
        }
        LocalFollowChannel localFollowChannel = (LocalFollowChannel) obj;
        return this.userId == localFollowChannel.userId && j.a(this.userLogin, localFollowChannel.userLogin) && j.a(this.userName, localFollowChannel.userName) && j.a(this.channelLogo, localFollowChannel.channelLogo);
    }

    public final String getChannelLogo() {
        return this.channelLogo;
    }

    public final int getId() {
        return this.id;
    }

    public final int getUserId() {
        return this.userId;
    }

    public final String getUserLogin() {
        return this.userLogin;
    }

    public final String getUserName() {
        return this.userName;
    }

    public int hashCode() {
        int i10 = this.userId * 31;
        String str = this.userLogin;
        int i11 = 0;
        int hashCode = (i10 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.userName;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.channelLogo;
        if (str3 != null) {
            i11 = str3.hashCode();
        }
        return hashCode2 + i11;
    }

    public final void setChannelLogo(String str) {
        this.channelLogo = str;
    }

    public final void setId(int i10) {
        this.id = i10;
    }

    public final void setUserLogin(String str) {
        this.userLogin = str;
    }

    public final void setUserName(String str) {
        this.userName = str;
    }

    public String toString() {
        int i10 = this.userId;
        String str = this.userLogin;
        String str2 = this.userName;
        String str3 = this.channelLogo;
        return "LocalFollowChannel(userId=" + i10 + ", userLogin=" + str + ", userName=" + str2 + ", channelLogo=" + str3 + ")";
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.f("out", parcel);
        parcel.writeInt(this.userId);
        parcel.writeString(this.userLogin);
        parcel.writeString(this.userName);
        parcel.writeString(this.channelLogo);
    }

    public LocalFollowChannel(int i10, String str, String str2, String str3) {
        this.userId = i10;
        this.userLogin = str;
        this.userName = str2;
        this.channelLogo = str3;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LocalFollowChannel(int i10, String str, String str2, String str3, int i11, f fVar) {
        this((i11 & 1) != 0 ? 0 : i10, (i11 & 2) != 0 ? null : str, (i11 & 4) != 0 ? null : str2, (i11 & 8) != 0 ? null : str3);
    }
}
