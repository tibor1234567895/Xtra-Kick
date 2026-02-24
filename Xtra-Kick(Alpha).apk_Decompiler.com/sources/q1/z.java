package q1;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.h;
import android.text.TextUtils;
import g1.a0;
import g1.u0;
import g1.y0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class z implements y0 {
    public static final Parcelable.Creator<z> CREATOR = new w();

    /* renamed from: h  reason: collision with root package name */
    public final String f13282h;

    /* renamed from: i  reason: collision with root package name */
    public final String f13283i;

    /* renamed from: j  reason: collision with root package name */
    public final List f13284j;

    public z(Parcel parcel) {
        this.f13282h = parcel.readString();
        this.f13283i = parcel.readString();
        int readInt = parcel.readInt();
        ArrayList arrayList = new ArrayList(readInt);
        for (int i10 = 0; i10 < readInt; i10++) {
            arrayList.add((y) parcel.readParcelable(y.class.getClassLoader()));
        }
        this.f13284j = Collections.unmodifiableList(arrayList);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || z.class != obj.getClass()) {
            return false;
        }
        z zVar = (z) obj;
        return TextUtils.equals(this.f13282h, zVar.f13282h) && TextUtils.equals(this.f13283i, zVar.f13283i) && this.f13284j.equals(zVar.f13284j);
    }

    public final /* synthetic */ a0 g() {
        return null;
    }

    public final /* synthetic */ void h(u0 u0Var) {
    }

    public final int hashCode() {
        int i10 = 0;
        String str = this.f13282h;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f13283i;
        if (str2 != null) {
            i10 = str2.hashCode();
        }
        return this.f13284j.hashCode() + ((hashCode + i10) * 31);
    }

    public final /* synthetic */ byte[] r() {
        return null;
    }

    public final String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder("HlsTrackMetadataEntry");
        String str2 = this.f13282h;
        if (str2 != null) {
            str = h.p(h.s(" [", str2, ", "), this.f13283i, "]");
        } else {
            str = "";
        }
        sb2.append(str);
        return sb2.toString();
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f13282h);
        parcel.writeString(this.f13283i);
        List list = this.f13284j;
        int size = list.size();
        parcel.writeInt(size);
        for (int i11 = 0; i11 < size; i11++) {
            parcel.writeParcelable((Parcelable) list.get(i11), 0);
        }
    }

    public z(String str, String str2, List list) {
        this.f13282h = str;
        this.f13283i = str2;
        this.f13284j = Collections.unmodifiableList(new ArrayList(list));
    }
}
