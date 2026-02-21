package g1;

import android.os.Bundle;
import c9.n;
import j1.l0;
import java.util.Arrays;

public final class j1 implements m {

    /* renamed from: q  reason: collision with root package name */
    public static final String f6422q = l0.C(0);

    /* renamed from: r  reason: collision with root package name */
    public static final String f6423r = l0.C(1);

    /* renamed from: s  reason: collision with root package name */
    public static final String f6424s = l0.C(2);

    /* renamed from: t  reason: collision with root package name */
    public static final String f6425t = l0.C(3);

    /* renamed from: u  reason: collision with root package name */
    public static final String f6426u = l0.C(4);

    /* renamed from: v  reason: collision with root package name */
    public static final String f6427v = l0.C(5);

    /* renamed from: w  reason: collision with root package name */
    public static final String f6428w = l0.C(6);

    /* renamed from: x  reason: collision with root package name */
    public static final a f6429x = new a(16);

    /* renamed from: h  reason: collision with root package name */
    public final Object f6430h;

    /* renamed from: i  reason: collision with root package name */
    public final int f6431i;

    /* renamed from: j  reason: collision with root package name */
    public final s0 f6432j;

    /* renamed from: k  reason: collision with root package name */
    public final Object f6433k;

    /* renamed from: l  reason: collision with root package name */
    public final int f6434l;

    /* renamed from: m  reason: collision with root package name */
    public final long f6435m;

    /* renamed from: n  reason: collision with root package name */
    public final long f6436n;

    /* renamed from: o  reason: collision with root package name */
    public final int f6437o;

    /* renamed from: p  reason: collision with root package name */
    public final int f6438p;

    public j1(Object obj, int i10, s0 s0Var, Object obj2, int i11, long j10, long j11, int i12, int i13) {
        this.f6430h = obj;
        this.f6431i = i10;
        this.f6432j = s0Var;
        this.f6433k = obj2;
        this.f6434l = i11;
        this.f6435m = j10;
        this.f6436n = j11;
        this.f6437o = i12;
        this.f6438p = i13;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || j1.class != obj.getClass()) {
            return false;
        }
        j1 j1Var = (j1) obj;
        return this.f6431i == j1Var.f6431i && this.f6434l == j1Var.f6434l && this.f6435m == j1Var.f6435m && this.f6436n == j1Var.f6436n && this.f6437o == j1Var.f6437o && this.f6438p == j1Var.f6438p && n.a(this.f6430h, j1Var.f6430h) && n.a(this.f6433k, j1Var.f6433k) && n.a(this.f6432j, j1Var.f6432j);
    }

    public final Bundle h() {
        return i(true, true);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f6430h, Integer.valueOf(this.f6431i), this.f6432j, this.f6433k, Integer.valueOf(this.f6434l), Long.valueOf(this.f6435m), Long.valueOf(this.f6436n), Integer.valueOf(this.f6437o), Integer.valueOf(this.f6438p)});
    }

    public final Bundle i(boolean z10, boolean z11) {
        Bundle bundle = new Bundle();
        int i10 = 0;
        bundle.putInt(f6422q, z11 ? this.f6431i : 0);
        s0 s0Var = this.f6432j;
        if (s0Var != null && z10) {
            bundle.putBundle(f6423r, s0Var.h());
        }
        if (z11) {
            i10 = this.f6434l;
        }
        bundle.putInt(f6424s, i10);
        long j10 = 0;
        bundle.putLong(f6425t, z10 ? this.f6435m : 0);
        if (z10) {
            j10 = this.f6436n;
        }
        bundle.putLong(f6426u, j10);
        int i11 = -1;
        bundle.putInt(f6427v, z10 ? this.f6437o : -1);
        if (z10) {
            i11 = this.f6438p;
        }
        bundle.putInt(f6428w, i11);
        return bundle;
    }
}
