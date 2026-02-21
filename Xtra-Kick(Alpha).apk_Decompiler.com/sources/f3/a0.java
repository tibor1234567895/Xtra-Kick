package f3;

import d2.w;
import j1.b0;
import j1.h0;
import j1.l0;

public final class a0 {

    /* renamed from: a  reason: collision with root package name */
    public final h0 f5476a = new h0(0);

    /* renamed from: b  reason: collision with root package name */
    public final b0 f5477b = new b0();

    /* renamed from: c  reason: collision with root package name */
    public boolean f5478c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f5479d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f5480e;

    /* renamed from: f  reason: collision with root package name */
    public long f5481f = -9223372036854775807L;

    /* renamed from: g  reason: collision with root package name */
    public long f5482g = -9223372036854775807L;

    /* renamed from: h  reason: collision with root package name */
    public long f5483h = -9223372036854775807L;

    public static int b(int i10, byte[] bArr) {
        return (bArr[i10 + 3] & 255) | ((bArr[i10] & 255) << 24) | ((bArr[i10 + 1] & 255) << 16) | ((bArr[i10 + 2] & 255) << 8);
    }

    public static long c(b0 b0Var) {
        b0 b0Var2 = b0Var;
        int i10 = b0Var2.f8415b;
        if (b0Var2.f8416c - i10 < 9) {
            return -9223372036854775807L;
        }
        byte[] bArr = new byte[9];
        boolean z10 = false;
        b0Var2.d(bArr, 0, 9);
        b0Var2.G(i10);
        byte b10 = bArr[0];
        if ((b10 & 196) == 68 && (bArr[2] & 4) == 4 && (bArr[4] & 4) == 4 && (bArr[5] & 1) == 1 && (bArr[8] & 3) == 3) {
            z10 = true;
        }
        if (!z10) {
            return -9223372036854775807L;
        }
        long j10 = (long) b10;
        long j11 = ((j10 & 3) << 28) | (((56 & j10) >> 3) << 30) | ((((long) bArr[1]) & 255) << 20);
        long j12 = (long) bArr[2];
        return j11 | (((j12 & 248) >> 3) << 15) | ((j12 & 3) << 13) | ((((long) bArr[3]) & 255) << 5) | ((((long) bArr[4]) & 248) >> 3);
    }

    public final void a(w wVar) {
        byte[] bArr = l0.f8458f;
        b0 b0Var = this.f5477b;
        b0Var.getClass();
        b0Var.E(bArr.length, bArr);
        this.f5478c = true;
        wVar.f();
    }
}
