package f3;

import d2.x0;

public final class o {

    /* renamed from: a  reason: collision with root package name */
    public final x0 f5662a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f5663b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f5664c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f5665d;

    /* renamed from: e  reason: collision with root package name */
    public int f5666e;

    /* renamed from: f  reason: collision with root package name */
    public int f5667f;

    /* renamed from: g  reason: collision with root package name */
    public long f5668g;

    /* renamed from: h  reason: collision with root package name */
    public long f5669h;

    public o(x0 x0Var) {
        this.f5662a = x0Var;
    }

    public final void a(byte[] bArr, int i10, int i11) {
        if (this.f5664c) {
            int i12 = this.f5667f;
            int i13 = (i10 + 1) - i12;
            if (i13 < i11) {
                this.f5665d = ((bArr[i13] & 192) >> 6) == 0;
                this.f5664c = false;
                return;
            }
            this.f5667f = (i11 - i10) + i12;
        }
    }
}
