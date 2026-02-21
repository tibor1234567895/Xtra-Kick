package kb;

import hb.f0;
import hb.h0;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import jb.a;
import jb.r;
import jb.s;
import la.v;
import lb.f;
import lb.y;
import pa.k;
import pa.l;

public final class e extends f {

    /* renamed from: m  reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f9290m = AtomicIntegerFieldUpdater.newUpdater(e.class, "consumed");
    private volatile int consumed;

    /* renamed from: k  reason: collision with root package name */
    public final s f9291k;

    /* renamed from: l  reason: collision with root package name */
    public final boolean f9292l;

    public /* synthetic */ e(s sVar, boolean z10) {
        this(sVar, z10, l.f12754h, -3, a.SUSPEND);
    }

    public final Object b(j jVar, pa.e eVar) {
        int i10 = this.f9833i;
        qa.a aVar = qa.a.COROUTINE_SUSPENDED;
        if (i10 == -3) {
            k();
            Object R = h0.R(jVar, this.f9291k, this.f9292l, eVar);
            if (R == aVar) {
                return R;
            }
            return v.f9814a;
        }
        Object b10 = super.b(jVar, eVar);
        if (b10 == aVar) {
            return b10;
        }
        return v.f9814a;
    }

    public final String e() {
        return "channel=" + this.f9291k;
    }

    public final Object f(r rVar, pa.e eVar) {
        Object R = h0.R(new y(rVar), this.f9291k, this.f9292l, eVar);
        if (R == qa.a.COROUTINE_SUSPENDED) {
            return R;
        }
        return v.f9814a;
    }

    public final f g(k kVar, int i10, a aVar) {
        return new e(this.f9291k, this.f9292l, kVar, i10, aVar);
    }

    public final i i() {
        return new e(this.f9291k, this.f9292l);
    }

    public final s j(f0 f0Var) {
        k();
        return this.f9833i == -3 ? this.f9291k : super.j(f0Var);
    }

    public final void k() {
        if (this.f9292l) {
            boolean z10 = true;
            if (f9290m.getAndSet(this, 1) != 0) {
                z10 = false;
            }
            if (!z10) {
                throw new IllegalStateException("ReceiveChannel.consumeAsFlow can be collected just once".toString());
            }
        }
    }

    public e(s sVar, boolean z10, k kVar, int i10, a aVar) {
        super(kVar, i10, aVar);
        this.f9291k = sVar;
        this.f9292l = z10;
        this.consumed = 0;
    }
}
