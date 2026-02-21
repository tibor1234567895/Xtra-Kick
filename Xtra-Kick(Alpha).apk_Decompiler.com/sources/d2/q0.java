package d2;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;

public final class q0 {
    private q0() {
    }

    public static ArrayList a(byte[] bArr) {
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(bArr);
        arrayList.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong((((long) (((bArr[11] & 255) << 8) | (bArr[10] & 255))) * 1000000000) / 48000).array());
        arrayList.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(80000000).array());
        return arrayList;
    }

    public static long b(byte b10, byte b11) {
        byte b12;
        byte b13 = b10 & 255;
        byte b14 = b13 & 3;
        if (b14 != 0) {
            b12 = 2;
            if (!(b14 == 1 || b14 == 2)) {
                b12 = b11 & 63;
            }
        } else {
            b12 = 1;
        }
        int i10 = b13 >> 3;
        int i11 = i10 & 3;
        return ((long) b12) * ((long) (i10 >= 16 ? 2500 << i11 : i10 >= 12 ? 10000 << (i11 & 1) : i11 == 3 ? 60000 : 10000 << i11));
    }
}
