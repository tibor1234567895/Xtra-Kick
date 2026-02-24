package q2;

import android.os.Parcel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class l {

    /* renamed from: a  reason: collision with root package name */
    public final long f13309a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f13310b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f13311c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f13312d;

    /* renamed from: e  reason: collision with root package name */
    public final long f13313e;

    /* renamed from: f  reason: collision with root package name */
    public final List f13314f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f13315g;

    /* renamed from: h  reason: collision with root package name */
    public final long f13316h;

    /* renamed from: i  reason: collision with root package name */
    public final int f13317i;

    /* renamed from: j  reason: collision with root package name */
    public final int f13318j;

    /* renamed from: k  reason: collision with root package name */
    public final int f13319k;

    public l(long j10, boolean z10, boolean z11, boolean z12, ArrayList arrayList, long j11, boolean z13, long j12, int i10, int i11, int i12) {
        this.f13309a = j10;
        this.f13310b = z10;
        this.f13311c = z11;
        this.f13312d = z12;
        this.f13314f = Collections.unmodifiableList(arrayList);
        this.f13313e = j11;
        this.f13315g = z13;
        this.f13316h = j12;
        this.f13317i = i10;
        this.f13318j = i11;
        this.f13319k = i12;
    }

    public l(Parcel parcel) {
        this.f13309a = parcel.readLong();
        boolean z10 = false;
        this.f13310b = parcel.readByte() == 1;
        this.f13311c = parcel.readByte() == 1;
        this.f13312d = parcel.readByte() == 1;
        int readInt = parcel.readInt();
        ArrayList arrayList = new ArrayList(readInt);
        for (int i10 = 0; i10 < readInt; i10++) {
            arrayList.add(new k(parcel.readInt(), parcel.readLong()));
        }
        this.f13314f = Collections.unmodifiableList(arrayList);
        this.f13313e = parcel.readLong();
        this.f13315g = parcel.readByte() == 1 ? true : z10;
        this.f13316h = parcel.readLong();
        this.f13317i = parcel.readInt();
        this.f13318j = parcel.readInt();
        this.f13319k = parcel.readInt();
    }
}
