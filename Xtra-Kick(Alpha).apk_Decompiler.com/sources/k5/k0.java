package k5;

import b5.l;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

public final class k0 implements l {

    /* renamed from: a  reason: collision with root package name */
    public final ByteBuffer f9164a = ByteBuffer.allocate(8);

    public final void a(byte[] bArr, Object obj, MessageDigest messageDigest) {
        Long l10 = (Long) obj;
        messageDigest.update(bArr);
        synchronized (this.f9164a) {
            this.f9164a.position(0);
            messageDigest.update(this.f9164a.putLong(l10.longValue()).array());
        }
    }
}
