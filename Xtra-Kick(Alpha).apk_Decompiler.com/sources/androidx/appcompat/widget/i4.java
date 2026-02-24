package androidx.appcompat.widget;

import android.os.Parcel;
import android.os.Parcelable;
import t0.c;

public final class i4 extends c {
    public static final Parcelable.Creator<i4> CREATOR = new h4();

    /* renamed from: j  reason: collision with root package name */
    public boolean f872j;

    public i4(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.f872j = ((Boolean) parcel.readValue((ClassLoader) null)).booleanValue();
    }

    public final String toString() {
        return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.f872j + "}";
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeParcelable(this.f14484h, i10);
        parcel.writeValue(Boolean.valueOf(this.f872j));
    }

    public i4(Parcelable parcelable) {
        super(parcelable);
    }
}
