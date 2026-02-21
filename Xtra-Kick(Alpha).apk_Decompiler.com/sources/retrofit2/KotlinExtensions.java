package retrofit2;

import hb.h0;
import hb.l;
import pa.e;
import qa.a;
import qa.d;
import xa.j;

public final class KotlinExtensions {
    public static final <T> Object await(Call<T> call, e<? super T> eVar) {
        l lVar = new l(1, d.b(eVar));
        lVar.j(new KotlinExtensions$await$$inlined$suspendCancellableCoroutine$lambda$1(call));
        call.enqueue(new KotlinExtensions$await$2$2(lVar));
        Object u10 = lVar.u();
        if (u10 == a.COROUTINE_SUSPENDED) {
            h0.m1(eVar);
        }
        return u10;
    }

    public static final <T> Object awaitNullable(Call<T> call, e<? super T> eVar) {
        l lVar = new l(1, d.b(eVar));
        lVar.j(new KotlinExtensions$await$$inlined$suspendCancellableCoroutine$lambda$2(call));
        call.enqueue(new KotlinExtensions$await$4$2(lVar));
        Object u10 = lVar.u();
        if (u10 == a.COROUTINE_SUSPENDED) {
            h0.m1(eVar);
        }
        return u10;
    }

    public static final <T> Object awaitResponse(Call<T> call, e<? super Response<T>> eVar) {
        l lVar = new l(1, d.b(eVar));
        lVar.j(new KotlinExtensions$awaitResponse$$inlined$suspendCancellableCoroutine$lambda$1(call));
        call.enqueue(new KotlinExtensions$awaitResponse$2$2(lVar));
        Object u10 = lVar.u();
        if (u10 == a.COROUTINE_SUSPENDED) {
            h0.m1(eVar);
        }
        return u10;
    }

    public static final <T> T create(Retrofit retrofit) {
        j.g("$this$create", retrofit);
        throw new UnsupportedOperationException("This function has a reified type parameter and thus can only be inlined at compilation time, not called directly.");
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0021  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object suspendAndThrow(java.lang.Exception r4, pa.e<?> r5) {
        /*
            boolean r0 = r5 instanceof retrofit2.KotlinExtensions$suspendAndThrow$1
            if (r0 == 0) goto L_0x0013
            r0 = r5
            retrofit2.KotlinExtensions$suspendAndThrow$1 r0 = (retrofit2.KotlinExtensions$suspendAndThrow$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            retrofit2.KotlinExtensions$suspendAndThrow$1 r0 = new retrofit2.KotlinExtensions$suspendAndThrow$1
            r0.<init>(r5)
        L_0x0018:
            java.lang.Object r5 = r0.result
            qa.a r1 = qa.a.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r4 = r0.L$0
            java.lang.Exception r4 = (java.lang.Exception) r4
            hb.h0.O1(r5)
            la.v r4 = la.v.f9814a
            return r4
        L_0x002d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0035:
            hb.h0.O1(r5)
            r0.L$0 = r4
            r0.label = r3
            nb.e r5 = hb.p0.f7833a
            pa.k r2 = r0.getContext()
            retrofit2.KotlinExtensions$suspendAndThrow$$inlined$suspendCoroutineUninterceptedOrReturn$lambda$1 r3 = new retrofit2.KotlinExtensions$suspendAndThrow$$inlined$suspendCoroutineUninterceptedOrReturn$lambda$1
            r3.<init>(r0, r4)
            r5.M0(r2, r3)
            hb.h0.m1(r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: retrofit2.KotlinExtensions.suspendAndThrow(java.lang.Exception, pa.e):java.lang.Object");
    }
}
