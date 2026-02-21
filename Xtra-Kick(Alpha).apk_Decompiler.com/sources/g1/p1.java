package g1;

import android.os.Bundle;
import j1.l0;
import java.util.Arrays;

public final class p1 extends l1 {

    /* renamed from: l  reason: collision with root package name */
    public static final String f6509l = l0.C(1);

    /* renamed from: m  reason: collision with root package name */
    public static final String f6510m = l0.C(2);

    /* renamed from: n  reason: collision with root package name */
    public static final a f6511n = new a(19);

    /* renamed from: j  reason: collision with root package name */
    public final boolean f6512j;

    /* renamed from: k  reason: collision with root package name */
    public final boolean f6513k;

    public p1() {
        this.f6512j = false;
        this.f6513k = false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0006, code lost:
        r4 = (g1.p1) r4;
        r0 = r4.f6513k;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            boolean r0 = r4 instanceof g1.p1
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            g1.p1 r4 = (g1.p1) r4
            boolean r0 = r4.f6513k
            boolean r2 = r3.f6513k
            if (r2 != r0) goto L_0x0015
            boolean r0 = r3.f6512j
            boolean r4 = r4.f6512j
            if (r0 != r4) goto L_0x0015
            r1 = 1
        L_0x0015:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: g1.p1.equals(java.lang.Object):boolean");
    }

    public final Bundle h() {
        Bundle bundle = new Bundle();
        bundle.putInt(l1.f6454h, 3);
        bundle.putBoolean(f6509l, this.f6512j);
        bundle.putBoolean(f6510m, this.f6513k);
        return bundle;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Boolean.valueOf(this.f6512j), Boolean.valueOf(this.f6513k)});
    }

    public final boolean i() {
        return this.f6512j;
    }

    public p1(boolean z10) {
        this.f6512j = true;
        this.f6513k = z10;
    }
}
