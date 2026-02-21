package q9;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
import java.util.Map;
import p9.c;
import p9.e;
import p9.f;
import p9.o;
import p9.p;
import p9.q;
import p9.r;
import p9.w;
import p9.x;
import xa.j;

public final class d implements Parcelable.Creator {
    private d() {
    }

    public /* synthetic */ d(int i10) {
        this();
    }

    public final Object createFromParcel(Parcel parcel) {
        boolean z10;
        j.g("source", parcel);
        int readInt = parcel.readInt();
        String readString = parcel.readString();
        String str = "";
        if (readString == null) {
            readString = str;
        }
        String readString2 = parcel.readString();
        if (readString2 == null) {
            readString2 = str;
        }
        String readString3 = parcel.readString();
        if (readString3 != null) {
            str = readString3;
        }
        int readInt2 = parcel.readInt();
        q qVar = r.f12714m;
        int readInt3 = parcel.readInt();
        qVar.getClass();
        r a10 = q.a(readInt3);
        Serializable readSerializable = parcel.readSerializable();
        if (readSerializable != null) {
            Map map = (Map) readSerializable;
            long readLong = parcel.readLong();
            long readLong2 = parcel.readLong();
            w wVar = x.f12743t;
            int readInt4 = parcel.readInt();
            wVar.getClass();
            x a11 = w.a(readInt4);
            e eVar = f.O;
            int readInt5 = parcel.readInt();
            eVar.getClass();
            f a12 = e.a(readInt5);
            o oVar = p.f12708n;
            int readInt6 = parcel.readInt();
            oVar.getClass();
            p a13 = o.a(readInt6);
            f fVar = a12;
            p pVar = a13;
            long readLong3 = parcel.readLong();
            String readString4 = parcel.readString();
            c cVar = p9.d.f12635n;
            int readInt7 = parcel.readInt();
            cVar.getClass();
            String str2 = "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>";
            p9.d a14 = c.a(readInt7);
            long j10 = readLong3;
            long readLong4 = parcel.readLong();
            if (parcel.readInt() == 1) {
                z10 = true;
            } else {
                z10 = false;
            }
            long readLong5 = parcel.readLong();
            long readLong6 = parcel.readLong();
            Serializable readSerializable2 = parcel.readSerializable();
            if (readSerializable2 != null) {
                int readInt8 = parcel.readInt();
                int readInt9 = parcel.readInt();
                e eVar2 = new e();
                eVar2.f13433h = readInt;
                eVar2.H(readString);
                eVar2.M(readString2);
                eVar2.G(str);
                eVar2.f13437l = readInt2;
                eVar2.J(a10);
                eVar2.f13439n = map;
                eVar2.f13440o = readLong;
                eVar2.f13441p = readLong2;
                eVar2.K(a11);
                eVar2.D(fVar);
                eVar2.I(pVar);
                eVar2.f13445t = j10;
                eVar2.f13446u = readString4;
                eVar2.C(a14);
                eVar2.f13448w = readLong4;
                eVar2.f13449x = z10;
                eVar2.B = readLong5;
                eVar2.C = readLong6;
                eVar2.F(new y9.j((Map) readSerializable2));
                eVar2.f13451z = readInt8;
                eVar2.A = readInt9;
                return eVar2;
            }
            throw new la.q(str2);
        }
        throw new la.q("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
    }

    public final Object[] newArray(int i10) {
        return new e[i10];
    }
}
