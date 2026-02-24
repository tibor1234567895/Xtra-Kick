package n4;

import hb.f0;
import hb.h0;
import i4.c;
import la.v;
import qa.a;
import ra.i;
import s4.m;
import wa.p;
import xa.u;

public final class e extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f11645i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ j f11646j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ u f11647k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ u f11648l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ s4.i f11649m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ Object f11650n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ u f11651o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ i4.i f11652p;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(j jVar, u uVar, u uVar2, s4.i iVar, Object obj, u uVar3, i4.i iVar2, pa.e eVar) {
        super(2, eVar);
        this.f11646j = jVar;
        this.f11647k = uVar;
        this.f11648l = uVar2;
        this.f11649m = iVar;
        this.f11650n = obj;
        this.f11651o = uVar3;
        this.f11652p = iVar2;
    }

    public final pa.e create(Object obj, pa.e eVar) {
        return new e(this.f11646j, this.f11647k, this.f11648l, this.f11649m, this.f11650n, this.f11651o, this.f11652p, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((e) create((f0) obj, (pa.e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f11645i;
        if (i10 == 0) {
            h0.O1(obj);
            j jVar = this.f11646j;
            i4.i iVar = this.f11652p;
            this.f11645i = 1;
            obj = j.a(jVar, (m4.v) this.f11647k.f16818h, (c) this.f11648l.f16818h, this.f11649m, this.f11650n, (m) this.f11651o.f16818h, iVar, this);
            if (obj == aVar) {
                return aVar;
            }
        } else if (i10 == 1) {
            h0.O1(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }
}
