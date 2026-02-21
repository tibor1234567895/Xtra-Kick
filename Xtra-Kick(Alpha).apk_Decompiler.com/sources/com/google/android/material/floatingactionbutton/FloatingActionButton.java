package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import androidx.appcompat.widget.h0;
import androidx.appcompat.widget.n0;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import b4.e0;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.woxthebox.draglistview.R;
import f0.d;
import java.util.ArrayList;
import java.util.WeakHashMap;
import k8.a;
import k8.b;
import l8.l;
import l8.n;
import m0.c1;
import m0.l0;
import m8.x;
import q.k;
import t8.i;
import t8.j;
import t8.y;
import w7.f;
import z.e;

public class FloatingActionButton extends x implements a, y, z.a {

    /* renamed from: i  reason: collision with root package name */
    public ColorStateList f3811i;

    /* renamed from: j  reason: collision with root package name */
    public PorterDuff.Mode f3812j;

    /* renamed from: k  reason: collision with root package name */
    public ColorStateList f3813k;

    /* renamed from: l  reason: collision with root package name */
    public PorterDuff.Mode f3814l;

    /* renamed from: m  reason: collision with root package name */
    public ColorStateList f3815m;

    /* renamed from: n  reason: collision with root package name */
    public int f3816n;

    /* renamed from: o  reason: collision with root package name */
    public int f3817o;

    /* renamed from: p  reason: collision with root package name */
    public int f3818p;

    /* renamed from: q  reason: collision with root package name */
    public int f3819q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f3820r;

    /* renamed from: s  reason: collision with root package name */
    public final Rect f3821s = new Rect();

    /* renamed from: t  reason: collision with root package name */
    public final Rect f3822t = new Rect();

    /* renamed from: u  reason: collision with root package name */
    public final n0 f3823u;

    /* renamed from: v  reason: collision with root package name */
    public final b f3824v;

    /* renamed from: w  reason: collision with root package name */
    public n f3825w;

    public static class BaseBehavior<T extends FloatingActionButton> extends z.b {

        /* renamed from: a  reason: collision with root package name */
        public Rect f3826a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f3827b;

        public BaseBehavior() {
            this.f3827b = true;
        }

        public final boolean a(View view, Rect rect) {
            FloatingActionButton floatingActionButton = (FloatingActionButton) view;
            int left = floatingActionButton.getLeft();
            Rect rect2 = floatingActionButton.f3821s;
            rect.set(left + rect2.left, floatingActionButton.getTop() + rect2.top, floatingActionButton.getRight() - rect2.right, floatingActionButton.getBottom() - rect2.bottom);
            return true;
        }

        public final void c(e eVar) {
            if (eVar.f17329h == 0) {
                eVar.f17329h = 80;
            }
        }

        public final boolean d(CoordinatorLayout coordinatorLayout, View view, View view2) {
            boolean z10;
            FloatingActionButton floatingActionButton = (FloatingActionButton) view;
            if (view2 instanceof AppBarLayout) {
                t(coordinatorLayout, (AppBarLayout) view2, floatingActionButton);
            } else {
                ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                if (layoutParams instanceof e) {
                    z10 = ((e) layoutParams).f17322a instanceof BottomSheetBehavior;
                } else {
                    z10 = false;
                }
                if (z10) {
                    u(view2, floatingActionButton);
                }
            }
            return false;
        }

