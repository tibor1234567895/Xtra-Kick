package h4;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

public final class q extends View.BaseSavedState {
    public static final Parcelable.Creator<q> CREATOR = new p();

    /* renamed from: h  reason: collision with root package name */
    public int f7544h;

    /* renamed from: i  reason: collision with root package name */
    public int f7545i;

    /* renamed from: j  reason: collision with root package name */
    public Parcelable f7546j;

    public q(Parcel parcel) {
        super(parcel);
        this.f7544h = parcel.readInt();
        this.f7545i = parcel.readInt();
        this.f7546j = parcel.readParcelable((ClassLoader) null);
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeInt(this.f7544h);
        parcel.writeInt(this.f7545i);
        parcel.writeParcelable(this.f7546j, i10);
    }

    public q(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.f7544h = parcel.readInt();
        this.f7545i = parcel.readInt();
        this.f7546j = parcel.readParcelable(classLoader);
    }

    public q(Parcelable parcelable) {
        super(parcelable);
    }
}
