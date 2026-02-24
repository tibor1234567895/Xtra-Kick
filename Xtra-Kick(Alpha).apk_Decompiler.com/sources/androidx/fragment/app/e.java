package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

public final class e implements Parcelable {
    public static final Parcelable.Creator<e> CREATOR = new d();

    /* renamed from: h  reason: collision with root package name */
    public final List f1400h;

    /* renamed from: i  reason: collision with root package name */
    public final List f1401i;

    public e(Parcel parcel) {
        this.f1400h = parcel.createStringArrayList();
        this.f1401i = parcel.createTypedArrayList(c.CREATOR);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeStringList(this.f1400h);
        parcel.writeTypedList(this.f1401i);
    }

    public e(ArrayList arrayList, ArrayList arrayList2) {
        this.f1400h = arrayList;
        this.f1401i = arrayList2;
    }
}
