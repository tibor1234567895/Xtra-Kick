package u2;

import d2.w;
import j1.b0;

public final class t {

    /* renamed from: a  reason: collision with root package name */
    public static final int[] f15304a = {1769172845, 1769172786, 1769172787, 1769172788, 1769172789, 1769172790, 1769172793, 1635148593, 1752589105, 1751479857, 1635135537, 1836069937, 1836069938, 862401121, 862401122, 862417462, 862417718, 862414134, 862414646, 1295275552, 1295270176, 1714714144, 1801741417, 1295275600, 1903435808, 1297305174, 1684175153, 1769172332, 1885955686};

    private t() {
    }

    public static boolean a(w wVar, boolean z10, boolean z11) {
        boolean z12;
        boolean z13;
        int i10;
        long j10;
        boolean z14;
        w wVar2 = wVar;
        long c10 = wVar.c();
        long j11 = 4096;
        long j12 = -1;
        int i11 = (c10 > -1 ? 1 : (c10 == -1 ? 0 : -1));
        if (i11 != 0 && c10 <= 4096) {
            j11 = c10;
        }
        int i12 = (int) j11;
        b0 b0Var = new b0(64);
        boolean z15 = false;
        int i13 = 0;
        boolean z16 = false;
        while (true) {
            if (i13 >= i12) {
                break;
            }
            b0Var.D(8);
            if (!wVar2.k(b0Var.f8414a, z15 ? 1 : 0, 8, true)) {
                break;
            }
            long w10 = b0Var.w();
            int f10 = b0Var.f();
            if (w10 == 1) {
                wVar2.m(b0Var.f8414a, 8, 8);
                i10 = 16;
                b0Var.F(16);
                j10 = b0Var.o();
            } else {
                if (w10 == 0) {
                    long c11 = wVar.c();
                    if (c11 != j12) {
                        w10 = (c11 - wVar.l()) + ((long) 8);
                    }
                }
                j10 = w10;
                i10 = 8;
            }
            long j13 = (long) i10;
            if (j10 < j13) {
                return z15;
            }
            i13 += i10;
            if (f10 == 1836019574) {
                i12 += (int) j10;
                if (i11 != 0 && ((long) i12) > c10) {
                    i12 = (int) c10;
                }
                j12 = -1;
            } else if (f10 == 1836019558 || f10 == 1836475768) {
                z12 = true;
                z13 = true;
            } else {
                int i14 = f10;
                int i15 = i13;
                if ((((long) i13) + j10) - j13 >= ((long) i12)) {
                    break;
                }
                int i16 = (int) (j10 - j13);
                i13 = i15 + i16;
                if (i14 == 1718909296) {
                    if (i16 < 8) {
                        return false;
                    }
                    b0Var.D(i16);
                    wVar2.m(b0Var.f8414a, 0, i16);
                    int i17 = i16 / 4;
                    int i18 = 0;
                    while (true) {
                        if (i18 >= i17) {
                            break;
                        }
                        if (i18 == 1) {
                            b0Var.H(4);
                        } else {
                            int f11 = b0Var.f();
                            if ((f11 >>> 8) != 3368816 && (f11 != 1751476579 || !z11)) {
                                int[] iArr = f15304a;
                                int i19 = 0;
                                while (true) {
                                    if (i19 >= 29) {
                                        z14 = false;
                                        break;
                                    } else if (iArr[i19] == f11) {
                                        break;
                                    } else {
                                        i19++;
                                    }
                                }
                            }
                            z14 = true;
                            if (z14) {
                                z16 = true;
                                break;
                            }
                        }
                        i18++;
                    }
                    if (!z16) {
                        return false;
                    }
                } else if (i16 != 0) {
                    wVar2.n(i16);
                }
                j12 = -1;
                z15 = false;
            }
        }
        z12 = true;
        z13 = false;
        if (!z16 || z10 != z13) {
            return false;
        }
        return z12;
    }
}
