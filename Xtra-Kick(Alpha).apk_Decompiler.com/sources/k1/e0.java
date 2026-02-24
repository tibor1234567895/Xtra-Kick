package k1;

import android.net.Uri;
import java.util.Collections;
import java.util.Map;

public final class e0 implements h {

    /* renamed from: a  reason: collision with root package name */
    public final h f8990a;

    /* renamed from: b  reason: collision with root package name */
    public long f8991b;

    /* renamed from: c  reason: collision with root package name */
    public Uri f8992c = Uri.EMPTY;

    public e0(h hVar) {
        hVar.getClass();
        this.f8990a = hVar;
        Collections.emptyMap();
    }

    public final void close() {
        this.f8990a.close();
    }

    public final Map e() {
        return this.f8990a.e();
    }

    public final void i(f0 f0Var) {
        f0Var.getClass();
        this.f8990a.i(f0Var);
    }

    public final Uri j() {
        return this.f8990a.j();
    }

    public final int o(byte[] bArr, int i10, int i11) {
        int o10 = this.f8990a.o(bArr, i10, i11);
        if (o10 != -1) {
            this.f8991b += (long) o10;
        }
        return o10;
    }

    public final long q(m mVar) {
        this.f8992c = mVar.f9022a;
        Collections.emptyMap();
        long q10 = this.f8990a.q(mVar);
        Uri j10 = j();
        j10.getClass();
        this.f8992c = j10;
        e();
        return q10;
    }
}
