package cc;

import dc.g;
import dc.j;
import dc.n;
import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import pb.p0;
import qb.f;
import qb.h;

public final class l implements Closeable {

    /* renamed from: h  reason: collision with root package name */
    public final boolean f3124h;

    /* renamed from: i  reason: collision with root package name */
    public final dc.l f3125i;

    /* renamed from: j  reason: collision with root package name */
    public final k f3126j;

    /* renamed from: k  reason: collision with root package name */
    public final boolean f3127k;

    /* renamed from: l  reason: collision with root package name */
    public final boolean f3128l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f3129m;

    /* renamed from: n  reason: collision with root package name */
    public int f3130n;

    /* renamed from: o  reason: collision with root package name */
    public long f3131o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f3132p;

    /* renamed from: q  reason: collision with root package name */
    public boolean f3133q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f3134r;

    /* renamed from: s  reason: collision with root package name */
    public final j f3135s = new j();

    /* renamed from: t  reason: collision with root package name */
    public final j f3136t = new j();

    /* renamed from: u  reason: collision with root package name */
    public a f3137u;

    /* renamed from: v  reason: collision with root package name */
    public final byte[] f3138v;

    /* renamed from: w  reason: collision with root package name */
    public final g f3139w;

    public l(boolean z10, dc.l lVar, g gVar, boolean z11, boolean z12) {
        xa.j.f("source", lVar);
        xa.j.f("frameCallback", gVar);
        this.f3124h = z10;
        this.f3125i = lVar;
        this.f3126j = gVar;
        this.f3127k = z11;
        this.f3128l = z12;
        g gVar2 = null;
        this.f3138v = z10 ? null : new byte[4];
        this.f3139w = !z10 ? new g() : gVar2;
    }

    public final void c() {
        String str;
        short s10;
        long j10 = this.f3131o;
        if (j10 > 0) {
            this.f3125i.H(this.f3135s, j10);
            if (!this.f3124h) {
                j jVar = this.f3135s;
                g gVar = this.f3139w;
                xa.j.c(gVar);
                jVar.W(gVar);
                this.f3139w.e(0);
                j jVar2 = j.f3123a;
                g gVar2 = this.f3139w;
                byte[] bArr = this.f3138v;
                xa.j.c(bArr);
                jVar2.getClass();
                j.b(gVar2, bArr);
                this.f3139w.close();
            }
        }
        switch (this.f3130n) {
            case 8:
                j jVar3 = this.f3135s;
                long j11 = jVar3.f4787i;
                if (j11 != 1) {
                    if (j11 != 0) {
                        s10 = jVar3.readShort();
                        str = this.f3135s.j0();
                        j.f3123a.getClass();
                        String a10 = j.a(s10);
                        if (a10 != null) {
                            throw new ProtocolException(a10);
                        }
                    } else {
                        str = "";
                        s10 = 1005;
                    }
                    ((g) this.f3126j).f(s10, str);
                    this.f3129m = true;
                    return;
                }
                throw new ProtocolException("Malformed close payload length of 1.");
            case 9:
                k kVar = this.f3126j;
                n m10 = this.f3135s.m();
                g gVar3 = (g) kVar;
                synchronized (gVar3) {
                    xa.j.f("payload", m10);
                    if (!gVar3.f3113u) {
                        if (!gVar3.f3110r || !gVar3.f3108p.isEmpty()) {
                            gVar3.f3107o.add(m10);
                            gVar3.h();
                        }
                    }
                }
                return;
            case 10:
                ((g) this.f3126j).g(this.f3135s.m());
                return;
            default:
                int i10 = this.f3130n;
                p0 p0Var = h.f13493a;
                String hexString = Integer.toHexString(i10);
                xa.j.e("toHexString(this)", hexString);
                throw new ProtocolException("Unknown control opcode: ".concat(hexString));
        }
    }

    public final void close() {
        a aVar = this.f3137u;
        if (aVar != null) {
            aVar.close();
        }
    }

    /* JADX INFO: finally extract failed */
    public final void e() {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        String str;
        boolean z15;
        if (!this.f3129m) {
            dc.l lVar = this.f3125i;
            long h10 = lVar.timeout().h();
            lVar.timeout().b();
            try {
                byte readByte = lVar.readByte();
                byte[] bArr = f.f13487a;
                byte b10 = readByte & 255;
                lVar.timeout().g(h10, TimeUnit.NANOSECONDS);
                byte b11 = b10 & 15;
                this.f3130n = b11;
                boolean z16 = false;
                if ((b10 & 128) != 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                this.f3132p = z10;
                if ((b10 & 8) != 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                this.f3133q = z11;
                if (!z11 || z10) {
                    if ((b10 & 64) != 0) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    if (b11 == 1 || b11 == 2) {
                        if (!z12) {
                            z15 = false;
                        } else if (this.f3127k) {
                            z15 = true;
                        } else {
                            throw new ProtocolException("Unexpected rsv1 flag");
                        }
                        this.f3134r = z15;
                    } else if (z12) {
                        throw new ProtocolException("Unexpected rsv1 flag");
                    }
                    if ((b10 & 32) != 0) {
                        z13 = true;
                    } else {
                        z13 = false;
                    }
                    if (!z13) {
                        if ((b10 & 16) != 0) {
                            z14 = true;
                        } else {
                            z14 = false;
                        }
                        if (!z14) {
                            byte readByte2 = lVar.readByte() & 255;
                            if ((readByte2 & 128) != 0) {
                                z16 = true;
                            }
                            boolean z17 = this.f3124h;
                            if (z16 == z17) {
                                if (z17) {
                                    str = "Server-sent frames must not be masked.";
                                } else {
                                    str = "Client-sent frames must be masked.";
                                }
                                throw new ProtocolException(str);
                            }
                            long j10 = (long) (readByte2 & Byte.MAX_VALUE);
                            this.f3131o = j10;
                            if (j10 == 126) {
                                this.f3131o = (long) (lVar.readShort() & 65535);
                            } else if (j10 == 127) {
                                long readLong = lVar.readLong();
                                this.f3131o = readLong;
                                if (readLong < 0) {
                                    StringBuilder sb2 = new StringBuilder("Frame length 0x");
                                    long j11 = this.f3131o;
                                    p0 p0Var = h.f13493a;
                                    String hexString = Long.toHexString(j11);
                                    xa.j.e("toHexString(this)", hexString);
                                    sb2.append(hexString);
                                    sb2.append(" > 0x7FFFFFFFFFFFFFFF");
                                    throw new ProtocolException(sb2.toString());
                                }
                            }
                            if (this.f3133q && this.f3131o > 125) {
                                throw new ProtocolException("Control frame must be less than 125B.");
                            } else if (z16) {
                                byte[] bArr2 = this.f3138v;
                                xa.j.c(bArr2);
                                lVar.readFully(bArr2);
                            }
                        } else {
                            throw new ProtocolException("Unexpected rsv3 flag");
                        }
                    } else {
                        throw new ProtocolException("Unexpected rsv2 flag");
                    }
                } else {
                    throw new ProtocolException("Control frames must be final.");
                }
            } catch (Throwable th) {
                lVar.timeout().g(h10, TimeUnit.NANOSECONDS);
                throw th;
            }
        } else {
            throw new IOException("closed");
        }
    }
}
