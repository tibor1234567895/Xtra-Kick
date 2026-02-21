package z9;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
import java.util.HashMap;
import la.q;
import xa.j;

public final class b implements Parcelable.Creator {
    private b() {
    }

    public /* synthetic */ b(int i10) {
        this();
    }

    public final Object createFromParcel(Parcel parcel) {
        String str;
        String str2;
        String str3;
        boolean z10;
        j.g("source", parcel);
        int readInt = parcel.readInt();
        String readString = parcel.readString();
        if (readString != null) {
            str = readString;
        } else {
            str = "";
        }
        long readLong = parcel.readLong();
        long readLong2 = parcel.readLong();
        String readString2 = parcel.readString();
        if (readString2 != null) {
            str2 = readString2;
        } else {
            str2 = "";
        }
        String readString3 = parcel.readString();
        if (readString3 != null) {
            str3 = readString3;
        } else {
            str3 = "";
        }
        Serializable readSerializable = parcel.readSerializable();
        if (readSerializable != null) {
            y9.j jVar = new y9.j((HashMap) readSerializable);
            int readInt2 = parcel.readInt();
            int readInt3 = parcel.readInt();
            if (parcel.readInt() == 1) {
                z10 = true;
            } else {
                z10 = false;
            }
            return new c(readInt, str, readLong, readLong2, str2, str3, jVar, readInt2, readInt3, z10);
        }
        throw new q("null cannot be cast to non-null type kotlin.collections.HashMap<kotlin.String, kotlin.String> /* = java.util.HashMap<kotlin.String, kotlin.String> */");
    }

    public final Object[] newArray(int i10) {
        return new c[i10];
    }
}
