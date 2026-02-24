package tb;

import java.io.IOException;
import la.a;

public final class c0 implements h {

    /* renamed from: a  reason: collision with root package name */
    public final v f14930a;

    public c0(v vVar) {
        this.f14930a = vVar;
    }

    public final r a() {
        boolean z10;
        IOException iOException = null;
        while (!this.f14930a.f15029c.f14995w) {
            try {
                z b10 = this.f14930a.b();
                if (!b10.b()) {
                    y f10 = b10.f();
                    if (f10.f15039b == null && f10.f15040c == null) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    if (z10) {
                        f10 = b10.c();
                    }
                    z zVar = f10.f15039b;
                    Throwable th = f10.f15040c;
                    if (th != null) {
                        throw th;
                    } else if (zVar != null) {
                        this.f14930a.f15034h.c(zVar);
                    }
                }
                return b10.d();
            } catch (IOException e10) {
                if (iOException == null) {
                    iOException = e10;
                } else {
                    a.a(iOException, e10);
                }
                if (!this.f14930a.a((r) null)) {
                    throw iOException;
                }
            }
        }
        throw new IOException("Canceled");
    }

    public final v b() {
        return this.f14930a;
    }
}
