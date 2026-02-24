package ec;

import dc.d0;
import dc.k0;
import fb.c;
import xa.j;

public abstract class k {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f5385a;

    static {
        byte[] bytes = "0123456789abcdef".getBytes(c.f5986b);
        j.e("this as java.lang.String).getBytes(charset)", bytes);
        f5385a = bytes;
    }

    public static final String a(dc.j jVar, long j10) {
        j.f("<this>", jVar);
        if (j10 > 0) {
            long j11 = j10 - 1;
            if (jVar.v(j11) == 13) {
                String H0 = jVar.H0(j11);
                jVar.a(2);
                return H0;
            }
        }
        String H02 = jVar.H0(j10);
        jVar.a(1);
        return H02;
    }

    public static final int b(dc.j jVar, d0 d0Var, boolean z10) {
        int i10;
        int i11;
        byte[] bArr;
        k0 k0Var;
        int i12;
        dc.j jVar2 = jVar;
        d0 d0Var2 = d0Var;
        j.f("<this>", jVar2);
        j.f("options", d0Var2);
        k0 k0Var2 = jVar2.f4786h;
        int i13 = -2;
        if (k0Var2 == null) {
            return z10 ? -2 : -1;
        }
        int i14 = k0Var2.f4789b;
        int i15 = k0Var2.f4790c;
        byte[] bArr2 = k0Var2.f4788a;
        k0 k0Var3 = k0Var2;
        int i16 = 0;
        int i17 = -1;
        loop0:
        while (true) {
            int i18 = i16 + 1;
            int[] iArr = d0Var2.f4751j;
            int i19 = iArr[i16];
            int i20 = i18 + 1;
            int i21 = iArr[i18];
            if (i21 != -1) {
                i17 = i21;
            }
            if (k0Var3 == null) {
                break;
            }
            if (i19 < 0) {
                int i22 = (i19 * -1) + i20;
                while (true) {
                    int i23 = i14 + 1;
                    int i24 = i20 + 1;
                    if ((bArr2[i14] & 255) != iArr[i20]) {
                        return i17;
                    }
                    boolean z11 = i24 == i22;
                    if (i23 == i15) {
                        j.c(k0Var3);
                        k0 k0Var4 = k0Var3.f4793f;
                        j.c(k0Var4);
                        i12 = k0Var4.f4789b;
                        int i25 = k0Var4.f4790c;
                        bArr = k0Var4.f4788a;
                        if (k0Var4 == k0Var2) {
                            if (!z11) {
                                break loop0;
                            }
                            i15 = i25;
                            k0Var = null;
                        } else {
                            int i26 = i25;
                            k0Var = k0Var4;
                            i15 = i26;
                        }
                    } else {
                        k0 k0Var5 = k0Var3;
                        bArr = bArr2;
                        i12 = i23;
                        k0Var = k0Var5;
                    }
                    if (z11) {
                        i10 = iArr[i24];
                        i11 = i12;
                        bArr2 = bArr;
                        k0Var3 = k0Var;
                        break;
                    }
                    i14 = i12;
                    bArr2 = bArr;
                    i20 = i24;
                    k0Var3 = k0Var;
                }
            } else {
                int i27 = i14 + 1;
                byte b10 = bArr2[i14] & 255;
                int i28 = i20 + i19;
                while (i20 != i28) {
                    if (b10 == iArr[i20]) {
                        i10 = iArr[i20 + i19];
                        if (i27 == i15) {
                            k0Var3 = k0Var3.f4793f;
                            j.c(k0Var3);
                            i11 = k0Var3.f4789b;
                            i15 = k0Var3.f4790c;
                            bArr2 = k0Var3.f4788a;
                            if (k0Var3 == k0Var2) {
                                k0Var3 = null;
                            }
                        } else {
                            i11 = i27;
                        }
                    } else {
                        i20++;
                    }
                }
                return i17;
            }
            if (i10 >= 0) {
                return i10;
            }
            i16 = -i10;
            i14 = i11;
            i13 = -2;
        }
        return z10 ? i13 : i17;
    }
}
