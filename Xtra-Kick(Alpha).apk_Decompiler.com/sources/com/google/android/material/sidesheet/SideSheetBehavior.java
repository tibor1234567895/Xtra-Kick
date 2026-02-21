package com.google.android.material.sidesheet;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import b8.e;
import com.woxthebox.draglistview.R;
import java.lang.ref.WeakReference;
import java.util.LinkedHashSet;
import java.util.WeakHashMap;
import m0.c1;
import m0.i0;
import m0.l0;
import m0.o0;
import n0.g;
import q7.d;
import t8.i;
import t8.n;
import u0.h;
import u8.a;
import z.b;

public class SideSheetBehavior<V extends View> extends b {

    /* renamed from: a  reason: collision with root package name */
    public a f3835a;

    /* renamed from: b  reason: collision with root package name */
    public i f3836b;

    /* renamed from: c  reason: collision with root package name */
    public final ColorStateList f3837c;

    /* renamed from: d  reason: collision with root package name */
    public final n f3838d;

    /* renamed from: e  reason: collision with root package name */
    public final e f3839e = new e(this);

    /* renamed from: f  reason: collision with root package name */
    public final float f3840f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f3841g = true;

    /* renamed from: h  reason: collision with root package name */
    public int f3842h = 5;

    /* renamed from: i  reason: collision with root package name */
    public h f3843i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f3844j;

    /* renamed from: k  reason: collision with root package name */
    public final float f3845k = 0.1f;

    /* renamed from: l  reason: collision with root package name */
    public int f3846l;

    /* renamed from: m  reason: collision with root package name */
    public int f3847m;

    /* renamed from: n  reason: collision with root package name */
    public int f3848n;

    /* renamed from: o  reason: collision with root package name */
    public WeakReference f3849o;

    /* renamed from: p  reason: collision with root package name */
    public WeakReference f3850p;

    /* renamed from: q  reason: collision with root package name */
    public int f3851q = -1;

    /* renamed from: r  reason: collision with root package name */
    public VelocityTracker f3852r;

    /* renamed from: s  reason: collision with root package name */
    public int f3853s;

    /* renamed from: t  reason: collision with root package name */
    public final LinkedHashSet f3854t = new LinkedHashSet();

    /* renamed from: u  reason: collision with root package name */
    public final d f3855u = new d(1, this);

    public SideSheetBehavior() {
    }

    public final void c(z.e eVar) {
        this.f3849o = null;
        this.f3843i = null;
    }

    public final void f() {
        this.f3849o = null;
        this.f3843i = null;
    }

