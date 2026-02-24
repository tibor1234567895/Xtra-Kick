package q1;

import android.support.v4.media.h;
import d2.w0;
import d2.x0;
import g1.a0;
import g1.p;
import g1.z;
import j1.b0;
import j1.l0;
import j1.v;
import java.io.EOFException;
import java.util.Arrays;
import l2.b;
import l2.c;

public final class t implements x0 {

    /* renamed from: g  reason: collision with root package name */
    public static final a0 f13243g;

    /* renamed from: h  reason: collision with root package name */
    public static final a0 f13244h;

    /* renamed from: a  reason: collision with root package name */
    public final c f13245a = new c();

    /* renamed from: b  reason: collision with root package name */
    public final x0 f13246b;

    /* renamed from: c  reason: collision with root package name */
    public final a0 f13247c;

    /* renamed from: d  reason: collision with root package name */
    public a0 f13248d;

    /* renamed from: e  reason: collision with root package name */
    public byte[] f13249e;

    /* renamed from: f  reason: collision with root package name */
    public int f13250f;

    static {
        z zVar = new z();
        zVar.f6754k = "application/id3";
        f13243g = zVar.a();
        z zVar2 = new z();
        zVar2.f6754k = "application/x-emsg";
        f13244h = zVar2.a();
    }

    public t(x0 x0Var, int i10) {
        a0 a0Var;
        this.f13246b = x0Var;
        if (i10 == 1) {
            a0Var = f13243g;
        } else if (i10 == 3) {
            a0Var = f13244h;
        } else {
            throw new IllegalArgumentException(h.i("Unknown metadataType: ", i10));
        }
        this.f13247c = a0Var;
        this.f13249e = new byte[0];
        this.f13250f = 0;
    }

    public final void a(a0 a0Var) {
        this.f13248d = a0Var;
        this.f13246b.a(this.f13247c);
    }

    public final void b(int i10, b0 b0Var) {
        int i11 = this.f13250f + i10;
        byte[] bArr = this.f13249e;
        if (bArr.length < i11) {
            this.f13249e = Arrays.copyOf(bArr, (i11 / 2) + i11);
        }
        b0Var.d(this.f13249e, this.f13250f, i10);
        this.f13250f += i10;
    }

    public final int c(p pVar, int i10, boolean z10) {
        return f(pVar, i10, z10);
    }

    public final void d(int i10, b0 b0Var) {
        b(i10, b0Var);
    }

    public final void e(long j10, int i10, int i11, int i12, w0 w0Var) {
        boolean z10;
        this.f13248d.getClass();
        int i13 = this.f13250f - i12;
        b0 b0Var = new b0(Arrays.copyOfRange(this.f13249e, i13 - i11, i13));
        byte[] bArr = this.f13249e;
        System.arraycopy(bArr, i13, bArr, 0, i12);
        this.f13250f = i12;
        String str = this.f13248d.f6276s;
        a0 a0Var = this.f13247c;
        if (!l0.a(str, a0Var.f6276s)) {
            if ("application/x-emsg".equals(this.f13248d.f6276s)) {
                this.f13245a.getClass();
                b c10 = c.c(b0Var);
                a0 g10 = c10.g();
                String str2 = a0Var.f6276s;
                if (g10 == null || !l0.a(str2, g10.f6276s)) {
                    z10 = false;
                } else {
                    z10 = true;
                }
                if (!z10) {
                    v.g("HlsSampleStreamWrapper", String.format("Ignoring EMSG. Expected it to contain wrapped %s but actual wrapped format: %s", new Object[]{str2, c10.g()}));
                    return;
                }
                byte[] r10 = c10.r();
                r10.getClass();
                b0Var = new b0(r10);
            } else {
                v.g("HlsSampleStreamWrapper", "Ignoring sample for unsupported format: " + this.f13248d.f6276s);
                return;
            }
        }
        int i14 = b0Var.f8416c - b0Var.f8415b;
        this.f13246b.d(i14, b0Var);
        this.f13246b.e(j10, i10, i14, i12, w0Var);
    }

    public final int f(p pVar, int i10, boolean z10) {
        int i11 = this.f13250f + i10;
        byte[] bArr = this.f13249e;
        if (bArr.length < i11) {
            this.f13249e = Arrays.copyOf(bArr, (i11 / 2) + i11);
        }
        int o10 = pVar.o(this.f13249e, this.f13250f, i10);
        if (o10 != -1) {
            this.f13250f += o10;
            return o10;
        } else if (z10) {
            return -1;
        } else {
            throw new EOFException();
        }
    }
}
