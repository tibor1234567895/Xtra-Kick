package f5;

import b5.j;
import d5.o0;
import d5.w;
import h5.f0;
import h5.g0;
import java.util.ArrayDeque;
import w5.k;

public final class h extends k {

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f5822d = 0;

    /* renamed from: e  reason: collision with root package name */
    public Object f5823e;

    public h(long j10) {
        super(j10);
    }

    public final int b(Object obj) {
        switch (this.f5822d) {
            case 0:
                o0 o0Var = (o0) obj;
                if (o0Var == null) {
                    return 1;
                }
                return o0Var.b();
            default:
                return 1;
        }
    }

    public final void c(Object obj, Object obj2) {
        switch (this.f5822d) {
            case 0:
                j jVar = (j) obj;
                o0 o0Var = (o0) obj2;
                i iVar = (i) this.f5823e;
                if (iVar != null && o0Var != null) {
                    ((w) iVar).f4502e.a(o0Var, true);
                    return;
                }
                return;
            default:
                f0 f0Var = (f0) obj;
                f0Var.getClass();
                ArrayDeque arrayDeque = f0.f7570d;
                synchronized (arrayDeque) {
                    arrayDeque.offer(f0Var);
                }
                return;
        }
    }

    public final void f(int i10) {
        long j10;
        if (i10 >= 40) {
            e(0);
        } else if (i10 >= 20 || i10 == 15) {
            synchronized (this) {
                j10 = this.f16119b;
            }
            e(j10 / 2);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h(g0 g0Var, long j10) {
        super(j10);
        this.f5823e = g0Var;
    }
}
