package j3;

import android.os.Bundle;
import xa.j;

public final class b1 implements Comparable {

    /* renamed from: h  reason: collision with root package name */
    public final c1 f8495h;

    /* renamed from: i  reason: collision with root package name */
    public final Bundle f8496i;

    /* renamed from: j  reason: collision with root package name */
    public final boolean f8497j;

    /* renamed from: k  reason: collision with root package name */
    public final int f8498k;

    /* renamed from: l  reason: collision with root package name */
    public final boolean f8499l;

    /* renamed from: m  reason: collision with root package name */
    public final int f8500m;

    public b1(c1 c1Var, Bundle bundle, boolean z10, int i10, boolean z11, int i11) {
        j.f("destination", c1Var);
        this.f8495h = c1Var;
        this.f8496i = bundle;
        this.f8497j = z10;
        this.f8498k = i10;
        this.f8499l = z11;
        this.f8500m = i11;
    }

    /* renamed from: a */
    public final int compareTo(b1 b1Var) {
        j.f("other", b1Var);
        boolean z10 = b1Var.f8497j;
        boolean z11 = this.f8497j;
        if (z11 && !z10) {
            return 1;
        }
        if (!z11 && z10) {
            return -1;
        }
        int i10 = this.f8498k - b1Var.f8498k;
        if (i10 > 0) {
            return 1;
        }
        if (i10 < 0) {
            return -1;
        }
        Bundle bundle = b1Var.f8496i;
        Bundle bundle2 = this.f8496i;
        if (bundle2 != null && bundle == null) {
            return 1;
        }
        if (bundle2 == null && bundle != null) {
            return -1;
        }
        if (bundle2 != null) {
            int size = bundle2.size();
            j.c(bundle);
            int size2 = size - bundle.size();
            if (size2 > 0) {
                return 1;
            }
            if (size2 < 0) {
                return -1;
            }
        }
        boolean z12 = b1Var.f8499l;
        boolean z13 = this.f8499l;
        if (z13 && !z12) {
            return 1;
        }
        if (z13 || !z12) {
            return this.f8500m - b1Var.f8500m;
        }
        return -1;
    }
}
