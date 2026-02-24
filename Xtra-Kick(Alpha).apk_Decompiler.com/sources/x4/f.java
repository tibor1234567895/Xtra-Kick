package x4;

import java.io.Closeable;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

public final class f implements Closeable {

    /* renamed from: h  reason: collision with root package name */
    public final InputStream f16674h;

    /* renamed from: i  reason: collision with root package name */
    public final Charset f16675i;

    /* renamed from: j  reason: collision with root package name */
    public byte[] f16676j;

    /* renamed from: k  reason: collision with root package name */
    public int f16677k;

    /* renamed from: l  reason: collision with root package name */
    public int f16678l;

    public f(FileInputStream fileInputStream, Charset charset) {
        if (charset == null) {
            throw null;
        } else if (charset.equals(g.f16679a)) {
            this.f16674h = fileInputStream;
            this.f16675i = charset;
            this.f16676j = new byte[8192];
        } else {
            throw new IllegalArgumentException("Unsupported encoding");
        }
    }

    public final String c() {
        int i10;
        synchronized (this.f16674h) {
            byte[] bArr = this.f16676j;
            if (bArr != null) {
                if (this.f16677k >= this.f16678l) {
                    int read = this.f16674h.read(bArr, 0, bArr.length);
                    if (read != -1) {
                        this.f16677k = 0;
                        this.f16678l = read;
                    } else {
                        throw new EOFException();
                    }
                }
                for (int i11 = this.f16677k; i11 != this.f16678l; i11++) {
                    byte[] bArr2 = this.f16676j;
                    if (bArr2[i11] == 10) {
                        int i12 = this.f16677k;
                        if (i11 != i12) {
                            i10 = i11 - 1;
                            if (bArr2[i10] == 13) {
                                String str = new String(bArr2, i12, i10 - i12, this.f16675i.name());
                                this.f16677k = i11 + 1;
                                return str;
                            }
                        }
                        i10 = i11;
                        String str2 = new String(bArr2, i12, i10 - i12, this.f16675i.name());
                        this.f16677k = i11 + 1;
                        return str2;
                    }
                }
                e eVar = new e(this, (this.f16678l - this.f16677k) + 80);
                while (true) {
                    byte[] bArr3 = this.f16676j;
                    int i13 = this.f16677k;
                    eVar.write(bArr3, i13, this.f16678l - i13);
                    this.f16678l = -1;
                    byte[] bArr4 = this.f16676j;
                    int read2 = this.f16674h.read(bArr4, 0, bArr4.length);
                    if (read2 != -1) {
                        this.f16677k = 0;
                        this.f16678l = read2;
                        int i14 = 0;
                        while (true) {
                            if (i14 != this.f16678l) {
                                byte[] bArr5 = this.f16676j;
                                if (bArr5[i14] == 10) {
                                    int i15 = this.f16677k;
                                    if (i14 != i15) {
                                        eVar.write(bArr5, i15, i14 - i15);
                                    }
                                    this.f16677k = i14 + 1;
                                    String eVar2 = eVar.toString();
                                    return eVar2;
                                }
                                i14++;
                            }
                        }
                    } else {
                        throw new EOFException();
                    }
                }
            } else {
                throw new IOException("LineReader is closed");
            }
        }
    }

    public final void close() {
        synchronized (this.f16674h) {
            if (this.f16676j != null) {
                this.f16676j = null;
                this.f16674h.close();
            }
        }
    }
}
