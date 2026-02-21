package dc;

import android.support.v4.media.h;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import java.util.zip.CRC32;
import java.util.zip.Inflater;
import xa.j;

public final class w implements p0 {

    /* renamed from: h  reason: collision with root package name */
    public byte f4836h;

    /* renamed from: i  reason: collision with root package name */
    public final i0 f4837i;

    /* renamed from: j  reason: collision with root package name */
    public final Inflater f4838j;

    /* renamed from: k  reason: collision with root package name */
    public final x f4839k;

    /* renamed from: l  reason: collision with root package name */
    public final CRC32 f4840l = new CRC32();

    public w(p0 p0Var) {
        j.f("source", p0Var);
        i0 i0Var = new i0(p0Var);
        this.f4837i = i0Var;
        Inflater inflater = new Inflater(true);
        this.f4838j = inflater;
        this.f4839k = new x(i0Var, inflater);
    }

    public static void c(int i10, int i11, String str) {
        if (i11 != i10) {
            String format = String.format("%s: actual 0x%08x != expected 0x%08x", Arrays.copyOf(new Object[]{str, Integer.valueOf(i11), Integer.valueOf(i10)}, 3));
            j.e("format(this, *args)", format);
            throw new IOException(format);
        }
    }

    public final void close() {
        this.f4839k.close();
    }

    public final void e(long j10, long j11, j jVar) {
        k0 k0Var = jVar.f4786h;
        while (true) {
            j.c(k0Var);
            int i10 = k0Var.f4790c;
            int i11 = k0Var.f4789b;
            if (j10 < ((long) (i10 - i11))) {
                break;
            }
            j10 -= (long) (i10 - i11);
            k0Var = k0Var.f4793f;
        }
        while (j11 > 0) {
            int i12 = (int) (((long) k0Var.f4789b) + j10);
            int min = (int) Math.min((long) (k0Var.f4790c - i12), j11);
            this.f4840l.update(k0Var.f4788a, i12, min);
            j11 -= (long) min;
            k0Var = k0Var.f4793f;
            j.c(k0Var);
            j10 = 0;
        }
    }

    public final long read(j jVar, long j10) {
        boolean z10;
        i0 i0Var;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        long j11;
        j jVar2 = jVar;
        long j12 = j10;
        j.f("sink", jVar2);
        int i10 = (j12 > 0 ? 1 : (j12 == 0 ? 0 : -1));
        if (i10 >= 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            throw new IllegalArgumentException(h.k("byteCount < 0: ", j12).toString());
        } else if (i10 == 0) {
            return 0;
        } else {
            byte b10 = this.f4836h;
            CRC32 crc32 = this.f4840l;
            i0 i0Var2 = this.f4837i;
            if (b10 == 0) {
                i0Var2.u0(10);
                j jVar3 = i0Var2.f4784i;
                byte v10 = jVar3.v(3);
                if (((v10 >> 1) & 1) == 1) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z11) {
                    e(0, 10, i0Var2.f4784i);
                }
                c(8075, i0Var2.readShort(), "ID1ID2");
                i0Var2.a(8);
                if (((v10 >> 2) & 1) == 1) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                if (z12) {
                    i0Var2.u0(2);
                    if (z11) {
                        e(0, 2, i0Var2.f4784i);
                    }
                    long Z = (long) jVar3.Z();
                    i0Var2.u0(Z);
                    if (z11) {
                        e(0, Z, i0Var2.f4784i);
                        j11 = Z;
                    } else {
                        j11 = Z;
                    }
                    i0Var2.a(j11);
                }
                if (((v10 >> 3) & 1) == 1) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                if (z13) {
                    i0 i0Var3 = i0Var2;
                    long c10 = i0Var2.c((byte) 0, 0, Long.MAX_VALUE);
                    if (c10 != -1) {
                        if (z11) {
                            i0Var = i0Var3;
                            e(0, c10 + 1, i0Var3.f4784i);
                        } else {
                            i0Var = i0Var3;
                        }
                        i0Var.a(c10 + 1);
                    } else {
                        throw new EOFException();
                    }
                } else {
                    i0Var = i0Var2;
                }
                if (((v10 >> 4) & 1) == 1) {
                    z14 = true;
                } else {
                    z14 = false;
                }
                if (z14) {
                    long c11 = i0Var.c((byte) 0, 0, Long.MAX_VALUE);
                    if (c11 != -1) {
                        if (z11) {
                            e(0, c11 + 1, i0Var.f4784i);
                        }
                        i0Var.a(c11 + 1);
                    } else {
                        throw new EOFException();
                    }
                }
                if (z11) {
                    c(i0Var.e(), (short) ((int) crc32.getValue()), "FHCRC");
                    crc32.reset();
                }
                this.f4836h = 1;
            } else {
                i0Var = i0Var2;
            }
            if (this.f4836h == 1) {
                long j13 = jVar2.f4787i;
                long read = this.f4839k.read(jVar2, j12);
                if (read != -1) {
                    e(j13, read, jVar);
                    return read;
                }
                this.f4836h = 2;
            }
            if (this.f4836h != 2) {
                return -1;
            }
            c(i0Var.O(), (int) crc32.getValue(), "CRC");
            c(i0Var.O(), (int) this.f4838j.getBytesWritten(), "ISIZE");
            this.f4836h = 3;
            if (i0Var.R()) {
                return -1;
            }
            throw new IOException("gzip finished without exhausting source");
        }
    }

    public final s0 timeout() {
        return this.f4837i.timeout();
    }
}
