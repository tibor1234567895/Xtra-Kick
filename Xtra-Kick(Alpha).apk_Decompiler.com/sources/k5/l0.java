package k5;

import b5.l;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

public final class l0 implements l {

    /* renamed from: a  reason: collision with root package name */
    public final ByteBuffer f9165a = ByteBuffer.allocate(4);

    public final void a(byte[] bArr, Object obj, MessageDigest messageDigest) {
        Integer num = (Integer) obj;
        if (num != null) {
            messageDigest.update(bArr);
            synchronized (this.f9165a) {
                this.f9165a.position(0);
                messageDigest.update(this.f9165a.putInt(num.intValue()).array());
            }
        }
    }
}
