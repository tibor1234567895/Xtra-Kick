package k1;

import c9.b;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;

public class x extends i {

    /* renamed from: j  reason: collision with root package name */
    public final int f9069j;

    public x() {
        super(2008);
        this.f9069j = 1;
    }

    public static x a(IOException iOException, int i10) {
        String message = iOException.getMessage();
        int i11 = iOException instanceof SocketTimeoutException ? 2002 : iOException instanceof InterruptedIOException ? 1004 : (message == null || !b.a(message).matches("cleartext.*not permitted.*")) ? 2001 : 2007;
        return i11 == 2007 ? new w(iOException) : new x(iOException, i11, i10);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public x(java.io.IOException r2, int r3, int r4) {
        /*
            r1 = this;
            r0 = 2000(0x7d0, float:2.803E-42)
            if (r3 != r0) goto L_0x0009
            r0 = 1
            if (r4 != r0) goto L_0x0009
            r3 = 2001(0x7d1, float:2.804E-42)
        L_0x0009:
            r1.<init>((java.lang.Throwable) r2, (int) r3)
            r1.f9069j = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: k1.x.<init>(java.io.IOException, int, int):void");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public x(String str, int i10) {
        super(str, i10 == 2000 ? 2001 : i10);
        this.f9069j = 1;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public x(String str, IOException iOException, int i10) {
        super(i10 == 2000 ? 2001 : i10, str, iOException);
        this.f9069j = 1;
    }
}
