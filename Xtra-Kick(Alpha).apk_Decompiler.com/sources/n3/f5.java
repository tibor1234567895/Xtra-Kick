package n3;

import hb.f0;
import hb.h0;
import jb.g;
import la.v;
import pa.e;
import qa.a;
import ra.i;
import wa.p;

public final class f5 extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f11161i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ g f11162j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ p f11163k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f5(g gVar, p pVar, e eVar) {
        super(2, eVar);
        this.f11162j = gVar;
        this.f11163k = pVar;
    }

    public final e create(Object obj, e eVar) {
        return new f5(this.f11162j, this.f11163k, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((f5) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f11161i;
        g gVar = this.f11162j;
        if (i10 == 0) {
            h0.O1(obj);
            e5 e5Var = new e5(gVar, this.f11163k, (e) null);
            this.f11161i = 1;
            if (h0.H(e5Var, this) == aVar) {
                return aVar;
            }
        } else if (i10 == 1) {
            try {
                h0.O1(obj);
            } catch (Throwable th) {
                gVar.b(th);
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        gVar.b((Throwable) null);
        return v.f9814a;
    }
}
