package retrofit2;

import hb.h0;
import la.l;
import pa.e;
import qa.d;

public final class KotlinExtensions$suspendAndThrow$$inlined$suspendCoroutineUninterceptedOrReturn$lambda$1 implements Runnable {
    final /* synthetic */ e $continuation;
    final /* synthetic */ Exception $this_suspendAndThrow$inlined;

    public KotlinExtensions$suspendAndThrow$$inlined$suspendCoroutineUninterceptedOrReturn$lambda$1(e eVar, Exception exc) {
        this.$continuation = eVar;
        this.$this_suspendAndThrow$inlined = exc;
    }

    public final void run() {
        e b10 = d.b(this.$continuation);
        Exception exc = this.$this_suspendAndThrow$inlined;
        int i10 = l.f9802h;
        b10.resumeWith(h0.I(exc));
    }
}
