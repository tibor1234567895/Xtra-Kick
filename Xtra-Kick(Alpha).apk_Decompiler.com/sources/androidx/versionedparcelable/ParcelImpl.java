package androidx.versionedparcelable;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import d4.a;
import d4.d;
import d4.e;

@SuppressLint({"BanParcelableUsage"})
public class ParcelImpl implements Parcelable {
    public static final Parcelable.Creator<ParcelImpl> CREATOR = new a();

    /* renamed from: h  reason: collision with root package name */
    public final e f2283h;

    public ParcelImpl(Parcel parcel) {
        this.f2283h = new d(parcel).h();
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        new d(parcel).l(this.f2283h);
    }

    public ParcelImpl(e eVar) {
        this.f2283h = eVar;
    }
}
