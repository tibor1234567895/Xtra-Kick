package d2;

import android.support.v4.media.h;
import g1.b1;
import j1.a0;
import j1.k;
import j1.v;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final int[] f4135a = {96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, 8000, 7350};

    /* renamed from: b  reason: collision with root package name */
    public static final int[] f4136b = {0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1};

    private a() {
    }

    public static int a(a0 a0Var) {
        int g10 = a0Var.g(4);
        if (g10 == 15) {
            if (a0Var.b() >= 24) {
                return a0Var.g(24);
            }
            throw b1.a("AAC header insufficient data", (Exception) null);
        } else if (g10 < 13) {
            return f4135a[g10];
        } else {
            throw b1.a("AAC header wrong Sampling Frequency Index", (Exception) null);
        }
    }

    public static k b(a0 a0Var, boolean z10) {
        int g10 = a0Var.g(5);
        if (g10 == 31) {
            g10 = a0Var.g(6) + 32;
        }
        int a10 = a(a0Var);
        int g11 = a0Var.g(4);
        String i10 = h.i("mp4a.40.", g10);
        if (g10 == 5 || g10 == 29) {
            a10 = a(a0Var);
            int g12 = a0Var.g(5);
            if (g12 == 31) {
                g12 = a0Var.g(6) + 32;
            }
            g10 = g12;
            if (g10 == 22) {
                g11 = a0Var.g(4);
            }
        }
        if (z10) {
            if (!(g10 == 1 || g10 == 2 || g10 == 3 || g10 == 4 || g10 == 6 || g10 == 7 || g10 == 17)) {
                switch (g10) {
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                        break;
                    default:
                        throw b1.c("Unsupported audio object type: " + g10);
                }
            }
            if (a0Var.f()) {
                v.g("AacUtil", "Unexpected frameLengthFlag = 1");
            }
            if (a0Var.f()) {
                a0Var.m(14);
            }
            boolean f10 = a0Var.f();
            if (g11 != 0) {
                if (g10 == 6 || g10 == 20) {
                    a0Var.m(3);
                }
                if (f10) {
                    if (g10 == 22) {
                        a0Var.m(16);
                    }
                    if (g10 == 17 || g10 == 19 || g10 == 20 || g10 == 23) {
                        a0Var.m(3);
                    }
                    a0Var.m(1);
                }
                switch (g10) {
                    case 17:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                        int g13 = a0Var.g(2);
                        if (g13 == 2 || g13 == 3) {
                            throw b1.c("Unsupported epConfig: " + g13);
                        }
                }
            } else {
                throw new UnsupportedOperationException();
            }
        }
        int i11 = f4136b[g11];
        if (i11 != -1) {
            return new k(a10, i11, i10);
        }
        throw b1.a((String) null, (Exception) null);
    }
}
