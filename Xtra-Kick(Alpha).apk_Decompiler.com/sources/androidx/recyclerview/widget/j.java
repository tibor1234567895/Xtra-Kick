package androidx.recyclerview.widget;

public final class j {

    /* renamed from: a  reason: collision with root package name */
    public long f2049a = 0;

    /* renamed from: b  reason: collision with root package name */
    public j f2050b;

    public final void a(int i10) {
        if (i10 >= 64) {
            j jVar = this.f2050b;
            if (jVar != null) {
                jVar.a(i10 - 64);
                return;
            }
            return;
        }
        this.f2049a &= ~(1 << i10);
    }

    public final int b(int i10) {
        long j10;
        j jVar = this.f2050b;
        if (jVar == null) {
            if (i10 >= 64) {
                j10 = this.f2049a;
            }
            j10 = this.f2049a & ((1 << i10) - 1);
        } else {
            if (i10 >= 64) {
                return Long.bitCount(this.f2049a) + jVar.b(i10 - 64);
            }
            j10 = this.f2049a & ((1 << i10) - 1);
        }
        return Long.bitCount(j10);
    }

    public final void c() {
        if (this.f2050b == null) {
            this.f2050b = new j();
        }
    }

    public final boolean d(int i10) {
        if (i10 < 64) {
            return (this.f2049a & (1 << i10)) != 0;
        }
        c();
        return this.f2050b.d(i10 - 64);
    }

    public final void e(int i10, boolean z10) {
        if (i10 >= 64) {
            c();
            this.f2050b.e(i10 - 64, z10);
            return;
        }
        long j10 = this.f2049a;
        boolean z11 = (Long.MIN_VALUE & j10) != 0;
        long j11 = (1 << i10) - 1;
        this.f2049a = ((j10 & (~j11)) << 1) | (j10 & j11);
        if (z10) {
            h(i10);
        } else {
            a(i10);
        }
        if (z11 || this.f2050b != null) {
            c();
            this.f2050b.e(0, z11);
        }
    }

    public final boolean f(int i10) {
        if (i10 >= 64) {
            c();
            return this.f2050b.f(i10 - 64);
        }
        long j10 = 1 << i10;
        long j11 = this.f2049a;
        boolean z10 = (j11 & j10) != 0;
        long j12 = j11 & (~j10);
        this.f2049a = j12;
        long j13 = j10 - 1;
        this.f2049a = (j12 & j13) | Long.rotateRight((~j13) & j12, 1);
        j jVar = this.f2050b;
        if (jVar != null) {
            if (jVar.d(0)) {
                h(63);
            }
            this.f2050b.f(0);
        }
        return z10;
    }

    public final void g() {
        this.f2049a = 0;
        j jVar = this.f2050b;
        if (jVar != null) {
            jVar.g();
        }
    }

    public final void h(int i10) {
        if (i10 >= 64) {
            c();
            this.f2050b.h(i10 - 64);
            return;
        }
        this.f2049a |= 1 << i10;
    }

    public final String toString() {
        if (this.f2050b == null) {
            return Long.toBinaryString(this.f2049a);
        }
        return this.f2050b.toString() + "xx" + Long.toBinaryString(this.f2049a);
    }
}
