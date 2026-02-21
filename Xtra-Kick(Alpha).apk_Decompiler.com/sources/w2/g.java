package w2;

import d2.j0;
import d2.s0;
import d2.v;
import d2.w;
import d2.w0;
import d2.x0;
import d2.y;
import g1.a0;
import g1.b1;
import g1.z;
import g9.b;
import j1.a;
import j1.b0;
import j1.l0;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.List;

public final class g implements v {

    /* renamed from: a  reason: collision with root package name */
    public final e f16053a;

    /* renamed from: b  reason: collision with root package name */
    public final b f16054b = new b();

    /* renamed from: c  reason: collision with root package name */
    public final b0 f16055c = new b0();

    /* renamed from: d  reason: collision with root package name */
    public final a0 f16056d;

    /* renamed from: e  reason: collision with root package name */
    public final ArrayList f16057e;

    /* renamed from: f  reason: collision with root package name */
    public final ArrayList f16058f;

    /* renamed from: g  reason: collision with root package name */
    public y f16059g;

    /* renamed from: h  reason: collision with root package name */
    public x0 f16060h;

    /* renamed from: i  reason: collision with root package name */
    public int f16061i;

    /* renamed from: j  reason: collision with root package name */
    public int f16062j;

    /* renamed from: k  reason: collision with root package name */
    public long f16063k;

    public g(e eVar, a0 a0Var) {
        this.f16053a = eVar;
        z zVar = new z(a0Var);
        zVar.f6754k = "text/x-exoplayer-cues";
        zVar.f6751h = a0Var.f6276s;
        this.f16056d = new a0(zVar);
        this.f16057e = new ArrayList();
        this.f16058f = new ArrayList();
        this.f16062j = 0;
        this.f16063k = -9223372036854775807L;
    }

    public final void a() {
        if (this.f16062j != 5) {
            this.f16053a.a();
            this.f16062j = 5;
        }
    }

    public final void b() {
        boolean z10;
        int i10;
        a.f(this.f16060h);
        ArrayList arrayList = this.f16057e;
        int size = arrayList.size();
        ArrayList arrayList2 = this.f16058f;
        if (size == arrayList2.size()) {
            z10 = true;
        } else {
            z10 = false;
        }
        a.e(z10);
        long j10 = this.f16063k;
        if (j10 == -9223372036854775807L) {
            i10 = 0;
        } else {
            i10 = l0.d(arrayList, Long.valueOf(j10), true);
        }
        while (i10 < arrayList2.size()) {
            b0 b0Var = (b0) arrayList2.get(i10);
            b0Var.G(0);
            int length = b0Var.f8414a.length;
            this.f16060h.d(length, b0Var);
            this.f16060h.e(((Long) arrayList.get(i10)).longValue(), 1, length, 0, (w0) null);
            i10++;
        }
    }

    public final void c(long j10, long j11) {
        int i10 = this.f16062j;
        a.e((i10 == 0 || i10 == 5) ? false : true);
        this.f16063k = j11;
        if (this.f16062j == 2) {
            this.f16062j = 1;
        }
        if (this.f16062j == 4) {
            this.f16062j = 3;
        }
    }

    public final int d(w wVar, s0 s0Var) {
        boolean z10;
        boolean z11;
        h hVar;
        i iVar;
        int i10;
        int i11 = this.f16062j;
        boolean z12 = true;
        if (i11 == 0 || i11 == 5) {
            z10 = false;
        } else {
            z10 = true;
        }
        a.e(z10);
        int i12 = this.f16062j;
        int i13 = 1024;
        b0 b0Var = this.f16055c;
        if (i12 == 1) {
            if (wVar.c() != -1) {
                i10 = b.a(wVar.c());
            } else {
                i10 = 1024;
            }
            b0Var.D(i10);
            this.f16061i = 0;
            this.f16062j = 2;
        }
        if (this.f16062j == 2) {
            int length = b0Var.f8414a.length;
            int i14 = this.f16061i;
            if (length == i14) {
                b0Var.a(i14 + 1024);
            }
            byte[] bArr = b0Var.f8414a;
            int i15 = this.f16061i;
            int o10 = wVar.o(bArr, i15, bArr.length - i15);
            if (o10 != -1) {
                this.f16061i += o10;
            }
            long c10 = wVar.c();
            if ((c10 == -1 || ((long) this.f16061i) != c10) && o10 != -1) {
                z11 = false;
            } else {
                z11 = true;
            }
            if (z11) {
                e eVar = this.f16053a;
                while (true) {
                    try {
                        hVar = (h) eVar.e();
                        if (hVar != null) {
                            break;
                        }
                        Thread.sleep(5);
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                        throw new InterruptedIOException();
                    } catch (f e10) {
                        throw b1.a("SubtitleDecoder failed.", e10);
                    }
                }
                hVar.j(this.f16061i);
                hVar.f9515j.put(b0Var.f8414a, 0, this.f16061i);
                hVar.f9515j.limit(this.f16061i);
                eVar.c(hVar);
                while (true) {
                    iVar = (i) eVar.d();
                    if (iVar != null) {
                        break;
                    }
                    Thread.sleep(5);
                }
                for (int i16 = 0; i16 < iVar.d(); i16++) {
                    List c11 = iVar.c(iVar.b(i16));
                    this.f16054b.getClass();
                    byte[] a10 = b.a(c11);
                    this.f16057e.add(Long.valueOf(iVar.b(i16)));
                    this.f16058f.add(new b0(a10));
                }
                iVar.h();
                b();
                this.f16062j = 4;
            }
        }
        if (this.f16062j == 3) {
            if (wVar.c() != -1) {
                i13 = b.a(wVar.c());
            }
            if (wVar.a(i13) != -1) {
                z12 = false;
            }
            if (z12) {
                b();
                this.f16062j = 4;
            }
        }
        if (this.f16062j == 4) {
            return -1;
        }
        return 0;
    }

    public final void e(y yVar) {
        a.e(this.f16062j == 0);
        this.f16059g = yVar;
        this.f16060h = yVar.d(0, 3);
        this.f16059g.a();
        this.f16059g.g(new j0(-9223372036854775807L, new long[]{0}, new long[]{0}));
        this.f16060h.a(this.f16056d);
        this.f16062j = 1;
    }

    public final boolean h(w wVar) {
        return true;
    }
}
