package androidx.fragment.app;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public final class b0 implements Parcelable {
    public static final Parcelable.Creator<b0> CREATOR = new a0();

    /* renamed from: h  reason: collision with root package name */
    public final Bundle f1328h;

    public b0(Bundle bundle) {
        this.f1328h = bundle;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeBundle(this.f1328h);
    }

    public b0(Parcel parcel, ClassLoader classLoader) {
        Bundle readBundle = parcel.readBundle();
        this.f1328h = readBundle;
        if (classLoader != null && readBundle != null) {
            readBundle.setClassLoader(classLoader);
        }
    }
}
