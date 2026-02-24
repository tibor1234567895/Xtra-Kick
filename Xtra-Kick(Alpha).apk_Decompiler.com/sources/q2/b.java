package q2;

import android.os.Parcel;
import android.os.Parcelable;
import j1.l0;

public final class b extends c {
    public static final Parcelable.Creator<b> CREATOR = new a();

    /* renamed from: h  reason: collision with root package name */
    public final long f13285h;

    /* renamed from: i  reason: collision with root package name */
    public final long f13286i;

    /* renamed from: j  reason: collision with root package name */
    public final byte[] f13287j;

    public b(long j10, byte[] bArr, long j11) {
        this.f13285h = j11;
        this.f13286i = j10;
        this.f13287j = bArr;
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeLong(this.f13285h);
        parcel.writeLong(this.f13286i);
        parcel.writeByteArray(this.f13287j);
    }

    public b(Parcel parcel) {
        this.f13285h = parcel.readLong();
        this.f13286i = parcel.readLong();
        byte[] createByteArray = parcel.createByteArray();
        int i10 = l0.f8453a;
        this.f13287j = createByteArray;
    }
}
