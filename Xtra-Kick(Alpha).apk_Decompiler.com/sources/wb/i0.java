package wb;

import android.support.v4.media.h;
import dc.j;
import dc.k;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import ma.o;
import qb.f;

public final class i0 implements Closeable {

    /* renamed from: n  reason: collision with root package name */
    public static final Logger f16260n = Logger.getLogger(i.class.getName());

    /* renamed from: h  reason: collision with root package name */
    public final k f16261h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f16262i;

    /* renamed from: j  reason: collision with root package name */
    public final j f16263j;

    /* renamed from: k  reason: collision with root package name */
    public int f16264k = 16384;

    /* renamed from: l  reason: collision with root package name */
    public boolean f16265l;

    /* renamed from: m  reason: collision with root package name */
    public final g f16266m;

    static {
        new h0(0);
    }

    public i0(k kVar, boolean z10) {
        this.f16261h = kVar;
        this.f16262i = z10;
        j jVar = new j();
        this.f16263j = jVar;
        this.f16266m = new g(jVar);
    }

    public final synchronized void N(int i10, c cVar) {
        boolean z10;
        xa.j.f("errorCode", cVar);
        if (!this.f16265l) {
            if (cVar.f16199h != -1) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                k(i10, 4, 3, 0);
                this.f16261h.A(cVar.f16199h);
                this.f16261h.flush();
            } else {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
        } else {
            throw new IOException("closed");
        }
    }

