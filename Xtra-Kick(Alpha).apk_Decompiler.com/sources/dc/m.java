package dc;

import fb.c;
import hb.h0;
import ma.o;
import xa.j;

public final class m {
    private m() {
    }

    public /* synthetic */ m(int i10) {
        this();
    }

    public static n a(String str) {
        if (str.length() % 2 == 0) {
            int length = str.length() / 2;
            byte[] bArr = new byte[length];
            for (int i10 = 0; i10 < length; i10++) {
                int i11 = i10 * 2;
                bArr[i10] = (byte) (h0.c(str.charAt(i11 + 1)) + (h0.c(str.charAt(i11)) << 4));
            }
            return new n(bArr);
        }
        throw new IllegalArgumentException("Unexpected hex string: ".concat(str).toString());
    }

    public static n b(String str) {
        j.f("<this>", str);
        byte[] bytes = str.getBytes(c.f5986b);
        j.e("this as java.lang.String).getBytes(charset)", bytes);
        n nVar = new n(bytes);
        nVar.f4806j = str;
        return nVar;
    }

    public static n c(m mVar, byte[] bArr) {
        g gVar = w0.f4841a;
        mVar.getClass();
        int length = bArr.length;
        w0.b((long) bArr.length, (long) 0, (long) length);
        return new n(o.e(bArr, 0, length + 0));
    }
}
