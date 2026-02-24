package androidx.recyclerview.widget;

import android.os.Parcel;
import android.os.Parcelable;
import t0.c;

public final class c2 extends c {
    public static final Parcelable.Creator<c2> CREATOR = new b2();

    /* renamed from: j  reason: collision with root package name */
    public Parcelable f1954j;

    public c2(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.f1954j = parcel.readParcelable(classLoader == null ? q1.class.getClassLoader() : classLoader);
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeParcelable(this.f14484h, i10);
        parcel.writeParcelable(this.f1954j, 0);
    }

    public c2(Parcelable parcelable) {
        super(parcelable);
    }
}
