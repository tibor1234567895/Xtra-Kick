package d2;

import j1.b0;
import j1.v;

public final class m {
    private m() {
    }

    public static void a(long j10, b0 b0Var, x0[] x0VarArr) {
        int i10;
        int i11;
        boolean z10;
        while (true) {
            boolean z11 = true;
            if (b0Var.f8416c - b0Var.f8415b > 1) {
                int i12 = 0;
                while (true) {
                    if (b0Var.f8416c - b0Var.f8415b != 0) {
                        int v10 = b0Var.v();
                        i12 += v10;
                        if (v10 != 255) {
                            i10 = i12;
                            break;
                        }
                    } else {
                        i10 = -1;
                        break;
                    }
                }
                int i13 = 0;
                while (true) {
                    if (b0Var.f8416c - b0Var.f8415b != 0) {
                        int v11 = b0Var.v();
                        i13 += v11;
                        if (v11 != 255) {
                            break;
                        }
                    } else {
                        i13 = -1;
                        break;
                    }
                }
                int i14 = b0Var.f8415b;
                int i15 = i14 + i13;
                if (i13 == -1 || i13 > b0Var.f8416c - i14) {
                    v.g("CeaUtil", "Skipping remainder of malformed SEI NAL unit.");
                    i15 = b0Var.f8416c;
                } else if (i10 == 4 && i13 >= 8) {
                    int v12 = b0Var.v();
                    int A = b0Var.A();
                    if (A == 49) {
                        i11 = b0Var.f();
                    } else {
                        i11 = 0;
                    }
                    int v13 = b0Var.v();
                    if (A == 47) {
                        b0Var.H(1);
                    }
                    if (v12 == 181 && ((A == 49 || A == 47) && v13 == 3)) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    if (A == 49) {
                        if (i11 != 1195456820) {
                            z11 = false;
                        }
                        z10 &= z11;
                    }
                    if (z10) {
                        b(j10, b0Var, x0VarArr);
                    }
                }
                b0Var.G(i15);
            } else {
                return;
            }
        }
    }

    public static void b(long j10, b0 b0Var, x0[] x0VarArr) {
        boolean z10;
        int v10 = b0Var.v();
        if ((v10 & 64) != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            b0Var.H(1);
            int i10 = (v10 & 31) * 3;
            int i11 = b0Var.f8415b;
            for (x0 x0Var : x0VarArr) {
                b0Var.G(i11);
                x0Var.d(i10, b0Var);
                if (j10 != -9223372036854775807L) {
                    x0Var.e(j10, 1, i10, 0, (w0) null);
                }
            }
        }
    }
}
