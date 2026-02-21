package dc;

import java.nio.ByteBuffer;
import xa.j;

public final class h0 implements k {

    /* renamed from: h  reason: collision with root package name */
    public final n0 f4779h;

    /* renamed from: i  reason: collision with root package name */
    public final j f4780i = new j();

    /* renamed from: j  reason: collision with root package name */
    public boolean f4781j;

    public h0(n0 n0Var) {
        j.f("sink", n0Var);
        this.f4779h = n0Var;
    }

    public final k A(int i10) {
        if (!this.f4781j) {
            this.f4780i.T0(i10);
            b0();
            return this;
        }
        throw new IllegalStateException("closed".toString());
    }

    public final long F0(p0 p0Var) {
        j.f("source", p0Var);
        long j10 = 0;
        while (true) {
            long read = p0Var.read(this.f4780i, 8192);
            if (read == -1) {
                return j10;
            }
            j10 += read;
            b0();
        }
    }

    public final k S(int i10) {
        if (!this.f4781j) {
            this.f4780i.Q0(i10);
            b0();
            return this;
        }
        throw new IllegalStateException("closed".toString());
    }

    public final k X(byte[] bArr) {
        j.f("source", bArr);
        if (!this.f4781j) {
            this.f4780i.O0(bArr);
            b0();
            return this;
        }
        throw new IllegalStateException("closed".toString());
    }

    public final j b() {
        return this.f4780i;
    }

    public final k b0() {
        if (!this.f4781j) {
            j jVar = this.f4780i;
            long e10 = jVar.e();
            if (e10 > 0) {
                this.f4779h.o0(jVar, e10);
            }
            return this;
        }
        throw new IllegalStateException("closed".toString());
    }

    public final void c(int i10) {
        if (!this.f4781j) {
            j jVar = this.f4780i;
            jVar.getClass();
            g gVar = w0.f4841a;
            jVar.T0(((i10 & 255) << 24) | ((-16777216 & i10) >>> 24) | ((16711680 & i10) >>> 8) | ((65280 & i10) << 8));
            b0();
            return;
        }
        throw new IllegalStateException("closed".toString());
    }

    public final void close() {
        n0 n0Var = this.f4779h;
        if (!this.f4781j) {
            try {
                j jVar = this.f4780i;
                long j10 = jVar.f4787i;
                if (j10 > 0) {
                    n0Var.o0(jVar, j10);
                }
                th = null;
            } catch (Throwable th) {
                th = th;
            }
            try {
                n0Var.close();
            } catch (Throwable th2) {
                if (th == null) {
                    th = th2;
                }
            }
            this.f4781j = true;
            if (th != null) {
                throw th;
            }
        }
    }

    public final k f(byte[] bArr, int i10, int i11) {
        j.f("source", bArr);
        if (!this.f4781j) {
            this.f4780i.P0(bArr, i10, i11);
            b0();
            return this;
        }
        throw new IllegalStateException("closed".toString());
    }

    public final void flush() {
        if (!this.f4781j) {
            j jVar = this.f4780i;
            long j10 = jVar.f4787i;
            n0 n0Var = this.f4779h;
            if (j10 > 0) {
                n0Var.o0(jVar, j10);
            }
            n0Var.flush();
            return;
        }
        throw new IllegalStateException("closed".toString());
    }

    public final k i0(n nVar) {
        j.f("byteString", nVar);
        if (!this.f4781j) {
            this.f4780i.N0(nVar);
            b0();
            return this;
        }
        throw new IllegalStateException("closed".toString());
    }

    public final boolean isOpen() {
        return !this.f4781j;
    }

    public final k l(long j10) {
        if (!this.f4781j) {
            this.f4780i.S0(j10);
            b0();
            return this;
        }
        throw new IllegalStateException("closed".toString());
    }

    public final void o0(j jVar, long j10) {
        j.f("source", jVar);
        if (!this.f4781j) {
            this.f4780i.o0(jVar, j10);
            b0();
            return;
        }
        throw new IllegalStateException("closed".toString());
    }

    public final k r() {
        if (!this.f4781j) {
            j jVar = this.f4780i;
            long j10 = jVar.f4787i;
            if (j10 > 0) {
                this.f4779h.o0(jVar, j10);
            }
            return this;
        }
        throw new IllegalStateException("closed".toString());
    }

    public final k s(int i10) {
        if (!this.f4781j) {
            this.f4780i.U0(i10);
            b0();
            return this;
        }
        throw new IllegalStateException("closed".toString());
    }

    public final s0 timeout() {
        return this.f4779h.timeout();
    }

    public final String toString() {
        return "buffer(" + this.f4779h + ')';
    }

    public final k v0(String str) {
        j.f("string", str);
        if (!this.f4781j) {
            this.f4780i.X0(str);
            b0();
            return this;
        }
        throw new IllegalStateException("closed".toString());
    }

    public final k w0(long j10) {
        if (!this.f4781j) {
            this.f4780i.w0(j10);
            b0();
            return this;
        }
        throw new IllegalStateException("closed".toString());
    }

    public final int write(ByteBuffer byteBuffer) {
        j.f("source", byteBuffer);
        if (!this.f4781j) {
            int write = this.f4780i.write(byteBuffer);
            b0();
            return write;
        }
        throw new IllegalStateException("closed".toString());
    }
}
