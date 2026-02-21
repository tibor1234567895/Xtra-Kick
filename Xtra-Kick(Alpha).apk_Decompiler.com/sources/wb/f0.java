package wb;

import android.support.v4.media.h;
import androidx.lifecycle.p1;
import dc.e;
import java.io.IOException;
import java.net.SocketTimeoutException;
import la.v;
import sb.c;

public final class f0 extends e {

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ g0 f16228n;

    public f0(g0 g0Var) {
        this.f16228n = g0Var;
    }

    public final IOException k(IOException iOException) {
        SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
        if (iOException != null) {
            socketTimeoutException.initCause(iOException);
        }
        return socketTimeoutException;
    }

    public final void l() {
        this.f16228n.e(c.CANCEL);
        v vVar = this.f16228n.f16239b;
        synchronized (vVar) {
            long j10 = vVar.f16326w;
            long j11 = vVar.f16325v;
            if (j10 >= j11) {
                vVar.f16325v = j11 + 1;
                vVar.f16327x = System.nanoTime() + ((long) 1000000000);
                v vVar2 = v.f9814a;
                c.c(vVar.f16319p, h.p(new StringBuilder(), vVar.f16314k, " ping"), 0, new p1(28, vVar), 6);
            }
        }
    }

    public final void m() {
        if (j()) {
            throw k((IOException) null);
        }
    }
}
