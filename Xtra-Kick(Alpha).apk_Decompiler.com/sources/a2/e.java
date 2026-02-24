package a2;

import j1.l0;
import java.util.Arrays;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f22a = true;

    /* renamed from: b  reason: collision with root package name */
    public final int f23b = 65536;

    /* renamed from: c  reason: collision with root package name */
    public int f24c;

    /* renamed from: d  reason: collision with root package name */
    public int f25d;

    /* renamed from: e  reason: collision with root package name */
    public int f26e = 0;

    /* renamed from: f  reason: collision with root package name */
    public a[] f27f = new a[100];

    public final synchronized void a(int i10) {
        boolean z10 = i10 < this.f24c;
        this.f24c = i10;
        if (z10) {
            b();
        }
    }

    public final synchronized void b() {
        int i10 = this.f24c;
        int i11 = this.f23b;
        int i12 = l0.f8453a;
        int max = Math.max(0, (((i10 + i11) - 1) / i11) - this.f25d);
        int i13 = this.f26e;
        if (max < i13) {
            Arrays.fill(this.f27f, max, i13, (Object) null);
            this.f26e = max;
        }
    }
}
