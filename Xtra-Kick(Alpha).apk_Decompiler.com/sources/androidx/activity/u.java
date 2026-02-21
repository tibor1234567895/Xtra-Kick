package androidx.activity;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import i3.c0;
import i3.w;
import i3.x;
import jb.q;
import jb.r;
import xa.j;

public final /* synthetic */ class u implements View.OnLayoutChangeListener {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f527h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Object f528i;

    public /* synthetic */ u(int i10, Object obj) {
        this.f527h = i10;
        this.f528i = obj;
    }

    public final void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        int i18;
        int i19;
        int i20;
        int i21;
        boolean z10;
        View view2 = view;
        int i22 = i10;
        int i23 = i11;
        int i24 = i12;
        int i25 = i13;
        int i26 = i14;
        int i27 = i15;
        int i28 = i16;
        int i29 = i17;
        int i30 = this.f527h;
        Object obj = this.f528i;
        switch (i30) {
            case 0:
                r rVar = (r) obj;
                if (i22 != i26 || i24 != i28 || i23 != i27 || i25 != i29) {
                    j.e("v", view2);
                    Rect rect = new Rect();
                    view2.getGlobalVisibleRect(rect);
                    ((q) rVar).h(rect);
                    return;
                }
                return;
            case 1:
                w wVar = (w) obj;
                float[] fArr = w.E0;
                wVar.getClass();
                int i31 = i25 - i23;
                int i32 = i29 - i27;
                if (i24 - i22 != i28 - i26 || i31 != i32) {
                    PopupWindow popupWindow = wVar.f8206r;
                    if (popupWindow.isShowing()) {
                        wVar.r();
                        int width = wVar.getWidth() - popupWindow.getWidth();
                        int i33 = wVar.f8208s;
                        popupWindow.update(view, width - i33, (-popupWindow.getHeight()) - i33, -1, -1);
                        return;
                    }
                    return;
                }
                return;
            default:
                c0 c0Var = (c0) obj;
                w wVar2 = c0Var.f8038a;
                int width2 = (wVar2.getWidth() - wVar2.getPaddingLeft()) - wVar2.getPaddingRight();
                int height = (wVar2.getHeight() - wVar2.getPaddingBottom()) - wVar2.getPaddingTop();
                ViewGroup viewGroup = c0Var.f8040c;
                int d10 = c0.d(viewGroup);
                boolean z11 = false;
                if (viewGroup != null) {
                    i18 = viewGroup.getPaddingRight() + viewGroup.getPaddingLeft();
                } else {
                    i18 = 0;
                }
                int i34 = d10 - i18;
                if (viewGroup == null) {
                    i19 = 0;
                } else {
                    i19 = viewGroup.getHeight();
                    ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                        i19 += marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
                    }
                }
                if (viewGroup != null) {
                    i20 = viewGroup.getPaddingBottom() + viewGroup.getPaddingTop();
                } else {
                    i20 = 0;
                }
                int i35 = i19 - i20;
                int max = Math.max(i34, c0.d(c0Var.f8048k) + c0.d(c0Var.f8046i));
                ViewGroup viewGroup2 = c0Var.f8041d;
                if (viewGroup2 == null) {
                    i21 = 0;
                } else {
                    i21 = viewGroup2.getHeight();
                    ViewGroup.LayoutParams layoutParams2 = viewGroup2.getLayoutParams();
                    if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
                        i21 += marginLayoutParams2.topMargin + marginLayoutParams2.bottomMargin;
                    }
                }
                int i36 = (i21 * 2) + i35;
                if (width2 <= max || height <= i36) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (c0Var.A != z10) {
                    c0Var.A = z10;
                    view2.post(new x(c0Var, 5));
                }
                if (i24 - i22 != i28 - i26) {
                    z11 = true;
                }
                if (!c0Var.A && z11) {
                    view2.post(new x(c0Var, 6));
                    return;
                }
                return;
        }
    }
}
