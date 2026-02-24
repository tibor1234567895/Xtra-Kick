package t6;

import android.content.Context;
import com.github.andreyasadchy.xtra.model.offline.LocalFollowChannel;
import e6.t0;
import e6.y0;
import hb.d1;
import hb.f0;
import hb.h0;
import la.v;
import pa.e;
import pa.h;
import qa.a;
import ra.i;
import wa.p;
import xa.j;

public final class e0 extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f14583i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f14584j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ i0 f14585k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Context f14586l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e0(int i10, i0 i0Var, Context context, e eVar) {
        super(2, eVar);
        this.f14584j = i10;
        this.f14585k = i0Var;
        this.f14586l = context;
    }

    public final e create(Object obj, e eVar) {
        return new e0(this.f14584j, this.f14585k, this.f14586l, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((e0) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f14583i;
        i0 i0Var = this.f14585k;
        if (i10 == 0) {
            h0.O1(obj);
            int i11 = this.f14584j;
            if (i11 != 0) {
                y0 y0Var = i0Var.f14604e;
                this.f14583i = 1;
                obj = y0Var.a(i11, this);
                if (obj == aVar) {
                    return aVar;
                }
            }
            return v.f9814a;
        } else if (i10 == 1) {
            try {
                h0.O1(obj);
            } catch (Exception unused) {
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        LocalFollowChannel localFollowChannel = (LocalFollowChannel) obj;
        if (localFollowChannel != null) {
            Context context = this.f14586l;
            y0 y0Var2 = i0Var.f14604e;
            y0Var2.getClass();
            j.f("context", context);
            h0.b1(d1.f7786h, (h) null, 0, new t0(localFollowChannel, y0Var2, context, (e) null), 3);
        }
        i0Var.f14609j.j(new la.i(Boolean.FALSE, (Object) null));
        return v.f9814a;
    }
}
