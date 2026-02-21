package g1;

import android.os.Parcel;
import android.os.Parcelable;
import j1.l0;
import java.util.Arrays;
import java.util.Comparator;
import java.util.UUID;

public final class u implements Comparator, Parcelable {
    public static final Parcelable.Creator<u> CREATOR = new r();

    /* renamed from: h  reason: collision with root package name */
    public final t[] f6592h;

    /* renamed from: i  reason: collision with root package name */
    public int f6593i;

    /* renamed from: j  reason: collision with root package name */
    public final String f6594j;

    /* renamed from: k  reason: collision with root package name */
    public final int f6595k;

    public u(Parcel parcel) {
        this.f6594j = parcel.readString();
        t[] tVarArr = (t[]) parcel.createTypedArray(t.CREATOR);
        int i10 = l0.f8453a;
        this.f6592h = tVarArr;
        this.f6595k = tVarArr.length;
    }

    public final int compare(Object obj, Object obj2) {
        t tVar = (t) obj;
        t tVar2 = (t) obj2;
        UUID uuid = n.f6473a;
        if (!uuid.equals(tVar.f6567i)) {
            return tVar.f6567i.compareTo(tVar2.f6567i);
        }
        if (uuid.equals(tVar2.f6567i)) {
            return 0;
        }
        return 1;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || u.class != obj.getClass()) {
            return false;
        }
        u uVar = (u) obj;
        return l0.a(this.f6594j, uVar.f6594j) && Arrays.equals(this.f6592h, uVar.f6592h);
    }

    public final int hashCode() {
        if (this.f6593i == 0) {
            String str = this.f6594j;
            this.f6593i = ((str == null ? 0 : str.hashCode()) * 31) + Arrays.hashCode(this.f6592h);
        }
        return this.f6593i;
    }

    public final u u(String str) {
        return l0.a(this.f6594j, str) ? this : new u(str, false, this.f6592h);
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f6594j);
        parcel.writeTypedArray(this.f6592h, 0);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: g1.t[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public u(java.lang.String r1, boolean r2, g1.t... r3) {
        /*
            r0 = this;
            r0.<init>()
            r0.f6594j = r1
            if (r2 == 0) goto L_0x000e
            java.lang.Object r1 = r3.clone()
            r3 = r1
            g1.t[] r3 = (g1.t[]) r3
        L_0x000e:
            r0.f6592h = r3
            int r1 = r3.length
            r0.f6595k = r1
            java.util.Arrays.sort(r3, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: g1.u.<init>(java.lang.String, boolean, g1.t[]):void");
    }
}
