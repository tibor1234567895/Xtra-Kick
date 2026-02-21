package g1;

import android.os.Bundle;
import j1.l0;

public final class q implements m {

    /* renamed from: k  reason: collision with root package name */
    public static final q f6514k = new q(0, 0, 0);

    /* renamed from: l  reason: collision with root package name */
    public static final String f6515l = l0.C(0);

    /* renamed from: m  reason: collision with root package name */
    public static final String f6516m = l0.C(1);

    /* renamed from: n  reason: collision with root package name */
    public static final String f6517n = l0.C(2);

    /* renamed from: o  reason: collision with root package name */
    public static final a f6518o = new a(4);

    /* renamed from: h  reason: collision with root package name */
    public final int f6519h;

    /* renamed from: i  reason: collision with root package name */
    public final int f6520i;

    /* renamed from: j  reason: collision with root package name */
    public final int f6521j;

    public q(int i10, int i11, int i12) {
        this.f6519h = i10;
        this.f6520i = i11;
        this.f6521j = i12;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000a, code lost:
        r5 = (g1.q) r5;
        r1 = r5.f6519h;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r5) {
        /*
            r4 = this;
            r0 = 1
            if (r4 != r5) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r5 instanceof g1.q
            r2 = 0
            if (r1 != 0) goto L_0x000a
            return r2
        L_0x000a:
            g1.q r5 = (g1.q) r5
            int r1 = r5.f6519h
            int r3 = r4.f6519h
            if (r3 != r1) goto L_0x001f
            int r1 = r4.f6520i
            int r3 = r5.f6520i
            if (r1 != r3) goto L_0x001f
            int r1 = r4.f6521j
            int r5 = r5.f6521j
            if (r1 != r5) goto L_0x001f
            goto L_0x0020
        L_0x001f:
            r0 = 0
        L_0x0020:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: g1.q.equals(java.lang.Object):boolean");
    }

    public final Bundle h() {
        Bundle bundle = new Bundle();
        bundle.putInt(f6515l, this.f6519h);
        bundle.putInt(f6516m, this.f6520i);
        bundle.putInt(f6517n, this.f6521j);
        return bundle;
    }

    public final int hashCode() {
        return ((((527 + this.f6519h) * 31) + this.f6520i) * 31) + this.f6521j;
    }
}
