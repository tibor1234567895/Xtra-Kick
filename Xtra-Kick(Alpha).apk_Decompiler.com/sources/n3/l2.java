package n3;

import android.support.v4.media.h;
import hb.h0;
import kb.j;
import kb.l;
import kb.s0;
import la.v;
import ob.d;
import pa.e;
import qa.a;
import ra.i;
import wa.q;

public final class l2 extends i implements q {

    /* renamed from: i  reason: collision with root package name */
    public int f11301i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ j f11302j;

    /* renamed from: k  reason: collision with root package name */
    public /* synthetic */ Object f11303k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ g3 f11304l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ d1 f11305m;

    /* renamed from: n  reason: collision with root package name */
    public d f11306n;

    /* renamed from: o  reason: collision with root package name */
    public int f11307o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public l2(d1 d1Var, g3 g3Var, e eVar) {
        super(3, eVar);
        this.f11304l = g3Var;
        this.f11305m = d1Var;
    }

    public final Object e(Object obj, Object obj2, Object obj3) {
        g3 g3Var = this.f11304l;
        l2 l2Var = new l2(this.f11305m, g3Var, (e) obj3);
        l2Var.f11302j = (j) obj;
        l2Var.f11303k = obj2;
        return l2Var.invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        j jVar;
        h3 h3Var;
        d dVar;
        int i10;
        kb.i iVar;
        int i11;
        boolean z10;
        d1 d1Var = this.f11305m;
        a aVar = a.COROUTINE_SUSPENDED;
        int i12 = this.f11301i;
        g3 g3Var = this.f11304l;
        if (i12 == 0) {
            h0.O1(obj);
            jVar = this.f11302j;
            i10 = ((Number) this.f11303k).intValue();
            h3Var = g3Var.f11205l;
            dVar = h3Var.f11229a;
            this.f11302j = jVar;
            this.f11303k = h3Var;
            this.f11306n = dVar;
            this.f11307o = i10;
            this.f11301i = 1;
            if (dVar.e(this) == aVar) {
                return aVar;
            }
        } else if (i12 == 1) {
            i10 = this.f11307o;
            dVar = this.f11306n;
            h3Var = (h3) this.f11303k;
            jVar = this.f11302j;
            h0.O1(obj);
        } else if (i12 == 2) {
            h0.O1(obj);
            return v.f9814a;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        try {
            h1 h1Var = h3Var.f11230b.f11319l;
            a1 a10 = h1Var.a(d1Var);
            z0.f11599b.getClass();
            if (xa.j.a(a10, z0.f11600c)) {
                iVar = new l(new r0[0]);
            } else {
                if (!(h1Var.a(d1Var) instanceof w0)) {
                    h1Var.c(d1Var, z0.f11601d);
                }
                v vVar = v.f9814a;
                dVar.f((Object) null);
                s0 a11 = g3Var.f11202i.a(d1Var);
                if (i10 == 0) {
                    i11 = 0;
                } else {
                    i11 = 1;
                }
                if (i11 >= 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (z10) {
                    iVar = new n2(new n2(a11, i11, 1), i10, 0);
                } else {
                    throw new IllegalArgumentException(h.i("Drop count should be non-negative, but had ", i11).toString());
                }
            }
            this.f11302j = null;
            this.f11303k = null;
            this.f11306n = null;
            this.f11301i = 2;
            if (h0.Q(jVar, iVar, this) == aVar) {
                return aVar;
            }
            return v.f9814a;
        } finally {
            dVar.f((Object) null);
        }
    }
}
