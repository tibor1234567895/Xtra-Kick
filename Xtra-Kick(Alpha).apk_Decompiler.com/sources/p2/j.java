package p2;

import android.os.Parcel;
import android.os.Parcelable;
import g1.a0;
import g1.u0;
import g1.y0;

public final class j implements y0 {
    public static final Parcelable.Creator<j> CREATOR = new i();

    /* renamed from: h  reason: collision with root package name */
    public final float f12524h;

    /* renamed from: i  reason: collision with root package name */
    public final int f12525i;

    public j(int i10, float f10) {
        this.f12524h = f10;
        this.f12525i = i10;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || j.class != obj.getClass()) {
            return false;
        }
        j jVar = (j) obj;
        return this.f12524h == jVar.f12524h && this.f12525i == jVar.f12525i;
    }

    public final /* synthetic */ a0 g() {
        return null;
    }

    public final /* synthetic */ void h(u0 u0Var) {
    }

    public final int hashCode() {
        return ((Float.valueOf(this.f12524h).hashCode() + 527) * 31) + this.f12525i;
    }

    public final /* synthetic */ byte[] r() {
        return null;
    }

    public final String toString() {
        return "smta: captureFrameRate=" + this.f12524h + ", svcTemporalLayerCount=" + this.f12525i;
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeFloat(this.f12524h);
        parcel.writeInt(this.f12525i);
    }

    public j(Parcel parcel) {
        this.f12524h = parcel.readFloat();
        this.f12525i = parcel.readInt();
    }
}
