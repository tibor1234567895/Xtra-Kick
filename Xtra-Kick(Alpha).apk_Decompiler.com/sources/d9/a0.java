package d9;

import c9.n;

public final class a0 {
    private a0() {
    }

    public static Object a(int i10) {
        if (i10 >= 2 && i10 <= 1073741824 && Integer.highestOneBit(i10) == i10) {
            return i10 <= 256 ? new byte[i10] : i10 <= 65536 ? new short[i10] : new int[i10];
        }
        StringBuilder sb2 = new StringBuilder(52);
        sb2.append("must be power of 2 between 2^1 and 2^30: ");
        sb2.append(i10);
        throw new IllegalArgumentException(sb2.toString());
    }

    public static int b(int i10) {
        return (i10 + 1) * (i10 < 32 ? 4 : 2);
    }

    public static int c(Object obj, Object obj2, int i10, Object obj3, int[] iArr, Object[] objArr, Object[] objArr2) {
        int i11;
        int i12;
        int b10 = h0.b(obj);
        int i13 = b10 & i10;
        int d10 = d(i13, obj3);
        if (d10 == 0) {
            return -1;
        }
        int i14 = ~i10;
        int i15 = b10 & i14;
        int i16 = -1;
        while (true) {
            i11 = d10 - 1;
            i12 = iArr[i11];
            if ((i12 & i14) != i15 || !n.a(obj, objArr[i11]) || (objArr2 != null && !n.a(obj2, objArr2[i11]))) {
                int i17 = i12 & i10;
                if (i17 == 0) {
                    return -1;
                }
                int i18 = i17;
                i16 = i11;
                d10 = i18;
            }
        }
        int i19 = i12 & i10;
        if (i16 == -1) {
            e(i13, i19, obj3);
        } else {
            iArr[i16] = (i19 & i10) | (iArr[i16] & i14);
        }
        return i11;
    }

    public static int d(int i10, Object obj) {
        return obj instanceof byte[] ? ((byte[]) obj)[i10] & 255 : obj instanceof short[] ? ((short[]) obj)[i10] & 65535 : ((int[]) obj)[i10];
    }

    public static void e(int i10, int i11, Object obj) {
        if (obj instanceof byte[]) {
            ((byte[]) obj)[i10] = (byte) i11;
        } else if (obj instanceof short[]) {
            ((short[]) obj)[i10] = (short) i11;
        } else {
            ((int[]) obj)[i10] = i11;
        }
    }
}
