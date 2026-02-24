package c2;

import g1.a0;
import j1.b0;
import j1.l0;
import java.nio.ByteBuffer;
import l1.h;
import m1.f;
import m1.w0;

public final class b extends f {

    /* renamed from: t  reason: collision with root package name */
    public final h f2722t = new h(1);

    /* renamed from: u  reason: collision with root package name */
    public final b0 f2723u = new b0();

    /* renamed from: v  reason: collision with root package name */
    public long f2724v;

    /* renamed from: w  reason: collision with root package name */
    public a f2725w;

    /* renamed from: x  reason: collision with root package name */
    public long f2726x;

    public b() {
        super(6);
    }

    public final void b(int i10, Object obj) {
        if (i10 == 8) {
            this.f2725w = (a) obj;
        }
    }

    public final String g() {
        return "CameraMotionRenderer";
    }

    public final boolean j() {
        return h();
    }

    public final boolean k() {
        return true;
    }

    public final void l() {
        a aVar = this.f2725w;
        if (aVar != null) {
            aVar.c();
        }
    }

    public final void n(long j10, boolean z10) {
        this.f2726x = Long.MIN_VALUE;
        a aVar = this.f2725w;
        if (aVar != null) {
            aVar.c();
        }
    }

    public final void r(a0[] a0VarArr, long j10, long j11) {
        this.f2724v = j11;
    }

    public final void t(long j10, long j11) {
        float[] fArr;
        while (!h() && this.f2726x < 100000 + j10) {
            h hVar = this.f2722t;
            hVar.h();
            w0 w0Var = this.f10217i;
            w0Var.a();
            if (s(w0Var, hVar, 0) == -4 && !hVar.f(4)) {
                this.f2726x = hVar.f9517l;
                if (this.f2725w != null && !hVar.g()) {
                    hVar.k();
                    ByteBuffer byteBuffer = hVar.f9515j;
                    int i10 = l0.f8453a;
                    if (byteBuffer.remaining() != 16) {
                        fArr = null;
                    } else {
                        byte[] array = byteBuffer.array();
                        int limit = byteBuffer.limit();
                        b0 b0Var = this.f2723u;
                        b0Var.E(limit, array);
                        b0Var.G(byteBuffer.arrayOffset() + 4);
                        float[] fArr2 = new float[3];
                        for (int i11 = 0; i11 < 3; i11++) {
                            fArr2[i11] = Float.intBitsToFloat(b0Var.i());
                        }
                        fArr = fArr2;
                    }
                    if (fArr != null) {
                        this.f2725w.a(this.f2726x - this.f2724v, fArr);
                    }
                }
            } else {
                return;
            }
        }
    }

    public final int x(a0 a0Var) {
        return "application/x-camera-motion".equals(a0Var.f6276s) ? android.support.v4.media.h.c(4, 0, 0) : android.support.v4.media.h.c(0, 0, 0);
    }
}
