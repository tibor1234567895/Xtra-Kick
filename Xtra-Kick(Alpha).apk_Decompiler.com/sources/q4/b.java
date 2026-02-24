package q4;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.LinkedHashMap;
import xa.j;

public final class b implements Parcelable.Creator {
    public final Object createFromParcel(Parcel parcel) {
        String readString = parcel.readString();
        j.c(readString);
        int readInt = parcel.readInt();
        LinkedHashMap linkedHashMap = new LinkedHashMap(readInt);
        for (int i10 = 0; i10 < readInt; i10++) {
            String readString2 = parcel.readString();
            j.c(readString2);
            String readString3 = parcel.readString();
            j.c(readString3);
            linkedHashMap.put(readString2, readString3);
        }
        return new d(readString, linkedHashMap);
    }

    public final Object[] newArray(int i10) {
        return new d[i10];
    }
}
