package f3;

import j1.a;
import java.util.Arrays;

public final class y {

    /* renamed from: a  reason: collision with root package name */
    public final int f5797a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f5798b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f5799c;

    /* renamed from: d  reason: collision with root package name */
    public byte[] f5800d;

    /* renamed from: e  reason: collision with root package name */
    public int f5801e;

    public y(int i10) {
        this.f5797a = i10;
        byte[] bArr = new byte[131];
        this.f5800d = bArr;
        bArr[2] = 1;
    }

    public final void a(byte[] bArr, int i10, int i11) {
        if (this.f5798b) {
            int i12 = i11 - i10;
            byte[] bArr2 = this.f5800d;
            int length = bArr2.length;
            int i13 = this.f5801e;
            if (length < i13 + i12) {
                this.f5800d = Arrays.copyOf(bArr2, (i13 + i12) * 2);
            }
            System.arraycopy(bArr, i10, this.f5800d, this.f5801e, i12);
            this.f5801e += i12;
        }
    }

    public final boolean b(int i10) {
        if (!this.f5798b) {
            return false;
        }
        this.f5801e -= i10;
        this.f5798b = false;
        this.f5799c = true;
        return true;
    }

    public final void c() {
        this.f5798b = false;
        this.f5799c = false;
    }

    public final void d(int i10) {
        boolean z10 = true;
        a.e(!this.f5798b);
        if (i10 != this.f5797a) {
            z10 = false;
        }
        this.f5798b = z10;
        if (z10) {
            this.f5801e = 3;
            this.f5799c = false;
        }
    }
}
