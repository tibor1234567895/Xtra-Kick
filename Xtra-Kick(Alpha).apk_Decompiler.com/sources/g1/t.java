package g1;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.h;
import j1.l0;
import java.util.Arrays;
import java.util.UUID;

public final class t implements Parcelable {
    public static final Parcelable.Creator<t> CREATOR = new s();

    /* renamed from: h  reason: collision with root package name */
    public int f6566h;

    /* renamed from: i  reason: collision with root package name */
    public final UUID f6567i;

    /* renamed from: j  reason: collision with root package name */
    public final String f6568j;

    /* renamed from: k  reason: collision with root package name */
    public final String f6569k;

    /* renamed from: l  reason: collision with root package name */
    public final byte[] f6570l;

    public t(Parcel parcel) {
        this.f6567i = new UUID(parcel.readLong(), parcel.readLong());
        this.f6568j = parcel.readString();
        String readString = parcel.readString();
        int i10 = l0.f8453a;
        this.f6569k = readString;
        this.f6570l = parcel.createByteArray();
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof t)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        t tVar = (t) obj;
        return l0.a(this.f6568j, tVar.f6568j) && l0.a(this.f6569k, tVar.f6569k) && l0.a(this.f6567i, tVar.f6567i) && Arrays.equals(this.f6570l, tVar.f6570l);
    }

    public final int hashCode() {
        int i10;
        if (this.f6566h == 0) {
            int hashCode = this.f6567i.hashCode() * 31;
            String str = this.f6568j;
            if (str == null) {
                i10 = 0;
            } else {
                i10 = str.hashCode();
            }
            this.f6566h = Arrays.hashCode(this.f6570l) + h.e(this.f6569k, (hashCode + i10) * 31, 31);
        }
        return this.f6566h;
    }

    public final boolean u(UUID uuid) {
        UUID uuid2 = n.f6473a;
        UUID uuid3 = this.f6567i;
        return uuid2.equals(uuid3) || uuid.equals(uuid3);
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        UUID uuid = this.f6567i;
        parcel.writeLong(uuid.getMostSignificantBits());
        parcel.writeLong(uuid.getLeastSignificantBits());
        parcel.writeString(this.f6568j);
        parcel.writeString(this.f6569k);
        parcel.writeByteArray(this.f6570l);
    }

    public t(UUID uuid, String str, String str2, byte[] bArr) {
        uuid.getClass();
        this.f6567i = uuid;
        this.f6568j = str;
        str2.getClass();
        this.f6569k = str2;
        this.f6570l = bArr;
    }
}
