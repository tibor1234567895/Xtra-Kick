package androidx.lifecycle;

import hb.f0;
import hb.h0;
import hb.l1;
import la.v;
import pa.e;
import qa.a;
import ra.i;
import wa.p;

public final class s0 extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f1753i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f1754j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ t f1755k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ s f1756l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ p f1757m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public s0(t tVar, s sVar, p pVar, e eVar) {
        super(2, eVar);
        this.f1755k = tVar;
        this.f1756l = sVar;
        this.f1757m = pVar;
    }

    public final e create(Object obj, e eVar) {
        s0 s0Var = new s0(this.f1755k, this.f1756l, this.f1757m, eVar);
        s0Var.f1754j = obj;
        return s0Var;
    }

    public final Object g(Object obj, Object obj2) {
        return ((s0) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        v vVar;
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f1753i;
        if (i10 == 0) {
            h0.O1(obj);
            l1 l1Var = (l1) ((f0) this.f1754j).v().N(l1.f7823b);
            if (l1Var != null) {
                r0 r0Var = new r0();
                v vVar2 = new v(this.f1755k, this.f1756l, r0Var.f1745j, l1Var);
                try {
                    p pVar = this.f1757m;
                    this.f1754j = vVar2;
                    this.f1753i = 1;
                    obj = h0.c2(r0Var, pVar, this);
                    if (obj == aVar) {
                        return aVar;
                    }
                    vVar = vVar2;
                } catch (Throwable th) {
                    th = th;
                    vVar = vVar2;
                    vVar.a();
                    throw th;
                }
            } else {
                throw new IllegalStateException("when[State] methods should have a parent job".toString());
            }
        } else if (i10 == 1) {
            vVar = (v) this.f1754j;
            try {
                h0.O1(obj);
            } catch (Throwable th2) {
                th = th2;
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        vVar.a();
        return obj;
    }
}
