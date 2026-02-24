package n3;

import hb.h0;
import hb.l1;
import java.util.concurrent.CancellationException;
import kb.j;
import la.v;
import o7.g;
import pa.e;
import qa.a;
import ra.i;
import wa.q;

public final class u extends i implements q {

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f11493i;

    /* renamed from: j  reason: collision with root package name */
    public int f11494j;

    /* renamed from: k  reason: collision with root package name */
    public /* synthetic */ Object f11495k;

    /* renamed from: l  reason: collision with root package name */
    public /* synthetic */ Object f11496l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ u(int i10, e eVar) {
        super(3, eVar);
        this.f11493i = i10;
    }

    public final Object e(Object obj, Object obj2, Object obj3) {
        switch (this.f11493i) {
            case 0:
                u uVar = new u(0, (e) obj3);
                uVar.f11495k = (f1) obj;
                uVar.f11496l = (f1) obj2;
                return uVar.invokeSuspend(v.f9814a);
            case 1:
                return l((j) obj, obj2, (e) obj3);
            default:
                return l((j) obj, obj2, (e) obj3);
        }
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        switch (this.f11493i) {
            case 0:
                int i10 = this.f11494j;
                if (i10 == 0) {
                    h0.O1(obj);
                    f1 f1Var = (f1) this.f11496l;
                    this.f11495k = f1Var;
                    this.f11494j = 1;
                    ((l1) ((f1) this.f11495k).f11148b.f8717d).e((CancellationException) null);
                    if (v.f9814a == aVar) {
                        return aVar;
                    }
                    return f1Var;
                } else if (i10 == 1) {
                    f1 f1Var2 = (f1) this.f11495k;
                    h0.O1(obj);
                    return f1Var2;
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            case 1:
                int i11 = this.f11494j;
                if (i11 == 0) {
                    h0.O1(obj);
                    this.f11494j = 1;
                    if (h0.Q((j) this.f11495k, (kb.i) new e.a(new r3(30, 3, 30), (wa.a) new e7.i((String) this.f11496l, 1)).f4852i, this) == aVar) {
                        return aVar;
                    }
                } else if (i11 == 1) {
                    h0.O1(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return v.f9814a;
            default:
                int i12 = this.f11494j;
                if (i12 == 0) {
                    h0.O1(obj);
                    o7.e eVar = (o7.e) this.f11496l;
                    this.f11494j = 1;
                    if (h0.Q((j) this.f11495k, (kb.i) new e.a(new r3(30, 3, 30), (wa.a) g.f12300h).f4852i, this) == aVar) {
                        return aVar;
                    }
                } else if (i12 == 1) {
                    h0.O1(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return v.f9814a;
        }
    }

    public final Object l(j jVar, Object obj, e eVar) {
        switch (this.f11493i) {
            case 1:
                u uVar = new u(1, eVar);
                uVar.f11495k = jVar;
                uVar.f11496l = obj;
                return uVar.invokeSuspend(v.f9814a);
            default:
                u uVar2 = new u(2, eVar);
                uVar2.f11495k = jVar;
                uVar2.f11496l = obj;
                return uVar2.invokeSuspend(v.f9814a);
        }
    }
}
