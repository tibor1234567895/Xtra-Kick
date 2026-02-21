package dc;

import android.support.v4.media.h;
import ec.k;
import fb.a;
import java.io.EOFException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import xa.j;

public final class i0 implements l {

    /* renamed from: h  reason: collision with root package name */
    public final p0 f4783h;

    /* renamed from: i  reason: collision with root package name */
    public final j f4784i = new j();

    /* renamed from: j  reason: collision with root package name */
    public boolean f4785j;

    public i0(p0 p0Var) {
        j.f("source", p0Var);
        this.f4783h = p0Var;
    }

    public final long D0() {
        j jVar;
        u0(1);
        int i10 = 0;
        while (true) {
            int i11 = i10 + 1;
            boolean t10 = t((long) i11);
            jVar = this.f4784i;
            if (!t10) {
                break;
            }
            byte v10 = jVar.v((long) i10);
            if ((v10 >= 48 && v10 <= 57) || ((v10 >= 97 && v10 <= 102) || (v10 >= 65 && v10 <= 70))) {
                i10 = i11;
            } else if (i10 == 0) {
                a.a(16);
                a.a(16);
                String num = Integer.toString(v10, 16);
                j.e("toString(this, checkRadix(radix))", num);
                throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x".concat(num));
            }
        }
        return jVar.D0();
    }

    public final boolean E(long j10, n nVar) {
        j.f("bytes", nVar);
        byte[] bArr = nVar.f4804h;
        int length = bArr.length;
        if (!this.f4785j) {
            if (j10 >= 0 && length >= 0 && bArr.length - 0 >= length) {
                int i10 = 0;
                while (i10 < length) {
                    long j11 = ((long) i10) + j10;
                    if (t(1 + j11) && this.f4784i.v(j11) == bArr[0 + i10]) {
                        i10++;
                    }
                }
                return true;
            }
            return false;
        }
        throw new IllegalStateException("closed".toString());
    }

    public final String E0(Charset charset) {
        j.f("charset", charset);
        p0 p0Var = this.f4783h;
        j jVar = this.f4784i;
        jVar.F0(p0Var);
        return jVar.E0(charset);
    }

    public final h G0() {
        return new h(this, 1);
    }

    public final void H(j jVar, long j10) {
        j jVar2 = this.f4784i;
        j.f("sink", jVar);
        try {
            u0(j10);
            jVar2.H(jVar, j10);
        } catch (EOFException e10) {
            jVar.F0(jVar2);
            throw e10;
        }
    }

    public final String K() {
        return e0(Long.MAX_VALUE);
    }

    public final int K0(d0 d0Var) {
        j.f("options", d0Var);
        if (!this.f4785j) {
            while (true) {
                j jVar = this.f4784i;
                int b10 = k.b(jVar, d0Var, true);
                if (b10 == -2) {
                    if (this.f4783h.read(jVar, 8192) == -1) {
                        break;
                    }
                } else if (b10 != -1) {
                    jVar.a((long) d0Var.f4750i[b10].d());
                    return b10;
                }
            }
            return -1;
        }
        throw new IllegalStateException("closed".toString());
    }

    public final byte[] M() {
        p0 p0Var = this.f4783h;
        j jVar = this.f4784i;
        jVar.F0(p0Var);
        return jVar.M();
    }

    public final int O() {
        u0(4);
        return this.f4784i.O();
    }

    public final long Q(k kVar) {
        j jVar;
        long j10 = 0;
        while (true) {
            p0 p0Var = this.f4783h;
            jVar = this.f4784i;
            if (p0Var.read(jVar, 8192) == -1) {
                break;
            }
            long e10 = jVar.e();
            if (e10 > 0) {
                j10 += e10;
                kVar.o0(jVar, e10);
            }
        }
        long j11 = jVar.f4787i;
        if (j11 <= 0) {
            return j10;
        }
        long j12 = j10 + j11;
        kVar.o0(jVar, j11);
        return j12;
    }

    public final boolean R() {
        if (!this.f4785j) {
            j jVar = this.f4784i;
            return jVar.R() && this.f4783h.read(jVar, 8192) == -1;
        }
        throw new IllegalStateException("closed".toString());
    }

    public final void a(long j10) {
        if (!this.f4785j) {
            while (j10 > 0) {
                j jVar = this.f4784i;
                if (jVar.f4787i == 0 && this.f4783h.read(jVar, 8192) == -1) {
                    throw new EOFException();
                }
                long min = Math.min(j10, jVar.f4787i);
                jVar.a(min);
                j10 -= min;
            }
            return;
        }
        throw new IllegalStateException("closed".toString());
    }

    public final j b() {
        return this.f4784i;
    }

