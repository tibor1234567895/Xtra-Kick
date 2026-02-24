package w8;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import q.k;
import t0.c;

public final class b extends c {
    public static final Parcelable.Creator<b> CREATOR = new a();

    /* renamed from: j  reason: collision with root package name */
    public final k f16170j;

    public b(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        int readInt = parcel.readInt();
        String[] strArr = new String[readInt];
        parcel.readStringArray(strArr);
        Bundle[] bundleArr = new Bundle[readInt];
        parcel.readTypedArray(bundleArr, Bundle.CREATOR);
        this.f16170j = new k(readInt);
        for (int i10 = 0; i10 < readInt; i10++) {
            this.f16170j.put(strArr[i10], bundleArr[i10]);
        }
    }

    public final String toString() {
        return "ExtendableSavedState{" + Integer.toHexString(System.identityHashCode(this)) + " states=" + this.f16170j + "}";
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeParcelable(this.f14484h, i10);
        k kVar = this.f16170j;
        int i11 = kVar.f13081j;
        parcel.writeInt(i11);
        String[] strArr = new String[i11];
        Bundle[] bundleArr = new Bundle[i11];
        for (int i12 = 0; i12 < i11; i12++) {
            strArr[i12] = (String) kVar.h(i12);
            bundleArr[i12] = (Bundle) kVar.l(i12);
        }
        parcel.writeStringArray(strArr);
        parcel.writeTypedArray(bundleArr, 0);
    }

    public b(Parcelable parcelable) {
        super(parcelable);
        this.f16170j = new k();
    }
}
