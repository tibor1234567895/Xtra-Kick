package p5;

import b5.n;
import d5.o0;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicReference;
import k5.h0;
import o5.e;
import w0.c;
import w5.a;

public final class b implements c {
    public final o0 d(o0 o0Var, n nVar) {
        c cVar;
        byte[] bArr;
        ByteBuffer asReadOnlyBuffer = ((e) o0Var.get()).f12201h.f12200a.f12216a.getData().asReadOnlyBuffer();
        AtomicReference atomicReference = a.f16106a;
        if (asReadOnlyBuffer.isReadOnly() || !asReadOnlyBuffer.hasArray()) {
            cVar = null;
        } else {
            cVar = new c(asReadOnlyBuffer.array(), asReadOnlyBuffer.arrayOffset(), asReadOnlyBuffer.limit());
        }
        if (cVar != null && cVar.f16017a == 0 && cVar.f16018b == ((byte[]) cVar.f16019c).length) {
            bArr = asReadOnlyBuffer.array();
        } else {
            ByteBuffer asReadOnlyBuffer2 = asReadOnlyBuffer.asReadOnlyBuffer();
            byte[] bArr2 = new byte[asReadOnlyBuffer2.limit()];
            ByteBuffer byteBuffer = (ByteBuffer) asReadOnlyBuffer2.position(0);
            asReadOnlyBuffer2.get(bArr2);
            bArr = bArr2;
        }
        return new h0(bArr);
    }
}
