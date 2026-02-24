package d2;

import g1.b1;
import j1.b0;
import j1.e;
import java.util.Collections;
import java.util.List;

public final class h0 {

    /* renamed from: a  reason: collision with root package name */
    public final List f4196a;

    /* renamed from: b  reason: collision with root package name */
    public final int f4197b;

    /* renamed from: c  reason: collision with root package name */
    public final float f4198c;

    /* renamed from: d  reason: collision with root package name */
    public final int f4199d;

    /* renamed from: e  reason: collision with root package name */
    public final int f4200e;

    /* renamed from: f  reason: collision with root package name */
    public final int f4201f;

    /* renamed from: g  reason: collision with root package name */
    public final String f4202g;

    public h0(List list, int i10, float f10, String str, int i11, int i12, int i13) {
        this.f4196a = list;
        this.f4197b = i10;
        this.f4198c = f10;
        this.f4202g = str;
        this.f4199d = i11;
        this.f4200e = i12;
        this.f4201f = i13;
    }

    public static h0 a(b0 b0Var) {
        List list;
        int i10;
        int i11;
        b0 b0Var2 = b0Var;
        try {
            b0Var2.H(21);
            int v10 = b0Var.v() & 3;
            int v11 = b0Var.v();
            int i12 = b0Var2.f8415b;
            int i13 = 0;
            int i14 = 0;
            for (int i15 = 0; i15 < v11; i15++) {
                b0Var2.H(1);
                int A = b0Var.A();
                for (int i16 = 0; i16 < A; i16++) {
                    int A2 = b0Var.A();
                    i14 += A2 + 4;
                    b0Var2.H(A2);
                }
            }
            b0Var2.G(i12);
            byte[] bArr = new byte[i14];
            String str = null;
            int i17 = 0;
            int i18 = 0;
            float f10 = 1.0f;
            int i19 = -1;
            int i20 = -1;
            int i21 = -1;
            while (i17 < v11) {
                int v12 = b0Var.v() & 63;
                int A3 = b0Var.A();
                int i22 = 0;
                while (i22 < A3) {
                    int A4 = b0Var.A();
                    int i23 = v11;
                    System.arraycopy(p0.f4278a, i13, bArr, i18, 4);
                    int i24 = i18 + 4;
                    System.arraycopy(b0Var2.f8414a, b0Var2.f8415b, bArr, i24, A4);
                    if (v12 == 33 && i22 == 0) {
                        m0 c10 = p0.c(bArr, i24, i24 + A4);
                        i19 = c10.f4239j;
                        int i25 = c10.f4240k;
                        int i26 = c10.f4241l;
                        i20 = i25;
                        i11 = v12;
                        i10 = A3;
                        i21 = i26;
                        f10 = c10.f4238i;
                        str = e.b(c10.f4230a, c10.f4231b, c10.f4232c, c10.f4233d, c10.f4234e, c10.f4235f);
                    } else {
                        i11 = v12;
                        i10 = A3;
                    }
                    i18 = i24 + A4;
                    b0Var2.H(A4);
                    i22++;
                    v11 = i23;
                    v12 = i11;
                    A3 = i10;
                    i13 = 0;
                }
                int i27 = v11;
                i17++;
                i13 = 0;
            }
            if (i14 == 0) {
                list = Collections.emptyList();
            } else {
                list = Collections.singletonList(bArr);
            }
            return new h0(list, v10 + 1, f10, str, i19, i20, i21);
        } catch (ArrayIndexOutOfBoundsException e10) {
            throw b1.a("Error parsing HEVC config", e10);
        }
    }
}
