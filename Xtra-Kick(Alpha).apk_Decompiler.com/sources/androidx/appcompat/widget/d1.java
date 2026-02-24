package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import android.widget.ListAdapter;
import android.widget.SpinnerAdapter;
import com.woxthebox.draglistview.R;
import g.g;
import m.e;

public final class d1 extends b3 implements g1 {
    public CharSequence K;
    public ListAdapter L;
    public final Rect M = new Rect();
    public int N;
    public final /* synthetic */ h1 O;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d1(h1 h1Var, Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.spinnerStyle, 0);
        this.O = h1Var;
        this.f765v = h1Var;
        this.F = true;
        this.G.setFocusable(true);
        this.f766w = new g(this, 1, h1Var);
    }

    public final void h(CharSequence charSequence) {
        this.K = charSequence;
    }

    public final void k(int i10) {
        this.N = i10;
    }

    public final void m(int i10, int i11) {
        ViewTreeObserver viewTreeObserver;
        boolean b10 = b();
        r();
        q0 q0Var = this.G;
        q0Var.setInputMethodMode(2);
        d();
        o2 o2Var = this.f753j;
        o2Var.setChoiceMode(1);
        y0.d(o2Var, i10);
        y0.c(o2Var, i11);
        h1 h1Var = this.O;
        int selectedItemPosition = h1Var.getSelectedItemPosition();
        o2 o2Var2 = this.f753j;
        if (b() && o2Var2 != null) {
            o2Var2.setListSelectionHidden(false);
            o2Var2.setSelection(selectedItemPosition);
            if (o2Var2.getChoiceMode() != 0) {
                o2Var2.setItemChecked(selectedItemPosition, true);
            }
        }
        if (!b10 && (viewTreeObserver = h1Var.getViewTreeObserver()) != null) {
            e eVar = new e(4, this);
            viewTreeObserver.addOnGlobalLayoutListener(eVar);
            q0Var.setOnDismissListener(new c1(this, eVar));
        }
    }

    public final CharSequence o() {
        return this.K;
    }

    public final void p(ListAdapter listAdapter) {
        super.p(listAdapter);
        this.L = listAdapter;
    }

    public final void r() {
        int i10;
        int i11;
        Drawable e10 = e();
        h1 h1Var = this.O;
        if (e10 != null) {
            e10.getPadding(h1Var.f854o);
            if (l5.a(h1Var)) {
                i10 = h1Var.f854o.right;
            } else {
                i10 = -h1Var.f854o.left;
            }
        } else {
            Rect rect = h1Var.f854o;
            rect.right = 0;
            rect.left = 0;
            i10 = 0;
        }
        int paddingLeft = h1Var.getPaddingLeft();
        int paddingRight = h1Var.getPaddingRight();
        int width = h1Var.getWidth();
        int i12 = h1Var.f853n;
        if (i12 == -2) {
            int a10 = h1Var.a((SpinnerAdapter) this.L, e());
            int i13 = h1Var.getContext().getResources().getDisplayMetrics().widthPixels;
            Rect rect2 = h1Var.f854o;
            int i14 = (i13 - rect2.left) - rect2.right;
            if (a10 > i14) {
                a10 = i14;
            }
            i12 = Math.max(a10, (width - paddingLeft) - paddingRight);
        } else if (i12 == -1) {
            i12 = (width - paddingLeft) - paddingRight;
        }
        q(i12);
        if (l5.a(h1Var)) {
            i11 = (((width - paddingRight) - this.f755l) - this.N) + i10;
        } else {
            i11 = paddingLeft + this.N + i10;
        }
        this.f756m = i11;
    }
}
