package o3;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.AbsSavedState;
import java.util.Collections;
import java.util.HashSet;

public final class n extends r {
    public static final Parcelable.Creator<n> CREATOR = new m();

    /* renamed from: h  reason: collision with root package name */
    public HashSet f12162h;

    public n(Parcel parcel) {
        super(parcel);
        int readInt = parcel.readInt();
        this.f12162h = new HashSet();
        String[] strArr = new String[readInt];
        parcel.readStringArray(strArr);
        Collections.addAll(this.f12162h, strArr);
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeInt(this.f12162h.size());
        HashSet hashSet = this.f12162h;
        parcel.writeStringArray((String[]) hashSet.toArray(new String[hashSet.size()]));
    }

    public n(AbsSavedState absSavedState) {
        super(absSavedState);
    }
}
