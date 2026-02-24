package e6;

import a6.s;
import android.content.Context;
import android.os.CancellationSignal;
import androidx.lifecycle.u1;
import com.github.andreyasadchy.xtra.model.offline.Request;
import com.github.andreyasadchy.xtra.ui.download.DownloadService;
import hb.d0;
import hb.d1;
import hb.f0;
import hb.h0;
import hb.l;
import la.v;
import pa.e;
import q0.f;
import qa.a;
import qa.d;
import r3.g;
import r3.n0;
import r3.s0;
import r3.x0;
import ra.i;
import u3.c;
import wa.p;

public final class j1 extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f5164i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ o1 f5165j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Context f5166k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public j1(o1 o1Var, Context context, e eVar) {
        super(2, eVar);
        this.f5165j = o1Var;
        this.f5166k = context;
    }

    public final e create(Object obj, e eVar) {
        return new j1(this.f5165j, this.f5166k, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((j1) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f5164i;
        if (i10 == 0) {
            h0.O1(obj);
            a6.p pVar = this.f5165j.f5208b;
            this.f5164i = 1;
            s sVar = (s) pVar;
            sVar.getClass();
            s0 k10 = s0.k(0, "SELECT * FROM requests");
            int i11 = c.f15348a;
            CancellationSignal cancellationSignal = new CancellationSignal();
            a6.e eVar = new a6.e(sVar, k10, 2);
            r3.i.f13681a.getClass();
            n0 n0Var = sVar.f258a;
            if (!n0Var.p() || !n0Var.l()) {
                f.l(getContext().N(x0.f13772h));
                d0 C0 = h0.C0(n0Var);
                l lVar = new l(1, d.b(this));
                lVar.w();
                lVar.j(new u1(cancellationSignal, 5, h0.b1(d1.f7786h, C0, 0, new g(eVar, lVar, (e) null), 2)));
                obj = lVar.u();
                if (obj == aVar) {
                    h0.m1(this);
                }
            } else {
                obj = eVar.call();
            }
            if (obj == aVar) {
                return aVar;
            }
        } else if (i10 == 1) {
            h0.O1(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        for (Request request : (Iterable) obj) {
            DownloadService.f3380w.getClass();
            if (DownloadService.f3381x.add(new Integer(request.getOfflineVideoId()))) {
                s7.d.f14369a.getClass();
                s7.d.a(this.f5166k, request);
            }
        }
        return v.f9814a;
    }
}
