package z9;

import android.os.Parcel;
import android.os.Parcelable;
import xa.j;

public final class d implements Parcelable.Creator {
    private d() {
    }

    public /* synthetic */ d(int i10) {
        this();
    }

    public final Object createFromParcel(Parcel parcel) {
        String str;
        j.g("source", parcel);
        int readInt = parcel.readInt();
        int readInt2 = parcel.readInt();
        int readInt3 = parcel.readInt();
        long readLong = parcel.readLong();
        long readLong2 = parcel.readLong();
        String readString = parcel.readString();
        if (readString != null) {
            str = readString;
        } else {
            str = "";
        }
        String readString2 = parcel.readString();
        if (readString2 == null) {
            readString2 = "";
        }
        return new e(readInt, readInt2, readInt3, readLong, readLong2, str, readString2);
    }

    public final Object[] newArray(int i10) {
        return new e[i10];
    }
}