    public final boolean g(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        boolean z10;
        h hVar;
        VelocityTracker velocityTracker;
        if ((view.isShown() || c1.d(view) != null) && this.f3841g) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            this.f3844j = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0 && (velocityTracker = this.f3852r) != null) {
            velocityTracker.recycle();
            this.f3852r = null;
        }
        if (this.f3852r == null) {
            this.f3852r = VelocityTracker.obtain();
        }
        this.f3852r.addMovement(motionEvent);
        if (actionMasked == 0) {
            this.f3853s = (int) motionEvent.getX();
        } else if ((actionMasked == 1 || actionMasked == 3) && this.f3844j) {
            this.f3844j = false;
            return false;
        }
        if (this.f3844j || (hVar = this.f3843i) == null || !hVar.s(motionEvent)) {
            return false;
        }
        return true;
    }

    public final boolean h(CoordinatorLayout coordinatorLayout, View view, int i10) {
        int i11;
        int i12;
        View findViewById;
        int i13;
        WeakHashMap weakHashMap = c1.f10054a;
        if (i0.b(coordinatorLayout) && !i0.b(view)) {
            view.setFitsSystemWindows(true);
        }
        int i14 = 0;
        if (this.f3849o == null) {
            this.f3849o = new WeakReference(view);
            i iVar = this.f3836b;
            if (iVar != null) {
                i0.q(view, iVar);
                i iVar2 = this.f3836b;
                float f10 = this.f3840f;
                if (f10 == -1.0f) {
                    f10 = o0.i(view);
                }
                iVar2.j(f10);
            } else {
                ColorStateList colorStateList = this.f3837c;
                if (colorStateList != null) {
                    c1.r(view, colorStateList);
                }
            }
            if (this.f3842h == 5) {
                i13 = 4;
            } else {
                i13 = 0;
            }
            if (view.getVisibility() != i13) {
                view.setVisibility(i13);
            }
            u();
            if (i0.c(view) == 0) {
                i0.s(view, 1);
            }
            if (c1.d(view) == null) {
                c1.q(view, view.getResources().getString(R.string.side_sheet_accessibility_pane_title));
            }
        }
        if (this.f3843i == null) {
            this.f3843i = new h(coordinatorLayout.getContext(), coordinatorLayout, this.f3855u);
        }
        a aVar = this.f3835a;
        aVar.getClass();
        int left = view.getLeft() - aVar.f15438a.f3848n;
        coordinatorLayout.r(view, i10);
        this.f3847m = coordinatorLayout.getWidth();
        this.f3846l = view.getWidth();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        if (marginLayoutParams != null) {
            this.f3835a.getClass();
            i11 = marginLayoutParams.rightMargin;
        } else {
            i11 = 0;
        }
        this.f3848n = i11;
        int i15 = this.f3842h;
        if (i15 == 1 || i15 == 2) {
            a aVar2 = this.f3835a;
            aVar2.getClass();
            i14 = left - (view.getLeft() - aVar2.f15438a.f3848n);
        } else if (i15 != 3) {
            if (i15 == 5) {
                i14 = this.f3835a.f15438a.f3847m;
            } else {
                throw new IllegalStateException("Unexpected value: " + this.f3842h);
            }
        }
        c1.j(view, i14);
        if (!(this.f3850p != null || (i12 = this.f3851q) == -1 || (findViewById = coordinatorLayout.findViewById(i12)) == null)) {
            this.f3850p = new WeakReference(findViewById);
        }
        for (u8.e eVar : this.f3854t) {
            if (eVar instanceof u8.e) {
                eVar.getClass();
            }
        }
        return true;
    }

    public final boolean i(CoordinatorLayout coordinatorLayout, View view, int i10, int i11, int i12) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(ViewGroup.getChildMeasureSpec(i10, coordinatorLayout.getPaddingRight() + coordinatorLayout.getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i11, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i12, coordinatorLayout.getPaddingBottom() + coordinatorLayout.getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + 0, marginLayoutParams.height));
        return true;
    }

    public final void n(View view, Parcelable parcelable) {
        int i10 = ((u8.d) parcelable).f15439j;
        if (i10 == 1 || i10 == 2) {
            i10 = 5;
        }
        this.f3842h = i10;
    }

    public final Parcelable o(View view) {
        return new u8.d(View.BaseSavedState.EMPTY_STATE, this);
    }

    public final boolean r(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        boolean z10;
        boolean z11;
        boolean z12;
        VelocityTracker velocityTracker;
        boolean z13 = false;
        if (!view.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        int i10 = this.f3842h;
        if (i10 == 1 && actionMasked == 0) {
            return true;
        }
        h hVar = this.f3843i;
        if (hVar == null || (!this.f3841g && i10 != 1)) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (z10) {
            hVar.l(motionEvent);
        }
        if (actionMasked == 0 && (velocityTracker = this.f3852r) != null) {
            velocityTracker.recycle();
            this.f3852r = null;
        }
        if (this.f3852r == null) {
            this.f3852r = VelocityTracker.obtain();
        }
        this.f3852r.addMovement(motionEvent);
        h hVar2 = this.f3843i;
        if (hVar2 == null || (!this.f3841g && this.f3842h != 1)) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (z11 && actionMasked == 2 && !this.f3844j) {
            if (hVar2 == null || (!this.f3841g && this.f3842h != 1)) {
                z12 = false;
            } else {
                z12 = true;
            }
            if (z12 && Math.abs(((float) this.f3853s) - motionEvent.getX()) > ((float) this.f3843i.f15176b)) {
                z13 = true;
            }
            if (z13) {
                this.f3843i.b(view, motionEvent.getPointerId(motionEvent.getActionIndex()));
            }
        }
        return !this.f3844j;
    }

    public final void s(int i10) {
        View view;
        int i11;
        if (this.f3842h != i10) {
            this.f3842h = i10;
            WeakReference weakReference = this.f3849o;
            if (weakReference != null && (view = (View) weakReference.get()) != null) {
                if (this.f3842h == 5) {
                    i11 = 4;
                } else {
                    i11 = 0;
                }
                if (view.getVisibility() != i11) {
                    view.setVisibility(i11);
                }
                for (u8.e b10 : this.f3854t) {
                    b10.b();
                }
                u();
            }
        }
    }

    public final void t(View view, int i10, boolean z10) {
        int i11;
        boolean z11;
        SideSheetBehavior sideSheetBehavior = this.f3835a.f15438a;
        if (i10 == 3) {
            i11 = sideSheetBehavior.f3835a.a();
        } else if (i10 == 5) {
            i11 = sideSheetBehavior.f3835a.f15438a.f3847m;
        } else {
            sideSheetBehavior.getClass();
            throw new IllegalArgumentException(android.support.v4.media.h.i("Invalid state to get outer edge offset: ", i10));
        }
        h hVar = sideSheetBehavior.f3843i;
        if (hVar == null || (!z10 ? !hVar.t(view, i11, view.getTop()) : !hVar.r(i11, view.getTop()))) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (z11) {
            s(2);
            this.f3839e.a(i10);
            return;
        }
        s(i10);
    }

    public final void u() {
        View view;
        WeakReference weakReference = this.f3849o;
        if (weakReference != null && (view = (View) weakReference.get()) != null) {
            c1.m(view, 262144);
            c1.i(view, 0);
            c1.m(view, 1048576);
            c1.i(view, 0);
            if (this.f3842h != 5) {
                c1.n(view, g.f10908j, new e7.b((Object) this, 5));
            }
            if (this.f3842h != 3) {
                c1.n(view, g.f10906h, new e7.b((Object) this, 3));
            }
        }
    }

    public SideSheetBehavior(Context context, AttributeSet attributeSet) {
        super(0);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, v7.a.E);
        if (obtainStyledAttributes.hasValue(3)) {
            this.f3837c = q8.d.a(context, obtainStyledAttributes, 3);
        }
        if (obtainStyledAttributes.hasValue(6)) {
            this.f3838d = new n(n.b(context, attributeSet, 0, 2132018239));
        }
        if (obtainStyledAttributes.hasValue(5)) {
            int resourceId = obtainStyledAttributes.getResourceId(5, -1);
            this.f3851q = resourceId;
            WeakReference weakReference = this.f3850p;
            if (weakReference != null) {
                weakReference.clear();
            }
            this.f3850p = null;
            WeakReference weakReference2 = this.f3849o;
            if (weakReference2 != null) {
                View view = (View) weakReference2.get();
                if (resourceId != -1) {
                    WeakHashMap weakHashMap = c1.f10054a;
                    if (l0.c(view)) {
                        view.requestLayout();
                    }
                }
            }
        }
        n nVar = this.f3838d;
        if (nVar != null) {
            i iVar = new i(nVar);
            this.f3836b = iVar;
            iVar.i(context);
            ColorStateList colorStateList = this.f3837c;
            if (colorStateList != null) {
                this.f3836b.k(colorStateList);
            } else {
                TypedValue typedValue = new TypedValue();
                context.getTheme().resolveAttribute(16842801, typedValue, true);
                this.f3836b.setTint(typedValue.data);
            }
        }
        this.f3840f = obtainStyledAttributes.getDimension(2, -1.0f);
        this.f3841g = obtainStyledAttributes.getBoolean(4, true);
        obtainStyledAttributes.recycle();
        if (this.f3835a == null) {
            this.f3835a = new a(this);
        }
        ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }
}
