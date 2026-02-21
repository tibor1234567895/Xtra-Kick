package e8;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.h;
import android.view.View;

public final class c extends View.BaseSavedState {
    public static final Parcelable.Creator<c> CREATOR = new b();

    /* renamed from: h  reason: collision with root package name */
    public int f5314h;

    public c(Parcel parcel) {
        super(parcel);
        this.f5314h = ((Integer) parcel.readValue(c.class.getClassLoader())).intValue();
    }

    public final String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder("MaterialCheckBox.SavedState{");
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        sb2.append(" CheckedState=");
        int i10 = this.f5314h;
        if (i10 == 1) {
            str = "checked";
        } else if (i10 != 2) {
            str = "unchecked";
        } else {
            str = "indeterminate";
        }
        return h.p(sb2, str, "}");
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeValue(Integer.valueOf(this.f5314h));
    }

    public c(Parcelable parcelable) {
        super(parcelable);
    }
}
