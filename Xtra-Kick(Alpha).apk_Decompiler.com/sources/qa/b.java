package qa;

import hb.h0;
import pa.e;
import ra.g;
import wa.p;
import xa.j;
import xa.y;

public final class b extends g {

    /* renamed from: h  reason: collision with root package name */
    public int f13468h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ p f13469i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Object f13470j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(Object obj, e eVar, p pVar) {
        super(eVar);
        this.f13469i = pVar;
        this.f13470j = obj;
        j.d("null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>", eVar);
    }

    public final Object invokeSuspend(Object obj) {
        int i10 = this.f13468h;
        if (i10 == 0) {
            this.f13468h = 1;
            h0.O1(obj);
            p pVar = this.f13469i;
            j.d("null cannot be cast to non-null type kotlin.Function2<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1>, kotlin.Any?>", pVar);
            y.c(2, pVar);
            return pVar.g(this.f13470j, this);
        } else if (i10 == 1) {
            this.f13468h = 2;
            h0.O1(obj);
            return obj;
        } else {
            throw new IllegalStateException("This coroutine had already completed".toString());
        }
    }
}
