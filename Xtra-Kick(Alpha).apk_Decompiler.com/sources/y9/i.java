package y9;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
import java.util.HashMap;
import la.q;
import xa.j;

public final class i implements Parcelable.Creator {
    private i() {
    }

    public /* synthetic */ i(int i10) {
        this();
    }

    public final Object createFromParcel(Parcel parcel) {
        j.g("source", parcel);
        Serializable readSerializable = parcel.readSerializable();
        if (readSerializable != null) {
            return new j((HashMap) readSerializable);
        }
        throw new q("null cannot be cast to non-null type kotlin.collections.HashMap<kotlin.String, kotlin.String> /* = java.util.HashMap<kotlin.String, kotlin.String> */");
    }

    public final Object[] newArray(int i10) {
        return new j[i10];
    }
}
