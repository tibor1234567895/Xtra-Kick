package t6;

import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import hb.h0;
import xa.j;

public final /* synthetic */ class e implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ l f14582h;

    public /* synthetic */ e(l lVar) {
        this.f14582h = lVar;
    }

    public final void onGlobalLayout() {
        f fVar = l.f14620w0;
        l lVar = this.f14582h;
        j.f("this$0", lVar);
        if (h0.W0(lVar.u0())) {
            if (!lVar.f14629p0) {
                lVar.f14629p0 = true;
                if (!lVar.f14628o0) {
                    ViewGroup viewGroup = lVar.f14627n0;
                    if (viewGroup != null) {
                        ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
                        if (layoutParams != null) {
                            layoutParams.width = (int) (((float) lVar.u0().getWidth()) / 1.8f);
                            viewGroup.setLayoutParams(layoutParams);
                            lVar.J0();
                            return;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
                    }
                    j.l("chatLayout");
                    throw null;
                }
            }
        } else if (lVar.f14629p0) {
            lVar.f14629p0 = false;
            ViewGroup viewGroup2 = lVar.f14627n0;
            if (viewGroup2 != null) {
                viewGroup2.clearFocus();
                if (!lVar.f14628o0) {
                    ViewGroup viewGroup3 = lVar.f14627n0;
                    if (viewGroup3 != null) {
                        ViewGroup.LayoutParams layoutParams2 = viewGroup3.getLayoutParams();
                        if (layoutParams2 != null) {
                            layoutParams2.width = lVar.f14634u0;
                            viewGroup3.setLayoutParams(layoutParams2);
                            if (lVar.u0().f3546v) {
                                lVar.x0();
                                return;
                            }
                            return;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
                    }
                    j.l("chatLayout");
                    throw null;
                }
                return;
            }
            j.l("chatLayout");
            throw null;
        }
    }
}
