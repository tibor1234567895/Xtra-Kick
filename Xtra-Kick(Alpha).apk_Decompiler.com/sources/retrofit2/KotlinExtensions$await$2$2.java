package retrofit2;

import hb.h0;
import hb.k;
import java.lang.reflect.Method;
import la.d;
import la.l;
import pb.j1;
import xa.e;
import xa.j;
import xa.v;

public final class KotlinExtensions$await$2$2 implements Callback<T> {
    final /* synthetic */ k $continuation;

    public KotlinExtensions$await$2$2(k kVar) {
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
            t10 = response.body();
            if (t10 == null) {
                j1 request = call.request();
                request.getClass();
                e a10 = v.a(Invocation.class);
                Object cast = h0.s0(a10).cast(request.f12888e.get(a10));
                if (cast != null) {
                    Method method = ((Invocation) cast).method();
                    StringBuilder sb2 = new StringBuilder("Response from ");
                    j.b("method", method);
                    Class<?> declaringClass = method.getDeclaringClass();
                    j.b("method.declaringClass", declaringClass);
                    sb2.append(declaringClass.getName());
                    sb2.append('.');
                    sb2.append(method.getName());
                    sb2.append(" was null but response body type was declared as non-null");
                    d dVar = new d(sb2.toString());
                    kVar = this.$continuation;
                    int i10 = l.f9802h;
                    t10 = h0.I(dVar);
                } else {
                    d dVar2 = new d();
                    j.j(j.class.getName(), dVar2);
                    throw dVar2;
                }
            } else {
                kVar = this.$continuation;
                int i11 = l.f9802h;
            }
        } else {
            kVar = this.$continuation;
            HttpException httpException = new HttpException(response);
            int i12 = l.f9802h;
            t10 = h0.I(httpException);
        }
        kVar.resumeWith(t10);
    }
}
