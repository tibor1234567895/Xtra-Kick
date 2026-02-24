package pb;

import fb.y;
import hb.h0;
import java.util.Arrays;
import xa.j;

public final class o0 {
    private o0() {
    }

    public /* synthetic */ o0(int i10) {
        this();
    }

    public static p0 a(String... strArr) {
        boolean z10;
        boolean z11;
        String[] strArr2 = (String[]) Arrays.copyOf(strArr, strArr.length);
        j.f("inputNamesAndValues", strArr2);
        int i10 = 0;
        if (strArr2.length % 2 == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            String[] strArr3 = (String[]) Arrays.copyOf(strArr2, strArr2.length);
            int length = strArr3.length;
            int i11 = 0;
            while (i11 < length) {
                if (strArr3[i11] != null) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z11) {
                    strArr3[i11] = y.R(strArr2[i11]).toString();
                    i11++;
                } else {
                    throw new IllegalArgumentException("Headers cannot be null".toString());
                }
            }
            int B0 = h0.B0(0, strArr3.length - 1, 2);
            if (B0 >= 0) {
                while (true) {
                    String str = strArr3[i10];
                    String str2 = strArr3[i10 + 1];
                    h0.N0(str);
                    h0.O0(str2, str);
                    if (i10 == B0) {
                        break;
                    }
                    i10 += 2;
                }
            }
            return new p0(strArr3);
        }
        throw new IllegalArgumentException("Expected alternating header names and values".toString());
    }
}
