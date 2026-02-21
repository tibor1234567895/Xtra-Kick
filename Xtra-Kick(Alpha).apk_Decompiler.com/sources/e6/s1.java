package e6;

import android.net.Uri;
import hb.f0;
import hb.h0;
import hb.p0;
import la.v;
import pa.e;
import qa.a;
import ra.i;
import wa.p;
import xa.j;

public final class s1 extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f5234i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ z1 f5235j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ String f5236k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public s1(z1 z1Var, String str, e eVar) {
        super(2, eVar);
        this.f5235j = z1Var;
        this.f5236k = str;
    }

    public final e create(Object obj, e eVar) {
        return new s1(this.f5235j, this.f5236k, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((s1) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f5234i;
        if (i10 == 0) {
            h0.O1(obj);
            x xVar = this.f5235j.f5286d;
            this.f5234i = 1;
            s0 s0Var = xVar.f5265a;
            s0Var.getClass();
            obj = h0.c2(p0.f7834b, new j0(s0Var, this.f5236k, (e) null), this);
            if (obj == aVar) {
                return aVar;
            }
        } else if (i10 == 1) {
            h0.O1(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        String str = (String) obj;
        if (str == null) {
            return null;
        }
        Uri parse = Uri.parse(str);
        j.e("parse(this)", parse);
        return parse;
    }
}
