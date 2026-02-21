package e6;

import a6.o;
import hb.f0;
import hb.h0;
import java.util.Collection;
import la.v;
import ma.z;
import pa.e;
import r3.n0;
import ra.i;
import wa.p;

public final class p1 extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Collection f5218i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ z1 f5219j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public p1(Collection collection, z1 z1Var, e eVar) {
        super(2, eVar);
        this.f5218i = collection;
        this.f5219j = z1Var;
    }

    public final e create(Object obj, e eVar) {
        return new p1(this.f5218i, this.f5219j, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((p1) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    /* JADX INFO: finally extract failed */
    public final Object invokeSuspend(Object obj) {
        h0.O1(obj);
        Collection collection = this.f5218i;
        int size = collection.size();
        if (size > 50) {
            collection = z.J(collection).subList(size - 50, size);
        }
        o oVar = (o) this.f5219j.f5284b;
        n0 n0Var = oVar.f250a;
        n0Var.c();
        try {
            h0.U(oVar, collection);
            n0Var.r();
            n0Var.g();
            return v.f9814a;
        } catch (Throwable th) {
            n0Var.g();
            throw th;
        }
    }
}
