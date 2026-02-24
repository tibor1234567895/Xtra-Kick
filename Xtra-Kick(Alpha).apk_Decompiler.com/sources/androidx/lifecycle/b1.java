package androidx.lifecycle;

import hb.f0;
import hb.h0;
import hb.l;
import hb.l1;
import java.util.concurrent.CancellationException;
import la.v;
import pa.e;
import qa.a;
import qa.d;
import ra.i;
import wa.p;
import xa.u;

public final class b1 extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public u f1658i;

    /* renamed from: j  reason: collision with root package name */
    public u f1659j;

    /* renamed from: k  reason: collision with root package name */
    public int f1660k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ t f1661l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ s f1662m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ f0 f1663n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ p f1664o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b1(t tVar, s sVar, f0 f0Var, p pVar, e eVar) {
        super(2, eVar);
        this.f1661l = tVar;
        this.f1662m = sVar;
        this.f1663n = f0Var;
        this.f1664o = pVar;
    }

    public final e create(Object obj, e eVar) {
        return new b1(this.f1661l, this.f1662m, this.f1663n, this.f1664o, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((b1) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        u uVar;
        u uVar2;
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f1660k;
        t tVar = this.f1661l;
        if (i10 == 0) {
            h0.O1(obj);
            if (tVar.b() == s.DESTROYED) {
                return v.f9814a;
            }
            u uVar3 = new u();
            u uVar4 = new u();
            try {
                s sVar = this.f1662m;
                f0 f0Var = this.f1663n;
                p pVar = this.f1664o;
                this.f1658i = uVar3;
                this.f1659j = uVar4;
                this.f1660k = 1;
                l lVar = new l(1, d.b(this));
                lVar.w();
                r.Companion.getClass();
                RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1 repeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1 = new RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1(p.c(sVar), uVar3, f0Var, p.a(sVar), lVar, ob.e.a(), pVar);
                uVar4.f16818h = repeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1;
                tVar.a(repeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1);
                Object u10 = lVar.u();
                if (u10 == aVar) {
                    h0.m1(this);
                }
                if (u10 == aVar) {
                    return aVar;
                }
                uVar = uVar3;
                uVar2 = uVar4;
            } catch (Throwable th) {
                th = th;
                uVar = uVar3;
                uVar2 = uVar4;
                l1 l1Var = (l1) uVar.f16818h;
                if (l1Var != null) {
                    l1Var.e((CancellationException) null);
                }
                b0 b0Var = (b0) uVar2.f16818h;
                if (b0Var != null) {
                    tVar.c(b0Var);
                }
                throw th;
            }
        } else if (i10 == 1) {
            uVar2 = this.f1659j;
            uVar = this.f1658i;
            try {
                h0.O1(obj);
            } catch (Throwable th2) {
                th = th2;
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        l1 l1Var2 = (l1) uVar.f16818h;
        if (l1Var2 != null) {
            l1Var2.e((CancellationException) null);
        }
        b0 b0Var2 = (b0) uVar2.f16818h;
        if (b0Var2 != null) {
            tVar.c(b0Var2);
        }
        return v.f9814a;
    }
}
