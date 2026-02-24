package retrofit2;

import la.v;
import wa.l;
import xa.k;

public final class KotlinExtensions$await$$inlined$suspendCancellableCoroutine$lambda$2 extends k implements l {
    final /* synthetic */ Call $this_await$inlined;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public KotlinExtensions$await$$inlined$suspendCancellableCoroutine$lambda$2(Call call) {
        super(1);
        this.$this_await$inlined = call;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return v.f9814a;
    }

    public final void invoke(Throwable th) {
        this.$this_await$inlined.cancel();
    }
}
