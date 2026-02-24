package dc;

import java.io.OutputStream;
import xa.j;

public final class i extends OutputStream {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ j f4782h;

    public i(j jVar) {
        this.f4782h = jVar;
    }

    public final void close() {
    }

    public final void flush() {
    }

    public final String toString() {
        return this.f4782h + ".outputStream()";
    }

    public final void write(int i10) {
        this.f4782h.Q0(i10);
    }

    public final void write(byte[] bArr, int i10, int i11) {
        j.f("data", bArr);
        this.f4782h.P0(bArr, i10, i11);
    }
}
