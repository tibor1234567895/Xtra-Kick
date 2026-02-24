package f3;

import j1.b0;

public final class l0 {
    private l0() {
    }

    public static long a(int i10, int i11, b0 b0Var) {
        boolean z10;
        boolean z11;
        b0Var.G(i10);
        if (b0Var.f8416c - b0Var.f8415b < 5) {
            return -9223372036854775807L;
        }
        int f10 = b0Var.f();
        if ((8388608 & f10) != 0 || ((2096896 & f10) >> 8) != i11) {
            return -9223372036854775807L;
        }
        if ((f10 & 32) != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10 && b0Var.v() >= 7 && b0Var.f8416c - b0Var.f8415b >= 7) {
            if ((b0Var.v() & 16) == 16) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                byte[] bArr = new byte[6];
                b0Var.d(bArr, 0, 6);
                return ((((long) bArr[0]) & 255) << 25) | ((((long) bArr[1]) & 255) << 17) | ((((long) bArr[2]) & 255) << 9) | ((((long) bArr[3]) & 255) << 1) | ((((long) bArr[4]) & 255) >> 7);
            }
        }
        return -9223372036854775807L;
    }
}
