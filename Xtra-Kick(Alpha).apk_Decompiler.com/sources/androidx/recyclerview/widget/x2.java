package androidx.recyclerview.widget;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

public final class x2 implements Parcelable {
    public static final Parcelable.Creator<x2> CREATOR = new w2();

    /* renamed from: h  reason: collision with root package name */
    public int f2235h;

    /* renamed from: i  reason: collision with root package name */
    public int f2236i;

    /* renamed from: j  reason: collision with root package name */
    public int f2237j;

    /* renamed from: k  reason: collision with root package name */
    public int[] f2238k;

    /* renamed from: l  reason: collision with root package name */
    public int f2239l;

    /* renamed from: m  reason: collision with root package name */
    public int[] f2240m;

    /* renamed from: n  reason: collision with root package name */
    public List f2241n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f2242o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f2243p;

    /* renamed from: q  reason: collision with root package name */
    public boolean f2244q;

    public x2() {
    }

    public x2(Parcel parcel) {
        this.f2235h = parcel.readInt();
        this.f2236i = parcel.readInt();
        int readInt = parcel.readInt();
        this.f2237j = readInt;
        if (readInt > 0) {
            int[] iArr = new int[readInt];
            this.f2238k = iArr;
            parcel.readIntArray(iArr);
        }
        int readInt2 = parcel.readInt();
        this.f2239l = readInt2;
        if (readInt2 > 0) {
            int[] iArr2 = new int[readInt2];
            this.f2240m = iArr2;
            parcel.readIntArray(iArr2);
        }
        boolean z10 = false;
        this.f2242o = parcel.readInt() == 1;
        this.f2243p = parcel.readInt() == 1;
        this.f2244q = parcel.readInt() == 1 ? true : z10;
        this.f2241n = parcel.readArrayList(u2.class.getClassLoader());
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f2235h);
        parcel.writeInt(this.f2236i);
        parcel.writeInt(this.f2237j);
        if (this.f2237j > 0) {
            parcel.writeIntArray(this.f2238k);
        }
        parcel.writeInt(this.f2239l);
        if (this.f2239l > 0) {
            parcel.writeIntArray(this.f2240m);
        }
        parcel.writeInt(this.f2242o ? 1 : 0);
        parcel.writeInt(this.f2243p ? 1 : 0);
        parcel.writeInt(this.f2244q ? 1 : 0);
        parcel.writeList(this.f2241n);
    }

    public x2(x2 x2Var) {
        this.f2237j = x2Var.f2237j;
        this.f2235h = x2Var.f2235h;
        this.f2236i = x2Var.f2236i;
        this.f2238k = x2Var.f2238k;
        this.f2239l = x2Var.f2239l;
        this.f2240m = x2Var.f2240m;
        this.f2242o = x2Var.f2242o;
        this.f2243p = x2Var.f2243p;
        this.f2244q = x2Var.f2244q;
        this.f2241n = x2Var.f2241n;
    }
}
