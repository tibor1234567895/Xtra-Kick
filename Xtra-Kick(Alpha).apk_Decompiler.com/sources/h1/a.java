package h1;

import j1.l0;
import java.util.Arrays;

public final class a {

    /* renamed from: e  reason: collision with root package name */
    public static final a f6877e = new a(-1, -1, -1);

    /* renamed from: a  reason: collision with root package name */
    public final int f6878a;

    /* renamed from: b  reason: collision with root package name */
    public final int f6879b;

    /* renamed from: c  reason: collision with root package name */
    public final int f6880c;

    /* renamed from: d  reason: collision with root package name */
    public final int f6881d;

    public a(int i10, int i11, int i12) {
        this.f6878a = i10;
        this.f6879b = i11;
        this.f6880c = i12;
        this.f6881d = l0.D(i12) ? l0.u(i12, i11) : -1;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000a, code lost:
        r5 = (h1.a) r5;
        r1 = r5.f6878a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r5) {
        /*
            r4 = this;
            r0 = 1
            if (r4 != r5) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r5 instanceof h1.a
            r2 = 0
            if (r1 != 0) goto L_0x000a
            return r2
        L_0x000a:
            h1.a r5 = (h1.a) r5
            int r1 = r5.f6878a
            int r3 = r4.f6878a
            if (r3 != r1) goto L_0x001f
            int r1 = r4.f6879b
            int r3 = r5.f6879b
            if (r1 != r3) goto L_0x001f
            int r1 = r4.f6880c
            int r5 = r5.f6880c
            if (r1 != r5) goto L_0x001f
            goto L_0x0020
        L_0x001f:
            r0 = 0
        L_0x0020:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: h1.a.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f6878a), Integer.valueOf(this.f6879b), Integer.valueOf(this.f6880c)});
    }

    public final String toString() {
        return "AudioFormat[sampleRate=" + this.f6878a + ", channelCount=" + this.f6879b + ", encoding=" + this.f6880c + ']';
    }
}
