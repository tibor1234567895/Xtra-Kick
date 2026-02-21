package e9;

import java.io.InputStream;
import java.util.ArrayDeque;

public final class b {
    static {
        new a();
    }

    private b() {
    }

    public static byte[] a(InputStream inputStream) {
        byte[] bArr;
        inputStream.getClass();
        ArrayDeque arrayDeque = new ArrayDeque(20);
        int i10 = 8192;
        int i11 = 0;
        while (true) {
            if (i11 < 2147483639) {
                int min = Math.min(i10, 2147483639 - i11);
                byte[] bArr2 = new byte[min];
                arrayDeque.add(bArr2);
                int i12 = 0;
                while (i12 < min) {
                    int read = inputStream.read(bArr2, i12, min - i12);
                    if (read == -1) {
                        bArr = new byte[i11];
                        int i13 = i11;
                        while (i13 > 0) {
                            byte[] bArr3 = (byte[]) arrayDeque.remove();
                            int min2 = Math.min(i13, bArr3.length);
                            System.arraycopy(bArr3, 0, bArr, i11 - i13, min2);
                            i13 -= min2;
                        }
                    } else {
                        i12 += read;
                        i11 += read;
                    }
                }
                i10 = g9.b.c(((long) i10) * ((long) 2));
            } else if (inputStream.read() == -1) {
                bArr = new byte[2147483639];
                int i14 = 2147483639;
                while (i14 > 0) {
                    byte[] bArr4 = (byte[]) arrayDeque.remove();
                    int min3 = Math.min(i14, bArr4.length);
                    System.arraycopy(bArr4, 0, bArr, 2147483639 - i14, min3);
                    i14 -= min3;
                }
            } else {
                throw new OutOfMemoryError("input is too large to fit in a byte array");
            }
        }
        return bArr;
    }
}
