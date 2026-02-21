package o3;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.AbsSavedState;

public class r extends AbsSavedState {
    public static final Parcelable.Creator<r> CREATOR = new q();

    public r(Parcel parcel) {
        super(parcel);
    }

    public r(AbsSavedState absSavedState) {
        super(absSavedState);
    }
}
