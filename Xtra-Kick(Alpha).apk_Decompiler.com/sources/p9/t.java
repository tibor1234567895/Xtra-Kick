package p9;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
import java.util.Map;
import la.q;
import ma.j0;
import xa.j;

public final class t implements Parcelable.Creator {
    private t() {
    }

    public /* synthetic */ t(int i10) {
        this();
    }

    public final Object createFromParcel(Parcel parcel) {
        j.g("input", parcel);
        String readString = parcel.readString();
        String str = "";
        if (readString == null) {
            readString = str;
        }
        String readString2 = parcel.readString();
        if (readString2 != null) {
            str = readString2;
        }
        long readLong = parcel.readLong();
        int readInt = parcel.readInt();
        Serializable readSerializable = parcel.readSerializable();
        if (readSerializable != null) {
            Map map = (Map) readSerializable;
            q qVar = r.f12714m;
            int readInt2 = parcel.readInt();
            qVar.getClass();
            r a10 = q.a(readInt2);
            o oVar = p.f12708n;
            int readInt3 = parcel.readInt();
            oVar.getClass();
            p a11 = o.a(readInt3);
            String readString3 = parcel.readString();
            c cVar = d.f12635n;
            int readInt4 = parcel.readInt();
            cVar.getClass();
            d a12 = c.a(readInt4);
            boolean z10 = true;
            if (parcel.readInt() != 1) {
                z10 = false;
            }
            Serializable readSerializable2 = parcel.readSerializable();
            if (readSerializable2 != null) {
                Map map2 = (Map) readSerializable2;
                int readInt5 = parcel.readInt();
                u uVar = new u(readString, str);
                uVar.f12722h = readLong;
                uVar.f12723i = readInt;
                for (Map.Entry entry : map.entrySet()) {
                    String str2 = (String) entry.getKey();
                    String str3 = (String) entry.getValue();
                    j.g("key", str2);
                    j.g("value", str3);
                    uVar.f12724j.put(str2, str3);
                }
                uVar.f12725k = a10;
                uVar.f12726l = a11;
                uVar.f12727m = readString3;
                uVar.f12728n = a12;
                uVar.f12729o = z10;
                uVar.f12731q = new y9.j(j0.g(new y9.j(map2).f17264h));
                if (readInt5 >= 0) {
                    uVar.f12730p = readInt5;
                    return uVar;
                }
                throw new IllegalArgumentException("The maximum number of attempts has to be greater than -1");
            }
            throw new q("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
        }
        throw new q("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
    }

    public final Object[] newArray(int i10) {
        return new u[i10];
    }
}
