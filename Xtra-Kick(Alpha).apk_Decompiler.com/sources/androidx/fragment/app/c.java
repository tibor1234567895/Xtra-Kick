package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.lifecycle.s;
import java.util.ArrayList;
import java.util.Objects;

public final class c implements Parcelable {
    public static final Parcelable.Creator<c> CREATOR = new b();

    /* renamed from: h  reason: collision with root package name */
    public final int[] f1335h;

    /* renamed from: i  reason: collision with root package name */
    public final ArrayList f1336i;

    /* renamed from: j  reason: collision with root package name */
    public final int[] f1337j;

    /* renamed from: k  reason: collision with root package name */
    public final int[] f1338k;

    /* renamed from: l  reason: collision with root package name */
    public final int f1339l;

    /* renamed from: m  reason: collision with root package name */
    public final String f1340m;

    /* renamed from: n  reason: collision with root package name */
    public final int f1341n;

    /* renamed from: o  reason: collision with root package name */
    public final int f1342o;

    /* renamed from: p  reason: collision with root package name */
    public final CharSequence f1343p;

    /* renamed from: q  reason: collision with root package name */
    public final int f1344q;

    /* renamed from: r  reason: collision with root package name */
    public final CharSequence f1345r;

    /* renamed from: s  reason: collision with root package name */
    public final ArrayList f1346s;

    /* renamed from: t  reason: collision with root package name */
    public final ArrayList f1347t;

    /* renamed from: u  reason: collision with root package name */
    public final boolean f1348u;

    public c(Parcel parcel) {
        this.f1335h = parcel.createIntArray();
        this.f1336i = parcel.createStringArrayList();
        this.f1337j = parcel.createIntArray();
        this.f1338k = parcel.createIntArray();
        this.f1339l = parcel.readInt();
        this.f1340m = parcel.readString();
        this.f1341n = parcel.readInt();
        this.f1342o = parcel.readInt();
        this.f1343p = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f1344q = parcel.readInt();
        this.f1345r = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f1346s = parcel.createStringArrayList();
        this.f1347t = parcel.createStringArrayList();
        this.f1348u = parcel.readInt() != 0;
    }

    public final int describeContents() {
        return 0;
    }

    public final void u(a aVar) {
        int i10 = 0;
        int i11 = 0;
        while (true) {
            int[] iArr = this.f1335h;
            boolean z10 = true;
            if (i10 < iArr.length) {
                o1 o1Var = new o1();
                int i12 = i10 + 1;
                o1Var.f1521a = iArr[i10];
                if (c1.I(2)) {
                    Objects.toString(aVar);
                    int i13 = iArr[i12];
                }
                o1Var.f1528h = s.values()[this.f1337j[i11]];
                o1Var.f1529i = s.values()[this.f1338k[i11]];
                int i14 = i12 + 1;
                if (iArr[i12] == 0) {
                    z10 = false;
                }
                o1Var.f1523c = z10;
                int i15 = i14 + 1;
                int i16 = iArr[i14];
                o1Var.f1524d = i16;
                int i17 = i15 + 1;
                int i18 = iArr[i15];
                o1Var.f1525e = i18;
                int i19 = i17 + 1;
                int i20 = iArr[i17];
                o1Var.f1526f = i20;
                int i21 = iArr[i19];
                o1Var.f1527g = i21;
                aVar.f1534b = i16;
                aVar.f1535c = i18;
                aVar.f1536d = i20;
                aVar.f1537e = i21;
                aVar.b(o1Var);
                i11++;
                i10 = i19 + 1;
            } else {
                aVar.f1538f = this.f1339l;
                aVar.f1541i = this.f1340m;
                aVar.f1539g = true;
                aVar.f1542j = this.f1342o;
                aVar.f1543k = this.f1343p;
                aVar.f1544l = this.f1344q;
                aVar.f1545m = this.f1345r;
                aVar.f1546n = this.f1346s;
                aVar.f1547o = this.f1347t;
                aVar.f1548p = this.f1348u;
                return;
            }
        }
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeIntArray(this.f1335h);
        parcel.writeStringList(this.f1336i);
        parcel.writeIntArray(this.f1337j);
        parcel.writeIntArray(this.f1338k);
        parcel.writeInt(this.f1339l);
        parcel.writeString(this.f1340m);
        parcel.writeInt(this.f1341n);
        parcel.writeInt(this.f1342o);
        TextUtils.writeToParcel(this.f1343p, parcel, 0);
        parcel.writeInt(this.f1344q);
        TextUtils.writeToParcel(this.f1345r, parcel, 0);
        parcel.writeStringList(this.f1346s);
        parcel.writeStringList(this.f1347t);
        parcel.writeInt(this.f1348u ? 1 : 0);
    }

    public c(a aVar) {
        int size = aVar.f1533a.size();
        this.f1335h = new int[(size * 6)];
        if (aVar.f1539g) {
            this.f1336i = new ArrayList(size);
            this.f1337j = new int[size];
            this.f1338k = new int[size];
            int i10 = 0;
            int i11 = 0;
            while (i10 < size) {
                o1 o1Var = (o1) aVar.f1533a.get(i10);
                int i12 = i11 + 1;
                this.f1335h[i11] = o1Var.f1521a;
                ArrayList arrayList = this.f1336i;
                c0 c0Var = o1Var.f1522b;
                arrayList.add(c0Var != null ? c0Var.f1356l : null);
                int[] iArr = this.f1335h;
                int i13 = i12 + 1;
                iArr[i12] = o1Var.f1523c;
                int i14 = i13 + 1;
                iArr[i13] = o1Var.f1524d;
                int i15 = i14 + 1;
                iArr[i14] = o1Var.f1525e;
                int i16 = i15 + 1;
                iArr[i15] = o1Var.f1526f;
                iArr[i16] = o1Var.f1527g;
                this.f1337j[i10] = o1Var.f1528h.ordinal();
                this.f1338k[i10] = o1Var.f1529i.ordinal();
                i10++;
                i11 = i16 + 1;
            }
            this.f1339l = aVar.f1538f;
            this.f1340m = aVar.f1541i;
            this.f1341n = aVar.f1321s;
            this.f1342o = aVar.f1542j;
            this.f1343p = aVar.f1543k;
            this.f1344q = aVar.f1544l;
            this.f1345r = aVar.f1545m;
            this.f1346s = aVar.f1546n;
            this.f1347t = aVar.f1547o;
            this.f1348u = aVar.f1548p;
            return;
        }
        throw new IllegalStateException("Not on back stack");
    }
}
