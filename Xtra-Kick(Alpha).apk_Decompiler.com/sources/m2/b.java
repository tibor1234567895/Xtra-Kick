package m2;

import android.os.Parcel;
import android.os.Parcelable;
import c9.h;
import g1.a0;
import g1.u0;
import g1.y0;
import j1.b0;
import j1.l0;
import java.util.Arrays;

public final class b implements y0 {
    public static final Parcelable.Creator<b> CREATOR = new a();

    /* renamed from: h  reason: collision with root package name */
    public final int f10556h;

    /* renamed from: i  reason: collision with root package name */
    public final String f10557i;

    /* renamed from: j  reason: collision with root package name */
    public final String f10558j;

    /* renamed from: k  reason: collision with root package name */
    public final int f10559k;

    /* renamed from: l  reason: collision with root package name */
    public final int f10560l;

    /* renamed from: m  reason: collision with root package name */
    public final int f10561m;

    /* renamed from: n  reason: collision with root package name */
    public final int f10562n;

    /* renamed from: o  reason: collision with root package name */
    public final byte[] f10563o;

    public b(int i10, String str, String str2, int i11, int i12, int i13, int i14, byte[] bArr) {
        this.f10556h = i10;
        this.f10557i = str;
        this.f10558j = str2;
        this.f10559k = i11;
        this.f10560l = i12;
        this.f10561m = i13;
        this.f10562n = i14;
        this.f10563o = bArr;
    }

    public static b u(b0 b0Var) {
        int f10 = b0Var.f();
        String t10 = b0Var.t(b0Var.f(), h.f3033a);
        String s10 = b0Var.s(b0Var.f());
        int f11 = b0Var.f();
        int f12 = b0Var.f();
        int f13 = b0Var.f();
        int f14 = b0Var.f();
        int f15 = b0Var.f();
        byte[] bArr = new byte[f15];
        b0Var.d(bArr, 0, f15);
        return new b(f10, t10, s10, f11, f12, f13, f14, bArr);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return this.f10556h == bVar.f10556h && this.f10557i.equals(bVar.f10557i) && this.f10558j.equals(bVar.f10558j) && this.f10559k == bVar.f10559k && this.f10560l == bVar.f10560l && this.f10561m == bVar.f10561m && this.f10562n == bVar.f10562n && Arrays.equals(this.f10563o, bVar.f10563o);
    }

    public final /* synthetic */ a0 g() {
        return null;
    }

    public final void h(u0 u0Var) {
        u0Var.a(this.f10556h, this.f10563o);
    }

    public final int hashCode() {
        int e10 = android.support.v4.media.h.e(this.f10557i, (this.f10556h + 527) * 31, 31);
        return Arrays.hashCode(this.f10563o) + ((((((((android.support.v4.media.h.e(this.f10558j, e10, 31) + this.f10559k) * 31) + this.f10560l) * 31) + this.f10561m) * 31) + this.f10562n) * 31);
    }

    public final /* synthetic */ byte[] r() {
        return null;
    }

    public final String toString() {
        return "Picture: mimeType=" + this.f10557i + ", description=" + this.f10558j;
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f10556h);
        parcel.writeString(this.f10557i);
        parcel.writeString(this.f10558j);
        parcel.writeInt(this.f10559k);
        parcel.writeInt(this.f10560l);
        parcel.writeInt(this.f10561m);
        parcel.writeInt(this.f10562n);
        parcel.writeByteArray(this.f10563o);
    }

    public b(Parcel parcel) {
        this.f10556h = parcel.readInt();
        String readString = parcel.readString();
        int i10 = l0.f8453a;
        this.f10557i = readString;
        this.f10558j = parcel.readString();
        this.f10559k = parcel.readInt();
        this.f10560l = parcel.readInt();
        this.f10561m = parcel.readInt();
        this.f10562n = parcel.readInt();
        this.f10563o = parcel.createByteArray();
    }
}