    public final synchronized void W(p0 p0Var) {
        int i10;
        xa.j.f("settings", p0Var);
        if (!this.f16265l) {
            k(0, Integer.bitCount(p0Var.f16292a) * 6, 4, 0);
            for (int i11 = 0; i11 < 10; i11++) {
                boolean z10 = true;
                if (((1 << i11) & p0Var.f16292a) == 0) {
                    z10 = false;
                }
                if (z10) {
                    if (i11 == 4) {
                        i10 = 3;
                    } else if (i11 != 7) {
                        i10 = i11;
                    } else {
                        i10 = 4;
                    }
                    this.f16261h.s(i10);
                    this.f16261h.A(p0Var.f16293b[i11]);
                }
            }
            this.f16261h.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public final synchronized void Y(int i10, long j10) {
        if (!this.f16265l) {
            if (j10 != 0 && j10 <= 2147483647L) {
                Logger logger = f16260n;
                if (logger.isLoggable(Level.FINE)) {
                    i.f16255a.getClass();
                    logger.fine(i.c(j10, i10, 4, false));
                }
                k(i10, 4, 8, 0);
                this.f16261h.A((int) j10);
                this.f16261h.flush();
            } else {
                throw new IllegalArgumentException(("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: " + j10).toString());
            }
        } else {
            throw new IOException("closed");
        }
    }

    public final void Z(int i10, long j10) {
        while (j10 > 0) {
            long min = Math.min((long) this.f16264k, j10);
            j10 -= min;
            k(i10, (int) min, 9, j10 == 0 ? 4 : 0);
            this.f16261h.o0(this.f16263j, min);
        }
    }

    public final synchronized void c(p0 p0Var) {
        int i10;
        int i11;
        xa.j.f("peerSettings", p0Var);
        if (!this.f16265l) {
            int i12 = this.f16264k;
            int i13 = p0Var.f16292a;
            if ((i13 & 32) != 0) {
                i12 = p0Var.f16293b[5];
            }
            this.f16264k = i12;
            if ((i13 & 2) != 0) {
                i10 = p0Var.f16293b[1];
            } else {
                i10 = -1;
            }
            if (i10 != -1) {
                g gVar = this.f16266m;
                if ((i13 & 2) != 0) {
                    i11 = p0Var.f16293b[1];
                } else {
                    i11 = -1;
                }
                gVar.getClass();
                int min = Math.min(i11, 16384);
                int i14 = gVar.f16233e;
                if (i14 != min) {
                    if (min < i14) {
                        gVar.f16231c = Math.min(gVar.f16231c, min);
                    }
                    gVar.f16232d = true;
                    gVar.f16233e = min;
                    int i15 = gVar.f16237i;
                    if (min < i15) {
                        if (min == 0) {
                            e[] eVarArr = gVar.f16234f;
                            o.f(eVarArr, (j0) null, 0, eVarArr.length);
                            gVar.f16235g = gVar.f16234f.length - 1;
                            gVar.f16236h = 0;
                            gVar.f16237i = 0;
                        } else {
                            gVar.a(i15 - min);
                        }
                    }
                }
            }
            k(0, 0, 4, 1);
            this.f16261h.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public final synchronized void close() {
        this.f16265l = true;
        this.f16261h.close();
    }

    public final synchronized void e(boolean z10, int i10, j jVar, int i11) {
        if (!this.f16265l) {
            k(i10, i11, 0, z10 ? 1 : 0);
            if (i11 > 0) {
                xa.j.c(jVar);
                this.f16261h.o0(jVar, (long) i11);
            }
        } else {
            throw new IOException("closed");
        }
    }

    public final synchronized void flush() {
        if (!this.f16265l) {
            this.f16261h.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public final void k(int i10, int i11, int i12, int i13) {
        boolean z10;
        boolean z11 = false;
        if (i12 != 8) {
            Level level = Level.FINE;
            Logger logger = f16260n;
            if (logger.isLoggable(level)) {
                i.f16255a.getClass();
                logger.fine(i.b(i10, i11, i12, i13, false));
            }
        }
        if (i11 <= this.f16264k) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            if ((Integer.MIN_VALUE & i10) == 0) {
                z11 = true;
            }
            if (z11) {
                byte[] bArr = f.f13487a;
                k kVar = this.f16261h;
                xa.j.f("<this>", kVar);
                kVar.S((i11 >>> 16) & 255);
                kVar.S((i11 >>> 8) & 255);
                kVar.S(i11 & 255);
                kVar.S(i12 & 255);
                kVar.S(i13 & 255);
                kVar.A(i10 & Integer.MAX_VALUE);
                return;
            }
            throw new IllegalArgumentException(h.i("reserved bit set: ", i10).toString());
        }
        throw new IllegalArgumentException(("FRAME_SIZE_ERROR length > " + this.f16264k + ": " + i11).toString());
    }

    public final synchronized void v(int i10, c cVar, byte[] bArr) {
        boolean z10;
        if (!this.f16265l) {
            boolean z11 = false;
            if (cVar.f16199h != -1) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                k(0, bArr.length + 8, 7, 0);
                this.f16261h.A(i10);
                this.f16261h.A(cVar.f16199h);
                if (bArr.length == 0) {
                    z11 = true;
                }
                if (!z11) {
                    this.f16261h.X(bArr);
                }
                this.f16261h.flush();
            } else {
                throw new IllegalArgumentException("errorCode.httpCode == -1".toString());
            }
        } else {
            throw new IOException("closed");
        }
    }

    public final synchronized void w(int i10, ArrayList arrayList, boolean z10) {
        int i11;
        if (!this.f16265l) {
            this.f16266m.d(arrayList);
            long j10 = this.f16263j.f4787i;
            long min = Math.min((long) this.f16264k, j10);
            int i12 = (j10 > min ? 1 : (j10 == min ? 0 : -1));
            if (i12 == 0) {
                i11 = 4;
            } else {
                i11 = 0;
            }
            if (z10) {
                i11 |= 1;
            }
            k(i10, (int) min, 1, i11);
            this.f16261h.o0(this.f16263j, min);
            if (i12 > 0) {
                Z(i10, j10 - min);
            }
        } else {
            throw new IOException("closed");
        }
    }

    public final synchronized void z(int i10, int i11, boolean z10) {
        if (!this.f16265l) {
            k(0, 8, 6, z10 ? 1 : 0);
            this.f16261h.A(i10);
            this.f16261h.A(i11);
            this.f16261h.flush();
        } else {
            throw new IOException("closed");
        }
    }
}
