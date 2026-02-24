package g1;

import android.os.Bundle;
import j1.l0;

public final class b2 implements m {

    /* renamed from: l  reason: collision with root package name */
    public static final b2 f6311l = new b2(1.0f, 0, 0, 0);

    /* renamed from: m  reason: collision with root package name */
    public static final String f6312m = l0.C(0);

    /* renamed from: n  reason: collision with root package name */
    public static final String f6313n = l0.C(1);

    /* renamed from: o  reason: collision with root package name */
    public static final String f6314o = l0.C(2);

    /* renamed from: p  reason: collision with root package name */
    public static final String f6315p = l0.C(3);

    /* renamed from: q  reason: collision with root package name */
    public static final a f6316q = new a(28);

    /* renamed from: h  reason: collision with root package name */
    public final int f6317h;

    /* renamed from: i  reason: collision with root package name */
    public final int f6318i;

    /* renamed from: j  reason: collision with root package name */
    public final int f6319j;

    /* renamed from: k  reason: collision with root package name */
    public final float f6320k;

    public b2(float f10, int i10, int i11, int i12) {
        this.f6317h = i10;
        this.f6318i = i11;
        this.f6319j = i12;
        this.f6320k = f10;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0009, code lost:
        r5 = (g1.b2) r5;
        r1 = r5.f6317h;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r5) {
        /*
            r4 = this;
            r0 = 1
            if (r4 != r5) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r5 instanceof g1.b2
            r2 = 0
            if (r1 == 0) goto L_0x0028
            g1.b2 r5 = (g1.b2) r5
            int r1 = r5.f6317h
            int r3 = r4.f6317h
            if (r3 != r1) goto L_0x0026
            int r1 = r4.f6318i
            int r3 = r5.f6318i
            if (r1 != r3) goto L_0x0026
            int r1 = r4.f6319j
            int r3 = r5.f6319j
            if (r1 != r3) goto L_0x0026
            float r1 = r4.f6320k
            float r5 = r5.f6320k
            int r5 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r5 != 0) goto L_0x0026
            goto L_0x0027
        L_0x0026:
            r0 = 0
        L_0x0027:
            return r0
        L_0x0028:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: g1.b2.equals(java.lang.Object):boolean");
    }

    public final Bundle h() {
        Bundle bundle = new Bundle();
        bundle.putInt(f6312m, this.f6317h);
        bundle.putInt(f6313n, this.f6318i);
        bundle.putInt(f6314o, this.f6319j);
        bundle.putFloat(f6315p, this.f6320k);
        return bundle;
    }

    public final int hashCode() {
        return Float.floatToRawIntBits(this.f6320k) + ((((((217 + this.f6317h) * 31) + this.f6318i) * 31) + this.f6319j) * 31);
    }
}
