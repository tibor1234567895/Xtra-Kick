package a2;

import g1.b1;
import j1.z;
import java.io.FileNotFoundException;
import java.io.IOException;
import k1.w;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    public final int f54a;

    public i() {
        this(-1);
    }

    public static k a(j jVar, z zVar) {
        boolean z10;
        boolean z11;
        int i10;
        IOException iOException = (IOException) zVar.f8486d;
        boolean z12 = true;
        if ((iOException instanceof k1.z) && ((i10 = ((k1.z) iOException).f9070k) == 403 || i10 == 404 || i10 == 410 || i10 == 416 || i10 == 500 || i10 == 503)) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            return null;
        }
        if (jVar.f55a - jVar.f56b > 1) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return new k(1, 300000);
        }
        if (jVar.f57c - jVar.f58d <= 1) {
            z12 = false;
        }
        if (z12) {
            return new k(2, 60000);
        }
        return null;
    }

    public static long c(z zVar) {
        boolean z10;
        Throwable th = (IOException) zVar.f8486d;
        if (!(th instanceof b1) && !(th instanceof FileNotFoundException) && !(th instanceof w) && !(th instanceof p)) {
            int i10 = k1.i.f9006i;
            while (true) {
                if (th != null) {
                    if ((th instanceof k1.i) && ((k1.i) th).f9007h == 2008) {
                        z10 = true;
                        break;
                    }
                    th = th.getCause();
                } else {
                    z10 = false;
                    break;
                }
            }
            if (!z10) {
                return (long) Math.min((zVar.f8483a - 1) * 1000, 5000);
            }
        }
        return -9223372036854775807L;
    }

    public final int b(int i10) {
        int i11 = this.f54a;
        return i11 == -1 ? i10 == 7 ? 6 : 3 : i11;
    }

    public i(int i10) {
        this.f54a = i10;
    }
}
