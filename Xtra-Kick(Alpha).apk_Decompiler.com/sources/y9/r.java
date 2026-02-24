package y9;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
import java.util.HashMap;
import la.q;
import ma.j0;
import xa.j;

public final class r implements Parcelable.Creator {
    private r() {
    }

    public /* synthetic */ r(int i10) {
        this();
    }

    public final Object createFromParcel(Parcel parcel) {
        j.g("source", parcel);
        Serializable readSerializable = parcel.readSerializable();
        if (readSerializable != null) {
            return new s(j0.i((HashMap) readSerializable));
        }
        throw new q("null cannot be cast to non-null type kotlin.collections.HashMap<kotlin.String, kotlin.String> /* = java.util.HashMap<kotlin.String, kotlin.String> */");
    }

    public final Object[] newArray(int i10) {
        return new s[i10];
    }
}
