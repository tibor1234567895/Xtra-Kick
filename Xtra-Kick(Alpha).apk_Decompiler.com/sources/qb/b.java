package qb;

import fb.l;
import fb.w;
import java.util.Arrays;
import ma.o;
import xa.j;

public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    public static final l f13476a = new l("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");

    public static final byte[] a(int i10, int i11, String str) {
        boolean z10;
        int i12 = i11;
        String str2 = str;
        j.f("input", str2);
        int i13 = 16;
        byte[] bArr = new byte[16];
        int i14 = -1;
        boolean z11 = false;
        int i15 = 0;
        int i16 = -1;
        int i17 = -1;
        int i18 = i10;
        while (true) {
            if (i18 >= i12) {
                break;
            } else if (i15 == i13) {
                return null;
            } else {
                int i19 = i18 + 2;
                if (i19 > i12 || !w.l(str2, "::", i18, z11)) {
                    if (i15 != 0) {
                        if (w.l(str2, Constants.EXT_TAG_END, i18, z11)) {
                            i18++;
                        } else if (!w.l(str2, ".", i18, z11)) {
                            return null;
                        } else {
                            int i20 = i15 - 2;
                            int i21 = i20;
                            loop1:
                            while (true) {
                                if (i17 < i12) {
                                    if (i21 == i13) {
                                        break;
                                    }
                                    if (i21 != i20) {
                                        if (str2.charAt(i17) != '.') {
                                            break;
                                        }
                                        i17++;
                                    }
                                    int i22 = i17;
                                    int i23 = 0;
                                    while (true) {
                                        if (i22 >= i12) {
                                            break;
                                        }
                                        char charAt = str2.charAt(i22);
                                        if (j.h(charAt, 48) >= 0 && j.h(charAt, 57) <= 0) {
                                            if ((i23 == 0 && i17 != i22) || (i23 = ((i23 * 10) + charAt) - 48) > 255) {
                                                break loop1;
                                            }
                                            i22++;
                                        } else {
                                            break;
                                        }
                                    }
                                    if (i22 - i17 == 0) {
                                        break;
                                    }
                                    bArr[i21] = (byte) i23;
                                    i21++;
                                    i17 = i22;
                                    i13 = 16;
                                } else if (i21 == i20 + 4) {
                                    z10 = true;
                                }
                            }
                            z10 = false;
                            if (!z10) {
                                return null;
                            }
                            i15 += 2;
                        }
                    }
                    i17 = i18;
                } else if (i16 != i14) {
                    return null;
                } else {
                    i15 += 2;
                    i16 = i15;
                    if (i19 == i12) {
                        break;
                    }
                    i17 = i19;
                }
                i18 = i17;
                int i24 = 0;
                while (i18 < i12) {
                    int l10 = f.l(str2.charAt(i18));
                    if (l10 == -1) {
                        break;
                    }
                    i24 = (i24 << 4) + l10;
                    i18++;
                }
                int i25 = i18 - i17;
                if (i25 == 0 || i25 > 4) {
                    return null;
                }
                int i26 = i15 + 1;
                bArr[i15] = (byte) ((i24 >>> 8) & 255);
                i15 = i26 + 1;
                bArr[i26] = (byte) (i24 & 255);
                i13 = 16;
                i14 = -1;
                z11 = false;
            }
        }
        if (i15 != 16) {
            if (i16 == -1) {
                return null;
            }
            o.c(16 - (i15 - i16), i16, i15, bArr, bArr);
            Arrays.fill(bArr, i16, (16 - i15) + i16, (byte) 0);
        }
        return bArr;
    }
}
