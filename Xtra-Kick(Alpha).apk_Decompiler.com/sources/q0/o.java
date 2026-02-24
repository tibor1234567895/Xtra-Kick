package q0;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.h;
import android.view.View;

public final class o extends View.BaseSavedState {
    public static final Parcelable.Creator<o> CREATOR = new n();

    /* renamed from: h  reason: collision with root package name */
    public int f13119h;

    public o(Parcel parcel) {
        super(parcel);
        this.f13119h = parcel.readInt();
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("HorizontalScrollView.SavedState{");
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        sb2.append(" scrollPosition=");
        return h.o(sb2, this.f13119h, "}");
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeInt(this.f13119h);
    }

    public o(Parcelable parcelable) {
        super(parcelable);
    }
}
