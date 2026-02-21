package androidx.lifecycle;

import hb.f0;
import hb.h0;
import hb.p0;
import la.v;
import mb.u;
import pa.e;
import qa.a;
import ra.i;
import wa.p;

public final class w extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f1778i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ x f1779j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ p f1780k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public w(x xVar, p pVar, e eVar) {
        super(2, eVar);
        this.f1779j = xVar;
        this.f1780k = pVar;
    }

    public final e create(Object obj, e eVar) {
        return new w(this.f1779j, this.f1780k, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((w) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f1778i;
        if (i10 == 0) {
            h0.O1(obj);
            t c10 = this.f1779j.c();
            this.f1778i = 1;
            s sVar = s.RESUMED;
            nb.e eVar = p0.f7833a;
            if (h0.c2(u.f10886a.Q0(), new s0(c10, sVar, this.f1780k, (e) null), this) == aVar) {
                return aVar;
            }
        } else if (i10 == 1) {
            h0.O1(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return v.f9814a;
    }
}
