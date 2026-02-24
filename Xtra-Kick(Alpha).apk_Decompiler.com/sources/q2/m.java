package q2;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class m extends c {
    public static final Parcelable.Creator<m> CREATOR = new j();

    /* renamed from: h  reason: collision with root package name */
    public final List f13320h;

    public m(Parcel parcel) {
        int readInt = parcel.readInt();
        ArrayList arrayList = new ArrayList(readInt);
        for (int i10 = 0; i10 < readInt; i10++) {
            arrayList.add(new l(parcel));
        }
        this.f13320h = Collections.unmodifiableList(arrayList);
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        List list = this.f13320h;
        int size = list.size();
        parcel.writeInt(size);
        for (int i11 = 0; i11 < size; i11++) {
            l lVar = (l) list.get(i11);
            parcel.writeLong(lVar.f13309a);
            parcel.writeByte(lVar.f13310b ? (byte) 1 : 0);
            parcel.writeByte(lVar.f13311c ? (byte) 1 : 0);
            parcel.writeByte(lVar.f13312d ? (byte) 1 : 0);
            List list2 = lVar.f13314f;
            int size2 = list2.size();
            parcel.writeInt(size2);
            for (int i12 = 0; i12 < size2; i12++) {
                k kVar = (k) list2.get(i12);
                parcel.writeInt(kVar.f13307a);
                parcel.writeLong(kVar.f13308b);
            }
            parcel.writeLong(lVar.f13313e);
            parcel.writeByte(lVar.f13315g ? (byte) 1 : 0);
            parcel.writeLong(lVar.f13316h);
            parcel.writeInt(lVar.f13317i);
            parcel.writeInt(lVar.f13318j);
            parcel.writeInt(lVar.f13319k);
        }
    }

    public m(ArrayList arrayList) {
        this.f13320h = Collections.unmodifiableList(arrayList);
    }
}
