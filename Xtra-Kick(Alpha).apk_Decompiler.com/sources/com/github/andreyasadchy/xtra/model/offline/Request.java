package com.github.andreyasadchy.xtra.model.offline;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.h;
import q0.f;
import xa.j;

public final class Request implements Parcelable {
    public static final Parcelable.Creator<Request> CREATOR = new Creator();
    private final int offlineVideoId;
    private final String path;
    private final Integer segmentFrom;
    private Integer segmentTo;
    private final String url;
    private final String videoId;
    private final String videoType;

    public static final class Creator implements Parcelable.Creator<Request> {
        public final Request createFromParcel(Parcel parcel) {
            j.f("parcel", parcel);
            return new Request(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()));
        }

        public final Request[] newArray(int i10) {
            return new Request[i10];
        }
    }

    public Request(int i10, String str, String str2, String str3, String str4, Integer num, Integer num2) {
        j.f("url", str);
        j.f("path", str2);
        this.offlineVideoId = i10;
        this.url = str;
        this.path = str2;
        this.videoId = str3;
        this.videoType = str4;
        this.segmentFrom = num;
        this.segmentTo = num2;
    }

    public static /* synthetic */ Request copy$default(Request request, int i10, String str, String str2, String str3, String str4, Integer num, Integer num2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = request.offlineVideoId;
        }
        if ((i11 & 2) != 0) {
            str = request.url;
        }
        String str5 = str;
        if ((i11 & 4) != 0) {
            str2 = request.path;
        }
        String str6 = str2;
        if ((i11 & 8) != 0) {
            str3 = request.videoId;
        }
        String str7 = str3;
        if ((i11 & 16) != 0) {
            str4 = request.videoType;
        }
        String str8 = str4;
        if ((i11 & 32) != 0) {
            num = request.segmentFrom;
        }
        Integer num3 = num;
        if ((i11 & 64) != 0) {
            num2 = request.segmentTo;
        }
        return request.copy(i10, str5, str6, str7, str8, num3, num2);
    }

    public final int component1() {
        return this.offlineVideoId;
    }

    public final String component2() {
        return this.url;
    }

    public final String component3() {
        return this.path;
    }

    public final String component4() {
        return this.videoId;
    }

    public final String component5() {
        return this.videoType;
    }

    public final Integer component6() {
        return this.segmentFrom;
    }

    public final Integer component7() {
        return this.segmentTo;
    }

    public final Request copy(int i10, String str, String str2, String str3, String str4, Integer num, Integer num2) {
        j.f("url", str);
        j.f("path", str2);
        return new Request(i10, str, str2, str3, str4, num, num2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Request)) {
            return false;
        }
        Request request = (Request) obj;
        return this.offlineVideoId == request.offlineVideoId && j.a(this.url, request.url) && j.a(this.path, request.path) && j.a(this.videoId, request.videoId) && j.a(this.videoType, request.videoType) && j.a(this.segmentFrom, request.segmentFrom) && j.a(this.segmentTo, request.segmentTo);
    }

    public final int getOfflineVideoId() {
        return this.offlineVideoId;
    }

    public final String getPath() {
        return this.path;
    }

    public final Integer getSegmentFrom() {
        return this.segmentFrom;
    }

    public final Integer getSegmentTo() {
        return this.segmentTo;
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getVideoId() {
        return this.videoId;
    }

    public final String getVideoType() {
        return this.videoType;
    }

    public int hashCode() {
        int i10;
        int i11;
        int i12;
        int e10 = h.e(this.path, h.e(this.url, this.offlineVideoId * 31, 31), 31);
        String str = this.videoId;
        int i13 = 0;
        if (str == null) {
            i10 = 0;
        } else {
            i10 = str.hashCode();
        }
        int i14 = (e10 + i10) * 31;
        String str2 = this.videoType;
        if (str2 == null) {
            i11 = 0;
        } else {
            i11 = str2.hashCode();
        }
        int i15 = (i14 + i11) * 31;
        Integer num = this.segmentFrom;
        if (num == null) {
            i12 = 0;
        } else {
            i12 = num.hashCode();
        }
        int i16 = (i15 + i12) * 31;
        Integer num2 = this.segmentTo;
        if (num2 != null) {
            i13 = num2.hashCode();
        }
        return i16 + i13;
    }

    public final void setSegmentTo(Integer num) {
        this.segmentTo = num;
    }

    public String toString() {
        int i10 = this.offlineVideoId;
        String str = this.url;
        String str2 = this.path;
        String str3 = this.videoId;
        String str4 = this.videoType;
        Integer num = this.segmentFrom;
        Integer num2 = this.segmentTo;
        StringBuilder sb2 = new StringBuilder("Request(offlineVideoId=");
        sb2.append(i10);
        sb2.append(", url=");
        sb2.append(str);
        sb2.append(", path=");
        f.k(sb2, str2, ", videoId=", str3, ", videoType=");
        sb2.append(str4);
        sb2.append(", segmentFrom=");
        sb2.append(num);
        sb2.append(", segmentTo=");
        sb2.append(num2);
        sb2.append(")");
        return sb2.toString();
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.f("out", parcel);
        parcel.writeInt(this.offlineVideoId);
        parcel.writeString(this.url);
        parcel.writeString(this.path);
        parcel.writeString(this.videoId);
        parcel.writeString(this.videoType);
        Integer num = this.segmentFrom;
        if (num == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        }
        Integer num2 = this.segmentTo;
        if (num2 == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcel.writeInt(num2.intValue());
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Request(int i10, String str, String str2, String str3, String str4, Integer num, Integer num2, int i11, xa.f fVar) {
        this(i10, str, str2, (i11 & 8) != 0 ? null : str3, (i11 & 16) != 0 ? null : str4, (i11 & 32) != 0 ? null : num, (i11 & 64) != 0 ? null : num2);
    }
}
