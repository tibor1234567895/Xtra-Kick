package retrofit2;

import hb.h0;
import hb.k;
import la.l;
import xa.j;

public final class KotlinExtensions$await$4$2 implements Callback<T> {
    final /* synthetic */ k $continuation;

    public KotlinExtensions$await$4$2(k kVar) {
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
        T t10;
        k kVar;
        j.g("call", call);
        j.g("response", response);
        if (response.isSuccessful()) {
            kVar = this.$continuation;
            t10 = response.body();
            int i10 = l.f9802h;
        } else {
            kVar = this.$continuation;
            HttpException httpException = new HttpException(response);
            int i11 = l.f9802h;
            t10 = h0.I(httpException);
        }
        kVar.resumeWith(t10);
    }
}