    public final long c(byte b10, long j10, long j11) {
        boolean z10 = true;
        if (!this.f4785j) {
            long j12 = 0;
            if (0 > j11) {
                z10 = false;
            }
            if (z10) {
                while (j12 < j11) {
                    long w10 = this.f4784i.w(b10, j12, j11);
                    if (w10 != -1) {
                        return w10;
                    }
                    j jVar = this.f4784i;
                    long j13 = jVar.f4787i;
                    if (j13 >= j11 || this.f4783h.read(jVar, 8192) == -1) {
                        return -1;
                    }
                    j12 = Math.max(j12, j13);
                }
                return -1;
            }
            throw new IllegalArgumentException(h.k("fromIndex=0 toIndex=", j11).toString());
        }
        throw new IllegalStateException("closed".toString());
    }

    public final void close() {
        if (!this.f4785j) {
            this.f4785j = true;
            this.f4783h.close();
            this.f4784i.c();
        }
    }

    public final long d0() {
        u0(8);
        return this.f4784i.d0();
    }

    public final short e() {
        u0(2);
        return this.f4784i.Z();
    }

    public final String e0(long j10) {
        boolean z10;
        long j11;
        long j12 = j10;
        if (j12 >= 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            if (j12 == Long.MAX_VALUE) {
                j11 = Long.MAX_VALUE;
            } else {
                j11 = j12 + 1;
            }
            long c10 = c((byte) 10, 0, j11);
            j jVar = this.f4784i;
            if (c10 != -1) {
                return k.a(jVar, c10);
            }
            if (j11 < Long.MAX_VALUE && t(j11) && jVar.v(j11 - 1) == 13 && t(1 + j11) && jVar.v(j11) == 10) {
                return k.a(jVar, j11);
            }
            j jVar2 = new j();
            jVar.k(0, Math.min((long) 32, jVar.f4787i), jVar2);
            throw new EOFException("\\n not found: limit=" + Math.min(jVar.f4787i, j12) + " content=" + jVar2.m().e() + 8230);
        }
        throw new IllegalArgumentException(h.k("limit < 0: ", j12).toString());
    }

    public final boolean isOpen() {
        return !this.f4785j;
    }

    public final String k(long j10) {
        u0(j10);
        return this.f4784i.H0(j10);
    }

    public final n m() {
        p0 p0Var = this.f4783h;
        j jVar = this.f4784i;
        jVar.F0(p0Var);
        return jVar.m();
    }

    public final n n(long j10) {
        u0(j10);
        return this.f4784i.n(j10);
    }

    public final int read(ByteBuffer byteBuffer) {
        j.f("sink", byteBuffer);
        j jVar = this.f4784i;
        if (jVar.f4787i == 0 && this.f4783h.read(jVar, 8192) == -1) {
            return -1;
        }
        return jVar.read(byteBuffer);
    }

    public final byte readByte() {
        u0(1);
        return this.f4784i.readByte();
    }

    public final void readFully(byte[] bArr) {
        j jVar = this.f4784i;
        try {
            u0((long) bArr.length);
            jVar.readFully(bArr);
        } catch (EOFException e10) {
            int i10 = 0;
            while (true) {
                long j10 = jVar.f4787i;
                if (j10 > 0) {
                    int N = jVar.N(bArr, i10, (int) j10);
                    if (N != -1) {
                        i10 += N;
                    } else {
                        throw new AssertionError();
                    }
                } else {
                    throw e10;
                }
            }
        }
    }

    public final int readInt() {
        u0(4);
        return this.f4784i.readInt();
    }

    public final long readLong() {
        u0(8);
        return this.f4784i.readLong();
    }

    public final short readShort() {
        u0(2);
        return this.f4784i.readShort();
    }

    public final boolean t(long j10) {
        boolean z10;
        j jVar;
        if (j10 >= 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            throw new IllegalArgumentException(h.k("byteCount < 0: ", j10).toString());
        } else if (!this.f4785j) {
            do {
                jVar = this.f4784i;
                if (jVar.f4787i >= j10) {
                    return true;
                }
            } while (this.f4783h.read(jVar, 8192) != -1);
            return false;
        } else {
            throw new IllegalStateException("closed".toString());
        }
    }

    public final s0 timeout() {
        return this.f4783h.timeout();
    }

    public final String toString() {
        return "buffer(" + this.f4783h + ')';
    }

    public final void u0(long j10) {
        if (!t(j10)) {
            throw new EOFException();
        }
    }

    public final long read(j jVar, long j10) {
        j.f("sink", jVar);
        if (!(j10 >= 0)) {
            throw new IllegalArgumentException(h.k("byteCount < 0: ", j10).toString());
        } else if (!this.f4785j) {
            j jVar2 = this.f4784i;
            if (jVar2.f4787i == 0 && this.f4783h.read(jVar2, 8192) == -1) {
                return -1;
            }
            return jVar2.read(jVar, Math.min(j10, jVar2.f4787i));
        } else {
            throw new IllegalStateException("closed".toString());
        }
    }
}
