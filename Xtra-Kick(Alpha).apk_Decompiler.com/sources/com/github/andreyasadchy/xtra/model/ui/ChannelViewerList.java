package com.github.andreyasadchy.xtra.model.ui;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
import xa.j;

public final class ChannelViewerList implements Parcelable {
    public static final Parcelable.Creator<ChannelViewerList> CREATOR = new Creator();
    private final List<String> broadcasters;
    private final Integer count;
    private final List<String> moderators;
    private final List<String> viewers;
    private final List<String> vips;

    public static final class Creator implements Parcelable.Creator<ChannelViewerList> {
        public final ChannelViewerList createFromParcel(Parcel parcel) {
            j.f("parcel", parcel);
            return new ChannelViewerList(parcel.createStringArrayList(), parcel.createStringArrayList(), parcel.createStringArrayList(), parcel.createStringArrayList(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()));
        }

        public final ChannelViewerList[] newArray(int i10) {
            return new ChannelViewerList[i10];
        }
    }

    public ChannelViewerList(List<String> list, List<String> list2, List<String> list3, List<String> list4, Integer num) {
        j.f("broadcasters", list);
        j.f("moderators", list2);
        j.f("vips", list3);
        j.f("viewers", list4);
        this.broadcasters = list;
        this.moderators = list2;
        this.vips = list3;
        this.viewers = list4;
        this.count = num;
    }

    public static /* synthetic */ ChannelViewerList copy$default(ChannelViewerList channelViewerList, List<String> list, List<String> list2, List<String> list3, List<String> list4, Integer num, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = channelViewerList.broadcasters;
        }
        if ((i10 & 2) != 0) {
            list2 = channelViewerList.moderators;
        }
        List<String> list5 = list2;
        if ((i10 & 4) != 0) {
            list3 = channelViewerList.vips;
        }
        List<String> list6 = list3;
        if ((i10 & 8) != 0) {
            list4 = channelViewerList.viewers;
        }
        List<String> list7 = list4;
        if ((i10 & 16) != 0) {
            num = channelViewerList.count;
        }
        return channelViewerList.copy(list, list5, list6, list7, num);
    }

    public final List<String> component1() {
        return this.broadcasters;
    }

    public final List<String> component2() {
        return this.moderators;
    }

    public final List<String> component3() {
        return this.vips;
    }

    public final List<String> component4() {
        return this.viewers;
    }

    public final Integer component5() {
        return this.count;
    }

    public final ChannelViewerList copy(List<String> list, List<String> list2, List<String> list3, List<String> list4, Integer num) {
        j.f("broadcasters", list);
        j.f("moderators", list2);
        j.f("vips", list3);
        j.f("viewers", list4);
        return new ChannelViewerList(list, list2, list3, list4, num);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChannelViewerList)) {
            return false;
        }
        ChannelViewerList channelViewerList = (ChannelViewerList) obj;
        return j.a(this.broadcasters, channelViewerList.broadcasters) && j.a(this.moderators, channelViewerList.moderators) && j.a(this.vips, channelViewerList.vips) && j.a(this.viewers, channelViewerList.viewers) && j.a(this.count, channelViewerList.count);
    }

    public final List<String> getBroadcasters() {
        return this.broadcasters;
    }

    public final Integer getCount() {
        return this.count;
    }

    public final List<String> getModerators() {
        return this.moderators;
    }

    public final List<String> getViewers() {
        return this.viewers;
    }

    public final List<String> getVips() {
        return this.vips;
    }

    public int hashCode() {
        int hashCode = this.moderators.hashCode();
        int hashCode2 = (this.viewers.hashCode() + ((this.vips.hashCode() + ((hashCode + (this.broadcasters.hashCode() * 31)) * 31)) * 31)) * 31;
        Integer num = this.count;
        return hashCode2 + (num == null ? 0 : num.hashCode());
    }

    public String toString() {
        List<String> list = this.broadcasters;
        List<String> list2 = this.moderators;
        List<String> list3 = this.vips;
        List<String> list4 = this.viewers;
        Integer num = this.count;
        return "ChannelViewerList(broadcasters=" + list + ", moderators=" + list2 + ", vips=" + list3 + ", viewers=" + list4 + ", count=" + num + ")";
    }

    public void writeToParcel(Parcel parcel, int i10) {
        int i11;
        j.f("out", parcel);
        parcel.writeStringList(this.broadcasters);
        parcel.writeStringList(this.moderators);
        parcel.writeStringList(this.vips);
        parcel.writeStringList(this.viewers);
        Integer num = this.count;
        if (num == null) {
            i11 = 0;
        } else {
            parcel.writeInt(1);
            i11 = num.intValue();
        }
        parcel.writeInt(i11);
    }
}
