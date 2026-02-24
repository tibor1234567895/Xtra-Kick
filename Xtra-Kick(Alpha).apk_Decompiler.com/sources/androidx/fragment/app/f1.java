package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

public final class f1 implements Parcelable {
    public static final Parcelable.Creator<f1> CREATOR = new e1();

    /* renamed from: h  reason: collision with root package name */
    public ArrayList f1419h;

    /* renamed from: i  reason: collision with root package name */
    public ArrayList f1420i;

    /* renamed from: j  reason: collision with root package name */
    public c[] f1421j;

    /* renamed from: k  reason: collision with root package name */
    public int f1422k;

    /* renamed from: l  reason: collision with root package name */
    public String f1423l = null;

    /* renamed from: m  reason: collision with root package name */
    public final ArrayList f1424m = new ArrayList();

    /* renamed from: n  reason: collision with root package name */
    public final ArrayList f1425n = new ArrayList();

    /* renamed from: o  reason: collision with root package name */
    public ArrayList f1426o;

    public f1() {
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeStringList(this.f1419h);
        parcel.writeStringList(this.f1420i);
        parcel.writeTypedArray(this.f1421j, i10);
        parcel.writeInt(this.f1422k);
        parcel.writeString(this.f1423l);
        parcel.writeStringList(this.f1424m);
        parcel.writeTypedList(this.f1425n);
        parcel.writeTypedList(this.f1426o);
    }

    public f1(Parcel parcel) {
        this.f1419h = parcel.createStringArrayList();
        this.f1420i = parcel.createStringArrayList();
        this.f1421j = (c[]) parcel.createTypedArray(c.CREATOR);
        this.f1422k = parcel.readInt();
        this.f1423l = parcel.readString();
        this.f1424m = parcel.createStringArrayList();
        this.f1425n = parcel.createTypedArrayList(e.CREATOR);
        this.f1426o = parcel.createTypedArrayList(x0.CREATOR);
    }
}
