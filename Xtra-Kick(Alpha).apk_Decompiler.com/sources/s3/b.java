package s3;

import android.support.v4.media.h;
import fb.y;
import java.util.Locale;
import xa.j;

public final class b {

    /* renamed from: h  reason: collision with root package name */
    public static final a f14162h = new a(0);

    /* renamed from: a  reason: collision with root package name */
    public final String f14163a;

    /* renamed from: b  reason: collision with root package name */
    public final String f14164b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f14165c;

    /* renamed from: d  reason: collision with root package name */
    public final int f14166d;

    /* renamed from: e  reason: collision with root package name */
    public final String f14167e;

    /* renamed from: f  reason: collision with root package name */
    public final int f14168f;

    /* renamed from: g  reason: collision with root package name */
    public final int f14169g;

    public b(int i10, int i11, String str, String str2, String str3, boolean z10) {
        int i12;
        this.f14163a = str;
        this.f14164b = str2;
        this.f14165c = z10;
        this.f14166d = i10;
        this.f14167e = str3;
        this.f14168f = i11;
        Locale locale = Locale.US;
        j.e("US", locale);
        String upperCase = str2.toUpperCase(locale);
        j.e("this as java.lang.String).toUpperCase(locale)", upperCase);
        if (y.n(upperCase, "INT", false)) {
            i12 = 3;
        } else if (y.n(upperCase, "CHAR", false) || y.n(upperCase, "CLOB", false) || y.n(upperCase, "TEXT", false)) {
            i12 = 2;
        } else if (y.n(upperCase, "BLOB", false)) {
            i12 = 5;
        } else if (y.n(upperCase, "REAL", false) || y.n(upperCase, "FLOA", false) || y.n(upperCase, "DOUB", false)) {
            i12 = 4;
        } else {
            i12 = 1;
        }
        this.f14169g = i12;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x005d, code lost:
        if (s3.a.a(r6, r1) == false) goto L_0x0062;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0060, code lost:
        if (r1 != null) goto L_0x0062;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0064, code lost:
        r1 = false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r10) {
        /*
            r9 = this;
            r0 = 1
            if (r9 != r10) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r10 instanceof s3.b
            r2 = 0
            if (r1 != 0) goto L_0x000a
            return r2
        L_0x000a:
            s3.b r10 = (s3.b) r10
            int r1 = r10.f14166d
            int r3 = r9.f14166d
            if (r3 == r1) goto L_0x0013
            return r2
        L_0x0013:
            java.lang.String r1 = r10.f14163a
            java.lang.String r3 = r9.f14163a
            boolean r1 = xa.j.a(r3, r1)
            if (r1 != 0) goto L_0x001e
            return r2
        L_0x001e:
            boolean r1 = r9.f14165c
            boolean r3 = r10.f14165c
            if (r1 == r3) goto L_0x0025
            return r2
        L_0x0025:
            java.lang.String r1 = r10.f14167e
            int r3 = r10.f14168f
            r4 = 2
            s3.a r5 = f14162h
            java.lang.String r6 = r9.f14167e
            int r7 = r9.f14168f
            if (r7 != r0) goto L_0x0040
            if (r3 != r4) goto L_0x0040
            if (r6 == 0) goto L_0x0040
            r5.getClass()
            boolean r8 = s3.a.a(r6, r1)
            if (r8 != 0) goto L_0x0040
            return r2
        L_0x0040:
            if (r7 != r4) goto L_0x0050
            if (r3 != r0) goto L_0x0050
            if (r1 == 0) goto L_0x0050
            r5.getClass()
            boolean r4 = s3.a.a(r1, r6)
            if (r4 != 0) goto L_0x0050
            return r2
        L_0x0050:
            if (r7 == 0) goto L_0x0068
            if (r7 != r3) goto L_0x0068
            if (r6 == 0) goto L_0x0060
            r5.getClass()
            boolean r1 = s3.a.a(r6, r1)
            if (r1 != 0) goto L_0x0064
            goto L_0x0062
        L_0x0060:
            if (r1 == 0) goto L_0x0064
        L_0x0062:
            r1 = 1
            goto L_0x0065
        L_0x0064:
            r1 = 0
        L_0x0065:
            if (r1 == 0) goto L_0x0068
            return r2
        L_0x0068:
            int r1 = r9.f14169g
            int r10 = r10.f14169g
            if (r1 != r10) goto L_0x006f
            goto L_0x0070
        L_0x006f:
            r0 = 0
        L_0x0070:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: s3.b.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        return (((((this.f14163a.hashCode() * 31) + this.f14169g) * 31) + (this.f14165c ? 1231 : 1237)) * 31) + this.f14166d;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("Column{name='");
        sb2.append(this.f14163a);
        sb2.append("', type='");
        sb2.append(this.f14164b);
        sb2.append("', affinity='");
        sb2.append(this.f14169g);
        sb2.append("', notNull=");
        sb2.append(this.f14165c);
        sb2.append(", primaryKeyPosition=");
        sb2.append(this.f14166d);
        sb2.append(", defaultValue='");
        String str = this.f14167e;
        if (str == null) {
            str = "undefined";
        }
        return h.p(sb2, str, "'}");
    }
}
