package dc;

import java.io.IOException;
import java.io.InputStream;
import xa.j;

public final class h extends InputStream {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f4777h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ l f4778i;

    public /* synthetic */ h(l lVar, int i10) {
        this.f4777h = i10;
        this.f4778i = lVar;
    }

    public final int available() {
        long min;
        int i10 = this.f4777h;
        l lVar = this.f4778i;
        switch (i10) {
            case 0:
                min = Math.min(((j) lVar).f4787i, (long) Integer.MAX_VALUE);
                break;
            default:
                i0 i0Var = (i0) lVar;
                if (!i0Var.f4785j) {
                    min = Math.min(i0Var.f4784i.f4787i, (long) Integer.MAX_VALUE);
                    break;
                } else {
                    throw new IOException("closed");
                }
        }
        return (int) min;
    }

    public final void close() {
        switch (this.f4777h) {
            case 0:
                return;
            default:
                ((i0) this.f4778i).close();
                return;
        }
    }

    public final int read() {
        int i10 = this.f4777h;
        l lVar = this.f4778i;
        switch (i10) {
            case 0:
                j jVar = (j) lVar;
                if (jVar.f4787i > 0) {
                    return jVar.readByte() & 255;
                }
                return -1;
            default:
                i0 i0Var = (i0) lVar;
                if (!i0Var.f4785j) {
                    j jVar2 = i0Var.f4784i;
                    if (jVar2.f4787i == 0 && i0Var.f4783h.read(jVar2, 8192) == -1) {
                        return -1;
                    }
                    return jVar2.readByte() & 255;
                }
                throw new IOException("closed");
        }
    }

    public final String toString() {
        int i10 = this.f4777h;
        l lVar = this.f4778i;
        switch (i10) {
            case 0:
                return ((j) lVar) + ".inputStream()";
            default:
                return ((i0) lVar) + ".inputStream()";
        }
    }

    public final int read(byte[] bArr, int i10, int i11) {
        int i12 = this.f4777h;
        l lVar = this.f4778i;
        switch (i12) {
            case 0:
                j.f("sink", bArr);
                return ((j) lVar).N(bArr, i10, i11);
            default:
                j.f("data", bArr);
                i0 i0Var = (i0) lVar;
                if (!i0Var.f4785j) {
                    w0.b((long) bArr.length, (long) i10, (long) i11);
                    j jVar = i0Var.f4784i;
                    if (jVar.f4787i == 0 && i0Var.f4783h.read(jVar, 8192) == -1) {
                        return -1;
                    }
                    return jVar.N(bArr, i10, i11);
                }
                throw new IOException("closed");
        }
    }
}
