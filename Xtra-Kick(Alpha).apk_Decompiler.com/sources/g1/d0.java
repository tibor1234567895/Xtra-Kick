package g1;

import android.os.Bundle;
import j1.l0;
import java.util.Arrays;

public final class d0 extends l1 {

    /* renamed from: l  reason: collision with root package name */
    public static final String f6338l = l0.C(1);

    /* renamed from: m  reason: collision with root package name */
    public static final String f6339m = l0.C(2);

    /* renamed from: n  reason: collision with root package name */
    public static final a f6340n = new a(6);

    /* renamed from: j  reason: collision with root package name */
    public final boolean f6341j;

    /* renamed from: k  reason: collision with root package name */
    public final boolean f6342k;

    public d0() {
        this.f6341j = false;
        this.f6342k = false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0006, code lost:
        r4 = (g1.d0) r4;
        r0 = r4.f6342k;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            boolean r0 = r4 instanceof g1.d0
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            g1.d0 r4 = (g1.d0) r4
            boolean r0 = r4.f6342k
            boolean r2 = r3.f6342k
            if (r2 != r0) goto L_0x0015
            boolean r0 = r3.f6341j
            boolean r4 = r4.f6341j
            if (r0 != r4) goto L_0x0015
            r1 = 1
        L_0x0015:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: g1.d0.equals(java.lang.Object):boolean");
    }

    public final Bundle h() {
        Bundle bundle = new Bundle();
        bundle.putInt(l1.f6454h, 0);
        bundle.putBoolean(f6338l, this.f6341j);
        bundle.putBoolean(f6339m, this.f6342k);
        return bundle;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Boolean.valueOf(this.f6341j), Boolean.valueOf(this.f6342k)});
    }

    public final boolean i() {
        return this.f6341j;
    }

    public d0(boolean z10) {
        this.f6341j = true;
        this.f6342k = z10;
    }
}
