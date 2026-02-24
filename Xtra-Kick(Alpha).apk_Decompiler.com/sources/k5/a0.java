package k5;

import b5.f;
import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import e5.k;
import j4.n;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicReference;
import w5.a;
import x0.g;

public final class a0 implements f {
    public final ImageHeaderParser$ImageType a(ByteBuffer byteBuffer) {
        return ImageHeaderParser$ImageType.UNKNOWN;
    }

    public final int b(InputStream inputStream, k kVar) {
        int c10 = new g(inputStream).c();
        if (c10 == 0) {
            return -1;
        }
        return c10;
    }

    public final ImageHeaderParser$ImageType c(InputStream inputStream) {
        return ImageHeaderParser$ImageType.UNKNOWN;
    }

    public final int d(ByteBuffer byteBuffer, k kVar) {
        AtomicReference atomicReference = a.f16106a;
        return b(new n(byteBuffer), kVar);
    }
}
