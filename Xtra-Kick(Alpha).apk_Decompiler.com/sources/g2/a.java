package g2;

import android.support.v4.media.n;
import androidx.activity.result.j;
import d2.g;
import d2.l;
import j1.h0;

public final class a extends l {
    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public a(d2.f0 r15, int r16, long r17, long r19) {
        /*
            r14 = this;
            r0 = r15
            java.util.Objects.requireNonNull(r15)
            p0.c r1 = new p0.c
            r2 = 8
            r1.<init>(r2, r15)
            d0.d r2 = new d0.d
            r3 = r16
            r2.<init>(r15, r3)
            long r3 = r15.b()
            long r5 = r0.f4182j
            int r7 = r0.f4175c
            int r8 = r0.f4176d
            if (r8 <= 0) goto L_0x0027
            long r8 = (long) r8
            long r10 = (long) r7
            long r8 = r8 + r10
            r10 = 2
            long r8 = r8 / r10
            r10 = 1
            goto L_0x0042
        L_0x0027:
            int r8 = r0.f4174b
            int r9 = r0.f4173a
            if (r9 != r8) goto L_0x0031
            if (r9 <= 0) goto L_0x0031
            long r8 = (long) r9
            goto L_0x0033
        L_0x0031:
            r8 = 4096(0x1000, double:2.0237E-320)
        L_0x0033:
            int r10 = r0.f4179g
            long r10 = (long) r10
            long r8 = r8 * r10
            int r0 = r0.f4180h
            long r10 = (long) r0
            long r8 = r8 * r10
            r10 = 8
            long r8 = r8 / r10
            r10 = 64
        L_0x0042:
            long r11 = r8 + r10
            r0 = 6
            int r13 = java.lang.Math.max(r0, r7)
            r0 = r14
            r7 = r17
            r9 = r19
            r0.<init>(r1, r2, r3, r5, r7, r9, r11, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: g2.a.<init>(d2.f0, int, long, long):void");
    }

    public static int d(int i10, byte[] bArr) {
        return (bArr[i10 + 3] & 255) | ((bArr[i10] & 255) << 24) | ((bArr[i10 + 1] & 255) << 16) | ((bArr[i10 + 2] & 255) << 8);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(h0 h0Var, long j10, long j11) {
        super(new g(), new n(h0Var, 0), j10, j10 + 1, 0, j11, 188, 1000);
        h0 h0Var2 = h0Var;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(h0 h0Var, long j10, long j11, int i10, int i11) {
        super(new g(), new j(i10, h0Var, i11), j10, j10 + 1, 0, j11, 188, 940);
        h0 h0Var2 = h0Var;
    }
}
