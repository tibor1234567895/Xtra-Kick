package l2;

import android.os.Parcel;
import android.os.Parcelable;
import g1.a0;
import g1.u0;
import g1.y0;
import g1.z;
import j1.l0;
import java.util.Arrays;

public final class b implements y0 {
    public static final Parcelable.Creator<b> CREATOR = new a();

    /* renamed from: n  reason: collision with root package name */
    public static final a0 f9524n;

    /* renamed from: o  reason: collision with root package name */
    public static final a0 f9525o;

    /* renamed from: h  reason: collision with root package name */
    public final String f9526h;

    /* renamed from: i  reason: collision with root package name */
    public final String f9527i;

    /* renamed from: j  reason: collision with root package name */
    public final long f9528j;

    /* renamed from: k  reason: collision with root package name */
    public final long f9529k;

    /* renamed from: l  reason: collision with root package name */
    public final byte[] f9530l;

    /* renamed from: m  reason: collision with root package name */
    public int f9531m;

    static {
        z zVar = new z();
        zVar.f6754k = "application/id3";
        f9524n = zVar.a();
        z zVar2 = new z();
        zVar2.f6754k = "application/x-scte35";
        f9525o = zVar2.a();
    }

    public b(Parcel parcel) {
        String readString = parcel.readString();
        int i10 = l0.f8453a;
        this.f9526h = readString;
        this.f9527i = parcel.readString();
        this.f9528j = parcel.readLong();
        this.f9529k = parcel.readLong();
        this.f9530l = parcel.createByteArray();
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
        return this.f9528j == bVar.f9528j && this.f9529k == bVar.f9529k && l0.a(this.f9526h, bVar.f9526h) && l0.a(this.f9527i, bVar.f9527i) && Arrays.equals(this.f9530l, bVar.f9530l);
    }

    public final a0 g() {
        String str = this.f9526h;
        str.getClass();
        char c10 = 65535;
        switch (str.hashCode()) {
            case -1468477611:
                if (str.equals("urn:scte:scte35:2014:bin")) {
                    c10 = 0;
                    break;
                }
                break;
            case -795945609:
                if (str.equals("https://aomedia.org/emsg/ID3")) {
                    c10 = 1;
                    break;
                }
                break;
            case 1303648457:
                if (str.equals("https://developer.apple.com/streaming/emsg-id3")) {
                    c10 = 2;
                    break;
                }
                break;
        }
        switch (c10) {
            case 0:
                return f9525o;
            case 1:
            case 2:
                return f9524n;
            default:
                return null;
        }
    }

    public final /* synthetic */ void h(u0 u0Var) {
    }

    public final int hashCode() {
        if (this.f9531m == 0) {
            int i10 = 0;
            String str = this.f9526h;
            int hashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.f9527i;
            if (str2 != null) {
                i10 = str2.hashCode();
            }
            long j10 = this.f9528j;
            long j11 = this.f9529k;
            this.f9531m = Arrays.hashCode(this.f9530l) + ((((((hashCode + i10) * 31) + ((int) (j10 ^ (j10 >>> 32)))) * 31) + ((int) (j11 ^ (j11 >>> 32)))) * 31);
        }
        return this.f9531m;
    }

    public final byte[] r() {
        if (g() != null) {
            return this.f9530l;
        }
        return null;
    }

    public final String toString() {
        return "EMSG: scheme=" + this.f9526h + ", id=" + this.f9529k + ", durationMs=" + this.f9528j + ", value=" + this.f9527i;
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f9526h);
        parcel.writeString(this.f9527i);
        parcel.writeLong(this.f9528j);
        parcel.writeLong(this.f9529k);
        parcel.writeByteArray(this.f9530l);
    }

    public b(String str, String str2, long j10, long j11, byte[] bArr) {
        this.f9526h = str;
        this.f9527i = str2;
        this.f9528j = j10;
        this.f9529k = j11;
        this.f9530l = bArr;
    }
}
