package g1;

import android.os.Bundle;
import j1.a;
import j1.l0;
import java.util.Arrays;

public final class z1 implements m {

    /* renamed from: m  reason: collision with root package name */
    public static final String f6772m = l0.C(0);

    /* renamed from: n  reason: collision with root package name */
    public static final String f6773n = l0.C(1);

    /* renamed from: o  reason: collision with root package name */
    public static final String f6774o = l0.C(3);

    /* renamed from: p  reason: collision with root package name */
    public static final String f6775p = l0.C(4);

    /* renamed from: q  reason: collision with root package name */
    public static final a f6776q = new a(27);

    /* renamed from: h  reason: collision with root package name */
    public final int f6777h;

    /* renamed from: i  reason: collision with root package name */
    public final v1 f6778i;

    /* renamed from: j  reason: collision with root package name */
    public final boolean f6779j;

    /* renamed from: k  reason: collision with root package name */
    public final int[] f6780k;

    /* renamed from: l  reason: collision with root package name */
    public final boolean[] f6781l;

    public z1(v1 v1Var, boolean z10, int[] iArr, boolean[] zArr) {
        int i10 = v1Var.f6673h;
        this.f6777h = i10;
        boolean z11 = false;
        a.b(i10 == iArr.length && i10 == zArr.length);
        this.f6778i = v1Var;
        if (z10 && i10 > 1) {
            z11 = true;
        }
        this.f6779j = z11;
        this.f6780k = (int[]) iArr.clone();
        this.f6781l = (boolean[]) zArr.clone();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || z1.class != obj.getClass()) {
            return false;
        }
        z1 z1Var = (z1) obj;
        return this.f6779j == z1Var.f6779j && this.f6778i.equals(z1Var.f6778i) && Arrays.equals(this.f6780k, z1Var.f6780k) && Arrays.equals(this.f6781l, z1Var.f6781l);
    }

    public final Bundle h() {
        Bundle bundle = new Bundle();
        bundle.putBundle(f6772m, this.f6778i.h());
        bundle.putIntArray(f6773n, this.f6780k);
        bundle.putBooleanArray(f6774o, this.f6781l);
        bundle.putBoolean(f6775p, this.f6779j);
        return bundle;
    }

    public final int hashCode() {
        int hashCode = Arrays.hashCode(this.f6780k);
        return Arrays.hashCode(this.f6781l) + ((hashCode + (((this.f6778i.hashCode() * 31) + (this.f6779j ? 1 : 0)) * 31)) * 31);
    }
}
