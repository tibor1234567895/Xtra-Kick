package t0;

import android.os.Parcel;
import android.os.Parcelable;

public abstract class c implements Parcelable {
    public static final Parcelable.Creator<c> CREATOR = new b();

    /* renamed from: i  reason: collision with root package name */
    public static final a f14483i = new a();

    /* renamed from: h  reason: collision with root package name */
    public final Parcelable f14484h;

    private c() {
        this.f14484h = null;
    }

    public final int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeParcelable(this.f14484h, i10);
    }

    public /* synthetic */ c(int i10) {
        this();
    }

    public c(Parcel parcel, ClassLoader classLoader) {
        Parcelable readParcelable = parcel.readParcelable(classLoader);
        this.f14484h = readParcelable == null ? f14483i : readParcelable;
    }

    public c(Parcelable parcelable) {
        if (parcelable != null) {
            this.f14484h = parcelable == f14483i ? null : parcelable;
            return;
        }
        throw new IllegalArgumentException("superState must not be null");
    }
}
