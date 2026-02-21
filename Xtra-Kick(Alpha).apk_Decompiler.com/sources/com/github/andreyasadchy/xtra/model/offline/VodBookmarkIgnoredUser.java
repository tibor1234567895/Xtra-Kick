package com.github.andreyasadchy.xtra.model.offline;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.h;
import xa.j;

public final class VodBookmarkIgnoredUser implements Parcelable {
    public static final Parcelable.Creator<VodBookmarkIgnoredUser> CREATOR = new Creator();
    private final int user_id;

    public static final class Creator implements Parcelable.Creator<VodBookmarkIgnoredUser> {
        public final VodBookmarkIgnoredUser createFromParcel(Parcel parcel) {
            j.f("parcel", parcel);
            return new VodBookmarkIgnoredUser(parcel.readInt());
        }

        public final VodBookmarkIgnoredUser[] newArray(int i10) {
            return new VodBookmarkIgnoredUser[i10];
        }
    }

    public VodBookmarkIgnoredUser(int i10) {
        this.user_id = i10;
    }

    public static /* synthetic */ VodBookmarkIgnoredUser copy$default(VodBookmarkIgnoredUser vodBookmarkIgnoredUser, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = vodBookmarkIgnoredUser.user_id;
        }
        return vodBookmarkIgnoredUser.copy(i10);
    }

    public final int component1() {
        return this.user_id;
    }

    public final VodBookmarkIgnoredUser copy(int i10) {
        return new VodBookmarkIgnoredUser(i10);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof VodBookmarkIgnoredUser) && this.user_id == ((VodBookmarkIgnoredUser) obj).user_id;
    }

    public final int getUser_id() {
        return this.user_id;
    }

    public int hashCode() {
        return this.user_id;
    }

    public String toString() {
        return h.j("VodBookmarkIgnoredUser(user_id=", this.user_id, ")");
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.f("out", parcel);
        parcel.writeInt(this.user_id);
    }
}
