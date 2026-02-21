package p2;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

public final class e implements Parcelable.Creator {
    public final Object createFromParcel(Parcel parcel) {
        ArrayList arrayList = new ArrayList();
        parcel.readList(arrayList, g.class.getClassLoader());
        return new h(arrayList);
    }

    public final Object[] newArray(int i10) {
        return new h[i10];
    }
}
