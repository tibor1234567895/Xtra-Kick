package o1;

import h1.a;
import h1.b;
import java.nio.ByteBuffer;

public final class h0 extends q {

    /* renamed from: i  reason: collision with root package name */
    public static final int f11930i = Float.floatToIntBits(Float.NaN);

    public final void e(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2;
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i10 = limit - position;
        int i11 = this.f12030b.f6880c;
        int i12 = f11930i;
        if (i11 == 536870912) {
            byteBuffer2 = l((i10 / 3) * 4);
            while (position < limit) {
                int floatToIntBits = Float.floatToIntBits((float) (((double) (((byteBuffer.get(position) & 255) << 8) | ((byteBuffer.get(position + 1) & 255) << 16) | ((byteBuffer.get(position + 2) & 255) << 24))) * 4.656612875245797E-10d));
                if (floatToIntBits == i12) {
                    floatToIntBits = Float.floatToIntBits(0.0f);
                }
                byteBuffer2.putInt(floatToIntBits);
                position += 3;
            }
        } else if (i11 == 805306368) {
            byteBuffer2 = l(i10);
            while (position < limit) {
                int floatToIntBits2 = Float.floatToIntBits((float) (((double) ((byteBuffer.get(position) & 255) | ((byteBuffer.get(position + 1) & 255) << 8) | ((byteBuffer.get(position + 2) & 255) << 16) | ((byteBuffer.get(position + 3) & 255) << 24))) * 4.656612875245797E-10d));
                if (floatToIntBits2 == i12) {
                    floatToIntBits2 = Float.floatToIntBits(0.0f);
                }
                byteBuffer2.putInt(floatToIntBits2);
                position += 4;
            }
        } else {
            throw new IllegalStateException();
        }
        byteBuffer.position(byteBuffer.limit());
        byteBuffer2.flip();
    }

    public final a h(a aVar) {
        int i10 = aVar.f6880c;
        if (i10 == 536870912 || i10 == 805306368 || i10 == 4) {
            return i10 != 4 ? new a(aVar.f6878a, aVar.f6879b, 4) : a.f6877e;
        }
        throw new b(aVar);
    }
}
