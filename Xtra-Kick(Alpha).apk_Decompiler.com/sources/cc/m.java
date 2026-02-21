package cc;

import dc.g;
import dc.j;
import dc.k;
import dc.k0;
import dc.n;
import dc.w0;
import hb.h0;
import java.io.Closeable;
import java.io.IOException;
import java.util.Random;
import java.util.zip.Deflater;
import vb.h;

public final class m implements Closeable {

    /* renamed from: h  reason: collision with root package name */
    public final boolean f3140h;

    /* renamed from: i  reason: collision with root package name */
    public final k f3141i;

    /* renamed from: j  reason: collision with root package name */
    public final Random f3142j;

    /* renamed from: k  reason: collision with root package name */
    public final boolean f3143k;

    /* renamed from: l  reason: collision with root package name */
    public final boolean f3144l;

    /* renamed from: m  reason: collision with root package name */
    public final long f3145m;

    /* renamed from: n  reason: collision with root package name */
    public final j f3146n = new j();

    /* renamed from: o  reason: collision with root package name */
    public final j f3147o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f3148p;

    /* renamed from: q  reason: collision with root package name */
    public a f3149q;

    /* renamed from: r  reason: collision with root package name */
    public final byte[] f3150r;

    /* renamed from: s  reason: collision with root package name */
    public final g f3151s;

    public m(boolean z10, k kVar, Random random, boolean z11, boolean z12, long j10) {
        xa.j.f("sink", kVar);
        xa.j.f("random", random);
        this.f3140h = z10;
        this.f3141i = kVar;
        this.f3142j = random;
        this.f3143k = z11;
        this.f3144l = z12;
        this.f3145m = j10;
        this.f3147o = kVar.b();
        g gVar = null;
        this.f3150r = z10 ? new byte[4] : null;
        this.f3151s = z10 ? new g() : gVar;
    }

    public final void c(int i10, n nVar) {
        boolean z10;
        if (!this.f3148p) {
            int d10 = nVar.d();
            if (((long) d10) <= 125) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                j jVar = this.f3147o;
                jVar.Q0(i10 | 128);
                if (this.f3140h) {
                    jVar.Q0(d10 | 128);
                    byte[] bArr = this.f3150r;
                    xa.j.c(bArr);
                    this.f3142j.nextBytes(bArr);
                    jVar.O0(bArr);
                    if (d10 > 0) {
                        long j10 = jVar.f4787i;
                        jVar.N0(nVar);
                        g gVar = this.f3151s;
                        xa.j.c(gVar);
                        jVar.W(gVar);
                        gVar.e(j10);
                        j.f3123a.getClass();
                        j.b(gVar, bArr);
                        gVar.close();
                    }
                } else {
                    jVar.Q0(d10);
                    jVar.N0(nVar);
                }
                this.f3141i.flush();
                return;
            }
            throw new IllegalArgumentException("Payload size must be less than or equal to 125".toString());
        }
        throw new IOException("closed");
    }

    public final void close() {
        a aVar = this.f3149q;
        if (aVar != null) {
            aVar.close();
        }
    }

    public final void e(int i10, n nVar) {
        boolean z10;
        Throwable th;
        n nVar2 = nVar;
        xa.j.f("data", nVar2);
        if (!this.f3148p) {
            j jVar = this.f3146n;
            jVar.N0(nVar2);
            int i11 = 128;
            int i12 = i10 | 128;
            if (this.f3143k && ((long) nVar.d()) >= this.f3145m) {
                a aVar = this.f3149q;
                if (aVar == null) {
                    aVar = new a(0, this.f3144l);
                    this.f3149q = aVar;
                }
                j jVar2 = aVar.f3081j;
                if (jVar2.f4787i == 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (z10) {
                    if (aVar.f3080i) {
                        ((Deflater) aVar.f3082k).reset();
                    }
                    h hVar = (h) aVar.f3083l;
                    hVar.o0(jVar, jVar.f4787i);
                    hVar.flush();
                    n nVar3 = b.f3084a;
                    if (jVar2.E(jVar2.f4787i - ((long) nVar3.f4804h.length), nVar3)) {
                        long j10 = jVar2.f4787i - ((long) 4);
                        g W = jVar2.W(w0.f4841a);
                        try {
                            W.c(j10);
                            h0.A(W, (Throwable) null);
                        } catch (Throwable th2) {
                            Throwable th3 = th2;
                            h0.A(W, th);
                            throw th3;
                        }
                    } else {
                        jVar2.Q0(0);
                    }
                    jVar.o0(jVar2, jVar2.f4787i);
                    i12 |= 64;
                } else {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
            }
            long j11 = jVar.f4787i;
            j jVar3 = this.f3147o;
            jVar3.Q0(i12);
            boolean z11 = this.f3140h;
            if (!z11) {
                i11 = 0;
            }
            if (j11 <= 125) {
                jVar3.Q0(i11 | ((int) j11));
            } else if (j11 <= 65535) {
                jVar3.Q0(i11 | 126);
                jVar3.U0((int) j11);
            } else {
                jVar3.Q0(i11 | 127);
                k0 M0 = jVar3.M0(8);
                int i13 = M0.f4790c;
                int i14 = i13 + 1;
                byte[] bArr = M0.f4788a;
                bArr[i13] = (byte) ((int) ((j11 >>> 56) & 255));
                int i15 = i14 + 1;
                bArr[i14] = (byte) ((int) ((j11 >>> 48) & 255));
                int i16 = i15 + 1;
                bArr[i15] = (byte) ((int) ((j11 >>> 40) & 255));
                int i17 = i16 + 1;
                bArr[i16] = (byte) ((int) ((j11 >>> 32) & 255));
                int i18 = i17 + 1;
                bArr[i17] = (byte) ((int) ((j11 >>> 24) & 255));
                int i19 = i18 + 1;
                bArr[i18] = (byte) ((int) ((j11 >>> 16) & 255));
                int i20 = i19 + 1;
                bArr[i19] = (byte) ((int) ((j11 >>> 8) & 255));
                bArr[i20] = (byte) ((int) (j11 & 255));
                M0.f4790c = i20 + 1;
                jVar3.f4787i += 8;
            }
            if (z11) {
                byte[] bArr2 = this.f3150r;
                xa.j.c(bArr2);
                this.f3142j.nextBytes(bArr2);
                jVar3.O0(bArr2);
                if (j11 > 0) {
                    g gVar = this.f3151s;
                    xa.j.c(gVar);
                    jVar.W(gVar);
                    gVar.e(0);
                    j.f3123a.getClass();
                    j.b(gVar, bArr2);
                    gVar.close();
                }
            }
            jVar3.o0(jVar, j11);
            this.f3141i.r();
            return;
        }
        throw new IOException("closed");
    }
}
