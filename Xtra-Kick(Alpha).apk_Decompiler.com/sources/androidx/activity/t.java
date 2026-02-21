package androidx.activity;

import android.app.Activity;
import android.graphics.Rect;
import hb.h0;
import jb.g;
import kb.j;
import la.v;
import n3.k5;
import n3.s1;
import n3.z3;
import pa.e;
import qa.a;

public final class t implements j {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f525h;

    /* renamed from: i  reason: collision with root package name */
    public final Object f526i;

    public /* synthetic */ t(int i10, Object obj) {
        this.f525h = i10;
        this.f526i = obj;
    }

    public final Object a(Object obj, e eVar) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f525h;
        Object obj2 = this.f526i;
        switch (i10) {
            case 0:
                Rect rect = (Rect) obj;
                Activity activity = (Activity) obj2;
                c.f476a.getClass();
                xa.j.f("activity", activity);
                xa.j.f("hint", rect);
                b.t();
                activity.setPictureInPictureParams(b.i().setSourceRectHint(rect).build());
                return v.f9814a;
            case 1:
                Object g10 = ((jb.t) obj2).g(obj, eVar);
                if (g10 == aVar) {
                    return g10;
                }
                return v.f9814a;
            case 2:
                Object h10 = ((g) obj2).h((v) obj);
                if (h10 == aVar) {
                    return h10;
                }
                return v.f9814a;
            default:
                n3.g gVar = (n3.g) obj2;
                Object c22 = h0.c2(gVar.f11165b, new z3((s1) obj, gVar, (e) null), eVar);
                if (c22 == aVar) {
                    return c22;
                }
                return v.f9814a;
        }
    }

    public t(k5 k5Var) {
        this.f525h = 1;
        xa.j.f("channel", k5Var);
        this.f526i = k5Var;
    }
}
