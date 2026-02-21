package d4;

import android.os.Parcel;
import android.support.v4.media.h;
import android.util.SparseIntArray;
import q.e;

public final class d extends c {

    /* renamed from: d  reason: collision with root package name */
    public final SparseIntArray f4328d;

    /* renamed from: e  reason: collision with root package name */
    public final Parcel f4329e;

    /* renamed from: f  reason: collision with root package name */
    public final int f4330f;

    /* renamed from: g  reason: collision with root package name */
    public final int f4331g;

    /* renamed from: h  reason: collision with root package name */
    public final String f4332h;

    /* renamed from: i  reason: collision with root package name */
    public int f4333i;

    /* renamed from: j  reason: collision with root package name */
    public int f4334j;

    /* renamed from: k  reason: collision with root package name */
    public int f4335k;

    public d(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", new e(), new e(), new e());
    }

    public final d a() {
        Parcel parcel = this.f4329e;
        int dataPosition = parcel.dataPosition();
        int i10 = this.f4334j;
        if (i10 == this.f4330f) {
            i10 = this.f4331g;
        }
        return new d(parcel, dataPosition, i10, h.p(new StringBuilder(), this.f4332h, "  "), this.f4325a, this.f4326b, this.f4327c);
    }

    public final boolean e(int i10) {
        while (this.f4334j < this.f4331g) {
            int i11 = this.f4335k;
            if (i11 == i10) {
                return true;
            }
            if (String.valueOf(i11).compareTo(String.valueOf(i10)) > 0) {
                return false;
            }
            int i12 = this.f4334j;
            Parcel parcel = this.f4329e;
            parcel.setDataPosition(i12);
            int readInt = parcel.readInt();
            this.f4335k = parcel.readInt();
            this.f4334j += readInt;
        }
        return this.f4335k == i10;
    }

    public final void i(int i10) {
        int i11 = this.f4333i;
        SparseIntArray sparseIntArray = this.f4328d;
        Parcel parcel = this.f4329e;
        if (i11 >= 0) {
            int i12 = sparseIntArray.get(i11);
            int dataPosition = parcel.dataPosition();
            parcel.setDataPosition(i12);
            parcel.writeInt(dataPosition - i12);
            parcel.setDataPosition(dataPosition);
        }
        this.f4333i = i10;
        sparseIntArray.put(i10, parcel.dataPosition());
        parcel.writeInt(0);
        parcel.writeInt(i10);
    }

    public d(Parcel parcel, int i10, int i11, String str, e eVar, e eVar2, e eVar3) {
        super(eVar, eVar2, eVar3);
        this.f4328d = new SparseIntArray();
        this.f4333i = -1;
        this.f4335k = -1;
        this.f4329e = parcel;
        this.f4330f = i10;
        this.f4331g = i11;
        this.f4334j = i10;
        this.f4332h = str;
    }
}
