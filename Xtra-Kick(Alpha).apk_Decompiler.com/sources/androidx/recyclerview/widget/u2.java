package androidx.recyclerview.widget;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

public final class u2 implements Parcelable {
    public static final Parcelable.Creator<u2> CREATOR = new t2();

    /* renamed from: h  reason: collision with root package name */
    public int f2210h;

    /* renamed from: i  reason: collision with root package name */
    public int f2211i;

    /* renamed from: j  reason: collision with root package name */
    public int[] f2212j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f2213k;

    public u2() {
    }

    public u2(Parcel parcel) {
        this.f2210h = parcel.readInt();
        this.f2211i = parcel.readInt();
        this.f2213k = parcel.readInt() != 1 ? false : true;
        int readInt = parcel.readInt();
        if (readInt > 0) {
            int[] iArr = new int[readInt];
            this.f2212j = iArr;
            parcel.readIntArray(iArr);
        }
    }

    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return "FullSpanItem{mPosition=" + this.f2210h + ", mGapDir=" + this.f2211i + ", mHasUnwantedGapAfter=" + this.f2213k + ", mGapPerSpan=" + Arrays.toString(this.f2212j) + '}';
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f2210h);
        parcel.writeInt(this.f2211i);
        parcel.writeInt(this.f2213k ? 1 : 0);
        int[] iArr = this.f2212j;
        if (iArr == null || iArr.length <= 0) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(iArr.length);
        parcel.writeIntArray(this.f2212j);
    }
}
