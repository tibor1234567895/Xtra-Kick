package androidx.appcompat.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

public final class f1 extends View.BaseSavedState {
    public static final Parcelable.Creator<f1> CREATOR = new e1();

    /* renamed from: h  reason: collision with root package name */
    public boolean f819h;

    public f1(Parcel parcel) {
        super(parcel);
        this.f819h = parcel.readByte() != 0;
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeByte(this.f819h ? (byte) 1 : 0);
    }

    public f1(Parcelable parcelable) {
        super(parcelable);
    }
}
