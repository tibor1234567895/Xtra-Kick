package g1;

import android.os.Bundle;
import j1.a;
import j1.l0;
import java.util.Arrays;

public final class m1 extends l1 {

    /* renamed from: l  reason: collision with root package name */
    public static final String f6468l = l0.C(1);

    /* renamed from: m  reason: collision with root package name */
    public static final String f6469m = l0.C(2);

    /* renamed from: n  reason: collision with root package name */
    public static final a f6470n = new a(18);

    /* renamed from: j  reason: collision with root package name */
    public final int f6471j;

    /* renamed from: k  reason: collision with root package name */
    public final float f6472k;

    public m1(int i10) {
        a.a("maxStars must be a positive integer", i10 > 0);
        this.f6471j = i10;
        this.f6472k = -1.0f;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0006, code lost:
        r4 = (g1.m1) r4;
        r0 = r4.f6471j;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            boolean r0 = r4 instanceof g1.m1
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            g1.m1 r4 = (g1.m1) r4
            int r0 = r4.f6471j
            int r2 = r3.f6471j
            if (r2 != r0) goto L_0x0017
            float r0 = r3.f6472k
            float r4 = r4.f6472k
            int r4 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r4 != 0) goto L_0x0017
            r1 = 1
        L_0x0017:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: g1.m1.equals(java.lang.Object):boolean");
    }

    public final Bundle h() {
        Bundle bundle = new Bundle();
        bundle.putInt(l1.f6454h, 2);
        bundle.putInt(f6468l, this.f6471j);
        bundle.putFloat(f6469m, this.f6472k);
        return bundle;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f6471j), Float.valueOf(this.f6472k)});
    }

    public final boolean i() {
        return this.f6472k != -1.0f;
    }

    public m1(int i10, float f10) {
        boolean z10 = false;
        a.a("maxStars must be a positive integer", i10 > 0);
        if (f10 >= 0.0f && f10 <= ((float) i10)) {
            z10 = true;
        }
        a.a("starRating is out of range [0, maxStars]", z10);
        this.f6471j = i10;
        this.f6472k = f10;
    }
}
