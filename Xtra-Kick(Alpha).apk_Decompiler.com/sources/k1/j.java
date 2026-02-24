package k1;

import j1.a;
import java.io.InputStream;

public final class j extends InputStream {

    /* renamed from: h  reason: collision with root package name */
    public final h f9008h;

    /* renamed from: i  reason: collision with root package name */
    public final m f9009i;

    /* renamed from: j  reason: collision with root package name */
    public final byte[] f9010j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f9011k = false;

    /* renamed from: l  reason: collision with root package name */
    public boolean f9012l = false;

    public j(h hVar, m mVar) {
        this.f9008h = hVar;
        this.f9009i = mVar;
        this.f9010j = new byte[1];
    }

    public final void c() {
        if (!this.f9011k) {
            this.f9008h.q(this.f9009i);
            this.f9011k = true;
        }
    }

    public final void close() {
        if (!this.f9012l) {
            this.f9008h.close();
            this.f9012l = true;
        }
    }

    public final int read() {
        byte[] bArr = this.f9010j;
        if (read(bArr) == -1) {
            return -1;
        }
        return bArr[0] & 255;
    }

    public final int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    public final int read(byte[] bArr, int i10, int i11) {
        a.e(!this.f9012l);
        c();
        int o10 = this.f9008h.o(bArr, i10, i11);
        if (o10 == -1) {
            return -1;
        }
        return o10;
    }
}
