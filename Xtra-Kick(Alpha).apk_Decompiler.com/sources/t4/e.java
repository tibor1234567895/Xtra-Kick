package t4;

import android.view.View;
import android.view.ViewTreeObserver;
import hb.h0;
import hb.l;
import i4.q;
import j3.m2;
import q0.f;
import qa.a;
import qa.d;
import xa.j;

public final class e implements h {

    /* renamed from: a  reason: collision with root package name */
    public final View f14545a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f14546b;

    public e(View view, boolean z10) {
        this.f14545a = view;
        this.f14546b = z10;
    }

    public final Object a(q qVar) {
        Object a10 = f.a(this);
        if (a10 == null) {
            l lVar = new l(1, d.b(qVar));
            lVar.w();
            ViewTreeObserver viewTreeObserver = this.f14545a.getViewTreeObserver();
            i iVar = new i(this, viewTreeObserver, lVar);
            viewTreeObserver.addOnPreDrawListener(iVar);
            lVar.j(new m2(this, viewTreeObserver, iVar, 2));
            a10 = lVar.u();
            if (a10 == a.COROUTINE_SUSPENDED) {
                h0.m1(qVar);
            }
        }
        return a10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof e) {
            e eVar = (e) obj;
            if (!j.a(this.f14545a, eVar.f14545a) || this.f14546b != eVar.f14546b) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (this.f14545a.hashCode() * 31) + (this.f14546b ? 1231 : 1237);
    }
}
