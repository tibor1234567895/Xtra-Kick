package z;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import t0.c;

public final class h extends c {
    public static final Parcelable.Creator<h> CREATOR = new g();

    /* renamed from: j  reason: collision with root package name */
    public SparseArray f17341j;

    public h(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        int readInt = parcel.readInt();
        int[] iArr = new int[readInt];
        parcel.readIntArray(iArr);
        Parcelable[] readParcelableArray = parcel.readParcelableArray(classLoader);
        this.f17341j = new SparseArray(readInt);
        for (int i10 = 0; i10 < readInt; i10++) {
            this.f17341j.append(iArr[i10], readParcelableArray[i10]);
        }
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        int i11;
        parcel.writeParcelable(this.f14484h, i10);
        SparseArray sparseArray = this.f17341j;
        if (sparseArray != null) {
            i11 = sparseArray.size();
        } else {
            i11 = 0;
        }
        parcel.writeInt(i11);
        int[] iArr = new int[i11];
        Parcelable[] parcelableArr = new Parcelable[i11];
        for (int i12 = 0; i12 < i11; i12++) {
            iArr[i12] = this.f17341j.keyAt(i12);
            parcelableArr[i12] = (Parcelable) this.f17341j.valueAt(i12);
        }
        parcel.writeIntArray(iArr);
        parcel.writeParcelableArray(parcelableArr, i10);
    }

    public h(Parcelable parcelable) {
        super(parcelable);
    }
}
