package w2;

import android.os.Bundle;
import android.os.Parcel;
import j1.c;
import java.util.ArrayList;
import java.util.List;

public final class b {
    public static byte[] a(List list) {
        ArrayList b10 = c.b(list);
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("c", b10);
        Parcel obtain = Parcel.obtain();
        obtain.writeBundle(bundle);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        return marshall;
    }
}
