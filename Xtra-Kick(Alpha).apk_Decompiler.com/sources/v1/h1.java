package v1;

import a2.n;
import java.util.Arrays;
import k1.e0;
import k1.h;
import k1.k;
import k1.m;

public final class h1 implements n {

    /* renamed from: a  reason: collision with root package name */
    public final m f15654a;

    /* renamed from: b  reason: collision with root package name */
    public final e0 f15655b;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f15656c;

    public h1(h hVar, m mVar) {
        r.f15758a.getAndIncrement();
        this.f15654a = mVar;
        this.f15655b = new e0(hVar);
    }

    public final void a() {
        e0 e0Var = this.f15655b;
        e0Var.f8991b = 0;
        try {
            e0Var.q(this.f15654a);
            int i10 = 0;
            while (i10 != -1) {
                int i11 = (int) e0Var.f8991b;
                byte[] bArr = this.f15656c;
                if (bArr == null) {
                    this.f15656c = new byte[1024];
                } else if (i11 == bArr.length) {
                    this.f15656c = Arrays.copyOf(bArr, bArr.length * 2);
                }
                byte[] bArr2 = this.f15656c;
                i10 = e0Var.o(bArr2, i11, bArr2.length - i11);
            }
        } finally {
            k.a(e0Var);
        }
    }

    public final void b() {
    }
}
