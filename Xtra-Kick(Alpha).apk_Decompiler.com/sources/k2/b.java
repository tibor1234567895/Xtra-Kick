package k2;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.h;
import g1.a0;
import g1.u0;
import g1.y0;

public final class b implements y0 {
    public static final Parcelable.Creator<b> CREATOR = new a();

    /* renamed from: h  reason: collision with root package name */
    public final int f9072h;

    /* renamed from: i  reason: collision with root package name */
    public final String f9073i;

    public b(int i10, String str) {
        this.f9072h = i10;
        this.f9073i = str;
    }

    public final int describeContents() {
        return 0;
    }

    public final /* synthetic */ a0 g() {
        return null;
    }

    public final /* synthetic */ void h(u0 u0Var) {
    }

    public final /* synthetic */ byte[] r() {
        return null;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("Ait(controlCode=");
        sb2.append(this.f9072h);
        sb2.append(",url=");
        return h.p(sb2, this.f9073i, ")");
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f9073i);
        parcel.writeInt(this.f9072h);
    }
}
