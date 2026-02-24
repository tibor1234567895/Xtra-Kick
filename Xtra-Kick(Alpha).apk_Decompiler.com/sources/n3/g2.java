package n3;

import androidx.lifecycle.p1;
import hb.h0;
import hb.l1;
import hb.o1;
import java.util.concurrent.atomic.AtomicInteger;
import la.v;
import pa.e;
import qa.a;
import ra.i;
import wa.p;

public final class g2 extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f11189i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f11190j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ kb.i f11191k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ kb.i f11192l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ h1 f11193m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g2(kb.i iVar, kb.i iVar2, e eVar, h1 h1Var) {
        super(2, eVar);
        this.f11191k = iVar;
        this.f11192l = iVar2;
        this.f11193m = h1Var;
    }

    public final e create(Object obj, e eVar) {
        g2 g2Var = new g2(this.f11191k, this.f11192l, eVar, this.f11193m);
        g2Var.f11190j = obj;
        return g2Var;
    }

    public final Object g(Object obj, Object obj2) {
        return ((g2) create((k5) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f11189i;
        if (i10 == 0) {
            h0.O1(obj);
            k5 k5Var = (k5) this.f11190j;
            AtomicInteger atomicInteger = new AtomicInteger(2);
            x5 x5Var = new x5(new c2(k5Var, (e) null, this.f11193m));
            o1 o1Var = new o1((l1) null);
            kb.i[] iVarArr = {this.f11191k, this.f11192l};
            int i11 = 0;
            int i12 = 0;
            while (i11 < 2) {
                f2 f2Var = r4;
                f2 f2Var2 = new f2(iVarArr[i11], atomicInteger, k5Var, x5Var, i12, (e) null);
                h0.b1(k5Var, o1Var, 0, f2Var, 2);
                i11++;
                atomicInteger = atomicInteger;
                i12++;
            }
            p1 p1Var = new p1(3, o1Var);
            this.f11189i = 1;
            if (k5Var.c(p1Var, this) == aVar) {
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
