package d2;

import android.support.v4.media.n;
import j1.b0;
import java.util.Arrays;

public final class d0 {
    private d0() {
    }

    public static n a(b0 b0Var) {
        b0Var.H(1);
        int x10 = b0Var.x();
        long j10 = ((long) b0Var.f8415b) + ((long) x10);
        int i10 = x10 / 18;
        long[] jArr = new long[i10];
        long[] jArr2 = new long[i10];
        int i11 = 0;
        while (true) {
            if (i11 >= i10) {
                break;
            }
            long o10 = b0Var.o();
            if (o10 == -1) {
                jArr = Arrays.copyOf(jArr, i11);
                jArr2 = Arrays.copyOf(jArr2, i11);
                break;
            }
            jArr[i11] = o10;
            jArr2[i11] = b0Var.o();
            b0Var.H(2);
            i11++;
        }
        b0Var.H((int) (j10 - ((long) b0Var.f8415b)));
        return new n((Object) jArr, 14, (Object) jArr2);
    }
}