        public final boolean h(CoordinatorLayout coordinatorLayout, View view, int i10) {
            int i11;
            boolean z10;
            FloatingActionButton floatingActionButton = (FloatingActionButton) view;
            ArrayList k10 = coordinatorLayout.k(floatingActionButton);
            int size = k10.size();
            int i12 = 0;
            for (int i13 = 0; i13 < size; i13++) {
                View view2 = (View) k10.get(i13);
                if (!(view2 instanceof AppBarLayout)) {
                    ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                    if (layoutParams instanceof e) {
                        z10 = ((e) layoutParams).f17322a instanceof BottomSheetBehavior;
                    } else {
                        z10 = false;
                    }
                    if (z10 && u(view2, floatingActionButton)) {
                        break;
                    }
                } else if (t(coordinatorLayout, (AppBarLayout) view2, floatingActionButton)) {
                    break;
                }
            }
            coordinatorLayout.r(floatingActionButton, i10);
            Rect rect = floatingActionButton.f3821s;
            if (rect == null || rect.centerX() <= 0 || rect.centerY() <= 0) {
                return true;
            }
            e eVar = (e) floatingActionButton.getLayoutParams();
            if (floatingActionButton.getRight() >= coordinatorLayout.getWidth() - eVar.rightMargin) {
                i11 = rect.right;
            } else if (floatingActionButton.getLeft() <= eVar.leftMargin) {
                i11 = -rect.left;
            } else {
                i11 = 0;
            }
            if (floatingActionButton.getBottom() >= coordinatorLayout.getHeight() - eVar.bottomMargin) {
                i12 = rect.bottom;
            } else if (floatingActionButton.getTop() <= eVar.topMargin) {
                i12 = -rect.top;
            }
            if (i12 != 0) {
                c1.k(floatingActionButton, i12);
            }
            if (i11 == 0) {
                return true;
            }
            c1.j(floatingActionButton, i11);
            return true;
        }

        public final boolean s(View view, FloatingActionButton floatingActionButton) {
            e eVar = (e) floatingActionButton.getLayoutParams();
            if (this.f3827b && eVar.f17327f == view.getId() && floatingActionButton.getUserSetVisibility() == 0) {
                return true;
            }
            return false;
        }

        public final boolean t(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, FloatingActionButton floatingActionButton) {
            if (!s(appBarLayout, floatingActionButton)) {
                return false;
            }
            if (this.f3826a == null) {
                this.f3826a = new Rect();
            }
            Rect rect = this.f3826a;
            m8.e.a(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                floatingActionButton.d();
                return true;
            }
            floatingActionButton.f();
            return true;
        }

