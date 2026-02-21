package o3;

import androidx.preference.Preference;

public final class c0 {

    /* renamed from: a  reason: collision with root package name */
    public final int f12108a;

    /* renamed from: b  reason: collision with root package name */
    public final int f12109b;

    /* renamed from: c  reason: collision with root package name */
    public final String f12110c;

    public c0(Preference preference) {
        this.f12110c = preference.getClass().getName();
        this.f12108a = preference.L;
        this.f12109b = preference.M;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0006, code lost:
        r4 = (o3.c0) r4;
        r0 = r4.f12108a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            boolean r0 = r4 instanceof o3.c0
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            o3.c0 r4 = (o3.c0) r4
            int r0 = r4.f12108a
            int r2 = r3.f12108a
            if (r2 != r0) goto L_0x001f
            int r0 = r3.f12109b
            int r2 = r4.f12109b
            if (r0 != r2) goto L_0x001f
            java.lang.String r0 = r3.f12110c
            java.lang.String r4 = r4.f12110c
            boolean r4 = android.text.TextUtils.equals(r0, r4)
            if (r4 == 0) goto L_0x001f
            r1 = 1
        L_0x001f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: o3.c0.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        return this.f12110c.hashCode() + ((((527 + this.f12108a) * 31) + this.f12109b) * 31);
    }
}
