package d4;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.versionedparcelable.ParcelImpl;

public final class a implements Parcelable.Creator {
    public final Object createFromParcel(Parcel parcel) {
        return new ParcelImpl(parcel);
    }

    public final Object[] newArray(int i10) {
        return new ParcelImpl[i10];
    }
}
