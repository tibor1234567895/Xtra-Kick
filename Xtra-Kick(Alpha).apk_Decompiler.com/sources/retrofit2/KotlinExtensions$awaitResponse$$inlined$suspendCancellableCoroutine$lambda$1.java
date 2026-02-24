package retrofit2;

import la.v;
import wa.l;
import xa.k;

public final class KotlinExtensions$awaitResponse$$inlined$suspendCancellableCoroutine$lambda$1 extends k implements l {
    final /* synthetic */ Call $this_awaitResponse$inlined;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public KotlinExtensions$awaitResponse$$inlined$suspendCancellableCoroutine$lambda$1(Call call) {
        super(1);
        this.$this_awaitResponse$inlined = call;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return v.f9814a;
    }

    public final void invoke(Throwable th) {
        this.$this_awaitResponse$inlined.cancel();
    }
}
