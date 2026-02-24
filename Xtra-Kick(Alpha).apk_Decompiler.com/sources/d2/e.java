package d2;

import g1.b1;
import j1.b0;
import java.util.ArrayList;
import java.util.List;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public final List f4157a;

    /* renamed from: b  reason: collision with root package name */
    public final int f4158b;

    /* renamed from: c  reason: collision with root package name */
    public final int f4159c;

    /* renamed from: d  reason: collision with root package name */
    public final int f4160d;

    /* renamed from: e  reason: collision with root package name */
    public final float f4161e;

    /* renamed from: f  reason: collision with root package name */
    public final String f4162f;

    public e(ArrayList arrayList, int i10, int i11, int i12, float f10, String str) {
        this.f4157a = arrayList;
        this.f4158b = i10;
        this.f4159c = i11;
        this.f4160d = i12;
        this.f4161e = f10;
        this.f4162f = str;
    }

    public static e a(b0 b0Var) {
        byte[] bArr;
        String str;
        float f10;
        int i10;
        int i11;
        try {
            b0Var.H(4);
            int v10 = (b0Var.v() & 3) + 1;
            if (v10 != 3) {
                ArrayList arrayList = new ArrayList();
                int v11 = b0Var.v() & 31;
                int i12 = 0;
                while (true) {
                    bArr = j1.e.f8421a;
                    if (i12 >= v11) {
                        break;
                    }
                    int A = b0Var.A();
                    int i13 = b0Var.f8415b;
                    b0Var.H(A);
                    byte[] bArr2 = b0Var.f8414a;
                    byte[] bArr3 = new byte[(A + 4)];
                    System.arraycopy(bArr, 0, bArr3, 0, 4);
                    System.arraycopy(bArr2, i13, bArr3, 4, A);
                    arrayList.add(bArr3);
                    i12++;
                }
                int v12 = b0Var.v();
                for (int i14 = 0; i14 < v12; i14++) {
                    int A2 = b0Var.A();
                    int i15 = b0Var.f8415b;
                    b0Var.H(A2);
                    byte[] bArr4 = b0Var.f8414a;
                    byte[] bArr5 = new byte[(A2 + 4)];
                    System.arraycopy(bArr, 0, bArr5, 0, 4);
                    System.arraycopy(bArr4, i15, bArr5, 4, A2);
                    arrayList.add(bArr5);
                }
                if (v11 > 0) {
                    o0 e10 = p0.e((byte[]) arrayList.get(0), v10, ((byte[]) arrayList.get(0)).length);
                    int i16 = e10.f4262e;
                    int i17 = e10.f4263f;
                    float f11 = e10.f4264g;
                    str = j1.e.a(e10.f4258a, e10.f4259b, e10.f4260c);
                    i11 = i16;
                    i10 = i17;
                    f10 = f11;
                } else {
                    str = null;
                    i11 = -1;
                    i10 = -1;
                    f10 = 1.0f;
                }
                return new e(arrayList, v10, i11, i10, f10, str);
            }
            throw new IllegalStateException();
        } catch (ArrayIndexOutOfBoundsException e11) {
            throw b1.a("Error parsing AVC config", e11);
        }
    }
}
