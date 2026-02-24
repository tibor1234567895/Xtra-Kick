package wb;

import dc.j;
import dc.l;
import dc.p0;
import dc.s0;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import qb.f;

public final class a0 implements p0 {

    /* renamed from: h  reason: collision with root package name */
    public final l f16179h;

    /* renamed from: i  reason: collision with root package name */
    public int f16180i;

    /* renamed from: j  reason: collision with root package name */
    public int f16181j;

    /* renamed from: k  reason: collision with root package name */
    public int f16182k;

    /* renamed from: l  reason: collision with root package name */
    public int f16183l;

    /* renamed from: m  reason: collision with root package name */
    public int f16184m;

    public a0(l lVar) {
        this.f16179h = lVar;
    }

    public final void close() {
    }

    public final long read(j jVar, long j10) {
        int i10;
        int readInt;
        xa.j.f("sink", jVar);
        do {
            int i11 = this.f16183l;
            l lVar = this.f16179h;
            if (i11 == 0) {
                lVar.a((long) this.f16184m);
                this.f16184m = 0;
                if ((this.f16181j & 4) != 0) {
                    return -1;
                }
                i10 = this.f16182k;
                int m10 = f.m(lVar);
                this.f16183l = m10;
                this.f16180i = m10;
                byte readByte = lVar.readByte() & 255;
                this.f16181j = lVar.readByte() & 255;
                b0.f16185l.getClass();
                Logger logger = b0.f16186m;
                if (logger.isLoggable(Level.FINE)) {
                    i iVar = i.f16255a;
                    int i12 = this.f16182k;
                    int i13 = this.f16180i;
                    int i14 = this.f16181j;
                    iVar.getClass();
                    logger.fine(i.b(i12, i13, readByte, i14, true));
                }
                readInt = lVar.readInt() & Integer.MAX_VALUE;
                this.f16182k = readInt;
                if (readByte != 9) {
                    throw new IOException(readByte + " != TYPE_CONTINUATION");
                }
            } else {
                long read = lVar.read(jVar, Math.min(j10, (long) i11));
                if (read == -1) {
                    return -1;
                }
                this.f16183l -= (int) read;
                return read;
            }
        } while (readInt == i10);
        throw new IOException("TYPE_CONTINUATION streamId changed");
    }

    public final s0 timeout() {
        return this.f16179h.timeout();
    }
}
