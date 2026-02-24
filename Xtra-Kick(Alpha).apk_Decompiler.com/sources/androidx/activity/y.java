package androidx.activity;

import android.graphics.Rect;
import android.view.View;
import hb.h0;
import jb.q;
import jb.r;
import la.v;
import pa.e;
import qa.a;
import ra.i;
import wa.p;
import xa.j;

public final class y extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f540i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f541j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ View f542k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public y(View view, e eVar) {
        super(2, eVar);
        this.f542k = view;
    }

    public final e create(Object obj, e eVar) {
        y yVar = new y(this.f542k, eVar);
        yVar.f541j = obj;
        return yVar;
    }

    public final Object g(Object obj, Object obj2) {
        return ((y) create((r) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f540i;
        if (i10 == 0) {
            h0.O1(obj);
            r rVar = (r) this.f541j;
            u uVar = new u(0, rVar);
            View view = this.f542k;
            v vVar = new v(rVar, view);
            x xVar = new x(rVar, view, vVar, uVar);
            a.f475a.getClass();
            j.f("view", view);
            if (view.isAttachedToWindow()) {
                Rect rect = new Rect();
                view.getGlobalVisibleRect(rect);
                ((q) rVar).h(rect);
                view.getViewTreeObserver().addOnScrollChangedListener(vVar);
                view.addOnLayoutChangeListener(uVar);
            }
            view.addOnAttachStateChangeListener(xVar);
            w wVar = new w(this.f542k, vVar, uVar, xVar, 0);
            this.f540i = 1;
            if (h0.k(rVar, wVar, this) == aVar) {
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
