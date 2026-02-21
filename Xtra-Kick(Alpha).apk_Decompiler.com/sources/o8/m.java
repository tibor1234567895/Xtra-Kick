package o8;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import t0.c;

public final class m extends c {
    public static final Parcelable.Creator<m> CREATOR = new l();

    /* renamed from: j  reason: collision with root package name */
    public Bundle f12354j;

    public m(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.f12354j = parcel.readBundle(classLoader == null ? m.class.getClassLoader() : classLoader);
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeParcelable(this.f14484h, i10);
        parcel.writeBundle(this.f12354j);
    }

    public m(Parcelable parcelable) {
        super(parcelable);
    }
}
