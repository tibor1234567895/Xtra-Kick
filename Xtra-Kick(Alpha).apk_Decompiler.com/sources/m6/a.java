package m6;

import android.support.v4.media.h;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final int f10609a;

    /* renamed from: b  reason: collision with root package name */
    public final String f10610b;

    /* renamed from: c  reason: collision with root package name */
    public final String f10611c;

    public a(int i10, String str, String str2) {
        this.f10609a = i10;
        this.f10610b = str;
        this.f10611c = str2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000a, code lost:
        r5 = (m6.a) r5;
        r1 = r5.f10609a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r5) {
        /*
            r4 = this;
            r0 = 1
            if (r4 != r5) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r5 instanceof m6.a
            r2 = 0
            if (r1 != 0) goto L_0x000a
            return r2
        L_0x000a:
            m6.a r5 = (m6.a) r5
            int r1 = r5.f10609a
            int r3 = r4.f10609a
            if (r3 == r1) goto L_0x0013
            return r2
        L_0x0013:
            java.lang.String r1 = r4.f10610b
            java.lang.String r3 = r5.f10610b
            boolean r1 = xa.j.a(r1, r3)
            if (r1 != 0) goto L_0x001e
            return r2
        L_0x001e:
            java.lang.String r1 = r4.f10611c
            java.lang.String r5 = r5.f10611c
            boolean r5 = xa.j.a(r1, r5)
            if (r5 != 0) goto L_0x0029
            return r2
        L_0x0029:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: m6.a.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        return this.f10611c.hashCode() + h.e(this.f10610b, this.f10609a * 31, 31);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("Storage(id=");
        sb2.append(this.f10609a);
        sb2.append(", name=");
        sb2.append(this.f10610b);
        sb2.append(", path=");
        return h.p(sb2, this.f10611c, ")");
    }
}
