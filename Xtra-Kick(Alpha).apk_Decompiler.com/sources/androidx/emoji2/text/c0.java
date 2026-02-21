package androidx.emoji2.text;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import v0.b;

public final class c0 {
    private c0() {
    }

    public static b a(MappedByteBuffer mappedByteBuffer) {
        long j10;
        ByteBuffer duplicate = mappedByteBuffer.duplicate();
        b0 b0Var = new b0(0, duplicate);
        b0Var.k(4);
        ByteBuffer byteBuffer = b0Var.f1246b;
        short s10 = byteBuffer.getShort() & 65535;
        if (s10 <= 100) {
            b0Var.k(6);
            int i10 = 0;
            while (true) {
                if (i10 >= s10) {
                    j10 = -1;
                    break;
                }
                int i11 = byteBuffer.getInt();
                b0Var.k(4);
                j10 = b0Var.j();
                b0Var.k(4);
                if (1835365473 == i11) {
                    break;
                }
                i10++;
            }
            if (j10 != -1) {
                b0Var.k((int) (j10 - ((long) byteBuffer.position())));
                b0Var.k(12);
                long j11 = b0Var.j();
                for (int i12 = 0; ((long) i12) < j11; i12++) {
                    int i13 = byteBuffer.getInt();
                    long j12 = b0Var.j();
                    b0Var.j();
                    if (1164798569 == i13 || 1701669481 == i13) {
                        duplicate.position((int) (j12 + j10));
                        b bVar = new b();
                        duplicate.order(ByteOrder.LITTLE_ENDIAN);
                        int position = duplicate.position() + duplicate.getInt(duplicate.position());
                        bVar.f15552b = duplicate;
                        bVar.f15551a = position;
                        int i14 = position - duplicate.getInt(position);
                        bVar.f15553c = i14;
                        bVar.f15554d = bVar.f15552b.getShort(i14);
                        return bVar;
                    }
                }
            }
            throw new IOException("Cannot read metadata.");
        }
        throw new IOException("Cannot read metadata.");
    }
}
