package q2;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class g extends c {
    public static final Parcelable.Creator<g> CREATOR = new e();

    /* renamed from: h  reason: collision with root package name */
    public final long f13294h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f13295i;

    /* renamed from: j  reason: collision with root package name */
    public final boolean f13296j;

    /* renamed from: k  reason: collision with root package name */
    public final boolean f13297k;

    /* renamed from: l  reason: collision with root package name */
    public final boolean f13298l;

    /* renamed from: m  reason: collision with root package name */
    public final long f13299m;

    /* renamed from: n  reason: collision with root package name */
    public final long f13300n;

    /* renamed from: o  reason: collision with root package name */
    public final List f13301o;

    /* renamed from: p  reason: collision with root package name */
    public final boolean f13302p;

    /* renamed from: q  reason: collision with root package name */
    public final long f13303q;

    /* renamed from: r  reason: collision with root package name */
    public final int f13304r;

    /* renamed from: s  reason: collision with root package name */
    public final int f13305s;

    /* renamed from: t  reason: collision with root package name */
    public final int f13306t;

    public g(long j10, boolean z10, boolean z11, boolean z12, boolean z13, long j11, long j12, List list, boolean z14, long j13, int i10, int i11, int i12) {
        this.f13294h = j10;
        this.f13295i = z10;
        this.f13296j = z11;
        this.f13297k = z12;
        this.f13298l = z13;
        this.f13299m = j11;
        this.f13300n = j12;
        this.f13301o = Collections.unmodifiableList(list);
        this.f13302p = z14;
        this.f13303q = j13;
        this.f13304r = i10;
        this.f13305s = i11;
        this.f13306t = i12;
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeLong(this.f13294h);
        parcel.writeByte(this.f13295i ? (byte) 1 : 0);
        parcel.writeByte(this.f13296j ? (byte) 1 : 0);
        parcel.writeByte(this.f13297k ? (byte) 1 : 0);
        parcel.writeByte(this.f13298l ? (byte) 1 : 0);
        parcel.writeLong(this.f13299m);
        parcel.writeLong(this.f13300n);
        List list = this.f13301o;
        int size = list.size();
        parcel.writeInt(size);
        for (int i11 = 0; i11 < size; i11++) {
            f fVar = (f) list.get(i11);
            parcel.writeInt(fVar.f13291a);
            parcel.writeLong(fVar.f13292b);
            parcel.writeLong(fVar.f13293c);
        }
        parcel.writeByte(this.f13302p ? (byte) 1 : 0);
        parcel.writeLong(this.f13303q);
        parcel.writeInt(this.f13304r);
        parcel.writeInt(this.f13305s);
        parcel.writeInt(this.f13306t);
    }

    public g(Parcel parcel) {
        this.f13294h = parcel.readLong();
        boolean z10 = false;
        this.f13295i = parcel.readByte() == 1;
        this.f13296j = parcel.readByte() == 1;
        this.f13297k = parcel.readByte() == 1;
        this.f13298l = parcel.readByte() == 1;
        this.f13299m = parcel.readLong();
        this.f13300n = parcel.readLong();
        int readInt = parcel.readInt();
        ArrayList arrayList = new ArrayList(readInt);
        for (int i10 = 0; i10 < readInt; i10++) {
            arrayList.add(new f(parcel.readInt(), parcel.readLong(), parcel.readLong()));
        }
        this.f13301o = Collections.unmodifiableList(arrayList);
        this.f13302p = parcel.readByte() == 1 ? true : z10;
        this.f13303q = parcel.readLong();
        this.f13304r = parcel.readInt();
        this.f13305s = parcel.readInt();
        this.f13306t = parcel.readInt();
    }
}
