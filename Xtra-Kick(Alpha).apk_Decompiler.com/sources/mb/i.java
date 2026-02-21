package mb;

import hb.d0;
import hb.f2;
import hb.h0;
import hb.o0;
import hb.s0;
import hb.w;
import hb.x;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import la.l;
import la.v;
import pa.e;
import pa.k;
import ra.d;

public final class i extends o0 implements d, e {

    /* renamed from: o  reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f10859o = AtomicReferenceFieldUpdater.newUpdater(i.class, Object.class, "_reusableCancellableContinuation");
    private volatile Object _reusableCancellableContinuation;

    /* renamed from: k  reason: collision with root package name */
    public final d0 f10860k;

    /* renamed from: l  reason: collision with root package name */
    public final e f10861l;

    /* renamed from: m  reason: collision with root package name */
    public Object f10862m = j.f10864a;

    /* renamed from: n  reason: collision with root package name */
    public final Object f10863n = f0.b(getContext());

    public i(d0 d0Var, e eVar) {
        super(-1);
        this.f10860k = d0Var;
        this.f10861l = eVar;
    }

    public final void b(Object obj, CancellationException cancellationException) {
        if (obj instanceof x) {
            ((x) obj).f7881b.invoke(cancellationException);
        }
    }

    public final e c() {
        return this;
    }

    public final d getCallerFrame() {
        e eVar = this.f10861l;
        if (eVar instanceof d) {
            return (d) eVar;
        }
        return null;
    }

    public final k getContext() {
        return this.f10861l.getContext();
    }

    public final Object k() {
        Object obj = this.f10862m;
        this.f10862m = j.f10864a;
        return obj;
    }

    public final void resumeWith(Object obj) {
        Object obj2;
        k context;
        Object c10;
        e eVar = this.f10861l;
        k context2 = eVar.getContext();
        Throwable a10 = l.a(obj);
        if (a10 == null) {
            obj2 = obj;
        } else {
            obj2 = new w(a10, false);
        }
        d0 d0Var = this.f10860k;
        if (d0Var.O0(context2)) {
            this.f10862m = obj2;
            this.f7831j = 0;
            d0Var.M0(context2, this);
            return;
        }
        f2.f7793a.getClass();
        s0 a11 = f2.a();
        if (a11.T0()) {
            this.f10862m = obj2;
            this.f7831j = 0;
            a11.R0(this);
            return;
        }
        a11.S0(true);
        try {
            context = getContext();
            c10 = f0.c(context, this.f10863n);
            eVar.resumeWith(obj);
            v vVar = v.f9814a;
            f0.a(context, c10);
            do {
            } while (a11.V0());
        } catch (Throwable th) {
            try {
                h(th, (Throwable) null);
            } catch (Throwable th2) {
                a11.Q0(true);
                throw th2;
            }
        }
        a11.Q0(true);
    }

    public final String toString() {
        return "DispatchedContinuation[" + this.f10860k + ", " + h0.S1(this.f10861l) + ']';
    }
}
