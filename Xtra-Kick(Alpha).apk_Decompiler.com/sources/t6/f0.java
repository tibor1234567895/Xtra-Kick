package t6;

import androidx.lifecycle.o0;
import com.github.andreyasadchy.xtra.model.offline.LocalFollowChannel;
import e6.y0;
import hb.h0;
import la.v;
import pa.e;
import qa.a;
import ra.i;
import wa.p;

public final class f0 extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f14587i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f14588j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ i0 f14589k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f0(int i10, i0 i0Var, e eVar) {
        super(2, eVar);
        this.f14588j = i10;
        this.f14589k = i0Var;
    }

    public final e create(Object obj, e eVar) {
        return new f0(this.f14588j, this.f14589k, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((f0) create((hb.f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        boolean z10;
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f14587i;
        i0 i0Var = this.f14589k;
        boolean z11 = true;
        if (i10 == 0) {
            h0.O1(obj);
            int i11 = this.f14588j;
            y0 y0Var = i0Var.f14604e;
            this.f14587i = 1;
            obj = y0Var.a(i11, this);
            if (obj == aVar) {
                return aVar;
            }
        } else if (i10 == 1) {
            try {
                h0.O1(obj);
            } catch (Exception unused) {
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (((LocalFollowChannel) obj) != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        o0 o0Var = i0Var.f14609j;
        if (!z10) {
            z11 = false;
        }
        o0Var.j(new la.i(Boolean.valueOf(z11), (Object) null));
        return v.f9814a;
    }
}
