package j2;

import g1.z0;
import j1.a;
import java.nio.ByteBuffer;

public abstract class b {
    public final z0 a(a aVar) {
        boolean z10;
        ByteBuffer byteBuffer = aVar.f9515j;
        byteBuffer.getClass();
        if (byteBuffer.position() == 0 && byteBuffer.hasArray() && byteBuffer.arrayOffset() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        a.b(z10);
        if (aVar.g()) {
            return null;
        }
        return b(aVar, byteBuffer);
    }

    public abstract z0 b(a aVar, ByteBuffer byteBuffer);
}
