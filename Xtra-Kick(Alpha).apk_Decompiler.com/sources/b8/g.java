package b8;

import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import g8.a;
import java.util.WeakHashMap;
import m0.c1;
import m0.o0;
import m0.q2;
import m0.v2;
import m8.f;
import t8.i;

public final class g extends b {

    /* renamed from: a  reason: collision with root package name */
    public final Boolean f2675a;

    /* renamed from: b  reason: collision with root package name */
    public final q2 f2676b;

    /* renamed from: c  reason: collision with root package name */
    public Window f2677c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f2678d;

    public g(FrameLayout frameLayout, q2 q2Var) {
        ColorStateList colorStateList;
        Boolean bool;
        int i10;
        this.f2676b = q2Var;
        i iVar = BottomSheetBehavior.w(frameLayout).f3673i;
        if (iVar != null) {
            colorStateList = iVar.f14744h.f14725c;
        } else {
            WeakHashMap weakHashMap = c1.f10054a;
            colorStateList = o0.g(frameLayout);
        }
        if (colorStateList != null) {
            i10 = colorStateList.getDefaultColor();
        } else if (frameLayout.getBackground() instanceof ColorDrawable) {
            i10 = ((ColorDrawable) frameLayout.getBackground()).getColor();
        } else {
            bool = null;
            this.f2675a = bool;
        }
        bool = Boolean.valueOf(a.c(i10));
        this.f2675a = bool;
    }

    public final void a(View view) {
        d(view);
    }

    public final void b(View view) {
        d(view);
    }

    public final void c(View view, int i10) {
        d(view);
    }

    public final void d(View view) {
        int top = view.getTop();
        q2 q2Var = this.f2676b;
        if (top < q2Var.e()) {
            Window window = this.f2677c;
            if (window != null) {
                Boolean bool = this.f2675a;
                f.a(window, bool == null ? this.f2678d : bool.booleanValue());
            }
            view.setPadding(view.getPaddingLeft(), q2Var.e() - view.getTop(), view.getPaddingRight(), view.getPaddingBottom());
        } else if (view.getTop() != 0) {
            Window window2 = this.f2677c;
            if (window2 != null) {
                f.a(window2, this.f2678d);
            }
            view.setPadding(view.getPaddingLeft(), 0, view.getPaddingRight(), view.getPaddingBottom());
        }
    }

    public final void e(Window window) {
        if (this.f2677c != window) {
            this.f2677c = window;
            if (window != null) {
                this.f2678d = ((v2) new e.a(window, window.getDecorView()).f4852i).b();
            }
        }
    }
}
