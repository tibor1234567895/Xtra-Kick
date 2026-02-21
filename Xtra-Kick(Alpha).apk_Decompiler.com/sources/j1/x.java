package j1;

import android.media.MediaFormat;
import android.support.v4.media.h;
import java.nio.ByteBuffer;
import java.util.List;

public final class x {
    private x() {
    }

    public static void a(MediaFormat mediaFormat, String str, int i10) {
        if (i10 != -1) {
            mediaFormat.setInteger(str, i10);
        }
    }

    public static void b(MediaFormat mediaFormat, List list) {
        for (int i10 = 0; i10 < list.size(); i10++) {
            mediaFormat.setByteBuffer(h.i("csd-", i10), ByteBuffer.wrap((byte[]) list.get(i10)));
        }
    }
}