        public final boolean u(View view, FloatingActionButton floatingActionButton) {
            if (!s(view, floatingActionButton)) {
                return false;
            }
            if (view.getTop() < (floatingActionButton.getHeight() / 2) + ((e) floatingActionButton.getLayoutParams()).topMargin) {
                floatingActionButton.d();
                return true;
            }
            floatingActionButton.f();
            return true;
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(0);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, v7.a.f15944m);
            this.f3827b = obtainStyledAttributes.getBoolean(0, true);
            obtainStyledAttributes.recycle();
        }
    }

    public static class Behavior extends BaseBehavior<FloatingActionButton> {
        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public FloatingActionButton(android.content.Context r18, android.util.AttributeSet r19) {
        /*
            r17 = this;
            r0 = r17
            r7 = r19
            r8 = 2130969104(0x7f040210, float:1.754688E38)
            r9 = 2132018099(0x7f1403b3, float:1.9674495E38)
            r1 = r18
            android.content.Context r1 = a9.a.a(r1, r7, r8, r9)
            r0.<init>(r1, r7)
            android.graphics.Rect r1 = new android.graphics.Rect
            r1.<init>()
            r0.f3821s = r1
            android.graphics.Rect r1 = new android.graphics.Rect
            r1.<init>()
            r0.f3822t = r1
            android.content.Context r10 = r17.getContext()
            int[] r3 = v7.a.f15943l
            r5 = 2132018099(0x7f1403b3, float:1.9674495E38)
            r11 = 0
            int[] r6 = new int[r11]
            r4 = 2130969104(0x7f040210, float:1.754688E38)
            r1 = r10
            r2 = r19
            android.content.res.TypedArray r1 = m8.r.d(r1, r2, r3, r4, r5, r6)
            r2 = 1
            android.content.res.ColorStateList r3 = q8.d.a(r10, r1, r2)
            r0.f3811i = r3
            r3 = 2
            r4 = -1
            int r3 = r1.getInt(r3, r4)
            r5 = 0
            android.graphics.PorterDuff$Mode r3 = m8.w.d(r3, r5)
            r0.f3812j = r3
            r3 = 12
            android.content.res.ColorStateList r3 = q8.d.a(r10, r1, r3)
            r0.f3815m = r3
            r3 = 7
            int r3 = r1.getInt(r3, r4)
            r0.f3816n = r3
            r3 = 6
            int r3 = r1.getDimensionPixelSize(r3, r11)
            r0.f3817o = r3
            r3 = 3
            int r3 = r1.getDimensionPixelSize(r3, r11)
            r4 = 4
            r5 = 0
            float r4 = r1.getDimension(r4, r5)
            r6 = 9
            float r6 = r1.getDimension(r6, r5)
            r12 = 11
            float r5 = r1.getDimension(r12, r5)
            r12 = 16
            boolean r12 = r1.getBoolean(r12, r11)
            r0.f3820r = r12
            android.content.res.Resources r12 = r17.getResources()
            r13 = 2131165889(0x7f0702c1, float:1.7946008E38)
            int r12 = r12.getDimensionPixelSize(r13)
            r13 = 10
            int r13 = r1.getDimensionPixelSize(r13, r11)
            r0.setMaxImageSize(r13)
            r13 = 15
            w7.f r13 = w7.f.a(r10, r1, r13)
            r14 = 8
            w7.f r14 = w7.f.a(r10, r1, r14)
            t8.k r15 = t8.n.f14777m
            int[] r2 = v7.a.f15953v
            android.content.res.TypedArray r2 = r10.obtainStyledAttributes(r7, r2, r8, r9)
            int r9 = r2.getResourceId(r11, r11)
            r16 = r14
            r8 = 1
            int r14 = r2.getResourceId(r8, r11)
            r2.recycle()
            t8.m r2 = t8.n.a(r10, r9, r14, r15)
            t8.n r8 = new t8.n
            r8.<init>(r2)
            r2 = 5
            boolean r2 = r1.getBoolean(r2, r11)
            r9 = 1
            boolean r9 = r1.getBoolean(r11, r9)
            r0.setEnabled(r9)
            r1.recycle()
            androidx.appcompat.widget.n0 r1 = new androidx.appcompat.widget.n0
            r1.<init>(r0)
            r0.f3823u = r1
            r9 = 2130969104(0x7f040210, float:1.754688E38)
            r1.d(r7, r9)
            k8.b r1 = new k8.b
            r1.<init>(r0)
            r0.f3824v = r1
            l8.l r1 = r17.getImpl()
            r1.n(r8)
            l8.l r1 = r17.getImpl()
            android.content.res.ColorStateList r7 = r0.f3811i
            android.graphics.PorterDuff$Mode r8 = r0.f3812j
            android.content.res.ColorStateList r9 = r0.f3815m
            r1.g(r7, r8, r9, r3)
            l8.l r1 = r17.getImpl()
            r1.f9740k = r12
            l8.l r1 = r17.getImpl()
            float r3 = r1.f9737h
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 == 0) goto L_0x0110
            r1.f9737h = r4
            float r3 = r1.f9738i
            float r7 = r1.f9739j
            r1.k(r4, r3, r7)
        L_0x0110:
            l8.l r1 = r17.getImpl()
            float r3 = r1.f9738i
            int r3 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r3 == 0) goto L_0x0123
            r1.f9738i = r6
            float r3 = r1.f9737h
            float r4 = r1.f9739j
            r1.k(r3, r6, r4)
        L_0x0123:
            l8.l r1 = r17.getImpl()
            float r3 = r1.f9739j
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 == 0) goto L_0x0136
            r1.f9739j = r5
            float r3 = r1.f9737h
            float r4 = r1.f9738i
            r1.k(r3, r4, r5)
        L_0x0136:
            l8.l r1 = r17.getImpl()
            r1.f9742m = r13
            l8.l r1 = r17.getImpl()
            r3 = r16
            r1.f9743n = r3
            l8.l r1 = r17.getImpl()
            r1.f9735f = r2
            android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.MATRIX
            r0.setScaleType(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.floatingactionbutton.FloatingActionButton.<init>(android.content.Context, android.util.AttributeSet):void");
    }

    private l getImpl() {
        if (this.f3825w == null) {
            this.f3825w = new n(this, new e0(24, this));
        }
        return this.f3825w;
    }

    public final int c(int i10) {
        int i11 = this.f3817o;
        if (i11 != 0) {
            return i11;
        }
        Resources resources = getResources();
        if (i10 == -1) {
            return Math.max(resources.getConfiguration().screenWidthDp, resources.getConfiguration().screenHeightDp) < 470 ? c(1) : c(0);
        }
        return resources.getDimensionPixelSize(i10 != 1 ? R.dimen.design_fab_size_normal : R.dimen.design_fab_size_mini);
    }

    public final void d() {
        boolean z10;
        AnimatorSet animatorSet;
        l impl = getImpl();
        FloatingActionButton floatingActionButton = impl.f9748s;
        boolean z11 = true;
        if (floatingActionButton.getVisibility() != 0 ? impl.f9747r == 2 : impl.f9747r != 1) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (!z10) {
            Animator animator = impl.f9741l;
            if (animator != null) {
                animator.cancel();
            }
            WeakHashMap weakHashMap = c1.f10054a;
            FloatingActionButton floatingActionButton2 = impl.f9748s;
            if (!l0.c(floatingActionButton2) || floatingActionButton2.isInEditMode()) {
                z11 = false;
            }
            if (z11) {
                f fVar = impl.f9743n;
                if (fVar != null) {
                    animatorSet = impl.b(fVar, 0.0f, 0.0f, 0.0f);
                } else {
                    animatorSet = impl.c(0.0f, 0.4f, 0.4f, l.C, l.D);
                }
                animatorSet.addListener(new l8.e(impl, (k5.a) null));
                impl.getClass();
                animatorSet.start();
                return;
            }
            floatingActionButton.a(4, false);
        }
    }

    public final void drawableStateChanged() {
        super.drawableStateChanged();
        getImpl().j(getDrawableState());
    }

    public final void e() {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            ColorStateList colorStateList = this.f3813k;
            if (colorStateList == null) {
                d.a(drawable);
                return;
            }
            int colorForState = colorStateList.getColorForState(getDrawableState(), 0);
            PorterDuff.Mode mode = this.f3814l;
            if (mode == null) {
                mode = PorterDuff.Mode.SRC_IN;
            }
            drawable.mutate().setColorFilter(h0.c(colorForState, mode));
        }
    }

    public final void f() {
        boolean z10;
        boolean z11;
        AnimatorSet animatorSet;
        float f10;
        float f11;
        l impl = getImpl();
        boolean z12 = true;
        if (impl.f9748s.getVisibility() == 0 ? impl.f9747r == 1 : impl.f9747r != 2) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (!z10) {
            Animator animator = impl.f9741l;
            if (animator != null) {
                animator.cancel();
            }
            if (impl.f9742m == null) {
                z11 = true;
            } else {
                z11 = false;
            }
            WeakHashMap weakHashMap = c1.f10054a;
            FloatingActionButton floatingActionButton = impl.f9748s;
            if (!l0.c(floatingActionButton) || floatingActionButton.isInEditMode()) {
                z12 = false;
            }
            Matrix matrix = impl.f9753x;
            if (z12) {
                if (floatingActionButton.getVisibility() != 0) {
                    float f12 = 0.0f;
                    floatingActionButton.setAlpha(0.0f);
                    if (z11) {
                        f10 = 0.4f;
                    } else {
                        f10 = 0.0f;
                    }
                    floatingActionButton.setScaleY(f10);
                    if (z11) {
                        f11 = 0.4f;
                    } else {
                        f11 = 0.0f;
                    }
                    floatingActionButton.setScaleX(f11);
                    if (z11) {
                        f12 = 0.4f;
                    }
                    impl.f9745p = f12;
                    impl.a(f12, matrix);
                    floatingActionButton.setImageMatrix(matrix);
                }
                f fVar = impl.f9742m;
                if (fVar != null) {
                    animatorSet = impl.b(fVar, 1.0f, 1.0f, 1.0f);
                } else {
                    animatorSet = impl.c(1.0f, 1.0f, 1.0f, l.A, l.B);
                }
                animatorSet.addListener(new l8.f(impl, (k5.a) null));
                impl.getClass();
                animatorSet.start();
                return;
            }
            floatingActionButton.a(0, false);
            floatingActionButton.setAlpha(1.0f);
            floatingActionButton.setScaleY(1.0f);
            floatingActionButton.setScaleX(1.0f);
            impl.f9745p = 1.0f;
            impl.a(1.0f, matrix);
            floatingActionButton.setImageMatrix(matrix);
        }
    }

    public ColorStateList getBackgroundTintList() {
        return this.f3811i;
    }

    public PorterDuff.Mode getBackgroundTintMode() {
        return this.f3812j;
    }

    public z.b getBehavior() {
        return new Behavior();
    }

    public float getCompatElevation() {
        return getImpl().e();
    }

    public float getCompatHoveredFocusedTranslationZ() {
        return getImpl().f9738i;
    }

    public float getCompatPressedTranslationZ() {
        return getImpl().f9739j;
    }

    public Drawable getContentBackground() {
        return getImpl().f9734e;
    }

    public int getCustomSize() {
        return this.f3817o;
    }

    public int getExpandedComponentIdHint() {
        return this.f3824v.f9255c;
    }

    public f getHideMotionSpec() {
        return getImpl().f9743n;
    }

    @Deprecated
    public int getRippleColor() {
        ColorStateList colorStateList = this.f3815m;
        if (colorStateList != null) {
            return colorStateList.getDefaultColor();
        }
        return 0;
    }

    public ColorStateList getRippleColorStateList() {
        return this.f3815m;
    }

    public t8.n getShapeAppearanceModel() {
        t8.n nVar = getImpl().f9730a;
        nVar.getClass();
        return nVar;
    }

    public f getShowMotionSpec() {
        return getImpl().f9742m;
    }

    public int getSize() {
        return this.f3816n;
    }

    public int getSizeDimension() {
        return c(this.f3816n);
    }

    public ColorStateList getSupportBackgroundTintList() {
        return getBackgroundTintList();
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return getBackgroundTintMode();
    }

    public ColorStateList getSupportImageTintList() {
        return this.f3813k;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        return this.f3814l;
    }

    public boolean getUseCompatPadding() {
        return this.f3820r;
    }

    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        getImpl().h();
    }

    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        l impl = getImpl();
        i iVar = impl.f9731b;
        FloatingActionButton floatingActionButton = impl.f9748s;
        if (iVar != null) {
            j.d(floatingActionButton, iVar);
        }
        if (!(impl instanceof n)) {
            ViewTreeObserver viewTreeObserver = floatingActionButton.getViewTreeObserver();
            if (impl.f9754y == null) {
                impl.f9754y = new z.f(2, impl);
            }
            viewTreeObserver.addOnPreDrawListener(impl.f9754y);
        }
    }

    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        l impl = getImpl();
        ViewTreeObserver viewTreeObserver = impl.f9748s.getViewTreeObserver();
        z.f fVar = impl.f9754y;
        if (fVar != null) {
            viewTreeObserver.removeOnPreDrawListener(fVar);
            impl.f9754y = null;
        }
    }

    public final void onMeasure(int i10, int i11) {
        int sizeDimension = getSizeDimension();
        this.f3818p = (sizeDimension - this.f3819q) / 2;
        getImpl().q();
        int min = Math.min(View.resolveSize(sizeDimension, i10), View.resolveSize(sizeDimension, i11));
        Rect rect = this.f3821s;
        setMeasuredDimension(rect.left + min + rect.right, min + rect.top + rect.bottom);
    }

    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof w8.b)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        w8.b bVar = (w8.b) parcelable;
        super.onRestoreInstanceState(bVar.f14484h);
        Bundle bundle = (Bundle) bVar.f16170j.getOrDefault("expandableWidgetHelper", (Object) null);
        bundle.getClass();
        b bVar2 = this.f3824v;
        bVar2.getClass();
        bVar2.f9254b = bundle.getBoolean("expanded", false);
        bVar2.f9255c = bundle.getInt("expandedComponentIdHint", 0);
        if (bVar2.f9254b) {
            View view = bVar2.f9253a;
            ViewParent parent = view.getParent();
            if (parent instanceof CoordinatorLayout) {
                ((CoordinatorLayout) parent).i(view);
            }
        }
    }

    public final Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        if (onSaveInstanceState == null) {
            onSaveInstanceState = new Bundle();
        }
        w8.b bVar = new w8.b(onSaveInstanceState);
        k kVar = bVar.f16170j;
        b bVar2 = this.f3824v;
        bVar2.getClass();
        Bundle bundle = new Bundle();
        bundle.putBoolean("expanded", bVar2.f9254b);
        bundle.putInt("expandedComponentIdHint", bVar2.f9255c);
        kVar.put("expandableWidgetHelper", bundle);
        return bVar;
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z10;
        if (motionEvent.getAction() == 0) {
            WeakHashMap weakHashMap = c1.f10054a;
            boolean c10 = l0.c(this);
            Rect rect = this.f3822t;
            if (c10) {
                rect.set(0, 0, getWidth(), getHeight());
                int i10 = rect.left;
                Rect rect2 = this.f3821s;
                rect.left = i10 + rect2.left;
                rect.top += rect2.top;
                rect.right -= rect2.right;
                rect.bottom -= rect2.bottom;
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10 && !rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                return false;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setBackgroundColor(int i10) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    public void setBackgroundDrawable(Drawable drawable) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    public void setBackgroundResource(int i10) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    public void setBackgroundTintList(ColorStateList colorStateList) {
        if (this.f3811i != colorStateList) {
            this.f3811i = colorStateList;
            l impl = getImpl();
            i iVar = impl.f9731b;
            if (iVar != null) {
                iVar.setTintList(colorStateList);
            }
            l8.a aVar = impl.f9733d;
            if (aVar != null) {
                if (colorStateList != null) {
                    aVar.f9698m = colorStateList.getColorForState(aVar.getState(), aVar.f9698m);
                }
                aVar.f9701p = colorStateList;
                aVar.f9699n = true;
                aVar.invalidateSelf();
            }
        }
    }

    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.f3812j != mode) {
            this.f3812j = mode;
            i iVar = getImpl().f9731b;
            if (iVar != null) {
                iVar.setTintMode(mode);
            }
        }
    }

    public void setCompatElevation(float f10) {
        l impl = getImpl();
        if (impl.f9737h != f10) {
            impl.f9737h = f10;
            impl.k(f10, impl.f9738i, impl.f9739j);
        }
    }

    public void setCompatElevationResource(int i10) {
        setCompatElevation(getResources().getDimension(i10));
    }

    public void setCompatHoveredFocusedTranslationZ(float f10) {
        l impl = getImpl();
        if (impl.f9738i != f10) {
            impl.f9738i = f10;
            impl.k(impl.f9737h, f10, impl.f9739j);
        }
    }

    public void setCompatHoveredFocusedTranslationZResource(int i10) {
        setCompatHoveredFocusedTranslationZ(getResources().getDimension(i10));
    }

    public void setCompatPressedTranslationZ(float f10) {
        l impl = getImpl();
        if (impl.f9739j != f10) {
            impl.f9739j = f10;
            impl.k(impl.f9737h, impl.f9738i, f10);
        }
    }

    public void setCompatPressedTranslationZResource(int i10) {
        setCompatPressedTranslationZ(getResources().getDimension(i10));
    }

    public void setCustomSize(int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException("Custom size must be non-negative");
        } else if (i10 != this.f3817o) {
            this.f3817o = i10;
            requestLayout();
        }
    }

    public void setElevation(float f10) {
        super.setElevation(f10);
        i iVar = getImpl().f9731b;
        if (iVar != null) {
            iVar.j(f10);
        }
    }

    public void setEnsureMinTouchTargetSize(boolean z10) {
        if (z10 != getImpl().f9735f) {
            getImpl().f9735f = z10;
            requestLayout();
        }
    }

    public void setExpandedComponentIdHint(int i10) {
        this.f3824v.f9255c = i10;
    }

    public void setHideMotionSpec(f fVar) {
        getImpl().f9743n = fVar;
    }

    public void setHideMotionSpecResource(int i10) {
        setHideMotionSpec(f.b(getContext(), i10));
    }

    public void setImageDrawable(Drawable drawable) {
        if (getDrawable() != drawable) {
            super.setImageDrawable(drawable);
            l impl = getImpl();
            float f10 = impl.f9745p;
            impl.f9745p = f10;
            Matrix matrix = impl.f9753x;
            impl.a(f10, matrix);
            impl.f9748s.setImageMatrix(matrix);
            if (this.f3813k != null) {
                e();
            }
        }
    }

    public void setImageResource(int i10) {
        this.f3823u.e(i10);
        e();
    }

    public void setMaxImageSize(int i10) {
        this.f3819q = i10;
        l impl = getImpl();
        if (impl.f9746q != i10) {
            impl.f9746q = i10;
            float f10 = impl.f9745p;
            impl.f9745p = f10;
            Matrix matrix = impl.f9753x;
            impl.a(f10, matrix);
            impl.f9748s.setImageMatrix(matrix);
        }
    }

    public void setRippleColor(int i10) {
        setRippleColor(ColorStateList.valueOf(i10));
    }

    public void setScaleX(float f10) {
        super.setScaleX(f10);
        getImpl().getClass();
    }

    public void setScaleY(float f10) {
        super.setScaleY(f10);
        getImpl().getClass();
    }

    public void setShadowPaddingEnabled(boolean z10) {
        l impl = getImpl();
        impl.f9736g = z10;
        impl.q();
    }

    public void setShapeAppearanceModel(t8.n nVar) {
        getImpl().n(nVar);
    }

    public void setShowMotionSpec(f fVar) {
        getImpl().f9742m = fVar;
    }

    public void setShowMotionSpecResource(int i10) {
        setShowMotionSpec(f.b(getContext(), i10));
    }

    public void setSize(int i10) {
        this.f3817o = 0;
        if (i10 != this.f3816n) {
            this.f3816n = i10;
            requestLayout();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        setBackgroundTintList(colorStateList);
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        setBackgroundTintMode(mode);
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        if (this.f3813k != colorStateList) {
            this.f3813k = colorStateList;
            e();
        }
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        if (this.f3814l != mode) {
            this.f3814l = mode;
            e();
        }
    }

    public void setTranslationX(float f10) {
        super.setTranslationX(f10);
        getImpl().l();
    }

    public void setTranslationY(float f10) {
        super.setTranslationY(f10);
        getImpl().l();
    }

    public void setTranslationZ(float f10) {
        super.setTranslationZ(f10);
        getImpl().l();
    }

    public void setUseCompatPadding(boolean z10) {
        if (this.f3820r != z10) {
            this.f3820r = z10;
            getImpl().i();
        }
    }

    public void setVisibility(int i10) {
        super.setVisibility(i10);
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (this.f3815m != colorStateList) {
            this.f3815m = colorStateList;
            getImpl().m(this.f3815m);
        }
    }
}
