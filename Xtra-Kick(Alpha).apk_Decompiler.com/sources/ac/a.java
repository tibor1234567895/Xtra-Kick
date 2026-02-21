package ac;

import fb.c;
import qb.f;

public final class a {
    private a() {
    }

    public /* synthetic */ a(int i10) {
        this();
    }

    public static final String a(a aVar, byte[] bArr, byte[][] bArr2, int i10) {
        int i11;
        boolean z10;
        byte b10;
        int i12;
        byte[] bArr3 = bArr;
        byte[][] bArr4 = bArr2;
        aVar.getClass();
        int length = bArr3.length;
        int i13 = 0;
        while (i13 < length) {
            int i14 = (i13 + length) / 2;
            while (i14 > -1 && bArr3[i14] != ((byte) 10)) {
                i14--;
            }
            int i15 = i14 + 1;
            int i16 = 1;
            while (true) {
                i11 = i15 + i16;
                if (bArr3[i11] == ((byte) 10)) {
                    break;
                }
                i16++;
            }
            int i17 = i11 - i15;
            int i18 = i10;
            boolean z11 = false;
            int i19 = 0;
            int i20 = 0;
            while (true) {
                if (z11) {
                    b10 = 46;
                    z10 = false;
                } else {
                    byte b11 = bArr4[i18][i19];
                    byte[] bArr5 = f.f13487a;
                    byte b12 = b11 & 255;
                    z10 = z11;
                    b10 = b12;
                }
                byte b13 = bArr3[i15 + i20];
                byte[] bArr6 = f.f13487a;
                i12 = b10 - (b13 & 255);
                if (i12 != 0) {
                    break;
                }
                i20++;
                i19++;
                if (i20 == i17) {
                    break;
                } else if (bArr4[i18].length != i19) {
                    z11 = z10;
                } else if (i18 == bArr4.length - 1) {
                    break;
                } else {
                    i18++;
                    z11 = true;
                    i19 = -1;
                }
            }
            if (i12 >= 0) {
                if (i12 <= 0) {
                    int i21 = i17 - i20;
                    int length2 = bArr4[i18].length - i19;
                    int length3 = bArr4.length;
                    for (int i22 = i18 + 1; i22 < length3; i22++) {
                        length2 += bArr4[i22].length;
                    }
                    if (length2 >= i21) {
                        if (length2 <= i21) {
                            return new String(bArr3, i15, i17, c.f5986b);
                        }
                    }
                }
                i13 = i11 + 1;
            }
            length = i15 - 1;
        }
        return null;
    }
}
