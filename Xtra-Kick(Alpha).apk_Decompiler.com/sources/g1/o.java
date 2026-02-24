package g1;

import android.os.Bundle;
import j1.l0;
import java.util.Arrays;

public final class o implements m {

    /* renamed from: m  reason: collision with root package name */
    public static final String f6485m = l0.C(0);

    /* renamed from: n  reason: collision with root package name */
    public static final String f6486n = l0.C(1);

    /* renamed from: o  reason: collision with root package name */
    public static final String f6487o = l0.C(2);

    /* renamed from: p  reason: collision with root package name */
    public static final String f6488p = l0.C(3);

    /* renamed from: q  reason: collision with root package name */
    public static final a f6489q = new a(3);

    /* renamed from: h  reason: collision with root package name */
    public final int f6490h;

    /* renamed from: i  reason: collision with root package name */
    public final int f6491i;

    /* renamed from: j  reason: collision with root package name */
    public final int f6492j;

    /* renamed from: k  reason: collision with root package name */
    public final byte[] f6493k;

    /* renamed from: l  reason: collision with root package name */
    public int f6494l;

    public o(int i10, int i11, int i12, byte[] bArr) {
        this.f6490h = i10;
        this.f6491i = i11;
        this.f6492j = i12;
        this.f6493k = bArr;
    }

    public static int i(int i10) {
        if (i10 == 1) {
            return 1;
        }
        if (i10 != 9) {
            return (i10 == 4 || i10 == 5 || i10 == 6 || i10 == 7) ? 2 : -1;
        }
        return 6;
    }

    public static int j(int i10) {
        if (i10 == 1) {
            return 3;
        }
        if (i10 == 16) {
            return 6;
        }
        if (i10 != 18) {
            return (i10 == 6 || i10 == 7) ? 3 : -1;
        }
        return 7;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || o.class != obj.getClass()) {
            return false;
        }
        o oVar = (o) obj;
        return this.f6490h == oVar.f6490h && this.f6491i == oVar.f6491i && this.f6492j == oVar.f6492j && Arrays.equals(this.f6493k, oVar.f6493k);
    }

    public final Bundle h() {
        Bundle bundle = new Bundle();
        bundle.putInt(f6485m, this.f6490h);
        bundle.putInt(f6486n, this.f6491i);
        bundle.putInt(f6487o, this.f6492j);
        bundle.putByteArray(f6488p, this.f6493k);
        return bundle;
    }

    public final int hashCode() {
        if (this.f6494l == 0) {
            this.f6494l = Arrays.hashCode(this.f6493k) + ((((((527 + this.f6490h) * 31) + this.f6491i) * 31) + this.f6492j) * 31);
        }
        return this.f6494l;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("ColorInfo(");
        sb2.append(this.f6490h);
        sb2.append(", ");
        sb2.append(this.f6491i);
        sb2.append(", ");
        sb2.append(this.f6492j);
        sb2.append(", ");
        sb2.append(this.f6493k != null);
        sb2.append(")");
        return sb2.toString();
    }
}
