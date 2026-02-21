package ma;

import java.util.Arrays;
import java.util.List;
import wb.j0;
import xa.j;

public class o extends n {
    public static final List b(Object[] objArr) {
        j.f("<this>", objArr);
        List asList = Arrays.asList(objArr);
        j.e("asList(this)", asList);
        return asList;
    }

    public static final void c(int i10, int i11, int i12, byte[] bArr, byte[] bArr2) {
        j.f("<this>", bArr);
        j.f("destination", bArr2);
        System.arraycopy(bArr, i11, bArr2, i10, i12 - i11);
    }

    public static final void d(int i10, int i11, int i12, Object[] objArr, Object[] objArr2) {
        j.f("<this>", objArr);
        j.f("destination", objArr2);
        System.arraycopy(objArr, i11, objArr2, i10, i12 - i11);
    }

    public static final byte[] e(byte[] bArr, int i10, int i11) {
        j.f("<this>", bArr);
        m.a(i11, bArr.length);
        byte[] copyOfRange = Arrays.copyOfRange(bArr, i10, i11);
        j.e("copyOfRange(this, fromIndex, toIndex)", copyOfRange);
        return copyOfRange;
    }

    public static final void f(Object[] objArr, j0 j0Var, int i10, int i11) {
        j.f("<this>", objArr);
        Arrays.fill(objArr, i10, i11, j0Var);
    }
}
