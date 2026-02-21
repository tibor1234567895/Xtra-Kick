package i2;

import d2.w;
import j1.a;

public final class d implements w {

    /* renamed from: a  reason: collision with root package name */
    public final w f8016a;

    /* renamed from: b  reason: collision with root package name */
    public final long f8017b;

    public d(w wVar, long j10) {
        boolean z10;
        this.f8016a = wVar;
        if (wVar.p() >= j10) {
            z10 = true;
        } else {
            z10 = false;
        }
        a.b(z10);
        this.f8017b = j10;
    }

    public final int a(int i10) {
        return this.f8016a.a(i10);
    }

    public final boolean b(byte[] bArr, int i10, int i11, boolean z10) {
        return this.f8016a.b(bArr, i10, i11, z10);
    }

    public final long c() {
        return this.f8016a.c() - this.f8017b;
    }

    public final int d(byte[] bArr, int i10, int i11) {
        return this.f8016a.d(bArr, i10, i11);
    }

    public final void f() {
        this.f8016a.f();
    }

    public final void g(int i10) {
        this.f8016a.g(i10);
    }

    public final boolean h(int i10, boolean z10) {
        return this.f8016a.h(i10, z10);
    }

    public final boolean k(byte[] bArr, int i10, int i11, boolean z10) {
        return this.f8016a.k(bArr, i10, i11, z10);
    }

    public final long l() {
        return this.f8016a.l() - this.f8017b;
    }

    public final void m(byte[] bArr, int i10, int i11) {
        this.f8016a.m(bArr, i10, i11);
    }

    public final void n(int i10) {
        this.f8016a.n(i10);
    }

    public final int o(byte[] bArr, int i10, int i11) {
        return this.f8016a.o(bArr, i10, i11);
    }

    public final long p() {
        return this.f8016a.p() - this.f8017b;
    }

    public final void readFully(byte[] bArr, int i10, int i11) {
        this.f8016a.readFully(bArr, i10, i11);
    }
}
