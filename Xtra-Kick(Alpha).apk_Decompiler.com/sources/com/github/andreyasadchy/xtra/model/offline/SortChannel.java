package com.github.andreyasadchy.xtra.model.offline;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.h;
import q0.f;
import xa.j;

public final class SortChannel implements Parcelable {
    public static final Parcelable.Creator<SortChannel> CREATOR = new Creator();
    private String clipPeriod;
    private final String id;
    private Boolean saveSort;
    private String videoSort;
    private String videoType;

    public static final class Creator implements Parcelable.Creator<SortChannel> {
        public final SortChannel createFromParcel(Parcel parcel) {
            Boolean valueOf;
            j.f("parcel", parcel);
            String readString = parcel.readString();
            if (parcel.readInt() == 0) {
                valueOf = null;
            } else {
                valueOf = Boolean.valueOf(parcel.readInt() != 0);
            }
            return new SortChannel(readString, valueOf, parcel.readString(), parcel.readString(), parcel.readString());
        }

        public final SortChannel[] newArray(int i10) {
            return new SortChannel[i10];
        }
    }

    public SortChannel(String str, Boolean bool, String str2, String str3, String str4) {
        j.f("id", str);
        this.id = str;
        this.saveSort = bool;
        this.videoSort = str2;
        this.videoType = str3;
        this.clipPeriod = str4;
    }

    public static /* synthetic */ SortChannel copy$default(SortChannel sortChannel, String str, Boolean bool, String str2, String str3, String str4, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = sortChannel.id;
        }
        if ((i10 & 2) != 0) {
            bool = sortChannel.saveSort;
        }
        Boolean bool2 = bool;
        if ((i10 & 4) != 0) {
            str2 = sortChannel.videoSort;
        }
        String str5 = str2;
        if ((i10 & 8) != 0) {
            str3 = sortChannel.videoType;
        }
        String str6 = str3;
        if ((i10 & 16) != 0) {
            str4 = sortChannel.clipPeriod;
        }
        return sortChannel.copy(str, bool2, str5, str6, str4);
    }

    public final String component1() {
        return this.id;
    }

    public final Boolean component2() {
        return this.saveSort;
    }

    public final String component3() {
        return this.videoSort;
    }

    public final String component4() {
        return this.videoType;
    }

    public final String component5() {
        return this.clipPeriod;
    }

    public final SortChannel copy(String str, Boolean bool, String str2, String str3, String str4) {
        j.f("id", str);
        return new SortChannel(str, bool, str2, str3, str4);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SortChannel)) {
            return false;
        }
        SortChannel sortChannel = (SortChannel) obj;
        return j.a(this.id, sortChannel.id) && j.a(this.saveSort, sortChannel.saveSort) && j.a(this.videoSort, sortChannel.videoSort) && j.a(this.videoType, sortChannel.videoType) && j.a(this.clipPeriod, sortChannel.clipPeriod);
    }

    public final String getClipPeriod() {
        return this.clipPeriod;
    }

    public final String getId() {
        return this.id;
    }

    public final Boolean getSaveSort() {
        return this.saveSort;
    }

    public final String getVideoSort() {
        return this.videoSort;
    }

    public final String getVideoType() {
        return this.videoType;
    }

    public int hashCode() {
        int hashCode = this.id.hashCode() * 31;
        Boolean bool = this.saveSort;
        int i10 = 0;
        int hashCode2 = (hashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        String str = this.videoSort;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.videoType;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.clipPeriod;
        if (str3 != null) {
            i10 = str3.hashCode();
        }
        return hashCode4 + i10;
    }

    public final void setClipPeriod(String str) {
        this.clipPeriod = str;
    }

    public final void setSaveSort(Boolean bool) {
        this.saveSort = bool;
    }

    public final void setVideoSort(String str) {
        this.videoSort = str;
    }

    public final void setVideoType(String str) {
        this.videoType = str;
    }

    public String toString() {
        String str = this.id;
        Boolean bool = this.saveSort;
        String str2 = this.videoSort;
        String str3 = this.videoType;
        String str4 = this.clipPeriod;
        StringBuilder sb2 = new StringBuilder("SortChannel(id=");
        sb2.append(str);
        sb2.append(", saveSort=");
        sb2.append(bool);
        sb2.append(", videoSort=");
        f.k(sb2, str2, ", videoType=", str3, ", clipPeriod=");
        return h.p(sb2, str4, ")");
    }

    public void writeToParcel(Parcel parcel, int i10) {
        boolean booleanValue;
        j.f("out", parcel);
        parcel.writeString(this.id);
        Boolean bool = this.saveSort;
        if (bool == null) {
            booleanValue = false;
        } else {
            parcel.writeInt(1);
            booleanValue = bool.booleanValue();
        }
        parcel.writeInt(booleanValue ? 1 : 0);
        parcel.writeString(this.videoSort);
        parcel.writeString(this.videoType);
        parcel.writeString(this.clipPeriod);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SortChannel(String str, Boolean bool, String str2, String str3, String str4, int i10, xa.f fVar) {
        this(str, (i10 & 2) != 0 ? null : bool, (i10 & 4) != 0 ? null : str2, (i10 & 8) != 0 ? null : str3, (i10 & 16) != 0 ? null : str4);
    }
}
