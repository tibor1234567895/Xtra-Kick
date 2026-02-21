package d2;

public final class y0 {

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f4308a = new byte[10];

    /* renamed from: b  reason: collision with root package name */
    public boolean f4309b;

    /* renamed from: c  reason: collision with root package name */
    public int f4310c;

    /* renamed from: d  reason: collision with root package name */
    public long f4311d;

    /* renamed from: e  reason: collision with root package name */
    public int f4312e;

    /* renamed from: f  reason: collision with root package name */
    public int f4313f;

    /* renamed from: g  reason: collision with root package name */
    public int f4314g;

    public final void a(x0 x0Var, w0 w0Var) {
        if (this.f4310c > 0) {
            x0Var.e(this.f4311d, this.f4312e, this.f4313f, this.f4314g, w0Var);
            this.f4310c = 0;
        }
    }

    public final void b(x0 x0Var, long j10, int i10, int i11, int i12, w0 w0Var) {
        boolean z10;
        if (this.f4314g <= i11 + i12) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            throw new IllegalStateException("TrueHD chunk samples must be contiguous in the sample queue.");
        } else if (this.f4309b) {
            int i13 = this.f4310c;
            int i14 = i13 + 1;
            this.f4310c = i14;
            if (i13 == 0) {
                this.f4311d = j10;
                this.f4312e = i10;
                this.f4313f = 0;
            }
            this.f4313f += i11;
            this.f4314g = i12;
            if (i14 >= 16) {
                a(x0Var, w0Var);
            }
        }
    }

    public final void c(w wVar) {
        char c10;
        if (!this.f4309b) {
            byte[] bArr = this.f4308a;
            int i10 = 0;
            wVar.m(bArr, 0, 10);
            wVar.f();
            if (bArr[4] == -8 && bArr[5] == 114 && bArr[6] == 111) {
                byte b10 = bArr[7];
                if ((b10 & 254) == 186) {
                    if ((b10 & 255) == 187) {
                        i10 = 1;
                    }
                    if (i10 != 0) {
                        c10 = 9;
                    } else {
                        c10 = 8;
                    }
                    i10 = 40 << ((bArr[c10] >> 4) & 7);
                }
            }
            if (i10 != 0) {
                this.f4309b = true;
            }
        }
    }
}
