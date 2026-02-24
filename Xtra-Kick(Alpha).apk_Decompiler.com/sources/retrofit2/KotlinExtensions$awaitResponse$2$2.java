package retrofit2;

import hb.h0;
import hb.k;
import la.l;
import xa.j;

public final class KotlinExtensions$awaitResponse$2$2 implements Callback<T> {
    final /* synthetic */ k $continuation;

    public KotlinExtensions$awaitResponse$2$2(k kVar) {
        this.$continuation = kVar;
    }

    public void onFailure(Call<T> call, Throwable th) {
        j.g("call", call);
        j.g("t", th);
        k kVar = this.$continuation;
        int i10 = l.f9802h;
        kVar.resumeWith(h0.I(th));
    }

    public void onResponse(Call<T> call, Response<T> response) {
        j.g("call", call);
        j.g("response", response);
        k kVar = this.$continuation;
        int i10 = l.f9802h;
        kVar.resumeWith(response);
    }
}
