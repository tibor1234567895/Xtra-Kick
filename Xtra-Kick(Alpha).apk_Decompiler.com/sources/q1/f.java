package q1;

import g1.a0;
import j1.l0;
import java.util.Arrays;
import k1.h;
import k1.k;
import k1.m;
import x1.a;

public final class f extends a {

    /* renamed from: j  reason: collision with root package name */
    public byte[] f13152j;

    /* renamed from: k  reason: collision with root package name */
    public volatile boolean f13153k;

    /* renamed from: l  reason: collision with root package name */
    public byte[] f13154l;

    public f(h hVar, m mVar, a0 a0Var, int i10, Object obj, byte[] bArr) {
        super(hVar, mVar, 3, a0Var, i10, obj, -9223372036854775807L, -9223372036854775807L);
        f fVar;
        byte[] bArr2;
        if (bArr == null) {
            bArr2 = l0.f8458f;
            fVar = this;
        } else {
            fVar = this;
            bArr2 = bArr;
        }
        fVar.f13152j = bArr2;
    }

    public final void a() {
        try {
            this.f16562i.q(this.f16555b);
            int i10 = 0;
            int i11 = 0;
            while (i10 != -1 && !this.f13153k) {
                byte[] bArr = this.f13152j;
                if (bArr.length < i11 + 16384) {
                    this.f13152j = Arrays.copyOf(bArr, bArr.length + 16384);
                }
                i10 = this.f16562i.o(this.f13152j, i11, 16384);
                if (i10 != -1) {
                    i11 += i10;
                }
            }
            if (!this.f13153k) {
                this.f13154l = Arrays.copyOf(this.f13152j, i11);
            }
        } finally {
            k.a(this.f16562i);
        }
    }

    public final void b() {
        this.f13153k = true;
    }
}
