package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.lifecycle.s;

public final class l1 implements Parcelable {
    public static final Parcelable.Creator<l1> CREATOR = new k1();

    /* renamed from: h  reason: collision with root package name */
    public final String f1480h;

    /* renamed from: i  reason: collision with root package name */
    public final String f1481i;

    /* renamed from: j  reason: collision with root package name */
    public final boolean f1482j;

    /* renamed from: k  reason: collision with root package name */
    public final int f1483k;

    /* renamed from: l  reason: collision with root package name */
    public final int f1484l;

    /* renamed from: m  reason: collision with root package name */
    public final String f1485m;

    /* renamed from: n  reason: collision with root package name */
    public final boolean f1486n;

    /* renamed from: o  reason: collision with root package name */
    public final boolean f1487o;

    /* renamed from: p  reason: collision with root package name */
    public final boolean f1488p;

    /* renamed from: q  reason: collision with root package name */
    public final boolean f1489q;

    /* renamed from: r  reason: collision with root package name */
    public final int f1490r;

    /* renamed from: s  reason: collision with root package name */
    public final String f1491s;

    /* renamed from: t  reason: collision with root package name */
    public final int f1492t;

    /* renamed from: u  reason: collision with root package name */
    public final boolean f1493u;

    public l1(Parcel parcel) {
        this.f1480h = parcel.readString();
        this.f1481i = parcel.readString();
        boolean z10 = true;
        this.f1482j = parcel.readInt() != 0;
        this.f1483k = parcel.readInt();
        this.f1484l = parcel.readInt();
        this.f1485m = parcel.readString();
        this.f1486n = parcel.readInt() != 0;
        this.f1487o = parcel.readInt() != 0;
        this.f1488p = parcel.readInt() != 0;
        this.f1489q = parcel.readInt() != 0;
        this.f1490r = parcel.readInt();
        this.f1491s = parcel.readString();
        this.f1492t = parcel.readInt();
        this.f1493u = parcel.readInt() == 0 ? false : z10;
    }

    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append("FragmentState{");
        sb2.append(this.f1480h);
        sb2.append(" (");
        sb2.append(this.f1481i);
        sb2.append(")}:");
        if (this.f1482j) {
            sb2.append(" fromLayout");
        }
        int i10 = this.f1484l;
        if (i10 != 0) {
            sb2.append(" id=0x");
            sb2.append(Integer.toHexString(i10));
        }
        String str = this.f1485m;
        if (str != null && !str.isEmpty()) {
            sb2.append(" tag=");
            sb2.append(str);
        }
        if (this.f1486n) {
            sb2.append(" retainInstance");
        }
        if (this.f1487o) {
            sb2.append(" removing");
        }
        if (this.f1488p) {
            sb2.append(" detached");
        }
        if (this.f1489q) {
            sb2.append(" hidden");
        }
        String str2 = this.f1491s;
        if (str2 != null) {
            sb2.append(" targetWho=");
            sb2.append(str2);
            sb2.append(" targetRequestCode=");
            sb2.append(this.f1492t);
        }
        if (this.f1493u) {
            sb2.append(" userVisibleHint");
        }
        return sb2.toString();
    }

    public final c0 u(j0 j0Var, ClassLoader classLoader) {
        c0 a10 = j0Var.a(classLoader, this.f1480h);
        a10.f1356l = this.f1481i;
        a10.f1365u = this.f1482j;
        a10.f1367w = true;
        a10.D = this.f1483k;
        a10.E = this.f1484l;
        a10.F = this.f1485m;
        a10.I = this.f1486n;
        a10.f1363s = this.f1487o;
        a10.H = this.f1488p;
        a10.G = this.f1489q;
        a10.U = s.values()[this.f1490r];
        a10.f1359o = this.f1491s;
        a10.f1360p = this.f1492t;
        a10.O = this.f1493u;
        return a10;
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f1480h);
        parcel.writeString(this.f1481i);
        parcel.writeInt(this.f1482j ? 1 : 0);
        parcel.writeInt(this.f1483k);
        parcel.writeInt(this.f1484l);
        parcel.writeString(this.f1485m);
        parcel.writeInt(this.f1486n ? 1 : 0);
        parcel.writeInt(this.f1487o ? 1 : 0);
        parcel.writeInt(this.f1488p ? 1 : 0);
        parcel.writeInt(this.f1489q ? 1 : 0);
        parcel.writeInt(this.f1490r);
        parcel.writeString(this.f1491s);
        parcel.writeInt(this.f1492t);
        parcel.writeInt(this.f1493u ? 1 : 0);
    }

    public l1(c0 c0Var) {
        this.f1480h = c0Var.getClass().getName();
        this.f1481i = c0Var.f1356l;
        this.f1482j = c0Var.f1365u;
        this.f1483k = c0Var.D;
        this.f1484l = c0Var.E;
        this.f1485m = c0Var.F;
        this.f1486n = c0Var.I;
        this.f1487o = c0Var.f1363s;
        this.f1488p = c0Var.H;
        this.f1489q = c0Var.G;
        this.f1490r = c0Var.U.ordinal();
        this.f1491s = c0Var.f1359o;
        this.f1492t = c0Var.f1360p;
        this.f1493u = c0Var.O;
    }
}
