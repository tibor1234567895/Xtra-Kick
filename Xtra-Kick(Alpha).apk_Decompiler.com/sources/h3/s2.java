package h3;

import a2.j;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import e0.d;
import h9.v;
import j1.l0;
import m0.q2;
import m8.w;

public final class s2 implements v, m8.v {

    /* renamed from: h  reason: collision with root package name */
    public boolean f7314h;

    /* renamed from: i  reason: collision with root package name */
    public final Object f7315i;

    public /* synthetic */ s2(Object obj, boolean z10) {
        this.f7315i = obj;
        this.f7314h = z10;
    }

    public final q2 a(View view, q2 q2Var, j jVar) {
        boolean z10;
        int i10;
        int i11;
        int i12;
        d a10 = q2Var.a(7);
        d a11 = q2Var.a(32);
        BottomSheetBehavior bottomSheetBehavior = (BottomSheetBehavior) this.f7315i;
        bottomSheetBehavior.f3687w = a10.f4857b;
        boolean c10 = w.c(view);
        int paddingBottom = view.getPaddingBottom();
        int paddingLeft = view.getPaddingLeft();
        int paddingRight = view.getPaddingRight();
        if (bottomSheetBehavior.f3679o) {
            int b10 = q2Var.b();
            bottomSheetBehavior.f3686v = b10;
            paddingBottom = b10 + jVar.f58d;
        }
        boolean z11 = bottomSheetBehavior.f3680p;
        int i13 = a10.f4856a;
        if (z11) {
            if (c10) {
                i12 = jVar.f57c;
            } else {
                i12 = jVar.f55a;
            }
            paddingLeft = i12 + i13;
        }
        boolean z12 = bottomSheetBehavior.f3681q;
        int i14 = a10.f4858c;
        if (z12) {
            if (c10) {
                i11 = jVar.f55a;
            } else {
                i11 = jVar.f57c;
            }
            paddingRight = i11 + i14;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        boolean z13 = true;
        if (!bottomSheetBehavior.f3683s || marginLayoutParams.leftMargin == i13) {
            z10 = false;
        } else {
            marginLayoutParams.leftMargin = i13;
            z10 = true;
        }
        if (bottomSheetBehavior.f3684t && marginLayoutParams.rightMargin != i14) {
            marginLayoutParams.rightMargin = i14;
            z10 = true;
        }
        if (!bottomSheetBehavior.f3685u || marginLayoutParams.topMargin == (i10 = a10.f4857b)) {
            z13 = z10;
        } else {
            marginLayoutParams.topMargin = i10;
        }
        if (z13) {
            view.setLayoutParams(marginLayoutParams);
        }
        view.setPadding(paddingLeft, view.getPaddingTop(), paddingRight, paddingBottom);
        boolean z14 = this.f7314h;
        if (z14) {
            bottomSheetBehavior.f3677m = a11.f4859d;
        }
        if (bottomSheetBehavior.f3679o || z14) {
            bottomSheetBehavior.L();
        }
        return q2Var;
    }

    public final void c(Throwable th) {
    }

    public final void d(Object obj) {
        l0.L(((x2) this.f7315i).f7437g.f7239l, new r2(this, (f2) obj, this.f7314h));
    }

    public s2(String str, boolean z10) {
        this.f7314h = z10;
        this.f7315i = str;
    }
}
